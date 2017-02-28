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
	public final boolean isFlowIndicator;
	
	private AgeConnection(final LineStyle lineStyle, final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator, final boolean isCurved, final boolean isFlowIndicator) {
		this.lineStyle = Objects.requireNonNull(lineStyle, "lineStyle must not be null");
		this.srcTerminator = srcTerminator;
		this.dstTerminator = dstTerminator;
		this.isCurved = isCurved;
		this.isFlowIndicator = isFlowIndicator;
	}
	
	/**
	 * Create a connection which is not a flow indicator.
	 * @param lineStyle
	 * @param srcTerminator
	 * @param dstTerminator
	 * @param isCurved
	 * @return
	 */
	public static AgeConnection createNormal(final LineStyle lineStyle, final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator, final boolean isCurved) {
		return new AgeConnection(lineStyle, srcTerminator, dstTerminator, isCurved, false);
	}
	
	public static AgeConnection createFlowIndicator(final LineStyle lineStyle, final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator) {
		return new AgeConnection(lineStyle, srcTerminator, dstTerminator, false, true);
	}
}
