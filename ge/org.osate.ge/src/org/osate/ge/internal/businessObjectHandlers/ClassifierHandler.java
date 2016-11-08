/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * This material is based upon work supported by 
 * Aviation and Missile Research, Development, and Engineering Command (AMRDEC) 
 * under W31P4Q-15-D-0062 TO 0045.
 *******************************************************************************/
package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.Log;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;

public class ClassifierHandler {
	private static final LabelConfiguration classifierDiagramNameLabelConfiguration = LabelConfigurationBuilder.create().top().horizontalCenter().build();
	private static final LabelConfiguration ccNameLabelConfiguration = LabelConfigurationBuilder.create().aboveTop().horizontalCenter().build(); // TODO: Adjust. For testing//LabelConfigurationBuilder.create().center().build();
	private static final LabelConfiguration fgtNameLabelConfiguration = LabelConfigurationBuilder.create().afterRight().verticalCenter().build();
	private static final StandaloneDiagramElementQuery packageQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof AadlPackage));
	private static final Graphic featureGroupTypeClassifierDiagramGraphic = RectangleBuilder.create().lineWidth(2).build(); // Graphic to use for feature group types when they are not contained in a package diagram element.
	
	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Classifier bo) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if(!(diagramBo instanceof AadlPackage || diagramBo instanceof ProjectOverview)) {
			return null;
		}
		
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return new PaletteEntry[] { 
			createPaletteEntry(p.getAbstractType()),
			createPaletteEntry(p.getAbstractImplementation()),
			createPaletteEntry(p.getBusType()),
			createPaletteEntry(p.getBusImplementation()),
			createPaletteEntry(p.getDataType()),
			createPaletteEntry(p.getDataImplementation()),
			createPaletteEntry(p.getDeviceType()),
			createPaletteEntry(p.getDeviceImplementation()),
			createPaletteEntry(p.getFeatureGroupType()),
			createPaletteEntry(p.getMemoryType()),
			createPaletteEntry(p.getMemoryImplementation()),
			createPaletteEntry(p.getProcessType()),
			createPaletteEntry(p.getProcessImplementation()),
			createPaletteEntry(p.getProcessorType()),
			createPaletteEntry(p.getProcessorImplementation()),
			createPaletteEntry(p.getSubprogramType()),
			createPaletteEntry(p.getSubprogramImplementation()),
			createPaletteEntry(p.getSubprogramGroupType()),
			createPaletteEntry(p.getSubprogramGroupImplementation()),
			createPaletteEntry(p.getSystemType()),
			createPaletteEntry(p.getSystemImplementation()),
			createPaletteEntry(p.getThreadType()),
			createPaletteEntry(p.getThreadImplementation()),
			createPaletteEntry(p.getThreadGroupType()),
			createPaletteEntry(p.getThreadGroupImplementation()),
			createPaletteEntry(p.getVirtualBusType()),
			createPaletteEntry(p.getVirtualBusImplementation()),
			createPaletteEntry(p.getVirtualProcessorType()),
			createPaletteEntry(p.getVirtualProcessorImplementation())
		};
	}
	
	private static PaletteEntry createPaletteEntry(final EClass classifierType) {
		return PaletteEntryBuilder.create().label(StringUtil.camelCaseToUser(classifierType.getName())).icon(ImageHelper.getImage(classifierType.getName())).category(Categories.CLASSIFIERS).context(classifierType).build();
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) EObject bo, final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass classifierType) {
		return bo instanceof AadlPackage || isValidBaseClassifier(bo, classifierType);
	}
	
	private boolean isValidBaseClassifier(final EObject containerBo, final EClass classifierType) {
		final EClass containerType = containerBo.eClass();
		
		// Determine if the container is a valid base classifier
		boolean containerIsValidBaseClassifier = false;
		if(isComponentImplementation(classifierType)) {				
			for(final EClass superType : classifierType.getESuperTypes()) {
				if(!Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(superType)) {
					if(superType.isSuperTypeOf(containerType)) {
						containerIsValidBaseClassifier = true;
						break;
					}
				}
			}
		} else {
			containerIsValidBaseClassifier = classifierType.isSuperTypeOf(containerType) || Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractType().isSuperTypeOf(containerType);
		}
		
		return containerIsValidBaseClassifier;
	}
	
	private EObject determineBaseClassifier(final EObject targetBo, final EClass classifierType, final IProject project) {
		// Determine the base classifier using the container. The base classifier is the classifier that should be extended or implemented(if any)
		final EObject baseClassifier;

		// Determine if the container is a valid base classifier
		boolean containerIsValidBaseClassifier = isValidBaseClassifier(targetBo, classifierType);
		
		// Set the base classifier
		if(containerIsValidBaseClassifier) {
			baseClassifier = targetBo;
		} else {
			if(isComponentImplementation(classifierType)) {
				final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier to implement or extend.", getValidBaseClassifierDescriptions(project, classifierType));
				if(dlg.open() == Dialog.CANCEL) {
					return null;
				}			
				baseClassifier = (EObject)dlg.getFirstSelectedElement();			
			} else {
				baseClassifier = null;
			}
		}

		return (baseClassifier != null && baseClassifier.eIsProxy()) ? EcoreUtil.resolve(baseClassifier, targetBo.eResource()) : baseClassifier;
	}
	
	@GetCreateOwner
	private AadlPackage getCreateOwner(final @Named(Names.TARGET_BO) EObject targetBo, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		if(targetBo instanceof AadlPackage) {
			return (AadlPackage)targetBo;
		} else if(targetBo instanceof Classifier) {
			// Get the AadlPackage based on the query. This ensures that the package is the one represented by the diagram rather than the one in which the
			// target business object is contained.
			return (AadlPackage)queryService.getFirstBusinessObject(packageQuery, diagramElement);
		}

		return null;
	}
	
	/**
	 * Return a list of EObjectDescriptions for classifiers that would be valid "base" classifiers for the current classifierType.
	 * A "base" classifier is one that will be implemented or extended.
	 * Assumes classifier type is a type of component implementation.
	 * @return
	 */
	private List<IEObjectDescription> getValidBaseClassifierDescriptions(final IProject project, final EClass classifierType) {
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project, Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier())) {
			// Add objects that have care either types or implementations of the same category as the classifier type
			for(final EClass superType : classifierType.getESuperTypes()) {
				if(!Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(superType)) {
					if(superType.isSuperTypeOf(desc.getEClass())) {
						objectDescriptions.add(desc);
						break;
					}
				}
			}
		}

		return objectDescriptions;
	}

	@Create
	public Object createBusinessObject(@Named(Names.OWNER_BO) final AadlPackage pkg, @Named(Names.TARGET_BO) final EObject targetBo, 
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass classifierType, final @Named(InternalNames.PROJECT) IProject project,
			final NamingService namingService) {
		final EObject baseClassifier = determineBaseClassifier(targetBo, classifierType, project);
		if(baseClassifier == null && isComponentImplementation(classifierType)) {
			return null;
		}
		
		final PackageSection section = pkg.getPublicSection();
		if(section == null) {
			return null;
		}

		// Create the new classifier
		final Classifier newClassifier = section.createOwnedClassifier(classifierType);
		
		// Determine the name
		final String newName = buildNewName(section, classifierType, baseClassifier, namingService);
		if(newName == null) {
			return null;
		}		
		
		// Handle implementations
		if(newClassifier instanceof ComponentImplementation) {
			final ComponentImplementation newImpl = (ComponentImplementation)newClassifier;
			if(baseClassifier instanceof ComponentType) {
				final Realization realization = newImpl.createOwnedRealization();
				realization.setImplemented((ComponentType)baseClassifier);
			} else if(baseClassifier instanceof ComponentImplementation) {
				final ComponentImplementation baseImpl = (ComponentImplementation)baseClassifier;
				final ImplementationExtension extension = newImpl.createOwnedExtension();
				extension.setExtended(baseImpl);
				
				final Realization realization = newImpl.createOwnedRealization();
				realization.setImplemented(baseImpl.getType());
			}	
		} else if(newClassifier instanceof ComponentType && baseClassifier instanceof ComponentType) {
			final ComponentType newType = (ComponentType)newClassifier;
			final TypeExtension extension = newType.createOwnedExtension();
			extension.setExtended((ComponentType)baseClassifier);
		} else if(newClassifier instanceof FeatureGroupType && baseClassifier instanceof FeatureGroupType) {
			final FeatureGroupType newFgt = (FeatureGroupType)newClassifier;
			final GroupExtension extension = newFgt.createOwnedExtension();
			extension.setExtended((FeatureGroupType)baseClassifier);
		}
		
		// Set the name
		newClassifier.setName(newName);
		
		Log.info("Created classifier with name: " + newClassifier.getName());
			
		return newClassifier;
	}
	
	private String buildNewName(final PackageSection section, final EClass classifierType, final Object contextBo, final NamingService namingService) {
		// Determine the appropriate base name. The base name will be used if there are no conflicts
		final String baseName;
		if(isComponentImplementation(classifierType)) {
			final ComponentType componentType;
			if(contextBo instanceof ComponentImplementation) {
				componentType = ((ComponentImplementation)contextBo).getType();
			} else if(contextBo instanceof ComponentType) {
				componentType = (ComponentType)contextBo;
			} else {
				componentType = null;
			}
			
			if(componentType == null) {
				return null;
			}
			
			// Resolve name. Add imports as needed
			final String componentTypeName = resolveComponentTypeName(section, componentType, namingService);

			// Make sure the component type has a name
			if(componentTypeName == null) {
				return null;
			}

			baseName = componentTypeName + ".impl";
		} else {
			baseName = "new_classifier";
		}
		
		// Build the name and check for conflicts
		return namingService.buildUniqueIdentifier(section, baseName);
	}
	
	private String resolveComponentTypeName(final PackageSection section, final ComponentType ct, final NamingService namingService) {
		// Ensure the component type has a valid namespace
		if(ct.getNamespace() == null) {
			return null;
		}
		
		// Check if the component type is in the same package
		if(section == ct.getNamespace()) {
			return ct.getName();
		}
		
		// Look for an existing component type renames
		for(final ComponentTypeRename ctr : section.getOwnedComponentTypeRenames()) {
			if(ctr.getRenamedComponentType() == ct && ctr.getName() != null) {
				return ctr.getName();
			}
		}
		
		// Import the package if necessary
		final AadlPackage ctPkg = (AadlPackage)ct.getNamespace().getOwner();
		if(!section.getImportedUnits().contains(ctPkg)) {
			section.getImportedUnits().add(ctPkg);
		}
		
		// Create a new component type rename
		final String ctFullName = ct.getFullName();
		if(ctFullName == null) {
			return null;			
		}
		
		// Determine a unique name for the new rename
		final String baseAlias = ct.getQualifiedName().replace("::","_");
		final String alias = namingService.buildUniqueIdentifier(section, baseAlias);
	
		final ComponentTypeRename ctr = section.createOwnedComponentTypeRename();
		ctr.setName(alias);
		ctr.setCategory(ct.getCategory());
		ctr.setRenamedComponentType(ct);
		
		return alias;
	}
	
	private static boolean isComponentImplementation(EClass classifierType) {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(classifierType);
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) Classifier bo, final @Named(InternalNames.INTERNAL_DIAGRAM_BO) Object diagramBo) {
		if(bo instanceof FeatureGroupType && !(diagramBo instanceof AadlPackage)) {
			return featureGroupTypeClassifierDiagramGraphic;
		}
		return AadlGraphics.getGraphic(bo);
	}
	
	@GetNameLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration(final @Named(Names.BUSINESS_OBJECT) Classifier classifier, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		// Is the diagram element contained inside a package diagram element
		if(queryService.getFirstBusinessObject(packageQuery, diagramElement) == null) {
			// Not in package
			return classifierDiagramNameLabelConfiguration;
		} else {
			// In a package
			if(classifier instanceof FeatureGroupType) {
				return fgtNameLabelConfiguration;
			} else {
				return ccNameLabelConfiguration;
			}
		}
	}
		
	@CanRename
	public boolean canRename(final @Named(Names.BUSINESS_OBJECT) Classifier classifier, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		return classifierIsOwnedByPackage(classifier, diagramElement, queryService);
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Classifier classifier, final @Named(InternalNames.DIAGRAM_ELEMENT_PROXY) DiagramElementProxy diagramElement, final QueryService queryService) {
		return classifierIsOwnedByPackage(classifier, diagramElement, queryService) ? classifier.getName() : classifier.getQualifiedName(); 
	}
	
	// Returns whether the classifier is owned by the package in which the diagram element is contained.
	private boolean classifierIsOwnedByPackage(final Classifier classifier, final DiagramElementProxy diagramElement, final QueryService queryService) {
		final AadlPackage containingAadlPackage = (AadlPackage)queryService.getFirstBusinessObject(packageQuery, diagramElement);
		if(containingAadlPackage == null || classifier == null || classifier.getNamespace() == null || classifier.getNamespace().getOwner() == null) {
			return false;
		}
		
		return containingAadlPackage.getQualifiedName().equalsIgnoreCase(((NamedElement)classifier.getNamespace().getOwner()).getQualifiedName()) ? true : false;
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Classifier classifier, final @Named(Names.NAME) String value, final NamingService namingService) {
    	// If the name hasn't changed or has only changed case
    	if(value.equalsIgnoreCase(classifier.getName())) {
    		return null;
    	}
    	    
    	// Check if the value matches the format for AADL identifiers
    	if(classifier instanceof ComponentImplementation) {
    		// Check that the name specified both a type and implementation name
    		final String[] segs = value.split("\\.");
    		if(segs.length != 2) {
    			return "The name is not a valid name for a component implementaiton";
    		}
    		
    		// Ensure both segments are valid identifiers
    		if(!namingService.isValidIdentifier(segs[0]) || !namingService.isValidIdentifier(segs[1])) {
    			return "The specified name is not a valid AADL identifier";
    		}    		
    		
    		// Check the new type name...
    		final String typeName = segs[0];
    		NamedElement ctElement = null; // Either a ComponentType or a ComponentTypeRename    		
    		if(classifier.getNamespace() != null) {
				for(final NamedElement el : classifier.getNamespace().getMembers()) {
					if(typeName.equalsIgnoreCase(el.getName()) && (el instanceof ComponentType || el instanceof ComponentTypeRename)) {
						ctElement = el;
					}
				}
    		}
    		
    		if(ctElement == null) {
    			return segs[0] + " does not name a Component Type.";
    		}
    	} else {
    		if(!namingService.isValidIdentifier(value)) {
	    		return "The specified name is not a valid AADL identifier";
	    	}
    	}
    	
    	// Check for conflicts in the namespace
    	if(namingService.isNameInUse(classifier.getNamespace(), value)) {
    		return "The specified name conflicts with an existing member of the namespace.";
    	}

        // The value is valid
        return null;        
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) Classifier bo, final @Named(Names.NAME) String value) {
		bo.setName(value);
	}
}
