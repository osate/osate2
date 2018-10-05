package org.osate.ge.internal.diagram.runtime.updating;

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.model.EmbeddedBusinessObject;

// Holds information regarding diagram elements which have not been created.
public class FutureElementInfo {
	public final boolean manual; // Initial value of the manual flag

	// The position may be null to indicate that an element should be added as a manually added element but that a position hasn't been specified.
	public final Point position;

	// The business object that is being added to the diagram element.
	// Required for embedded business objects because such objects are not contributed by business object providers.
	// Otherwise, the business object provided by a business object provider is used during the update process.
	public final EmbeddedBusinessObject embeddedBo;

	public FutureElementInfo(final boolean manual) {
		this(manual, null, null);
	}

	public FutureElementInfo(final boolean manual, final Point position, final EmbeddedBusinessObject embeddedBo) {
		this.manual = manual;
		this.position = position;
		this.embeddedBo = embeddedBo;
	}
}
