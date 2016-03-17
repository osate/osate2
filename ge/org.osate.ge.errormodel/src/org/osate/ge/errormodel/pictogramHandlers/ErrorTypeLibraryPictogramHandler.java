package org.osate.ge.errormodel.pictogramHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Rectangle;
import org.osate.ge.services.GraphicalEditorService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeLibraryPictogramHandler {
	private static final Rectangle graphics = new Rectangle();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return true;
	}
	
	@GetChildren
	public Stream<ErrorType> getChildren(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return typeLib.getErrorModelLibrary().getTypes().stream();
	}

	@GetGraphicalRepresentation
	public Rectangle getGraphicalRepresentation() {
		return graphics;
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib, final GraphicalEditorService editorService) {
		editorService.openBusinessObject(typeLib);
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return "Error Type Library";
	}
}
