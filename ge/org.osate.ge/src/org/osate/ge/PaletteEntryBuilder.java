/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
	 * @see org.osate.ge.di.Names#MODIFY_BO
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
