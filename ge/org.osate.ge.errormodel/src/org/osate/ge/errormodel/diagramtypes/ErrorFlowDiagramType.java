/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.ge.errormodel.filters.PropagationPointFilter;
import org.osate.ge.errormodel.filters.UsedKeywordPropagationPointFilter;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

/**
 * Diagram type which shows a classifier's error flows and related elements.
 */
public class ErrorFlowDiagramType implements DiagramType {
	private static final String ID = "em.errorFlow";
	private static final ImmutableSet<String> DEFAULT_CLASSIFIER_AND_SUBCOMPONENT_FILTERS = ImmutableSet.of(
			AadlContentFilterIds.FEATURES, UsedKeywordPropagationPointFilter.ID,
			PropagationPointFilter.ID, ErrorFlowFilter.ID);
	private static final ImmutableSet<String> DEFAULT_PROPAGATION_POINT_FILTERS = ImmutableSet
			.of(ErrorPropagationFilter.ID);

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
			return DEFAULT_CLASSIFIER_AND_SUBCOMPONENT_FILTERS;
		} else if (bo instanceof Feature || bo instanceof PropagationPoint || bo instanceof KeywordPropagationPoint) {
			return DEFAULT_PROPAGATION_POINT_FILTERS;
		}

		return ImmutableSet.of();
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of();
	}
}
