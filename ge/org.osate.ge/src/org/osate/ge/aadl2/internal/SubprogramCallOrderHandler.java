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
package org.osate.ge.aadl2.internal;

import java.util.Optional;

import org.eclipse.xtext.util.Strings;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.model.SubprogramCallOrder;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.GetNameForDiagramContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SubprogramCallOrderHandler extends AadlBusinessObjectHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().line().build()).build();
	private static final Style style = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(sco->((SubprogramCallOrder)sco).previousSubprogramCall));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(sco->((SubprogramCallOrder)sco).subprogramCall));

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(SubprogramCallOrder.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final SubprogramCallOrder sco = ctx.getBusinessObject(SubprogramCallOrder.class).get();
		return new CanonicalBusinessObjectReference(DeclarativeReferenceType.SUBPROGRAM_CALL_ORDER.getId(),
				sco.previousSubprogramCall.getQualifiedName(),
				sco.subprogramCall.getQualifiedName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final SubprogramCallOrder sco = ctx.getBusinessObject(SubprogramCallOrder.class).get();
		return new RelativeBusinessObjectReference(DeclarativeReferenceType.SUBPROGRAM_CALL_ORDER.getId(),
				AadlReferenceUtil.getNameForSerialization(sco.previousSubprogramCall),
				AadlReferenceUtil.getNameForSerialization(sco.subprogramCall));
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(
				SubprogramCallOrder.class)
				.map(bo -> "Subprogram Call Order " + Strings.emptyIfNull(bo.previousSubprogramCall.getName()) + " -> "
						+ Strings.emptyIfNull(bo.subprogramCall.getName()))
				.orElse("");
	}

	@Override
	public String getNameForDiagram(final GetNameForDiagramContext ctx) {
		return "";
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final SubprogramCallOrder bo = boc.getBusinessObject(SubprogramCallOrder.class).get();
		final QueryService queryService = ctx.getQueryService();
		return Optional.of(GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(bo)).
				style(style).
				source(getSource(boc, queryService)).
				destination(getDestination(boc, queryService)).
				build());
	}

	private Graphic getGraphicalRepresentation(final SubprogramCallOrder bo) {
		return graphic;
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
}
