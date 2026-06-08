/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Objects;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.osate.ge.aadl2.ui.internal.editor.DeleteFlowContributionItem;
import org.osate.ge.aadl2.ui.internal.editor.EditFlowContributionItem;
import org.osate.ge.aadl2.ui.internal.editor.FlowContributionItem;
import org.osate.ge.aadl2.ui.internal.editor.ModeContributionItem;
import org.osate.ge.aadl2.ui.internal.editor.ShowFlowContributionItem;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.ui.editor.DummyContributionItem;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Action bar contributor for {@link AgeEditor}. Provides items for the action bar when the graphical editor is active.
 * This class is referenced as part of the editor extension definition.
 *
 */
public final class AgeEditorActionBarContributor extends EditorActionBarContributor {
	private final ZoomSelectorContributionItem zoomItem;
	private final ModeContributionItem selectedModeItem;
	private final FlowContributionItem selectedFlowItem;
	private final ShowFlowContributionItem showFlowImplElements;
	private final EditFlowContributionItem editFlowItem;
	private final DeleteFlowContributionItem deleteFlowItem;
	private final DummyContributionItem dummyItem;

	/**
	 * Creates a new instance
	 */
	public AgeEditorActionBarContributor() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ModelChangeNotifier.class),
				"unable to retrieve model change notifier");

		zoomItem = new ZoomSelectorContributionItem();
		selectedModeItem = new ModeContributionItem("org.osate.ge.gef.ui.editor.items.selected_mode",
				modelChangeNotifier);
		showFlowImplElements = new ShowFlowContributionItem("org.osate.ge.gef.ui.editor.items.show_flow_elements");
		editFlowItem = new EditFlowContributionItem("org.osate.ge.gef.ui.editor.items.edit_flow");
		deleteFlowItem = new DeleteFlowContributionItem("org.osate.ge.gef.ui.editor.items.delete_flow");
		selectedFlowItem = new FlowContributionItem("org.osate.ge.gef.ui.editor.items.selected_flow",
				showFlowImplElements, editFlowItem, deleteFlowItem, modelChangeNotifier);
		dummyItem = new DummyContributionItem("org.osate.ge.gef.ui.editor.items.dummy"); // Needed to ensure separator appears
	}

	@Override
	public void dispose() {
		zoomItem.setActiveEditor(null);
		selectedModeItem.setActiveEditor(null);
		selectedFlowItem.setActiveEditor(null);
		showFlowImplElements.setActiveEditor(null);
		editFlowItem.setActiveEditor(null);
		deleteFlowItem.setActiveEditor(null);
		super.dispose();
	}

	@Override
	public void contributeToToolBar(final IToolBarManager tbm) {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			tbm.add(new CommandContributionItem(new CommandContributionItemParameter(window, null,
					"org.osate.ge.gef.ui.commands.zoomOut", CommandContributionItem.STYLE_PUSH)));
			tbm.add(new CommandContributionItem(new CommandContributionItemParameter(window, null,
					"org.osate.ge.gef.ui.commands.zoomIn", CommandContributionItem.STYLE_PUSH)));
		}

		tbm.add(zoomItem);
		tbm.add(selectedModeItem);
		tbm.add(new Separator());
		tbm.add(selectedFlowItem);
		tbm.add(showFlowImplElements);
		tbm.add(editFlowItem);
		tbm.add(deleteFlowItem);
		tbm.add(new Separator());
		tbm.add(dummyItem);
	}

	@Override
	public final void setActiveEditor(final IEditorPart editor) {
		super.setActiveEditor(editor);
		zoomItem.setActiveEditor(editor);
		selectedModeItem.setActiveEditor(editor);
		selectedFlowItem.setActiveEditor(editor);
		showFlowImplElements.setActiveEditor(editor);
		editFlowItem.setActiveEditor(editor);
		deleteFlowItem.setActiveEditor(editor);
	}
}
