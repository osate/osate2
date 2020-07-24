package org.osate.ge.ba.ui.palette;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.ba.util.BaNamingUtil;
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
					final BehaviorAnnex ba = BaUtil.createBehaviorAnnex(modifyBo);
					ba.setName("behavior_specification");

					// Create the state
					final BehaviorState newState = (BehaviorState) EcoreUtil
							.create(AadlBaPackage.eINSTANCE.getBehaviorState());
					final String newName = BaNamingUtil.buildUniqueIdentifier(ba, "new_state");
					newState.setName(newName);

					// Set as initial state if the behavior annex does not have an initial state.
					if (ba.getInitialState() == null) {
						newState.setInitial(true);
					}

					newState.setFinal(true);

					// Add the new state to the behavior annex
					ba.getStates().add(newState);

					return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), ba).build();
				})).orElse(Optional.empty());
	}
}
