package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;

public interface ClassifierService {

	void createUpdateFeatureShapes(ContainerShape shape,
			List<Feature> features, Collection<Shape> touchedShapes);

	void createUpdateModeShapes(ContainerShape shape, List<Mode> modes);

	void createUpdateShapesForElements(ContainerShape shape,
			List<? extends NamedElement> elements, int startX, boolean incX,
			int xPadding, int startY, boolean incY, int yPadding);

	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container
	 * @param shape
	 * @param fp
	 */
	int[] adjustChildShapePositions(ContainerShape shape);

	/**
	 * Returns all the features owned by the feature group type or the type it extends. It does not return features from the inverse and in the case of refined features, 
	 * only returns the refined feature.
	 * @param fgt
	 * @return
	 */
	EList<Feature> getAllOwnedFeatures(FeatureGroupType fgt);

	/**
	 * Returns all the features owned by the feature group type or the type it extends. It does not return features from the inverse and in the case of refined features, 
	 * only returns the refined feature.
	 * @param fgt
	 * @return
	 */
	EList<Feature> getAllOwnedFeatures(ComponentType ct);

	/**
	 * Returns all the features owned by the feature group type or the type it extends. This differs from getAllFeatures because it does not 
	 * return features from the inverse
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

	// Prototype Related Methods
	// CLEAN-UP: Consider moving to another class
	FeatureGroupType getFeatureGroupType(Shape shape, FeatureGroup fg);

	ComponentClassifier getComponentClassifier(Shape shape, Subcomponent sc);

	ComponentCategory getComponentCategory(Shape shape, Subcomponent sc);

	boolean isImplementation(Shape shape, Subcomponent sc);

	/**
	 * Returns either the feature group type or the actual prototype
	 * @param shape
	 * @param fg
	 * @param fp
	 * @return
	 */
	// TODO: Define what shape is supposed to be
	Element getFeatureGroupTypeOrActual(Shape shape, FeatureGroup fg);

	/**
	 * @param shape
	 * @param fp
	 * @return
	 */
	Element getPrototypeBindingContext(Shape shape);

	FeatureGroupPrototypeActual resolveFeatureGroupPrototypeToActual(
			Prototype proto, Element context);

}