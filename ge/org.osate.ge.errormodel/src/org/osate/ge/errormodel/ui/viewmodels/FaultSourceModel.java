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
package org.osate.ge.errormodel.ui.viewmodels;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.errormodel.ui.ErrorModelUiUtil;
import org.osate.ge.errormodel.ui.swt.FaultSource;
import org.osate.ge.errormodel.ui.swt.FaultSourceEditorModel;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * View model for editing the {@link FaultSource} for {@link ErrorSource} objects included in a {@link BusinessObjectSelection}.
 * Only a single {@link ErrorSource} is supported.
 *
 */
public class FaultSourceModel extends BaseObservableModel implements FaultSourceEditorModel {
	private String error;
	private BusinessObjectSelection bos;
	private FaultSource faultSource;
	private List<ErrorBehaviorState> states;
	private NamedObjectsProvider<ErrorTypes> knownErrorTypes;

	public FaultSourceModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		error = null;
		faultSource = new FaultSource();
		states = Collections.emptyList();
		knownErrorTypes = EmptyNamedObjectsProvider.instance();

		final List<ErrorSource> selectedErrorSources = value.boStream(ErrorSource.class).collect(Collectors.toList());
		if (selectedErrorSources.isEmpty()) {
			error = "<No Error Source Selected>";
		} else if (selectedErrorSources.size() > 1) {
			error = "<Multiple Error Sources Selected>";
		} else if (selectedErrorSources.get(0).eResource() == null) {
			error = "<No Resource Available>";
		} else {
			final ErrorSource selectedErrorSource = selectedErrorSources.get(0);
			if (selectedErrorSource.getFailureModeDescription() != null) {
				faultSource = new FaultSource(selectedErrorSource.getFailureModeDescription());
			} else {
				faultSource = new FaultSource(selectedErrorSource.getFailureModeReference(),
						selectedErrorSource.getFailureModeType());
			}

			knownErrorTypes = new ProjectErrorTypesProvider(
					ProjectUtil.getProjectOrThrow(selectedErrorSource.eResource()));
			states = getReferenceableStates(selectedErrorSource);
		}

		triggerChangeEvent();
	}

	/**
	 * Get a list of all referenceable error behavior states for a error source
	 * @param errorSource the source for which to get the states
	 * @return the referenceable states
	 */
	private static List<ErrorBehaviorState> getReferenceableStates(final ErrorSource errorSource) {
		return ErrorModelGeUtil.getAllInheritedErrorModelSubclauses(errorSource.getContainingClassifier())
				.map(ErrorModelSubclause::getUseBehavior)
				.filter(Objects::nonNull).findFirst().map(sm -> (List<ErrorBehaviorState>) sm.getStates())
				.orElseGet(() -> Collections.emptyList());
	}

	@Override
	public boolean isEnabled() {
		return error == null;
	}

	@Override
	public FaultSource getFaultSource() {
		return faultSource;
	}

	@Override
	public void setFaultSource(final FaultSource value) {
		bos.modify(ErrorSource.class, s -> {
			s.setFailureModeDescription(value.getFailureModeDescription());
			s.setFailureModeReference(value.getErrorBehaviorState() == null ? null
					: (ErrorBehaviorState) s.eResource().getResourceSet()
							.getEObject(EcoreUtil.getURI((value.getErrorBehaviorState())), true));
			s.setFailureModeType(value.getErrorTypeSet());
		});
	}

	@Override
	public Collection<ErrorBehaviorState> getStateOptions() {
		return states;
	}

	@Override
	public NamedObjectsProvider<ErrorTypes> getErrorTypeOptions() {
		return knownErrorTypes;
	}

	@Override
	public String getTypeTokensLabel() {
		if (getFaultSource().getErrorTypeSet() == null || getFaultSource().getErrorTypeSet().getTypeTokens() == null) {
			return "";
		}

		return ErrorModelUiUtil.getTypeTokensLabel(getFaultSource().getErrorTypeSet().getTypeTokens().stream(),
				knownErrorTypes::getName);
	}

	@Override
	public Optional<String> getError() {
		return Optional.ofNullable(error);
	}
}
