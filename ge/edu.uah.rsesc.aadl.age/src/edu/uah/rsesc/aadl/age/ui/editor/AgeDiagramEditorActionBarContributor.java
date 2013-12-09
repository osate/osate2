/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.ui.editor;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IEditorPart;

import edu.uah.rsesc.aadl.age.services.impl.DefaultPropertyService;

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
