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
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.diagram.DiagramElement;
import org.osate.ge.internal.Activator;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;

public class MatchSizeAction extends SelectionAction {	
	final private AgeDiagramEditor editor;
	final public static String MATCH_SIZE = "org.osate.ge.ui.editor.items.match_size";
	final public static ImageDescriptor matchSizeImageDescriptor = Activator.getImageDescriptor("icons/Match.gif");
	final public static ImageDescriptor matchSizeDisabledImageDescriptor = Activator.getImageDescriptor("icons/Match_Disabled.gif");
	
	protected MatchSizeAction(final IWorkbenchPart part) {
		super(part);
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(matchSizeImageDescriptor);
		setDisabledImageDescriptor(matchSizeDisabledImageDescriptor);
		setId(MATCH_SIZE);
	}

	//Matches the height and width of every shape selected with the final shape selected.   
	@Override 
	public void run(){
		for(final Object selectedObject : getSelectedObjects()) {
			System.err.println("SELECTED OBJECT: " + selectedObject);
		}
		
		// TODO: Should use diagram modification here...
		
		/*
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Match Height and Width") {
			@Override
			protected void doExecute() {
			*/
				final Collection<ResizeShapeContext> ctxs = getResizeContextsFromEditorSelection();
				if(ctxs != null) {
					final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
					for(final ResizeShapeContext ctx : ctxs) {
						final IResizeShapeFeature feature = fp.getResizeShapeFeature(ctx);
						feature.execute(ctx);
					}
				}
			/*}
		});
		*/
	}
	
	private DiagramElement[] getDiagramElements(final List<?> object) {
		
	}

	//Updates action being available based on how many pictograms are selected
	@Override
	protected boolean calculateEnabled() {
		return getResizeContextsFromEditorSelection() != null;
	}
	
	/**
	 * Performs validation and builds and returns a collection of contexts
	 * @return the contexts. Returns null if validation fails.
	 */
	private Collection<ResizeShapeContext> getResizeContextsFromEditorSelection() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length < 2) {
			return null;
		}
		
		if(!LayoutUtil.areAllShapes(pes)) {
			return null;
		}
				
		final Shape[] shapes = Arrays.copyOf(pes, pes.length, Shape[].class);
		if(!LayoutUtil.haveSameContainerShapes(shapes)) {
			return null;
		}
			
		final Collection<ResizeShapeContext> resizeContexts = getResizeContexts(shapes);
		final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
		for(final ResizeShapeContext ctx : resizeContexts) {
			final IResizeShapeFeature feature = fp.getResizeShapeFeature(ctx);
			if(feature == null || !feature.canExecute(ctx)) {
				return null;
			}
		}
		
		return resizeContexts;
	}
	
	private static Collection<ResizeShapeContext> getResizeContexts(final Shape[] shapes) {
		final Collection<ResizeShapeContext> result = new ArrayList<ResizeShapeContext>(); 
		
		for (final Shape shape : shapes) {
			final ResizeShapeContext newResizeContext = new ResizeShapeContext(shape);
			newResizeContext.setLocation(shape.getGraphicsAlgorithm().getX(), shape.getGraphicsAlgorithm().getY());
			newResizeContext.setHeight(shapes[shapes.length-1].getGraphicsAlgorithm().getHeight());
			newResizeContext.setWidth(shapes[shapes.length-1].getGraphicsAlgorithm().getWidth());
			
			result.add(newResizeContext);
		}
		
		return result;
	}
}
