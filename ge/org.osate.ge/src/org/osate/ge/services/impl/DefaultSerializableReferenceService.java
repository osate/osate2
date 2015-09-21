package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
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
import org.osate.ge.services.SerializableReferenceService;
import org.osate.ge.util.Log;
import org.osate.ge.util.StringUtil;

public class DefaultSerializableReferenceService implements SerializableReferenceService {
	private final static String TYPE_ANNEX_LIBRARY = "annex_library";
	private final static String TYPE_ANNEX_SUBCLAUSE = "annex_subclause";
	
	@Override
	public String getReference(final Object bo) {
		if(bo instanceof AadlPackage) {
			return "package " + ((AadlPackage)bo).getQualifiedName();				
		} else if(bo instanceof Classifier) {
			return "classifier " + ((Classifier)bo).getQualifiedName();
		} else if(bo instanceof Subcomponent) {
			return "subcomponent " + ((Subcomponent)bo).getQualifiedName();
		} else if(bo instanceof Realization) {
			return "realization " + ((Realization)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof TypeExtension) {
			return "type_extension " + ((TypeExtension)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof ImplementationExtension) {
			return "implementation_extension " + ((ImplementationExtension)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof GroupExtension) {
			return "group_extension " + ((GroupExtension)bo).getSpecific().getQualifiedName();
		} else if(bo instanceof Feature) {
			return "feature " + ((Feature)bo).getQualifiedName();
		} else if(bo instanceof InternalFeature) {
			return "internal_feature " + ((InternalFeature)bo).getQualifiedName();
		} else if(bo instanceof ProcessorFeature) {
			return "processor_feature " + ((ProcessorFeature)bo).getQualifiedName();
		} else if(bo instanceof FlowSpecification) {
			return "flow_specification " + ((FlowSpecification)bo).getQualifiedName();
		} else if(bo instanceof Connection) {
			return "connection " + ((Connection)bo).getQualifiedName();
		} else if(bo instanceof Mode) {
			return "mode " + ((Mode)bo).getQualifiedName();
		} else if(bo instanceof ModeTransition) {
			return buildModeTransitionKey((ModeTransition)bo);
		} else if(bo instanceof SubprogramCallSequence) {
			return "subprogram_call_sequence " + ((SubprogramCallSequence)bo).getQualifiedName();
		} else if(bo instanceof SubprogramCall) {
			return "subprogram_call " + ((SubprogramCall)bo).getQualifiedName();
		} else if(bo instanceof SubprogramCallOrder) {
			final SubprogramCallOrder sco = (SubprogramCallOrder)bo;
			return "subprogram_call_order " + sco.previousSubprogramCall.getQualifiedName() + " " + sco.subprogramCall.getQualifiedName();
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
		
	public Object getReferencedObject(final XtextResourceSet resourceSet, final String reference) {
		if(reference == null) {
			return null;
		}

		// Check the resource set
		if(resourceSet == null) {
			return null;
		}
		
		final String[] segs = reference.split(" ");
		if(segs.length < 2) {
			return null;
		}		
		
		Object referencedObject = null; // The object that will be returned
		final String type = segs[0];
		
		if(type.equals("subprogram_call_order")) {
			if(segs.length == 3) {
				final Element previousSubprogramCall = getNamedElementByQualifiedName(resourceSet, segs[1]);
				final Element subprogramCall = getNamedElementByQualifiedName(resourceSet, segs[2]);
				if(previousSubprogramCall instanceof SubprogramCall && subprogramCall instanceof SubprogramCall) {
					referencedObject = new SubprogramCallOrder((SubprogramCall)previousSubprogramCall, (SubprogramCall)subprogramCall);
				}
			}			
		} else { 
			final String qualifiedName = segs[1];
			final Element relevantElement = getNamedElementByQualifiedName(resourceSet, qualifiedName);
					
			if(type.equals("package") ||
				type.equals("classifier") ||
				type.equals("subcomponent") ||
				type.equals("feature") ||
				type.equals("internal_feature") ||
				type.equals("processor_feature") ||
				type.equals("flow_specification") ||
				type.equals("connection") ||
				type.equals("mode") ||
				type.equals("subprogram_call_sequence") ||
				type.equals("subprogram_call")) {
					referencedObject = relevantElement;
			} else if(type.equals("mode_transition")) {
				if(relevantElement instanceof ComponentClassifier) {
					for(final ModeTransition mt : ((ComponentClassifier) relevantElement).getOwnedModeTransitions()) {
						if(reference.equalsIgnoreCase(buildModeTransitionKey(mt))) {
							referencedObject = mt;
						}
					}
				}			
			} else if(type.equals("realization")) {
				if(relevantElement instanceof ComponentImplementation) {
					referencedObject = ((ComponentImplementation)relevantElement).getOwnedRealization();
				}
			} else if(type.equals("type_extension")) {
				if(relevantElement instanceof ComponentType) {
					referencedObject = ((ComponentType)relevantElement).getOwnedExtension();
				}
			} else if(type.equals("implementation_extension")) {
				if(relevantElement instanceof ComponentImplementation) {
					referencedObject = ((ComponentImplementation)relevantElement).getOwnedExtension();
				}
			} else if(type.equals("group_extension")) {
				if(relevantElement instanceof FeatureGroupType) {
					referencedObject = ((FeatureGroupType)relevantElement).getOwnedExtension();
				}
			} else if(type.equals(TYPE_ANNEX_LIBRARY)) {
				if(segs.length == 4 && relevantElement instanceof AadlPackage) {
					final AadlPackage pkg = (AadlPackage)relevantElement;
					final String annexName = segs[2];
					final int annexIndex = Integer.parseInt(segs[3]);
					referencedObject = findAnnexLibrary(pkg, annexName, annexIndex);
				}
			} else if(type.equals(TYPE_ANNEX_SUBCLAUSE)) {
				if(segs.length == 4 && relevantElement instanceof Classifier) {
					final Classifier classifier = (Classifier)relevantElement;
					final String annexName = segs[2];
					final int annexIndex = Integer.parseInt(segs[3]);
					referencedObject = findAnnexSubclause(classifier, annexName, annexIndex);
				}
			} else {
				Log.error("Unhandled case: " + type);
			}
		}
		
		return referencedObject;
	}
	
	private String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "<null>" : ne.getName();
	}
	
	private String buildModeTransitionKey(final ModeTransition mt) {
		String result = "mode_transition ";
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
	
	private NamedElement getNamedElementByQualifiedName(final XtextResourceSet resourceSet, final String qualifiedName) {
		// Check if the qualified name refers to a package
		AadlPackage pkg = getPackage(resourceSet, qualifiedName);
		if(pkg != null) {
			return pkg;
		}
		
		// Otherwise, determine the package and find the element
		final String[] segs = qualifiedName.split("::");
		String pkgName = StringUtil.join(segs, 0, segs.length-1, "::");

		// Find the package	
		pkg = getPackage(resourceSet, pkgName);
		if(pkg == null) {
			return null;
		}
		
		if(segs.length == 1) { 
			return pkg;
		}
		
		// Check the public section first then the private
		final String path = segs[segs.length-1];
		final String[] pathSegs = path.split("\\.");
		NamedElement element = findNamedElement(pkg.getPublicSection(), pathSegs);
		if(element == null) {
			element =  findNamedElement(pkg.getPrivateSection(), pathSegs);
		}
		
		return element;
	}
	
	private NamedElement findNamedElement(final Namespace namespace, final String[] pathSegs) {
		return findNamedElement(namespace, pathSegs, 0);
	}
	
	private NamedElement findNamedElement(final NamedElement element, final String[] pathSegs, final int i) {
		if(i >= pathSegs.length) {
			return element;
		}
		
		final String seg = pathSegs[i];
		if(element instanceof Classifier) {
			final Classifier c = (Classifier)element;
			return findNamedElementInClassifier(c, pathSegs, i, new HashSet<Classifier>());
		} else if(element instanceof Namespace) {
			for(final NamedElement member : ((Namespace)element).getMembers()) {
				final String name = member.getName();
				if(name != null) {
					if(name.equalsIgnoreCase(seg)) {
						final NamedElement result = findNamedElement(member, pathSegs, i+1);
						if(result != null) {
							return result;
						}
					} 
					
					// Handle Component Implementations
					if(((i+1) < pathSegs.length) && name.contains(".")) {
						if(name.equalsIgnoreCase(pathSegs[i] + "." + pathSegs[i+1])) {
							final NamedElement result = findNamedElement(member, pathSegs, i+2);
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
	private NamedElement findNamedElementInClassifier(final Classifier c, final String[] pathSegs, final int i, Set<Classifier> checkedClassifiers) {
		final String seg = pathSegs[i];
		
		if(c != null) {
			for(final NamedElement member : c.getOwnedMembers()) {
				final String name = member.getName();
				if(name != null) {
					if(name.equalsIgnoreCase(seg)) {
						final NamedElement result = findNamedElement(member, pathSegs, i+1);
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
								final NamedElement result = findNamedElement(member, pathSegs, i+1);
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
					final NamedElement result = findNamedElementInClassifier(gc, pathSegs, i, checkedClassifiers);
					if(result != null) {
						return result;
					}				
				}
			}
		}
		
		return null;
	}
	
	private AadlPackage getPackage(final XtextResourceSet resourceSet, final String name) {
		// Look for the resource that contains the package
		for(final Resource resource : new ArrayList<Resource>(resourceSet.getResources())) {
			if(resource.getContents().size() > 0) {
				final EObject obj = resource.getContents().get(0);
				if(obj instanceof AadlPackage) {
					final AadlPackage pkg = ((AadlPackage)obj);
					if(pkg.getName().equalsIgnoreCase(name)) {
						return pkg;
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
