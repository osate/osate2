package org.osate.ge.query;

import java.util.function.Function;

import org.osate.ge.internal.query.DefaultStandaloneQuery;

public interface StandaloneQuery {
	public static StandaloneQuery create(Function<Query, Query> queryCreator) {
		return new DefaultStandaloneQuery(queryCreator);
	}
}
