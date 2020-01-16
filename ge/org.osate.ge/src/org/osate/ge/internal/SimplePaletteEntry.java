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
package org.osate.ge.internal;

import java.util.Objects;

import org.osate.ge.PaletteEntry;

public class SimplePaletteEntry implements PaletteEntry {
	public enum Type {
		CREATE,
		CREATE_CONNECTION
	}
	
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
		this.category = category;
		this.type = Objects.requireNonNull(type, "type must not be null");
		this.label = Objects.requireNonNull(label, "label must not be null");
		this.imageId = imageId;
		this.context = context;
	}
	
	public final String getCategory() {
		return category;
	}

	public final String getLabel() {
		return label;
	}

	public final String getImageId() {
		return imageId;
	}
	
	public final Type getType() {
		return type;
	}
	
	// Extension supplied object that can be used to distinguish between palette entries.
	public final Object getContext() {
		return context;
	}
}
