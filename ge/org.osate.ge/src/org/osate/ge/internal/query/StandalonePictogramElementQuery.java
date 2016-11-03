package org.osate.ge.internal.query;

import java.util.function.Function;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.query.DiagramElementQuery;

public class StandalonePictogramElementQuery implements StandaloneDiagramElementQuery {
	private final PictogramQuery<Object> rootQuery = new RootPictogramQuery(() -> this.rootPictogramElement);
	private PictogramElement rootPictogramElement;
	private final PictogramQuery<?> query;
	
	StandalonePictogramElementQuery(Function<DiagramElementQuery<?>, DiagramElementQuery<?>> queryCreator) {
		this.query = (PictogramQuery<?>)queryCreator.apply(rootQuery);	
	}	
	
	public PictogramElement getFirstResult(final QueryRunner qr, final PictogramElement rootPictogramElement) {
		try {
			this.rootPictogramElement = rootPictogramElement;
			return (PictogramElement)qr.getFirstResult(query, null);
		} finally {
			this.rootPictogramElement = null;
		}
	}
}
