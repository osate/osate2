/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.ShapeService;

public class DefaultShapeService implements ShapeService {
	private final PropertyService propertyUtil;
	private final BusinessObjectResolutionService bor;
	
	public DefaultShapeService(final PropertyService propertyUtil, final BusinessObjectResolutionService bor) {
		this.propertyUtil = propertyUtil;
		this.bor = bor;
	}
	
	@Override
	public List<Shape> getNonGhostChildren(final ContainerShape shape) {
		final List<Shape> children = new ArrayList<Shape>();
		for(final Shape child : shape.getChildren()) {
			if(!propertyUtil.isGhost(child)) {
				children.add(child);
			}
		}
		
		return children;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ShapeService#getChildShapeByElementQualifiedName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */
	@Override
	public Shape getChildShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && areQualifiedNamesEqual((NamedElement)bo, el)) {
				return c;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ShapeService#getChildShapeByElementName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */
	@Override
	public Shape getChildShapeByElementName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && areNamesEqual((NamedElement)bo, el)) {
				return c;
			}
		}
		return null;
	}
		
	@Override
	public Shape getDescendantShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(c);			
			if(childBo instanceof NamedElement && areQualifiedNamesEqual((NamedElement)childBo, el)) {
				return c;
			} else if(childBo == null && c instanceof ContainerShape) {
				final Shape recResult = getDescendantShapeByElementQualifiedName((ContainerShape)c, el);
				if(recResult != null) {
					return recResult;
				}
			}
		}

		return null;
	}	
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ShapeService#getDescendantShapeByElementName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */	
	@Override
	public Shape getDescendantShapeByElementName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(c);			
			if(childBo instanceof NamedElement && areNamesEqual((NamedElement)childBo, el)) {
				return c;
			} else if(childBo == null && c instanceof ContainerShape) {
				final Shape recResult = getDescendantShapeByElementName((ContainerShape)c, el);
				if(recResult != null) {
					return recResult;
				}
			}
		}
		
		return null;
	}	

	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ShapeService#getChildShapeByName(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.String)
	 */
	@Override
	public Shape getChildShapeByName(final ContainerShape shape, final String name) {
		for(final Shape child : getNonGhostChildren(shape)) {
			if(name.equals(propertyUtil.getName(child))) {
				return child;
			}
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ShapeService#doesShapeContain(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Shape)
	 */
	@Override
	public boolean doesShapeContain(final Shape s1, final Shape s2) {
		Shape temp = s2.getContainer();
		while(temp != null) {
			if(temp == s1) {
				return true;
			}
			
			temp = temp.getContainer();
		}
		return false;
	}
	
	private boolean areNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getName() == null || e2 == null || e2.getName() == null)
			return false;

		return e1.getName().equalsIgnoreCase(e2.getName());
	}
	
	private boolean areQualifiedNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getQualifiedName() == null || e2 == null || e2.getQualifiedName() == null)
			return false;

		return e1.getQualifiedName().equalsIgnoreCase(e2.getQualifiedName());
	}
	
	@Override
	public Shape getClosestAncestorWithBusinessObjectType(final Shape s, final Class<?> ... boTypes) {
		for(Shape tmpShape = s; tmpShape != null; tmpShape = tmpShape.getContainer()) {
			final Object tmpShapeBo = bor.getBusinessObjectForPictogramElement(tmpShape);
			for(Class<?> tmpClass : boTypes) {
				if(tmpClass.isInstance(tmpShapeBo)) {
					return tmpShape;
				}	
			}			
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getClosestBusinessObjectOfType(Shape s, final Class<?> ... types) {
		for(Shape tmpShape = s; tmpShape != null; tmpShape = tmpShape.getContainer()) {
			final Object tmpShapeBo = bor.getBusinessObjectForPictogramElement(tmpShape);
			for(Class<?>type : types) {
				if(type.isInstance(tmpShapeBo)) {
					return (T)tmpShapeBo;
				}	
			}			
		}
		
		return null;
	}
}
