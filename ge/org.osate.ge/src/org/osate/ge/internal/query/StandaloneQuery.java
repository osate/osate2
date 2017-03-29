package org.osate.ge.internal.query;

import java.util.function.Function;
import org.osate.ge.query.DiagramElementQuery;

public class StandaloneQuery implements StandaloneDiagramElementQuery {
	private final Query<Object> rootQuery = new RootQuery(() -> this.rootNode);
	private Queryable rootNode;
	private final Query<?> query;
	
	StandaloneQuery(Function<DiagramElementQuery<?>, DiagramElementQuery<?>> queryCreator) {
		this.query = (Query<?>)queryCreator.apply(rootQuery);	
	}	
	
	public Queryable getFirstResult(final QueryRunner qr, final Queryable rootNode) {
		try {
			this.rootNode = rootNode;
			return qr.getFirstResult(query, null);
		} finally {
			this.rootNode = null;
		}
	}
}
