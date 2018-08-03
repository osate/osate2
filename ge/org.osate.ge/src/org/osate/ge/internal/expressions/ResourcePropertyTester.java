package org.osate.ge.internal.expressions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class ResourcePropertyTester extends org.eclipse.core.expressions.PropertyTester {
	private static final Object AADL_EXT = "aadl";

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IFolder) {
			final IFolder folder = (IFolder) receiver;
			if (property.equals("name")) {
				if (folder.getName().equalsIgnoreCase(expectedValue.toString())) {
					return true;
				}
			}
		} else if (receiver instanceof IFile) {
			final IFile file = (IFile) receiver;
			if (property.equals("isAadlPackage")) {
				if (AADL_EXT.equals(file.getFileExtension())) {
					EList<EObject> contents = OsateResourceUtil.getResource(file).getContents();
					if (null != contents && !contents.isEmpty()) {
						EObject root = contents.get(0);
						if (root instanceof AadlPackage) {
							return true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
