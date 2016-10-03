/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.Categories;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.DefaultAgeResizeConfiguration;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.Log;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;

public class PackageClassifierPattern extends AgeLeafShapePattern implements Categorized {
	private static final String labelShapeName = "label";
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final PropertyService propertyUtil;
	private final AadlModificationService modificationService;
	private final ShapeService shapeService;
	private final UserInputService userInputService;
	private final NamingService namingService;
	private final RefactoringService refactoringService; 
	private final DiagramModificationService diagramModService;
	private final LabelService labelService;
	private final BusinessObjectResolutionService bor;
	private final EClass classifierType;
	
	@Inject
	public PackageClassifierPattern(final AnchorService anchorUtil, final GhostingService ghostingService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator,
			final PropertyService propertyUtil, final AadlModificationService modificationService, final ShapeService shapeService, final UserInputService userInputService,
			final NamingService namingService, final RefactoringService refactoringService, final DiagramModificationService diagramModService,
			final LabelService labelService, final BusinessObjectResolutionService bor, final @Named("Classifier Type") EClass classifierType) {
		super(anchorUtil, ghostingService, propertyUtil);
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.propertyUtil = propertyUtil;
		this.modificationService = modificationService;
		this.shapeService = shapeService;
		this.userInputService = userInputService;
		this.namingService = namingService;
		this.refactoringService = refactoringService;
		this.diagramModService = diagramModService;
		this.labelService = labelService;
		this.bor = bor;
		this.classifierType = classifierType;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject)	{
		return isPackageDiagram() && classifierType.isInstance(AadlElementWrapper.unwrap(mainBusinessObject));
	}
	
	@Override
	public boolean isPaletteApplicable() {
		return isPackageDiagram();
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, int x, int y) {		
		final Classifier classifier = (Classifier)bo;
		final IGaService gaService = Graphiti.getGaService();

		// Remove child shapes
		shape.getChildren().clear();
		
		// Determine the label text
        final String labelTxt = getLabelText(classifier);
        
		// Create label
        final Shape labelShape = labelService.createLabelShape(shape, labelShapeName, classifier, labelTxt);
        
        final int shapeWidth;
        final int shapeHeight;
        if(shape.getGraphicsAlgorithm() == null) {
        	shapeHeight = 50;
        	if(bo instanceof FeatureGroupType) {
            	final int symbolWidth = getEstimatedSymbolSize(1000, shapeHeight);
            	shapeWidth = symbolWidth + labelShape.getGraphicsAlgorithm().getWidth();
        	} else {
        		shapeWidth = labelShape.getGraphicsAlgorithm().getWidth();
        	}
        } else {
        	shapeWidth = shape.getGraphicsAlgorithm().getWidth();
        	shapeHeight = shape.getGraphicsAlgorithm().getHeight();
        }
        
		// Create the graphics algorithm
        final GraphicsAlgorithm ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, classifier, shapeWidth, shapeHeight); 
        gaService.setLocation(ga, x, y);
	}

	private String getLabelText(final Classifier classifier) {
		final Diagram diagram = getDiagram();
		final NamedElement diagramElement = (NamedElement)AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(diagram));
		
		if(diagramElement == null || classifier == null || classifier.getNamespace() == null || classifier.getNamespace().getOwner() == null) {
			return "";
		}
		
		return diagramElement.getQualifiedName().equalsIgnoreCase(((NamedElement)classifier.getNamespace().getOwner()).getQualifiedName()) ? classifier.getName() : classifier.getQualifiedName(); 
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return !propertyUtil.isTransient(context.getPictogramElement());
	}
	
	public void resizeShape(final IResizeShapeContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		final ContainerShape container = (ContainerShape)pe;
       	graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(container, ((Classifier)bo), context.getWidth(), context.getHeight());

		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());
		super.resizeShape(context);      	
	}	
	
	@Override
	public boolean canLayout(final ILayoutContext context) {
		return isPatternControlled(context.getPictogramElement()) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		
		final int shapeWidth = shape.getGraphicsAlgorithm().getWidth();
		final int shapeHeight = shape.getGraphicsAlgorithm().getHeight();
		final Shape labelShape = getLabelShape(shape);
		
		final GraphicsAlgorithm labelGa = labelShape.getGraphicsAlgorithm();
		if(bo instanceof FeatureGroupType) {
			final int estSymbolSize = getEstimatedSymbolSize(shapeWidth, shapeHeight);
			Graphiti.getGaLayoutService().setLocation(labelGa, estSymbolSize, (shapeHeight - labelShape.getGraphicsAlgorithm().getHeight()) / 2);
		} else {
			Graphiti.getGaLayoutService().setLocation(labelGa, (shapeWidth - labelShape.getGraphicsAlgorithm().getWidth()) / 2, (shapeHeight - labelShape.getGraphicsAlgorithm().getHeight()) / 2);
		}				

		return true;
	}
	
	private final int getEstimatedSymbolSize(final int shapeWidth, final int shapeHeight) {
		return Math.min(shapeWidth, shapeHeight) * 3 / 4;
	}
	
	private Shape getLabelShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, labelShapeName);
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		return true;
	}
	
	@Override
	public String getCreateImageId() {
		return ImageHelper.getImage(classifierType.getName());
	}
	
	
	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(classifierType.getName());
	}
	
	private boolean isComponentImplementation() {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(classifierType);
	}
	
	private AadlPackage getPackage() {
		return (AadlPackage)bor.getBusinessObjectForPictogramElement(getDiagram());
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		// Get the target container BO
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		
		// Determine the base classifier using the container. The base classifier is the classifier that should be extended or implemented(if any)
		final EObject baseClassifier;
		if(containerBo instanceof EObject) {
			final EObject containerObj = (EObject)containerBo;
			final EClass containerType = containerObj.eClass();

			// Determine if the container is a valid base classifier
			boolean containerIsValidBaseClassifier = false;
			if(isComponentImplementation()) {				
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
			
			// Set the base classifier
			if(containerIsValidBaseClassifier) {
				baseClassifier = containerObj;
			} else {
				if(isComponentImplementation()) {
					final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier to implement or extend.", getValidBaseClassifierDescriptions());
					if(dlg.open() == Dialog.CANCEL) {
						return null;
					}			
					baseClassifier = (EObject)dlg.getFirstSelectedElement();			
				} else {
					baseClassifier = null;
				}
			}
		} else {
			baseClassifier = null;
		}
		
		// Make the modification
		final AadlPackage pkg = getPackage();
		final Classifier newClassifier = modificationService.modify(pkg, new AbstractModifier<AadlPackage, Classifier>() {
			@Override
			public Classifier modify(final Resource resource, final AadlPackage pkg) {
				final Object resolvedContext = (baseClassifier != null && baseClassifier.eIsProxy()) ? EcoreUtil.resolve(baseClassifier, resource) : baseClassifier;
				return createClassifier(resource, resolvedContext);
			}			
		});
		
		// If the shape was dropped on the diagram, set the location of the new shape
		if(newClassifier != null && context.getTargetContainer() instanceof Diagram) {
			Shape newShape = shapeService.getDescendantShapeByReference(getDiagram(), newClassifier);
			
			// If the update feature hasn't been called, add the shape to the diagram
			if(newShape == null) {
				final AddContext addContext = new AddContext();
				addContext.setTargetContainer(getDiagram());
				addContext.setNewObject(new AadlElementWrapper(newClassifier));				
				
				// Execute the add feature
				final IAddFeature addFeature = this.getFeatureProvider().getAddFeature(addContext);
				if(addFeature != null && addFeature.canAdd(addContext)) {
					addFeature.execute(addContext);
				}
	
				// Try to find the shape again
				newShape = shapeService.getDescendantShapeByReference(getDiagram(), newClassifier);			
			}

			if(newShape != null) {
				Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), context.getX(), context.getY());
				propertyUtil.setIsLayedOut(newShape, true);
			}
		}

		// Return the object that was created
		return newClassifier == null ? EMPTY : new Object[] {newClassifier};
	}
	
	private Classifier createClassifier(final Resource resource, final Object baseClassifier) {		
		final AadlPackage pkg = (AadlPackage)resource.getContents().get(0);
		final PackageSection section = pkg.getPublicSection();
		if(section == null) {
			return null;
		}

		// Create the new classifier
		final Classifier newClassifier = section.createOwnedClassifier(classifierType);
		
		// Determine the name
		final String newName = buildNewName(section, baseClassifier);
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
	
	private String resolveComponentTypeName(final PackageSection section, final ComponentType ct) {
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
	
	/**
	 * Return a list of EObjectDescriptions for classifiers that would be valid "base" classifiers for the current classifierType.
	 * A "base" classifier is one that will be implemented or extended.
	 * Assumes classifier type is a type of component implementation.
	 * @return
	 */
	private List<IEObjectDescription> getValidBaseClassifierDescriptions() {
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(getDiagram().eResource(), Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier())) {
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
	
	private String buildNewName(final PackageSection section, final Object contextBo) {
		// Determine the appropriate base name. The base name will be used if there are no conflicts
		final String baseName;
		if(isComponentImplementation()) {
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
			final String componentTypeName = resolveComponentTypeName(section, componentType);
			
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

	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	final Namespace ns = classifier.getNamespace();
    	final AadlPackage pkg = getPackage();
    	return ns != null && ns.getOwner() == pkg;
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		modificationService.modify(classifier, new AbstractModifier<Classifier, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final Classifier classifier) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(classifier);

	 			// Just remove the classifier. In the future it would be helpful to offer options for refactoring the model so that it does not
				// cause errors.
				EcoreUtil.remove(classifier);
				
				return null;
			}			
			
	 		@Override
			public void beforeCommit(final Resource resource, final Classifier classifier, final Object modificationResult) {
				diagramMod.commit();
			}
		});
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
	
	@Override
	public int getEditingType() {
        return TYPE_TEXT;
    }
 
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
        final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        
        if (bo instanceof Classifier && ga instanceof Text) {
        	final Namespace ns = ((Classifier)bo).getNamespace();
        	final AadlPackage pkg = getPackage();
        	return ns != null && ns.getOwner() == pkg;
        }

        return false;
    }
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return this.getLabelText(classifier);
    }
 
    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(pe);

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
    
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(pe);    	
    	refactoringService.renameElement(classifier,  value);  	   
    }

	@Override
	public String getCategory() {
		return Categories.CLASSIFIERS;
	}
	
	@Override
	public IResizeConfiguration getResizeConfiguration(final IResizeShapeContext context) {
		final DefaultAgeResizeConfiguration conf = new DefaultAgeResizeConfiguration();
		
		// Prevent the layout algorithm from shrinking feature group types. This prevent the layout algorithm from cutting off the
		// feature group type's label
		if(bor.getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof FeatureGroupType && 
				context.getPictogramElement().getGraphicsAlgorithm() != null) {
			final GraphicsAlgorithm ga = context.getPictogramElement().getGraphicsAlgorithm();
			conf.setMinimumSize(ga.getWidth(), ga.getHeight());
		}
		return conf;		
	}
}
