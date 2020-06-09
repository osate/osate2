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
package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;

public class ClassifierHandler {
	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Classifier bo) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Classifier bo) {
		return GraphicalConfigurationBuilder.create().graphic(AadlGraphics.getGraphic(bo))
				.style(AadlGraphics.getStyle(bo)).build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Classifier classifier) {
		return classifier.getName();
	}

	@GetNameForEditing
	public String getName(final @Named(Names.BUSINESS_OBJECT) ComponentImplementation ci) {
		return ci.getImplementationName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Classifier classifier,
			final @Named(Names.NAME) String value) {
		final String newFullName;
		final String oldName;

		// Transform value so that is is the full name
		if (classifier instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) classifier;
			newFullName = ci.getTypeName() + "." + value;
			oldName = ci.getImplementationName();
		} else {
			newFullName = value;
			oldName = classifier.getName();
		}

		// If the name hasn't changed or has only changed case
		if (value.equalsIgnoreCase(oldName)) {
			return null;
		}

		// Check if the value matches the format for AADL identifiers
		if (!AadlNamingUtil.isValidIdentifier(value)) {
			return "The specified name is not a valid AADL identifier";
		}

		// Check for conflicts in the namespace
		if (AadlNamingUtil.isNameInUse(classifier.getNamespace(), newFullName)) {
			return "The specified name conflicts with an existing member of the namespace.";
		}

		// The value is valid
		return null;
	}
}
