/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.ge.internal.services.PropertyService;

public class NestingDepthSelectorContributionItem extends ComboContributionItem {
	private final PropertyService propertyService;
	private AgeDiagramEditor editor = null;	
	private final Adapter nestingPropertyChangeListener = new AdapterImpl() {
		@Override
		public void notifyChanged(final Notification notification) {
			if(notification.getNewValue() instanceof Property) {
				final Property property = (Property)notification.getNewValue();
				if(propertyService.getNestingDepthKey().equals(property.getKey())) {
					refresh();
				}
			}
		}	
	};
	
	public NestingDepthSelectorContributionItem(final String id, final PropertyService propertyService) {
		super(id);
		this.propertyService = propertyService;
	}
	
	public final void setActiveEditor(final IEditorPart newEditor) {
		unregisterPropertyChangeListener();
		
		// Set the new editor
		if(newEditor instanceof AgeDiagramEditor) {
			this.editor = (AgeDiagramEditor)newEditor;
		} else {
			this.editor = null;
		}
		
		refresh();
		
		// Register the listener with the new editor
		registerPropertyChangeListener();
	}
	
	@Override
	protected void onControlDisposed() {
		unregisterPropertyChangeListener();
		super.onControlDisposed();
	}	
	
	private void registerPropertyChangeListener() {
		if(editor != null) {
			final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
			diagram.eAdapters().add(nestingPropertyChangeListener);
		}
	}

	private void unregisterPropertyChangeListener() {
		if(editor != null) {
			final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
			diagram.eAdapters().remove(nestingPropertyChangeListener);
		}
	}
	
	private void refresh() {
		final Combo cmb = getCombo();
		if(cmb != null) {
			if(editor == null) {
				cmb.setText("");
			} else {
				// Set the value of the combo box
				final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
				final int nestingDepth = propertyService.getNestingDepth(diagram);
				
				// Add items to the combo box so that the current nesting depth is available in the list.
				while(nestingDepth >= cmb.getItemCount()) {
					cmb.add(Integer.toString(cmb.getItemCount()));
				}
				cmb.setText(Integer.toString(nestingDepth));
			}
		}
	}
	
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		final Combo combo = getCombo();
		if(combo != null) {
			combo.add("0");
			combo.add("1");
			combo.add("2");
			combo.add("3");
			combo.add("4");
		}

		return control;
	}
	
	@Override
	protected int computeWidth(Control control) {
        return control.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x;
    }
	
	@Override
	protected void onSelection(final String txt) {
		if(editor != null) {
			try {			 
				final int newNestingDepth = Integer.parseInt(txt);
				final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();			
				final UpdateContext ctx = new UpdateContext(diagram);
				final IUpdateFeature feature = editor.getDiagramTypeProvider().getFeatureProvider().getUpdateFeature(ctx);
				
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain()) {			
					@Override
					protected void doExecute() {
						propertyService.setNestingDepth(diagram, newNestingDepth);
						
						// Update the diagram
						if(feature != null && feature.canUpdate(ctx)) {
							editor.getDiagramBehavior().executeFeature(feature, ctx);
						}
					}				
				});
			} catch(NumberFormatException ex) {
				
			}			 
		}
	}
}
