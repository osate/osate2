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
package org.osate.ge.errormodel.businessObjectHandlers;

import java.util.Optional;

import javax.inject.Named;

import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;

/**
 * Branchless error behavior transitions are represented as a single connection from the source to the target.
 * If the transition has a branch, the transition business object is represented as a shape which serves as a branch point. In that case
 * the business object provider will contribute a trunk object and branch objects as children of the transition.
 * The trunk will be represented as a connection between the source and the branch point.
 * The branches will be represented as a connection from the branch point to the target.
 */
public class ErrorBehaviorTransitionHandler {
	private static final Graphic branchPointGraphic = EllipseBuilder.create().fixedSize(new Dimension(8, 8)).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference(ebt -> ((ErrorBehaviorTransition) ebt).getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(ebt -> {
				final ErrorBehaviorTransition t = (ErrorBehaviorTransition) ebt;
				return t.isSteadyState() ? t.getSource() : t.getTarget();
			}));
	private static Style branchPointStyle = StyleBuilder.create().backgroundColor(Color.BLACK).labelsAboveTop()
			.labelsLeft().primaryLabelVisible(false).build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		if (transition.getDestinationBranches().isEmpty()) {
			return GraphicalConfigurationBuilder.create().graphic(ErrorModelGeUtil.transitionConnectionGraphic)
					.style(ErrorModelGeUtil.transitionConnectionStyle).source(getSource(boc, queryService))
					.destination(getDestination(boc, queryService)).build();
		} else {
			return GraphicalConfigurationBuilder.create().graphic(branchPointGraphic).style(branchPointStyle).build();
		}

	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition bo) {
		final String name = bo.getName() == null ? "" : bo.getName() + ": ";
		return name + getText(bo.getCondition()).map(t -> "-[" + t + "]").orElse("");
	}

	private static Optional<String> getText(final ConditionExpression e) {
		return Optional.ofNullable(e).map(el -> NodeModelUtils.findActualNodeFor(el)).map(n -> n.getText());
	}

	@GetNameForEditing
	public String getNameForEditing(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition bo) {
		return bo.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition,
			final @Named(Names.NAME) String value) {
		final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine) transition.eContainer();
		return ErrorModelNamingUtil.validateName(stateMachine, transition.getName(), value);
	}
}
