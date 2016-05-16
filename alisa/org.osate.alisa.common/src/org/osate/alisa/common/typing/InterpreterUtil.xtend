package org.osate.alisa.common.typing

import org.osate.aadl2.Aadl2Factory
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.ListValue
import org.osate.aadl2.NumberValue
import org.osate.aadl2.PropertyValue
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.RecordValue
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.UnitLiteral

class InterpreterUtil {
	
	public static def UnitLiteral smallerUnit(UnitLiteral unit1, UnitLiteral unit2) {
		if (unit1 == unit2) {
			unit1
		} else {
			val tester = Aadl2Factory.eINSTANCE.createRealLiteral
			tester.value = 1.0
			tester.unit = unit1
			if (tester.getScaledValue(unit2) < 1) {
				unit1
			} else {
				unit2
			}
		}
	}

	static def compare(NumberValue v1, NumberValue v2) {
		val minUnit = smallerUnit(v1.unit, v2.unit)
		val s1 = if (v1.unit == null) v1 else v1.getScaledValue(minUnit)
		val s2 = if (v1.unit == null) v2 else v2.getScaledValue(minUnit)
		if (s1 instanceof IntegerLiteral && s2 instanceof IntegerLiteral) {
			val n1 = (s1 as IntegerLiteral).value
			val n2 = (s2 as IntegerLiteral).value
			n1.compareTo(n2)
		} else {
			val n1 = if (s1 instanceof RealLiteral) {
					s1.value
				} else {
					(s1 as IntegerLiteral).value
				}
			val n2 = if (s2 instanceof RealLiteral) {
					s2.value
				} else {
					(s2 as IntegerLiteral).value
				}
			n1.compareTo(n2)
		}
	}


	// compare 2 property values

	public static def dispatch equalTo(BooleanLiteral v1, BooleanLiteral v2) {
		v1.getValue == v2.getValue
	}

	public static def dispatch equalTo(NumberValue v1, NumberValue v2) {
		v1.compare(v2) == 0
	}

	public static def dispatch equalTo(StringLiteral v1, StringLiteral v2) {
		v1.value.equals(v2.value)
	}

	public static def dispatch equalTo(RangeValue v1, RangeValue v2) {
		(v1.minimum as NumberValue).compare(v2.minimum as NumberValue) == 0
		&& (v1.maximum as NumberValue).compare(v2.maximum as NumberValue) == 0
	}

	public static def dispatch equalTo(RecordValue v1, RecordValue v2) {
		val i1 = v1.ownedFieldValues.iterator
		val i2 = v2.ownedFieldValues.iterator
		while (i1.hasNext) {
			val f1 = i1.next
			val f2 = i2.next
			if (false){//(f1.value as PropertyValue).equalTo(f2.value as PropertyValue)) {
				return false
			}
		}
		true
	}

	public static def dispatch equalTo(ListValue v1, ListValue v2) {
	}

//	public static def dispatch equalTo(v1, v2) {
//	}
//
//	public static def dispatch equalTo(v1, v2) {
//	}
//
//	public static def dispatch equalTo(v1, v2) {
//	}
//
//	public static def dispatch equalTo(v1, v2) {
//	}

	public static def dispatch equalTo(PropertyValue v1, PropertyValue v2) {
		false
	}

}