package org.osate.ge.internal.diagram;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;

// TODO: Listeners
// TODO: What listener is needed to allow updating the Graphiti diagram in the appropriate order. Want connections to be updated last. 
// TODO: Could be a separate method instead of a listener.

/**
 * This class is the in-memory data structure for the diagram. 
 * Represents the state of the diagram independent of the UI library being used to present the diagram. 
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram implements DiagramElementContainer, ModifiableDiagramElementContainer {
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
	public Collection<AgeDiagramElement> getDiagramElements() {
		return Collections.unmodifiableCollection(elements);
	}
	
	@Override
	public DiagramElementCollection getModifiableDiagramElements() {
		return elements;
	}
	
	@Override
	public AgeDiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return elements.getByRelativeReference(ref);
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
	
	public static interface Modification {
		// TODO: Add parameters
		void addElement(final AgeDiagramElement e);
		void removeElement(final AgeDiagramElement e);
		void updateBusinessObjectWithSameRelativeReference(final AgeDiagramElement e, final Object bo); // TODO: Refresh business object? Require relative reference to match?
		void setGraphic(final AgeDiagramElement e, final Graphic value);
		void setDockArea(final AgeDiagramElement e, final DockArea value);
		void setPosition(final AgeDiagramElement e, final Point value);
		void setSize(final AgeDiagramElement e, final Dimension value);
		void setConnectionStart(final AgeDiagramElement e, final AgeDiagramElement value);
		void setConnectionEnd(final AgeDiagramElement e, final AgeDiagramElement value);
	}
	
	public static interface Modifier {
		void modify(final Modification m);
	}
	
	private class DiagramModification implements Modification {
		@Override
		public void updateBusinessObjectWithSameRelativeReference(final AgeDiagramElement e, final Object bo) {
			e.setBusinessObject(bo);
		}
		
		@Override
		public void setSize(final AgeDiagramElement e, final Dimension value) {
			e.setSize(value);
		}
		
		@Override
		public void setPosition(final AgeDiagramElement e, final Point value) {
			e.setPosition(value);
		}
		
		@Override
		public void setGraphic(final AgeDiagramElement e, final Graphic value) {
			e.setGraphic(value);
		}
		
		@Override
		public void setDockArea(final AgeDiagramElement e, final DockArea value) {
			e.setDockArea(value);
		}
		
		@Override
		public void setConnectionStart(final AgeDiagramElement e, final AgeDiagramElement value) {
			e.setStartElement(value);
		}
		
		@Override
		public void setConnectionEnd(final AgeDiagramElement e, final AgeDiagramElement value) {
			e.setEndElement(value);
		}
		
		@Override
		public void removeElement(final AgeDiagramElement e) {
			e.getModifiableContainer().getModifiableDiagramElements().remove(e);
		}
		
		@Override
		public void addElement(final AgeDiagramElement e) {
			e.getModifiableContainer().getModifiableDiagramElements().add(e);
		}
	}
	
	public void modify(final Modifier modifier) {
		final DiagramModification m = new DiagramModification();
		modifier.modify(m);
	}
}
