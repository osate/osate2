/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge;

import java.util.Objects;

import org.osate.ge.internal.SimplePaletteEntry;

/**
 * Builder for creating palette entries. 
 * @noextend
 @see PaletteEntry
 */
public final class PaletteEntryBuilder {
	private SimplePaletteEntry.Type type = SimplePaletteEntry.Type.CREATE;
	private String category;
	private String label;
	private String imageId;
	private Object context;
	
	private PaletteEntryBuilder() {}
	
	/**
	 * Creates a palette entry builder
	 * @return a new palette entry builder
	 */
	public static PaletteEntryBuilder create() {
		return new PaletteEntryBuilder();
	}
	
	/**
	 * Configures the palette entry builder to create a palette entry for creating a business object based on an owner business object.
	 * Such a palette entry is most often used to create business objects represented by shapes.
	 * @return this builder to allow method chaining.
	 * @see org.osate.ge.di.Names#OWNER_BO
	 * @see org.osate.ge.di.GetCreateOwner
	 * @see org.osate.ge.di.CanCreate
	 * @see org.osate.ge.di.Create
	 */
	public PaletteEntryBuilder creation() {
		this.type = SimplePaletteEntry.Type.CREATE;
		return this;
	}
	
	/**
	 * Configures the palette entry builder to create a palette entry for creating a business object based on a source and a destination business object.
	 * Such a palette entry is most often used to create business objects represented by connections.
	 * @return this builder to allow method chaining.
	 * @see org.osate.ge.di.Names#SOURCE_BO
	 * @see org.osate.ge.di.Names#DESTINATION_BO
	 * @see org.osate.ge.di.GetCreateOwner
	 * @see org.osate.ge.di.CanCreate
	 * @see org.osate.ge.di.Create
	 */
	public PaletteEntryBuilder connectionCreation() {
		this.type = SimplePaletteEntry.Type.CREATE_CONNECTION;
		return this;
	}
	
	/**
	 * Configures the palette entry builder to create a palette entry with the specified label.
	 * @param label the label to use when creating the palette entry
	 * @return this builder to allow method chaining.
	 */
	public PaletteEntryBuilder label(final String label) {
		this.label = Objects.requireNonNull(label, "label must not be null");
		return this;
	}

	/**
	 * Configures the palette entry builder to create a palette entry with the specified category. The category id must be the id of built-in category 
	 * as provided by the {@link Categories} class or a category id registered using the org.osate.ge.categories extension point.
	 * @param category the id of the category to use when creating the palette entry
	 * @return this builder to allow method chaining.
	 * @see Categories
	 */
	public PaletteEntryBuilder category(final String category) {
		this.category = category;
		return this;
	}
	
	/**
	 * Configures the palette entry builder to create a palette entry which uses the specified image as its icon. 
	 * The image id must be one which has been registered using the org.osate.ge.images extension point. 
	 * @param imageId the id of the category to use when creating the palette entry
	 * @return this builder to allow method chaining.
	 */
	public PaletteEntryBuilder icon(final String imageId) {
		this.imageId = imageId;
		return this;
	}
	
	
	/**
	 * Configures the palette entry builder to create a palette entry with the specified context. 
	 * The context may be any object. It is passed to the business object handler when the palette entry is used.
	 * @param context the context to use when creating the palette entry.
	 * @return this builder to allow method chaining.
	 * @see org.osate.ge.di.Names#PALETTE_ENTRY_CONTEXT
	 */
	public PaletteEntryBuilder context(final Object context) {
		this.context = context;
		return this;
	}
	
	/**
	 * Creates a palette entry based on the current state of the palette entry builder.
	 * @return the newly created palette entry
	 */
	public PaletteEntry build() {
		return new SimplePaletteEntry(category, type, label, imageId, context);
	}
}
