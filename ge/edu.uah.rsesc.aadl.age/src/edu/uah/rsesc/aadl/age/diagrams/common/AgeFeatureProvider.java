package edu.uah.rsesc.aadl.age.diagrams.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.UpdateFeatureForPattern;
import org.osate.aadl2.Element;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.features.DrillDownFeature;
import edu.uah.rsesc.aadl.age.diagrams.common.features.LayoutDiagramFeature;
import edu.uah.rsesc.aadl.age.services.AadlFeatureService;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionCreationService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmManipulationService;
import edu.uah.rsesc.aadl.age.services.HighlightingService;
import edu.uah.rsesc.aadl.age.services.LayoutService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.PrototypeService;
import edu.uah.rsesc.aadl.age.services.ShapeCreationService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.SubcomponentService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultAadlFeatureService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultAnchorService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultBusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultConnectionCreationService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultConnectionService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultGraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultGraphicsAlgorithmManipulationService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultHighlightingService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultLayoutService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultPropertyService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultPrototypeService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultShapeCreationService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultShapeService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultStyleService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultSubcomponentService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultVisibilityService;

public class AgeFeatureProvider extends DefaultFeatureProviderWithPatterns {
	private final IEclipseContext context;
	
	public AgeFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
		setIndependenceSolver(new IndependenceProvider(this));
		
		// Create the eclipse context
		this.context = createEclipseContext();
	}
	
	private IEclipseContext createEclipseContext() {
		// Create objects for the context
		final BusinessObjectResolutionService bor = new DefaultBusinessObjectResolutionService(this);
		final DefaultGraphicsAlgorithmManipulationService graphicsAlgorithmUtil = new DefaultGraphicsAlgorithmManipulationService();
		final DefaultPropertyService propertyUtil = new DefaultPropertyService();
		final DefaultStyleService styleUtil = new DefaultStyleService(this);
		final DefaultAnchorService anchorUtil = new DefaultAnchorService(propertyUtil);
		final DefaultVisibilityService visibilityHelper = new DefaultVisibilityService(propertyUtil, bor, this);
		final DefaultLayoutService layoutService = new DefaultLayoutService(visibilityHelper, bor, this);
		final DefaultShapeService shapeHelper = new DefaultShapeService(propertyUtil, visibilityHelper, bor);
		final DefaultPrototypeService prototypeService = new DefaultPrototypeService(bor);
		final DefaultAadlFeatureService featureService = new DefaultAadlFeatureService(prototypeService, bor);
		final DefaultSubcomponentService subcomponentService = new DefaultSubcomponentService(prototypeService);
		final DefaultShapeCreationService shapeCreationService = new DefaultShapeCreationService(shapeHelper, this);
		final DefaultConnectionService connectionService = new DefaultConnectionService(anchorUtil, shapeHelper, bor, this);
		final DefaultConnectionCreationService connectionCreationService = new DefaultConnectionCreationService(connectionService, this);
		final DefaultGraphicsAlgorithmCreationService graphicsAlgorithmCreator = new DefaultGraphicsAlgorithmCreationService(styleUtil, featureService, subcomponentService, graphicsAlgorithmUtil);		
		final DefaultHighlightingService highlightingHelper = new DefaultHighlightingService(propertyUtil, styleUtil, this);		
		
		// Create the eclipse context
		final Bundle bundle = FrameworkUtil.getBundle(getClass());	
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		
		// Populate the context. 
		context.set(GraphicsAlgorithmManipulationService.class, graphicsAlgorithmUtil);
		context.set(PropertyService.class, propertyUtil);
		context.set(LayoutService.class, layoutService);
		context.set(StyleService.class, styleUtil);
		context.set(AnchorService.class, anchorUtil);
		context.set(VisibilityService.class, visibilityHelper);
		context.set(ShapeService.class, shapeHelper);
		context.set(ShapeCreationService.class, shapeCreationService);
		context.set(AadlFeatureService.class, featureService);
		context.set(SubcomponentService.class, subcomponentService);
		context.set(PrototypeService.class, prototypeService);
		context.set(ConnectionService.class, connectionService);
		context.set(ConnectionCreationService.class, connectionCreationService);
		context.set(GraphicsAlgorithmCreationService.class, graphicsAlgorithmCreator);
		context.set(HighlightingService.class, highlightingHelper);
		context.set(IFeatureProvider.class, this);
		context.set(BusinessObjectResolutionService.class, bor);
		
		return context;
	}
	
	IEclipseContext getContext() {
		return context;
	}
	
	/**
	 * Instantiates an object and injects the current context into it
	 * @param clazz
	 * @return
	 */
	protected final <T> T make(final Class<T> clazz) {
		return ContextInjectionFactory.make(clazz, context);
	}
	
	// TODO: Remove when deleting is allowed. Just returns false for now. As of 07/03/13, connection patterns do not handle remove and delete features.
	@Override 
	public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
		return null;
	}
	
	@Override 
	public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
		return null;
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(final ICustomContext context) {
		final ArrayList<ICustomFeature> features = new ArrayList<ICustomFeature>();
		addCustomFeatures(features);
		return features.toArray(new ICustomFeature[] {});
	}
	
	
	/**
	 * Method used to additively build a list of custom features. Subclasses can override to add additional custom features while including those supported by parent classes.
	 * @param features
	 */
	protected void addCustomFeatures(final List<ICustomFeature> features) {
		features.add(make(DrillDownFeature.class));
		features.add(make(LayoutDiagramFeature.class));
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {	
		PictogramElement pictogramElement = context.getPictogramElement();
		// As of 2013-07-08 Graphiti doesn't support connection patterns handling updates so check if the pattern implements IUpdate and return a feature based on the pattern
		if(pictogramElement instanceof Connection) {
			for(final IConnectionPattern conPattern : getConnectionPatterns()) {
				if(conPattern instanceof IUpdate) {
					if(((IUpdate)conPattern).canUpdate(context)) {
						final IUpdateFeature f = new UpdateFeatureForPattern(this, (IUpdate)conPattern);
						if (checkFeatureAndContext(f, context)) {
							return f;
						}
					}
				}
			}
		}
 
		return super.getUpdateFeature(context);
	}

	// Helper methods to hide the fact that we are wrapping our AADL Elements to hide the fact they are EMF objects from Graphiti. See AadlElementWrapper
	@Override
	public PictogramElement getPictogramElementForBusinessObject(Object businessObject) {
		if(businessObject instanceof Element) {
			businessObject =  new AadlElementWrapper((Element)businessObject);
		}
		
		return super.getPictogramElementForBusinessObject(businessObject);
	}
	
	public PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject) {
		if(businessObject instanceof Element) {
			businessObject =  new AadlElementWrapper((Element)businessObject);
		}
		
		return super.getAllPictogramElementsForBusinessObject(businessObject);
	}
}
