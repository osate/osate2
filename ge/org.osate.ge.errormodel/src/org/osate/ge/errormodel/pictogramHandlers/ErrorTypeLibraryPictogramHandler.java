package org.osate.ge.errormodel.pictogramHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.GetChildren;
import org.osate.ge.ext.annotations.GetGraphicalRepresentation;
import org.osate.ge.ext.annotations.GetName;
import org.osate.ge.ext.annotations.HandleDoubleClick;
import org.osate.ge.ext.annotations.IsApplicable;
import org.osate.ge.ext.graphics.Rectangle;
import org.osate.ge.ext.services.DiagramService;
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
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib, final DiagramService diagramService) {
		diagramService.openOrCreateDiagramBusinessObject(typeLib);
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return "Error Type Library";
	}
}
