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
package org.osate.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Inject;

public class InstantiateHandler extends AbstractHandler {
	@Inject
	private XtextResourceSetProvider resourceSetProvider;

	public InstantiateHandler() {
		Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		URI uri;
		if (selection instanceof EObjectNode) {
			uri = ((EObjectNode) selection).getEObjectURI();
		} else if (selection instanceof EObjectURIWrapper) {
			uri = ((EObjectURIWrapper) selection).getUri();
		} else {
			throw new AssertionError("Unexpected selection: " + selection);
		}
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
		ResourceSet resourceSet = resourceSetProvider.get(project);
		ComponentImplementation impl = (ComponentImplementation) resourceSet.getEObject(uri, true);
		AtomicBoolean instantiationSuccessful = new AtomicBoolean();
		try {
			new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, monitor -> {
				SubMonitor subMonitor = SubMonitor.convert(monitor, "Instantiating " + impl.getQualifiedName(), 1);
				try {
					SystemInstance instance = InstantiateModel.buildInstanceModelFile(impl, subMonitor.split(1));
					instantiationSuccessful.set(instance != null);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				}
			});
			if (!instantiationSuccessful.get()) {
				String message = "Error when instantiating the model";
				if (InstantiateModel.getErrorMessage() != null) {
					message = message + " - reason: " + InstantiateModel.getErrorMessage()
							+ "\nRefer to the help content and FAQ for more information";
				}
				Dialog.showError("Model Instantiate", message);
			}
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof UnsupportedOperationException) {
				Dialog.showError("Model Instantiate", "Operation is not supported: " + e.getCause().getMessage());
			} else {
				e.getCause().printStackTrace();
				Dialog.showError("Model Instantiate", "Error when instantiating the model");
			}
		} catch (InterruptedException e) {
			// Instantiation was canceled by the user.
		}

		return null;
	}
}