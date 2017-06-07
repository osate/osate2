package org.osate.ge.internal.graphiti.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.util.AnnotationUtil;

// ICustomFeature implementation that delegates behavior to a business object handler's double click functionality
public class BoHandlerDoubleClickFeature extends AbstractCustomFeature {
	private final ExtensionService extService;
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	
	public BoHandlerDoubleClickFeature(final ExtensionService extService, 
			final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final IFeatureProvider fp) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}

	public boolean canExecute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final DiagramElement element = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getClosestDiagramElement(pe);
		if(element == null) {
			return false;
		}
		
		return AnnotationUtil.hasMethodWithAnnotation(HandleDoubleClick.class, element.getBusinessObjectHandler());
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final DiagramElement element = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getClosestDiagramElement(pe);
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.BUSINESS_OBJECT, element.getBusinessObject());
			eclipseCtx.set(Names.BUSINESS_OBJECT_CONTEXT, element);
			
			// Call the double-click handler method
			ContextInjectionFactory.invoke(element.getBusinessObjectHandler(), HandleDoubleClick.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}

}
