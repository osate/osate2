package org.osate.ge.services.impl;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.osate.ge.services.RefactoringService;

public class DefaultRefactoringService implements RefactoringService {
	private final IFeatureProvider fp;
	
	public DefaultRefactoringService(final IFeatureProvider fp) {
		this.fp = fp;
	}
}
