package org.osate.ge.ui.editor;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
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
	protected DistributeVerticallyAction(final IWorkbenchPart part) {
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
					final PictogramElement[] pes = editor.getSelectedPictogramElements();
					final int arrayLength = pes.length-1;		
					//Sort
					Arrays.sort(pes, DistributeVerticallyAction.YValueComparator);
					//Distribute each shape between the head and the tail evenly.
					int heightOfShapes = 0;
					for (int i = arrayLength-1;i>0;i--) {
						heightOfShapes = pes[i].getGraphicsAlgorithm().getHeight()+heightOfShapes;
					}
					int yDistribution = (pes[arrayLength].getGraphicsAlgorithm().getY() - (pes[0].getGraphicsAlgorithm().getY()+pes[0].getGraphicsAlgorithm().getHeight()) - heightOfShapes)/arrayLength;
					for(int i=1;i<arrayLength;i++) {
						if (pes[i] instanceof Shape) {
							final Shape shape = (Shape)pes[i];
							final int yValue = pes[i-1].getGraphicsAlgorithm().getY()+pes[i-1].getGraphicsAlgorithm().getHeight()+yDistribution;
							final MoveShapeContext moveContext = new MoveShapeContext(shape);
							moveContext.setLocation(pes[i].getGraphicsAlgorithm().getX(), yValue);
							moveContext.setSourceContainer(shape.getContainer());
							moveContext.setTargetContainer(shape.getContainer());
							moveContext.setDeltaX(pes[i].getGraphicsAlgorithm().getX());
							moveContext.setDeltaY(yValue);
							final IMoveShapeFeature moveFeature = editor.getDiagramTypeProvider().getFeatureProvider().getMoveShapeFeature(moveContext);
							if(moveFeature != null && moveFeature.canMoveShape(moveContext)) {
								moveFeature.moveShape(moveContext);
							}
						}
					}
				}	
			});
		}
	}

	//Sort
	private static final Comparator<PictogramElement> YValueComparator 
	= new Comparator<PictogramElement>() {
		@Override
		public int compare(PictogramElement yValueArg1, PictogramElement yValueArg2) {
			return Integer.valueOf(yValueArg1.getGraphicsAlgorithm().getY()).compareTo(yValueArg2.getGraphicsAlgorithm().getY());
		}
	};

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		if(editor.getSelectedPictogramElements().length >= 3) {
			final PictogramElement[] pes = editor.getSelectedPictogramElements();
			for (final PictogramElement pe : pes) {
				if (pe instanceof ContainerShape) {
					//Make sure pe is not the container of another element selected
					for (PictogramElement p : pes) {
						if (!(p instanceof Shape)) {
							return false;
						}
						if (((ContainerShape)pe).getContainer().equals((Shape)p)) {
							return false;
						}
					}
				} else {
					if (!(pe instanceof Shape)) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
}

