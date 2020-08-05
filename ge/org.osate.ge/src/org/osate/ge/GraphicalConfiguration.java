/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
 * Stores data needed to represent a business object graphically. Provides by the business object handler.
 * GraphicalConfiguration objects must be created using the {@link GraphicalConfigurationBuilder} class.
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @see GraphicalConfigurationBuilder
 */
public final class GraphicalConfiguration {
	private final Graphic graphic;
	private final DockingPosition defaultDockingPosition;
	private final DiagramElement connectionSource;
	private final DiagramElement connectionDestination;
	private final Style style;
	private final boolean isDecoration;
	private final String annotation;
	private final boolean primaryLabelIsMultiline;

	/**
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	GraphicalConfiguration(
			final Graphic graphic,
			final DockingPosition defaultDockingPosition,
			final DiagramElement connectionSource, final DiagramElement connectionDestination, final Style style,
			final boolean isDecoration, final String annotation, final boolean primaryLabelIsMultiline) {
		this.graphic = Objects.requireNonNull(graphic, "graphic must not be null");
		this.defaultDockingPosition = defaultDockingPosition;
		this.connectionSource = connectionSource;
		this.connectionDestination = connectionDestination;
		this.style = Objects.requireNonNull(style, "style must not be null");
		this.isDecoration = isDecoration;
		this.annotation = annotation;
		this.primaryLabelIsMultiline = primaryLabelIsMultiline;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final Graphic getGraphic() {
		return graphic;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final DockingPosition getDefaultDockingPosition() {
		return defaultDockingPosition;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final DiagramElement getConnectionSource() {
		return connectionSource;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final DiagramElement getConnectionDestination() {
		return connectionDestination;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final Style getStyle() {
		return style;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final boolean isDecoration() {
		return isDecoration;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public final String getAnnotation() {
		return annotation;
	}

	/**
	 *
	 * @noreference This method is not intended to be referenced by clients.
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
		result = prime * result + (isDecoration() ? 1231 : 1237);
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
		if (isDecoration() != other.isDecoration()) {
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
