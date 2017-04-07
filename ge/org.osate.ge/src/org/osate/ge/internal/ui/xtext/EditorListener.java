/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.xtext;

import org.eclipse.core.resources.IFile;
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
			if(aadlXtextLanguageName.equals(editor.getLanguageName()) && editor.getResource() instanceof IFile) {				
				openAadlResources.onXtextDocumentOpened(editor.getDocument());

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
						
						if(newInput instanceof IXtextDocument) {
							openAadlResources.onXtextDocumentOpened((IXtextDocument)newInput);
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
				openAadlResources.onXtextDocumentClosed(document);;
			}
		}
	}	
}
