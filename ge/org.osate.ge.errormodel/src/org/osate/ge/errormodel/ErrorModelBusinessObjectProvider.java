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
package org.osate.ge.errormodel;

import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.stream.Stream;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectProvider;
import org.osate.ge.BusinessObjectProviderContext;
import org.osate.ge.errormodel.combined.CombinedErrorModelSubclause;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.ge.errormodel.model.KeywordPropagationPointType;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

public class ErrorModelBusinessObjectProvider implements BusinessObjectProvider {
	private WeakHashMap<Classifier, CombinedErrorModelSubclause> classifierCache = new WeakHashMap<>();

	@Override
	public Stream<?> getChildBusinessObjects(final BusinessObjectProviderContext ctx) {
		final Object bo = ctx.getBusinessObjectContext().getBusinessObject();
		if (bo instanceof AadlPackage) {
			return ErrorModelGeUtil.getErrorModelLibrary((AadlPackage) bo)
					.map(lib -> Stream.concat(Stream.concat(lib.getTypes().stream(), lib.getTypesets().stream()),
							lib.getBehaviors().stream()))
					.orElseGet(() -> Stream.empty());
		} else if (bo instanceof ErrorBehaviorStateMachine) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine) bo;
			return Stream.concat(Stream.concat(stateMachine.getEvents().stream(), stateMachine.getStates().stream()),
					stateMachine.getTransitions().stream());
		} else if (bo instanceof ErrorBehaviorTransition) {
			// See ErrorBehaviorTransitionHandler for details regarding how the business objects related to error behavior transitions are represented.
			final ErrorBehaviorTransition t = (ErrorBehaviorTransition) bo;
			return t.getDestinationBranches().isEmpty() ? Stream.empty()
					: Stream.concat(Stream.of(new BehaviorTransitionTrunk(t)), t.getDestinationBranches().stream());
		} else if (bo instanceof ErrorType) {
			final ErrorType errorType = (ErrorType) bo;
			if (errorType.getSuperType() != null) {
				return Stream.of(new ErrorTypeExtension(errorType.getSuperType(), errorType));
			}
		} else if (bo instanceof Classifier || bo instanceof Subcomponent) {
			// Anytime the children of a classifier or subcomponent is requested, process of error model subclauses
			// in the element or extended elements and cache the result.
			// Ideally, we would only do this if the classifier has changed but it would require a reliable means to
			// determine if a classifier or any classifiers it extends has changed. If extended classifiers are in another
			// package, the classifier be the same instance.
			// The object is cached so it is available when calling the business object provider on children.
			final Classifier classifier = ErrorModelGeUtil.getClassifier(ctx.getBusinessObjectContext()).orElse(null);
			if (classifier != null) {
				final CombinedErrorModelSubclause cacheEntry = CombinedErrorModelSubclause.create(classifier);
				classifierCache.put(classifier, cacheEntry);
				if (cacheEntry.subclauseExists()) {
					return Stream
							.of(cacheEntry.getPoints(), cacheEntry.getPaths(), cacheEntry.getFlows(),
									Arrays.stream(KeywordPropagationPointType.values())
											.map(t -> new KeywordPropagationPoint(classifier, t)))
							.flatMap(Function.identity());
				}
			}
		} else if (bo instanceof Feature || bo instanceof PropagationPoint || bo instanceof KeywordPropagationPoint) {
			// Propagation(and containment) objects
			final CombinedErrorModelSubclause cacheEntry = getClassifierCacheEntry(ctx.getBusinessObjectContext());
			return cacheEntry.getPropagations().getPropagationsForBusinessObjectContext(ctx.getBusinessObjectContext());
		}

		return Stream.empty();
	}

	/**
	 * Returns the combined error model subclause for the first subcomponent/classifier found when walking up the
	 * business object context tree.
	 * @param boc the business object context to get the combined subclause for
	 * @return the combined subclause
	 */
	private CombinedErrorModelSubclause getClassifierCacheEntry(final BusinessObjectContext boc) {
		return ErrorModelGeUtil.getClassifier(boc).map(classifier -> classifierCache.get(classifier))
				.orElse(CombinedErrorModelSubclause.EMPTY);
	}
}
