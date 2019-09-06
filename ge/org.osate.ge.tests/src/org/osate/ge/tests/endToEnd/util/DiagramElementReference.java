package org.osate.ge.tests.endToEnd.util;

import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

import com.google.common.collect.ImmutableList;

public class DiagramElementReference {
	private final ImmutableList<RelativeBusinessObjectReference> pathToElement;

	public DiagramElementReference(final RelativeBusinessObjectReference... pathToElement) {
		this.pathToElement = ImmutableList.copyOf(pathToElement);
	}

	// TODO: Rename. Should be immutable list?
	public RelativeBusinessObjectReference[] getRelativeReferences() {
		return pathToElement.toArray(c -> new RelativeBusinessObjectReference[c]);
	}
}
