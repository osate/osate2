package org.osate.alisa.common.typing

import org.osate.aadl2.Aadl2Factory
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.NumberValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.instance.InstanceObject
import org.osate.alisa.common.common.AModelReference

class InterpreterUtil {

	public static def UnitLiteral smallerUnit(UnitLiteral unit1, UnitLiteral unit2) {
		if (unit1 == null || unit2 == null) {
			null
		} else if (unit1 == unit2) {
			unit1
		} else {
			val tester = Aadl2Factory.eINSTANCE.createRealLiteral
			tester.value = 1.0
			tester.unit = unit1
			if (tester.getScaledValue(unit2) < 1.0) {
				unit1
			} else {
				unit2
			}
		}
	}

	public static def compareTo(NumberValue v1, NumberValue v2) {
		val minUnit = smallerUnit(v1.unit, v2.unit)
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			val s1 = if (v1.unit == null)
					(v1 as IntegerLiteral).getValue
				else
					Math.round(v1.getScaledValue(minUnit))
			val s2 = if (v2.unit == null)
					(v2 as IntegerLiteral).getValue
				else
					Math.round(v2.getScaledValue(minUnit))
			s1.compareTo(s2)
		} else {
			val s1 = if (v1.unit == null) {
					if (v1 instanceof IntegerLiteral)
						v1.getValue
					else
						(v1 as RealLiteral).value
				} else
					v1.getScaledValue(minUnit)
			val s2 = if (v2.unit == null) {
					if (v2 instanceof IntegerLiteral)
						v2.getValue
					else
						(v2 as RealLiteral).value
				} else
					v2.getScaledValue(minUnit)
			s1.compareTo(s2)
		}
	}

	public static def add(NumberValue v1, NumberValue v2) {
		val minUnit = smallerUnit(v1.unit, v2.unit)
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			val s1 = if (v1.unit == null)
					(v1 as IntegerLiteral).getValue
				else
					Math.round(v1.getScaledValue(minUnit))
			val s2 = if (v2.unit == null)
					(v2 as IntegerLiteral).getValue
				else
					Math.round(v2.getScaledValue(minUnit))
			val result = Aadl2Factory.eINSTANCE.createIntegerLiteral
			result.value = s1 + s2
			result.unit = minUnit
			result
		} else {
			val s1 = 
				if (v1.unit == null) {
					if (v1 instanceof IntegerLiteral)
						v1.getValue
					else
						(v1 as RealLiteral).value
				} else
					v1.getScaledValue(minUnit)
			val s2 = 
				if (v2.unit == null) {
					if (v2 instanceof IntegerLiteral)
						v2.getValue
					else
						(v2 as RealLiteral).value
				} else
					v2.getScaledValue(minUnit)
			val result = Aadl2Factory.eINSTANCE.createRealLiteral
			result.value = s1 + s2
			result.unit = minUnit
			result
		}
	}

	public static def subtract(NumberValue v1, NumberValue v2) {
		if (v2 instanceof IntegerLiteral) {
			val neg = Aadl2Factory.eINSTANCE.createIntegerLiteral
			neg.value = -v2.value
			neg.unit = v2.unit
			v1.add(neg)

		} else {
			val neg = Aadl2Factory.eINSTANCE.createRealLiteral
			neg.value = -(v2 as RealLiteral).value
			neg.unit = v2.unit
			v1.add(neg)
		}
	}

	public static def multiply(NumberValue v1, NumberValue v2) {
		val unit = if (v1.unit != null) v1.unit else v2.unit
		if (v1 instanceof IntegerLiteral && v2 instanceof IntegerLiteral) {
			val s1 = (v1 as IntegerLiteral).getValue
			val s2 = (v2 as IntegerLiteral).getValue
			val result = Aadl2Factory.eINSTANCE.createIntegerLiteral
			result.value = s1 * s2
			result.unit = unit
			result
		} else {
			val s1 =
					if (v1 instanceof IntegerLiteral)
						v1.getValue
					else
						(v1 as RealLiteral).value
			val s2 = 
					if (v2 instanceof IntegerLiteral)
						v2.getValue
					else
						(v2 as RealLiteral).value
			val result = Aadl2Factory.eINSTANCE.createRealLiteral
			result.value = s1 * s2
			result.unit = unit
			result
		}
	}

	public static def divide(NumberValue v1, NumberValue v2) {
		val minUnit = smallerUnit(v1.unit, v2.unit)
		val twoUnits = v1.unit != null && v2.unit != null
		val unit = if (v1.unit != null) v1.unit else v2.unit

		val s1 = 
			if (!twoUnits) {
				if (v1 instanceof IntegerLiteral)
					v1.getValue
				else
					(v1 as RealLiteral).value
			} else
				v1.getScaledValue(minUnit)
		val s2 = 
			if (!twoUnits) {
				if (v2 instanceof IntegerLiteral)
					v2.getValue
				else
					(v2 as RealLiteral).value
			} else
				v2.getScaledValue(minUnit)
		val result = Aadl2Factory.eINSTANCE.createRealLiteral
		result.value = s1 / s2
		result.unit = if (twoUnits) minUnit else unit
		result
	}
	
	public static def divideInt(IntegerLiteral v1, IntegerLiteral v2) {
		val minUnit = smallerUnit(v1.unit, v2.unit)
		val twoUnits = v1.unit != null && v2.unit != null
		val unit = if (v1.unit != null) v1.unit else v2.unit

		val s1 = 
				if (!twoUnits)
					v1.getValue
				else
					Math.round(v1.getScaledValue(minUnit))
		val s2 =
				if (!twoUnits)
					v2.getValue
				else
					Math.round(v2.getScaledValue(minUnit))
		val result = Aadl2Factory.eINSTANCE.createIntegerLiteral
		result.value = s1 / s2
		result.unit = if (twoUnits) minUnit else unit
		result
	}
	
	public static def mod(IntegerLiteral v1, IntegerLiteral v2) {
		val minUnit = smallerUnit(v1.unit, v2.unit)
		val twoUnits = v1.unit != null && v2.unit != null
		val unit = if (v1.unit != null) v1.unit else v2.unit

		val s1 = 
				if (!twoUnits)
					v1.getValue
				else
					Math.round(v1.getScaledValue(minUnit))
		val s2 =
				if (!twoUnits)
					v2.getValue
				else
					Math.round(v2.getScaledValue(minUnit))
		val result = Aadl2Factory.eINSTANCE.createIntegerLiteral
		result.value = s1 % s2
		result.unit = if (twoUnits) minUnit else unit
		result
	}
	
	/**
	 * Resolve a model element reference relative to an instance object
	 */
	static def InstanceObject resolve(AModelReference ref, InstanceObject root) {
		if (ref.prev == null)
			root
		else {
			val io = ref.prev.resolve(root)
			io.eContents.findFirst[
				if (it instanceof InstanceObject) it.name.equalsIgnoreCase(ref.modelElement.name) else false
			] as InstanceObject
		}
	}
	
}