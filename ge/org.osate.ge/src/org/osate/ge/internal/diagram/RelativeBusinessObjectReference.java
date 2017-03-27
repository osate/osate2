package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TODO: Should have a variable argument constructor?
public class RelativeBusinessObjectReference {
	private List<String> segments;
	
	public RelativeBusinessObjectReference(final String... reference) {
		if(reference == null || reference.length < 1) {
			throw new RuntimeException("reference must contain at least one segment");
		}
		
		this.segments = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(reference)));
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
		// TODO: Do this without converting to array
		return Arrays.toString(segments.toArray());
	}
}
