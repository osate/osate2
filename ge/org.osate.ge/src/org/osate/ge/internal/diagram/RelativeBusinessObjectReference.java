package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Immutable data type for relative references to a business object. 
 * A relative reference along with a containing diagram element must uniquely identify the business object.
 */
public class RelativeBusinessObjectReference {
	private List<String> segments;

	/**
	 * Creates a relative reference from an array of segments. Segments are case insensitive.
	 * @param reference
	 */
	public RelativeBusinessObjectReference(final String... reference) {
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
		
		final RelativeBusinessObjectReference other = (RelativeBusinessObjectReference) obj;
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
}
