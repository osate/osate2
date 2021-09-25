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
package org.osate.ge.internal.ui.navigator;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.internal.services.DiagramService.DiagramReference;

import com.google.common.collect.ImmutableCollection;

/**
 * Contains information about a collection of diagrams. Each instance represents a "folder" in the AADL Diagram view.
 */
public class DiagramGroup {
	/**
	 * Builder for the {@link DiagramGroup} class
	 *
	 */
	public static class Builder {
		private ImmutableCollection<DiagramReference> validProjectDiagrams; // Ignored by hashcode() and equals() to ensure link with editor works.
		private final IProject project;
		private String diagramTypeId;
		private boolean contextRefValid = false;
		private CanonicalBusinessObjectReference contextRef;

		private Builder(final ImmutableCollection<DiagramReference> validProjectDiagrams, final IProject project) {
			this.validProjectDiagrams = Objects.requireNonNull(validProjectDiagrams,
					"validProjectDiagrams must not be null");
			this.project = Objects.requireNonNull(project, "project must not be null");
		}

		/**
		 * Creates a new {@link DiagramGroup} instance based on configured values
		 * @return a new {@link DiagramGroup} instance with configured values
		 */
		public DiagramGroup build() {
			return new DiagramGroup(validProjectDiagrams, project, diagramTypeId, contextRefValid, contextRef);
		}

		/**
		 * Configures the builder to create an instance with the specified diagram type
		 * @param value the group's diagram type
		 * @return this builder to allow method chaining.
		 */
		public Builder diagramType(final String value) {
			this.diagramTypeId = value;
			return this;
		}

		/**
		 * Configures the builder to create an instance with the specified diagram context
		 * @param value the group's diagram context
		 * @return this builder to allow method chaining.
		 */
		public Builder contextReference(final CanonicalBusinessObjectReference value) {
			this.contextRef = value;
			this.contextRefValid = true;
			return this;
		}

		/**
		 * Configures the builder to create an instance with a false value for the context reference valid flag
		 * @return this builder to allow method chaining.
		 */
		public Builder resetContextReference() {
			this.contextRef = null;
			this.contextRefValid = false;
			return this;
		}
	}

	/**
	 * Creates a builder which builds a {@link DiagramGroup}
	 * @param projectDiagrams all the valid diagrams contained in the project.
	 * @param project the group's project
	 * @return the new builder
	 */
	public static Builder builder(final ImmutableCollection<DiagramReference> projectDiagrams,
			final IProject project) {
		return new Builder(projectDiagrams, project);
	}

	/**
	 * Creates a builder which is configured based on an existing group
	 * @param group the group from which to configure the builder
	 * @return the new builder
	 */
	public static Builder builder(final DiagramGroup group) {
		final Builder builder = builder(group.validProjectDiagrams, group.project).diagramType(group.diagramTypeId);
		if (group.contextRefValid) {
			builder.contextReference(group.contextRef);
		}

		return builder;
	}

	private final ImmutableCollection<DiagramReference> validProjectDiagrams; // All valid diagrams in the project. Not just the one that matches the group
	private final IProject project;
	private final String diagramTypeId;
	private boolean contextRefValid; // Indicates whether the contextRef field is valid. The context reference will be null for filtering contextless diagrams.
	private final CanonicalBusinessObjectReference contextRef;

	private DiagramGroup(final ImmutableCollection<DiagramReference> validProjectDiagrams, final IProject project,
			final String diagramTypeId, final boolean contextRefValid,
			final CanonicalBusinessObjectReference contextRef) {
		this.validProjectDiagrams = Objects.requireNonNull(validProjectDiagrams,
				"validProjectDiagrams must not be null");
		this.project = project;
		this.diagramTypeId = diagramTypeId;
		this.contextRefValid = contextRefValid;
		this.contextRef = contextRef;
	}

	/**
	 * Returns the group's project
	 * @return the group's project
	 */
	public final IProject getProject() {
		return project;
	}

	/**
	 * Returns the group's diagram type ID
	 * @return the group's diagram type ID
	 */
	public final String getDiagramTypeId() {
		return diagramTypeId;
	}

	/**
	 * Returns whether the value returned by {@link #getContextReference()} is valid. Valid values may be null
	 * @return whether the group has a valid context reference
	 */
	public final boolean isContextReferenceValid() {
		return contextRefValid;
	}

	/**
	 * Returns the group's diagram context reference
	 * @return the group's diagram context reference
	 */
	public final CanonicalBusinessObjectReference getContextReference() {
		return contextRef;
	}

	/**
	 * Returns the diagrams which meet the group's criteria
	 * @return the diagrams which meet the group's criteria.
	 */
	public final Stream<DiagramReference> findMatchingDiagramReferences() {
		return validProjectDiagrams.stream()
				.filter(dr -> (diagramTypeId == null || diagramTypeId.equals(dr.getDiagramTypeId()))
						&& (!contextRefValid || Objects.equals(contextRef, dr.getContextReference())));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contextRef == null) ? 0 : contextRef.hashCode());
		result = prime * result + (contextRefValid ? 1231 : 1237);
		result = prime * result + ((diagramTypeId == null) ? 0 : diagramTypeId.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
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
		DiagramGroup other = (DiagramGroup) obj;
		if (contextRef == null) {
			if (other.contextRef != null) {
				return false;
			}
		} else if (!contextRef.equals(other.contextRef)) {
			return false;
		}
		if (contextRefValid != other.contextRefValid) {
			return false;
		}
		if (diagramTypeId == null) {
			if (other.diagramTypeId != null) {
				return false;
			}
		} else if (!diagramTypeId.equals(other.diagramTypeId)) {
			return false;
		}
		if (project == null) {
			if (other.project != null) {
				return false;
			}
		} else if (!project.equals(other.project)) {
			return false;
		}
		return true;
	}
}
