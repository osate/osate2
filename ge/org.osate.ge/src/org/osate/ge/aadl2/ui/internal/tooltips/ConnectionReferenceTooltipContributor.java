/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.ui.internal.tooltips;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.ui.TooltipContributor;
import org.osate.ge.ui.TooltipContributorContext;

public class ConnectionReferenceTooltipContributor implements TooltipContributor {
	@Override
	public void addTooltipContents(final TooltipContributorContext ctx) {
		ctx.getBusinessObjectContext().getBusinessObject(ConnectionReference.class).ifPresent(cr -> {
			final String srcStr = getConnectionEndName(cr.getSource());
			final String dstStr = getConnectionEndName(cr.getDestination());

			final String conType = cr.getConnection().eClass().getName().toLowerCase().replace("connection", "");
			final Label lbl = new Label(ctx.getTooltip(), SWT.NONE);
			lbl.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_FOREGROUND));
			lbl.setText(cr.getName() + ": " + conType + " " + srcStr + " -> " + dstStr);
		});
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
