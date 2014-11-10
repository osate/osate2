package org.osate.ge.ui.editor;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
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

	public final void setActiveEditor(final IEditorPart newEditor) {
		if(editor != newEditor) {
			if(newEditor instanceof AgeDiagramEditor) {
				editor = (AgeDiagramEditor)newEditor;
			} else {
				editor = null;
			}
		}
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
						//Take into consideration width of shapes to distribute evenly
						for(int i=0; i < arrayLength; i++){
								pe = sort(pe,i);
							}
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
	//Sort by Y, so it does not matter which order the user selects the pictogram elements
	private static final PictogramElement[] sort(PictogramElement[] pe, int i){
		if(pe[i].getGraphicsAlgorithm().getY() > pe[i+1].getGraphicsAlgorithm().getY()){
		final PictogramElement[] temp = new PictogramElement[pe.length-1];
		temp[i] = pe[i];
		pe[i] = pe[i+1];
		pe[i+1] = temp[i];
			if(i==0)
				return pe;
			else
				return sort(pe, i-1);
		}
		else
			return pe;
	}
	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		if(editor.getSelectedPictogramElements().length >= 3)
		return true;
		
		else
			return false;
	}

	
}