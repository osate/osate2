package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.query.Queryable;

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
	public Collection<DiagramElement> getDiagramElements() {
		return Collections.unmodifiableCollection(elements);
	}
	
	@Override
	public DiagramElementCollection getModifiableDiagramElements() {
		return elements;
	}
	
	@Override
	public DiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return elements.getByRelativeReference(ref);
	}
	
	public void addModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.add(Objects.requireNonNull(listener, "listener must not be null"));
	}
	
	public void removeModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.remove(Objects.requireNonNull(listener, "listener must not be null"));
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
	
	/**
	 * Holds previous values to alllow modifications to be undone.
	 *
	 */
	private static class FieldChange {
		public final DiagramElement element;
		public final DiagramElementField field;
		public final Object previousValue;
		public final Object newValue;
		
		public FieldChange(final DiagramElement element, final DiagramElementField field, final Object previousValue, final Object newValue) {
			this.element = element;
			this.field = field;
			this.previousValue = previousValue;
			this.newValue = newValue;
		}
	}
	
	private class AgeDiagramModification implements DiagramModification {		
		private DiagramElement addedElement;
		private DiagramElement updatedElement;
		private EnumSet<DiagramElementField> updates = EnumSet.noneOf(DiagramElementField.class);
		private DiagramElement removedElement;
		private boolean undoable = true;
		private ArrayList<FieldChange> fieldChanges = new ArrayList<>(); // Used for undoing the modification
		
		@Override
		public void updateBusinessObjectWithSameRelativeReference(final DiagramElement e, final Object bo) {
			e.setBusinessObject(bo);
			// Should listeners be notified?
		}
		
		@Override
		public void setSize(final DiagramElement e, final Dimension value) {
			storeChange(e, DiagramElementField.SIZE, e.getSize(), value);
			e.setSize(value);
			afterUpdate(e, DiagramElementField.SIZE);
		}
				
		@Override
		public void setPosition(final DiagramElement e, final Point value) {
			if(!value.equals(e.getPosition())) { 
				storeChange(e, DiagramElementField.POSITION, e.getPosition(), value);
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
		public void setGraphic(final DiagramElement e, final Graphic value) {
			if(!value.equals(e.getGraphic())) { 
				storeChange(e, DiagramElementField.GRAPHIC, e.getGraphic(), value);
				e.setGraphic(value);
				afterUpdate(e, DiagramElementField.GRAPHIC);
			}
		}
		
		@Override
		public void setDockArea(final DiagramElement e, final DockArea value) {
			if(value != e.getDockArea()) { 
				storeChange(e, DiagramElementField.DOCK_AREA, e.getDockArea(), value);
				e.setDockArea(value);
				afterUpdate(e, DiagramElementField.DOCK_AREA);
			}
		}
		
		@Override
		public void setLabelConfiguration(final DiagramElement e, final AgeLabelConfiguration value) {
			if(value != e.getLabelConfiguration()) { 
				storeChange(e, DiagramElementField.LABEL_CONFIGURATION, e.getLabelConfiguration(), value);
				e.setLabelConfiguration(value);
				afterUpdate(e, DiagramElementField.LABEL_CONFIGURATION);
			}
		}
		
		@Override
		public void setConnectionStart(final DiagramElement e, final DiagramElement value) {
			if(value != e.getStartElement()) {
				storeChange(e, DiagramElementField.CONNECTION_START, e.getStartElement(), value);
				e.setStartElement(value);
				afterUpdate(e, DiagramElementField.CONNECTION_START);
			}
		}
		
		@Override
		public void setConnectionEnd(final DiagramElement e, final DiagramElement value) {
			if(value != e.getEndElement()) {
				storeChange(e, DiagramElementField.CONNECTION_END, e.getEndElement(), value);
				e.setEndElement(value);
				afterUpdate(e, DiagramElementField.CONNECTION_END);
			}
		}
		
		
		@Override
		public void setBendpoints(final DiagramElement e, final List<Point> value) {
			if(!value.equals(e.getBendpoints())) {
				// Make copy of values because lists are not immutable.
				storeChange(e, DiagramElementField.BENDPOINTS, new ArrayList<>(e.getBendpoints()), value == null ? Collections.emptyList() : new ArrayList<>(value));
				e.setBendpoints(value);
				afterUpdate(e, DiagramElementField.BENDPOINTS);
			}
		}		
		
		// Notifies listeners and manages change tracking state after a field has been updated.
		private void afterUpdate(final DiagramElement e, final DiagramElementField c) {
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
		public void removeElement(final DiagramElement e) {
			Objects.requireNonNull(e, "e must not be null");
			
			// Notify listeners of the previous modification
			if(addedElement != null || updatedElement != null || removedElement != null) { 
				notifyListeners();
			}
			
			e.getModifiableContainer().getModifiableDiagramElements().remove(e);			
			removedElement = e;
			undoable = false;
		}
		
		@Override
		public void addElement(final DiagramElement e) {
			// Notify listeners of the previous modification
			if(addedElement != null || updatedElement != null || removedElement != null) { 
				notifyListeners();
			}			
			
			e.getModifiableContainer().getModifiableDiagramElements().add(e);			
			addedElement = e;
			undoable = false;
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
		
		public void undoModification(final DiagramModification modification) {
			if(!modification.isUndoable()) {
				throw new RuntimeException("The modification cannot be undone.");
			}
			
			if(modification instanceof AgeDiagramModification) {
				((AgeDiagramModification) modification).undo(this);
			}
		}
		
		public void redoModification(final DiagramModification modification) {
			if(!modification.isRedoable()) {
				throw new RuntimeException("The modification cannot be redone.");
			}
			
			if(modification instanceof AgeDiagramModification) {
				((AgeDiagramModification) modification).redo(this);
			}
		}		
		
		public boolean isUndoable() {
			return undoable;
		}
		
		public boolean isRedoable() {
			return undoable; // Only commands that can be undone can be redone.
		}
		
		/**
		 * Undoes the current modification. Makes modifications using the modification specified.
		 * @param newModification
		 */
		private void undo(final AgeDiagramModification newModification) {
			for(int i = fieldChanges.size()-1; i >= 0; i--) {
				final FieldChange change = fieldChanges.get(i);
				setValue(newModification, change.element, change.field, change.previousValue);
			}
		}
		
		/**
		 * Undoes the current modification. Makes modifications using the modification specified.
		 * @param newModification
		 */
		private void redo(final AgeDiagramModification newModification) {
			for(final FieldChange change : fieldChanges) {
				setValue(newModification, change.element, change.field, change.newValue);				
			}
		}

		@SuppressWarnings("unchecked")
		private void setValue(final AgeDiagramModification m, final DiagramElement element, final DiagramElementField field, final Object value) {
			switch(field) {
			case BENDPOINTS:
				m.setBendpoints(element, (List<Point>)value);
				break;
				
			case CONNECTION_END:
				m.setConnectionEnd(element, (DiagramElement)value);
				break;
				
			case CONNECTION_START:
				m.setConnectionEnd(element, (DiagramElement)value);
				break;
				
			case DOCK_AREA:
				m.setDockArea(element, (DockArea)value);
				break;
				
			case GRAPHIC:
				m.setGraphic(element, (Graphic)value);
				break;
				
			case LABEL_CONFIGURATION:
				m.setLabelConfiguration(element, (AgeLabelConfiguration)value);
				break;
				
			case POSITION:
				m.setPosition(element, (Point)value);
				break;
				
			case SIZE:
				m.setSize(element, (Dimension)value);
				break;
			}
		}
		
		/**
		 * Stores the current value so that changes can be undone/redone
		 */
		private void storeChange(final DiagramElement element, final DiagramElementField field, final Object currentValue, final Object newValue) {
			fieldChanges.add(new FieldChange(element, field, currentValue, newValue));
		}
	}
	
	private DockArea calculateDockArea(final DiagramElement e) {
		return AgeDiagramUtil.determineDockingPosition(e.getContainer(), e.getX(), e.getY(), e.getWidth(), e.getHeight()).getDockArea();
	}

	@Override
	public Collection<Queryable> getChildren() {
		return Collections.unmodifiableCollection(elements);
	}

	// The diagram has a business object in cases where it's children are logically owned by another object which is not shown.
	@Override
	public Object getBusinessObject() {
		return bo;
	}
	
	public void setBusinessObject(final Object value) {
		this.bo = value;
	}
	
	// TODO: Rework
	private Object bo = null;
}
