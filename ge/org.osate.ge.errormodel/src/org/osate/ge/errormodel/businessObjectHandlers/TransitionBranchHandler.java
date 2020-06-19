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

import javax.inject.Named;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.internal.di.DeleteRaw;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

/**
 * @see ErrorBehaviorTransitionHandler for details about how transitions are represented.
 */
public class TransitionBranchHandler {
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(2).children()
			.filterByBusinessObjectRelativeReference(b -> ((TransitionBranch) b).eContainer()));
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.ancestor(2).children()
					.filterByBusinessObjectRelativeReference(b -> {
						final TransitionBranch branch = (TransitionBranch) b;
						return branch.isSteadyState() ? ((ErrorBehaviorTransition) branch.eContainer()).getSource()
								: branch.getTarget();
					}));

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) TransitionBranch branch) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().graphic(ErrorModelGeUtil.transitionConnectionGraphic)
				.style(ErrorModelGeUtil.transitionConnectionStyle)
				.source(getSource(boc, queryService))
				.destination(getDestination(boc, queryService)).build();
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@DeleteRaw
	public void delete(final @Named(Names.BUSINESS_OBJECT) TransitionBranch branchReadonly,
			final AadlModificationService modService) {
		modService.modify(branchReadonly, (branch) -> {
			final ErrorBehaviorTransition transition = (ErrorBehaviorTransition) branch.eContainer();
			EcoreUtil.remove(branch);

			if (transition.getDestinationBranches().size() == 1) {
				final TransitionBranch remainingBranch = transition.getDestinationBranches().get(0);
				if (remainingBranch.isSteadyState()) {
					transition.setSteadyState(true);
				} else {
					transition.setTarget(remainingBranch.getTarget());
					transition.setTargetToken(remainingBranch.getTargetToken());
				}

				transition.getDestinationBranches().clear();
			}
		});
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) TransitionBranch branch) {
		final BranchValue value = branch.getValue();
		if (value == null) {
			return null;
		}

		if (value.getRealvalue() != null) {
			return value.getRealvalue();
		}

		if (value.isOthers()) {
			return "others";
		}

		if (value.getSymboliclabel() != null) {
			return value.getSymboliclabel().getQualifiedName();
		}

		return null;
	}
}
