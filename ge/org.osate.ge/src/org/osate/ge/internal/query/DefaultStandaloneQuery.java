package org.osate.ge.internal.query;

import java.util.List;
import java.util.function.Function;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;

public class DefaultStandaloneQuery implements StandaloneQuery {
	private final DefaultQuery rootQuery = new RootQuery(() -> this.rootNode);
	private Queryable rootNode;
	private final DefaultQuery query;
	
	public DefaultStandaloneQuery(Function<Query, Query> queryCreator) {
		this.query = (DefaultQuery)queryCreator.apply(rootQuery);	
	}	
	
	public Queryable getFirstResult(final QueryRunner qr, final Queryable rootNode, final Object arg) {
		try {
			this.rootNode = rootNode;
			return qr.getFirstResult(query, arg);
		} finally {
			this.rootNode = null;
		}
	}
	
	public List<? extends Queryable> getResults(final QueryRunner qr, final Queryable rootNode, final Object arg) {
		try {
			this.rootNode = rootNode;
			return qr.getResults(query, arg);
		} finally {
			this.rootNode = null;
		}
	}
}
