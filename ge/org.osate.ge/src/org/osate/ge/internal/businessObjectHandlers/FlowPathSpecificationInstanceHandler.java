package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.FlowKind;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.query.Supplier;
import org.osate.ge.services.QueryService;

public class FlowPathSpecificationInstanceHandler extends FlowSpecificationInstanceHandler {
	private static final Supplier<FlowSpecificationInstance, Object[]> getPathToFlowSpecificationInstanceSource = (
			fsi) -> AadlHelper.getPathToBusinessObject(fsi.getComponentInstance(), fsi.getSource());
	private static final StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference(getPathToFlowSpecificationInstanceSource).first());
	private static final StandaloneQuery partialSrcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference(getPathToFlowSpecificationInstanceSource, 1).first());
	private static final Supplier<FlowSpecificationInstance, Object[]> getPathToFlowSpecificationInstanceDestination = (
			fsi) -> AadlHelper.getPathToBusinessObject(fsi.getComponentInstance(), fsi.getDestination());
	private static final StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference(getPathToFlowSpecificationInstanceDestination).first());
	private static final StandaloneQuery partialDstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference(getPathToFlowSpecificationInstanceDestination, 1).first());

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		return fsi.getFlowSpecification().getKind() == FlowKind.PATH;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		BusinessObjectContext dst = queryService.getFirstResult(dstQuery, boc);

		boolean partial = false;

		if (src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		if (dst == null) {
			dst = queryService.getFirstResult(partialDstQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY).lineWidth(4.0)
				.backgroundColor(Color.BLACK);

		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create()
				.graphic(AadlGraphics.getFlowSpecificationGraphic(fsi.getFlowSpecification())).style(sb.build())
				.source(src).destination(dst).build();
	}
}
