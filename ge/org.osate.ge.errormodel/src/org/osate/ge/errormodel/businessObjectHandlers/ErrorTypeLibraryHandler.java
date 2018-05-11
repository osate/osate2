package org.osate.ge.errormodel.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.errormodel.util.ErrorModelUtil;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorTypeLibraryHandler {
	private static final Graphic graphic = RectangleBuilder.create().build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary lib) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().graphic(graphic).build();
	}

	@GetName
	public String getName() {
		return "Error Type Library";
	}

	// Creation
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] { PaletteEntryBuilder.create().label("Error Type Library")
				.category(ErrorModelCategories.ERROR_MODEL).build() };
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) AadlPackage pkg) {
		return !hasErrorModelLibrary(pkg);
	}

	@Create
	public Object createBusinessObject(@Named(Names.MODIFY_BO) AadlPackage pkg) {
		return ErrorModelUtil.getOrCreateErrorModelLibrary(pkg);
	}

	private static boolean hasErrorModelLibrary(final AadlPackage pkg) {
		if (pkg.getPublicSection() == null) {
			return false;
		}

		for (final AnnexLibrary lib : pkg.getPublicSection().getOwnedAnnexLibraries()) {
			if (lib.getName().equals(EMV2Util.ErrorModelAnnexName)) {
				return true;
			}
		}

		return false;
	}
}
