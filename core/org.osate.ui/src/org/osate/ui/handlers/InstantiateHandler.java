/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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