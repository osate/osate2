package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.inject.Named;
import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
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
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.annotations.Annotation;
import org.osate.ge.internal.annotations.AnnotationBuilder;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.GetAnnotations;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.AadlArrayService;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.SubcomponentService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.internal.util.SubcomponentUtil;

public class SubcomponentHandler {
	private static final StandaloneDiagramElementQuery componentImplementationQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation).first());
	private LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().top().horizontalCenter().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, 
			final @Named(InternalNames.PARENT_DIAGRAM_ELEMENT_PROXY) DiagramElementProxy parentDiagramElement, 
			final SubcomponentService subcomponentService) {
		final ComponentClassifier cc = subcomponentService.getComponentClassifier(parentDiagramElement, sc);
		if(cc == null) {
			return AadlGraphics.getGraphic(sc.getCategory(), false);
		} else {
			return AadlGraphics.getGraphic(cc);
		}
	}
	
	// Labels
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final AadlArrayService arrayService) {
		return getSubcomponentName(sc) + arrayService.getDimensionUserString(sc);
	}
	
	private String getSubcomponentName(final Subcomponent sc) {
		return sc.getName() == null ? "" : sc.getName();
	}
		
	@GetNameLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration() {
		return nameLabelConfiguration;
	}

	@GetAnnotations
	public Annotation[] getAnnotations(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final SubcomponentService subcomponentService) {
		return new Annotation[] {AnnotationBuilder.create().text(getTypeText(sc, subcomponentService)).build()};
	}
	
	private String getTypeText(final Subcomponent sc, final SubcomponentService subcomponentService) {
		String retVal = "";
        final SubcomponentType scType = subcomponentService.getAllSubcomponentType(sc);
        
		if(scType != null) {
			retVal += scType.getQualifiedName();
		}

		// Add text for each of the implementation references (for arrays)
		final List<ComponentImplementationReference> implRefs = subcomponentService.getArrayComponentImplementationReferences(sc);
		if(implRefs.size() != 0) {
			retVal += "\n(";			
			for(int i = 0; i < implRefs.size(); i++) {
				final ComponentImplementationReference ref = implRefs.get(i);
				if(ref.getImplementation() != null) {
					if(ref.getImplementation().eIsProxy()) {
						retVal += "<unresolved>";
					} else {
						retVal += ref.getImplementation().getQualifiedName();
					}
				}
				
				if(i == (implRefs.size() - 1)) {
					retVal += ")";
				} else {
					retVal += ",\n";					
				}
				
			}
		}
		
		return retVal;
	}
	
	// Children
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, 
			final @Named(InternalNames.PARENT_DIAGRAM_ELEMENT_PROXY) DiagramElementProxy parentDiagramElement,
			final AadlFeatureService featureService,
			final SubcomponentService subcomponentService) {
		final ComponentClassifier cc = subcomponentService.getComponentClassifier(parentDiagramElement, sc);
		if(cc == null) {
			return null;
		}
		
		return ClassifierHandler.getChildren(cc, featureService, false);
	}
	
	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ComponentImplementation ci) {
		final List<PaletteEntry> paletteEntries = new ArrayList<>();
		
		// Create palette entries for each subcomponent class which can be contained in the component implementation
		for(final EClass subcomponentType : SubcomponentUtil.getSubcomponentTypes()) {
			if(SubcomponentUtil.canContainSubcomponentType(ci, subcomponentType)) {
				paletteEntries.add(PaletteEntryBuilder.create().
						label(StringUtil.camelCaseToUser(subcomponentType.getName())).
						icon(ImageHelper.getImage(subcomponentType.getName())).
						category(Categories.SUBCOMPONENTS).context(subcomponentType).
						build());
			}
		}

		return paletteEntries.toArray(new PaletteEntry[paletteEntries.size()]);		
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) ComponentImplementation ci, final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass subcomponentType) {
		return SubcomponentUtil.canContainSubcomponentType(ci, subcomponentType);
	}
	
	@Create
	public Subcomponent createBusinessObject(@Named(Names.OWNER_BO) final ComponentImplementation owner,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass subcomponentType, 
			final NamingService namingService) {
		
		final String name = namingService.buildUniqueIdentifier(owner, "new_subcomponent");
		final Subcomponent sc = SubcomponentUtil.createSubcomponent(owner, subcomponentType);
		sc.setName(name);
		
		// Reset the no subcomponents flag
		owner.setNoSubcomponents(false);
		
		return sc;	
	}
	
	// Renaming    
	@CanRename
    public boolean canRename(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		final ComponentImplementation ci = (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, diagramElement);
		return sc.getContainingClassifier() == ci && sc.getRefined() == null;
    }
	
	@ValidateName
    public String validateName(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final @Named(Names.NAME) String value, final NamingService namingService) {
    	return namingService.checkNameValidity(sc, value);
    }	
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final @Named(Names.NAME) String value, final RefactoringService refactoringService) {
		refactoringService.renameElement(sc, value);
	}
	
	// Deleting
	@CanDelete
    public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) Subcomponent sc, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		final ComponentImplementation ci = (ComponentImplementation)queryService.getFirstBusinessObject(componentImplementationQuery, diagramElement);
		return sc.getContainingClassifier() == ci;
    }
}
