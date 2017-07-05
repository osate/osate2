package org.osate.ge.internal.diagram.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Immutable data type for canonical references to a business object. 
 * A canonical reference uniquely identifies a business object.
 *
 */
public class CanonicalBusinessObjectReference {
	private List<String> segments;
	
	/**
	 * Creates a canonical reference from an array of segments. Segments are case insensitive.
	 * @param reference
	 */
	public CanonicalBusinessObjectReference(final String... reference) {
		if(reference == null || reference.length < 1) {
			throw new RuntimeException("reference must contain at least one segment");
		}
		
		// Copy segments into a new list and covert all segments to lower case
		final List<String> segmentCopy = new ArrayList<>(reference.length);
		for(int i = 0 ; i < reference.length; i++) {
			segmentCopy.add(reference[i].toLowerCase());
		}
		
		// Store an unmodifiable list of segments
		this.segments = Collections.unmodifiableList(segmentCopy);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((segments == null) ? 0 : segments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		final CanonicalBusinessObjectReference other = (CanonicalBusinessObjectReference)obj;
		if (segments == null) {
			if (other.segments != null) {
				return false;
			}
		} else if (!segments.equals(other.segments)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(segments.toArray());
	}
	
	/**
	 * Returns an array of segments. All segments will be lowercase.
	 * @return
	 */
	public String[] toSegmentArray() {
		return segments.toArray(new String[segments.size()]);
	}
	
	public org.osate.ge.diagram.CanonicalBusinessObjectReference toMetamodel() {
		final org.osate.ge.diagram.CanonicalBusinessObjectReference newValue = new org.osate.ge.diagram.CanonicalBusinessObjectReference();
		for(final String seg : segments) {
			newValue.getSeg().add(seg);
		}
		return newValue;
	}
}
