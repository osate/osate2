package org.osate.ge.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.PackageSection;

/**
 * Stand-alone static methods for working with AADL models
 * @author philip.alldredge
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
}
