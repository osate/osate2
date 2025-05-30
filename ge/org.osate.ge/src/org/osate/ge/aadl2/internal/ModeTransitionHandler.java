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
package org.osate.ge.aadl2.internal;

import java.util.Optional;

import org.osate.aadl2.ModeTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.util.AadlInheritanceUtil;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.query.ExecutableQuery;
import org.osate.ge.services.QueryService;

public class ModeTransitionHandler extends AadlBusinessObjectHandler {
	private static final ExecutableQuery<ModeTransition> SRC_QUERY = ExecutableQuery
			.create(rootQuery -> rootQuery.parent()
			.children()
			.filterByBusinessObjectRelativeReference(ModeTransition::getSource));
	private static final ExecutableQuery<ModeTransition> DST_QUERY = ExecutableQuery
			.create(rootQuery -> rootQuery.parent()
			.children()
			.filterByBusinessObjectRelativeReference(ModeTransition::getDestination));

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(ModeTransition.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final ModeTransition mt = ctx.getBusinessObject(ModeTransition.class).get();
		final String name = mt.getName();
		if (name == null) {
			return AadlReferenceUtil.getCanonicalReferenceForUnnamedModeTransition(mt);
		} else {
			return new CanonicalBusinessObjectReference(DeclarativeReferenceType.MODE_TRANSITION_NAMED.getId(),
					ctx.getReferenceBuilder().getCanonicalReference(mt.eContainer()).encode(),
					AadlReferenceUtil.getNameForSerialization(mt));
		}
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final ModeTransition mt = ctx.getBusinessObject(ModeTransition.class).get();
		final String name = mt.getName();
		if (name == null) {
			return AadlReferenceUtil.getUnnamedModeTransitionRelativeReference(mt);
		} else {
			return AadlReferenceUtil
					.buildSimpleRelativeReference(DeclarativeReferenceType.MODE_TRANSITION_NAMED.getId(), mt);
		}
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final QueryService queryService = ctx.getQueryService();
		return Optional.of(GraphicalConfigurationBuilder.create()
				.graphic(AadlGraphics.getModeTransitionGraphic())
				.source(getSource(boc, queryService))
				.destination(getDestination(boc, queryService))
				.style(StyleBuilder
						.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
						.build())
				.build());
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(SRC_QUERY, boc,
				boc.getBusinessObject(ModeTransition.class).orElseThrow());
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(DST_QUERY, boc,
				boc.getBusinessObject(ModeTransition.class).orElseThrow());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(ModeTransition.class).map(mt -> mt.getName()).orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}
}
