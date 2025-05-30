/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.businessobjecthandling.RenameContext;

/**
 * Utility class for naming behavior annex elements
 *
 */
public final class BehaviorAnnexNamingUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private BehaviorAnnexNamingUtil() {
	}

	private final static Set<String> RESERVED_WORDS; // Set which compares entries base on a case-insensitive comparison
	static {
		RESERVED_WORDS = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		RESERVED_WORDS.addAll(Arrays.asList("abs", "and", "any", "binding", "classifier", "complete", "computation",
				"count", "dispatch", "do", "else", "elsif", "end", "false", "final", "for", "forall", "fresh", "frozen",
				"if", "in", "initial", "lower_bound", "mod", "not", "on", "or", "otherwise", "reference", "variables",
				"rem", "state", "states", "stop", "timeout", "transitions", "true", "until", "upper_bound", "while",
				"xor"));
	}

	/**
	 * Creates a new unique identifier
	 * @param ba the behavior annex for which the identifier must be unique
	 * @param baseIdentifier the identifier to start with when building the identifier. If this identifier is unique, it will be returned.
	 * @return a new unique identifier
	 */
	public static String buildUniqueIdentifier(final BehaviorAnnex ba, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(ba);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);
	}

	private static String buildUniqueIdentifier(final Set<String> existingIdentifiers, final String baseIdentifier) {
		// Resolve naming conflicts
		String newIdentifier = baseIdentifier;
		boolean done = false;
		int num = 1;
		do {
			if (existingIdentifiers.contains(newIdentifier.toLowerCase())) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while (!done);

		return newIdentifier;
	}

	private static Set<String> buildNameSet(final BehaviorAnnex ba) {
		final Set<String> names = new HashSet<String>();
		addToNameSet(names, ba.getStates());
		addToNameSet(names, ba.getVariables());
		addToNameSet(names, ba.getTransitions());
		return names;
	}

	private static void addToNameSet(final Set<String> names, final Collection<? extends NamedElement> elements) {
		for (final NamedElement el : elements) {
			if (el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
	}

	/**
	 * Determines whether a specified string is a valid AADL identifier
	 * @param value
	 * @return
	 */
	private static boolean isValidIdentifier(final String value) {
		if (RESERVED_WORDS.contains(value)) {
			return false;
		}

		return value.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*+");
	}

	/**
	 * Returns whether an behavior annex element is conflicting with features, modes, or data subcomponents.
	 */
	private static boolean nameIsConflictingInClassifiers(final Classifier classifier,
			final String newName) {
		final Stream.Builder<String> builder = Stream.builder();
		classifier.getAllFeatures().forEach(feature -> builder.add(feature.getName()));

		if (classifier instanceof ComponentImplementation) {
			((ComponentImplementation) classifier).getAllSubcomponents().stream()
					.filter(sc -> sc instanceof DataSubcomponent)
					.forEach(sc -> builder.add(AgeAadlUtil.getRootRefinedElement(sc).getName()));
		}

		return builder.build().anyMatch(name -> newName.equalsIgnoreCase(name));
	}

	/**
	 * Check if behavior element new name is valid.
	 * @param ctx the context containing the informaton regarding the proposed rename
	 * @return empty if the name is valid. Otherwise returns the error message
	 */
	public static Optional<String> checkNameValidity(final RenameContext ctx) {
		final NamedElement ne = ctx.getBusinessObject(NamedElement.class).orElseThrow();
		final String newName = ctx.getNewName();
		return checkNameValidity(ne, newName);
	}

	/**
	 * Check if behavior element new name is valid.
	 * @param ne the named element to check
	 * @param newName the proposed name
	 * @return empty if the name is valid.  Otherwise return the error message
	 */
	public static Optional<String> checkNameValidity(final NamedElement ne, final String newName) {
		if (newName.equalsIgnoreCase(ne.getName())) {
			return Optional.empty();
		}

		if (!BehaviorAnnexNamingUtil.isValidIdentifier(newName)) {
			return Optional.of("The specified name is not a valid AADL identifier");
		}

		// Check for conflicts in the owning behavior annex
		final Element owner = ne.getOwner();
		if (BehaviorAnnexNamingUtil.isNameInUseInBehaviorAnnex(owner, newName)) {
			return Optional.of("The specified name conflicts with an existing member of the behavior annex.");
		}

		if (ne instanceof BehaviorState) {
			final BehaviorState behaviorState = (BehaviorState) ne;
			final Optional<String> modeNameMatch = getModeNames(behaviorState.getContainingClassifier())
					.filter(modeName -> newName.equalsIgnoreCase(modeName)).findAny();
			// States can match mode names
			if (modeNameMatch.isPresent()) {
				return Optional.empty();
			}
		}

		// Check for conflicts of modes, features, and data subcomponents, including inherited elements.
		if (BehaviorAnnexNamingUtil.nameIsConflictingInClassifiers(ne.getContainingClassifier(),
				newName)) {
			return Optional.of("The specified name conflicts with an existing element.");
		}

		return Optional.empty();
	}

	private static Stream<String> getModeNames(final Classifier classifier) {
		if (classifier instanceof ComponentClassifier) {
			return ((ComponentClassifier) classifier).getAllModes().stream().map(Mode::getName);
		}

		return Stream.empty();
	}

	private static boolean isNameInUseInBehaviorAnnex(final Element owner, final String newName) {
		return owner.getChildren().stream().anyMatch(child -> {
			if (child instanceof NamedElement) {
				final NamedElement ne = (NamedElement) child;
				return newName.equalsIgnoreCase(ne.getName());
			}

			return false;
		});
	}
}
