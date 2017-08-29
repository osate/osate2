package org.osate.ge.internal.graphics;

import org.osate.ge.graphics.Graphic;

/**
 * Graphic which will be used to represent connections. Not public API.
 */
public class AgeConnection implements Graphic {
	public final AgeConnectionTerminator srcTerminator;
	public final AgeConnectionTerminator dstTerminator;
	public final boolean isCurved;
	public final boolean isFlowIndicator;

	private AgeConnection(final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator,
			final boolean isCurved, final boolean isFlowIndicator) {
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
	public static AgeConnection createNormal(final AgeConnectionTerminator srcTerminator,
			final AgeConnectionTerminator dstTerminator, final boolean isCurved) {
		return new AgeConnection(srcTerminator, dstTerminator, isCurved, false);
	}

	public static AgeConnection createFlowIndicator(final AgeConnectionTerminator srcTerminator,
			final AgeConnectionTerminator dstTerminator) {
		return new AgeConnection(srcTerminator, dstTerminator, false, true);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dstTerminator == null) ? 0 : dstTerminator.hashCode());
		result = prime * result + (isCurved ? 1231 : 1237);
		result = prime * result + (isFlowIndicator ? 1231 : 1237);
		result = prime * result + ((srcTerminator == null) ? 0 : srcTerminator.hashCode());
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
		AgeConnection other = (AgeConnection) obj;
		if (dstTerminator == null) {
			if (other.dstTerminator != null) {
				return false;
			}
		} else if (!dstTerminator.equals(other.dstTerminator)) {
			return false;
		}
		if (isCurved != other.isCurved) {
			return false;
		}
		if (isFlowIndicator != other.isFlowIndicator) {
			return false;
		}
		if (srcTerminator == null) {
			if (other.srcTerminator != null) {
				return false;
			}
		} else if (!srcTerminator.equals(other.srcTerminator)) {
			return false;
		}
		return true;
	}
}
