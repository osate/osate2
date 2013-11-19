package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
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
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.services.AadlFeatureService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionCreationService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.HighlightingService;
import edu.uah.rsesc.aadl.age.services.LayoutService;
import edu.uah.rsesc.aadl.age.services.NamingService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.ShapeCreationService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.SubcomponentService;
import edu.uah.rsesc.aadl.age.services.UserInputService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class SubcomponentPattern extends AgePattern {
	private final AnchorService anchorUtil;
	private final VisibilityService visibilityHelper;
	private final LayoutService layoutService;
	private final ShapeCreationService shapeCreationService;
	private final AadlFeatureService featureService;
	private final SubcomponentService subcomponentService;
	private final ConnectionCreationService connectionCreationService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final HighlightingService highlightingHelper;
	private final AadlModificationService aadlModService;
	private final NamingService namingService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;

	@Inject
	public SubcomponentPattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final LayoutService resizeHelper, 
			final ShapeCreationService shapeCreationService, AadlFeatureService featureService, SubcomponentService subcomponentService, 
			final ConnectionCreationService connectionCreationService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, 
			final HighlightingService highlightingHelper, final AadlModificationService aadlModService, final NamingService namingService,
			final DiagramModificationService diagramModService, final UserInputService userInputService, final ShapeService shapeService, 
			final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		this.anchorUtil = anchorUtil;
		this.visibilityHelper = visibilityHelper;
		this.layoutService = resizeHelper;
		this.shapeCreationService = shapeCreationService;
		this.featureService = featureService;
		this.subcomponentService = subcomponentService;
		this.connectionCreationService = connectionCreationService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.highlightingHelper = highlightingHelper;
		this.aadlModService = aadlModService;
		this.namingService = namingService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.shapeService = shapeService;
		this.propertyService = propertyService;
		this.bor = bor;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Subcomponent;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		return isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		if(!super.canUpdate(context)) {
			return false;
		}
		
		// Return that the shape can be updated if the subcomponent is actually a subcomponent of the component implementation
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return getComponentImplementation((Shape)context.getPictogramElement()).getAllSubcomponents().contains(sc);
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		return super.canMoveShape(context);
	}
	
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		this.refresh(shape, sc, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		layoutService.checkContainerSize(shape);
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		layoutService.checkContainerSize((ContainerShape)context.getPictogramElement());
	}
	
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createFalseReason();
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {	
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(sc));        
				
		// Finish Creating the Shape
        refresh(shape, sc, context.getX(), context.getY(), 0, 0);

        return shape;
	}

	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y, width, height;
			if(ga == null) {
				x = y = 25;
				width = height = 0;
			} else {
				x = ga.getX();
				y = ga.getY();
				width = ga.getWidth();
				height = ga.getHeight();
			}
			this.refresh((ContainerShape)pe, sc, x, y, width, height);
		}
		return true;
	}
	
	private void refresh(final ContainerShape shape, final Subcomponent sc, final int x, final int y, final int minWidth, final int minHeight) {
		visibilityHelper.setIsGhost(shape, false);
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Remove invalid flow specifications from the diagram
		visibilityHelper.ghostInvalidConnections();
		
		// Remove invalid shapes
		visibilityHelper.ghostInvalidShapes(shape);

		final Set<Shape> childShapesToGhost = new HashSet<Shape>();
		childShapesToGhost.addAll(visibilityHelper.getNonGhostChildren(shape));

		// Create/update child shapes
		final Classifier classifier = subcomponentService.getComponentClassifier(shape,  sc);
		if(classifier != null) {
			final List<Shape> touchedShapes = new ArrayList<Shape>();
			shapeCreationService.createUpdateFeatureShapes(shape, featureService.getAllOwnedFeatures(classifier), touchedShapes);
			childShapesToGhost.removeAll(touchedShapes);
		}
		
		// Create/Update Flow Specifications
		final ComponentType componentType;
		if(classifier instanceof ComponentType) {
			componentType = (ComponentType)classifier;
		} else if(classifier instanceof ComponentImplementation) {
			componentType = ((ComponentImplementation)classifier).getType();
		} else {
			componentType = null;
		}
		
		// Create/Update Flow Specifications
		if(componentType != null) {
			connectionCreationService.createUpdateConnections(shape, componentType.getAllFlowSpecifications());
		} 

		// Ghost child shapes that were not updated
		for(final Shape child : childShapesToGhost) {
			visibilityHelper.setIsGhost(child, true);
		}
		
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        this.link(labelShape, new AadlElementWrapper(sc));
        final String name = getLabelText(sc);
        final Text labelText = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, name);
        final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelText.getValue(), labelText.getStyle().getFont());
        
		// Create Subcomponent Type Indicator
        final Shape subcomponentTypeIndicatorShape = peCreateService.createShape(shape, false);
        final String subcomponentTypeName = sc.getSubcomponentType() == null ? "" : sc.getSubcomponentType().getQualifiedName();
        final Text subcomponentTypeText = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(subcomponentTypeIndicatorShape, subcomponentTypeName);
        final IDimension subcomponentTypeTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(subcomponentTypeText.getValue(), subcomponentTypeText.getStyle().getFont());
        
		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// Calculate max width and height
		int maxWidth = Math.max(minWidth, 150);
		int maxHeight = Math.max(minHeight, 50);
		final int extraWidth = 30;
		final int extraHeight = 30;
		maxWidth = Math.max(maxWidth, Math.max(textSize.getWidth(), subcomponentTypeTextSize.getWidth()) + extraWidth);
		for(final Shape childShape : visibilityHelper.getNonGhostChildren(shape)) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Ignore shape like the label when determining size.
			if(getBusinessObjectForPictogramElement(childShape) != null) {
				maxWidth = Math.max(maxWidth, childGa.getWidth() + extraWidth);
				maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() + extraHeight);
			}
		}		

		// Create the graphics Algorithm
		ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, sc, maxWidth, maxHeight);  
		gaService.setLocation(ga, x, y);
		
		// Set the position of the text
		gaService.setLocationAndSize(labelText, 0, 0, ga.getWidth(), 20);
		gaService.setLocationAndSize(subcomponentTypeText, 0, labelText.getY()+textSize.getHeight(), ga.getWidth(), 20);
		
		// Set color based on current mode
		highlightingHelper.highlight(sc, ga);		
	
		layoutService.layoutChildren(shape);
		anchorUtil.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}
	
	private String getLabelText(final Subcomponent sc) {
		return sc.getName() == null ? "" : sc.getName();
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		return true;
	}
	
	@Override
	public String getCreateName() {
		return "Subcomponent";
	}
	
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
	
	private List<ComponentImplementation> getAllExtended(final ComponentImplementation ci) {
		final List<ComponentImplementation> results = new ArrayList<ComponentImplementation>();		
		for(ComponentImplementation tmp = ci.getExtended(); tmp != null; tmp = tmp.getExtended()) {
			results.add(tmp);
		}
		return results;
	}
	
	private boolean isExtendedFrom(final ComponentImplementation ci, ComponentImplementation baseComponentImplementation) {
		for(final Classifier extended : getAllExtended(ci)) {
			if(extended == baseComponentImplementation) {
				return true;
			}
		}
		return false;	
	}
	
	private void markDiagramsOfDerivativeComponentImplementationsAsDirty(final DiagramModificationService.Modification diagramMod, final ComponentImplementation ci) {
		// Mark any diagrams that are linked to component implementations that extends the current component implementation as dirty
		for(final Diagram tmpDiagram : diagramMod.getDiagrams()) {
			final Object tmpDiagramBo = bor.getBusinessObjectForPictogramElement(tmpDiagram);
			if(tmpDiagramBo instanceof ComponentImplementation) {
				final ComponentImplementation tmpDiagramCi = (ComponentImplementation)tmpDiagramBo;
				if(isExtendedFrom(tmpDiagramCi, ci)) {
					diagramMod.markDiagramAsDirty(tmpDiagram);			
				}
			}					
		}
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		final Subcomponent newSubcomponent = aadlModService.modify(getComponentImplementation(context.getTargetContainer()), new AbstractModifier<ComponentImplementation, Subcomponent>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Subcomponent modify(final Resource resource, final ComponentImplementation ci) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			markDiagramsOfDerivativeComponentImplementationsAsDirty(diagramMod, ci);

				final String name = namingService.buildUniqueIdentifier(ci, "newSubcomponent");
				final AbstractSubcomponent sc = ci.createOwnedAbstractSubcomponent();
				sc.setName(name);
				return sc;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ComponentImplementation ci, final Subcomponent newSubcomponent) {
				diagramMod.commit();
			}
	 		
			@Override
			public void afterCommit(final Resource resource, final ComponentImplementation ci, final Subcomponent newSubcomponent) {
				// If the shape was dropped inside the component implementation shape
				if(newSubcomponent != null && !(context.getTargetContainer() instanceof Diagram) && bor.getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ComponentImplementation) {
					final ContainerShape newShape = (ContainerShape)shapeService.getDescendantShapeByElementQualifiedName(context.getTargetContainer(), newSubcomponent);
					if(newShape != null) {
						Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), context.getX(), context.getY());
						propertyService.setIsLayedOut(newShape, true);
						
						// Update the size of the container
						layoutService.checkContainerSize(newShape);
					}
				}
			}
		});
		
		return newSubcomponent == null ? EMPTY : new Object[] {newSubcomponent};
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()));
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
		return sc.getContainingClassifier() == containerBo;
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final Subcomponent sc) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			markDiagramsOfDerivativeComponentImplementationsAsDirty(diagramMod, getComponentImplementation((Shape)context.getPictogramElement()));
	 			
				// Just remove the classifier. In the future it would be helpful to offer options for refactoring the model so that it does not
				// cause errors.
				EcoreUtil.remove(sc);
				
				return null;
			}		
			
	 		@Override
			public void beforeCommit(final Resource resource, final Subcomponent sc, final Object modificationResult) {
				diagramMod.commit();
			}
		});
				
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
	
	// Renaming
	@Override
	public int getEditingType() {
        return TYPE_TEXT;
    }
	
    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }
 
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
        final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        
        // To be able to be renamed the subcomponent must be contained by the component implementation represented by the diagram and it must not be refined
        if (bo instanceof Subcomponent && ga instanceof Text) {
        	final Subcomponent sc = (Subcomponent)bo;
        	return sc.getContainingClassifier() == getComponentImplementation((Shape)context.getPictogramElement()) && sc.getRefined() == null;
        }
        return false;
    }
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return this.getLabelText(sc);
    }
    
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(pe);    	
   	
    	aadlModService.modify(sc, new RenameSubcomponentModifier(value, diagramModService));   	
    }
    
    private static class RenameSubcomponentModifier extends AbstractModifier<Subcomponent, Object> {
    	private final String newName;
		private final DiagramModificationService diagramModService;
		private DiagramModificationService.Modification diagramMod;
		
 		public RenameSubcomponentModifier(final String newName, final DiagramModificationService diagramModService) {
			this.newName = newName;
			this.diagramModService = diagramModService;
		}
 		
 		@Override
		public Object modify(final Resource resource, final Subcomponent sc) {
 			// Resolving allows the name change to propagate when editing without an Xtext document
 			EcoreUtil.resolveAll(resource.getResourceSet());

 			// Start the diagram modification
 			diagramMod = diagramModService.startModification();
 			
 			// Mark linkages to refinements as dirty
			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(sc, resource.getResourceSet())) {
				final EStructuralFeature sf = s.getEStructuralFeature();
				if(!sf.isDerived() && sf.isChangeable()) {
					final EObject obj = s.getEObject();
					if(obj instanceof Subcomponent && ((Subcomponent)obj).getRefined() == sc) {
						diagramMod.markLinkagesAsDirty((Subcomponent)obj);
					}
				}
			}
 			
 			// Mark linkages to the subcomponent as dirty 			
 			diagramMod.markLinkagesAsDirty(sc);
 			
 			// Set the subcomponent's name
			sc.setName(newName);

			return null;
		}	

 		@Override
		public void beforeCommit(final Resource resource, final Subcomponent sc, final Object modificationResult) {
			diagramMod.commit();
		}
 	}
}
