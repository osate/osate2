package org.osate.ge.internal.ui.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.PackageSection;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.internal.util.classifiers.ClassifierCreationHelper;
import org.osate.ge.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPart;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;

public class DefaultCreateSelectClassifierDialogModel implements ClassifierOperationDialog.Model {
	private final NamingService namingService;
	private final ClassifierCreationHelper classifierCreationHelper;
	private final String defaultMessage;

	public DefaultCreateSelectClassifierDialogModel(final NamingService namingService, final ResourceSet resourceSet,
			final String defaultMessage) {
		this.namingService = Objects.requireNonNull(namingService, "namingService must not be null");
		this.classifierCreationHelper = new ClassifierCreationHelper(namingService, resourceSet);
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
			if (!namingService.isValidIdentifier(op.getIdentifier())) {
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
			if (namingService.isNameInUse(section, newName)) {
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
