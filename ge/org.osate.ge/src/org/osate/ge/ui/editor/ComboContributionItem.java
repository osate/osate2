/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.editor;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ComboContributionItem extends ControlContribution {
	private Combo combo;

	protected ComboContributionItem(final String id) {
		super(id);
	}

	@Override
	protected Control createControl(final Composite parent) {
		combo = new Combo(parent, SWT.DROP_DOWN);
		combo.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				onControlDisposed();
			}
			
		});

		combo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onSelection(combo.getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}			
		});

		return combo;
	}

	public Combo getCombo() {
		if(combo == null || combo.isDisposed())
			return null;
		
		return combo;
	}
	
	protected void onControlDisposed() {
		
	}
	
	protected void onSelection(final String txt) {
		
	}
	
	// Force a fixed width for the combo contribution items. Otherwise the sizes are often incorrect due to the dynamic nature of the control.
	protected int computeWidth(Control control) {
	    return 150;
	}
}
