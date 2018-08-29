package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.inject.Named;

import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowPathSpecificationInstanceHandler extends FlowSpecificationHandler {
	private static final StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference(
					(FlowSpecificationInstance fsi) -> getBusinessObjectsPathToFlowEnd(fsi,
							fsi.getFlowSpecification().getAllInEnd(), (fsInstance) -> (fsInstance.getSource())))
					.first());

	private static final StandaloneQuery partialSrcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference(
					(FlowSpecificationInstance fsi) -> getBusinessObjectsPathToFlowEnd(fsi,
							fsi.getFlowSpecification().getAllInEnd(), (fsInstance) -> (fsInstance.getSource())),
					1).first());

	private static final StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference(
					(FlowSpecificationInstance fsi) -> getBusinessObjectsPathToFlowEnd(fsi,
							fsi.getFlowSpecification().getAllOutEnd(), (fsInstance) -> (fsInstance.getDestination())))
					.first());
	private static final StandaloneQuery partialDstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference(
					(FlowSpecificationInstance fsi) -> getBusinessObjectsPathToFlowEnd(fsi,
							fsi.getFlowSpecification().getAllOutEnd(), (fsInstance) -> (fsInstance.getDestination())),
					1).first());

	protected static Object[] getBusinessObjectsPathToFlowEnd(final FlowSpecificationInstance fsi,
			final FlowEnd flowEnd,
			final Function<FlowSpecificationInstance, FeatureInstance> addFeatureInstance) {
		final List<Object> path = new ArrayList<>(2);
		if (flowEnd != null && flowEnd.getContext() instanceof Feature) {
			path.add(getContext(fsi.getComponentInstance(), (Feature) flowEnd.getContext()));
		}

		path.add(addFeatureInstance.apply(fsi));

		return path.toArray();
	}

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

		return GraphicalConfigurationBuilder.create().graphic(graphic).style(sb.build()).source(src).destination(dst)
				.build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		return fsi.getFullName();
	}
}
