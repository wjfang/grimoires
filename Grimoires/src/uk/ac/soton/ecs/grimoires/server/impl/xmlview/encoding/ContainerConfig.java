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

import org.apache.axis.AxisEngine;
import org.apache.axis.MessageContext;
import org.apache.axis.client.AxisClient;

/**
 * This class makes global container configuration variables available to 
 * the application.
 */
public class ContainerConfig {

    private static AxisEngine axisClientEngine = null;

    
    /**
     * Get the default Axis client engine.
     */
    public static synchronized AxisEngine getClientEngine() {
        if (axisClientEngine == null) {
            axisClientEngine = new AxisClient();
        }
        return axisClientEngine;
    }

    /**
     * Gets MessageContext associated with the current thread. If 
     * MessageContext is not associated with the current thread a new
     * one is created, initialized with client AxisEngine.
     */
    public static MessageContext getContext() {
        MessageContext ctx = MessageContext.getCurrentContext();
        if (ctx == null) {
            ctx = new MessageContext(getClientEngine());
            ctx.setEncodingStyle("");
            ctx.setProperty(AxisClient.PROP_DOMULTIREFS,
                            Boolean.FALSE);
        }
        return ctx;
    }

}
