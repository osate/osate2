package org.osate.xtext.aadl2.properties.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.Element;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;

public class MyQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public String getDelimiter() {
		return "::";
	}
	
	public QualifiedName qualifiedName(final PropertyType obj) {
		return getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final PropertySet obj) {
		return getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final Element obj) {
		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
	}

}
