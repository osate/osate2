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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Classifier;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.selectors.SingleSelectorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

/**
 * View model which sets the use behavior for {@link Classifier} objects included in a {@link BusinessObjectSelection}.
 * Creates an error model subclause if needed. Only a single {@link Classifier} is supported.
 *
 */
public class ErrorBehaviorModel extends BaseObservableModel
		implements SingleSelectorModel<ErrorBehaviorStateMachine> {
	private static class Option {
		public Option(final IEObjectDescription desc) {
			this.stateMachine = (ErrorBehaviorStateMachine) desc.getEObjectOrProxy();
			this.qualifiedName = ErrorModelViewModelUtil.getQualifiedName(desc);
		}

		public final ErrorBehaviorStateMachine stateMachine;
		public final String qualifiedName;
	}

	private BusinessObjectSelection bos;
	private Map<URI, Option> uriToOptionMap;
	private String error;

	/**
	 * Creates a new instance
	 * @param bos the initial business object selection
	 */
	public ErrorBehaviorModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		uriToOptionMap = Collections.emptyMap();
		error = null;

		final List<Classifier> selectedClassifiers = value.boStream(Classifier.class).collect(Collectors.toList());
		if (selectedClassifiers.size() > 1) {
			error = "<Multiple Classifiers Selected>";
		} else if (selectedClassifiers.size() == 0) {
			error = "<No Classifiers Selected>";
		} else {
			final Classifier selectedClassifier = selectedClassifiers.get(0);
			if (selectedClassifier.eResource() == null) {
				error = "<No Resource Available>";
			} else {
				final Collection<IEObjectDescription> descriptions = AadlModelAccessUtil.getAllEObjectsByType(
						selectedClassifier.eResource(), ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine());
				uriToOptionMap = descriptions.stream()
						.collect(Collectors.toMap(IEObjectDescription::getEObjectURI, Option::new));
			}
		}

		triggerChangeEvent();
	}

	@Override
	public Stream<ErrorBehaviorStateMachine> getElements() {
		return Stream.concat(Stream.of((ErrorBehaviorStateMachine) null),
				uriToOptionMap.values().stream().map(v -> v.stateMachine));
	}

	@Override
	public ErrorBehaviorStateMachine getSelectedElement() {
		final Optional<ErrorBehaviorStateMachine> optStateMachine = bos.boStream(Classifier.class)
				.flatMap(ErrorModelGeUtil::getAllInheritedErrorModelSubclauses).map(ErrorModelSubclause::getUseBehavior)
				.filter(Objects::nonNull).findFirst();
		if (!optStateMachine.isPresent()) {
			return null;
		}

		final ErrorBehaviorStateMachine sm = optStateMachine.get();

		// Return the element from the options list.
		final URI behaviorUri = EcoreUtil.getURI(sm);
		final Option option = uriToOptionMap.get(behaviorUri);
		if (option == null) {
			// Return the actual state machine if an option wasn't available.
			return sm;
		}

		return option.stateMachine;
	}

	@Override
	public void setSelectedElement(final ErrorBehaviorStateMachine value) {
		bos.modify("Set Error Behavior",
				boc -> boc.getBusinessObject(Classifier.class).isPresent(), boc -> {
					final Classifier c = boc.getBusinessObject(Classifier.class).get();
			final Optional<ErrorModelSubclause> subclause = ErrorModelGeUtil.getFirstErrorModelSubclause(c);
					return subclause.map(EObject.class::cast).orElse(c);
		}, (boToModify, boc) -> {
			// Get or create the error model subclause as needed
			final ErrorModelSubclause subclause;
			if (boToModify instanceof Classifier) {
				subclause = ErrorModelGeUtil.getOrCreateErrorModelSubclause((Classifier) boToModify);
			} else {
				subclause = (ErrorModelSubclause) boToModify;
			}

			subclause.setUseBehavior(value);
		});
	}

	@Override
	public String getLabel(final ErrorBehaviorStateMachine element) {
		if (error != null) {
			return error;
		}

		if (element == null) {
			return "<None>";
		}

		final Option option = uriToOptionMap.get(EcoreUtil.getURI(element));
		if (option == null) {
			return "<Unknown State Machine>";
		}

		return option.qualifiedName;
	}
}
