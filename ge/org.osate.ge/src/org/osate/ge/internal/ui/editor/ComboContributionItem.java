/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.NamedElement;

public class ComboContributionItem extends ControlContribution {
	private ComboViewer combo;
	private final Object nullValue = new Object();
	
	protected ComboContributionItem(final String id) {
		super(id);
	}

	protected final Object getNullValue() {
		return nullValue;
	}
	
	@Override
	protected Control createControl(final Composite parent) {
		combo = new ComboViewer(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setContentProvider(ArrayContentProvider.getInstance());
		combo.getCombo().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				onControlDisposed();
			}
			
		});

		combo.getCombo().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final StructuredSelection sel = (StructuredSelection)combo.getSelection();
				onSelection(sel.getFirstElement());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}			
		});
		
		combo.setLabelProvider(new LabelProvider() {
	        @Override
	        public String getText(Object element) {
	        	if(element == nullValue) {
	        		return getNullValueString();
	        	} else if (element instanceof NamedElement) {
                	return getQualifiedName((NamedElement) element);
                }
                return super.getText(element);
	        }
		});

		return combo.getControl();
	}

	// Gets qualified name. For flow implementations, it returns the qualified name of the specification
	protected String getQualifiedName(final NamedElement element) {
		if(element instanceof FlowImplementation) {
			return ((FlowImplementation) element).getSpecification().getQualifiedName();
		}
		
		return element.getQualifiedName();
	}
	
	public ComboViewer getComboViewer() {
		if(combo == null || combo.getCombo() == null || combo.getCombo().isDisposed())
			return null;
		
		return combo;
	}
	
	protected void onControlDisposed() {
		
	}
	
	protected void onSelection(final Object value) {
		
	}
	
	protected String getNullValueString() {
		return "";
	}
	
	// Force a fixed width for the combo contribution items. Otherwise the sizes are often incorrect due to the dynamic nature of the control.
	@Override
	protected int computeWidth(Control control) {
	    return 300;
	}
}
