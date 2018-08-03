package org.osate.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;

public final class BlankPropertyPage extends PropertyPage {
	public BlankPropertyPage() {
		setDescription("Expand the tree to edit preferences for a specific feature.");
	}

	@Override
	protected Control createContents(Composite parent) {
		return new Composite(parent, SWT.NULL);
	}
}

