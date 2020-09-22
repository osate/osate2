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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class CreateTypeAliasPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateTypeAliasPaletteCommand() {
		super("Error Type Alias", ErrorModelPaletteCategories.ERROR_TYPES, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ErrorModelGeUtil.createErrorModelLibraryPromptAndModifyOperation(ctx.getTarget(), () -> {
			// Prompt user to select an ErrorType
			final AadlPackage pkg = ctx.getTarget().getBusinessObject(AadlPackage.class).get();
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);

			final ErrorModelObjectDescriptionCollectionSingleSelectorModel model = new ErrorModelObjectDescriptionCollectionSingleSelectorModel(
					AadlModelAccessUtil.getAllEObjectsByType(project, ErrorModelPackage.eINSTANCE.getErrorType()));
			if (!FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(), "Select Error Type to Alias",
					new LabelFilteringListSelectorModel<>(model))) {
				return Optional.empty();
			}

			final ErrorType errorType = (ErrorType) model.getSelectedElement().getEObjectOrProxy();
			return Optional.of(errorType);
		}, (lib, aliasedType) -> {
			// Type aliases are just error types with an alias set. Create a new type and set the aliased type
			final ErrorType newErrorTypeAlias = ErrorModelFactory.eINSTANCE.createErrorType();
			final String newErrorTypeName = ErrorModelNamingUtil.buildUniqueIdentifier(lib, "new_error_type_alias");
			newErrorTypeAlias.setName(newErrorTypeName);
			newErrorTypeAlias.setAliasedType(aliasedType);

			// Add the new type to the error model library
			lib.getTypes().add(newErrorTypeAlias);

			return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), newErrorTypeAlias).build();
		});
	}
}
