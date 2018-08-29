package org.osate.xtext.aadl2.ui.editor.model

import org.eclipse.core.runtime.CoreException
import org.eclipse.jface.text.source.AnnotationModel
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider
import org.osate.xtext.aadl2.ui.editor.ContributedAadlEditorInput

class Aadl2DocumentProvider extends XtextDocumentProvider {
	override protected createAnnotationModel(Object element) throws CoreException {
		if (element instanceof ContributedAadlEditorInput) {
			new AnnotationModel
		} else {
			super.createAnnotationModel(element)
		}
	}
}