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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

import com.google.inject.Injector;

public class AadlNavigatorActionProvider extends CommonActionProvider {
	private final IURIEditorOpener editorOpener;
	private final Action openFileAction;

	public AadlNavigatorActionProvider() {
		Injector injector = Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		editorOpener = injector.getInstance(IURIEditorOpener.class);
		openFileAction = new Action() {
			{
				setText("&Open");
				setToolTipText("Open in an AADL editor");
			}

			@Override
			public void run() {
				Object[] selectedElements = getActionSite().getStructuredViewer().getStructuredSelection().toArray();
				for (Object selected : selectedElements) {
					if (selected instanceof ContributedAadlStorage) {
						editorOpener.open(((ContributedAadlStorage) selected).getUri(), true);
					} else if (selected instanceof EObjectURIWrapper) {
						editorOpener.open(((EObjectURIWrapper) selected).getUri(), true);
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

		if (openFileAction.isEnabled()) {
			aMenu.insertAfter(ICommonMenuConstants.GROUP_OPEN, openFileAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openFileAction);
	}
}