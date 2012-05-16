package org.osate.xtext.aadl2.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.UnitLiteral;

public class Aadl2QualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public String getDelimiter() {
		return "::";
	}

	// Enable to limit indexing to global items
	// Duplicates checking only applies to global items
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		if (obj instanceof AadlPackage || obj instanceof Classifier
				|| obj instanceof PropertyConstant || obj instanceof Property || obj instanceof PropertySet || obj instanceof PropertyType)
			return super.getFullyQualifiedName(obj);
	   return null;
	}
	
	public QualifiedName qualifiedName(final Classifier obj) {
		if (obj.getOwner() instanceof PrivatePackageSection) return null;
		return getConverter().toQualifiedName(getTheName(obj));
	}
	
	public QualifiedName qualifiedName(final Element obj) {
		return null;
		//getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final NamedElement obj) {
		//		return getConverter().toQualifiedName(obj.getName());
		return getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final BasicProperty obj) {
		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final UnitLiteral obj) {
		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final EnumerationLiteral obj) {
		return null;//getConverter().toQualifiedName(obj.getQualifiedName());
	}
	
	public QualifiedName qualifiedName(final AadlPackage obj) {
		return getConverter().toQualifiedName(obj.getName());
	}
	
	public QualifiedName qualifiedName(final PackageSection obj) {
		return null;
		//return getConverter().toQualifiedName(obj.getQualifiedName());
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
			if (namedElement.hasName()) {
				Namespace namespace = namedElement.getNamespace();
				if (namespace != null ) {
					if (namespace instanceof PropertySet && namespace.hasName())
						return namespace.getName() + "::" + namedElement.getName();
					else if (namespace instanceof PackageSection && ((AadlPackage)namespace.getOwner()).hasName())
						return ((AadlPackage)namespace.getOwner()).getName() + "::" + namedElement.getName();
					else
						return namedElement.getName();
				} else
					return namedElement.getName();
			} else
				return null;
	}


}
