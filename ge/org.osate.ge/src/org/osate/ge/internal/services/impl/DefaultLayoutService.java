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
package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;

public class DefaultLayoutService implements LayoutService {
	private final PropertyService propertyService;
	private final ShapeService shapeService;
	private final IFeatureProvider fp;
	private final static int minimumWidth = 150;
	private final static int minimumHeight = 50;
	private final Comparator<Shape> yComparator = new Comparator<Shape>() {
		@Override
		public int compare(final Shape s1, final Shape s2) {
			if(s1.getGraphicsAlgorithm() == null) {
				return -1;
			} else if(s2.getGraphicsAlgorithm() == null) {
				return 1;
			}
			
			return Integer.compare(s1.getGraphicsAlgorithm().getY(), s2.getGraphicsAlgorithm().getY());
		}		
	};

	public DefaultLayoutService(final PropertyService propertyService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.propertyService = propertyService;
		this.shapeService = shapeService;
		this.fp = fp;
	}	
	
	@Override
	public boolean checkShapeBounds(final ContainerShape shape) {
		final ContainerShape container = shape.getContainer();		
		if(container instanceof Diagram) {
			return false;
		}
		
		boolean layoutShape = false;
		
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final int endX = ga.getX() + ga.getWidth();
		final int endY = ga.getY() + ga.getHeight();
		if(ga.getX() < 0 || ga.getY() < 0 || endX > containerGa.getWidth()|| endY > containerGa.getHeight()) {
			layoutShape = true;
		}	

		if(layoutShape) {
			final LayoutContext context = new LayoutContext(container);
			final ILayoutFeature feature = fp.getLayoutFeature(context);
			if(feature != null && feature.canLayout(context)) {
				feature.layout(context);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean checkShapeBoundsWithAncestors(final ContainerShape shape) {
		if(checkShapeBounds(shape)) {
			final ContainerShape container = shape.getContainer();
			if(container != null && !(container instanceof Diagram)) {
				checkShapeBoundsWithAncestors(container);
			}
			return true;
		}		

		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.UpdateService#layoutChildren(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public void layoutChildren(final ContainerShape shape) {
		// Layout the children first
		for(final Shape child : shapeService.getNonGhostChildren(shape)) {
			final LayoutContext ctx = new LayoutContext(child);
			final ILayoutFeature feature = fp.getLayoutFeature(ctx);
			if(feature != null && feature.canLayout(ctx)) {
				feature.layout(ctx);
			}
		}
	}
	
	@Override
	public int getMinimumWidth() {
		return minimumWidth;
	}
	
	@Override
	public int getMinimumHeight() {
		return minimumHeight;
	}
	
	private boolean isDocked(final Shape shape) {
		return propertyService.getDockArea(shape) != null;
	}

	public int[] getMinimumSize(final ContainerShape shape) {
		// Calculate max width and height
		final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
		int maxWidth = Math.max(150, shapeGa == null ? 0 : shapeGa.getWidth());
		int maxHeight = Math.max(50, shapeGa == null ? 0 : shapeGa.getHeight());
		for(final Shape childShape :  shapeService.getNonGhostChildren(shape)) {
			if(childShape.isVisible()) {
				final boolean childIsDocked = isDocked(childShape);
				if(!propertyService.isManuallyPositioned(childShape) && propertyService.isLayedOut(childShape)) {
					final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
					if(!childIsDocked) {	
						maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth());
					}			
					
					maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight());					
				}
			}
		}

		return new int[] { maxWidth, maxHeight };
	}
	
	private enum SimpleDockArea implements DockArea {
		LEFT(DOCK_AREA_ID_LEFT),
		RIGHT(DOCK_AREA_ID_RIGHT),
		FEATURE_GROUP(DOCK_AREA_ID_FEATURE_GROUP);

		public static final Map<String, SimpleDockArea> idToDockAreaMap;
		static {
			final Map<String, SimpleDockArea> modifiableMap = new HashMap<String, SimpleDockArea>();
			for(final SimpleDockArea area : SimpleDockArea.values()) {
				modifiableMap.put(area.id, area);
			}
			idToDockAreaMap = Collections.unmodifiableMap(modifiableMap);
		}
		
		public final String id;
		
		SimpleDockArea(final String id) {
			this.id = id;
		}
	}
	
	@Override
	public SimpleDockArea getDockArea(final String dockAreaId) {
		return SimpleDockArea.idToDockAreaMap.get(dockAreaId);
	}
	
	@Override
	public SimpleDockArea getDockArea(final Shape shape) {
		return getDockArea(propertyService.getDockArea(shape));
	}
	
	@Override
	public void setDockArea(final Shape shape, final DockArea dockArea) {
		propertyService.setDockArea(shape, ((SimpleDockArea)dockArea).id);
	}
	
	@Override
	public Map<DockArea, List<Shape>> buildDockAreaToChildrenMap(final ContainerShape shape, boolean includeUndockedShapes) {
		// Build mapping from dock area to shapes
		final Map<DockArea, List<Shape>> result = new HashMap<DockArea, List<Shape>>();
		for(final Shape child : shapeService.getNonGhostChildren(shape)) {
			final DockArea dockArea = getDockArea(child);
			if(includeUndockedShapes || dockArea != null) {
				List<Shape> dockAreaShapes = result.get(dockArea);
				
				// Create a new list if the shape is the first shape in the dock area
				if(dockAreaShapes == null) {
					dockAreaShapes = new ArrayList<Shape>();
					result.put(dockArea, dockAreaShapes);
				}
				
				dockAreaShapes.add(child);
			}
		}
		
		return result;
	}
	
	@Override
	public void cleanupOverlappingDockedShapes(final Map<DockArea, List<Shape>> dockAreaToShapesMap, final int yStartOffset) {
		for(final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
			if(dockAreaToShapesEntry.getKey() != null) {
				// TODO: When non-vertical dock areas are implemented, support will need to be added to this method
				// Sort shapes by order
				final List<Shape> sortedShapes = new ArrayList<Shape>(dockAreaToShapesEntry.getValue());
				Collections.sort(sortedShapes, yComparator);
				
				int minY = yStartOffset;
				for(Shape shape : sortedShapes) {
					if(shape.getGraphicsAlgorithm() != null) {
						final int newY = Math.max(shape.getGraphicsAlgorithm().getY(), minY);
						shape.getGraphicsAlgorithm().setY(newY);
						minY = newY + shape.getGraphicsAlgorithm().getHeight() + 5;
					}
				}
			}
		}
		
	}
}
