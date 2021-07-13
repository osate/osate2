/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.State;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RegistryToggleState;
import org.osate.ge.gef.ui.AgeGefUiPlugin;
import org.osate.ge.gef.ui.preferences.Preferences;

public class ShowGridHandler extends AbstractHandler {
	private static final String SHOW_GRID_CMD_ID = "org.osate.ge.gef.ui.commands.showGrid";
	private final IPreferenceStore preferenceStore = AgeGefUiPlugin.getDefault().getPreferenceStore();

	public ShowGridHandler() {
		// Set toggle state based on preferences
		final ICommandService service = PlatformUI.getWorkbench().getService(ICommandService.class);
		final State toggleState = service.getCommand(SHOW_GRID_CMD_ID).getState(RegistryToggleState.STATE_ID);
		final boolean value = preferenceStore.getBoolean(Preferences.SHOW_GRID);
		toggleState.setValue(value);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final boolean currentValue = HandlerUtil.toggleCommandState(event.getCommand());
		// Update show grid value
		preferenceStore.setValue(Preferences.SHOW_GRID, !currentValue);
		return null;
	}
}
