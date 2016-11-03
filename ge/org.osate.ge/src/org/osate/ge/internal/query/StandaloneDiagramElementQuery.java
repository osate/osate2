package org.osate.ge.internal.query;

import java.util.function.Function;

import org.osate.ge.query.DiagramElementQuery;

// TODO: Make API when stabilized
public interface StandaloneDiagramElementQuery {
	// TODO: Move to factory?
	public static StandaloneDiagramElementQuery create(Function<DiagramElementQuery<?>, DiagramElementQuery<?>> queryCreator) {
		return new StandalonePictogramElementQuery(queryCreator);
	}
}
