/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.Connection;
import org.osate.aadl2.Mode;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * The modal declarations a semantic connection path passes through, in traversal
 * order.
 *
 * <p>
 * This is descriptive state for identity, diagnostics, and tests. It does not
 * replace the mode and system operation mode pipeline: a topologically valid path is
 * not discarded here because its modes have no compatible system operation mode. The
 * existing pipeline materializes such a path, {@code fillInModes()} computes its
 * system operation modes, emits the existing warning when none are active, and
 * deletes it. Deciding earlier would change which diagnostics a model produces.
 * </p>
 *
 * @param requirements one entry per traversed declaration that carries an in-modes
 *            clause, in traversal order
 */
public record ModeConstraint(List<Requirement> requirements) {

	/** No traversed declaration is modal. */
	public static final ModeConstraint UNCONSTRAINED = new ModeConstraint(List.of());

	public ModeConstraint {
		requirements = List.copyOf(requirements);
	}

	/**
	 * One traversed declaration's in-modes clause, together with the component
	 * instance whose modes those are.
	 *
	 * @param declaration the modal connection declaration
	 * @param context the component instance the declaration belongs to
	 * @param modes the modes the declaration is active in
	 */
	public record Requirement(Connection declaration, ComponentInstance context, List<Mode> modes) {

		public Requirement {
			if (declaration == null || context == null) {
				throw new IllegalArgumentException("A mode requirement needs a declaration and a context");
			}
			modes = List.copyOf(modes);
		}

		public String key() {
			StringBuilder key = new StringBuilder(PathKeys.declarative(declaration));
			key.append('@').append(PathKeys.instance(context)).append('[');
			for (Mode mode : modes) {
				key.append(PathKeys.declarative(mode)).append(',');
			}
			return key.append(']').toString();
		}
	}

	/**
	 * This constraint plus the in-modes clause of {@code declaration}, or this
	 * constraint unchanged when the declaration is not modal. Returns a new
	 * constraint; this one is unchanged.
	 */
	public ModeConstraint and(Connection declaration, ComponentInstance context) {
		List<Mode> modes = declaration.getAllInModes();
		if (modes == null || modes.isEmpty()) {
			return this;
		}
		List<Requirement> extended = new ArrayList<>(requirements);
		extended.add(new Requirement(declaration, context, modes));
		return new ModeConstraint(extended);
	}

	public boolean isUnconstrained() {
		return requirements.isEmpty();
	}

	/** Stable identity of the constraint. Never uses object identity. */
	public String key() {
		StringBuilder key = new StringBuilder();
		for (Requirement requirement : requirements) {
			key.append(requirement.key()).append(';');
		}
		return key.toString();
	}
}
