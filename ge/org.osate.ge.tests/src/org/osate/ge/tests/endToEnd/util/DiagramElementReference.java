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
package org.osate.ge.tests.endToEnd.util;

import java.util.stream.Collectors;

import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

import com.google.common.collect.ImmutableList;

public class DiagramElementReference {
	public final ImmutableList<RelativeBusinessObjectReference> pathToElement;

	public DiagramElementReference(final RelativeBusinessObjectReference... pathToElement) {
		this.pathToElement = ImmutableList.copyOf(pathToElement);
	}

	public DiagramElementReference(final ImmutableList<RelativeBusinessObjectReference> pathToElement) {
		this.pathToElement = pathToElement;
	}

	/**
	 * Builds a new element reference by adding a relative reference to the current reference
	 */
	public DiagramElementReference join(final RelativeBusinessObjectReference toAdd) {
		return new DiagramElementReference(
				new ImmutableList.Builder<RelativeBusinessObjectReference>().addAll(pathToElement).add(toAdd).build());
	}

	@Override
	public String toString() {
		return "[" + pathToElement.stream().map(r -> r.toString()).collect(Collectors.joining(",")) + "]";
	}

	public static DiagramElementReference fromDiagramElement(final DiagramElement element) {
		final ImmutableList.Builder<RelativeBusinessObjectReference> builder = new ImmutableList.Builder<RelativeBusinessObjectReference>();
		addReferenceToBuilder(builder, element);
		return new DiagramElementReference(builder.build());
	}

	private static void addReferenceToBuilder(final ImmutableList.Builder<RelativeBusinessObjectReference> builder, final DiagramElement element) {
		if(element != null) {
			final DiagramNode parent = element.getParent();
			if(parent instanceof DiagramElement) {
				addReferenceToBuilder(builder, (DiagramElement)parent);
			}
			builder.add(element.getRelativeReference());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pathToElement == null) ? 0 : pathToElement.hashCode());
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
		DiagramElementReference other = (DiagramElementReference) obj;
		if (pathToElement == null) {
			if (other.pathToElement != null) {
				return false;
			}
		} else if (!pathToElement.equals(other.pathToElement)) {
			return false;
		}
		return true;
	}
}
