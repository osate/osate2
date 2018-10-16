package org.osate.ge.internal.tooltips;

import javax.inject.Named;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;

public class ConnectionReferenceTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		final String srcStr = getConnectionEndName(cr.getSource());
		final String dstStr = getConnectionEndName(cr.getDestination());

		final String conType = cr.getConnection().eClass().getName().toLowerCase().replace("connection", "");
		final Label lbl = new Label(parent, SWT.NONE);
		lbl.setText(cr.getName() + ": " + conType + " " + srcStr + " -> " + dstStr);
	}

	/**
	 * Get connection end name and containing subcomponent name formatted for tool tip
	 * @param cie
	 * @return containing subcomponent name if applicable and connection end name
	 */
	private String getConnectionEndName(final ConnectionInstanceEnd cie) {
		final Subcomponent ctx = cie.getComponentInstance().getSubcomponent();
		return ctx == null ? cie.getName() : ctx.getName() + "." + cie.getName();
	}
}
