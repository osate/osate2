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
