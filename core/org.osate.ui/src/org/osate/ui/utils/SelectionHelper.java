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
package org.osate.ui.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class SelectionHelper {
	private static EObjectAtOffsetHelper eObjectAtOffsetHelper = new EObjectAtOffsetHelper();

	public static XtextEditor getXtextEditor() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get active editor");
		}

		XtextEditor xtextEditor = activeEditor.getAdapter(XtextEditor.class);
		if (xtextEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get Xtext editor");
		}

		return xtextEditor;
	}

	public static EObject getEObjectFromSelection(final ISelection selection) {
		return getXtextEditor().getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {
			@Override
			public EObject exec(XtextResource resource) throws Exception {
				EObject targetElement = null;
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection ss = (IStructuredSelection) selection;
					Object eon = ss.getFirstElement();
					if (eon instanceof EObjectNode) {
						targetElement = ((EObjectNode) eon).getEObject(resource);
					}
				} else {
					targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
							((ITextSelection) selection).getOffset());
				}

				return targetElement;
			}
		});
	}

	public static EObject getSelectedObjectinOutline() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		final IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		final IEditorPart activeEditor = workbenchPage.getActiveEditor();
		EObject res;

		res = null;

		if (!(activeEditor instanceof XtextEditor)) {
			return null;
		}

		IWorkbenchPart workbenchPart = workbenchPage.getActivePart();

		if (workbenchPart instanceof ContentOutline) {
			ISelection selection = ((ContentOutline) workbenchPart).getSelection();
			res = getEObjectFromSelection(selection);
		}

		return res;
	}
}