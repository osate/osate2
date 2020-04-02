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
class IntegerNoUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testIntegerNoUnits() {
		val otherPs = '''
			property set other_ps is
				other_integer_no_units_type: type aadlinteger;
			end other_ps;
		'''
		val integerNoUnitsTest = '''
			property set integer_no_units_test is
				with other_ps;
				
				local_integer_type: type aadlinteger;
				
				owned_integer: aadlinteger applies to (all);
				referenced_integer_local: integer_no_units_test::local_integer_type applies to (all);
				referenced_integer_other: other_ps::other_integer_no_units_type applies to (all);
				
				list_1_integer: list of other_ps::other_integer_no_units_type applies to (all);
				list_5_integer: list of list of list of list of list of other_ps::other_integer_no_units_type applies to (all);
			end integer_no_units_test;
		'''
		val integerNoUnitsTestClass = '''
			package integer_no_units_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			public class IntegerNoUnitsTest {
				public static OptionalLong getOwnedInteger(NamedElement namedElement) {
					String name = "integer_no_units_test::owned_integer";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return OptionalLong.of(((IntegerLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static PropertyExpression getOwnedInteger_EObject(NamedElement namedElement) {
					String name = "integer_no_units_test::owned_integer";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement namedElement) {
					String name = "integer_no_units_test::referenced_integer_local";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return OptionalLong.of(((IntegerLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static PropertyExpression getReferencedIntegerLocal_EObject(NamedElement namedElement) {
					String name = "integer_no_units_test::referenced_integer_local";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement namedElement) {
					String name = "integer_no_units_test::referenced_integer_other";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return OptionalLong.of(((IntegerLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static PropertyExpression getReferencedIntegerOther_EObject(NamedElement namedElement) {
					String name = "integer_no_units_test::referenced_integer_other";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement namedElement) {
					String name = "integer_no_units_test::list_1_integer";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((IntegerLiteral) element1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Integer_EObject(NamedElement namedElement) {
					String name = "integer_no_units_test::list_1_integer";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement namedElement) {
					String name = "integer_no_units_test::list_5_integer";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
								return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
									return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
										return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
											return ((IntegerLiteral) element5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5Integer_EObject(NamedElement namedElement) {
					String name = "integer_no_units_test::list_5_integer";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(integerNoUnitsTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("IntegerNoUnitsTest.java", results.head.fileName)
		assertEquals(integerNoUnitsTestClass.toString, results.head.contents)
	}
}