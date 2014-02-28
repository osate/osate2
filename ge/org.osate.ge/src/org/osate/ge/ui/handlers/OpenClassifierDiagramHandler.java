/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.ge.Activator;
import org.osate.ge.services.DiagramService;
import org.osate.ge.ui.util.SelectionHelper;
import org.osate.ge.util.Log;

/**
 * Handler for the open classifier diagram menu commands
 * @author philip.alldredge
 *
 */
public class OpenClassifierDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			Log.ok(getClass().getSimpleName() + " Started");			

			// Determine the classifier
			final Classifier classifier = getSelectedClassifier();
			if(classifier == null) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Select a classifier.");
			} else {
				final DiagramService diagramService = (DiagramService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(DiagramService.class);
				diagramService.openOrCreateDiagramForRootBusinessObject(classifier);
			}
			Log.ok(getClass().getSimpleName() + " Finished");
		} catch(RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Error opening classifier diagram handler: " + e.getMessage());
			Log.error("Error opening classifier diagram", e);
			throw e;
		}
		
		return null;
	}
	
	private Classifier getSelectedClassifier() {
		EObject obj = SelectionHelper.getSelectedObject();
		while(obj instanceof Element) {
			if(obj instanceof Classifier) {
				return (Classifier)obj;
			}
			
			obj = obj.eContainer();
		}

		return null;
	}
}
