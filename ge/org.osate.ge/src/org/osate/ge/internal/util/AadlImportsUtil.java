package org.osate.ge.internal.util;

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
