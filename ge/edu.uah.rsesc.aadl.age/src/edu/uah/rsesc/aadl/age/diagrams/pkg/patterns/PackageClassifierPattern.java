package edu.uah.rsesc.aadl.age.diagrams.pkg.patterns;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractClassifier;
import org.osate.aadl2.BusClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DeviceClassifier;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.MemoryClassifier;
import org.osate.aadl2.NamedElement;
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
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.ModificationService;
import edu.uah.rsesc.aadl.age.services.ModificationService.Modifier;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.util.Log;

public class PackageClassifierPattern extends AgeLeafShapePattern {
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final PropertyService propertyUtil;
	private final ModificationService modificationService;
	private final BusinessObjectResolutionService bor;
	private final EClass classifierType;
	
	/*
	@Inject
	public PackageClassifierPattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator,
			final PropertyService propertyUtil, final BusinessObjectResolutionService bor) {
		super(anchorUtil, visibilityHelper);
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.propertyUtil = propertyUtil;
		this.bor = bor;
		this.classifierType = Aadl2Factory.eINSTANCE.getAadl2Package().getSystemType(); // TODO: Remove constructor, etc.
	}
	*/
	@Inject
	public PackageClassifierPattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator,
			final PropertyService propertyUtil, final ModificationService modificationService, final BusinessObjectResolutionService bor, final @Named("Classifier Type") EClass classifierType) {
		super(anchorUtil, visibilityHelper);
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.propertyUtil = propertyUtil;
		this.modificationService = modificationService;
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

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Classifier classifier = (Classifier)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		final String actualTypeName = getClassifierTypeName(classifier);
		final String storedTypeName = propertyUtil.getTypeName(pe);	
		if(!actualTypeName.equals(storedTypeName)) {
			return Reason.createTrueReason("Type is out of date");
		}
		
		final Text label = getLabel((ContainerShape)pe);
		if(label == null || !label.getValue().equals(getLabelText(classifier))) {
			return Reason.createTrueReason("Label is out of date");			
		}

		return Reason.createFalseReason();
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
	
	private Shape getLabelShape(final ContainerShape cs) {
		for(final Shape shape : cs.getChildren()) {
			if(shape.getGraphicsAlgorithm() instanceof Text) {
				return shape;
			}
		}
		return null;
	}
	
	private Text getLabel(final ContainerShape cs) {
		final Shape labelShape = getLabelShape(cs);
		if(labelShape != null) {
			return (Text)labelShape.getGraphicsAlgorithm();
		}
		return null;
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
		// TODO: Implement can create
		// return context.getTargetContainer() instanceof Diagram;
		return true;
	}
	
	@Override
	public String getCreateName() {
		return classifierType.getName();
	}
	
	private boolean isComponentImplementation() {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(classifierType);
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		// TODO: Changes to do:
		// Filter out the types based on applicability in the prompt dialog
		// Don't allow invalid implementation(check type) when creating classiier
		// Move dialog to appropriate place
		// Handle adding with statements as necessary when creating implementations
		// Add features... figure out how to specify location
		// Cleanup
		
		// Determine the "context". The context is the classifier that should be extended or implemented(if any)
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		final EObject contextBo;
		if(isComponentImplementation() && !(containerBo instanceof ComponentClassifier)) {			
			final ComponentClassifierPromptDialog dlg = new ComponentClassifierPromptDialog(Display.getCurrent().getActiveShell());
			if(dlg.open() == Dialog.CANCEL) {
				return null;
			}			
			contextBo = dlg.getSelectedClassifier();			
		} else if(containerBo instanceof EObject) {
			contextBo = (EObject)containerBo;
		} else {
			contextBo = null;
		}
		
		final AadlPackage pkg = (AadlPackage)bor.getBusinessObjectForPictogramElement(getDiagram());
		final Classifier newClassifier = modificationService.modifyModel(pkg, new Modifier<Classifier>() {
			@Override
			public Classifier modify(final Resource resource) {
				final Object resolvedContext = contextBo.eIsProxy() ? EcoreUtil.resolve(contextBo, resource) : contextBo;
				return createClassifier(resource, resolvedContext);
			}			
		});
		
		// TODO: Potentially run add feature to add shape. Is that normal behavior?
		// Update has already ran.. Would need to call add inside of modify...
		// TODO: Need someway to do that only if model changes... Or just need to split out call to update
		// But the xtext update may be triggered automatically so that may not be possible.. 
		// Would it be clean to have a way to suspend updates, etc...
		
		// Return the object that was created
		return newClassifier == null ? EMPTY : new Object[] {newClassifier};
	}
	
	private Classifier createClassifier(final Resource resource, final Object contextBo) {		
		final AadlPackage pkg = (AadlPackage)resource.getContents().get(0);
		final PackageSection section = pkg.getPublicSection();
		if(section == null) {
			return null;
		}
		
		// Create the new classifier
		final Classifier newClassifier = section.createOwnedClassifier(classifierType);
		
		// Determine the name
		final String newName = buildNewName(section, contextBo);
		if(newName == null) {
			return null;
		}
		
		// Handle implementations
		if(newClassifier instanceof ComponentImplementation) {
			final ComponentImplementation newImpl = (ComponentImplementation)newClassifier;
			if(contextBo instanceof ComponentType) {
				final Realization realization = newImpl.createOwnedRealization();
				realization.setImplemented((ComponentType)contextBo);
			} else if(contextBo instanceof ComponentImplementation) {
				final ComponentImplementation baseImpl = (ComponentImplementation)contextBo;
				final ImplementationExtension extension = newImpl.createOwnedExtension();
				extension.setExtended(baseImpl);
				
				final Realization realization = newImpl.createOwnedRealization();
				realization.setImplemented(baseImpl.getType());
			}			
		} else if(newClassifier instanceof ComponentType && contextBo instanceof ComponentType) {
			final ComponentType newType = (ComponentType)newClassifier;
			final TypeExtension extension = newType.createOwnedExtension();
			extension.setExtended((ComponentType)contextBo);
		} else if(newClassifier instanceof FeatureGroupType && contextBo instanceof FeatureGroupType) {
			final FeatureGroupType newFgt = (FeatureGroupType)newClassifier;
			final GroupExtension extension = newFgt.createOwnedExtension();
			extension.setExtended((FeatureGroupType)contextBo);
		}
		
		// Set the name
		newClassifier.setName(newName);
		Log.info("Created classifier with name: " + newClassifier.getName());
			
		return newClassifier;
	}
	
	// TODO: Double click on list should confirm dialog
	static class ComponentClassifierPromptDialog extends Dialog {
		private final EList<IEObjectDescription> objectDescriptions;
		private org.eclipse.swt.widgets.List classifierList;
		private ComponentClassifier selectedClassifier;
		
		public ComponentClassifierPromptDialog(Shell parentShell) {
			super(parentShell);
			objectDescriptions = EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier());
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);
			final RowLayout layout = new RowLayout();
			layout.type = SWT.VERTICAL;
			layout.fill = true;
			layout.pack = true;
		    container.setLayout(layout);

		    final Label lbl = new Label(container, SWT.NONE);
		    lbl.setText("Select a classifier to implement or extend.");

		    classifierList = new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.V_SCROLL);
		    RowData rowData = new RowData();
		    rowData.height = 500;
		    classifierList.setLayoutData(rowData);
		    
		    // Populate the list with the names of the classifiers in the workspace

		    // TODO: Sort
		    final String[] classifierNames = new String[objectDescriptions.size()];
		    for(int i = 0; i < objectDescriptions.size(); i++) {
		    	classifierNames[i] = objectDescriptions.get(i).getName().toString();
		    }
		    classifierList.setItems(classifierNames);		    
		    
		    return container;
		}
		
		@Override
		protected void okPressed() {
			// Check bounds
			if(classifierList.getSelectionIndex() >= 0 && classifierList.getSelectionIndex() < objectDescriptions.size()) {
				// Get the object from the object description
				final IEObjectDescription objDesc = objectDescriptions.get(classifierList.getSelectionIndex());
				final EObject obj = objDesc.getEObjectOrProxy();
				
				// Return the object
				if(obj instanceof ComponentClassifier) {
					selectedClassifier = (ComponentClassifier)obj;
				}
			}
						
		    super.okPressed();
		}
		
		public ComponentClassifier getSelectedClassifier() {
			return selectedClassifier;
		}
	}
	
	private String buildNewName(final PackageSection section, final Object contextBo) {
		// Determine the name
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
			
			// Make sure the component type has a name
			if(componentType.getName() == null) {
				return null;
			}
			
			baseName = componentType.getName() + ".Impl";
		} else {
			baseName = "NewClassifier";
		}
		
		// Resolve naming conflicts
		String newName = baseName;
		boolean nameClash;
		int num = 1;
		do {
			nameClash = false;
			for(final Classifier c : section.getOwnedClassifiers()) {
				if(newName.equalsIgnoreCase(c.getName())) {
					nameClash = true;
					break;
				}
			}
			
			if(nameClash) {
				num++;
				newName = baseName + num;
			}
		} while(nameClash);
		
		return newName;
	}
}
