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
			package stringtest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class StringTest {
				public static final String STRING_TEST__NAME = "string_test";
				
				public static final String OWNED_STRING__NAME = "owned_string";
				public static final String REFERENCED_STRING_LOCAL__NAME = "referenced_string_local";
				public static final String REFERENCED_STRING_OTHER__NAME = "referenced_string_other";
				public static final String LIST_1_STRING__NAME = "list_1_string";
				public static final String LIST_5_STRING__NAME = "list_5_string";
				
				public static Optional<String> getOwnedString(NamedElement lookupContext) {
					return getOwnedString(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getOwnedString(NamedElement lookupContext, Mode mode) {
					return getOwnedString(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getOwnedString(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "string_test::owned_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOwnedString_EObject(NamedElement lookupContext) {
					String name = "string_test::owned_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getReferencedStringLocal(NamedElement lookupContext) {
					return getReferencedStringLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getReferencedStringLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedStringLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getReferencedStringLocal(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "string_test::referenced_string_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferencedStringLocal_EObject(NamedElement lookupContext) {
					String name = "string_test::referenced_string_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getReferencedStringOther(NamedElement lookupContext) {
					return getReferencedStringOther(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getReferencedStringOther(NamedElement lookupContext, Mode mode) {
					return getReferencedStringOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getReferencedStringOther(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "string_test::referenced_string_other";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferencedStringOther_EObject(NamedElement lookupContext) {
					String name = "string_test::referenced_string_other";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext) {
					return getList1String(lookupContext, Optional.empty());
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext, Mode mode) {
					return getList1String(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "string_test::list_1_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((StringLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1String_EObject(NamedElement lookupContext) {
					String name = "string_test::list_1_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext) {
					return getList5String(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext, Mode mode) {
					return getList5String(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "string_test::list_5_string";
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
											return ((StringLiteral) resolved5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5String_EObject(NamedElement lookupContext) {
					String name = "string_test::list_5_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(stringTest, otherPs))
		assertEquals("src-gen/stringtest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("StringTest.java", results.classes.head.fileName)
		assertEquals(stringTestClass.toString, results.classes.head.contents)
	}
}