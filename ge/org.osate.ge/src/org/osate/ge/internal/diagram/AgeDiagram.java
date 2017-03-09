package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AgeDiagram {
	private DiagramConfiguration diagramConfiguration;
	final List<DiagramElement> elements;
	
	public AgeDiagram() {
		this.diagramConfiguration = new DiagramConfiguration(null);
		this.elements = new ArrayList<DiagramElement>();
	}
	
	public AgeDiagram(final AgeDiagram diagram) {
		this.diagramConfiguration = diagram.diagramConfiguration;
		this.elements = DiagramElement.copyList(null, diagram.getElements());		
	}
	
	/**
	 * Sets the diagram configuration.
	 * @param diagramConfiguration
	 */
	public void setDiagramConfiguration(final DiagramConfiguration diagramConfiguration) {
		this.diagramConfiguration = Objects.requireNonNull(diagramConfiguration, "diagramConfiguration must not be null");
	}
	
	/**
	 * Returns a copy of the diagram configuration
	 * @return
	 */
	public DiagramConfiguration getConfiguration() {
		return diagramConfiguration;
	}
	
	public List<DiagramElement> getElements() {
		return Collections.unmodifiableList(elements);
	}
}
