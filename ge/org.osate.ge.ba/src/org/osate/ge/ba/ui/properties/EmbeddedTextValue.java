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

/**
 * Contains details regarding the source text being modified.
 */
public class EmbeddedTextValue {
	private final String prefix;
	private final String suffix;
	private final String editableText;
	private final String editableResourceText;
	private final int editableTextOffset;
	private int updateOffset;
	private int updateLength;

	/**
	 * Creates a new instance
	 * @param originalResourceText the contents of the resource being edited
	 * @param prefix the portion of the resource text that occurs before the text being edited
	 * @param editableText the text being edited. This is not required to be the same as the text between the prefix and the suffix.
	 * @param suffix the portion of the resource text that occurs after the element being modified.
	 */
	public EmbeddedTextValue(final String originalResourceText, final String prefix, final String editableText,
			final String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.editableText = editableText;
		final String prefixWithLineEnding = prefix + "\n";
		this.editableResourceText = prefixWithLineEnding + editableText + "\n" + suffix;
		// Offset to show text within embedded styled text
		this.editableTextOffset = prefixWithLineEnding.length();
		this.updateOffset = prefix.length();
		// Length of text to replace. Max is needed because the action block editor appends additional characters to prefix in the case that
		// the action block is empty.
		this.updateLength = Math.max(0, originalResourceText.length() - prefix.length() - suffix.length());
	}

	/**
	 * Returns the text to be edited.
	 * @return the text to be edited
	 */
	public String getEditableText() {
		return editableText;
	}

	/**
	 * The index of {@link #getEditableText()} within {@link #getEditableResourceText()}
	 * @return the location of the editable within the editable resource text.
	 */
	public int getEditableTextOffset() {
		return editableTextOffset;
	}

	/**
	 * The source of the resource being edited. This is the combination of the prefix, editableText, suffix specified in the constructor and
	 * additional line endings to ensure the text is suitable for editing. Lines breaks are needed between the editable text and other sections
	 * so that it can be properly shown in the source viewer.
	 * @return the text for a resource which is suitable for editing.
	 * @since 2.0
	 */
	public String getEditableResourceText() {
		return editableResourceText;
	}

	/**
	 * Returns the prefix specified during construction
	 * @return the prefix specified during construction
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Returns the suffix specified during construction
	 * @return the suffix specified during construction
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Returns the length of the region in the original resource text to be replaced with the new text.
	 * @return the length of the region in the original resource text to be replaced with the new text.
	 */
	public int getUpdateLength() {
		return updateLength;
	}

	/**
	 * Sets the length of the region in the original resource text to be replaced with the new text.
	 * @param updateLength the new length of the region of the resource text to be replaced.
	 */
	public void setUpdateLength(final int updateLength) {
		this.updateLength = updateLength;
	}

	/**
	 * Returns the location of the start of the region in the original resource text which will be replaced.
	 * @return the location of the start of the region in the original resource text which will be replaced.
	 */
	public int getUpdateOffset() {
		return updateOffset;
	}

	/**
	 * Sets the location of the start of the region in the original resource text which will be replaced.
	 * @param updateOffset the new location of the start of the region in the original resource text which will be replaced.
	 */
	public void setUpdateOffset(final int updateOffset) {
		this.updateOffset = updateOffset;
	}
}
