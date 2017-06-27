/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.imv.ui.editor.ImvInstanceEditor;
import org.osate.imv.ui.perspective.ImvPerspectiveFactory;
import org.osate.workspace.WorkspacePlugin;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

public final class OpenImvEditor extends AbstractHandler {
	private void openImvEditor(NamedElement si, ExecutionEvent event) {
		// Create the editor input object.
		IEditorInput input = createEditorInput(si);
		if (input != null) {
			IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
			try {
				page.openEditor(input, ImvInstanceEditor.ID);
				openImvPerspective();
			} catch (PartInitException e) {
				System.err.println("Failed to open IMV editor for: " + si.getFullName());
				e.printStackTrace();
			}
		}
	}

	private IEditorInput createEditorInput(NamedElement si) {
		IEditorInput editorInput = null;
		Resource eRes = si.eResource();
		URI eUri = eRes.getURI();

		String last = eUri.lastSegment();
		String filename = last.substring(0, last.indexOf('.'));
		URI path = eUri.trimSegments(1);
		if (path.lastSegment().equalsIgnoreCase(WorkspacePlugin.AADL_INSTANCES_DIR)) {
			path = path.trimSegments(1);
		}

		URI imvURI = path.appendSegment("imv");
		imvURI = imvURI.appendSegment(filename);
		imvURI = imvURI.appendFileExtension("imv");
		AadlUtil.makeSureFoldersExist(OsateResourceUtil.getOsatePath(imvURI));
		IFile imvFile = OsateResourceUtil.getOsateIFile(imvURI);
		editorInput = new FileEditorInput(imvFile);

		return editorInput;
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		Element root = null;

		// We need to invoke the static 'getInstance' method here before we attempt to get the ResourceSet because
		// the Aadl2Activator must be instantiated before we get the ResourceSet.
		Aadl2Activator.getInstance();
		root = AadlUtil.getElement(getCurrentSelection(event));
		if (root == null) {
			Resource resource = OsateResourceUtil.getResource((IResource) getCurrentSelection(event));
			EObject eobj = resource.getContents().get(0);
			if (eobj instanceof Element)
				root = (Element) eobj;
		}

		// Get the system instance (if any)
		if (root instanceof InstanceObject || root instanceof AadlPackage) {
			final NamedElement si = (NamedElement) root;

			// We MUST open the IMV editor from the UI thread!
			HandlerUtil.getActiveShell(event).getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					// Open the IMV editor for the currently selected instance model or Aadl Package.
					openImvEditor(si, event);
				}
			});
		} else {
			System.err.println("Action should NOT be enabled: OpenImvEditor");
		}
		return null;
	}
	
	private void openImvPerspective() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		// Get the active page if one exists.
		IWorkbenchPage activePage = window.getActivePage();
		// Get perspective descriptor.
		IPerspectiveDescriptor desc = workbench.getPerspectiveRegistry()
				.findPerspectiveWithId(ImvPerspectiveFactory.ID);
		if (activePage != null && desc != null) {
			try {
				// Make the IMV perspective the active perspective if it is not already.
				if (ImvPerspectiveFactory.ID != activePage.getPerspective().getId()) {
					workbench.showPerspective(ImvPerspectiveFactory.ID, window);
				}
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * the current selection in the AADL model
	 */
	private Object getCurrentSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			return object;
		} else {
			return null;
		}
	}
}