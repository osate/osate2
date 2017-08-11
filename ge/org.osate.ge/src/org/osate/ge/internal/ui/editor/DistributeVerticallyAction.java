/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.internal.Activator;

public class DistributeVerticallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public final static String DISTRIBUTE_VERTICALLY = "org.osate.ge.ui.editor.items.distribute_vertically";
	public static final ImageDescriptor verticalImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically.gif");
	public static final ImageDescriptor verticalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeVertically_Disabled.gif");
	
	public DistributeVerticallyAction(final IWorkbenchPart part) {
		super(part);
		this.editor = (AgeDiagramEditor)part;
		setHoverImageDescriptor(verticalImageDescriptor);
		setDisabledImageDescriptor(verticalDisabledImageDescriptor);
		setId(DISTRIBUTE_VERTICALLY);
	}
	
	/**
	 * Distributes shapes along the Y axis so each shape has an equal distance between them
	 */
	@Override
	public void run() {
		if (editor != null && editor.getSelectedPictogramElements().length >= 3){
			editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Vertically") {
				@Override
				protected void doExecute() {
					final Collection<MoveShapeContext> ctxs = getMoveShapeContextsFromEditorSelection();
					if(ctxs != null) {
						for (final MoveShapeContext ctx : ctxs) {
							final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
							final IMoveShapeFeature feature = fp.getMoveShapeFeature(ctx);
							feature.execute(ctx);
						}	
					}
				}
			});
		}
	}

	/**
	 * Updates whether action is available based on if shapes selected are valid
	 */
	@Override
	protected boolean calculateEnabled() {
		return getMoveShapeContextsFromEditorSelection() != null;
	}

	/**
	 * Performs validation, builds, and returns a collection of contexts
	 * @return the contexts. Returns null if validation fails.
	 */
	private Collection<MoveShapeContext> getMoveShapeContextsFromEditorSelection() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length<3) {
			return null;
		}
		
		if(!LayoutUtil.areAllUndockedMoveableShapes(pes, editor.getGraphitiAgeDiagram())) {
			return null;
		}
		
		final Shape[] shapes = Arrays.copyOf(pes, pes.length, Shape[].class);
		if(!LayoutUtil.haveSameContainerShapes(shapes)) {
			return null;
		}
		
		Arrays.sort(shapes, YValueComparator);
		
		final Collection<MoveShapeContext> moveShapeCtxs = getMoveShapeContext(shapes);
		final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
		for (final MoveShapeContext ctx : moveShapeCtxs) {
			final IMoveShapeFeature moveFeature = fp.getMoveShapeFeature(ctx);
			if (moveFeature == null || !moveFeature.canExecute(ctx)) {
				return null;
			}
		}
		
		return moveShapeCtxs;
	}

	private Collection<MoveShapeContext> getMoveShapeContext(final Shape[] shapes) {
		final Collection<MoveShapeContext> result = new ArrayList<MoveShapeContext>();
		final int yDistribution = getYDistribution(shapes);
		for (int i=1;i<shapes.length-1;i++) {
			final Shape shape = shapes[i];
			final int xValue = shape.getGraphicsAlgorithm().getX();
			final int yValue = getYValue(shapes[i-1].getGraphicsAlgorithm(), yDistribution);
			final ContainerShape container = shape.getContainer();

			result.add(LayoutUtil.getDistributeMoveShapeContext(shape, xValue, yValue, container));
		}
		
		return result;
	}
	
	/**
	 * Calculate the height of the middle shapes, used for distribution calculations
	 * @param shapes the selected shapes
	 * @return the height of the middle shapes
	 */
	private static int getHeightOfShapes(final Shape[] shapes) {
		int result = 0;
		//Iterate on shapes between first and last shape selected
		for (int i=shapes.length-2;i>0;i--) {
			result = shapes[i].getGraphicsAlgorithm().getHeight()+result;
		}
		
		return result;
	}
	
	/**
	 * Calculate the Y-coordinate value for the shape being evaluated
	 * @param prevShapeGA the GraphicsAlgorithm of the shape just before the current shape being evaluated
	 * @param yDistribution the Y-coordinate distance that needs to be between each shape
	 * @return the Y-coordinate value for the shape being evaluated
	 */
	private static int getYValue(final GraphicsAlgorithm prevShapeGA, final int yDistribution) {
		return prevShapeGA.getY()+prevShapeGA.getHeight()+yDistribution;
	}
	
	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param shapes the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static int getYDistribution(final Shape[] shapes) {
		final int arrayLength = shapes.length-1;
		final int heightOfShapes = getHeightOfShapes(shapes);
		final GraphicsAlgorithm firstShapeGA = shapes[0].getGraphicsAlgorithm();
		final GraphicsAlgorithm lastShapeGA = shapes[arrayLength].getGraphicsAlgorithm();
		
		return (lastShapeGA.getY()-(firstShapeGA.getY()+firstShapeGA.getHeight())-heightOfShapes)/arrayLength;
	}
	
	/**
	 * Sort the selected shapes based on Y-coordinate value
	 */
	private static final Comparator<Shape> YValueComparator 
	= new Comparator<Shape>() {
		@Override
		public int compare(final Shape yShape1, final Shape yShape2) {
			return Integer.valueOf(yShape1.getGraphicsAlgorithm().getY()).compareTo(yShape2.getGraphicsAlgorithm().getY());
		}
	};
}

