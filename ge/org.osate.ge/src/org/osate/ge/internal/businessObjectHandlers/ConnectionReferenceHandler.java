package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ConnectionReferenceHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();//.destinationTerminator(ArrowBuilder.create().open().build()).build();
	
	/*
	private static final Graphic graphic = ConnectionBuilder.create().
			sourceTerminator(ArrowBuilder.create().open().build()).
			destinationTerminator(ArrowBuilder.create().filled().build()).build();
	*/
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		/*
		// Create decorators
		//
		// Determine which indicators should be shown
		final boolean showImmediateDecoration;
		final boolean showDelayedDecoration;
		if(cr.getConnection() instanceof PortConnection) {
			final EnumerationLiteral connectionTiming = GetProperties.getConnectionTiming(cr);
			if(connectionTiming.equals(GetProperties.getDelayedUnitLiteral(cr))) {
				showDelayedDecoration = true;
				showImmediateDecoration = false;
			} else if(connectionTiming.equals(GetProperties.getImmediateUnitLiteral(cr))) {
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
		// One of the ports is not directional
		// Not Feature Group...
		final boolean showDirectionDecoration;
		if(!showImmediateDecoration) {
			final ConnectionInstanceEnd src = cr.getSource();
			final ConnectionInstanceEnd dst = cr.getDestination();
			if((src != null && src instanceof FeatureInstance && (((FeatureInstance)src).getDirection() == null || ((FeatureInstance)src).getDirection() == DirectionType.IN_OUT)) ||
			 (dst != null && dst instanceof FeatureInstance && (((FeatureInstance)dst).getDirection() == null || ((FeatureInstance)dst).getDirection() == DirectionType.IN_OUT))) {
				showDirectionDecoration = true;
			} else {
				showDirectionDecoration = false;
			}
		} else {
			showDirectionDecoration = false;
		}
		
		// Create decorators
		// Determine how much to shift the decorators in case multiple decorators will be displayed
		final int decoratorXShift = (showDelayedDecoration && showDirectionDecoration) ? 10 : 0;

		// TODO
		if(showDelayedDecoration) {
			// TODO
			//final int delayedSpacing = 3;
			//final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			//gaCreationService.createDelayedIndicator(timingDecorator1, -delayedSpacing - decoratorXShift, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
			//final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			//gaCreationService.createDelayedIndicator(timingDecorator2, delayedSpacing - decoratorXShift, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
		} else if(showImmediateDecoration) {
			// TODO
			//final int immediateSpacing = 5;
			//final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			//gaCreationService.createDirectionIndicator(timingDecorator1, -immediateSpacing, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
			//final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			//gaCreationService.createDirectionIndicator(timingDecorator2, immediateSpacing, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
		}

		// Draw a direction indicator
		if(showDirectionDecoration) {
			// TODO
	        //final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
	       // gaCreationService.createDirectionIndicator(directionDecorator, decoratorXShift, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
		}
		*/
		return graphic;
	}
	
	@CreateParentQuery
	public DiagramElementQuery<?> createOwnerDiagramElementQuery(final @Named(Names.SOURCE_ROOT_QUERY) DiagramElementQuery<ConnectionReference> srcRootQuery, 
			final @Named(Names.DESTINATION_ROOT_QUERY) DiagramElementQuery<ConnectionReference> dstRootQuery) {
		
		return srcRootQuery.ancestors().filterByBusinessObject((cr) -> cr.getContainingComponentInstance());
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<ConnectionReference> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<ConnectionReference> rootQuery) {
		return rootQuery.descendants().filterByBusinessObject((cr) -> cr.getSource());
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<ConnectionReference> createDestination(final @Named(Names.ROOT_QUERY) DiagramElementQuery<ConnectionReference> rootQuery) {
		return rootQuery.descendants().filterByBusinessObject((cr) -> cr.getDestination());
	}
}
