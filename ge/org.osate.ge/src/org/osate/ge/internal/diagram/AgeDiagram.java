package org.osate.ge.internal.diagram;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfiguration;

/**
 * This class is the in-memory data structure for the diagram. 
 * Represents the state of the diagram independent of the UI library being used to present the diagram. 
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram implements DiagramNode, ModifiableDiagramElementContainer {
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
	public DiagramNode getContainer() {
		return null;
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
			// Should listeners be notified?
		}
		
		@Override
		public void setSize(final AgeDiagramElement e, final Dimension value) {
			e.setSize(value);
			afterUpdate(e, DiagramElementField.SIZE);
		}
		
		@Override
		public void setPosition(final AgeDiagramElement e, final Point value) {
			if(!value.equals(e.getPosition())) { 
				e.setPosition(value);
				afterUpdate(e, DiagramElementField.POSITION);
				
				// Update the dock area based on the position
				final DockArea currentDockArea = e.getDockArea();
				if(currentDockArea != null) {
					if(currentDockArea != DockArea.GROUP) {
						setDockArea(e, calculateDockArea(e));
					}
				}
			}
		}
		
		@Override
		public void setGraphic(final AgeDiagramElement e, final Graphic value) {
			if(!value.equals(e.getGraphic())) { 
				e.setGraphic(value);
				afterUpdate(e, DiagramElementField.GRAPHIC);
			}
		}
		
		@Override
		public void setDockArea(final AgeDiagramElement e, final DockArea value) {
			if(value != e.getDockArea()) { 
				e.setDockArea(value);
				afterUpdate(e, DiagramElementField.DOCK_AREA);
			}
		}
		
		@Override
		public void setLabelConfiguration(final AgeDiagramElement e, final AgeLabelConfiguration value) {
			if(value != e.getLabelConfiguration()) { 
				e.setLabelConfiguration(value);
				afterUpdate(e, DiagramElementField.LABEL_CONFIGURATION);
			}
		}
		
		@Override
		public void setConnectionStart(final AgeDiagramElement e, final AgeDiagramElement value) {
			if(value != e.getStartElement()) { 
				e.setStartElement(value);
				afterUpdate(e, DiagramElementField.CONNECTION_START);
			}
		}
		
		@Override
		public void setConnectionEnd(final AgeDiagramElement e, final AgeDiagramElement value) {
			if(value != e.getEndElement()) { 
				e.setEndElement(value);
				afterUpdate(e, DiagramElementField.CONNECTION_END);
			}
		}
		
		
		@Override
		public void setBendpoints(final AgeDiagramElement e, final List<Point> value) {
			if(!value.equals(e.getBendpoints())) {
					e.setBendpoints(value);
				afterUpdate(e, DiagramElementField.BENDPOINTS);
			}
		}
		
		
		// Notifies listeners and manages change tracking state after a field has been updated.
		private void afterUpdate(final AgeDiagramElement e, final DiagramElementField c) {
			// Notify listeners of the previous modification
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
			// Notify listeners of the previous modification
			if(addedElement != null || updatedElement != null || removedElement != null) { 
				notifyListeners();
			}
			
			e.getModifiableContainer().getModifiableDiagramElements().remove(e);			
			removedElement = e;
		}
		
		@Override
		public void addElement(final AgeDiagramElement e) {
			// Notify listeners of the previous modification
			if(addedElement != null || updatedElement != null || removedElement != null) { 
				notifyListeners();
			}			
			
			e.getModifiableContainer().getModifiableDiagramElements().add(e);			
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
		
		private void notifyListeners() {
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
	
	private DockArea calculateDockArea(final AgeDiagramElement e) {
		return determineDockingPosition(e.getContainer(), e.getX(), e.getY(), e.getWidth(), e.getHeight()).getDockArea();
	}
	
	private static DockingPosition determineDockingPosition(final DiagramNode container, final int x, final int y, final int width, final int height) {
		if(!(container instanceof AgeDiagramElement)) {
			return DockingPosition.ANY;
		}		
		
		final AgeDiagramElement containerElement = (AgeDiagramElement)container;
		
		final int distanceToLeft = Math.max(0, x);
		final int distanceToRight = containerElement.getWidth() - Math.min(x + width, containerElement.getWidth());
		final int distanceToTop = Math.max(0, y);
		final int distanceToBottom = containerElement.getHeight() - Math.min(y + height, containerElement.getHeight());

		// Find the closest dock area while giving priority to the left, right, top, and bottom.
		if(distanceToLeft <= distanceToRight && distanceToLeft <= distanceToTop && distanceToLeft <= distanceToBottom) {
			return DockingPosition.LEFT;
		} else if(distanceToRight <= distanceToTop && distanceToRight <= distanceToBottom) {
			return DockingPosition.RIGHT;
		} else if(distanceToTop <= distanceToBottom) {
			return DockingPosition.TOP;
		} else {
			return DockingPosition.BOTTOM;
		}
	}
}
