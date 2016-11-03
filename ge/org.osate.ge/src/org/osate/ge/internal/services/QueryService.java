package org.osate.ge.internal.services;

import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;

// TODO: Make API once stabilized.
public interface QueryService {
	// TODO: root should be some sort of reference/object that is part of the API?
	Object getFirstBusinessObject(StandaloneDiagramElementQuery query, DiagramElementProxy rootElement);
}
