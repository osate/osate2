/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.Optional;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.AadlCategories;
import org.osate.ge.aadl2.AadlImportsUtil;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.ui.AadlOperationBuilder;
import org.osate.ge.aadl2.ui.internal.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.aadl2.ui.internal.dialogs.SelectSubprogramDialog;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

public class CreateSubprogramCallSequencePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {

	public CreateSubprogramCallSequencePaletteCommand() {
		super("Subprogram Call Sequence", AadlCategories.SUBPROGRAM_CALLS,
				AadlImages.getImage(Aadl2Package.eINSTANCE.getSubprogramCallSequence()));
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		final BusinessObjectContext targetBoc = ctx.getTarget();
		final Object targetBo = targetBoc.getBusinessObject();

		if (!getClassifierOpBuilder().canBuildOperation(targetBo)) {
			return Optional.empty();
		}

		// Used to pass arguments between steps
		class CreateArgs {
			final BehavioredImplementation bi;
			final CallContext callContext;
			final CalledSubprogram calledSubprogram;

			public CreateArgs(final BehavioredImplementation bi, final CallContext callContext,
					final CalledSubprogram calledSubprogram) {
				this.bi = bi;
				this.callContext = callContext;
				this.calledSubprogram = calledSubprogram;
			}
		}

		return Optional.of(Operation.createWithBuilder(createOp -> {
			getClassifierOpBuilder().buildOperation(createOp, targetBo).map(ci -> {
				final BehavioredImplementation bi = (BehavioredImplementation) ci;
				final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(
						bi);
				final SelectSubprogramDialog dlg = new SelectSubprogramDialog(Display.getCurrent().getActiveShell(),
						subprogramSelectionModel);
				if (dlg.open() == Window.CANCEL) {
					return StepResult.abort();
				}

				// Get the CallContext and Called Subprogram
				final CallContext callContext = subprogramSelectionModel.getCallContext(dlg.getSelectedContext());
				final CalledSubprogram calledSubprogram = subprogramSelectionModel
						.getCalledSubprogram(dlg.getSelectedSubprogram());

				return StepResult.forValue(new CreateArgs(bi, callContext, calledSubprogram));
			}).modifyModel(null, (tag, createArgs) -> createArgs.bi, (tag, bi, createArgs) -> {
				final String newScsName = AadlNamingUtil.buildUniqueIdentifier(bi, "new_call_sequence");
				final String initialSubprogramCallName = AadlNamingUtil.buildUniqueIdentifier(bi, "new_call");

				final SubprogramCallSequence newScs = bi.createOwnedSubprogramCallSequence();
				newScs.setName(newScsName);

				// Create an initial call. Needed because call sequences must have at least one call
				final SubprogramCall initialSubprogramCall = newScs.createOwnedSubprogramCall();
				initialSubprogramCall.setName(initialSubprogramCallName);
				initialSubprogramCall.setContext(createArgs.callContext);
				initialSubprogramCall.setCalledSubprogram(createArgs.calledSubprogram);

				AadlImportsUtil.ensurePackageIsImportedForClassifier(bi, createArgs.callContext);
				AadlImportsUtil.ensurePackageIsImportedForClassifier(bi, createArgs.calledSubprogram);

				return StepResultBuilder.create().showNewBusinessObject(targetBoc, newScs).build();
			});
		}));
	}

	private static AadlOperationBuilder<ComponentImplementation> getClassifierOpBuilder() {
		return AadlOperationBuilder.componentImplementations().filter(ci -> ci instanceof BehavioredImplementation);
	}
}
