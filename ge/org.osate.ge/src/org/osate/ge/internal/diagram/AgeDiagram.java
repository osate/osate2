package org.osate.ge.internal.diagram;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;

/**
 * This class is the in-memory data structure for the diagram. 
 * Represents the state of the diagram independent of the UI library being used to present the diagram. 
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram implements DiagramElementContainer, ModifiableDiagramElementContainer {
	private final List<DiagramModificationListener> modificationListeners = new CopyOnWriteArrayList<>();
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
	
	public void addModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.add(Objects.requireNonNull(listener, "listener must not be null"));
	}		
	
	public void modify(final DiagramModifier modifier) {
		final AgeDiagramModification m = new AgeDiagramModification();
		modifier.modify(m);
		m.completeModification();
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
	
	private class AgeDiagramModification implements DiagramModification {
		private AgeDiagramElement addedElement;
		private AgeDiagramElement updatedElement;
		private EnumSet<DiagramElementField> updates = EnumSet.noneOf(DiagramElementField.class);
		private AgeDiagramElement removedElement;
		
		@Override
		public void updateBusinessObjectWithSameRelativeReference(final AgeDiagramElement e, final Object bo) {
			e.setBusinessObject(bo);
			// TODO: Decide whether an update notification is needed.
		}
		
		@Override
		public void setSize(final AgeDiagramElement e, final Dimension value) {
			e.setSize(value);
			afterUpdate(e, DiagramElementField.SIZE);
		}
		
		@Override
		public void setPosition(final AgeDiagramElement e, final Point value) {
			e.setPosition(value);
			afterUpdate(e, DiagramElementField.POSITION);
		}
		
		@Override
		public void setGraphic(final AgeDiagramElement e, final Graphic value) {
			e.setGraphic(value);
			afterUpdate(e, DiagramElementField.GRAPHIC);
		}
		
		@Override
		public void setDockArea(final AgeDiagramElement e, final DockArea value) {
			e.setDockArea(value);
			afterUpdate(e, DiagramElementField.DOCK_AREA);
		}
		
		@Override
		public void setConnectionStart(final AgeDiagramElement e, final AgeDiagramElement value) {
			e.setStartElement(value);
			afterUpdate(e, DiagramElementField.CONNECTION_START);
		}
		
		@Override
		public void setConnectionEnd(final AgeDiagramElement e, final AgeDiagramElement value) {
			e.setEndElement(value);
			afterUpdate(e, DiagramElementField.CONNECTION_END);			
		}
		
		// Notifies listeners and manages change tracking state after a field has been updated.
		private void afterUpdate(final AgeDiagramElement e, final DiagramElementField c) {
			if((addedElement != null && addedElement != e) ||
				(updatedElement != null && updatedElement != e) ||
				removedElement != null) { 
				notifyListeners();
			}
			
			// Don't track updates on an element that has a pending add event
			if(addedElement != e) {
				updatedElement = e;
				updates.add(c);
			}
		}
		
		@Override
		public void removeElement(final AgeDiagramElement e) {
			e.getModifiableContainer().getModifiableDiagramElements().remove(e);
			if(addedElement != null || updatedElement != null || removedElement != null) { 
				notifyListeners();
			}
			
			removedElement = e;
		}
		
		@Override
		public void addElement(final AgeDiagramElement e) {
			e.getModifiableContainer().getModifiableDiagramElements().add(e);			
			if(addedElement != null || updatedElement != null || removedElement != null) { 
				notifyListeners();
			}
			
			addedElement = e;
		}
		
		private void completeModification() {
			// Send any pending events
			notifyListeners();
			
			// Send the modifications complete event
			if(modificationListeners.size() > 0) {
				final ModificationsCompletedEvent event = new ModificationsCompletedEvent(AgeDiagram.this);
				for(final DiagramModificationListener ml : modificationListeners) {
					ml.modificationsCompleted(event);
				}
			}			
		}
		
		// TODO: Needs to be called on modification finish.
		private void notifyListeners() {
			// TODO: Should wait until other changes
			// Notify Listeners
			if(modificationListeners.size() > 0) {
				if(addedElement != null) {
					final ElementAddedEvent event = new ElementAddedEvent(addedElement);
					for(final DiagramModificationListener ml : modificationListeners) {
						ml.elementAdded(event);
					}
					
					addedElement = null;
				}
				
				if(updatedElement != null) {
					final ElementUpdatedEvent event = new ElementUpdatedEvent(updatedElement, updates);
					for(final DiagramModificationListener ml : modificationListeners) {
						ml.elementUpdated(event);
					}
					
					updatedElement = null;
					updates.clear();
				}
				
				if(removedElement != null) {
					final ElementRemovedEvent event = new ElementRemovedEvent(removedElement);
					for(final DiagramModificationListener ml : modificationListeners) {
						ml.elementRemoved(event);
					}
					
					removedElement = null;
				}
			}
		}
	}
}
