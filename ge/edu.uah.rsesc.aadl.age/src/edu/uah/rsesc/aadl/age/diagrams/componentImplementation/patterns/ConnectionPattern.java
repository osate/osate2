package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.PortConnection;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ElementHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ModalElementHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleUtil;

public class ConnectionPattern extends AgeConnectionPattern {
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof org.osate.aadl2.Connection;
	}

	@Override
	public PictogramElement add(final IAddContext context) {
		final IAddConnectionContext addConContext = (IAddConnectionContext)context;
        final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)AadlElementWrapper.unwrap(context.getNewObject());
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final Diagram diagram = getDiagram();
        
        // Create the implements connection
        final org.eclipse.graphiti.mm.pictograms.Connection connection = peCreateService.createFreeFormConnection(diagram);
        link(connection, new AadlElementWrapper(aadlConnection));

        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        createGraphicsAlgorithm(connection);
        createDecorators(connection, aadlConnection);
        
		return connection;
	}
	
	private void createDecorators(final org.eclipse.graphiti.mm.pictograms.Connection connection, final org.osate.aadl2.Connection aadlConnection) {
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
			createDelayedIndicator(timingDecorator1, -delayedSpacing - decoratorXShift, StyleUtil.getDecoratorStyle(getDiagram()));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDelayedIndicator(timingDecorator2, delayedSpacing - decoratorXShift, StyleUtil.getDecoratorStyle(getDiagram()));
		} else if(showImmediateDecoration) {
			final int immediateSpacing = 5;
			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDirectionIndicator(timingDecorator1, -immediateSpacing, StyleUtil.getDecoratorStyle(getDiagram()));
			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
			createDirectionIndicator(timingDecorator2, immediateSpacing, StyleUtil.getDecoratorStyle(getDiagram()));
		}

		// Draw a direction indicator
		if(showDirectionDecoration) {
	        final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
	        createDirectionIndicator(directionDecorator, decoratorXShift, StyleUtil.getDecoratorStyle(getDiagram()));
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(StyleUtil.getLabelStyle(getDiagram()));
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(aadlConnection.getName());
	    
	    // Set color based on current mode/mode transition
	    ModalElementHelper.setColorIfInSelectedMode(getDiagram(), aadlConnection, connection.getGraphicsAlgorithm());
	}

	private void createGraphicsAlgorithm(final org.eclipse.graphiti.mm.pictograms.Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = StyleUtil.getDecoratorStyle(getDiagram());
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
	public boolean canUpdate(final IUpdateContext context) {
		final Object bo = this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return context.getPictogramElement() instanceof org.eclipse.graphiti.mm.pictograms.Connection && isMainBusinessObjectApplicable(bo);
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createFalseReason();
	}

	@Override
	public boolean update(final IUpdateContext context) {		
		// Rebuild the graphics algorithm and the decorators to ensure they are up to date and to ensure they reference the latest styles.
		// Old styles are removed when the diagram is updated
		final org.eclipse.graphiti.mm.pictograms.Connection connection = (org.eclipse.graphiti.mm.pictograms.Connection)context.getPictogramElement();
		final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));

		// Update anchors
		//aadlConnection.getContainingComponentImpl() - That may not be right... Need to get it from the diagram..
		Object diagramBo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(getDiagram()));
		if(!(diagramBo instanceof ComponentImplementation)) {
			throw new RuntimeException("Unhandled case. " + getClass().getSimpleName() + " only supported in component implementation diagrams");
		}
		
		final Anchor[] anchors = AnchorUtil.getAnchorsForConnection((ComponentImplementation)diagramBo, aadlConnection, getFeatureProvider());
		if(anchors == null) {
			connection.setStart(null);
			connection.setEnd(null);
			EcoreUtil.remove(connection);
		}
		else {
			connection.setStart(anchors[0]);
			connection.setEnd(anchors[1]);
			
			createGraphicsAlgorithm(connection);
			createDecorators(connection, aadlConnection);
		}
		
		return true;
	}
}
