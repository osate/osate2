package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;

/**
 * Pattern for controlling Feature shapes
 * Note: With the exception of child feature shapes, child shapes are recreated during updates so they should not be referenced.
 * @author philip.alldredge
 */
public class FeaturePattern extends AgeLeafShapePattern {
	private static final String featureShapeName = "feature";
	private static final String labelShapeName = "label";	
	public static final String innerConnectorAnchorName = "innerConnector";
	public static final String outerConnectorAnchorName = "outerConnector";
	public static final String flowSpecificationAnchorName = "flowSpecification";
	private static final int featureGroupSymbolWidth = 30;
	private static final int labelPadding = 5;
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Feature;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext ctx) {
		if(ctx.getPictogramElement() instanceof Shape){
			final Shape shape = (Shape)ctx.getPictogramElement();
			// TODO: Add support for moving features within a feature group
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
		PropertyUtil.setIsLeft(shape, isLeft);
		
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
		
		boolean wasLeftLayout = PropertyUtil.getIsLeftLayout(shape);
		final boolean isLeftLayout = isLeft(shape);
		PropertyUtil.setIsLeftLayout(shape, isLeftLayout);
		
		// Feature groups
		if(feature instanceof FeatureGroup) {
			if(isLeftLayout != wasLeftLayout) {
				GraphicsAlgorithmUtil.mirror(featureGa);
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
	    		GraphicsAlgorithmUtil.mirror(featureGa);
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
		for(final Shape child : getFeatureShape(shape).getChildren()) {
			layoutAll((ContainerShape)child);
		}
		
		layout(shape);
	}
	

	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y) {
		createGaAndInnerShapes(shape, bo, x, y, 0);
	}

	// CLEAN-UP: Move to another class?
	/**
	 * Returns the classifier obtained directly from a shape or indirectly from a subcomponent that contains the specified shape. May return null. For example when a subcomponent
	 * does not specify a classifier
	 * @param shape
	 * @param fp
	 * @return
	 */
	private static Classifier getContainingClassifier(final Shape shape, final IFeatureProvider fp) {
		ContainerShape temp = shape.getContainer();
		while(temp != null) {
			Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(temp));
			if(bo instanceof ComponentClassifier || bo instanceof FeatureGroupType) {
				return (Classifier)bo;
			} else if(bo instanceof Subcomponent) {
				// TODO: Handle prototype bindings...
				return ((Subcomponent) bo).getClassifier();
			}	

			temp = temp.getContainer();
		}
		return null;
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
        PropertyUtil.setIsLeftLayout(shape, true);
        
		if(callDepth > 2) {
			return;
		}

		// Create the feature shape if there wasn't one
        if(featureShape == null) {
        	featureShape = peCreateService.createContainerShape(shape, true);
        	PropertyUtil.setName(featureShape, featureShapeName);
        } else {
        	gaService.createInvisibleRectangle(featureShape);
        	UpdateHelper.removeInvalidShapes(featureShape, getFeatureProvider());
        }

		// Determine the label text
        final String labelTxt = getLabelText(feature);        
        
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        PropertyUtil.setName(labelShape, labelShapeName);
        final Text label = GraphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, getDiagram(), labelTxt);
        
        // Set the size        
        final IDimension labelSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, label.getStyle().getFont());
		gaService.setLocationAndSize(label, 0, 0, labelSize.getWidth(), labelSize.getHeight());		
		
		// Special case for feature groups
		if(feature instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup)feature;
			
			int childY = 0;
			int maxChildWidth = 0;
			if(fg.getAllFeatureGroupType() == null) {
				featureShape.getChildren().clear();
			} else {				
		        // Create a set of child shapes for deletion. We will remove shapes from this list as they are updated. If a shape isn't updated, it should be removed even though
		        // it has a valid business object associated with it.
		        final Set<Shape> featureShapeChildrenToDelete = new HashSet<Shape>();
		        featureShapeChildrenToDelete.addAll(featureShape.getChildren());
		        
		        // Create/Update shapes for the child features
				for(final Feature childFeature : ClassifierHelper.getAllFeatures(fg.getAllFeatureGroupType())) {
					ContainerShape childFeatureContainer = ShapeHelper.getChildShapeByElement(featureShape, childFeature, getFeatureProvider());
					
					// Get existing shape instead of always creating
					if(childFeatureContainer == null) {
			        	// Create the container shape
			        	childFeatureContainer = peCreateService.createContainerShape(featureShape, true);
			        	link(childFeatureContainer, new AadlElementWrapper(childFeature));
			        } else {
						// Remove the shape from the list of shapes to remove
						featureShapeChildrenToDelete.remove(childFeatureContainer);
			        }
					
			        createGaAndInnerShapes(childFeatureContainer, childFeature, 50, childY, callDepth + 1);
			        final GraphicsAlgorithm childFeatureGa = childFeatureContainer.getGraphicsAlgorithm();
			        childY += childFeatureGa.getHeight() + 5;
			        maxChildWidth = Math.max(maxChildWidth, childFeatureGa.getWidth());
				}
				
				// Remove children of the feature shape that were not updated
				for(final Shape featureShapeChild : featureShapeChildrenToDelete) {
					EcoreUtil.delete(featureShapeChild, true);	
				}
			}
			
			// Create the feature group graphics algorithm
			final GraphicsAlgorithm fgGa = GraphicsAlgorithmCreator.createFeatureGroupGraphicsAlgorithm(featureShape, getDiagram(), featureGroupSymbolWidth, childY + 25);
			GraphicsAlgorithmUtil.shrink(fgGa);
			final int fgWidth = maxChildWidth+featureGroupSymbolWidth;

			// CLEAN-UP: Consider changing how symbol is created to assume left like the other symbols...
			GraphicsAlgorithmUtil.mirror(fgGa);					

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
					final Classifier classifier = getContainingClassifier(shape, getFeatureProvider());
					if(classifier != null) {
						final PrototypeBinding binding = resolveFeaturePrototype(af.getFeaturePrototype(), classifier);
						if(binding instanceof FeaturePrototypeBinding) {
							FeaturePrototypeActual actual = ((FeaturePrototypeBinding) binding).getActual();
							if(actual instanceof PortSpecification) {
								GraphicsAlgorithmCreator.createPortGraphicsAlgorithm(featureShape, getDiagram(), getFeatureProvider(), ((PortSpecification) actual).getCategory(), ((PortSpecification) actual).getDirection());
								featureGaCreated = true;
							} else if(actual instanceof AccessSpecification) {
								GraphicsAlgorithmCreator.createAccessGraphicsAlgorithm(featureShape, getDiagram(), getFeatureProvider(), ((AccessSpecification) actual).getCategory(), ((AccessSpecification) actual).getKind());
								featureGaCreated = true;
							}
						}
					}
				}
			}
			
			// Create the symbol based on the feature itself if one has not been created already
			if(!featureGaCreated) {
				// Create symbol
				GraphicsAlgorithmCreator.createFeatureGraphicsAlgorithm(featureShape, getDiagram(), feature, getFeatureProvider());		
			}
		}
		
		// Position the feature shape
		gaService.setLocation(featureShape.getGraphicsAlgorithm(), 0, labelSize.getHeight());  
		
        // Set size as appropriate
        gaService.setSize(ga, Math.max(getWidth(label)+labelPadding, getWidth(featureShape.getGraphicsAlgorithm())), 
        		Math.max(getHeight(label), getHeight(featureShape.getGraphicsAlgorithm())));

        layoutAll(shape); // CLEAN-UP: Ideally would only layout each shape one.. This will cause it to happen multiple times        
	}
	
	// TODO: Use OSATE2 version if/when accepted
	/**
	 * Find the binding for a given feature prototype. Recursively resolves references.
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a ComponentType,  FeatureGroupType
	 * @return the actual feature this prototype resolves to.
	 */
	private static FeaturePrototypeBinding resolveFeaturePrototype(Prototype proto, Element context) {
		final FeaturePrototypeBinding fpb = (FeaturePrototypeBinding)ResolvePrototypeUtil.resolvePrototype(proto, context);
		if(fpb == null) {
			// cannot resolve
			return null;
		}
		
		final FeaturePrototypeActual actual = fpb.getActual();
		if(actual instanceof FeaturePrototypeReference) {
			return resolveFeaturePrototype(((FeaturePrototypeReference) actual).getPrototype(), context);
		}			
		
		return fpb;
	}

	@Override
	protected void updateAnchors(final ContainerShape shape) {
		super.updateAnchors(shape);

		final Feature feature = (Feature)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));		
		final GraphicsAlgorithm featureGa = getFeatureShape(shape).getGraphicsAlgorithm();
		final boolean isLeft = isLeft(shape);
		
		final int featureWidth = feature instanceof FeatureGroup ? featureGroupSymbolWidth : featureGa.getWidth();
		final int innerX = featureGa.getX() + (isLeft ? featureWidth : featureGa.getWidth() - featureWidth);
		final int outerX = featureGa.getX() + (isLeft ? 0 : featureWidth);
		final int connectorY = feature instanceof FeatureGroup ? featureGa.getHeight() - 5 : featureGa.getY() + (featureGa.getHeight() / 2);
		final int offset = isLeft ? 50 : -50;

		// Create anchors		
		// Special cases for event out features
		if(feature instanceof EventPort && ((EventPort)feature).getDirection() == DirectionType.OUT) {
			AnchorUtil.createOrUpdateFixPointAnchor(shape, innerConnectorAnchorName, outerX, connectorY);
		} else {
			AnchorUtil.createOrUpdateFixPointAnchor(shape, innerConnectorAnchorName, innerX, connectorY);
		}
		
		if(feature instanceof EventPort && ((EventPort)feature).getDirection() == DirectionType.IN) {
			AnchorUtil.createOrUpdateFixPointAnchor(shape, outerConnectorAnchorName, innerX, connectorY);
		} else {
			AnchorUtil.createOrUpdateFixPointAnchor(shape, outerConnectorAnchorName, outerX, connectorY);
		}		
		
		AnchorUtil.createOrUpdateFixPointAnchor(shape, flowSpecificationAnchorName, innerX + offset, connectorY);
		
		// Update the anchors of the children
		for(final Shape child : getFeatureShape(shape).getChildren()) {
			updateAnchors((ContainerShape)child);
		}
	}
	
	public static ContainerShape getFeatureShape(final ContainerShape container) {
		return (ContainerShape)ShapeHelper.getChildShapeByName(container, featureShapeName);
	}
	
	public static Shape getLabelShape(final ContainerShape container) {
		return ShapeHelper.getChildShapeByName(container, labelShapeName);
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
		
		return PropertyUtil.getIsLeft(shape);
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
