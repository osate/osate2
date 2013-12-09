/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import edu.uah.rsesc.aadl.age.Activator;
import edu.uah.rsesc.aadl.age.services.DiagramService;
import edu.uah.rsesc.aadl.age.ui.util.SelectionHelper;
import edu.uah.rsesc.aadl.age.util.Log;

/**
 * Handler for the open package diagram menu commands
 * @author philip.alldredge
 *
 */
public class OpenPackageDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			Log.ok(getClass().getSimpleName() + " Started");
			
			// Get the selected package and try to create\open a diagram for it
			final AadlPackage pkg = getSelectedPackage();
			if(pkg == null) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Select a package or classifier.");
			} else {
				final DiagramService diagramService = (DiagramService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(DiagramService.class);
				diagramService.openOrCreateDiagramForRootBusinessObject(pkg);	
			}			
			Log.ok(getClass().getSimpleName() + " Finished");
		} catch(RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Error opening package diagram handler: " + e.getMessage());
			Log.error("Error opening package diagram", e);
			throw e;
		}
		
		return null;
	}
	
	private AadlPackage getSelectedPackage() {
		final EObject obj = SelectionHelper.getSelectedObject();
		if(obj instanceof Element) {
			Element root = ((Element)obj).getElementRoot();
			if(root instanceof AadlPackage) {
				return (AadlPackage)root;
			}
		}

		return null;
	}
}
