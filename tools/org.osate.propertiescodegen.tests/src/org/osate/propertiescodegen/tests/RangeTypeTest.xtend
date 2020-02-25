package org.osate.propertiescodegen.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.PropertySet
import org.osate.propertiescodegen.PropertiesCodeGen
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class RangeTypeTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRangeType() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				
				mass_type: type aadlreal units ps2::mass;
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				integer_no_units: type aadlinteger;
				integer_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				real_no_units: type aadlreal;
				
				range_of_integer_no_units: type range of aadlinteger;
				range_of_integer_owned_units: type range of aadlinteger units (g, kg => g * 1000);
				range_of_integer_referenced_units_local: type range of aadlinteger units ps1::time;
				range_of_integer_referenced_units_other_file: type range of aadlinteger units ps2::mass;
				range_of_real_no_units: type range of aadlreal;
				range_of_real_owned_units: type range of aadlreal units (mN, cN => mN * 10, N => cN * 100);
				range_of_real_referenced_units_local: type range of aadlreal units ps1::time;
				range_of_real_referenced_units_other_file: type range of aadlreal units ps2::mass;
				range_of_referenced_integer_no_units: type range of ps1::integer_no_units;
				range_of_referenced_real_no_units: type range of ps1::real_no_units;
				range_of_referenced_number_local: type range of ps1::integer_owned_units;
				range_of_referenced_number_other_file: type range of ps2::mass_type;
			end ps1;
		'''
		val time = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public enum Time {
				SEC(1.0, "sec"),
				MIN(60.0, "min"),
				HR(3600.0, "hr"),
				DAY(86400.0, "day");
				
				private final double factorToBase;
				private final String originalName;
				
				private Time(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				public static Time getValue(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					if (abstractNamedValue instanceof UnitLiteral) {
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					} else if (abstractNamedValue instanceof Property) {
						throw new IllegalArgumentException("Reference to property not supported");
					} else if (abstractNamedValue instanceof PropertyConstant) {
						throw new IllegalArgumentException("Reference to property constant not supported");
					} else {
						throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
					}
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerNoUnits = '''
			package ps1;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class IntegerNoUnits {
				public static long getValue(PropertyExpression propertyExpression) {
					return ((IntegerLiteral) propertyExpression).getValue();
				}
			}
		'''
		val integerOwnedUnits = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class IntegerOwnedUnits {
				private final long value;
				private final Units unit;
				
				private IntegerOwnedUnits(PropertyExpression propertyExpression) {
					IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Units.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static IntegerOwnedUnits getValue(PropertyExpression propertyExpression) {
					return new IntegerOwnedUnits(propertyExpression);
				}
				
				public long getValue() {
					return value;
				}
				
				public Units getUnit() {
					return unit;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(value, unit);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof IntegerOwnedUnits)) {
						return false;
					}
					IntegerOwnedUnits other = (IntegerOwnedUnits) obj;
					return value == other.value && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
				
				public enum Units {
					MM(1.0, "mm"),
					CM(10.0, "cm"),
					M(1000.0, "m");
					
					private final double factorToBase;
					private final String originalName;
					
					private Units(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(Units target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val realNoUnits = '''
			package ps1;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			
			public class RealNoUnits {
				public static double getValue(PropertyExpression propertyExpression) {
					return ((RealLiteral) propertyExpression).getValue();
				}
			}
		'''
		val rangeOfIntegerNoUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeOfIntegerNoUnits {
				private final long minimum;
				private final long maximum;
				private final OptionalLong delta;
				
				private RangeOfIntegerNoUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = ((IntegerLiteral) rangeValue.getMinimum()).getValue();
					maximum = ((IntegerLiteral) rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = OptionalLong.empty();
					} else {
						delta = OptionalLong.of(((IntegerLiteral) rangeValue.getDelta()).getValue());
					}
				}
				
				public static RangeOfIntegerNoUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfIntegerNoUnits(propertyExpression);
				}
				
				public long getMinimum() {
					return minimum;
				}
				
				public long getMaximum() {
					return maximum;
				}
				
				public OptionalLong getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfIntegerNoUnits)) {
						return false;
					}
					RangeOfIntegerNoUnits other = (RangeOfIntegerNoUnits) obj;
					return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
			}
		'''
		val rangeOfIntegerOwnedUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeOfIntegerOwnedUnits {
				private final Number minimum;
				private final Number maximum;
				private final Optional<Number> delta;
				
				private RangeOfIntegerOwnedUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
				}
				
				public static RangeOfIntegerOwnedUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfIntegerOwnedUnits(propertyExpression);
				}
				
				public Number getMinimum() {
					return minimum;
				}
				
				public Number getMaximum() {
					return maximum;
				}
				
				public Optional<Number> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfIntegerOwnedUnits)) {
						return false;
					}
					RangeOfIntegerOwnedUnits other = (RangeOfIntegerOwnedUnits) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				
				public static class Number {
					private final long value;
					private final Units unit;
					
					private Number(PropertyExpression propertyExpression) {
						IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Units.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public long getValue() {
						return value;
					}
					
					public Units getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Number)) {
							return false;
						}
						Number other = (Number) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
					
					public enum Units {
						G(1.0, "g"),
						KG(1000.0, "kg");
						
						private final double factorToBase;
						private final String originalName;
						
						private Units(double factorToBase, String originalName) {
							this.factorToBase = factorToBase;
							this.originalName = originalName;
						}
						
						public double getFactorToBase() {
							return factorToBase;
						}
						
						public double getFactorTo(Units target) {
							return factorToBase / target.factorToBase;
						}
						
						@Override
						public String toString() {
							return originalName;
						}
					}
				}
			}
		'''
		val rangeOfIntegerReferencedUnitsLocal = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeOfIntegerReferencedUnitsLocal {
				private final Number minimum;
				private final Number maximum;
				private final Optional<Number> delta;
				
				private RangeOfIntegerReferencedUnitsLocal(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
				}
				
				public static RangeOfIntegerReferencedUnitsLocal getValue(PropertyExpression propertyExpression) {
					return new RangeOfIntegerReferencedUnitsLocal(propertyExpression);
				}
				
				public Number getMinimum() {
					return minimum;
				}
				
				public Number getMaximum() {
					return maximum;
				}
				
				public Optional<Number> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfIntegerReferencedUnitsLocal)) {
						return false;
					}
					RangeOfIntegerReferencedUnitsLocal other = (RangeOfIntegerReferencedUnitsLocal) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				
				public static class Number {
					private final long value;
					private final Time unit;
					
					private Number(PropertyExpression propertyExpression) {
						IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Time.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public long getValue() {
						return value;
					}
					
					public Time getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Number)) {
							return false;
						}
						Number other = (Number) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
			}
		'''
		val rangeOfIntegerReferencedUnitsOtherFile = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			import ps2.Mass;
			
			public class RangeOfIntegerReferencedUnitsOtherFile {
				private final Number minimum;
				private final Number maximum;
				private final Optional<Number> delta;
				
				private RangeOfIntegerReferencedUnitsOtherFile(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
				}
				
				public static RangeOfIntegerReferencedUnitsOtherFile getValue(PropertyExpression propertyExpression) {
					return new RangeOfIntegerReferencedUnitsOtherFile(propertyExpression);
				}
				
				public Number getMinimum() {
					return minimum;
				}
				
				public Number getMaximum() {
					return maximum;
				}
				
				public Optional<Number> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfIntegerReferencedUnitsOtherFile)) {
						return false;
					}
					RangeOfIntegerReferencedUnitsOtherFile other = (RangeOfIntegerReferencedUnitsOtherFile) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				
				public static class Number {
					private final long value;
					private final Mass unit;
					
					private Number(PropertyExpression propertyExpression) {
						IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public long getValue() {
						return value;
					}
					
					public Mass getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Number)) {
							return false;
						}
						Number other = (Number) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
			}
		'''
		val rangeOfRealNoUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalDouble;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			
			public class RangeOfRealNoUnits {
				private final double minimum;
				private final double maximum;
				private final OptionalDouble delta;
				
				private RangeOfRealNoUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = ((RealLiteral) rangeValue.getMinimum()).getValue();
					maximum = ((RealLiteral) rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = OptionalDouble.empty();
					} else {
						delta = OptionalDouble.of(((RealLiteral) rangeValue.getDelta()).getValue());
					}
				}
				
				public static RangeOfRealNoUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfRealNoUnits(propertyExpression);
				}
				
				public double getMinimum() {
					return minimum;
				}
				
				public double getMaximum() {
					return maximum;
				}
				
				public OptionalDouble getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfRealNoUnits)) {
						return false;
					}
					RangeOfRealNoUnits other = (RangeOfRealNoUnits) obj;
					return Double.doubleToLongBits(minimum) == Double.doubleToLongBits(other.minimum)
							&& Double.doubleToLongBits(maximum) == Double.doubleToLongBits(other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
			}
		'''
		val rangeOfRealOwnedUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			
			public class RangeOfRealOwnedUnits {
				private final Number minimum;
				private final Number maximum;
				private final Optional<Number> delta;
				
				private RangeOfRealOwnedUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
				}
				
				public static RangeOfRealOwnedUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfRealOwnedUnits(propertyExpression);
				}
				
				public Number getMinimum() {
					return minimum;
				}
				
				public Number getMaximum() {
					return maximum;
				}
				
				public Optional<Number> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfRealOwnedUnits)) {
						return false;
					}
					RangeOfRealOwnedUnits other = (RangeOfRealOwnedUnits) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				
				public static class Number {
					private final double value;
					private final Units unit;
					
					private Number(PropertyExpression propertyExpression) {
						RealLiteral numberValue = (RealLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Units.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public double getValue() {
						return value;
					}
					
					public Units getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Number)) {
							return false;
						}
						Number other = (Number) obj;
						return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
					
					public enum Units {
						MN(1.0, "mN"),
						CN(10.0, "cN"),
						N(1000.0, "N");
						
						private final double factorToBase;
						private final String originalName;
						
						private Units(double factorToBase, String originalName) {
							this.factorToBase = factorToBase;
							this.originalName = originalName;
						}
						
						public double getFactorToBase() {
							return factorToBase;
						}
						
						public double getFactorTo(Units target) {
							return factorToBase / target.factorToBase;
						}
						
						@Override
						public String toString() {
							return originalName;
						}
					}
				}
			}
		'''
		val rangeOfRealReferencedUnitsLocal = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			
			public class RangeOfRealReferencedUnitsLocal {
				private final Number minimum;
				private final Number maximum;
				private final Optional<Number> delta;
				
				private RangeOfRealReferencedUnitsLocal(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
				}
				
				public static RangeOfRealReferencedUnitsLocal getValue(PropertyExpression propertyExpression) {
					return new RangeOfRealReferencedUnitsLocal(propertyExpression);
				}
				
				public Number getMinimum() {
					return minimum;
				}
				
				public Number getMaximum() {
					return maximum;
				}
				
				public Optional<Number> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfRealReferencedUnitsLocal)) {
						return false;
					}
					RangeOfRealReferencedUnitsLocal other = (RangeOfRealReferencedUnitsLocal) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				
				public static class Number {
					private final double value;
					private final Time unit;
					
					private Number(PropertyExpression propertyExpression) {
						RealLiteral numberValue = (RealLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Time.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public double getValue() {
						return value;
					}
					
					public Time getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Number)) {
							return false;
						}
						Number other = (Number) obj;
						return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
			}
		'''
		val rangeOfRealReferencedUnitsOtherFile = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			
			import ps2.Mass;
			
			public class RangeOfRealReferencedUnitsOtherFile {
				private final Number minimum;
				private final Number maximum;
				private final Optional<Number> delta;
				
				private RangeOfRealReferencedUnitsOtherFile(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
				}
				
				public static RangeOfRealReferencedUnitsOtherFile getValue(PropertyExpression propertyExpression) {
					return new RangeOfRealReferencedUnitsOtherFile(propertyExpression);
				}
				
				public Number getMinimum() {
					return minimum;
				}
				
				public Number getMaximum() {
					return maximum;
				}
				
				public Optional<Number> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfRealReferencedUnitsOtherFile)) {
						return false;
					}
					RangeOfRealReferencedUnitsOtherFile other = (RangeOfRealReferencedUnitsOtherFile) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				
				public static class Number {
					private final double value;
					private final Mass unit;
					
					private Number(PropertyExpression propertyExpression) {
						RealLiteral numberValue = (RealLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public double getValue() {
						return value;
					}
					
					public Mass getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Number)) {
							return false;
						}
						Number other = (Number) obj;
						return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
			}
		'''
		val rangeOfReferencedIntegerNoUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeOfReferencedIntegerNoUnits {
				private final long minimum;
				private final long maximum;
				private final OptionalLong delta;
				
				private RangeOfReferencedIntegerNoUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = ((IntegerLiteral) rangeValue.getMinimum()).getValue();
					maximum = ((IntegerLiteral) rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = OptionalLong.empty();
					} else {
						delta = OptionalLong.of(((IntegerLiteral) rangeValue.getDelta()).getValue());
					}
				}
				
				public static RangeOfReferencedIntegerNoUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfReferencedIntegerNoUnits(propertyExpression);
				}
				
				public long getMinimum() {
					return minimum;
				}
				
				public long getMaximum() {
					return maximum;
				}
				
				public OptionalLong getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfReferencedIntegerNoUnits)) {
						return false;
					}
					RangeOfReferencedIntegerNoUnits other = (RangeOfReferencedIntegerNoUnits) obj;
					return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
			}
		'''
		val rangeOfReferencedRealNoUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalDouble;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			
			public class RangeOfReferencedRealNoUnits {
				private final double minimum;
				private final double maximum;
				private final OptionalDouble delta;
				
				private RangeOfReferencedRealNoUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = ((RealLiteral) rangeValue.getMinimum()).getValue();
					maximum = ((RealLiteral) rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = OptionalDouble.empty();
					} else {
						delta = OptionalDouble.of(((RealLiteral) rangeValue.getDelta()).getValue());
					}
				}
				
				public static RangeOfReferencedRealNoUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfReferencedRealNoUnits(propertyExpression);
				}
				
				public double getMinimum() {
					return minimum;
				}
				
				public double getMaximum() {
					return maximum;
				}
				
				public OptionalDouble getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfReferencedRealNoUnits)) {
						return false;
					}
					RangeOfReferencedRealNoUnits other = (RangeOfReferencedRealNoUnits) obj;
					return Double.doubleToLongBits(minimum) == Double.doubleToLongBits(other.minimum)
							&& Double.doubleToLongBits(maximum) == Double.doubleToLongBits(other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
			}
		'''
		val rangeOfReferencedNumberLocal = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeOfReferencedNumberLocal {
				private final IntegerOwnedUnits minimum;
				private final IntegerOwnedUnits maximum;
				private final Optional<IntegerOwnedUnits> delta;
				
				private RangeOfReferencedNumberLocal(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = IntegerOwnedUnits.getValue(rangeValue.getMinimum());
					maximum = IntegerOwnedUnits.getValue(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> IntegerOwnedUnits.getValue(it));
				}
				
				public static RangeOfReferencedNumberLocal getValue(PropertyExpression propertyExpression) {
					return new RangeOfReferencedNumberLocal(propertyExpression);
				}
				
				public IntegerOwnedUnits getMinimum() {
					return minimum;
				}
				
				public IntegerOwnedUnits getMaximum() {
					return maximum;
				}
				
				public Optional<IntegerOwnedUnits> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfReferencedNumberLocal)) {
						return false;
					}
					RangeOfReferencedNumberLocal other = (RangeOfReferencedNumberLocal) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
			}
		'''
		val rangeOfReferencedNumberOtherFile = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			import ps2.MassType;
			
			public class RangeOfReferencedNumberOtherFile {
				private final MassType minimum;
				private final MassType maximum;
				private final Optional<MassType> delta;
				
				private RangeOfReferencedNumberOtherFile(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = MassType.getValue(rangeValue.getMinimum());
					maximum = MassType.getValue(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> MassType.getValue(it));
				}
				
				public static RangeOfReferencedNumberOtherFile getValue(PropertyExpression propertyExpression) {
					return new RangeOfReferencedNumberOtherFile(propertyExpression);
				}
				
				public MassType getMinimum() {
					return minimum;
				}
				
				public MassType getMaximum() {
					return maximum;
				}
				
				public Optional<MassType> getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfReferencedNumberOtherFile)) {
						return false;
					}
					RangeOfReferencedNumberOtherFile other = (RangeOfReferencedNumberOtherFile) obj;
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(16, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("IntegerNoUnits.java", results.get(1).fileName)
		assertEquals(integerNoUnits.toString, results.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(2).contents)
		
		assertEquals("RealNoUnits.java", results.get(3).fileName)
		assertEquals(realNoUnits.toString, results.get(3).contents)
		
		assertEquals("RangeOfIntegerNoUnits.java", results.get(4).fileName)
		assertEquals(rangeOfIntegerNoUnits.toString, results.get(4).contents)
		
		assertEquals("RangeOfIntegerOwnedUnits.java", results.get(5).fileName)
		assertEquals(rangeOfIntegerOwnedUnits.toString, results.get(5).contents)
		
		assertEquals("RangeOfIntegerReferencedUnitsLocal.java", results.get(6).fileName)
		assertEquals(rangeOfIntegerReferencedUnitsLocal.toString, results.get(6).contents)
		
		assertEquals("RangeOfIntegerReferencedUnitsOtherFile.java", results.get(7).fileName)
		assertEquals(rangeOfIntegerReferencedUnitsOtherFile.toString, results.get(7).contents)
		
		assertEquals("RangeOfRealNoUnits.java", results.get(8).fileName)
		assertEquals(rangeOfRealNoUnits.toString, results.get(8).contents)
		
		assertEquals("RangeOfRealOwnedUnits.java", results.get(9).fileName)
		assertEquals(rangeOfRealOwnedUnits.toString, results.get(9).contents)
		
		assertEquals("RangeOfRealReferencedUnitsLocal.java", results.get(10).fileName)
		assertEquals(rangeOfRealReferencedUnitsLocal.toString, results.get(10).contents)
		
		assertEquals("RangeOfRealReferencedUnitsOtherFile.java", results.get(11).fileName)
		assertEquals(rangeOfRealReferencedUnitsOtherFile.toString, results.get(11).contents)
		
		assertEquals("RangeOfReferencedIntegerNoUnits.java", results.get(12).fileName)
		assertEquals(rangeOfReferencedIntegerNoUnits.toString, results.get(12).contents)
		
		assertEquals("RangeOfReferencedRealNoUnits.java", results.get(13).fileName)
		assertEquals(rangeOfReferencedRealNoUnits.toString, results.get(13).contents)
		
		assertEquals("RangeOfReferencedNumberLocal.java", results.get(14).fileName)
		assertEquals(rangeOfReferencedNumberLocal.toString, results.get(14).contents)
		
		assertEquals("RangeOfReferencedNumberOtherFile.java", results.get(15).fileName)
		assertEquals(rangeOfReferencedNumberOtherFile.toString, results.get(15).contents)
	}
}