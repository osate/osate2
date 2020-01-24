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
package org.osate.ui.actions;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.Element;
import org.osate.ui.OsateUiPlugin;

/**
 * AaxlModifyAction defines an action framework for processing Aadl object model with modifications
  *
 * @deprecated Usage of this class should be replaced with
 * {@link org.osate.ui.actions.AaxlModifyActionAsJob}. Will be removed in 2.7.
*/
@Deprecated
public abstract class AaxlModifyAction extends AaxlReadOnlyAction {

	/**
	 * Override to wrap the execution of the action so that changes to the
	 * resource are tracked and the resource is saved afterwards if it has
	 * been changed.
	 */
	@Override
	final void processAaxlAction(final Resource resource, final Element root) {
		boolean prev = resource.isTrackingModification();
		// turn on modification tracking since we may make changes
		resource.setTrackingModification(true);
		doAaxlAction(root);
		if (resource.isModified()) {
			try {
				resource.save(null);
			} catch (IOException e) {
				IStatus status = new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, e.getMessage(), e);
				StatusManager.getManager().handle(status);
			}
		}
		resource.setTrackingModification(prev);
	}
}