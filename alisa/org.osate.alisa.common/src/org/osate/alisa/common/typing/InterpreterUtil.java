/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.alisa.common.typing;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.alisa.common.common.AModelReference;
import org.osate.pluginsupport.ExecuteJavaUtil;

public class InterpreterUtil {

	public static UnitLiteral smallerUnit(UnitLiteral unit1, UnitLiteral unit2) {
		if (unit1 == null || unit2 == null) {
			return null;
		} else if (unit1 == unit2) {
			return unit1;
		} else {
			RealLiteral tester = Aadl2Factory.eINSTANCE.createRealLiteral();
			tester.setValue(1.0);
			tester.setUnit(unit1);
			if (tester.getScaledValue(unit2) < 1.0) {
				return unit1;
			} else {
				return unit2;
			}
		}
	}

	public static int compareTo(NumberValue v1, NumberValue v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			Long s1 = (v1.getUnit() == null) ? ((IntegerLiteral) v1).getValue()
					: Math.round(v1.getScaledValue(minUnit));
			Long s2 = (v2.getUnit() == null) ? ((IntegerLiteral) v2).getValue()
					: Math.round(v2.getScaledValue(minUnit));
			return s1.compareTo(s2);
		} else {
			Double s1 = (v1.getUnit() == null)
					? (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue() : ((RealLiteral) v1).getValue()
					: v1.getScaledValue(minUnit);
			Double s2 = (v2.getUnit() == null)
					? (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue() : ((RealLiteral) v2).getValue()
					: v2.getScaledValue(minUnit);
			return s1.compareTo(s2);
		}
	}

	public static NumberValue add(NumberValue v1, NumberValue v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			long s1 = (v1.getUnit() == null) ? ((IntegerLiteral) v1).getValue()
					: Math.round(v1.getScaledValue(minUnit));
			long s2 = (v2.getUnit() == null) ? ((IntegerLiteral) v2).getValue()
					: Math.round(v2.getScaledValue(minUnit));
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(s1 + s2);
			result.setUnit(minUnit);
			return result;
		} else {
			double s1 = (v1.getUnit() == null)
					? (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue() : ((RealLiteral) v1).getValue()
					: v1.getScaledValue(minUnit);
			double s2 = (v2.getUnit() == null)
					? (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue() : ((RealLiteral) v2).getValue()
					: v2.getScaledValue(minUnit);
			RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
			result.setValue(s1 + s2);
			result.setUnit(minUnit);
			return result;
		}
	}

	public static NumberValue subtract(NumberValue v1, NumberValue v2) {
		if (v2 instanceof IntegerLiteral) {
			IntegerLiteral neg = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			neg.setValue(-((IntegerLiteral) v2).getValue());
			neg.setUnit(v2.getUnit());
			return add(v1, neg);
		} else {
			RealLiteral neg = Aadl2Factory.eINSTANCE.createRealLiteral();
			neg.setValue(-((RealLiteral) v2).getValue());
			neg.setUnit(v2.getUnit());
			return add(v1, neg);
		}
	}

	public static NumberValue multiply(NumberValue v1, NumberValue v2) {
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			long s1 = ((IntegerLiteral) v1).getValue();
			long s2 = ((IntegerLiteral) v2).getValue();
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(s1 * s2);
			result.setUnit(unit);
			return result;
		} else {
			double s1 = (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue()
					: ((RealLiteral) v1).getValue();
			double s2 = (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue()
					: ((RealLiteral) v2).getValue();
			RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
			result.setValue(s1 * s2);
			result.setUnit(unit);
			return result;
		}
	}

	public static NumberValue divide(NumberValue v1, NumberValue v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		boolean twoUnits = v1.getUnit() != null && v2.getUnit() != null;
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();

		double s1 = (!twoUnits)
				? (v1 instanceof IntegerLiteral) ? ((IntegerLiteral) v1).getValue() : ((RealLiteral) v1).getValue()
				: v1.getScaledValue(minUnit);
		double s2 = (!twoUnits)
				? (v2 instanceof IntegerLiteral) ? ((IntegerLiteral) v2).getValue() : ((RealLiteral) v2).getValue()
				: v2.getScaledValue(minUnit);
		RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
		result.setValue(s1 / s2);
		result.setUnit(twoUnits ? null : unit);
		return result;
	}

	public static NumberValue divideInt(IntegerLiteral v1, IntegerLiteral v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		boolean twoUnits = v1.getUnit() != null && v2.getUnit() != null;
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();

		long s1 = (!twoUnits) ? v1.getValue() : Math.round(v1.getScaledValue(minUnit));
		long s2 = (!twoUnits) ? v2.getValue() : Math.round(v2.getScaledValue(minUnit));
		IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		result.setValue(s1 / s2);
		result.setUnit(twoUnits ? minUnit : unit);
		return result;
	}

	public static NumberValue mod(IntegerLiteral v1, IntegerLiteral v2) {
		UnitLiteral minUnit = smallerUnit(v1.getUnit(), v2.getUnit());
		boolean twoUnits = v1.getUnit() != null && v2.getUnit() != null;
		UnitLiteral unit = (v1.getUnit() != null) ? v1.getUnit() : v2.getUnit();

		long s1 = (!twoUnits) ? v1.getValue() : Math.round(v1.getScaledValue(minUnit));
		long s2 = (!twoUnits) ? v2.getValue() : Math.round(v2.getScaledValue(minUnit));
		IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		result.setValue(s1 % s2);
		result.setUnit(twoUnits ? minUnit : unit);
		return result;
	}

	public static NumberValue min(Collection<NumberValue> nvals) {
		Iterator<NumberValue> it = nvals.iterator();
		NumberValue result = it.next();
		while (it.hasNext()) {
			NumberValue nv = it.next();
			if (compareTo(nv, result) < 0) {
				result = nv;
			}
		}
		return result;
	}

	public static NumberValue max(Collection<NumberValue> nvals) {
		Iterator<NumberValue> it = nvals.iterator();
		NumberValue result = it.next();
		while (it.hasNext()) {
			NumberValue nv = it.next();
			if (compareTo(nv, result) > 0) {
				result = nv;
			}
		}
		return result;
	}

	public static IntegerLiteral round(NumberValue nv) {
		if (nv instanceof RealLiteral) {
			long iv = Math.round(((RealLiteral) nv).getValue());
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(iv);
			result.setUnit(nv.getUnit());
			return result;
		} else {
			return (IntegerLiteral) nv;
		}
	}

	public static IntegerLiteral floor(NumberValue nv) {
		if (nv instanceof RealLiteral) {
			long iv = new Double(Math.floor(((RealLiteral) nv).getValue())).longValue(); // (new Double(d)).longValue()
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(iv);
			result.setUnit(nv.getUnit());
			return result;
		} else {
			return (IntegerLiteral) nv;
		}
	}

	public static IntegerLiteral ceil(NumberValue nv) {
		if (nv instanceof RealLiteral) {
			long iv = new Double(Math.ceil(((RealLiteral) nv).getValue())).longValue();
			IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			result.setValue(iv);
			result.setUnit(nv.getUnit());
			return result;
		} else {
			return (IntegerLiteral) nv;
		}
	}

	/**
	 * Resolve a model element reference relative to an instance object
	 */
	static InstanceObject resolve(AModelReference ref, NamedElement root) {
		if (!(root instanceof InstanceObject)) {
			return null;
		}
		if (ref.getPrev() == null) {
			return (InstanceObject) root;
		} else {
			InstanceObject io = resolve(ref.getPrev(), root);
			EObject result = io.eContents().stream()
					.filter(it -> (it instanceof InstanceObject)
							? ((InstanceObject) it).getName().equalsIgnoreCase(ref.getModelElement().getName()) : false)
					.findFirst().get();
			return (InstanceObject) result;
		}
	}

	public static InterpreterUtil instance = new InterpreterUtil();

	// Method returns null if Java class was found.
	// Otherwise it returns an error message
	public String methodExists(final String javaMethod) {
		Method m = ExecuteJavaUtil.getJavaMethod(javaMethod);
		if (m != null) {
			return null;
		} else {
			return "Java method " + javaMethod + " not found.";
		}
	}

}