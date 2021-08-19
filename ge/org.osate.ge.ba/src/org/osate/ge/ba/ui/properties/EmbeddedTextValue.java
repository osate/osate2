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

import java.util.Objects;

/**
 * Text information for editing embedded models
 */
public abstract class EmbeddedTextValue implements EmbeddedTextValueModificationModel {
	private final int originalTextLength;
	private String prefix;
	private String editableText;
	private String suffix;

	/**
	 * Text information for editing embedded models.
	 * @param originalTextLength is the length of the original source text
	 * @param prefix is the text before the modifiable text
	 * @param editableText is the text that is modifiable
	 * @param suffix is the text after the modifiable text
	 * @since 2.0
	 */
	public EmbeddedTextValue(final int originalTextLength, final String prefix, final String editableText,
			final String suffix) {
		this.originalTextLength = originalTextLength;
		this.prefix = Objects.requireNonNull(prefix, "prefix must not be null");
		this.editableText = Objects.requireNonNull(editableText, "editableText must not be null");
		this.suffix = Objects.requireNonNull(suffix, "suffix must not be null");
	}

	/**
	 * The length of the text that will be replaced when updated
	 * @return the length of the text that will be replaced when updated
	 */
	public int getUpdateLength() {
		return Math.max(0, originalTextLength - prefix.length() - suffix.length());
	}

	/**
	 * The text that is edited to modify embedded text
	 * @return is the text that is edited to modify embedded text
	 * @since 2.0
	 */
	public String getEditableText() {
		return editableText;
	}

	/**
	 * The prefix of the editable text
	 * @return the text before the editable text
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * The suffix of the editable text
	 * @return the text after the editable text
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Sets the prefix to the editable text
	 * @param prefix is the new prefix to the editable text
	 * @since 2.0
	 */
	public void setPrefix(final String prefix) {
		this.prefix = Objects.requireNonNull(prefix, "prefix must not be null");
	}

	/**
	 * Sets the suffix to the editable text
	 * @param suffix is the new suffix to the editable text
	 * @since 2.0
	 */
	public void setSuffix(final String suffix) {
		this.suffix = Objects.requireNonNull(suffix, "suffix must not be null");
	}

	/**
	 * Sets the editable text used to edit embedded text
	 * @param editableText the new editable text
	 * @since 2.0
	 */
	public void setEditableText(final String editableText) {
		this.editableText = editableText;
	}
}
