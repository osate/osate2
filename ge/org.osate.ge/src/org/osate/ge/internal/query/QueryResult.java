package org.osate.ge.internal.query;

import java.util.ArrayList;
import java.util.List;
import org.osate.ge.internal.diagram.DiagramElementContainer;

public class QueryResult {
	public final List<DiagramElementContainer> result = new ArrayList<DiagramElementContainer>();
	public boolean done = false;
}
