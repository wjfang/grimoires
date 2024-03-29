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



package uk.ac.soton.ecs.grimoires.axis;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class NodeListIterator implements Iterator {
    public NodeListIterator (NodeList iterateOver) {
        basis = iterateOver;
        next  = 0;
    }
    
    public NodeListIterator (Node iterateChildren) {
        this (iterateChildren.getChildNodes ());
    }
    
    public boolean hasNext () {
        return basis.getLength () > next;
    }
    
    public Object next () {
        Object current = basis.item (next);
        if (current == null) {
            throw new NoSuchElementException ();
        }
        next += 1;
        return current;
    }
    
    public void remove () {
        throw new UnsupportedOperationException ();
    }
    
    private NodeList basis;
    private int      next;
}
