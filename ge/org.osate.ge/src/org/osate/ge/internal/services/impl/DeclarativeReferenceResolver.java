/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveCanonicalReference;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.SavedAadlResourceService;
import org.osate.ge.internal.services.CachingService.Cache;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.SavedAadlResourceService.AadlPackageReference;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.services.ReferenceResolutionService;

// Handles resolving references related to the AADL declarative model
public class DeclarativeReferenceResolver {
	// Cache for items that should not change unless models have changed.
	private static class DeclarativeCache implements Cache {
		private static final EClass aadlPackageEClass = Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage();
		private final ProjectProvider projectProvider;
		private final CachingService cachingService;
		private final Map<String, Object> packageNameToPackageMap = new HashMap<>(); // Map for caching. Cleared when cache is invalidated
		private final Set<AadlPackageReference> pkgReferences = new HashSet<>(); // Collection of package references. Not cleared to ensure strong references to the EObjectReference objects exist during the lifetime of the service 
		private Set<IResourceDescription> resourceDescriptions = null; // Resource descriptions for resources which are in the project references path
		private SavedAadlResourceService savedAadlResourceService;
		
		private final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
			@Override
			public void resourceChanged(final IResourceChangeEvent event) {
				final IResourceDelta delta = event.getDelta();
				if(delta != null) {
					try {
						delta.accept(visitor);
					} catch (CoreException e) {
					}
				}
			}
		};
		
		private IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
	        public boolean visit(final IResourceDelta delta) {
	           // If the resource's contents has changed changed
	           if(delta.getKind() != IResourceDelta.CHANGED || (delta.getFlags() & IResourceDelta.CONTENT) == 0)
	              return true;

	           // Check AADL files
	           final IResource resource = delta.getResource();
	           if (resource.getType() == IResource.FILE && "aadl".equalsIgnoreCase(resource.getFileExtension())) {
	        	   // Invalidate all caches
        		   cachingService.invalidate();
	           }
	           return true;
	        }
	    };
	    	    
	    public DeclarativeCache(final ProjectProvider projectProvider, final CachingService cachingService, final SavedAadlResourceService savedAadlResourceService) {
			this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
	    	this.cachingService = Objects.requireNonNull(cachingService, "cachingService must not be null");
			this.savedAadlResourceService = Objects.requireNonNull(savedAadlResourceService, "savedAadlResourceService must not be null");
			
			// Register a resource change listener
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(resourceChangeListener);
	    }
		
	    public void dispose() {
	    	// Remove the resource change listener
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(resourceChangeListener);
			
	    	invalidate();
	    	
	    	// Remove object reference
	    	pkgReferences.clear();
	    }
	    
		@Override
		public void invalidate() {
			resourceDescriptions = null;
			packageNameToPackageMap.clear();
		}			
		
		public AadlPackage getAadlPackage(final String packageName) {
			final String lowerCasePackageName = packageName.toLowerCase();
			Object pkgRef = packageNameToPackageMap.get(lowerCasePackageName);
			if(pkgRef == null) {
				pkgRef = findAadlPackage(lowerCasePackageName, getCachedResourceDescriptions(), savedAadlResourceService);
				if(pkgRef instanceof AadlPackageReference) {
					// Store strong reference
					pkgReferences.add((AadlPackageReference)pkgRef);
				} 
				
				// Store a reference to the package in the cache if the reference was valid
				if(pkgRef != null) {
					packageNameToPackageMap.put(lowerCasePackageName, pkgRef);					 
				}
			}
						
			if(pkgRef instanceof AadlPackageReference) {
				return ((AadlPackageReference) pkgRef).getAadlPackage();
			} else {
				return (AadlPackage)pkgRef;
			}
		}
		
		/**
		 * Returns an AadlPackage or an EObjectReference depending on whether the package is retrieved from disk or from an Xtext document
		 * @return
		 */
		private static Object findAadlPackage(final String packageName, Set<IResourceDescription> resourceDescriptions, final SavedAadlResourceService savedAadlResourceService) {
			// Get the Xtext Resource for the package
			final XtextResource xtextResource = AgeXtextUtil.getOpenXtextResourceByRootQualifiedName(packageName, resourceDescriptions);
			if(xtextResource == null) {
				final String[] pkgNameSegs = packageName.split("::");
				final QualifiedName packageQualifiedName = QualifiedName.create(pkgNameSegs);
				for(final IResourceDescription resDesc : resourceDescriptions) {
					for(IEObjectDescription eod : resDesc.getExportedObjects(aadlPackageEClass, packageQualifiedName, true)) {
						return savedAadlResourceService.getPackageReference(eod.getEObjectURI());
					}
				}
			} else {		
				final EObject rootObj = xtextResource.getContents().get(0);
				if(rootObj instanceof AadlPackage) {
					return rootObj;
				}
			}
			
			return null;
		}
		
		private Set<IResourceDescription> getCachedResourceDescriptions() {
			if(resourceDescriptions == null) {
				// Find resources that should be looked in
				final Set<IProject> projects = getRelevantProjects();
				resourceDescriptions = ScopedEMFIndexRetrieval.calculateResourceDescriptions(projects);
			}
			
			return resourceDescriptions;
		}
		
		/**
		 * Returns the set of projects that can be referenced from the project containing the diagram. 
		 * Recursive(Projects referenced by referenced projects are also included).
		 * @return
		 */
		private Set<IProject> getRelevantProjects() {
			try {
				final Set<IProject> projects = new HashSet<IProject>();
				final IProject diagramProject = projectProvider.getProject();
				projects.add(diagramProject);
				addReferencedProjects(diagramProject, projects);

				return projects;
			} catch(final CoreException ex) {
				throw new RuntimeException(ex);
			}		 
		}
		
		private void addReferencedProjects(final IProject project, final Set<IProject> results) throws CoreException {
			for(final IProject rp : project.getReferencedProjects()) {
				if(rp.isAccessible()) {
					if(!results.contains(rp)) {
						results.add(rp);
						addReferencedProjects(rp, results);
					}
				}
			}
		}
	}
	
	private final DeclarativeCache declarativeCache;
         
	@Inject
	public DeclarativeReferenceResolver(final ProjectProvider projectProvider, final CachingService cachingService, final SavedAadlResourceService savedAadlResourceService) {
		this.declarativeCache = new DeclarativeCache(projectProvider, cachingService, savedAadlResourceService);		
		cachingService.registerCache(declarativeCache);
	}
		
	@PreDestroy
	public void dispose() {
		declarativeCache.dispose();
	}

	@ResolveCanonicalReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] refSegs, final ReferenceResolutionService refService) {
		Objects.requireNonNull(refSegs, "refSegs must not be null");
		if(refSegs.length < 2) {
			return null;
		}
				
		Object referencedObject = null; // The object that will be returned
		final String type = refSegs[0];
					
		if(type.equals(DeclarativeReferenceBuilder.TYPE_SUBPROGRAM_CALL_ORDER)) {
			if(refSegs.length == 3) {
				final SubprogramCall previousSubprogramCall = getNamedElementByQualifiedName(refSegs[1], SubprogramCall.class);
				final SubprogramCall subprogramCall = getNamedElementByQualifiedName(refSegs[2], SubprogramCall.class);
				if(previousSubprogramCall != null && subprogramCall != null) {
					referencedObject = new SubprogramCallOrder(previousSubprogramCall, subprogramCall);
				}
			}			
		} else { 
			final String qualifiedName = refSegs[1];
			if(type.equals(DeclarativeReferenceBuilder.TYPE_PACKAGE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, AadlPackage.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_CLASSIFIER)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Classifier.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_SUBCOMPONENT)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Subcomponent.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_FEATURE)){
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Feature.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_INTERNAL_FEATURE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, InternalFeature.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_PROCESSOR_FEATURE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, ProcessorFeature.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_FLOW_SPECIFICATION)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, FlowSpecification.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_CONNECTION)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Connection.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_MODE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Mode.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_SUBPROGRAM_CALL_SEQUENCE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, SubprogramCallSequence.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_SUBPROGRAM_CALL)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, SubprogramCall.class);
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_MODE_TRANSITION_NAMED)) {
				if(refSegs.length == 3) {
					final Object referencedClassifier = refService.getReferencedObject(refSegs[1]);
					if(referencedClassifier instanceof ComponentClassifier) {
						final ComponentClassifier cc = (ComponentClassifier)referencedClassifier;
						final String name = refSegs[2];
						referencedObject = cc.getOwnedModeTransitions().stream().
								filter(mt -> name.equalsIgnoreCase(DeclarativeReferenceBuilder.getNameForSerialization(mt))). // Filter objects by name
								findAny().orElse(null);
					}
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_MODE_TRANSITION_UNNAMED)) {
				final ComponentClassifier cc = getNamedElementByQualifiedName(qualifiedName, ComponentClassifier.class);
				if(cc != null) {
					for(final ModeTransition mt : cc.getOwnedModeTransitions()) {
						if(equalsIgnoreCase(refSegs, DeclarativeReferenceBuilder.buildUnnamedModeTransitionKey(mt))) { 
							referencedObject = mt;
							break;
						}
					}
				}			
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_MODE_TRANSITION_TRIGGER)) {
				if(refSegs.length == 4) {
					final Object referencedModeTransition = refService.getReferencedObject(refSegs[1]);
					if(referencedModeTransition instanceof ModeTransition) {
						final ModeTransition mt = (ModeTransition)referencedModeTransition;
						final String contextName = refSegs[2];
						final String triggerPortName = refSegs[3];
						referencedObject = mt.getOwnedTriggers().stream().
								filter(mtt -> contextName.equalsIgnoreCase(DeclarativeReferenceBuilder.getNameForSerialization(mtt.getContext())) &&
										triggerPortName.equalsIgnoreCase(DeclarativeReferenceBuilder.getNameForSerialization(mtt.getTriggerPort()))).
								findAny().orElse(null);
					}
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_REALIZATION)) {
				final ComponentImplementation ci = getNamedElementByQualifiedName(qualifiedName, ComponentImplementation.class);
				if(ci != null) {
					referencedObject = ci.getOwnedRealization();
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_TYPE_EXTENSION)) {
				final ComponentType ct = getNamedElementByQualifiedName(qualifiedName, ComponentType.class);
				if(ct instanceof ComponentType) {
					referencedObject = ct.getOwnedExtension();
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_IMPLEMENTATION_EXTENSION)) {
				final ComponentImplementation ci = getNamedElementByQualifiedName(qualifiedName, ComponentImplementation.class);
				if(ci != null) {
					referencedObject = ci.getOwnedExtension();
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_GROUP_EXTENSION)) {
				final FeatureGroupType fgt = getNamedElementByQualifiedName(qualifiedName, FeatureGroupType.class);
				if(fgt != null) {
					referencedObject = fgt.getOwnedExtension();
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_ANNEX_LIBRARY)) {
				final AadlPackage pkg = getNamedElementByQualifiedName(qualifiedName, AadlPackage.class);
				if(refSegs.length == 4 && pkg != null) {
					final String annexName = refSegs[2];
					final int annexIndex = Integer.parseInt(refSegs[3]);
					referencedObject = findAnnexLibrary(pkg, annexName, annexIndex);
				}
			} else if(type.equals(DeclarativeReferenceBuilder.TYPE_ANNEX_SUBCLAUSE)) {
				final Classifier classifier = getNamedElementByQualifiedName(qualifiedName, Classifier.class);
				if(refSegs.length == 4 && classifier != null) {
					final String annexName = refSegs[2];
					final int annexIndex = Integer.parseInt(refSegs[3]);
					referencedObject = findAnnexSubclause(classifier, annexName, annexIndex);
				}
			}
		}

		return referencedObject;
	}
	
	/**
	 * Assumes all elements are non-null
	 * @param a1
	 * @param a2
	 * @return
	 */
	private boolean equalsIgnoreCase(final String[] a1, final String[] a2) {
		if(a1.length != a2.length) {
			return false;
		}
		
		for(int i = 0; i < a1.length; i++) {
			if(!a1[i].equalsIgnoreCase(a2[i])) {
				return false;
			}
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	private <T> T getNamedElementByQualifiedName(final String qualifiedName, final Class<? extends T> searchClass) {
		// Special handling of AadlPackage
		final String elementPath;
		final String packageName;
		if(searchClass == AadlPackage.class) {
			elementPath = null; // Not needed when retrieving an Aadl Package
			packageName = qualifiedName;
		} else {
			final String[] qualifiedNameSegs = qualifiedName.split("::");
			packageName = StringUtil.join(qualifiedNameSegs, 0, qualifiedNameSegs.length-1, "::");
			elementPath = qualifiedNameSegs[qualifiedNameSegs.length-1];
		}

		final AadlPackage pkg = getAadlPackage(packageName);
		if(pkg == null) { 
			return null;
		}

		// Return the package if that is the element that was being retrieved		 
		T element;
		if(searchClass == AadlPackage.class) {
			element = (T)pkg;
		} else {		
			final String[] elementPathSegs = elementPath.split("\\.");
			element = findNamedElementByDeclarativeModelPath(pkg.getPublicSection(), searchClass, elementPathSegs);
			if(element == null) {
				element = findNamedElementByDeclarativeModelPath(pkg.getPrivateSection(), searchClass, elementPathSegs);
			}
		}

		return element;
	}
	
	public AadlPackage getAadlPackage(final String packageName) {
		return declarativeCache.getAadlPackage(packageName);
	}

	private <T> T findNamedElementByDeclarativeModelPath(final Namespace namespace, final Class<T> searchClass, final String[] pathSegs) {
		return findNamedElementByDeclarativeModelPath(namespace, searchClass, pathSegs, 0);
	}
	
	/**
	 * Looks up a model element based on the concept of a declarative model path. This path does not include the AadlPackage
	 * An example path is top_classifier.flow_type
	 * @param element the element in which to look for the next child
	 * @param searchClass the base type of the final object.
	 * @param pathSegs is the segments to use to find the object. Usually one segment corresponds to one child but in the case of component implementations, two 
	 * segments will be used for a single child.
	 * @param i the current path segment
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T findNamedElementByDeclarativeModelPath(final NamedElement element, final Class<T> searchClass, final String[] pathSegs, final int i) {
		if(i >= pathSegs.length) {
			return searchClass.isInstance(element) ? (T)element : null;
		}
		
		final String seg = pathSegs[i];
		if(element instanceof Classifier) {
			final Classifier c = (Classifier)element;
			return findNamedElementInClassifierByDeclarativeModelPath(c, searchClass, pathSegs, i, new HashSet<Classifier>());
		} else if(element instanceof Namespace) {
			for(final NamedElement member : ((Namespace)element).getMembers()) {
				final String name = member.getName();
				if(name != null) {
					if(name.equalsIgnoreCase(seg)) {
						final T result = findNamedElementByDeclarativeModelPath(member, searchClass, pathSegs, i+1);
						if(result != null) {
							return result;
						}
					} 
					
					// Handle Component Implementations
					if(((i+1) < pathSegs.length) && name.contains(".")) {
						if(name.equalsIgnoreCase(pathSegs[i] + "." + pathSegs[i+1])) {
							final T result = findNamedElementByDeclarativeModelPath(member, searchClass, pathSegs, i+2);
							if(result != null) {
								return result;
							}
						}
					}
				}				
			}
		}			
		
		return null;
	}
	
	// Specialized implementation of findNamedElementByDeclarativeModelPath for Classifiers because of performance issues when using Classifier.getMembers()
	private <T> T findNamedElementInClassifierByDeclarativeModelPath(final Classifier c, final Class<T> searchClass, final String[] pathSegs, final int i, Set<Classifier> checkedClassifiers) {
		final String seg = pathSegs[i];
		
		if(c != null) {
			for(final NamedElement member : c.getOwnedMembers()) {
				final String name = member.getName();
				if(name != null) {
					if(name.equalsIgnoreCase(seg)) {
						final T result = findNamedElementByDeclarativeModelPath(member, searchClass, pathSegs, i+1);
						if(result != null) {
							return result;
						}
					} 
				}
			}
			
			// Special handling for subprogram calls. The qualified name does not include the call sequence. Just the classifier.
			if(c instanceof BehavioredImplementation) {
				final BehavioredImplementation bi = (BehavioredImplementation)c;
				for(final SubprogramCallSequence callSequence : bi.getOwnedSubprogramCallSequences()) {
					for(final SubprogramCall member : callSequence.getOwnedSubprogramCalls()) {
						final String name = member.getName();
						if(name != null) {
							if(name.equalsIgnoreCase(seg)) {
								final T result = findNamedElementByDeclarativeModelPath(member, searchClass, pathSegs, i+1);
								if(result != null) {
									return result;
								}
							} 
						}
					}
				}
			}
			
			for (Generalization g : c.getGeneralizations()) {
				final Classifier gc = g.getGeneral();
				// Only check the generalization if it has not been checked yet. This protects against cycles.
				if(!checkedClassifiers.contains(gc)) {
					checkedClassifiers.add(gc);
					final T result = findNamedElementInClassifierByDeclarativeModelPath(gc, searchClass, pathSegs, i, checkedClassifiers);
					if(result != null) {
						return result;
					}				
				}
			}
		}
		
		return null;
	}
	
	// Helper methods for working with Annexes
	private AnnexLibrary findAnnexLibrary(final AadlPackage pkg, final String annexName, final int searchIndex) {
		int currentIndex = 0;
		for(final AnnexLibrary library : AnnexUtil.getAllDefaultAnnexLibraries(pkg)) {
			if(annexName.equalsIgnoreCase(library.getName())) {
				if(currentIndex == searchIndex) {
					return library;
				}
				
				currentIndex++;
			}
		}
		
		return null;
	}
	
	private AnnexSubclause findAnnexSubclause(final Classifier classifier, final String annexName, final int searchIndex) {
		int currentIndex = 0;
		for(final AnnexSubclause subclause : classifier.getOwnedAnnexSubclauses()) {
			if(annexName.equalsIgnoreCase(subclause.getName())) {
				if(currentIndex == searchIndex) {
					return subclause;
				}
				
				currentIndex++;
			}
		}
		
		return null;
	}
}
