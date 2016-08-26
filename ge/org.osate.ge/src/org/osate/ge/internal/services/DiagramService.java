/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

/**
 * Service for finding, opening, and creating diagrams. Registered as an Eclipse service.
 *
 */
public interface DiagramService {
	public static interface DiagramReference {
		boolean isOpen();
		Diagram getDiagram();
		IProject getProject();
		
		/**
		 * Returns the currently open editor for the diagram.
		 * @return the editor. Will be non-null if and only if isOpen() is true.
		 */
		AgeDiagramEditor getEditor();
	}
	
	public DiagramReference findFirstDiagramByRootBusinessObject(final Object bo);
	
	public List<DiagramReference> findDiagrams();
	
	/**
	 * Opens the first existing diagram found for a business object. If a diagram is not found, a diagram is create.
	 * @param bo the business object for which to open/create the diagram
	 */
	public AgeDiagramEditor openOrCreateDiagramForRootBusinessObject(final Object bo);
	
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
	
	/**
	 * Returns a name for a diagram with the specified business object
	 * @param bo
	 * @return
	 */
	public String getDiagramNameByBusinessObject(Object bo);
	
	public Resource getResource(Object bo);
}
