package org.osate.ge.graphics.internal;

import java.util.Objects;

import org.osate.ge.graphics.ConnectionTerminator;

public class AgeConnectionTerminator implements ConnectionTerminator {
	public final ConnectionTerminatorType type;
	public final ConnectionTerminatorSize size;
	public final boolean reversed;
	
	public AgeConnectionTerminator(final ConnectionTerminatorType type, final ConnectionTerminatorSize size, final boolean reversed) {
		this.type = Objects.requireNonNull(type, "type must not be null");
		this.size = Objects.requireNonNull(size, "size must not be null");
		this.reversed = reversed;
	}
}
