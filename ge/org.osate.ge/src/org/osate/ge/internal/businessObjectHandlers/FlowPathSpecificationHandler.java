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
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.query.AgeDiagramElementQuery;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.DiagramElementQuery;

public class FlowPathSpecificationHandler extends FlowSpecificationHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().small().build()).build();
	
	// Basics
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getKind() == FlowKind.PATH;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
			
	@CreateSourceQuery
	public DiagramElementQuery<FlowSpecification> createSourceQuery(final @Named(Names.ROOT_QUERY) AgeDiagramElementQuery<FlowSpecification> rootQuery) {
		return rootQuery.descendantsByBusinessObjects((fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllInEnd())).first();
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<FlowSpecification> createDestination(final @Named(Names.ROOT_QUERY) AgeDiagramElementQuery<FlowSpecification> rootQuery) {
		return rootQuery.descendantsByBusinessObjects((fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllOutEnd())).first();
	}
	
	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if(!canOwnFlowSpecification(diagramBo)) {
			return null;
		}
		
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().connectionCreation().label("Flow Path").icon(ImageHelper.getImage("FlowPath")).category(Categories.FLOWS).context(FlowKind.PATH).build(),
		};
	}
	
	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Feature srcFeature, 
			@Named(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY) final AgeDiagramElement srcDiagramElement, 
			final @Named(Names.PALETTE_ENTRY_CONTEXT) FlowKind flowKind,
			final QueryService queryService) {
		
		if(flowKind != FlowKind.PATH) {
			return false;
		}
		
		return isValidFlowEnd(srcFeature, srcDiagramElement, DirectionType.IN, queryService);
	}	
	
	@CanCreate
	public boolean canCreate(@Named(Names.DESTINATION_BO) final Feature dstFeature, 
			@Named(InternalNames.DESTINATION_DIAGRAM_ELEMENT_PROXY) final AgeDiagramElement dstDiagramElement, 
			final QueryService queryService) {		
		return isValidFlowEnd(dstFeature, dstDiagramElement, DirectionType.OUT, queryService);
	}
	
	@GetCreateOwner
	public ComponentType getCreateOwner(final @Named(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY) DiagramElement srcDiagramElement,
			final QueryService queryService) {
		return getComponentType(srcDiagramElement, queryService);
	}	
	
	@Create
	public FlowSpecification createFlowPath(final @Named(Names.OWNER_BO) ComponentType ct,
			final @Named(Names.SOURCE_BO) Feature srcFeature,
			final @Named(InternalNames.SOURCE_DIAGRAM_ELEMENT_PROXY) DiagramElement srcDiagramElement,
			final @Named(Names.DESTINATION_BO) Feature dstFeature,
			final @Named(InternalNames.DESTINATION_DIAGRAM_ELEMENT_PROXY) DiagramElement dstDiagramElement,
			final NamingService namingService,
			final QueryService queryService) {
		
		final FlowSpecification fs = ct.createOwnedFlowSpecification();
		fs.setKind(FlowKind.PATH);
		fs.setName(getNewFlowSpecificationName(ct, namingService));

		// Create the flow ends
		final FlowEnd inFlowEnd = fs.createInEnd();
		inFlowEnd.setFeature(srcFeature);
		inFlowEnd.setContext(getContext(srcDiagramElement, queryService));
		
		final FlowEnd outFlowEnd = fs.createOutEnd();
		outFlowEnd.setFeature(dstFeature);
		outFlowEnd.setContext(getContext(dstDiagramElement, queryService));
		
		ct.setNoFlows(false);
			
		return null;
	}
}
