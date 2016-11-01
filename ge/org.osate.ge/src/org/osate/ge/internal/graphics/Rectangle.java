package org.osate.ge.internal.graphics;

public class Rectangle implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	public final boolean rounded;
	
	public Rectangle(final int lineWidth, final LineStyle lineStyle, final boolean rounded) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.rounded = rounded;
	}
}
