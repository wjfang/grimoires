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

/**
 * A lock that allows multiple read access or single write access to some data at
 * any one time. Reads are prioritised over writes so all reads are processed
 * first. Before performing a read operation on the data in question, the client
 * code should call beforeRead() on the associated lock, then call afterRead ()
 * afterwards. Similarly, before performing a write operation on the data, the client
 * code should call beforeWrite() on the associated lock, then call afterWrite ()
 * afterwards.
 * <P>
 * This code is adapted from that in "Concurrent Programming in Java" by Doug Lea,
 * published by Addison Wesley.
 *
 * @author Simon Miles
 * @version $Id: ReadWriteLock.java,v 1.5 2006/07/17 10:18:32 wf Exp $
 *
 * Created: 29 April 2004,16:14
 *
 * Copyright 2003 Simon Miles,
 *                Luc Moreau,
 *                Juri Papay
 *
 */
public class ReadWriteLock {
    private int activeReaders;
    private int activeWriters;
    private int waitingReaders;
    private int waitingWriters;
    
    /** Creates a new instance of ReadWriteLock */
    public ReadWriteLock () {
        activeReaders  = 0;
        activeWriters  = 0;
        waitingReaders = 0;
        waitingWriters = 0;
    }
    
    /**
     * Call after every read operation
     */
    public synchronized void afterRead () {
//        activeReaders -= 1;
//        notifyAll ();
//        if (activeReaders < 0) {
//            throw new RuntimeException ("ReadWriteLock: More afterReads than beforeReads");
//        }
    }

    /**
     * Call after every write operation
     */
    public synchronized void afterWrite () {
//        activeWriters -= 1;
//        notifyAll ();
//        if (activeReaders < 0) {
//            throw new RuntimeException ("ReadWriteLock: More afterWrites than beforeWrites");
//        }
    }
    
    /**
     * Multiple reads are allowed at the same time and reads are prioritised
     * over writes. To change so that read and write are given the same
     * priority, change the line to: return activeWriters == 0 &&
     * waitingWriters == 0;
     */
    protected boolean allowReader () {
        return activeWriters == 0;
    }

    /**
     * A write can only take place when no other reads or writes are
     * taking place
     */    
    protected boolean allowWriter () {
        return activeReaders == 0 && activeWriters == 0;
    }
    
    /**
     * Call before every read operation
     */
    public synchronized void beforeRead () {
//        waitingReaders += 1;
//        while (!allowReader ()) {
//            try {
//                wait ();
//            } catch (InterruptedException canContinue) {}
//        }
//        waitingReaders -= 1;
//        activeReaders  += 1;
    }
    
    /**
     * Call before every write operation
     */
    public synchronized void beforeWrite () {
//        waitingWriters += 1;
//        while (!allowWriter ()) {
//            try {
//                wait ();
//            } catch (InterruptedException canContinue) {}
//        }
//        waitingWriters -= 1;
//        activeWriters  += 1;
    }
}
