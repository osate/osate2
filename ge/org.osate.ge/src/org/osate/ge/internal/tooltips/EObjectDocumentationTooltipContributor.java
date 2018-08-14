package org.osate.ge.internal.tooltips;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.util.EObjectDocumentationUtil;

public class EObjectDocumentationTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) EObject bo) {
		// Get the documentation provider for the business object. If the documentation provider cannot be retrieved, then assume that the business object does
		// not have any documentation.
		final IEObjectDocumentationProvider docProvider = EObjectDocumentationUtil.getDocumentationProvider(bo);
		if (docProvider == null) {
			return;
		}

		// Get the documentation
		String doc = docProvider.getDocumentation(bo);
		if (doc == null) {
			return;
		}

		// Trim whitespace
		doc = doc.trim();
		if (doc.isEmpty()) {
			return;
		}

		// Remove whitespace
		doc = doc.replaceAll("\\s+", " ");

		// Create a widget for the tooltip
		final Label lbl = new Label(parent, SWT.WRAP);
		lbl.setText(doc);
	}
}
