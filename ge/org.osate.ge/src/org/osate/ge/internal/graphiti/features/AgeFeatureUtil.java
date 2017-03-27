package org.osate.ge.internal.graphiti.features;

import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class AgeFeatureUtil {
	private static String PROPERTY_MODIFICATION = "org.osate.ge.mod";
	
	public static AgeDiagramElement getDiagramElement(PictogramElement pe, final GraphitiAgeDiagram graphitiAgeDiagram) {
		DiagramNode result = graphitiAgeDiagram.getDiagramNode(pe);
		while(result == null ) {
			if(pe instanceof ConnectionDecorator) {
				pe = ((ConnectionDecorator) pe).getConnection();
			} else if(pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			} else {
				break;
			}
			
			result = graphitiAgeDiagram.getDiagramNode(pe);
		}
		
		return result instanceof AgeDiagramElement ? (AgeDiagramElement)result : null;
	}
	
	/**
	 * Stores a modification in a Graphiti context to allow for undo/redo
	 * @param context
	 * @param mod
	 */
	public static void storeModificationInContext(final IContext context, final DiagramModification mod) {
		context.putProperty(PROPERTY_MODIFICATION, mod);
	}
	
	public static boolean canUndo(final IContext context) {
		final DiagramModification previousModification = (DiagramModification)context.getProperty(PROPERTY_MODIFICATION);
		return previousModification != null && previousModification.isUndoable();
	}
	
	public static void undoModification(final GraphitiAgeDiagram graphitiAgeDiagram, final IContext context) {
		final DiagramModification previousModification = (DiagramModification)context.getProperty(PROPERTY_MODIFICATION);
		if(previousModification != null) {
			graphitiAgeDiagram.modify(new DiagramModifier() {
				@Override
				public void modify(final DiagramModification m) {
					((DiagramModification)m).undoModification(previousModification);
				}				
			}, false);
		}
	}
	
	public static boolean canRedo(final IContext context) {
		final DiagramModification previousModification = (DiagramModification)context.getProperty(PROPERTY_MODIFICATION);
		return previousModification != null && previousModification.isRedoable();
	}
	
	public static void redoModification(final GraphitiAgeDiagram graphitiAgeDiagram, final IContext context) {
		final DiagramModification previousModification = (DiagramModification)context.getProperty(PROPERTY_MODIFICATION);
		if(previousModification != null) {
			graphitiAgeDiagram.modify(new DiagramModifier() {
				@Override
				public void modify(final DiagramModification m) {
					((DiagramModification)m).redoModification(previousModification);
				}				
			}, false);
		}
	}
}
