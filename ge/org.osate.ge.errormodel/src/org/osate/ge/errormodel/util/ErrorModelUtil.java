package org.osate.ge.errormodel.util;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelUtil {
	public static ErrorModelLibrary getOrCreateErrorModelLibrary(final AadlPackage pkg) {
		// Get or create the EMV2 DefaultAnnexLibrary
		DefaultAnnexLibrary defaultLib = getDefaultErrorModelLibrary(pkg);
		if(defaultLib == null) {
			// Must create new annex
			defaultLib = (DefaultAnnexLibrary) pkg.getPublicSection().createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getDefaultAnnexLibrary());
			defaultLib.setName(EMV2Util.ErrorModelAnnexName);
			defaultLib.setSourceText("{** **}");
		}
		
		// Create the parsed library as needed
		ErrorModelLibrary errorModelLibrary = getErrorModelLibrary(defaultLib);
		if(errorModelLibrary == null) {
			// Create the ErrorModelLibrary
			errorModelLibrary = (ErrorModelLibrary)defaultLib.createParsedAnnexLibrary(ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
			errorModelLibrary.setName(EMV2Util.ErrorModelAnnexName);
		}

		return errorModelLibrary;
	}
	
	private static DefaultAnnexLibrary getDefaultErrorModelLibrary(final AadlPackage pkg) {
		if(pkg.getPublicSection() == null) {
			throw new RuntimeException("Unable to get public section");
		}

		for(final AnnexLibrary lib : pkg.getPublicSection().getOwnedAnnexLibraries()) {
			if(lib.getName().equals(EMV2Util.ErrorModelAnnexName) && lib instanceof DefaultAnnexLibrary) {
				return (DefaultAnnexLibrary)lib;
			}
		}
		
		return null;
	}
	
	private static ErrorModelLibrary getErrorModelLibrary(final DefaultAnnexLibrary defaultLib) {
		final AnnexLibrary parsedAnnexLibrary = defaultLib.getParsedAnnexLibrary();
		if(parsedAnnexLibrary instanceof ErrorModelLibrary) { 
			return (ErrorModelLibrary)parsedAnnexLibrary;
		}
		
		// In this case... don't want to creat ea new library
		if("{****}".equals(defaultLib.getSourceText().trim())) {
			return null;
		}
		
		// If unable to get the parsed annex library, throw an exception. Should not mistake this case for simply not having an error model library.
		throw new RuntimeException("EMV2 libary found but unable to retrieve parsed annex library.");
	}
}
