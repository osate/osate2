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
package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.internal.ui.dialogs.SelectSubprogramDialog;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.services.QueryService;

public class SubprogramCallHandler {
	private Graphic graphic = EllipseBuilder.create().build();
	private Style style = StyleBuilder.create().dashed().labelsCenter().build();

	@IsApplicable
	@CanRename
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage
				|| diagramBo instanceof ComponentImplementation;
		if (!applicable) {
			return null;
		}

		return new PaletteEntry[] { PaletteEntryBuilder.create().label("Subprogram Call")
				.icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getSubprogramCall()))
				.category(Categories.SUBPROGRAM_CALLS).build() };
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().graphic(graphic).style(style).build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return call.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call,
			final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(call, value);
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) SubprogramCallSequence cs,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final QueryService queryService) {
		return cs.getContainingClassifier() instanceof BehavioredImplementation;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final NamingService namingService, final QueryService queryService) {
		return Operation.create(createOp -> {
			createOp.supply(() -> StepResult.forValue((SubprogramCallSequence) targetBoc.getBusinessObject()))
			.modifyPreviousResult(cs -> {
				if (!(cs.getContainingClassifier() instanceof BehavioredImplementation)) {
					throw new RuntimeException("Unexpected case. Unable to find BehavioredImplementation");
				}

				final BehavioredImplementation bi = (BehavioredImplementation) cs.getContainingClassifier();

				final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(
						bi);
				final SelectSubprogramDialog dlg = new SelectSubprogramDialog(
						Display.getCurrent().getActiveShell(), subprogramSelectionModel);
				if (dlg.open() == Window.CANCEL) {
					return null;
				}

				// Get the CallContext and Called Subprogram
				final CallContext callContext = subprogramSelectionModel
						.getCallContext(dlg.getSelectedContext());
				final CalledSubprogram calledSubprogram = subprogramSelectionModel
						.getCalledSubprogram(dlg.getSelectedSubprogram());
				final String newSubprogramCallName = namingService.buildUniqueIdentifier(bi, "new_call");

				// Create the call.
				final SubprogramCall newSubprogramCall = cs.createOwnedSubprogramCall();
				newSubprogramCall.setName(newSubprogramCallName);
				newSubprogramCall.setContext(callContext);
				newSubprogramCall.setCalledSubprogram(calledSubprogram);

				AadlImportsUtil.ensurePackageIsImportedForClassifier(bi, callContext);
				AadlImportsUtil.ensurePackageIsImportedForClassifier(bi, calledSubprogram);

				// Build Result
				StepResultBuilder<?> resultBuilder = StepResultBuilder.create().showNewBusinessObject(targetBoc,
						newSubprogramCall);

				if (cs.getOwnedSubprogramCalls().size() >= 2) {
					final SubprogramCallOrder newSubprogramCallOrder = new SubprogramCallOrder(
							cs.getOwnedSubprogramCalls().get(cs.getOwnedSubprogramCalls().size() - 2),
							newSubprogramCall);
					resultBuilder = resultBuilder.showNewBusinessObject(targetBoc, newSubprogramCallOrder);
				}

				return resultBuilder.build();
			});
		});
	}

	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		// Don't allow deleting the last subprogram call
		return call.eContainer() instanceof SubprogramCallSequence
				&& ((SubprogramCallSequence) call.eContainer()).getOwnedSubprogramCalls().size() > 1;
	}
}
