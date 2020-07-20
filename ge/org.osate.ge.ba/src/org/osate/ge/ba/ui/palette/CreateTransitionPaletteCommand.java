package org.osate.ge.ba.ui.palette;

import java.util.Optional;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.operations.Operation;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class CreateTransitionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	private static final StandaloneQuery containerQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier
					|| fa.getBusinessObject() instanceof Subcomponent).first());

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
		/*
		 * if (!ctx.getDestination().getBusinessObject(Mode.class).isPresent()) {
		 * return Optional.empty();
		 * }
		 *
		 * final List<ComponentClassifier> potentialOwners = getPotentialOwners(ctx.getSource(), ctx
		 * .getDestination(),
		 * ctx.getQueryService());
		 * if (potentialOwners.size() == 0) {
		 * return Optional.empty();
		 * }
		 *
		 * final BusinessObjectContext container = getOwnerBoc(ctx.getSource(), ctx.getQueryService());
		 * if (container == null) {
		 * return Optional.empty();
		 * }
		 *
		 * final Mode srcMode = ctx.getSource().getBusinessObject(Mode.class).get();
		 * final Mode dstMode = ctx.getDestination().getBusinessObject(Mode.class).get();
		 *
		 * return Optional.of(Operation.createPromptAndModifyWithExtra(() -> {
		 * // Determine which classifier should own the new element
		 * final ComponentClassifier selectedClassifier = AadlUiUtil.getBusinessObjectToModify(potentialOwners);
		 * if (selectedClassifier == null) {
		 * return Optional.empty();
		 * }
		 *
		 * // Prompt for transition triggers
		 * final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog
		 * .promptForTriggers(selectedClassifier, null);
		 * if (selectedTriggers == null) {
		 * return Optional.empty();
		 * }
		 *
		 * return Optional.of(new BusinessObjectAndExtra<>(selectedClassifier, selectedTriggers));
		 * }, args -> {
		 * final ComponentClassifier cc = args.getBusinessObject();
		 *
		 * // Determine the name for the new mode transition
		 * final String newElementName = AadlNamingUtil.buildUniqueIdentifier(cc, "new_transition");
		 *
		 * // Create the new mode transition
		 * final ModeTransition newModeTransition = cc.createOwnedModeTransition();
		 *
		 * // Clear the no modes flag
		 * cc.setNoModes(false);
		 *
		 * // Set the name
		 * newModeTransition.setName(newElementName);
		 *
		 * // Set the source and destination
		 * newModeTransition.setSource(srcMode);
		 * newModeTransition.setDestination(dstMode);
		 *
		 * // Create Triggers
		 * for (ModeTransitionTriggerInfo selectedPort : args.getExtra()) {
		 * final ModeTransitionTrigger mtt = newModeTransition.createOwnedTrigger();
		 * mtt.setTriggerPort(selectedPort.port);
		 * mtt.setContext(selectedPort.context);
		 * }
		 *
		 * return StepResultBuilder.create().showNewBusinessObject(container, newModeTransition).build();
		 * }));
		 */


		// System.err.println(ctx.getDestination().getBusinessObject(BehaviorState.class).isPresent() + " isPres");

		System.err.println(ctx.getSource().getParent().getBusinessObject(Classifier.class).get() + " getAA");


		if (!ctx.getDestination().getBusinessObject(BehaviorState.class).isPresent()) {
			return Optional.empty();
		}

		final BusinessObjectContext container = getOwnerBoc(ctx.getSource(), ctx.getQueryService());
		if (container == null) {
			return Optional.empty();
		}

		final BehaviorState srcState = ctx.getSource().getBusinessObject(BehaviorState.class).get();
		final BehaviorState dstState = ctx.getDestination().getBusinessObject(BehaviorState.class).get();

		// Optional.of(Operation.createSimple(container, containerBoType, modifier);
		// Optional.of(Operation.createWithBuilder(b -> b.c));

		return Optional.empty();
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(containerQuery, modeBoc);
	}
}
