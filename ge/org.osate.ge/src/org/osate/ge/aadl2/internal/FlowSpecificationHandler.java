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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
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
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.query.QueryResult;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowSpecificationHandler extends AadlBusinessObjectHandler {
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(
					fs.getKind() == FlowKind.SOURCE ? fs.getAllOutEnd() : fs.getAllInEnd()), 1)
			.first());
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference(
					(FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllOutEnd()), 1).first());

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(FlowSpecification.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return new CanonicalBusinessObjectReference(DeclarativeReferenceType.FLOW_SPECIFICATION.getId(),
				ctx.getBusinessObject(FlowSpecification.class).get().getQualifiedName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return AadlReferenceUtil.buildSimpleRelativeReference(DeclarativeReferenceType.FLOW_SPECIFICATION.getId(),
				((FlowSpecification) ctx.getBusinessObject()));
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(FlowSpecification.class)
				.map(fs -> fs.getName()).orElse("");
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final FlowSpecification fs = boc.getBusinessObject(FlowSpecification.class).get();
		final QueryService queryService = ctx.getQueryService();
		final QueryResult srcResult = queryService.getFirstResult(srcQuery, boc).orElse(null);
		final BusinessObjectContext src = srcResult == null ? null : srcResult.getBusinessObjectContext();
		boolean partial = (srcResult != null && srcResult.isPartial());

		BusinessObjectContext dst = null;
		if (fs.getKind() == FlowKind.PATH) {
			final QueryResult dstResult = queryService.getFirstResult(dstQuery, boc).orElse(null);
			dst = dstResult == null ? null : dstResult.getBusinessObjectContext();
			partial |= (dstResult != null && dstResult.isPartial());
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY);

		if (fs.getKind() == FlowKind.PATH) {
			sb.lineWidth(4.0).backgroundColor(Color.BLACK);
		}

		if (partial) {
			sb.dotted();
		}

		return Optional.of(GraphicalConfigurationBuilder.create().graphic(AadlGraphics.getFlowSpecificationGraphic(fs))
				.style(sb.build()).source(src).destination(dst).build());
	}

	/**
	 * Gets an array of business objects which describes the logical diagram element path to the flow end.
	 * @param ctx
	 * @param flowEnd
	 * @return
	 */
	private static Object[] getBusinessObjectsPathToFlowEnd(final FlowEnd flowEnd) {
		if (flowEnd == null || flowEnd.getFeature() == null) {
			return null;
		}

		final List<Object> path = new ArrayList<>(2);
		if (flowEnd.getContext() != null) {
			path.add(flowEnd.getContext());
		}

		path.add(flowEnd.getFeature());

		return path.toArray();
	}
}
