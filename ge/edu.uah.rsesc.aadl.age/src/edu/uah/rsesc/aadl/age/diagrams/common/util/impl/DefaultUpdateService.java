package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Feature;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.util.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

public class DefaultUpdateService implements UpdateService {
	private final StyleService styleUtil;
	private final VisibilityService visibilityHelper;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultUpdateService(final StyleService styleUtil, final VisibilityService visibilityHelper, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.styleUtil = styleUtil;
		this.visibilityHelper = visibilityHelper;
		this.bor = bor;
		this.fp = fp;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService#ghostInvalidShapes(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */	
	@Override
	public void ghostInvalidShapes(final ContainerShape shape) {
		for(final Shape childShape : shape.getChildren()) {
			// Check if the shape has a business object and can be updated
			final Object bo = bor.getBusinessObjectForPictogramElement(childShape);
			final UpdateContext updateContext = new UpdateContext(childShape);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Determine whether to ghost the shape
			boolean ghost = false;
			if(bo == null || updateFeature == null || (updateFeature != null && !updateFeature.canUpdate(updateContext))) {
				ghost = true;
			} else {
				EObject emfBusinesObject = (EObject)bo;
				if(emfBusinesObject.eIsProxy()) {
					emfBusinesObject = EcoreUtil.resolve(emfBusinesObject, OsateResourceUtil.getResourceSet());
				}
	
				if(emfBusinesObject.eIsProxy()) {
					ghost = true;
				}
			}
			
			// Ghost the shape
			if(ghost) {
				visibilityHelper.setIsGhost(childShape, true);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService#layoutChildren(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public void layoutChildren(final ContainerShape shape) {
		// Layout the children first
		for(final Shape child : visibilityHelper.getNonGhostChildren(shape)) {
			final LayoutContext ctx = new LayoutContext(child);
			final ILayoutFeature feature = fp.getLayoutFeature(ctx);
			if(feature != null && feature.canLayout(ctx)) {
				feature.layout(ctx);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService#removeConnectionsByAnchorParent(org.eclipse.graphiti.mm.pictograms.Diagram, org.eclipse.graphiti.mm.pictograms.PictogramElement)
	 */
	@Override
	public void removeConnectionsByAnchorParent(final Diagram diagram, final PictogramElement anchorParent) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : diagram.getConnections()) {
			boolean remove = false;
			
			if((connection.getStart() != null && connection.getStart().getParent() == anchorParent) ||
					(connection.getEnd() != null && connection.getEnd().getParent() == anchorParent)) {
				remove = true;
				break;
			}

			if(remove) {
				connectionsToRemove.add(connection);
			}
		}
		
		// Remove the connections
		for(final Connection connection : connectionsToRemove) {
			EcoreUtil.delete(connection, true);
		}		
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService#ghostInvalidConnections(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public void ghostInvalidConnections(final Diagram diagram) {
		for(final Connection connection : diagram.getConnections()) {
			final Object bo = bor.getBusinessObjectForPictogramElement(connection);
			if(!(bo instanceof EObject)) {
				visibilityHelper.setIsGhost(connection, true);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService#removeAnchorsWithoutConnections(org.eclipse.graphiti.mm.pictograms.Shape)
	 */
	@Override
	public void removeAnchorsWithoutConnections(final Shape shape) {
		// Remove anchors that don't have an incoming or outgoing connection
		final Iterator<Anchor> it = shape.getAnchors().iterator();
		while(it.hasNext()) {
			final Anchor anchor = it.next();
			if(anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size() == 0) {
				it.remove();
			}
		}
	}	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService#refreshStyles(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public void refreshStyles(final Diagram diagram) {
		// Remove all styles. Styles will be recreated as needed
		diagram.getStyles().clear();	
				
		// Refresh shape styles
		refreshStyles(diagram, diagram);
		
		// Refresh connection styles
		for(final Connection connection : diagram.getConnections()) {
			refreshStyles(diagram, connection);
		}
	}

	private void refreshStyles(final Diagram diagram, final Shape shape) {
		refreshStyles(diagram, shape.getGraphicsAlgorithm());
		
		// Refresh the style of child shapes
		if(shape instanceof ContainerShape) {
			for(final Shape child : ((ContainerShape)shape).getChildren()) {
				refreshStyles(diagram, child);
			}	
		}
		
		// Refresh the styles for the anchors
		for(final Anchor anchor : shape.getAnchors()) {
			refreshStyles(diagram, anchor.getGraphicsAlgorithm());
		}
	}
	
	private void refreshStyles(final Diagram diagram, final Connection connection) {
		refreshStyles(diagram, connection.getGraphicsAlgorithm());
		
		// Refresh the style for the decorators
		for(final ConnectionDecorator cd : connection.getConnectionDecorators()) {
			refreshStyles(diagram, cd);
		}
	}
	
	private void refreshStyles(final Diagram diagram, final GraphicsAlgorithm ga) {
		// Get an updated version of the current style
		if(ga != null) {
			final Style oldStyle = ga.getStyle();
			if(oldStyle != null) {
				final String styleId = ga.getStyle().getId();
				final Style style = styleUtil.getStyle(diagram, styleId);

				// Set the style
				ga.setStyle(style);
			}
			
			// Handle children
			for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				refreshStyles(diagram, childGa);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#adjustChildShapePositions(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public int[] adjustChildShapePositions(final ContainerShape shape) {	
		// Determine the extra width needed to hold AADL features
		int featureWidth = 80;
		for(final Shape childShape : shape.getChildren()) {
			if(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth()) + 30;
			}
		}		
		
		// Determine how much to shift the X and Y of the children by
		int shiftX = 0;
		int shiftY = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			if(!(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature)) {				
				shiftX = Math.min(shiftX, childGa.getX()-featureWidth);
				shiftY = Math.min(shiftY, childGa.getY()-30);				
			}
		}
		
		// Calculate max width and height
		int maxWidth = 300;
		int maxHeight = 300;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Determine the needed width and height of the classifier shape
			// Do not consider features when calculating needed width. Otherwise, features on the right side of the shape would prevent the width from shrinking
			if(!(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature)) {				
				maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() - shiftX + featureWidth);
			}			
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() - shiftY);
			
			// Update the position of the child
			childGa.setX(childGa.getX()-shiftX);
			childGa.setY(childGa.getY()-shiftY);
		}
		
		return new int[] { maxWidth, maxHeight+25};
	}
}
