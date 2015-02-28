/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.layout;

public class Connection {
	private final Shape src;
	private final Shape dest;
	
	public Connection(final Shape src, final Shape dest) {
		this.src = src;
		this.dest = dest;
	}

	public Shape getSource() {
		return src;
	}

	public Shape getDestination() {
		return dest;
	}
}
