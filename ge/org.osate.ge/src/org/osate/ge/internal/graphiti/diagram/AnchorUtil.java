package org.osate.ge.internal.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.PrecisionPoint;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILayoutService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

class AnchorUtil {	
	public static ChopboxAnchor createOrUpdateChopboxAnchor(final AnchorContainer container) {
		final IPeService peService = Graphiti.getPeService();
		final Anchor retrievedAnchor = peService.getChopboxAnchor(container);

		if(retrievedAnchor != null) {
			return (ChopboxAnchor)retrievedAnchor;
		}
		
		return peService.createChopboxAnchor(container);
	}
	
	public static FixPointAnchor createOrUpdateFixPointAnchor(final AnchorContainer shape, final String name, final int x, final int y, boolean updateOnly) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		// Create or get the anchor by name
		final Anchor retrievedAnchor = getAnchorByName(shape, name);
		final FixPointAnchor anchor;
		if(retrievedAnchor == null) {
			if(updateOnly) {
				return null;
			}
			
			anchor = peCreateService.createFixPointAnchor(shape);
			PropertyUtil.setName(anchor, name);
			// Theoretically this could be done for the retrieved anchor as well to ensure it has the proper graphical algorithm. Practically it causes problem for Graphiti
			// for an unknown reason when moving feature groups. We do it only when creating the anchor for that reason
			gaService.createInvisibleRectangle(anchor);
		} else {
			if(!(retrievedAnchor instanceof FixPointAnchor)) {
				throw new RuntimeException("Retrieved anchor is of invalid type: " + retrievedAnchor.getClass().getName());	
			}
			
			anchor = (FixPointAnchor)retrievedAnchor;
		}

		// Configure the anchor
        anchor.setLocation(gaService.createPoint(x, y));
        anchor.setUseAnchorLocationAsConnectionEndpoint(true);
        
        return anchor;
	}
	
	public static Anchor getAnchorByName(final PictogramElement pe, final String name) {
		if(pe instanceof AnchorContainer) {
			for(final Anchor anchor : ((AnchorContainer)pe).getAnchors()) {
				if(name.equals(PropertyUtil.getName(anchor))) {
					return anchor;
				}
			}	
		}

		return null;
	}
	
	/**
	 * Updates the connection anchors for connections that are connected by a specified shape.
	 * @param shape
	 * @param diagramNodeProvider
	 */
	public static void updateConnectionAnchors(final Shape shape, final NodePictogramBiMap diagramNodeProvider) {
		// This is needed to update connection anchors for connections which are not owned by any of elements involved in the connection.
		for(final Anchor anchor : shape.getAnchors()) {
			for(final Connection connection : anchor.getIncomingConnections()) {
				updateConnectionAnchor((DiagramElement)diagramNodeProvider.getDiagramNode(connection), connection, diagramNodeProvider);
			}
			
			for(final Connection connection : anchor.getOutgoingConnections()) {
				updateConnectionAnchor((DiagramElement)diagramNodeProvider.getDiagramNode(connection), connection, diagramNodeProvider);
			}
		}
	}
	
	private static Shape getConnectionAnchorContainer(final DiagramElement connectionDiagramElement, final NodePictogramBiMap mapping) {
		if(connectionDiagramElement == null) {
			return null;
		}
		
		// Get the first non-connection owner
		Shape containerShape = null;		
		for(DiagramNode tmpDe = connectionDiagramElement.getContainer(); tmpDe != null; tmpDe = tmpDe.getContainer()) {
			final PictogramElement pe = mapping.getPictogramElement(tmpDe);
			if(pe == null) {
				break;
			} else if(pe instanceof Shape) {
				containerShape = (Shape)pe;
			}
		}

		if(containerShape == null) {
			return null;
		}
		
		return containerShape;
	}
	
	private static String getConnectionAnchorName(final DiagramElement connectionElement) {
		return getUniqueReference(connectionElement);
	}
	
	/**
	 * Gets the connection anchor for a specified connection. Creates a new anchor and initializes it as necessary.
	 * @param connectionDiagramElement
	 * @param connection
	 * @param mapping
	 * @return
	 */
	public static Anchor getOrCreateConnectionAnchor(final DiagramElement connectionDiagramElement, final Connection connection, final NodePictogramBiMap mapping) {
		final Shape containerShape = getConnectionAnchorContainer(connectionDiagramElement, mapping);
		final String anchorName = getConnectionAnchorName(connectionDiagramElement);
		if(anchorName == null) {
			return null;
		}
		
		Anchor retrievedAnchor = getAnchorByName(containerShape, anchorName);
		if(retrievedAnchor != null) {
			return retrievedAnchor;
		}
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		FixPointAnchor newAnchor = peCreateService.createFixPointAnchor(containerShape);
		PropertyUtil.setName(newAnchor, anchorName);	
		
		// Theoretically this could be done for the retrieved anchor as well to ensure it has the proper graphical algorithm. Practically it causes problem for Graphiti
		// for an unknown reason when moving feature groups. We do it only when creating the anchor for that reason
		gaService.createInvisibleRectangle(newAnchor);
		
		// Configure the anchor
		newAnchor.setLocation(gaService.createPoint(0, 0));
        newAnchor.setUseAnchorLocationAsConnectionEndpoint(true);

		return newAnchor;
	}	
			
	public static Anchor updateConnectionAnchor(final DiagramElement connectionDiagramElement, final Connection connection, final NodePictogramBiMap mapping) {
		final Shape containerShape = getConnectionAnchorContainer(connectionDiagramElement, mapping);
		final String anchorName = getConnectionAnchorName(connectionDiagramElement);
		if(anchorName == null) {
			return null;
		}
		
		final Anchor retrievedAnchor = getAnchorByName(containerShape, anchorName);
		if(!(retrievedAnchor instanceof FixPointAnchor)) {
			return null;
		}
		
		final FixPointAnchor fpa = (FixPointAnchor)retrievedAnchor;		
		final ILayoutService layoutService = Graphiti.getLayoutService();
		final ILocation ownerLocation = layoutService.getLocationRelativeToDiagram(containerShape);
		final Point connectionMidpoint = getConnectionMidpoint(connection, 0.5);
		if(connectionMidpoint == null) {
			return null;
		}
		
		// Configure the anchor
		final int anchorX = connectionMidpoint.x - ownerLocation.getX();
		final int anchorY = connectionMidpoint.y - ownerLocation.getY();	
        fpa.setLocation(Graphiti.getGaService().createPoint(anchorX, anchorY));
        fpa.setUseAnchorLocationAsConnectionEndpoint(true);
		
		return retrievedAnchor;
	}
	
	private static Point getConnectionMidpoint(final Connection connection, final double d) {
		final ILayoutService layoutService = Graphiti.getLayoutService();
		
		// The layout service's getConnectionMidpoint() method doesn't seem to work properly unless the connection is a freeform connection with at least one bendpoints
		if(connection instanceof FreeFormConnection && ((FreeFormConnection) connection).getBendpoints().size() > 0) {
			final ILocation midpoint = layoutService.getConnectionMidpoint(connection, d);
			return new Point(midpoint.getX(), midpoint.getY());
		}
		
		final Shape startShape = (Shape)connection.getStart().getParent();
		final Shape endShape = (Shape)connection.getEnd().getParent();
		final ILocation startShapeLocation = layoutService.getLocationRelativeToDiagram(startShape);
		final ILocation endShapeLocation = layoutService.getLocationRelativeToDiagram(endShape);
		
		final GraphicsAlgorithm startShapeGa = startShape.getGraphicsAlgorithm();
		final GraphicsAlgorithm endShapeGa = endShape.getGraphicsAlgorithm();
		
		final Rectangle startShapeRect = new Rectangle(startShapeLocation.getX(), startShapeLocation.getY(), startShapeGa.getWidth(), startShapeGa.getHeight());
		final Rectangle endShapeRect = new Rectangle(endShapeLocation.getX(), endShapeLocation.getY(), endShapeGa.getWidth(), endShapeGa.getHeight());
		
		// Find a point on the the line
		if(connection instanceof CurvedConnection) {			
			final Point startPoint = new Point(startShapeLocation.getX() + startShapeRect.width/2, startShapeLocation.getY() + startShapeRect.height/2);
			final Point endPoint = new Point(endShapeLocation.getX() + endShapeRect.width/2, endShapeLocation.getY() + endShapeRect.height/2);
	
			final CurvedConnection cc = (CurvedConnection)connection;
			final BezierRouter router = new BezierRouter(cc.getControlPoints());
			final List<org.eclipse.draw2d.geometry.PrecisionPoint> altResults = router.route(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			
			// Not technically the midpoint but in practice the point is a reasonable substitute
			final org.eclipse.draw2d.geometry.PrecisionPoint altPoint = altResults.get(altResults.size()/2-2);
			return new Point(altPoint.x, altPoint.y);
		} else { // Assume that the connection does not have any bendpoints
			final ILocation startLoc = layoutService.getLocationRelativeToDiagram(connection.getStart());
			final ILocation endLoc = layoutService.getLocationRelativeToDiagram(connection.getEnd());
		
			return new Point((int)(startLoc.getX() + (endLoc.getX() - startLoc.getX()) * d), (int)(startLoc.getY() + (endLoc.getY() - startLoc.getY()) * d));
		}
	}	
	
	// Copied and adapted from: org.eclipse.graphiti.ui.internal.parts.CurvedConnectionEditPart.BezierRouter
	private static class BezierRouter {
		private List<PrecisionPoint> bezierPoints;

		public BezierRouter(List<PrecisionPoint> bezierPoints) {
			this.bezierPoints = bezierPoints;
		}

		public List<org.eclipse.draw2d.geometry.PrecisionPoint> route(final int startX, final int startY, final int endX, final int endY) {
			final List<org.eclipse.draw2d.geometry.PrecisionPoint> points = new ArrayList<org.eclipse.draw2d.geometry.PrecisionPoint>();
			List<org.eclipse.draw2d.geometry.PrecisionPoint> controllPoints = new ArrayList<org.eclipse.draw2d.geometry.PrecisionPoint>();
			org.eclipse.draw2d.geometry.PrecisionPoint start = new org.eclipse.draw2d.geometry.PrecisionPoint();
			org.eclipse.draw2d.geometry.PrecisionPoint end = new org.eclipse.draw2d.geometry.PrecisionPoint();
			start.setLocation(startX, startY);
			end.setLocation(endX, endY);
			controllPoints.add(start);
			double gradient = (end.preciseY() - start.preciseY()) / (-end.preciseX() + start.preciseX());
			double ortho_gradient = -Math.pow(gradient, -1);
			double orthovector_x = 1;
			double orthovector_y = ortho_gradient;
			double factor_to_length = 1 / Math.sqrt((Math.pow(orthovector_y, 2) + Math.pow(orthovector_x, 2)));
			for (PrecisionPoint precisionPoint : this.bezierPoints) {

				double orthovector_x_cp = factor_to_length * orthovector_x * precisionPoint.getY();
				double orthovector_y_cp = factor_to_length * orthovector_y * precisionPoint.getY();
				if (Double.isNaN(orthovector_x_cp)) {
					orthovector_x_cp = 0;
				}
				if (Double.isNaN(orthovector_y_cp)) {
					orthovector_y_cp = 1 * precisionPoint.getY();
				}
				org.eclipse.draw2d.geometry.PrecisionPoint anchor = new org.eclipse.draw2d.geometry.PrecisionPoint(
						(start.x + (end.x - start.x) * precisionPoint.getX() - orthovector_x_cp),
						(start.y - (start.y - end.y) * precisionPoint.getX()) + orthovector_y_cp);

				controllPoints.add(anchor);
			}
			controllPoints.add(end);
			int precision = 10;
			double factor = 1.0d / precision;
			points.add(start);
			for (int i = 1; i < precision; i++) {
				int j = 0;
				double sum_x = 0;
				double sum_y = 0;
				for (Point point : controllPoints) {
					sum_x += (bezier(j, controllPoints.size() - 1, i * factor) * point.preciseX());
					sum_y += (bezier(j, controllPoints.size() - 1, i * factor) * point.preciseY());
					j++;
				}
				org.eclipse.draw2d.geometry.PrecisionPoint bezierPoint = new org.eclipse.draw2d.geometry.PrecisionPoint(
						sum_x, sum_y);
				points.add(bezierPoint);
			}
			points.add(end);
			
			return points;
		}

		private double bezier(int i, int n, double t) {
			return binomialCoefficients(n, i) * Math.pow(t, i) * Math.pow((1 - t), (n - i));
		}

		private long binomialCoefficients(int n, int k) {
			long coeff = 1;
			for (int i = n - k + 1; i <= n; i++) {
				coeff *= i;
			}
			for (int i = 1; i <= k; i++) {
				coeff /= i;
			}
			return coeff;
		}
	}
	
	private static String getUniqueReference(final DiagramElement element) {
		String result = "";
		for(DiagramNode t = element; t != null; t = t.getContainer()) {
			if(t instanceof DiagramElement) {
				result += "/" + ((DiagramElement) t).getRelativeReference().toString();
			}
		}
		
		return result;
	}
}
