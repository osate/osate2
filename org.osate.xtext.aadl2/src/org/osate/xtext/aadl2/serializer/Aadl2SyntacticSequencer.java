package org.osate.xtext.aadl2.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;

public class Aadl2SyntacticSequencer extends AbstractAadl2SyntacticSequencer {

	@Override
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (semanticObject instanceof Classifier)
			return ((Classifier)semanticObject).getName();
		if(semanticObject instanceof AadlPackage)
			return ((AadlPackage)semanticObject).getName();
		return super.getIDToken(semanticObject, ruleCall, node);
	}
	
	@Override
	protected String getFULLINAMEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (semanticObject instanceof ComponentImplementation)
 			return ((ComponentImplementation)semanticObject).getName();
		return super.getFULLINAMEToken(semanticObject, ruleCall, node);
	}

}
