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
package org.osate.ge.aadl2.internal.diagramtypes;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.DiagramType;
import org.osate.ge.aadl2.internal.contentfilters.SubcomponentCategoryFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public class ProcessorBindingDiagramType implements DiagramType {
	private final ImmutableSet<String> defaultClassifierOrSubcomponentFilters = ImmutableSet.of(
			SubcomponentCategoryFilter.getId(ComponentCategory.SYSTEM),
			SubcomponentCategoryFilter.getId(ComponentCategory.PROCESSOR),
			SubcomponentCategoryFilter.getId(ComponentCategory.VIRTUAL_PROCESSOR),
			SubcomponentCategoryFilter.getId(ComponentCategory.DEVICE),
			SubcomponentCategoryFilter.getId(ComponentCategory.THREAD),
			SubcomponentCategoryFilter.getId(ComponentCategory.THREAD_GROUP),
			SubcomponentCategoryFilter.getId(ComponentCategory.PROCESS));

	@Override
	public String getId() {
		return "processorBinding";
	}

	@Override
	public String getName() {
		return "Processor Binding Diagram";
	}

	@Override
	public boolean isApplicableToContext(final Object contextBo) {
		return contextBo instanceof ComponentImplementation
				|| contextBo instanceof SystemInstance;
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof Classifier || bo instanceof Subcomponent || bo instanceof ComponentInstance) {
			return defaultClassifierOrSubcomponentFilters;
		}

		return AadlDiagramTypeUtil.getDefaultContentFilters(bo);
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of("deployment_properties::actual_processor_binding");
	}
}
