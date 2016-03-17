/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.DiagramReference;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.SubcomponentService;

/**
 * Updates a subcomponent shape to duplicate the layout of the classifier diagram associated with the subcomponent's classifier.
 *
 */
public class UpdateLayoutFromClassifierDiagramFeature extends AbstractCustomFeature {
	private final DiagramService diagramService;
	private final SubcomponentService subcomponentService;
	private final PropertyService propertyService;
	private final ShapeService shapeService;
	private final ConnectionService connectionService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public UpdateLayoutFromClassifierDiagramFeature(final DiagramService diagramService, final SubcomponentService subcomponentService, 
			final PropertyService propertyService, final ShapeService shapeService, final ConnectionService connectionService, 
			final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.diagramService = diagramService;
		this.subcomponentService = subcomponentService;
		this.propertyService = propertyService;
		this.shapeService = shapeService;
		this.connectionService = connectionService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Update Layout from Classifier Diagram";
    }
	
	@Override
	public boolean isAvailable(final IContext context) {
		if(!(context instanceof ICustomContext)) {
			return false;
		}
		
		final ICustomContext customContext = (ICustomContext)context;		
    	if(customContext.getPictogramElements().length != 1) {
    		return false;
    	}
    	
    	// Only allow when the feature is owned by the container    	
    	final PictogramElement pe = customContext.getPictogramElements()[0];
    	if(!(pe instanceof Shape)) {
    		return false;
    	}
    	
    	final Shape shape = (Shape)customContext.getPictogramElements()[0];
    	final Object bo = bor.getBusinessObjectForPictogramElement(pe);
    	return bo instanceof Subcomponent && subcomponentService.getComponentClassifier(shape, (Subcomponent)bo) != null;
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }

	@Override
	public void execute(final ICustomContext context) {
		// "dst" refers to the diagram that is being updated
		// "src" refers to the diagram whose layout is being copied 
		final Shape dstShape = (Shape)context.getPictogramElements()[0];
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(dstShape);
		final ComponentClassifier classifier = subcomponentService.getComponentClassifier(dstShape, sc);
		
		// Update the diagram before updating positions of pictogram elements
		updatePictogramElement(getDiagram());
		
		// Get the source classifier diagram and its root shape.
		final Diagram srcDiagram = findSourceDiagram(classifier);
		final Shape srcRootShape = srcDiagram == null ? null : findRootShape(srcDiagram, classifier);
		if(srcRootShape == null) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", "Unable to find classifier diagram or root shape.");
			return;
		}		

		final Map<Shape, List<Connection>> dstShapeToConnectionMap = buildShapeToConnectionMap(getDiagram());
		final Map<Shape, List<Connection>> srcShapeToConnectionMap = buildShapeToConnectionMap(srcDiagram);
		
		final Map<Shape, Shape> dstToSrcShapeMap = new HashMap<Shape, Shape>();
		dstToSrcShapeMap.put(dstShape, srcRootShape);
		
		// Adjust Inner Shapes(along with Properties for features)
		if(dstShape instanceof ContainerShape && srcRootShape instanceof ContainerShape) {
			adjustInnerShapes((ContainerShape)dstShape, (ContainerShape)srcRootShape, dstToSrcShapeMap);
		}
		
		// Resize the shape
		adjustSize(dstShape, srcRootShape.getGraphicsAlgorithm().getWidth(), srcRootShape.getGraphicsAlgorithm().getHeight());
			
		final ILocation shapeOffset = Graphiti.getPeLayoutService().getLocationRelativeToDiagram(dstShape);
		final ILocation srcRootOffset = Graphiti.getPeLayoutService().getLocationRelativeToDiagram(srcRootShape);
		final int rootOffsetX = shapeOffset.getX() - srcRootOffset.getX();
		final int rootOffsetY = shapeOffset.getY() - srcRootOffset.getY();
		for(final Entry<Shape, Shape> dstToSrcShapeEntry : dstToSrcShapeMap.entrySet()) {
			adjustConnections(dstToSrcShapeEntry.getKey(), dstShapeToConnectionMap.get(dstToSrcShapeEntry.getKey()), 
					dstToSrcShapeEntry.getValue(), srcShapeToConnectionMap.get(dstToSrcShapeEntry.getValue()),
					rootOffsetX, rootOffsetY);
		}
	}	
	
	private Map<Shape, List<Connection>> buildShapeToConnectionMap(final Diagram diagram) {
		final Map<Shape, List<Connection>> results = new HashMap<Shape, List<Connection>>();
		for(final Connection c : diagram.getConnections()) {
			final Shape ownerShape = connectionService.getOwnerShape(c);
			List<Connection> shapeConnections = results.get(ownerShape);
			if(shapeConnections == null) {
				shapeConnections = new ArrayList<Connection>();
				results.put(ownerShape, shapeConnections);
			}
			
			shapeConnections.add(c);			
		}
		
		return results;
	}
	
	// Labels, etc
	private void adjustInnerShapes(final ContainerShape shape, final ContainerShape srcShape, final Map<Shape, Shape> dstToSrcShapeMap) {
		for(final Shape innerShape : shapeService.getNonGhostChildren(shape)) {
			final Object bo = bor.getBusinessObjectForPictogramElement(innerShape);
			if(bo != null && propertyService.getName(innerShape) == null) {
				for(final Shape srcInnerShape : shapeService.getNonGhostChildren(srcShape)) {
					final Object srcBo = bor.getBusinessObjectForPictogramElement(srcInnerShape);
					if(bo == srcBo) {
						// Move the shape
						final GraphicsAlgorithm srcGa = srcInnerShape.getGraphicsAlgorithm();
						if(srcGa != null) {
							adjustSizeAndPosition(innerShape, srcGa.getX(), srcGa.getY(),srcGa.getWidth(),srcGa.getHeight());
							dstToSrcShapeMap.put(innerShape, srcInnerShape);
							
							// Adjust inner shapes
							if(bo instanceof Subcomponent || bo instanceof SubprogramCallSequence) { 
								if(innerShape instanceof ContainerShape && srcInnerShape instanceof ContainerShape) {
									adjustInnerShapes((ContainerShape)innerShape, (ContainerShape)srcInnerShape, dstToSrcShapeMap);
								}
							}
							
							break;
						}
					}
				}
			}
		}
	}
	
	private void adjustConnections(final Shape shape, final List<Connection> shapeConnections, final Shape srcShape, final List<Connection> srcShapeConnections, 
			final int rootOffsetX, final int rootOffsetY) {
		if(shape == null || shapeConnections == null || srcShape == null || srcShapeConnections == null) {
			return;
		}

		for(final Connection dc : shapeConnections) {
			final Object dstBo = bor.getBusinessObjectForPictogramElement(dc);
			for(final Connection sc : srcShapeConnections) {
				final Object srcBo = bor.getBusinessObjectForPictogramElement(sc);
				if(dstBo != null && bor.areBusinessObjectsEqual(dstBo, srcBo)) {
					// Adjust bendpoints of free form connections
					if(dc instanceof FreeFormConnection && sc instanceof FreeFormConnection) {						
						final FreeFormConnection dstFfc = (FreeFormConnection)dc;
						final FreeFormConnection srcFfc = (FreeFormConnection)sc;
						
						dstFfc.getBendpoints().clear();
						for(final Point p : srcFfc.getBendpoints()) {
							dstFfc.getBendpoints().add(Graphiti.getCreateService().createPoint(rootOffsetX + p.getX(), rootOffsetY + p.getY()));
						}
					}
				}
			}
		}
	}
	
	private void adjustSize(final Shape shape, final int width, final int height) {
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		adjustSizeAndPosition(shape, ga.getX(), ga.getY(), width, height);
	}
	
	/**
	 * Resizes and moves the shape. If adjusting the size fails because the shape is not resizable, the shape is moved.
	 * @param shape
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	private void adjustSizeAndPosition(final Shape shape, final int x, final int y, final int width, final int height) {
		final ResizeShapeContext context = new ResizeShapeContext(shape);
		context.setSize(width, height);
		context.setLocation(x, y);
		
		// Try to resize the shape
		final IResizeShapeFeature feature = getFeatureProvider().getResizeShapeFeature(context);
		if(feature != null && feature.canResizeShape(context)) {
			feature.resizeShape(context);
		} else {
			// Try simply moving the shape
			move(shape, x, y);
		}
		
	}	
	
	private void move(final Shape shape, final int x, final int y) {
		final MoveShapeContext context = new MoveShapeContext(shape);
		context.setLocation(x, y);
		context.setSourceContainer(shape.getContainer());
		context.setTargetContainer(shape.getContainer());
		
		// Move the shape
		final IMoveShapeFeature feature = getFeatureProvider().getMoveShapeFeature(context);
		if(feature != null && feature.canMoveShape(context)) {
			feature.moveShape(context);
		}
	}

	private Diagram findSourceDiagram(final ComponentClassifier classifier) {
		// Find all diagrams related to the subcomponent's classifier
		final DiagramReference diagramRef = diagramService.findFirstDiagramByRootBusinessObject(classifier);
		if(diagramRef == null) {
			return null;
		}

		// Return the diagram from the diagram reference
		return diagramRef.getDiagram();
	}
	
	private Shape findRootShape(final Diagram diagram, final ComponentClassifier classifier) {	
		for(final Shape childShape : diagram.getChildren()) {
			if(bor.getBusinessObjectForPictogramElement(childShape) == classifier) {
				return childShape;
			}			
		}
		
		return null;
	}
}
