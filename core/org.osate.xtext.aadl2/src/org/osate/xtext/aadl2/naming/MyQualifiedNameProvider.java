package org.osate.xtext.aadl2.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;

public class MyQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public String getDelimiter() {
		return "::";
	}
	
	public QualifiedName qualifiedName(final Classifier obj) {
		return getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final Element obj) {
		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final AadlPackage obj) {
		return getConverter().toQualifiedName(obj.getQualifiedName());
	}

}
