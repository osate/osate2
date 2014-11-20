/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.NamedElement;

/**
 * Contains methods for finding and working with shapes
 * @author philip.alldredge
 *
 */
public interface ShapeService {
	List<Shape> getNonGhostChildren(ContainerShape shape);
	
	/**
	 * Gets a child shape tied to a particular element. Delegates to comparison by element name because there are scenarios where names can be duplicated. For example
	 * an invalid model during copy and paste operations.
	 * Note: This method will return ghosted children.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getChildShapeByElementQualifiedName(ContainerShape shape,
			NamedElement el);

	/**
	 * Note: This method will return ghosted children.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getChildShapeByElementName(ContainerShape shape,
			NamedElement el);

	/**
	 * Gets a descendant shape that is linked to a an AADL element with the same qualified same as the specified element. Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getDescendantShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el);
	
	/**
	 * Gets a descendant shape that is linked to a an AADL element with the same same as the specified element. Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getDescendantShapeByElementName(ContainerShape shape,
			NamedElement el);

	Shape getChildShapeByName(ContainerShape shape, String name);

	/**
	 * Determines whether s1 contains s2
	 * @param s1
	 * @param s2
	 * @return
	 */
	boolean doesShapeContain(Shape s1, Shape s2);
	
	/**
	 * Returns the closest ancestor shape that has a business object of one of the specified types. If the shape has a business object of one of the specified types, the shape will be returned.
	 * @param s
	 * @return
	 */
	Shape getClosestAncestorWithBusinessObjectType(Shape s, Class<?> ... boTypes);

	/**
	 * Returns the business object of the closest ancestor shape which has a business object of one of the specified types.
	 * @param s
	 * @return
	 */
	<T> T getClosestBusinessObjectOfType(Shape s, Class<?> ... types);
}