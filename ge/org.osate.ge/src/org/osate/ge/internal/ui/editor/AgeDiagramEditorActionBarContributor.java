/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IEditorPart;

public class AgeDiagramEditorActionBarContributor extends org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor {
	final ModeContributionItem selectedModeItem;
	final FlowContributionItem selectedFlowItem;
	DummyContributionItem dummyItem;

	public AgeDiagramEditorActionBarContributor() {
		selectedModeItem = new ModeContributionItem("org.osate.ge.ui.editor.items.selected_mode");
		selectedFlowItem = new FlowContributionItem("org.osate.ge.ui.editor.items.selected_flow");
		dummyItem = new DummyContributionItem("org.osate.ge.ui.editor.items.dummy");
	}

	@Override
	public void dispose() {
		selectedModeItem.setActiveEditor(null);
		selectedFlowItem.setActiveEditor(null);
		super.dispose();
	}

	@Override
	public void contributeToToolBar(final IToolBarManager tbm) {
		// Don't call base class. Want to override completely.
		// super.contributeToToolBar(tbm);

		tbm.add(getAction(GEFActionConstants.ZOOM_OUT));
		tbm.add(getAction(GEFActionConstants.ZOOM_IN));
		ZoomComboContributionItem zoomCombo = new ZoomComboContributionItem(getPage());
		tbm.add(zoomCombo);

		tbm.add(new Separator());

		tbm.add(selectedModeItem);
		tbm.add(new Separator());
		tbm.add(selectedFlowItem);
		tbm.add(new Separator());
		tbm.add(dummyItem);
	}

	@Override
	public final void setActiveEditor(final IEditorPart editor) {
		super.setActiveEditor(editor);
		selectedModeItem.setActiveEditor(editor);
		selectedFlowItem.setActiveEditor(editor);
	}

}
