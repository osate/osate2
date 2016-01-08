package org.osate.ge.ext;

import java.util.Objects;

public final class SimplePaletteEntry implements ExtensionPaletteEntry {
	private final String category;
	private final Type type;
	private final String label;
	private final String imageId;
	private final Object context;
	
	/**
	 * 
	 * @param type
	 * @param label
	 * @param imageId is optional.
	 * @param category
	 */
	public SimplePaletteEntry(final String category, final Type type, final String label, final String imageId, final Object context) {
		this.category = Objects.requireNonNull(category, "category must not be null");
		this.type = Objects.requireNonNull(type, "type must not be null");
		this.label = Objects.requireNonNull(label, "label must not be null");
		this.imageId = imageId;
		this.context = context;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getImageId() {
		return imageId;
	}
	
	@Override
	public Type getType() {
		return type;
	}
	
	@Override
	public Object getContext() {
		return context;
	}
}
