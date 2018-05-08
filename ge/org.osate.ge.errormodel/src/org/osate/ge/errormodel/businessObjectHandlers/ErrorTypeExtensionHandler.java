package org.osate.ge.errormodel.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.Delete;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeExtensionHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().open().build()).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(2).children().filterByBusinessObjectRelativeReference(ete->((ErrorTypeExtension)ete).getSubtype()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(2).children().filterByBusinessObjectRelativeReference(ete->((ErrorTypeExtension)ete).getSupertype()));

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] {
				PaletteEntryBuilder.create().connectionCreation().label("Error Type Extension").category(ErrorModelCategories.ERROR_MODEL).build()
		};
	}

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension errorTypeExtension) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				source(getSource(boc, queryService)).
				destination(getDestination(boc, queryService)).
				build();
	}

	private BusinessObjectContext getSource(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@Delete
	public void delete(final @Named(Names.MODIFY_BO) ErrorType subtype, final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension errorTypeExtension) {
		subtype.setSuperType(null);
	}

	@GetCreateOwner
	public BusinessObjectContext getCreateConnectionOwner(
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext subtype) {
		return subtype;
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final ErrorType subtype) {
		return true;
	}

	@CanCreate
	public boolean canCreateTypeExtension(@Named(Names.SOURCE_BO) final ErrorType subtype, @Named(Names.DESTINATION_BO) final ErrorType supertype) {
		return supertype != subtype;
	}

	@Create
	public ErrorTypeExtension createConnectionBusinessObject(@Named(Names.MODIFY_BO) final ErrorType subtype,
			@Named(Names.DESTINATION_BO) final ErrorType supertype) {
		subtype.setSuperType(supertype);
		return new ErrorTypeExtension(supertype, subtype);
	}
}
