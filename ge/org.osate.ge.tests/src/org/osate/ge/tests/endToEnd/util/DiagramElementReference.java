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
