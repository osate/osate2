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
package org.osate.ge.internal.diagram.runtime;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A collection of diagram elements. A diagram element may only be added to the collection once.
 *
 */
class DiagramElementCollection extends AbstractCollection<DiagramElement> {
	private Map<RelativeBusinessObjectReference, DiagramElement> relativeReferenceToDiagramElementMap; // Initialized lazily.
	
	// Internal
	@Override
	public boolean add(final DiagramElement e) {
		if(relativeReferenceToDiagramElementMap == null) {
			relativeReferenceToDiagramElementMap = new ConcurrentHashMap<>(16, 0.75f, 1);
		}
		
		return relativeReferenceToDiagramElementMap.put(e.getRelativeReference(), e) != e;
	}
	
	@Override
	public boolean remove(final Object o) {
		return remove((DiagramElement)o);
	}
	
	public boolean remove(final DiagramElement e) {
		if(relativeReferenceToDiagramElementMap == null) {
			return false;
		}
		
		return relativeReferenceToDiagramElementMap.remove(e.getRelativeReference()) != null;
	}
	
	@Override
	public int size() {
		return relativeReferenceToDiagramElementMap == null ? 0 : relativeReferenceToDiagramElementMap.size();
	}

	/**
	 * Iterator does not allow modification. 
	 */
	@Override
	public Iterator<DiagramElement> iterator() {
		final Collection<DiagramElement> c = relativeReferenceToDiagramElementMap == null ? Collections.emptyList() : relativeReferenceToDiagramElementMap.values(); 
		return c.iterator();
	}
	
	public DiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return relativeReferenceToDiagramElementMap == null ? null : relativeReferenceToDiagramElementMap.get(ref);
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		toString(sb, "");
		return sb.toString();
	}
	
	void toString(final StringBuilder sb, final String indention) {
		for(final DiagramElement e : this) {
			e.toString(sb, indention);
		}
	}
}
