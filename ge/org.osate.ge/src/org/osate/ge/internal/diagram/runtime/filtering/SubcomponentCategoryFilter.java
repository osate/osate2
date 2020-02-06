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
package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Objects;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.ContentFilter;

public class SubcomponentCategoryFilter implements ContentFilter {
	private final ComponentCategory category;
	private final String id;

	public SubcomponentCategoryFilter(final ComponentCategory category) {
		this.category = Objects.requireNonNull(category, "category must not be null");
		this.id = getId(category);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getParentId() {
		return SubcomponentFilter.ID;
	}

	@Override
	public String getName() {
		switch (category) {
		case ABSTRACT:
			return "Abstract Subcomponents";
		case BUS:
			return "Buses";
		case DATA:
			return "Data";
		case DEVICE:
			return "Devices";
		case MEMORY:
			return "Memories";
		case PROCESS:
			return "Processes";
		case PROCESSOR:
			return "Processors";
		case SUBPROGRAM:
			return "Subprograms";
		case SUBPROGRAM_GROUP:
			return "Subprogram Groups";
		case SYSTEM:
			return "Systems";
		case THREAD:
			return "Threads";
		case THREAD_GROUP:
			return "Thread Groups";
		case VIRTUAL_BUS:
			return "Virtual Buses";
		case VIRTUAL_PROCESSOR:
			return "Virtual Processors";
		default:
			throw new RuntimeException("Unsupported category: " + category);

		}
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentImplementation || bo instanceof Subcomponent || bo instanceof ComponentInstance;
	}

	@Override
	public boolean test(Object bo) {
		return (bo instanceof Subcomponent && ((Subcomponent) bo).getCategory() == category)
				|| (bo instanceof ComponentInstance && ((ComponentInstance) bo).getCategory() == category);
	}

	public static String getId(final ComponentCategory category) {
		return FilterUtil.componentCategoryToIdPrefix(category) + "Subcomponents";
	}
}
