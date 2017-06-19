package org.osate.ge.internal.ltk;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider.NoSuchStrategyException;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.services.ReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Inject;

public class AgeRenameParticipant extends RenameParticipant {
	public AgeRenameParticipant() {
		System.err.println("CREATED");
	}

	// TODO: Don't store variables like this? Or is it okay.. Is a new object used each time?
	private IRenameElementContext ctx;
	private Map<URI, URI> oldToNewUriMap;
	private EObject targetObject; // TODO: Rename
	private XtextResourceSet rs; // TODO: SHould have a refactoring resource set provider?
	private InternalReferenceBuilderService refBuilder;
	
	// TODO: Cleanup.. Improve reliability of object fetching code
	
	@Override
	protected boolean initialize(final Object element) {
		if(!(element instanceof IRenameElementContext)) {
			return false;
		}
		
		ctx = (IRenameElementContext)element;

		// TODO: Needs lots of error checking
		final URI targetElementUri = ctx.getTargetElementURI();
		
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(targetElementUri.toPlatformString(true)));
		System.err.println(resource);
		
		XtextResource xtextResource = AgeXtextUtil.getOpenXtextResource(resource);
		if(xtextResource == null) {
			System.err.println("NOT OPEN");
			// TODO: Error checking
			rs = OsateResourceUtil.createXtextResourceSet();
			targetObject = rs.getEObject(targetElementUri, true);
			xtextResource = (XtextResource)targetObject.eResource(); // TODO: Check type before casting
		}  else {
			System.err.println("OLD RESOURCE " + xtextResource);
			rs = (XtextResourceSet)xtextResource.getResourceSet();
			targetObject = rs.getEObject(targetElementUri, false); // TODO: Consider this.. false? Could a method be called on the resource itself? If true then could move some code out of branches
		}
		
		System.err.println("XTEXT RESOURCE, Target Object:  " + xtextResource + " : " + targetObject);
		
		// TODO: Get IResource of the element to be moved
		// TODO: Need to get original element reference?
		
		// TODO: Need to use the refactoring resource set provider? Unfortunately, cna't get that without a resource which is needed to get the resource set...
		final RefactoringResourceSetProvider refactoringResourceSetProvider = xtextResource.getResourceServiceProvider().get(RefactoringResourceSetProvider.class);
		
		final IPath projectPath = new Path(targetElementUri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		
		System.err.println("PROJECT: " + projectResource);
		// TODO: Check before casting
		rs = (XtextResourceSet)refactoringResourceSetProvider.get((IProject)projectResource);  // TODO: have a different name?
		System.err.println("NEW RESOURCE SET: " + rs);
		//refactoringResourceSetProvider.get(project)

		final RenameElementProcessor renameElementProcessor = (RenameElementProcessor)getProcessor();
		
		// TODO: Just get resource service provider once?
		IRenameRefactoringProvider renameRefactoringProvider = xtextResource.getResourceServiceProvider().get(IRenameRefactoringProvider.class);
		final IRenamedElementTracker elementTracker = xtextResource.getResourceServiceProvider().get(IRenamedElementTracker.class);
		final IRenameStrategy.Provider renameStrategyProvider = xtextResource.getResourceServiceProvider().get(IRenameStrategy.Provider.class);
		System.err.println("RENAME STRATEGY PROVIDER: " + renameStrategyProvider);
		IRenameStrategy renameStrategy = null;
		try {
			renameStrategy = renameStrategyProvider.get(targetObject, ctx);
		} catch (NoSuchStrategyException e) {
			e.printStackTrace(); // TODO
		}
		
		System.err.println("RENAME STRATEGY: " + renameStrategy);		
		System.err.println("ELEMENT TRACKER: " + elementTracker);
		
		oldToNewUriMap = elementTracker.renameAndTrack(Collections.singleton(ctx.getTargetElementURI()), renameElementProcessor.getNewName(), rs, renameStrategy, new NullProgressMonitor());
		
		//System.err.println(res.getResourceServiceProvider().get(Injector.class));

		final Bundle bundle = FrameworkUtil.getBundle(getClass());	
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		refBuilder = context.get(InternalReferenceBuilderService.class); // TODO: Check for null
		
		// TODO: It would be better to not throw exceptions to avoid interfering with normal renames? Consider if that is a reasonable approach or not.
		
		System.err.println("OLD CANONICAL REF: " + refBuilder.getCanonicalReference(targetObject));
		System.err.println("OLD RELATIVE REF: " + refBuilder.getRelativeReference(targetObject));
		
		return true;
	}

	@Override
	public String getName() {
		return "AgeRenameParticipant"; // TODO
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		//System.err.println("checkConditions()");
		return null;
	}

	@Override
	public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
		//System.err.println("createChange()");
		return new Change() {
			@Override
			public String getName() {
				return "TODO: AGE CHANGE"; // TODO
			}

			@Override
			public void initializeValidationData(final IProgressMonitor pm) {
			}

			@Override
			public RefactoringStatus isValid(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
				return new RefactoringStatus(); // TODO
			}

			@Override
			public Change perform(final IProgressMonitor pm) throws CoreException {
				System.err.println("PERFORM");
				final URI newUri = oldToNewUriMap.get(ctx.getTargetElementURI()); // TODO: This URI should probably be stored instead of the map...
				
				System.err.println("OLD URI: " + ctx.getTargetElementURI());
				System.err.println("NEW URI: " + newUri);
				
				// If resource editor is open, need to save it before trying to open.. Or get the object by using the xtext document form the editor?
				
				final EObject newObject;
				final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(newUri.toPlatformString(true)));
				
				final IXtextDocument doc = AgeXtextUtil.getDocumentByIResource(resource);
				if(doc == null) {
					System.err.println("NOT OPEN");
					// TODO: Error checking
					XtextResourceSet rs = OsateResourceUtil.createXtextResourceSet();
					newObject = rs.getEObject(newUri, true);

				}  else {
					System.err.println("DOC: " + doc);
					// TODO: Also forces synchronization. Perhaps could use AgeXtextUtil after the call to readonly? Less code paths?
					newObject = (EObject)doc.readOnly(new IUnitOfWork<Object, XtextResource>() { // TODO: Check casting
						@Override
						public Object exec(final XtextResource res) throws Exception {
							XtextResourceSet rs = (XtextResourceSet)res.getResourceSet();
							return rs.getEObject(newUri, true); // TODO: Should be false?					
						}
					});
				}

				// TODO: rs variable hides field.
				System.err.println("NEW OBJECT : " + newObject);
				System.err.println("NEW CANONICAL REF: " + refBuilder.getCanonicalReference(newObject));
				System.err.println("NEW RELATIVE REF: " + refBuilder.getRelativeReference(newObject));
								
				return null;
			}

			@Override
			public Object getModifiedElement() {
				// TODO
				return null;
			}
			
		};
	}

}
