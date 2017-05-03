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
import java.util.Objects;

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

public class DistributeHorizontallyAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public static final String DISTRIBUTE_HORIZONTALLY = "org.osate.ge.ui.editor.items.distribute_horizontally";
	public static final ImageDescriptor horizontalImageDescriptor = Activator.getImageDescriptor("icons/DistributeHorizontally.gif");
	public static final ImageDescriptor horizontalDisabledImageDescriptor = Activator.getImageDescriptor("icons/DistributeHorizontally_Disabled.gif");

	public DistributeHorizontallyAction(final IWorkbenchPart part) {
		super(part); 
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(horizontalImageDescriptor);
		setDisabledImageDescriptor(horizontalDisabledImageDescriptor);
		setId(DISTRIBUTE_HORIZONTALLY);
	}

	/**
	 * Distributes shapes along the X axis so each shape has an equal distance between them
	 */
	@Override
	public void run(){
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Distribute Horizontally") {
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

	/**
	 * Updates whether action is available based on if shapes selected are valid
	 */
	@Override
	protected boolean calculateEnabled() {
		return getMoveShapeContextsFromEditorSelection() != null;
	}
	
	/**
	 * Calculate the width of the middle shapes, used for distribution calculations
	 * @param shapes the selected shapes
	 * @return the width of the middle shapes
	 */
	private static int getWidthOfShapes(final Shape[] shapes) {
		int result = 0;
		//Iterate on shapes between first and last shape selected
		for (int i=shapes.length-2;i>0;i--) {
			result = shapes[i].getGraphicsAlgorithm().getWidth()+result;
		}
		
		return result;
	}
	
	/**
	 * Performs validation, builds, and returns a collection of contexts
	 * @return the contexts. Returns null if validation fails.
	 */
	private Collection<MoveShapeContext> getMoveShapeContextsFromEditorSelection() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length < 3) {
			return null;
		}

		if(!LayoutUtil.areAllShapes(pes)) {
			return null;
		}
		
		final Shape[] shapes = Arrays.copyOf(editor.getSelectedPictogramElements(), pes.length, Shape[].class);		
		if(!LayoutUtil.haveSameContainerShapes(shapes)) {
			return null;
		}

		Arrays.sort(shapes, XValueComparator);
		
		final Collection<MoveShapeContext> moveShapeCtxs = getMoveShapeContexts(shapes);
		final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
		for (final MoveShapeContext ctx : moveShapeCtxs) {
			final IMoveShapeFeature moveFeature = fp.getMoveShapeFeature(ctx);
			if (moveFeature == null || !moveFeature.canExecute(ctx)) {
				return null;
			}
		}
		
		return moveShapeCtxs;
	}
	
	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param shapes the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static int getXDistribution(final Shape[] shapes) {
		final int arrayLength = shapes.length-1;
		final int widthOfShapes = getWidthOfShapes(shapes);
		final GraphicsAlgorithm firstShapeGA = shapes[0].getGraphicsAlgorithm();
		final GraphicsAlgorithm lastShapeGA = shapes[arrayLength].getGraphicsAlgorithm();
		
		return (lastShapeGA.getX()-(firstShapeGA.getX()+firstShapeGA.getWidth())-widthOfShapes)/arrayLength;
	}
	
	/**
	 * Calculate the selected shapes new distribution location information
	 * @param shapes the selected shapes
	 * @return the list contexts that contain the shapes new locations
	 */
	private static Collection<MoveShapeContext> getMoveShapeContexts(final Shape[] shapes) {
		final Collection<MoveShapeContext> result = new ArrayList<MoveShapeContext>();
		final int xDistribution = getXDistribution(shapes);
		for (int i=1;i<shapes.length-1;i++) {
			final Shape shape = shapes[i];
			final int xValue = getXValue(shapes[i-1].getGraphicsAlgorithm(), xDistribution);
			final int yValue = shape.getGraphicsAlgorithm().getY();
			final ContainerShape container = shape.getContainer();

			result.add(LayoutUtil.getDistributeMoveShapeContext(shape, xValue, yValue, container));
		}
		
		return result;
	}
	
	/**
	 * Calculate the X-coordinate value for the shape being evaluated
	 * @param prevShapeGA the GraphicsAlgorithm of the shape just before the current shape being evaluated
	 * @param xDistribution the X-coordinate distance that needs to be between each shape
	 * @return the X-coordinate value for the shape being evaluated
	 */
	private static int getXValue(final GraphicsAlgorithm prevShapeGA, final int xDistribution) {
		return prevShapeGA.getX()+prevShapeGA.getWidth()+xDistribution;
	}

	/**
	 * Sort the selected shapes based on X-coordinate value
	 */
	private static final Comparator<Shape> XValueComparator 
	= new Comparator<Shape>() {
		@Override
		public int compare(final Shape xShape1, final Shape xShape2) {
			return Integer.valueOf(xShape1.getGraphicsAlgorithm().getX()).compareTo(xShape2.getGraphicsAlgorithm().getX());
		}
	};
}