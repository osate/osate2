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
class StringTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testString() {
		val otherPs = '''
			property set other_ps is
				other_string_type: type aadlstring;
			end other_ps;
		'''
		val stringTest = '''
			property set string_test is
				with other_ps;
				
				local_string_type: type aadlstring;
				
				owned_string: aadlstring applies to (all);
				referenced_string_local: string_test::local_string_type applies to (all);
				referenced_string_other: other_ps::other_string_type applies to (all);
				
				list_1_string: list of other_ps::other_string_type applies to (all);
				list_5_string: list of list of list of list of list of other_ps::other_string_type applies to (all);
			end string_test;
		'''
		val stringTestClass = '''
			package string_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			public class StringTest {
				public static Optional<String> getOwnedString(InstanceObject instanceObject) {
					String name = "string_test::owned_string";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((StringLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<String> getReferencedStringLocal(InstanceObject instanceObject) {
					String name = "string_test::referenced_string_local";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((StringLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<String> getReferencedStringOther(InstanceObject instanceObject) {
					String name = "string_test::referenced_string_other";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((StringLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<String>> getList1String(InstanceObject instanceObject) {
					String name = "string_test::list_1_string";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((StringLiteral) element1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(InstanceObject instanceObject) {
					String name = "string_test::list_5_string";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
								return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
									return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
										return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
											return ((StringLiteral) element5).getValue();
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(stringTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("StringTest.java", results.head.fileName)
		assertEquals(stringTestClass.toString, results.head.contents)
	}
}