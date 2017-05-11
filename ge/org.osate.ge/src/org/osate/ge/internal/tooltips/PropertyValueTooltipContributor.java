package org.osate.ge.internal.tooltips;

import javax.inject.Named;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.internal.util.PropertyValueFormatter;

public class PropertyValueTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			@Named(Names.BUSINESS_OBJECT) PropertyResultValue prv) {
		final String txt = PropertyValueFormatter.getUserString(boc.getParent(), prv, true);	
		final Text text = new Text(parent, SWT.NONE);
		text.setText(txt);
	}
}
