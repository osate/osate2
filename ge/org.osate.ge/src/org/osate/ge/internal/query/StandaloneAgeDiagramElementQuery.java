package org.osate.ge.internal.query;

import java.util.function.Function;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.query.DiagramElementQuery;

public class StandaloneAgeDiagramElementQuery implements StandaloneDiagramElementQuery {
	private final AgeDiagramElementQuery<Object> rootQuery = new RootAgeDiagramElementQuery(() -> this.rootDiagramElement);
	private AgeDiagramElement rootDiagramElement;
	private final AgeDiagramElementQuery<?> query;
	
	StandaloneAgeDiagramElementQuery(Function<DiagramElementQuery<?>, DiagramElementQuery<?>> queryCreator) {
		this.query = (AgeDiagramElementQuery<?>)queryCreator.apply(rootQuery);	
	}	
	
	public AgeDiagramElement getFirstResult(final QueryRunner qr, final AgeDiagramElement rootDiagramElement) {
		try {
			this.rootDiagramElement = rootDiagramElement;
			return (AgeDiagramElement)qr.getFirstResult(query, null);
		} finally {
			this.rootDiagramElement = null;
		}
	}
}
