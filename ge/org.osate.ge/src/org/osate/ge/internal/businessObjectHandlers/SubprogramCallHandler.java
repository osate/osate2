package org.osate.ge.internal.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.annotations.Annotation;
import org.osate.ge.internal.annotations.AnnotationBuilder;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.GetAnnotations;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.ui.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.internal.ui.dialogs.SelectSubprogramDialog;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ImageHelper;

public class SubprogramCallHandler {
	private static final StandaloneDiagramElementQuery behavioredImplementationQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof BehavioredImplementation).first());
	private Graphic graphic = EllipseBuilder.create().dashed().build();
	private LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().center().build();
		
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ComponentClassifier classifier) {				
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
		
	@GetNameLabelConfiguration
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
    public boolean canRename(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		return call.getContainingClassifier() == getBehavioredImplementation(diagramElement, queryService);
    }
	
	private BehavioredImplementation getBehavioredImplementation(final DiagramElementProxy callDiagramElement, final QueryService queryService) {
		return (BehavioredImplementation)queryService.getFirstBusinessObject(behavioredImplementationQuery, callDiagramElement);
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
	public boolean canCreate(final @Named(Names.TARGET_BO) SubprogramCallSequence cs, final @Named(InternalNames.TARGET_DIAGRAM_ELEMENT_PROXY) DiagramElementProxy targetDiagramElement, final QueryService queryService) {
		return cs.getContainingClassifier() == getBehavioredImplementation(targetDiagramElement, queryService);
	}
	
	@Create
	public SubprogramCall createBusinessObject(@Named(Names.OWNER_BO) SubprogramCallSequence cs, 
			final @Named(InternalNames.TARGET_DIAGRAM_ELEMENT_PROXY) DiagramElementProxy targetDiagramElement,
			final AadlFeatureService featureService, 
			final NamingService namingService,
			final QueryService queryService) {
		final BehavioredImplementation bi = getBehavioredImplementation(targetDiagramElement, queryService);
		if(bi == null) {
			throw new RuntimeException("Unexpected case. Unable to find BehavioredImplementation");
		}
		
		final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(featureService, bi);
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
    public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		if(call.eContainer() instanceof SubprogramCallSequence) {
			final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();
			
			// Don't allow deleting the last subprogram call
			if(cs.getOwnedSubprogramCalls().size() <= 1) {
				return false;
			}
					
			// ensure the that call sequence is owned by the component implementation depicted by the shape
			return call.getContainingClassifier() == getBehavioredImplementation(diagramElement, queryService);				
		}
		
		return false;
    }
		
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) SubprogramCall call, final AadlFeatureService featureService) {
		final SubprogramType subprogramType = getSubprogramType(call);
		if(subprogramType != null) {
			return Stream.concat(featureService.getAllDeclaredFeatures(subprogramType).stream(), subprogramType.getAllFlowSpecifications().stream());
		}
		
		return null;
	}
	
	/**
	 * Finds and returns the SubprogramType associated with the specified model element.
	 * @param element
	 * @return
	 */
	private SubprogramType getSubprogramType(final EObject element) {
		if(element instanceof SubprogramType) {
			return (SubprogramType)element;
		} else if(element instanceof SubprogramCall) {
			return getSubprogramType(((SubprogramCall) element).getCalledSubprogram());
		} else if(element instanceof SubprogramImplementation) {
			return ((SubprogramImplementation)element).getType();
		} else if(element instanceof SubprogramSubcomponent) {
			return getSubprogramType(((SubprogramSubcomponent) element).getSubprogramSubcomponentType());
		} else if(element instanceof SubprogramAccess) {
			final SubprogramSubcomponentType scType = ((SubprogramAccess) element).getSubprogramFeatureClassifier();
			return getSubprogramType(scType);
		} else if(element instanceof SubprogramProxy) {
			final SubprogramClassifier scClassifier = ((SubprogramProxy) element).getSubprogramClassifier();
			return getSubprogramType(scClassifier);
		} else if(element instanceof ComponentPrototype) {
			final ComponentClassifier constrainingClassifier = ((ComponentPrototype) element).getConstrainingClassifier();
			return getSubprogramType(constrainingClassifier);
		} else {
			// Unsupported case. Possibly prototype
			return null;
		}
	}
}
