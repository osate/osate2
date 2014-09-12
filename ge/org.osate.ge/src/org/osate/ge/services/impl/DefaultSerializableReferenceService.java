package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
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
import org.osate.aadl2.TypeExtension;
import org.osate.ge.services.SerializableReferenceService;
import org.osate.ge.util.Log;
import org.osate.ge.util.StringUtil;

public class DefaultSerializableReferenceService implements SerializableReferenceService {
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
		
		Element aadlElement = null; // The AADL Element that is returned
		final String type = segs[0];
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
			type.equals("mode")) {
				aadlElement = relevantElement;
		} else if(type.equals("mode_transition")) {
			if(relevantElement instanceof ComponentClassifier) {
				for(final ModeTransition mt : ((ComponentClassifier) relevantElement).getOwnedModeTransitions()) {
					if(reference.equalsIgnoreCase(buildModeTransitionKey(mt))) {
						aadlElement = mt;
					}
				}
			}
			
		} else if(type.equals("realization")) {
			if(relevantElement instanceof ComponentImplementation) {
				aadlElement = ((ComponentImplementation)relevantElement).getOwnedRealization();
			}
		} else if(type.equals("type_extension")) {
			if(relevantElement instanceof ComponentType) {
				aadlElement = ((ComponentType)relevantElement).getOwnedExtension();
			}
		} else if(type.equals("implementation_extension")) {
			if(relevantElement instanceof ComponentImplementation) {
				aadlElement = ((ComponentImplementation)relevantElement).getOwnedExtension();
			}
		} else if(type.equals("group_extension")) {
			if(relevantElement instanceof FeatureGroupType) {
				aadlElement = ((FeatureGroupType)relevantElement).getOwnedExtension();
			}
		} else {
			Log.error("Unhandled case: " + type);
		}

		// TODO: aadlElement should be a generatic object
		return aadlElement;
	}
	
	private String getNameForSerialization(final NamedElement ne) {
		return (ne == null || ne.getName() == null) ? "null" : ne.getName();
	}
	
	private String buildModeTransitionKey(final ModeTransition mt) {
		String result = "mode_transition ";
		result += mt.getContainingClassifier().getQualifiedName();
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
}
