package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.graphics.FlowIndicatorBuilder;
import org.osate.ge.internal.graphics.OrthogonalLineBuilder;
import org.osate.ge.internal.query.Query;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.DiagramElementQuery;

public class FlowSourceSinkSpecificationHandler extends FlowSpecificationHandler {
	private static final Graphic flowSourceGraphic = FlowIndicatorBuilder.create().
			sourceTerminator(ArrowBuilder.create().small().build()).
			destinationTerminator(OrthogonalLineBuilder.create().build()).
			build();
	private static final Graphic flowSinkGraphic = FlowIndicatorBuilder.create().
			sourceTerminator(ArrowBuilder.create().small().reverse().build()).
			destinationTerminator(OrthogonalLineBuilder.create().build()).
			build();
	
	// Basics
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getKind() == FlowKind.SOURCE || fs.getKind() == FlowKind.SINK;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		switch(fs.getKind()) {
		case SOURCE:
			return flowSourceGraphic;
			
		case SINK:
			return flowSinkGraphic;
			
		default:
			return null;
		}
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<FlowSpecification> createSourceQuery(final @Named(Names.ROOT_QUERY) Query<FlowSpecification> rootQuery) {
		return rootQuery.descendantsByBusinessObjects((fs) -> getBusinessObjectsPathToFlowEnd(fs.getKind() == FlowKind.SOURCE ? fs.getAllOutEnd() : fs.getAllInEnd())).first();
	}
	
	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if(!canOwnFlowSpecification(diagramBo)) {
			return null;
		}
		
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().creation().label("Flow Source").icon(ImageHelper.getImage("FlowSource")).category(Categories.FLOWS).context(FlowKind.SOURCE).build(),
			PaletteEntryBuilder.create().creation().label("Flow Sink").icon(ImageHelper.getImage("FlowSink")).category(Categories.FLOWS).context(FlowKind.SINK).build()
		};
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) Feature feature,
			final @Named(InternalNames.TARGET_DIAGRAM_ELEMENT) AgeDiagramElement featureDiagramElement,
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
		return isValidFlowEnd(feature, featureDiagramElement, requiredDirection, queryService);
	}	
	
	@GetCreateOwner
	public ComponentType getCreateOwner(final @Named(InternalNames.TARGET_DIAGRAM_ELEMENT) DiagramElement targetDiagramElement,
			final QueryService queryService) {
		return getComponentType(targetDiagramElement, queryService);
	}	

	@Create
	public FlowSpecification createFlowSpecification(final @Named(Names.OWNER_BO) ComponentType ct,
			final @Named(Names.TARGET_BO) Feature feature,
			final @Named(InternalNames.TARGET_DIAGRAM_ELEMENT) DiagramElement featureDiagramElement,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) FlowKind flowKind, 
			final NamingService namingService,
			final QueryService queryService) {
		final FlowSpecification fs = ct.createOwnedFlowSpecification();
		fs.setKind(flowKind);
		fs.setName(getNewFlowSpecificationName(ct, namingService));

		// Create the appropriate flow end depending on the type being created
		final FlowEnd flowEnd;
		if(flowKind == FlowKind.SOURCE) {
			flowEnd = fs.createOutEnd();
		} else if(flowKind == FlowKind.SINK) {
			flowEnd = fs.createInEnd();
		} else {
			throw new RuntimeException("Unexpected flow kind: " + flowKind);
		}     			
		flowEnd.setFeature(feature);
		flowEnd.setContext(getContext(featureDiagramElement, queryService));
		
		// Clear the no flows flag
		ct.setNoFlows(false);

		return fs;
	}
}
