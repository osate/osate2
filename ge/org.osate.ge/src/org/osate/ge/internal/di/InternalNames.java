/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.di;

/**
 * Internal constants for named parameters. For use with the @Named annotation. Not API.
 *
 */
public class InternalNames {
	// All items are static
	private InternalNames() {
	}

	public static final String PROJECT = "project";
	public static final String SELECTED_DIAGRAM_ELEMENT = "selected_diagram_element";
	public static final String SELECTED_DIAGRAM_ELEMENTS = "selected_diagram_elements";
	public static final String REFERENCE = "reference";
}
