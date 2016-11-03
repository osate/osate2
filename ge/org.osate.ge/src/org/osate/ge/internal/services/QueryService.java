package org.osate.ge.internal.services;

import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;

// TODO: Make API once stabilized.
public interface QueryService {
	Object getFirstBusinessObject(StandaloneDiagramElementQuery query, DiagramElementProxy rootElement);
}
