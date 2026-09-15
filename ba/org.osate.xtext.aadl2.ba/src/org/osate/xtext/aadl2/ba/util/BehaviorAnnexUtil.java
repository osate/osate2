/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Mode;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

/** Compatibility access to the strict public BA model derived from an Xtext annex. */
public final class BehaviorAnnexUtil {
	private BehaviorAnnexUtil() {
	}

	/**
	 * Returns the Behavior Annex subclauses that apply to a classifier. AS5506/3 Rev. A D.3 applies the subclauses of
	 * an ancestor to a descendant except where the descendant declares its own, which completely replace the ancestor
	 * ones; the nearest classifier that declares any therefore supplies all of them. A component implementation is
	 * searched before its type, so a subclause of the type applies to an implementation that declares none of its own,
	 * the way core AADL inherits the rest of the type's declarations.
	 *
	 * <p>D.3 also lets a component with modes declare a separate subclause for each mode, so every subclause of the
	 * classifier that supplies them is returned; {@link #getBehaviorAnnexSubclauses(ComponentClassifier, Mode)}
	 * selects among them by mode.
	 *
	 * @param classifier component classifier to find the applicable subclauses of
	 * @return the applicable subclauses in declaration order, empty when neither the classifier nor anything it
	 *         inherits from declares one
	 */
	public static List<DefaultAnnexSubclause> getBehaviorAnnexSubclauses(final ComponentClassifier classifier) {
		Objects.requireNonNull(classifier, "classifier");
		final List<Classifier> searchOrder = new ArrayList<>(classifier.getSelfPlusAllExtended());
		if (classifier instanceof ComponentImplementation implementation && implementation.getType() != null) {
			searchOrder.addAll(implementation.getType().getSelfPlusAllExtended());
		}
		for (final var candidate : searchOrder) {
			final var declared = declaredBehaviorAnnexSubclauses(candidate);
			if (!declared.isEmpty()) {
				return declared;
			}
		}
		return List.of();
	}

	/**
	 * Returns the applicable Behavior Annex subclauses of a classifier that are in effect in a mode. D.3 lets a
	 * component with modes declare a separate subclause for each mode, and core AADL expresses which modes a subclause
	 * applies in with its {@code in modes} statement, so a subclause without one is in effect in every mode. Modes are
	 * matched by name, case insensitively, because an applicable subclause can be declared by an ancestor and name
	 * that ancestor's mode.
	 *
	 * @param classifier component classifier to find the applicable subclauses of
	 * @param mode mode to select the subclauses in effect in
	 * @return the applicable subclauses in effect in the mode, in declaration order
	 */
	public static List<DefaultAnnexSubclause> getBehaviorAnnexSubclauses(final ComponentClassifier classifier,
			final Mode mode) {
		Objects.requireNonNull(mode, "mode");
		final List<DefaultAnnexSubclause> result = new ArrayList<>();
		for (final var subclause : getBehaviorAnnexSubclauses(classifier)) {
			if (subclause.getInModes().isEmpty() || subclause.getInModes().stream()
					.anyMatch(applicable -> applicable.getName() != null
							&& applicable.getName().equalsIgnoreCase(mode.getName()))) {
				result.add(subclause);
			}
		}
		return Collections.unmodifiableList(result);
	}

	/**
	 * Returns the Behavior Annex subclauses a classifier declares itself. Selection is by annex name so that finding
	 * the applicable subclauses of a classifier does not parse the subclauses of other annexes.
	 */
	private static List<DefaultAnnexSubclause> declaredBehaviorAnnexSubclauses(final Classifier classifier) {
		final List<DefaultAnnexSubclause> result = new ArrayList<>();
		for (final var subclause : classifier.getOwnedAnnexSubclauses()) {
			if (subclause instanceof DefaultAnnexSubclause defaultAnnex
					&& BehaviorAnnexStandaloneSetup.ANNEX_NAME.equalsIgnoreCase(defaultAnnex.getName())) {
				result.add(defaultAnnex);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static org.osate.ba.aadlba.BehaviorAnnex getStrictModel(final DefaultAnnexSubclause defaultAnnex) {
		Objects.requireNonNull(defaultAnnex, "defaultAnnex");
		if (!(defaultAnnex.getParsedAnnexSubclause() instanceof BehaviorAnnex source)) {
			throw new IllegalArgumentException("The subclause does not contain an Xtext Behavior Annex model");
		}
		if (!(defaultAnnex.getContainingClassifier() instanceof ComponentClassifier owner)) {
			throw new IllegalArgumentException("The Behavior Annex is not contained in a component classifier");
		}
		return new DeclarativeToStrictTranslator().translate(source, owner).getStrictAnnex();
	}
}
