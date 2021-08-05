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
package org.osate.ge.ba.businessobjecthandlers;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ba.declarative.Identifier;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.ba.util.BehaviorAnnexNamingUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanCopyContext;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.CustomRenamer;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.query.ExecutableQuery;
import org.osate.ge.services.QueryService;

/**
 * Business Object Handler for {@link BehaviorTransition}.
 */
public class BehaviorTransitionHandler implements BusinessObjectHandler, CustomDeleter, CustomRenamer {
	private static final ExecutableQuery<BehaviorTransition> SRC_QUERY = ExecutableQuery.<BehaviorTransition> create(
			rootQuery -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(bt -> {
				if (bt instanceof DeclarativeBehaviorTransition) {
					final DeclarativeBehaviorTransition dt = (DeclarativeBehaviorTransition) bt;
					if (!dt.getSrcStates().isEmpty()) {
						final Identifier src = dt.getSrcStates().get(0);
						final BehaviorAnnex ba = (BehaviorAnnex) bt.getOwner();
						return getState(ba, src.getId());
					}
				}

				return bt.getSourceState();
			}));

	private static final ExecutableQuery<BehaviorTransition> DST_QUERY = ExecutableQuery
			.create(rootQuery -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(bt -> {
				if (bt instanceof DeclarativeBehaviorTransition) {
					final DeclarativeBehaviorTransition dt = (DeclarativeBehaviorTransition) bt;
					final Identifier dest = dt.getDestState();
					if (dest != null) {
						final BehaviorAnnex ba = (BehaviorAnnex) bt.getOwner();
						return getState(ba, dest.getId());
					}
				}

				return bt.getDestinationState();
			}));

	private static Element getState(final BehaviorAnnex ba, final String id) {
		return ba.getChildren()
				.stream()
				.filter(c -> c instanceof NamedElement && id.equals(((NamedElement) c).getName()))
				.findAny()
				.orElse(null);
	}

	private static final Graphic transitionConnectionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().filled().build())
			.build();
	private static final Style transitionConnectionStyle = Style.EMPTY;

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorTransition.class).isPresent();
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
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).orElseThrow();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.getOwner();
		final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
		return new CanonicalBusinessObjectReference(BehaviorAnnexReferenceUtil.TRANSITION_TYPE, Integer.toString(index),
				ctx.getReferenceBuilder().getCanonicalReference(behaviorAnnex).encode());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).orElseThrow();
		final String refSeg = getTransitionReference((BehaviorAnnex) behaviorTransition.getOwner(), behaviorTransition);
		return BehaviorAnnexReferenceUtil.getTransitionRelativeReference(refSeg);
	}

	private static String getTransitionReference(final BehaviorAnnex behaviorAnnex,
			final BehaviorTransition behaviorTransition) {
		final String name = behaviorTransition.getName();
		if (name == null) {
			final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
			return Integer.toString(index);
		}

		return name;
	}

	@Override
	public String getNameForRenaming(final GetNameContext ctx) {
		return ctx.getBusinessObject(BehaviorTransition.class).map(BehaviorTransition::getName).orElse("");
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final QueryService queryService = ctx.getQueryService();
		return Optional.of(GraphicalConfigurationBuilder.create()
				.graphic(transitionConnectionGraphic)
				.style(transitionConnectionStyle)
				.source(getSource(boc, queryService))
				.destination(getDestination(boc, queryService))
				.build());
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(SRC_QUERY, boc,
				boc.getBusinessObject(BehaviorTransition.class).orElseThrow());
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(DST_QUERY, boc,
				boc.getBusinessObject(BehaviorTransition.class).orElseThrow());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(BehaviorTransition.class).map(BehaviorTransition::getName).orElse("");
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		// Allow removing name of transition
		final String newName = ctx.getNewName();
		if (newName.isEmpty()) {
			return Optional.empty();
		}

		return BehaviorAnnexNamingUtil.checkNameValidity(ctx);
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		final BehaviorAnnex behaviorAnnex = ctx.getContainerBusinessObject(BehaviorAnnex.class).orElseThrow();
		// Find transition by URI.
		final BehaviorTransition behaviorTransition = (BehaviorTransition) behaviorAnnex.eResource()
				.getResourceSet()
				.getEObject(EcoreUtil.getURI(ctx.getReadonlyBoToDelete(BehaviorTransition.class).orElseThrow()), true);
		EcoreUtil.remove(behaviorTransition);
		if (behaviorAnnex.getTransitions().isEmpty()) {
			behaviorAnnex.unsetTransitions();
		}
	}

	@Override
	public void rename(final RenameContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).orElseThrow();
		final String newName = ctx.getNewName();
		// An unnamed transition's name must be set to null
		behaviorTransition.setName(newName.isEmpty() ? null : newName);
	}
}
