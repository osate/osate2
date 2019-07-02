package org.osate.ge.internal.diagram.runtime.updating;

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.model.EmbeddedBusinessObject;

// Holds information regarding diagram elements which have not been created.
public class FutureElementInfo {
	// The position may be null to indicate that a position hasn't been specified.
	public final Point position;

	// The business object that is being added to the diagram element.
	// Required for embedded business objects because such objects are not contributed by business object providers.
	// Otherwise, the business object provided by a business object provider is used during the update process.
	public final EmbeddedBusinessObject embeddedBo;

	public FutureElementInfo() {
		this(null, null);
	}

	public FutureElementInfo(final Point position, final EmbeddedBusinessObject embeddedBo) {
		this.position = position;
		this.embeddedBo = embeddedBo;
	}
}
