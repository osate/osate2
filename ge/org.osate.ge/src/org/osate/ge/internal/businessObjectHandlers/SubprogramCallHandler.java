package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.annotations.Annotation;
import org.osate.ge.internal.annotations.AnnotationBuilder;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.GetAnnotations;
import org.osate.ge.internal.di.GetDefaultLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.ui.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.internal.ui.dialogs.SelectSubprogramDialog;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SubprogramCallHandler {
	private static final StandaloneQuery behavioredImplementationQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof BehavioredImplementation).first());
	private Graphic graphic = EllipseBuilder.create().dashed().build();
	private LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().center().build();
		
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
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return graphic;
	}	

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return call.getName();
	}
		
	@GetDefaultLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration() {
		return nameLabelConfiguration;
	}

	@GetAnnotations
	public Annotation[] getAnnotations(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return new Annotation[] {AnnotationBuilder.create().text(getSubprogramReferenceString(call)).build()};
	}	
	
	private String getSubprogramReferenceString(final SubprogramCall call) {
		String subprogramReferenceStr = "";
	    if(call.getContext() instanceof NamedElement) {
	    	final String contextTxt = ((NamedElement)call.getContext()).getName();
	    	if(contextTxt != null) {
	    		subprogramReferenceStr = contextTxt + ".";
	    	}
	    }
	
	    if(call.getCalledSubprogram() instanceof NamedElement) {
	    	final String calledSubprogramTxt = ((NamedElement)call.getCalledSubprogram()).getName();
	    	if(calledSubprogramTxt != null) {
	    		subprogramReferenceStr += calledSubprogramTxt;
	    	}
	    }        
	
	    return subprogramReferenceStr;
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
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final @Named(Names.NAME) String value, final RefactoringService refactoringService) {
		refactoringService.renameElement(call, value);
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) SubprogramCallSequence cs, final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc, 
			final QueryService queryService) {
		return cs.getContainingClassifier() == getBehavioredImplementation(targetBoc, queryService);
	}
	
	@Create
	public SubprogramCall createBusinessObject(@Named(Names.OWNER_BO) SubprogramCallSequence cs, 
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final NamingService namingService,
			final QueryService queryService) {
		final BehavioredImplementation bi = getBehavioredImplementation(targetBoc, queryService);
		if(bi == null) {
			throw new RuntimeException("Unexpected case. Unable to find BehavioredImplementation");
		}
		
		final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(bi);
		final SelectSubprogramDialog dlg = new SelectSubprogramDialog(Display.getCurrent().getActiveShell(), subprogramSelectionModel);
		if(dlg.open() == Dialog.CANCEL) {
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
