package org.osate.ge.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IFeatureProvider;
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
	private IFeatureProvider fp;
	private PictogramElement[] pes;
	private IMoveShapeFeature moveFeature;
	private final ArrayList<MoveShapeContext> moveContextList = new ArrayList<MoveShapeContext>();
	public final static String DISTRIBUTE_VERTICALLY = "org.osate.ge.ui.editor.items.distribute_vertically";
	public static final ImageDescriptor verticalImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically.gif");
	public static final ImageDescriptor verticalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically_Disabled.gif");
	
	public DistributeVerticallyAction(final IWorkbenchPart part) {
		super(part);
		this.editor = (AgeDiagramEditor)part;
		this.fp = editor.getDiagramTypeProvider().getFeatureProvider();
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
					for (MoveShapeContext moveContext : moveContextList) {
						moveFeature.moveShape(moveContext);
					}
					final PictogramElement[] pes = new PictogramElement[0];
					editor.selectPictogramElements(pes);
				}
			});
		}
	}

	private boolean isSameContainerShapes() {
		if (pes[0] instanceof Shape) {
			final ContainerShape containerShape = ((Shape)pes[0]).getContainer();
			for (int i=1;i<pes.length;i++) {
				if ((!(pes[i] instanceof Shape)) || ((Shape)pes[i]).getContainer() != containerShape) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		if(editor != null && editor.getSelectedPictogramElements().length >= 3) {
			pes = editor.getSelectedPictogramElements();
			if (isSameContainerShapes()) {
				//Sort
				Arrays.sort(pes, YValueComparator);
				final int arrayLength = pes.length-1;
				//Distribute each shape between the head and the tail evenly.
				int heightOfShapes = 0;
				for (int i = arrayLength-1;i>0;i--) {
					heightOfShapes = pes[i].getGraphicsAlgorithm().getHeight()+heightOfShapes;
				}
				int yDistribution = (pes[arrayLength].getGraphicsAlgorithm().getY() - (pes[0].getGraphicsAlgorithm().getY()+pes[0].getGraphicsAlgorithm().getHeight()) - heightOfShapes)/arrayLength;
				for(int i=1;i<arrayLength;i++) {
					final Shape s = (Shape)pes[i];
					final int yValue = pes[i-1].getGraphicsAlgorithm().getY()+pes[i-1].getGraphicsAlgorithm().getHeight()+yDistribution;
					final MoveShapeContext moveContext = new MoveShapeContext(s);
					moveContext.setLocation(pes[i].getGraphicsAlgorithm().getX(), yValue);
					moveContext.setSourceContainer(s.getContainer());
					moveContext.setTargetContainer(s.getContainer());
					moveContext.setDeltaX(pes[i].getGraphicsAlgorithm().getX());
					moveContext.setDeltaY(yValue);
					moveFeature = editor.getDiagramTypeProvider().getFeatureProvider().getMoveShapeFeature(moveContext);
					moveFeature = fp.getMoveShapeFeature(moveContext);
					if (moveFeature != null && moveFeature.canMoveShape(moveContext)) {
						moveContextList.add(moveContext);
					} else {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	private static final Comparator<PictogramElement> YValueComparator 
	= new Comparator<PictogramElement>() {
		@Override
		public int compare(final PictogramElement yValueArg1, final PictogramElement yValueArg2) {
			return Integer.valueOf(yValueArg1.getGraphicsAlgorithm().getY()).compareTo(yValueArg2.getGraphicsAlgorithm().getY());
		}
	};
}

