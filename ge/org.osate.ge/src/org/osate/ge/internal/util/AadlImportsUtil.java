package org.osate.ge.internal.util;

import org.osate.aadl2.AadlPackage;
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
}
