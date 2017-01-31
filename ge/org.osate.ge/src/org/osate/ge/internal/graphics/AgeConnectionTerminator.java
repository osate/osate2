package org.osate.ge.internal.graphics;

import java.util.Objects;

import org.osate.ge.graphics.ConnectionTerminator;

public class AgeConnectionTerminator implements ConnectionTerminator {
	public final ConnectionTerminatorType type;
	public final ConnectionTerminatorSize size;
	
	public AgeConnectionTerminator(final ConnectionTerminatorType type, final ConnectionTerminatorSize size) {
		this.type = Objects.requireNonNull(type, "type must not be null");
		this.size = Objects.requireNonNull(size, "size must not be null");
	}
}
