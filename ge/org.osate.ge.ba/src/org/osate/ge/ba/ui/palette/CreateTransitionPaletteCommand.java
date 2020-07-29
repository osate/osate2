package org.osate.ge.ba.ui.palette;

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ba.model.BehaviorAnnexState;
import org.osate.ge.ba.model.BehaviorAnnexTransition;
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
		// TODO any other conditions for starting?
		return ctx.getSource().getBusinessObject(BehaviorAnnexState.class).isPresent();
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		if (!ctx.getDestination().getBusinessObject(BehaviorAnnexState.class).isPresent()) {
			return Optional.empty();
		}

		final BusinessObjectContext srcContainer = getOwnerBoc(ctx.getSource(), ctx.getQueryService());
		if (srcContainer == null) {
			return Optional.empty();
		}

		final BusinessObjectContext dstContainer = getOwnerBoc(ctx.getDestination(), ctx.getQueryService());
		if (dstContainer != srcContainer) {
			return Optional.empty();
		}

//		final BehaviorState srcState = ctx.getSource().getBusinessObject(BehaviorAnnexState.class)
//				.map(BehaviorAnnexState::getState).get();
//		final BehaviorState dstState = ctx.getDestination().getBusinessObject(BehaviorAnnexState.class)
//				.map(BehaviorAnnexState::getState).get();

		final BehaviorAnnexState srcState = ctx.getSource().getBusinessObject(BehaviorAnnexState.class).get();
		final BehaviorAnnexState dstState = ctx.getDestination().getBusinessObject(BehaviorAnnexState.class).get();
		if (srcState == dstState) {
			return Optional.empty();
		}

		// TODO as a rule, if it serializes do not set things myself, vs just errors like with states, look at setting initial/final
		// if it serializes do not set myself

		// TODO find same name for src and dest as a test, look into how behavior annex extends and stuff to see if this can break
		return srcContainer.getBusinessObject(BehaviorAnnex.class)
				.map(ba -> Operation.createSimple(srcContainer, BehaviorAnnex.class, boToModify -> {
					final BehaviorTransition baTransition = (BehaviorTransition) EcoreUtil
							.create(AadlBaPackage.eINSTANCE.getBehaviorTransition());

					final EList<BehaviorState> behaviorStates = boToModify.getStates();

					final String srcName = srcState.getState().getName();
					final String dstName = dstState.getState().getName();

					// Set source and destination for transition
					for (final BehaviorState behaviorState : behaviorStates) {
						Optional.ofNullable(behaviorState.getName()).ifPresent(name -> {
							if (name.equalsIgnoreCase(srcName)) { // Source
								baTransition.setSourceState(behaviorState);
							} else if (name.equalsIgnoreCase(dstName)) { // Destination
								baTransition.setDestinationState(behaviorState);
							}
						});
					}

					// Add new transition
					boToModify.getTransitions().add(baTransition);

					// Show
					return StepResultBuilder.create()
							.showNewBusinessObject(srcContainer,
									new BehaviorAnnexTransition(baTransition, srcState, dstState))
							.build();
				})).orElse(Optional.empty());
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(containerQuery, modeBoc);
	}
}
