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
package org.osate.ge.graphics.internal;

import java.util.Objects;

import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

public class AgeGraphicalConfiguration implements GraphicalConfiguration {
	public final Graphic graphic;
	public final DockingPosition defaultDockingPosition;
	public final DiagramElement connectionSource;
	public final DiagramElement connectionDestination;
	public final Style style;
	public final boolean isDecoration;
	public final String annotation;
	public final boolean primaryLabelIsMultiline;

	public AgeGraphicalConfiguration(final Graphic graphic, final DockingPosition defaultDockingPosition,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((connectionDestination == null) ? 0 : connectionDestination.hashCode());
		result = prime * result + ((connectionSource == null) ? 0 : connectionSource.hashCode());
		result = prime * result + ((defaultDockingPosition == null) ? 0 : defaultDockingPosition.hashCode());
		result = prime * result + ((graphic == null) ? 0 : graphic.hashCode());
		result = prime * result + (isDecoration ? 1231 : 1237);
		result = prime * result + ((style == null) ? 0 : style.hashCode());
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
		AgeGraphicalConfiguration other = (AgeGraphicalConfiguration) obj;
		if (annotation == null) {
			if (other.annotation != null) {
				return false;
			}
		} else if (!annotation.equals(other.annotation)) {
			return false;
		}
		if (connectionDestination == null) {
			if (other.connectionDestination != null) {
				return false;
			}
		} else if (!connectionDestination.equals(other.connectionDestination)) {
			return false;
		}
		if (connectionSource == null) {
			if (other.connectionSource != null) {
				return false;
			}
		} else if (!connectionSource.equals(other.connectionSource)) {
			return false;
		}
		if (defaultDockingPosition != other.defaultDockingPosition) {
			return false;
		}
		if (graphic == null) {
			if (other.graphic != null) {
				return false;
			}
		} else if (!graphic.equals(other.graphic)) {
			return false;
		}
		if (isDecoration != other.isDecoration) {
			return false;
		}
		if (style == null) {
			if (other.style != null) {
				return false;
			}
		} else if (!style.equals(other.style)) {
			return false;
		}
		return true;
	}
}
