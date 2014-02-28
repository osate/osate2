/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.aadl2.Element;

/**
 * Contains methods for creating Graphiti connections
 * @author philip.alldredge
 *
 */
public interface ConnectionCreationService {
	void createUpdateConnections(ContainerShape ownerShape,	List<? extends Element> elements);

	Connection createUpdateConnection(ContainerShape ownerShape, Element el);
}
