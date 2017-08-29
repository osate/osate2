package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
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
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.internal.ui.dialogs.SelectSubprogramDialog;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SubprogramCallHandler {
	private static final StandaloneQuery behavioredImplementationQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof BehavioredImplementation).first());
	private Graphic graphic = EllipseBuilder.create().build();
	private Style style = StyleBuilder.create().dashed().build();
	private LabelConfiguration labelConfiguration = LabelConfigurationBuilder.create().center().build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof BehavioredImplementation;
		if(!applicable) {
			return null;
		}

		return new PaletteEntry[] {
				PaletteEntryBuilder.create().label("Subprogram Call").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getSubprogramCall())).category(Categories.SUBPROGRAM_CALLS).build()
		};
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				defaultStyle(style).
				defaultLabelConfiguration(labelConfiguration).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return call.getName();
	}

	@CanRename
	public boolean canRename(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		return call.getContainingClassifier() == getBehavioredImplementation(boc, queryService);
	}

	private BehavioredImplementation getBehavioredImplementation(final BusinessObjectContext callBoc, final QueryService queryService) {
		return (BehavioredImplementation)queryService.getFirstBusinessObject(behavioredImplementationQuery, callBoc);
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(call, value);
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) SubprogramCallSequence cs, final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final QueryService queryService) {
		return cs.getContainingClassifier() == getBehavioredImplementation(targetBoc, queryService);
	}

	@Create
	public SubprogramCall createBusinessObject(@Named(Names.MODIFY_BO) SubprogramCallSequence cs,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final NamingService namingService,
			final QueryService queryService) {
		final BehavioredImplementation bi = getBehavioredImplementation(targetBoc, queryService);
		if(bi == null) {
			throw new RuntimeException("Unexpected case. Unable to find BehavioredImplementation");
		}

		final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(bi);
		final SelectSubprogramDialog dlg = new SelectSubprogramDialog(Display.getCurrent().getActiveShell(), subprogramSelectionModel);
		if(dlg.open() == Window.CANCEL) {
			return null;
		}

		// Get the CallContext and Called Subprogram
		final CallContext callContext = subprogramSelectionModel.getCallContext(dlg.getSelectedContext());
		final CalledSubprogram calledSubprogram = subprogramSelectionModel.getCalledSubprogram(dlg.getSelectedSubprogram());
		final String newSubprogramCallName = namingService.buildUniqueIdentifier(bi, "new_call");

		// Create an initial call. Needed because call sequences must have at least one call
		final SubprogramCall newSubprogramCall = cs.createOwnedSubprogramCall();
		newSubprogramCall.setName(newSubprogramCallName);
		newSubprogramCall.setContext(callContext);
		newSubprogramCall.setCalledSubprogram(calledSubprogram);

		AadlHelper.ensurePackageIsImported(bi, callContext);
		AadlHelper.ensurePackageIsImported(bi, calledSubprogram);

		return newSubprogramCall;
	}

	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		if(call.eContainer() instanceof SubprogramCallSequence) {
			final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();

			// Don't allow deleting the last subprogram call
			if(cs.getOwnedSubprogramCalls().size() <= 1) {
				return false;
			}

			// ensure the that call sequence is owned by the component implementation depicted by the shape
			return call.getContainingClassifier() == getBehavioredImplementation(boc, queryService);
		}

		return false;
	}
}
