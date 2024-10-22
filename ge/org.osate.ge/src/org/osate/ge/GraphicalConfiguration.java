/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge;

import java.util.Objects;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Immutable data type which stores data needed to represent a business object graphically.
 * Provided by a diagram element's {@link org.osate.ge.businessobjecthandling.BusinessObjectHandler}.
 * GraphicalConfiguration objects must be created using the {@link GraphicalConfigurationBuilder} class.
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @see GraphicalConfigurationBuilder
 * @see org.osate.ge.businessobjecthandling.BusinessObjectHandler
 */
public final class GraphicalConfiguration {
	private final Graphic graphic;
	private final DockingPosition defaultDockingPosition;
	private final DiagramElement connectionSource;
	private final DiagramElement connectionDestination;
	private final Style style;
	private final String annotation;
	private final boolean primaryLabelIsMultiline;

	/**
	 * Creates a new instance.
	 * @param graphic the diagram element's graphic.
	 * @param defaultDockingPosition the default docking position for the diagram element.
	 * @param connectionSource the diagram element which is the start of the connection.
	 * @param connectionDestination the diagram element which is the end of the connection.
	 * @param style the diagram element's style
	 * @param annotation an additional text annotation for use with shapes.
	 * @param primaryLabelIsMultiline whether the primary label for the diagram element is allowed to span multiple lines
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	GraphicalConfiguration(
			final Graphic graphic,
			final DockingPosition defaultDockingPosition,
			final DiagramElement connectionSource, final DiagramElement connectionDestination, final Style style,
			final String annotation, final boolean primaryLabelIsMultiline) {
		this.graphic = Objects.requireNonNull(graphic, "graphic must not be null");
		this.defaultDockingPosition = defaultDockingPosition;
		this.connectionSource = connectionSource;
		this.connectionDestination = connectionDestination;
		this.style = Objects.requireNonNull(style, "style must not be null");
		this.annotation = annotation;
		this.primaryLabelIsMultiline = primaryLabelIsMultiline;
	}

	/**
	 * Returns the graphic used for the diagram element.
	 * @return the graphic
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final Graphic getGraphic() {
		return graphic;
	}

	/**
	 * Returns the default docking position of the diagram element. Used to determine if diagram element is a docked element.
	 * The layout algorithm is not required to dock the diagram to the requested side.
	 * @return the default docking position
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final DockingPosition getDefaultDockingPosition() {
		return defaultDockingPosition;
	}

	/**
	 * For connections, returning the diagram element which is the start of the connection. For flow indicators, this indicates the
	 * diagram element to which the indicator is attached.
	 * @return the diagram element which at which the connection starts
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final DiagramElement getConnectionSource() {
		return connectionSource;
	}

	/**
	 * For connections, returning the diagram element which is the end of the connection.
	 * @return the diagram element which at which the connection ends
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final DiagramElement getConnectionDestination() {
		return connectionDestination;
	}

	/**
	 * The default style for the diagram element. The fields of the diagram element's style overrides this style.
	 * @return the style
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final Style getStyle() {
		return style;
	}

	/**
	 * Returns a string which will be used as an additional label for the diagram element. Only supported for shapes.
	 * @return the annotation text. Null if the shape does not have an annotation.
	 */
	public final String getAnnotation() {
		return annotation;
	}

	/**
	 * Returns whether to allow the primary label to span multiple lines.
	 * @return true if the primary label should be allowed to span multiple lines.
	 */
	public final boolean isPrimaryLabelIsMultiline() {
		return primaryLabelIsMultiline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAnnotation() == null) ? 0 : getAnnotation().hashCode());
		result = prime * result + ((getConnectionDestination() == null) ? 0 : getConnectionDestination().hashCode());
		result = prime * result + ((getConnectionSource() == null) ? 0 : getConnectionSource().hashCode());
		result = prime * result + ((getDefaultDockingPosition() == null) ? 0 : getDefaultDockingPosition().hashCode());
		result = prime * result + ((getGraphic() == null) ? 0 : getGraphic().hashCode());
		result = prime * result + ((getStyle() == null) ? 0 : getStyle().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		GraphicalConfiguration other = (GraphicalConfiguration) obj;
		if (getAnnotation() == null) {
			if (other.getAnnotation() != null) {
				return false;
			}
		} else if (!getAnnotation().equals(other.getAnnotation())) {
			return false;
		}
		if (getConnectionDestination() == null) {
			if (other.getConnectionDestination() != null) {
				return false;
			}
		} else if (!getConnectionDestination().equals(other.getConnectionDestination())) {
			return false;
		}
		if (getConnectionSource() == null) {
			if (other.getConnectionSource() != null) {
				return false;
			}
		} else if (!getConnectionSource().equals(other.getConnectionSource())) {
			return false;
		}
		if (getDefaultDockingPosition() != other.getDefaultDockingPosition()) {
			return false;
		}
		if (getGraphic() == null) {
			if (other.getGraphic() != null) {
				return false;
			}
		} else if (!getGraphic().equals(other.getGraphic())) {
			return false;
		}
		if (getStyle() == null) {
			if (other.getStyle() != null) {
				return false;
			}
		} else if (!getStyle().equals(other.getStyle())) {
			return false;
		}
		return true;
	}
}
