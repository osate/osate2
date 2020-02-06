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

// Components are in range 0-255
public class Color {
	private final static double colorScaling = 0.7; // Used for scaling colors with darker() and brighter()
	private final double minBrighterColor = 3.0;

	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color BLUE = new Color(0, 0, 255);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color CYAN = new Color(0, 255, 255);
	public static final Color MAGENTA = new Color(255, 0, 255);
	public static final Color ORANGE = new Color(255, 128, 0);
	public static final Color PURPLE = new Color(128, 0, 128);
	public static final Color DARK_ORANGE = new Color(255, 140, 0);

	private final int red;
	private final int green;
	private final int blue;

	public Color(final int red, final int green, final int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public final int getRed() {
		return red;
	}

	public final int getGreen() {
		return green;
	}

	public final int getBlue() {
		return blue;
	}

	public final Color darker() {
		return new Color((int) (red * colorScaling), (int) (green * colorScaling), (int) (blue * colorScaling));
	}

	public final Color brighter() {
		return new Color((int) Math.max(Math.min(red / colorScaling, 255.0), minBrighterColor),
				(int) Math.max(Math.min(green / colorScaling, 255.0), minBrighterColor),
				(int) Math.max(Math.min(blue / colorScaling, 255.0), minBrighterColor));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + green;
		long temp;
		temp = Double.doubleToLongBits(minBrighterColor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + red;
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
		if (blue != other.blue) {
			return false;
		}
		if (green != other.green) {
			return false;
		}
		if (Double.doubleToLongBits(minBrighterColor) != Double.doubleToLongBits(other.minBrighterColor)) {
			return false;
		}
		if (red != other.red) {
			return false;
		}
		return true;
	}

}
