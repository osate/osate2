/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.PropertyService;

public class ModeContributionItem extends ComboContributionItem implements ComponentClassifierItem {
	private static final String emptySelectionTxt = "<Modes>";
	private static final String selectedModePropertyKey = "org.osate.ge.ui.editor.selectedMode";
	private final PropertyService propertyUtil;
	private AgeDiagramEditor editor = null;	
	
	public ModeContributionItem(final String id, final PropertyService propertyUtil) {
		super(id);
		this.propertyUtil = propertyUtil;
	}
	
	@Override
	public boolean isDynamic() {
		return true;
	}
	
	public final void setActiveEditor(final IEditorPart newEditor) {
		if(editor != newEditor) {
			saveModeSelection();

			// Update the editor
			if(getBusinessObjectForEditor(newEditor) instanceof ComponentClassifier) {
				this.editor = (AgeDiagramEditor)newEditor;
			} else {
				this.editor = null;
			}
			
			refresh();
		}
	}
	
	@Override
	protected void onControlDisposed() {
		saveModeSelection();
		super.onControlDisposed();
	}
	
	private void saveModeSelection() {
		// Save the current mode selection
		final Combo cmb = this.getCombo();
		if(cmb != null) {
			if(this.editor != null) {
				final String selection = cmb.getText();
				editor.setPartProperty(selectedModePropertyKey, selection);
			}
		}
	}
	
	private static Object getBusinessObjectForEditor(final IEditorPart part) {
		if(!(part instanceof AgeDiagramEditor)) {
			return null;
		}
			
		final AgeDiagramEditor ed = (AgeDiagramEditor)part;
		final IFeatureProvider fp = ed.getDiagramTypeProvider().getFeatureProvider();
		return AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(ed.getDiagramTypeProvider().getDiagram()));
	}
	
	/**
	 * Get the top-level component classifier from the editor
	 * @return
	 */
	private ComponentClassifier getComponentClassifier() {
		if(editor != null) {
			// Get the AADL Element at the top level of the diagram
			final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
			final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
			final NamedElement element = (NamedElement)AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(diagram));
			if(element instanceof ComponentClassifier) {
				return (ComponentClassifier)element;
			}
		}
		
		return null;
	}	
	
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		refresh(); // Populate the combo box
		return control;
	}
	
	private void refresh() {
		final Combo combo = getCombo();
		if(combo != null) {
			String selectedModeName = null;
			if(editor != null) {
				selectedModeName = editor.getPartProperty(selectedModePropertyKey);
				if(selectedModeName == null) {
					selectedModeName = propertyUtil.getSelectedMode(editor.getDiagramTypeProvider().getDiagram()); 
				}
			}
			
			// Clear the combo box			
			combo.removeAll();

			String selectionTxt = emptySelectionTxt;
			final ComponentClassifier componentClassifier = getComponentClassifier();
			if(componentClassifier != null) {
				combo.add(emptySelectionTxt);
				
				// Add both modes and mode transitions to the drop down
				for(final Mode mode : componentClassifier.getAllModes()) {
					final String modeName = mode.getName();
					if(modeName != null) {
						combo.add(modeName);
						if(modeName.equalsIgnoreCase(selectedModeName)) {
							selectionTxt = modeName;
						}
					}
				}
				
				for(final ModeTransition transition : componentClassifier.getAllModeTransitions()) {
					final String transitionName = transition.getName();
					if(transitionName != null) {
						combo.add(transitionName);
						if(transitionName.equalsIgnoreCase(selectedModeName)) {
							selectionTxt = transitionName;
						}
					}
				}
			}			
			
			// Set the selection
			combo.setText(selectionTxt);
		}
	}
	
	@Override
	protected void onSelection(final String txt) {
		final ComponentClassifier cc = getComponentClassifier();
		final String transformedTxt = txt.equals(emptySelectionTxt) ? "" : txt;
		if(cc != null) {	
			if(!transformedTxt.equalsIgnoreCase(propertyUtil.getSelectedMode(editor.getDiagramTypeProvider().getDiagram()))) {
				final UpdateContext ctx = new UpdateContext(editor.getDiagramTypeProvider().getDiagram());
				final IUpdateFeature feature = editor.getDiagramTypeProvider().getFeatureProvider().getUpdateFeature(ctx);
				
				// Set the selected mode property on the diagram and update the diagram
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain()) {
					@Override
					protected void doExecute() {
						propertyUtil.setSelectedMode(editor.getDiagramTypeProvider().getDiagram(), transformedTxt);
						
						if(feature != null && feature.canUpdate(ctx)) {
							editor.getDiagramBehavior().executeFeature(feature, ctx);
						}
					}				
				});
			}
		}
	}
}
