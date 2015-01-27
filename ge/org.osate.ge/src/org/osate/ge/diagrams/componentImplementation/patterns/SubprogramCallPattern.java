package org.osate.ge.diagrams.componentImplementation.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
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
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.AgeImageProvider;
import org.osate.ge.diagrams.common.Categorized;
import org.osate.ge.diagrams.common.DefaultAgeResizeConfiguration;
import org.osate.ge.diagrams.common.patterns.AgePattern;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.LabelService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.RefactoringService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.StyleService;

public class SubprogramCallPattern extends AgePattern implements Categorized {
	private static final String nameShapeName = "label";
	private static final String subprogramReferenceShapeName = "subprogramReference";
	private final GhostingService ghostingService;
	private final LayoutService layoutService;
	private final StyleService styleService;
	private final ShapeService shapeService;
	private final LabelService labelService;
	private final ShapeCreationService shapeCreationService;
	private final PropertyService propertyService;
	private final AadlFeatureService featureService;
	private final AnchorService anchorService;
	private final NamingService namingService;
	private final RefactoringService refactoringService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SubprogramCallPattern(final GhostingService ghostingService, final LayoutService layoutService, final StyleService styleService, 
			final ShapeService shapeService, final LabelService labelService, final ShapeCreationService shapeCreationService, final PropertyService propertyService,
			final AadlFeatureService featureService, final AnchorService anchorService, final NamingService namingService,
			final RefactoringService refactoringService, final BusinessObjectResolutionService bor) {
		this.ghostingService = ghostingService;
		this.layoutService = layoutService;
		this.styleService = styleService;
		this.shapeService = shapeService;
		this.labelService = labelService;
		this.shapeCreationService = shapeCreationService;
		this.propertyService = propertyService;
		this.featureService = featureService;
		this.anchorService = anchorService;
		this.namingService = namingService;
		this.refactoringService = refactoringService;
		this.bor = bor;
	}
	
	@Override
	public Category getCategory() {
		return Category.SUBPROGRAM_CALLS;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof SubprogramCall;
	}
	
	// Add
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			final Object targetBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
			return targetBo instanceof SubprogramCallSequence;
		}

		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final SubprogramCall call = (SubprogramCall)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(call));       
        
        // Finish creating
        refresh(shape, call, context.getX(), context.getY(), layoutService.getMinimumWidth(), layoutService.getMinimumHeight());
        
        return shape;
	}
	
	// Update
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final SubprogramCall call = (SubprogramCall)bor.getBusinessObjectForPictogramElement(pe);
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if(ga == null) {
				refresh((ContainerShape)pe, call, 255, 255, layoutService.getMinimumWidth(), layoutService.getMinimumHeight());
			} else {
				refresh((ContainerShape)pe, call, ga.getX(), ga.getY(), ga.getWidth(), ga.getHeight());
			}
		}
		return true;
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
	
	// Shared Between add and update
	private void refresh(final ContainerShape shape, final SubprogramCall call, final int x, final int y, final int minWidth, final int minHeight) {
		// Handle ghosting
		ghostingService.setIsGhost(shape, false);
		ghostingService.ghostInvalidChildShapes(shape);
		
		final List<Shape> touchedShapes = new ArrayList<Shape>();
		final Set<Shape> childShapesToGhost = new HashSet<Shape>();
		childShapesToGhost.addAll(shapeService.getNonGhostChildren(shape));

		// Create/Update feature shapes
		final SubprogramType subprogramType = getSubprogramType(call);
		if(subprogramType != null) {
			shapeCreationService.createUpdateFeatureShapes(shape, featureService.getAllDeclaredFeatures(subprogramType), touchedShapes);
		}

		// Ghost children that haven't been updated
		childShapesToGhost.removeAll(touchedShapes);
		for(final Shape child : childShapesToGhost) {
			ghostingService.setIsGhost(child, true);
		}
		
		// Create labels
        labelService.createLabelShape(shape, nameShapeName, call, getName(call));
        labelService.createLabelShape(shape, subprogramReferenceShapeName, call, getSubprogramReferenceString(call));
                
		layout(shape, call, x, y);

		// Create/update the chopbox anchor
		anchorService.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
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
		
	private void createGraphicsAlgorithm(final ContainerShape shape,  final int x, final int y, final int width, final int height) {
		// Create the graphics algorithm for the subprogram call
		final IGaService gaService = Graphiti.getGaService();
		
		final Style style = styleService.getStyle("subprogram_call");
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	gaService.setSize(ga, width, height);
		
		final GraphicsAlgorithm ellipseGa = gaService.createPlainEllipse(ga);
		gaService.setSize(ellipseGa, width, height);
		ellipseGa.setStyle(style);
		ellipseGa.setFilled(false);

		// Position the graphics algorithm
        gaService.setLocation(ga, x, y);   
	}
	
	// Move
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		super.postMoveShape(context);

		if(layoutService.checkContainerSize((ContainerShape)context.getPictogramElement())) {
			getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();
		}
	}
	
	// Resize
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return !propertyService.isTransient(context.getPictogramElement());
	}

	@Override
	public IResizeConfiguration getResizeConfiguration(IResizeShapeContext context) {
		final DefaultAgeResizeConfiguration conf = new DefaultAgeResizeConfiguration();
		conf.setMinimumSize(layoutService.getMinimumWidth(), layoutService.getMinimumHeight());
		return conf;		
	}
	
	@Override
	public void resizeShape(final IResizeShapeContext context) {
		super.resizeShape(context);
		
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		layoutService.checkContainerSize(shape);
		
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();
		
		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());
	}
	
	// Layout
	public boolean canLayout(final ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final int x = shape.getGraphicsAlgorithm().getX();
		final int y = shape.getGraphicsAlgorithm().getY();
		return layout(shape, bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), x , y);
	}
	
	private boolean layout(final ContainerShape shape, final Object bo, final int x, final int y) {
		final Shape nameShape = getNameShape(shape);
		final Shape subprogramReferenceShape = getSubprogramReferenceShape(shape);
		
		// Create the graphics algorithm for the shape
		final int newSize[] = layoutService.adjustChildShapePositions(shape);
		if(nameShape != null && subprogramReferenceShape != null) {
			newSize[0] = Math.max(Math.max(Math.max(newSize[0], layoutService.getMinimumWidth()), nameShape.getGraphicsAlgorithm().getWidth() + 30), subprogramReferenceShape.getGraphicsAlgorithm().getWidth() + 30);
			newSize[1] = Math.max(Math.max(Math.max(newSize[1], layoutService.getMinimumHeight()), nameShape.getGraphicsAlgorithm().getHeight() + 30), subprogramReferenceShape.getGraphicsAlgorithm().getHeight() + 30);
		}
		
		createGraphicsAlgorithm(shape, x, y, newSize[0], newSize[1]);
		
        // Layout labels		
		if(nameShape != null && subprogramReferenceShape != null) {
			final int shapeWidth = shape.getGraphicsAlgorithm().getWidth();
			final int shapeHeight = shape.getGraphicsAlgorithm().getHeight();
			final IGaService gaService = Graphiti.getGaService();
			
			final int totalLabelHeight = nameShape.getGraphicsAlgorithm().getHeight() + subprogramReferenceShape.getGraphicsAlgorithm().getHeight();
			gaService.setLocation(nameShape.getGraphicsAlgorithm(), (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, (shapeHeight - totalLabelHeight) / 2);
			gaService.setLocation(subprogramReferenceShape.getGraphicsAlgorithm(), (shapeWidth - subprogramReferenceShape.getGraphicsAlgorithm().getWidth()) / 2, nameShape.getGraphicsAlgorithm().getY() + nameShape.getGraphicsAlgorithm().getHeight());		
		}
		
		layoutService.layoutChildren(shape);
		
		return true;	
	}
	
	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, nameShapeName);
	}
	
	private Shape getSubprogramReferenceShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, subprogramReferenceShapeName);
	}
	
	// Create
	@Override
	public boolean isPaletteApplicable() {
		return bor.getBusinessObjectForPictogramElement(getDiagram()) instanceof BehavioredImplementation;
	}
	
	@Override
	public String getCreateName() {
		return "Subprogram Call";
	}
		
	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return AgeImageProvider.getImage(p.getSubprogramCall());
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {
		/*
		if(subcomponentType == null) {
			return false;
		}
		
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		return !(context.getTargetContainer() instanceof Diagram) && (containerBo instanceof ComponentImplementation ? ClassifierPattern.canContainSubcomponentType((ComponentImplementation)containerBo, subcomponentType) : false);
		*/
		
		return false;
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		// TODO
		return EMPTY;
	}
	
	// Direct Edit / Rename
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
        final Object bo = bor.getBusinessObjectForPictogramElement(pe);
        if (bo instanceof SubprogramCall && pe instanceof Shape && nameShapeName.equals(propertyService.getName(pe))) {
        	final SubprogramCall call = (SubprogramCall)bo;
        	return call.getContainingClassifier() == getComponentImplementation((Shape)pe);
        }
        
        return false;
    }
    
	@Override
	public int getEditingType() {
        return TYPE_TEXT;
    }

	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}
	
    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final SubprogramCall call = (SubprogramCall)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return getName(call);
    }
    
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final SubprogramCall call = (SubprogramCall)bor.getBusinessObjectForPictogramElement(pe);  	
    	refactoringService.renameElement(call, value);
    }
    
    // Shared
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
	
	private String getName(final SubprogramCall call) {
		return call.getName() == null ? "" : call.getName();
	}
}
