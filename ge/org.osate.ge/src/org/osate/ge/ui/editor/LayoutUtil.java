package org.osate.ge.ui.editor;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class LayoutUtil {
	public static boolean areAllShapes(final PictogramElement[] pes) {
		for(final PictogramElement pe : pes) {
			if(!(pe instanceof Shape)) {
				return false;
			}
		}
		
		return true;
	}	
	
	public static boolean haveSameContainerShapes(final Shape[] shapes) {
		if(shapes.length == 0) {
			throw new RuntimeException("shapes is empty");
		}
		
		final ContainerShape containerShape = shapes[0].getContainer();
		for (int i=1;i<shapes.length;i++) {
			if (shapes[i].getContainer() != containerShape) {
				return false;
			}
		}
		
		return true;
	}
}
