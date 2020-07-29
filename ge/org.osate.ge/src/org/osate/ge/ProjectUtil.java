/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge;

import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Utility functions related to {@link IProject}
 * @since 2.0
 */
public class ProjectUtil {
	/**
	 * Get affected projects. At this point, this function returns projects which directly or indirectly reference the project containing the model element.
	 * @param project
	 * @param relevantProjects
	 * @return relevantProjects
	 */
	public static Set<IProject> getAffectedProjects(final IProject project, final Set<IProject> relevantProjects) {
		if (project.isAccessible()) {
			if (relevantProjects.add(project)) {
				// Get referencing projects if the project was not already part of the relevant projects set
				for (final IProject referencingProject : project.getReferencingProjects()) {
					getAffectedProjects(referencingProject, relevantProjects);
				}

				// Get referencing projects if the project was not already part of the relevant projects set
				try {
					for (final IProject referencedProject : project.getReferencedProjects()) {
						getAffectedProjects(referencedProject, relevantProjects);
					}
				} catch (final CoreException e) {
					// Ignore
				}
			}
		}

		return relevantProjects;
	}

	/**
	 * Retrieves the project that contains the resource.
	 * @param resource is the EMF resource for which to return the project.
	 * @return the project. Throws an exception if unable to retrieve the project.
	 */
	public static IProject getProjectOrThrow(final Resource resource) {
		return getProjectOrThrow(resource.getURI());
	}

	/**
	 * Retrieves the project based on an EMF URI.
	 * @param uri is the URI for the EMF element for which to return the project.
	 * @return an optional containing a project based on the URI. The optional will be empty if the project cannot be retrieved.
	 */
	public static Optional<IProject> getProject(final URI uri) {
		final IPath projectPath = new Path(uri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if (projectResource instanceof IProject) {
			return Optional.of((IProject) projectResource);
		}

		return Optional.empty();
	}

	/**
	 * Retrieves the project based on an EMF URI.
	 * @param uri is the URI for the EMF element for which to return the project.
	 * @return the project. Returns null if the project cannot be returned.
	 */
	public static IProject getProjectOrNull(final URI elementUri) {
		return getProject(elementUri).orElse(null);
	}

	/**
	 * Retrieves the project based on a EMF URI.
	 * @param uri is the URI for the EMF element for which to return the project.
	 * @return the project. Throws an exception if unable to retrieve the project.
	 */
	public static IProject getProjectOrThrow(final URI uri) {
		return getProject(uri)
				.orElseThrow(() -> new RuntimeException("Unable to receive project. URI: " + uri));
	}

	/**
	 * Retrieves the project that contains the resource in which the business object is contained.
	 * @param bo is the business for which to retrieve the project.
	 * @return the project. Throws an exception if unable to retrieve the project.
	 */
	public static IProject getProjectForBoOrThrow(final Object bo) {
		return getProjectForBo(bo)
				.orElseThrow(() -> new RuntimeException("Unable to get project for business object: " + bo));
	}

	/**
	 * Retrieves the project that contains the resource in which the business object is contained.
	 * @param bo is the business for which to retrieve the project.
	 * @return an optional describing the project. An empty optional is returned if the project cannot be trieved.
	 */
	public static Optional<IProject> getProjectForBo(final Object bo) {
		return getResource(bo).flatMap(r -> Optional.ofNullable(r.getURI())).flatMap(ProjectUtil::getProject);
	}

	private static Optional<Resource> getResource(final Object bo) {
		final EObject eObject;

		// Handle EObject instances without delegating to specialized handlers
		if (bo instanceof EObject) {
			eObject = (EObject) bo;
		} else if (bo instanceof EmfContainerProvider) { // Use the EMF Object container if the business object is not an EMF Object
			final EObject container = ((EmfContainerProvider) bo).getEmfContainer();
			if (container == null) {
				return Optional.empty();
			}

			eObject = container;
		} else {
			return Optional.empty();
		}

		return Optional.ofNullable(eObject.eResource());
	}
}
