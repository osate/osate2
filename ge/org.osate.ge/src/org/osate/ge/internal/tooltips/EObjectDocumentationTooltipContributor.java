package org.osate.ge.internal.tooltips;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.util.EObjectDocumentationUtil;

public class EObjectDocumentationTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) EObject bo) {
		final String doc = EObjectDocumentationUtil.getPlainTextDocumentation(bo);
		if (doc == null) {
			return;
		}

		// Create a widget for the tooltip
		final Label lbl = new Label(parent, SWT.WRAP);
		lbl.setText(doc);
	}
}
