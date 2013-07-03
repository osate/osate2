package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.features.impl.IIndependenceSolver;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

import edu.uah.rsesc.aadl.age.xtext.AgeXtextUtil;

public class IndependenceProvider implements IIndependenceSolver {
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
			} else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public Object getBusinessObjectForKey(String key) {
		if(key == null) {
			return null;
		}
		
		final String[] segs = key.split(" ");
		if(segs.length < 2) {
			return null;
		}		
		
		Element aadlElement = null;
		final String type = segs[0];
		final String name = segs[1];
		Element classifier;
		switch(type) {
		case "package":
		case "classifier":
			aadlElement = (Element)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
			break;

		case "realization":
			classifier = (Element)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
			if(classifier instanceof ComponentImplementation) {
				aadlElement = ((ComponentImplementation)classifier).getOwnedRealization();
			}	
			break;
			
		case "type_extension":
			classifier = (Element)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
			if(classifier instanceof ComponentType) {
				aadlElement = ((ComponentType)classifier).getOwnedExtension();
			}
			break;
		
		case "implementation_extension":
			classifier = (Element)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
			if(classifier instanceof ComponentImplementation) {
				aadlElement = ((ComponentImplementation)classifier).getOwnedExtension();
			}
			break;
			
		case "group_extension":
			classifier = (Element)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
			if(classifier instanceof FeatureGroupType) {
				aadlElement = ((FeatureGroupType)classifier).getOwnedExtension();
			}
			break;
		}

		return aadlElement == null ? null : new AadlElementWrapper(aadlElement);
	}
}
