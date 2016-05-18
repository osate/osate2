/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

import org.osate.ge.internal.graphics.ConnectionStyle;
import org.osate.ge.internal.graphics.AgeConnectionTerminator;
import org.osate.ge.internal.graphics.FreeFormConnection;

public class ConnectionGraphicBuilder {
	private AgeConnectionTerminator srcTerminator = null;
	private AgeConnectionTerminator dstTerminator = null;
	private ConnectionStyle connectionStyle = ConnectionStyle.SOLID;
	
	private ConnectionGraphicBuilder() {}
	
	public static ConnectionGraphicBuilder create() {
		return new ConnectionGraphicBuilder();
	}
	
	public ConnectionGraphicBuilder sourceTerminator(final ConnectionTerminator value) {
		this.srcTerminator = (AgeConnectionTerminator)value;
		return this;
	}
	
	public ConnectionGraphicBuilder destinationTerminator(final ConnectionTerminator value) {
		this.dstTerminator = (AgeConnectionTerminator)value;
		return this;
	}
	
	public ConnectionGraphicBuilder dashed() {
		this.connectionStyle = ConnectionStyle.DASHED;
		return this;
	}
	
	public Graphic build() {
		return new FreeFormConnection(connectionStyle, srcTerminator, dstTerminator);
	}
}
