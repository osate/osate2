package org.osate.ge.ba.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;

/**
 * EmbeddedTextValue and editing support for {@link BehaviorCondition}.
 * @since 2.0
 */
public class BehaviorConditionEmbeddedTextValue extends EmbeddedTextValue {
	private final BehaviorTransition behaviorTransition;

	/**
	 * Creates an {@link EmbeddedTextValue} for {@link BehaviorCondition} and editing support within an {@link EmbeddedTextEditor}
	 * @param behaviorTransition the owner of the {@link BehaviorCondition} being edited
	 * @param originalSrcLength is the length of the original AADL source text
	 * @param prefix is the text before the modifiable text
	 * @param editableText is the text that is modifiable
	 * @param suffix is the text after the modifiable text
	 */
	public BehaviorConditionEmbeddedTextValue(final BehaviorTransition behaviorTransition, final int originalSrcLength,
			final String prefix, final String editableText, final String suffix) {
		super(originalSrcLength, prefix, editableText, suffix);
		this.behaviorTransition = behaviorTransition;
	}

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
}
