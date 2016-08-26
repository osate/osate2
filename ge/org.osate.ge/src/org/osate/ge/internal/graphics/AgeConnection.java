package org.osate.ge.internal.graphics;

import org.osate.ge.graphics.Graphic;

/**
 * Marker for graphics which will be used to represent connections. Not public API.
 */
public interface AgeConnection extends Graphic {
	ConnectionStyle getConnectionStyle();
	AgeConnectionTerminator getSourceTerminator();
	AgeConnectionTerminator getDestinationTerminator();
}
