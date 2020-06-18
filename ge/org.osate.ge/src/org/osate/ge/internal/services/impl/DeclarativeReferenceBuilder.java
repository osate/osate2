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
package org.osate.ge.internal.services.impl;

import java.util.List;

import javax.inject.Named;

import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.businessObjectHandlers.AadlReferenceUtil;
import org.osate.ge.aadl2.internal.model.SubprogramCallOrder;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.services.ReferenceBuilderService;

// Handles building references related to the AADL declarative model
public class DeclarativeReferenceBuilder {
	public static RelativeBusinessObjectReference getConnectionRelativeReference(final String name) {
		return AadlReferenceUtil.buildSimpleRelativeReference(DeclarativeReferenceType.CONNECTION.getId(), name);
	}

	public static RelativeBusinessObjectReference getSubcomponentRelativeReference(final String name) {
		return AadlReferenceUtil.buildSimpleRelativeReference(DeclarativeReferenceType.SUBCOMPONENT.getId(), name);
	}

	public static RelativeBusinessObjectReference getFlowSpecificationRelativeReference(final String name) {
		return AadlReferenceUtil.buildSimpleRelativeReference(DeclarativeReferenceType.FLOW_SPECIFICATION.getId(),
				name);
	}

	@BuildRelativeReference
	public RelativeBusinessObjectReference getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if (bo instanceof Subcomponent) {
			return getSubcomponentRelativeReference(((Subcomponent) bo).getName());
		} else if (bo instanceof Mode) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.MODE.getId(), ((Mode) bo));
		} else if (bo instanceof ModeTransition) {
			final ModeTransition mt = (ModeTransition) bo;
			final String name = mt.getName();
			if (name == null) {
				return buildUnnamedModeTransitionRelativeReference((ModeTransition) bo);
			} else {
				return buildSimpleRelativeReference(DeclarativeReferenceType.MODE_TRANSITION_NAMED.getId(), mt);
			}
		} else if (bo instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger) bo;
			return RelativeBusinessObjectReference
					.fromNullableSegments(new String[] { DeclarativeReferenceType.MODE_TRANSITION_TRIGGER.getId(),
							getNameForSerialization(mtt.getContext()),
							getNameForSerialization(mtt.getTriggerPort()) });
		} else if (bo instanceof SubprogramCallSequence) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.SUBPROGRAM_CALL_SEQUENCE.getId(),
					((SubprogramCallSequence) bo));
		} else if (bo instanceof SubprogramCall) {
			return buildSimpleRelativeReference(DeclarativeReferenceType.SUBPROGRAM_CALL.getId(),
					((SubprogramCall) bo));
		} else if (bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder) bo;
			return RelativeBusinessObjectReference
					.fromNullableSegments(new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL_ORDER.getId(),
							getNameForSerialization(sco.previousSubprogramCall),
							getNameForSerialization(sco.subprogramCall) });
		} else {
			return null;
		}
	}

	@BuildCanonicalReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final ReferenceBuilderService refBuilder) {
		if (bo instanceof Subcomponent) {
			return new String[] { DeclarativeReferenceType.SUBCOMPONENT.getId(),
					((Subcomponent) bo).getQualifiedName() };
		} else if (bo instanceof Mode) {
			return new String[] { DeclarativeReferenceType.MODE.getId(), ((Mode) bo).getQualifiedName() };
		} else if (bo instanceof ModeTransition) {
			final ModeTransition mt = (ModeTransition) bo;
			final String name = mt.getName();
			if (name == null) {
				return buildUnnamedModeTransitionKey((ModeTransition) bo);
			} else {
				return new String[] { DeclarativeReferenceType.MODE_TRANSITION_NAMED.getId(),
						refBuilder.getCanonicalReference(mt.eContainer())
						.encode(),
						getNameForSerialization(mt) };
			}
		} else if (bo instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger) bo;
			return new String[] { DeclarativeReferenceType.MODE_TRANSITION_TRIGGER.getId(),
					refBuilder.getCanonicalReference(mtt
							.eContainer())
					.encode(),
					getNameForSerialization(mtt.getContext()), getNameForSerialization(mtt.getTriggerPort()) };
		} else if (bo instanceof SubprogramCallSequence) {
			return new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL_SEQUENCE.getId(),
					((SubprogramCallSequence) bo).getQualifiedName() };
		} else if (bo instanceof SubprogramCall) {
			return new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL.getId(),
					((SubprogramCall) bo).getQualifiedName() };
		} else if (bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder) bo;
			return new String[] { DeclarativeReferenceType.SUBPROGRAM_CALL_ORDER.getId(),
					sco.previousSubprogramCall.getQualifiedName(),
					sco.subprogramCall.getQualifiedName() };
		} else {
			return null;
		}
	}

	static RelativeBusinessObjectReference buildUnnamedModeTransitionRelativeReference(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[4 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = DeclarativeReferenceType.MODE_TRANSITION_UNNAMED.getId();
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for (final ModeTransitionTrigger trigger : triggers) {
			key[index++] = getNameForSerialization(trigger.getContext());
			key[index++] = getNameForSerialization(trigger.getTriggerPort());
		}

		return RelativeBusinessObjectReference.fromNullableSegments(key);
	}

	public static String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}

	static String[] buildUnnamedModeTransitionKey(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[5 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = DeclarativeReferenceType.MODE_TRANSITION_UNNAMED.getId();
		key[index++] = mt.getContainingClassifier().getQualifiedName();
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for (final ModeTransitionTrigger trigger : triggers) {
			key[index++] = getNameForSerialization(trigger.getContext());
			key[index++] = getNameForSerialization(trigger.getTriggerPort());
		}

		return key;
	}


}

