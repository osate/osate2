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
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RealNoUnitsTest {
				public static OptionalDouble getOwnedReal(NamedElement lookupContext) {
					String name = "real_no_units_test::owned_real";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return OptionalDouble.of(((RealLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static PropertyExpression getOwnedReal_EObject(NamedElement lookupContext) {
					String name = "real_no_units_test::owned_real";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static OptionalDouble getReferencedRealLocal(NamedElement lookupContext) {
					String name = "real_no_units_test::referenced_real_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return OptionalDouble.of(((RealLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static PropertyExpression getReferencedRealLocal_EObject(NamedElement lookupContext) {
					String name = "real_no_units_test::referenced_real_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static OptionalDouble getReferencedRealOther(NamedElement lookupContext) {
					String name = "real_no_units_test::referenced_real_other";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return OptionalDouble.of(((RealLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static PropertyExpression getReferencedRealOther_EObject(NamedElement lookupContext) {
					String name = "real_no_units_test::referenced_real_other";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Double>> getList1Real(NamedElement lookupContext) {
					String name = "real_no_units_test::list_1_real";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return ((RealLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Real_EObject(NamedElement lookupContext) {
					String name = "real_no_units_test::list_1_real";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<Double>>>>>> getList5Real(NamedElement lookupContext) {
					String name = "real_no_units_test::list_5_real";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext);
										return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
											PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext);
											return ((RealLiteral) resolved5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5Real_EObject(NamedElement lookupContext) {
					String name = "real_no_units_test::list_5_real";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(realNoUnitsTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("RealNoUnitsTest.java", results.head.fileName)
		assertEquals(realNoUnitsTestClass.toString, results.head.contents)
	}
}