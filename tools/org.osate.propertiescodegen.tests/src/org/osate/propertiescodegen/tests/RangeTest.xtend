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
			import org.osate.aadl2.Mode;
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
					return getIntegerNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRange(resolved, lookupContext, mode));
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
					return getIntegerOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::integer_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits.class, lookupContext, mode));
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
					return getIntegerSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::integer_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode));
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
					return getIntegerOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::integer_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode));
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
					return getList1IntegerNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRange(resolved1, lookupContext, mode);
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
					return getList1IntegerOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_integer_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits.class, lookupContext, mode);
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
					return getList1IntegerSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_integer_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
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
					return getList1IntegerOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_integer_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
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
					return getRealNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRange> getRealNoUnits(NamedElement lookupContext, Mode mode) {
					return getRealNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRange> getRealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRange(resolved, lookupContext, mode));
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
					return getRealOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getRealOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::real_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, RealOwnedUnits.class, lookupContext, mode));
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
					return getRealSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getRealSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::real_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode));
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
					return getRealOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getRealOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::real_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode));
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
					return getList1RealNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRange(resolved1, lookupContext, mode);
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
					return getList1RealOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_real_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits.class, lookupContext, mode);
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
					return getList1RealSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_real_same_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
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
					return getList1RealOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::list_1_real_other_file_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
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
					return getRecordProperty(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Mode mode) {
					return getRecordProperty(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "range_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordProperty(resolved, lookupContext, mode));
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
				
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
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
				
				public double getFactorTo(IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
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
				
				public double getFactorTo(List1IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
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
				
				public double getFactorTo(RealOwnedUnits target) {
					return factorToBase / target.factorToBase;
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
				
				public double getFactorTo(List1RealOwnedUnits target) {
					return factorToBase / target.factorToBase;
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
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.aadl2.properties.PropertyNotPresentException;
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
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerRange> integerNoUnits_local;
					try {
						integerNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("integer_no_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRange(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						integerNoUnits_local = Optional.empty();
					}
					this.integerNoUnits = integerNoUnits_local;
					
					Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits_local;
					try {
						integerOwnedUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("integer_owned_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						integerOwnedUnits_local = Optional.empty();
					}
					this.integerOwnedUnits = integerOwnedUnits_local;
					
					Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits_local;
					try {
						integerSameFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("integer_same_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						integerSameFileUnits_local = Optional.empty();
					}
					this.integerSameFileUnits = integerSameFileUnits_local;
					
					Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits_local;
					try {
						integerOtherFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("integer_other_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						integerOtherFileUnits_local = Optional.empty();
					}
					this.integerOtherFileUnits = integerOtherFileUnits_local;
					
					Optional<List<IntegerRange>> list1IntegerNoUnits_local;
					try {
						list1IntegerNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_integer_no_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerRange(resolved1, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1IntegerNoUnits_local = Optional.empty();
					}
					this.list1IntegerNoUnits = list1IntegerNoUnits_local;
					
					Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits_local;
					try {
						list1IntegerOwnedUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_integer_owned_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1IntegerOwnedUnits_local = Optional.empty();
					}
					this.list1IntegerOwnedUnits = list1IntegerOwnedUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits_local;
					try {
						list1IntegerSameFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_integer_same_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1IntegerSameFileUnits_local = Optional.empty();
					}
					this.list1IntegerSameFileUnits = list1IntegerSameFileUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits_local;
					try {
						list1IntegerOtherFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_integer_other_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1IntegerOtherFileUnits_local = Optional.empty();
					}
					this.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits_local;
					
					Optional<RealRange> realNoUnits_local;
					try {
						realNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("real_no_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealRange(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						realNoUnits_local = Optional.empty();
					}
					this.realNoUnits = realNoUnits_local;
					
					Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits_local;
					try {
						realOwnedUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("real_owned_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						realOwnedUnits_local = Optional.empty();
					}
					this.realOwnedUnits = realOwnedUnits_local;
					
					Optional<RealRangeWithUnits<Time>> realSameFileUnits_local;
					try {
						realSameFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("real_same_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						realSameFileUnits_local = Optional.empty();
					}
					this.realSameFileUnits = realSameFileUnits_local;
					
					Optional<RealRangeWithUnits<Mass>> realOtherFileUnits_local;
					try {
						realOtherFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("real_other_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						realOtherFileUnits_local = Optional.empty();
					}
					this.realOtherFileUnits = realOtherFileUnits_local;
					
					Optional<List<RealRange>> list1RealNoUnits_local;
					try {
						list1RealNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_real_no_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new RealRange(resolved1, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1RealNoUnits_local = Optional.empty();
					}
					this.list1RealNoUnits = list1RealNoUnits_local;
					
					Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits_local;
					try {
						list1RealOwnedUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_real_owned_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1RealOwnedUnits_local = Optional.empty();
					}
					this.list1RealOwnedUnits = list1RealOwnedUnits_local;
					
					Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits_local;
					try {
						list1RealSameFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_real_same_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1RealSameFileUnits_local = Optional.empty();
					}
					this.list1RealSameFileUnits = list1RealSameFileUnits_local;
					
					Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits_local;
					try {
						list1RealOtherFileUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_real_other_file_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1RealOtherFileUnits_local = Optional.empty();
					}
					this.list1RealOtherFileUnits = list1RealOtherFileUnits_local;
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
					
					public double getFactorTo(IntegerOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
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
					
					public double getFactorTo(List1IntegerOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
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
					
					public double getFactorTo(RealOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
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
					
					public double getFactorTo(List1RealOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
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