package org.osate.ge.errormodel.filters;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.ContentFilter;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;

public class ErrorTypeLibraryFilter implements ContentFilter {
	public static final String ID = "emv2.errorTypeLibrary";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Type Library";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof AadlPackage;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorTypeLibrary;
	}
}
