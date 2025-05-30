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

import java.util.Objects;

/**
 * AADL feature graphic
 *
 */
public class FeatureGraphic implements AgeShape {
	/**
	 * The direction of the feature
	 */
	public final Direction direction;

	/**
	 * The type of feature graphic
	 */
	public final FeatureGraphicType featureType;

	/**
	 * Creates a new instance with the specified direction and type
	 * @param direction the value for the {@link #direction} field
	 * @param featureType the value for the {@link #featureType} field
	 */
	public FeatureGraphic(final Direction direction, final FeatureGraphicType featureType) {
		this.direction = Objects.requireNonNull(direction, "direction must not be null");
		this.featureType = Objects.requireNonNull(featureType, "featureType must not be null");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((featureType == null) ? 0 : featureType.hashCode());
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
		FeatureGraphic other = (FeatureGraphic) obj;
		if (direction != other.direction) {
			return false;
		}
		if (featureType != other.featureType) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isResizeable() {
		return featureType == FeatureGraphicType.FEATURE_GROUP;
	}
}
