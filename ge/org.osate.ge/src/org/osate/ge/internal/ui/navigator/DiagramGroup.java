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
package org.osate.ge.internal.ui.navigator;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.services.DiagramService.DiagramReference;

public class DiagramGroup {
	public static class Builder {
		private Collection<DiagramReference> validProjectDiagrams; // Ignored by hashcode() and equals() to ensure link with editor works.
		private IProject project;
		private String diagramTypeId;
		private boolean contextRefValid = false;
		private CanonicalBusinessObjectReference contextRef;

		public Builder(final Collection<DiagramReference> validProjectDiagrams, final IProject project) {
			this.validProjectDiagrams = Objects.requireNonNull(validProjectDiagrams,
					"validProjectDiagrams must not be null");
			this.project = Objects.requireNonNull(project, "project must not be null");
		}

		public DiagramGroup build() {
			return new DiagramGroup(validProjectDiagrams, project, diagramTypeId, contextRefValid, contextRef);
		}

		public Builder project(final IProject value) {
			this.project = value;
			return this;
		}

		public Builder diagramType(final String value) {
			this.diagramTypeId = value;
			return this;
		}

		public Builder contextReference(final CanonicalBusinessObjectReference value) {
			this.contextRef = value;
			this.contextRefValid = true;
			return this;
		}

		public Builder resetContextReference() {
			this.contextRef = null;
			this.contextRefValid = false;
			return this;
		}
	}

	public static Builder builder(final Collection<DiagramReference> projectDiagrams,
			final IProject project) {
		return new Builder(projectDiagrams, project);
	}

	public static Builder builder(final DiagramGroup group) {
		final Builder builder = builder(group.validProjectDiagrams, group.project).diagramType(group.diagramTypeId);
		if (group.contextRefValid) {
			builder.contextReference(group.contextRef);
		}

		return builder;
	}

	private final Collection<DiagramReference> validProjectDiagrams; // All valid diagrams in the project. Not just the one that matches the group
	private final IProject project;
	private final String diagramTypeId;
	private boolean contextRefValid; // Indicates whether the contextRef field is valid. The context reference will be null for filtering contextless diagrams.
	private final CanonicalBusinessObjectReference contextRef;

	public DiagramGroup(final Collection<DiagramReference> validProjectDiagrams, final IProject project,
			final String diagramTypeId, final boolean contextRefValid,
			final CanonicalBusinessObjectReference contextRef) {
		this.validProjectDiagrams = Objects.requireNonNull(validProjectDiagrams,
				"validProjectDiagrams must not be null");
		this.project = project;
		this.diagramTypeId = diagramTypeId;
		this.contextRefValid = contextRefValid;
		this.contextRef = contextRef;
	}

	public final IProject getProject() {
		return project;
	}

	public final String getDiagramTypeId() {
		return diagramTypeId;
	}

	public final boolean isContextReferenceValid() {
		return contextRefValid;
	}

	public final CanonicalBusinessObjectReference getContextReference() {
		return contextRef;
	}

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
