package org.osate.aadl2.modelsupport.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;

public class EObjectURIWrapperPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof EObjectURIWrapper && property.equals("wrapperSuperType") && expectedValue instanceof String) {
			String expectedClassName = (String) expectedValue;
			EClassifier expectedClass = Aadl2Package.eINSTANCE.getEClassifier(expectedClassName);
			if (expectedClass == null) {
				expectedClass = InstancePackage.eINSTANCE.getEClassifier(expectedClassName);
			}
			if (expectedClass instanceof EClass) {
				return ((EClass) expectedClass).isSuperTypeOf(((EObjectURIWrapper) receiver).getEClass());
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}