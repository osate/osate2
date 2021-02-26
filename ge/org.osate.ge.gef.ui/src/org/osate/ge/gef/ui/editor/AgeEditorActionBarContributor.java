package org.osate.ge.gef.ui.editor;

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
import org.osate.ge.internal.ui.editor.DummyContributionItem;

public class AgeEditorActionBarContributor extends EditorActionBarContributor {
	private final ZoomSelectorContributionItem zoomItem;
	private final ModeContributionItem selectedModeItem;
	private final FlowContributionItem selectedFlowItem;
	private final ShowFlowContributionItem showFlowImplElements;
	private final EditFlowContributionItem editFlowItem;
	private final DeleteFlowContributionItem deleteFlowItem;
	private final DummyContributionItem dummyItem;

	public AgeEditorActionBarContributor() {
		zoomItem = new ZoomSelectorContributionItem();
		selectedModeItem = new ModeContributionItem("org.osate.ge.gef.ui.editor.items.selected_mode");
		showFlowImplElements = new ShowFlowContributionItem("org.osate.ge.gef.ui.editor.items.show_flow_elements");
		editFlowItem = new EditFlowContributionItem("org.osate.ge.gef.ui.editor.items.edit_flow");
		deleteFlowItem = new DeleteFlowContributionItem("org.osate.ge.gef.ui.editor.items.delete_flow");
		selectedFlowItem = new FlowContributionItem("org.osate.ge.gef.ui.editor.items.selected_flow",
				showFlowImplElements, editFlowItem, deleteFlowItem);
		dummyItem = new DummyContributionItem("org.osate.ge.gef.ui.editor.items.dummy"); // Needed to ensure separator appears
	}

	@Override
	public void dispose() {
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
