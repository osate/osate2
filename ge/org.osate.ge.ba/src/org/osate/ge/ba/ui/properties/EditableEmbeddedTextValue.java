/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
 * Text and modification information for editing embedded AADL source
 * @since 2.0
 */
public abstract class EditableEmbeddedTextValue {
	private final IProject project;
	private final int originalSrcLength;
	private String prefix;
	private String editableText;
	private String suffix;

	/**
	 * Text information for editing embedded AADL models.
	 * @param project the project that contains AADL resource being edited
	 * @param originalSrcLength is the length of the AADL source before being edited.
	 * Note: The {@link #originalSrcLength} may not be the same length as {@link #prefix}, {@link #editableText}, and {@link #suffix} combined
	 * because although these values are derived from the original AADL source, they may be modified to support embedded editing.
	 * @param prefix is the text before the editable text
	 * @param editableText is the text that is editable
	 * @param suffix is the text after the editable text
	 * @since 2.0
	 */
	protected EditableEmbeddedTextValue(final IProject project, final int originalSrcLength, final String prefix,
			final String editableText,
			final String suffix) {
		this.project = project;
		this.originalSrcLength = originalSrcLength;
		this.prefix = Objects.requireNonNull(prefix, "prefix must not be null");
		this.editableText = Objects.requireNonNull(editableText, "editableText must not be null");
		this.suffix = Objects.requireNonNull(suffix, "suffix must not be null");
	}

	/**
	 * Retrieve the {@link IProject} that contains AADL resource being edited
	 * @return the project that contains the AADL resource being edited
	 */
	public final IProject getProject() {
		return project;
	}

	/**
	 * Returns the length of the text that will be replaced when updated
	 * @return the length of the text that will be replaced when updated
	 */
	public final int getUpdateLength() {
		return Math.max(0, originalSrcLength - prefix.length() - suffix.length());
	}

	/**
	 * Returns the embedded text that is editable
	 * @return the embedded text that is editable
	 * @since 2.0
	 */
	public final String getEditableText() {
		return editableText;
	}

	/**
	 * Returns the prefix of the editable text
	 * @return the prefix of the editable text
	 */
	public final String getPrefix() {
		return prefix;
	}

	/**
	 * Returns the suffix of the editable text
	 * @return the suffix of the editable text
	 */
	public final String getSuffix() {
		return suffix;
	}

	/**
	 * Sets the prefix to the editable text
	 * @param prefix is the new prefix to the editable text
	 * @since 2.0
	 */
	protected void setPrefix(final String prefix) {
		this.prefix = Objects.requireNonNull(prefix, "prefix must not be null");
	}

	/**
	 * Sets the suffix to the editable text
	 * @param suffix is the new suffix to the editable text
	 * @since 2.0
	 */
	protected void setSuffix(final String suffix) {
		this.suffix = Objects.requireNonNull(suffix, "suffix must not be null");
	}

	/**
	 * Sets the editable text used to edit embedded text
	 * @param editableText the new editable text
	 * @since 2.0
	 */
	public void setEditableText(final String editableText) {
		this.editableText = Objects.requireNonNull(editableText, "editableText must not be null");
	}

	/**
	 * The title of the dialog used to edit an {@link EditableEmbeddedTextValue}
	 * @return the title of the dialog for editing embedded text
	 */
	public abstract String getEditDialogTitle();

	/**
	 * The message of the dialog used to edit an {@link EditableEmbeddedTextValue}
	 * @return the message of the dialog for editing embedded text
	 */
	public abstract String getEditDialogMessage();

	/**
	 * The label for the modification when an {@link EditableEmbeddedTextValue} is executed
	 * @return the message
	 */
	public abstract String getModificationLabel();

	/**
	 * Determines if the new text is a valid replacement for the editable text of an {@link EditableEmbeddedTextValue} for the AADL model
	 * @param bo the business object being modified
	 * @param newText the text to replace editable text in an {@link EditableEmbeddedTextValue}
	 * @return whether the new text is valid replacement
	 */
	public abstract boolean isValidModification(final EObject bo, final String newText);

	/**
	 * @return the {@link NamedElement} being modified
	 */
	public abstract NamedElement getElementToModify();

	/**
	 * Overrides the new source for the AADL resource based on the new text.
	 * @param newText the text entered by the user.
	 * @return the new source for the AADL resource. If an empty value is returned, the source of the AADL resource used
	 * by the embedded editor will be used.
	 */
	public Optional<String> getModifiedAADLSourceForNewText(final String newText) {
		return Optional.empty();
	}
}
