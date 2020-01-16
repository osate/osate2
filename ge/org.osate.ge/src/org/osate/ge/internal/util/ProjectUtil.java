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
package org.osate.ge.internal.util;

import java.util.Objects;
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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Injector;

public class ProjectUtil {
	/**
	 * Get affects projects. At this point, this function returns projects which directly or indirectly reference the project containing the model element.
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

	public static IProject getProject(final URI elementUri) {
		final IPath projectPath = new Path(elementUri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if (!(projectResource instanceof IProject)) {
			return null;
		}
		return (IProject) projectResource;
	}

	public static IProject getProjectForBoOrThrow(final Object bo) {
		return getResource(bo).flatMap(r -> Optional.ofNullable(r.getURI())).flatMap(SelectionUtil::getProject).orElseThrow(() -> new RuntimeException("Unable to get project for business object: " + bo));
	}

	public static Optional<IProject> getProjectForBo(final Object bo) {
		return getResource(bo).flatMap(r -> Optional.ofNullable(r.getURI())).flatMap(SelectionUtil::getProject);
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

	/**
	 * Returns a live resource set based on the project or throws an exception if one cannot be returned.
	 * @param project
	 * @return
	 */
	public static ResourceSet getLiveResourceSet(IProject project) {
		final Injector injector = Objects.requireNonNull(
				Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2),
				"Unable to retrieve injector");
		final XtextLiveScopeResourceSetProvider liveResourceSetProvider = Objects.requireNonNull(
				injector.getInstance(XtextLiveScopeResourceSetProvider.class),
				"Unable to retrieve live scope resource set provider");

		return Objects.requireNonNull(liveResourceSetProvider.get(project), "Unable to get live resource set");
	}
}
