package org.osate.xtext.aadl2.ui.editor

import com.google.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.emf.ecore.EReference
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.PartInitException
import org.eclipse.ui.ide.IDE
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.ui.resource.IStorage2UriMapper
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage

class Aadl2LanguageSpecificURIEditorOpener extends LanguageSpecificURIEditorOpener {
	val static logger = Logger.getLogger(Aadl2LanguageSpecificURIEditorOpener)
	
	@Inject
	IStorage2UriMapper mapper
	
	@Inject(optional = true)
	IWorkbench workbench
	
	/*
	 * Mostly copied from the super implementation. The one difference is to construct a
	 * ContributedAadlEditorInput if the storage is an instance of ContributedAadlStorage.
	 */
	override open(URI uri, EReference crossReference, int indexInList, boolean select) {
		val storages = mapper.getStorages(uri.trimFragment).iterator
		if (storages !== null && storages.hasNext) {
			try {
				val storage = storages.next.first
				val editorInput = if (storage instanceof ContributedAadlStorage) {
					new ContributedAadlEditorInput(storage)
				} else {
					EditorUtils.createEditorInput(storage)
				}
				val activePage = workbench.activeWorkbenchWindow.activePage
				val editor = IDE.openEditor(activePage, editorInput, editorId)
				selectAndReveal(editor, uri, crossReference, indexInList, select)
				return EditorUtils.getXtextEditor(editor)
			} catch (WrappedException e) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", e.cause)
			} catch (PartInitException partInitException) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", partInitException)
			}
		}
		null
	}
}