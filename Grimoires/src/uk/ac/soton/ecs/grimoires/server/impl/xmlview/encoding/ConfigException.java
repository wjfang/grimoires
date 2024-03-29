/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package uk.ac.soton.ecs.grimoires.server.impl.xmlview.encoding;

public class ConfigException extends Exception {
    
    public ConfigException(String message) {
        super(message);
    }
    
    public ConfigException(Exception e) {
        super("", e);
    }
    
    public ConfigException(String message, Exception e) {
        super(message, e);
    }
    
}
