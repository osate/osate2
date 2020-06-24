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

import org.osate.aadl2.FlowKind;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.util.AadlInheritanceUtil;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowSpecificationInstanceHandler extends AadlBusinessObjectHandler {
	private static final StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference(
					(FlowSpecificationInstance fsi) -> getPathToFlowSpecificationInstanceSource(fsi)).first());
	private static final StandaloneQuery partialSrcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) -> getPathToFlowSpecificationInstanceSource(fsi), 1)
					.first());
	private static final StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) -> getPathToFlowSpecificationInstanceDestination(fsi))
					.first());
	private static final StandaloneQuery partialDstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) -> getPathToFlowSpecificationInstanceDestination(fsi), 1)
					.first());

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(FlowSpecificationInstance.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final FlowSpecificationInstance bo = ctx.getBusinessObject(FlowSpecificationInstance.class).get();
		return new CanonicalBusinessObjectReference(AadlReferenceUtil.INSTANCE_ID,
				AadlReferenceUtil.FLOW_SPECIFICATION_INSTANCE_KEY, AadlReferenceUtil.getSystemInstanceKey(bo),
				bo.getInstanceObjectPath());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return new RelativeBusinessObjectReference(AadlReferenceUtil.INSTANCE_ID,
				AadlReferenceUtil.FLOW_SPECIFICATION_INSTANCE_KEY,
				ctx.getBusinessObject(FlowSpecificationInstance.class).get().getFullName());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(FlowSpecificationInstance.class).map(fsi -> fsi.getName()).orElse("");
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final FlowSpecificationInstance fsi = boc.getBusinessObject(FlowSpecificationInstance.class).get();
		final QueryService queryService = ctx.getQueryService();

		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);

		boolean partial = false;

		if (src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		BusinessObjectContext dst = null;
		if (fsi.getFlowSpecification().getKind() == FlowKind.PATH) {
			dst = queryService.getFirstResult(dstQuery, boc);

			if (dst == null) {
				dst = queryService.getFirstResult(partialDstQuery, boc);
				partial = true;
			}
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY);

		if (fsi.getFlowSpecification().getKind() == FlowKind.PATH) {
			sb.lineWidth(4.0).backgroundColor(Color.BLACK);
		}

		if (partial) {
			sb.dotted();
		}

		return Optional.of(GraphicalConfigurationBuilder.create()
				.graphic(AadlGraphics.getFlowSpecificationGraphic(fsi.getFlowSpecification())).style(sb.build())
				.source(src).destination(dst).build());
	}

	private static Object[] getPathToFlowSpecificationInstanceSource(FlowSpecificationInstance fsi) {
		return AgeAadlUtil.getPathToBusinessObject(fsi.getComponentInstance(),
				fsi.getFlowSpecification().getKind() == FlowKind.SOURCE ? fsi.getDestination() : fsi.getSource());
	}

	private static Object[] getPathToFlowSpecificationInstanceDestination(FlowSpecificationInstance fsi) {
		return AgeAadlUtil.getPathToBusinessObject(fsi.getComponentInstance(), fsi.getDestination());
	}
}
