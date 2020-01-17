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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Immutable data type for relative references to a business object.
 * A relative reference along with a containing diagram element must uniquely identify the business object.
 */
public class RelativeBusinessObjectReference implements Comparable<RelativeBusinessObjectReference> {
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

	/**
	 * Creates a RelativeBusinessObjectReference from a segment array. Returns null if the segment array or any of the segments is null.
	 */
	public static RelativeBusinessObjectReference fromNullableSegments(final String[] segments) {
		if (segments == null) {
			return null;
		}

		// Return null if any segments are null
		for (final String seg : segments) {
			if (seg == null) {
				return null;
			}
		}

		return new RelativeBusinessObjectReference(segments);
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

	@Override
	public int compareTo(final RelativeBusinessObjectReference o) {
		for(int i = 0; i < segments.size(); i++) {
			// Check that the reference with which this is being compared to has at least the current number of segments.
			if(o.segments.size() <= i) {
				return -1;
			}

			final int result = segments.get(i).compareTo(o.segments.get(i));
			if(result != 0) {
				return result;
			}
		}

		return 0;
	}

	/**
	 * Returns an unmodifiable list containing the segments. All segments will be lowercase.
	 * @return
	 */
	public List<String> getSegments() {
		return segments;
	}

	/**
	 * Returns an array of segments. All segments will be lowercase.
	 * @return
	 */
	public String[] toSegmentArray() {
		return segments.toArray(new String[segments.size()]);
	}

	public org.osate.ge.diagram.RelativeBusinessObjectReference toMetamodel() {
		final org.osate.ge.diagram.RelativeBusinessObjectReference newValue = new org.osate.ge.diagram.RelativeBusinessObjectReference();
		for(final String seg : segments) {
			newValue.getSeg().add(seg);
		}
		return newValue;
	}
}
