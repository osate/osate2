/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal;

import org.eclipse.graphiti.features.DefaultResizeConfiguration;

/** 
 * A default implementation of AgeResizeConfiguration that extends DefaultResizeConfiguration as well.
 *
 */
public class DefaultAgeResizeConfiguration extends DefaultResizeConfiguration implements AgeResizeConfiguration {
	private boolean hasMinimumSize = false;
	private int minimumWidth;
	private int minimumHeight;
	
	@Override
	public boolean hasMinimumSize() {
		return hasMinimumSize;
	}
	
	@Override
	public int getMinimumWidth() {
		return minimumWidth;
	}
	
	@Override
	public int getMinimumHeight() {
		return minimumHeight;
	}
	
	public void setMinimumSize(final int minimumWidth, final int minimumHeight) {
		this.minimumWidth = minimumWidth;
		this.minimumHeight = minimumHeight;
		this.hasMinimumSize = true;
	}
}
