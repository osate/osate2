/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.DeleteResourceAction;
import org.eclipse.ui.ide.undo.DeleteResourcesOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class ActionProvider extends org.eclipse.ui.navigator.CommonActionProvider {
	public void fillActionBars(final IActionBars actionBars) {
		super.fillActionBars(actionBars);
		
		if(getSelectedDiagramFile() != null) {
			actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteHandler);
		}
	}
	
	@Override
	public void fillContextMenu(final IMenuManager menu) {
		super.fillContextMenu(menu);

		if(getSelectedDiagramFile() != null) {
			// Replace the delete resource action with our handler
			menu.insertAfter(DeleteResourceAction.ID, deleteHandler);
			menu.remove(DeleteResourceAction.ID);
		}
	}
	
	private IFile getSelectedDiagramFile() {
		final IStructuredSelection selection = (IStructuredSelection)getContext().getSelection();
		if(selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			
			// Check if the resource is a diagram
			if(selectedElement instanceof IFile) {
				final IFile selectedFile = (IFile)selectedElement;
				if(selectedFile.getName().endsWith(AgeDiagramEditor.EXTENSION)) {
					return selectedFile;
				}
			}
		}
		
		return null;
	}
	
	private final IAction deleteHandler = new Action("Delete") {
		@Override
		public void run() {
			final IFile diagramFile = getSelectedDiagramFile();
			if(diagramFile != null) {
				if(confirmDelete(diagramFile)) {
					final Job deleteJob = new Job("Delete Diagram") {
						@Override
						protected IStatus run(IProgressMonitor monitor) {
							try {
								final DeleteResourcesOperation op = new DeleteResourcesOperation(new IResource[] { diagramFile }, "Delete Diagram", false);
								return PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute(op, monitor, 
										WorkspaceUndoUtil.getUIInfoAdapter(getActionSite().getViewSite().getShell()));
							} catch(Exception e) {
								if(e.getCause() instanceof CoreException) {
									return ((CoreException)e.getCause()).getStatus();
								} 
								
								return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
							}
						}
						
					};

					deleteJob.setUser(true);
					deleteJob.schedule();
				}
			}
		}
	};
	
	private boolean confirmDelete(final IFile diagramFile) {
		// Get the name of the selected diagram
		String diagramName = diagramFile.getName();
		try {
			final URI diagramUri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(diagramUri, true);
			for(final EObject obj : resource.getContents()) {
				if(obj instanceof Diagram) {
					final Diagram diagram = (Diagram)obj;
					diagramName = diagram.getName();
					break;
				}
			}
		} catch(Exception e) {
			// Ignore all exceptions while trying to get the diagram's name
		}
				
		return MessageDialog.openQuestion(getActionSite().getViewSite().getShell(), "Delete Diagram", "Are you sure you want to delete '" + diagramName + "'?");
	}
}
