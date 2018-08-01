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
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

import com.google.common.collect.ImmutableSet;

/**
 * Service for finding, opening, and creating diagrams. Registered as an Eclipse service.
 *
 */
public interface DiagramService {
	static interface DiagramReference {
		/**
		 * Returns whether the diagram is valid. If it is valid then getDiagramTypeId() and getContextReference() will return valid values.
		 * @return
		 */
		boolean isValid();

		boolean isOpen();

		/**
		 * Returns the currently open editor for the diagram.
		 * @return the editor. Will be non-null if and only if isOpen() is true.
		 */
		AgeDiagramEditor getEditor();

		IFile getFile();

		/**
		 *
		 * @return will return null if the diagram is not valid.
		 */
		String getDiagramTypeId();

		/**
		 *
		 * @return will return null if the diagram is not valid.
		 */
		CanonicalBusinessObjectReference getContextReference();
	}

	List<DiagramReference> findDiagramsByContextBusinessObject(final Object bo);

	List<DiagramReference> findDiagrams(Set<IProject> projects);


	/**
	 * Opens the first existing diagram found for a business object. If a diagram is not found, a diagram may be created after prompting the user.
	 * @param bo
	 * @return
	 */
	default AgeDiagramEditor openOrCreateDiagramForBusinessObject(final Object bo) {
		return openOrCreateDiagramForBusinessObject(bo, true, false);
	}

	/**
	 * Opens the first existing diagram found for a business object. If a diagram is not found, a diagram may be created after optionally prompting the user.
	 * @param bo the business object for which to open/create the diagram
	 * @param promptForCreate is whether the user should be prompted before a diagram is created. If false, the diagram will be created.
	 * @param promptForConfigureAfterCreate is whether the user should be prompted to configure the diagram if a new diagram is created.
	 */
	AgeDiagramEditor openOrCreateDiagramForBusinessObject(final Object bo, final boolean promptForCreate, final boolean promptForConfigureAfterCreate);

	/**
	 * Create a new diagram which uses the specified business object as the context business object
	 * @param contextBo
	 * @return the file resource for the new diagram
	 */
	IFile createDiagram(final Object contextBo);

	void createDiagram(final IFile diagramFile, final DiagramType diagramType, final Object contextBo);

	/**
	 * Returns the name of a specified diagram
	 */
	String getName(final IFile diagramFile);

	/**
	 * Clear persistent resource properties used by legacy versions of the graphical editor
	 * @param diagram
	 */
	void clearLegacyPersistentProperties(final IResource fileResource);

	interface ReferenceCollection {
		void update(UpdatedReferenceValueProvider newReferenceValues);

		ImmutableSet<IFile> getRelatedDiagramFiles();
	}

	// Used to provide new reference values when updating a reference collection
	interface UpdatedReferenceValueProvider {
		/**
		 *
		 * @param originalCanonicalReference is the canonical reference at the time the reference collection was created.
		 * @return
		 */
		CanonicalBusinessObjectReference getNewCanonicalReference(final CanonicalBusinessObjectReference originalCanonicalReference);

		/**
		 *
		 * @param originalCanonicalReference is the canonical reference at the time the reference collection was created.
		 * @return
		 */
		RelativeBusinessObjectReference getNewRelativeReference(final CanonicalBusinessObjectReference originalCanonicalReference);
	}

	/**
	 * Gets references in saved and open resources. Used during the refactoring process to update references in open and saved diagrams.
	 * @param relevantProjects
	 * @param originalCanonicalReferences
	 * @return
	 */
	ReferenceCollection getReferences(final Set<IProject> relevantProjects, final Set<CanonicalBusinessObjectReference> originalCanonicalReferences);
}
