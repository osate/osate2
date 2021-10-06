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
package org.osate.ge.graphics;

//
/**
 * Immutable data type for RGB color.
 * The values of individual components are in range [0-255].
 */
public final class Color {
	private static final double COLOR_SCALING = 0.7; // Used for scaling colors with darker() and brighter()
	private static final double MIN_BRIGHTER_COLOR = 3.0;

	/**
	 * The color black
	 */
	public static final Color BLACK = new Color(0, 0, 0);

	/**
	 * The color white
	 */
	public static final Color WHITE = new Color(255, 255, 255);

	/**
	 * The color blue
	 */
	public static final Color BLUE = new Color(0, 0, 255);

	/**
	 * The color green
	 */
	public static final Color GREEN = new Color(0, 255, 0);

	/**
	 * The color cyan
	 */
	public static final Color CYAN = new Color(0, 255, 255);

	/**
	 * The color magenta
	 */
	public static final Color MAGENTA = new Color(255, 0, 255);

	/**
	 * The color orange
	 */
	public static final Color ORANGE = new Color(255, 128, 0);

	/**
	 * The color purple
	 */
	public static final Color PURPLE = new Color(128, 0, 128);

	/**
	 * The color dark orange
	 */
	public static final Color DARK_ORANGE = new Color(255, 140, 0);

	private final int r;
	private final int g;
	private final int b;

	/**
	 * Creates a new instance. The value of each component should be within the range [0, 255]
	 * @param red the value of the red component
	 * @param green the value of the green component
	 * @param blue the value of the blue component
	 */
	public Color(final int red, final int green, final int blue) {
		this.r = red;
		this.g = green;
		this.b = blue;
	}

	/**
	 * Returns the red component.
	 * @return the red component
	 */
	public final int getRed() {
		return r;
	}

	/**
	 * Returns the green component.
	 * @return the green component
	 */
	public final int getGreen() {
		return g;
	}

	/**
	 * Returns the blue component.
	 * @return the blue component
	 */
	public final int getBlue() {
		return b;
	}

	/**
	 * Returns a darker version of this color.
	 * @return a darker version of this color
	 */
	public final Color darker() {
		return new Color((int) (r * COLOR_SCALING), (int) (g * COLOR_SCALING), (int) (b * COLOR_SCALING));
	}

	/**
	 * Returns a brighter version of this color.
	 * @return a brighter version of this color
	 */
	public final Color brighter() {
		return new Color((int) Math.max(Math.min(r / COLOR_SCALING, 255.0), MIN_BRIGHTER_COLOR),
				(int) Math.max(Math.min(g / COLOR_SCALING, 255.0), MIN_BRIGHTER_COLOR),
				(int) Math.max(Math.min(b / COLOR_SCALING, 255.0), MIN_BRIGHTER_COLOR));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + g;
		long temp;
		temp = Double.doubleToLongBits(MIN_BRIGHTER_COLOR);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + r;
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
		Color other = (Color) obj;
		if (b != other.b) {
			return false;
		}
		if (g != other.g) {
			return false;
		}
		if (Double.doubleToLongBits(MIN_BRIGHTER_COLOR) != Double.doubleToLongBits(Color.MIN_BRIGHTER_COLOR)) {
			return false;
		}
		return r == other.r;
	}
}
