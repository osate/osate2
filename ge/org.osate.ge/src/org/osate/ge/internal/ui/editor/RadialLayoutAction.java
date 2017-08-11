package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.Point;

public class RadialLayoutAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public static final String RADIAL_LAYOUT = "org.osate.ge.ui.editor.items.radial_layout";
	public static final ImageDescriptor radialImageDescriptor = Activator.getImageDescriptor("icons/RadialLayout.gif");
	public static final ImageDescriptor radialDisabledImageDescriptor = Activator.getImageDescriptor("icons/RadialLayout_Disabled.gif");

	public RadialLayoutAction(final IWorkbenchPart part) {
		super(part); 
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(radialImageDescriptor);
		setDisabledImageDescriptor(radialDisabledImageDescriptor);
		setId(RADIAL_LAYOUT);
	}

	/**
	 * Updates whether action is available based on if shapes selected are valid
	 */
	@Override
	protected boolean calculateEnabled() {
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		if(selectedDiagramElements == null) {
			return false;
		}
		
		if(selectedDiagramElements.size() < 2) {
			return false;
		}
		
		if(!ContributionHelper.allHaveSameParent(selectedDiagramElements)) {
			return false;
		}
		
		return selectedDiagramElements.stream().allMatch(RadialLayoutAction::isSupported);
	}

	private static boolean isSupported(final DiagramElement de) {
		return DiagramElementPredicates.isUndocked(de) && DiagramElementPredicates.isMoveable(de);
	}
	
	/**
	 * Lays out selected shapes in a radial pattern
	 */
	@Override
	public void run(){
		final AgeDiagram ageDiagram = editor.getAgeDiagram();
		if(ageDiagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}
		
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		ageDiagram.modify("Radial Layout", new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				// Calculate and sets the position of the selected shapes into a radial layout.
				final List<Double> angles = new ArrayList<>();
				final double padding = 25;
				double radius = 0;
				double sizeOfShapes = 0;
				double circumference = -1;
				
				// Find appropriate radius for shapes
				while((sizeOfShapes > circumference) || (Double.isNaN(sizeOfShapes))) {
					sizeOfShapes = 0;
					angles.clear();
					radius++;
					circumference = 2*Math.PI*radius;
					
					for(final DiagramElement e : selectedDiagramElements) {
						// Get largest dimension of shape
						final double shapeDimension = ((e.getWidth() > e.getHeight() ? e.getWidth() : e.getHeight()) + padding) / 2;

						// Calculate diagonal of shape
						final double shapeSize = Math.sqrt((Math.pow(shapeDimension, 2) + Math.pow(shapeDimension, 2)));

						// Calculate angle for shape diagonal using Law of Cosines and double it
						final double angle = Math.acos((Math.pow(radius, 2) + Math.pow(radius, 2) - Math.pow(shapeSize, 2)) / (2*radius*radius)) * 2;

						angles.add(angle);
						sizeOfShapes += (circumference * (angle/(2*Math.PI)));
					}
				}

				final Point center = getCenter(selectedDiagramElements, radius);
				double placementAngle = 0;
				int i = 0;
				for(final DiagramElement e : selectedDiagramElements) {
					double spacingAngle = angles.get(i++);

					// Center of placement
					placementAngle += spacingAngle/2;

					// Calculate where to place shape
					final long x = Math.round(center.x + radius * Math.cos(placementAngle) - e.getWidth()/2);
					final long y = Math.round(center.y + radius * Math.sin(placementAngle) - e.getHeight()/2);

					// End of placement
					placementAngle += spacingAngle/2;

					m.setPosition(e, new Point((int)x, (int)y));
				}
			}
		});
	}

	private static Point getCenter(final List<DiagramElement> diagramElements, final double radius) {
		final int boarderPadding = 10;
		int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE, yMax = Integer.MIN_VALUE;
		int maxWidth = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;

		// Get min and max values for x and y axis.
		// Get max dimension of shapes
		for(final DiagramElement diagramElement : diagramElements) {
			final int width = diagramElement.getWidth()/2;
			final int height = diagramElement.getHeight()/2;
			
			final int x = diagramElement.getX() + width;
			final int y = diagramElement.getY() + height;
			
			if(x < xMin) {
				xMin = x;
			}

			if(x > xMax) {
				xMax = x;
			}

			if(y < yMin) {
				yMin = y;
			}

			if(y > yMax) {
				yMax = y;
			}

			if(maxWidth < width) {
				maxWidth = width;
			}

			if(maxHeight < height) {
				maxHeight = height;
			}
		}

		// Calculate center point
		int xCenter = (xMin + xMax) / 2;
		int yCenter = (yMax + yMin) / 2;
		
		// Move center point to appropriate location if necessary
		if(xCenter - radius - maxWidth < 0) {
			xCenter += Math.abs(xCenter - radius - maxWidth) + boarderPadding;
		}

		if(yCenter - radius - maxHeight < 0) {
			yCenter += Math.abs(yCenter - radius - maxHeight) + boarderPadding;
		}

		return new Point(xCenter, yCenter);
	}
}