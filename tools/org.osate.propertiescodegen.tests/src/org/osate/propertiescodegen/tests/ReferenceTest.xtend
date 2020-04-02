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
class ReferenceTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testReference() {
		val otherPs = '''
			property set other_ps is
				other_boolean_type: type aadlboolean;
				other_string_type: type aadlstring;
				other_classifier_type: type classifier;
				other_integer_no_units_type: type aadlinteger;
				other_real_no_units_type: type aadlreal;
				other_reference_type: type reference;
			end other_ps;
		'''
		val referenceTest = '''
			property set reference_test is
				with other_ps;
				
				local_reference_type: type reference;
				
				owned_reference: reference applies to (all);
				referenced_reference_local: reference_test::local_reference_type applies to (all);
				referenced_reference_other: other_ps::other_reference_type applies to (all);
				
				list_1_reference: list of other_ps::other_reference_type applies to (all);
				list_5_reference: list of list of list of list of list of other_ps::other_reference_type applies to (all);
			end reference_test;
		'''
		val referenceTestClass = '''
			package reference_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			public class ReferenceTest {
				public static Optional<InstanceObject> getOwnedReference(NamedElement namedElement) {
					String name = "reference_test::owned_reference";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOwnedReference_EObject(NamedElement namedElement) {
					String name = "reference_test::owned_reference";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement namedElement) {
					String name = "reference_test::referenced_reference_local";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferencedReferenceLocal_EObject(NamedElement namedElement) {
					String name = "reference_test::referenced_reference_local";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<InstanceObject> getReferencedReferenceOther(NamedElement namedElement) {
					String name = "reference_test::referenced_reference_other";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferencedReferenceOther_EObject(NamedElement namedElement) {
					String name = "reference_test::referenced_reference_other";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement namedElement) {
					String name = "reference_test::list_1_reference";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((InstanceReferenceValue) element1).getReferencedInstanceObject();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Reference_EObject(NamedElement namedElement) {
					String name = "reference_test::list_1_reference";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement namedElement) {
					String name = "reference_test::list_5_reference";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
								return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
									return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
										return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
											return ((InstanceReferenceValue) element5).getReferencedInstanceObject();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5Reference_EObject(NamedElement namedElement) {
					String name = "reference_test::list_5_reference";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(referenceTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("ReferenceTest.java", results.head.fileName)
		assertEquals(referenceTestClass.toString, results.head.contents)
	}
}