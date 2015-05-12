package org.osate.ge.ui.editor;



import java.util.Objects;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.Activator;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;



public class MatchSizeAction extends SelectionAction {
	final private AgeDiagramEditor editor;
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

	//Matches the height and width of every shape selected with the final shape selected.   
	@Override 
	public void run(){
		if(editor != null) {	
			editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Match Height and Width") {
				@Override
				protected void doExecute() {
					final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
					final PictogramElement[] pe = editor.getSelectedPictogramElements();
					final int arrayLength = pe.length-1;
					for (int i = pe.length-1; i>=0; i--){
						final Shape s = (Shape)pe[i];
						final ResizeShapeContext resizeContext = new ResizeShapeContext(s);
						resizeContext.setLocation(s.getGraphicsAlgorithm().getX(), s.getGraphicsAlgorithm().getY());
						resizeContext.setHeight(pe[arrayLength].getGraphicsAlgorithm().getHeight());
						resizeContext.setWidth(pe[arrayLength].getGraphicsAlgorithm().getWidth());
						
						final IResizeShapeFeature resizeFeature = fp.getResizeShapeFeature(resizeContext);
						if(resizeFeature != null && resizeFeature.canResizeShape(resizeContext)) {
							resizeFeature.resizeShape(resizeContext);
						}
					}   
				}				
			});
			
		}
	}

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length >= 2) {
			final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
			for(final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
				final IEditorPart editorPart = editorRef.getEditor(false);
				if(editorPart instanceof AgeDiagramEditor) {
					final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editorPart;
					if(diagramEditor.getDiagramTypeProvider().getDiagram() == diagram) {
						for (final PictogramElement pe : pes) {
							final BusinessObjectResolutionService bor = Objects.requireNonNull((BusinessObjectResolutionService)diagramEditor.getAdapter(BusinessObjectResolutionService.class), "unable to get business object resolution service");
							final Object bo = bor.getBusinessObjectForPictogramElement(pe);
							if(!((pe instanceof ContainerShape) || (bo instanceof org.osate.aadl2.Subcomponent) || (bo instanceof org.osate.aadl2.SubprogramCallSequence))) {
								return false;
							}
						}
						return true;
					}
				}
			}
		}
		return false;
	}
}
