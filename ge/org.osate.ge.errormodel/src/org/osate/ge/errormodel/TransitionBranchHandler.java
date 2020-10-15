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

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanCopyContext;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

/**
 * @see ErrorBehaviorTransitionHandler for details about how transitions are represented.
 */
public class TransitionBranchHandler implements BusinessObjectHandler, CustomDeleter {
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(2).children()
			.filterByBusinessObjectRelativeReference(b -> ((TransitionBranch) b).eContainer()));
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.ancestor(2).children().filterByBusinessObjectRelativeReference(b -> {
				final TransitionBranch branch = (TransitionBranch) b;
				return branch.isSteadyState() ? ((ErrorBehaviorTransition) branch.eContainer()).getSource()
						: branch.getTarget();
			}));

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(TransitionBranch.class).map(bo -> bo.getElementRoot() instanceof AadlPackage)
				.isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final TransitionBranch b = ctx.getBusinessObject(TransitionBranch.class).get();
				return new CanonicalBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION_BRANCH,
						ctx.getReferenceBuilder().getCanonicalReference(b.eContainer())
								.encode(),
						ErrorModelReferenceUtil
								.getTargetNameForSerialization(
								b),
						Integer.toString(getTransitionBranchIndex(b)));
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final TransitionBranch b= ctx.getBusinessObject(TransitionBranch.class).get();
		return ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch(
				ErrorModelReferenceUtil.getTargetNameForSerialization(b), getTransitionBranchIndex(b));
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public boolean canCopy(final CanCopyContext ctx) {
		return false;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final QueryService queryService = ctx.getQueryService();
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(ErrorModelGeUtil.transitionConnectionGraphic)
				.style(ErrorModelGeUtil.transitionConnectionStyle).source(getSource(boc,
						queryService))
				.destination(getDestination(boc, queryService)).build());
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(dstQuery, boc);
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		final ErrorBehaviorTransition transition = ctx.getContainerBusinessObject(ErrorBehaviorTransition.class).get();

		// Find branch by URI.
		final TransitionBranch branch = (TransitionBranch) transition.eResource().getResourceSet()
				.getEObject(EcoreUtil.getURI(ctx.getReadonlyBoToDelete(TransitionBranch.class).get()), true);
		if (branch != null) {
			EcoreUtil.remove(branch);

			if (transition.getDestinationBranches().size() == 1) {
				final TransitionBranch remainingBranch = transition.getDestinationBranches().get(0);
				if (remainingBranch.isSteadyState()) {
					transition.setSteadyState(true);
				} else {
					transition.setTarget(remainingBranch.getTarget());
					transition.setTargetToken(remainingBranch.getTargetToken());
				}

				transition.getDestinationBranches().clear();
			}
		}
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(TransitionBranch.class).map(branch -> {
			final BranchValue value = branch.getValue();
			if (value == null) {
				return "";
			}

			if (value.getRealvalue() != null) {
				return value.getRealvalue();
			}

			if (value.isOthers()) {
				return "others";
			}

			if (value.getSymboliclabel() != null) {
				return value.getSymboliclabel().getQualifiedName();
			}

			return "";
		}).orElse("");
	}

	private static int getTransitionBranchIndex(final TransitionBranch b) {
		// Check type of container
		if (!(b.eContainer() instanceof ErrorBehaviorTransition)) {
			return -1;
		}

		final ErrorBehaviorTransition t = (ErrorBehaviorTransition) b.eContainer();
		return ErrorModelReferenceUtil.getIndex(
				b,
				t.getDestinationBranches().stream().filter(tmpBranch -> tmpBranch.getTarget() == b.getTarget()));
	}
}
