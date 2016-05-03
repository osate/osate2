package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;

import org.osate.ge.ConnectionTerminator;
import org.osate.ge.Graphic;
import org.osate.ge.GraphicFactory;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryFactory;
import org.osate.ge.di.AllowDelete;
import org.osate.ge.di.CanCreateConnection;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.CreateBusinessObject;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateOwnerDiagramElementQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.Delete;
import org.osate.ge.di.GetCreateOwningBusinessObject;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeExtensionPictogramHandler {
	private static final Graphic graphic = GraphicFactory.createSolidFreeFormConnection(null, ConnectionTerminator.OPEN_ARROW);
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ErrorTypeLibrary typeLib) {
		return new PaletteEntry[] { 
			PaletteEntryFactory.makeCreateConnectionEntry(ErrorModelCategories.ERROR_MODEL, "Error Type Extension", null, null)
		};
	}
	
	@IsApplicable
	@AllowDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension errorTypeExtension) {
		return true;
	}
	
	@GetGraphicalRepresentation
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@CreateOwnerDiagramElementQuery
	public DiagramElementQuery<?> createOwnerDiagramElementQuery(final @Named(Names.SRC_ROOT_QUERY) DiagramElementQuery<?> srcRootQuery) {
		return srcRootQuery.ancestor(1);
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<?> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<?> rootQuery) {
		return rootQuery.children().filterByBusinessObject(ete->((ErrorTypeExtension)ete).getSubtype());
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<?> createDestination(final @Named(Names.ROOT_QUERY) DiagramElementQuery<?> rootQuery) {
		return rootQuery.children().filterByBusinessObject(ete->((ErrorTypeExtension)ete).getSupertype());
	}
	
	@Delete
	public void delete(final @Named(Names.OWNER_BO) ErrorType subtype, final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension errorTypeExtension) {
		subtype.setSuperType(null);
	}
		
	@GetCreateOwningBusinessObject
	public ErrorType getCreateConnectionOwner(@Named(Names.SOURCE_BO) final ErrorType subtype, @Named(Names.DESTINATION_BO) final ErrorType supertype) {
		return subtype;
	}
	
	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final ErrorType subtype) {
		return true;
	}	
	
	@CanCreateConnection
	public boolean canCreateTypeExtension(@Named(Names.SOURCE_BO) final ErrorType subtype, @Named(Names.DESTINATION_BO) final ErrorType supertype) {
		return supertype != subtype;
	}
	
	@CreateBusinessObject
	public ErrorTypeExtension createConnectionBusinessObject(@Named(Names.SOURCE_BO) final ErrorType subtype, @Named(Names.DESTINATION_BO) final ErrorType supertype) {
		subtype.setSuperType(supertype);
		return new ErrorTypeExtension(supertype, subtype);
	}
}
