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

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.Element;
import org.osate.ui.OsateUiPlugin;

/**
 * AaxlModifyHandler defines an action framework for processing Aadl object model
 * with modifications.
 */
public abstract class AbstractInstanceOrDeclarativeModelModifyHandler
		extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	/**
	 * Override to wrap the execution of the action so that changes to the
	 * resource are tracked and the resource is saved afterwards if it has
	 * been changed.
	 */
	/*
	 * This is identical to what we do in AaxlModifyActionAsJob. The
	 * extension hierarchy is getting a big out of control, but that is the
	 * price we pay for not break existing code.
	 */
	@Override
	final void processAaxlAction(final IProgressMonitor monitor, final Resource resource, final Element root) {
		boolean prev = resource.isTrackingModification();
		// turn on modification tracking since we may make changes
		resource.setTrackingModification(true);
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		// We execute this command on the command stack because otherwise, we will not
		// have write permissions on the editing domain.
		Command cmd = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doAaxlAction(monitor, root);
				if (resource.isModified()) {
					try {
						resource.save(null);
					} catch (IOException e) {
						IStatus status = new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, e.getMessage(), e);
						StatusManager.getManager().handle(status);
					}
				}
			}

		};

		try {
			((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resource.setTrackingModification(prev);
	}
}