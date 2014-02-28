/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.impl.IIndependenceSolver;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
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
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.ui.xtext.AgeXtextUtil;
import org.osate.ge.util.Log;
import org.osate.ge.util.StringUtil;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

// NOTE: There is an issue where there could be confusion over which element is being referenced. Qualified names are not always unique. Features and Component Implementations could conflict
// TODO: Expand check so that it ensures that the element being retrieved is of the expected type to reduce likelihood of problems if a reliable solutation can not be found.
public class IndependenceProvider implements IIndependenceSolver {
	private IFeatureProvider featureProvider;
	private boolean gettingDiagramObj = false; // Flag to indicate which code path to use. Needed because the independence provider needs to get the object for the diagram which would otherwise result in endless recursion
	
	public IndependenceProvider(final IFeatureProvider featureProvider) {
		this.featureProvider = featureProvider;
	}
	
	// TODO: Consider simplify naming scheme since in most cases, a qualified name is all that is needed
	@Override
	public String getKeyForBusinessObject(Object bo) {
		bo = AadlElementWrapper.unwrap(bo);
		if(bo != null) {
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
			} else if(bo instanceof FlowSpecification) {
				return "flow_specification " + ((FlowSpecification)bo).getQualifiedName();
			} else if(bo instanceof Connection) {
				return "connection " + ((Connection)bo).getQualifiedName();
			} else if(bo instanceof Mode) {
				return "mode " + ((Mode)bo).getQualifiedName();
			} else if(bo instanceof ModeTransition) {
				return "mode_transition " + ((ModeTransition)bo).getQualifiedName();
			} else {
				return null;
			}
		}
		
		return null;
	}
	
	// Returns the named element for a key from a diagram object
	private NamedElement getDiagramElement(final String key) {
		final String[] segs = key.split(" ");
		if(segs.length < 2) {
			return null;
		}
		
		final String name = segs[1];
		
		return (NamedElement)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
	}
	
	private AadlPackage getPackage() {
		final Diagram diagram = featureProvider.getDiagramTypeProvider().getDiagram();
		gettingDiagramObj = true;
		final NamedElement diagramElement = (NamedElement)featureProvider.getBusinessObjectForPictogramElement(diagram);
		gettingDiagramObj = false;
		
		if(diagramElement == null) {
			return null;
		}

		if(diagramElement instanceof AadlPackage) {
			return (AadlPackage)diagramElement;
		} else {
			final Element pkg = diagramElement.getNamespace().getOwner();
			if(pkg instanceof AadlPackage) {
				return (AadlPackage)pkg;
			}
		}
		
		return null;
	}
	@Override
	public Object getBusinessObjectForKey(String key) {	
		if(key == null) {
			return null;
		}

		// Check if we are trying to get the element corresponding to the diagram
		if(gettingDiagramObj) {
			return getDiagramElement(key);
		} else {
			final AadlPackage pkg = getPackage();
			if(pkg == null) {
				return null;
			}
			
			// Get the resource set
			final XtextResourceSet resourceSet = AgeXtextUtil.getResourceSetByQualifiedName(pkg.getQualifiedName());
			if(resourceSet == null) {
				return null;
			}
			
			final String[] segs = key.split(" ");
			if(segs.length < 2) {
				return null;
			}		
			
			Element aadlElement = null; // The AADL Element that is returned
			final String type = segs[0];
			final String qualifiedName = segs[1];
			final Element relevantElement = getNamedElementByQualifiedName(resourceSet, qualifiedName);
			
			switch(type) {
			case "package":
			case "classifier":
			case "subcomponent":
			case "feature":
			case "flow_specification":
			case "connection":
			case "mode":
			case "mode_transition":
				aadlElement = relevantElement;
				break;
			
			case "realization":
				if(relevantElement instanceof ComponentImplementation) {
					aadlElement = ((ComponentImplementation)relevantElement).getOwnedRealization();
				}	
				break;
				
			case "type_extension":
				if(relevantElement instanceof ComponentType) {
					aadlElement = ((ComponentType)relevantElement).getOwnedExtension();
				}
				break;
			
			case "implementation_extension":
				if(relevantElement instanceof ComponentImplementation) {
					aadlElement = ((ComponentImplementation)relevantElement).getOwnedExtension();
				}
				break;
				
			case "group_extension":
				if(relevantElement instanceof FeatureGroupType) {
					aadlElement = ((FeatureGroupType)relevantElement).getOwnedExtension();
				}
				break;
				
			default:
				Log.error("Unhandled case: " + type);
			}
	
			return aadlElement == null ? null : new AadlElementWrapper(aadlElement);
		}
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
