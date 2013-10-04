package edu.uah.rsesc.aadl.age.diagrams.pkg.patterns;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
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
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractClassifier;
import org.osate.aadl2.BusClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DeviceClassifier;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.MemoryClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.ProcessClassifier;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.Realization;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupClassifier;
import org.osate.aadl2.SystemClassifier;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.ThreadGroupClassifier;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.VirtualBusClassifier;
import org.osate.aadl2.VirtualProcessorClassifier;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeLeafShapePattern;
import edu.uah.rsesc.aadl.age.dialogs.ElementSelectionDialog;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.ModificationService;
import edu.uah.rsesc.aadl.age.services.UserInputService;
import edu.uah.rsesc.aadl.age.services.ModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.ui.util.DiagramFinder;
import edu.uah.rsesc.aadl.age.util.Log;

public class PackageClassifierPattern extends AgeLeafShapePattern {
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final PropertyService propertyUtil;
	private final ModificationService modificationService;
	private final ShapeService shapeService;
	private final UserInputService userInputService;
	private final BusinessObjectResolutionService bor;
	private final EClass classifierType;

	@Inject
	public PackageClassifierPattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator,
			final PropertyService propertyUtil, final ModificationService modificationService, final ShapeService shapeService, final UserInputService userInputService,
			final BusinessObjectResolutionService bor, final @Named("Classifier Type") EClass classifierType) {
		super(anchorUtil, visibilityHelper);
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.propertyUtil = propertyUtil;
		this.modificationService = modificationService;
		this.shapeService = shapeService;
		this.userInputService = userInputService;
		this.bor = bor;
		this.classifierType = classifierType;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject)	{
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);

		return classifierType.isInstance(bo);
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
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Remove child shapes
		shape.getChildren().clear();
		
		// Determine the label text
        final String labelTxt = getLabelText(classifier);
        
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        this.link(labelShape, new AadlElementWrapper(classifier));
        final Text text = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, labelTxt);
        
        // Set the size        
        final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, text.getStyle().getFont());
		final int width = Math.max(100, textSize == null ? 0 : textSize.getWidth() + 30); 
		final int height = 50; 
		gaService.setLocationAndSize(text, 0, 0, width, 20);
				
		// Create the graphics algorithm
        final GraphicsAlgorithm ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, classifier, width, height);        
        gaService.setLocation(ga, x, y);
	}
	
	private String getClassifierTypeName(final Classifier classifier) {
		if(classifier instanceof SystemClassifier) {
        	return "system";
        } else if(classifier instanceof ProcessClassifier) {
        	return "process";
        } else if(classifier instanceof ThreadGroupClassifier) {
        	return "thread_group";
        } else if(classifier instanceof ThreadClassifier) {
        	return "thread";
        } else if(classifier instanceof SubprogramClassifier) {
        	return "subprogram";
        } else if(classifier instanceof SubprogramGroupClassifier) {
        	return "subprogram_group";
        } else if(classifier instanceof DataClassifier) {
        	return "data";
        } else if(classifier instanceof AbstractClassifier) {
        	return "abstract";
        } else if(classifier instanceof VirtualBusClassifier) {
        	return "virtual_bus";
        } else if(classifier instanceof VirtualProcessorClassifier) {
        	return "virtual_processor";
        } else if(classifier instanceof BusClassifier) {
        	return "bus";
        } else if(classifier instanceof ProcessorClassifier) {
        	return "processor";
        } else if(classifier instanceof DeviceClassifier) {     	
        	return "device";
        } else if(classifier instanceof MemoryClassifier) {
        	return "memory";
        } else if(classifier instanceof FeatureGroupType) {
        	return "feature_group";
        } else {
        	return "unknown";
        }
	}

	private String getLabelText(final Classifier classifier) {
		final Diagram diagram = getDiagram();
		final NamedElement diagramElement = (NamedElement)AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(diagram));
		
		if(diagramElement == null || classifier == null || classifier.getNamespace() == null || classifier.getNamespace().getOwner() == null)
			return "";
		
		 return diagramElement.getQualifiedName().equalsIgnoreCase(((NamedElement)classifier.getNamespace().getOwner()).getQualifiedName()) ? classifier.getName() : classifier.getQualifiedName(); 
	}
	
	@Override
	public void setShapeProperties(final ContainerShape shape, final Object bo) {
		// Update the type name property
		propertyUtil.setTypeName(shape, getClassifierTypeName((Classifier)bo));
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return super.canResizeShape(context);
	}
	
	public void resizeShape(final IResizeShapeContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		final ContainerShape container = (ContainerShape)pe;
       	graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(container, ((Classifier)bo), context.getWidth(), context.getHeight());
		
		super.resizeShape(context);
	}	
	
	@Override
	public boolean canLayout(final ILayoutContext context) {
		return isPatternControlled(context.getPictogramElement());
	}

	@Override
	public boolean layout(final ILayoutContext context) {
		final PictogramElement pictogramElement = context.getPictogramElement();
		
		if(pictogramElement instanceof ContainerShape) {
			final ContainerShape containerShape = (ContainerShape)pictogramElement;
			final GraphicsAlgorithm outerGraphicsAlgorithm = containerShape.getGraphicsAlgorithm();
			final EList<Shape> children = containerShape.getChildren();
			if (children.size() > 0) {
				final Shape shape = children.get(0);
				final GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
				if (graphicsAlgorithm instanceof Text) {
					Graphiti.getGaLayoutService().setLocationAndSize(graphicsAlgorithm, 0, 0, outerGraphicsAlgorithm.getWidth(), outerGraphicsAlgorithm.getHeight());
					return true;
				}
			}
		}

		return false;
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		return true;
	}
	
	@Override
	public String getCreateName() {
		return classifierType.getName();
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
					final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a classifier to implement or extend.", getValidBaseClassifierDescriptions());
					if(dlg.open() == Dialog.CANCEL) {
						return null;
					}			
					baseClassifier = dlg.getSelectedElement();			
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
			Shape newShape = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), newClassifier);
			
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
				newShape = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), newClassifier);			
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
		final String alias = buildUniqueIdentifier(baseAlias, buildNameSet(section.getOwnedComponentTypeRenames()));
	
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
		for(final IEObjectDescription desc : EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier())) {
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
			
			baseName = componentTypeName + ".Impl";
		} else {
			baseName = "NewClassifier";
		}
		
		// Build the name and check for conflicts
		return buildUniqueIdentifier(baseName, buildNameSet(section.getOwnedClassifiers()));
	}
	
	// TODO: Consider refactoring into a naming service. Will need to take into account other cases and now just owned classifiers.
	/**
	 * Builds an identifier using the specified base that doesn't conflict with a set of existing identifiers
	 * @param baseIdentifier
	 * @param existingIdentifiers
	 * @return
	 */
	private String buildUniqueIdentifier(final String baseIdentifier, final Set<String> existingIdentifiers) {
		// Resolve naming conflicts
		String newIdentifier = baseIdentifier;
		boolean done = false;
		int num = 1;
		do {			
			if(existingIdentifiers.contains(newIdentifier.toLowerCase())) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while(!done);
		
		return newIdentifier;
	}
	
	/**
	 * Builds a set containing the names of a list of elements
	 * @param elements
	 * @param namedElements
	 * @return
	 */
	private Set<String> buildNameSet(final Collection<? extends NamedElement> elements) {
		final Set<String> names = new HashSet<String>();
		for(final NamedElement el : elements) {
			if(el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
		return names;
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return true;
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		modificationService.modify(classifier, new AbstractModifier<Classifier, Object>() {
			@Override
			public Object modify(final Resource resource, final Classifier classifier) {
				// Just remove the classifier. In the future it would be helpful to offer options for refactoring the model so that it does not
				// cause errors.
				EcoreUtil.remove(classifier);
				
				return null;
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
    		if(!isValidIdentifier(segs[0]) || !isValidIdentifier(segs[1])) {
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
    		if(!isValidIdentifier(value)) {
	    		return "The specified name is not a valid AADL identifier";
	    	}
    	}
    	
    	// Check for conflicts in the namespace
    	final Namespace ns = classifier.getNamespace();
    	for(final NamedElement el : ns.getOwnedMembers()) {
    		if(value.equalsIgnoreCase(el.getName())) {
    			return "The specified name conflicts with an existing member of the namespace.";
    		}
    	}

        // The value is valid
        return null;
    }
    
    private boolean isValidIdentifier(final String value) {
    	return value.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*");
    }
 
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(pe);    	
   	
    	modificationService.modify(classifier, new RenameClassifierModifier((Shape)pe, value, getFeatureProvider()));   	
    }
    
    private static class RenameClassifierModifier extends AbstractModifier<Classifier, Object> {
    	private final Shape labelShape;
    	private final String newName;
    	private final IFeatureProvider fp;
    	private Map<NamedElement, PictogramElement[]> pendingLinkages = new HashMap<NamedElement, PictogramElement[]>(); // Holds changes in linkages that should be made after the modificatio is completed
		private Map<NamedElement, Collection<Resource>> resourcesToRelink = new HashMap<NamedElement, Collection<Resource>>();		
		
		public RenameClassifierModifier(final Shape labelShape, final String newName, IFeatureProvider fp) {
			this.labelShape = labelShape;
			this.newName = newName;
			this.fp = fp;
		}
		
		@Override
		public Object modify(final Resource resource, final Classifier classifier) {
			// Reset run specific fields
			pendingLinkages.clear();
			resourcesToRelink.clear();
			
			// Resolving allows the name change to propagate when editing without an Xtext document
			EcoreUtil.resolveAll(resource.getResourceSet());

			// Find diagrams that links to this classifier
			// TODO: Need to pass in a diagram finder as a service instead of instantiating
			resourcesToRelink.put(classifier, new DiagramFinder().findDiagramResources(classifier));
			
			// Set the name
			classifier.setName(newName);
			
			// Add the text shape and the root shape for the classifier to the list of shapes to be relinked
			final ContainerShape rootShape = labelShape.getContainer();
			pendingLinkages.put(classifier, new PictogramElement[] {rootShape, labelShape});
			
			// Special handling of renaming component implementations. Need to set the type so that they will update appropriately in all cases.
			if(classifier instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation)classifier;
				final String typeName = newName.split("\\.")[0];
				for(final NamedElement member : ci.getNamespace().getMembers()) {
					if(typeName.equalsIgnoreCase(member.getName())) {
						// Handle renames
						if(member instanceof ComponentTypeRename) {
							final ComponentTypeRename ctr = (ComponentTypeRename) member;
							if(ctr.getRenamedComponentType() != null) {
								ci.setType(ctr.getRenamedComponentType());
							}
						}
						
						// Component Types
						if(member instanceof ComponentType) {
							ci.setType((ComponentType)member);
						}
						break;
					}
					
				}
			}
			
			// Check for cross references and update them
			// The extension changes are only needed when editing using an xtext document
			// Other changes are needed in all cases
			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(classifier, resource.getResourceSet())) {
				final EStructuralFeature sf = s.getEStructuralFeature();
				if(!sf.isDerived() && sf.isChangeable()) {
					final EObject obj = s.getEObject();
					if(obj instanceof TypeExtension) {
						final TypeExtension extension = (TypeExtension)obj;
						if(classifier == extension.getExtended()) {
							((ComponentType)extension.getSpecific()).createOwnedExtension().setExtended((ComponentType) classifier);
						}
					} else if(obj instanceof ImplementationExtension) {
						final ImplementationExtension extension = (ImplementationExtension)obj;
						if(classifier == extension.getExtended()) {
							((ComponentImplementation)extension.getSpecific()).createOwnedExtension().setExtended((ComponentImplementation)classifier);
						}
					} else if(obj instanceof GroupExtension) {
						final GroupExtension extension = (GroupExtension)obj;
						if(classifier == extension.getExtended()) {
							((FeatureGroupType)extension.getSpecific()).createOwnedExtension().setExtended((FeatureGroupType) classifier);
						}
					} else if(obj instanceof Realization && classifier instanceof ComponentType) {
						final Realization realization = (Realization)obj;
						final ComponentImplementation ci = (ComponentImplementation)realization.getSpecific();
						if(ci.getName() != null) {
							final String[] segs = ci.getName().split("\\.");
							if(segs.length == 2) {
								// Store linkages
								final PictogramElement[] implementationPes = fp.getAllPictogramElementsForBusinessObject(new AadlElementWrapper(ci));
								pendingLinkages.put(ci, implementationPes);
								
								// Add related resources to the list of resource to relink
								// TODO: Need to pass in a diagram finder as a service instead of instantiating
								resourcesToRelink.put(ci, new DiagramFinder().findDiagramResources(ci));
								
								// Set the name
								ci.setName(classifier.getName() + "." + segs[1]);
							}
						}
						
					}
				}
			}
			
			return null;
		}
		
		@Override
		public void afterModification(final Resource resource, final Classifier classifier) {
			// TODO: Consider moving this modifier to a separate file
			
			// Update linkages to renamed elements
			for(final Entry<NamedElement, PictogramElement[]> entry : pendingLinkages.entrySet()) {
				final AadlElementWrapper elementWrapper = new AadlElementWrapper(entry.getKey());
				for(PictogramElement pe : entry.getValue()) {
					fp.link(pe, elementWrapper);
				}
			}

			// Relink Diagrams
			for(final Entry<NamedElement, Collection<Resource>> entry : resourcesToRelink.entrySet()) {
				final AadlElementWrapper elementWrapper = new AadlElementWrapper(entry.getKey());
				for(final Resource resourceToRelink : entry.getValue()) {
					linkDiagram(resourceToRelink, elementWrapper);
				}
			}
		}
		
		private void linkDiagram(final Resource resource, final AadlElementWrapper classifierWrapper) {
			final ResourceSet resourceSet = resource.getResourceSet();
			
			if(resource.getContents().size() > 0) {
				final Object resourceContent = resource.getContents().get(0);
				System.out.println(resourceContent);
				if(resourceContent instanceof Diagram) {
					final Diagram diagram = (Diagram)resourceContent;
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resourceSet);
					boolean editingDomainCreated = false;
					if(editingDomain == null) {
						Log.info("Creating a editing domain");
						editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
						editingDomainCreated = true;
					}					
					
					// Execute a transaction to update the diagram's linkage
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
							GraphitiUi.getExtensionManager().createFeatureProvider(diagram).link(diagram, classifierWrapper);
						}			
					});						
					
					try {
						resource.save(null);
					} catch (IOException e) {
						throw new RuntimeException("Error saving new diagram", e);
					}
					
					// Dispose of the editing domain if we created it
					if(editingDomainCreated) {
						editingDomain.getCommandStack().flush();
						editingDomain.dispose();
					}
				}
			}
		}
	}
}
