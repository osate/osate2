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
package org.osate.ge;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.ImmutableList;

/**
 * Immutable data type for relative references to a business object.
 * A relative reference along with a containing diagram element must uniquely identify the business object.
 * @since 2.0
 */
public class RelativeBusinessObjectReference implements Comparable<RelativeBusinessObjectReference> {
	private ImmutableList<String> segments;
	private ImmutableList<String> lcSegments; // Lowercase segments. Used for comparison.

	/**
	 * Creates an instance from an array of segments. Segments are case insensitive. Throws an exception is optional or if the segments
	 * array is null or empty.
	 * @param segments is an array of segments that makes up the reference.
	 */
	public RelativeBusinessObjectReference(final String... segments) {
		if (segments == null || segments.length < 1) {
			throw new RuntimeException("segments must contain at least one segment");
		}

		// Check that all segments are non-null
		for (final String seg : segments) {
			if (seg == null) {
				throw new RuntimeException("segment is null");
			}
		}

		// Store segments and lower case segments in separate lists. The lowercase segments are used for comparison while the other list is used to preserve
		// case for serialization.
		this.segments = ImmutableList.copyOf(segments);
		this.lcSegments = this.segments.stream().map(s -> s.toLowerCase(Locale.ROOT))
				.collect(ImmutableList.toImmutableList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lcSegments == null) ? 0 : lcSegments.hashCode());
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
		if (!lcSegments.equals(other.lcSegments)) {
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
		for (int i = 0; i < lcSegments.size(); i++) {
			// Check that the reference with which this is being compared to has at least the current number of segments.
			if (o.lcSegments.size() <= i) {
				return -1;
			}

			final int result = lcSegments.get(i).compareTo(o.lcSegments.get(i));
			if(result != 0) {
				return result;
			}
		}

		return 0;
	}

	/**
	 * Returns an unmodifiable list containing the segments.
	 * @return
	 */
	public List<String> getSegments() {
		return segments;
	}

	public org.osate.ge.diagram.RelativeBusinessObjectReference toMetamodel() {
		final org.osate.ge.diagram.RelativeBusinessObjectReference newValue = new org.osate.ge.diagram.RelativeBusinessObjectReference();
		for(final String seg : segments) {
			newValue.getSeg().add(seg);
		}
		return newValue;
	}
}
