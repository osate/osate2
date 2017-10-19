package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
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
		final ILocation midpoint = layoutService.getConnectionMidpoint(connection, d);
		return new Point(midpoint.getX(), midpoint.getY());
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
