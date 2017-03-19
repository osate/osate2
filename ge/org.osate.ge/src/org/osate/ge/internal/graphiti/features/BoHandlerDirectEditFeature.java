package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.ui.util.SelectionHelper;
import org.osate.ge.internal.util.AnnotationUtil;

// Direct Editing Feature implementation that delegates behavior to a business object handler
public class BoHandlerDirectEditFeature extends AbstractDirectEditingFeature implements ICustomUndoRedoFeature {
	private final ExtensionService extService;
	private final PropertyService propertyService;
	private final ConnectionService connectionService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public BoHandlerDirectEditFeature(final IFeatureProvider fp, final ExtensionService extService,
			final PropertyService propertyService, final ConnectionService connectionService, final AadlModificationService aadlModService, 
			final DiagramModificationService diagramModService,	final BusinessObjectResolutionService bor) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramModService = Objects.requireNonNull(diagramModService, "diaramModService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
	}

	@Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(!(bo instanceof EObject)) {
			return false;
		}
		
		if(!BoHandlerFeatureHelper.nameShapeName.equals(propertyService.getName(context.getPictogramElement()))) {
			return false;
		}
		
		// Find business object handler that handles the business object
		final Object handler = extService.getApplicableBusinessObjectHandler(bo);
		if(handler == null) {
			return false;
		}
				
		final IEclipseContext childCtx = extService.createChildContext();
		boolean canRename = true;
		try {
			PictogramElement pe = context.getPictogramElement();
			
			// Use the connection instead of the connection decorator when calling the business object handler
			if(pe instanceof ConnectionDecorator) {
				pe = ((ConnectionDecorator) pe).getConnection();
			}
			
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			//TODO: Migrate!childCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(pe, propertyService, connectionService)));
			canRename = (boolean)ContextInjectionFactory.invoke(handler, CanRename.class, childCtx, true);
			if(!canRename) {
				return false;
			}
		} finally {
			childCtx.dispose();
		}
		
		// Check if there is a method to set the name
		return AnnotationUtil.hasMethodWithAnnotation(SetName.class, handler);
	}
	
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
	
	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}

    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
		// Set the business object's name
    	final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		final Object handler = extService.getApplicableBusinessObjectHandler(bo);
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.NAME, value);
			childCtx.set(InternalNames.PROJECT, SelectionHelper.getProject(getDiagram().eResource()));
			return (String)ContextInjectionFactory.invoke(handler, ValidateName.class, childCtx, null);
		} finally {
			childCtx.dispose();
		}
    }    
	
	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		final Object handler = extService.getApplicableBusinessObjectHandler(bo);
		final IEclipseContext childCtx = extService.createChildContext();
		
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			//TODO: Migrate!childCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(AgeFeatureUtil.getLogicalPictogramElement(context.getPictogramElement(), propertyService, connectionService)));
			
			// Get the name of the business object from the handler
			final String name = (String)ContextInjectionFactory.invoke(handler, GetName.class, childCtx, null);
			if(name != null) {
				return name;
			}
		} finally {
			childCtx.dispose();
		}
		
		return null;
	}
	
	public void setValue(final String value, final IDirectEditingContext context) {
		final EObject bo = (EObject)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());		
		aadlModService.modify(bo, new AbstractModifier<EObject, Object>() {
			private DiagramModificationService.Modification diagramMod;   
			
     		@Override
    		public Object modify(final Resource resource, final EObject bo) {
     			// Resolving allows the name change to propagate when editing without an Xtext document
     			EcoreUtil.resolveAll(resource.getResourceSet());
     			
     			// TODO: Implement/rework propagating changes to other diagrams and packages.
     			
     			// Start the diagram modification
     			diagramMod = diagramModService.startModification();

     			// Mark linkages to the element as dirty 			
     			diagramMod.markOpenLinkagesAsDirty(bo);
     			
     			// Set the business object's name
     			final Object handler = extService.getApplicableBusinessObjectHandler(bo);
     			final IEclipseContext childCtx = extService.createChildContext();
     			try {
     				childCtx.set(Names.BUSINESS_OBJECT, bo);
     				childCtx.set(Names.NAME, value);
     				ContextInjectionFactory.invoke(handler, SetName.class, childCtx);
     			} finally {
     				childCtx.dispose();
     			}

    			return null;
    		}	
     		
     		@Override
			public void beforeCommit(final Resource resource, final EObject bo, final Object modificationResult) {
    			diagramMod.commit();
    		}
     	});
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
