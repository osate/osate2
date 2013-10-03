package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICustomUndoableFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.ComponentImplementation;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.features.LayoutDiagramFeature;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.util.Log;

public class ComponentImplementationUpdateDiagramFeature extends AbstractUpdateFeature implements ICustomUndoableFeature {
	private final StyleService styleService;
	private final VisibilityService visibilityService;
	private final ShapeService shapeService;
	
	@Inject
	public ComponentImplementationUpdateDiagramFeature(final IFeatureProvider fp, final StyleService styleService, final VisibilityService visibilityService, final ShapeService shapeService) {
		super(fp);
		this.styleService = styleService;
		this.visibilityService = visibilityService;
		this.shapeService = shapeService;
	}

	private ComponentImplementation getComponentImplementation(final IUpdateContext context) {
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		if(bo instanceof ComponentImplementation) {
			return (ComponentImplementation)bo;
		}
		
		return null;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return getComponentImplementation(context) != null;
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createTrueReason("");
	}

	@Override
	public boolean update(final IUpdateContext context) {
		Log.info("called with context: " + context);
		final ComponentImplementation ci = getComponentImplementation(context);
		final Diagram diagram = getDiagram();	

		styleService.refreshStyles();
				
		// Remove shapes that are invalid
		visibilityService.ghostInvalidShapes(diagram);

		// Add/Update the shape for the classifier
		final PictogramElement pe = shapeService.getDescendantShapeByElementQualifiedName(diagram, ci);
		if(pe == null) {
			final AddContext addContext = new AddContext();
			addContext.setNewObject(new AadlElementWrapper(ci));
			addContext.setTargetContainer(diagram);
			addContext.setX(50);
			addContext.setY(20);
			addContext.setWidth(500);
			addContext.setHeight(500);
			final IAddFeature feature = this.getFeatureProvider().getAddFeature(addContext);
			if(feature != null && feature.canAdd(addContext)) {
				feature.execute(addContext);
			}
		} else {
			final UpdateContext updateContext = new UpdateContext(pe);
			final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
			
			// Update the classifier regardless of whether it is "needed" or not.
			if(updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
			}
		}

		// Layout the diagram
		final ICustomContext layoutCtx = LayoutDiagramFeature.createContext(false);
		for(ICustomFeature feature : this.getFeatureProvider().getCustomFeatures(layoutCtx)) {
			if(feature instanceof LayoutDiagramFeature) {
				feature.execute(layoutCtx);
				break;
			}
		}

		return false;
	}

	@Override
	public void undo(final IContext context) {
	}

	@Override
	public boolean canRedo(final IContext context) {
		return false;
	}

	@Override
	public void redo(final IContext context) {	
	}
}
