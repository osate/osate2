package edu.uah.rsesc.aadl.age.diagrams.common.util;

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
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class UpdateHelper {
	/**
	 * Removes invalid shapes from a diagram. An invalid shape is defined as a top level shape that is not associated with a business object or can not be updated
	 * @param diagram
	 * @param fp
	 */	
	public static void removeInvalidShapes(final ContainerShape shape, final IFeatureProvider fp) {	
		final List<Shape> shapesToRemove = new ArrayList<Shape>();		
		for(final Shape childShape : shape.getChildren()) {
			// Check if the shape has a business object and can be updated
			final Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(childShape));
			final UpdateContext updateContext = new UpdateContext(childShape);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			if(bo == null || updateFeature == null || (updateFeature != null && !updateFeature.canUpdate(updateContext))) {
				shapesToRemove.add(childShape);
			} else {
				EObject emfBusinesObject = (EObject)bo;
				if(emfBusinesObject.eIsProxy()) {
					emfBusinesObject = EcoreUtil.resolve(emfBusinesObject, OsateResourceUtil.getResourceSet());
				}
	
				if(emfBusinesObject.eIsProxy()) {
					shapesToRemove.add(childShape);
				}
			}
		}
		
		for(final Shape childShape : shapesToRemove) {
			EcoreUtil.delete(childShape, true);			
		}
	}
	
	public static void layoutChildren(final ContainerShape shape, final IFeatureProvider fp) {
		// Layout the children first
		for(final Shape child : shape.getChildren()) {
			final LayoutContext ctx = new LayoutContext(child);
			final ILayoutFeature feature = fp.getLayoutFeature(ctx);
			if(feature != null && feature.canLayout(ctx)) {
				feature.layout(ctx);
			}
		}
	}
	
	public static void removeConnectionsByAnchorParent(final Diagram diagram, final PictogramElement anchorParent) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : diagram.getConnections()) {
			// TODO: Test in circumstances where this is necessary
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
	
	/**
	 * Removes connections that are invalid. Such as ones that do not have a valid business object associated with them.
	 * @param diagram
	 * @param fp
	 */
	// TODO: Remove the mode handling when modes are supported fully
	public static void removeInvalidConnections(final Diagram diagram, final IFeatureProvider fp) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : diagram.getConnections()) {
			final Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(connection));
			boolean remove = false;
			if(!(bo instanceof EObject)) {
				// Remove the object if the business object was not an EObject
				remove = true;
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
	
	/**
	 * Removes anchors from a shape if they do not have connections. Not recursive.
	 * @param shape
	 */
	public static void removeAnchorsWithoutConnections(final Shape shape) {
		// Remove anchors that don't have an incoming or outgoing connection
		final Iterator<Anchor> it = shape.getAnchors().iterator();
		while(it.hasNext()) {
			final Anchor anchor = it.next();
			if(anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size() == 0) {
				it.remove();
			}
		}
	}
	
	
	/**
	 * Refresh styles used by all the diagrams. Removes all styles from the diagram and then finds any usage of styles and reset them.
	 * @param diagram
	 */
	public static void refreshStyles(final Diagram diagram) {
		// Remove all styles. Styles will be recreated as needed
		diagram.getStyles().clear();	
				
		// Refresh shape styles
		refreshStyles(diagram, diagram);
		
		// Refresh connection styles
		for(final Connection connection : diagram.getConnections()) {
			refreshStyles(diagram, connection);
		}
	}

	private static void refreshStyles(final Diagram diagram, final Shape shape) {
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
	
	private static void refreshStyles(final Diagram diagram, final Connection connection) {
		refreshStyles(diagram, connection.getGraphicsAlgorithm());
		
		// Refresh the style for the decorators
		for(final ConnectionDecorator cd : connection.getConnectionDecorators()) {
			refreshStyles(diagram, cd);
		}
	}
	
	private static void refreshStyles(final Diagram diagram, final GraphicsAlgorithm ga) {
		// Get an updated version of the current style
		if(ga != null) {
			final Style oldStyle = ga.getStyle();
			if(oldStyle != null) {
				final String styleId = ga.getStyle().getId();
				final Style style = StyleUtil.getStyle(diagram, styleId);

				// Set the style
				ga.setStyle(style);
			}
			
			// Handle children
			for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				refreshStyles(diagram, childGa);
			}
		}
	}
}
