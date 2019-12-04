package org.osate.xtext.aadl2.findReferences;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;

public class Aadl2TargetURICollector extends TargetURICollector {

	@Override
	protected void doAdd(EObject object, TargetURIs targetURIs) {
		super.doAdd(object, targetURIs);

		if (object instanceof ComponentType) {
			AadlPackage pkg = EcoreUtil2.getContainerOfType(object, AadlPackage.class);
			for (ComponentImplementation impl : EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class)) {
				if (impl.getType() == object) {
					super.doAdd(impl, targetURIs);
				}
			}
		} else if (object instanceof AadlPackage) {
			for (Classifier cl : EcoreUtil2.getAllContentsOfType(object, Classifier.class)) {
				super.doAdd(cl, targetURIs);
			}
		} else if (object instanceof PropertySet) {
			for (PropertyType p : EcoreUtil2.getAllContentsOfType(object, PropertyType.class)) {
				super.doAdd(p, targetURIs);
			}
			for (PropertyConstant p : EcoreUtil2.getAllContentsOfType(object, PropertyConstant.class)) {
				super.doAdd(p, targetURIs);
			}
			for (Property p : EcoreUtil2.getAllContentsOfType(object, Property.class)) {
				super.doAdd(p, targetURIs);
			}
		}
	}

}
