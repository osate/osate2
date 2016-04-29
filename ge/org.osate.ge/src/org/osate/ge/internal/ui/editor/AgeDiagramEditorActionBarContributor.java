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
import org.eclipse.graphiti.ui.internal.action.ToggleContextButtonPadAction;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.impl.DefaultPropertyService;
import org.osate.ge.internal.util.ExtensionUtil;

@SuppressWarnings({ "restriction" })
public class AgeDiagramEditorActionBarContributor extends org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor {
	final ModeContributionItem selectedModeItem;
	final FlowContributionItem selectedFlowItem;
	DummyContributionItem dummyItem;
	final NestingDepthSelectorContributionItem nestingDepthSelectorItem;
	
	public AgeDiagramEditorActionBarContributor() {
		final PropertyService propService = new DefaultPropertyService();
		selectedModeItem = new ModeContributionItem("org.osate.ge.ui.editor.items.selected_mode", propService);
		selectedFlowItem = new FlowContributionItem("org.osate.ge.ui.editor.items.selected_flow", propService);
		dummyItem = new DummyContributionItem("org.osate.ge.ui.editor.items.dummy");
		nestingDepthSelectorItem = new NestingDepthSelectorContributionItem("org.osate.ge.ui.editor.items.nesting_depth", propService);
	}
	
	@Override
	public void dispose() {
		selectedModeItem.setActiveEditor(null);
		selectedFlowItem.setActiveEditor(null);
		nestingDepthSelectorItem.setActiveEditor(null);
		super.dispose();
	}
	@Override
	protected void buildActions() {
		super.buildActions();		
		addRetargetAction(new MatchSizeRetargetAction(MatchSizeAction.MATCH_SIZE));
		addRetargetAction(new DistributeHorizontallyRetargetAction(DistributeHorizontallyAction.DISTRIBUTE_HORIZONTALLY));
		addRetargetAction(new DistributeVerticallyRetargetAction(DistributeVerticallyAction.DISTRIBUTE_VERTICALLY));
		addRetargetAction(new DecreaseNestingDepthRetargetAction());
		addRetargetAction(new IncreaseNestingDepthRetargetAction());

		// Create retarget actions of each tool
		for(final Object tool : getExtensionRegistryService().getTools()) {
			addRetargetAction(new ActivateToolRetargetAction(tool));
		}
	}
	
	@Override
	public void contributeToToolBar(final IToolBarManager tbm) {
		super.contributeToToolBar(tbm);
		tbm.insertAfter(GEFActionConstants.MATCH_HEIGHT, getAction(MatchSizeAction.MATCH_SIZE));
		tbm.insertAfter(GEFActionConstants.ALIGN_BOTTOM, new Separator());
		tbm.insertBefore(GEFActionConstants.MATCH_WIDTH, getAction(DistributeHorizontallyAction.DISTRIBUTE_HORIZONTALLY));
		tbm.insertAfter(DistributeHorizontallyAction.DISTRIBUTE_HORIZONTALLY, getAction(DistributeVerticallyAction.DISTRIBUTE_VERTICALLY));
		
		tbm.add(selectedModeItem);
		tbm.add(new Separator());
		tbm.add(selectedFlowItem);
		tbm.add(new Separator());
		tbm.add(dummyItem);
		
		// Add nesting depth control actions
		final String nestingControlInsertionPoint = MatchSizeAction.MATCH_SIZE;
		tbm.insertAfter(nestingControlInsertionPoint, nestingDepthSelectorItem);
		tbm.insertAfter(nestingControlInsertionPoint, getAction(IncreaseNestingDepthAction.ID));
		tbm.insertAfter(nestingControlInsertionPoint, getAction(DecreaseNestingDepthAction.ID));
		tbm.insertAfter(nestingControlInsertionPoint, new Separator());
		
		final String bindingInsertionPoint = MatchSizeAction.MATCH_SIZE;
		tbm.insertAfter(bindingInsertionPoint, new Separator());
		tbm.insertAfter(bindingInsertionPoint, new Separator());
		
		// Insert the actions for each tool
		final String toolsInsertionPoint = MatchSizeAction.MATCH_SIZE;
		for(final Object tool : getExtensionRegistryService().getTools()) {
			tbm.insertAfter(toolsInsertionPoint, getAction(ExtensionUtil.getId(tool)));
		}
		
		tbm.remove(ToggleContextButtonPadAction.ACTION_ID);
	}
	
	@Override
	public void contributeToMenu(final IMenuManager menubar) {
		super.contributeToMenu(menubar);		
		
		// Add actions for increase and decrease the nesting depth to the view menu.
		// TODO: As of 2014-11-10, Graphiti does not define a constant for the ID of the view menu so we must look it up. If/when such an ID is added,
		// lookup the menu by ID.
		for(final IContributionItem item : menubar.getItems()) {
			if(item instanceof SubContributionItem) {
				final IContributionItem innerItem = ((SubContributionItem) item).getInnerItem();
				if(innerItem instanceof MenuManager) {
					final MenuManager menuManager = (MenuManager)innerItem;
					if(menuManager.getMenuText().equalsIgnoreCase("View")) {
						menuManager.add(new Separator());
						menuManager.add(getAction(IncreaseNestingDepthAction.ID));
						menuManager.add(getAction(DecreaseNestingDepthAction.ID));
					}
				}
			}
		}
	}
	
	@Override
	public final void setActiveEditor(final IEditorPart editor) {
		super.setActiveEditor(editor);
		selectedModeItem.setActiveEditor(editor);
		selectedFlowItem.setActiveEditor(editor);
		nestingDepthSelectorItem.setActiveEditor(editor);
		
		// Update the visibility of contribution items
		if(editor instanceof AgeDiagramEditor) {
			final AgeDiagramEditor ageEditor = (AgeDiagramEditor)editor;
			if(ageEditor.getDiagramTypeProvider() != null) {
				final BusinessObjectResolutionService bor = (BusinessObjectResolutionService)ageEditor.getAdapter(BusinessObjectResolutionService.class);
				final Object diagramBo = bor.getBusinessObjectForPictogramElement(ageEditor.getDiagramTypeProvider().getDiagram());
			
				final boolean isComponentClassifierDiagram = diagramBo instanceof ComponentClassifier;
				final boolean isComponentImplementationDiagram = diagramBo instanceof ComponentImplementation;
				updateItemVisibility(getActionBars().getToolBarManager(), isComponentClassifierDiagram, isComponentImplementationDiagram);
				updateItemVisibility(getActionBars().getMenuManager(), isComponentClassifierDiagram, isComponentImplementationDiagram);
			}
		}
	}
	private void updateItemVisibility(final IContributionManager mgr, final boolean isComponentClassifierDiagram, final boolean isComponentImplementationDiagram) {
		for(final IContributionItem item : mgr.getItems()) {
			boolean show = true;
			final Object markedObject = item instanceof ActionContributionItem ? ((ActionContributionItem) item).getAction() : item;
			if(markedObject instanceof ComponentClassifierItem) {
				show = isComponentClassifierDiagram;
			} else if(markedObject instanceof ComponentImplementationItem) {
				show = isComponentImplementationDiagram; 
			}
			item.setVisible(show);
		}
		mgr.update(true);
	}
	
	private ExtensionRegistryService getExtensionRegistryService() {
		return (ExtensionRegistryService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ExtensionRegistryService.class);
	}
	
}
