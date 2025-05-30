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
package org.osate.ge.graphics.internal;

import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;

/**
 * AADL mode graphic
 *
 */
public class ModeGraphic implements AgeShape {
	/**
	 * The diameter of the ellipse used as part of the initial mode indicator
	 */
	private final static int INITIAL_MODE_CIRCLE_SIZE = 10;

	/**
	 * The vertical spacing between the circle used in the initial mode indicator and the mode shape.
	 */
	private final static int SPACING_BETWEEN_INITIAL_MODE_ELLIPSE_AND_MODE = 10;

	/**
	 * The height of the area consumed by the initial mode indicator. This value is not used by the actual mode graphic implementation.
	 * This is part of a workaround to ensure adequate minimum height for initial modes. This should be removed and {@link LayoutInfoProvider}
	 * should be expanded to allow the minimum height adjustment.
	 */
	public final static int INITIAL_MODE_AREA_HEIGHT = INITIAL_MODE_CIRCLE_SIZE
			+ SPACING_BETWEEN_INITIAL_MODE_ELLIPSE_AND_MODE;

	/**
	 * Whether the graphic should include the initial mode indicator
	 */
	public final boolean isInitialMode;

	/**
	 * Creates a new instance
	 * @param isInitialMode whether the mode graphic should include the initial mode indicator
	 */
	public ModeGraphic(final boolean isInitialMode) {
		this.isInitialMode = isInitialMode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isInitialMode ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ModeGraphic other = (ModeGraphic) obj;
		if (isInitialMode != other.isInitialMode) {
			return false;
		}
		return true;
	}
}
