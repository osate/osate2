package org.osate.ge.internal.businessObjectHandlers;

import java.util.function.Function;

import javax.inject.Named;

import org.osate.aadl2.FlowKind;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowSourceSinkSpecificationInstanceHandler extends FlowSpecificationInstanceHandler {
	private static final Function<FlowSpecificationInstance, Object[]> getPathToFlowSpecificationInstance = (fsi) -> AadlHelper.getPathToBusinessObject(
			fsi.getComponentInstance(),
			fsi.getFlowSpecification().getKind() == FlowKind.SOURCE ? fsi.getDestination() : fsi.getSource());
	private static final StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) ->
							getPathToFlowSpecificationInstance.apply(fsi))
					.first());
	private static final StandaloneQuery partialSrcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) -> getPathToFlowSpecificationInstance.apply(fsi),
							1)
					.first());

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		final FlowKind flowKind = fsi.getFlowSpecification().getKind();
		return flowKind == FlowKind.SOURCE || flowKind == FlowKind.SINK;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		boolean partial = false;

		if (src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY);
		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create()
				.graphic(AadlGraphics.getFlowSpecificationGraphic(fsi.getFlowSpecification()))
				.style(sb.build())
				.source(src).build();
	}
}
