package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

/**
 * Contains methods for finding and working with shapes
 * @author philip.alldredge
 *
 */
public interface ShapeService {

	/**
	 * Gets a child shape tied to a particular element. Delegates to comparison by element name because there are scenarios where names can be duplicated. For example
	 * an invalid model during copy and paste operations.
	 * @param shape
	 * @param el
	 * @return
	 */
	ContainerShape getChildShapeByElementQualifiedName(ContainerShape shape,
			NamedElement el);

	ContainerShape getChildShapeByElementName(ContainerShape shape,
			NamedElement el);

	/**
	 * Gets a descendant shape that is linked to a particular AADL element. Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param el
	 * @return
	 */
	ContainerShape getDescendantShapeByElement(ContainerShape shape, Element el);

	/**
	 * Gets a descendant shape that is linked to a an AADL element with the same same as the specified elmeent. Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param el
	 * @return
	 */
	ContainerShape getDescendantShapeByElementName(ContainerShape shape,
			NamedElement el);

	Shape getChildShapeByName(ContainerShape shape, String name);

	/**
	 * Determines whether s1 contains s2
	 * @param s1
	 * @param s2
	 * @return
	 */
	boolean doesShapeContain(Shape s1, Shape s2);

}