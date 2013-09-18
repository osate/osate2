package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;

/**
 * Contains methods for working with AADL prototypes
 * @author philip.alldredge
 *
 */
public interface PrototypeService {
	/**
	 * @param shape
	 * @param fp
	 * @return
	 */
	Element getPrototypeBindingContext(Shape shape);
}
