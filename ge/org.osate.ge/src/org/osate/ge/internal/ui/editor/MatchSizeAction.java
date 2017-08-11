package org.osate.ge.internal.ui.editor;

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
import org.osate.ge.internal.diagram.runtime.Dimension;

public class MatchSizeAction extends SelectionAction {	
	final private AgeDiagramEditor editor;
	final public static String MATCH_SIZE = "org.osate.ge.ui.editor.items.match_size";
	final public static ImageDescriptor matchSizeImageDescriptor = Activator.getImageDescriptor("icons/Match.gif");
	final public static ImageDescriptor matchSizeDisabledImageDescriptor = Activator.getImageDescriptor("icons/Match_Disabled.gif");
	
	protected MatchSizeAction(final IWorkbenchPart part) {
		super(part);
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(matchSizeImageDescriptor);
		setDisabledImageDescriptor(matchSizeDisabledImageDescriptor);
		setId(MATCH_SIZE);
	}	

	// Updates action being available based on selection
	@Override
	protected boolean calculateEnabled() {
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		if(selectedDiagramElements == null) {
			return false;
		}
		
		if(selectedDiagramElements.size() < 2) {
			return false;
		}
		
		return selectedDiagramElements.stream().allMatch(MatchSizeAction::isSupported);
	}
	
	private static boolean isSupported(final DiagramElement de) {
		return DiagramElementPredicates.isResizeable(de);
	}

	// Matches the height and width of every shape selected with the final shape selected.   
	@Override 
	public void run(){
		final AgeDiagram ageDiagram = editor.getAgeDiagram();
		if(ageDiagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}
		
		final List<DiagramElement> selectedDiagramElements = ContributionHelper.getSelectedDiagramElements(editor, getSelectedObjects());
		ageDiagram.modify("Match Size", new DiagramModifier() {			
			@Override
			public void modify(DiagramModification m) {
				final Dimension newSize = selectedDiagramElements.get(selectedDiagramElements.size()-1).getSize();
				for(final DiagramElement tmpElement : selectedDiagramElements) {
					m.setSize(tmpElement, newSize);
				}
			}
		});
	}
}
