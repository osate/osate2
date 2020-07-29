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

import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.ProjectUtil;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.errormodel.ui.viewmodels.ErrorModelObjectDescriptionCollectionSingleSelectorModel;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

public class CreateTypeSetAliasPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateTypeSetAliasPaletteCommand() {
		super("Error Type Set Alias", ErrorModelPaletteCategories.ERROR_MODEL, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ErrorModelGeUtil.createErrorModelLibraryPromptAndModifyOperation(ctx.getTarget(), () -> {
			// Prompt user to select an TypeSet
			final AadlPackage pkg = ctx.getTarget().getBusinessObject(AadlPackage.class).get();
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);

			final ErrorModelObjectDescriptionCollectionSingleSelectorModel model = new ErrorModelObjectDescriptionCollectionSingleSelectorModel(
					AadlModelAccessUtil.getAllEObjectsByType(project, ErrorModelPackage.eINSTANCE.getTypeSet()));
			if (!FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(), "Select Type Set to Alias",
					new LabelFilteringListSelectorModel<>(model))) {
				return Optional.empty();
			}

			final TypeSet typeSet = (TypeSet) model.getSelectedElement().getEObjectOrProxy();
			return Optional.of(typeSet);
		}, (lib, typeSetToAlias) -> {
			final TypeSet newTypeSet = (TypeSet) EcoreUtil.create(ErrorModelPackage.eINSTANCE.getTypeSet());
			final String newTypeSetName = ErrorModelNamingUtil.buildUniqueIdentifier(lib, "new_error_type_set_alias");
			newTypeSet.setName(newTypeSetName);
			newTypeSet.setAliasedType(typeSetToAlias);
			lib.getTypesets().add(newTypeSet);

			return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), newTypeSet).build();
		});
	}
}
