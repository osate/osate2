package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AadlFeatureService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PrototypeService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

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
	private static final int featureGroupSymbolWidth = 30;
	private static final int labelPadding = 5;
	private final AnchorService anchorUtil;
	private final VisibilityService visibilityHelper;
	private final PropertyService propertyUtil;
	private final GraphicsAlgorithmService graphicsAlgorithmUtil;
	private final UpdateService updateHelper;
	private final ShapeService shapeHelper;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final AadlFeatureService featureService;
	private final PrototypeService prototypeService;
	
	@Inject
	public FeaturePattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, 
			final PropertyService propertyUtil, final GraphicsAlgorithmService graphicsAlgorithmUtil, final UpdateService updateHelper,
			final ShapeService shapeHelper, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, final AadlFeatureService featureService, final PrototypeService prototypeService) {
		super(anchorUtil, visibilityHelper);
		this.anchorUtil = anchorUtil;
		this.visibilityHelper = visibilityHelper;
		this.propertyUtil = propertyUtil;
		this.graphicsAlgorithmUtil = graphicsAlgorithmUtil;
		this.updateHelper = updateHelper;
		this.shapeHelper = shapeHelper;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.featureService = featureService;
		this.prototypeService = prototypeService;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Feature;
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
        	updateHelper.ghostInvalidShapes(featureShape);
        }

		if(callDepth > 2) {
			return;
		}
		
		// Determine the label text
        final String labelTxt = getLabelText(feature);        
        
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        propertyUtil.setName(labelShape, labelShapeName);
        final Text label = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, getDiagram(), labelTxt);
        
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
		        
		        // Create/Update shapes for the child features
				for(final Feature childFeature : featureService.getAllFeatures(fgt)) {
					ContainerShape childFeatureContainer = shapeHelper.getChildShapeByElementQualifiedName(featureShape, childFeature);
					
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
				
				// Remove children of the feature shape that were not updated
				for(final Shape featureShapeChild : featureShapeChildrenToGhost) {
					visibilityHelper.setIsGhost(featureShapeChild, true);
				}
			}
			
			// Create the feature group graphics algorithm
			final GraphicsAlgorithm fgGa = graphicsAlgorithmCreator.createFeatureGroupGraphicsAlgorithm(featureShape, getDiagram(), featureGroupSymbolWidth, childY + 25);
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
								graphicsAlgorithmCreator.createPortGraphicsAlgorithm(featureShape, getDiagram(), ((PortSpecification) actual).getCategory(), ((PortSpecification) actual).getDirection());
								featureGaCreated = true;
							} else if(actual instanceof AccessSpecification) {
								graphicsAlgorithmCreator.createAccessGraphicsAlgorithm(featureShape, getDiagram(), ((AccessSpecification) actual).getCategory(), ((AccessSpecification) actual).getKind());
								featureGaCreated = true;
							}
						}
					}
				}
			}
			
			// Create the symbol based on the feature itself if one has not been created already
			if(!featureGaCreated) {
				// Create symbol
				graphicsAlgorithmCreator.createFeatureGraphicsAlgorithm(featureShape, getDiagram(), feature);		
			}
		}
		
		// Position the feature shape
		gaService.setLocation(featureShape.getGraphicsAlgorithm(), 0, labelSize.getHeight());  
		
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
		return (ContainerShape)shapeHelper.getChildShapeByName(container, featureShapeName);
	}
	
	private Shape getLabelShape(final ContainerShape container) {
		return shapeHelper.getChildShapeByName(container, labelShapeName);
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
}
