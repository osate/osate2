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
package org.osate.ge.errormodel.diagramtypes;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.DiagramType;
import org.osate.ge.aadl2.AadlContentFilterIds;
import org.osate.ge.errormodel.filters.ErrorFlowFilter;
import org.osate.ge.errormodel.filters.ErrorPropagationFilter;
import org.osate.ge.errormodel.filters.KeywordPropagationPointFilter;
import org.osate.ge.errormodel.filters.PropagationPointFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public class ErrorFlowDiagramType implements DiagramType {
	private final static String ID = "em.errorFlow";
	private final ImmutableSet<String> defaultClassifierAndSubcomponentFilters = ImmutableSet.of(
			AadlContentFilterIds.FEATURES, AadlContentFilterIds.INTERNAL_FEATURES, AadlContentFilterIds.PROCESSOR_FEATURES,
			KeywordPropagationPointFilter.ID, PropagationPointFilter.ID, ErrorFlowFilter.ID);
	private final ImmutableSet<String> defaultFeatureFilters = ImmutableSet.of(ErrorPropagationFilter.ID);

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Flow Diagram";
	}

	@Override
	public boolean isApplicableToContext(Object contextBo) {
		return contextBo instanceof Classifier;
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof Classifier || bo instanceof Subcomponent) {
			return defaultClassifierAndSubcomponentFilters;
		} else if (bo instanceof Feature) {
			return defaultFeatureFilters;
		}

		return ImmutableSet.of();
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of();
	}
}
