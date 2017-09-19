package org.osate.ge.internal.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;

// Low level service for retrieving and working with AADL Packages that must be loaded by the editor rather than
// loaded by Xtext. Ensures that only one copy of the package is open at a time. That version is shared between all editors
// that need access to the package.
public interface SavedAadlResourceService {
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

	/**
	 * Notified the service that the resource is being saved. Used to prevent reloading resource when the file change was due to a save
	 * by the editor.
	 * @param resource
	 * @param value
	 */
	void setSaveInProgress(final Resource resource, boolean value);

	/**
	 * Notify the service that the resource has being saved. Used to avoid reloading resource when the file change was due to a save
	 * by the editor. Should only be called when the underlying file is being saved directly instead of using the xtext editor.
	 * @param resource
	 */
	void markAsSaved(final Resource resource);
}
