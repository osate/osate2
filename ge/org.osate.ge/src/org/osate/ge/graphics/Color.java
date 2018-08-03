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
