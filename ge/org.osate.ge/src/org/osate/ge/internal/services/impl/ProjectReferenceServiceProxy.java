package org.osate.ge.internal.services.impl;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
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

}
