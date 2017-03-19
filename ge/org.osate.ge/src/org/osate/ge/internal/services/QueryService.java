package org.osate.ge.internal.services;

import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;

// TODO: Make API once stabilized.
public interface QueryService {
	Object getFirstBusinessObject(StandaloneDiagramElementQuery query, DiagramElement rootElement);
}
