/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge;

/**
 * Contains constants whose values are the id's of built-in categories.
 * @noimplement
 * @see PaletteEntryBuilder#category(String)
 */
public interface Categories {
	public static final String CLASSIFIERS = "org.osate.ge.categories.classifiers";
	public static final String CONNECTIONS = "org.osate.ge.categories.connections";
	public static final String FEATURES = "org.osate.ge.categories.features";
	public static final String FLOWS = "org.osate.ge.categories.flows";
	public static final String MODES = "org.osate.ge.categories.modes";
	public static final String SUBCOMPONENTS = "org.osate.ge.categories.subcomponents";
	public static final String SUBPROGRAM_CALLS = "org.osate.ge.categories.subprogram_calls";
	public static final String MISC = "org.osate.ge.categories.misc";
}
