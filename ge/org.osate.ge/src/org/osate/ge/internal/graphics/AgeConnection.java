package org.osate.ge.internal.graphics;

import org.osate.ge.ConnectionTerminator;
import org.osate.ge.Graphic;

/**
 * Marker for graphics which will be used to represent connections. Not public API.
 */
public interface AgeConnection extends Graphic {
	ConnectionStyle getConnectionStyle();
	ConnectionTerminator getSourceTerminator();
	ConnectionTerminator getDestinationTerminator();
}
