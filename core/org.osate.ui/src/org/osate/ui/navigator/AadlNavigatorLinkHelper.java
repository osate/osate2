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
package org.osate.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.ui.editor.ContributedAadlEditorInput;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlNavigatorLinkHelper implements ILinkHelper {
	private final IURIEditorOpener editorOpener = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(IURIEditorOpener.class);

	@Override
	public IStructuredSelection findSelection(IEditorInput anInput) {
		if (anInput instanceof ContributedAadlEditorInput) {
			try {
				return new StructuredSelection(((ContributedAadlEditorInput) anInput).getStorage());
			} catch (CoreException e) {
				return StructuredSelection.EMPTY;
			}
		} else {
			IFile file = ResourceUtil.getFile(anInput);
			if (file != null) {
				return new StructuredSelection(file);
			} else {
				return StructuredSelection.EMPTY;
			}
		}
	}

	@Override
	public void activateEditor(IWorkbenchPage page, IStructuredSelection structuredSelection) {
		if (structuredSelection == null || structuredSelection.isEmpty()) {
			return;
		}
		Object selected = structuredSelection.getFirstElement();
		if (selected instanceof IFile) {
			IEditorPart editor = page.findEditor(new FileEditorInput((IFile) selected));
			if (editor != null) {
				page.bringToTop(editor);
			}
		} else if (selected instanceof ContributedAadlStorage) {
			ContributedAadlStorage storage = (ContributedAadlStorage) selected;
			IEditorPart editor = page.findEditor(new ContributedAadlEditorInput(storage));
			if (editor != null) {
				page.bringToTop(editor);
			}
		} else if (selected instanceof EObjectURIWrapper) {
			EObjectURIWrapper navigatorNode = (EObjectURIWrapper) selected;
			URI resourceURI = navigatorNode.getUri().trimFragment();
			IEditorPart editor = null;
			if (resourceURI.isPlatformResource()) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IFile file = root.getFile(new Path(null, resourceURI.toPlatformString(true)));
				editor = page.findEditor(new FileEditorInput(file));
			} else if (resourceURI.isPlatformPlugin()) {
				ContributedAadlStorage storage = new ContributedAadlStorage(null, resourceURI);
				editor = page.findEditor(new ContributedAadlEditorInput(storage));
			}
			if (editor != null) {
				page.bringToTop(editor);
				if (editor instanceof XtextEditor) {
					editorOpener.open(navigatorNode.getUri(), true);
				} else {
					IGotoMarker gotoMarkerAdapter = Adapters.adapt(editor, IGotoMarker.class);
					if (gotoMarkerAdapter != null) {
						try {
							IMarker marker = ResourcesPlugin.getWorkspace().getRoot().createMarker(IMarker.MARKER);
							marker.setAttribute("uri", navigatorNode.getUri().toString());
							gotoMarkerAdapter.gotoMarker(marker);
							marker.delete();
						} catch (CoreException e) {
							OsateCorePlugin.log(e);
						}
					}
				}
			}
		}
	}
}