/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.diagram.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.diagramtypes.CustomDiagramType;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.GraphicalEditorException;
import org.osate.ge.internal.diagram.runtime.updating.Completeness;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.impl.SimpleActionExecutor;

import com.google.common.collect.Lists;

/**
 * This class is the in-memory data structure for the diagram.
 * Represents the state of the diagram independent of the UI library being used to present the diagram.
 * Listeners are used to provide notifications when the diagram state changes. For example: when an element is moved listeners are notified.
 */
public class AgeDiagram extends DiagramNode {
	private final List<DiagramModificationListener> modificationListeners = new CopyOnWriteArrayList<>();
	private DiagramConfiguration diagramConfiguration;
	private final DiagramElementCollection elements = new DiagramElementCollection();
	private ActionExecutor actionExecutor = new SimpleActionExecutor();
	private boolean actionExecutorSet = false;
	private DiagramModification currentModification;
	private int changeNumber = 0;

	/**
	 * Creates a new instance
	 */
	public AgeDiagram() {
		this.diagramConfiguration = new DiagramConfiguration(new CustomDiagramType(), null, Collections.emptySet(),
				true);
	}

	/**
	 * Returns the diagram configuration
	 * @return the diagram configuration
	 */
	public DiagramConfiguration getConfiguration() {
		return diagramConfiguration;
	}

	@Override
	public DiagramNode getParent() {
		return null;
	}

	@Override
	public Collection<DiagramElement> getChildren() {
		return Collections.unmodifiableCollection(elements);
	}

	@Override
	public DiagramElementCollection getModifiableChildren() {
		return elements;
	}

	@Override
	public DiagramElement getChildByRelativeReference(final RelativeBusinessObjectReference ref) {
		return elements.getByRelativeReference(ref);
	}

	/**
	 * Adds a listener which is notified when the diagram is modified
	 * @param listener the listener to notify
	 * @see #removeModificationListener(DiagramModificationListener)
	 */
	public void addModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.add(Objects.requireNonNull(listener, "listener must not be null"));
	}

	/**
	 * Removes a listener from the collection of listeners which are notified when the diagram is modified
	 * @param listener the listener to remove. If the instance is not in the listener collection, it is ignored.
	 * @see #addModificationListener(DiagramModificationListener)
	 */
	public void removeModificationListener(final DiagramModificationListener listener) {
		this.modificationListeners.remove(Objects.requireNonNull(listener, "listener must not be null"));
	}

	/**
	 * Sets the action executor to be used when performing modifications.
	 * Must be set at most once. An exception will be thrown if this method is called more than once without resetting the action listener.
	 * If the action executor is not set, a default action executor which simply executes the action will be used.
	 * @param actionExecutor the action executor to use when performing modifications
	 * @see #resetActionExecutor()
	 */
	public void setActionExecutor(final ActionExecutor actionExecutor) {
		if (actionExecutorSet) {
			throw new GraphicalEditorException("The action executor for the diagram must not be set multiple times");
		}

		this.actionExecutor = Objects.requireNonNull(actionExecutor, "actionExecutor must not be null");
		actionExecutorSet = true;
	}

	/**
	 * Resets the action executor. Sets the action executor to a default value which simply executes the action. Once this method has been
	 * called, {@link #setActionExecutor(ActionExecutor)} may be called again. The set -> reset mechanism is used to detect errors which
	 * would occur if the action executor was replaced. Diagrams editors typically create the action executor and the same action executor
	 * should be used for all actions related to the diagram.
	 * @see #setActionExecutor(ActionExecutor)
	 */
	public void resetActionExecutor() {
		this.actionExecutor = new SimpleActionExecutor();
		actionExecutorSet = false;
	}

	/**
	 * Calls a modifier to modify the diagram. If a modification is not in progress, a new action will be executed using the current action executor.
	 * If a modification is in progress, the modification will simply be performed as part of the current modification.
	 * @param label the label for the action. If a modification is already in progress, then it will be ignored.
	 * @param modifier the modifier which performs the modification.
	 * @see #setActionExecutor(ActionExecutor)
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

	// The diagram does not have a business object. However, the diagram configuration may provide a business object to scope the diagram.
	@Override
	public Object getBusinessObject() {
		return null;
	}

	/**
	 * Searches for a diagram element using the specified ID
	 * @param id the ID of the element to return
	 * @return the element with the specified ID. Returns null if the element cannot be returned.
	 * @see DiagramElement#getId()
	 */
	public DiagramElement findElementById(final UUID id) {
		return findDescendantById(this, id);
	}

	/**
	 * Returns the change number. The change number is an Incrementing number that is not persisted which indicates the diagram has been
	 * modified in a way which would affect the persisted version of the diagram. Used to determine whether a diagram is "dirty".
	 * @return the change number
	 */
	public int getCurrentChangeNumber() {
		return changeNumber;
	}

	private static DiagramElement findDescendantById(final DiagramNode container, final UUID id) {
		for (final DiagramElement child : container.getChildren()) {
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

	/**
	 * {@link DiagramModification} implementation which modifies diagram elements. It also tracks changes to allow undo and redo.
	 */
	private class AgeDiagramModification implements DiagramModification {
		private DiagramElement addedElement;
		private DiagramElement updatedElement;
		private EnumSet<ModifiableField> updates = EnumSet.noneOf(ModifiableField.class);
		private DiagramElement removedElement;
		private ArrayList<DiagramChange> changes = new ArrayList<>(); // Used for undoing the modification

		@Override
		public AgeDiagram getDiagram() {
			return AgeDiagram.this;
		}

		@Override
		public void setDiagramConfiguration(final DiagramConfiguration config) {
			Objects.requireNonNull(config, "config must not be null");

			final boolean valuesAreEqual = getConfiguration().equals(config);

			if (!valuesAreEqual) {
				storeFieldChange(null, ModifiableField.DIAGRAM_CONFIGURATION, AgeDiagram.this.diagramConfiguration,
						config);
			}

			// The reference is changed even if the configuration is logically equal. The case of the context reference may have changed that
			// requires an update or indicator but needs to stored so that it will be serialized during the next save.
			AgeDiagram.this.diagramConfiguration = config;

			if (!valuesAreEqual) {
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

			final boolean valuesAreEqual = Objects.equals(relativeReference, e.getRelativeReference());
			boolean wasRemoved = false;
			if (!valuesAreEqual) {
				wasRemoved = e.getParent().getModifiableChildren().remove(e);

				storeFieldChange(e, ModifiableField.RELATIVE_REFERENCE, e.getRelativeReference(), relativeReference);
			}

			// The relative reference is updated even when the objects are equal so that the case of the relative reference will be preserved.
			// However, it will not be recorded as a change.
			e.setRelativeReference(relativeReference);

			if (!valuesAreEqual) {
				if (wasRemoved) {
					e.getParent().getModifiableChildren().add(e);
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
					throw new GraphicalEditorException(
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
		public void setBusinessObjectHandler(final DiagramElement e, final BusinessObjectHandler boh) {
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
		public void setPosition(final DiagramElement e, final Point value) {
			if (!Objects.equals(e.getPosition(), value)) {
				storeFieldChange(e, ModifiableField.POSITION, e.getPosition(), value);
				e.setPosition(value);
				afterUpdate(e, ModifiableField.POSITION);
			}
		}

		@Override
		public void setGraphicalConfiguration(final DiagramElement e, final GraphicalConfiguration value) {
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

			e.getParent().getModifiableChildren().remove(e);
			removedElement = e;
			changes.add(new RemoveElementChange(e));
		}

		@Override
		public void addElement(final DiagramElement e) {
			// Notify listeners of the previous modification
			if (addedElement != null || updatedElement != null || removedElement != null) {
				notifyListeners();
			}

			e.getParent().getModifiableChildren().add(e);
			addedElement = e;
			changes.add(new AddElementChange(e));
		}

		private void sendBeforeCompletedNotifications() {
			// Send any pending events
			notifyListeners();

			// Send the before modifications complete event
			if (modificationListeners.size() > 0) {
				final BeforeModificationsCompletedEvent beforeCompletedEvent = new BeforeModificationsCompletedEvent(
						AgeDiagram.this, this);
				for (final DiagramModificationListener ml : modificationListeners) {
					ml.beforeModificationsCompleted(beforeCompletedEvent);
				}
			}
		}

		private void sendCompleteNotifications() {
			// Send the modifications complete event
			if (modificationListeners.size() > 0) {
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
		void undo(final AgeDiagramModification m);

		void redo(final AgeDiagramModification m);

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
		public void undo(AgeDiagramModification m) {
			m.removeElement(diagramElement);
		}

		@Override
		public void redo(AgeDiagramModification m) {
			m.addElement(diagramElement);
		}
	}

	private static class RemoveElementChange implements DiagramChange {
		private DiagramElement diagramElement;

		public RemoveElementChange(final DiagramElement diagramElement) {
			this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		}

		@Override
		public void undo(AgeDiagramModification m) {
			m.addElement(diagramElement);
		}

		@Override
		public void redo(AgeDiagramModification m) {
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
		public void undo(final AgeDiagramModification m) {
			setValue(m, previousValue);
		}

		@Override
		public void redo(final AgeDiagramModification m) {
			setValue(m, newValue);
		}

		@SuppressWarnings("unchecked")
		private void setValue(final AgeDiagramModification m, final Object value) {
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
				m.setGraphicalConfiguration(element, (GraphicalConfiguration) value);
				break;

			case POSITION:
				m.setPosition(element, (Point) value);
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
				break;

			case EMBEDDED_BUSINESS_OBJECT:
				m.updateBusinessObjectWithSameRelativeReference(element, value);
				break;

			default:
				break;
			}
		}

		@Override
		public boolean affectsChangeNumber() {
			if (field == ModifiableField.COMPLETENESS || field == ModifiableField.USER_INTERFACE_NAME
					|| field == ModifiableField.LABEL_NAME || field == ModifiableField.GRAPHICAL_CONFIGURATION) {
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
			modifier.modify(mod);
			mod.sendBeforeCompletedNotifications();
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

				mod.sendCompleteNotifications();

				return undoAction;
			} else {
				mod.sendCompleteNotifications();
				return null;
			}
		}
	}
}
