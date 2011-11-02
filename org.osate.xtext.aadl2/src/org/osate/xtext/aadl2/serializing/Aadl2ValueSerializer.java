package org.osate.xtext.aadl2.serializing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;

public class Aadl2ValueSerializer extends ValueSerializer {
@Override
public String serializeUnassignedValue(EObject context, RuleCall ruleCall, INode node) {
	if (context instanceof ComponentType || context instanceof FeatureGroupType){
		return ((NamedElement)context).getName();
	}
	if (context instanceof AadlPackage){
		return ((NamedElement)context).getName();
	}
	if (context instanceof ComponentImplementation){
		return ((NamedElement)context).getName();
	}
	return "";
}

}
