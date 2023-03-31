/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba.ui.properties;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.unparser.AadlBaUnparser;
import org.osate.ge.ProjectUtil;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.ba.ui.EmbeddedTextEditor;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;

/**
 * EditableEmbeddedTextValue for editing an {@link BehaviorActionBlock} in an {@link EmbeddedTextEditor}
 * @since 2.0
 */
public class BehaviorActionBlockEmbeddedTextValue extends EditableEmbeddedTextValue {
	/**
	 * The behavior transition that owns the behavior action block that is being edited
	 */
	private final BehaviorTransition behaviorTransition;

	/**
	 * Instantiates an {@link EditableEmbeddedTextValue} for {@link BehaviorActionBlock} and editing support within an {@link EmbeddedTextEditor}
	 * @param behaviorTransition the owner of the {@link BehaviorActionBlock} being edited
	 * @param originalSrcLength is the length of the AADL source before being edited
	 * Note: The {@link #originalSrcLength} may not be the same length as {@link #prefix}, {@link #editableText}, and {@link #suffix} combined
	 * because although these values are derived from the original AADL source, they may be modified to support embedded editing.
	 * @param prefix is the text before the modifiable text
	 * @param editableText is the text that is modifiable
	 * @param suffix is the text after the modifiable text
	 */
	private BehaviorActionBlockEmbeddedTextValue(final BehaviorTransition behaviorTransition,
			final int originalSrcLength, final String prefix, final String editableText, final String suffix) {
		super(ProjectUtil.getProjectForBoOrThrow(behaviorTransition), originalSrcLength, prefix, editableText, suffix);
		this.behaviorTransition = behaviorTransition;
	}

	@Override
	public String getEditDialogTitle() {
		return "Edit Transition Action";
	}

	@Override
	public String getEditDialogMessage() {
		return "Enter new action block.";
	}

	@Override
	public String getModificationLabel() {
		return "Modify Behavior Transition Action";
	}

	@Override
	public boolean isValidModification(final EObject bo, final String newText) {
		if (bo instanceof BehaviorTransition) {
			final BehaviorActionBlock actionBlock = ((BehaviorTransition) bo).getActionBlock();
			// Calculate enabled based on if action should exist and if it exists
			return newText.isEmpty() ? actionBlock == null : actionBlock != null;
		}

		return false;
	}

	@Override
	public NamedElement getElementToModify() {
		return behaviorTransition;
	}

	@Override
	public Optional<String> getModifiedAADLSourceForNewText(final String newActionBlock) {
		if (newActionBlock.isBlank()) {
			// Remove brackets for empty action block
			final String prefix = getPrefix();
			return Optional
					.of(new StringBuilder(prefix.substring(0, prefix.length() - 1)).append(getSuffix().substring(1))
							.toString());
		}

		return Optional.empty();
	}

	@Override
	public void setEditableText(String newActionBlock) {
		final boolean actionExists = !getEditableText().isEmpty();
		if (!actionExists && !newActionBlock.isEmpty()) {
			// Modify prefix to account for bracket being added
			setPrefix(getPrefix().substring(0, getPrefix().length() - 1));
			// Add braces for creating new action block
			newActionBlock = "{" + newActionBlock + "}";
		} else {
			if (actionExists && newActionBlock.isEmpty()) {
				// Modify prefix and suffix to delete existing brackets for removing action block
				setPrefix(getPrefix().substring(0, getPrefix().length() - 1));
				setSuffix(getSuffix().substring(1));
			}
		}

		super.setEditableText(newActionBlock);
	};

	/**
	 * Creates an {@link EditableEmbeddedTextValue} that allows editing of the embedded AADL source for the {@link BehaviorActionBlock}
	 * @param behaviorTransition the Behavior Transition that owns the Behavior Action Block
	 * @return an {@link EditableEmbeddedTextValue} for the {@link BehaviorActionBlock}
	 */
	public static EditableEmbeddedTextValue create(final BehaviorTransition behaviorTransition) {
		final String sourceText = BehaviorAnnexXtextUtil.getText(behaviorTransition);
		final BehaviorActionBlock actionBlock = behaviorTransition.getActionBlock();

		// Text before action block
		final String prefix;
		// Action block text
		final String actionText;
		// Text after action block
		final String suffix;
		if (actionBlock == null) {
			// Transition offset
			final int transitionOffset = behaviorTransition.getAadlBaLocationReference().getOffset();
			final String transitionText = sourceText.substring(transitionOffset);
			// Find transition terminating semicolon offset
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedTerminationChar(transitionText, ';')
					+ transitionOffset;

			// Transition action prefix and add open bracket for action
			prefix = sourceText.substring(0, terminationOffset) + "{";
			// Empty action text
			actionText = "";
			// Add bracket to close action text
			suffix = "}" + sourceText.substring(terminationOffset);
		} else {
			// Action offset
			final int updateOffset = actionBlock.getAadlBaLocationReference().getOffset() + 1;
			prefix = sourceText.substring(0, updateOffset);

			// Note: Condition length only counts until the first space (assuming).
			// For example, when dispatch condition is "on dispatch" length is 2.
			// Find closing "]", to get condition text
			final String afterTransitionText = sourceText.substring(updateOffset);
			// Find action ending offset
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedTerminationChar(afterTransitionText,
					'}') + updateOffset;

			// Get formatted action block text
			final AadlBaUnparser baUnparser = new AadlBaUnparser();
			// Throw exception if first and last char is not a bracket
			// to know when formatter has changed
			final String formattedActionBlock = baUnparser.process(actionBlock);
			final int lastIndex = formattedActionBlock.length() - 1;
			if (!Objects.equals('{', formattedActionBlock.charAt(0))
					|| !Objects.equals('}', formattedActionBlock.charAt(lastIndex))) {
				throw new AadlGraphicalEditorException(
						"Unexpected action block format '" + formattedActionBlock + "'.");
			}

			// Split action at new line character and throw out action block brackets
			final List<String> actionBlockText = getInnerActionBlockText(formattedActionBlock.split("\n"));

			// Get whitespace to trim from each line after removing opening bracket
			final int whitespace = getWhiteSpace(actionBlockText.get(0));
			actionText = String
					.join("", actionBlockText.stream().map(ss -> ss.substring(whitespace)).toArray(String[]::new))
					.trim();

			suffix = sourceText.substring(terminationOffset);
		}

		// Create the value
		return new BehaviorActionBlockEmbeddedTextValue(behaviorTransition, sourceText.length(), prefix, actionText,
				suffix);
	}

	private static int getWhiteSpace(final String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i))) {
				return i;
			}
		}

		return 0;
	}

	private static List<String> getInnerActionBlockText(final String[] splitActionBlockText) {
		return Arrays.asList(splitActionBlockText).subList(1, splitActionBlockText.length - 1);
	}
}
