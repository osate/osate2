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

import java.util.stream.Stream;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.wizards.WizardShortcutAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.wizards.IWizardDescriptor;

public class NewAadlProjectActionProvider extends CommonActionProvider {
	private IAction action;
	
	@Override
	public void init(ICommonActionExtensionSite aSite) {
		if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchWindow window = ((ICommonViewerWorkbenchSite) aSite.getViewSite()).getWorkbenchWindow();
			IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry()
					.findWizard("org.osate.ui.wizards.AadlProjectWizardID");
			action = new WizardShortcutAction(window, descriptor);
		}
	}
	
	@Override
	public void fillContextMenu(IMenuManager menu) {
		if (action != null) {
			Stream.of(menu.getItems())
				.filter(item -> item instanceof IMenuManager)
				.map(item -> (IMenuManager) item)
				.filter(item -> "common.new.menu".equals(item.getId()))
				.findFirst()
				.ifPresent(newMenu -> {
					IContributionItem[] items = newMenu.getItems();
					newMenu.removeAll();
					newMenu.add(action);
					Stream.of(items).forEach(item -> newMenu.add(item));
				});
		}
	}
	
	@Override
	public void dispose() {
		action = null;
	}
}