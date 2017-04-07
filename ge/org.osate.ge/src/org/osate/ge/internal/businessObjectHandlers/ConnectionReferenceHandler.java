package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import javax.inject.Named;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.di.GetDestination;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetSource;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.decorations.Decoration;
import org.osate.ge.internal.decorations.DelayedDecorationBuilder;
import org.osate.ge.internal.decorations.DirectionDecorationBuilder;
import org.osate.ge.internal.decorations.ImmediateDecorationBuilder;
import org.osate.ge.internal.di.CreateParentQuery;
import org.osate.ge.internal.di.GetDecorations;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ConnectionReferenceHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static final Decoration delayedDecoration = DelayedDecorationBuilder.create().build();
	private static final Decoration immediateDecoration = ImmediateDecorationBuilder.create().build();
	private static final Decoration directionDecoration = DirectionDecorationBuilder.create().build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendants().filterByBusinessObject((ConnectionReference cr) -> cr.getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendants().filterByBusinessObject((ConnectionReference cr) -> cr.getDestination()));
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		return true;
	}
		
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		return graphic;
	}
	
	@GetDecorations
	public Decoration[] getDecorations(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		final ArrayList<Decoration> decorations = new ArrayList<Decoration>(3);
		
		// Determine which indicators should be shown
		final boolean showImmediateDecoration;
		final boolean showDelayedDecoration;
		if(cr.getConnection() instanceof PortConnection) {
			final EnumerationLiteral connectionTiming = GetProperties.getConnectionTiming(cr);
			final String connectionTimingName = connectionTiming == null ? null : connectionTiming.getName();
			if(CommunicationProperties.DELAYED.equals(connectionTimingName)) {
				showDelayedDecoration = true;
				showImmediateDecoration = false;
			} else if(CommunicationProperties.IMMEDIATE.equals(connectionTimingName)) {
				showDelayedDecoration = false;
				showImmediateDecoration = true;
			} else {			
				showImmediateDecoration = showDelayedDecoration = false;
			}		
		} else {
			showImmediateDecoration = showDelayedDecoration = false;
		}
		
		// Show the direction indicator If:
		// Connection is not bidirectional
		// Immediate Decoration is not being shown
		// Both of the ports are not directional
		// Not Feature Group...
		final boolean showDirectionDecoration;
		if(!showImmediateDecoration) {
			final ConnectionInstanceEnd src = cr.getSource();
			final ConnectionInstanceEnd dst = cr.getDestination();
			if((src != null && src instanceof FeatureInstance && (((FeatureInstance)src).getDirection() == null || ((FeatureInstance)src).getDirection() == DirectionType.IN_OUT)) &&
			 (dst != null && dst instanceof FeatureInstance && (((FeatureInstance)dst).getDirection() == null || ((FeatureInstance)dst).getDirection() == DirectionType.IN_OUT))) {
				showDirectionDecoration = true;
			} else {
				showDirectionDecoration = false;
			}
		} else {
			showDirectionDecoration = false;
		}
		
		// Create decorations
		if(showDelayedDecoration) {
			decorations.add(delayedDecoration);
		} else if(showImmediateDecoration) {
			decorations.add(immediateDecoration);
		}

		if(showDirectionDecoration) {
			decorations.add(directionDecoration);
		}		
		
		return decorations.toArray(new Decoration[decorations.size()]);
	}
	
	@CreateParentQuery
	public Query createParentQuery(final @Named(InternalNames.SOURCE_ROOT_QUERY) Query srcRootQuery, 
			final @Named(InternalNames.DESTINATION_ROOT_QUERY) Query dstRootQuery) {
		
		return srcRootQuery.ancestors().filterByBusinessObject((ConnectionReference cr) -> cr.getContainingComponentInstance());
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
}
