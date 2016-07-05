/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge;

/**
 * Marker interface representing an entry in graphical editor palette. The graphical editor's palette is populated based on PaletteEntry objects 
 * provided by the Business Object Handler extensions. PaletteEntry objects must be created using the {@link PaletteEntryBuilder} class.
 * @noextend
 * @noimplement
 * @see org.osate.ge.di.GetPaletteEntries
 * @see PaletteEntryBuilder
 */
public interface PaletteEntry {
}
