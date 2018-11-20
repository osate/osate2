package org.osate.ge.errormodel.tooltips;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

public class ErrorModelTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) Object bo) {
		if (bo instanceof BehaviorTransitionTrunk) {
			bo = ((BehaviorTransitionTrunk) bo).getTransition();
		}

		if (bo instanceof EObject) {
			createLabel(parent, (EObject) bo);
		}
	}

	private void createLabel(final Composite parent, final EObject bo) {
		final boolean showSource = bo instanceof ErrorBehaviorTransition || bo instanceof TransitionBranch
				|| bo instanceof ErrorBehaviorEvent || bo instanceof ErrorBehaviorState;
		if (!showSource) {
			return;
		}

		final INode n = NodeModelUtils.getNode(bo);
		if (n == null) {
			return;
		}

		final String txt = NodeModelUtils.getTokenText(n);
		if (txt == null) {
			return;
		}

		final Label lbl = new Label(parent, SWT.NONE);
		lbl.setText(txt);
	}
}
