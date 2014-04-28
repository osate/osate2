/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.pkg.features;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.graphiti.features.IAddFeature;
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
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.features.LayoutDiagramFeature;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.StyleService;
import org.osate.ge.services.VisibilityService;
import org.osate.ge.util.Log;

public class PackageUpdateDiagramFeature extends AbstractUpdateFeature {
	private final StyleService styleService;
	private final ConnectionCreationService connectionCreationService;
	private final VisibilityService visibilityService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public PackageUpdateDiagramFeature(final IFeatureProvider fp, final StyleService styleService, final ConnectionCreationService connectionCreationService, final VisibilityService visibilityService, final ShapeService shapeService, final BusinessObjectResolutionService bor) {
		super(fp);
		this.styleService = styleService;
		this.connectionCreationService = connectionCreationService;
		this.visibilityService = visibilityService;
		this.shapeService = shapeService;
		this.bor = bor;
	}
	
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createTrueReason("");
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return true;
	}
	
	@Override
	public boolean canUndo(IContext context) {
		return false;
	}
	
	@Override
	public boolean update(IUpdateContext context) {
		Log.info("called with context: " + context);
		final Diagram diagram = (Diagram)context.getPictogramElement();
		styleService.refreshStyles();
		
		// Get the AADL Package
		final NamedElement element = (NamedElement)AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(diagram));
		if(element == null || !(element instanceof AadlPackage)) {
			final Status status = new Status(IStatus.ERROR, Activator.getPluginId(), "Unable to update diagram. Unable to find AADL model element associated with diagram.", null);
			StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
			return false;
		}	
		final AadlPackage pkg = (AadlPackage)element;
		
		// Update the diagram's name
		if(pkg.getQualifiedName() != null) {
			diagram.setName(pkg.getQualifiedName());
		}
				
		// Prune Invalid Generalizations
		visibilityService.ghostInvalidConnections(null);

		// Prune Invalid Shapes
		visibilityService.ghostInvalidShapes(diagram);
		
		// Build a list of all named elements in the public and private sections of the package
		final Set<NamedElement> relevantElements = new HashSet<NamedElement>();
		if(pkg.getPublicSection() != null) {
			relevantElements.addAll(pkg.getPublicSection().getMembers());	
		}

		if(pkg.getPrivateSection() != null) {
			relevantElements.addAll(pkg.getPrivateSection().getMembers());	
		}
		
		// Add classifiers that are extends or implemented by classifiers in this package
		final Set<NamedElement> elementsToAdd = new HashSet<NamedElement>();
		for(final NamedElement el : relevantElements) {
			if(el instanceof ComponentType) {
				final ComponentType componentType = ((ComponentType)el);
				if(componentType.getOwnedExtension() != null) {
					elementsToAdd.add(componentType.getOwnedExtension().getGeneral());
				}
			} else if(el instanceof ComponentImplementation) {
				final ComponentImplementation componentImplementation = ((ComponentImplementation)el);
				if(componentImplementation.getOwnedExtension() != null) {
					elementsToAdd.add(componentImplementation.getOwnedExtension().getGeneral());
				}
				if(componentImplementation.getOwnedRealization() != null) {
					elementsToAdd.add(componentImplementation.getOwnedRealization().getGeneral());
				}
			} else if(el instanceof FeatureGroupType) {
				final FeatureGroupType featureGroupType = ((FeatureGroupType)el);
				if(featureGroupType.getOwnedExtension() != null) {
					elementsToAdd.add(featureGroupType.getOwnedExtension().getGeneral());
				}
			}
		}
		relevantElements.addAll(elementsToAdd);
		
		// Iterate over named elements and add/update classifiers and their relationships.
		updateClassifiers(diagram, relevantElements, 0, 0);	
		updateRelationships(diagram, relevantElements);

		// Layout the diagram
		final ICustomContext layoutCtx = LayoutDiagramFeature.createContext(false);
		for(ICustomFeature feature : this.getFeatureProvider().getCustomFeatures(layoutCtx)) {
			if(feature instanceof LayoutDiagramFeature) {
				feature.execute(layoutCtx);
				break;
			}
		}

		return false;
	}
	
	private void updateClassifiers(final Diagram diagram, final Set<NamedElement> elements, int x, int y) {
		// Ghost any classifier shapes that are not in the element list. This will ensure that classifiers in other packages are ghosted.
		for(final Shape childShape : visibilityService.getNonGhostChildren(diagram)) {
			// Check if the shape has a business object and can be updated
			final Object bo = bor.getBusinessObjectForPictogramElement(childShape);
			if(bo instanceof Classifier && !elements.contains(bo)) {
				visibilityService.setIsGhost(childShape, true);
			}
		}
		
		for(final NamedElement el : elements) {
			// Add a item for the classifier
			if(!Aadl2Util.isNull(el) && el instanceof Classifier) {
				PictogramElement pictogramElement = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), el);
				if(pictogramElement == null) {					
					final AddContext addContext = new AddContext();
					addContext.setNewObject(new AadlElementWrapper(el));
					addContext.setTargetContainer(diagram);
					addContext.setX(x);
					addContext.setY(y);
					
					final IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
					if(addFeature.canAdd(addContext)) {			
						pictogramElement = addFeature.add(addContext);
						x += 150;
						if(x > 800) {
							y += 70;
							x = 0;
						}
					}
				} else {				
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
					
					// Update the classifier regardless of whether it is "needed" or not.
					if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
			}
		}
	}
	
	private void updateRelationships(final Diagram diagram, final Set<NamedElement> elements) {
		final AadlPackage pkg = (AadlPackage)AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(diagram));
		for(final NamedElement el : elements) {
			if(el.getNamespace() != null && el.getNamespace().getOwner() == pkg) {
				if(el instanceof ComponentType) {
					// Extension
					final ComponentType ct = (ComponentType)el;
					final TypeExtension te = ct.getOwnedExtension();
					if(te != null) {
						updateGeneralization(diagram, te);	
					}
				}
				
				if(el instanceof ComponentImplementation) {
					final ComponentImplementation ci = ((ComponentImplementation)el);
					
					// Implementation Extension
					final ImplementationExtension ie = ci.getOwnedExtension();
					if(ie != null) {	
						updateGeneralization(diagram, ie);					
					}
					
					// Realization
					final Realization realization = ci.getOwnedRealization();
					if(realization != null) {	
						updateGeneralization(diagram, realization);					
					}
				}
				
				if(el instanceof FeatureGroupType) {
					final FeatureGroupType fgt = (FeatureGroupType)el;
					final GroupExtension ge = fgt.getOwnedExtension();
					if(ge != null) {
						updateGeneralization(diagram, ge);	
					}
				}
			}
		}
	}
	
	private void updateGeneralization(final Diagram diagram, final Generalization generalization) {
		connectionCreationService.createUpdateConnection(diagram, generalization);
	}
}
