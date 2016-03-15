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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.PropertyService;

public class FlowContributionItem extends ComboContributionItem implements ComponentClassifierItem {
	private static final String emptySelectionTxt = "<Flows>";
	private static final String selectedFlowPropertyKey = "org.osate.ge.ui.editor.selectedFlow";
	private final PropertyService propertyUtil;
	private AgeDiagramEditor editor = null;	
	
	public FlowContributionItem(final String id, final PropertyService propertyUtil) {
		super(id);
		this.propertyUtil = propertyUtil;
	}
	
	@Override
	public boolean isDynamic() {
		return true;
	}
	
	public final void setActiveEditor(final IEditorPart newEditor) {
		if(editor != newEditor) {
			saveFlowSelection();

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
		saveFlowSelection();
		super.onControlDisposed();
	}
	
	private void saveFlowSelection() {
		// Save the current flow selection
		final Combo cmb = this.getCombo();
		if(cmb != null) {
			if(this.editor != null) {
				final String selection = cmb.getText();
				editor.setPartProperty(selectedFlowPropertyKey, selection);
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
	private ComponentImplementation getComponentImplementation() {
		if(editor != null) {
			// Get the AADL Element at the top level of the diagram
			final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
			final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
			final NamedElement element = (NamedElement)AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(diagram));
			if(element instanceof ComponentImplementation) {
				return (ComponentImplementation)element;
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
			String selectedFlowName = null;
			if(editor != null) {
				selectedFlowName = editor.getPartProperty(selectedFlowPropertyKey);
				if(selectedFlowName == null) {
					selectedFlowName = propertyUtil.getSelectedFlow(editor.getDiagramTypeProvider().getDiagram());
				}
			}
			
			// Clear the combo box			
			combo.removeAll();

			String selectionTxt = emptySelectionTxt;
			final ComponentImplementation componentImplementation = getComponentImplementation();
			if(componentImplementation != null) {
				combo.add(emptySelectionTxt);
				
				// Add Flow Implementations
				for(final FlowImplementation flow : componentImplementation.getAllFlowImplementations()) {
					if(flow.getSpecification() != null && flow.getSpecification().getName() != null) {
						final String name = flow.getSpecification().getName();
						combo.add(name);

						if(name.equalsIgnoreCase(selectedFlowName)) {
							selectionTxt = name;
						}
					}
				}
				
				// Add End to End Flows
				for(final EndToEndFlow flow : componentImplementation.getAllEndToEndFlows()) {
					final String name = flow.getName();
					if(name != null) {
						combo.add(name);
						if(name.equalsIgnoreCase(selectedFlowName)) {
							selectionTxt = name;
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
		final ComponentClassifier cc = getComponentImplementation();
		final String transformedTxt = txt.equals(emptySelectionTxt) ? "" : txt;
		if(cc != null) {
			if(!transformedTxt.equalsIgnoreCase(propertyUtil.getSelectedFlow(editor.getDiagramTypeProvider().getDiagram()))) {
				final UpdateContext ctx = new UpdateContext(editor.getDiagramTypeProvider().getDiagram());
				final IUpdateFeature feature = editor.getDiagramTypeProvider().getFeatureProvider().getUpdateFeature(ctx);

				// Set the selected flow property on the diagram and then update it
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain()) {
					@Override
					protected void doExecute() {
						propertyUtil.setSelectedFlow(editor.getDiagramTypeProvider().getDiagram(), transformedTxt);
						if(feature != null && feature.canUpdate(ctx)) {
							feature.execute(ctx);
						}
					}				
				});
			}
		}
	}
}
