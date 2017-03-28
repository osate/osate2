package org.osate.ge.internal.diagram.updating;

import org.osate.ge.internal.diagram.DiagramConfiguration;

// This interface provides the business objects that should be included in the diagram.
// The updater is responsible for adding and removing elements as necessary.
public interface BusinessObjectTreeFactory {
	BusinessObjectTree createBusinessObjectTree(final DiagramConfiguration configuration);
}