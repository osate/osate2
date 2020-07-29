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
package org.osate.ge.errormodel.ui.palette;

import java.util.Collections;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.ProjectUtil;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorDialog;
import org.osate.ge.errormodel.ui.viewmodels.BasicTypeTokenListEditorModel;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

public class CreateTypeSetPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateTypeSetPaletteCommand() {
		super("Error Type Set", ErrorModelPaletteCategories.ERROR_MODEL, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ErrorModelGeUtil.createErrorModelLibraryPromptAndModifyOperation(ctx.getTarget(), () -> {
			// Prompt for contents of type set. This just gets the first type for testing..
			final AadlPackage pkg = ctx.getTarget().getBusinessObject(AadlPackage.class).get();
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
			final BasicTypeTokenListEditorModel model = new BasicTypeTokenListEditorModel(project,
					Collections.emptyList());
			if (TypeTokenListEditorDialog.open(Display.getDefault().getActiveShell(), "Select Type Tokens",
					model)) {
				return Optional.of(model.getTypeTokenList());
			} else {
				return Optional.empty();
			}
		}, (lib, typeTokens) -> {
			final TypeSet newTypeSet = (TypeSet) EcoreUtil.create(ErrorModelPackage.eINSTANCE.getTypeSet());
			final String newTypeSetName = ErrorModelNamingUtil.buildUniqueIdentifier(lib, "new_error_type_set");
			newTypeSet.setName(newTypeSetName);
			newTypeSet.getTypeTokens().addAll(typeTokens);
			lib.getTypesets().add(newTypeSet);

			return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), newTypeSet).build();
		});
	}
}
