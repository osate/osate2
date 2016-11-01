package org.osate.ge.internal.graphics;

public class Parallelogram implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	public final int horizontalOffset;
	
	public Parallelogram(final int lineWidth, final LineStyle lineStyle, final int horizontalOffset) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.horizontalOffset = horizontalOffset;
	}
}
