package org.osate.ge.internal.query;

import java.util.ArrayList;
import java.util.List;
import org.osate.ge.internal.diagram.DiagramNode;

public class QueryResult {
	public final List<DiagramNode> result = new ArrayList<DiagramNode>();
	public boolean done = false;
}
