package org.osate.ge.internal.diagram.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.types.CustomDiagramType;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.impl.SimpleActionExecutor;

import com.google.common.collect.Lists;

/**
 * This class is the in-memory data structure for the diagram.
 * Represents the state of the diagram independent of the UI library being used to present the diagram.
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram implements DiagramNode, ModifiableDiagramElementContainer {
	private final List<DiagramModificationListener> modificationListeners = new CopyOnWriteArrayList<>();
	private DiagramConfiguration diagramConfiguration;
	private final DiagramElementCollection elements = new DiagramElementCollection();
	private ActionExecutor actionExecutor = new SimpleActionExecutor();
	private boolean actionExecutorSet = false;
	private DiagramModification currentModification;

	// Incrementing number that is not persisted which indicates a change that would affect the persisted version of the diagram.
	// Used to determine whether a diagram is "dirty"
	private int changeNumber = 0;

	/**
	 *
	 * @param startingElementId is the id of the first diagram element which has an id automatically assigned to it.
	 */
	public AgeDiagram() {
		this.diagramConfiguration = new DiagramConfiguration(new CustomDiagramType(), null, Collections.emptySet(),
				true);
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

	/**
	 * Sets the action executor to be used when performing modifications.
	 * Must be set at most once. An exception will be thrown if this method is called more than once.
	 * If the action executor is not set, a default action executor which simply executes the action will be used.
	 * @param actionExecutor
	 */
	public void setActionExecutor(final ActionExecutor actionExecutor) {
		if (actionExecutorSet) {
			throw new RuntimeException("The action executor for the diagram must not be set multiple times");
		}

		this.actionExecutor = Objects.requireNonNull(actionExecutor, "actionExecutor must not be null");
		actionExecutorSet = true;
	}

	/**
	 * Calls a modifier to modify the diagram. The current action executor will be used to execute the modification.
	 * @param label
	 * @param modifier
	 */
	public synchronized void modify(final String label, final DiagramModifier modifier) {
		final boolean modificationInProgress = currentModification != null;
		if (modificationInProgress) {
			modifier.modify(currentModification);
		} else {
			try {
				final AgeDiagramModification m = new AgeDiagramModification();
				currentModification = m;
				actionExecutor.execute(label, ActionExecutor.ExecutionMode.NORMAL,
						new AgeDiagramModificationAction(this, m, modifier));
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

		if (elements.size() > 0) {
			elements.toString(sb, indention);
		}

		sb.append("}");

		return sb.toString();
	}

	private DockArea calculateDockArea(final DiagramElement e) {
		return AgeDiagramUtil
				.determineDockingPosition(e.getContainer(), e.getX(), e.getY(), e.getWidth(), e.getHeight())
				.getDefaultDockArea();
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

	public DiagramElement findElementById(final UUID id) {
		return findDescendantById(this, id);
	}

	public int getCurrentChangeNumber() {
		return changeNumber;
	}

	private static DiagramElement findDescendantById(final DiagramNode container, final UUID id) {
		for (final DiagramElement child : container.getDiagramElements()) {
			if (Objects.equals(id, child.getId())) {
				return child;
			}

			final DiagramElement result = findDescendantById(child, id);
			if (result != null) {
				return result;
			}
		}

		return null;
	}

	private class AgeDiagramModification implements DiagramModification {
		private DiagramElement addedElement;
		private DiagramElement updatedElement;
		private EnumSet<ModifiableField> updates = EnumSet.noneOf(ModifiableField.class);
		private DiagramElement removedElement;
		private ArrayList<DiagramChange> changes = new ArrayList<>(); // Used for undoing the modification

		@Override
		public void setDiagramConfiguration(final DiagramConfiguration config) {
			Objects.requireNonNull(config, "config must not be null");

			if (!getConfiguration().equals(config)) {
				storeFieldChange(null, ModifiableField.DIAGRAM_CONFIGURATION, AgeDiagram.this.diagramConfiguration,
						config);
				AgeDiagram.this.diagramConfiguration = config;

				// Notify listeners. Diagram configuration doesn't get the usual update event. It gets a special one for diagram configuration.
				final DiagramConfigurationChangedEvent event = new DiagramConfigurationChangedEvent();
				for (final DiagramModificationListener ml : modificationListeners) {
					ml.diagramConfigurationChanged(event);
				}
			}
		}

		@Override
		public void updateBusinessObject(final DiagramElement e, final Object bo,
				final RelativeBusinessObjectReference relativeReference) {
			Objects.requireNonNull(e, "e must not be null");
			Objects.requireNonNull(bo, "bo must not be null");
			Objects.requireNonNull(relativeReference, "relativeReference must not be null");

			setBusinessObject(e, bo);
			setRelativeReference(e, relativeReference);
		}

		private void setRelativeReference(final DiagramElement e,
				final RelativeBusinessObjectReference relativeReference) {
			Objects.requireNonNull(e, "e must not be null");
			Objects.requireNonNull(relativeReference, "relativeReference must not be null");

			if (!Objects.equals(relativeReference, e.getRelativeReference())) {
				final boolean wasRemoved = e.getModifiableContainer().getModifiableDiagramElements().remove(e);

				storeFieldChange(e, ModifiableField.RELATIVE_REFERENCE, e.getRelativeReference(), relativeReference);
				e.setRelativeReference(relativeReference);

				if (wasRemoved) {
					e.getModifiableContainer().getModifiableDiagramElements().add(e);
				}

				afterUpdate(e, ModifiableField.RELATIVE_REFERENCE);
			}
		}

		@Override
		public void updateBusinessObjectWithSameRelativeReference(final DiagramElement e, final Object bo) {
			setBusinessObject(e, bo);
		}

		private void setBusinessObject(final DiagramElement e, final Object bo) {
			Objects.requireNonNull(e, "e must not be null");

			// Special handling for embedded business objects.
			if (bo instanceof EmbeddedBusinessObject) {
				// Conversion from non-embedded to an embedded object is not supported.
				if (!(e.getBusinessObject() instanceof EmbeddedBusinessObject)) {
					throw new RuntimeException(
							"Invalid case. Conversion from non-embeedded to embedded business object");
				}

				final String oldData = ((EmbeddedBusinessObject) e.getBusinessObject()).getData();
				final String newData = ((EmbeddedBusinessObject) bo).getData();

				// This does not consider the UUID of the embedded object. That should be handled by updating the relative reference
				if (!Objects.equals(oldData, newData)) {
					storeFieldChange(e, ModifiableField.EMBEDDED_BUSINESS_OBJECT, e.getBusinessObject(), bo);
					e.setBusinessObject(bo);
					afterUpdate(e, ModifiableField.EMBEDDED_BUSINESS_OBJECT);
				}
			} else {
				e.setBusinessObject(bo);
			}
		}

		@Override
		public void setBusinessObjectHandler(final DiagramElement e, final Object boh) {
			e.setBusinessObjectHandler(boh);
			// Do not notify listeners
		}

		@Override
		public void setCompleteness(final DiagramElement e, final Completeness value) {
			if (!value.equals(e.getCompleteness())) {
				storeFieldChange(e, ModifiableField.COMPLETENESS, e.getCompleteness(), value);
				e.setCompleteness(value);
				afterUpdate(e, ModifiableField.COMPLETENESS);
			}
		}

		@Override
		public void setLabelName(final DiagramElement e, final String value) {
			if (value == null && e.getLabelName() == null) {
				return;
			}

			if (value == null || !value.equals(e.getLabelName())) {
				storeFieldChange(e, ModifiableField.LABEL_NAME, e.getLabelName(), value);
				e.setLabelName(value);
				afterUpdate(e, ModifiableField.LABEL_NAME);
			}
		}

		@Override
		public void setUserInterfaceName(final DiagramElement e, final String value) {
			if (!Objects.equals(e.getUserInterfaceName(), value)) {
				storeFieldChange(e, ModifiableField.USER_INTERFACE_NAME, e.getUserInterfaceName(), value);
				e.setUserInterfaceName(value);
				afterUpdate(e, ModifiableField.USER_INTERFACE_NAME);
			}
		}

		@Override
		public void setSize(final DiagramElement e, final Dimension value) {
			if (value == null && e.getSize() == null) {
				return;
			}

			if (value == null || !value.equals(e.getSize())) {
				storeFieldChange(e, ModifiableField.SIZE, e.getSize(), value);
				e.setSize(value);
				afterUpdate(e, ModifiableField.SIZE);
			}
		}

		@Override
		public void setPosition(final DiagramElement e, final Point value, final boolean updateDockArea,
				final boolean updatedBendpoints) {
			if (!Objects.equals(e.getPosition(), value)) {
				// Determine the different between X and Y
				final Point delta = value == null ? null : new Point(value.x - e.getX(), value.y - e.getY());

				storeFieldChange(e, ModifiableField.POSITION, e.getPosition(), value);
				e.setPosition(value);
				afterUpdate(e, ModifiableField.POSITION);

				// Only update dock area and bendpoints if position is being set to an actual value
				if (delta != null) {
					if (updateDockArea) {
						// Update the dock area based on the position
						final DockArea currentDockArea = e.getDockArea();
						if (currentDockArea != null) {
							if (currentDockArea != DockArea.GROUP) {
								setDockArea(e, calculateDockArea(e));
							}
						}
					}

					if (updatedBendpoints) {
						DiagramElementLayoutUtil.shiftRelatedConnectionBendpoints(AgeDiagram.this, Stream.of(e),
								new Point(delta.x, delta.y),
								this);
					}
				}
			}
		}

		@Override
		public void setGraphicalConfiguration(final DiagramElement e, final AgeGraphicalConfiguration value) {
			if (!Objects.equals(value, e.getGraphicalConfiguration())) {
				storeFieldChange(e, ModifiableField.GRAPHICAL_CONFIGURATION, e.getGraphicalConfiguration(), value);
				e.setGraphicalConfiguration(value);
				afterUpdate(e, ModifiableField.GRAPHICAL_CONFIGURATION);
			}
		}

		@Override
		public void setDockArea(final DiagramElement e, final DockArea value) {
			if (value != e.getDockArea()) {
				storeFieldChange(e, ModifiableField.DOCK_AREA, e.getDockArea(), value);
				e.setDockArea(value);
				afterUpdate(e, ModifiableField.DOCK_AREA);
			}
		}

		@Override
		public void setBendpoints(final DiagramElement e, final List<Point> value) {
			if (value == null && !e.isBendpointsSet()) {
				return;
			}

			// Set the bendpoints even if the returned bendpoints are equal if the bendpoints is being set for the first time or unset.
			if (value == null || !e.isBendpointsSet() || !value.equals(e.getBendpoints())) {
				// Make copy of values because lists are not immutable.
				storeFieldChange(e, ModifiableField.BENDPOINTS, new ArrayList<>(e.getBendpoints()),
						value == null ? Collections.emptyList() : new ArrayList<>(value));
				e.setBendpoints(value);
				afterUpdate(e, ModifiableField.BENDPOINTS);
			}
		}

		@Override
		public void setConnectionPrimaryLabelPosition(final DiagramElement e, final Point value) {
			if (value == null && e.getConnectionPrimaryLabelPosition() == null) {
				return;
			}

			if (value == null || !value.equals(e.getConnectionPrimaryLabelPosition())) {
				storeFieldChange(e, ModifiableField.CONNECTION_PRIMARY_LABEL_POSITION,
						e.getConnectionPrimaryLabelPosition(), value);
				e.setConnectionPrimaryLabelPosition(value);
				afterUpdate(e, ModifiableField.CONNECTION_PRIMARY_LABEL_POSITION);
			}
		}

		@Override
		public void setStyle(final DiagramElement e, final Style value) {
			if (!value.equals(e.getStyle())) {
				storeFieldChange(e, ModifiableField.STYLE, e.getStyle(), value);
				e.setStyle(value);
				afterUpdate(e, ModifiableField.STYLE);
			}
		}

		// Notifies listeners and manages change tracking state after a field has been updated.
		private void afterUpdate(final DiagramElement e, final ModifiableField c) {
			// Notify listeners of the previous modification
			if ((addedElement != null && addedElement != e) || (updatedElement != null && updatedElement != e)
					|| removedElement != null) {
				notifyListeners();
			}

			// Don't track updates on an element that has a pending add event
			if (addedElement != e) {
				updatedElement = e;
				updates.add(c);
			}
		}

		@Override
		public void removeElement(final DiagramElement e) {
			Objects.requireNonNull(e, "e must not be null");

			// Notify listeners of the previous modification
			if (addedElement != null || updatedElement != null || removedElement != null) {
				notifyListeners();
			}

			e.getModifiableContainer().getModifiableDiagramElements().remove(e);
			removedElement = e;
			changes.add(new RemoveElementChange(e));
		}

		@Override
		public void addElement(final DiagramElement e) {
			// Notify listeners of the previous modification
			if (addedElement != null || updatedElement != null || removedElement != null) {
				notifyListeners();
			}

			e.getModifiableContainer().getModifiableDiagramElements().add(e);
			addedElement = e;
			changes.add(new AddElementChange(e));
		}

		private void completeModification() {

			// Send any pending events
			notifyListeners();

			// Send the modifications complete event
			if (modificationListeners.size() > 0) {
				final BeforeModificationsCompletedEvent beforeCompletedEvent = new BeforeModificationsCompletedEvent(
						AgeDiagram.this, this);
				for (final DiagramModificationListener ml : modificationListeners) {
					ml.beforeModificationsCompleted(beforeCompletedEvent);
				}

				final ModificationsCompletedEvent completedEvent = new ModificationsCompletedEvent(AgeDiagram.this);
				for (final DiagramModificationListener ml : modificationListeners) {
					ml.modificationsCompleted(completedEvent);
				}
			}
		}

		private void notifyListeners() {
			// Notify Listeners
			if (modificationListeners.size() > 0) {
				if (addedElement != null) {
					final ElementAddedEvent event = new ElementAddedEvent(addedElement);
					for (final DiagramModificationListener ml : modificationListeners) {
						ml.elementAdded(event);
					}

					addedElement = null;
				}

				if (updatedElement != null) {
					final ElementUpdatedEvent event = new ElementUpdatedEvent(updatedElement, updates);
					for (final DiagramModificationListener ml : modificationListeners) {
						ml.elementUpdated(event);
					}

					updatedElement = null;
					updates.clear();
				}

				if (removedElement != null) {
					final ElementRemovedEvent event = new ElementRemovedEvent(removedElement);
					for (final DiagramModificationListener ml : modificationListeners) {
						ml.elementRemoved(event);
					}

					removedElement = null;
				}
			}
		}

		@Override
		public void undoModification(final DiagramModification modification) {
			if (modification instanceof AgeDiagramModification) {
				final AgeDiagramModification modificationToUndo = ((AgeDiagramModification) modification);
				for (final DiagramChange change : Lists.reverse(modificationToUndo.changes)) {
					change.undo(this);
				}
			}
		}

		@Override
		public void redoModification(final DiagramModification modification) {
			if (modification instanceof AgeDiagramModification) {
				final AgeDiagramModification modificationToRedo = ((AgeDiagramModification) modification);
				for (final DiagramChange change : modificationToRedo.changes) {
					change.redo(this);
				}
			}
		}

		/**
		 * Stores the current value so that changes can be undone/redone
		 */
		private void storeFieldChange(final DiagramElement element, final ModifiableField field,
				final Object currentValue, final Object newValue) {
			changes.add(new FieldChange(element, field, currentValue, newValue));
		}
	}

	private static interface DiagramChange {
		void undo(final DiagramModification m);

		void redo(final DiagramModification m);

		default boolean affectsChangeNumber() {
			return true;
		}
	}

	private static class AddElementChange implements DiagramChange {
		private DiagramElement diagramElement;

		public AddElementChange(final DiagramElement diagramElement) {
			this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		}

		@Override
		public void undo(DiagramModification m) {
			m.removeElement(diagramElement);
		}

		@Override
		public void redo(DiagramModification m) {
			m.addElement(diagramElement);
		}
	}

	private static class RemoveElementChange implements DiagramChange {
		private DiagramElement diagramElement;

		public RemoveElementChange(final DiagramElement diagramElement) {
			this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		}

		@Override
		public void undo(DiagramModification m) {
			m.addElement(diagramElement);
		}

		@Override
		public void redo(DiagramModification m) {
			m.removeElement(diagramElement);
		}
	}

	/**
	 * Holds previous values to allow modifications to be undone.
	 *
	 */
	private static class FieldChange implements DiagramChange {
		public final DiagramElement element;
		public final ModifiableField field;
		public final Object previousValue;
		public final Object newValue;

		public FieldChange(final DiagramElement element, final ModifiableField field, final Object previousValue,
				final Object newValue) {
			this.element = element;
			this.field = field;
			this.previousValue = previousValue;
			this.newValue = newValue;
		}

		@Override
		public void undo(final DiagramModification m) {
			setValue(m, previousValue);
		}

		@Override
		public void redo(final DiagramModification m) {
			setValue(m, newValue);
		}

		@SuppressWarnings("unchecked")
		private void setValue(final DiagramModification m, final Object value) {
			switch (field) {
			case COMPLETENESS:
				m.setCompleteness(element, (Completeness) value);
				break;

			case LABEL_NAME:
				m.setLabelName(element, (String) value);
				break;

			case USER_INTERFACE_NAME:
				m.setUserInterfaceName(element, (String) value);
				break;

			case BENDPOINTS:
				m.setBendpoints(element, (List<Point>) value);
				break;

			case DOCK_AREA:
				m.setDockArea(element, (DockArea) value);
				break;

			case GRAPHICAL_CONFIGURATION:
				m.setGraphicalConfiguration(element, (AgeGraphicalConfiguration) value);
				break;

			case POSITION:
				// Don't update dock area or bendpoints during undo or redo. Such changes occur in an order that will result in erroneous
				// values. If a value was changed during the original action, it will have its own entry in the change list.
				m.setPosition(element, (Point) value, false, false);
				break;

			case SIZE:
				m.setSize(element, (Dimension) value);
				break;

			case CONNECTION_PRIMARY_LABEL_POSITION:
				m.setConnectionPrimaryLabelPosition(element, (Point) value);
				break;

			case STYLE:
				m.setStyle(element, (Style) value);
				break;

			case DIAGRAM_CONFIGURATION:
				m.setDiagramConfiguration((DiagramConfiguration) value);
				break;

			case RELATIVE_REFERENCE:
				((AgeDiagramModification) m).setRelativeReference(element, (RelativeBusinessObjectReference) value);

			case EMBEDDED_BUSINESS_OBJECT:
				m.updateBusinessObjectWithSameRelativeReference(element, value);

			default:
				break;
			}
		}

		@Override
		public boolean affectsChangeNumber() {
			if (field == ModifiableField.COMPLETENESS || field == ModifiableField.USER_INTERFACE_NAME
					|| field == ModifiableField.LABEL_NAME
					|| field == ModifiableField.GRAPHICAL_CONFIGURATION) {
				return false;
			}

			if (field == ModifiableField.SIZE && !DiagramElementPredicates.isResizeable(element)) {
				return false;
			}

			if (field == ModifiableField.POSITION && !DiagramElementPredicates.isMoveable(element)) {
				return false;
			}

			if (field == ModifiableField.DOCK_AREA && element.getDockArea() == DockArea.GROUP) {
				return false;
			}

			return true;
		}
	}

	private static class AgeDiagramModificationAction implements AgeAction {
		private final AgeDiagram ageDiagram;
		private final AgeDiagramModification mod;
		private final DiagramModifier modifier;
		private final AgeAction undoAction;
		private final AgeAction redoAction;

		private int originalVersionNumber;
		private int newVersionNumber;

		public AgeDiagramModificationAction(final AgeDiagram ageDiagram, final AgeDiagramModification mod,
				final DiagramModifier modifier) {
			this.ageDiagram = Objects.requireNonNull(ageDiagram, "ageDiagram must not be null");
			this.mod = Objects.requireNonNull(mod, "mod must not be null");
			this.modifier = Objects.requireNonNull(modifier, "modifier must not be null");

			this.undoAction = () -> {
				ageDiagram.modify("Undo Diagram Modification", newMod -> {
					newMod.undoModification(mod);
				});
				ageDiagram.changeNumber = originalVersionNumber;

				return getRedoAction();
			};

			this.redoAction = () -> {
				ageDiagram.modify("Redo Diagram Modification", newMod -> newMod.redoModification(mod));
				ageDiagram.changeNumber = newVersionNumber;
				return undoAction;
			};
		}

		// Needed to allow implementation of undo action since the formatter convers the undo action into a lambda.
		private AgeAction getRedoAction() {
			return redoAction;
		}

		private static boolean affectsChangeNumber(Collection<DiagramChange> changes) {
			return changes.stream().anyMatch(DiagramChange::affectsChangeNumber);
		}

		@Override
		public AgeAction execute() {
			AgeDiagram.runModification(modifier, mod);
			if (mod.changes.size() > 0) {
				if (affectsChangeNumber(mod.changes)) {

					for (final DiagramChange c : mod.changes) {
						if (c.affectsChangeNumber()) {
							break;
						}
					}

					originalVersionNumber = ageDiagram.changeNumber;
					ageDiagram.changeNumber++;
					newVersionNumber = ageDiagram.changeNumber;
				}

				return undoAction;
			} else {
				return null;
			}
		}
	}
}
