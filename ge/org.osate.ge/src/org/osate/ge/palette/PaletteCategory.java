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
package org.osate.ge.palette;

import java.util.Objects;

/**
 * Describes a palette category. Categories are used the group palette commands. Categories are represented as folders in the user interface.
 * @since 2.0
 */
public class PaletteCategory {
	private String id;
	private String label;

	/**
	 * Create a new instance
	 * @param id the ID of the palette category
	 * @param label the label of the palette category to be shown in the user interface.
	 */
	public PaletteCategory(final String id, final String label) {
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.label = Objects.requireNonNull(label, "label must not be null");
	}

	/**
	 * Returns the palette category's ID
	 * @return the category's ID
	 */
	public final String getId() {
		return id;
	}

	/**
	 * Returns the palette category's label. The label is the text shown in the user interface.
	 * @return the category's label
	 */
	public final String getLabel() {
		return label;
	}
}