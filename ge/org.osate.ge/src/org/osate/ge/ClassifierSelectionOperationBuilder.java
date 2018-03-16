package org.osate.ge;

import java.util.Objects;
import java.util.function.Predicate;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.internal.businessObjectHandlers.ClassifierEditingUtil;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;

/**
 * Helper class for building an operation or determining whether a valid operation can be created to select a classifier.
 * Supports filtering. If the target object is a subcomponent, allows the selection of related classifiers.
 */
public class ClassifierSelectionOperationBuilder<ClassifierType extends Classifier> {
	private final Class<ClassifierType> classifierType;
	private Predicate<ClassifierType> filter = c -> true; // Filter for selecting those from the classifier. These filters are and'ed together
	private boolean includeAllWhenBoIsMatch = false;
	private String allowedClassifierDescription = "classifier";

	private ClassifierSelectionOperationBuilder(Class<ClassifierType> classifierType) {
		this.classifierType = Objects.requireNonNull(classifierType, "classifierType must not be null");
	}

	public static ClassifierSelectionOperationBuilder<Classifier> classifiers() {
		return new ClassifierSelectionOperationBuilder<>(Classifier.class);
	}

	public static ClassifierSelectionOperationBuilder<ComponentImplementation> componentImplementations() {
		return new ClassifierSelectionOperationBuilder<>(ComponentImplementation.class)
				.allowedClassifierDescription("component implementation");
	}

	public static ClassifierSelectionOperationBuilder<ComponentType> componentTypes() {
		return new ClassifierSelectionOperationBuilder<>(ComponentType.class)
				.allowedClassifierDescription("component type");
	}

	public static ClassifierSelectionOperationBuilder<ComponentClassifier> componentClassifiers() {
		return new ClassifierSelectionOperationBuilder<>(ComponentClassifier.class)
				.allowedClassifierDescription("component classifier");
	}

	public static ClassifierSelectionOperationBuilder<FeatureGroupType> featureGroupTypes() {
		return new ClassifierSelectionOperationBuilder<>(FeatureGroupType.class)
				.allowedClassifierDescription("feature group");
	}

	public static ClassifierSelectionOperationBuilder<Classifier> classifierTypes() {
		return new ClassifierSelectionOperationBuilder<>(Classifier.class)
				.filter(c -> c instanceof ComponentType || c instanceof FeatureGroupType)
				.allowedClassifierDescription("component or feature group type");
	}

	public ClassifierSelectionOperationBuilder<ClassifierType> filter(final Predicate<ClassifierType> value) {
		this.filter = this.filter.and(value);
		return this;
	}

	private ClassifierSelectionOperationBuilder<ClassifierType> allowedClassifierDescription(final String value) {
		this.allowedClassifierDescription = Objects.requireNonNull(value, "value must not be null");
		return this;
	}

	/**
	 * The classifiers are filtered to determine which ones are applicable. Typically if the specified business object is applicable, then only it is used. Calling this method
	 * will result in all applicable classifiers to be considered when selecting the classifier to modify.
	 * @return
	 */
	public ClassifierSelectionOperationBuilder<ClassifierType> allowAnyMatchingClassifier() {
		includeAllWhenBoIsMatch = true;
		return this;
	}

	public OperationBuilder<ClassifierType> buildOperation(final OperationBuilder<?> operation, final Object targetBo) {
		return operation.supply(() -> {
			if (ClassifierEditingUtil.showMessageIfSubcomponentOrFeatureGroupWithoutMatchingClassifier(targetBo,
					"Set a " + allowedClassifierDescription + ".", classifierType, filter)) {
				return StepResult.abort();
			}

			// Determine which classifier should own the new element
			final ClassifierType selectedClassifier = ClassifierEditingUtil.getClassifierToModify(
					ClassifierEditingUtil.getPotentialClassifiersForEditing(targetBo, classifierType, filter,
							includeAllWhenBoIsMatch));
			if (selectedClassifier == null) {
				return StepResult.abort();
			}

			return StepResult.forValue(selectedClassifier);
		});
	}

	/**
	 * Returns true if buildOperation() will be return a valid operation().
	 * @param bo
	 * @return
	 */
	public boolean canBuildOperation(final Object bo) {
		// Return true for subcomponents / feature groups which do not have a classifier assigned so that the operation can show an explanation.
		if (ComponentClassifier.class.isAssignableFrom(classifierType)) {
			if (ClassifierEditingUtil.isSubcomponentWithoutMatchingClassifier(bo, classifierType, filter)) {
				return true;
			}
		} else {
			if (ClassifierEditingUtil.isSubcomponentOrFeatureGroupWithoutMatchingClassifier(bo, classifierType, filter)) {
				return true;
			}
		}

		// Check number of potential classifiers to edit.
		return ClassifierEditingUtil.getPotentialClassifiersForEditing(bo, classifierType, filter).size() > 0;
	}
}
