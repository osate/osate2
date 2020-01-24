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
package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

public class AadlProjectDependenciesActionProvider extends CommonActionProvider {
	private static final String ID = "org.eclipse.ui.propertypages.project.reference";
	private static final String[] ID_LIST = { ID };
	private static final Object DUMMY_DATA = new Object();

	private final Action editDependenciesAction;

	public AadlProjectDependenciesActionProvider() {
		editDependenciesAction = new Action() {
			{
				setText("Edit Referenced Projects...");
				setToolTipText("Open the project references property page.");
			}

			@Override
			public void run() {
				Object[] selectedElements = getActionSite().getStructuredViewer().getStructuredSelection().toArray();
				if (selectedElements.length == 1) {
					final Object selection = selectedElements[0];
					IProject project = null;
					if (selection instanceof IProject) {
						project = (IProject) selection;
					} else if (selection instanceof VirtualProjectDependencies) {
						project = ((VirtualProjectDependencies) selection).getProject();
					} else if (selection instanceof VirtualProjectNode) {
						project = ((VirtualProjectNode) selection).getParent().getProject();
					}
					if (project != null) {
						PreferencesUtil.createPropertyDialogOn(getActionSite().getViewSite().getShell(), project, ID,
								ID_LIST, DUMMY_DATA).open();
					}
				}
			}
		};
	}

	@Override
	public void fillContextMenu(final IMenuManager aMenu) {
		if (getContext().getSelection().isEmpty()) {
			return;
		}

		if (editDependenciesAction.isEnabled()) {
			aMenu.insertAfter(ICommonMenuConstants.GROUP_PROPERTIES, editDependenciesAction);
		}
	}
}