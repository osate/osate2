/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.editor;


import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IEditorPart;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.impl.DefaultPropertyService;


public class AgeDiagramEditorActionBarContributor extends org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor {
	final ModeContributionItem selectedModeItem;
	final FlowContributionItem selectedFlowItem;
	
	public AgeDiagramEditorActionBarContributor() {
		final PropertyService propService = new DefaultPropertyService();
		selectedModeItem = new ModeContributionItem("org.osate.ge.ui.editor.items.selected_mode", propService);
		selectedFlowItem = new FlowContributionItem("org.osate.ge.ui.editor.items.selected_flow", propService);
	}
	
	@Override
	protected void buildActions() {
		super.buildActions();		
		addRetargetAction(new MatchSizeRetargetAction(MatchSizeAction.MATCH_SIZE));
		addRetargetAction(new DistributeHorizontallyRetargetAction(DistributeHorizontallyAction.DISTRIBUTE_HORIZONTALLY));
		addRetargetAction(new DistributeVerticallyRetargetAction(DistributeVerticallyAction.DISTRIBUTE_VERTICALLY));
	}
	
	@Override
	public void contributeToToolBar(final IToolBarManager tbm) {
		super.contributeToToolBar(tbm);
		tbm.insertAfter(GEFActionConstants.MATCH_HEIGHT, getAction(MatchSizeAction.MATCH_SIZE));
		tbm.insertAfter(GEFActionConstants.ALIGN_BOTTOM, new Separator());
		tbm.insertBefore(GEFActionConstants.MATCH_WIDTH, getAction(DistributeHorizontallyAction.DISTRIBUTE_HORIZONTALLY));
		tbm.insertAfter(DistributeHorizontallyAction.DISTRIBUTE_HORIZONTALLY, getAction(DistributeVerticallyAction.DISTRIBUTE_VERTICALLY));
		tbm.insertAfter(DistributeVerticallyAction.DISTRIBUTE_VERTICALLY, new Separator());
		tbm.add(selectedModeItem);
		tbm.add(new Separator());
		tbm.add(selectedFlowItem);
		tbm.add(new Separator());
	}
	
	@Override
	public final void setActiveEditor(final IEditorPart editor) {
		super.setActiveEditor(editor);
		selectedModeItem.setActiveEditor(editor);
		selectedFlowItem.setActiveEditor(editor);
	}
	

}
