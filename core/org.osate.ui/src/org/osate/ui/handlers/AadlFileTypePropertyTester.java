package org.osate.ui.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public final class AadlFileTypePropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final boolean testAadlPackage = property.equals("aadlPackage");
		final boolean testAadlPropertySet = property.equals("aadlPropertySet");
		if (receiver instanceof IFile && (testAadlPackage || testAadlPropertySet)) {
			final IFile file = (IFile) receiver;
			if ("aadl".equalsIgnoreCase(file.getFileExtension())) {
				final URI uri = OsateResourceUtil.toResourceURI(file);
				final Resource resource = new ResourceSetImpl().getResource(uri, true);
				if (!resource.getContents().isEmpty()) {
					final EObject root = resource.getContents().get(0);
					return (testAadlPackage && root instanceof AadlPackage)
							|| (testAadlPropertySet && root instanceof PropertySet);
				}
			}
		}
		return false;
	}
}
