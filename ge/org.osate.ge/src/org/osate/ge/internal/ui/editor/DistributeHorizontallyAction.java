package org.osate.ge.internal.ui.editor;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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

public class DistributeHorizontallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public static final String DISTRIBUTE_HORIZONTALLY = "org.osate.ge.ui.editor.items.distribute_horizontally";
	public static final ImageDescriptor horizontalImageDescriptor = Activator.getImageDescriptor("icons/DistributeHorizontally.gif");
	public static final ImageDescriptor horizontalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeHorizontally_Disabled.gif");

	public DistributeHorizontallyAction(final IWorkbenchPart part) {
		super(part); 
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(horizontalImageDescriptor);
		setDisabledImageDescriptor(horizontalDisabledImageDescriptor);
		setId(DISTRIBUTE_HORIZONTALLY);
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
		
		return selectedDiagramElements.stream().allMatch(DistributeHorizontallyAction::isSupported);
	}

	private static boolean isSupported(final DiagramElement de) {
		return DiagramElementPredicates.isUndocked(de) && DiagramElementPredicates.isMoveable(de);
	}
	
	/**
	 * Distributes shapes along the X axis so each shape has an equal distance between them
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
				selectedDiagramElements.sort(XValueComparator);

				// Distribute the shapes horizontally
				final int xDistribution = getXDistribution(selectedDiagramElements);
				for(int i = 1; i < selectedDiagramElements.size()-1; i++) {
					final DiagramElement de = selectedDiagramElements.get(i);
					final int x = getXValue(selectedDiagramElements.get(i-1), xDistribution);
					final int y = de.getY();

					m.setPosition(de, new Point(x, y));
				}
			}
		});
	}
	
	/**
	 * Calculate the width of all shapes, used for distribution calculations
	 * @param diagramElements the selected shapes
	 * @return the width of the middle shapes
	 */
	private static int getWidthOfShapes(final List<DiagramElement> diagramElements) {
		return (int)diagramElements.stream().mapToDouble(de -> de.getWidth()).sum();
	}

	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param diagramElements the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static int getXDistribution(final List<DiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size()-1;
		final int widthOfShapes = getWidthOfShapes(diagramElements);
		final DiagramElement firstElement = diagramElements.get(0);
		final DiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.getX()+lastElement.getWidth()-firstElement.getX()-widthOfShapes)/lastIndex;
	}

	/**
	 * Calculate the X-coordinate value for the shape being evaluated
	 * @param prevElement the element of the shape just before the current element being evaluated
	 * @param xDistribution the X-coordinate distance that needs to be between each shape
	 * @return the X-coordinate value for the shape being evaluated
	 */
	private static int getXValue(final DiagramElement prevElement, final int xDistribution) {
		return prevElement.getX()+prevElement.getWidth()+xDistribution;
	}

	/**
	 * Sort the selected shapes based on X-coordinate value
	 */
	private static final Comparator<DiagramElement> XValueComparator = new Comparator<DiagramElement>() {
		@Override
		public int compare(final DiagramElement de1, final DiagramElement de2) {
			return Integer.valueOf(de1.getX()).compareTo(de2.getX());
		}
	};
}