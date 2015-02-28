package org.osate.ge.ui.editor;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
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
		if (editor.getSelectedPictogramElements().length >= 3){
			if(editor != null) {
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Horizontally") {
					@Override
					protected void doExecute() {
						PictogramElement[] pe = editor.getSelectedPictogramElements();
						final int arrayLength = pe.length-1;
						//Sort by X, so it does not matter which order the user selects the pictogram elements
						Arrays.sort(pe, DistributeHorizontallyAction.XValueComparator);
						//Take into consideration width of shapes to distribute evenly
						int widthOfShapes = 0;
						for(int i = arrayLength-1;i>0;i--){
							widthOfShapes = pe[i].getGraphicsAlgorithm().getWidth()+widthOfShapes;
						}
						//Distribute each shape between the head and the tail evenly
						final int xDistribution = (pe[arrayLength].getGraphicsAlgorithm().getX() - (pe[0].getGraphicsAlgorithm().getX()+pe[0].getGraphicsAlgorithm().getWidth()) - widthOfShapes)/arrayLength;
						for(int i=1;i<arrayLength;i++){
							pe[i].getGraphicsAlgorithm().setX(pe[i-1].getGraphicsAlgorithm().getX()+pe[i-1].getGraphicsAlgorithm().getWidth()+xDistribution);
						}
						
					}				
				});
			}
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
		final PictogramElement[] pe = editor.getSelectedPictogramElements();
		if(editor.getSelectedPictogramElements().length >= 3) {
			//Make sure selected pictogram is a shape. (Not a connection)
			for(int i = 0; i < editor.getSelectedPictogramElements().length;i++){
				if(!(pe[i]  instanceof Shape)){
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}