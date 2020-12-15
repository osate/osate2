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
package org.osate.ge.errormodel;

import java.util.stream.Stream;

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

public class ErrorModelReferenceUtil {
	private ErrorModelReferenceUtil() {
	}

	public final static String EMV2_REFERENCE_PREFIX = "emv2.";
	public final static String TYPE_BEHAVIOR_STATE_MACHINE = EMV2_REFERENCE_PREFIX + "behavior";
	public final static String TYPE_BEHAVIOR_EVENT = EMV2_REFERENCE_PREFIX + "behavior_event";
	public final static String TYPE_BEHAVIOR_STATE = EMV2_REFERENCE_PREFIX + "behavior_state";
	public final static String TYPE_BEHAVIOR_TRANSITION = EMV2_REFERENCE_PREFIX + "behavior_transition";
	public final static String TYPE_ANONYMOUS_BEHAVIOR_TRANSITION = EMV2_REFERENCE_PREFIX
			+ "anonymous_behavior_transition";
	public final static String TYPE_BEHAVIOR_TRANSITION_BRANCH = EMV2_REFERENCE_PREFIX + "behavior_transition_branch";
	public final static String TYPE_BEHAVIOR_TRANSITION_TRUNK = EMV2_REFERENCE_PREFIX + "behavior_transition_trunk";
	public final static String TYPE_ERROR_TYPE_LIBRARY = EMV2_REFERENCE_PREFIX + "error_type_library";
	public final static String TYPE_ERROR_TYPE = EMV2_REFERENCE_PREFIX + "error_type";
	public final static String TYPE_ERROR_TYPE_EXT = EMV2_REFERENCE_PREFIX + "error_type_extension";
	public final static String TYPE_TYPE_SET = EMV2_REFERENCE_PREFIX + "error_type_set";
	public final static String TYPE_PROPAGATION_POINT = EMV2_REFERENCE_PREFIX + "propagation_point";
	public final static String TYPE_KEYWORD_PROPAGATION_POINT = EMV2_REFERENCE_PREFIX + "keyword_propagation_point";
	public final static String TYPE_PROPAGATION = EMV2_REFERENCE_PREFIX + "propagation";
	public final static String TYPE_PROPAGATION_PATH = EMV2_REFERENCE_PREFIX + "propagation_path";
	public final static String TYPE_ERROR_FLOW = EMV2_REFERENCE_PREFIX + "error_flow";
	public final static String IS_STEADY = "<steady>"; // Used to identify the transition or branch as steady state.

	public static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}

	public static <T> int getIndex(final T bo, final Stream<T> matchingSiblings) {
		int index = 0;
		for (final Object tmp : (Iterable<T>) matchingSiblings::iterator) {
			if (tmp == bo) {
				return index;
			}

			index++;
		}
		return -1;
	}

	public static String getTargetNameForSerialization(final TransitionBranch b) {
		if (b.isSteadyState()) {
			return IS_STEADY;
		} else {
			return getNameForSerialization(b.getTarget());
		}
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForErrorType(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_TYPE, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForTypeSet(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_TYPE_SET, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForErrorTypeExtension() {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_TYPE_EXT);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForStateMachine(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_STATE_MACHINE, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForState(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_STATE, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForEvent(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_EVENT, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForNamedTransition(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForTransitionBranch(
			final String serializableTargetName, final int index) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION_BRANCH,
				serializableTargetName,
				Integer.toString(index));
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForPropagationPoint(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION_POINT, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForKeywordPropagationPoint(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_KEYWORD_PROPAGATION_POINT, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForPropagation(final boolean isContainment,
			final DirectionType direction) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION,
				Boolean.toString(isContainment), direction == null ? "<null>" : direction.getLiteral());
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForPropagationPath(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION_PATH, name);
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForErrorFlow(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_FLOW, name);
	}
}
