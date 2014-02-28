/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.componentImplementation.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.patterns.AgePattern;
import org.osate.ge.diagrams.common.patterns.ModePattern;
import org.osate.ge.diagrams.common.patterns.ModeTransitionPattern;
import org.osate.ge.services.ConnectionCreationService;
import org.osate.ge.services.GraphicsAlgorithmCreationService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.VisibilityService;

/**
 * A pattern that controls the component implementation shape that contains all the other shapes in the type diagram
 * @author philip.alldredge
 */
public class ComponentImplementationPattern extends AgePattern {
	private final VisibilityService visibilityHelper;
	private final LayoutService layoutService;
	private final ShapeCreationService shapeCreationService;
	private final ConnectionCreationService connectionCreationService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	
	@Inject
	public ComponentImplementationPattern(final VisibilityService visibilityHelper, final LayoutService layoutService, final ShapeCreationService shapeCreationService, 
			final ConnectionCreationService connectionCreationService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator) {
		this.visibilityHelper = visibilityHelper;
		this.layoutService = layoutService;
		this.shapeCreationService = shapeCreationService;
		this.connectionCreationService = connectionCreationService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof ComponentImplementation;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final ComponentImplementation ci = (ComponentImplementation)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(ci));  
			
        // Finish creation
        refresh(shape, ci, context.getX(), context.getY());
        
        return shape;
	}
	
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final ComponentImplementation ci = (ComponentImplementation)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y;
			if(ga == null) {
				x = 25;
				y = 25;
			} else {
				x = ga.getX();
				y = ga.getY();
			}
			this.refresh((ContainerShape)pe, ci, x, y);
		}
		return true;
	}
	
	private void refresh(final ContainerShape shape, final ComponentImplementation ci, final int x, final int y) {
		visibilityHelper.setIsGhost(shape, false);
		
		// Remove invalid connections from the diagram
		visibilityHelper.ghostInvalidConnections(null);
		visibilityHelper.ghostInvalidConnections(ModeTransitionPattern.MODE_TRANSITION_TRIGGER_CONNECTION_TYPE);
		visibilityHelper.ghostInvalidConnections(ModePattern.INITIAL_MODE_CONNECTION_TYPE);
				
		// Remove invalid features
		visibilityHelper.ghostInvalidShapes(shape);		
			
		// Create/Update Shapes
		shapeCreationService.createUpdateFeatureShapes(shape, ci.getAllFeatures(), null);
		
		createUpdateSubcomponents(shape, ci);

		// Create/Update Modes and Mode Transitions
		shapeCreationService.createUpdateModeShapes(shape, ci.getAllModes());
		connectionCreationService.createUpdateConnections(shape, ci.getAllModeTransitions());
		connectionCreationService.createUpdateConnections(shape, ci.getAllConnections());

		// Adjust size. Width and height		
		final int newSize[] = layoutService.adjustChildShapePositions(shape);

		// Create a new graphics Algorithm
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, ci, newSize[0], newSize[1]);
		gaService.setLocation(ga, x, y);	

		layoutService.layoutChildren(shape);
	}
	
	private void createUpdateSubcomponents(final ContainerShape shape, final ComponentImplementation ci) {
		shapeCreationService.createUpdateShapesForElements(shape, ci.getAllSubcomponents(), 25, true, 30, 25, true, 20);
	}
	
	@Override
	public boolean isPaletteApplicable() {
		return false;
	}
}
