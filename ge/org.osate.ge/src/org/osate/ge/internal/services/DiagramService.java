/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.services;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DiagramType;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.RelativeBusinessObjectReference;

import com.google.common.collect.ImmutableSet;

/**
 * Service for finding, opening, and creating diagrams. Registered as an Eclipse service.
 *
 */
public interface DiagramService {
	/**
	 * Contains members which provide information about a diagram
	 */
	static interface DiagramReference {
		/**
		 * Returns whether the diagram is valid.
		 * If it is valid then {@link #getDiagramTypeId()} and {@link #getContextReference()} will return valid values.
		 * @return whether the diagram is valid.
		 */
		boolean isValid();

		/**
		 * Returns whether the diagram is currently open in an editor
		 * @return whether the diagram is currently open in an editor
		 */
		boolean isOpen();

		/**
		 * Returns the diagram's file
		 * @return the diagram's file
		 */
		IFile getFile();

		/**
		 * Returns the ID of the diagram type.
		 * @return will return null if the diagram is not valid.
		 * @see DiagramType
		 */
		String getDiagramTypeId();

		/**
		 * Returns the reference for the diagram's context
		 * @return will return null if the diagram is not valid.
		 */
		CanonicalBusinessObjectReference getContextReference();
	}

	/**
	 * Returns all diagrams with the specified context
	 * @param bo the context for which to return diagrams
	 * @return diagrams with the specified context
	 */
	List<? extends DiagramReference> findDiagramsByContextBusinessObject(final Object bo);

	/**
	 * Returns all diagrams in the specified projects
	 * @param projects the projects for which to return diagrams
	 * @return the diagrams in the specified projects
	 */
	List<? extends DiagramReference> findDiagrams(Set<IProject> projects);


	/**
	 * Opens the first existing diagram found for a business object. If a diagram is not found, a diagram may be created after prompting the user.
	 * @param bo the context of the diagram to open
	 * @return the editor for the open diagram. Returns null if an editor was not opened.
	 */
	default GraphicalEditor openOrCreateDiagramForBusinessObject(final Object bo) {
		return openOrCreateDiagramForBusinessObject(bo, true, false);
	}

	/**
	 * Opens the first existing diagram found for a business object. If a diagram is not found, a diagram may be created after optionally prompting the user.
	 * @param bo the business object for which to open/create the diagram
	 * @param promptForCreate is whether the user should be prompted before a diagram is created. If false, the diagram will be created.
	 * @param promptForConfigureAfterCreate is whether the user should be prompted to configure the diagram if a new diagram is created.
	 * @return the editor for the open diagram. Returns null if an editor was not opened.
	 */
	GraphicalEditor openOrCreateDiagramForBusinessObject(final Object bo, final boolean promptForCreate,
			final boolean promptForConfigureAfterCreate);

	/**
	 * Create a new diagram which uses the specified business object as the context business object.
	 * Prompts the user for the name and diagram type.
	 * @param contextBo the new diagram's context
	 * @return the file resource for the new diagram
	 */
	IFile createDiagram(final Object contextBo);

	/**
	 * Creates a diagram
	 * @param diagramFile the diagram file to create
	 * @param diagramType the new diagram's type
	 * @param contextBo the new diagram's context
	 */
	void createDiagram(final IFile diagramFile, final DiagramType diagramType, final Object contextBo);

	/**
	 * Represents a collection of references to business objects
	 *
	 */
	interface ReferenceCollection {
		/**
		 * Updates diagrams with the new reference values
		 * @param newReferenceValues provides updated canonical and relative references
		 */
		void update(UpdatedReferenceValueProvider newReferenceValues);

		/**
		 * Returns the diagram files which contain the references
		 * @return the diagram files which contain the references
		 */
		ImmutableSet<IFile> getRelatedDiagramFiles();
	}

	/**
	 * Used to provide new reference values when updating a reference collection
	 *
	 */
	interface UpdatedReferenceValueProvider {
		/**
		 * Returns the canonical reference which should replace the specified canonical reference
		 * @param originalCanonicalReference is the canonical reference at the time the reference collection was created.
		 * @return the canonical reference which should replace the specified canonical reference
		 */
		CanonicalBusinessObjectReference getNewCanonicalReference(final CanonicalBusinessObjectReference originalCanonicalReference);

		/**
		 * Returns the relative reference which should be used for the business object referenced by the specified original canonical reference.
		 * @param originalCanonicalReference is the canonical reference at the time the reference collection was created.
		 * @return the relative reference which should be used for the business object referenced by the specified original canonical reference.
		 */
		RelativeBusinessObjectReference getNewRelativeReference(final CanonicalBusinessObjectReference originalCanonicalReference);
	}

	/**
	 * Gets references in saved and open resources. Used during the refactoring process to update references in open and saved diagrams.
	 * @param relevantProjects the projects for which to return references
	 * @param originalCanonicalReferences the canonical references of the business objects for which to return references
	 * @return the references to the specified business objects.
	 */
	ReferenceCollection getReferences(final Set<IProject> relevantProjects, final Set<CanonicalBusinessObjectReference> originalCanonicalReferences);
}
