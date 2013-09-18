package edu.uah.rsesc.aadl.age.services;

import java.util.Collection;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;

/**
 * Contains methods for creating shapes
 * @author philip.alldredge
 *
 */
public interface ShapeCreationService {
	void createUpdateFeatureShapes(ContainerShape shape,
			List<Feature> features, Collection<Shape> touchedShapes);

	void createUpdateModeShapes(ContainerShape shape, List<Mode> modes);

	void createUpdateShapesForElements(ContainerShape shape,
			List<? extends NamedElement> elements, int startX, boolean incX,
			int xPadding, int startY, boolean incY, int yPadding);
}
