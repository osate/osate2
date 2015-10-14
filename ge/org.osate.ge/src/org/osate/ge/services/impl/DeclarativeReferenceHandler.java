package org.osate.ge.services.impl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
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
import org.osate.core.OsateCorePlugin;
import org.osate.ge.diagrams.componentImplementation.patterns.SubprogramCallOrder;
import org.osate.ge.ui.util.SelectionHelper;
import org.osate.ge.ui.xtext.AgeXtextUtil;
import org.osate.ge.util.Log;
import org.osate.ge.util.StringUtil;

import com.google.inject.Injector;

// Handles references related to the AADL declarative model
public class DeclarativeReferenceHandler {
	// TODO: Would there be a way to cleanup things using an enumeration and possibly lambdas?
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
	private IDiagramTypeProvider diagramTypeProvider;
	
	public DeclarativeReferenceHandler(final IDiagramTypeProvider diagramTypeProvider) {
		this.diagramTypeProvider = Objects.requireNonNull(diagramTypeProvider, "diagramTypeProvider must not be null");
	}
	
	public String getReference(final Object bo) {
		if(bo instanceof AadlPackage) {
			return TYPE_PACKAGE + " " + ((AadlPackage)bo).getQualifiedName();				
		} else if(bo instanceof Classifier) {
			return TYPE_CLASSIFIER + " " + ((Classifier)bo).getQualifiedName();
		} else if(bo instanceof Subcomponent) {
			return TYPE_SUBCOMPONENT + " " + ((Subcomponent)bo).getQualifiedName();
		} else if(bo instanceof Realization) {
			return TYPE_REALIZATION + " " + ((Realization)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof TypeExtension) {
			return TYPE_TYPE_EXTENSION + " " + ((TypeExtension)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof ImplementationExtension) {
			return TYPE_IMPLEMENTATION_EXTENSION + " " + ((ImplementationExtension)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof GroupExtension) {
			return TYPE_GROUP_EXTENSION + " " + ((GroupExtension)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof Feature) {
			return TYPE_FEATURE + " " + ((Feature)bo).getQualifiedName();
		} else if(bo instanceof InternalFeature) {
			return TYPE_INTERNAL_FEATURE + " " + ((InternalFeature)bo).getQualifiedName();
		} else if(bo instanceof ProcessorFeature) {
			return TYPE_PROCESSOR_FEATURE + "  " + ((ProcessorFeature)bo).getQualifiedName();
		} else if(bo instanceof FlowSpecification) {
			return TYPE_FLOW_SPECIFICATION + " " + ((FlowSpecification)bo).getQualifiedName();
		} else if(bo instanceof Connection) {
			return TYPE_CONNECTION + " " + ((Connection)bo).getQualifiedName();
		} else if(bo instanceof Mode) {
			return TYPE_MODE + " " + ((Mode)bo).getQualifiedName();
		} else if(bo instanceof ModeTransition) {
			return buildModeTransitionKey((ModeTransition)bo);
		} else if(bo instanceof SubprogramCallSequence) {
			return TYPE_SUBPROGRAM_CALL_SEQUENCE + " " + ((SubprogramCallSequence)bo).getQualifiedName();
		} else if(bo instanceof SubprogramCall) {
			return TYPE_SUBPROGRAM_CALL + " " + ((SubprogramCall)bo).getQualifiedName();
		} else if(bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder)bo;
			return TYPE_SUBPROGRAM_CALL_ORDER + " " + sco.previousSubprogramCall.getQualifiedName() + " " + sco.subprogramCall.getQualifiedName();
		} else if(bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary)bo;					
			final AadlPackage annexPkg = getAnnexLibraryPackage(annexLibrary);
			if(annexPkg == null) {
				throw new RuntimeException("Unable to retrieve package.");
			}
			
			final int index = getAnnexLibraryIndex(annexLibrary);
			return TYPE_ANNEX_LIBRARY + " " + annexPkg.getQualifiedName() + " " + annexLibrary.getName().toLowerCase() + " " + index;
		} else if(bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause)bo;			
			if(annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}
			
			final Classifier annexSubclauseClassifier = annexSubclause.getContainingClassifier();	
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return TYPE_ANNEX_SUBCLAUSE + " " + annexSubclauseClassifier.getQualifiedName() + " " + annexSubclause.getName().toLowerCase() + " " + index;
		} else {
			return null;
		}
	}
	
	public Object getReferencedObject(final String reference, final String[] refSegs) {
		Objects.requireNonNull(reference, "reference must not be null");
		Objects.requireNonNull(refSegs, "refSegs must not be null");

		if(refSegs.length < 2) {
			return null;
		}
				
		// TODO: Could intern type and then wouldn't need string comparison for type?
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
						if(reference.equalsIgnoreCase(buildModeTransitionKey(mt))) {
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

		// Find resources that should be looked in
		final Set<IProject> projects = getRelevantProjects();
		final Set<IResourceDescription> resourceDescriptions = getResourceDescriptions(projects);
						
		// Get the Xtext Resource for the package
		final XtextResource xtextResource = AgeXtextUtil.getXtextResourceByRootQualifiedName(packageName, resourceDescriptions);
		if(xtextResource == null) {
			return null;
		}
		
		final EObject rootObj = xtextResource.getContents().get(0);
		if(!(rootObj instanceof AadlPackage)) {
			return null;
		}

		// Return the package if that is the element that was being retrieved
		final AadlPackage pkg = (AadlPackage)rootObj;
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
	
	// TODO: Consider making some of this capability available outside of the declarative reference handler. 	
	private Set<IProject> getRelevantProjects() {
		try {
			// TODO: Could be cached, but would need to know when to invalidate cache. Project reference changes...
			final Set<IProject> projects = new HashSet<IProject>();
			final IProject diagramProject = SelectionHelper.getProject(diagramTypeProvider.getDiagram().eResource());
			projects.add(diagramProject);
			addReferencedProjects(diagramProject, projects);

			return projects;
		} catch(final CoreException ex) {
			throw new RuntimeException(ex);
		}		 
	}
	
	private Set<IResourceDescription> getResourceDescriptions(final Set<IProject> projects) {
		// TODO: Like projects, would ideally be cached.
		final Set<IResourceDescription> resourceDescriptions = new HashSet<IResourceDescription>();
		// TODO: Better way that doesn't involve creating a new resource set?
		final Injector injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.properties.Properties");
		final ResourceDescriptionsProvider resourceDescProvider = injector.getInstance(ResourceDescriptionsProvider.class);
		final IResourceDescriptions resDescriptions = resourceDescProvider.getResourceDescriptions(new XtextResourceSet());		
		for(final IResourceDescription resDesc : resDescriptions.getAllResourceDescriptions()) {
			final IPath resPath = new Path(resDesc.getURI().toPlatformString(true));
			for(final IProject p : projects) {
				// TODO: Check behavior
				if(p.getFullPath().isPrefixOf(resPath)) {
					resourceDescriptions.add(resDesc);
				}
			}
		}
		
		return resourceDescriptions;
	}
	
	private void addReferencedProjects(final IProject project, final Set<IProject> results) throws CoreException {
		for(final IProject rp : project.getReferencedProjects()) {
			if(!results.contains(rp)) {
				results.add(rp);
				addReferencedProjects(rp, results);
			}
		}
	}
	
	private String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}
	
	private String buildModeTransitionKey(final ModeTransition mt) {
		String result = TYPE_MODE_TRANSITION + " ";
		result += mt.getContainingClassifier().getQualifiedName();
		result += " " + getNameForSerialization(mt);
		result += " " + getNameForSerialization(mt.getSource());
		result += " " + getNameForSerialization(mt.getDestination());
		for(final ModeTransitionTrigger trigger : mt.getOwnedTriggers()) {
			result += " " + getNameForSerialization(trigger.getContext());
			result += " " + getNameForSerialization(trigger.getTriggerPort());
		}

		return result;
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
