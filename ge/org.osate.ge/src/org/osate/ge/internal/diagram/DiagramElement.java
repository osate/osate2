package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DiagramElement {
	private final DiagramElement parent;
	private final Object bo;
	final List<DiagramElement> children = new ArrayList<DiagramElement>();
	
	public DiagramElement(final AgeDiagram diagram, final Object bo) {
		// Diagram is not used, but this ensured that either a diagram or a parent element is specified.
		Objects.requireNonNull(diagram, "diagram must not be null");
		this.parent = null;
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
	}
	
	public DiagramElement(final DiagramElement parent, final Object bo) {
		this.parent = Objects.requireNonNull(parent, "parent must not be null");
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
	}
	
	/**
	 * Returns unmodifiable children list
	 * @return
	 */
	public List<DiagramElement> getChildren() {
		return Collections.unmodifiableList(children);
	}
	
	/**
	 * Performs a deep copy of an element list. Updates the parent to reflect the element.
	 * @param newParent
	 * @param list
	 * @return
	 */
	static List<DiagramElement> copyList(final DiagramElement newParent, final List<DiagramElement> list) {
		Objects.requireNonNull(list, "list must not be null");
		final List<DiagramElement> newList = new ArrayList<>(list.size());
		for(DiagramElement e : list) {
			final DiagramElement newElement = new DiagramElement(newParent, e.bo);
			newElement.children.addAll(copyList(newElement, e.children));
		}
		
		return newList;
	}
}
