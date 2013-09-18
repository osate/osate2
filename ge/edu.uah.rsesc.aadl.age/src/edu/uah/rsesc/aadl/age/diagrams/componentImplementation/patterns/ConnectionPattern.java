package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.PortConnection;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.HighlightingService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

public class ConnectionPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;
	private final HighlightingService highlightingHelper;
	private final ConnectionService connectionHelper;
	
	@Inject
	public ConnectionPattern(final VisibilityService visibilityHelper, final StyleService styleUtil,final HighlightingService highlightingHelper, final ConnectionService connectionHelper) {
		super(visibilityHelper);
		this.styleUtil = styleUtil;
		this.highlightingHelper = highlightingHelper;
		this.connectionHelper = connectionHelper;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof org.osate.aadl2.Connection;
	}
	
	private org.osate.aadl2.Connection getAadlConnection(final Connection connection) {
		return (org.osate.aadl2.Connection)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final org.osate.aadl2.Connection aadlConnection = getAadlConnection(connection);
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Before removing all the decorators, get position of the label(if one exists)
		int labelX = 5;
		int labelY = 10;
		for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
			if(d.getGraphicsAlgorithm() instanceof Text) {
				final Text text = (Text)d.getGraphicsAlgorithm();
				labelX = text.getX();
				labelY = text.getY();
			}
		}
		
		connection.getConnectionDecorators().clear();

		final boolean showImmediateDecoration;
		final boolean showDelayedDecoration;
		if(aadlConnection instanceof PortConnection) {
			final PortConnection pc = (PortConnection)aadlConnection;
			final EnumerationLiteral connectionTiming = GetProperties.getConnectionTiming(pc);
			if(connectionTiming.equals(GetProperties.getDelayedUnitLiteral(pc))) {
				showDelayedDecoration = true;
				showImmediateDecoration = false;
			} else if(connectionTiming.equals(GetProperties.getImmediateUnitLiteral(pc))) {
				showDelayedDecoration = false;
				showImmediateDecoration = true;
			} else {
			
				showImmediateDecoration = showDelayedDecoration = false;
			}
		} else {
			showImmediateDecoration = showDelayedDecoration = false;
		}
		
		// Show the direction indicator IF:
		// Connection is not bidirectional
		// Immediate Decoration is not being shown
		// One of the ports is not directional
		// Not Feature Group...
		final boolean showDirectionDecoration;
		if(!showImmediateDecoration && !aadlConnection.isBidirectional()) {
			final ConnectionEnd src = aadlConnection.getAllSource();
			final ConnectionEnd dst = aadlConnection.getAllDestination();
			if((src != null && src instanceof DirectedFeature && (((DirectedFeature)src).getDirection() == null || ((DirectedFeature)src).getDirection() == DirectionType.IN_OUT)) ||
			 (dst != null && dst instanceof DirectedFeature && (((DirectedFeature)dst).getDirection() == null || ((DirectedFeature)dst).getDirection() == DirectionType.IN_OUT))) {
				showDirectionDecoration = true;
			} else {
				showDirectionDecoration = false;
			}
		} else {
			showDirectionDecoration = false;
		}
		
		// Determine how much to shift the decorators incase multiple decorators will be displayed
		final int decoratorXShift = (showDelayedDecoration && showDirectionDecoration) ? 10 : 0;

		if(showDelayedDecoration) {
			final int delayedSpacing = 3;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDelayedIndicator(timingDecorator1, -delayedSpacing - decoratorXShift, styleUtil.getDecoratorStyle(getDiagram()));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDelayedIndicator(timingDecorator2, delayedSpacing - decoratorXShift, styleUtil.getDecoratorStyle(getDiagram()));
		} else if(showImmediateDecoration) {
			final int immediateSpacing = 5;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDirectionIndicator(timingDecorator1, -immediateSpacing, styleUtil.getDecoratorStyle(getDiagram()));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDirectionIndicator(timingDecorator2, immediateSpacing, styleUtil.getDecoratorStyle(getDiagram()));
		}

		// Draw a direction indicator
		if(showDirectionDecoration) {
	        final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
	        createDirectionIndicator(directionDecorator, decoratorXShift, styleUtil.getDecoratorStyle(getDiagram()));
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(styleUtil.getLabelStyle(getDiagram()));
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(aadlConnection.getName());
	    
	    // Set color based on current mode/mode transition
	    highlightingHelper.highlight(getDiagram(), aadlConnection, connection.getGraphicsAlgorithm());
	}

	@Override
	protected void createGraphicsAlgorithm(final org.eclipse.graphiti.mm.pictograms.Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleUtil.getDecoratorStyle(getDiagram());
		polyline.setStyle(style);
	}
	
	private void createDirectionIndicator(final GraphicsAlgorithmContainer gaContainer, final int x, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		x+4, 6, 
	    		x-4, 0, 
	    		x+4, -6});
	    ga.setStyle(style);
	}
		
	private void createDelayedIndicator(final GraphicsAlgorithmContainer gaContainer, final int x, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
		gaService.createPlainPolyline(gaContainer, new int[] {
			x, -10, 
			x, 10}).setStyle(style);
	}
	
	@Override
	protected Anchor[] getAnchors(final Connection connection) {
		final org.osate.aadl2.Connection aadlConnection = getAadlConnection(connection);
		final ContainerShape ownerShape = connectionHelper.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionHelper.getAnchors(ownerShape, aadlConnection);	
	}
}
