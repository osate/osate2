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
 * Text information for editing embedded models
 */
public class EmbeddedTextValue {
	private final String wholeText;
	private final String prefix;
	private final int offset;
	private final String editableText;
	private final int updateLength;

	public EmbeddedTextValue(final String orignalText, final String prefix, final String editableText, final String suffix) {
		this.prefix = prefix;
		this.editableText = editableText;
		final String prefixWithLineEnding = prefix + "\n";
		wholeText = prefixWithLineEnding + editableText + "\n" + suffix;
		// Offset to show text within embedded styled text
		offset = prefixWithLineEnding.length();
		// Length of text to replace
		updateLength = orignalText.length() - prefix.length() - suffix.length();
	}

	public int getUpdateLength() {
		return updateLength;
	}

	public String getEditableText() {
		return editableText;
	}

	public int getEditableTextOffset() {
		return offset;
	}

	public String getWholeText() {
		return wholeText;
	}

	public String getPrefix() {
		return prefix;
	}
}
