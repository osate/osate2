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
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetDestination;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.GetSource;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.CreateParentQuery;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowPathSpecificationHandler extends FlowSpecificationHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().small().build()).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllInEnd())).first());
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllOutEnd())).first());
	
	// Basics
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getKind() == FlowKind.PATH;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
			
	@CreateParentQuery
	public Query createParentQuery(final @Named(InternalNames.SOURCE_ROOT_QUERY) Query srcRootQuery) {
		return srcRootQuery.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentType).first();
	}
	
	@GetSource
	public BusinessObjectContext getSource(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}
	
	@GetDestination
	public BusinessObjectContext getDestination(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
	
	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] {
			PaletteEntryBuilder.create().connectionCreation().label("Flow Path").icon(ImageHelper.getImage("FlowPath")).category(Categories.FLOWS).context(FlowKind.PATH).build(),
		};
	}
	
	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Feature srcFeature, 
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc, 
			final @Named(Names.PALETTE_ENTRY_CONTEXT) FlowKind flowKind,
			final QueryService queryService) {
		if(flowKind != FlowKind.PATH) {
			return false;
		}
		
		return isValidFlowEnd(srcFeature, srcBoc, DirectionType.IN, queryService);
	}	
	
	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			@Named(Names.DESTINATION_BO) final Feature dstFeature, 
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc, 
			final QueryService queryService) {
		
		final ComponentType srcComponentType = getComponentTypeByFeature(srcBoc, queryService);
		final ComponentType dstComponentType = getComponentTypeByFeature(dstBoc, queryService);
		return canOwnFlowSpecification(srcComponentType) && 
				srcComponentType == dstComponentType && 
				isValidFlowEnd(dstFeature, dstBoc, DirectionType.OUT, queryService);
	}
	
	@GetCreateOwner
	public ComponentType getCreateOwner(final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			final QueryService queryService) {
		return getComponentTypeByFeature(srcBoc, queryService);
	}	
	
	@Create
	public FlowSpecification createFlowPath(final @Named(Names.OWNER_BO) ComponentType ct,
			final @Named(Names.SOURCE_BO) Feature srcFeature,
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			final @Named(Names.DESTINATION_BO) Feature dstFeature,
			final @Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext dstBoc,
			final NamingService namingService,
			final QueryService queryService) {
		
		final FlowSpecification fs = ct.createOwnedFlowSpecification();
		fs.setKind(FlowKind.PATH);
		fs.setName(getNewFlowSpecificationName(ct, namingService));

		// Create the flow ends
		final FlowEnd inFlowEnd = fs.createInEnd();
		inFlowEnd.setFeature(srcFeature);
		inFlowEnd.setContext(getContext(srcBoc, queryService));
		
		final FlowEnd outFlowEnd = fs.createOutEnd();
		outFlowEnd.setFeature(dstFeature);
		outFlowEnd.setContext(getContext(dstBoc, queryService));
		
		ct.setNoFlows(false);
			
		return null;
	}
}
