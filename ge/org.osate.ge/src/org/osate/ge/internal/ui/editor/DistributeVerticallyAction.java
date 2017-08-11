package org.osate.ge.internal.ui.editor;

import java.util.Comparator;
import java.util.List;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.Point;

public class DistributeVerticallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public final static String DISTRIBUTE_VERTICALLY = "org.osate.ge.ui.editor.items.distribute_vertically";
	public static final ImageDescriptor verticalImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically.gif");
	public static final ImageDescriptor verticalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically_Disabled.gif");
	
	public DistributeVerticallyAction(final IWorkbenchPart part) {
		super(part);
		this.editor = (AgeDiagramEditor)part;
		setHoverImageDescriptor(verticalImageDescriptor);
		setDisabledImageDescriptor(verticalDisabledImageDescriptor);
		setId(DISTRIBUTE_VERTICALLY);
	}
	
	/**
	 * Updates whether action is available based on if shapes selected are valid
	 */
	@Override
	protected boolean calculateEnabled() {
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		if(selectedDiagramElements == null) {
			return false;
		}
		
		if(selectedDiagramElements.size() < 3) {
			return false;
		}
		
		if(!ContributionHelper.allHaveSameParent(selectedDiagramElements)) {
			return false;
		}
		
		return selectedDiagramElements.stream().allMatch(DistributeVerticallyAction::isSupported);
	}

	private static boolean isSupported(final DiagramElement de) {
		return DiagramElementPredicates.isUndocked(de) && DiagramElementPredicates.isMoveable(de);
	}
	
	/**
	 * Distributes shapes along the Y axis so each shape has an equal distance between them
	 */
	@Override
	public void run(){
		final AgeDiagram ageDiagram = editor.getAgeDiagram();
		if(ageDiagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}
		
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		ageDiagram.modify("Distribute Horizontally", new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				selectedDiagramElements.sort(YValueComparator);

				// Distribute the shapes horizontally
				final int xDistribution = getYDistribution(selectedDiagramElements);
				for(int i = 1; i < selectedDiagramElements.size()-1; i++) {
					final DiagramElement de = selectedDiagramElements.get(i);
					final int x = de.getX();
					final int y = getYValue(selectedDiagramElements.get(i-1), xDistribution);

					m.setPosition(de, new Point(x, y));
				}
			}
		});
	}
	
	/**
	 * Calculate the height of the all shapes, used for distribution calculations
	 * @param shapes the selected shapes
	 * @return the height of the middle shapes
	 */
	private static int getHeightOfShapes(final List<DiagramElement> diagramElements) {
		return (int)diagramElements.stream().mapToDouble(de -> de.getHeight()).sum();
	}
		
	/**
	 * Calculate the Y-coordinate value for the shape being evaluated
	 * @param prevElement the GraphicsAlgorithm of the shape just before the current shape being evaluated
	 * @param yDistribution the Y-coordinate distance that needs to be between each shape
	 * @return the Y-coordinate value for the shape being evaluated
	 */
	private static int getYValue(final DiagramElement prevElement, final int yDistribution) {
		return prevElement.getY()+prevElement.getHeight()+yDistribution;
	}
	
	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param shapes the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static int getYDistribution(final List<DiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size()-1;
		final int heightOfShapes = getHeightOfShapes(diagramElements);
		final DiagramElement firstElement = diagramElements.get(0);
		final DiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.getY()+lastElement.getHeight()-firstElement.getY()-heightOfShapes)/lastIndex;
	}
	
	/**
	 * Sort the selected shapes based on Y-coordinate value
	 */
	private static final Comparator<DiagramElement> YValueComparator = new Comparator<DiagramElement>() {
		@Override
		public int compare(final DiagramElement de1, final DiagramElement de2) {
			return Integer.valueOf(de1.getY()).compareTo(de2.getY());
		}
	};
}

