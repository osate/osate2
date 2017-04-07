package org.osate.ge.internal.graphiti;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class PictogramElementUtil {
	/**
	 * Returns null if it is unable get the business object context for any pictogram element
	 * @param pes
	 * @return
	 */
	public static BusinessObjectContext[] getBusinessObjectContexts(final GraphitiAgeDiagram graphitiAgeDiagram, final PictogramElement[] pes) {
		final BusinessObjectContext[] diagramElements = new BusinessObjectContext[pes.length];
		for(int i = 0; i < pes.length; i++) {
			final BusinessObjectContext boc = graphitiAgeDiagram.getClosestDiagramNode(pes[i]);
			
			// Return null if we are unable to get the pictogram element for any passed in pictogram element
			if(boc == null) {
				return null;
			}
			
			diagramElements[i] = boc;
		}

		return diagramElements;
	}
}
