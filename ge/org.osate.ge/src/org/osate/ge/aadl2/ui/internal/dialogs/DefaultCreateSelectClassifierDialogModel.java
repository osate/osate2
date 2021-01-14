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
package org.osate.ge.aadl2.ui.internal.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.PackageSection;
import org.osate.ge.StringUtil;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierCreationHelper;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperationPart;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperationPartType;

public class DefaultCreateSelectClassifierDialogModel implements ClassifierOperationDialog.Model {
	private final ClassifierCreationHelper classifierCreationHelper;
	private final String defaultMessage;

	public DefaultCreateSelectClassifierDialogModel(final ResourceSet resourceSet,
			final String defaultMessage) {
		this.classifierCreationHelper = new ClassifierCreationHelper(resourceSet);
		this.defaultMessage = Objects.requireNonNull(defaultMessage, "defaultMessage must not be null");
	}

	@Override
	public String getTitle() {
		return "Select Element";
	}

	@Override
	public final String getMessage(final ClassifierOperation value) {
		if (ClassifierOperationPart.areRelevantFieldsNonNull(value.getPrimaryPart())) {
			final ClassifierOperationPartType primaryOp = value.getPrimaryPart().getType();
			if (primaryOp == ClassifierOperationPartType.NEW_COMPONENT_TYPE
					|| primaryOp == ClassifierOperationPartType.NEW_FEATURE_GROUP_TYPE
					|| (primaryOp == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION
					&& ClassifierOperationPart.areRelevantFieldsNonNull(value.getBasePart()))) {
				final AadlPackage pkg = classifierCreationHelper
						.getResolvedPackage(value.getPrimaryPart().getSelectedPackage());
				if (pkg == null) {
					return "";
				}

				if (!ClassifierOperationPart.areRelevantFieldsNonNull(value.getBasePart())
						|| !ClassifierOperationPart.areRelevantFieldsNonNull(value.getPrimaryPart())) {
					return "";
				}

				if (value.getPrimaryPart().getType() == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION
						&& value.getBasePart().getType() == ClassifierOperationPartType.NONE) {
					return "";
				}

				return "The classifier '"
				+ classifierCreationHelper.getName(value.getPrimaryPart(), value.getBasePart())
				+ "' will be created.";
			}
		}

		return defaultMessage;
	}

	@Override
	public Collection<?> getPackageOptions() {
		return Collections.emptyList();
	}

	@Override
	public String getPrimarySelectTitle() {
		return "";
	}

	@Override
	public String getPrimarySelectMessage() {
		return "";
	}

	@Override
	public Collection<?> getPrimarySelectOptions() {
		return Collections.emptyList();
	}

	@Override
	public Collection<?> getUnfilteredPrimarySelectOptions() {
		return Collections.emptyList();
	}

	@Override
	public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
		return Collections.emptyList();
	}

	@Override
	public Collection<?> getUnfilteredBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
		return null;
	}

	@Override
	public String validate(final ClassifierOperation value) {
		String result = validate(value.getBasePart(), null);

		if (result == null) {
			result = validate(value.getPrimaryPart(), value.getBasePart());
		} else {
			result = "Base: " + result.substring(0, 1).toLowerCase() + result.substring(1); // Uncapitalize the message
		}

		return result;
	}

	private String validate(final ClassifierOperationPart op, final ClassifierOperationPart baseOperation) {
		if (ClassifierOperationPartType.isCreate(op.getType())) {
			// Check identifier validity
			if (!AadlNamingUtil.isValidIdentifier(op.getIdentifier())) {
				return "The specified identifier is not a valid AADL identifier";
			}

			// Check component category
			if (ClassifierOperationPartType.isComponentClassifierCreate(op.getType())) {
				if (op.getComponentCategory() == null) {
					return "Select a component category.";
				}

				if (baseOperation != null && baseOperation.getType() == ClassifierOperationPartType.EXISTING) {
					// Check for a compatible component category when selecting an existing base classifier
					final Classifier baseClassifier = classifierCreationHelper
							.getResolvedClassifier(baseOperation.getSelectedClassifier());
					if (baseClassifier instanceof ComponentClassifier) {
						final ComponentClassifier baseCategory = (ComponentClassifier) baseClassifier;
						if (baseCategory.getCategory() != op.getComponentCategory()
								&& (op.getType() != ClassifierOperationPartType.NEW_COMPONENT_TYPE
								|| baseCategory.getCategory() != ComponentCategory.ABSTRACT)) {

							return "Base: category(" + baseCategory.getCategory()
							+ ") of the selected classifier is not compatible with category type of the "
							+ StringUtil.upperUnderscoreToLowercaseUser(op.getType().name())
							+ "(" + op.getComponentCategory() + ").";
						}
					}
				}
			}

			// Check package.
			final AadlPackage pkg = classifierCreationHelper.getResolvedPackage(op.getSelectedPackage());
			if (pkg == null) {
				return "Select a package.";
			}

			final PackageSection section = pkg.getPublicSection();
			if (section == null) {
				return "Unable to retrieve public section of package.";
			}

			// New Component Implementation validation
			if (op.getType() == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION) {
				if (baseOperation == null) {
					return "Base classifier is invalid";
				} else if (!ClassifierOperationPartType.isCreate(baseOperation.getType())
						&& baseOperation.getType() != ClassifierOperationPartType.EXISTING) {
					if (baseOperation.getType() == ClassifierOperationPartType.NONE) {
						return "Select a base for the new component implementation.";
					} else {
						return "Invalid base classifier: " + baseOperation.getType();
					}
				}
			}

			final String newName = classifierCreationHelper.getName(op, baseOperation);
			if (newName == null) {
				return "Unable to build name. Check for model errors.";
			}

			// Check if the name is in use
			if (AadlNamingUtil.isNameInUse(section, newName)) {
				return "The specified name conflicts with an existing member of the package.";
			}
		} else if (op.getType() == ClassifierOperationPartType.EXISTING) {
			// Check that the classifier can be resolved.
			if (classifierCreationHelper.getResolvedClassifier(op.getSelectedClassifier()) == null) {
				return "Select a classifier.";
			}
		} else if (op.getType() == null) {
			return "Select a classifier type.";
		}

		return null;
	}
}
