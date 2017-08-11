package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.services.QueryService;

/**
 * Contains simple methods that are shared between UI contributions
 *
 */
class ContributionHelper {
	public static QueryService getQueryService(final AgeDiagramEditor editor) {
		if(editor == null) {
			return null;
		}
		
		return (QueryService)editor.getAdapter(QueryService.class);
	}
	
	public static ColoringService getColoringService(final AgeDiagramEditor editor) {
		if(editor == null) {
			return null;
		}
		
		return (ColoringService)editor.getAdapter(ColoringService.class);
	}
	
	// TODO: Migrate to use adapters to get DiagramElement when that capability is merged
	/**
	 * Returns null if a diagram element could not be retrieved for any of the currently selected objects.
	 * @return
	 */
	public static List<DiagramElement> getSelectedDiagramElements(final AgeDiagramEditor editor, 
			final List<?> selectedObjects) {
		final GraphitiAgeDiagram graphitiAgeDiagram = editor.getGraphitiAgeDiagram();
		if(graphitiAgeDiagram == null) { 
			throw new RuntimeException("Unable to get graphiti diagram");
		}

		final List<DiagramElement> results = new ArrayList<DiagramElement>();
		
		for(final Object selectedObject : selectedObjects) {
			if(!(selectedObject instanceof EditPart)) {
				return null;
			}
			
			final EditPart editPart = (EditPart)selectedObject;
			if(!(editPart.getModel() instanceof PictogramElement)) {
				return null;
			}
			
			final PictogramElement pe = (PictogramElement)editPart.getModel();
			final DiagramElement de = graphitiAgeDiagram.getDiagramElement(pe);
			if(de == null) {
				return null;
			}
			
			results.add(de);
		}
		
		return results;
	}
	
	public static boolean allHaveSameParent(final Collection<DiagramElement> diagramElements) {
		if(diagramElements.size() == 0) {
			return true;
		}
		
		final DiagramNode parent = diagramElements.iterator().next().getParent();
		return diagramElements.stream().allMatch(de -> de.getParent() == parent);
	}
}
