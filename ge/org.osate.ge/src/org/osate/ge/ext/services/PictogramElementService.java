/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105
 *******************************************************************************/
package org.osate.ge.ext.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public interface PictogramElementService {
	/**
	 * Returns the business object linked to a pictogram element.
	 * @param pe
	 * @return
	 */
	Object getBusinessObject(PictogramElement pe);
	
	void refreshShapesForBusinessObject(final ContainerShape container, final Object bo);
	void refreshShapesForBusinessObjects(final ContainerShape container, final List<?> bos);
	void refreshConnectionsForBusinessObjects(final ContainerShape ownerShape, final List<?> bos);
}
