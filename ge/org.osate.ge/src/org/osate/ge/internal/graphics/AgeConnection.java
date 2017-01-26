package org.osate.ge.internal.graphics;

import java.util.Objects;

import org.osate.ge.graphics.Graphic;

/**
 * Graphic which will be used to represent connections. Not public API.
 */
public class AgeConnection implements Graphic {
	public final LineStyle lineStyle;
	public final AgeConnectionTerminator srcTerminator;
	public final AgeConnectionTerminator dstTerminator;
	public final boolean isCurved;
	
	public AgeConnection(final LineStyle lineStyle, final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator, final boolean isCurved) {
		this.lineStyle = Objects.requireNonNull(lineStyle, "lineStyle must not be null");
		this.srcTerminator = srcTerminator;
		this.dstTerminator = dstTerminator;
		this.isCurved = isCurved;
	}
}
