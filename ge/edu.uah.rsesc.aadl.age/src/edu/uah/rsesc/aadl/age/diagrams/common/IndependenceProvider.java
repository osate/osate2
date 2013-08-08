package edu.uah.rsesc.aadl.age.diagrams.common;

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
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

import edu.uah.rsesc.aadl.age.ui.xtext.AgeXtextUtil;
import edu.uah.rsesc.aadl.age.util.Log;

// NOTE: There is an issue where there could be confusion over which element is being referenced. Qualified names are not always unique. Features and Component Implementations could conflict
// TODO: Expand check so that it ensures that the element being retrieved is of the expected type to reduce likelihood of problems if a reliable solutation can not be found.
class IndependenceProvider implements IIndependenceSolver {
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
			case "feature":
			case "flow_specification":
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
		final String[] segs = qualifiedName.split("::");
		final String pkgName = segs[0];
		
		// Find the package
		final AadlPackage pkg = getPackage(resourceSet, pkgName);
		if(pkg == null) {
			return null;
		}
		
		if(segs.length == 1) { 
			return pkg;
		}
		
		// Check the public section first then the private
		final String path = segs[1];
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
		if(element instanceof Namespace) {
			for(final NamedElement member : ((Namespace)element).getMembers()) {
				if(member.getName().equalsIgnoreCase(seg)) {
					NamedElement result = findNamedElement(member, pathSegs, i+1);
					if(result != null) {
						return result;
					}
				} 
				
				// Handle Component Implementations
				if(((i+1) < pathSegs.length) && member.getName().contains(".")) {
					if(member.getName().equalsIgnoreCase(pathSegs[i] + "." + pathSegs[i+1])) {
						NamedElement result = findNamedElement(member, pathSegs, i+2);
						if(result != null) {
							return result;
						}
					}
				}
			}
		}			
		
		return null;
	}
	
	private AadlPackage getPackage(final XtextResourceSet resourceSet, final String name) {
		// Look for the resource that contains the package
		for(final Resource resource : resourceSet.getResources()) {
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
