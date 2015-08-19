package org.osate.ge.diagrams.common.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.LabelService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.ShapeService;

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
	
	@Inject
	public AnnexPattern(final GhostingService ghostingService, final AnchorService anchorService, final ShapeService shapeService, final LabelService labelService, 
			final LayoutService layoutService, final BusinessObjectResolutionService bor) {
		this.ghostingService = ghostingService;
		this.anchorService = anchorService;
		this.shapeService = shapeService;
		this.labelService = labelService;
		this.layoutService = layoutService;
		this.bor = bor;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof AnnexLibrary || bo instanceof AnnexSubclause;
	}
	
	@Override
	public boolean isPaletteApplicable() {
		return false;
	}
	
	// Adding
	@Override
	public boolean canAdd(final IAddContext context) {
		return isMainBusinessObjectApplicable(context.getNewObject());
	}
	
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
	
	private GraphicsAlgorithm createGraphicsAlgorithm(final Shape shape, final int x, final int y) {
		final IGaService gaService = Graphiti.getGaService();
        final GraphicsAlgorithm ga = gaService.createPlainRectangle(shape);
        gaService.setLocation(ga, x, y);
        ga.setFilled(false);
        return ga;
	}
	
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
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final int x = shape.getGraphicsAlgorithm().getX();
		final int y = shape.getGraphicsAlgorithm().getY();
		final NamedElement annexElement = (NamedElement)bor.getBusinessObjectForPictogramElement(shape);

		final IGaService gaService = Graphiti.getGaService();
		final Shape nameShape = Objects.requireNonNull(getNameShape(shape), "unable to retrieve name shape");
		
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
		gaService.setLocation(nameShape.getGraphicsAlgorithm(), (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, 5);
					
		// Set the shape as not filled
		ga.setFilled(false);
						
		// Refresh. For some reason if it is not refreshed, some shapes may not be drawn correctly.
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();

		return true;
	}
	
	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, nameShapeName);
	}
}
