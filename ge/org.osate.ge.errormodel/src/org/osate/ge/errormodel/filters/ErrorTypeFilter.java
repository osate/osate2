package org.osate.ge.errormodel.filters;

import org.osate.ge.ContentFilter;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeFilter implements ContentFilter {
	public static final String ID = "emv2.errorTypes";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Types";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorTypeLibrary;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorType;
	}
}
