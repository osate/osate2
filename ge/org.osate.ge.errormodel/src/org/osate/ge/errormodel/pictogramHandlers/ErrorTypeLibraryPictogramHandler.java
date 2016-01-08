package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.ExtensionPaletteEntry.Type;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.SimplePaletteEntry;
import org.osate.ge.ext.annotations.CanCreateConnection;
import org.osate.ge.ext.annotations.CanCreateShape;
import org.osate.ge.ext.annotations.CanStartConnection;
import org.osate.ge.ext.annotations.CreateConnection;
import org.osate.ge.ext.annotations.CreateShape;
import org.osate.ge.ext.annotations.GetPaletteEntries;

public class ErrorTypeLibraryPictogramHandler {
	@GetPaletteEntries
	public ExtensionPaletteEntry[] getPaletteEntries() {
		return new ExtensionPaletteEntry[] { 
			new SimplePaletteEntry(ErrorModelCategories.ERROR_MODEL, Type.CREATE_SHAPE, "Error Type Library", null, null),
			new SimplePaletteEntry(ErrorModelCategories.ERROR_MODEL, Type.CREATE_CONNECTION, "Connection Test", null, null)
		};
	}
	
	@CanCreateShape
	public boolean canCreateShape(final @Named(Names.CONTAINER) ContainerShape container) {
		// TODO
		return true;
	}
	
	@CreateShape
	public void createShape() {
		// TODO
		System.err.println("CREATE SHAPE");
	}
	
	// TODO: Remove following after  testing
	@CanStartConnection
	public boolean canStartConnection() {
		// TODO
		return true;
	}
	
	@CanCreateConnection
	public boolean canCreateConnection() {
		// TODO
		return true;
	}
	
	@CreateConnection
	public void createConnection() {
		// TODO
		System.err.println("CREATE CONNECTION");
	}
}
