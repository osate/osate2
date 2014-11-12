package org.osate.ge.diagrams.common.features;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.SubcomponentService;

public class UpdateFromDiagramFeature extends AbstractCustomFeature {
	private final DiagramService diagramService;
	private final SubcomponentService subcomponentService;
	private final PropertyService propertyService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public UpdateFromDiagramFeature(final DiagramService diagramService, final SubcomponentService subcomponentService, 
			final PropertyService propertyService, final ShapeService shapeService, final BusinessObjectResolutionService bor, 
			final IFeatureProvider fp) {
		super(fp);
		this.diagramService = diagramService;
		this.subcomponentService = subcomponentService;
		this.propertyService = propertyService;
		this.shapeService = shapeService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Update from Diagram";
    }
	
	@Override
	public boolean isAvailable(final IContext context) {
		if(!(context instanceof ICustomContext)) {
			return false;
		}
		
		final ICustomContext customContext = (ICustomContext)context;		
    	if(customContext.getPictogramElements().length != 1) {
    		return false;
    	}
    	
    	// Only allow when the feature is owned by the container    	
    	final PictogramElement pe = customContext.getPictogramElements()[0];
    	if(!(pe instanceof Shape)) {
    		return false;
    	}
    	
    	final Shape shape = (Shape)customContext.getPictogramElements()[0];
    	final Object bo = (NamedElement)bor.getBusinessObjectForPictogramElement(pe);
    	return bo instanceof Subcomponent && subcomponentService.getComponentClassifier(shape, (Subcomponent)bo) != null;
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
	
    // TODO: Does Graphiti have support for(potentially) long running jobs?
    
	@Override
	public void execute(final ICustomContext context) {
		final Shape shape = (Shape)context.getPictogramElements()[0];
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(shape);
		final ComponentClassifier classifier = subcomponentService.getComponentClassifier(shape, sc);
		
		// TODO: Reword
		final Shape rootShape = findRootShape(classifier);
		if(rootShape == null) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", "Unable to find associated diagram or shape.");
		}
		
		// TODO: Need terminology for which diagram a shape belongs to. Foreign? Src, dst?
		
		// Resize the shape
		resizeOrMove(shape, rootShape.getGraphicsAlgorithm().getWidth(), rootShape.getGraphicsAlgorithm().getHeight());

		// TODO: Adjust Inner Shapes(along with Properties for features)
		if(shape instanceof ContainerShape && rootShape instanceof ContainerShape) {
			adjustInnerShapes((ContainerShape)shape, (ContainerShape)rootShape);
		}

		// TODO: Adjust Connections
	}	
	
	// TODO: Rename?
	// TODO: Rename "foreign"
	// Labels, etc
	private void adjustInnerShapes(final ContainerShape shape, final ContainerShape foreignShape) {
		for(final Shape innerShape : shapeService.getNonGhostChildren(shape)) {
			final Object bo = bor.getBusinessObjectForPictogramElement(innerShape);
			if(bo != null && propertyService.getName(innerShape) == null) {
				for(final Shape foreignInnerShape : shapeService.getNonGhostChildren(foreignShape)) {
					final Object foreignBo = bor.getBusinessObjectForPictogramElement(foreignInnerShape);
					if(bo == foreignBo) {
						// Move the shape
						final GraphicsAlgorithm foreignGa = foreignInnerShape.getGraphicsAlgorithm();
						if(foreignGa != null) {
							resizeOrMove(innerShape, foreignGa.getX(), foreignGa.getY(),foreignGa.getWidth(),foreignGa.getHeight());
							
							// Adjust inner shapes
							if(bo instanceof Subcomponent) { 
								if(innerShape instanceof ContainerShape && foreignInnerShape instanceof ContainerShape) {
									adjustInnerShapes((ContainerShape)innerShape, (ContainerShape)foreignInnerShape);
								}
							}
						}
					}
				}
			}
		}
	}
	
	// TODO: Rename?
	private void resizeOrMove(final Shape shape, final int width, final int height) {
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		resizeOrMove(shape, ga.getX(), ga.getY(), width, height);
	}
	
	private void resizeOrMove(final Shape shape, final int x, final int y, final int width, final int height) {
		final ResizeShapeContext context = new ResizeShapeContext(shape);
		context.setSize(width, height);
		context.setLocation(x, y);
		
		// Try to resize the shape
		final IResizeShapeFeature feature = getFeatureProvider().getResizeShapeFeature(context);
		if(feature != null && feature.canResizeShape(context)) {
			feature.resizeShape(context);
		} else {
			// Try simply moving the shape
			move(shape, x, y);
		}
		
	}	
	
	private void move(final Shape shape, final int x, final int y) {
		final MoveShapeContext context = new MoveShapeContext(shape);
		context.setLocation(x, y);
		context.setSourceContainer(shape.getContainer());
		context.setTargetContainer(shape.getContainer());
		
		// Move the shape
		final IMoveShapeFeature feature = getFeatureProvider().getMoveShapeFeature(context);
		if(feature != null && feature.canMoveShape(context)) {
			feature.moveShape(context);
		}
	}

	private Shape findRootShape(final ComponentClassifier classifier) {
		// Find all diagrams related to the subcomponent's classifier
		final List<Diagram> diagrams = diagramService.findDiagramsByRootBusinessObject(classifier);
		if(diagrams.size() == 0) {
			return null;
		}

		// Use the first diagram
		final Diagram diagram = diagrams.get(0);
		
		// TODO: Get the root shape
		// TODO: Need a different feature provider, etc?		
		for(final Shape childShape : diagram.getChildren()) {
			if(bor.getBusinessObjectForPictogramElement(childShape) == classifier) {
				return childShape;
			}
			
		}
		
		return null;
	}
}
