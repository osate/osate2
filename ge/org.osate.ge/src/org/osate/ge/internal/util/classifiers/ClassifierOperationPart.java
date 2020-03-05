/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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