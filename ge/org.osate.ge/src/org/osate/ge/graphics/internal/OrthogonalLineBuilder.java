/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.ConnectionTerminator;
import org.osate.ge.graphics.internal.AgeConnectionTerminator;
import org.osate.ge.graphics.internal.ConnectionTerminatorType;

/**
 * Builder for creating arrow connection terminators. 
 * @noextend
 * @see ConnectionTerminator
 */
public class OrthogonalLineBuilder {
	private OrthogonalLineBuilder() {} 
	
	/**
	 * Creates an arrow builder.
	 * @return a arrow builder
	 */
	public static OrthogonalLineBuilder create() {
		return new OrthogonalLineBuilder();
	}
	
	/**
	 * Creates a connection terminator based on the current state of the orthogonal line builder.
	 * @return the newly created connection terminator
	 */
	public ConnectionTerminator build() {
		return new AgeConnectionTerminator(ConnectionTerminatorType.ORTHOGONAL_LINE, ConnectionTerminatorSize.REGULAR, false);
	}
}
