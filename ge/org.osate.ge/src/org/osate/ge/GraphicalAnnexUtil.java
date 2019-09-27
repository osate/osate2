package org.osate.ge;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;

public class GraphicalAnnexUtil {
	// All methods are static
	private GraphicalAnnexUtil() {
	}

	//
	// Libraries
	//
	public static AnnexLibrary getOrCreateParsedAnnexLibrary(final AadlPackage pkg, final String annexName,
			final EClass parsedType) {
		// Get or create the DefaultAnnexLibrary
		DefaultAnnexLibrary defaultLib = getFirstDefaultAnnexLibrary(pkg, annexName);
		if (defaultLib == null) {
			// Must create new annex
			defaultLib = (DefaultAnnexLibrary) pkg.getPublicSection()
					.createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getDefaultAnnexLibrary());
			defaultLib.setName(annexName);
			defaultLib.setSourceText("{** **}");
		}

		// Create the parsed library as needed
		AnnexLibrary parsedLib = getParsedAnnexLibrary(defaultLib, parsedType);
		if (parsedLib == null) {
			parsedLib = defaultLib.createParsedAnnexLibrary(parsedType);
		}

		return parsedLib;
	}

	public static AnnexLibrary getFirstParsedAnnexLibrary(final AadlPackage pkg, final String annexName,
			final EClass parsedType) {
		DefaultAnnexLibrary defaultLib = getFirstDefaultAnnexLibrary(pkg, annexName);
		if (defaultLib == null) {
			return null;
		}

		return getParsedAnnexLibrary(defaultLib, parsedType);
	}

	private static DefaultAnnexLibrary getFirstDefaultAnnexLibrary(final AadlPackage pkg, final String annexName) {
		if (pkg.getPublicSection() == null) {
			throw new RuntimeException("Unable to get public section");
		}

		for (final AnnexLibrary lib : pkg.getPublicSection().getOwnedAnnexLibraries()) {
			if (lib.getName().equals(annexName) && lib instanceof DefaultAnnexLibrary) {
				return (DefaultAnnexLibrary) lib;
			}
		}

		return null;
	}

	private static AnnexLibrary getParsedAnnexLibrary(final DefaultAnnexLibrary defaultLib, final EClass parsedType) {
		final AnnexLibrary parsedAnnexLibrary = defaultLib.getParsedAnnexLibrary();
		if (parsedType.isInstance(parsedAnnexLibrary)) {
			return parsedAnnexLibrary;
		}
		final String trimmedSrc = defaultLib.getSourceText().trim();
		if ("{****}".equals(trimmedSrc) || "{** **}".equals(trimmedSrc)) {
			return null;
		}

		// If unable to get the parsed annex library, throw an exception. Should not mistake this case for simply not having the annex library.
		throw new RuntimeException(
				"Annex library found but unable to retrieve parsed annex library of type: " + parsedType.getName());
	}

	//
	// Subclause
	//
	public static AnnexSubclause getOrCreateParsedAnnexSubclause(final Classifier c, final String annexName,
			final EClass parsedType) {
		// Get or create the DefaultAnnexSubclause
		DefaultAnnexSubclause defaultSubclause = getFirstDefaultAnnexSubclause(c, annexName);
		if (defaultSubclause == null) {
			// Must create new annex
			defaultSubclause = c.createOwnedAnnexSubclause();
			defaultSubclause.setName(annexName);
			defaultSubclause.setSourceText("{** **}");
		}

		// Create the parsed subclause as needed
		AnnexSubclause parsedSubclause = getParsedAnnexSubclause(defaultSubclause, parsedType);
		if (parsedSubclause == null) {
			parsedSubclause = defaultSubclause.createParsedAnnexSubclause(parsedType);
		}

		return parsedSubclause;
	}

	public static AnnexSubclause getFirstParsedAnnexSubclause(final Classifier c, final String annexName,
			final EClass parsedType) {
		DefaultAnnexSubclause defaultSubclause = getFirstDefaultAnnexSubclause(c, annexName);
		if (defaultSubclause == null) {
			return null;
		}

		return getParsedAnnexSubclause(defaultSubclause, parsedType);
	}

	private static DefaultAnnexSubclause getFirstDefaultAnnexSubclause(final Classifier c, final String annexName) {
		for (final AnnexSubclause subclause : c.getOwnedAnnexSubclauses()) {
			if (subclause.getName().equals(annexName) && subclause instanceof DefaultAnnexSubclause) {
				return (DefaultAnnexSubclause) subclause;
			}
		}

		return null;
	}

	private static AnnexSubclause getParsedAnnexSubclause(final DefaultAnnexSubclause defaultSubclause,
			final EClass parsedType) {
		final AnnexSubclause parsedAnnexSubclause = defaultSubclause.getParsedAnnexSubclause();
		if (parsedType.isInstance(parsedAnnexSubclause)) {
			return parsedAnnexSubclause;
		}
		final String trimmedSrc = defaultSubclause.getSourceText().trim();
		if ("{****}".equals(trimmedSrc) || "{** **}".equals(trimmedSrc)) {
			return null;
		}

		// If unable to get the parsed annex subclause, throw an exception. Should not mistake this case for simply not having the annex subclause.
		throw new RuntimeException(
				"Annex subclause found but unable to retrieve parsed annex subclause of type: " + parsedType.getName());
	}
}
