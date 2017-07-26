package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.internal.Activator;

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
		return getMoveShapeContextsFromEditorSelection() != null;
	}

	/**
	 * Lays out selected shapes in a grid pattern
	 */
	@Override
	public void run(){
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Grid Layout") {
			@Override
			protected void doExecute() {
				final Collection<MoveShapeContext> ctxs = getMoveShapeContextsFromEditorSelection();
				if(ctxs != null) {
					for (final MoveShapeContext ctx : ctxs) {
						final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
						final IMoveShapeFeature feature = fp.getMoveShapeFeature(ctx);
						feature.execute(ctx);
					}	
				}
			}
		});
	}

	/**
	 * Performs validation, builds, and returns a collection of contexts
	 * @return the contexts. Returns null if validation fails.
	 */
	private Collection<MoveShapeContext> getMoveShapeContextsFromEditorSelection() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length < 2) {
			return null;
		}

		if(!LayoutUtil.areAllShapes(pes)) {
			return null;
		}

		final Shape[] shapes = Arrays.copyOf(editor.getSelectedPictogramElements(), pes.length, Shape[].class);
		if(!LayoutUtil.haveSameContainerShapes(shapes)) {
			return null;
		}

		final Collection<MoveShapeContext> moveShapeCtxs = getMoveShapeContexts(shapes);

		// TODO: Disabling for now to allow container to expand
		/*final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
		for (final MoveShapeContext ctx : moveShapeCtxs) {
			final IMoveShapeFeature moveFeature = fp.getMoveShapeFeature(ctx);
			if (moveFeature == null || !moveFeature.canExecute(ctx)) {
				return null;
			}
		}*/

		return moveShapeCtxs;
	}
	
	/**
	 * Calculate the selected shapes new grid layout location information
	 * @param shapes the selected shapes
	 * @return the list contexts that contain the shapes new locations
	 */
	private static Collection<MoveShapeContext> getMoveShapeContexts(final Shape[] shapes) {
		final Collection<MoveShapeContext> results = new ArrayList<MoveShapeContext>();
		final ContainerShape container = shapes[0].getContainer();
		final int padding = 25;
		
		int numOfRows = (int)Math.sqrt(shapes.length);
		int numOfCols = (int)Math.ceil(shapes.length/(double)numOfRows);

		final Integer[] colSizes = initializeArray(numOfCols-1);
		final Integer[] rowSizes = initializeArray(numOfRows-1);
		
		// Assign column and row width for grid
		for(int i = 0 ; i < shapes.length ; i++) {
			final GraphicsAlgorithm shapeGA = shapes[i].getGraphicsAlgorithm();
			int col = i % numOfCols;
			int row = i / numOfCols;
			
			if(col < colSizes.length) {
				if(colSizes[col] < shapeGA.getWidth() + padding) {
					colSizes[col] = shapeGA.getWidth() + padding;
				}
			}

			if(row < rowSizes.length) {
				if(rowSizes[row] < shapeGA.getHeight() + padding) {
					rowSizes[row] = shapeGA.getHeight() + padding;
				}
			}
		}

		// Calculate grid position and place first shape
		final Point gridPosition = getGridPosition(shapes);
		int x = gridPosition.x;
		int y = gridPosition.y;
		
		results.add(LayoutUtil.getDistributeMoveShapeContext(shapes[0], x, y, container));

		// Place the rest of the shapes
		for(int i = 1 ; i < shapes.length ; i++) {
			if(i % (numOfCols) == 0) {
				x = gridPosition.x;
				if(rowSizes.length != 0) {
					y += rowSizes[i / numOfCols - 1];
				}
			} else {
				x += colSizes[i % numOfCols - 1];
			}

			results.add(LayoutUtil.getDistributeMoveShapeContext(shapes[i], x, y, container));
		}

		return results;
	}
	
	/**
	 * Get grid placement coordinate
	 */
	private static Point getGridPosition(final Shape[] shapes) {
		int xMin = Integer.MAX_VALUE, yMin = Integer.MAX_VALUE;

		// Get min values for x and y axis.
		for(final Shape shape : shapes) {
			final GraphicsAlgorithm shapeGA = shape.getGraphicsAlgorithm();

			final int x = shapeGA.getX();
			final int y = shapeGA.getY();
			
			if(x < xMin) {
				xMin = x;
			}

			if(y < yMin) {
				yMin = y;
			}
		}

		return new Point(xMin, yMin);
	}

	private static Integer[] initializeArray(final int size) {
		final Integer[] initArray = new Integer[size];

		for(int i = 0 ; i < size ; i++) {
			initArray[i] = 0;
		}
		
		return initArray;
	}
}
