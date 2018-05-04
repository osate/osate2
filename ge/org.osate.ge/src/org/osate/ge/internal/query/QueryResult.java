package org.osate.ge.internal.query;

import java.util.ArrayList;
import java.util.List;

public class QueryResult {
	public final List<Queryable> result = new ArrayList<Queryable>();
	public boolean done = false;
}
