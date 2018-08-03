package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.ConnectionTerminator;
import org.osate.ge.graphics.Graphic;

public class FlowIndicatorBuilder {
	private AgeConnectionTerminator srcTerminator = null;
	private AgeConnectionTerminator dstTerminator = null;

	private FlowIndicatorBuilder() {}

	/**
	 * Creates a flow indicator builder.
	 * @return a flow indicator builder
	 */
	public static FlowIndicatorBuilder create() {
		return new FlowIndicatorBuilder();
	}

	/**
	 * Configures the flow indicator builder to create an indicator with the specified terminator at the source end of the indicator.
	 * @param value the source terminator to use when creating the indicator
	 * @return this builder to allow method chaining.
	 */
	public FlowIndicatorBuilder sourceTerminator(final ConnectionTerminator value) {
		this.srcTerminator = (AgeConnectionTerminator)value;
		return this;
	}

	/**
	 * Configures the flow indicator builder to create an indicator with the specified terminator at the destination end of the indicator.
	 * @param value the destination terminator to use when creating the connection
	 * @return this builder to allow method chaining.
	 */
	public FlowIndicatorBuilder destinationTerminator(final ConnectionTerminator value) {
		this.dstTerminator = (AgeConnectionTerminator)value;
		return this;
	}

	/**
	 * Creates a flow indicator based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return AgeConnection.createFlowIndicator(srcTerminator, dstTerminator);
	}
}
