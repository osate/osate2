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
package org.osate.ge.ba.businessobjecthandlers;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
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
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class BehaviorTransitionHandler implements BusinessObjectHandler, CustomDeleter, CustomRenamer {
	private static final StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference((BehaviorTransition bt) -> bt.getSourceState()));
	private static final StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference((BehaviorTransition bt) -> bt.getDestinationState()));

	public static final Graphic transitionConnectionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().filled().build()).build();
	public static final Style transitionConnectionStyle = StyleBuilder.create().backgroundColor(Color.BLACK)
			.labelsAboveTop().labelsLeft().build();

	private final String unnamedLabel = "<Unnamed>";

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorTransition.class).isPresent();
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public boolean canCopy() {
		return false;
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).get();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.eContainer();
		final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
		return new CanonicalBusinessObjectReference(BehaviorAnnexReferenceUtil.TRANSITION_TYPE,
				Integer.toString(index));
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).get();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.eContainer();
		final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.TRANSITION_TYPE, Integer.toString(index));
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final QueryService queryService = ctx.getQueryService();
		return Optional
				.of(GraphicalConfigurationBuilder.create().graphic(transitionConnectionGraphic)
						.style(transitionConnectionStyle).source(getSource(boc, queryService))
						.destination(getDestination(boc, queryService)).build());
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(BehaviorTransition.class).map(BehaviorTransition::getName)
				.orElse(unnamedLabel);
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		// Check current name against new name so that when a user clicks on an "<Unnamed>" label to
		// direct edit, the user does not receive an error about the name if they decide to keep the transition unnamed
		final String name = ctx.getBusinessObject(BehaviorTransition.class).map(BehaviorTransition::getName)
				.orElse(unnamedLabel);
		// Allow removing name of transition
		final String newName = ctx.getNewName();
		if (isEmptyOrMatchesName(newName, name)) {
			return Optional.empty();
		}

		return BehaviorAnnexNamingUtil.checkNameValidity(ctx);
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		final BehaviorTransition behaviorTransitionToModify = ctx.getContainerBusinessObject(BehaviorTransition.class)
				.get();
		final BehaviorAnnex behaviorAnnexToModify = (BehaviorAnnex) behaviorTransitionToModify.eContainer();
		EcoreUtil.remove(behaviorTransitionToModify);
		if (behaviorAnnexToModify.getTransitions().isEmpty()) {
			behaviorAnnexToModify.unsetTransitions();
		}
	}

	@Override
	public void rename(final RenameContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).get();
		final String newName = ctx.getNewName();
		// Transition names can be null, but not an empty string
		behaviorTransition.setName(isEmptyOrMatchesName(newName, unnamedLabel) ? null : newName);
	}

	private boolean isEmptyOrMatchesName(final String newName, final String name) {
		return newName.isEmpty() || newName.equals(name);
	}
}
