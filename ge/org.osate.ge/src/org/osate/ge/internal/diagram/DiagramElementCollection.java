package org.osate.ge.internal.diagram;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

// TODO: Need access to diagram to update listeners. TODO: Need access to owner too? Should listeners be on the updater or the collection. Consider things later..
// TODO: If listeners are on the other side, it makes things easier...
/**
 * A collection of diagram elements. A diagram element may only be added to the collection once.
 *
 */
public class DiagramElementCollection extends AbstractCollection<DiagramElement> {
	private final Map<RelativeBusinessObjectReference, DiagramElement> relativeReferenceToDiagramElementMap = new HashMap<>();

	// Internal. Only used by the DiagramUpdater.
	@Override
	public boolean add(final DiagramElement e) {
		return relativeReferenceToDiagramElementMap.put(e.getRelativeReference(), e) != e;
	}
	
	// TODO: Will need notifications on remove to allow for ghosting, etc.
	@Override
	public int size() {
		return relativeReferenceToDiagramElementMap.size();
	}
	
	// TODO: If notifications are not implemented, get rid of the custom iterator.
	private class DiagramElementIterator implements Iterator<DiagramElement> {
		private final Iterator<DiagramElement> innerIterator;
		
		public DiagramElementIterator(final Iterator<DiagramElement> innerIterator) {
			this.innerIterator = Objects.requireNonNull(innerIterator, "innerIterator must not be null");
		}
		
		@Override
		public boolean hasNext() {
			return innerIterator.hasNext();
		}

		@Override
		public DiagramElement next() {
			return innerIterator.next();
		}
		
		@Override
		public void remove() {
			// TODO: Notificatons as appropriate.
			innerIterator.remove();
		}
	}

	/**
	 * Iterator does not allow modification. 
	 */
	@Override
	public Iterator<DiagramElement> iterator() {
		return new DiagramElementIterator(relativeReferenceToDiagramElementMap.values().iterator());
	}
	
	public DiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return relativeReferenceToDiagramElementMap.get(ref);
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
