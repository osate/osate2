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

import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.impl.DefaultDiagramService;
import org.osate.ge.services.impl.SimpleServiceFactory;

/**
 * Service for finding, opening, and creating diagrams. Registered as an Eclipse service.
 * @author philip.alldredge
 *
 */
public interface DiagramService {
	public static class Factory extends SimpleServiceFactory {
		public Factory() {
			super(DiagramService.class, DefaultDiagramService.class);
		}
	}	

	public List<Diagram> findDiagramsByRootBusinessObject(final NamedElement ne);
	
	public List<Diagram> findDiagrams();
	
	/**
	 * Opens the first found existing diagram for an element. If a diagram is not found, a diagram of the appropriate type is created.
	 * @param element the element for which to open/create the diagram
	 */
	public void openOrCreateDiagramForRootBusinessObject(final NamedElement element);
	
	/**
	 * Returns the name of a specified diagram
	 */
	public String getName(final IFile diagramFile);
	
	/**
	 * Stores persistent properties in the diagram's resource. Should be called after resource has been saved.
	 * @param diagram
	 * @param name
	 */
	public void savePersistentProperties(final Diagram diagram);

}
