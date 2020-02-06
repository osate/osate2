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
package org.osate.ge.internal.services.impl;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;

public class ProjectReferenceServiceProxy implements ProjectReferenceService {
	private final ReferenceService referenceService;
	private final ProjectProvider projectProvider;
	private ProjectReferenceService currentProjectReferenceService;
	private IProject currentProject;

	public ProjectReferenceServiceProxy(final ReferenceService referenceService, final ProjectProvider projectProvider) {
		this.referenceService = Objects.requireNonNull(referenceService, "referenceService must not be null");
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		return referenceService.getCanonicalReference(bo);
	}

	public void dispose() {
		// Remove reference so that the reference service will be disposed even if a reference is kept to the proxy.
		this.currentProjectReferenceService = null;
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final Object bo) {
		return referenceService.getRelativeReference(bo);
	}

	@Override
	public Object resolve(final CanonicalBusinessObjectReference reference) {
		return getProjectReferenceService().resolve(reference);
	}

	private ProjectReferenceService getProjectReferenceService() {
		final IProject newProject = Objects.requireNonNull(projectProvider.getProject(), "Unable to retrieve project");
		if(currentProject == null ||
				currentProjectReferenceService == null ||
				currentProject != newProject) {
			currentProject = newProject;

			// A reference to the project reference service is stored instead of retrieving it each time because the reference service uses weak references to track project reference services.
			currentProjectReferenceService = Objects.requireNonNull(referenceService.getProjectReferenceService(currentProject), "Unable to retrieve project reference service");
		}

		return currentProjectReferenceService;
	}

	@Override
	public String getLabel(final CanonicalBusinessObjectReference ref, final IProject project) {
		return referenceService.getLabel(ref, project);
	}

	@Override
	public String getLabel(final RelativeBusinessObjectReference ref) {
		return referenceService.getLabel(ref);
	}

}
