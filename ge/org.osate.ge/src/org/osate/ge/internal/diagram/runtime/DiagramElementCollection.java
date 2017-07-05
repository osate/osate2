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
	
	// Internal. Only used by the DiagramUpdater.
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
