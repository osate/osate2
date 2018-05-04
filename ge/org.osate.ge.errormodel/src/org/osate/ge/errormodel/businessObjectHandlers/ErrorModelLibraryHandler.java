package org.osate.ge.errormodel.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorModelLibraryHandler {	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return true;
	}
}
