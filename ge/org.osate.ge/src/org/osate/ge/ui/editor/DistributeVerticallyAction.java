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



public class DistributeVerticallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public final static String DISTRIBUTE_VERTICALLY = "org.osate.ge.ui.editor.items.distribute_vertically";
	public static final ImageDescriptor verticalImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically.gif");
	public static final ImageDescriptor verticalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically_Disabled.gif");
	protected DistributeVerticallyAction(final IWorkbenchPart part) {
		super(part); 
		editor = (AgeDiagramEditor)part;
		setHoverImageDescriptor(verticalImageDescriptor);
		setDisabledImageDescriptor(verticalDisabledImageDescriptor);
		setId(DISTRIBUTE_VERTICALLY);
	}

	//Distributes shapes along the Y axis so each shape has an equal distance between them.
	@Override
	public void run() {
		if (editor.getSelectedPictogramElements().length >= 3){
			if(editor != null) {
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Vertically") {
					@Override
					protected void doExecute() {
						PictogramElement[] pe = editor.getSelectedPictogramElements();
						final int arrayLength = pe.length-1;
						//Sort by Y, so it does not matter which order the user selects the pictogram elements
						Arrays.sort(pe, DistributeVerticallyAction.YValueComparator);
						//Distribute each shape between the head and the tail evenly.
						int heightOfShapes = 0;
						for(int i = arrayLength-1;i>0;i--){
							heightOfShapes = pe[i].getGraphicsAlgorithm().getHeight()+heightOfShapes;
						}
						int yDistribution = (pe[arrayLength].getGraphicsAlgorithm().getY() - (pe[0].getGraphicsAlgorithm().getY()+pe[0].getGraphicsAlgorithm().getHeight()) - heightOfShapes)/arrayLength;
						for(int i=1;i<arrayLength;i++){
							pe[i].getGraphicsAlgorithm().setY(pe[i-1].getGraphicsAlgorithm().getY()+pe[i-1].getGraphicsAlgorithm().getHeight()+yDistribution);
						}
						
					}				
				});
			}
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
	
