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

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveCanonicalReference;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

public class ErrorModelReferenceHandler {
	private final static String EMV2_REFERENCE_PREFIX = "emv2.";
	private final static String TYPE_BEHAVIOR_STATE_MACHINE = EMV2_REFERENCE_PREFIX + "behavior";
	private final static String TYPE_BEHAVIOR_EVENT = EMV2_REFERENCE_PREFIX + "behavior_event";
	private final static String TYPE_BEHAVIOR_STATE = EMV2_REFERENCE_PREFIX + "behavior_state";
	private final static String TYPE_BEHAVIOR_TRANSITION = EMV2_REFERENCE_PREFIX + "behavior_transition";
	private final static String TYPE_ANONYMOUS_BEHAVIOR_TRANSITION = EMV2_REFERENCE_PREFIX
			+ "anonymous_behavior_transition";
	private final static String TYPE_BEHAVIOR_TRANSITION_BRANCH = EMV2_REFERENCE_PREFIX + "behavior_transition_branch";
	private final static String TYPE_BEHAVIOR_TRANSITION_TRUNK = EMV2_REFERENCE_PREFIX + "behavior_transition_trunk";
	private final static String TYPE_ERROR_TYPE_LIBRARY = EMV2_REFERENCE_PREFIX + "error_type_library";
	private final static String TYPE_ERROR_TYPE = EMV2_REFERENCE_PREFIX + "error_type";
	private final static String TYPE_ERROR_TYPE_EXT = EMV2_REFERENCE_PREFIX + "error_type_extension";
	private final static String IS_STEADY = "<steady>"; // Used to identify the transition or branch as steady state.

	@BuildRelativeReference
	public String[] getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof ErrorBehaviorStateMachine) {
			return new String[] {TYPE_BEHAVIOR_STATE_MACHINE, ((ErrorBehaviorStateMachine)bo).getName()};
		} else if(bo instanceof ErrorBehaviorEvent) {
			return new String[] {TYPE_BEHAVIOR_EVENT, ((ErrorBehaviorEvent)bo).getName()};
		} else if(bo instanceof ErrorBehaviorState) {
			return new String[] {TYPE_BEHAVIOR_STATE, ((ErrorBehaviorState)bo).getName()};
		} else if(bo instanceof ErrorBehaviorTransition) {
			final ErrorBehaviorTransition t = (ErrorBehaviorTransition) bo;
			final String name = t.getName();
			if (name == null) {
				return buildAnonymousBehaviorTransitionRelativeReference(t);
			} else {
				return new String[] { TYPE_BEHAVIOR_TRANSITION, name };
			}

		} else if (bo instanceof TransitionBranch) {
			final TransitionBranch b = (TransitionBranch) bo;
			return new String[] { TYPE_BEHAVIOR_TRANSITION_BRANCH, getTargetNameForSerialization(b),
					Integer.toString(getTransitionBranchIndex(b)) };
		} else if (bo instanceof BehaviorTransitionTrunk) {
			return new String[] {TYPE_BEHAVIOR_TRANSITION_TRUNK};
		} if(bo instanceof ErrorType) {
			return new String[] {TYPE_ERROR_TYPE, ((ErrorType)bo).getName()};
		} else if(bo instanceof ErrorTypeExtension) {
			return new String[] {TYPE_ERROR_TYPE_EXT };
		} else if (bo instanceof ErrorTypeLibrary) {
			return new String[] { TYPE_ERROR_TYPE_LIBRARY };
		}

		return null;
	}

	@BuildCanonicalReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo, final ReferenceBuilderService refBuilder) {
		if(bo instanceof Element) {
			final Element el = (Element)bo;

			if(el.getElementRoot() instanceof AadlPackage) {
				final AadlPackage pkg = (AadlPackage)el.getElementRoot();
				if(bo instanceof ErrorBehaviorStateMachine) {
					return new String[] { TYPE_BEHAVIOR_STATE_MACHINE, refBuilder.getReference(pkg),
							((ErrorBehaviorStateMachine) bo).getName() };
				} else if(bo instanceof ErrorBehaviorEvent) {
					final ErrorBehaviorEvent typedBo = (ErrorBehaviorEvent)bo;
					return new String[] { TYPE_BEHAVIOR_EVENT, refBuilder.getReference(typedBo.eContainer()),
							typedBo.getName() };
				} else if(bo instanceof ErrorBehaviorState) {
					final ErrorBehaviorState typedBo = (ErrorBehaviorState)bo;
					return new String[] { TYPE_BEHAVIOR_STATE, refBuilder.getReference(typedBo.eContainer()),
							typedBo.getName() };
				} else if(bo instanceof ErrorBehaviorTransition) {
					final ErrorBehaviorTransition typedBo = (ErrorBehaviorTransition)bo;
					if (typedBo.getName() == null) {
						return buildAnonymousBehaviorTransitionCanonicalReference((ErrorBehaviorTransition) bo,
								refBuilder);
					} else {
						return new String[] { TYPE_BEHAVIOR_TRANSITION, refBuilder.getReference(typedBo.eContainer()),
								typedBo.getName() };
					}
				} else if (bo instanceof TransitionBranch) {
					final TransitionBranch b = (TransitionBranch) bo;
					return new String[] { TYPE_BEHAVIOR_TRANSITION_BRANCH,
							refBuilder.getReference(b.eContainer()), getTargetNameForSerialization(b),
							Integer.toString(getTransitionBranchIndex(b)) };
				} else if (bo instanceof BehaviorTransitionTrunk) {
					final BehaviorTransitionTrunk trunk = (BehaviorTransitionTrunk) bo;
					return new String[] { TYPE_BEHAVIOR_TRANSITION_TRUNK,
							refBuilder.getReference(trunk.getTransition()) };
				} else if(bo instanceof ErrorType) {
					return new String[] { TYPE_ERROR_TYPE, refBuilder.getReference(pkg), ((ErrorType) bo).getName() };
				} else if (bo instanceof ErrorTypeLibrary) {
					return new String[] { TYPE_ERROR_TYPE_LIBRARY, refBuilder.getReference(pkg) };
				}
			}
		} else if(bo instanceof ErrorTypeExtension) {
			final ErrorTypeExtension ete = (ErrorTypeExtension)bo;
			if(ete.getSubtype().getElementRoot() instanceof AadlPackage && ete.getSupertype().getElementRoot() instanceof AadlPackage) {
				return new String[] {TYPE_ERROR_TYPE_EXT,
						refBuilder.getReference(ete.getSupertype()),
						refBuilder.getReference(ete.getSubtype())};
			}
		}

		return null;
	}

	@ResolveCanonicalReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] ref, final ReferenceResolutionService refService) {
		Objects.requireNonNull(ref, "ref must not be null");
		// Handle references with 2 or more segments
		if(ref.length < 2) {
			return null;
		}

		// Check that the type is an EMV2 type
		final String type = ref[0];
		if(!type.startsWith(EMV2_REFERENCE_PREFIX)) {
			return null;
		}

		// Retrieve the referenced object
		final Object ref1 = refService.getReferencedObject(ref[1]);
		if(ref1 == null) {
			return null;
		}

		if (ref.length == 2 && type.equals(TYPE_BEHAVIOR_TRANSITION_TRUNK)) {
			final ErrorBehaviorTransition transition = (ErrorBehaviorTransition) ref1;
			return new BehaviorTransitionTrunk(transition);
		}

		// Handle types which require 3 reference segments
		if(ref.length < 3) {
			return null;
		}

		if(type.equals(TYPE_BEHAVIOR_STATE_MACHINE)) {
			final AadlPackage pkg = (AadlPackage)ref1;
			final String name = ref[2];
			return pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary()).getBehaviors().stream()). // Get behaviors as stream
					reduce(Stream.empty(), (a, b) -> Stream.concat(a, b)). // Combine streams
					filter(b -> name.equalsIgnoreCase(b.getName())). // Filter behaviors by name
					findAny().orElse(null);
		} else if(type.equals(TYPE_BEHAVIOR_EVENT)) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)ref1;
			final String name = ref[2];
			return stateMachine.getEvents().stream().
					filter(o -> name.equalsIgnoreCase(o.getName())). // Filter objects by name
					findAny().orElse(null);
		} else if(type.equals(TYPE_BEHAVIOR_STATE)) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)ref1;
			final String name = ref[2];
			return stateMachine.getStates().stream().
					filter(o -> name.equalsIgnoreCase(o.getName())). // Filter objects by name
					findAny().orElse(null);
		} else if(type.equals(TYPE_BEHAVIOR_TRANSITION)) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)ref1;
			final String name = ref[2];
			return stateMachine.getTransitions().stream().
					filter(o -> name.equalsIgnoreCase(o.getName())). // Filter objects by name
					findAny().orElse(null);
		} else if(type.equals(TYPE_ERROR_TYPE)) {
			final AadlPackage pkg = (AadlPackage)ref1;
			final String name = ref[2];

			final Optional<ErrorType> errorType = pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary()).getTypes().stream()). // Get types as stream
					reduce(Stream.empty(), (a, b) -> Stream.concat(a, b)). // Combine streams
					filter(b -> name.equalsIgnoreCase(b.getName())). // Filter types by name
					findAny();

			return errorType.orElse(null);
		} else if(type.equals(TYPE_ERROR_TYPE_EXT)) {
			final ErrorType supertype = (ErrorType)ref1;
			final ErrorType subtype = (ErrorType)refService.getReferencedObject(ref[2]);
			if(supertype == null || subtype == null) {
				return null;
			}

			return new ErrorTypeExtension(supertype, subtype);
		}

		return null;
	}

	private static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}

	private static String[] buildAnonymousBehaviorTransitionRelativeReference(final ErrorBehaviorTransition t) {
		return new String[] { TYPE_ANONYMOUS_BEHAVIOR_TRANSITION, getNameForSerialization(t.getSource()),
				getTargetNameForSerialization(t), Integer.toString(getAnonymousBehaviorTransitionIndex(t)) };
	}

	private static String[] buildAnonymousBehaviorTransitionCanonicalReference(final ErrorBehaviorTransition t,
			final ReferenceBuilderService refBuilder) {
		return new String[] { TYPE_ANONYMOUS_BEHAVIOR_TRANSITION, refBuilder.getReference(t.eContainer()),
				getNameForSerialization(t.getSource()),
				getTargetNameForSerialization(t), Integer.toString(getAnonymousBehaviorTransitionIndex(t)) };
	}

	/**
	 * Gets the index of an anonymous error behavior transition. The index is a zero based value of the transitions with the same source and target.
	 * @param t
	 * @return the index or -1 if the appropriate index could not be determined.
	 */
	private static int getAnonymousBehaviorTransitionIndex(final ErrorBehaviorTransition t) {
		// Check type of container
		if (!(t.eContainer() instanceof ErrorBehaviorStateMachine)) {
			return -1;
		}

		final ErrorBehaviorStateMachine sm = (ErrorBehaviorStateMachine) t.eContainer();

		return getIndex(t,
				sm.getTransitions().stream().filter(tmpTransition -> tmpTransition.getSource() == t.getSource()
				&& tmpTransition.getTarget() == t.getTarget()));
	}

	private static int getTransitionBranchIndex(final TransitionBranch b) {
		// Check type of container
		if (!(b.eContainer() instanceof ErrorBehaviorTransition)) {
			return -1;
		}

		final ErrorBehaviorTransition t = (ErrorBehaviorTransition) b.eContainer();
		return getIndex(b,
				t.getDestinationBranches().stream().filter(tmpBranch -> tmpBranch.getTarget() == t.getTarget()));
	}

	private static <T> int getIndex(final T bo, final Stream<T> matchingSiblings) {
		int index = 0;
		for (final Object tmp : (Iterable<T>) matchingSiblings::iterator) {
			if (tmp == bo) {
				return index;
			}

			index++;
		}
		return -1;
	}

	private static String getTargetNameForSerialization(final ErrorBehaviorTransition t) {
		if (t.isSteadyState()) {
			return IS_STEADY;
		} else {
			// Branching transitions will use the serialization of the null target name.
			return getNameForSerialization(t.getTarget());
		}
	}

	private static String getTargetNameForSerialization(final TransitionBranch b) {
		if (b.isSteadyState()) {
			return IS_STEADY;
		} else {
			return getNameForSerialization(b.getTarget());
		}
	}

}
