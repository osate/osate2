package org.osate.ge.errormodel.filters;

import org.osate.ge.ContentFilter;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

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
		return bo instanceof ErrorType;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorTypeExtension;
	}
}
