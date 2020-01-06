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
package org.osate.verify.util

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.NumberType
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.EndToEndFlowInstance
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.InstancePackage
import org.osate.aadl2.instance.ModeInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.alisa.common.common.ModelRef
import org.osate.alisa.common.common.PropertyRef
import org.osate.alisa.common.common.TargetType
import org.osate.alisa.common.common.TypeRef
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.JavaParameter
import org.osate.verify.verify.VerificationMethod

class VerifyJavaUtil {

		// invoke Java method by first converting the actual parameters of a verification activity to a basic Java format for reflective call
		static def List<Object> getActualJavaObjects(JavaMethod vm, InstanceObject target, List<PropertyExpression> parameters) {
			val EList<FormalParameter> formalparameters = (vm.eContainer as VerificationMethod).formals
			val objects = new ArrayList()
			objects.add(target)
			val fpiter = formalparameters.iterator
			for (o : parameters) {
				val fp = fpiter.next
				objects.add(toJavaActual(fp, o, vm))
			}
			objects
		}
		
		/**
		 * Create list of Java objects as parameters to be used
		 */
		static def List<Object> getActualJavaObjects(EList<FormalParameter> formalparameters, InstanceObject target, List<PropertyExpression> parameters) {
			val objects = new ArrayList()
			objects.add(target)
			val fpiter = formalparameters.iterator
			for (actual : parameters) {
				val fp = fpiter.next
				objects.add(convertActualToJavaObject(fp, actual))
			}
			objects
		}

		/*
		 * returns collection of Java classes for parameters
		 */
		static def ArrayList<Class<?>>  getParameterClasses(JavaMethod vm) {
			val EList<FormalParameter> parameters = (vm.eContainer as VerificationMethod).formals
			val newClasses = newArrayList()
			newClasses.add(classForTargetType((vm.eContainer as VerificationMethod)))
			for (par : parameters) {
				val cl = classForParameter(par, vm);
				newClasses.add(cl);
			}
			newClasses
		}

		/*
		 * return Java class for target type
		 */
		private static def Class<?> classForTargetType(VerificationMethod vm) {
			switch (vm.targetType) {
				case TargetType.FEATURE:
					typeof(FeatureInstance)
				case COMPONENT: {
					typeof(ComponentInstance)
				}
				case CONNECTION: {
					typeof(ConnectionInstance)
				}
				case ELEMENT: {
					typeof(InstanceObject)
				}
				case FLOW: {
					typeof(EndToEndFlowInstance)
				}
				case MODE: {
					typeof(ModeInstance)
				}
				case ROOT: {
					typeof(SystemInstance)
				}
			}
		}

		private static def Class<?> classForParameter(FormalParameter fp, JavaMethod vm) {
			val jparameters = vm.params
			for (jp : jparameters) {
				if (fp.name.equalsIgnoreCase(jp.name)) {
					return forName(jp.parameterType)
				}
			}
			val type = fp.type
			switch (type) {
				AadlString: return typeof(String)
				NumberType: { 
					classForNumberType(type,fp.unit)
					}
				AadlBoolean: return typeof(Boolean)
				ModelRef: return typeof(EObject)
				TypeRef: {
					val pt = type.ref
					if (pt instanceof NumberType){
						return classForNumberType(pt,fp.unit)
					}
					return pt.class
				}
				PropertyRef: {
					val pt = type.ref.propertyType
					if (pt instanceof NumberType){
						return classForNumberType(pt,fp.unit)
					}
					return pt.class
				}
			}
		}
		
		private static def Class<?> classForNumberType(PropertyType type, UnitLiteral inUnit){
						switch (type) {
				AadlReal: { 
					if (inUnit === null){
						return typeof(RealLiteral)
					} else {
						return typeof(double)
					}
				}
				AadlInteger: {
					if (inUnit === null){
						return typeof(IntegerLiteral)
					} else {
						return typeof(long)
					}
				}
			}
			
		}

		/**
		 * return Java Class for class specified by name in JavaParameter
		 */
		private static def Class<?> forName(String name) throws ClassNotFoundException {
			switch (name) {
				case void.name:
					return typeof(void)
				case boolean.name:
					return typeof(boolean)
				case byte.name:
					return typeof(byte)
				case char.name:
					return typeof(char)
				case short.name:
					return typeof(short)
				case int.name:
					return typeof(int)
				case float.name:
					return typeof(float)
				case long.name:
					return typeof(long)
				case double.name:
					return typeof(double)
				case String.name:
					return typeof(String)
				case "Double":
					return typeof(Double)
				case "Long":
					return typeof(Long)
				case AadlReal.name:
					return typeof(RealLiteral)
				case AadlInteger.name:
					return typeof(IntegerLiteral)
				case AadlBoolean.name:
					return typeof(BooleanLiteral)
				default: {
					var ecl = Aadl2Package.eINSTANCE.getEClassifier(name);
					if (ecl === null) {
						InstancePackage.eINSTANCE.getEClassifier(name)
					}
					if(ecl !== null) return ecl.instanceClass
					return Class.forName(name)
				}
			}
		}

		/*
		 * convert actual to Java object if JavaParameter is specified 
		 */
		private static def Object toJavaActual(FormalParameter formal, PropertyExpression actual, JavaMethod vm) {
			val jparameters = vm.params
			for (jp : jparameters) {
				if (formal.name.equalsIgnoreCase(jp.name)) {
					return convertToJavaObject(jp, actual)
				}
			}
			return convertActualToJavaObject(formal, actual)
		}
		/*
		 * Convert AADL Property representation of string, boolean, integer, real to Java objects
		 */
		private static def Object convertActualToJavaObject(FormalParameter formal,PropertyExpression actual) {
			var Object result = actual
			switch (actual) {
				RealLiteral:
					if(formal.unit !== null) result = actual.value
				IntegerLiteral: {
					if (formal.unit !== null) {
						result = actual.value
					}
				}
				StringLiteral:
					result = actual.value
				BooleanLiteral:
					result = actual.isValue
			}
			return result
		}

		/*
		 * Convert AADL Property representation of string, boolean, integer, real to Java objects accordin gto JavaParameter specification
		 */
		private static def Object convertToJavaObject(JavaParameter formalParam, PropertyExpression actual) {
			var Object result = actual
			switch (actual) {
				RealLiteral:
					if(formalParam.parameterType.equalsIgnoreCase("double") ||
						formalParam.parameterType.equalsIgnoreCase("real")) result = actual.value
				IntegerLiteral: {
					if (formalParam.parameterType.equalsIgnoreCase("long")) {
						result = actual.value
					} else if (formalParam.parameterType.equalsIgnoreCase("int")) {
						result = actual.value.intValue
					}
				}
				StringLiteral:
					if(formalParam.parameterType.equalsIgnoreCase("string")) result = actual.value
				BooleanLiteral:
					if(formalParam.parameterType.equalsIgnoreCase("boolean")) result = actual.isValue
			}
			return result
		}



}