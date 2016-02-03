package org.osate.ge.services.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
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
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.TypeExtension;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ge.diagrams.componentImplementation.patterns.SubprogramCallOrder;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.BuildReference;
import org.osate.ge.ext.annotations.ResolveReference;
import org.osate.ge.services.CachingService;
import org.osate.ge.services.CachingService.Cache;
import org.osate.ge.services.SavedAadlResourceService;
import org.osate.ge.services.SavedAadlResourceService.AadlPackageReference;
import org.osate.ge.ui.util.SelectionHelper;
import org.osate.ge.ui.xtext.AgeXtextUtil;
import org.osate.ge.util.Log;
import org.osate.ge.util.ScopedEMFIndexRetrieval;
import org.osate.ge.util.StringUtil;

// Handles references related to the AADL declarative model
public class DeclarativeReferenceHandler {
	// Cache for items that should not change unless models have changed.
	private static class DeclarativeCache implements Cache {
		private static final EClass aadlPackageEClass = Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage();
		private final IDiagramTypeProvider diagramTypeProvider;
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
	    	    
	    public DeclarativeCache(final IDiagramTypeProvider diagramTypeProvider, final CachingService cachingService, final SavedAadlResourceService savedAadlResourceService) {
			this.diagramTypeProvider = Objects.requireNonNull(diagramTypeProvider, "diagramTypeProvider must not be null");
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
				final IProject diagramProject = SelectionHelper.getProject(diagramTypeProvider.getDiagram().eResource());
				projects.add(diagramProject);
				addReferencedProjects(diagramProject, projects);

				return projects;
			} catch(final CoreException ex) {
				throw new RuntimeException(ex);
			}		 
		}
		
		private void addReferencedProjects(final IProject project, final Set<IProject> results) throws CoreException {
			for(final IProject rp : project.getReferencedProjects()) {
				if(!results.contains(rp)) {
					results.add(rp);
					addReferencedProjects(rp, results);
				}
			}
		}
	}
	
	private final static String TYPE_PACKAGE = "package";
	private final static String TYPE_CLASSIFIER = "classifier";
	private final static String TYPE_SUBCOMPONENT = "subcomponent";
	private final static String TYPE_REALIZATION = "realization";
	private final static String TYPE_TYPE_EXTENSION = "type_extension";
	private final static String TYPE_IMPLEMENTATION_EXTENSION = "implementation_extension";
	private final static String TYPE_GROUP_EXTENSION = "group_extension";
	private final static String TYPE_FEATURE = "feature";
	private final static String TYPE_INTERNAL_FEATURE = "internal_feature";
	private final static String TYPE_PROCESSOR_FEATURE = "processor_feature";
	private final static String TYPE_FLOW_SPECIFICATION = "flow_specification";
	private final static String TYPE_CONNECTION = "connection";
	private final static String TYPE_MODE = "mode";
	private final static String TYPE_MODE_TRANSITION = "mode_transition";
	private final static String TYPE_SUBPROGRAM_CALL_SEQUENCE = "subprogram_call_sequence";
	private final static String TYPE_SUBPROGRAM_CALL = "subprogram_call";
	private final static String TYPE_SUBPROGRAM_CALL_ORDER = "subprogram_call_order";
	private final static String TYPE_ANNEX_LIBRARY = "annex_library";
	private final static String TYPE_ANNEX_SUBCLAUSE = "annex_subclause";
	private final DeclarativeCache declarativeCache;
         
	@Inject
	public DeclarativeReferenceHandler(final IDiagramTypeProvider diagramTypeProvider, final CachingService cachingService, final SavedAadlResourceService savedAadlResourceService) {
		this.declarativeCache = new DeclarativeCache(diagramTypeProvider, cachingService, savedAadlResourceService);		
		cachingService.registerCache(declarativeCache);
	}
		
	@PreDestroy
	public void dispose() {
		declarativeCache.dispose();
	}
	
	@BuildReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof AadlPackage) {
			return new String[] {TYPE_PACKAGE, ((AadlPackage)bo).getQualifiedName()};				
		} else if(bo instanceof Classifier) {
			return new String[] {TYPE_CLASSIFIER, ((Classifier)bo).getQualifiedName()};
		} else if(bo instanceof Subcomponent) {
			return new String[] {TYPE_SUBCOMPONENT, ((Subcomponent)bo).getQualifiedName()};
		} else if(bo instanceof Realization) {
			return new String[] {TYPE_REALIZATION, ((Realization)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof TypeExtension) {
			return new String[] {TYPE_TYPE_EXTENSION, ((TypeExtension)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof ImplementationExtension) {
			return new String[] {TYPE_IMPLEMENTATION_EXTENSION, ((ImplementationExtension)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof GroupExtension) {
			return new String[] {TYPE_GROUP_EXTENSION, ((GroupExtension)bo).getSpecific().getQualifiedName()};
		} else if(bo instanceof Feature) {
			return new String[] {TYPE_FEATURE, ((Feature)bo).getQualifiedName()};
		} else if(bo instanceof InternalFeature) {
			return new String[] {TYPE_INTERNAL_FEATURE, ((InternalFeature)bo).getQualifiedName()};
		} else if(bo instanceof ProcessorFeature) {
			return new String[] {TYPE_PROCESSOR_FEATURE, ((ProcessorFeature)bo).getQualifiedName()};
		} else if(bo instanceof FlowSpecification) {
			return new String[] {TYPE_FLOW_SPECIFICATION, ((FlowSpecification)bo).getQualifiedName()};
		} else if(bo instanceof Connection) {
			return new String[] {TYPE_CONNECTION, ((Connection)bo).getQualifiedName()};
		} else if(bo instanceof Mode) {
			return new String[] {TYPE_MODE, ((Mode)bo).getQualifiedName()};
		} else if(bo instanceof ModeTransition) {
			return buildModeTransitionKey((ModeTransition)bo);
		} else if(bo instanceof SubprogramCallSequence) {
			return new String[] {TYPE_SUBPROGRAM_CALL_SEQUENCE, ((SubprogramCallSequence)bo).getQualifiedName()};
		} else if(bo instanceof SubprogramCall) {
			return new String[] {TYPE_SUBPROGRAM_CALL, ((SubprogramCall)bo).getQualifiedName()};
		} else if(bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder)bo;
			return new String[] {TYPE_SUBPROGRAM_CALL_ORDER, sco.previousSubprogramCall.getQualifiedName(), sco.subprogramCall.getQualifiedName()};
		} else if(bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary)bo;					
			final AadlPackage annexPkg = getAnnexLibraryPackage(annexLibrary);
			if(annexPkg == null) {
				throw new RuntimeException("Unable to retrieve package.");
			}
			
			final int index = getAnnexLibraryIndex(annexLibrary);
			return new String[] {TYPE_ANNEX_LIBRARY, annexPkg.getQualifiedName(), annexLibrary.getName().toLowerCase(), Integer.toString(index)};
		} else if(bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause)bo;			
			if(annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}
			
			final Classifier annexSubclauseClassifier = annexSubclause.getContainingClassifier();	
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new String[] {TYPE_ANNEX_SUBCLAUSE, annexSubclauseClassifier.getQualifiedName(), annexSubclause.getName().toLowerCase(), Integer.toString(index)};
		} else {
			return null;
		}
	}
	
	@ResolveReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] refSegs) {
		Objects.requireNonNull(refSegs, "refSegs must not be null");

		if(refSegs.length < 2) {
			return null;
		}
				
		Object referencedObject = null; // The object that will be returned
		final String type = refSegs[0]; 
		
		if(type.equals(TYPE_SUBPROGRAM_CALL_ORDER)) {
			if(refSegs.length == 3) {
				final SubprogramCall previousSubprogramCall = getNamedElementByQualifiedName(refSegs[1], SubprogramCall.class);
				final SubprogramCall subprogramCall = getNamedElementByQualifiedName(refSegs[2], SubprogramCall.class);
				if(previousSubprogramCall != null && subprogramCall != null) {
					referencedObject = new SubprogramCallOrder(previousSubprogramCall, subprogramCall);
				}
			}			
		} else { 
			final String qualifiedName = refSegs[1];
			if(type.equals(TYPE_PACKAGE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, AadlPackage.class);
			} else if(type.equals(TYPE_CLASSIFIER)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Classifier.class);
			} else if(type.equals(TYPE_SUBCOMPONENT)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Subcomponent.class);
			} else if(type.equals(TYPE_FEATURE)){
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Feature.class);
			} else if(type.equals(TYPE_INTERNAL_FEATURE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, InternalFeature.class);
			} else if(type.equals(TYPE_PROCESSOR_FEATURE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, ProcessorFeature.class);
			} else if(type.equals(TYPE_FLOW_SPECIFICATION)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, FlowSpecification.class);
			} else if(type.equals(TYPE_CONNECTION)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Connection.class);
			} else if(type.equals(TYPE_MODE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, Mode.class);
			} else if(type.equals(TYPE_SUBPROGRAM_CALL_SEQUENCE)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, SubprogramCallSequence.class);
			} else if(type.equals(TYPE_SUBPROGRAM_CALL)) {
				referencedObject = getNamedElementByQualifiedName(qualifiedName, SubprogramCall.class);
			} else if(type.equals(TYPE_MODE_TRANSITION)) {
				final ComponentClassifier cc = getNamedElementByQualifiedName(qualifiedName, ComponentClassifier.class);
				if(cc != null) {
					for(final ModeTransition mt : cc.getOwnedModeTransitions()) {
						if(equalsIgnoreCase(refSegs, buildModeTransitionKey(mt))) { 
							referencedObject = mt;
							break;
						}
					}
				}			
			} else if(type.equals(TYPE_REALIZATION)) {
				final ComponentImplementation ci = getNamedElementByQualifiedName(qualifiedName, ComponentImplementation.class);
				if(ci != null) {
					referencedObject = ci.getOwnedRealization();
				}
			} else if(type.equals(TYPE_TYPE_EXTENSION)) {
				final ComponentType ct = getNamedElementByQualifiedName(qualifiedName, ComponentType.class);
				if(ct instanceof ComponentType) {
					referencedObject = ct.getOwnedExtension();
				}
			} else if(type.equals(TYPE_IMPLEMENTATION_EXTENSION)) {
				final ComponentImplementation ci = getNamedElementByQualifiedName(qualifiedName, ComponentImplementation.class);
				if(ci != null) {
					referencedObject = ci.getOwnedExtension();
				}
			} else if(type.equals(TYPE_GROUP_EXTENSION)) {
				final FeatureGroupType fgt = getNamedElementByQualifiedName(qualifiedName, FeatureGroupType.class);
				if(fgt != null) {
					referencedObject = fgt.getOwnedExtension();
				}
			} else if(type.equals(TYPE_ANNEX_LIBRARY)) {
				final AadlPackage pkg = getNamedElementByQualifiedName(qualifiedName, AadlPackage.class);
				if(refSegs.length == 4 && pkg != null) {
					final String annexName = refSegs[2];
					final int annexIndex = Integer.parseInt(refSegs[3]);
					referencedObject = findAnnexLibrary(pkg, annexName, annexIndex);
				}
			} else if(type.equals(TYPE_ANNEX_SUBCLAUSE)) {
				final Classifier classifier = getNamedElementByQualifiedName(qualifiedName, Classifier.class);
				if(refSegs.length == 4 && classifier != null) {
					final String annexName = refSegs[2];
					final int annexIndex = Integer.parseInt(refSegs[3]);
					referencedObject = findAnnexSubclause(classifier, annexName, annexIndex);
				}
			} else {
				Log.error("Unhandled case: " + type);
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
			element = findNamedElement(pkg.getPublicSection(), searchClass, elementPathSegs);
			if(element == null) {
				element = findNamedElement(pkg.getPrivateSection(), searchClass, elementPathSegs);
			}
		}

		return element;
	}
	
	public AadlPackage getAadlPackage(final String packageName) {
		return declarativeCache.getAadlPackage(packageName);
	}

	private <T> T findNamedElement(final Namespace namespace, final Class<T> searchClass, final String[] pathSegs) {
		return findNamedElement(namespace, searchClass, pathSegs, 0);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T findNamedElement(final NamedElement element, final Class<T> searchClass, final String[] pathSegs, final int i) {
		if(i >= pathSegs.length) {
			return searchClass.isInstance(element) ? (T)element : null;
		}
		
		final String seg = pathSegs[i];
		if(element instanceof Classifier) {
			final Classifier c = (Classifier)element;
			return findNamedElementInClassifier(c, searchClass, pathSegs, i, new HashSet<Classifier>());
		} else if(element instanceof Namespace) {
			for(final NamedElement member : ((Namespace)element).getMembers()) {
				final String name = member.getName();
				if(name != null) {
					if(name.equalsIgnoreCase(seg)) {
						final T result = findNamedElement(member, searchClass, pathSegs, i+1);
						if(result != null) {
							return result;
						}
					} 
					
					// Handle Component Implementations
					if(((i+1) < pathSegs.length) && name.contains(".")) {
						if(name.equalsIgnoreCase(pathSegs[i] + "." + pathSegs[i+1])) {
							final T result = findNamedElement(member, searchClass, pathSegs, i+2);
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
	
	// Specialized implementation of findNamedElement for Classifiers because of performance issues when using Classifier.getMembers()
	private <T> T findNamedElementInClassifier(final Classifier c, final Class<T> searchClass, final String[] pathSegs, final int i, Set<Classifier> checkedClassifiers) {
		final String seg = pathSegs[i];
		
		if(c != null) {
			for(final NamedElement member : c.getOwnedMembers()) {
				final String name = member.getName();
				if(name != null) {
					if(name.equalsIgnoreCase(seg)) {
						final T result = findNamedElement(member, searchClass, pathSegs, i+1);
						if(result != null) {
							return result;
						}
					} 
				}
			}
			
			// Special handling for subprogram calls. They are not owned by the classifier but rather the subprogram call sequence.
			if(c instanceof BehavioredImplementation) {
				final BehavioredImplementation bi = (BehavioredImplementation)c;
				for(final SubprogramCallSequence callSequence : bi.getOwnedSubprogramCallSequences()) {
					for(final SubprogramCall member : callSequence.getOwnedSubprogramCalls()) {
						final String name = member.getName();
						if(name != null) {
							if(name.equalsIgnoreCase(seg)) {
								final T result = findNamedElement(member, searchClass, pathSegs, i+1);
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
					final T result = findNamedElementInClassifier(gc, searchClass, pathSegs, i, checkedClassifiers);
					if(result != null) {
						return result;
					}				
				}
			}
		}
		
		return null;
	}
	
	private String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}
	
	private String[] buildModeTransitionKey(final ModeTransition mt) {
		final List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();
		final String[] key = new String[5 + (triggers.size() * 2)];
		int index = 0;
		key[index++] = TYPE_MODE_TRANSITION;
		key[index++] = mt.getContainingClassifier().getQualifiedName();
		key[index++] = getNameForSerialization(mt);
		key[index++] = getNameForSerialization(mt.getSource());
		key[index++] = getNameForSerialization(mt.getDestination());
		for(final ModeTransitionTrigger trigger : triggers) {
			key[index++] = getNameForSerialization(trigger.getContext());
			key[index++] = getNameForSerialization(trigger.getTriggerPort());
		}

		return key;
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
		
	/**
	 * Get the package in which the annex library is contained.
	 * @param annex
	 * @return
	 */
	private AadlPackage getAnnexLibraryPackage(final AnnexLibrary annexLibrary) {
		for(Element o = annexLibrary.getOwner(); o != null; o = o.getOwner()) {
			if(o instanceof AadlPackage) {
				return (AadlPackage)o;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns a 0 based index for referencing an annex library in a list that contains only annex libraries with the same type and owner
	 * @param annexLibrary
	 * @return
	 */
	private int getAnnexLibraryIndex(final AnnexLibrary annexLibrary) {
		final String annexName = annexLibrary.getName();
		if(annexName == null) {
			return -1;
		}
		
		// Get the Aadl Package
		Element tmp = annexLibrary.getOwner();
		while(tmp != null && !(tmp instanceof AadlPackage)) {
			tmp = tmp.getOwner();
		}
		
		int index = 0;
		if(tmp instanceof AadlPackage) {
			for(final AnnexLibrary tmpLibrary : AnnexUtil.getAllDefaultAnnexLibraries((AadlPackage)tmp)) {
				if(tmpLibrary == annexLibrary) {
					return index;
				} else if(annexName.equalsIgnoreCase(tmpLibrary.getName())) {
					index++;
				}
			}
		}

		return -1;
	}
	
	/**
	 * Returns a 0 based index for referencing an annex subclause in a list that contains only annex subclauses with the same type and owner
	 * @param annexLibrary
	 * @return
	 */
	private int getAnnexSubclauseIndex(final AnnexSubclause annexSubclause) {
		final String annexName = annexSubclause.getName();
		if(annexName == null) {
			return -1;
		}
		
		// Get the Classifier
		final Classifier classifier = annexSubclause.getContainingClassifier();
				
		int index = 0;
		for(final AnnexSubclause tmpSubclause : classifier.getOwnedAnnexSubclauses()) {
			if(tmpSubclause == annexSubclause) {
				return index;
			} else if(annexName.equalsIgnoreCase(tmpSubclause.getName())) {
				index++;
			}
		}

		return -1;
	}
}
