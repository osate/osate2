package org.osate.ge.internal.graphics;

public class ModeGraphic implements AgeShape {
	public final boolean isInitialMode;
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public ModeGraphic(final boolean isInitialMode, final int lineWidth, final LineStyle lineStyle) {
		this.isInitialMode = isInitialMode;
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}
}
