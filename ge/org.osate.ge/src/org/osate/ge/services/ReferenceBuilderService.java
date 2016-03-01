/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.services;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Service for building string references to business objects
 */
public interface ReferenceBuilderService {
	String getReference(Object bo);
	String getTitle(Object bo);
	IProject getProject(Object bo);
	Resource getResource(Object bo);
}
