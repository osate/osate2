package org.osate.ge.internal.graphics;

public class BusGraphic implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public BusGraphic(final int lineWidth, final LineStyle lineStyle) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}
}
