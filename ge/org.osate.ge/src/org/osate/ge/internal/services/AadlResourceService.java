package org.osate.ge.internal.services;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AadlPackage;

// Low level service for retrieving AADL resources. This service provides references to "live" resources.
// Ensures that only one copy of the package is open at a time. That version is shared between all editors
// that need access to the package.
public interface AadlResourceService {
	public interface AadlPackageReference {
		AadlPackage getAadlPackage();
	}

	/**
	 * Returns a reference to an AadlPackage based on the package URI. The reference itself should be help as long as the package is needed.
	 * The package will return the latest version of the package which has been saved.
	 * @param packageUri
	 * @return
	 */
	AadlPackageReference getPackageReference(URI packageUri);
}
