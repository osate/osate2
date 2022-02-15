/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba;

import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.AnnexHandler;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;

/**
 * Class containing constants and utility functions related to references to behavior annex business objects
 *
 */
public class BehaviorAnnexReferenceUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private BehaviorAnnexReferenceUtil() {
	}

	/**
	 * First segment for annex subclause references
	 */
	private static final String ANNEX_SUBCLAUSE = DeclarativeReferenceType.ANNEX_SUBCLAUSE.getId();

	/**
	 * Name of the behavior specification annex subclauses
	 */
	public static final String ANNEX_NAME = "behavior_specification";

	private static final String BA_REFERENCE_PREFIX = "ba.";

	/**
	 * First segment for state references
	 */
	public static final String STATE_TYPE = BA_REFERENCE_PREFIX + "behavior_state";

	/**
	 * First segment of behavior transitions references
	 */
	public static final String TRANSITION_TYPE = BA_REFERENCE_PREFIX + "behavior_transition";

	/**
	 * First segment of variable references
	 */
	public static final String VARIABLE_TYPE = BA_REFERENCE_PREFIX + "behavior_variable";

	/**
	 * First segment of behavior condition references
	 * @since 2.0
	 */
	public static final String BEHAVIOR_CONDITION = BA_REFERENCE_PREFIX + "behavior_condition";

	/**
	 * Returns the relative reference for a behavior specification
	 * @param index see {@link AnnexHandler#getAnnexSubclauseIndex(org.osate.aadl2.AnnexSubclause, boolean)}
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getSpecificationRelativeReference(final int index) {
		return AnnexHandler.getRelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.ANNEX_SUBCLAUSE,
				BehaviorAnnexReferenceUtil.ANNEX_NAME, index);
	}

	/**
	 * Returns the relative reference for a state with the specified name
	 * @param name the name of the state
	 * @return the relative reference for the state
	 */
	public static RelativeBusinessObjectReference getStateRelativeReference(final String name) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.STATE_TYPE, name);
	}

	/**
	 * Returns the relative reference for a transition with the specified identifier
	 * @param id the identifier for the transition. If the transition has a name, this is the name of the transition. If it is not named, then this
	 * is expected to be the index of the transition within the behavior specification
	 * @return the relative reference for the transition
	 */
	public static RelativeBusinessObjectReference getTransitionRelativeReference(
			final String id) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.TRANSITION_TYPE, id);
	}

	/**
	 * Returns a relative reference for the variable with the specified name
	 * @param name the name of the variable
	 * @return the relative reference for the variable
	 */
	public static RelativeBusinessObjectReference getVariableRelativeReference(final String name) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.VARIABLE_TYPE, name);
	}
}
