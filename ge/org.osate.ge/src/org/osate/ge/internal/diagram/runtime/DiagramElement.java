/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.updating.Completeness;
import org.osate.ge.internal.query.RelativeReferenceProvider;

import com.google.common.collect.ImmutableList;

/**
 * A node in the {@link AgeDiagram} tree which represents a single business object. Instances are displayed
 * graphically in the editor.
 * All non-root {@link DiagramNode} instances which make up an {@link AgeDiagram} are instances of this class.
 */
public class DiagramElement extends DiagramNode implements RelativeReferenceProvider {
	private final DiagramNode container;

	private final UUID id;
	private Object bo;
	private BusinessObjectHandler boHandler;
	private RelativeBusinessObjectReference boRelReference;
	private Completeness completeness = Completeness.UNKNOWN;
	private final DiagramElementCollection children = new DiagramElementCollection();
	private String labelName;
	private String uiName;
	private GraphicalConfiguration graphicalConfig; // Required after initialization.
	private Style style = Style.EMPTY; // Will never be null

	private Point position; // Optional. Relative to container.

	// Shape Specific
	private Dimension size; // Optional
	private DockArea dockArea; // Optional

	// Connection Specific
	private ImmutableList<Point> bendpoints; // Optional. Diagram coordinate system. A null value indicates that the bendpoints have not been configured.
	private Point connectionPrimaryLabelPosition; // Optional. Position of the connection label. Relative to the midpoint of the connection.

	/**
	 * Creates a new instance
	 * It is intended that bo and boHandler will not be null except for during the diagram loading process.
	 * Once the diagram is updated, these fields should be non-null
	 * @param container the container for the diagram element. The diagram element will not be added to the container as part of this
	 * constructor. Diagram elements are added to their container using {@link DiagramModification#addElement(DiagramElement)}.
	 * @param bo the business object to which the diagram element is related.
	 * @param boHandler the handler for the business object
	 * @param boRelReference the relative reference for the business object. Must not be null.
	 * @param id a unique identifier used to distinguish diagram elements from others in the same diagram. Must not be null.
	 */
	public DiagramElement(final DiagramNode container, final Object bo, final BusinessObjectHandler boHandler,
			final RelativeBusinessObjectReference boRelReference, final UUID id) {
		this.container = container;
		this.bo = bo;
		this.boHandler = boHandler;
		this.boRelReference = Objects.requireNonNull(boRelReference, "boRelReference must not be null");
		this.id = Objects.requireNonNull(id, "id must not be null");
	}

	@Override
	public final DiagramNode getParent() {
		return container;
	}

	@Override
	public final Collection<DiagramElement> getChildren() {
		return Collections.unmodifiableCollection(children);
	}

	@Override
	public final DiagramElementCollection getModifiableChildren() {
		return children;
	}

	@Override
	public final DiagramElement getChildByRelativeReference(final RelativeBusinessObjectReference ref) {
		return children.getByRelativeReference(ref);
	}

	/**
	 * Returns the identifier for the diagram element. Unique within a diagram.
	 * @return the identifier for the diagram element. Unique within a diagram.
	 */
	public final UUID getId() {
		return id;
	}

	@Override
	public final Object getBusinessObject() {
		return bo;
	}

	/**
	 * Returns whether the diagram element is complete
	 * @return whether the diagram element is complete. Will not return null.
	 */
	public final Completeness getCompleteness() {
		return completeness;
	}

	/**
	 * Sets whether the value which indicates whether the diagram element is complete.
	 * @param value the new completeness state. Must not be null.
	 * @see DiagramModification#setCompleteness(DiagramElement, Completeness)
	 */
	final void setCompleteness(final Completeness value) {
		this.completeness = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 * Returns the business object handler
	 * @return the business object handler
	 */
	public final BusinessObjectHandler getBusinessObjectHandler() {
		return boHandler;
	}

	/**
	 * Sets the business object handler.
	 * @param value the new business object handler
	 * @see DiagramModification#setBusinessObjectHandler(DiagramElement, BusinessObjectHandler)
	 */
	public final void setBusinessObjectHandler(final BusinessObjectHandler value) {
		this.boHandler = value;
	}

	/**
	 * Sets the business object
	 * @param value the new business object
	 * @see DiagramModification#updateBusinessObject(DiagramElement, Object, RelativeBusinessObjectReference)
	 * @see DiagramModification#updateBusinessObjectWithSameRelativeReference(DiagramElement, Object)
	 */
	final void setBusinessObject(final Object value) {
		this.bo = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 * Sets the reference to the business object
	 * @param value the new business object reference
	 */
	final void setRelativeReference(final RelativeBusinessObjectReference value) {
		this.boRelReference = Objects.requireNonNull(value, "value must not be null");
	}

	@Override
	public final RelativeBusinessObjectReference getRelativeReference() {
		return boRelReference;
	}

	/**
	 * Returns the name used for the diagram element's label
	 * @return the name used for the diagram element's label
	 * @see BusinessObjectHandler#getNameForDiagram(org.osate.ge.businessobjecthandling.GetNameForDiagramContext)
	 */
	public final String getLabelName() {
		return labelName;
	}

	/**
	 * Sets the name used for the diagram element's label
	 * @param value the new value
	 * @see DiagramModification#setLabelName(DiagramElement, String)
	 */
	final void setLabelName(final String value) {
		this.labelName = value;
	}

	/**
	 * Returns the name used to identify the diagram element in the user interface
	 * @return the name used to identify the diagram element in the user interface
	 * @see BusinessObjectHandler#getName(org.osate.ge.businessobjecthandling.GetNameContext)
	 */
	public final String getUserInterfaceName() {
		return uiName;
	}

	/**
	 * Sets the name used to identify the diagram element in the user interface
	 * @param value the new value
	 * @see DiagramModification#setUserInterfaceName(DiagramElement, String)
	 */
	final void setUserInterfaceName(final String value) {
		this.uiName = value;
	}

	/**
	 * Returns true if the diagram element has a non-null position
	 * @return true if the diagram element has a non-null position
	 */
	public final boolean hasPosition() {
		return position != null;
	}

	/**
	 * Returns the diagram element's position
	 * @return the element's position or null.
	 */
	public final Point getPosition() {
		return position;
	}

	/**
	 * Returns the X component of the position.
	 * @return 0 if the element does not have a position
	 * @see #hasPosition()
	 * @see #getPosition()
	 */
	public final double getX() {
		return position == null ? 0 : position.x;
	}

	/**
	 * Returns the Y component of the position
	 * @return 0 if the element does not have a position
	 * @see #hasPosition()
	 * @see #getPosition()
	 */
	public final double getY() {
		return position == null ? 0 : position.y;
	}

	/**
	 * Sets the position of the diagram element
	 * @param value the new value
	 * @see DiagramModification#setPosition(DiagramElement, Point)
	 */
	final void setPosition(final Point value) {
		this.position = value;
	}

	/**
	 * Returns true if the diagram element has a non-null size
	 * @return true if the diagram element has a non-null size
	 */
	public boolean hasSize() {
		return size != null;
	}

	/**
	 * Returns the diagram element's size
	 * @return element's size or null.
	 */
	public final Dimension getSize() {
		return size;
	}

	/**
	 * Return the width of the diagram element
	 * @return 0 if the element does not have a size
	 * @see #hasSize()
	 * @see #getSize()
	 */
	public final double getWidth() {
		return size == null ? 0 : size.width;
	}

	/**
	 * Returns the height of the diagram element
	 * @return 0 if the element does not have a size
	 * @see #hasSize()
	 * @see #getSize()
	 */
	public final double getHeight() {
		return size == null ? 0 : size.height;
	}

	/**
	 * Sets the size of the diagram element
	 * @param value the new value
	 * @see DiagramModification#setSize(DiagramElement, Dimension)
	 */
	final void setSize(final Dimension value) {
		this.size = value;
	}

	/**
	 * Returns the diagram element's user-specified style. Fields in this style overrides styles specified in the graphical configuration
	 * and the default style.
	 * @return the diagram element's style
	 */
	public final Style getStyle() {
		return style;
	}

	/**
	 * Sets the user specified style.
	 * @param value the new style. Must not be null.
	 * @see #getStyle()
	 * @see DiagramModification#setStyle(DiagramElement, Style)
	 */
	public final void setStyle(final Style value) {
		this.style = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 * Returns the diagram element's graphical configuration.
	 * @return the diagram element's graphical configuration
	 */
	public final GraphicalConfiguration getGraphicalConfiguration() {
		return graphicalConfig;
	}

	/**
	 * Sets the diagram element's graphical configuration
	 * @param value the new value
	 */
	final void setGraphicalConfiguration(final GraphicalConfiguration value) {
		this.graphicalConfig = value;
	}

	/**
	 * Returns the graphical configuration's graphic
	 * @return the graphical configuration's graphic. Returns null if the graphical configuration is null.
	 * @see #getGraphicalConfiguration()
	 * @see GraphicalConfiguration#getGraphic()
	 */
	public final Graphic getGraphic() {
		return graphicalConfig == null ? null : graphicalConfig.getGraphic();
	}

	/**
	 * Returns the graphical configuration's connection source
	 * @return the graphical configuration's connection source. Returns null if the graphical configuration is null.
	 * @see #getGraphicalConfiguration()
	 * @see GraphicalConfiguration#getConnectionSource()
	 */
	public final DiagramElement getStartElement() {
		return graphicalConfig.getConnectionSource();
	}

	/**
	 * Returns the graphical configuration's connection destination.
	 * @return the graphical configuration's connection destination. Returns null if the graphical configuration is null.
	 * @see #getGraphicalConfiguration()
	 * @see GraphicalConfiguration#getConnectionDestination()
	 */
	public final DiagramElement getEndElement() {
		return graphicalConfig.getConnectionDestination();
	}

	/**
	 * Returns the diagram element's dock area
	 * @return the diagram element's dock area. Returns null if the diagram element is not docked.
	 */
	public final DockArea getDockArea() {
		return dockArea;
	}

	/**
	 * Sets the diagram element's dock area.
	 * @param value the new value. A null value indicates that the diagram element is not docked.
	 * @see DiagramModification#setDockArea(DiagramElement, DockArea)
	 */
	final void setDockArea(final DockArea value) {
		this.dockArea = value;
	}

	/**
	 * Returns true if the diagram element's bendpoints have been set. Will return true when there are no bendpoints if the bendpoints
	 * have been set to an empty list.
	 * @return true if the diagram element's bendpoints have been set.
	 */
	public final boolean isBendpointsSet() {
		return bendpoints != null;
	}

	/**
	 * Returns an immutable list of the element's bendpoints.
	 * The list is immutable. The returned list will not be updated to reflect changes in the diagram element.
	 * Bendpoints are specified in diagram coordinates rather than relative to the diagram element.
	 * @return never returns null.
	 */
	public final List<Point> getBendpoints() {
		return bendpoints == null ? Collections.emptyList() : bendpoints;
	}

	/**
	 * Sets the diagram element's bendpoints. Only relevant for connections and flow indicators.
	 * Bendpoints may be set to null instead of an empty list to indicate that the bendpoints have not been set.
	 * To indicate that the diagram element does not have any bendpoints, an empty value should be set.
	 * @param value the new bendpoints.
	 * @see DiagramModification#setBendpoints(DiagramElement, List)
	 */
	final void setBendpoints(final List<Point> value) {
		bendpoints = value == null ? null : ImmutableList.copyOf(value);
	}

	/**
	 * Returns the position of the primary label position. Only valid for connections and flow indicators.
	 * The position is relative to the midpoint of the connection.
	 * @return will return null if the position has not been set.
	 */
	public final Point getConnectionPrimaryLabelPosition() {
		return connectionPrimaryLabelPosition;
	}

	/**
	 * Sets the position of the primary label. Only appropriate for connections and flow indicators
	 * @param value the position of the label relative to the connection's midpoint.
	 */
	final void setConnectionPrimaryLabelPosition(final Point value) {
		this.connectionPrimaryLabelPosition = value;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		toString(sb, "");
		return sb.toString();
	}

	/**
	 * Appends a string representation of the object to the specified string builder.
	 * @param sb the string builder to which to append the string representation
	 * @param indentation a string containing the indentation that should be added to each line
	 */
	void toString(final StringBuilder sb, final String indentation) {
		sb.append(indentation);
		sb.append('{');
		sb.append(System.lineSeparator());

		final String innerIndentation = indentation + '\t';
		sb.append(innerIndentation);
		sb.append("relative reference: ");
		sb.append(boRelReference);
		sb.append(System.lineSeparator());

		sb.append(innerIndentation);
		sb.append("id: ");
		sb.append(id);
		sb.append(System.lineSeparator());

		sb.append(innerIndentation);
		sb.append("graphicalConfig: ");
		sb.append(graphicalConfig);
		sb.append(System.lineSeparator());

		if (position != null) {
			sb.append(innerIndentation);
			sb.append("position: ");
			sb.append(position);
			sb.append(System.lineSeparator());
		}

		if (size != null) {
			sb.append(innerIndentation);
			sb.append("size: ");
			sb.append(size);
			sb.append(System.lineSeparator());
		}

		if (dockArea != null) {
			sb.append(innerIndentation);
			sb.append("dock area: ");
			sb.append(dockArea);
			sb.append(System.lineSeparator());
		}

		if (bendpoints != null) {
			sb.append(innerIndentation);
			sb.append("bendpoints: ");
			sb.append(Arrays.toString(bendpoints.toArray(new Point[bendpoints.size()])));
			sb.append(System.lineSeparator());
		}

		if (style != null) {
			sb.append(innerIndentation);
			sb.append("style: ");
			sb.append(style);
			sb.append(System.lineSeparator());
		}

		if (children.size() > 0) {
			children.toString(sb, innerIndentation);
		}

		sb.append(indentation);
		sb.append('}');
		sb.append(System.lineSeparator());
	}
}
