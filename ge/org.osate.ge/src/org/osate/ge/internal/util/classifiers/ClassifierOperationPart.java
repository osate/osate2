package org.osate.ge.internal.util.classifiers;

import org.osate.aadl2.ComponentCategory;

import com.google.common.base.Strings;

public class ClassifierOperationPart {
	private final ClassifierOperationPartType type;
	private final Object selectedPackage; // For create operations
	private final String identifier; // For create operations
	private final ComponentCategory componentCategory; // For create component type/implementation
	private final Object selectedClassifier; // For select existing operation.

	public ClassifierOperationPart(final ClassifierOperationPartType type, final Object selectedPackage,
			final String identifier, final ComponentCategory componentCategory,
			final Object selectedElement) {
		this.type = type;
		this.selectedPackage = selectedPackage;
		this.identifier = identifier;
		this.componentCategory = componentCategory;
		this.selectedClassifier = selectedElement;
	}

	public ClassifierOperationPartType getType() {
		return type;
	}

	//
	// For create operations
	//
	public Object getSelectedPackage() {
		return selectedPackage;
	}

	public String getIdentifier() {
		return identifier;
	}

	public ComponentCategory getComponentCategory() {
		return componentCategory;
	}

	//
	// For selecting existing
	//
	public Object getSelectedClassifier() {
		return selectedClassifier;
	}

	/**
	 * Returns true if the value is non-null, the operation is set and all related fields are non-null.
	 * @return
	 */
	public static boolean areRelevantFieldsNonNull(final ClassifierOperationPart value) {
		if(value == null) {
			return false;
		}

		final ClassifierOperationPartType operation = value.getType();
		return operation == ClassifierOperationPartType.NONE
				|| (operation == ClassifierOperationPartType.EXISTING && value.getSelectedClassifier() != null)
				|| (ClassifierOperationPartType.isCreate(operation) && value.getSelectedPackage() != null
						&& !Strings.isNullOrEmpty(value.getIdentifier()));
	}

	public static ClassifierOperationPart createNone() {
		return new ClassifierOperationPart(ClassifierOperationPartType.NONE, null, null, null, null);
	}

	public static ClassifierOperationPart createExisting(final Object selectedElement) {
		return new ClassifierOperationPart(ClassifierOperationPartType.EXISTING, null, null, null, selectedElement);
	}

	public static ClassifierOperationPart createCreation(final ClassifierOperationPartType partType,
			final Object selectedPackage, final String identifier, final ComponentCategory componentCategory) {
		if (!ClassifierOperationPartType.isCreate(partType)) {
			throw new RuntimeException("operation part type is not a creation type");
		}
		return new ClassifierOperationPart(partType, selectedPackage, identifier, componentCategory, null);
	}

}