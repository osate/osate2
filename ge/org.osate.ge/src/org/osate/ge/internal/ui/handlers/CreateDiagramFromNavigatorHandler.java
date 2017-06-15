// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.util.EditorUtil;
import org.osate.ui.navigator.AadlNavigator;
import org.osate.workspace.WorkspacePlugin;

public class CreateDiagramFromNavigatorHandler extends AbstractHandler {
	private static final String AADL_EXT = "aadl";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			// Determine the classifier
			final Element element = getSelectedElement();
			if (element != null) {
				if (element instanceof Classifier || element instanceof AadlPackage || element instanceof ComponentInstance) {
					final NamedElement ne = (NamedElement)element;
					final DiagramService diagramService = (DiagramService) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getService(DiagramService.class);
					final IFile file = diagramService.createDiagram(ne);
					if(file != null) {
						EditorUtil.openEditor(file, true);
					}
				} 
			}
		} catch (RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					Activator.PLUGIN_ID, "Error creating and opening diagram: " + e.getMessage());
			throw e;
		}

		return null;
	}

	private AadlPackage getSelectedPackage(final Element element) {
		final Element root = element.getElementRoot();
		if (root instanceof AadlPackage) {
			return (AadlPackage) root;
		}
		return null;
	}

	private Classifier getSelectedClassifier(EObject obj) {
		while (obj instanceof Element) {
			if (obj instanceof Classifier) {
				return (Classifier) obj;
			}
			obj = obj.eContainer();
		}
		return null;
	}

	private Element getSelectedElement() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		final IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		final IWorkbenchPage page = win.getActivePage();
		final IWorkbenchPart part = page.getActivePart();

		if (part instanceof AadlNavigator) {
			final ISelection selection = ((AadlNavigator) part).getCommonViewer().getSelection();
			if (selection instanceof TreeSelection) {
				final Object selectedObj = ((TreeSelection) selection).getFirstElement();
				if (selectedObj instanceof IFolder) {
					return null;
				} else if (selectedObj instanceof IProject) {
					return null;
				} else if (selectedObj instanceof IFile) {
					final String ext = ((IFile) selectedObj).getFileExtension();
					if (AADL_EXT.equalsIgnoreCase(ext) || WorkspacePlugin.INSTANCE_FILE_EXT.equalsIgnoreCase(ext)) {
						final EList<EObject> contents = OsateResourceUtil.getResource((IFile) selectedObj).getContents();
						if (null != contents && !contents.isEmpty()) {
							final EObject root = contents.get(0);
							if (root instanceof AadlPackage) {
								return (AadlPackage) root;
							} else if(root instanceof ComponentInstance) {
								return (ComponentInstance)root;
							} else {
								return null;
							}
						}
					} else {
						return null;
					}
				} else if (selectedObj instanceof PackageSection) {
					return getSelectedPackage((PackageSection) selectedObj);
				} else if (selectedObj instanceof AadlPackage) {
					return (AadlPackage) selectedObj;
				} else if (selectedObj instanceof Element) {
					return getSelectedClassifier((EObject) selectedObj);
				} else {
					return null;
				}
			}
		}
		return null;
	}
}