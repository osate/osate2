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
package org.osate.ge.internal.services.impl;

import java.util.Objects;

/**
 * Contains values for the different types of references created as part of support for the AADL declarative model. The ID
 * returned by {@link #getId()} are used as the first segment of references to those business objects.
 */
public enum DeclarativeReferenceType {
	/**
	 * {@link org.osate.aadl2.AadlPackage}
	 */
	PACKAGE("package"),
	/**
	 * {@link org.osate.aadl2.Classifier}
	 */
	CLASSIFIER("classifier"),
	/**
	 * {@link org.osate.aadl2.Subcomponent}
	 */
	SUBCOMPONENT("subcomponent"),
	/**
	 * {@link org.osate.aadl2.Realization}
	 */
	REALIZATION("realization"),
	/**
	 * {@link org.osate.aadl2.TypeExtension}
	 */
	TYPE_EXTENSION("type_extension"),
	/**
	 * {@link org.osate.aadl2.ImplementationExtension}
	 */
	IMPLEMENTATION_EXTENSION("implementation_extension"),
	/**
	 * {@link org.osate.aadl2.GroupExtension}
	 */
	GROUP_EXTENSION("group_extension"),
	/**
	 * {@link org.osate.aadl2.Feature}
	 */
	FEATURE("feature"),
	/**
	 * {@link org.osate.aadl2.InternalFeature}
	 */
	INTERNAL_FEATURE("internal_feature"),
	/**
	 * {@link org.osate.aadl2.ProcessorFeature}
	 */
	PROCESSOR_FEATURE("processor_feature"),
	/**
	 * {@link org.osate.aadl2.FlowSpecification}
	 */
	FLOW_SPECIFICATION("flow_specification"),
	/**
	 * {@link org.osate.aadl2.Connection}
	 */
	CONNECTION("connection"),
	/**
	 * {@link org.osate.aadl2.Mode}
	 */
	MODE("mode"),
	/**
	 * {@link org.osate.aadl2.ModeTransition} which does not have a name
	 */
	MODE_TRANSITION_UNNAMED("mode_transition"),
	/**
	 * {@link org.osate.aadl2.ModeTransition} which does have a name
	 */
	MODE_TRANSITION_NAMED("mt"),
	/**
	 * {@link org.osate.aadl2.ModeTransitionTrigger}
	 */
	MODE_TRANSITION_TRIGGER("mtt"),
	/**
	 * {@link org.osate.aadl2.SubprogramCallSequence}
	 */
	SUBPROGRAM_CALL_SEQUENCE("subprogram_call_sequence"),
	/**
	 * {@link org.osate.aadl2.SubprogramCall}
	 */
	SUBPROGRAM_CALL("subprogram_call"),
	/**
	 * {@link org.osate.ge.aadl2.internal.model.SubprogramCallOrder}
	 */
	SUBPROGRAM_CALL_ORDER("subprogram_call_order"),
	/**
	 * {@link org.osate.aadl2.AnnexLibrary}
	 */
	ANNEX_LIBRARY("annex_library"),
	/**
	 * {@link org.osate.aadl2.AnnexSubclause}
	 */
	ANNEX_SUBCLAUSE("annex_subclause");

	private String id;

	DeclarativeReferenceType(final String id) {
		this.id = Objects.requireNonNull(id, "tag must not be null");
	}

	/**
	 * A identifier for the type. The ID will be lower case.
	 * @return an identifier for the type
	 */
	public final String getId() {
		return id;
	}

	/**
	 * Returns whether the specified value matches the id of one of the {@link DeclarativeReferenceType} values. Case sensitive.
	 * @param value the value to check.
	 * @return whether the specified value matches the id of one of the {@link DeclarativeReferenceType} values
	 */
	public static boolean isId(final String value) {
		for (final DeclarativeReferenceType type : DeclarativeReferenceType.values()) {
			if (type.getId().equals(value)) {
				return true;
			}
		}

		return false;
	}
}
