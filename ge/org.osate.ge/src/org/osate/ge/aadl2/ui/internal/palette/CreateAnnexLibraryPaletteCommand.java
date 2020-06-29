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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.ge.Categories;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.ui.internal.dialogs.AnnexNameDialog;
import org.osate.ge.operations.BusinessObjectAndExtra;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

public class CreateAnnexLibraryPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {

	public CreateAnnexLibraryPaletteCommand() {
		super("Annex Library", Categories.MISC, AadlImages.getImage(getDefaultAnnexLibrary()));

	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(AadlPackage.class).map(readonlyPkg -> Operation.createPromptAndModifyWithExtra(() -> {
			final AnnexNameDialog annexNameDialog = new AnnexNameDialog(Display.getCurrent().getActiveShell(),
					readonlyPkg, "Create Annex Library", "Enter a name for the new Annex Library.");
			if (annexNameDialog.open() == Window.CANCEL || annexNameDialog.getValue() == null) {
				return Optional.empty();
			}

			return Optional.of(new BusinessObjectAndExtra<>(readonlyPkg, annexNameDialog.getValue()));
		}, args -> {
			final DefaultAnnexLibrary annexLibrary = (DefaultAnnexLibrary) args.getBusinessObject()
					.getPublicSection()
					.createOwnedAnnexLibrary(getDefaultAnnexLibrary());
			annexLibrary.setSourceText("{** \n**}");
			annexLibrary.setName(args.getExtra());

			return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), annexLibrary).build();
		}));
	}

	private static EClass getDefaultAnnexLibrary() {
		return Aadl2Package.eINSTANCE.getDefaultAnnexLibrary();
	}
}
