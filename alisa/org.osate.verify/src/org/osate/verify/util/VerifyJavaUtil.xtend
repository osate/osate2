package org.osate.verify.util

import java.util.Collection
import org.osate.verify.verify.JavaMethod
import org.osate.aadl2.instance.InstanceObject
import java.util.List
import org.osate.aadl2.PropertyExpression
import org.eclipse.emf.common.util.EList
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.VerificationMethod
import java.util.ArrayList
import org.osate.alisa.common.common.TargetType
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.EndToEndFlowInstance
import org.osate.aadl2.instance.ModeInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.PropertyType
import org.osate.aadl2.AadlString
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.instance.InstancePackage
import org.osate.verify.verify.JavaParameter
import org.osate.aadl2.StringLiteral
import org.osate.alisa.common.common.ModelRef
import org.eclipse.emf.ecore.EObject
import org.osate.alisa.common.common.TypeRef
import org.osate.alisa.common.common.PropertyRef
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.NumberType

class VerifyJavaUtil {

		// invoke Java method by first converting the actual parameters of a verification activity to a basic Java format for reflective call
		static def Collection<Object> getActualJavaObjects(JavaMethod vm, InstanceObject target, List<PropertyExpression> parameters) {
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
		static def Object[] getActualJavaObjects(EList<FormalParameter> formalparameters, InstanceObject target, List<PropertyExpression> parameters) {
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