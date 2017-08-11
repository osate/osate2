package org.osate.ge.internal.ui.editor;

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

public class GridLayoutAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public static final String GRID_LAYOUT = "org.osate.ge.ui.editor.items.grid_layout";
	public static final ImageDescriptor gridLayoutImageDescriptor = Activator.getImageDescriptor("icons/GridLayout.gif");
	public static final ImageDescriptor gridLayoutDisabledImageDescriptor = Activator.getImageDescriptor("icons/GridLayout_Disabled.gif");

	public GridLayoutAction(final IWorkbenchPart part) {
		super(part); 
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(gridLayoutImageDescriptor);
		setDisabledImageDescriptor(gridLayoutDisabledImageDescriptor);
		setId(GRID_LAYOUT);
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
		
		return selectedDiagramElements.stream().allMatch(GridLayoutAction::isSupported);
	}

	private static boolean isSupported(final DiagramElement de) {
		return DiagramElementPredicates.isUndocked(de) && DiagramElementPredicates.isMoveable(de);
	}
	
	/**
	 * Lays out selected shapes in a grid pattern
	 */
	@Override
	public void run(){
		final AgeDiagram ageDiagram = editor.getAgeDiagram();
		if(ageDiagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}
		
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		ageDiagram.modify("Grid Layout", new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				// Calculate and sets the selected diagram elements into a grid layout.
				final int padding = 25;
				
				final int numOfCols = (int)Math.ceil(Math.sqrt(selectedDiagramElements.size()));
				final int numOfRows = (int)Math.ceil(selectedDiagramElements.size()/(double)numOfCols);

				final int[] colSizes = new int[numOfCols-1];
				final int[] rowSizes = new int[numOfRows-1];

				// Assign column and row width for grid
				for(int i = 0 ; i < selectedDiagramElements.size() ; i++) {
					final DiagramElement de = selectedDiagramElements.get(i);
					int col = i % numOfCols;
					int row = i / numOfCols;
					
					if(col < colSizes.length) {
						colSizes[col] = Math.max(colSizes[col], de.getWidth() + padding);
					}

					if(row < rowSizes.length) {
						rowSizes[row] = Math.max(rowSizes[row], de.getHeight() + padding);
					}
				}

				// Calculate grid position and place first shape
				final Point gridPosition = getGridPosition(selectedDiagramElements);
				int x = gridPosition.x;
				int y = gridPosition.y;
				
				// Position the elements
				m.setPosition(selectedDiagramElements.get(0), new Point(x, y));

				// Place the rest of the shapes
				for(int i = 1 ; i < selectedDiagramElements.size(); i++) {
					if(i % numOfCols == 0) {
						x = gridPosition.x;
						if(rowSizes.length != 0) {
							y += rowSizes[i / numOfCols - 1];
						}
					} else {
						x += colSizes[i % numOfCols - 1];
					}

					m.setPosition(selectedDiagramElements.get(i), new Point(x,y));
				}
			}
		});
	}

	/**
	 * Get grid placement coordinate
	 */
	private static Point getGridPosition(final List<DiagramElement> diagramElements) {
		int xMin = Integer.MAX_VALUE, yMin = Integer.MAX_VALUE;

		// Get min values for x and y axis.
		for(final DiagramElement e : diagramElements) {
			final int x = e.getX();
			final int y = e.getY();
			
			if(x < xMin) {
				xMin = x;
			}

			if(y < yMin) {
				yMin = y;
			}
		}

		return new Point(xMin, yMin);
	}
}
