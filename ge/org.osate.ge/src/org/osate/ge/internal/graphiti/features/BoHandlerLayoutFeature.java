package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.impl.GaServiceImpl;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ShapeService;

// ILayoutFeature implementation for shapes associated with a BO with a business object handler
public class BoHandlerLayoutFeature extends AbstractLayoutFeature implements ICustomUndoRedoFeature {
	private final static LabelConfiguration defaultLabelConfiguration = LabelConfigurationBuilder.create().build();
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final ShapeService shapeService;
	
	@Inject
	public BoHandlerLayoutFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, 
			final ExtensionService extService, final ShapeService shapeService) {
		super(fp);
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.shapeService = Objects.requireNonNull(shapeService, "shapeService must not be null");
	}

	@Override
	public boolean canLayout(final ILayoutContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return context.getPictogramElement() instanceof ContainerShape && 
				!(context.getPictogramElement() instanceof Diagram) && 
				extService.getApplicableBusinessObjectHandler(bo) != null;
	}

	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		if(shape.getGraphicsAlgorithm() != null) {
			final Shape nameShape = shapeService.getChildShapeByName(shape, BoHandlerFeatureHelper.nameShapeName);
			if(nameShape != null && nameShape.getGraphicsAlgorithm() != null) {
				final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
				final Object handler = extService.getApplicableBusinessObjectHandler(bo);
				
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
					eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(context.getPictogramElement()));	
					final AgeLabelConfiguration labelConfiguration = (AgeLabelConfiguration)ContextInjectionFactory.invoke(handler, GetNameLabelConfiguration.class, eclipseCtx, defaultLabelConfiguration);
					
					final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
					if(ga.getGraphicsAlgorithmChildren().size() == 0) {
						// TODO
						System.err.println("NO CHILDREN");
						return false;
					}
					
					final GraphicsAlgorithm innerGa = ga.getGraphicsAlgorithmChildren().get(0);// TODO
					final GraphicsAlgorithm nameGa = nameShape.getGraphicsAlgorithm();
					int innerGaX = 0;
					int innerGaY = 0;
					
					// Set X value based on the label configuration
					switch(labelConfiguration.horizontalPosition) {
					case BEFORE_GRAPHIC:
						// TODO: Need a container for the overall shape?
						nameGa.setX(0);
						innerGaX = nameGa.getWidth() + 1;
						break;	
						
					case GRAPHIC_BEGINNING:
						nameGa.setX(0);
						break;
						
					case DEFAULT:
					case GRAPHIC_CENTER:
						nameGa.setX((ga.getWidth() - nameGa.getWidth()) / 2);
						break;
						
					case GRAPHIC_END:
						nameGa.setX(ga.getWidth() - nameGa.getWidth());
						break;
						
					case AFTER_GRAPHIC:
						nameGa.setX(innerGa.getWidth());
						break;
						
					default:
						nameGa.setX(0);
						break;					
					}					
					
					// Set Y value based on the label configuration
					switch(labelConfiguration.verticalPosition) {
					case BEFORE_GRAPHIC:
						// TODO: Need a container for the overall shape?
						nameGa.setY(0);
						innerGaY = nameGa.getHeight();
						break;	
						
					case DEFAULT:					
					case GRAPHIC_BEGINNING:
						nameGa.setY(0);
						break;
						
					case GRAPHIC_CENTER:
						nameGa.setY((ga.getHeight() - nameGa.getHeight()) / 2);
						break;
						
					case GRAPHIC_END:
						nameGa.setY(ga.getHeight() - nameGa.getHeight());
						break;
						
					case AFTER_GRAPHIC:
						// TODO
						break;
						
					default:
						nameGa.setY(0);
						break;					
					}
					
					innerGa.setX(innerGaX);
					innerGa.setY(innerGaY);
					
					// TODO: Calculate another way? More efficient
					ga.setHeight(Math.max(innerGa.getY() + innerGa.getHeight(), nameGa.getY() + nameGa.getHeight()));
					ga.setWidth(Math.max(innerGa.getX() + innerGa.getWidth(), nameGa.getX() + nameGa.getWidth()));
					
				} finally {
					eclipseCtx.dispose();
				}		
	
			}
		}
				
		return false;
	}
	
	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
