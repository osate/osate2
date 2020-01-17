/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.graphics;

import java.util.Objects;

import org.osate.ge.graphics.internal.Poly;
import org.osate.ge.graphics.internal.Poly.Type;

/**
 * Builder for creating polygon or polyline graphics. Builds polygon by default.
 * @noextend
 * @see Graphic
 */
public class PolyBuilder {
	private Point[] points;
	private Type type = Type.POLYGON;

	private PolyBuilder() {}

	/**
	 * Creates a poly builder.
	 * @return a poly builder
	 */
	public static PolyBuilder create() {
		return new PolyBuilder();
	}

	/**
	 * Configures the poly builder to build a poly composed of the specified points.
	 * @param points the points to use when creating the poly. All coordinates must be in the range of [0.0, 1.0]. Polylines are scaled by the editor.
	 * @return this builder to allow method chaining.
	 */
	public PolyBuilder points(final Point... points) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		return this;
	}

	/**
	 * Configures the poly builder to build a polygon
	 * @return this builder to allow method chaining.
	 */
	public PolyBuilder polygon() {
		this.type = Type.POLYGON;
		return this;
	}

	/**
	 * Configures the poly builder to build a polyline
	 * @return this builder to allow method chaining.
	 */
	public PolyBuilder polyline() {
		this.type = Type.POLYLINE;
		return this;
	}

	/**
	 * Creates a poly graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Poly(points, type);
	}
}
