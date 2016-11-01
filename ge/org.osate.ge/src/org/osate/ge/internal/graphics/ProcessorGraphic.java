package org.osate.ge.internal.graphics;

public class ProcessorGraphic implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public ProcessorGraphic(final int lineWidth, final LineStyle lineStyle) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}
}
