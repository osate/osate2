package org.osate.ge.internal.graphiti.diagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

// TODO: Rename InternalType?
public class GraphitiDiagramElement {
	private final GraphitiDiagramElement parent;
	private final PictogramElement pe;
	private final List<GraphitiDiagramElement> children = new ArrayList<GraphitiDiagramElement>();
	
	public GraphitiDiagramElement(final GraphitiDiagramElement parent, final PictogramElement pe) {
		this.parent = Objects.requireNonNull(parent, "parent must not be null");
		this.pe = Objects.requireNonNull(pe, "pe must not be null");
	}
}
