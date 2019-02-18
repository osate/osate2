package org.osate.ui.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public final class AadlFileTypePropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final boolean testAadlPackage = property.equals("aadlPackage");
		final boolean testAadlPropertySet = property.equals("aadlPropertySet");
		if (receiver instanceof IFile && (testAadlPackage || testAadlPropertySet)) {
			final Resource resource = OsateResourceUtil.getResource((IFile) receiver,
					OsateResourceUtil.getResourceSet());
			if (!resource.getContents().isEmpty()) {
				final EObject root = resource.getContents().get(0);
				return (testAadlPackage && root instanceof AadlPackage)
						|| (testAadlPropertySet && root instanceof PropertySet);
			}
		}
		return false;
	}
}
