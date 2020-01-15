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
package org.osate.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class AadlPerspectiveFactory implements IPerspectiveFactory {
	public AadlPerspectiveFactory() {
		super();
	}

	@Override
	public void createInitialLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();

		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float) 0.25, editorArea);
		left.addView("org.osate.ui.navigator.AadlNavigator");
		left.addPlaceholder(IPageLayout.ID_RES_NAV);

		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.75, editorArea);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView("org.osate.xtext.aadl2.ui.propertyview.AadlPropertyView");
		bottom.addView("org.osate.ui.classifier_info_view");

		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, (float) 0.75, editorArea);

		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);

//		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);

		layout.addShowViewShortcut("org.osate.xtext.aadl2.ui.propertyview.AadlPropertyView");
		layout.addShowViewShortcut("org.osate.ui.navigator.AadlNavigator");
		layout.addShowViewShortcut("org.osate.ui.classifier_info_view");

		layout.addNewWizardShortcut("org.osate.ui.wizards.AadlProjectWizardID");
		layout.addNewWizardShortcut("org.osate.ui.NewAadlPackageWizard");
		layout.addNewWizardShortcut("org.osate.ui.NewPropertySetWizard");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
		layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");

		layout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective");
		layout.addPerspectiveShortcut("org.eclipse.team.cvs.ui.cvsPerspective");
		layout.addPerspectiveShortcut("org.eclipse.team.ui.TeamSynchronizingPerspective");
	}
}