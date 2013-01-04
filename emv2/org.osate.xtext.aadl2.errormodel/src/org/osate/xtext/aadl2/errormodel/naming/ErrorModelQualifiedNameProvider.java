package org.osate.xtext.aadl2.errormodel.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

public class ErrorModelQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public String getDelimiter() {
		return "::";
	}
	// Enable to limit indexing to global items
	// Duplicates checking only applies to global items
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		if (!(obj instanceof NamedElement) ) return null;
		if (((NamedElement)obj).getName() == null) 
			return null;
		if (obj instanceof AadlPackage){
			return getConverter().toQualifiedName(((AadlPackage) obj).getName());
		}
		if (obj instanceof ErrorBehaviorStateMachine || obj instanceof TypeMappingSet || obj instanceof ErrorModelLibrary
				|| obj instanceof ErrorType || obj instanceof TypeSet || obj instanceof TypeTransformationSet){
			return getConverter().toQualifiedName(getTheName((NamedElement)obj));
		}
	   return null;
	}
	
	protected String getTheName(NamedElement namedElement){
		NamedElement root = namedElement.getElementRoot();
		if (namedElement instanceof ErrorModelLibrary){
			return root.getName() + "::"+"emv2";
		} 
		return root.getName() + "::emv2::" + namedElement.getName();
	}


}
