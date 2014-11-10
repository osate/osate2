package org.osate.ge.ui.editor;



import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.Activator;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.impl.LayoutContext;



public class MatchSizeAction extends SelectionAction {
	private AgeDiagramEditor editor;
	final public static String MATCH_SIZE = "org.osate.ge.ui.editor.items.match_size";
	final public static ImageDescriptor matchSizeImageDescriptor = Activator.getImageDescriptor("icons/Match.gif");
	final public static ImageDescriptor matchSizeDisabledImageDescriptor = Activator.getImageDescriptor("icons/Match_Disabled.gif");
	protected MatchSizeAction(final IWorkbenchPart part) {
		super(part); 
		editor = (AgeDiagramEditor)part;
		setHoverImageDescriptor(matchSizeImageDescriptor);
		setDisabledImageDescriptor(matchSizeDisabledImageDescriptor);
		setId(MATCH_SIZE);	
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

	//Matches the height and width of every shape selected with the final shape selected.   
	@Override 
	public void run(){
		if(editor != null) {	
			editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Match Height and Width") {
				@Override
				protected void doExecute() {
					final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
					final PictogramElement[] pe = editor.getSelectedPictogramElements();
					for (int i = pe.length-1; i>=0; i--){
						pe[i].getGraphicsAlgorithm().setHeight(pe[pe.length-1].getGraphicsAlgorithm().getHeight());
						pe[i].getGraphicsAlgorithm().setWidth(pe[pe.length-1].getGraphicsAlgorithm().getWidth());
						
						// Layout the pictogram element
						final LayoutContext ctx = new LayoutContext(pe[i]);
						final ILayoutFeature feature = fp.getLayoutFeature(ctx);
						if(feature != null && feature.canLayout(ctx)) {
							feature.layout(ctx);
						}
					}	   
				}				
			});
			
		}
	}
	
	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		if(editor.getSelectedPictogramElements().length >= 2)
			return true;
			else
				return false;
	}
	
}