/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import java.util.Iterator;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.Categories;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.ge.internal.util.ImageHelper;

public class ModePattern extends AgeLeafShapePattern implements Categorized {
	public static String INITIAL_MODE_CONNECTION_TYPE = "initial_mode";
	public static String innerModeShapeName = "inner_mode";
	public static String initialModeShapeName = "initial_mode";
	private static final String nameShapeName = "label";
	private final AnchorService anchorService;
	private final ConnectionService connectionService;
	private final LayoutService resizeHelper;
	private final ShapeService shapeHelper;
	private final PropertyService propertyService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final StyleService styleUtil;
	private final ShapeCreationService shapeCreationService;
	private final DiagramModificationService diagramModService;
	private final AadlModificationService modificationService;
	private final UserInputService userInputService;
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	private final RefactoringService refactoringService;
	private final LabelService labelService;
	
	@Inject
	public ModePattern(final AnchorService anchorUtil, final GhostingService ghostingService, final ConnectionService connectionService, final LayoutService resizeHelper, final ShapeService shapeHelper, 
			final PropertyService propertyUtil, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, final StyleService styleUtil, 
			final ShapeCreationService shapeCreationService, DiagramModificationService diagramModService, final AadlModificationService modificationService, 
			final UserInputService userInputService, final NamingService namingService, final RefactoringService refactoringService,
			final BusinessObjectResolutionService bor, final LabelService labelService) {
		super(anchorUtil, ghostingService, propertyUtil);
		this.anchorService = anchorUtil;
		this.connectionService = connectionService;
		this.resizeHelper = resizeHelper;
		this.shapeHelper = shapeHelper;
		this.propertyService = propertyUtil;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.styleUtil = styleUtil;
		this.shapeCreationService = shapeCreationService;
		this.diagramModService = diagramModService;
		this.modificationService = modificationService;
		this.userInputService = userInputService;
		this.namingService = namingService;
		this.refactoringService = refactoringService;
		this.bor = bor;
		this.labelService = labelService;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Mode;
	}	
		
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			final Object targetContainerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
			if(targetContainerBo instanceof ComponentClassifier || targetContainerBo instanceof Subcomponent) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext ctx) {
		return false;
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		resizeHelper.checkShapeBoundsWithAncestors((ContainerShape)context.getPictogramElement());
		layout((ContainerShape)context.getPictogramElement());
	}
	
	public boolean canLayout(ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean layout(ILayoutContext context) {
		layout((ContainerShape)context.getPictogramElement());
		return super.layout(context);
	}

	/**
	 * Adjusts the mode transitions
	 * @param shape
	 */
	private void layout(final ContainerShape shape) {
		connectionService.updateConnectionAnchors(getInnerModeShape(shape));
		
		// Layout name label
		final Shape nameShape = shapeHelper.getChildShapeByName(shape, nameShapeName);
		final Shape innerModeShape = getInnerModeShape(shape);
		
		if(innerModeShape != null && nameShape != null) {
			final GraphicsAlgorithm innerModeGa = innerModeShape.getGraphicsAlgorithm();
			final int shapeWidth = innerModeGa.getWidth();
			final int shapeHeight = innerModeGa.getHeight();
			final IGaService gaService = Graphiti.getGaService();
			
			gaService.setLocation(nameShape.getGraphicsAlgorithm(), 
					innerModeGa.getX() + (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, 
					innerModeGa.getY() + (shapeHeight - nameShape.getGraphicsAlgorithm().getHeight()) / 2);
	
		}
	}
	
	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y) {
		final Mode mode = (Mode)bo;
		final IGaService gaService = Graphiti.getGaService();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Remove connections related to the initial shape
		getVisibilityService().ghostOwnedConnections(shape);
		
		// Remove child shapes
		// Clear all shapes except for the inner mode shape
		final Iterator<Shape> it = shape.getChildren().iterator();
		while(it.hasNext()) {
			final Shape child = it.next();
			if(!innerModeShapeName.equals(propertyService.getName(child))) {
				it.remove();
			}
		}
		
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);		
		final int initialModeHeight = 20;
		final int innerModeHeight = 50;
		final int totalHeight = mode.isInitial() ? innerModeHeight + initialModeHeight : innerModeHeight;
		
		// Get/create inner mode shape
		ContainerShape innerModeShape = getInnerModeShape(shape);
		if(innerModeShape == null) {
			innerModeShape = peCreateService.createContainerShape(shape, true);
			propertyService.setName(innerModeShape, innerModeShapeName);
		}
		propertyService.setIsInnerShape(innerModeShape, true);
		
		 // Adjust properties on shapes so that the inner mode shape will be the one which is colored
		propertyService.setIsColoringContainer(shape, true);
        propertyService.setIsColoringChild(innerModeShape, true);
		
		// Ensure the inner mode shape has a chopbox anchor
		anchorService.createOrUpdateChopboxAnchor(innerModeShape, chopboxAnchorName);
		
		// Clear the inner mode shape's children
		innerModeShape.getChildren().clear();
		
		// Determine the label text
        final String labelTxt = mode.getName();
        
		// Create label
        final Shape labelShape = labelService.createLabelShape(shape, nameShapeName, mode, labelTxt);
        anchorService.createOrUpdateChopboxAnchor(labelShape, chopboxAnchorName);        
        final int width = Math.max(100, labelShape.getGraphicsAlgorithm().getWidth() + 30); 

		// Create the graphics algorithm for the inner mode shape
        final GraphicsAlgorithm modeGa = graphicsAlgorithmCreator.createModeGraphicsAlgorithm(innerModeShape, width, innerModeHeight);        
        gaService.setLocation(modeGa, 0, totalHeight - innerModeHeight);
        gaService.setLocationAndSize(ga, x, y, width, totalHeight);

        if(mode.isInitial()) {
			// Create the shape for the initial mode
			final ContainerShape initialModeShape = peCreateService.createContainerShape(shape, true);
			propertyService.setName(initialModeShape, initialModeShapeName);
			graphicsAlgorithmCreator.createInitialModeGraphicsAlgorithm(initialModeShape, 10);			
			final Anchor initialModeAnchor = peCreateService.createChopboxAnchor(initialModeShape);
			
			// Create a line between the initial mode symbol and the actual mode symbol
			final Connection initialModeConnection = peCreateService.createCurvedConnection(new double[] {0.0, -10.0}, getDiagram());
			initialModeConnection.setStart(initialModeAnchor);
			initialModeConnection.setEnd(anchorService.getAnchorByName(innerModeShape, chopboxAnchorName));
			propertyService.setIsTransient(initialModeConnection, true);
			propertyService.setConnectionType(initialModeConnection, INITIAL_MODE_CONNECTION_TYPE);
			
			// Create the line
			final Polyline polyline = gaService.createPlainPolyline(initialModeConnection);
			final Style style = styleUtil.getStyle(StyleConstants.DECORATOR_STYLE);
			polyline.setStyle(style);
			
			// Create the arrow decorator
			final ConnectionDecorator arrowDecorator = peCreateService.createConnectionDecorator(initialModeConnection, false, 1.0, true);    
	        createArrow(arrowDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));		
		}
	}
	
	private ContainerShape getInnerModeShape(final ContainerShape shape) {
		return (ContainerShape)shapeHelper.getChildShapeByName(shape, innerModeShapeName);
	}
	
	private ComponentClassifier getComponentClassifier(final Shape modeShape) {
		final Object container = shapeHelper.getClosestBusinessObjectOfType(modeShape, ComponentClassifier.class, Subcomponent.class);
		return container instanceof ComponentClassifier ? (ComponentClassifier)container : null;
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-6, 4, 
	    		2, 0, 
	    		-6, -4});
	    ga.setStyle(style);
	    return ga;
	}
	
	protected void updateAnchors(final ContainerShape shape) {
		// Remove orphan anchors. Usually created by mode transition triggers
		anchorService.removeAnchorsWithoutConnections(shape);
		
		super.updateAnchors(shape);
	}

	@Override
	public boolean isPaletteApplicable() {
		return bor.getBusinessObjectForPictogramElement(getDiagram()) instanceof ComponentClassifier;
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {
		return !(context.getTargetContainer() instanceof Diagram) && bor.getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ComponentClassifier;
	}
	
	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return ImageHelper.getImage(p.getMode().getName());
	}
	
	@Override
	public String getCreateName() {
		return "Mode";
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		// Get the classifier
		final ComponentClassifier classifier = (ComponentClassifier)bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		final Mode newMode;
		if(classifier == null) {
			newMode = null;
		} else {
			final String newModeName = namingService.buildUniqueIdentifier(classifier, "new_mode");
			
			// Make the modification
			newMode = modificationService.modify(classifier, new AbstractModifier<ComponentClassifier, Mode>() {
				private DiagramModificationService.Modification diagramMod;
				
				@Override
				public Mode modify(final Resource resource, final ComponentClassifier classifier) {
					// Handle diagram updates
		 			diagramMod = diagramModService.startModification();
		 			diagramMod.markOpenRelatedDiagramsAsDirty(classifier);
		 			
					final Mode newMode = classifier.createOwnedMode();
					newMode.setInitial(false);
					newMode.setName(newModeName);
					
					// Clear the no modes flag
					classifier.setNoModes(false);
					
					return newMode;
				}
				
				@Override
				public void beforeCommit(final Resource resource, final ComponentClassifier classifier, final Mode newMode) {
					diagramMod.commit();
					shapeCreationService.createShape(context.getTargetContainer(), newMode, context.getX(), context.getY());							
				}
			});
		}
		
		// Return the new mode if it was created
		return newMode == null ? EMPTY : new Object[] {newMode};
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Mode mode = (Mode)bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()));
		return mode.getContainingClassifier() == getComponentClassifier((Shape)context.getPictogramElement());
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		final Mode mode = (Mode)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		modificationService.modify(mode, new AbstractModifier<Mode, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final Mode mode) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			final Classifier classifier = mode.getContainingClassifier();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(classifier);	 			
	 			
				// Just remove the mode. In the future it would be helpful to offer options for refactoring the model so that it does not
				// cause errors.
				EcoreUtil.remove(mode);
				
				return null;
			}		
			
	 		@Override
			public void beforeCommit(final Resource resource, final Mode mode, final Object modificationResult) {
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
	public boolean stretchFieldToFitText() {
		return true;
	}
	
    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }
 
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        final Mode mode = (Mode)bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()));
		return ga instanceof Text && mode.getContainingClassifier() == getComponentClassifier((Shape)context.getPictogramElement());
    }
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final Mode mode = (Mode)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return mode.getName();
    }
    
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Mode mode = (Mode)bor.getBusinessObjectForPictogramElement(pe);
    	refactoringService.renameElement(mode, value);
    }

	@Override
	public String getCategory() {
		return Categories.MODES;
	}
}
