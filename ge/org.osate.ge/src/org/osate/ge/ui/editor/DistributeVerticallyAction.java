package org.osate.ge.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.Activator;

public class DistributeVerticallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public final static String DISTRIBUTE_VERTICALLY = "org.osate.ge.ui.editor.items.distribute_vertically";
	public static final ImageDescriptor verticalImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically.gif");
	public static final ImageDescriptor verticalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically_Disabled.gif");
	
	public DistributeVerticallyAction(final IWorkbenchPart part) {
		super(part);
		this.editor = (AgeDiagramEditor)part;
		setHoverImageDescriptor(verticalImageDescriptor);
		setDisabledImageDescriptor(verticalDisabledImageDescriptor);
		setId(DISTRIBUTE_VERTICALLY);
	}

	//Distributes shapes along the Y axis so each shape has an equal distance between them.
	@Override
	public void run() {
		if (editor != null && editor.getSelectedPictogramElements().length >= 3){
			editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Vertically") {
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
	}

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		return getMoveShapeContextsFromEditorSelection() != null;
	}

	private Collection<MoveShapeContext> getMoveShapeContextsFromEditorSelection() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length<3) {
			return null;
		}
		
		if(!LayoutUtil.areAllShapes(pes)) {
			return null;
		}
		
		final Shape[] shapes = Arrays.copyOf(pes, pes.length, Shape[].class);
		if(!LayoutUtil.haveSameContainerShapes(shapes)) {
			return null;
		}
		
		Arrays.sort(shapes, YValueComparator);
		
		final Collection<MoveShapeContext> moveShapeCtxs = getMoveShapeContext(shapes);
		final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
		for (final MoveShapeContext ctx : moveShapeCtxs) {
			final IMoveShapeFeature moveFeature = fp.getMoveShapeFeature(ctx);
			if (moveFeature == null || !moveFeature.canExecute(ctx)) {
				return null;
			}
		}
		
		return moveShapeCtxs;
	}

	private Collection<MoveShapeContext> getMoveShapeContext(final Shape[] shapes) {
		final Collection<MoveShapeContext> result = new ArrayList<MoveShapeContext>();
		final int yDistribution = getYDistribution(shapes);
		for (int i=1;i<shapes.length-1;i++) {
			final Shape shape = shapes[i];
			final int xValue = shape.getGraphicsAlgorithm().getX();
			final int yValue = getYValue(shapes[i-1].getGraphicsAlgorithm(), yDistribution);
			final ContainerShape container = shape.getContainer();

			result.add(LayoutUtil.getDistributeMoveShapeContext(shape, xValue, yValue, container));
		}
		
		return result;
	}
	
	private static int getHeightOfShapes(final Shape[] shapes) {
		int result = 0;
		//Iterate on shapes between first and last
		for (int i=shapes.length-2;i>0;i--) {
			result = shapes[i].getGraphicsAlgorithm().getHeight()+result;
		}
		
		return result;
	}
	
	private static int getYValue(final GraphicsAlgorithm prevShapeGA, final int yDistribution) {
		return prevShapeGA.getY()+prevShapeGA.getHeight()+yDistribution;
	}
	
	private static int getYDistribution(final Shape[] shapes) {
		final int arrayLength = shapes.length-1;
		final int heightOfShapes = getHeightOfShapes(shapes);
		
		return (shapes[arrayLength].getGraphicsAlgorithm().getY()-(shapes[0].getGraphicsAlgorithm().getY()+shapes[0].getGraphicsAlgorithm().getHeight())-heightOfShapes)/arrayLength;
	}

	private static final Comparator<Shape> YValueComparator 
	= new Comparator<Shape>() {
		@Override
		public int compare(final Shape yShape1, final Shape yShape2) {
			return Integer.valueOf(yShape1.getGraphicsAlgorithm().getY()).compareTo(yShape2.getGraphicsAlgorithm().getY());
		}
	};
}

