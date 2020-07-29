package org.osate.ge.ba.ui.palette;

import java.util.Optional;

import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.ba.util.BaUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

public class CreateBehaviorAnnexPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateBehaviorAnnexPaletteCommand() {
		super("Behavior Annex", BaPaletteCategories.BEHAVIOR_ANNEX, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(Classifier.class)
				.map(c -> Operation.createSimple(ctx.getTarget(), Classifier.class, modifyBo -> {
					// Create
					final BehaviorAnnex ba = BaUtil.createBehaviorAnnex(modifyBo);

					// Create the state
//					final BehaviorState newState = (BehaviorState) EcoreUtil
//							.create(AadlBaPackage.eINSTANCE.getBehaviorState());
//					final String newName = BaNamingUtil.buildUniqueIdentifier(ba, "new_state");
//					newState.setName(newName);
//
//					// Set state to initial and final
//					// TODO experiment with this. do not set if serialization errors do not occur.
//					// TODO do not create state unless serialization errors occer as well.
//					newState.setInitial(true);
//					newState.setFinal(true);
//
//					// Add the new state to the behavior annex
//					ba.getStates().add(newState);

					// Show as owner DefaultAnnexSubclause
					return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), ba.getOwner()).build();
				})).orElse(Optional.empty());
	}
}
