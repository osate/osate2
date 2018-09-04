package org.osate.ge.internal.businessObjectHandlers;

import java.util.function.Function;

import javax.inject.Named;

import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowSourceSinkSpecificationInstanceHandler extends FlowSpecificationHandler {
	private static final StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) -> getBusinessObjectsPathToFlowEnd(fsi))
					.first());

	private static final StandaloneQuery partialSrcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(FlowSpecificationInstance fsi) -> getBusinessObjectsPathToFlowEnd(
									fsi),
							1)
					.first());

	private static Object[] getBusinessObjectsPathToFlowEnd(final FlowSpecificationInstance fsi) {
		final FlowSpecification fs = fsi.getFlowSpecification();
		final FlowEnd flowEnd;
		final Function<FlowSpecificationInstance, FeatureInstance> addFeatureInstance;

		if (fs.getKind() == FlowKind.SOURCE) {
			flowEnd = fs.getAllOutEnd();
			addFeatureInstance = (fsInstance) -> (fsInstance.getDestination());
		} else {
			flowEnd = fs.getAllInEnd();
			addFeatureInstance = (fsInstance) -> (fsInstance.getSource());
		}

		return getBusinessObjectsPathToFlowEnd(fsi, flowEnd, addFeatureInstance);
	}

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

		return GraphicalConfigurationBuilder.create().graphic(getGraphicalRepresentation(fsi.getFlowSpecification()))
				.style(sb.build())
				.source(src).build();
	}

	private Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		switch (fs.getKind()) {
		case SOURCE:
			return flowSourceGraphic;

		case SINK:
			return flowSinkGraphic;

		default:
			return null;
		}
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		return fsi.getFullName();
	}
}
