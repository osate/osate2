package org.osate.ge;

import org.osate.ge.internal.SimplePaletteEntry;

public class PaletteEntryFactory {
	public static PaletteEntry makeCreateEntry(final String category, final String label, final String imageId, final Object context) {
		return new SimplePaletteEntry(category, SimplePaletteEntry.Type.CREATE, label, imageId, context);
	}
	
	public static PaletteEntry makeCreateConnectionEntry(final String category, final String label, final String imageId, final Object context) {
		return new SimplePaletteEntry(category, SimplePaletteEntry.Type.CREATE_CONNECTION, label, imageId, context);
	}
}
