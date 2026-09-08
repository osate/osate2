/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.verify.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.alisa.common.common.ModelRef;
import org.osate.alisa.common.common.PropertyRef;
import org.osate.alisa.common.common.TargetType;
import org.osate.alisa.common.common.TypeRef;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.JavaParameter;
import org.osate.verify.verify.VerificationMethod;

/**
 * @since 4.0
 */
public class VerifyJavaUtil {
	// Invoke a Java method by first converting the actual parameters of a verification activity to a basic Java format
	// for the reflective call.
	public static List<Object> getActualJavaObjects(final JavaMethod verificationMethod, final InstanceObject target,
			final List<PropertyExpression> parameters) {
		var formalParameters = ((VerificationMethod) verificationMethod.eContainer()).getFormals();
		var objects = new ArrayList<Object>();
		objects.add(target);
		var formalIterator = formalParameters.iterator();
		for (var actual : parameters) {
			objects.add(toJavaActual(formalIterator.next(), actual, verificationMethod));
		}
		return objects;
	}

	/**
	 * Create list of Java objects as parameters to be used.
	 */
	public static List<Object> getActualJavaObjects(final EList<FormalParameter> formalParameters,
			final InstanceObject target, final List<PropertyExpression> parameters) {
		var objects = new ArrayList<Object>();
		objects.add(target);
		var formalIterator = formalParameters.iterator();
		for (var actual : parameters) {
			objects.add(convertActualToJavaObject(formalIterator.next(), actual));
		}
		return objects;
	}

	/**
	 * Returns the Java classes for the target and formal parameters.
	 */
	public static ArrayList<Class<?>> getParameterClasses(final JavaMethod verificationMethod) {
		var method = (VerificationMethod) verificationMethod.eContainer();
		var classes = new ArrayList<Class<?>>();
		classes.add(classForTargetType(method));
		for (var parameter : method.getFormals()) {
			classes.add(classForParameter(parameter, verificationMethod));
		}
		return classes;
	}

	private static Class<?> classForTargetType(final VerificationMethod verificationMethod) {
		var targetType = verificationMethod.getTargetType();
		if (targetType == null) {
			return null;
		}
		return switch (targetType) {
		case FEATURE -> FeatureInstance.class;
		case COMPONENT -> ComponentInstance.class;
		case CONNECTION -> ConnectionInstance.class;
		case ELEMENT -> InstanceObject.class;
		case FLOW -> EndToEndFlowInstance.class;
		case MODE -> ModeInstance.class;
		case ROOT -> SystemInstance.class;
		default -> null;
		};
	}

	private static Class<?> classForParameter(final FormalParameter formalParameter,
			final JavaMethod verificationMethod) {
		try {
			for (var javaParameter : verificationMethod.getParams()) {
				if (formalParameter.getName().equalsIgnoreCase(javaParameter.getName())) {
					return forName(javaParameter.getParameterType());
				}
			}

			return switch (formalParameter.getType()) {
			case AadlString ignored -> String.class;
			case NumberType numberType -> classForNumberType(numberType, formalParameter.getUnit());
			case AadlBoolean ignored -> Boolean.class;
			case ModelRef ignored -> EObject.class;
			case TypeRef typeReference -> {
				var propertyType = typeReference.getRef();
				yield propertyType instanceof NumberType numberType
						? classForNumberType(numberType, formalParameter.getUnit())
						: propertyType.getClass();
			}
			case PropertyRef propertyReference -> {
				var propertyType = propertyReference.getRef().getPropertyType();
				yield propertyType instanceof NumberType numberType
						? classForNumberType(numberType, formalParameter.getUnit())
						: propertyType.getClass();
			}
			case null, default -> null;
			};
		} catch (ClassNotFoundException exception) {
			return sneakyThrow(exception);
		}
	}

	private static Class<?> classForNumberType(final PropertyType type, final UnitLiteral unit) {
		return switch (type) {
		case AadlReal ignored -> unit == null ? RealLiteral.class : double.class;
		case AadlInteger ignored -> unit == null ? IntegerLiteral.class : long.class;
		default -> null;
		};
	}

	/**
	 * Return the Java class for the class name specified by a Java parameter.
	 */
	private static Class<?> forName(final String name) throws ClassNotFoundException {
		if (Objects.equals(name, void.class.getName())) {
			return void.class;
		}
		if (Objects.equals(name, boolean.class.getName())) {
			return boolean.class;
		}
		if (Objects.equals(name, byte.class.getName())) {
			return byte.class;
		}
		if (Objects.equals(name, char.class.getName())) {
			return char.class;
		}
		if (Objects.equals(name, short.class.getName())) {
			return short.class;
		}
		if (Objects.equals(name, int.class.getName())) {
			return int.class;
		}
		if (Objects.equals(name, float.class.getName())) {
			return float.class;
		}
		if (Objects.equals(name, long.class.getName())) {
			return long.class;
		}
		if (Objects.equals(name, double.class.getName())) {
			return double.class;
		}
		if (Objects.equals(name, String.class.getName())) {
			return String.class;
		}
		if (Objects.equals(name, "Double")) {
			return Double.class;
		}
		if (Objects.equals(name, "Long")) {
			return Long.class;
		}
		if (Objects.equals(name, AadlReal.class.getName())) {
			return RealLiteral.class;
		}
		if (Objects.equals(name, AadlInteger.class.getName())) {
			return IntegerLiteral.class;
		}
		if (Objects.equals(name, AadlBoolean.class.getName())) {
			return BooleanLiteral.class;
		}

		var classifier = Aadl2Package.eINSTANCE.getEClassifier(name);
		if (classifier == null) {
			// Preserve the existing lookup side effect. The original implementation did not assign this result.
			InstancePackage.eINSTANCE.getEClassifier(name);
		}
		if (classifier != null) {
			return classifier.getInstanceClass();
		}
		return Class.forName(name);
	}

	private static Object toJavaActual(final FormalParameter formalParameter, final PropertyExpression actual,
			final JavaMethod verificationMethod) {
		for (var javaParameter : verificationMethod.getParams()) {
			if (formalParameter.getName().equalsIgnoreCase(javaParameter.getName())) {
				return convertToJavaObject(javaParameter, actual);
			}
		}
		return convertActualToJavaObject(formalParameter, actual);
	}

	/**
	 * Convert the AADL property representation of a string, boolean, integer, or real to a Java object.
	 */
	private static Object convertActualToJavaObject(final FormalParameter formalParameter,
			final PropertyExpression actual) {
		return switch (actual) {
		case RealLiteral realLiteral when formalParameter.getUnit() != null -> realLiteral.getValue();
		case IntegerLiteral integerLiteral when formalParameter.getUnit() != null -> integerLiteral.getValue();
		case StringLiteral stringLiteral -> stringLiteral.getValue();
		case BooleanLiteral booleanLiteral -> booleanLiteral.isValue();
		case null, default -> actual;
		};
	}

	/**
	 * Convert the AADL property representation of a string, boolean, integer, or real according to a Java parameter
	 * specification.
	 */
	private static Object convertToJavaObject(final JavaParameter formalParameter, final PropertyExpression actual) {
		return switch (actual) {
		case RealLiteral realLiteral
				when formalParameter.getParameterType().equalsIgnoreCase("double")
						|| formalParameter.getParameterType().equalsIgnoreCase("real") ->
			realLiteral.getValue();
		case IntegerLiteral integerLiteral when formalParameter.getParameterType().equalsIgnoreCase("long") ->
			integerLiteral.getValue();
		case IntegerLiteral integerLiteral when formalParameter.getParameterType().equalsIgnoreCase("int") ->
			Long.valueOf(integerLiteral.getValue()).intValue();
		case StringLiteral stringLiteral when formalParameter.getParameterType().equalsIgnoreCase("string") ->
			stringLiteral.getValue();
		case BooleanLiteral booleanLiteral when formalParameter.getParameterType().equalsIgnoreCase("boolean") ->
			booleanLiteral.isValue();
		case null, default -> actual;
		};
	}

	@SuppressWarnings("unchecked")
	private static <T, E extends Throwable> T sneakyThrow(final Throwable throwable) throws E {
		throw (E) throwable;
	}
}
