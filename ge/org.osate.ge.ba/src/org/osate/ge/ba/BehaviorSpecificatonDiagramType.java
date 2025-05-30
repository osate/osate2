/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba;

import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.DiagramType;
import org.osate.ge.ba.filters.BehaviorStateFilter;
import org.osate.ge.ba.filters.BehaviorTransitionFilter;
import org.osate.ge.ba.filters.BehaviorVariableFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

/**
 * Diagram type for behavior specifications. Automatically includes variables, transitions, and state.
 * @since 2.0
 *
 */
public class BehaviorSpecificatonDiagramType implements DiagramType {
	/**
	 * Unique identifier for the behavior specification diagram type
	 */
	public final static String ID = "ba.behavior_specification";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Behavior Specification";
	}

	@Override
	public boolean isApplicableToContext(final Object contextBo) {
		return contextBo instanceof DefaultAnnexSubclause
				&& BehaviorAnnexReferenceUtil.ANNEX_NAME
						.equalsIgnoreCase(((DefaultAnnexSubclause) contextBo).getName());
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof BehaviorAnnex) {
			return ImmutableSet.of(BehaviorVariableFilter.ID, BehaviorTransitionFilter.ID, BehaviorStateFilter.ID);
		}

		return ImmutableSet.of();
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of();
	}
}
