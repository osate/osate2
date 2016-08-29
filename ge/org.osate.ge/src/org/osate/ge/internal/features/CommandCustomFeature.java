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
package org.osate.ge.internal.features;

import java.lang.annotation.Annotation;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
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
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Custom feature for wrapping AADL Graphical Editor commands registered with the command service as a graphiti custom feature.
 *
 */
public class CommandCustomFeature extends AbstractCustomFeature {
	private final Object cmd;
	private final ExtensionService extService;
	private final BusinessObjectResolutionService bor;
	
	public CommandCustomFeature(final Object cmd, final ExtensionService extService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.cmd = cmd;
		this.bor = bor;
		this.extService = extService;
	}

	@Override
    public String getName() {
		return (String)invokeAndDisposeContext(cmd, GetLabel.class, createEclipseContext(null));
	}
	
	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		return (Boolean)invokeAndDisposeContext(cmd, IsAvailable.class, createEclipseContext(customCtx), Boolean.TRUE);
	}
	
	@Override
    public boolean canExecute(final ICustomContext context) {
		return (Boolean)invokeAndDisposeContext(cmd, CanActivate.class, createEclipseContext(context), Boolean.TRUE);
	}
	
	@Override
	public void execute(final ICustomContext context) {
		invokeAndDisposeContext(cmd, Activate.class, createEclipseContext(context));
	}
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public boolean hasDoneChanges() {
		return (Boolean)invokeAndDisposeContext(cmd, HasDoneChanges.class, createEclipseContext(null), Boolean.TRUE);
	}
	
	private IEclipseContext createEclipseContext(final ICustomContext ctx) {
		final IEclipseContext context = extService.createChildContext();

		if(ctx != null) {
			context.set(Names.BUSINESS_OBJECTS, getBusinessObjects(ctx.getPictogramElements()));
		}
		
		return context;
	}
	
	private Object[] getBusinessObjects(final PictogramElement[] pes) {
		if(pes == null) {
			 return null;
		}
		
		final Object[] bos = new Object[pes.length];
		for(int i = 0; i < pes.length; i++) {
			bos[i] = bor.getBusinessObjectForPictogramElement(pes[i]);
		}
		
		return bos;		
	}
	
	private static Object invokeAndDisposeContext(final Object object, final Class<? extends Annotation> qualifier, final IEclipseContext context, final Object defaultValue) {
		try {
			return ContextInjectionFactory.invoke(object, qualifier, context, defaultValue);
		} finally {
			context.dispose();
		}
	}
	
	private static Object invokeAndDisposeContext(final Object object, final Class<? extends Annotation> qualifier, final IEclipseContext context) {
		try {
			return ContextInjectionFactory.invoke(object, qualifier, context);
		} finally {
			context.dispose();
		}
	}
}
