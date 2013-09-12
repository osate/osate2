package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

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
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.FlowSpecification;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.HighlightingHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;

// TODO: Update styles, etc
public class FlowSpecificationPattern extends AgeConnectionPattern {
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof FlowSpecification;
	}

	@Override
	public PictogramElement add(final IAddContext context) {
		final IAddConnectionContext addConContext = (IAddConnectionContext)context;
        final FlowSpecification fs = (FlowSpecification)AadlElementWrapper.unwrap(context.getNewObject());
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final Diagram diagram = getDiagram();
        
        // Create the connection
        final Connection connection = peCreateService.createFreeFormConnection(diagram);
        link(connection, new AadlElementWrapper(fs));

        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        createGraphicsAlgorithm(connection);
        createDecorators(connection);
        
		return connection;
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final FlowSpecification fs = getFlowSpecification(connection);
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
		
		switch(fs.getKind()) {
		case PATH:
			{
				// Create the arrow
		        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);    
		        createArrow(arrowConnectionDecorator, StyleUtil.getDecoratorStyle(getDiagram()));	
				break;
			}
			
		case SOURCE:
			{
				final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
				createArrow(arrowConnectionDecorator, StyleUtil.getDecoratorStyle(getDiagram()));
				final ConnectionDecorator vbarConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
				createVbar(vbarConnectionDecorator, StyleUtil.getDecoratorStyle(getDiagram()));	
				break;
			}
			
		case SINK:
			{
				final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
				GraphicsAlgorithmUtil.mirror(createArrow(arrowConnectionDecorator, StyleUtil.getDecoratorStyle(getDiagram())));
				final ConnectionDecorator vbarConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
				createVbar(vbarConnectionDecorator, StyleUtil.getDecoratorStyle(getDiagram()));	
				break;
			}
		}
		
		// Set color for the decorators
		for(final ConnectionDecorator cd : connection.getConnectionDecorators()) {
			HighlightingHelper.highlight(getDiagram(), fs, cd.getGraphicsAlgorithm(), getFeatureProvider());
		}
		
		// Create Label
		final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(StyleUtil.getLabelStyle(getDiagram()));
		gaService.setLocation(text, labelX, labelY);
	    text.setValue(fs.getName());
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final FlowSpecification fs = getFlowSpecification(connection);
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = StyleUtil.getFlowSpecificationStyle(getDiagram());
		polyline.setStyle(style);
		HighlightingHelper.highlight(getDiagram(), fs, polyline, getFeatureProvider());
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
	
	final FlowSpecification getFlowSpecification(final Connection connection) {
		return (FlowSpecification)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
	}
	
	@Override
	protected Anchor[] getAnchors(final Connection connection) {
		final FlowSpecification fs = getFlowSpecification(connection);
		final ContainerShape ownerShape = ConnectionHelper.getFlowSpecificationOwnerShape(connection, getFeatureProvider());
		return (ownerShape == null) ? null : AnchorUtil.getAnchorsForFlowSpecification(fs, ownerShape, getFeatureProvider());		
	}
}
