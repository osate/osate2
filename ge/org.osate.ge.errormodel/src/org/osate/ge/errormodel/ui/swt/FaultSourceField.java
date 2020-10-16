/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.errormodel.ui.swt;

import java.util.Optional;

import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.swt.selectors.BaseField;

/**
 * Field for displaying and modifying a {@link FaultSource} using a {@link FaultSourceEditorModel}
 *
 */
public class FaultSourceField extends BaseField<FaultSourceEditorModel> {
	/**
	 * Create a new instance.
	 * @param parent is the container for the new component.
	 * @param model provides the information for the component.
	 */
	public FaultSourceField(final Composite parent, final FaultSourceEditorModel model) {
		super(parent, model, "Modify...");
	}

	@Override
	protected void onModify() {
		FaultSourceEditorDialog.open(getShell(), "Edit Fault Source", getModel());
	}

	@Override
	protected String getValueLabel() {
		// Error takes priority over actual value
		final Optional<String> error = getModel().getError();
		if (error.isPresent()) {
			return error.get();
		}

		final FaultSource value = getModel().getFaultSource();

		if (value.getFailureModeDescription() != null) {
			return value.getFailureModeDescription();
		} else {
			final StringBuilder sb = new StringBuilder();
			if (value.getErrorBehaviorState() != null) {
				sb.append(value.getErrorBehaviorState().getName());
				sb.append(' ');
			}

			if (value.getErrorTypeSet() != null) {
				sb.append('{');
				sb.append(getModel().getTypeTokensLabel());
				sb.append('}');
			}
			return sb.toString();
		}
	}

	@Override
	protected boolean isModifyButtonEnabled() {
		return getModel().isEnabled();
	}

	public static void main(String[] args) {
		SwtUtil.run(shell -> {
			new FaultSourceField(shell, new TestFaultSourceEditorModel());
		});
	}
}
