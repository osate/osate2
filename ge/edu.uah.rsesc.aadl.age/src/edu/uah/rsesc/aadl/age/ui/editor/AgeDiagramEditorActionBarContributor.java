package edu.uah.rsesc.aadl.age.ui.editor;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IEditorPart;

import edu.uah.rsesc.aadl.age.diagrams.common.util.impl.DefaultPropertyService;

public class AgeDiagramEditorActionBarContributor extends org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor {
	final ModeContributionItem selectedModeItem;
	//final FlowContributionItem selectedFlowItem = new FlowContributionItem("edu.uah.rsesc.aadl.age.ui.editor.items.selected_flow");
	
	public AgeDiagramEditorActionBarContributor() {
		selectedModeItem = new ModeContributionItem("edu.uah.rsesc.aadl.age.ui.editor.items.selected_mode", new DefaultPropertyService());
	}
	
	@Override
	public void contributeToToolBar(final IToolBarManager tbm) {
		super.contributeToToolBar(tbm);
		tbm.add(selectedModeItem);
	//	tbm.add(selectedFlowItem);
	}
	
	@Override
	public final void setActiveEditor(final IEditorPart editor) {
		super.setActiveEditor(editor);
		selectedModeItem.setActiveEditor(editor);
	//	selectedFlowItem.setActiveEditor(editor);
	}
}
