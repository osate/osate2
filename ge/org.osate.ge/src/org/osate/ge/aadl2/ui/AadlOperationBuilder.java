/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.ge.aadl2.ui.internal.AadlUiUtil;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;

/**
 * Helper class for building an operation or determining whether a valid operation for modifying the business object can be created.
 * Supports filtering.
 *
 * The target business object is not necessarily the object meant to be modified. For example, if the target object is a subcomponent or feature group, the referenced classifier may be edited.
 * @since 2.0
 */
public class AadlOperationBuilder<BusinessObjectType> {
	private final Class<BusinessObjectType> elementType;
	private Predicate<BusinessObjectType> filter = c -> true; // Filter for selecting those from the classifier. These filters are and'ed together
	private boolean includeAllWhenBoIsMatch = false;
	private String allowedClassifierDescription = "classifier";
	private boolean showErrorForSubcomponentWithoutClassifier = false;
	private boolean showErrorForFeatureGroupWithoutClassifier = false;

	private AadlOperationBuilder(Class<BusinessObjectType> elementType) {
		this.elementType = Objects.requireNonNull(elementType, "elementType must not be null");
	}

	public static AadlOperationBuilder<AadlPackage> packages() {
		return new AadlOperationBuilder<>(AadlPackage.class);
	}

	public static AadlOperationBuilder<Classifier> classifiers() {
		return new AadlOperationBuilder<>(Classifier.class).showErrorForSubcomponentWithoutClassifier(true)
				.showErrorForFeatureGroupWithoutClassifier(true);
	}

	public static AadlOperationBuilder<ComponentImplementation> componentImplementations() {
		return new AadlOperationBuilder<>(ComponentImplementation.class)
				.allowedClassifierDescription("component implementation")
				.showErrorForSubcomponentWithoutClassifier(true);
	}

	public static AadlOperationBuilder<ComponentType> componentTypes() {
		return new AadlOperationBuilder<>(ComponentType.class).allowedClassifierDescription("component type")
				.showErrorForSubcomponentWithoutClassifier(true);
	}

	public static AadlOperationBuilder<NamedElement> packagesAndComponentClassifiers() {
		return new AadlOperationBuilder<>(NamedElement.class)
				.filter(c -> c instanceof AadlPackage || c instanceof ComponentClassifier)
				.allowedClassifierDescription("component classifier").showErrorForSubcomponentWithoutClassifier(true);
	}

	public static AadlOperationBuilder<ComponentClassifier> componentClassifiers() {
		return new AadlOperationBuilder<>(ComponentClassifier.class)
				.allowedClassifierDescription("component classifier").showErrorForSubcomponentWithoutClassifier(true);
	}

	public static AadlOperationBuilder<FeatureGroupType> featureGroupTypes() {
		return new AadlOperationBuilder<>(FeatureGroupType.class).allowedClassifierDescription("feature group")
				.showErrorForFeatureGroupWithoutClassifier(true);
	}

	public static AadlOperationBuilder<Classifier> classifierTypes() {
		return new AadlOperationBuilder<>(Classifier.class)
				.filter(c -> c instanceof ComponentType || c instanceof FeatureGroupType)
				.allowedClassifierDescription("component or feature group type")
				.showErrorForSubcomponentWithoutClassifier(true).showErrorForFeatureGroupWithoutClassifier(true);
	}

	public AadlOperationBuilder<BusinessObjectType> filter(final Predicate<BusinessObjectType> value) {
		this.filter = this.filter.and(value);
		return this;
	}

	private AadlOperationBuilder<BusinessObjectType> allowedClassifierDescription(final String value) {
		this.allowedClassifierDescription = Objects.requireNonNull(value, "value must not be null");
		return this;
	}

	private AadlOperationBuilder<BusinessObjectType> showErrorForSubcomponentWithoutClassifier(final boolean value) {
		this.showErrorForSubcomponentWithoutClassifier = value;
		return this;
	}

	private AadlOperationBuilder<BusinessObjectType> showErrorForFeatureGroupWithoutClassifier(final boolean value) {
		this.showErrorForFeatureGroupWithoutClassifier = value;
		return this;
	}

	/**
	 * The classifiers are filtered to determine which ones are applicable. Typically if the specified business object is applicable, then only it is used. Calling this method
	 * will result in all applicable classifiers to be considered when selecting the classifier to modify.
	 * @return
	 */
	public AadlOperationBuilder<BusinessObjectType> allowAnyMatchingClassifier() {
		includeAllWhenBoIsMatch = true;
		return this;
	}

	/**
	 * Returns true if buildOperation() will be return a valid operation().
	 * @param bo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean canBuildOperation(final Object bo) {
		if (AadlUiUtil.matches(bo, elementType, filter)) {
			return true;
		}

		// Return true for subcomponents / feature groups which do not have a classifier assigned so that the operation can show an explanation.
		if (showErrorForSubcomponentWithoutClassifier) {
			if (AadlUiUtil.isSubcomponentWithoutClassifier(bo)) {
				return true;
			}
		}

		if (showErrorForFeatureGroupWithoutClassifier) {
			if (AadlUiUtil.isSubcomponentOrFeatureGroupWithoutClassifier(bo)) {
				return true;
			}
		}

		if ((showErrorForSubcomponentWithoutClassifier && bo instanceof Subcomponent)
				|| (showErrorForFeatureGroupWithoutClassifier && bo instanceof FeatureGroup)
				|| bo instanceof Classifier) {
			// Check number of potential classifiers to edit.
			return AadlUiUtil.getPotentialClassifiersForEditing(bo, (Class<Classifier>) elementType,
					(Predicate<Classifier>) filter).size() > 0;
		}

		return false;
	}

	/**
	 * Must not be called unless canBuildOperation() would return true.
	 * @param operation
	 * @param targetBo
	 * @return
	 */
	public OperationBuilder<BusinessObjectType> buildOperation(final OperationBuilder<?> operation,
			final Object targetBo) {
		return operation.supply(() -> {
			final boolean boMatches = AadlUiUtil.matches(targetBo, elementType, filter);

			final List<BusinessObjectType> potentialBusinessObjects = new ArrayList<>();

			// Avoid multiple entries by not including matching classifiers because that will be handled when processing classifiers
			if (!(targetBo instanceof Classifier)) {
				if (boMatches) {
					potentialBusinessObjects.add(elementType.cast(targetBo));
				}
			}

			if (potentialBusinessObjects.size() == 0 || includeAllWhenBoIsMatch) {
				potentialBusinessObjects.addAll(AadlUiUtil.getPotentialClassifiersForEditing(targetBo, elementType,
						filter, includeAllWhenBoIsMatch));
			}

			// Determine which classifier should own the new element
			if (potentialBusinessObjects.size() > 0) {
				final BusinessObjectType selectedBo = (BusinessObjectType) AadlUiUtil
						.getBusinessObjectToModify(potentialBusinessObjects);
				if (selectedBo == null) {
					return StepResult.abort();
				}

				return StepResult.forValue(selectedBo);
			} else {
				if ((showErrorForSubcomponentWithoutClassifier || showErrorForFeatureGroupWithoutClassifier)
						&& AadlUiUtil.showMessageIfSubcomponentOrFeatureGroupWithoutClassifier(targetBo,
								"Set a " + allowedClassifierDescription + ".")) {
					if (!boMatches) {
						return StepResult.abort();
					}
				}
			}

			// Should mean that canBuildOperation() would return false.
			throw new RuntimeException("Unable to determine business object to modify");
		});
	}
}
