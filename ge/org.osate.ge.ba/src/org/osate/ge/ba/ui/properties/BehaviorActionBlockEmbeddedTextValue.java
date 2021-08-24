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
package org.osate.ge.ba.ui.properties;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ba.ui.EmbeddedTextEditor;

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
	 * @param originalSrcLength is the length of the original AADL source text
	 * @param prefix is the text before the modifiable text
	 * @param editableText is the text that is modifiable
	 * @param suffix is the text after the modifiable text
	 */
	public BehaviorActionBlockEmbeddedTextValue(final BehaviorTransition behaviorTransition,
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
