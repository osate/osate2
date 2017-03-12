package org.osate.ge.internal.diagram;

import java.util.Objects;

// TODO: Listeners
// TODO: What listener is needed to allow updating the Graphiti diagram in the appropriate order. Want connections to be updated last. 
// TODO: Could be a separate method instead of a listener.

/**
 * Model class for the OSATE Graphical Editor diagram. 
 * Represents the state of the diagram independent of the library being used to present the diagram. 
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram implements DiagramElementContainer {
	private DiagramConfiguration diagramConfiguration;
	private final DiagramElementCollection elements = new DiagramElementCollection();

	public AgeDiagram() {
		this.diagramConfiguration = new DiagramConfiguration(null);
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

	@Override
	public DiagramElementCollection getDiagramElements() {
		return elements;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		String indention = "\t";
		sb.append("{");
		sb.append(System.lineSeparator());
		
		sb.append(indention);
		sb.append("diagram configuration: ");
		sb.append(diagramConfiguration);
		sb.append(System.lineSeparator());
		
		if(elements.size() > 0) {		
			elements.toString(sb, indention);
		}
		
		sb.append("}");

		return sb.toString();
	}
}
