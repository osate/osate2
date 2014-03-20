/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.patterns;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.GraphicsAlgorithmCreationService;
import org.osate.ge.services.GraphicsAlgorithmManipulationService;
import org.osate.ge.services.HighlightingService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.PrototypeService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.UserInputService;
import org.osate.ge.services.VisibilityService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.util.StringUtil;

/**
 * Pattern for controlling Feature shapes
 * Note: With the exception of child feature shapes, child shapes are recreated during updates so they should not be referenced.
 * @author philip.alldredge
 */
// TODO: Not a leaf shape since it may contain children associated with business objects. Rename the leaf shape pattern
// or do not extend AgeLeafShapePattern. The latter may be preferable due to the way this class interacts with its children.
public class FeaturePattern extends AgeLeafShapePattern {
	private static final String featureShapeName = "feature";
	private static final String labelShapeName = "label";	
	public static final String innerConnectorAnchorName = "innerConnector";
	public static final String outerConnectorAnchorName = "outerConnector";
	public static final String flowSpecificationAnchorName = "flowSpecification";
	private static LinkedHashMap<EClass, String> featureTypeToMethodNameMap = new LinkedHashMap<EClass, String>();
	private static final int featureGroupSymbolWidth = 30;
	private static final int labelPadding = 5;
	private final AnchorService anchorUtil;
	private final VisibilityService visibilityHelper;
	private final PropertyService propertyUtil;
	private final GraphicsAlgorithmManipulationService graphicsAlgorithmUtil;
	private final ShapeService shapeService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final AadlFeatureService featureService;
	private final PrototypeService prototypeService;
	private final UserInputService userInputService;
	private final LayoutService layoutService;
	private final AadlModificationService modificationService;
	private final NamingService namingService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;
	private final ShapeCreationService shapeCreationService;
	private final HighlightingService highlightingService;
	private final EClass featureType;
	
	/**
	 * Populate the map that contains the feature type to create method name mapping
	 */
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		featureTypeToMethodNameMap.put(p.getAbstractFeature(), "createOwnedAbstractFeature");
		featureTypeToMethodNameMap.put(p.getBusAccess(), "createOwnedBusAccess");
		featureTypeToMethodNameMap.put(p.getDataAccess(), "createOwnedDataAccess");
		featureTypeToMethodNameMap.put(p.getDataPort(), "createOwnedDataPort");
		featureTypeToMethodNameMap.put(p.getEventDataPort(), "createOwnedEventDataPort");
		featureTypeToMethodNameMap.put(p.getEventPort(), "createOwnedEventPort");
		featureTypeToMethodNameMap.put(p.getFeatureGroup(), "createOwnedFeatureGroup");
		featureTypeToMethodNameMap.put(p.getParameter(), "createOwnedParameter");
		featureTypeToMethodNameMap.put(p.getSubprogramAccess(), "createOwnedSubprogramAccess");
		featureTypeToMethodNameMap.put(p.getSubprogramGroupAccess(), "createOwnedSubprogramGroupAccess");
	}
	
	public static Collection<EClass> getFeatureTypes() {
		return featureTypeToMethodNameMap.keySet();
	}
	
	@Inject
	public FeaturePattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, 
			final PropertyService propertyUtil, final GraphicsAlgorithmManipulationService graphicsAlgorithmUtil,
			final ShapeService shapeService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, 
			final AadlFeatureService featureService, final PrototypeService prototypeService, final UserInputService userInputService, 
			final LayoutService layoutService, final AadlModificationService modificationService, final NamingService namingService,
			final DiagramModificationService diagramModService, final BusinessObjectResolutionService bor, final ShapeCreationService shapeCreationService,
			final HighlightingService highlightingService, final @Named("Feature Type") EClass featureType) {
		super(anchorUtil, visibilityHelper);
		this.anchorUtil = anchorUtil;
		this.visibilityHelper = visibilityHelper;
		this.propertyUtil = propertyUtil;
		this.graphicsAlgorithmUtil = graphicsAlgorithmUtil;
		this.shapeService = shapeService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.featureService = featureService;
		this.prototypeService = prototypeService;
		this.userInputService = userInputService;
		this.layoutService = layoutService;
		this.modificationService = modificationService;
		this.namingService = namingService;
		this.diagramModService = diagramModService;
		this.bor = bor;
		this.shapeCreationService = shapeCreationService;
		this.highlightingService = highlightingService;
		this.featureType = featureType;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return featureType.isInstance(AadlElementWrapper.unwrap(mainBusinessObject));
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext ctx) {
		if(ctx.getPictogramElement() instanceof Shape){
			final Shape shape = (Shape)ctx.getPictogramElement();
			final ContainerShape container = shape.getContainer();
			final Object containerBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(container));
			if(containerBo instanceof Classifier || containerBo instanceof Subcomponent) {
				return super.canMoveShape(ctx);
			}
		}
		
		return false;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext ctx) {
		return false;
	}
	
	@Override
	protected void preMoveShape(final IMoveShapeContext context) {
		super.preMoveShape(context);
		
		final Shape shape = context.getShape();
		final int containerWidth = shape.getContainer().getGraphicsAlgorithm().getWidth();
		final boolean isLeft = context.getX() < containerWidth/2;
		final MoveShapeContext mutableContext = (MoveShapeContext)context;
		mutableContext.setX(isLeft ? 0 : containerWidth-shape.getGraphicsAlgorithm().getWidth());
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		super.postMoveShape(context);
		final ContainerShape shape = (ContainerShape)context.getShape();		

		// Update whether or not the shape is on the left or not
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final boolean isLeft = calculateIsLeft(shape.getContainer(), ga.getX() + (ga.getWidth() / 2));
		propertyUtil.setIsLeft(shape, isLeft);
		
		layoutAll(shape);
		updateAnchors(shape);
		
		layoutService.checkContainerSize((ContainerShape)context.getPictogramElement());
	}

	@Override
	public boolean canLayout(final ILayoutContext context) {
		return isPatternControlled(context.getPictogramElement());
	}
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		layout(shape);
		
		return false;
	}

	private void layout(final ContainerShape shape) {
		final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
		final ContainerShape featureShape = getFeatureShape(shape);
		final GraphicsAlgorithm featureGa = featureShape.getGraphicsAlgorithm();
		final Feature feature = (Feature)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		
		boolean wasLeftLayout = propertyUtil.getIsLeftLayout(shape);
		final boolean isLeftLayout = isLeft(shape);
		propertyUtil.setIsLeftLayout(shape, isLeftLayout);
		
		// Feature groups
		if(feature instanceof FeatureGroup) {
			if(isLeftLayout != wasLeftLayout) {
				graphicsAlgorithmUtil.mirror(featureGa);
			}
			
			if(isLeftLayout) {
				featureGa.setX(0);
				// Set Position of All Children
				for(final Shape child : featureShape.getChildren()) {
					child.getGraphicsAlgorithm().setX(featureGroupSymbolWidth);
				}
			} else {
				// Set Position of the Graphics Algorithm
				featureGa.setX(featureGa.getWidth()-featureGroupSymbolWidth);
				
				// Set Position of All Children
				for(final Shape child : featureShape.getChildren()) {
					child.getGraphicsAlgorithm().setX(featureGa.getWidth()-child.getGraphicsAlgorithm().getWidth()-featureGroupSymbolWidth);
				}
			}
		} else {
			// Features
	        if(isLeftLayout != wasLeftLayout) {
	    		graphicsAlgorithmUtil.mirror(featureGa);
	        }
		}
		
		// All
		featureGa.setX(isLeftLayout ? 0 : shapeGa.getWidth()-featureGa.getWidth());
		final Shape labelShape = getLabelShape(shape);
		
		if(labelShape != null) {
			final GraphicsAlgorithm labelGa = labelShape.getGraphicsAlgorithm();
			labelGa.setX(isLeftLayout ? labelPadding : shapeGa.getWidth()-labelGa.getWidth()-labelPadding);
		}	
		
		// Handle positioning of the shape in cases where the shape container has a fully initialized container
		final GraphicsAlgorithm containerGa = shape.getContainer().getGraphicsAlgorithm();
		if(containerGa != null) {
			final int containerWidth = containerGa.getWidth();
			shapeGa.setX(isLeftLayout ? 0 : containerWidth-shape.getGraphicsAlgorithm().getWidth());
		}
	}
	
	private void layoutAll(final ContainerShape shape) {
		// Layout the children first
		for(final Shape child : visibilityHelper.getNonGhostChildren(getFeatureShape(shape))) {
			layoutAll((ContainerShape)child);
		}
		
		layout(shape);
	}
	

	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y) {
		createGaAndInnerShapes(shape, bo, x, y, 0);
	}

	/**
	 * Version of createGaAndInnerShapes that limits recursion
	 * @param shape
	 * @param bo
	 * @param x
	 * @param y
	 * @param callDepth
	 */
	private void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y, final int callDepth) {
		visibilityHelper.setIsGhost(shape, false);
		
		final Feature feature = (Feature)bo;
		final IGaService gaService = Graphiti.getGaService();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();		
	
		// Remove all children except for the feature shape
		final Iterator<Shape> childIt = shape.getChildren().iterator();
		ContainerShape featureShape = getFeatureShape(shape);
		while(childIt.hasNext()) {
			if(featureShape != childIt.next()) {
				childIt.remove();
			}
		}

		// Set the graphics algorithm for the container to an invisible rectangle to set the bounds	of the child shapes
        final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
        gaService.setLocation(ga, x, y);
        propertyUtil.setIsLeftLayout(shape, true);        

		// Create the feature shape if there wasn't one
        if(featureShape == null) {
        	featureShape = peCreateService.createContainerShape(shape, true);
        	gaService.createInvisibleRectangle(featureShape);
        	propertyUtil.setName(featureShape, featureShapeName);
        } else {
        	gaService.createInvisibleRectangle(featureShape);
        	visibilityHelper.ghostInvalidShapes(featureShape);
        }

		if(callDepth > 2) {
			return;
		}
		
		// Determine the label text
        final String labelTxt = getLabelText(feature);        
        
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        this.link(labelShape, new AadlElementWrapper(feature));
        propertyUtil.setName(labelShape, labelShapeName);
        final Text label = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, labelTxt);
        
        // Set the size        
        final IDimension labelSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, label.getStyle().getFont());
		gaService.setLocationAndSize(label, 0, 0, labelSize.getWidth(), labelSize.getHeight());		
		
		// Special case for feature groups
		if(feature instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup)feature;
			final FeatureGroupType fgt = featureService.getFeatureGroupType(shape, fg);
			int childY = 0;
			int maxChildWidth = 0;
			if(fgt == null) {
				featureShape.getChildren().clear();
			} else {				
		        // Create a set of child shapes for deletion. We will remove shapes from this list as they are updated. If a shape isn't updated, it should be turned into a ghost even though
		        // it has a valid business object associated with it.
		        final Set<Shape> featureShapeChildrenToGhost = new HashSet<Shape>();
		        featureShapeChildrenToGhost.addAll(visibilityHelper.getNonGhostChildren(featureShape));
		        
		        // Create shapes for each of the children if the feature group is not part of a subcomponent
		        if(shapeService.getClosestAncestorWithBusinessObjectType(shape, Subcomponent.class) == null) {
			        // Create/Update shapes for the child features
					for(final Feature childFeature : featureService.getAllFeatures(fgt)) {
						ContainerShape childFeatureContainer = (ContainerShape)shapeService.getChildShapeByElementQualifiedName(featureShape, childFeature);
						
						// Get existing shape instead of always creating
						if(childFeatureContainer == null) {
				        	// Create the container shape
				        	childFeatureContainer = peCreateService.createContainerShape(featureShape, true);
				        	link(childFeatureContainer, new AadlElementWrapper(childFeature));
				        } else {
							// Remove the shape from the list of shapes to remove
							featureShapeChildrenToGhost.remove(childFeatureContainer);
				        }
						
				        createGaAndInnerShapes(childFeatureContainer, childFeature, 50, childY, callDepth + 1);
				        final GraphicsAlgorithm childFeatureGa = childFeatureContainer.getGraphicsAlgorithm();
				        childY += childFeatureGa.getHeight() + 5;
				        maxChildWidth = Math.max(maxChildWidth, childFeatureGa.getWidth());
					}
		        }
				
				// Remove children of the feature shape that were not updated
				for(final Shape featureShapeChild : featureShapeChildrenToGhost) {
					visibilityHelper.setIsGhost(featureShapeChild, true);
				}
			}
			
			// Create the feature group graphics algorithm
			final GraphicsAlgorithm fgGa = graphicsAlgorithmCreator.createFeatureGroupGraphicsAlgorithm(featureShape, featureGroupSymbolWidth, childY + 25);
			graphicsAlgorithmUtil.shrink(fgGa);
			final int fgWidth = maxChildWidth+featureGroupSymbolWidth;
	     	
			// CLEAN-UP: Consider changing how symbol is created to assume left like the other symbols...
			graphicsAlgorithmUtil.mirror(fgGa);					

			featureShape.getGraphicsAlgorithm().setWidth(fgWidth);
		} else {
			featureShape.getChildren().clear();
			
			// Flag to indicate whether a graphics algorithm has been created by the prototype handling code
			boolean featureGaCreated = false;
			
			// Check to see if it is a prototype feature
			if(feature instanceof AbstractFeature) {
				final AbstractFeature af = (AbstractFeature)feature;
				if(af.getFeaturePrototype() != null) {
					// Lookup the binding
					// Get the proper context (FeatureGroupType or ComponentClassifier) - May be indirectly for example from Subcomponent...
					final Element bindingContext = prototypeService.getPrototypeBindingContext(shape);
					if(bindingContext != null) {
						final PrototypeBinding binding = ResolvePrototypeUtil.resolveFeaturePrototype(af.getFeaturePrototype(), bindingContext);
						if(binding instanceof FeaturePrototypeBinding) {
							FeaturePrototypeActual actual = ((FeaturePrototypeBinding) binding).getActual();
							if(actual instanceof PortSpecification) {
								graphicsAlgorithmCreator.createPortGraphicsAlgorithm(featureShape, ((PortSpecification) actual).getCategory(), ((PortSpecification) actual).getDirection());
								featureGaCreated = true;
							} else if(actual instanceof AccessSpecification) {
								graphicsAlgorithmCreator.createAccessGraphicsAlgorithm(featureShape, ((AccessSpecification) actual).getCategory(), ((AccessSpecification) actual).getKind());
								featureGaCreated = true;
							}
						}
					}
				}
			}
			
			// Create the symbol based on the feature itself if one has not been created already
			if(!featureGaCreated) {
				// Create symbol
				graphicsAlgorithmCreator.createFeatureGraphicsAlgorithm(featureShape, feature);		
			}
		}
		
		// Position the feature shape		
		gaService.setLocation(featureShape.getGraphicsAlgorithm(), 0, labelSize.getHeight());  
		
		// Determine whether the feature has a "context" and then highlight it
		final Element possibleContext = shapeService.getClosestBusinessObjectOfType(shape, Context.class, Classifier.class);
     	highlightingService.highlight(feature, possibleContext instanceof Context ? (Context)possibleContext : null, featureShape.getGraphicsAlgorithm());		
     	
        // Set size as appropriate
        gaService.setSize(ga, Math.max(getWidth(label)+labelPadding, getWidth(featureShape.getGraphicsAlgorithm())), 
        		Math.max(getHeight(label), getHeight(featureShape.getGraphicsAlgorithm())));
     		
        layoutAll(shape); // CLEAN-UP: Ideally would only layout each shape one.. This will cause it to happen multiple times        
	}
	
	@Override
	protected void updateAnchors(final ContainerShape shape) {
		super.updateAnchors(shape);

		final Feature feature = (Feature)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));		
		final GraphicsAlgorithm featureGa = getFeatureShape(shape).getGraphicsAlgorithm();
		final boolean isLeft = isLeft(shape);
		
		final int featureWidth = feature instanceof FeatureGroup ? featureGroupSymbolWidth : featureGa.getWidth();
		final int innerX = featureGa.getX() + (isLeft ? featureWidth : featureGa.getWidth() - featureWidth);
		final int outerX = featureGa.getX() + (isLeft ? 0 : featureGa.getWidth());
		final int connectorY = featureGa.getY() + (featureGa.getHeight() / 2);
		final int flowSpecConnectorY = feature instanceof FeatureGroup ? featureGa.getHeight() - 5 : connectorY;
		final int offset = isLeft ? 50 : -50;

		// Create anchors		
		// Special cases for event out features
		if(feature instanceof EventPort && ((EventPort)feature).getDirection() == DirectionType.OUT) {
			anchorUtil.createOrUpdateFixPointAnchor(shape, innerConnectorAnchorName, outerX, connectorY);
		} else {
			anchorUtil.createOrUpdateFixPointAnchor(shape, innerConnectorAnchorName, innerX, connectorY);
		}
		
		if(feature instanceof EventPort && ((EventPort)feature).getDirection() == DirectionType.IN) {
			anchorUtil.createOrUpdateFixPointAnchor(shape, outerConnectorAnchorName, innerX, connectorY);
		} else {
			anchorUtil.createOrUpdateFixPointAnchor(shape, outerConnectorAnchorName, outerX, connectorY);
		}		
		
		anchorUtil.createOrUpdateFixPointAnchor(shape, flowSpecificationAnchorName, innerX + offset, flowSpecConnectorY);
		
		// Update the anchors of the children
		for(final Shape child : visibilityHelper.getNonGhostChildren(getFeatureShape(shape))) {
			updateAnchors((ContainerShape)child);
		}
	}
	
	private ContainerShape getFeatureShape(final ContainerShape container) {
		return (ContainerShape)shapeService.getChildShapeByName(container, featureShapeName);
	}
	
	private Shape getLabelShape(final ContainerShape container) {
		return shapeService.getChildShapeByName(container, labelShapeName);
	}	

	private int getWidth(final GraphicsAlgorithm ga) {
		return ga.getX() + ga.getWidth();
	}
	
	private int getHeight(final GraphicsAlgorithm ga) {
		return ga.getY() + ga.getHeight();
	}
	
	public final String getLabelText(final Feature feature) {
		return feature.getName();
	}
		
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createFalseReason();
	}
	
	private boolean isLeft(ContainerShape shape) {
		while(true) {
			final ContainerShape container = shape.getContainer();
			if(container == null) {
				break;
			}
			
			final Object containerBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(container));
			if(containerBo instanceof Classifier || containerBo instanceof Subcomponent) {
				break;
			}
			shape = container;
		}

		return propertyUtil.getIsLeft(shape);
	}
	
	private boolean calculateIsLeft(final ContainerShape container, final int centerX) {
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		
		// Handle the case that isLeft is caused before the container is initialized
		if(containerGa == null) {
			return true;
		}
		
		final boolean result = centerX < containerGa.getWidth()/2;
		return result;
	}	
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return canEdit(context.getPictogramElement());
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		final Feature feature = (Feature)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		modificationService.modify(feature, new AbstractModifier<Feature, Object>() {
			@Override
			public Object modify(final Resource resource, final Feature feature) {
				// Just remove the feature. 
				// In the future it would be helpful to offer options for refactoring the model so that it does not cause errors.
				EcoreUtil.remove(feature);
				
				return null;
			}
		});
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
	
	@Override
	public boolean isPaletteApplicable() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return getFeatureCreateMethod((Classifier)diagramBo, featureType) != null;
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());

		// The container must be a Feature Group Type or a ComponentType and it must have a method to create the feature type that is controlled by this pattern
		return (containerBo instanceof FeatureGroupType || containerBo instanceof ComponentType) && canContainFeatureType((Classifier)containerBo, featureType);
	}
	
	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(featureType.getName());
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		// Get the classifier
		final Classifier classifier = (Classifier)bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		final Feature newFeature;
		if(classifier == null) {
			newFeature = null;
		} else {		
			final String newFeatureName = namingService.buildUniqueIdentifier(classifier, "new_feature");
			
			// Make the modification
			newFeature = modificationService.modify(classifier, new AbstractModifier<Classifier, Feature>() {
				private DiagramModificationService.Modification diagramMod;
				
				@Override
				public Feature modify(final Resource resource, final Classifier classifier) {
					// Handle diagram updates
		 			diagramMod = diagramModService.startModification();
		 			diagramMod.markRelatedDiagramsAsDirty(classifier);
		 			
					final Feature newFeature = createFeature(classifier, featureType);
					newFeature.setName(newFeatureName);
					return newFeature;
				}
				
				@Override
				public void beforeCommit(final Resource resource, final Classifier classifier, final Feature newFeature) {
					diagramMod.commit();
					
					final ContainerShape newShape = (ContainerShape)shapeCreationService.createShape(context.getTargetContainer(), newFeature, context.getX(), context.getY());
					
					// Set the is left property
					final GraphicsAlgorithm newShapeGa = newShape.getGraphicsAlgorithm();
					final boolean isLeft = calculateIsLeft(newShape.getContainer(), context.getX() + (newShapeGa.getWidth() / 2));
					propertyUtil.setIsLeft(newShape, isLeft);
				}
			});
		}
		
		// Return the new feature if it was created
		return newFeature == null ? EMPTY : new Object[] {newFeature};		
	}

	private static Method getFeatureCreateMethod(final Classifier featureOwner, final EClass featureType) {
		// Determine the method name for the type of feature
		final String methodName = featureTypeToMethodNameMap.get(featureType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = featureOwner.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
	public static Feature createFeature(final Classifier featureOwner, final EClass featureClass) {
		try {
			return (Feature)getFeatureCreateMethod(featureOwner, featureClass).invoke(featureOwner);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean canContainFeatureType(final Classifier featureOwner, final EClass featureType) {
		return getFeatureCreateMethod(featureOwner, featureType) != null;
	}
	
	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}
	
	@Override
	public int getEditingType() {
        return TYPE_TEXT;
    }
	
	private boolean canEdit(final PictogramElement pe) {
		if(!(pe instanceof Shape)) {
			return false;
		}
		
		final Shape featureShape = (Shape)pe;
		final Object bo = bor.getBusinessObjectForPictogramElement(featureShape);
		if(!(bo instanceof Feature)) {
			return false;
		}
		
		final Feature feature = (Feature)bo;
		final Object containerBo = bor.getBusinessObjectForPictogramElement(featureShape.getContainer());
		return (containerBo instanceof FeatureGroupType || containerBo instanceof ComponentType) && feature.getContainingClassifier() == containerBo;
	}
 
	@Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
		if(context.getPictogramElement() instanceof Shape) {
	        final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
	        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
	        
	        if (bo instanceof Feature && ga instanceof Text) {
	        	final Shape labelShape = (Shape)context.getPictogramElement();
	        	final Shape featureShape = labelShape.getContainer();
	        	return canEdit(featureShape) && ((Feature)bo).getRefined() == null;
	        }
		}

        return false;
    }
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final Feature feature = (Feature)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return this.getLabelText(feature);
    }
    
    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }
     
 	public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Feature feature = (Feature)bor.getBusinessObjectForPictogramElement(pe);    	
   	
    	modificationService.modify(feature, new RenameFeatureModifier(value, diagramModService));   	
    }
 	
 	private static class RenameFeatureModifier extends AbstractModifier<Feature, Object> {
    	private final String newName;
		private final DiagramModificationService diagramModService;
		private DiagramModificationService.Modification diagramMod;
		
 		public RenameFeatureModifier(final String newName, final DiagramModificationService diagramModService) {
			this.newName = newName;
			this.diagramModService = diagramModService;
		}
 		
 		@Override
		public Object modify(final Resource resource, final Feature feature) {
 			// Resolving allows the name change to propagate when editing without an Xtext document
 			EcoreUtil.resolveAll(resource.getResourceSet());
			
 			diagramMod = diagramModService.startModification();
 			diagramMod.markLinkagesAsDirty(feature);
			feature.setName(newName); // TODO:Reneable
			
			updateReferences(feature, resource.getResourceSet());
			
			return null;
		}
 		
 		/**
 		 * Recursive method that updates references to the feature. It recursively updates refinees.
 		 * @param feature
 		 * @param resourceSet
 		 */
 	    private void updateReferences(final Feature feature, final ResourceSet resourceSet) {
 			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(feature, resourceSet)) {
 				final EStructuralFeature sf = s.getEStructuralFeature();
 				if(!sf.isDerived() && sf.isChangeable()) {
 					final EObject obj = s.getEObject();
 		 			// Mark linkages to refinements as dirty
 					if(obj instanceof Feature && ((Feature)obj).getRefined() == feature) {
 						final Feature refinee = (Feature)obj;
 						
 						diagramMod.markLinkagesAsDirty(refinee);
 						
 						// Set the refined element to null and then set it again to trigger the change 
 						refinee.setRefined(null);
 						refinee.setRefined(feature);
 						
 						updateReferences(refinee, resourceSet);
 					} else if(obj instanceof ConnectedElement) {
						final ConnectedElement connectedElement = (ConnectedElement)obj;
						if(connectedElement.getConnectionEnd() == feature) {
							// Reset the connection end. This will trigger and update by xtext
							connectedElement.setConnectionEnd(null);
							connectedElement.setConnectionEnd(feature);							
						} 
					} else if(obj instanceof ModeTransitionTrigger) {
						final ModeTransitionTrigger mtt = (ModeTransitionTrigger)obj;
						if(mtt.getTriggerPort() == feature) {
							// Reset the port. This will trigger and update by xtext
							mtt.setTriggerPort(null);
							mtt.setTriggerPort((TriggerPort)feature);							
						} 
					} else if(obj instanceof FlowEnd) {
						final FlowEnd fe = (FlowEnd)obj;
						if(fe.getFeature() == feature) {
							// Reset the feature. This will trigger and update by xtext
							fe.setFeature(null);
							fe.setFeature(feature);
						}
						
						// Flow Implementations do not have a reference to the feature but rather to the flow specification. Trigger an update.
						if(fe.getOwner() instanceof FlowSpecification) {
							final FlowSpecification flowSpec = (FlowSpecification)fe.getOwner();
							updateFlowImplementationReferencesToFlowSpecification(flowSpec, resourceSet);
						}
					} else if(obj instanceof FlowSegment && obj instanceof FlowElement) {
						final FlowSegment fs = (FlowSegment)obj;
						if(fs.getFlowElement() == feature) {
							// Reset the flow element. This will trigger and update by xtext
							fs.setFlowElement(null);
							fs.setFlowElement((FlowElement)feature);							
						}
					}
 				}
 			}
 	    }
 				
 		private void updateFlowImplementationReferencesToFlowSpecification(final FlowSpecification flowSpec, final ResourceSet resourceSet) {
 			// Look for flow implementations
			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(flowSpec, resourceSet)) {
				final EStructuralFeature sf = s.getEStructuralFeature();
				if(!sf.isDerived() && sf.isChangeable()) {
					final EObject obj = s.getEObject();
					if(obj instanceof FlowImplementation) {
						final FlowImplementation fi = (FlowImplementation)obj;
						if(fi.getSpecification() == flowSpec) {
							fi.setSpecification(null);
							fi.setSpecification(flowSpec);
						}
					}
				}
			}
 		}		

		@Override
		public void beforeCommit(final Resource resource, final Feature feature, final Object modificationResult) {
			diagramMod.commit();
		}
 	}

}
