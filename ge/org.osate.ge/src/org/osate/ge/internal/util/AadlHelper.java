/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;

/**
 * Stand-alone static methods for working with AADL models
 *
 */
public class AadlHelper {
	/**
	 * Ensure that an element's package has the necessary imports to reference a specified object.
	 * @param pkgContext is the object that needs to referenced the containing object
	 * @param referencedObject is the object which needs to be referenced
	 */
	public static void ensurePackageIsImported(final Element pkgContext, final Object referencedObject) {
		if(referencedObject instanceof Classifier) {
			Classifier referencedClassifier = (Classifier)referencedObject;
			
			final AadlPackage pkg = (AadlPackage)pkgContext.getElementRoot();
			if(pkg != null) {
				final PackageSection section = pkg.getPublicSection();				
				if(referencedClassifier.eIsProxy()) {
					referencedClassifier = (Classifier)EcoreUtil.resolve(referencedClassifier, pkgContext.eResource());
				} 
				
				if(referencedClassifier.getNamespace() != null) {
					final AadlPackage classifierPkg = (AadlPackage)referencedClassifier.getNamespace().getOwner();
					if(pkg != classifierPkg && !section.getImportedUnits().contains(classifierPkg)) {
						section.getImportedUnits().add(classifierPkg);
					}
				}
			}
		}
	}
	
	/**
	 * Checks whether the named elements have the same name. Ignores case.
	 * @param ne1
	 * @param ne2
	 * @return
	 */
	public static boolean namesMatch(final NamedElement ne1, final NamedElement ne2) {
		if(ne1 == null || ne2 == null) {
			return ne1 == ne2;
		}
		
		if(ne1 == ne2) {
			return true;
		}
		
		final String n1 = ne1.getName();
		final String n2 = ne2.getName();
		return n1 != null && n1.equalsIgnoreCase(n2);
	}
}
