package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.query.DiagramElementQuery;

public class SubprogramCallOrderHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().line().build()).build();
	
	@IsApplicable	
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo) {
		return graphic;
	}
	
	@CreateParentQuery
	public DiagramElementQuery<?> createOwnerDiagramElementQuery(final @Named(Names.SOURCE_ROOT_QUERY) DiagramElementQuery<?> srcRootQuery) {
		return srcRootQuery.ancestor(1);
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<?> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<?> rootQuery) {
		return rootQuery.children().filterByBusinessObject(sco->((SubprogramCallOrder)sco).previousSubprogramCall);
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<?> createDestination(final @Named(Names.ROOT_QUERY) DiagramElementQuery<?> rootQuery) {
		return rootQuery.children().filterByBusinessObject(sco->((SubprogramCallOrder)sco).subprogramCall);
	}
}
