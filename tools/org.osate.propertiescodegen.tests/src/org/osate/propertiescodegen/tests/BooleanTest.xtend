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
class BooleanTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testBoolean() {
		val otherPs = '''
			property set other_ps is
				other_boolean_type: type aadlboolean;
			end other_ps;
		'''
		val booleanTest = '''
			property set boolean_test is
				with other_ps;
				
				local_boolean_type: type aadlboolean;
				
				owned_boolean: aadlboolean applies to (all);
				referenced_boolean_local: boolean_test::local_boolean_type applies to (all);
				referenced_boolean_other: other_ps::other_boolean_type applies to (all);
				
				list_1_boolean: list of other_ps::other_boolean_type applies to (all);
				list_5_boolean: list of list of list of list of list of other_ps::other_boolean_type applies to (all);
			end boolean_test;
		'''
		val booleanTestClass = '''
			package boolean_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			public class BooleanTest {
				public static Optional<Boolean> getOwnedBoolean(NamedElement namedElement) {
					String name = "boolean_test::owned_boolean";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((BooleanLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Boolean> getReferencedBooleanLocal(NamedElement namedElement) {
					String name = "boolean_test::referenced_boolean_local";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((BooleanLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Boolean> getReferencedBooleanOther(NamedElement namedElement) {
					String name = "boolean_test::referenced_boolean_other";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((BooleanLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement namedElement) {
					String name = "boolean_test::list_1_boolean";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((BooleanLiteral) element1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement namedElement) {
					String name = "boolean_test::list_5_boolean";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
								return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
									return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
										return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
											return ((BooleanLiteral) element5).getValue();
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(booleanTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("BooleanTest.java", results.head.fileName)
		assertEquals(booleanTestClass.toString, results.head.contents)
	}
}