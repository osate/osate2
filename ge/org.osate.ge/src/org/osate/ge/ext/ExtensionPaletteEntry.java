package org.osate.ge.ext;

public interface ExtensionPaletteEntry extends Categorized {
	enum Type {
		CREATE_SHAPE,
		CREATE_CONNECTION
	}
	
	Type getType();
	String getLabel();
	String getImageId();
	Object getContext(); // Extension supplied object that can be used to distinguish between palette entries.
}
