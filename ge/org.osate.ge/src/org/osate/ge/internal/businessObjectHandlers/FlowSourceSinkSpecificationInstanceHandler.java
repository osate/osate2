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
package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.FlowKind;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.query.Supplier;
import org.osate.ge.services.QueryService;

public class FlowSourceSinkSpecificationInstanceHandler extends FlowSpecificationInstanceHandler {
	private static final Supplier<FlowSpecificationInstance, Object[]> getPathToFlowSpecificationInstance = (
			fsi) -> AadlHelper.getPathToBusinessObject(fsi.getComponentInstance(),
					fsi.getFlowSpecification().getKind() == FlowKind.SOURCE ? fsi.getDestination() : fsi.getSource());
	private static final StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference(getPathToFlowSpecificationInstance).first());
	private static final StandaloneQuery partialSrcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference(getPathToFlowSpecificationInstance, 1).first());

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		final FlowKind flowKind = fsi.getFlowSpecification().getKind();
		return flowKind == FlowKind.SOURCE || flowKind == FlowKind.SINK;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		boolean partial = false;

		if (src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY);
		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create()
				.graphic(AadlGraphics.getFlowSpecificationGraphic(fsi.getFlowSpecification())).style(sb.build())
				.source(src).build();
	}
}
