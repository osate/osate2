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
import org.osate.aadl2.Element;
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
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.internal.ui.dialogs.SelectSubprogramDialog;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilderHelper;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;

public class SubprogramCallSequenceHandler {
	private Graphic graphic = RectangleBuilder.create().build();

	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCallSequence cs) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage
				|| diagramBo instanceof ComponentImplementation;
		if (!applicable) {
			return null;
		}

		return new PaletteEntry[] { PaletteEntryBuilder.create().label("Subprogram Call Sequence")
				.icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getSubprogramCallSequence()))
				.category(Categories.SUBPROGRAM_CALLS).build() };
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		return GraphicalConfigurationBuilder.create().graphic(graphic)
				.style(StyleBuilder
						.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY).dashed()
						.labelsTop().labelsHorizontalCenter().build())
				.build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) SubprogramCallSequence cs) {
		return cs.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) SubprogramCallSequence cs,
			final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(cs, value);
	}

	private static OperationBuilderHelper<ComponentImplementation> getClassifierOpBuilder() {
		return OperationBuilderHelper.componentImplementations()
				.filter(ci -> ci instanceof BehavioredImplementation);
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) Element bo) {
		return getClassifierOpBuilder().canBuildOperation(bo);
	}

	@BuildCreateOperation
	public Operation createBusinessObject(final @Named(Names.TARGET_BO) Element targetBo,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final NamingService namingService) {

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

		return Operation.create(createOp -> {
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
				final String newScsName = namingService.buildUniqueIdentifier(bi, "new_call_sequence");
				final String initialSubprogramCallName = namingService.buildUniqueIdentifier(bi, "new_call");

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
		});
	}
}
