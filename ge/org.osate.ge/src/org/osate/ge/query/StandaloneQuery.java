package org.osate.ge.query;

import java.util.function.Function;

import org.osate.ge.internal.query.DefaultStandaloneQuery;

// TODO: Document
// TODO: Rename?
public interface StandaloneQuery {
	// TODO: Document
	public static StandaloneQuery create(Function<Query, Query> queryCreator) {
		return new DefaultStandaloneQuery(queryCreator);
	}
}
