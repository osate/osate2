package org.osate.ge.ui.editor;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
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
	
	public final void setActiveEditor(final IEditorPart newEditor) {
		if(editor != newEditor) {
			if(newEditor instanceof AgeDiagramEditor) {
				editor = (AgeDiagramEditor)newEditor;
			} else {
				editor = null;
			}
		}
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
						for(int i=0; i < pe.length-1; i++){
								pe = sort(pe,i);
							}
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
	
	//Sort by X, so it does not matter which order the user selects the pictogram elements
	private static PictogramElement[] sort(PictogramElement[] pe, int i){
		if(pe[i].getGraphicsAlgorithm().getX() > pe[i+1].getGraphicsAlgorithm().getX()){
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