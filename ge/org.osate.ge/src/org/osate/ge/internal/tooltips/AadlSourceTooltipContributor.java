package org.osate.ge.internal.tooltips;

import javax.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;

public class AadlSourceTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) EObject bo) {
		final boolean showSource = bo instanceof Feature ||
				bo instanceof InternalFeature ||
				bo instanceof ProcessorFeature ||
				bo instanceof Feature ||
				bo instanceof Connection || 
				bo instanceof FlowSpecification || 
				bo instanceof Subcomponent ||
				bo instanceof SubprogramCall;
		if(!showSource) {
			return;
		}

		final INode n = NodeModelUtils.getNode(bo);
		if(n == null) {
			return;
		}
			
		final String txt = NodeModelUtils.getTokenText(n);
		if(txt == null) {
			return;
		}
		
		final Label lbl = new Label(parent, SWT.NONE);
		lbl.setText(txt);
	}
}
