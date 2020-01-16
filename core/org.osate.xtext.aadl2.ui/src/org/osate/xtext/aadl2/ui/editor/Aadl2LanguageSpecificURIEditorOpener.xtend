/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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