package org.osate.xtext.aadl2.instance.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.util.AadlUtil;

public class InstanceQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {


		// Enable to limit indexing to global items
		@Override
		public QualifiedName getFullyQualifiedName(final EObject obj) {
			if (!(obj instanceof NamedElement)) {
				return null;
			}
			if (obj instanceof AadlPackage || obj instanceof Classifier || obj instanceof PropertyConstant
					|| obj instanceof Property || obj instanceof PropertySet || obj instanceof PropertyType ||
					// DB: We also want a qualified name for package sections
					obj instanceof PackageSection) {
				if (((NamedElement) obj).getName() == null) {
					return null;
				}
				return getConverter().toQualifiedName(getTheName((NamedElement) obj));
			}
			return super.getFullyQualifiedName(obj);
		}

		protected String getTheName(NamedElement namedElement) {
			if (namedElement.getName() != null) {
				Namespace namespace = namedElement.getNamespace();
				if (namespace != null) {
					if (namespace instanceof PropertySet && namespace.hasName()) {
						return namespace.getName() + "::" + namedElement.getName();
					} else if (namespace instanceof PackageSection && ((AadlPackage) namespace.getOwner()).hasName()) {
						return ((AadlPackage) namespace.getOwner()).getName() + "::" + namedElement.getName();
					} else {
						return namedElement.getName();
					}
				} else {
					return namedElement.getName();
				}
			} else {
				return "<noname>";
			}
		}

		public String getDelimiter() {
			return "::";
		}
}
