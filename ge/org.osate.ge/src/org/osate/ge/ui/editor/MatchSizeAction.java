package org.osate.ge.ui.editor;

import java.util.ArrayList;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.Activator;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;

public class MatchSizeAction extends SelectionAction {	
	final private AgeDiagramEditor editor;
	private ResizeShapeContext resizeContext;
	private ArrayList<ResizeShapeContext> resizeContextList;
	private IResizeShapeFeature resizeFeature;
	private IFeatureProvider fp;
	PictogramElement[] pes;
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
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Match Height and Width") {
			@Override
			protected void doExecute() {
				for (ResizeShapeContext resizeContext : resizeContextList) {
					resizeFeature.resizeShape(resizeContext);
				}
			}
		});
	}

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		if (editor != null && editor.getSelectedPictogramElements().length >= 2) {
			pes = new PictogramElement[editor.getSelectedPictogramElements().length];
			pes = editor.getSelectedPictogramElements();
			resizeContextList = new ArrayList<ResizeShapeContext>();
			for (final PictogramElement pe : pes) {
				if (pe instanceof Shape) {
					for (final PictogramElement containerCheck : pes) {
						if (containerCheck instanceof Shape && (!(((Shape)containerCheck).getContainer().equals(((Shape)pe).getContainer())))) {
							return false;
						}
					}
				} else {
					return false;
				}
				final Shape s = (Shape)pe;
				resizeContext = new ResizeShapeContext(s);
				resizeContext.setLocation(s.getGraphicsAlgorithm().getX(), s.getGraphicsAlgorithm().getY());
				resizeContext.setHeight(pes[pes.length-1].getGraphicsAlgorithm().getHeight());
				resizeContext.setWidth(pes[pes.length-1].getGraphicsAlgorithm().getWidth());
				fp = editor.getDiagramTypeProvider().getFeatureProvider();
				resizeFeature = fp.getResizeShapeFeature(resizeContext);
				if(!(resizeFeature != null && resizeFeature.canResizeShape(resizeContext))) {
					return false;
				}
				resizeContextList.add(resizeContext);
			}
			return true;
		}
		return false;
	}
}
