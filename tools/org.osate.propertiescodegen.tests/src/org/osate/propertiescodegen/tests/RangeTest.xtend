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
			package rangetest;
			
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
			
			import otherps.Mass;
			
			public class RangeTest {
				public static final String RANGE_TEST__NAME = "range_test";
				
				public static final String INTEGER_NO_UNITS__NAME = "integer_no_units";
				public static final String INTEGER_OWNED_UNITS__NAME = "integer_owned_units";
				public static final String INTEGER_SAME_FILE_UNITS__NAME = "integer_same_file_units";
				public static final String INTEGER_OTHER_FILE_UNITS__NAME = "integer_other_file_units";
				public static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";
				public static final String LIST_1_INTEGER_OWNED_UNITS__NAME = "list_1_integer_owned_units";
				public static final String LIST_1_INTEGER_SAME_FILE_UNITS__NAME = "list_1_integer_same_file_units";
				public static final String LIST_1_INTEGER_OTHER_FILE_UNITS__NAME = "list_1_integer_other_file_units";
				public static final String REAL_NO_UNITS__NAME = "real_no_units";
				public static final String REAL_OWNED_UNITS__NAME = "real_owned_units";
				public static final String REAL_SAME_FILE_UNITS__NAME = "real_same_file_units";
				public static final String REAL_OTHER_FILE_UNITS__NAME = "real_other_file_units";
				public static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";
				public static final String LIST_1_REAL_OWNED_UNITS__NAME = "list_1_real_owned_units";
				public static final String LIST_1_REAL_SAME_FILE_UNITS__NAME = "list_1_real_same_file_units";
				public static final String LIST_1_REAL_OTHER_FILE_UNITS__NAME = "list_1_real_other_file_units";
				public static final String RECORD_PROPERTY__NAME = "record_property";
				
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
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits<Time> {
				SEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				MIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				HR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				DAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Time(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				CM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				M(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1IntegerOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1IntegerOwnedUnits implements GeneratedUnits<List1IntegerOwnedUnits> {
				M(1.0, "m", "__synthetic1.aadl#/0/@ownedProperty.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				KM(1000.0, "km", "__synthetic1.aadl#/0/@ownedProperty.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(List1IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val realOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RealOwnedUnits implements GeneratedUnits<RealOwnedUnits> {
				MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private RealOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(RealOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1RealOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1RealOwnedUnits implements GeneratedUnits<List1RealOwnedUnits> {
				MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CG(10.0, "cg", "__synthetic1.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1RealOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(List1RealOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordProperty = '''
			package rangetest;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.BasicPropertyAssociation;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedRecord;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
			import org.osate.pluginsupport.properties.RealRange;
			import org.osate.pluginsupport.properties.RealRangeWithUnits;
			
			import otherps.Mass;
			
			public class RecordProperty extends GeneratedRecord {
				public static final String INTEGER_NO_UNITS__NAME = "integer_no_units";
				public static final String INTEGER_OWNED_UNITS__NAME = "integer_owned_units";
				public static final String INTEGER_SAME_FILE_UNITS__NAME = "integer_same_file_units";
				public static final String INTEGER_OTHER_FILE_UNITS__NAME = "integer_other_file_units";
				public static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";
				public static final String LIST_1_INTEGER_OWNED_UNITS__NAME = "list_1_integer_owned_units";
				public static final String LIST_1_INTEGER_SAME_FILE_UNITS__NAME = "list_1_integer_same_file_units";
				public static final String LIST_1_INTEGER_OTHER_FILE_UNITS__NAME = "list_1_integer_other_file_units";
				public static final String REAL_NO_UNITS__NAME = "real_no_units";
				public static final String REAL_OWNED_UNITS__NAME = "real_owned_units";
				public static final String REAL_SAME_FILE_UNITS__NAME = "real_same_file_units";
				public static final String REAL_OTHER_FILE_UNITS__NAME = "real_other_file_units";
				public static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";
				public static final String LIST_1_REAL_OWNED_UNITS__NAME = "list_1_real_owned_units";
				public static final String LIST_1_REAL_SAME_FILE_UNITS__NAME = "list_1_real_same_file_units";
				public static final String LIST_1_REAL_OTHER_FILE_UNITS__NAME = "list_1_real_other_file_units";
				public static final URI INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.0");
				public static final URI INTEGER_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1");
				public static final URI INTEGER_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.2");
				public static final URI INTEGER_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.3");
				public static final URI LIST_1_INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.4");
				public static final URI LIST_1_INTEGER_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5");
				public static final URI LIST_1_INTEGER_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.6");
				public static final URI LIST_1_INTEGER_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.7");
				public static final URI REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.8");
				public static final URI REAL_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9");
				public static final URI REAL_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.10");
				public static final URI REAL_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.11");
				public static final URI LIST_1_REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.12");
				public static final URI LIST_1_REAL_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13");
				public static final URI LIST_1_REAL_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.14");
				public static final URI LIST_1_REAL_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.15");
				
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
				
				public RecordProperty(
						Optional<IntegerRange> integerNoUnits,
						Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits,
						Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits,
						Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits,
						Optional<List<IntegerRange>> list1IntegerNoUnits,
						Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits,
						Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits,
						Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits,
						Optional<RealRange> realNoUnits,
						Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits,
						Optional<RealRangeWithUnits<Time>> realSameFileUnits,
						Optional<RealRangeWithUnits<Mass>> realOtherFileUnits,
						Optional<List<RealRange>> list1RealNoUnits,
						Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits,
						Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits,
						Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits
				) {
					this.integerNoUnits = integerNoUnits;
					this.integerOwnedUnits = integerOwnedUnits;
					this.integerSameFileUnits = integerSameFileUnits;
					this.integerOtherFileUnits = integerOtherFileUnits;
					this.list1IntegerNoUnits = list1IntegerNoUnits;
					this.list1IntegerOwnedUnits = list1IntegerOwnedUnits;
					this.list1IntegerSameFileUnits = list1IntegerSameFileUnits;
					this.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits;
					this.realNoUnits = realNoUnits;
					this.realOwnedUnits = realOwnedUnits;
					this.realSameFileUnits = realSameFileUnits;
					this.realOtherFileUnits = realOtherFileUnits;
					this.list1RealNoUnits = list1RealNoUnits;
					this.list1RealOwnedUnits = list1RealOwnedUnits;
					this.list1RealSameFileUnits = list1RealSameFileUnits;
					this.list1RealOtherFileUnits = list1RealOtherFileUnits;
				}
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerRange> integerNoUnits_local;
					try {
						integerNoUnits_local = findFieldValue(recordValue, INTEGER_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRange(resolved, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerNoUnits_local = Optional.empty();
					}
					this.integerNoUnits = integerNoUnits_local;
					
					Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits_local;
					try {
						integerOwnedUnits_local = findFieldValue(recordValue, INTEGER_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerOwnedUnits_local = Optional.empty();
					}
					this.integerOwnedUnits = integerOwnedUnits_local;
					
					Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits_local;
					try {
						integerSameFileUnits_local = findFieldValue(recordValue, INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerSameFileUnits_local = Optional.empty();
					}
					this.integerSameFileUnits = integerSameFileUnits_local;
					
					Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits_local;
					try {
						integerOtherFileUnits_local = findFieldValue(recordValue, INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerOtherFileUnits_local = Optional.empty();
					}
					this.integerOtherFileUnits = integerOtherFileUnits_local;
					
					Optional<List<IntegerRange>> list1IntegerNoUnits_local;
					try {
						list1IntegerNoUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerNoUnits_local = Optional.empty();
					}
					this.list1IntegerNoUnits = list1IntegerNoUnits_local;
					
					Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits_local;
					try {
						list1IntegerOwnedUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerOwnedUnits_local = Optional.empty();
					}
					this.list1IntegerOwnedUnits = list1IntegerOwnedUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits_local;
					try {
						list1IntegerSameFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerSameFileUnits_local = Optional.empty();
					}
					this.list1IntegerSameFileUnits = list1IntegerSameFileUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits_local;
					try {
						list1IntegerOtherFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerOtherFileUnits_local = Optional.empty();
					}
					this.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits_local;
					
					Optional<RealRange> realNoUnits_local;
					try {
						realNoUnits_local = findFieldValue(recordValue, REAL_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRange(resolved, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realNoUnits_local = Optional.empty();
					}
					this.realNoUnits = realNoUnits_local;
					
					Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits_local;
					try {
						realOwnedUnits_local = findFieldValue(recordValue, REAL_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realOwnedUnits_local = Optional.empty();
					}
					this.realOwnedUnits = realOwnedUnits_local;
					
					Optional<RealRangeWithUnits<Time>> realSameFileUnits_local;
					try {
						realSameFileUnits_local = findFieldValue(recordValue, REAL_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realSameFileUnits_local = Optional.empty();
					}
					this.realSameFileUnits = realSameFileUnits_local;
					
					Optional<RealRangeWithUnits<Mass>> realOtherFileUnits_local;
					try {
						realOtherFileUnits_local = findFieldValue(recordValue, REAL_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realOtherFileUnits_local = Optional.empty();
					}
					this.realOtherFileUnits = realOtherFileUnits_local;
					
					Optional<List<RealRange>> list1RealNoUnits_local;
					try {
						list1RealNoUnits_local = findFieldValue(recordValue, LIST_1_REAL_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealNoUnits_local = Optional.empty();
					}
					this.list1RealNoUnits = list1RealNoUnits_local;
					
					Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits_local;
					try {
						list1RealOwnedUnits_local = findFieldValue(recordValue, LIST_1_REAL_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealOwnedUnits_local = Optional.empty();
					}
					this.list1RealOwnedUnits = list1RealOwnedUnits_local;
					
					Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits_local;
					try {
						list1RealSameFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealSameFileUnits_local = Optional.empty();
					}
					this.list1RealSameFileUnits = list1RealSameFileUnits_local;
					
					Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits_local;
					try {
						list1RealOtherFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
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
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!integerNoUnits.isPresent()
							&& !integerOwnedUnits.isPresent()
							&& !integerSameFileUnits.isPresent()
							&& !integerOtherFileUnits.isPresent()
							&& !list1IntegerNoUnits.isPresent()
							&& !list1IntegerOwnedUnits.isPresent()
							&& !list1IntegerSameFileUnits.isPresent()
							&& !list1IntegerOtherFileUnits.isPresent()
							&& !realNoUnits.isPresent()
							&& !realOwnedUnits.isPresent()
							&& !realSameFileUnits.isPresent()
							&& !realOtherFileUnits.isPresent()
							&& !list1RealNoUnits.isPresent()
							&& !list1RealOwnedUnits.isPresent()
							&& !list1RealSameFileUnits.isPresent()
							&& !list1RealOtherFileUnits.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					integerNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_NO_UNITS__URI, INTEGER_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression());
					});
					integerOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_OWNED_UNITS__URI, INTEGER_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					integerSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_SAME_FILE_UNITS__URI, INTEGER_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					integerOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_OTHER_FILE_UNITS__URI, INTEGER_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1IntegerNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_NO_UNITS__URI, LIST_1_INTEGER_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					list1IntegerOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_OWNED_UNITS__URI, LIST_1_INTEGER_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1IntegerSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_SAME_FILE_UNITS__URI, LIST_1_INTEGER_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1IntegerOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_OTHER_FILE_UNITS__URI, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					realNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_NO_UNITS__URI, REAL_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression());
					});
					realOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_OWNED_UNITS__URI, REAL_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					realSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_SAME_FILE_UNITS__URI, REAL_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					realOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_OTHER_FILE_UNITS__URI, REAL_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1RealNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_NO_UNITS__URI, LIST_1_REAL_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					list1RealOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_OWNED_UNITS__URI, LIST_1_REAL_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1RealSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_SAME_FILE_UNITS__URI, LIST_1_REAL_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1RealOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_OTHER_FILE_UNITS__URI, LIST_1_REAL_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
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
						builder.append(INTEGER_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerOwnedUnits.ifPresent(field -> {
						builder.append(INTEGER_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerSameFileUnits.ifPresent(field -> {
						builder.append(INTEGER_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerOtherFileUnits.ifPresent(field -> {
						builder.append(INTEGER_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1IntegerNoUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerOwnedUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerSameFileUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerOtherFileUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.realNoUnits.ifPresent(field -> {
						builder.append(REAL_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.realOwnedUnits.ifPresent(field -> {
						builder.append(REAL_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.realSameFileUnits.ifPresent(field -> {
						builder.append(REAL_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.realOtherFileUnits.ifPresent(field -> {
						builder.append(REAL_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1RealNoUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealOwnedUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealSameFileUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealOtherFileUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum IntegerOwnedUnits_FieldType implements GeneratedUnits<IntegerOwnedUnits_FieldType> {
					CM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					M(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private IntegerOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
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
					public double getFactorTo(IntegerOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1IntegerOwnedUnits_FieldType implements GeneratedUnits<List1IntegerOwnedUnits_FieldType> {
					M(1.0, "m", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					KM(1000.0, "km", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1IntegerOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
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
					public double getFactorTo(List1IntegerOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum RealOwnedUnits_FieldType implements GeneratedUnits<RealOwnedUnits_FieldType> {
					MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private RealOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
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
					public double getFactorTo(RealOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1RealOwnedUnits_FieldType implements GeneratedUnits<List1RealOwnedUnits_FieldType> {
					MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					CG(10.0, "cg", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1RealOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
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
					public double getFactorTo(List1RealOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(rangeTest, otherPs))
		assertEquals("src-gen/rangetest", results.packagePath)
		assertEquals(7, results.classes.size)
		
		assertEquals("RangeTest.java", results.classes.get(0).fileName)
		assertEquals(rangeTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(2).contents)
		
		assertEquals("List1IntegerOwnedUnits.java", results.classes.get(3).fileName)
		assertEquals(list1IntegerOwnedUnits.toString, results.classes.get(3).contents)
		
		assertEquals("RealOwnedUnits.java", results.classes.get(4).fileName)
		assertEquals(realOwnedUnits.toString, results.classes.get(4).contents)
		
		assertEquals("List1RealOwnedUnits.java", results.classes.get(5).fileName)
		assertEquals(list1RealOwnedUnits.toString, results.classes.get(5).contents)
		
		assertEquals("RecordProperty.java", results.classes.get(6).fileName)
		assertEquals(recordProperty.toString, results.classes.get(6).contents)
	}
}