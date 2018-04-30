package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FlowIndicatorBuilder;
import org.osate.ge.graphics.internal.OrthogonalLineBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowSourceSinkSpecificationHandler extends FlowSpecificationHandler {
	private static final Graphic flowSourceGraphic = FlowIndicatorBuilder.create().
			sourceTerminator(ArrowBuilder.create().small().build()).
			destinationTerminator(OrthogonalLineBuilder.create().build()).
			build();
	private static final Graphic flowSinkGraphic = FlowIndicatorBuilder.create().
			sourceTerminator(ArrowBuilder.create().small().reverse().build()).
			destinationTerminator(OrthogonalLineBuilder.create().build()).
			build();

	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getKind() == FlowKind.SOURCE ? fs.getAllOutEnd() : fs.getAllInEnd())).first());
	private static StandaloneQuery partialSrcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getKind() == FlowKind.SOURCE ? fs.getAllOutEnd() : fs.getAllInEnd()), 1).first());

	// Basics
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getKind() == FlowKind.SOURCE || fs.getKind() == FlowKind.SINK;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		boolean partial = false;

		if(src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder.create(
				AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY);
		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(fs)).
				style(sb.build()).
				source(src).
				build();
	}

	private Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		switch(fs.getKind()) {
		case SOURCE:
			return flowSourceGraphic;

		case SINK:
			return flowSinkGraphic;

		default:
			return null;
		}
	}

	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if (!BusinessObjectHandlerUtil.diagramSupportsPackageOrClassifiers(diagramBo)) {
			return null;
		}

		return new PaletteEntry[] {
				PaletteEntryBuilder.create().creation().label("Flow Source Specification")
				.icon(ImageHelper.getImage("FlowSource")).category(Categories.FLOWS).context(FlowKind.SOURCE)
				.build(),
				PaletteEntryBuilder.create().creation().label("Flow Sink Specification")
				.icon(ImageHelper.getImage("FlowSink")).category(Categories.FLOWS).context(FlowKind.SINK)
				.build()
		};
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) Feature feature,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext featureBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) FlowKind flowKind,
			final QueryService queryService) {

		final DirectionType requiredDirection;
		if(flowKind == FlowKind.SOURCE) {
			requiredDirection = DirectionType.OUT;
		} else if(flowKind == FlowKind.SINK) {
			requiredDirection = DirectionType.IN;
		} else {
			throw new RuntimeException("Unexpected flow kind: " + flowKind);
		}

		return getPotentialOwnersByFeature(featureBoc, queryService).size() > 0
				&& isValidFlowEnd(feature, featureBoc, requiredDirection, queryService);
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext featureBoc,
			final @Named(Names.TARGET_BO) Feature feature,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) FlowKind flowKind, final QueryService queryService,
			final NamingService namingService) {
		final BusinessObjectContext container = getFlowSpecificationOwnerBoc(featureBoc, queryService);
		if (container == null) {
			return null;
		}

		return Operation.create(createOp -> {
			EditingUtil.selectClassifier(createOp, getPotentialOwnersByFeature(featureBoc, queryService))
					.modifyPreviousResult(ct -> {
						final FlowSpecification fs = ct.createOwnedFlowSpecification();
						fs.setKind(flowKind);
						fs.setName(getNewFlowSpecificationName(ct, namingService));

						// Create the appropriate flow end depending on the type being created
						final FlowEnd flowEnd;
						if (flowKind == FlowKind.SOURCE) {
							flowEnd = fs.createOutEnd();
						} else if (flowKind == FlowKind.SINK) {
							flowEnd = fs.createInEnd();
						} else {
							throw new RuntimeException("Unexpected flow kind: " + flowKind);
						}
						flowEnd.setFeature(feature);
						flowEnd.setContext(getContext(featureBoc, queryService));

						// Clear the no flows flag
						ct.setNoFlows(false);

						return StepResultBuilder.create().showNewBusinessObject(container, fs).build();
					});
		});
	}
}
