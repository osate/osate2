/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.osate.ge.services.GraphicsAlgorithmManipulationService;

public class DefaultGraphicsAlgorithmManipulationService implements GraphicsAlgorithmManipulationService {
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmService#mirror(org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm)
	 */
	@Override
	public void mirror(final GraphicsAlgorithm ga) {
		mirror(ga, ga);
	}
	
	/**
	 * Mirrors graphics algorithm in the x axis
	 * @param rootGa the graphics algorithm that will be treated at the top level graphics algorithm. The top level graphics algorithm will not be moved.
	 * @param ga the graphics algorithm to mirror
	 */
	private static void mirror(final GraphicsAlgorithm rootGa, final GraphicsAlgorithm ga) {
		if(rootGa != ga) {
			ga.setX(ga.getParentGraphicsAlgorithm().getWidth() - ga.getX() - ga.getWidth());
		}
		
		if(ga instanceof Polyline) {
			// Mirror every point in the polyline
			final Polyline polyline = (Polyline)ga;
			for(final Point p : polyline.getPoints()) {
				p.setX(ga.getWidth()-p.getX());
			}
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			mirror(rootGa, childGa);
		}
	}
	
	// TODO: Make note of when this method causes issues(out of bounds drawing)
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmService#shrink(org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm)
	 */
	@Override
	public void shrink(final GraphicsAlgorithm ga) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
	
		// Determine the min/max x/y of all children.
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			if(childGa instanceof Polyline) {
				shrinkPolyline((Polyline)childGa);
			}
			
			minX = Math.min(minX, childGa.getX());
			maxX = Math.max(maxX, childGa.getX()+childGa.getWidth());
			minY = Math.min(minY, childGa.getY());
			maxY = Math.max(maxY, childGa.getY()+childGa.getHeight());
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			childGa.setX(childGa.getX() - minX);
			childGa.setY(childGa.getY() - minY);
		}
		
		ga.setX(ga.getX() + minX);
		ga.setY(ga.getY() + minY);
		ga.setWidth(maxX - minX);
		ga.setHeight(maxY - minY);
	}
	
	/**
	 * @param polyline
	 */
	private static void shrinkPolyline(final Polyline polyline) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(final Point p : polyline.getPoints()) {
			minX = Math.min(minX, p.getX());
			maxX = Math.max(maxX, p.getX());
			minY = Math.min(minY, p.getY());
			maxY = Math.max(maxY, p.getY());
		}
		
		for(final Point p : polyline.getPoints()) {
			p.setX(p.getX()-minX);
			p.setY(p.getY()-minY);
		}
		
		polyline.setX(polyline.getX() + minX);
		polyline.setY(polyline.getY() + minY);
		polyline.setWidth(maxX-minX);
		polyline.setHeight(maxY-minY);
	}
}
