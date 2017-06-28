package org.osate.ge.internal.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Realization;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

@SuppressWarnings("restriction")
public class AgeRenameParticipant extends RenameParticipant {
	// TODO: Don't store variables like this? Or is it okay.. Is a new object used each time?
	private IRenameElementContext ctx;
	private EObject targetObject; // TODO: Rename
	private ReferenceService refBuilder;
	private DiagramService diagramService;
	private final Map<CanonicalBusinessObjectReference, URI> originalCanonicalReferenceToNewUriMap = new HashMap<>(); // TODO: Move
	private ResourceSet refactoringResourcSet;
	private IProject project;
	private DiagramService.ReferenceCollection references;
	
	@Override
	protected boolean initialize(final Object element) {
		originalCanonicalReferenceToNewUriMap.clear();
		
		if(!(element instanceof IRenameElementContext)) {
			return false;
		}
		
		ctx = (IRenameElementContext)element;

		// TODO: Needs lots of error checking
		final URI targetElementUri = ctx.getTargetElementURI();
		
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(targetElementUri.toPlatformString(true)));
		
		XtextResource xtextResource = AgeXtextUtil.getOpenXtextResource(resource);
		if(xtextResource == null) {
			// TODO: Error checking
			final XtextResourceSet tmpRs = OsateResourceUtil.createXtextResourceSet();
			targetObject = tmpRs.getEObject(targetElementUri, true);
			xtextResource = (XtextResource)targetObject.eResource(); // TODO: Check type before casting
		}  else {
			final XtextResourceSet tmpRs = (XtextResourceSet)xtextResource.getResourceSet();
			targetObject = tmpRs.getEObject(targetElementUri, false); // TODO: Consider this.. false? Could a method be called on the resource itself? If true then could move some code out of branches
		}
		// TODO: Get IResource of the element to be moved
		// TODO: Need to get original element reference?
		
		// TODO: Need to use the refactoring resource set provider? Unfortunately, cna't get that without a resource which is needed to get the resource set...
		final RefactoringResourceSetProvider refactoringResourceSetProvider = xtextResource.getResourceServiceProvider().get(RefactoringResourceSetProvider.class);
		
		final IPath projectPath = new Path(targetElementUri.toPlatformString(true)).uptoSegment(1);
		project = (IProject)ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath); // TODO: Check type. TODO: Check null
		
		refactoringResourcSet = (XtextResourceSet)refactoringResourceSetProvider.get(project);  // TODO: have a different name?

		final Bundle bundle = FrameworkUtil.getBundle(getClass());	
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		refBuilder = context.get(ReferenceService.class); // TODO: Check for null 
		diagramService = context.get(DiagramService.class); // TODO: Check for null
		
		// TODO: Need to use a separate resource set for renames? 
		// TODO: Should it use the one already found or should it always use a fresh one. What resource set does the index reference
		// TODO: Will need to ensure that incorrect objects aren't modified...
		// TODO: Will need to modify appropriate resources... Handle some files being open and some not... References between files
		
		// TODO: Move to separate function
		// Build a mapping between an EObject URI and the URIs of EObjects that it affects.
		final Map<URI, Set<URI>> externalReferencesMap = new HashMap<>(); // TODO: Rename
		final Set<IProject> projects = Collections.singleton(project); // TODO: Get all relevant projects
		for(final IResourceDescription resourceDescription : ScopedEMFIndexRetrieval.calculateResourceDescriptions(projects)) {
			for(final IReferenceDescription refDescription : resourceDescription.getReferenceDescriptions()) {
				final EReference ref = refDescription.getEReference();
				// TODO: Anyway to share this condition with the other function?
				// TODO: Implemented isn't really relevant because any objects that implement a type but are in a nother file would have a renamed object
				// renames aren't captured graphically
				
				if(isHandledRefinedReference(ref)) {
					if(refDescription.getSourceEObjectUri() != null && refDescription.getTargetEObjectUri() != null) {
						Set<URI> affectedUris = externalReferencesMap.get(refDescription.getTargetEObjectUri());
						if(affectedUris == null) {
							affectedUris = new HashSet<>();
							externalReferencesMap.put(refDescription.getTargetEObjectUri(), affectedUris);
						}
						
						affectedUris.add(refDescription.getSourceEObjectUri());
					}
				} 
			}
		}
		
		// TODO: Rename to affected objects? Cleanup function names and terminology?
		// Find all dependent objects
		final Set<EObject> dirtyObjects = getDependentObjects(targetObject, targetObject.eResource().getResourceSet(), externalReferencesMap);
		dirtyObjects.add(targetObject);
				
		for(final EObject dirtyObject : dirtyObjects) {
			final URI uri = getDefaultUri(dirtyObject);
			if(uri != null) {
				final CanonicalBusinessObjectReference canonicalReference = refBuilder.getCanonicalReference(dirtyObject);
				if(canonicalReference != null) {
					originalCanonicalReferenceToNewUriMap.put(canonicalReference, uri);
				}
			}
		}

		// TODO: Should this an other processing take place now or should it wait until performing the actual change. 
		// Initialize is called many times so it would be  best to do it before the change is made but not in the initialization pahse
		final HashSet<IProject> relevantProjects = new HashSet<>();
		relevantProjects.add(project);
		relevantProjects.addAll(Arrays.asList(project.getReferencingProjects()));		
		references = diagramService.getReferences(relevantProjects, originalCanonicalReferenceToNewUriMap.keySet());
		
		return true;
	}
	
	// TODO: Rename
	private static URI getDefaultUri(final EObject obj) {
		// Set the fragment processor of the resources to null so that the URI generated will be based on ordering and not actual names
		IFragmentProvider oldFragmentProvider = null;
		XtextResource res = null;
		try {
			if(obj.eResource() instanceof XtextResource) {
				res = (XtextResource)obj.eResource();
				oldFragmentProvider = res.getFragmentProvider();
				res.setFragmentProvider(null);
			}
			
			// Store the URIs
			return EcoreUtil.getURI(obj);
	
			
		} finally {
			// Restore the old fragment processor
			if(oldFragmentProvider != null) {
				res.setFragmentProvider(oldFragmentProvider);
			}
		}
	}

	private static Set<EObject> getDependentObjects(final EObject obj, final ResourceSet rs, final Map<URI, Set<URI>> externalReferencesMap) {
		final Set<EObject> results = new HashSet<>();
		getRelatedObjects(Collections.singleton(obj), rs, results, externalReferencesMap, obj instanceof Feature);
		return results;
	}
	
	// TODO: Need to handle refactoring of renames though. For implementing types in different packages... Could be used in same package too?	
	private static void getRelatedObjects(Collection<EObject> objectsOfInterest, 
			final ResourceSet rs, 
			final Set<EObject> results, 
			final Map<URI, Set<URI>> externalReferencesMap,
			final boolean recursive) {
		final Collection<EObject> newObjects = new ArrayList<>();
		for(final Collection<Setting> settings : UsageCrossReferencer.findAll(objectsOfInterest, rs).values()) {
			for(final Setting s : settings) {
				final EStructuralFeature sf = s.getEStructuralFeature();
				if(isHandledRefinedReference(sf)) {
					newObjects.add(s.getEObject());
				} else if(sf == Aadl2Package.eINSTANCE.getRealization_Implemented()) {
					// Get the component implementation from the realization
					final Realization realization = (Realization)s.getEObject();
					newObjects.add(realization.getSpecific()); 
				}
			}
		}
		
		for(final EObject objectOfInterest : objectsOfInterest) {
			final URI objectOfInterestUri = EcoreUtil.getURI(objectOfInterest);
			if(objectOfInterestUri != null) {
				// TODO: Rename
				final Set<URI> affectedUris = externalReferencesMap.get(objectOfInterestUri);
				if(affectedUris != null) {
					for(final URI affectedUri : affectedUris) {
						// TODO: Need to review use of resource set and the EMF index
						final EObject affectedObject = rs.getEObject(affectedUri, true);
						if(affectedObject != null) {
							newObjects.add(affectedObject);
						}
					}
				}
			}
		}

		if(results.addAll(newObjects)) {
			if(recursive) {
				getRelatedObjects(newObjects, rs, results, externalReferencesMap, recursive);
			}
		}
	}

	private static boolean isHandledRefinedReference(final EStructuralFeature sf) {
		return sf == Aadl2Package.eINSTANCE.getFeature_Refined() ||
			sf == Aadl2Package.eINSTANCE.getConnection_Refined() || 
			sf == Aadl2Package.eINSTANCE.getSubcomponent_Refined() ||
			sf == Aadl2Package.eINSTANCE.getSubcomponent_Refined() ||
			sf == Aadl2Package.eINSTANCE.getFlowSpecification_Refined();
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
				// TODO
				final Map<CanonicalBusinessObjectReference, Object> originalCanonicalReferenceToNewObjectMap = new HashMap<>();
				for(final Entry<CanonicalBusinessObjectReference, URI> entry : originalCanonicalReferenceToNewUriMap.entrySet()) {
					final EObject newObject = refactoringResourcSet.getEObject(entry.getValue(), true);
					if(newObject != null) {
						originalCanonicalReferenceToNewObjectMap.put(entry.getKey(), newObject);
					}
				}
				
				references.update(originalCanonicalReferenceToNewObjectMap);

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
