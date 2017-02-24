/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
package org.osate.ge.internal.graphiti.features;

import java.lang.annotation.Annotation;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.di.HasDoneChanges;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.Names;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.AnnotationUtil;

/**
 * Custom feature for wrapping AADL Graphical Editor commands registered with the command service as a graphiti custom feature.
 *
 */
public class CommandCustomFeature extends AbstractCustomFeature {
	private final Object cmd;
	private final ExtensionService extService;
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService aadlModificationService;
	private final PropertyService propertyService;
	private final ConnectionService connectionService;
	private final boolean modifiesBusinessObjects;
	private boolean hasMadeChanges = false;
	
	public CommandCustomFeature(final Object cmd, 
			final ExtensionService extService,
			final BusinessObjectResolutionService bor, 
			final AadlModificationService aadlModificationService,
			final PropertyService propertyService,
			final ConnectionService connectionService,
			final IFeatureProvider fp) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.cmd = Objects.requireNonNull(cmd, "cmd must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.aadlModificationService = Objects.requireNonNull(aadlModificationService, "aadlModificationService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
		this.modifiesBusinessObjects = cmd.getClass().getAnnotation(ModifiesBusinessObjects.class) != null;
	}

	@Override
    public String getName() {
		final IEclipseContext eclipseContext = extService.createChildContext();
		try {
			return (String)ContextInjectionFactory.invoke(cmd, GetLabel.class, eclipseContext);
		} finally {
			eclipseContext.dispose();
		}
	}
		
	@Override
	public boolean isAvailable(final IContext context) {
		// Return true if the command doesn't have a method with the annotation
		if(!hasMethodWithAnnotation(IsAvailable.class)) {
			return true;
		}

		final ICustomContext customCtx = (ICustomContext)context;
		final IEclipseContext eclipseContext = extService.createChildContext();
		try {
			final Object[] bos = getBusinessObjects(customCtx.getPictogramElements());
			if(bos == null) {
				return false;
			}
			
			final DiagramElementProxy[] diagramElements = getDiagramElements(customCtx.getPictogramElements());
			if(diagramElements == null) {
				return false;
			}
			
			populateEclipseContext(eclipseContext, diagramElements, bos);
			return (Boolean)ContextInjectionFactory.invoke(cmd, IsAvailable.class, eclipseContext, Boolean.FALSE);
		} finally {
			eclipseContext.dispose();
		}
	}
	
	@Override
    public boolean canExecute(final ICustomContext context) {
		// Return true if the command doesn't have a method with the annotation
		if(!hasMethodWithAnnotation(CanActivate.class)) {
			return true;
		}
		
		if(modifiesBusinessObjects) {
			final Object[] businessObjects = getBusinessObjects(context.getPictogramElements());
			if(businessObjects.length != 1 || !(businessObjects[0] instanceof EObject)) {
				return false;
			}			
		}

		final IEclipseContext eclipseContext = extService.createChildContext();
		try {
			populateEclipseContext(eclipseContext, getDiagramElements(context.getPictogramElements()), getBusinessObjects(context.getPictogramElements()));
			return (Boolean)ContextInjectionFactory.invoke(cmd, CanActivate.class, eclipseContext, Boolean.FALSE);
		} finally {
			eclipseContext.dispose();
		}
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final Object[] businessObjects = getBusinessObjects(context.getPictogramElements());
		if(modifiesBusinessObjects) {
			final EObject bo = (EObject)businessObjects[0];
			aadlModificationService.modify(bo, new AbstractModifier<EObject, Object>() {
				@Override
				public Object modify(final Resource resource, final EObject bo) {
					hasMadeChanges = activate(getDiagramElements(context.getPictogramElements()), new Object[] { bo });
					return null;
				}				
			});
		} else {		
			hasMadeChanges = activate(getDiagramElements(context.getPictogramElements()), getBusinessObjects(context.getPictogramElements()));
		}
	}
	
	private boolean activate(final DiagramElementProxy[] diagramElements, final Object[] businessObjects) {
		final IEclipseContext eclipseContext = extService.createChildContext();
		try {
			populateEclipseContext(eclipseContext, diagramElements, businessObjects);
			return (Boolean)ContextInjectionFactory.invoke(cmd, Activate.class, eclipseContext, modifiesBusinessObjects);
		} finally {
			eclipseContext.dispose();
		}
	}
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public boolean hasDoneChanges() {
		final IEclipseContext eclipseContext = extService.createChildContext();
		try {
			return (Boolean)ContextInjectionFactory.invoke(cmd, HasDoneChanges.class, eclipseContext, hasMadeChanges);
		} finally {
			eclipseContext.dispose();
		}
	}
	
	private void populateEclipseContext(final IEclipseContext context, final DiagramElementProxy[] diagramElements, final Object[] businessObjects) {
		// Diagram Elements
		if(diagramElements.length == 1) {
			context.set(InternalNames.DIAGRAM_ELEMENT_PROXY, diagramElements[0]);	
		}
		context.set(InternalNames.DIAGRAM_ELEMENT_PROXIES, diagramElements);
		
		// Business Objects
		if(businessObjects.length == 1) {
			context.set(Names.BUSINESS_OBJECT, businessObjects[0]);	
		}
		context.set(Names.BUSINESS_OBJECTS, businessObjects);
	}
	
	private DiagramElementProxy[] getDiagramElements(final PictogramElement[] pes) {
		final DiagramElementProxy[] diagramElements = new DiagramElementProxy[pes.length];
		for(int i = 0; i < pes.length; i++) {
			final PictogramElement pe = AgeFeatureUtil.getLogicalPictogramElement(pes[i], propertyService, connectionService);
			
			// Return null if we are unable to get the logical pictogram element for any passed in pictogram element
			if(pe == null) {
				return null;
			}
			
			diagramElements[i] = new PictogramElementProxy(pe);
		}
		
		return diagramElements;
	}
	
	private Object[] getBusinessObjects(final PictogramElement[] pes) {
		if(pes == null) {
			 return null;
		}
		
		final Object[] bos = new Object[pes.length];
		for(int i = 0; i < pes.length; i++) {
			bos[i] = bor.getBusinessObjectForPictogramElement(pes[i]);
			
			if(bos[i] == null) {
				return null;
			}
		}
		
		return bos;		
	}
	
	private boolean hasMethodWithAnnotation(final Class<? extends Annotation> annotationClass) {
		return AnnotationUtil.hasMethodWithAnnotation(annotationClass, cmd);
	}
}
