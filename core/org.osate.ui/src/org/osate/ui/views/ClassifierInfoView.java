package org.osate.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public final class ClassifierInfoView extends ViewPart {

	public ClassifierInfoView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(final Composite parent) {
		final SashForm sash = new SashForm(parent, SWT.HORIZONTAL);

		final Label label1 = new Label(sash, SWT.LEFT);
		label1.setText("Hierarchy section");

		final Label label2 = new Label(sash, SWT.LEFT);
		label2.setText("Member section");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
