package edu.uah.rsesc.aadl.age.patterns;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Classifier;
import edu.uah.rsesc.aadl.age.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class PackageClassifierPattern extends AbstractPattern implements IPattern {
	public PackageClassifierPattern() {
		super(null);
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return mainBusinessObject instanceof Classifier;
	}

	@Override
	protected boolean isPatternControlled(final PictogramElement pictogramElement) {
		final Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	protected boolean isPatternRoot(final PictogramElement pictogramElement) {
		final Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}
	
	@Override
	public boolean canAdd(final IAddContext context) {
		if(context.getNewObject() instanceof Classifier) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(final IAddContext context) {
		final Classifier classifier = (Classifier)context.getNewObject();
		final Diagram diagram = getDiagram();
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		int width = 100;
        int height = 50; 
        
        // Create the container shape
        final ContainerShape container = peCreateService.createContainerShape(diagram, true);
        link(container, classifier);        
       
        final GraphicsAlgorithm ga = GraphicsAlgorithmCreator.createGraphicsAlgorithm(container, diagram, classifier, width, height);        
        gaService.setLocation(ga, context.getX(), context.getY());
        
        // Create anchor
        final Anchor anchor = peCreateService.createChopboxAnchor(container);
        anchor.setReferencedGraphicsAlgorithm(ga);
        
        // Create label
        Shape shape = peCreateService.createShape(container, false);
        
        final String label = (this.getBusinessObjectForPictogramElement(diagram) == classifier.getNamespace().getOwner()) ? classifier.getName() : classifier.getQualifiedName(); 
        final Text text = gaService.createPlainText(shape, label);
        text.setStyle(StyleUtil.getClassifierLabelStyle(diagram));
        gaService.setLocationAndSize(text, 0, 0, width, 20);

        return container;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return (getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Classifier);
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		//System.out.println("UPDATE NEEDED?");
	//	context.getPictogramElement().g
	//	return Reason.createTrueReason();
		return Reason.createFalseReason();
		//return null;
	}

	@Override
	public boolean update(final IUpdateContext context) {
		//System.out.println("UPDATING....");
		return false;
	}
	
	@Override
	public boolean canRemove(final IRemoveContext context) {
		return false;
	}	
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return false;
	}

	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return super.canResizeShape(context);
	}
	
	public void resizeShape(final IResizeShapeContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(pe instanceof ContainerShape) {
			final ContainerShape container = (ContainerShape)pe;
			if(bo != null) {
				if(bo instanceof Classifier) {
		        	final GraphicsAlgorithm ga = GraphicsAlgorithmCreator.createGraphicsAlgorithm(container, getDiagram(), ((Classifier)bo), context.getWidth(), context.getHeight());
				}				
			}
		}
		
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
	
	
}
