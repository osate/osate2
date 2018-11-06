package org.osate.ge.errormodel.filters;

import org.osate.ge.ContentFilter;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;

public class ErrorTypeExtensionFilter implements ContentFilter {
	public static final String ID = "emv2.errorTypeExtensions";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Type Extensions";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorTypeLibrary;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorTypeExtension;
	}
}
