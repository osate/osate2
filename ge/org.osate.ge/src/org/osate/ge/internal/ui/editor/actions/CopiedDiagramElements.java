package org.osate.ge.internal.ui.editor.actions;

import java.util.Objects;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

/**
 * Class for the object stored on the clipboard to represent a collection of copied diagram elements.
 *
 */
public class CopiedDiagramElements {
	private final ImmutableList<CopiedDiagramElement> diagramElements;

	public CopiedDiagramElements(final ImmutableList<CopiedDiagramElement> diagramElements) {
		this.diagramElements = Objects.requireNonNull(diagramElements, "diagramElements must not be null");
	}

	public ImmutableCollection<CopiedDiagramElement> getCopiedDiagramElements() {
		return diagramElements;
	}
}