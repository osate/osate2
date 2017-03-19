package org.osate.ge.internal.diagram;

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
class DiagramElementCollection extends AbstractCollection<AgeDiagramElement> {
	private Map<RelativeBusinessObjectReference, AgeDiagramElement> relativeReferenceToDiagramElementMap; // Initialized lazily.
	
	// Internal. Only used by the DiagramUpdater.
	@Override
	public boolean add(final AgeDiagramElement e) {
		if(relativeReferenceToDiagramElementMap == null) {
			relativeReferenceToDiagramElementMap = new ConcurrentHashMap<>(16, 0.75f, 1);
		}
		
		return relativeReferenceToDiagramElementMap.put(e.getRelativeReference(), e) != e;
	}
	
	@Override
	public boolean remove(final Object o) {
		return remove((AgeDiagramElement)o);
	}
	
	public boolean remove(final AgeDiagramElement e) {
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
	public Iterator<AgeDiagramElement> iterator() {
		final Collection<AgeDiagramElement> c = relativeReferenceToDiagramElementMap == null ? Collections.emptyList() : relativeReferenceToDiagramElementMap.values(); 
		return c.iterator();
	}
	
	public AgeDiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return relativeReferenceToDiagramElementMap == null ? null : relativeReferenceToDiagramElementMap.get(ref);
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		toString(sb, "");
		return sb.toString();
	}
	
	void toString(final StringBuilder sb, final String indention) {
		for(final AgeDiagramElement e : this) {
			e.toString(sb, indention);
		}
	}
}
