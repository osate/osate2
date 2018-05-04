package org.osate.ui.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.Aadl2Package;

/**
 * Property tester for testing EObjectNodes and to test the EClass of the referenced EObject.
 * Tests that the EClass is a particular Aadl2 EClass or that the EClass has it as a super type.
 * The <code>value</code> attribute of the <code>test</code> element names EClass as found in the
 * <code>Aadl2Package</code> class.  The name <em>does not</em> include package prefix, e.g.,
 * just use <code>"ComponentImpementation"</code> or <code>"BusType"</code>.
 * @author aarong
 *
 */
public final class EObjectNodeAadlSuperTypePropertyTester extends PropertyTester {

	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if (receiver instanceof EObjectNode && property.equals("superType")) {
			if (expectedValue != null) {
				final EClassifier expectedClass = Aadl2Package.eINSTANCE.getEClassifier((String) expectedValue);
				final EClass receiverClass = ((EObjectNode) receiver).getEClass();
				return receiverClass.equals(expectedClass) || receiverClass.getEAllSuperTypes().contains(expectedClass);
			}
		}
		return false;
	}
}
