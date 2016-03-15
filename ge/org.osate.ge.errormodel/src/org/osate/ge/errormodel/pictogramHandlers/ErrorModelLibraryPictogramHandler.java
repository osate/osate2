package org.osate.ge.errormodel.pictogramHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.ge.di.GetChildren;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorModelLibraryPictogramHandler {	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return true;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return Stream.concat(Stream.of(new ErrorTypeLibrary(lib)), lib.getBehaviors().stream());
	}
}
