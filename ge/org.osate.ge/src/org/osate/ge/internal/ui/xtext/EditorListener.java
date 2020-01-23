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
package org.osate.ge.internal.ui.xtext;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

class EditorListener implements IPartListener {
	private final String aadlXtextLanguageName = "org.osate.xtext.aadl2.Aadl2";
	private final OpenAadlResources openAadlResources;

	public EditorListener(final IWorkbenchPage activePage, final OpenAadlResources openAadlResources) {
		this.openAadlResources = openAadlResources;
		for(final IEditorReference editorRef : activePage.getEditorReferences()) {
			IEditorPart editor = editorRef.getEditor(false);
			if (editor != null) {
				partOpened(editor);
			}
		}
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		if(part instanceof XtextEditor) {
			final XtextEditor editor = (XtextEditor)part;
			if (aadlXtextLanguageName.equals(editor.getLanguageName()) && editor.getResource() instanceof IFile) {
				final URI resourceUri = URI.createPlatformResourceURI(editor.getResource().getFullPath().toString(),
						true);

				openAadlResources.onXtextDocumentOpened(editor.getDocument(), resourceUri);

				// Listen for input changes such as what occurs when the user saves the document with a different name with Save As...
				editor.getInternalSourceViewer().addTextInputListener(new ITextInputListener() {
					@Override
					public void inputDocumentAboutToBeChanged(final IDocument oldInput, final IDocument newInput) {
					}

					@Override
					public void inputDocumentChanged(final IDocument oldInput, final IDocument newInput) {
						// Remove the model listener
						if(oldInput instanceof IXtextDocument) {
							openAadlResources.onXtextDocumentClosed((IXtextDocument)oldInput);
						}

						if (newInput instanceof IXtextDocument && editor.getResource() instanceof IFile) {
							final URI resourceUri = URI
									.createPlatformResourceURI(editor.getResource().getFullPath().toString(), true);

							openAadlResources.onXtextDocumentOpened((IXtextDocument) newInput, resourceUri);
						}
					}
				});
			}
		}
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		if(part instanceof XtextEditor) {
			final XtextEditor editor = (XtextEditor)part;
			if(aadlXtextLanguageName.equals(editor.getLanguageName())) {
				final IXtextDocument document = editor.getDocument();
				openAadlResources.onXtextDocumentClosed(document);
			}
		}
	}
}
