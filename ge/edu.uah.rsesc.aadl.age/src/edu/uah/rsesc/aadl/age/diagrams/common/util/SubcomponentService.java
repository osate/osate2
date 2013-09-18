package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;

/**
 * Contains methods for working with AADL Subcomponents
 * @author philip.alldredge
 *
 */
public interface SubcomponentService {
	ComponentClassifier getComponentClassifier(Shape shape, Subcomponent sc);

	ComponentCategory getComponentCategory(Shape shape, Subcomponent sc);

	boolean isImplementation(Shape shape, Subcomponent sc);
}
