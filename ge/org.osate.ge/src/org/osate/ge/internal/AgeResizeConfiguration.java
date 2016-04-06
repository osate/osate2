/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal;

/**
 * An interface similar to the Graphiti ResizeConfiguration interface that provides information regarding whether there is a minimum size for a particular type of shape.
 * This interface should be implemented by the resize configuration returned by resize shape features and patterns in order to define a minimum size.
 * Used by the layout algorithm to determine the minimum size of a shape. 
 *
 */
public interface AgeResizeConfiguration {
	boolean hasMinimumSize();
	int getMinimumWidth();
	int getMinimumHeight();
}
