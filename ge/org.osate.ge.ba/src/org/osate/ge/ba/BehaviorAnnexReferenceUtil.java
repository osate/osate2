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
package org.osate.ge.ba;

import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.AnnexHandler;

public class BehaviorAnnexReferenceUtil {
	public static final String ANNEX_SUBCLAUSE = "annex_subclause";
	public static final String ANNEX_NAME = "behavior_specification";
	private static final String BA_REFERENCE_PREFIX = "ba.";
	public static final String STATE_TYPE = BA_REFERENCE_PREFIX + "behavior_state";
	public static final String TRANSITION_TYPE = BA_REFERENCE_PREFIX + "behavior_transition";
	public static final String VARIABLE_TYPE = BA_REFERENCE_PREFIX + "behavior_variable";

	public static RelativeBusinessObjectReference getSpecificationRelativeReference(final int index) {
		return AnnexHandler.getRelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.ANNEX_SUBCLAUSE,
				BehaviorAnnexReferenceUtil.ANNEX_NAME, index);
	}

	public static RelativeBusinessObjectReference getStateRelativeReference(final String name) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.STATE_TYPE, name);
	}

	public static RelativeBusinessObjectReference getTransitionRelativeReference(final int index) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.TRANSITION_TYPE, String.valueOf(index));
	}

	public static RelativeBusinessObjectReference getVariableRelativeReference(final String name) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.VARIABLE_TYPE, name);
	}
}
