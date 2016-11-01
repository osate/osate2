package org.osate.ge.internal.graphics;

import java.util.Objects;

public class FreeFormConnection implements AgeConnection {
	private final LineStyle connectionStyle;
	private final AgeConnectionTerminator srcTerminator;
	private final AgeConnectionTerminator dstTerminator;
	
	public FreeFormConnection(final LineStyle connectionStyle, final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator) {
		this.connectionStyle = Objects.requireNonNull(connectionStyle, "connectionStyle must not be null");
		this.srcTerminator = srcTerminator;
		this.dstTerminator = dstTerminator;
	}
	
	@Override
	public LineStyle getLineStyle() {
		return connectionStyle;
	}
	
	@Override
	public AgeConnectionTerminator getSourceTerminator() {
		return srcTerminator;
	}
	
	@Override
	public AgeConnectionTerminator getDestinationTerminator() {
		return dstTerminator;
	}
}
