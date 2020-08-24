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
			package referencetest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class ReferenceTest {
				public static final String REFERENCE_TEST__NAME = "reference_test";
				
				public static final String OWNED_REFERENCE__NAME = "owned_reference";
				public static final String REFERENCED_REFERENCE_LOCAL__NAME = "referenced_reference_local";
				public static final String REFERENCED_REFERENCE_OTHER__NAME = "referenced_reference_other";
				public static final String LIST_1_REFERENCE__NAME = "list_1_reference";
				public static final String LIST_5_REFERENCE__NAME = "list_5_reference";
				
				public static Optional<InstanceObject> getOwnedReference(NamedElement lookupContext) {
					return getOwnedReference(lookupContext, Optional.empty());
				}
				
				public static Optional<InstanceObject> getOwnedReference(NamedElement lookupContext, Mode mode) {
					return getOwnedReference(lookupContext, Optional.of(mode));
				}
				
				public static Optional<InstanceObject> getOwnedReference(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "reference_test::owned_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOwnedReference_EObject(NamedElement lookupContext) {
					String name = "reference_test::owned_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement lookupContext) {
					return getReferencedReferenceLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedReferenceLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "reference_test::referenced_reference_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferencedReferenceLocal_EObject(NamedElement lookupContext) {
					String name = "reference_test::referenced_reference_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<InstanceObject> getReferencedReferenceOther(NamedElement lookupContext) {
					return getReferencedReferenceOther(lookupContext, Optional.empty());
				}
				
				public static Optional<InstanceObject> getReferencedReferenceOther(NamedElement lookupContext, Mode mode) {
					return getReferencedReferenceOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<InstanceObject> getReferencedReferenceOther(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "reference_test::referenced_reference_other";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferencedReferenceOther_EObject(NamedElement lookupContext) {
					String name = "reference_test::referenced_reference_other";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext) {
					return getList1Reference(lookupContext, Optional.empty());
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext, Mode mode) {
					return getList1Reference(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "reference_test::list_1_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Reference_EObject(NamedElement lookupContext) {
					String name = "reference_test::list_1_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement lookupContext) {
					return getList5Reference(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement lookupContext, Mode mode) {
					return getList5Reference(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "reference_test::list_5_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
										return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
											PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
											return ((InstanceReferenceValue) resolved5).getReferencedInstanceObject();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5Reference_EObject(NamedElement lookupContext) {
					String name = "reference_test::list_5_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(referenceTest, otherPs))
		assertEquals("src-gen/referencetest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("ReferenceTest.java", results.classes.head.fileName)
		assertEquals(referenceTestClass.toString, results.classes.head.contents)
	}
}