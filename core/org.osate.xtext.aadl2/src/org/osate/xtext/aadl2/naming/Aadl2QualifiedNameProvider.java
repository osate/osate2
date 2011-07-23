package org.osate.xtext.aadl2.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.UnitLiteral;

public class Aadl2QualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public String getDelimiter() {
		return "::";
	}
	
	public QualifiedName qualifiedName(final Classifier obj) {
		return getConverter().toQualifiedName(getTheName(obj));
	}
	
	public QualifiedName qualifiedName(final Element obj) {
		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
	}
//	
//	public QualifiedName qualifiedName(final NamedElement obj) {
//		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
//	}
//	
//	public QualifiedName qualifiedName(final UnitLiteral obj) {
//		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
//	}
	
	public QualifiedName qualifiedName(final AadlPackage obj) {
		return getConverter().toQualifiedName(obj.getName());
	}
	
	public QualifiedName qualifiedName(final PropertyType obj) {
		return getConverter().toQualifiedName(getTheName(obj));
	}
	
	public QualifiedName qualifiedName(final PropertyConstant obj) {
		return getConverter().toQualifiedName(getTheName(obj));
	}
	
	public QualifiedName qualifiedName(final Property obj) {
		return getConverter().toQualifiedName(getTheName(obj));
	}
	
	public QualifiedName qualifiedName(final PropertySet obj) {
		return getConverter().toQualifiedName(obj.getName());
	}
	
	protected String getTheName(NamedElement namedElement){
		Namespace namespace = namedElement.getNamespace();
		if (namespace != null && namespace.hasName()) {
			if (namespace instanceof PackageSection || namespace instanceof PropertySet)
				return namespace.getName() + "::" + namedElement.getName();
		}
		return namedElement.getName();
	}


}
