package org.osate.ge.errormodel.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Delete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForUserInterface;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeExtensionHandler {
	private static final Graphic labelGraphic = LabelBuilder.create().build();
	private static final Graphic connectionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().open().build()).build();

	private static StandaloneQuery dstDifferentPackageQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.ancestor(4)
					.descendantsByBusinessObjectsRelativeReference(
							ete -> getBusinessObjectPath(((ErrorTypeExtension) ete).getSupertype())));

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] { PaletteEntryBuilder.create().connectionCreation().label("Error Type Extension")
				.category(ErrorModelCategories.ERROR_MODEL).build() };
	}

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension errorTypeExtension) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final BusinessObjectContext destination = getDestination(boc, queryService);

		if (destination == null) {
			return GraphicalConfigurationBuilder.create().graphic(labelGraphic).decoration().build();
		} else {
			return GraphicalConfigurationBuilder.create().graphic(connectionGraphic).
					source(boc.getParent()).destination(destination).build();
		}
	}

	@GetNameForUserInterface
	public String getName() {
		return "Extension";
	}

	@GetName
	public String getLabelName(final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension ext,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		// Don't show the name when displaying as a connection
		if (getDestination(boc, queryService) != null) {
			return null;
		}

		// If elements are in the same package, only show the name instead of the equalified name
		final String superName;
		if (ext.getSupertype().getElementRoot() == ext.getSubtype().getElementRoot()) {
			superName = ext.getSupertype().getName();
		} else {
			superName = ext.getSupertype().getQualifiedName();
		}

		return "Extends: " + superName;
	}

	private BusinessObjectContext getDestination(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		final BusinessObjectContext packageParent = boc.getAncestor(4);
		if (packageParent == null) {
			// Not supported. Will need to be supported if error type libraries are supported as a diagram context
			return null;
		} else {
			return queryService.getFirstResult(dstDifferentPackageQuery, boc);
		}
	}

	@Delete
	public void delete(final @Named(Names.MODIFY_BO) ErrorType subtype,
			final @Named(Names.BUSINESS_OBJECT) ErrorTypeExtension errorTypeExtension) {
		subtype.setSuperType(null);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final ErrorType subtype) {
		return true;
	}

	@CanCreate
	public boolean canCreateTypeExtension(@Named(Names.SOURCE_BO) final ErrorType subtype,
			@Named(Names.DESTINATION_BO) final ErrorType supertype) {
		return supertype != subtype;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			final @Named(Names.SOURCE_BO) ErrorType subtypeReadonly,
			final @Named(Names.DESTINATION_BO) ErrorType supertype) {
		return Operation.create(createOp -> {
			createOp.supply(() -> StepResult.forValue(subtypeReadonly)).modifyPreviousResult(subtype -> {
				subtype.setSuperType(supertype);
				final Object newBo = new ErrorTypeExtension(supertype, subtype);
				return StepResultBuilder.create().showNewBusinessObject(srcBoc, newBo).build();
			});
		});
	}

	private static Object[] getBusinessObjectPath(final ErrorType et) {
		if (!(et.eContainer() instanceof ErrorModelLibrary)) {
			return null;
		}

		return new Object[] { et.getElementRoot(), new ErrorTypeLibrary((ErrorModelLibrary) et.eContainer()), et };
	}
}
