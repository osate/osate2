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
package org.osate.ge.gef;

import javafx.geometry.Dimension2D;
import javafx.scene.paint.Color;

/**
 * Extension of {@link PolygonNode} which is intended to be used as a connection end decoration.
 * The does not apply the style's stroke dash array. Additionally, it contains an optional parameter to control whether the
 * polygon is filled. If it is not filled, then it has a white background. Otherwise the background will match the style's
 * outline color. The background is not transparent because if it is, the connection is visible behind it.
 */
public class PolygonConnectionDecoration extends PolygonNode {
	private final boolean filled;

	/**
	 * Create a new instance
	 * @param filled indicates how the polygon is filled. If true, the polygon is filled with the outline color. Otherwise, it is filled with white.
	 * @param fixedSize may be null. If non-null, then the minimum, preferred, and max size will match this value.
	 * @param points the points for the polygon. Series of x, y coordinates.
	 * Must contain an even number of values be within the range of [0.0, 1.0] Will be scaled based on the size of the node.
	 */
	public PolygonConnectionDecoration(final boolean filled, final Dimension2D fixedSize, final double... points) {
		super(fixedSize, points);
		this.filled = filled;
	}

	@Override
	public void apply(final FxStyle style) {
		poly.setFill(filled ? style.getOutlineColor() : Color.WHITE); // Outline color is used as the fill color for this node
		poly.setStroke(style.getOutlineColor());
		poly.setStrokeWidth(style.getLineWidth());
	}
}
