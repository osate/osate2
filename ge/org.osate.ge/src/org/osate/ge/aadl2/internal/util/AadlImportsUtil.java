/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.aadl2.internal.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PackageSection;

public class AadlImportsUtil {
	/**
	 * Adds an import for pkg to section if it is not already imported.
	 * @param section
	 * @param pkg
	 */
	public static void addImportIfNeeded(final PackageSection section, final AadlPackage pkg) {
		final String pkgQualifiedName = pkg.getQualifiedName();
		if(pkgQualifiedName == null) {
			return;
		}

		// Don't do anything if the package is the owner of the section
		if(section.getOwner() instanceof AadlPackage &&
				pkgQualifiedName.equalsIgnoreCase(((AadlPackage)section.getOwner()).getQualifiedName())) {
			return;
		}

		//
		boolean isImported = false;
		for(final ModelUnit mu : section.getImportedUnits()) {
			final String qn = mu.getQualifiedName();
			if (pkgQualifiedName.equalsIgnoreCase(qn)) {
				isImported = true;
				break;
			}
		}

		// Import the package if needed
		if(!isImported) {
			section.getImportedUnits().add(pkg);
		}
	}

	/**
	 * Ensure that an element's package has the necessary imports to reference a specified object.
	 * Only supports classifiers as the referenced object at this time.
	 * If the referenced element is not a classifier, then the method does not perform any changes.
	 * @param pkgContext is the object that needs to reference the containing object
	 * @param referencedObject is the object which needs to be referenced.
	 */
	public static void ensurePackageIsImportedForClassifier(final Element pkgContext, final Object referencedObject) {
		final AadlPackage referencingPkg = (AadlPackage) pkgContext.getElementRoot();
		if (referencingPkg == null) {
			return;
		}

		final PackageSection referencingSection = referencingPkg.getPublicSection();

		if (referencedObject instanceof Classifier) {
			Classifier referencedClassifier = (Classifier) referencedObject;

			if (referencedClassifier.eIsProxy()) {
				referencedClassifier = (Classifier) EcoreUtil.resolve(referencedClassifier, pkgContext.eResource());
			}

			if (referencedClassifier.getNamespace() != null
					&& referencedClassifier.getNamespace().getOwner() instanceof AadlPackage) {
				final AadlPackage referencedPkg = (AadlPackage) referencedClassifier.getNamespace().getOwner();
				addImportIfNeeded(referencingSection, referencedPkg);
			}
		}
	}
}
