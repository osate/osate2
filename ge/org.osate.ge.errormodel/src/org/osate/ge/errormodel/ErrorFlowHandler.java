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

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.GraphicalExtensionUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanCopyContext;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.ge.errormodel.model.KeywordPropagationPointType;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.FlowIndicatorBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;

public class ErrorFlowHandler implements BusinessObjectHandler {
	private static final Graphic sourceGraphic = FlowIndicatorBuilder.create()
			.sourceTerminator(ArrowBuilder.create().line().build()).build();
	private static final Graphic sinkGraphic = FlowIndicatorBuilder.create()
			.destinationTerminator(ArrowBuilder.create().line().build()).build();
	private static final Graphic pathGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().line().build()).build();

	// Assumes root is the containing classifier
	private static StandaloneQuery propagationQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference(
					(ErrorPropagation p) -> getBusinessObjectPathToPropagationFeatureOrPP(p), 1).first());

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(ErrorFlow.class).filter(bo -> bo.getContainingClassifier() != null).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final ErrorFlow bo = ctx.getBusinessObject(ErrorFlow.class).get();
		return new CanonicalBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_FLOW,
				ctx.getReferenceBuilder().getCanonicalReference(bo.getContainingClassifier()).encode(), bo.getName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return ErrorModelReferenceUtil
				.getRelativeReferenceForErrorFlow(ctx.getBusinessObject(ErrorFlow.class).get().getName());
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final ErrorFlow bo = ctx.getBusinessObjectContext().getBusinessObject(ErrorFlow.class).get();
		final BusinessObjectContext classifierBoc = ctx.getBusinessObjectContext().getParent();
		if (classifierBoc == null) {
			return Optional.empty();
		}

		// Determine the type of graphic and the source and destination of the connection
		final ErrorFlowEnd src;
		final ErrorFlowEnd dst;
		final Graphic graphic;
		if (bo instanceof ErrorSource) {
			graphic = sourceGraphic;
			final ErrorSource es = (ErrorSource) bo;
			src = getErrorFlowEnd(ctx.getQueryService(), classifierBoc, es.isAll(), es.getSourceModelElement())
					.orElse(null);
			dst = null;
		} else if (bo instanceof ErrorSink) {
			graphic = sinkGraphic;
			final ErrorSink es = (ErrorSink) bo;
			src = getErrorFlowEnd(ctx.getQueryService(), classifierBoc, es.isAllIncoming(), es.getIncoming()).orElse(null);
			dst = null;
		} else if (bo instanceof ErrorPath) {
			graphic = pathGraphic;
			final ErrorPath ep = (ErrorPath) bo;
			src = getErrorFlowEnd(ctx.getQueryService(), classifierBoc, ep.isAllIncoming(), ep.getIncoming()).orElse(null);
			dst = getErrorFlowEnd(ctx.getQueryService(), classifierBoc, ep.isAllOutgoing(), ep.getOutgoing()).orElse(null);
		} else {
			return Optional.empty();
		}

		// Determine style
		final StyleBuilder sb = StyleBuilder.create(GraphicalExtensionUtil.isInherited(ctx.getBusinessObjectContext())
				? GraphicalExtensionUtil.STYLE_INHERITED_ELEMENT
				: Style.EMPTY).lineWidth(4.0);

		final boolean partial = (src != null && src.partial) || (dst != null && dst.partial);
		if (partial) {
			sb.dotted();
		}

		return Optional.of(GraphicalConfigurationBuilder.create().graphic(graphic).style(sb.build())
				.defaultDockingPosition(DockingPosition.ANY).source(src == null ? null : src.boc)
				.destination(dst == null ? null : dst.boc).build());
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
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(ErrorFlow.class).map(bo -> bo.getName()).orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ErrorModelNamingUtil.validateSubclauseChildName(ctx);
	}

	private static Optional<ErrorFlowEnd> getErrorFlowEnd(final QueryService queryService,
			final BusinessObjectContext classifierBoc, final boolean all, final NamedElement propagation) {
		if (all) {
			return getKeywordFlowEnd(classifierBoc, KeywordPropagationPointType.ALL);
		} else if (propagation instanceof ErrorPropagation) {
			return getPropagationFlowEnd(queryService, classifierBoc, (ErrorPropagation) propagation);
		} else {
			return Optional.empty();
		}
	}

	private static Optional<ErrorFlowEnd> getKeywordFlowEnd(final BusinessObjectContext container,
			final KeywordPropagationPointType keyword) {
		if (keyword == null) {
			return Optional.empty();
		}

		return container.getChildren().stream().filter(
				c -> c.getBusinessObject(KeywordPropagationPoint.class).filter(p -> p.getType() == keyword).isPresent())
				.findFirst().map(boc -> new ErrorFlowEnd(boc, false));
	}

	private static Optional<ErrorFlowEnd> getPropagationFlowEnd(final QueryService queryService,
			final BusinessObjectContext container, final ErrorPropagation p) {
		if (p.getKind() != null) {
			return getKeywordFlowEnd(container, KeywordPropagationPointType.getByKind(p.getKind()));
		}

		return queryService.getFirstResult(propagationQuery, container, p)
				.map(value -> new ErrorFlowEnd(value.getBusinessObjectContext(), value.isPartial()));
	}

	/**
	 * Gets an array of business objects representing the path to the specified error propagation
	 * @param p the propagation to get the path for
	 * @return the path or null if a model element was not available
	 */
	private static Object[] getBusinessObjectPathToPropagationFeatureOrPP(final ErrorPropagation p) {
		if (p.getFeatureorPPRef() == null) {
			return null;
		}

		// Determine the needed size for the array
		int count = 0;
		for (FeatureorPPReference t = p.getFeatureorPPRef(); t != null; t = t.getNext()) {
			if (t.getFeatureorPP() == null) {
				return null;
			}
			count++;
		}

		// Populate the array with the path
		final Object[] path = new Object[count];
		int index = 0;
		for (FeatureorPPReference t = p.getFeatureorPPRef(); t != null; t = t.getNext()) {
			path[index++] = t.getFeatureorPP();
		}
		return path;
	}

	/**
	 * Simple class representing a flow end and whether it is partial.
	 *
	 */
	private static class ErrorFlowEnd {
		final BusinessObjectContext boc;
		final boolean partial;

		public ErrorFlowEnd(final BusinessObjectContext boc, final boolean partial) {
			this.boc = Objects.requireNonNull(boc, "boc must not be null");
			this.partial = partial;
		}
	}
}
