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
class RealNoUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRealNoUnits() {
		val otherPs = '''
			property set other_ps is
				other_real_no_units_type: type aadlreal;
			end other_ps;
		'''
		val realNoUnitsTest = '''
			property set real_no_units_test is
				with other_ps;
				
				local_real_type: type aadlreal;
				
				owned_real: aadlreal applies to (all);
				referenced_real_local: real_no_units_test::local_real_type applies to (all);
				referenced_real_other: other_ps::other_real_no_units_type applies to (all);
				
				list_1_real: list of other_ps::other_real_no_units_type applies to (all);
				list_5_real: list of list of list of list of list of other_ps::other_real_no_units_type applies to (all);
			end real_no_units_test;
		'''
		val realNoUnitsTestClass = '''
			package real_no_units_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.OptionalDouble;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			public class RealNoUnitsTest {
				public static OptionalDouble getOwnedReal(NamedElement namedElement) {
					String name = "real_no_units_test::owned_real";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return OptionalDouble.of(((RealLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static OptionalDouble getReferencedRealLocal(NamedElement namedElement) {
					String name = "real_no_units_test::referenced_real_local";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return OptionalDouble.of(((RealLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static OptionalDouble getReferencedRealOther(NamedElement namedElement) {
					String name = "real_no_units_test::referenced_real_other";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return OptionalDouble.of(((RealLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static Optional<List<Double>> getList1Real(NamedElement namedElement) {
					String name = "real_no_units_test::list_1_real";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((RealLiteral) element1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<List<List<List<List<Double>>>>>> getList5Real(NamedElement namedElement) {
					String name = "real_no_units_test::list_5_real";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
								return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
									return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
										return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
											return ((RealLiteral) element5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(realNoUnitsTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("RealNoUnitsTest.java", results.head.fileName)
		assertEquals(realNoUnitsTestClass.toString, results.head.contents)
	}
}