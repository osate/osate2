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
package org.osate.ge.internal.diagram.runtime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.osate.ge.DiagramType;

/**
 * Immutable type which represents the diagram configuration.
 *
 * @see DiagramConfigurationBuilder
 */
public class DiagramConfiguration {
	private final DiagramType diagramType;
	private final CanonicalBusinessObjectReference contextBoReference;
	private final Set<String> lcEnabledAadlPropertyNames; // Lowercase AADL property names

	// Determines whether the primary label of connections should be visible by default. This overrides the settings of the business object handler and can be
	// overridden by the user selection.
	private final Boolean connectionPrimaryLabelsVisible;

	DiagramConfiguration(final DiagramType diagramType, final CanonicalBusinessObjectReference contextBoReference,
			final Set<String> displayedAadlPropertyNames, final Boolean connectionPrimaryLabelsVisible) {
		this.diagramType = Objects.requireNonNull(diagramType, "diagramType must not be null");
		this.contextBoReference = contextBoReference == null ? null : contextBoReference;
		this.lcEnabledAadlPropertyNames = Collections.unmodifiableSet(new HashSet<String>(Objects.requireNonNull(displayedAadlPropertyNames, "displayedAadlPropertyNames must not be null")));
		this.connectionPrimaryLabelsVisible = connectionPrimaryLabelsVisible;
	}

	public DiagramType getDiagramType() {
		return diagramType;
	}

	public CanonicalBusinessObjectReference getContextBoReference() {
		return contextBoReference;
	}

	/**
	 * Returns an unmodifiable collection of enable AADL qualified property names. All names will be lower case.
	 * @return
	 */
	public Set<String> getEnabledAadlPropertyNames() {
		return lcEnabledAadlPropertyNames;
	}

	public Boolean getConnectionPrimaryLabelsVisible() {
		return connectionPrimaryLabelsVisible;
	}

	@Override
	public String toString() {
		return "{ diagramType: " + diagramType.getName() + ", contextBoReference: " + contextBoReference
				+ ", enabledAadlPropertyNames: " + lcEnabledAadlPropertyNames + ", connectionPrimaryLabelsVisible: "
				+ connectionPrimaryLabelsVisible
				+ " } ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((connectionPrimaryLabelsVisible == null) ? 0 : connectionPrimaryLabelsVisible.hashCode());
		result = prime * result + ((contextBoReference == null) ? 0 : contextBoReference.hashCode());
		result = prime * result + ((diagramType == null) ? 0 : diagramType.hashCode());
		result = prime * result + ((lcEnabledAadlPropertyNames == null) ? 0 : lcEnabledAadlPropertyNames.hashCode());
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
		DiagramConfiguration other = (DiagramConfiguration) obj;
		if (connectionPrimaryLabelsVisible == null) {
			if (other.connectionPrimaryLabelsVisible != null) {
				return false;
			}
		} else if (!connectionPrimaryLabelsVisible.equals(other.connectionPrimaryLabelsVisible)) {
			return false;
		}
		if (contextBoReference == null) {
			if (other.contextBoReference != null) {
				return false;
			}
		} else if (!contextBoReference.equals(other.contextBoReference)) {
			return false;
		}
		if (diagramType == null) {
			if (other.diagramType != null) {
				return false;
			}
		} else if (!diagramType.equals(other.diagramType)) {
			return false;
		}
		if (lcEnabledAadlPropertyNames == null) {
			if (other.lcEnabledAadlPropertyNames != null) {
				return false;
			}
		} else if (!lcEnabledAadlPropertyNames.equals(other.lcEnabledAadlPropertyNames)) {
			return false;
		}
		return true;
	}
}
