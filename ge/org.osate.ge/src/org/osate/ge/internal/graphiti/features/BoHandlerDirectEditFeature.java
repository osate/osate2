package org.osate.ge.internal.graphiti.features;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.osate.aadl2.Aadl2Package;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.AnnotationUtil;

import com.google.inject.Injector;

// Direct Editing Feature implementation that delegates behavior to a business object handler
public class BoHandlerDirectEditFeature extends AbstractDirectEditingFeature implements ICustomUndoRedoFeature {
	private final GraphitiService graphitiService;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	
	@Inject
	public BoHandlerDirectEditFeature(final IFeatureProvider fp, 
			final GraphitiService graphitiService,
			final ExtensionService extService,
			final AadlModificationService aadlModService, 
			final DiagramModificationService diagramModService) {
		super(fp);
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramModService = Objects.requireNonNull(diagramModService, "diaramModService must not be null");
	}

	@Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		if(de == null) {
			return false;
		}
		
		final Object bo = de.getBusinessObject();
		if(!(bo instanceof EObject)) {
			return false;
		}
		
		if(!ShapeNames.primaryLabelShapeName.equals(PropertyUtil.getName(context.getPictogramElement()))) {
			return false;
		}
		
		final IEclipseContext childCtx = extService.createChildContext();
		final Object handler = de.getBusinessObjectHandler();
		boolean canRename = true;
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.BUSINESS_OBJECT_CONTEXT, de);
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
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());		
    	final Object bo = de.getBusinessObject();
		final Object handler = de.getBusinessObjectHandler();;
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.NAME, value);
			childCtx.set(InternalNames.PROJECT, graphitiService.getProject());
			return (String)ContextInjectionFactory.invoke(handler, ValidateName.class, childCtx, null);
		} finally {
			childCtx.dispose();
		}
    }    
	
	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());		
    	return de.getName();
	}
	
	@SuppressWarnings("restriction")
	public void setValue(final String value, final IDirectEditingContext context) {
		// TODO: Finish reworking. Use LTK if possible but support other mechanism as backup? 
		// Backup still needs to handle renaming element in other diagrams?		
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());		
    	final EObject bo = (EObject)de.getBusinessObject();
    	
    	// TODO
    	if(bo.eResource() instanceof XtextResource) {
    		// TODO: Check element type..
    		System.err.println("A1");
    		final XtextResource res = (XtextResource)bo.eResource();
    		IRenameRefactoringProvider renameRefactoringProvider = res.getResourceServiceProvider().get(IRenameRefactoringProvider.class);
    		
    		// TODO: Need to save resources before trying to rename otherwise the refactoring won't be able to get the correct element..
    		// TODO: Problem doesn't seem to be occuring now? SOMETIMES is does.. Need to investigate
    		// Could also be handled by using the other IRenameElementContext.Impl constructor?
    		
    		final ProcessorBasedRefactoring renameRefactoring = renameRefactoringProvider.getRenameRefactoring(new IRenameElementContext.Impl(EcoreUtil.getURI(bo), Aadl2Package.eINSTANCE.getNamedElement()));
    		((AbstractRenameProcessor) renameRefactoring.getProcessor()).setNewName("abc");
		    try {
	    		RefactoringStatus initialStatus = renameRefactoring.checkInitialConditions(new NullProgressMonitor());
	    		if(initialStatus.isOK()) {
	    			RefactoringStatus finalStatus = renameRefactoring.checkFinalConditions(new NullProgressMonitor());
	    			if(finalStatus.isOK()) {
		    		    final Change change = renameRefactoring.createChange(new NullProgressMonitor());
						new WorkspaceModifyOperation() {
							@Override
							protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
								change.perform(monitor);
							}
						}.run(null);
	    			}
	    		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("A6");
				e.printStackTrace();
			} 
		    
    		System.err.println("A8");
    	}
    	/*
		final Object handler = de.getBusinessObjectHandler();	
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
		*/
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
