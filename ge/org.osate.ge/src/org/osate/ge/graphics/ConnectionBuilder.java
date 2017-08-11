/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

import org.osate.ge.internal.graphics.LineStyle;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeConnectionTerminator;

/**
 * Builder for creating connection graphics. Currently all connections are straight line connections which do not support bend-points.
 * @noextend
 * @see Graphic
 */
public class ConnectionBuilder {
	private AgeConnectionTerminator srcTerminator = null;
	private AgeConnectionTerminator dstTerminator = null;
	private LineStyle lineStyle = LineStyle.SOLID;
	private boolean isCurved = false;
	
	private ConnectionBuilder() {}
	
	/**
	 * Creates a connection builder.
	 * @return a connection builder
	 */
	public static ConnectionBuilder create() {
		return new ConnectionBuilder();
	}
	
	/**
	 * Configures the connection builder to create a connection with the specified connection terminator at the source end of the connection.
	 * @param value the source connection terminator to use when creating the connection
	 * @return this builder to allow method chaining.
	 */
	public ConnectionBuilder sourceTerminator(final ConnectionTerminator value) {
		this.srcTerminator = (AgeConnectionTerminator)value;
		return this;
	}
	
	/**
	 * Configures the connection builder to create a connection with the specified connection terminator at the destination end of the connection.
	 * @param value the destination connection terminator to use when creating the connection
	 * @return this builder to allow method chaining.
	 */
	public ConnectionBuilder destinationTerminator(final ConnectionTerminator value) {
		this.dstTerminator = (AgeConnectionTerminator)value;
		return this;
	}
	
	/**
	 * Configures the connection builder to create a dashed connection.
	 * @return this builder to allow method chaining.
	 */
	public ConnectionBuilder dashed() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}
	
	/**
	 * Configures the connection builder to create a dotted connection.
	 * @return this builder to allow method chaining.
	 */
	public ConnectionBuilder dotted() {
		this.lineStyle = LineStyle.DOTTED;
		return this;
	}
	
	/**
	 * Configures the connection builder to create a curved connection.
	 * @return this builder to allow method chaining.
	 */
	public ConnectionBuilder curved() {
		this.isCurved = true;
		return this;
	}	
	
	/**
	 * Creates a connection based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return AgeConnection.createNormal(lineStyle, srcTerminator, dstTerminator, isCurved);
	}
}
