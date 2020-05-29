/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.graphiti.diagram;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
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

import com.google.common.base.Strings;

class AnchorUtil {
	private static final String FLOW_INDICATOR_ANCHOR_NAME_PREFIX = "fia_";

	// All items are static
	private AnchorUtil() {
	}

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
	 * Get the anchor used for the end of flow indicators. Creates it it does not exist
	 * @param anchorOwner the owner for the flow indicator anchor.
	 * @param flowIndicatorDiagramElement the diagram element which is represented by a flow indicator
	 * @param x the new x position of the anchor.
	 * @param y the new y position of the anchor.
	 * @return is the anchor to use for the end of the flow indicator
	 */
	public static Anchor getOrCreateFlowIndicatorAnchor(final AnchorContainer anchorOwner,
			final DiagramElement flowIndicatorDiagramElement,
			final int x, final int y) {
		return AnchorUtil.createOrUpdateFixPointAnchor(anchorOwner,
				getFlowIndicatorAnchorName(flowIndicatorDiagramElement), x,
				y, false);
	}

	private static String getFlowIndicatorAnchorName(final DiagramElement flowDiagramElement) {
		return FLOW_INDICATOR_ANCHOR_NAME_PREFIX + flowDiagramElement.getId().toString();
	}

	public static boolean isFlowIndicatorAnchor(final Anchor a) {
		return Strings.nullToEmpty(PropertyUtil.getName(a)).startsWith(FLOW_INDICATOR_ANCHOR_NAME_PREFIX);
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

	private static String getUniqueReference(final DiagramElement element) {
		String result = "";
		for(DiagramNode t = element; t != null; t = t.getContainer()) {
			if(t instanceof DiagramElement) {
				result += "/" + ((DiagramElement) t).getRelativeReference().toString();
			}
		}

		return result;
	}

	// This code is based on getConnectionMidpoint from Graphiti's PeSeviceImpl
	// Forked to work around issue: https://bugs.eclipse.org/bugs/show_bug.cgi?id=529378
	// Once the Graphiti issue is resolved and in the releases used by OSATE, switch the implemented to this function to delegate to Graphiti's PeService
	private static Point getConnectionMidpoint(Connection c, double d) {
		final IPeService peService = Graphiti.getPeService();
		Point ret = null;

		Anchor startAnchor = c.getStart();
		ILocation startLocation = peService.getLocationRelativeToDiagram(startAnchor);
		java.awt.Point startPoint = new java.awt.Point(startLocation.getX(), startLocation.getY());

		Anchor endAnchor = c.getEnd();
		ILocation endLocation = peService.getLocationRelativeToDiagram(endAnchor);
		java.awt.Point endPoint = new java.awt.Point(endLocation.getX(), endLocation.getY());

		// special solutions for chopbox anchors
		if (startAnchor instanceof ChopboxAnchor || endAnchor instanceof ChopboxAnchor) {
			if (startAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbStartAnchor = (ChopboxAnchor) startAnchor;
				GraphicsAlgorithm parentGa = cbStartAnchor.getParent().getGraphicsAlgorithm();
				Shape shape = (Shape) cbStartAnchor.getParent();
				ILocation location = peService.getLocationRelativeToDiagram(shape);
				java.awt.Rectangle parentRect = new java.awt.Rectangle(location.getX(), location.getY(),
						parentGa.getWidth(), parentGa.getHeight());

				java.awt.Point pointNextToStartAnchor = new java.awt.Point(endPoint.x, endPoint.y);

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List<org.eclipse.graphiti.mm.algorithms.styles.Point> bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						org.eclipse.graphiti.mm.algorithms.styles.Point firstBendpoint = bendpoints.get(0);
						pointNextToStartAnchor.setLocation(firstBendpoint.getX(), firstBendpoint.getY());
					}
				}

				java.awt.Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToStartAnchor, parentRect);
				startPoint.setLocation(chopboxLocationOnBox);
			}

			if (endAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbEndAnchor = (ChopboxAnchor) endAnchor;
				GraphicsAlgorithm parentGa = cbEndAnchor.getParent().getGraphicsAlgorithm();
				Shape shape = (Shape) cbEndAnchor.getParent();
				ILocation location = peService.getLocationRelativeToDiagram(shape);
				java.awt.Rectangle parentRect = new java.awt.Rectangle(location.getX(), location.getY(),
						parentGa.getWidth(), parentGa.getHeight());

				java.awt.Point pointNextToEndAnchor = new java.awt.Point(startPoint.x, startPoint.y);

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List<org.eclipse.graphiti.mm.algorithms.styles.Point> bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						org.eclipse.graphiti.mm.algorithms.styles.Point lastBendpoint = bendpoints
								.get(bendpoints.size() - 1);
						pointNextToEndAnchor.setLocation(lastBendpoint.getX(), lastBendpoint.getY());
					}
				}

				java.awt.Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToEndAnchor, parentRect);
				endPoint.setLocation(chopboxLocationOnBox);
			}
		}

		if (c instanceof FreeFormConnection) {
			FreeFormConnection ffc = (FreeFormConnection) c;
			List<org.eclipse.graphiti.mm.algorithms.styles.Point> bendpoints = ffc.getBendpoints();

			java.awt.Point[] awtPointsArray = new java.awt.Point[bendpoints.size() + 2];
			{
				awtPointsArray[0] = startPoint;
				int i = 1;
				for (Iterator<org.eclipse.graphiti.mm.algorithms.styles.Point> iter = bendpoints.iterator(); iter
						.hasNext();) {
					org.eclipse.graphiti.mm.algorithms.styles.Point pictogramsPoint = iter.next();
					awtPointsArray[i] = new java.awt.Point(pictogramsPoint.getX(), pictogramsPoint.getY());
					i++;
				}
				awtPointsArray[i] = endPoint;
			}

			double completeDistance = getDistance(awtPointsArray);
			double absDistanceToRelPoint = completeDistance * d;

			double distanceSum = 0;
			for (int i = 0; i < awtPointsArray.length - 1; i++) {
				double oldDistanceSum = distanceSum;
				java.awt.Point currentPoint = awtPointsArray[i];
				java.awt.Point nextPoint = awtPointsArray[i + 1];
				double additionalDistanceToNext = getDistance(currentPoint, nextPoint);
				distanceSum += additionalDistanceToNext;
				if (distanceSum >= absDistanceToRelPoint) {
					double thisRelative = ((completeDistance * d) - oldDistanceSum) / additionalDistanceToNext;
					ret = getMidpoint(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y, thisRelative);
					break; // or return ret;
				}
			}
		} else {
			int midX = (int) Math.round((startPoint.x + d * (endPoint.x - startPoint.x)));
			int midY = (int) Math.round((startPoint.y + d * (endPoint.y - startPoint.y)));
			ret = new Point(midX, midY);
		}
		return ret;
	}

	private static double getDistance(java.awt.Point start, java.awt.Point end) {
		int xDist = end.x - start.x;
		int yDist = end.y - start.y;
		double ret = Math.sqrt((xDist * xDist) + (yDist * yDist));
		return ret;
	}

	private static double getDistance(java.awt.Point[] points) {
		double ret = 0;
		for (int i = 0; i < points.length - 1; i++) {
			java.awt.Point currentPoint = points[i];
			java.awt.Point nextPoint = points[i + 1];
			ret += getDistance(currentPoint, nextPoint);
		}
		return ret;
	}

	private static Point getMidpoint(int startX, int startY, int endX, int endY, double d) {
		int midX = (int) Math.round((startX + d * (endX - startX)));
		int midY = (int) Math.round((startY + d * (endY - startY)));
		return new Point(midX, midY);
	}

	private static java.awt.Point getChopboxLocationOnBox(java.awt.Point outsidePoint, java.awt.Rectangle box) {
		java.awt.Rectangle r = new java.awt.Rectangle(box.x - 1, box.y - 1, box.width + 1, box.height + 1);

		float centerX = r.x + 0.5f * r.width;
		float centerY = r.y + 0.5f * r.height;

		if (r.isEmpty() || (outsidePoint.x == (int) centerX && outsidePoint.y == (int) centerY)) {
			return new java.awt.Point((int) centerX, (int) centerY); // This
			// avoids
			// divide-by-zero
		}

		float dx = outsidePoint.x - centerX;
		float dy = outsidePoint.y - centerY;

		// r.width, r.height, dx, and dy are guaranteed to be non-zero.
		float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);

		dx *= scale;
		dy *= scale;
		centerX += dx;
		centerY += dy;

		return new java.awt.Point(Math.round(centerX), Math.round(centerY));
	}
}
