/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
package org.osate.ge.internal.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ConnectionReferencePattern extends AgeConnectionPattern {
	private final BusinessObjectResolutionService bor;
	private final StyleService styleService;
	private final GraphicsAlgorithmCreationService gaCreationService;
	
	@Inject
	public ConnectionReferencePattern(final ColoringService coloringService, final GhostingService ghostingService, final ConnectionService connectionService, final BusinessObjectResolutionService bor,
			GraphicsAlgorithmCreationService gaCreationService, final PropertyService propertyService, final StyleService styleService) {
		super(coloringService, ghostingService, connectionService, propertyService, bor);
		this.bor = bor;
		this.gaCreationService = gaCreationService;
		this.styleService = styleService;		
	}

	@Override
	protected boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof ConnectionReference;
	}

	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleService.getStyle(StyleConstants.DECORATOR_STYLE);
		polyline.setStyle(style);
	}

	@Override
	protected void createDecorators(final Connection connection) {
		final ConnectionReference cr = (ConnectionReference)bor.getBusinessObjectForPictogramElement(connection);
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();

		// Clear old decorators
		connection.getConnectionDecorators().clear();		
		
		//
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

		if(showDelayedDecoration) {
			final int delayedSpacing = 3;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDelayedIndicator(timingDecorator1, -delayedSpacing - decoratorXShift, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDelayedIndicator(timingDecorator2, delayedSpacing - decoratorXShift, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
		} else if(showImmediateDecoration) {
			final int immediateSpacing = 5;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDirectionIndicator(timingDecorator1, -immediateSpacing, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			gaCreationService.createDirectionIndicator(timingDecorator2, immediateSpacing, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
		}

		// Draw a direction indicator
		if(showDirectionDecoration) {
	        final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
	        gaCreationService.createDirectionIndicator(directionDecorator, decoratorXShift, styleService.getStyle(StyleConstants.DECORATOR_STYLE));
		}
	}

	@Override
	public boolean isPaletteApplicable() {
		return false;
	}

}
