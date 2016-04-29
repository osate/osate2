/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import javax.inject.Inject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.util.Log;

public class UpdateClassifierDiagramFeature extends AbstractUpdateFeature implements ICustomUndoRedoFeature, DiagramUpdateFeature {
	private final InternalReferenceBuilderService refBuilder;
	private final StyleService styleService;
	private final GhostingService ghostingService;
	private final ShapeService shapeService;
	
	@Inject
	public UpdateClassifierDiagramFeature(final IFeatureProvider fp, final InternalReferenceBuilderService refBuilder, final StyleService styleService, final GhostingService ghostingService, final ShapeService shapeService) {
		super(fp);
		this.refBuilder = refBuilder;
		this.styleService = styleService;
		this.ghostingService = ghostingService;
		this.shapeService = shapeService;
	}

	private Classifier getClassifier(final IUpdateContext context) {
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		if(bo instanceof Classifier) {
			return (Classifier)bo;
		}
		
		return null;
	}
		
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return true;
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createTrueReason("");
	}

	@Override
	public boolean update(final IUpdateContext context) {
		Log.info("Called with context: " + context);
		final Classifier classifier = getClassifier(context);
		if(classifier == null) {
			final Status status = new Status(IStatus.ERROR, Activator.getPluginId(), "Unable to update diagram. Unable to find AADL model element associated with diagram.", null);
			StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
			return false;
		}
		
		// Update the diagram's name
		final Diagram diagram = getDiagram();
		final String newTitle = refBuilder.getTitle(classifier);
		if(newTitle != null) {
			diagram.setName(newTitle);
		}
		
		styleService.refreshStyles();
				
		// Remove shapes that are invalid
		ghostingService.ghostChildShapes(diagram);

		// Add/Update the shape for the classifier
		final PictogramElement pe = shapeService.getDescendantShapeByReference(diagram, classifier);
		if(pe == null) {
			final AddContext addContext = new AddContext();
			addContext.setNewObject(new AadlElementWrapper(classifier));
			addContext.setTargetContainer(diagram);
			addContext.setX(50);
			addContext.setY(20);
			addContext.setWidth(500);
			addContext.setHeight(500);
			final IAddFeature feature = this.getFeatureProvider().getAddFeature(addContext);
			if(feature != null && feature.canAdd(addContext)) {
				feature.execute(addContext);
			}
		} else {
			final UpdateContext updateContext = new UpdateContext(pe);
			final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
			
			// Update the classifier regardless of whether it is "needed" or not.
			if(updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
			}
		}
		
		// Adjust positions of shapes that have not been positioned.
		final ICustomContext layoutCtx = LayoutDiagramFeature.createContext(false);
		for(ICustomFeature feature : this.getFeatureProvider().getCustomFeatures(layoutCtx)) {
			if(feature instanceof LayoutDiagramFeature) {
				feature.execute(layoutCtx);
				break;
			}
		}

		return false;
	}

	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
