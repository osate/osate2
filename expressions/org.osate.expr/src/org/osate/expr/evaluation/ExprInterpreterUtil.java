package org.osate.expr.evaluation;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.expr.expr.EIntegerLiteral;
import org.osate.expr.expr.ERealLiteral;
import org.osate.expr.expr.ExprFactory;
import org.osate.expr.expr.NamedElementRef;
import org.osate.expr.expr.NumberLiteral;

class ExprInterpreterUtil {

	static int compareTo(NumberLiteral v1, NumberLiteral v2) {
		if (v1 instanceof EIntegerLiteral && v2 instanceof EIntegerLiteral) {
			Long s1 = ((EIntegerLiteral) v1).getValue();
			Long s2 = ((EIntegerLiteral) v2).getValue();
			return s1.compareTo(s2);
		} else {
			Double s1 = (v1 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v1).getValue()
					: ((ERealLiteral) v1).getValue();
			Double s2 = (v2 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v2).getValue()
					: ((ERealLiteral) v2).getValue();
			return s1.compareTo(s2);
		}
	}

	static NumberLiteral add(NumberLiteral v1, NumberLiteral v2) {
		if (v1 instanceof EIntegerLiteral && v2 instanceof EIntegerLiteral) {
			long s1 = ((EIntegerLiteral) v1).getValue();
			long s2 = ((EIntegerLiteral) v2).getValue();
			EIntegerLiteral result = ExprFactory.eINSTANCE.createEIntegerLiteral();
			result.setValue(s1 + s2);
			return result;
		} else {
			double s1 = (v1 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v1).getValue()
					: ((ERealLiteral) v1).getValue();
			double s2 = (v2 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v2).getValue()
					: ((ERealLiteral) v2).getValue();
			ERealLiteral result = ExprFactory.eINSTANCE.createERealLiteral();
			result.setValue(s1 + s2);
			return result;
		}
	}

	static NumberLiteral subtract(NumberLiteral v1, NumberLiteral v2) {
		if (v2 instanceof EIntegerLiteral) {
			EIntegerLiteral neg = ExprFactory.eINSTANCE.createEIntegerLiteral();
			neg.setValue(-((EIntegerLiteral) v2).getValue());
			return add(v1, neg);
		} else {
			ERealLiteral neg = ExprFactory.eINSTANCE.createERealLiteral();
			neg.setValue(-((ERealLiteral) v2).getValue());
			return add(v1, neg);
		}
	}

	static NumberLiteral multiply(NumberLiteral v1, NumberLiteral v2) {
		if (v1 instanceof EIntegerLiteral && v2 instanceof EIntegerLiteral) {
			long s1 = ((EIntegerLiteral) v1).getValue();
			long s2 = ((EIntegerLiteral) v1).getValue();
			EIntegerLiteral result = ExprFactory.eINSTANCE.createEIntegerLiteral();
			result.setValue(s1 * s2);
			return result;
		} else {
			double s1 = (v1 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v1).getValue()
					: ((ERealLiteral) v1).getValue();
			double s2 = (v2 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v2).getValue()
					: ((ERealLiteral) v2).getValue();
			ERealLiteral result = ExprFactory.eINSTANCE.createERealLiteral();
			result.setValue(s1 * s2);
			return result;
		}
	}

	static NumberLiteral divide(NumberLiteral v1, NumberLiteral v2) {
		double s1 = (v1 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v1).getValue()
				: ((ERealLiteral) v1).getValue();
		double s2 = (v2 instanceof EIntegerLiteral) ? ((EIntegerLiteral) v2).getValue()
				: ((ERealLiteral) v2).getValue();
		ERealLiteral result = ExprFactory.eINSTANCE.createERealLiteral();
		result.setValue(s1 / s2);
		return result;
	}

	static NumberLiteral divideInt(EIntegerLiteral v1, EIntegerLiteral v2) {
		long s1 = v1.getValue();
		long s2 = v2.getValue();
		EIntegerLiteral result = ExprFactory.eINSTANCE.createEIntegerLiteral();
		result.setValue(s1 / s2);
		return result;
	}

	static NumberLiteral mod(EIntegerLiteral v1, EIntegerLiteral v2) {
		long s1 = v1.getValue();
		long s2 = v2.getValue();
		EIntegerLiteral result = ExprFactory.eINSTANCE.createEIntegerLiteral();
		result.setValue(s1 % s2);
		return result;
	}

	/**
	 * Resolve a model element reference relative to an instance object
	 */
	static InstanceObject resolve(NamedElementRef ner, InstanceObject root) {
		if (ner.getPrev() == null) {
			return root;
		} else {
			InstanceObject io = resolve(ner.getPrev(), root);
			EObject result = io.eContents().stream()
					.filter(it -> (it instanceof InstanceObject)
							? ((InstanceObject) it).getName().equalsIgnoreCase(ner.getRef().getName())
							: false)
					.findFirst().get();
			return (InstanceObject) result;
		}
	}

//	public static InterpreterUtil instance = new InterpreterUtil();

	// Method returns null if Java class was found.
	// Otherwise it returns an error message
//	public String methodExists(final String javaMethod) {
//		Method m = ExecuteJavaUtil.eInstance.getJavaMethod(javaMethod);
//		if (m != null) {
//			return null;
//		} else {
//			return "Java method " + javaMethod + " not found.";
//		}
//	}

}