/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/* A invisible combobox contribution for the toolbar.
 * Can be added to the toolbar as a workaround on newer gtk versions (the rightmost dynamic combobox
 * in the toolbar doesn't work).
 */

public class DummyContributionItem extends ComboContributionItem {
	
	public DummyContributionItem(final String id) {
		super(id);
	}
	
	@Override
	public boolean isDynamic() {
		return true;
	}
	
	@Override
	protected void onControlDisposed() {
		super.onControlDisposed();
	}
	
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		ComboViewer combo = getComboViewer();
		if (combo != null) {
			combo.getCombo().setEnabled(false);
			combo.getCombo().setVisible(false);
		}
		return control;
	}
	
	@Override
	protected int computeWidth(Control control) {
	    return 0;
	}

}
