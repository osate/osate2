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

public class DistributeHorizontallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public static final String DISTRIBUTE_HORIZONTALLY = "org.osate.ge.ui.editor.items.distribute_horizontally";
	public static final ImageDescriptor horizontalImageDescriptor = Activator.getImageDescriptor("icons/DistributeHorizontally.gif");
	public static final ImageDescriptor horizontalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeHorizontally_Disabled.gif");

	protected DistributeHorizontallyAction(final IWorkbenchPart part) {
		super(part); 
		editor = (AgeDiagramEditor)part;
		setHoverImageDescriptor(horizontalImageDescriptor);
		setDisabledImageDescriptor(horizontalDisabledImageDescriptor);
		setId(DISTRIBUTE_HORIZONTALLY);
	}

	//Distributes shapes along the X axis so each shape has an equal distance between them
	@Override
	public void run(){
		if (editor != null && editor.getSelectedPictogramElements().length >= 3){
			editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Horizontally") {
				@Override
				protected void doExecute() {
					final PictogramElement[] pes = editor.getSelectedPictogramElements();
					final int arrayLength = pes.length-1;					
					//Sort
					Arrays.sort(pes, XValueComparator);
					//Distribute each shape between the head and the tail evenly.
					int widthOfShapes = 0;
					for (int i = arrayLength-1;i>0;i--) {
						widthOfShapes = pes[i].getGraphicsAlgorithm().getWidth()+widthOfShapes;
					}
					int xDistribution = (pes[arrayLength].getGraphicsAlgorithm().getX() - (pes[0].getGraphicsAlgorithm().getX()+pes[0].getGraphicsAlgorithm().getWidth()) - widthOfShapes)/arrayLength;
					for(int i=1;i<arrayLength;i++) {
						if (pes[i] instanceof Shape) {
							final Shape shape = (Shape)pes[i];
							final int xValue = pes[i-1].getGraphicsAlgorithm().getX()+pes[i-1].getGraphicsAlgorithm().getWidth()+xDistribution;
							final MoveShapeContext moveContext = new MoveShapeContext(shape);
							moveContext.setLocation(xValue, pes[i].getGraphicsAlgorithm().getY());
							moveContext.setSourceContainer(shape.getContainer());
							moveContext.setTargetContainer(shape.getContainer());
							moveContext.setDeltaX(xValue);
							moveContext.setDeltaY(pes[i].getGraphicsAlgorithm().getY());
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
	private static final Comparator<PictogramElement> XValueComparator 
	= new Comparator<PictogramElement>() {
		@Override
		public int compare(PictogramElement xValueArg1, PictogramElement xValueArg2) {
			return Integer.valueOf(xValueArg1.getGraphicsAlgorithm().getX()).compareTo(xValueArg2.getGraphicsAlgorithm().getX());
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