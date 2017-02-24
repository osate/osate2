/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.internal.DiagramElementProxy;

/**
 * Contains methods for getting and working with AADL Features and Feature Group Types
 *
 */
public interface AadlFeatureService {
	/**
	 * Returns all the features owned by the classifiers or the type it extends. This differs from getAllFeatures because it does not 
	 * return features from the inverse feature group types
	 * @param fgt
	 * @return
	 */
	EList<Feature> getAllDeclaredFeatures(Classifier classifier);

	EList<Feature> getAllFeatures(FeatureGroupType fgt);

	/**
	 * Returns whether a feature is inverted by checking parent shapes and the corresponding features and feature group type definitions. Walks the diagram shape
	 * instead of trying to walk declarative model because it is not possible to walk up the declarative model when nested feature groups are used and in cased
	 * involving feature groups implicitly defined using inverse of.
	 * @param featureShape
	 * @param fp
	 * @return
	 */
	boolean isFeatureInverted(Shape featureShape);
	boolean isFeatureInverted(DiagramElementProxy featureDiagramElement);
	boolean isFeatureInvertedByParent(DiagramElementProxy featureParentDiagramElement);

	FeatureGroupType getFeatureGroupType(Shape shape, FeatureGroup fg);
	
	FeatureGroupType getFeatureGroupType(DiagramElementProxy diagramElement, FeatureGroup fg);
	
	/**
	 * Returns the actual direction of a feature. Take into account inverted feature groups, etc
	 * @param featureShape
	 * @param feature
	 * @return
	 */
	DirectionType getFeatureDirection(final Shape featureShape, DirectedFeature feature);
}
