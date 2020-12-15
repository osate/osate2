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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.osate.ge.errormodel.ui.ErrorModelUiUtil;
import org.osate.ge.errormodel.ui.viewmodels.NamedObjectsProvider;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

class TestFaultSourceEditorModel extends BaseObservableModel implements FaultSourceEditorModel {
	private final List<ErrorBehaviorState> stateOptions = new ArrayList<>();
	private FaultSource value = new FaultSource("Test");
	private TestErrorTypesProvider errorTypes = new TestErrorTypesProvider();

	public TestFaultSourceEditorModel() {
		stateOptions.add(null);
		stateOptions.add(createState("S1"));
		stateOptions.add(createState("S2"));
		stateOptions.add(createState("S3"));
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void setFaultSource(FaultSource value) {
		if (this.value != value) {
			this.value = value;
			triggerChangeEvent();
		}
	}

	@Override
	public FaultSource getFaultSource() {
		return value;
	}

	@Override
	public Collection<ErrorBehaviorState> getStateOptions() {
		return stateOptions;
	}

	private static ErrorBehaviorState createState(final String name) {
		final ErrorBehaviorState newState = ErrorModelFactory.eINSTANCE.createErrorBehaviorState();
		newState.setName(name);
		return newState;
	}

	@Override
	public NamedObjectsProvider<ErrorTypes> getErrorTypeOptions() {
		return errorTypes;
	}

	@Override
	public String getTypeTokensLabel() {
		if (getFaultSource().getErrorTypeSet() == null || getFaultSource().getErrorTypeSet().getTypeTokens() == null) {
			return "";
		}

		return ErrorModelUiUtil.getTypeTokensLabel(getFaultSource().getErrorTypeSet().getTypeTokens().stream(),
				t -> t.getName());
	}

	@Override
	public Optional<String> getError() {
		return Optional.empty();
	}
}
