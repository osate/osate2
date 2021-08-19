package org.osate.ge.ba.businessobjecthandlers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Pair;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.unparser.AadlBaUnparser;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.ba.ui.properties.EmbeddedTextValue;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;

/**
 * Utility class to create an {@link EmbeddedTextValue} and get text for the {@link BehaviorCondition} of a specified {@link BehaviorTransition}
 */
public class BehaviorTransitionTextUtil {
	private BehaviorTransitionTextUtil() {
	}

	/**
	 * Returns an {@link EmbeddedTextValue} for the {@link BehaviorCondition}
	 */
	public static EmbeddedTextValue createConditionTextValue(final BehaviorTransition behaviorTransition,
			final String sourceText) {
		final int conditionOffset = getConditionOffset(behaviorTransition, sourceText);
		// Condition start
		final String afterPrefix = getAfterPrefix(sourceText, conditionOffset);

		// Text before condition text
		final String prefix = sourceText.substring(0, conditionOffset);
		final int conditionEnd = getConditionEnd(afterPrefix);

		// Text after condition
		final String suffix = afterPrefix.substring(conditionEnd);
		final String conditionText = afterPrefix.substring(0, conditionEnd).trim();
		return new EmbeddedTextValue(sourceText.length(), prefix, conditionText, suffix) {
			@Override
			public String getEditDialogTitle() {
				return "Edit Transition Condition";
			}

			@Override
			public String getEditDialogMessage() {
				return "Enter new dispatch condition.";
			}

			@Override
			public String getModificationLabel() {
				return "Modify Behavior Transition Condition";
			}

			@Override
			public NamedElement getElementToModify() {
				return behaviorTransition;
			}

			@Override
			public boolean isValidModification(final EObject bo, final String newText) {
				if (bo instanceof BehaviorTransition) {
					final BehaviorCondition condition = ((BehaviorTransition) bo).getCondition();
					// Calculate enabled based on if condition should exist and if it exists
					return newText.isEmpty() ? condition == null : condition != null;
				}

				return false;
			}
		};
	}

	/**
	 * Returns the text of the {@link BehaviorCondition}
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

	/**
	 * Returns an {@link EmbeddedTextValue} for the {@link BehaviorActionBlock}
	 */
	public static EmbeddedTextValue getActionBlockTextValue(final BehaviorTransition behaviorTransition,
			final String src) {
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
			final String transitionText = src.substring(transitionOffset);
			// Find transition terminating semicolon offset
			final int terminationOffset = BehaviorAnnexXtextUtil.findUncommentedTerminationChar(transitionText, ';')
					+ transitionOffset;

			// Transition action prefix and add open bracket for action
			prefix = src.substring(0, terminationOffset) + "{";
			// Empty condition text
			actionText = "";
			// Add bracket to close action text
			suffix = "}" + src.substring(terminationOffset);
		} else {
			// Condition offset
			final int updateOffset = actionBlock.getAadlBaLocationReference().getOffset() + 1;
			prefix = src.substring(0, updateOffset);

			// Note: Condition length only counts until the first space (assuming).
			// For example, when dispatch condition is "on dispatch" length is 2.
			// Find closing "]", to get condition text
			final String afterTransitionText = src.substring(updateOffset);
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

			suffix = src.substring(terminationOffset);
		}

		// Create condition value
		return new EmbeddedTextValue(src.length(), prefix, actionText, suffix) {
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
			public Optional<String> getModifiedAADLSourceForNewEditableText(
					final String newActionBlock) {
				if (newActionBlock.isEmpty()) {
					// Remove brackets for empty action block
					final String prefix = getPrefix();
					return Optional.of(new StringBuilder(prefix.substring(0, prefix.length() - 1))
							.append(getSuffix().substring(1))
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
					// Add brackets for creating new action block
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
		};
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
