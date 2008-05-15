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
 * RegistryException.java
 *
 * Created on 17 May 2004, 18:04
 */

package uk.ac.soton.ecs.grimoires.server.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;

/**
 * Reports an exception or set of exceptions from the server-side to the user.
 * The cause will be the first error encountered, but the total set can be retrieved
 * using getErrors ().
 *
 * @author  sm
 */
public class RegistryException extends Exception {
    private Collection problems;
    
    /** Creates a new instance of RegistryException with the set of Throwable
      causes of this exception. */
    public RegistryException (Collection allProblems) {
        super ("myGrid registry exception", (Throwable) allProblems.iterator ().next ());
        problems = allProblems;
    }
    
    /** Returns the set of Throwable causes of this exception */
    public Collection getErrors () {
        return problems;
    }
    
    public String toString () {
        StringBuffer result    = new StringBuffer ("Registry errors: ");
        Iterator     eachError = problems.iterator ();
        StringWriter strings;
        
        while (eachError.hasNext ()) {
            strings = new StringWriter ();
            ((Exception) eachError.next ()).printStackTrace (new PrintWriter (strings));
            result.append (strings.getBuffer ().toString ());
            result.append ("\n\n");
        }
        
        return result.toString ();
    }
}
