package org.osate.xtext.aadl2.ui.editor

import org.eclipse.ui.IElementFactory
import org.eclipse.ui.IMemento
import org.osate.pluginsupport.PluginSupportUtil
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage

import static extension org.eclipse.emf.common.util.URI.createURI

class ContributedAadlEditorInputFactory implements IElementFactory {
	val public static ID_FACTORY = "org.osate.xtext.aadl2.ui.editor.ContributedAadlEditorInputFactory"
	val public static TAG_URI = "uri"
	
	override createElement(IMemento memento) {
		val uri = memento.getString(TAG_URI)?.createURI
		if (PluginSupportUtil.contributedAadl.contains(uri)) {
			new ContributedAadlEditorInput(new ContributedAadlStorage(null,uri))
		}
	}
}