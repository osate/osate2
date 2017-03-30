/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.core.resources.IProject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;

/**
 * Internal service for accessing graphiti and other platform specific objects. Ideally would transition towards exposing all needed
 * capabilities via generic services. The purpose of this is to avoid adding graphiti objects to the context and thus exposing them
 * to extensions.
 */
public interface GraphitiService {
	Diagram getDiagram();
	IDiagramTypeProvider getDiagramTypeProvider();
	IFeatureProvider getFeatureProvider();
	
	/**
	 * Get the project containing the current diagram
	 * @return
	 */
	IProject getProject();
}
