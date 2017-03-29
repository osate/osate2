package org.osate.ge.internal.query;

import java.util.function.Function;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.query.DiagramElementQuery;

public class StandaloneAgeDiagramNodeQuery implements StandaloneDiagramElementQuery {
	private final DiagramNodeQuery<Object> rootQuery = new RootAgeDiagramNodeQuery(() -> this.rootNode);
	private DiagramNode rootNode;
	private final DiagramNodeQuery<?> query;
	
	StandaloneAgeDiagramNodeQuery(Function<DiagramElementQuery<?>, DiagramElementQuery<?>> queryCreator) {
		this.query = (DiagramNodeQuery<?>)queryCreator.apply(rootQuery);	
	}	
	
	public DiagramNode getFirstResult(final QueryRunner qr, final DiagramNode rootNode) {
		try {
			this.rootNode = rootNode;
			return qr.getFirstResult(query, null);
		} finally {
			this.rootNode = null;
		}
	}
}
