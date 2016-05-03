package org.osate.ge.internal.graphics;

import java.util.Objects;

import org.osate.ge.ConnectionTerminator;

public class FreeFormConnection implements AgeConnection {
	private final ConnectionStyle connectionStyle;
	private final ConnectionTerminator srcTerminator;
	private final ConnectionTerminator dstTerminator;
	
	public FreeFormConnection(final ConnectionStyle connectionStyle, final ConnectionTerminator srcTerminator, final ConnectionTerminator dstTerminator) {
		this.connectionStyle = Objects.requireNonNull(connectionStyle, "connectionStyle must not be null");
		this.srcTerminator = srcTerminator;
		this.dstTerminator = dstTerminator;
	}
	
	@Override
	public ConnectionStyle getConnectionStyle() {
		return connectionStyle;
	}
	
	@Override
	public ConnectionTerminator getSourceTerminator() {
		return srcTerminator;
	}
	
	@Override
	public ConnectionTerminator getDestinationTerminator() {
		return dstTerminator;
	}
}
