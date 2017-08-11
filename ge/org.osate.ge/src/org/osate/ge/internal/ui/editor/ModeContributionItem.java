/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeContributionItem extends ComboContributionItem {
	private static final String emptySelectionTxt = "<Modes>";
	private static final String selectedModePropertyKey = "org.osate.ge.ui.editor.selectedMode";
	private static final StandaloneQuery componentClassifiersQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendants().filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier));
	private AgeDiagramEditor editor = null;	
	
	public ModeContributionItem(final String id) {
		super(id);
	}
	
	@Override
	public boolean isDynamic() {
		return true;
	}
	
	public final void setActiveEditor(final IEditorPart newEditor) {
		if(editor != newEditor) {
			saveModeSelection();

			// Update the editor
			if(newEditor instanceof AgeDiagramEditor) {
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
		final ComboViewer comboViewer = getComboViewer();
		if(comboViewer != null) {
			if(this.editor != null) {
				final Object firstSelection = comboViewer.getStructuredSelection().getFirstElement();
				final String selectionStr = firstSelection instanceof NamedElement ? ((NamedElement)firstSelection).getQualifiedName() : null;
				editor.setPartProperty(selectedModePropertyKey, selectionStr);
			}
		}
	}	
	
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		refresh(); // Populate the combo box
		return control;
	}
	
	private void refresh() {
		final ComboViewer comboViewer = getComboViewer();
		if(comboViewer != null) {
			Object selectedValue = getNullValue();
			final String selectedModeName = editor == null ? null : editor.getPartProperty(selectedModePropertyKey);

			// Clear the combo box		
			comboViewer.setInput(null);

			if(editor == null) {
				return;
			}
			
			final AgeDiagram diagram = editor.getAgeDiagram();
			if(diagram != null) {
				final QueryService queryService = ContributionHelper.getQueryService(editor);
				if(queryService != null) {
					final Set<NamedElement> elements = new HashSet<>();
					for(final BusinessObjectContext componentClassifierBoc : queryService.getResults(componentClassifiersQuery, diagram)) {
						final ComponentClassifier componentClassifier = (ComponentClassifier)componentClassifierBoc.getBusinessObject();
						
						// Add both modes and mode transitions to the drop down
						for(final Mode mode : componentClassifier.getAllModes()) {
							if(mode.getName() != null) {
								elements.add(mode);
							}
						}
						
						for(final ModeTransition transition : componentClassifier.getAllModeTransitions()) {
							if(transition.getName() != null) {
								elements.add(transition);
							}
						}
					}
					
					// Find the selected value
					for(final NamedElement ne : elements) {
						if(ne.getQualifiedName().equalsIgnoreCase(selectedModeName)) {
							selectedValue = ne;
							break;
						}
					}

					final List<Object> sortedElements = new ArrayList<>();
					sortedElements.add(getNullValue());
					sortedElements.addAll(elements);
					sortedElements.sort(new Comparator<Object>() {
						@Override
						public int compare(final Object o1, final Object o2) {
							if(o1 == getNullValue()) {
								return -1;
							} else if(o2 == getNullValue()) {
								return 1;
							}
							
							final NamedElement e1 = (NamedElement)o1;
							final NamedElement e2 = (NamedElement)o2;
							if(e1.getClass() != e2.getClass()) {
								if(e1 instanceof Mode) {
									return -1;
								} else {
									return 1;
								}
							} else {
								return e1.getName().compareToIgnoreCase(e2.getName());
							}
						}
					});
					
					comboViewer.setInput(sortedElements);
				}
			}
			
			comboViewer.setSelection(new StructuredSelection(selectedValue));
		}
	}
	
	@Override
	protected void onSelection(final Object value) {
		// Notify coloring service of the selection
		ContributionHelper.getColoringService(editor).setHighlightedMode(value == getNullValue() ? null : (NamedElement)value);
				
		final UpdateContext ctx = new UpdateContext(editor.getDiagramTypeProvider().getDiagram());
		final IUpdateFeature feature = editor.getDiagramTypeProvider().getFeatureProvider().getUpdateFeature(ctx);
		
		// Set the selected mode property on the diagram and update the diagram
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain()) {
			@Override
			protected void doExecute() {
				if(feature != null && feature.canUpdate(ctx)) {
					editor.getDiagramBehavior().executeFeature(feature, ctx);
				}
			}				
		});
	}
	
	@Override
	protected String getNullValueString() {
		return emptySelectionTxt;
	}
}
