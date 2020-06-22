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
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveCanonicalReference;
import org.osate.ge.errormodel.businessObjectHandlers.ErrorModelReferenceUtil;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorModelReferenceHandler {

	@ResolveCanonicalReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] ref, final ReferenceResolutionService refService) {
		Objects.requireNonNull(ref, "ref must not be null");
		// Handle references with 2 or more segments
		if(ref.length < 2) {
			return null;
		}

		// Check that the type is an EMV2 type
		final String type = ref[0];
		if (!type.startsWith(ErrorModelReferenceUtil.EMV2_REFERENCE_PREFIX)) {
			return null;
		}

		// Retrieve the referenced object
		final Object ref1 = refService.resolve(CanonicalBusinessObjectReference.decode(ref[1]));
		if(ref1 == null) {
			return null;
		}

		if (ref.length == 2 && type.equals(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION_TRUNK)) {
			final ErrorBehaviorTransition transition = (ErrorBehaviorTransition) ref1;
			return new BehaviorTransitionTrunk(transition);
		}

		// Handle types which require 3 reference segments
		if(ref.length < 3) {
			return null;
		}

		if (type.equals(ErrorModelReferenceUtil.TYPE_BEHAVIOR_STATE_MACHINE)) {
			final AadlPackage pkg = (AadlPackage)ref1;
			final String name = ref[2];
			return pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary()).getBehaviors().stream()). // Get behaviors as stream
					reduce(Stream.empty(), (a, b) -> Stream.concat(a, b)). // Combine streams
					filter(b -> name.equalsIgnoreCase(b.getName())). // Filter behaviors by name
					findAny().orElse(null);
		} else if (type.equals(ErrorModelReferenceUtil.TYPE_BEHAVIOR_EVENT)) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)ref1;
			final String name = ref[2];
			return stateMachine.getEvents().stream().
					filter(o -> name.equalsIgnoreCase(o.getName())). // Filter objects by name
					findAny().orElse(null);
		} else if (type.equals(ErrorModelReferenceUtil.TYPE_BEHAVIOR_STATE)) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)ref1;
			final String name = ref[2];
			return stateMachine.getStates().stream().
					filter(o -> name.equalsIgnoreCase(o.getName())). // Filter objects by name
					findAny().orElse(null);
		} else if (type.equals(ErrorModelReferenceUtil.TYPE_BEHAVIOR_TRANSITION)) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)ref1;
			final String name = ref[2];
			return stateMachine.getTransitions().stream().
					filter(o -> name.equalsIgnoreCase(o.getName())). // Filter objects by name
					findAny().orElse(null);
		} else if (type.equals(ErrorModelReferenceUtil.TYPE_ERROR_TYPE)) {
			final AadlPackage pkg = (AadlPackage)ref1;
			final String name = ref[2];

			final Optional<ErrorType> errorType = pkg.getOwnedPublicSection().getOwnedAnnexLibraries().stream(). // Get annex libraries
					filter(lib -> lib instanceof DefaultAnnexLibrary && ((DefaultAnnexLibrary)lib).getParsedAnnexLibrary() instanceof ErrorModelLibrary). // Filter non EMV2 Libraries
					map(lib -> ((ErrorModelLibrary)((DefaultAnnexLibrary)lib).getParsedAnnexLibrary()).getTypes().stream()). // Get types as stream
					reduce(Stream.empty(), (a, b) -> Stream.concat(a, b)). // Combine streams
					filter(b -> name.equalsIgnoreCase(b.getName())). // Filter types by name
					findAny();

			return errorType.orElse(null);
		} else if (type.equals(ErrorModelReferenceUtil.TYPE_ERROR_TYPE_EXT)) {
			final ErrorType supertype = (ErrorType)ref1;
			final ErrorType subtype = (ErrorType) refService
					.resolve(CanonicalBusinessObjectReference.decode(ref[2]));
			if(supertype == null || subtype == null) {
				return null;
			}

			return new ErrorTypeExtension(supertype, subtype);
		}

		return null;
	}


}
