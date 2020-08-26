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
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;

/**
 * Business object handler for {@link BehaviorTransitionTrunk}
 * @see ErrorBehaviorTransitionHandler for details about how transitions are represented.
 */
public class BehaviorTransitionTrunkHandler implements BusinessObjectHandler, CustomDeleter
{
	private static StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.ancestor(2).children()
			.filterByBusinessObjectRelativeReference(t -> ((BehaviorTransitionTrunk) t).getTransition().getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(2).children()
			.filterByBusinessObjectRelativeReference(t -> ((BehaviorTransitionTrunk) t).getTransition()));

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorTransitionTrunk.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorTransitionTrunk trunk = ctx.getBusinessObject(BehaviorTransitionTrunk.class).get();
		return new CanonicalBusinessObjectReference(
				ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION_TRUNK,
				ctx.getReferenceBuilder().getCanonicalReference(trunk.getTransition()).encode());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION_TRUNK);
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(
				ErrorModelGeUtil.transitionConnectionGraphic)
				.style(ErrorModelGeUtil.transitionConnectionStyle)
				.source(getSource(ctx.getBusinessObjectContext(), ctx.getQueryService()))
				.destination(getDestination(ctx.getBusinessObjectContext(), ctx.getQueryService())).build());
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return "";
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		ctx.getContainerBusinessObject(ErrorBehaviorTransition.class).ifPresent(EcoreUtil::delete);
	}
}
