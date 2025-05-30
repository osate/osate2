/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Business object for note annotations
 *
 */
public class Note implements EmbeddedBusinessObject {
	private final UUID id;
	private final String text;

	/**
	 * Creates a new instance with blank text
	 * @param id a unique identifier in the scope of a diagram
	 */
	public Note(UUID id) {
		this(id, "");
	}

	/**
	 * Creates a new instance
	 * @param id a unique identifier in the scope of a diagram
	 * @param text the note's text
	 */
	public Note(UUID id, final String text) {
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.text = Objects.requireNonNull(text, "text must not be null");
	}

	/**
	 * Returns the note's unique identifier. This ID should be unique in the scope of a diagram.
	 * @return the note's unique identifier.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Returns the note's text. The text is user specified text which is displayed on the diagram.
	 * @return the note's text.
	 */
	public String getText() {
		return text;
	}

	@Override
	public Note copy() {
		return new Note(UUID.randomUUID(), text);
	}

	@Override
	public String getData() {
		return getText();
	}
}
