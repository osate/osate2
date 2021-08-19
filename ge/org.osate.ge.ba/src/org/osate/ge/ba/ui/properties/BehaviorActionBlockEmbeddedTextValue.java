package org.osate.ge.ba.ui.properties;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorTransition;

/**
 * @since 2.0
 */
public class BehaviorActionBlockEmbeddedTextValue extends EmbeddedTextValue {
	private final BehaviorTransition behaviorTransition;

	/**
	 * Creates an {@link EmbeddedTextValue} for {@link BehaviorActionBlock} and editing support within an {@link EmbeddedTextEditor}
	 * @param behaviorTransition the owner of the {@link BehaviorActionBlock} being edited
	 * @param originalSrcLength is the length of the original AADL source text
	 * @param prefix is the text before the modifiable text
	 * @param editableText is the text that is modifiable
	 * @param suffix is the text after the modifiable text
	 */
	public BehaviorActionBlockEmbeddedTextValue(final BehaviorTransition behaviorTransition,
			final int originalSrcLength, final String prefix, final String editableText, final String suffix) {
		super(originalSrcLength, prefix, editableText, suffix);
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
		if (newActionBlock.isEmpty()) {
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
}
