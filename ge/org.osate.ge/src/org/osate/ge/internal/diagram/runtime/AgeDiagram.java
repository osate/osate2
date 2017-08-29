package org.osate.ge.internal.diagram.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.osate.ge.graphics.Style;
import org.osate.ge.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.diagram.runtime.DiagramTransactionHandler.TransactionOperation;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.query.Queryable;

/**
 * This class is the in-memory data structure for the diagram.
 * Represents the state of the diagram independent of the UI library being used to present the diagram.
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram implements DiagramNode, ModifiableDiagramElementContainer {
	private final List<DiagramModificationListener> modificationListeners = new CopyOnWriteArrayList<>();
	private long maxElementId; // Next automatically assigned element id
	private DiagramConfiguration diagramConfiguration;
	private final DiagramElementCollection elements = new DiagramElementCollection();
	private DiagramTransactionHandler transactionHandler;
	private DiagramModification currentModification;

	/**
	 *
	 * @param startingElementId is the id of the first diagram element which has an id automatically assigned to it.
	 */
	public AgeDiagram(final long startingElementId) {
		this.diagramConfiguration = new DiagramConfiguration(null, Collections.emptySet());
		this.maxElementId = startingElementId-1; // The max element id is set to the specified value - 1 because the value is incremented before it is assigned as an id.
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

	public long getMaxElementId() {
		return maxElementId;
	}

	public void addModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.add(Objects.requireNonNull(listener, "listener must not be null"));
	}

	public void removeModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.remove(Objects.requireNonNull(listener, "listener must not be null"));
	}

	public void setTransactionHandler(final DiagramTransactionHandler value) {
		if(transactionHandler != null && value != null) {
			throw new RuntimeException("Transaction handler already set");
		}
		this.transactionHandler = value;
	}

	public synchronized void modify(final String label, final DiagramModifier modifier) {
		final boolean modificationInProgress = currentModification != null;
		if(modificationInProgress) {
			modifier.modify(currentModification);
		} else {
			try {
				final AgeDiagramModification m = new AgeDiagramModification();
				currentModification = m;

				// If a transaction handler is set, use it to run the modification
				if(transactionHandler != null) {
					transactionHandler.modify(label, new TransactionOperation() {
						@Override
						public void run() {
							runModification(modifier, m);
						}

						@Override
						public void undo() {
							modify("Undo " + label, newMod -> {
								newMod.undoModification(m);
							});
						}

						@Override
						public boolean canUndo() {
							return m.isUndoable();
						}

						@Override
						public void redo() {
							modify("Redo " + label, newMod -> newMod.redoModification(m));
						}
					});
				} else {
					runModification(modifier, m);
				}
			} finally {
				currentModification = null;
			}
		}
	}

	private static void runModification(final DiagramModifier modifier, final AgeDiagramModification m) {
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
		public void updateBusinessObject(final DiagramElement e, final Object bo, final RelativeBusinessObjectReference relativeReference) {
			storeChange(e, DiagramElementField.RELATIVE_REFERENCE, e.getRelativeReference(), relativeReference);

			Objects.requireNonNull(e, "e must not be null");
			Objects.requireNonNull(bo, "bo must not be null");
			Objects.requireNonNull(relativeReference, "relativeReference must not be null");

			e.getModifiableContainer().getModifiableDiagramElements().remove(e);
			e.setBusinessObject(bo);
			e.setRelativeReference(relativeReference);
			e.getModifiableContainer().getModifiableDiagramElements().add(e);

			updatedElement = e;
			undoable = false;
			afterUpdate(e, DiagramElementField.RELATIVE_REFERENCE);
		}

		@Override
		public void updateBusinessObjectWithSameRelativeReference(final DiagramElement e, final Object bo) {
			e.setBusinessObject(bo);
			// Do not notify listeners
		}

		@Override
		public void setBusinessObjectHandler(final DiagramElement e, final Object boh) {
			e.setBusinessObjectHandler(boh);
			// Do not notify listeners
		}

		@Override
		public void setId(final DiagramElement e, final Long value) {
			if(value == null && !e.hasId()) {
				return;
			}

			if(value == null || !value.equals(e.getId())) {
				storeChange(e, DiagramElementField.ID, e.getId(), value);
				e.setId(value);
				afterUpdate(e, DiagramElementField.ID);
			}
		}

		@Override
		public void setManual(final DiagramElement e, final boolean value) {
			if(value != e.isManual()) {
				storeChange(e, DiagramElementField.MANUAL, e.isManual(), value);
				e.setManual(value);
				afterUpdate(e, DiagramElementField.MANUAL);
			}
		}

		@Override
		public void setAutoContentsFilter(final DiagramElement e, final ContentsFilter value) {
			if(value == null && e.getAutoContentsFilter() == null) {
				return;
			}

			if(value == null || !value.equals(e.getAutoContentsFilter())) {
				storeChange(e, DiagramElementField.AUTO_CONTENTS_FILTER, e.getAutoContentsFilter(), value);
				e.setAutoContentsFilter(value);
				afterUpdate(e, DiagramElementField.AUTO_CONTENTS_FILTER);
			}
		}

		@Override
		public void setCompleteness(final DiagramElement e, final Completeness value) {
			if(!value.equals(e.getCompleteness())) {
				storeChange(e, DiagramElementField.COMPLETENESS, e.getCompleteness(), value);
				e.setCompleteness(value);
				afterUpdate(e, DiagramElementField.COMPLETENESS);
			}
		}

		@Override
		public void setName(final DiagramElement e, final String value) {
			if(value == null && e.getName() == null) {
				return;
			}

			if(value == null || !value.equals(e.getName())) {
				storeChange(e, DiagramElementField.NAME, e.getName(), value);
				e.setName(value);
				afterUpdate(e, DiagramElementField.NAME);
			}
		}

		@Override
		public void setSize(final DiagramElement e, final Dimension value) {
			if(value == null && e.getSize() == null) {
				return;
			}

			if(value == null || !value.equals(e.getSize())) {
				storeChange(e, DiagramElementField.SIZE, e.getSize(), value);
				e.setSize(value);
				afterUpdate(e, DiagramElementField.SIZE);
			}
		}

		@Override
		public void setPosition(final DiagramElement e, final Point value) {
			if(!value.equals(e.getPosition())) {
				// Determine the different between X and Y
				final int dx = value.x - e.getX();
				final int dy = value.y - e.getY();

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

				updateBendpointsForContainedConnections(e, dx, dy);
			}
		}

		private void updateBendpointsForContainedConnections(final DiagramElement shapeDiagramElement, final int dx,
				final int dy) {
			for (final DiagramElement child : shapeDiagramElement.getDiagramElements()) {
				if (child.getGraphic() instanceof AgeConnection) {
					final List<Point> bendpoints = child.getBendpoints();
					if (bendpoints.size() > 0) {
						final List<Point> newBendpoints = bendpoints.stream().map((p) -> new Point(p.x + dx, p.y + dy))
								.collect(Collectors.toList());
						setBendpoints(child, newBendpoints);
					}
				}

				updateBendpointsForContainedConnections(child, dx, dy);
			}
		}

		@Override
		public void setGraphicalConfiguration(final DiagramElement e, final AgeGraphicalConfiguration value) {
			if(!value.equals(e.getGraphicalConfiguration())) {
				storeChange(e, DiagramElementField.GRAPHICAL_CONFIGURATION, e.getGraphicalConfiguration(), value);
				e.setGraphicalConfiguration(value);
				afterUpdate(e, DiagramElementField.GRAPHICAL_CONFIGURATION);
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
		public void setBendpoints(final DiagramElement e, final List<Point> value) {
			if(!value.equals(e.getBendpoints())) {
				// Make copy of values because lists are not immutable.
				storeChange(e, DiagramElementField.BENDPOINTS, new ArrayList<>(e.getBendpoints()), value == null ? Collections.emptyList() : new ArrayList<>(value));
				e.setBendpoints(value);
				afterUpdate(e, DiagramElementField.BENDPOINTS);
			}
		}

		@Override
		public void setConnectionPrimaryLabelPosition(final DiagramElement e, final Point value) {
			if(value == null && e.getConnectionPrimaryLabelPosition() == null) {
				return;
			}

			if(value == null || !value.equals(e.getConnectionPrimaryLabelPosition())) {
				storeChange(e, DiagramElementField.CONNECTION_PRIMARY_LABEL_POSITION, e.getConnectionPrimaryLabelPosition(), value);
				e.setConnectionPrimaryLabelPosition(value);
				afterUpdate(e, DiagramElementField.CONNECTION_PRIMARY_LABEL_POSITION);
			}
		}

		@Override
		public void setStyle(final DiagramElement e, final Style value) {
			storeChange(e, DiagramElementField.STYLE, e.getStyle(), value);
			e.setStyle(value);
			afterUpdate(e, DiagramElementField.STYLE);
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

			// Assign the id
			if(e.hasId()) {
				maxElementId = Math.max(e.getId(), maxElementId);
			} else {
				maxElementId++;
				e.setId(maxElementId);
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
				final BeforeModificationsCompletedEvent beforeCompletedEvent = new BeforeModificationsCompletedEvent(
						AgeDiagram.this, this);
				for (final DiagramModificationListener ml : modificationListeners) {
					ml.beforeModificationsCompleted(beforeCompletedEvent);
				}

				final ModificationsCompletedEvent completedEvent = new ModificationsCompletedEvent(AgeDiagram.this);
				for(final DiagramModificationListener ml : modificationListeners) {
					ml.modificationsCompleted(completedEvent);
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

		@Override
		public void undoModification(final DiagramModification modification) {
			if(!modification.isUndoable()) {
				throw new RuntimeException("The modification cannot be undone.");
			}

			if(modification instanceof AgeDiagramModification) {
				((AgeDiagramModification) modification).undo(this);
			}
		}

		@Override
		public void redoModification(final DiagramModification modification) {
			if(!modification.isRedoable()) {
				throw new RuntimeException("The modification cannot be redone.");
			}

			if(modification instanceof AgeDiagramModification) {
				((AgeDiagramModification) modification).redo(this);
			}
		}

		@Override
		public boolean isUndoable() {
			return undoable;
		}

		@Override
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
			case ID:
				m.setId(element, (Long)value);
				break;

			case MANUAL:
				m.setManual(element, (boolean)value);
				break;

			case AUTO_CONTENTS_FILTER:
				m.setAutoContentsFilter(element, (ContentsFilter)value);
				break;

			case COMPLETENESS:
				m.setCompleteness(element, (Completeness)value);
				break;

			case NAME:
				m.setName(element, (String)value);
				break;

			case BENDPOINTS:
				m.setBendpoints(element, (List<Point>)value);
				break;

			case DOCK_AREA:
				m.setDockArea(element, (DockArea)value);
				break;

			case GRAPHICAL_CONFIGURATION:
				m.setGraphicalConfiguration(element, (AgeGraphicalConfiguration)value);
				break;

			case POSITION:
				m.setPosition(element, (Point)value);
				break;

			case SIZE:
				m.setSize(element, (Dimension)value);
				break;

			case CONNECTION_PRIMARY_LABEL_POSITION:
				m.setConnectionPrimaryLabelPosition(element, (Point)value);
				break;

			case STYLE:
				m.setStyle(element, (Style)value);
				break;

			case RELATIVE_REFERENCE:
				throw new RuntimeException("Setting the relative reference is not undoable");
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

	// The diagram does not have a business object. However, the diagram configuration may provide a business object to scope the diagram.
	@Override
	public Object getBusinessObject() {
		return null;
	}

	public DiagramElement findElementById(final long id) {
		return findDescendantById(this, id);
	}

	private static DiagramElement findDescendantById(final DiagramNode container, final long id) {
		for(final DiagramElement child : container.getDiagramElements()) {
			if(child.hasId() && id == child.getId()) {
				return child;
			}

			final DiagramElement result = findDescendantById(child, id);
			if(result != null) {
				return result;
			}
		}

		return null;
	}
}
