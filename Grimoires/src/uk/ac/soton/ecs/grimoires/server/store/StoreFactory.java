// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.


/*
 * Copyright 2003 The University of Southampton
 *
 *
 *  Simon Miles - 2003
 *  Luc Moreau  - 2003
 *  Juri Papay  - 2003
 *
 *  This file is part of myGrid.  Further information, and the
 *  latest version, can be found at http://www.mygrid.org.uk
 *
 *  myGrid is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1
 *  of the License, or (at your option) any later version.
 *
 *  myGrid is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with myGrid; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package uk.ac.soton.ecs.grimoires.server.store;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.db.ModelRDB;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.db.RDFRDBException;
import com.hp.hpl.jena.db.IDBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;


/** A factory for different triple stores supported by Jena: the
 * output is always a Jena Model. */

public class StoreFactory {
    public static final String MemoryType  = "Memory";
    public static final String JDBCType    = "RDB";
    public static final String FileType    = "File";

    private Configuration configuration;

    public StoreFactory (Configuration configuration) {
	this.configuration=configuration;
    }
    
    private Timer timer;
    
    public Model cleanStore (Model model, String type, Properties parameters) throws ClassNotFoundException, SQLException {
        if (type.equalsIgnoreCase (MemoryType)) {
            return makeMemoryStore ();
        }
        if (type.equalsIgnoreCase (JDBCType)) {
            ((ModelRDB) model).getConnection ().cleanDB ();
            ((ModelRDB) model).getConnection ().close ();
            return makeDatabaseStore (parameters);
        }
        if (type.equalsIgnoreCase (FileType)) {
            // May not be right
            return makeFileStore (parameters);
        }
        
        throw new RuntimeException ("Store type " + type + " not recognised.");
    }
    
    public synchronized Model makeStore (String type, Properties parameters) throws ClassNotFoundException, RDFException, RDFRDBException, SQLException {
System.out.println ("Making store of type " + type + " with properties " + parameters);
        if (type.equalsIgnoreCase (MemoryType)) {
            return makeMemoryStore ();
        }
        if (type.equalsIgnoreCase (JDBCType)) {
            return makeDatabaseStore (parameters);
        }
        if (type.equalsIgnoreCase (FileType)) {
            return makeFileStore (parameters);
        }
        
        throw new RuntimeException ("Store type " + type + " not recognised.");
    }
    
    public Model makeDatabaseStore (Properties parameters) throws ClassNotFoundException, RDFRDBException, SQLException {
        // Loading the Driver class
        Class.forName (parameters.getProperty ("Driver"));
        return makeDatabaseStore (parameters.getProperty ("URL"), parameters.getProperty ("Username"), parameters.getProperty ("Password"), parameters.getProperty ("DBType"));
    }
    
    public Model makeDatabaseStore (String dbURL, String username, String password, String dbType) throws RDFRDBException, SQLException {
        ModelRDB      model = null;
        IDBConnection dbcon = new DBConnection (configuration.openDatabaseConnection (dbURL, username, password), dbType);
        
        // Find out if the database already exist
        try {
            if (dbcon.isFormatOK ()) {
                model = ModelRDB.open (dbcon);
            }
            else {
                model = ModelRDB.createModel ( dbcon );
            }
        }
        catch ( RDFRDBException e) {
            System.err.println ("Exception: "+ e) ;
            e.printStackTrace (System.err) ;
        }
        
        model.setDoFastpath (false);
        
        return model;
    }
    
    
    // Create a memory model
    public Model makeMemoryStore () {
        return ModelFactory.createDefaultModel ();
    }
    
    // Create a File model
    
    public Model makeFileStore (Properties parameters) throws ClassNotFoundException, RDFRDBException {
        return makeFileStore (parameters.getProperty ("FileName"));
    }
    
    
    public Model makeFileStore (String fileName) {
        // Create memory model and read in the file
        Model model = ModelFactory.createDefaultModel ();
        
        InputStream in = StoreFactory.class.getClassLoader ().getResourceAsStream (fileName);
        
        if (in == null) {
            throw new IllegalArgumentException ( "File: " + fileName + " not found");
        }
        // read the RDF/XML file
        model.read (new InputStreamReader (in), "");
        
        try {
            in.close ();
        }
        catch (IOException e) {
            System.err.println ("Error while closing the InputStream " + e.toString ());
            e.printStackTrace ();
        }
        
        
        // Create a thread which writes the model to the file
        long seconds = 60;
        
        timer = new Timer ();
        timer.schedule (new SaveModelInFile (model, fileName), seconds*1000, seconds*1000);
        
        return model;
    }
}
