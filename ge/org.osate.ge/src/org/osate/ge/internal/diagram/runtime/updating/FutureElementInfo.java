package org.osate.ge.internal.diagram.runtime.updating;

import org.osate.ge.graphics.Point;

// Holds information regarding diagram elements which have not been created.
public class FutureElementInfo {
	public final boolean manual; // Initial value of the manual flag

	// The position may be null to indicate that an element should be added as a manually added element but that a position hasn't been specified.
	public final Point position;

	public FutureElementInfo(final boolean manual) {
		this(manual, null);
	}

	public FutureElementInfo(final boolean manual, final Point position) {
		this.manual = manual;
		this.position = position;
	}
}
