/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.aadl2.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.aadl2.ui.internal.AadlUiUtil;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;
import org.osate.ge.palette.PaletteCommand;

/**
 * Helper class for building an operation or determining whether a valid operation for modifying the business object can be created.
 * Supports filtering.
 *
 * This class is useful when implementing {@link PaletteCommand}. For a given target, an operation can be built which will modify the desired
 * type of object. If such a model element is not available or ambiguous, an error message or prompt may be shown by the operation based
 * on the builder's configuration.
 *
 * The target business object is not necessarily the object meant to be modified. For example, if the target object is a subcomponent or feature group,
 * the referenced classifier or extended classifier may be edited.
 * @param <T> is the type of AADL element to be modified
 *
 * @since 2.0
 * @see org.osate.ge.operations.Operation
 * @see OperationBuilder
 */
public final class AadlOperationBuilder<T> {
	private final Class<T> elementType;
	private Predicate<T> filter = c -> true; // Filter for selecting those from the classifier. These filters are and'ed together
	private boolean includeAllWhenBoIsMatch = false;
	private String allowedClassifierDescription = "classifier";
	private boolean showErrorForSubcomponentWithoutClassifier = false;
	private boolean showErrorForFeatureGroupWithoutClassifier = false;

	/**
	 * Private constructor.
	 * @param elementType is the type of AADL element to be modified.
	 */
	private AadlOperationBuilder(final Class<T> elementType) {
		this.elementType = Objects.requireNonNull(elementType, "elementType must not be null");
	}

	/**
	 * Creates an instance for modifying an {@link AadlPackage}
	 * @return the new instance
	 */
	public static AadlOperationBuilder<AadlPackage> packages() {
		return new AadlOperationBuilder<>(AadlPackage.class);
	}

	/**
	 * Creates an instance for modifying a {@link Classifier}.
	 * Will allowing building an operation which will show an error if the target is a subcomponent or feature group without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<Classifier> classifiers() {
		return new AadlOperationBuilder<>(Classifier.class).showErrorForSubcomponentWithoutClassifier(true)
				.showErrorForFeatureGroupWithoutClassifier(true);
	}

	/**
	 * Creates an instance for modifying a {@link ComponentImplementation}.
	 * Will allowing building an operation which will show an error if the target is a subcomponent without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<ComponentImplementation> componentImplementations() {
		return new AadlOperationBuilder<>(ComponentImplementation.class)
				.allowedClassifierDescription("component implementation")
				.showErrorForSubcomponentWithoutClassifier(true);
	}

	/**
	 * Creates an instance for modifying a {@link ComponentType}.
	 * Will allowing building an operation which will show an error if the target is a subcomponent without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<ComponentType> componentTypes() {
		return new AadlOperationBuilder<>(ComponentType.class).allowedClassifierDescription("component type")
				.showErrorForSubcomponentWithoutClassifier(true);
	}

	/**
	 * Creates an instance for modifying a {@link AadlPackage} or {@link ComponentClassifier}.
	 * Will allowing building an operation which will show an error if the target is a subcomponent without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<NamedElement> packagesAndComponentClassifiers() {
		return new AadlOperationBuilder<>(NamedElement.class)
				.filter(c -> c instanceof AadlPackage || c instanceof ComponentClassifier)
				.allowedClassifierDescription("component classifier")
				.showErrorForSubcomponentWithoutClassifier(true);
	}

	/**
	 * Creates an instance for modifying a {@link ComponentClassifier}.
	 * Will allowing building an operation which will show an error if the target is a subcomponent without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<ComponentClassifier> componentClassifiers() {
		return new AadlOperationBuilder<>(ComponentClassifier.class)
				.allowedClassifierDescription("component classifier")
				.showErrorForSubcomponentWithoutClassifier(true);
	}

	/**
	 * Creates an instance for modifying a {@link FeatureGroupType}}.
	 * Will allowing building an operation which will show an error if the target is a feature group without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<FeatureGroupType> featureGroupTypes() {
		return new AadlOperationBuilder<>(FeatureGroupType.class).allowedClassifierDescription("feature group")
				.showErrorForFeatureGroupWithoutClassifier(true);
	}

	/**
	 * Creates an instance for modifying a {@link ComponentType} or {@link FeatureGroupType}.
	 * Will allowing building an operation which will show an error if the target is a subcomponent or feature group without a classifier
	 * @return the new instance
	 */
	public static AadlOperationBuilder<Classifier> classifierTypes() {
		return new AadlOperationBuilder<>(Classifier.class)
				.filter(c -> c instanceof ComponentType || c instanceof FeatureGroupType)
				.allowedClassifierDescription("component or feature group type")
				.showErrorForSubcomponentWithoutClassifier(true)
				.showErrorForFeatureGroupWithoutClassifier(true);
	}

	/**
	 * Configures the builder to add an additional filter which restricts the allowed modified business objects.
	 * @param value the new filter
	 * @return this builder to allow method chaining.
	 */
	public AadlOperationBuilder<T> filter(final Predicate<T> value) {
		this.filter = this.filter.and(value);
		return this;
	}

	/**
	 * Configures the builder to use the specified label when describing the type of classifier that is missing from a
	 * subcomponent or feature group.
	 * @param value the label
	 * @return this builder to allow method chaining.
	 */
	private AadlOperationBuilder<T> allowedClassifierDescription(final String value) {
		this.allowedClassifierDescription = Objects.requireNonNull(value, "value must not be null");
		return this;
	}

	/**
	 * Configures the builder to allow building an operation when targeting a subcomponent without a classifier.
	 * @param value whether to allow building an operation when the target is a subcomponent without a classifier.
	 * @return this builder to allow method chaining.
	 */
	private AadlOperationBuilder<T> showErrorForSubcomponentWithoutClassifier(final boolean value) {
		this.showErrorForSubcomponentWithoutClassifier = value;
		return this;
	}

	/**
	 * Configures the builder to allow building an operation when targeting a feature group without a classifier.
	 * @param value whether to allow building an operation when the target is a feature group without a classifier.
	 * @return this builder to allow method chaining.
	 */
	private AadlOperationBuilder<T> showErrorForFeatureGroupWithoutClassifier(final boolean value) {
		this.showErrorForFeatureGroupWithoutClassifier = value;
		return this;
	}

	/**
	 * The classifiers are filtered to determine which ones are applicable. Typically if the target business object is applicable,
	 * then only it is used. Calling this method will result in all applicable classifiers to be considered when selecting the classifier to modify.
	 * @return this builder to allow method chaining.
	 */
	public AadlOperationBuilder<T> allowAnyMatchingClassifier() {
		includeAllWhenBoIsMatch = true;
		return this;
	}

	/**
	 * Returns true if {@link #buildOperation(OperationBuilder, Object)} will be return a valid operation.
	 * @param targetBo is the target for the operation
	 * @return whether an operation can be built.
	 */
	public boolean canBuildOperation(final Object targetBo) {
		if (AadlUiUtil.matches(targetBo, elementType, filter)) {
			return true;
		}

		// Return true for subcomponents / feature groups which do not have a classifier assigned so that the operation can show an explanation.
		if (showErrorForSubcomponentWithoutClassifier && AadlUiUtil.isSubcomponentWithoutClassifier(targetBo)) {
			return true;
		}

		if (showErrorForFeatureGroupWithoutClassifier && AadlUiUtil.isSubcomponentOrFeatureGroupWithoutClassifier(targetBo)) {
			return true;
		}

		// Check if there is at least one potential classifier for editing
		if ((showErrorForSubcomponentWithoutClassifier && targetBo instanceof Subcomponent)
				|| (showErrorForFeatureGroupWithoutClassifier && targetBo instanceof FeatureGroup)
				|| targetBo instanceof Classifier) {
			return !AadlUiUtil.getPotentialClassifiersForEditing(targetBo, elementType, filter).isEmpty();
		}

		return false;
	}

	/**
	 * Creates an operation builder which will either abort or supply a business object of the requested type.
	 * The built operation is not guaranteed to supply a business object. The operation may prompt the user or display an error depending on the configuration
	 * of the {@link AadlOperationBuilder}.
	 * Must not be called unless {@link #canBuildOperation(Object)} would return true.
	 * @param operation is the operation builder to use to build the operation.
	 * @param targetBo is the target of the operation.
	 * @return an operation builder which is configured to allow building the requested object type.
	 */
	public OperationBuilder<T> buildOperation(final OperationBuilder<?> operation, final Object targetBo) {
		return operation.supply(() -> {
			final List<T> potentialBusinessObjects = getPotentialBusinessObjects(targetBo);

			// Determine which classifier should own the new element
			if (!potentialBusinessObjects.isEmpty()) {
				final T selectedBo = AadlUiUtil.getBusinessObjectToModify(potentialBusinessObjects);
				if (selectedBo == null) {
					return StepResult.abort();
				}

				return StepResult.forValue(selectedBo);
			} else {
				if ((showErrorForSubcomponentWithoutClassifier || showErrorForFeatureGroupWithoutClassifier)
						&& AadlUiUtil.showMessageIfSubcomponentOrFeatureGroupWithoutClassifier(targetBo,
								"Set a " + allowedClassifierDescription + ".")) {
					return StepResult.abort();
				}
			}

			// Should mean that canBuildOperation() would return false.
			throw new AadlGraphicalEditorException("Unable to determine business object to modify");
		});
	}

	/**
	 * Returns a list of business objects which meet the configured criteria.
	 * @param targetBo the target of the operation.
	 * @return the list of modifiable business objects
	 */
	private List<T> getPotentialBusinessObjects(final Object targetBo) {
		final boolean boMatches = AadlUiUtil.matches(targetBo, elementType, filter);
		final List<T> potentialBusinessObjects = new ArrayList<>();

		// Avoid multiple entries by not including matching classifiers because that will be handled when processing classifiers
		if (!(targetBo instanceof Classifier) && boMatches) {
			potentialBusinessObjects.add(elementType.cast(targetBo));
		}

		if (potentialBusinessObjects.isEmpty() || includeAllWhenBoIsMatch) {
			potentialBusinessObjects.addAll(AadlUiUtil.getPotentialClassifiersForEditing(targetBo, elementType, filter,
					includeAllWhenBoIsMatch));
		}

		return potentialBusinessObjects;
	}
}
