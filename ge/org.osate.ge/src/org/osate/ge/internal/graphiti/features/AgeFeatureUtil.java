package org.osate.ge.internal.graphiti.features;

import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class AgeFeatureUtil {
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
}
