/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class PropertyTester extends org.eclipse.core.expressions.PropertyTester {
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
