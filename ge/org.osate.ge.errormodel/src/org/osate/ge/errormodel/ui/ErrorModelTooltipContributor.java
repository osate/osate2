/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.errormodel.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.ui.TooltipContributor;
import org.osate.ge.ui.TooltipContributorContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

public class ErrorModelTooltipContributor implements TooltipContributor {
	@Override
	public void addTooltipContents(final TooltipContributorContext ctx) {
		Object bo = ctx.getBusinessObjectContext().getBusinessObject();

		if (bo instanceof BehaviorTransitionTrunk) {
			bo = ((BehaviorTransitionTrunk) bo).getTransition();
		}

		if (bo instanceof EObject) {
			createLabel(ctx.getTooltip(), (EObject) bo);
		}
	}

	private void createLabel(final Composite parent, final EObject bo) {
		final boolean showSource = bo instanceof ErrorType || bo instanceof TypeSet
				|| bo instanceof ErrorBehaviorTransition || bo instanceof TransitionBranch
				|| bo instanceof ErrorBehaviorEvent || bo instanceof ErrorBehaviorState
				|| bo instanceof ErrorPropagation || bo instanceof PropagationPoint || bo instanceof ErrorFlow
				|| bo instanceof PropagationPath;
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

		final Label lbl = new Label(parent, SWT.WRAP);
		lbl.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		lbl.setText(txt);
	}
}
