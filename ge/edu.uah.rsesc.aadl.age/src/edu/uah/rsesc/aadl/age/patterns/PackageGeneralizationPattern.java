package edu.uah.rsesc.aadl.age.patterns;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;

import edu.uah.rsesc.aadl.age.diagram.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class PackageGeneralizationPattern extends AbstractConnectionPattern implements IConnectionPattern, ICustomUndoablePattern {
	
	@Override
	public boolean canAdd(IAddContext context) {
		final Object unwrappedObj = AadlElementWrapper.unwrap(context.getNewObject());
        if(context instanceof IAddConnectionContext && 
        		(unwrappedObj instanceof Realization || 
    				unwrappedObj instanceof TypeExtension || 
    				unwrappedObj instanceof ImplementationExtension ||
    				unwrappedObj instanceof GroupExtension)) {
            return true;
        }

        return false;
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
 
        final IGaService gaService = Graphiti.getGaService();
        final Polyline polyline = gaService.createPlainPolyline(connection);
        final boolean isImplements = addedGeneralization instanceof Realization;
        final Style style = isImplements ? StyleUtil.getImplementsStyle(diagram) : StyleUtil.getExtendsStyle(diagram);
        polyline.setStyle(style);

        // Create the arrow
        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.0, true);    
        createArrow(arrowConnectionDecorator, StyleUtil.getGeneralizationArrowHeadStyle(diagram));
		return connection;
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
	public boolean canUndo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void undo(final IFeature feature, final IContext context) {
	}

	@Override
	public boolean canRedo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void redo(final IFeature feature, final IContext context) {
	}
}
