// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.NamedElement;

/**
 * Contains methods for finding and working with shapes
 *
 */
public interface ShapeService {
	List<Shape> getNonGhostChildren(ContainerShape shape);
	
	/**
	 * Gets a child shape tied to a particular business object. The business object comparison is done using serializable references
	 * Note: This method will return ghosted children.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getChildShapeByReference(ContainerShape shape, Object bo);

	/**
	 * Note: This method will not return invisible shapes. The method will returns null if the specified shape is not visible.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getChildShapeByElementName(ContainerShape shape,
			NamedElement el);

	/**
	 * Gets a descendant shape tied to a particular business object. The business object comparison is done using serializable references
	 * Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getDescendantShapeByReference(final ContainerShape shape, final Object bo);
		
	/**
	 * Gets a descendant shape that is linked to a an AADL element with the same same as the specified element. Does not look at children if the child shape is associated with another object.
	 * Only looks for visible shapes.
	 * @param shape
	 * @param el
	 * @return
	 */
	Shape getDescendantShapeByElementName(ContainerShape shape,
			NamedElement el);

	Shape getChildShapeByName(ContainerShape shape, String name);
	
	List<Shape> getChildShapesByName(ContainerShape shape, String name);

	
	/**
	 * Finds a descendant shape that is linked to the specified business object. Unlike getDescendantShape*, this method does look into children that are associated with another object
	 * @param shape
	 * @param bo
	 * @return
	 */
	Shape findDescendantShapeByReference(ContainerShape shape, Object bo);
	
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