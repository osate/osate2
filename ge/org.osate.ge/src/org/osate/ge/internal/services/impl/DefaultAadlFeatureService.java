/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PrototypeService;

public class DefaultAadlFeatureService implements AadlFeatureService {
	private final PrototypeService prototypeService;
	private final BusinessObjectResolutionService bor;
	
	public DefaultAadlFeatureService(final PrototypeService prototypeService, final BusinessObjectResolutionService bor) {
		this.prototypeService = prototypeService;
		this.bor = bor;
	}

	/**
	 * Returns all the features owned by the feature group type or the type it extends. It does not return features from the inverse and in the case of refined features, 
	 * only returns the refined feature.
	 * @param fgt
	 * @return
	 */
	private EList<Feature> getAllOwnedFeatures(final FeatureGroupType fgt) {
		final EList<Feature> features = new BasicEList<Feature>();
		FeatureGroupType temp = fgt;
		while(temp != null) {
			boolean wasRefined = false;
			for(final Feature newFeature : temp.getOwnedFeatures()) {
				for(final Feature existingFeature : features) {
					if(existingFeature.getRefined() == newFeature) {
						wasRefined = true;
					}
				}
				
				if(!wasRefined) {
					features.add(newFeature);
				}
			}
			temp = temp.getExtended();
		}

		return features;
	}
		
	@Override
	public EList<Feature> getAllDeclaredFeatures(final Classifier classifier) {
		if(classifier instanceof FeatureGroupType) {
			return getAllOwnedFeatures((FeatureGroupType)classifier);
		} 
		
		return classifier.getAllFeatures();
	}
	
	@Override
	public EList<Feature> getAllFeatures(final FeatureGroupType fgt) {
		final EList<Feature> owned = getAllOwnedFeatures(fgt);
		final FeatureGroupType inverseFgt = fgt.getInverse();
		if (owned.isEmpty() && !Aadl2Util.isNull(inverseFgt)) {
			return getAllOwnedFeatures(inverseFgt);
		}
		
		return owned;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ClassifierService#isFeatureInverted(org.eclipse.graphiti.mm.pictograms.Shape)
	 */
	@Override
	public boolean isFeatureInverted(final Shape featureShape) {
		return isFeatureInvertedByParent(featureShape.getContainer());
	}
	
	private boolean isFeatureInvertedByParent(final Shape parentShape) {
		boolean isInverted = false;
		
		Shape container = parentShape;
		while(!(container instanceof Diagram)) {
			final Object containerBo = bor.getBusinessObjectForPictogramElement(container);
			if(containerBo instanceof FeatureGroup) {
				final FeatureGroup fg = (FeatureGroup)containerBo;
				isInverted ^= fg.isInverse();
				
				// This feature group type is not necessarily the one that owned the feature... Could be inverse.. Could be refined, etc..
				// Check if the feature group type was implicitly defined via an inverse
				final FeatureGroupType fgt = getFeatureGroupType(container, fg);
				if(fgt != null && getAllOwnedFeatures(fgt).isEmpty() && !Aadl2Util.isNull(fgt.getInverse())) {
					isInverted = !isInverted;
				}
			}

			container = container.getContainer();
		}
		
		return isInverted;
	}
	
	@Override
	public boolean isFeatureInverted(final DiagramElementProxy featureDiagramElement) {
		// TODO: Rewrite and expand API to prevent needing to drop down to the PictogramElementProxy level and to use logical diagram structure.
		if(featureDiagramElement instanceof PictogramElementProxy) {
			final PictogramElement pe = ((PictogramElementProxy) featureDiagramElement).getPictogramElement();
			if(pe instanceof Shape) {
				return isFeatureInvertedByParent(((Shape)pe).getContainer());
			}
		}
		
		return false;
		
	}
	
	@Override
	public boolean isFeatureInvertedByParent(final DiagramElementProxy parentFeatureDiagramElement) {
		// TODO: Rewrite and expand API to prevent needing to drop down to the PictogramElementProxy level.
		if(parentFeatureDiagramElement instanceof PictogramElementProxy) {
			final PictogramElement pe = ((PictogramElementProxy) parentFeatureDiagramElement).getPictogramElement();
			if(pe instanceof Shape) {
				return isFeatureInvertedByParent((Shape)pe);
			}
		}
		
		return false;		
	}
	
	// Prototype Related Methods
	@Override
	public FeatureGroupType getFeatureGroupType(final Shape shape, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			return prototypeService.getFeatureGroupType(prototypeService.getPrototypeBindingContext(shape), fg);		
		}
	}
	
	@Override
	public FeatureGroupType getFeatureGroupType(final DiagramElementProxy diagramElement, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			// TODO: Rewrite and expand API to prevent needing to drop down to the PictogramElementProxy level.
			if(diagramElement instanceof PictogramElementProxy) {
				final PictogramElement pe = ((PictogramElementProxy)diagramElement).getPictogramElement();
				if(pe instanceof Shape) {
					return prototypeService.getFeatureGroupType(prototypeService.getPrototypeBindingContext((Shape)pe), fg);
				}
			}
		}

		return null;
	}
	
	@Override
	public DirectionType getFeatureDirection(final Shape featureShape, DirectedFeature feature) {
		DirectionType direction = feature.getDirection();
		final boolean isInverted = isFeatureInverted(featureShape);
		
		// Invert the direction
		if(isInverted) {
			if(direction == DirectionType.IN) {
				direction = DirectionType.OUT;
			} else if(direction == DirectionType.OUT) {
				direction = DirectionType.IN;
			}
		}
		
		return direction;
	}
}
