/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;

/**
 * A cursor over the declarative segments of one end-to-end flow or one flow implementation.
 * <p>
 * The cursor is the position an end-to-end flow candidate has reached in a declaration. Because a candidate can fork,
 * the cursor has to be copyable: {@link #copy()} returns a second cursor over the same segments at the same position,
 * which is how a fork resumes exactly where its sibling was.
 */
public final class FlowIterator implements Iterator<Element> {

	private final List<? extends Element> segments;

	private int index;

	public FlowIterator(EndToEndFlow ete) {
		this(ete.getAllFlowSegments(), 0);
	}

	public FlowIterator(FlowImplementation flowImpl) {
		this(flowImpl.getOwnedFlowSegments(), 0);
	}

	private FlowIterator(List<? extends Element> segments, int index) {
		this.segments = segments;
		this.index = index;
	}

	@Override
	public boolean hasNext() {
		return index < segments.size();
	}

	@Override
	public Element next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return segments.get(index++);
	}

	FlowIterator copy() {
		return new FlowIterator(segments, index);
	}
}
