package org.osate.ge.errormodel.pictogramHandlers;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.ExtensionPaletteEntry.Type;
import org.osate.ge.ext.SimplePaletteEntry;
import org.osate.ge.ext.annotations.CanCreateConnection;
import org.osate.ge.ext.annotations.CanStartConnection;
import org.osate.ge.ext.annotations.CreateConnectionBusinessObject;
import org.osate.ge.ext.annotations.GetPaletteEntries;

public class TestConnectionHandler {
	@GetPaletteEntries
	public ExtensionPaletteEntry[] getPaletteEntries() {
		return new ExtensionPaletteEntry[] { 
			new SimplePaletteEntry(ErrorModelCategories.ERROR_MODEL, Type.CREATE_CONNECTION, "Connection Test", null, null)
		};
	}
	// TODO
	//@GetCreateConnectionOwner - RENAME - Returns a business object not the owning pictogram element? May not have a pictogram element
	public ContainerShape getCreateConnectionOwner() {
		return null;
	}
	
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
	
	// TODO: CreateConnectionBusinessObject
	@CreateConnectionBusinessObject
	public Object createConnectionBusinessObject() {
		// TODO
		return null;
	}
}
