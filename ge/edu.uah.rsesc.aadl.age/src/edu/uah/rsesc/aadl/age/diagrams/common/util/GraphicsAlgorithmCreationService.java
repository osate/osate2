package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.PortCategory;

public interface GraphicsAlgorithmCreationService {

	Text createLabelGraphicsAlgorithm(GraphicsAlgorithmContainer container,
			Diagram diagram, String labelTxt);

	/**
	 * Creates a graphics algorithm representing a specified classifer or subcomponent. 
	 * @param shape
	 * @param diagram
	 * @param element the classifier or subcomponent for which to create the graphics algorithm. If the classifier is null then a generic representation is returned.
	 * @param width
	 * @param height
	 * @return
	 */
	GraphicsAlgorithm createClassifierGraphicsAlgorithm(Shape shape,
			Diagram diagram, Element element, int width, int height);

	GraphicsAlgorithm createFeatureGraphicsAlgorithm(Shape shape,
			Diagram diagram, Feature feature);

	GraphicsAlgorithm createPortGraphicsAlgorithm(Shape shape, Diagram diagram,
			PortCategory category, DirectionType direction);

	GraphicsAlgorithm createAbstractFeatureGraphicsAlgorithm(Shape shape,
			Diagram diagram, DirectionType direction);

	GraphicsAlgorithm createAccessGraphicsAlgorithm(Shape shape,
			Diagram diagram, AccessCategory category, AccessType accessType);

	GraphicsAlgorithm createModeGraphicsAlgorithm(
			GraphicsAlgorithmContainer container, Diagram diagram, int width,
			int height);

	GraphicsAlgorithm createInitialModeGraphicsAlgorithm(
			GraphicsAlgorithmContainer container, Diagram diagram, int size);

	GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(
			GraphicsAlgorithmContainer container, Diagram diagram, int width,
			int height);

}