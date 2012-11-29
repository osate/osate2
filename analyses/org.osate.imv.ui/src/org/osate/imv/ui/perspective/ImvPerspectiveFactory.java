/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.osate.imv.ui.views.FlowImpView;
import org.osate.imv.ui.views.ModesView;
import org.osate.imv.ui.views.filter.ElementFilterView;


public class ImvPerspectiveFactory implements IPerspectiveFactory {

	// ID
	public static final String ID = "org.osate.imv.ui.perspective.ImvPerspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// Editor area must be visible.
		layout.setEditorAreaVisible(true);

		// Create a folder that will be placed in the top/left portion of the workbench window.
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.TOP, (float)0.19, layout.getEditorArea());
		topLeft.addView(ModesView.ID);

		// Create a folder that will be placed in the top/right portion of the workbench window.
		IFolderLayout topRight= layout.createFolder("topRight", IPageLayout.RIGHT, (float)0.60, "topLeft");
		topRight.addView(FlowImpView.ID);

		// Add outline view to the right of the editor area.
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, 0.80f, layout.getEditorArea());

		// Add filter view below the outline view.
		layout.addView(ElementFilterView.ID, IPageLayout.BOTTOM, 0.50f, IPageLayout.ID_OUTLINE);


		// Add the 'AADL' perspective as a perspective shortcut.
		layout.addPerspectiveShortcut("org.osate.ui.perspective.AadlPerspective");
	}

}
