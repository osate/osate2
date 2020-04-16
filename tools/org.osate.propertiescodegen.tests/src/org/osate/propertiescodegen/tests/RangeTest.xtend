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
class RangeTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRange() {
		val otherPs = '''
			property set other_ps is
				mass: type units (g, kg => g * 1000);
			end other_ps;
		'''
		val rangeTest = '''
			property set range_test is
				with other_ps;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				integer_no_units: range of aadlinteger applies to (all);
				integer_owned_units: range of aadlinteger units (cm, m => cm * 100) applies to (all);
				integer_same_file_units: range of aadlinteger units range_test::time applies to (all);
				integer_other_file_units: range of aadlinteger units other_ps::mass applies to (all);
				
				list_1_integer_no_units: list of range of aadlinteger applies to (all);
				list_1_integer_owned_units: list of range of aadlinteger units (m, km => m * 1000) applies to (all);
				list_1_integer_same_file_units: list of range of aadlinteger units range_test::time applies to (all);
				list_1_integer_other_file_units: list of range of aadlinteger units other_ps::mass applies to (all);
				
				real_no_units: range of aadlreal applies to (all);
				real_owned_units: range of aadlreal units (mm, cm => mm * 10) applies to (all);
				real_same_file_units: range of aadlreal units range_test::time applies to (all);
				real_other_file_units: range of aadlreal units other_ps::mass applies to (all);
				
				list_1_real_no_units: list of range of aadlreal applies to (all);
				list_1_real_owned_units: list of range of aadlreal units (mg, cg => mg * 10) applies to (all);
				list_1_real_same_file_units: list of range of aadlreal units range_test::time applies to (all);
				list_1_real_other_file_units: list of range of aadlreal units other_ps::mass applies to (all);
				
				record_property: record (
					integer_no_units: range of aadlinteger;
					integer_owned_units: range of aadlinteger units (cm, m => cm * 100);
					integer_same_file_units: range of aadlinteger units range_test::time;
					integer_other_file_units: range of aadlinteger units other_ps::mass;
					
					list_1_integer_no_units: list of range of aadlinteger;
					list_1_integer_owned_units: list of range of aadlinteger units (m, km => m * 1000);
					list_1_integer_same_file_units: list of range of aadlinteger units range_test::time;
					list_1_integer_other_file_units: list of range of aadlinteger units other_ps::mass;
					
					real_no_units: range of aadlreal;
					real_owned_units: range of aadlreal units (mm, cm => mm * 10);
					real_same_file_units: range of aadlreal units range_test::time;
					real_other_file_units: range of aadlreal units other_ps::mass;
					
					list_1_real_no_units: list of range of aadlreal;
					list_1_real_owned_units: list of range of aadlreal units (mg, cg => mg * 10);
					list_1_real_same_file_units: list of range of aadlreal units range_test::time;
					list_1_real_other_file_units: list of range of aadlreal units other_ps::mass;
				) applies to (all);
			end range_test;
		'''
		val rangeTestClass = '''
			package range_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
			import org.osate.pluginsupport.properties.RealRange;
			import org.osate.pluginsupport.properties.RealRangeWithUnits;
			
			import other_ps.Mass;
			
			public class RangeTest {
				public static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext) {
					String name = "range_test::integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new IntegerRange(resolved, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntegerNoUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext) {
					String name = "range_test::integer_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits.class, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntegerOwnedUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::integer_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext) {
					String name = "range_test::integer_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntegerSameFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::integer_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext) {
					String name = "range_test::integer_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntegerOtherFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::integer_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new IntegerRange(resolved1, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1IntegerNoUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits.class, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1IntegerOwnedUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1IntegerSameFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1IntegerOtherFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_integer_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealRange> getRealNoUnits(NamedElement lookupContext) {
					String name = "range_test::real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new RealRange(resolved, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRealNoUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext) {
					String name = "range_test::real_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new RealRangeWithUnits<>(resolved, RealOwnedUnits.class, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRealOwnedUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::real_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext) {
					String name = "range_test::real_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new RealRangeWithUnits<>(resolved, Time.class, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRealSameFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::real_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext) {
					String name = "range_test::real_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new RealRangeWithUnits<>(resolved, Mass.class, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRealOtherFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::real_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new RealRange(resolved1, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1RealNoUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_real_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits.class, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1RealOwnedUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_real_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_real_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1RealSameFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_real_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext) {
					String name = "range_test::list_1_real_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1RealOtherFileUnits_EObject(NamedElement lookupContext) {
					String name = "range_test::list_1_real_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext) {
					String name = "range_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new RecordProperty(resolved, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordProperty_EObject(NamedElement lookupContext) {
					String name = "range_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val time = '''
			package range_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits {
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
				
				public static Time valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerOwnedUnits = '''
			package range_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits {
				CM(1.0, "cm"),
				M(100.0, "m");
				
				private final double factorToBase;
				private final String originalName;
				
				private IntegerOwnedUnits(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1IntegerOwnedUnits = '''
			package range_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1IntegerOwnedUnits implements GeneratedUnits {
				M(1.0, "m"),
				KM(1000.0, "km");
				
				private final double factorToBase;
				private final String originalName;
				
				private List1IntegerOwnedUnits(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static List1IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val realOwnedUnits = '''
			package range_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RealOwnedUnits implements GeneratedUnits {
				MM(1.0, "mm"),
				CM(10.0, "cm");
				
				private final double factorToBase;
				private final String originalName;
				
				private RealOwnedUnits(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1RealOwnedUnits = '''
			package range_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1RealOwnedUnits implements GeneratedUnits {
				MG(1.0, "mg"),
				CG(10.0, "cg");
				
				private final double factorToBase;
				private final String originalName;
				
				private List1RealOwnedUnits(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static List1RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordProperty = '''
			package range_test;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
			import org.osate.pluginsupport.properties.RealRange;
			import org.osate.pluginsupport.properties.RealRangeWithUnits;
			
			import other_ps.Mass;
			
			public class RecordProperty {
				private final Optional<IntegerRange> integerNoUnits;
				private final Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits;
				private final Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits;
				private final Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits;
				private final Optional<List<IntegerRange>> list1IntegerNoUnits;
				private final Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits;
				private final Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits;
				private final Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits;
				private final Optional<RealRange> realNoUnits;
				private final Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits;
				private final Optional<RealRangeWithUnits<Time>> realSameFileUnits;
				private final Optional<RealRangeWithUnits<Mass>> realOtherFileUnits;
				private final Optional<List<RealRange>> list1RealNoUnits;
				private final Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits;
				private final Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits;
				private final Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits;
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.integerNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("integer_no_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new IntegerRange(resolved, lookupContext);
							})
							.findAny();
					this.integerOwnedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("integer_owned_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class, lookupContext);
							})
							.findAny();
					this.integerSameFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("integer_same_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext);
							})
							.findAny();
					this.integerOtherFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("integer_other_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext);
							})
							.findAny();
					this.list1IntegerNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_integer_no_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new IntegerRange(resolved1, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1IntegerOwnedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_integer_owned_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1IntegerSameFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_integer_same_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1IntegerOtherFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_integer_other_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.realNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("real_no_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new RealRange(resolved, lookupContext);
							})
							.findAny();
					this.realOwnedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("real_owned_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class, lookupContext);
							})
							.findAny();
					this.realSameFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("real_same_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new RealRangeWithUnits<>(resolved, Time.class, lookupContext);
							})
							.findAny();
					this.realOtherFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("real_other_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return new RealRangeWithUnits<>(resolved, Mass.class, lookupContext);
							})
							.findAny();
					this.list1RealNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_real_no_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new RealRange(resolved1, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1RealOwnedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_real_owned_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1RealSameFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_real_same_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1RealOtherFileUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_real_other_file_units"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
									PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
									return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext);
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public Optional<IntegerRange> getIntegerNoUnits() {
					return integerNoUnits;
				}
				
				public Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> getIntegerOwnedUnits() {
					return integerOwnedUnits;
				}
				
				public Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits() {
					return integerSameFileUnits;
				}
				
				public Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits() {
					return integerOtherFileUnits;
				}
				
				public Optional<List<IntegerRange>> getList1IntegerNoUnits() {
					return list1IntegerNoUnits;
				}
				
				public Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> getList1IntegerOwnedUnits() {
					return list1IntegerOwnedUnits;
				}
				
				public Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits() {
					return list1IntegerSameFileUnits;
				}
				
				public Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits() {
					return list1IntegerOtherFileUnits;
				}
				
				public Optional<RealRange> getRealNoUnits() {
					return realNoUnits;
				}
				
				public Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> getRealOwnedUnits() {
					return realOwnedUnits;
				}
				
				public Optional<RealRangeWithUnits<Time>> getRealSameFileUnits() {
					return realSameFileUnits;
				}
				
				public Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits() {
					return realOtherFileUnits;
				}
				
				public Optional<List<RealRange>> getList1RealNoUnits() {
					return list1RealNoUnits;
				}
				
				public Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> getList1RealOwnedUnits() {
					return list1RealOwnedUnits;
				}
				
				public Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits() {
					return list1RealSameFileUnits;
				}
				
				public Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits() {
					return list1RealOtherFileUnits;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							integerNoUnits,
							integerOwnedUnits,
							integerSameFileUnits,
							integerOtherFileUnits,
							list1IntegerNoUnits,
							list1IntegerOwnedUnits,
							list1IntegerSameFileUnits,
							list1IntegerOtherFileUnits,
							realNoUnits,
							realOwnedUnits,
							realSameFileUnits,
							realOtherFileUnits,
							list1RealNoUnits,
							list1RealOwnedUnits,
							list1RealSameFileUnits,
							list1RealOtherFileUnits
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordProperty)) {
						return false;
					}
					RecordProperty other = (RecordProperty) obj;
					return Objects.equals(this.integerNoUnits, other.integerNoUnits)
							&& Objects.equals(this.integerOwnedUnits, other.integerOwnedUnits)
							&& Objects.equals(this.integerSameFileUnits, other.integerSameFileUnits)
							&& Objects.equals(this.integerOtherFileUnits, other.integerOtherFileUnits)
							&& Objects.equals(this.list1IntegerNoUnits, other.list1IntegerNoUnits)
							&& Objects.equals(this.list1IntegerOwnedUnits, other.list1IntegerOwnedUnits)
							&& Objects.equals(this.list1IntegerSameFileUnits, other.list1IntegerSameFileUnits)
							&& Objects.equals(this.list1IntegerOtherFileUnits, other.list1IntegerOtherFileUnits)
							&& Objects.equals(this.realNoUnits, other.realNoUnits)
							&& Objects.equals(this.realOwnedUnits, other.realOwnedUnits)
							&& Objects.equals(this.realSameFileUnits, other.realSameFileUnits)
							&& Objects.equals(this.realOtherFileUnits, other.realOtherFileUnits)
							&& Objects.equals(this.list1RealNoUnits, other.list1RealNoUnits)
							&& Objects.equals(this.list1RealOwnedUnits, other.list1RealOwnedUnits)
							&& Objects.equals(this.list1RealSameFileUnits, other.list1RealSameFileUnits)
							&& Objects.equals(this.list1RealOtherFileUnits, other.list1RealOtherFileUnits);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.integerNoUnits.ifPresent(field -> {
						builder.append("integer_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerOwnedUnits.ifPresent(field -> {
						builder.append("integer_owned_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerSameFileUnits.ifPresent(field -> {
						builder.append("integer_same_file_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerOtherFileUnits.ifPresent(field -> {
						builder.append("integer_other_file_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1IntegerNoUnits.ifPresent(field -> {
						builder.append("list_1_integer_no_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerOwnedUnits.ifPresent(field -> {
						builder.append("list_1_integer_owned_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerSameFileUnits.ifPresent(field -> {
						builder.append("list_1_integer_same_file_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerOtherFileUnits.ifPresent(field -> {
						builder.append("list_1_integer_other_file_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.realNoUnits.ifPresent(field -> {
						builder.append("real_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.realOwnedUnits.ifPresent(field -> {
						builder.append("real_owned_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.realSameFileUnits.ifPresent(field -> {
						builder.append("real_same_file_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.realOtherFileUnits.ifPresent(field -> {
						builder.append("real_other_file_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1RealNoUnits.ifPresent(field -> {
						builder.append("list_1_real_no_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealOwnedUnits.ifPresent(field -> {
						builder.append("list_1_real_owned_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealSameFileUnits.ifPresent(field -> {
						builder.append("list_1_real_same_file_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealOtherFileUnits.ifPresent(field -> {
						builder.append("list_1_real_other_file_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum IntegerOwnedUnits_FieldType implements GeneratedUnits {
					CM(1.0, "cm"),
					M(100.0, "m");
					
					private final double factorToBase;
					private final String originalName;
					
					private IntegerOwnedUnits_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static IntegerOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1IntegerOwnedUnits_FieldType implements GeneratedUnits {
					M(1.0, "m"),
					KM(1000.0, "km");
					
					private final double factorToBase;
					private final String originalName;
					
					private List1IntegerOwnedUnits_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static List1IntegerOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum RealOwnedUnits_FieldType implements GeneratedUnits {
					MM(1.0, "mm"),
					CM(10.0, "cm");
					
					private final double factorToBase;
					private final String originalName;
					
					private RealOwnedUnits_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static RealOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1RealOwnedUnits_FieldType implements GeneratedUnits {
					MG(1.0, "mg"),
					CG(10.0, "cg");
					
					private final double factorToBase;
					private final String originalName;
					
					private List1RealOwnedUnits_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static List1RealOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(rangeTest, otherPs))
		assertEquals(7, results.size)
		
		assertEquals("RangeTest.java", results.get(0).fileName)
		assertEquals(rangeTestClass.toString, results.get(0).contents)
		
		assertEquals("Time.java", results.get(1).fileName)
		assertEquals(time.toString, results.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(2).contents)
		
		assertEquals("List1IntegerOwnedUnits.java", results.get(3).fileName)
		assertEquals(list1IntegerOwnedUnits.toString, results.get(3).contents)
		
		assertEquals("RealOwnedUnits.java", results.get(4).fileName)
		assertEquals(realOwnedUnits.toString, results.get(4).contents)
		
		assertEquals("List1RealOwnedUnits.java", results.get(5).fileName)
		assertEquals(list1RealOwnedUnits.toString, results.get(5).contents)
		
		assertEquals("RecordProperty.java", results.get(6).fileName)
		assertEquals(recordProperty.toString, results.get(6).contents)
	}
}