package org.osate.xtext.aadl2.ui.editor.model

import org.eclipse.core.resources.IStorage
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage

class Aadl2ResourceForEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {
	override protected createResourceFor(IStorage storage) throws CoreException {
		if (storage instanceof ContributedAadlStorage) {
			/*
			 * Mostly copied from ResourceForIEditorInputFactory.createResourceFor(IStorage).
			 * Ensures that contributed aadl resources have a platform plugin URI and not a platform resource URI.
			 */
			val resourceSet = getResourceSet(storage)
			val uri = storage.uri
			configureResourceSet(resourceSet, uri)
			val resource = resourceFactory.createResource(uri) as XtextResource
			resourceSet.resources += resource
			resource.validationDisabled = isValidationDisabled(uri, storage)
			resource
		} else {
			super.createResourceFor(storage)
		}
	}
}