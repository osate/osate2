package org.osate.ge.ba.ui.palette;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class CreateTransitionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	private static final StandaloneQuery containerQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof BehaviorAnnex).first());

	public CreateTransitionPaletteCommand() {
		super("Transition", BaPaletteCategories.BEHAVIOR_ANNEX, null);
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		/*
		 * return ctx.getSource().getBusinessObject(Mode.class).isPresent()
		 * && getPotentialOwnersByMode(ctx.getSource(), ctx.getQueryService()).size() > 0;
		 */
		return ctx.getSource().getBusinessObject(BehaviorState.class).isPresent();
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		if (!ctx.getDestination().getBusinessObject(BehaviorState.class).isPresent()) {
			return Optional.empty();
		}

		final BusinessObjectContext container = getOwnerBoc(ctx.getSource(), ctx.getQueryService());
		if (container == null) {
			return Optional.empty();
		}

		final Optional<BehaviorAnnex> baOpt = container.getBusinessObject(BehaviorAnnex.class);
		if (baOpt.isPresent()) {

			// return Optional.of(Operation.createSimple(container, BehaviorAnnex.class, baToModify -> {
			// return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), baTransition).build();
			// }));
		}

		return container.getBusinessObject(BehaviorAnnex.class)
				.map(ba -> Operation.createSimple(container, BehaviorAnnex.class, boToModify -> {
					final BehaviorState srcState = ctx.getSource().getBusinessObject(BehaviorState.class).get();
					final BehaviorState dstState = ctx.getDestination().getBusinessObject(BehaviorState.class).get();
					final BehaviorTransition baTransition = (BehaviorTransition) EcoreUtil
							.create(AadlBaPackage.eINSTANCE.getBehaviorTransition());

					baTransition.setSourceState(srcState);
					baTransition.setDestinationState(dstState);
					// boToModify.getTransitions().add(baTransition);

					return StepResultBuilder.create().showNewBusinessObject(container, baTransition).build();
				})).orElse(Optional.empty());


		// Optional.of(Operation.createSimple(container, containerBoType, modifier);
		// Optional.of(Operation.createWithBuilder(b -> b.c));

		// return Optional.empty();
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(containerQuery, modeBoc);
	}
}
