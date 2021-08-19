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
package org.osate.ge.errormodel;

import java.util.stream.Stream;

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

/**
 * Class containing constants and utility functions related to references to error model business objects
 */
public final class ErrorModelReferenceUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private ErrorModelReferenceUtil() {
	}

	private static final String EMV2_REFERENCE_PREFIX = "emv2.";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine} references
	 */
	public static final String TYPE_BEHAVIOR_STATE_MACHINE = EMV2_REFERENCE_PREFIX + "behavior";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent} references
	 */
	public static final String TYPE_BEHAVIOR_EVENT = EMV2_REFERENCE_PREFIX + "behavior_event";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState} references
	 */
	public static final String TYPE_BEHAVIOR_STATE = EMV2_REFERENCE_PREFIX + "behavior_state";

	/**
	 * First segment for named {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition} references
	 */
	public static final String TYPE_BEHAVIOR_TRANSITION = EMV2_REFERENCE_PREFIX + "behavior_transition";

	/**
	 * First segment for nameless {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition} references
	 */
	public static final String TYPE_ANONYMOUS_BEHAVIOR_TRANSITION = EMV2_REFERENCE_PREFIX
			+ "anonymous_behavior_transition";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch} references
	 */
	public static final String TYPE_BEHAVIOR_TRANSITION_BRANCH = EMV2_REFERENCE_PREFIX + "behavior_transition_branch";

	/**
	 * First segment for {@link org.osate.ge.errormodel.model.BehaviorTransitionTrunk} references
	 */
	public static final String TYPE_BEHAVIOR_TRANSITION_TRUNK = EMV2_REFERENCE_PREFIX + "behavior_transition_trunk";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType} references
	 */
	public static final String TYPE_ERROR_TYPE = EMV2_REFERENCE_PREFIX + "error_type";

	/**
	 * First segment for {@link org.osate.ge.errormodel.model.ErrorTypeExtension} references
	 */
	public static final String TYPE_ERROR_TYPE_EXT = EMV2_REFERENCE_PREFIX + "error_type_extension";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet} references
	 */
	public static final String TYPE_TYPE_SET = EMV2_REFERENCE_PREFIX + "error_type_set";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath} references
	 */
	public static final String TYPE_PROPAGATION_POINT = EMV2_REFERENCE_PREFIX + "propagation_point";

	/**
	 * First segment for {@link org.osate.ge.errormodel.model.KeywordPropagationPoint} references
	 */
	public static final String TYPE_KEYWORD_PROPAGATION_POINT = EMV2_REFERENCE_PREFIX + "keyword_propagation_point";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation} references
	 */
	public static final String TYPE_PROPAGATION = EMV2_REFERENCE_PREFIX + "propagation";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath} references
	 */
	public static final String TYPE_PROPAGATION_PATH = EMV2_REFERENCE_PREFIX + "propagation_path";

	/**
	 * First segment for {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow} references
	 */
	public static final String TYPE_ERROR_FLOW = EMV2_REFERENCE_PREFIX + "error_flow";

	/**
	 * Name used when serializing a steady state transition or transition branches
	 */
	public static final String IS_STEADY = "<steady>";

	/**
	 * Returns the element name that should be used for serialization. Will never return null.
	 * @param ne the element for which to get the serialization name.
	 * @return the string to use to serialize the name.
	 */
	public static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}

	/**
	 * Returns the index of the specified object in the stream. Returns -1 if the object is not in the stream.
	 * @param <T> the type of objects contained in the stream.
	 * @param bo the object for which to get the index.
	 * @param searchStream the stream to search
	 * @return the index of the specified object in the stream.
	 */
	public static <T> int getIndex(final T bo, final Stream<T> searchStream) {
		int index = 0;
		for (final Object tmp : (Iterable<T>) searchStream::iterator) {
			if (tmp == bo) {
				return index;
			}

			index++;
		}
		return -1;
	}

	/**
	 * Returns the string that should be used to serialize a transition branch's target. Will never return null.
	 * @param b the branch for which to get the target name
	 * @return the string that should be used to serialize the target
	 */
	public static String getTargetNameForSerialization(final TransitionBranch b) {
		if (b.isSteadyState()) {
			return IS_STEADY;
		} else {
			return getNameForSerialization(b.getTarget());
		}
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType}
	 * @param name the error type's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForErrorType(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_TYPE, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet}
	 * @param name the error type set's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForTypeSet(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_TYPE_SET, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.ge.errormodel.model.ErrorTypeExtension}
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForErrorTypeExtension() {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_TYPE_EXT);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine}
	 * @param name the state machine's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForStateMachine(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_STATE_MACHINE, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState}
	 * @param name the error behavior state's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForState(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_STATE, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent}
	 * @param name the error behavior events's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForEvent(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_EVENT, name);
	}

	/**
	 * Builds a relative reference for a named {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition}
	 * @param name the transition's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForNamedTransition(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION, name);
	}

	/**
	 * Builds a relative reference for a {@link TransitionBranch}
	 * @param serializableTargetName the serializable name of the branch's target. See {@link #getTargetNameForSerialization}
	 * @param index the index of the branch
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForTransitionBranch(
			final String serializableTargetName, final int index) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION_BRANCH,
				serializableTargetName, Integer.toString(index));
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint}
	 * @param name the propagation point's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForPropagationPoint(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION_POINT, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.ge.errormodel.model.KeywordPropagationPoint}
	 * @param name the keyword propagation point's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForKeywordPropagationPoint(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_KEYWORD_PROPAGATION_POINT, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation}
	 * @param isContainment whether the propagation is a containment
	 * @param direction the direction of the propagation
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForPropagation(final boolean isContainment,
			final DirectionType direction) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION,
				Boolean.toString(isContainment), direction == null ? "<null>" : direction.getLiteral());
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath}
	 * @param name the propagation path's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForPropagationPath(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION_PATH, name);
	}

	/**
	 * Builds a relative reference for an {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow}
	 * @param name the error flow's name
	 * @return the relative reference
	 */
	public static RelativeBusinessObjectReference getRelativeReferenceForErrorFlow(final String name) {
		return new RelativeBusinessObjectReference(ErrorModelReferenceUtil.TYPE_ERROR_FLOW, name);
	}
}
