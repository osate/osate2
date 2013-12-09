/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.componentImplementation;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeDiagramTypeProvider;

public class ComponentImplementationDiagramTypeProvider extends AgeDiagramTypeProvider {
	public ComponentImplementationDiagramTypeProvider() {
		setFeatureProvider(new ComponentImplementationFeatureProvider(this));
	}
}
