package org.osate.ge.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.Activator;

public class DistributeHorizontallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	private PictogramElement[] pes;
	private MoveShapeContext moveContext;
	private IMoveShapeFeature moveFeature;
	private ArrayList<MoveShapeContext> moveContextList;
	private IFeatureProvider fp;
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
			editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Horizontally") {
				@Override
				protected void doExecute() {
					for (MoveShapeContext moveContext : moveContextList) {
						moveFeature.moveShape(moveContext);
					}
					PictogramElement[] pes = new PictogramElement[0];
					editor.selectPictogramElements(pes);
				}
			});	
	}

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		if(editor != null && editor.getSelectedPictogramElements().length >= 3) {
			pes = new PictogramElement[editor.getSelectedPictogramElements().length];
			pes = editor.getSelectedPictogramElements();
			moveContextList = new ArrayList<MoveShapeContext>();
			for (final PictogramElement pe : pes) {
				if (pe instanceof Shape) {
					//Make sure all elements have the same container
					for (final PictogramElement containerCheck : pes) {
						if (containerCheck instanceof Shape && (!(((Shape)containerCheck).getContainer().equals(((Shape)pe).getContainer())))) {
							return false;
						}
					}
				} else {
					return false;
				}
			}
			//Sort
			Arrays.sort(pes, XValueComparator);
			final int arrayLength = pes.length-1;
			//Distribute each shape between the head and the tail evenly.
			int widthOfShapes = 0;
			for (int i = arrayLength-1;i>0;i--) {
				widthOfShapes = pes[i].getGraphicsAlgorithm().getWidth()+widthOfShapes;
			}
			int xDistribution = (pes[arrayLength].getGraphicsAlgorithm().getX() - (pes[0].getGraphicsAlgorithm().getX()+pes[0].getGraphicsAlgorithm().getWidth()) - widthOfShapes)/arrayLength;
			for(int i=1;i<arrayLength;i++) {
				final Shape s = (Shape)pes[i];
				final int xValue = pes[i-1].getGraphicsAlgorithm().getX()+pes[i-1].getGraphicsAlgorithm().getWidth()+xDistribution;
				moveContext = new MoveShapeContext(s);
				moveContext.setLocation(xValue, pes[i].getGraphicsAlgorithm().getY());
				moveContext.setSourceContainer(s.getContainer());
				moveContext.setTargetContainer(s.getContainer());
				moveContext.setDeltaX(xValue);
				moveContext.setDeltaY(pes[i].getGraphicsAlgorithm().getY());
				moveFeature = editor.getDiagramTypeProvider().getFeatureProvider().getMoveShapeFeature(moveContext);
				fp = editor.getDiagramTypeProvider().getFeatureProvider();
				moveFeature = fp.getMoveShapeFeature(moveContext);
				if (moveFeature != null && moveFeature.canMoveShape(moveContext)) {
					moveContextList.add(moveContext);
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	private static final Comparator<PictogramElement> XValueComparator 
	= new Comparator<PictogramElement>() {
		@Override
		public int compare(PictogramElement xValueArg1, PictogramElement xValueArg2) {
			return Integer.valueOf(xValueArg1.getGraphicsAlgorithm().getX()).compareTo(xValueArg2.getGraphicsAlgorithm().getX());
		}
	};
}