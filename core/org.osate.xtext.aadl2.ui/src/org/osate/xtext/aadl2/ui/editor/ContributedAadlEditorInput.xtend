package org.osate.xtext.aadl2.ui.editor

import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage
import org.eclipse.ui.IPersistableElement
import org.eclipse.ui.IMemento

class ContributedAadlEditorInput extends XtextReadonlyEditorInput {
	val ContributedAadlStorage storage
	
	new(ContributedAadlStorage storage) {
		super(storage)
		this.storage = storage
	}
	
	override getPersistable() {
		new IPersistableElement {
			override getFactoryId() {
				ContributedAadlEditorInputFactory.ID_FACTORY
			}
			
			override saveState(IMemento memento) {
				memento.putString(ContributedAadlEditorInputFactory.TAG_URI, storage.uri.toString)
			}
		}
	}
}