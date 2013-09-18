package edu.uah.rsesc.aadl.age.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;

/**
 * Contains methods for getting and working with AADL Features and Feature Group Types
 * @author philip.alldredge
 *
 */
public interface AadlFeatureService {
	/**
	 * Returns all the features owned by the classifiers or the type it extends. This differs from getAllFeatures because it does not 
	 * return features from the inverse feature group types
	 * @param fgt
	 * @return
	 */
	EList<Feature> getAllOwnedFeatures(Classifier classifier);

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

	FeatureGroupType getFeatureGroupType(Shape shape, FeatureGroup fg);
}
