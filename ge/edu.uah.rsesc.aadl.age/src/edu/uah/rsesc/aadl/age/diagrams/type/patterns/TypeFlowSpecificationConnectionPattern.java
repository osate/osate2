package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.FlowSpecification;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

// TODO: Update styles, etc
public class TypeFlowSpecificationConnectionPattern extends AgeConnectionPattern {
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof FlowSpecification;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		final IAddConnectionContext addConContext = (IAddConnectionContext)context;
        final FlowSpecification fs = (FlowSpecification)AadlElementWrapper.unwrap(context.getNewObject());
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final Diagram diagram = getDiagram();
        
        // Create the implements connection
        final Connection connection = peCreateService.createFreeFormConnection(diagram);
        link(connection, new AadlElementWrapper(fs));

        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        createGraphicsAlgorithm(connection);
        createDecorators(connection, fs);
        
		return connection;
	}
	
	private void createDecorators(final Connection connection, final FlowSpecification fs) {
		connection.getConnectionDecorators().clear();
		
		// TODO: Simply have decorator style instead of arrowhead?
		switch(fs.getKind()) {
		case PATH:
			// Create the arrow
	        final ConnectionDecorator arrowConnectionDecorator = Graphiti.getPeCreateService().createConnectionDecorator(connection, false, 1.0, true);    
	        createArrow(arrowConnectionDecorator, StyleUtil.getFlowSpecificationArrowHeadStyle(getDiagram()));	
			break;
			
		case SOURCE:
		case SINK:
			final ConnectionDecorator vbarConnectionDecorator = Graphiti.getPeCreateService().createConnectionDecorator(connection, false, 1.0, true);
			createVbar(vbarConnectionDecorator, StyleUtil.getFlowSpecificationArrowHeadStyle(getDiagram()));	
			break;
		}
	}
	
	private void createGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = StyleUtil.getFlowSpecificationStyle(getDiagram());
		polyline.setStyle(style);
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-6, 4, 
	    		2, 0, 
	    		-6, -4});
	    ga.setStyle(style);
	    return ga;
	}
	
	private GraphicsAlgorithm createVbar(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		0, 8,
	    		0, -8});
	    ga.setStyle(style);

	    return ga;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		final Object bo = this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return context.getPictogramElement() instanceof Connection && isMainBusinessObjectApplicable(bo);
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createFalseReason();
	}

	@Override
	public boolean update(final IUpdateContext context) {
		// Rebuild the graphics algorithm and the decorators to ensure they are up to date and to ensure they reference the latest styles.
		// Old styles are removed when the diagram is updated
		final Connection connection = (Connection)context.getPictogramElement();
		final FlowSpecification fs = (FlowSpecification)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));

		// Update anchors
		final Anchor[] anchors = AnchorUtil.getAnchorsForFlowSpecification(fs, this.getFeatureProvider());
		if(anchors == null) {
			connection.setStart(null);
			connection.setEnd(null);
			EcoreUtil.remove(connection);
		}
		else {
			connection.setStart(anchors[0]);
			connection.setEnd(anchors[1]);
			
			createGraphicsAlgorithm(connection);
			createDecorators(connection, fs);
		}
		
		return true;
	}
}
