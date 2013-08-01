package edu.uah.rsesc.aadl.age.diagrams.pkg.patterns;

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
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class PackageGeneralizationPattern extends AgeConnectionPattern {
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object unwrappedObj = AadlElementWrapper.unwrap(mainBusinessObject);
		return (unwrappedObj instanceof Realization || 
    				unwrappedObj instanceof TypeExtension || 
    				unwrappedObj instanceof ImplementationExtension ||
    				unwrappedObj instanceof GroupExtension);
	}

	@Override
	public PictogramElement add(IAddContext context) {
		final IAddConnectionContext addConContext = (IAddConnectionContext)context;
        final Generalization addedGeneralization = (Generalization)AadlElementWrapper.unwrap(context.getNewObject());
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final Diagram diagram = getDiagram();
        
        // Create the implements connection
        final Connection connection = peCreateService.createFreeFormConnection(diagram);
        link(connection, new AadlElementWrapper(addedGeneralization));

        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        createGraphicsAlgorithm(connection, addedGeneralization);
        createDecorators(connection);
        
		return connection;
	}
	
	private void createDecorators(final Connection connection) {
		connection.getConnectionDecorators().clear();
		
		// Create the arrow
        final ConnectionDecorator arrowConnectionDecorator = Graphiti.getPeCreateService().createConnectionDecorator(connection, false, 0.0, true);    
        createArrow(arrowConnectionDecorator, StyleUtil.getGeneralizationArrowHeadStyle(getDiagram()));
	}
	
	private void createGraphicsAlgorithm(final Connection connection, final Generalization generalization) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final boolean isImplements = generalization instanceof Realization;
		final Style style = isImplements ? StyleUtil.getImplementsStyle(getDiagram()) : StyleUtil.getExtendsStyle(getDiagram());
		polyline.setStyle(style);
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-15, 10, 
	    		0, 0, 
	    		-15, -10});
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
		final Generalization generalization = (Generalization)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
		
		// Update the anchors
		final Anchor[] anchors = AnchorUtil.getAnchorsForGeneralization(generalization, getFeatureProvider());
		connection.setStart(anchors[0]);
		connection.setEnd(anchors[1]);
				
		createGraphicsAlgorithm(connection, generalization);
		createDecorators(connection);
		
		return true;
	}
}
