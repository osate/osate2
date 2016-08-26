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
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ui.navigator.AadlNavigator;

public class OpenDiagramFromNavigatorHandler extends AbstractHandler {
	private static final Object AADL_EXT = "aadl";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			// Determine the classifier
			Element element = getSelectedElement();
			if (element != null) {
				if (element instanceof Classifier) {
					final Classifier classifier = (Classifier) element;
					final DiagramService diagramService = (DiagramService) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getService(DiagramService.class);
					diagramService.openOrCreateDiagramForRootBusinessObject(classifier);

				} else if (element instanceof AadlPackage) {
					final AadlPackage pkg = (AadlPackage) element;
					final DiagramService diagramService = (DiagramService) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getService(DiagramService.class);
					diagramService.openOrCreateDiagramForRootBusinessObject(pkg);

				}
			}
		} catch (RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					Activator.PLUGIN_ID, "Error opening diagram: " + e.getMessage());
			throw e;
		}

		return null;
	}

	private AadlPackage getSelectedPackage(Element element) {
		Element root = element.getElementRoot();
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
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();

		Object selectedObj = null;
		if (part instanceof AadlNavigator) {
			ISelection selection = ((AadlNavigator) part).getCommonViewer().getSelection();
			if (selection instanceof TreeSelection) {
				selectedObj = ((TreeSelection) selection).getFirstElement();
				if (selectedObj instanceof IFolder) {
					return null;
				} else if (selectedObj instanceof IProject) {
					return null;
				} else if (selectedObj instanceof IFile) {
					if (AADL_EXT.equals(((IFile) selectedObj).getFileExtension())) {
						EList<EObject> contents = OsateResourceUtil.getResource((IFile) selectedObj).getContents();
						if (null != contents && !contents.isEmpty()) {
							EObject root = contents.get(0);
							if (root instanceof AadlPackage) {
								return (AadlPackage) root;
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