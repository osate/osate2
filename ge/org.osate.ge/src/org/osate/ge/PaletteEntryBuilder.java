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

public class PaletteEntryBuilder {
	private SimplePaletteEntry.Type type = SimplePaletteEntry.Type.CREATE;
	private String category;
	private String label;
	private String imageId;
	private Object context;
	
	private PaletteEntryBuilder() {}
	
	public static PaletteEntryBuilder create() {
		return new PaletteEntryBuilder();
	}
	
	public PaletteEntryBuilder creation() {
		this.type = SimplePaletteEntry.Type.CREATE;
		return this;
	}
	
	public PaletteEntryBuilder connectionCreation() {
		this.type = SimplePaletteEntry.Type.CREATE_CONNECTION;
		return this;
	}
	
	public PaletteEntryBuilder label(final String label) {
		this.label = Objects.requireNonNull(label, "label must not be null");
		return this;
	}

	public PaletteEntryBuilder category(final String category) {
		this.category = category;
		return this;
	}
	
	public PaletteEntryBuilder icon(final String imageId) {
		this.imageId = imageId;
		return this;
	}
	
	public PaletteEntryBuilder context(final Object context) {
		this.context = context;
		return this;
	}
	
	public PaletteEntry build() {
		return new SimplePaletteEntry(category, type, label, imageId, context);
	}
}
