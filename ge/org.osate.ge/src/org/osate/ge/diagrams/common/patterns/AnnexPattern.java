package org.osate.ge.diagrams.common.patterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.LabelService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess.AnnexLibraryElements;

/**
 * Pattern for handling Annex libraries and subclauses
 *
 */
public class AnnexPattern extends AgePattern {
	private final static String nameShapeName = "name";
	
	private final GhostingService ghostingService;
	private final AnchorService anchorService;
	private final ShapeService shapeService;
	private final LabelService labelService;
	private final LayoutService layoutService;
	private final BusinessObjectResolutionService bor;
	private final PropertyService propertyService;
	private final AadlModificationService aadlModService;
	///private final DiagramModificationService diagramModService;
	private final ShapeCreationService shapeCreationService;
	
	@Inject
	public AnnexPattern(final GhostingService ghostingService, final AnchorService anchorService, final ShapeService shapeService, final LabelService labelService, 
			final LayoutService layoutService, final BusinessObjectResolutionService bor, final PropertyService propertyService, final AadlModificationService aadlModService,
			/*final DiagramModificationService diagramModService,*/ final ShapeCreationService shapeCreationService) {
		this.ghostingService = ghostingService;
		this.anchorService = anchorService;
		this.shapeService = shapeService;
		this.labelService = labelService;
		this.layoutService = layoutService;
		this.propertyService = propertyService;
		this.aadlModService = aadlModService;
		//this.diagramModService = diagramModService;
		this.shapeCreationService = shapeCreationService;
		this.bor = bor;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof AnnexLibrary || bo instanceof AnnexSubclause;
	}
	
	//TODO: add to palette
	@Override
	public boolean isPaletteApplicable() {
		return true;
	}
	
	// Adding
	@Override
	public boolean canAdd(final IAddContext context) {
		return true;
		//return isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return true;
	}
	
	//TODO: fix size when added to diagram
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Element bo = (Element)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape for the generic representation
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);

        link(shape, new AadlElementWrapper(bo));
        
        // Create Graphics Algorithm
        createGraphicsAlgorithm(shape, context.getX(), context.getY());
        
        // Finish creating
        refresh(shape);
        
        return shape;
	}
	
	private GraphicsAlgorithm createGraphicsAlgorithm(final ContainerShape shape, final int x, final int y) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm gaContainer = gaService.createInvisibleRectangle(shape);
		final GraphicsAlgorithm ga = createFolderShape(gaContainer, gaContainer.getWidth(), gaContainer.getHeight());
        gaService.setLocation(ga, x, y);

        return gaContainer;
	}
	
	private static GraphicsAlgorithm createFolderShape(final GraphicsAlgorithm container, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final int topOfFolderOffset = (int)(height*0.15);
		final int tabStartOffset = (int)(width*0.05);
		final int topOfTabOffset = (int)(width*0.3);

		final GraphicsAlgorithm ga = gaService.createPlainPolygon(container, 
    			new int[] {
    			0, height,
    			0, topOfFolderOffset,
    			tabStartOffset, 0,
    			topOfTabOffset, 0,
    			topOfTabOffset+tabStartOffset, topOfFolderOffset,
    			width, topOfFolderOffset,
    			width, height});
		gaService.setSize(ga, width, height);
		
		return ga;
	}
	
	/*private static GraphicsAlgorithm createFolderShape(final GraphicsAlgorithmContainer container, final int width, final int heigh) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(container, 
    			new int[] {
    			horizontalOffset, 0,
    			width, 0,
    			width-horizontalOffset, height,
    			0, height});
		gaService.setSize(ga, width, height);
		return ga;
	}*/
	/*
	 * private static GraphicsAlgorithm createParallelogram(final GraphicsAlgorithmContainer container, final int width, final int height, int horizontalOffset) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(container, 
    			new int[] {
    			horizontalOffset, 0,
    			width, 0,
    			width-horizontalOffset, height,
    			0, height});
		gaService.setSize(ga, width, height);
		return ga;
	}
	 */
	
	//private static createFolderShape(final )
	
	// Update
	@Override
	public final boolean update(final IUpdateContext context) {
		// TODO: Probably need a way of tagging shapes as being generic...
		// Update the generic representation
		final PictogramElement pe = context.getPictogramElement();
		if(pe instanceof ContainerShape) {
			final ContainerShape shape = (ContainerShape)pe;
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if(ga == null) {
				createGraphicsAlgorithm(shape, 25, 25);
			}

			refresh((ContainerShape)pe);
		}
		return true;
	}
	
	// Shared Add/Update 
	private void refresh(final ContainerShape shape) {
		ghostingService.setIsGhost(shape, false);
		
		final NamedElement annexElement = (NamedElement)bor.getBusinessObjectForPictogramElement(shape);
		final Set<Shape> childShapesToGhost = new HashSet<Shape>(shapeService.getNonGhostChildren(shape));
		final List<Shape> touchedShapes = new ArrayList<>();
				
		// Ghost Shapes
		childShapesToGhost.removeAll(touchedShapes);
		for(final Shape child : childShapesToGhost) {
			ghostingService.setIsGhost(child, true);
		}
		
		// Create label shape
		labelService.createLabelShape(shape, nameShapeName,  annexElement, annexElement.getName());
		
		// Layout
		layoutPictogramElement(shape);
		
		// Create/update the chopbox anchor
		anchorService.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}	
	
	// Layout
	public boolean canLayout(final ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	//TODO: change annex library name?
	@Override
	public boolean canDirectEdit(final IDirectEditingContext context) {
		return true;
	};
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return true;
	};
	
	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();	

		super.resizeShape(context);
		
		layoutService.checkContainerSize(shape);
		
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();
		
		// Update Connection Anchors
		//updateConnectionAnchors(shape);
		
		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());		
	};
	
	@Override
	public boolean layout(final ILayoutContext context) {
		System.err.println("layout");
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final int x = shape.getGraphicsAlgorithm().getX();
		final int y = shape.getGraphicsAlgorithm().getY();
		final NamedElement annexElement = (NamedElement)bor.getBusinessObjectForPictogramElement(shape);

		final IGaService gaService = Graphiti.getGaService();
		final Shape nameShape = Objects.requireNonNull(getNameShape(shape), "unable to retrieve name shape");
		propertyService.setIsUnselectable(nameShape, true);
		// Determine size of the shape
		final int[] newSize = layoutService.adjustChildShapePositions(shape); 
		
		// Enforce a minimum size for classifiers
		newSize[0] = Math.max(Math.max(newSize[0], layoutService.getMinimumWidth()), nameShape.getGraphicsAlgorithm().getWidth() + 30);
		newSize[1] = Math.max(Math.max(newSize[1], layoutService.getMinimumHeight()), nameShape.getGraphicsAlgorithm().getHeight() + 30);
						
		// Create new graphics algorithm
		final GraphicsAlgorithm ga = createGraphicsAlgorithm(shape, x, y);
		gaService.setSize(ga, newSize[0], newSize[1]);

		// Layout Labels
		final int shapeWidth = shape.getGraphicsAlgorithm().getWidth();
		final int shapeHeight = shape.getGraphicsAlgorithm().getHeight();
		//System.err.println(shapeHeight / 2);
		//gaService.setLocation(nameShape.getGraphicsAlgorithm(), (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, 5);
		gaService.setLocation(nameShape.getGraphicsAlgorithm(), (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, ((shapeHeight - nameShape.getGraphicsAlgorithm().getHeight())/2));		
		
		// Set the shape as not filled
		ga.setFilled(false);
						
		// Refresh. For some reason if it is not refreshed, some shapes may not be drawn correctly.
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();

		return true;
	}
	
	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, nameShapeName);
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {
		return true;
	};
	
	/*@Override
	public Object[] create(final ICreateContext context) {
		final AadlPackage aadlPackage = getAadlPackage(bor.getBusinessObjectForPictogramElement(context.getTargetContainer()));
		if (aadlPackage != null) {
		final AnnexLibrary newAnnexLibrary = aadlModService.modify(aadlPackage, new AbstractModifier<AadlPackage, AnnexLibrary>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public AnnexLibrary modify(final Resource resource, final AadlPackage pkg) {
				//diagramMod = diagramModService.startModification();
				final AnnexLibrary newAnnexLibrary = createAnnexLibrary(resource, context);
				return newAnnexLibrary;
			}
			
			@Override
			public void beforeCommit(final Resource resource, final AadlPackage pkg, final AnnexLibrary newAnnexLibrary) {
				diagramMod.commit();
				
				final ContainerShape newShape = (ContainerShape)shapeCreationService.createShape(context.getTargetContainer(), newAnnexLibrary, context.getX(), context.getY());
				
				// Set the is left property
				final GraphicsAlgorithm newShapeGa = newShape.getGraphicsAlgorithm();
				//final boolean isLeft = calculateIsLeft(newShape.getContainer(), context.getX(), newShapeGa.getWidth());
				//propertyUtil.setIsLeft(newShape, isLeft);
			}
			
		});
		// If the shape was dropped on the diagram, set the location of the new shape
				if(newAnnexLibrary != null && context.getTargetContainer() instanceof Diagram) {
					Shape newShape = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), newAnnexLibrary);
					
					// If the update feature hasn't been called, add the shape to the diagram
					if(newShape == null) {
						final AddContext addContext = new AddContext();
						addContext.setTargetContainer(getDiagram());
						addContext.setNewObject(new AadlElementWrapper(newAnnexLibrary));				
						
						// Execute the add feature
						final IAddFeature addFeature = this.getFeatureProvider().getAddFeature(addContext);
						if(addFeature != null && addFeature.canAdd(addContext)) {
							addFeature.execute(addContext);
						}
			
						// Try to find the shape again
						newShape = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), newAnnexLibrary);			
					}

					if(newShape != null) {
						Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), context.getX(), context.getY());
						propertyService.setIsLayedOut(newShape, true);
					}
				}
				
			//	System.err.println("returning");
		
		
		//return null;
		}
		
		
		return null;
	}
	
	public static DefaultAnnexLibrary createAnnexLibrary(final Resource resource, final ICreateContext context) {
		final AadlPackage aadlPackage = (AadlPackage)resource.getContents().get(0);
		//final PackageSection section = aadlPackage.getPublicSection();
		final PackageSection section = aadlPackage.getOwnedPublicSection();
		
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		if(section == null) {
			return null;
		}
		
		final DefaultAnnexLibrary annexLibrary = (DefaultAnnexLibrary)aadlPackage.getPublicSection().createOwnedAnnexLibrary();
		annexLibrary.setSourceText("{**");
		//annexLibrary.setParsedAnnexLibrary(annexLibrary);
		annexLibrary.setName("resources");
		

		return annexLibrary;
	}

	private static AadlPackage getAadlPackage(final Object targetContainerObject) {
		return targetContainerObject instanceof AadlPackage ? (AadlPackage)targetContainerObject : null;
	}*/
}
