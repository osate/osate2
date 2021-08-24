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
package org.osate.ge.ba.util;

import org.eclipse.xtext.xbase.lib.Pair;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.ba.ui.properties.BehaviorConditionEmbeddedTextValue;
import org.osate.ge.ba.ui.properties.EditableEmbeddedTextValue;

/**
 * Utility containing methods related to the source text of {@link BehaviorTransition} elements.
 */
public final class BehaviorTransitionEmbeddedTextUtil {
	/**
	 * Private constructor to prevent instantiation
	 */
	private BehaviorTransitionEmbeddedTextUtil() {
	}

	/**
	 * Creates an {@link EditableEmbeddedTextValue} that allows editing of the embedded AADL source for the {@link BehaviorCondition}
	 * @param behaviorTransition the {@link BehaviorTransition} that owns the Behavior Condition
	 * @return an {@link EditableEmbeddedTextValue} for the {@link BehaviorCondition}
	 */
	public static EditableEmbeddedTextValue createConditionTextValue(final BehaviorTransition behaviorTransition) {
		final String sourceText = BehaviorAnnexXtextUtil.getText(behaviorTransition);
		final int conditionOffset = getConditionOffset(behaviorTransition, sourceText);
		// Condition start
		final String afterPrefix = getAfterPrefix(sourceText, conditionOffset);

		// Text before condition text
		final String prefix = sourceText.substring(0, conditionOffset);
		final int conditionEnd = getConditionEnd(afterPrefix);

		// Text after condition
		final String suffix = afterPrefix.substring(conditionEnd);
		final String conditionText = afterPrefix.substring(0, conditionEnd).trim();
		return new BehaviorConditionEmbeddedTextValue(behaviorTransition, sourceText.length(), prefix, conditionText,
				suffix);
	}

	/**
	 * Returns AADL source region that contains the {@link BehaviorCondition} text
	 * @param behaviorTransition the {@link BehaviorTransition} that owns the Behavior Condition
	 * @param sourceText the full AADL source of the Behavior Transition's resource
	 * @return the AADL source region that contains the Behavior Condition text
	 */
	public static String getConditionText(final BehaviorTransition behaviorTransition, final String sourceText) {
		final int conditionOffset = getConditionOffset(behaviorTransition, sourceText);
		// Condition start
		final String afterPrefix = getAfterPrefix(sourceText, conditionOffset);
		final int conditionEnd = getConditionEnd(afterPrefix);
		// Condition text
		return afterPrefix.substring(0, conditionEnd).trim();
	}

	private static int getConditionEnd(final String afterPrefix) {
		// Note: condition.getAadlBaLocationReference().getLength() only counts until the first space (assuming).
		// For example, when dispatch condition is "on dispatch" length is 2.
		// Find closing "]", to get condition text
		return BehaviorAnnexXtextUtil.findUncommentedTerminationChar(afterPrefix, ']');
	}

	private static String getAfterPrefix(final String sourceText, final int conditionOffset) {
		return sourceText.substring(conditionOffset);
	}

	private static int getConditionOffset(final BehaviorTransition behaviorTransition, final String sourceText) {
		final BehaviorCondition condition = behaviorTransition.getCondition();
		final int conditionOffset;
		if (condition == null) {
			// Transition offset
			final int transitionOffset = behaviorTransition.getAadlBaLocationReference().getOffset();
			final Pair<Character, Character> charsToMatch = new Pair<Character, Character>('-', '[');
			// Find index for beginning of condition text "-["
			conditionOffset = BehaviorAnnexXtextUtil.findUncommentedCharPair(sourceText.substring(transitionOffset),
					charsToMatch) + transitionOffset;
		} else {
			// Condition offset
			conditionOffset = condition.getAadlBaLocationReference().getOffset();
		}

		return conditionOffset;
	}
}
