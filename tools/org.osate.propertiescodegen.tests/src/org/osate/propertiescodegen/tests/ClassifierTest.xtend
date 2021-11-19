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
class ClassifierTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testClassifier() {
		val otherPs = '''
			property set other_ps is
				other_classifier_type: type classifier;
			end other_ps;
		'''
		val classifierTest = '''
			property set classifier_test is
				with other_ps;
				
				local_classifier_type: type classifier;
				
				owned_classifier: classifier applies to (all);
				referenced_classifier_local: classifier_test::local_classifier_type applies to (all);
				referenced_classifier_other: other_ps::other_classifier_type applies to (all);
				
				list_1_classifier: list of other_ps::other_classifier_type applies to (all);
				list_5_classifier: list of list of list of list of list of other_ps::other_classifier_type applies to (all);
			end classifier_test;
		'''
		val classifierTestClass = '''
			package classifiertest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class ClassifierTest {
				public static final String CLASSIFIER_TEST__NAME = "classifier_test";
				
				public static final String OWNED_CLASSIFIER__NAME = "owned_classifier";
				public static final String REFERENCED_CLASSIFIER_LOCAL__NAME = "referenced_classifier_local";
				public static final String REFERENCED_CLASSIFIER_OTHER__NAME = "referenced_classifier_other";
				public static final String LIST_1_CLASSIFIER__NAME = "list_1_classifier";
				public static final String LIST_5_CLASSIFIER__NAME = "list_5_classifier";
				
				// Lookup methods for classifier_test::owned_classifier
				
				public static boolean acceptsOwnedClassifier(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedClassifier_Property(lookupContext));
				}
				
				public static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext) {
					return getOwnedClassifier(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext, Mode mode) {
					return getOwnedClassifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedClassifier_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOwnedClassifier_Property(NamedElement lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + OWNED_CLASSIFIER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedClassifier_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedClassifier_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::referenced_classifier_local
				
				public static boolean acceptsReferencedClassifierLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedClassifierLocal_Property(lookupContext));
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext) {
					return getReferencedClassifierLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedClassifierLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedClassifierLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedClassifierLocal_Property(NamedElement lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + REFERENCED_CLASSIFIER_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedClassifierLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedClassifierLocal_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::referenced_classifier_other
				
				public static boolean acceptsReferencedClassifierOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedClassifierOther_Property(lookupContext));
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext) {
					return getReferencedClassifierOther(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext, Mode mode) {
					return getReferencedClassifierOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedClassifierOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedClassifierOther_Property(NamedElement lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + REFERENCED_CLASSIFIER_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedClassifierOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedClassifierOther_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::list_1_classifier
				
				public static boolean acceptsList1Classifier(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Classifier_Property(lookupContext));
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext) {
					return getList1Classifier(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Mode mode) {
					return getList1Classifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Classifier_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ClassifierValue) resolved1).getClassifier();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1Classifier_Property(NamedElement lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + LIST_1_CLASSIFIER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Classifier_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Classifier_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::list_5_classifier
				
				public static boolean acceptsList5Classifier(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5Classifier_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext) {
					return getList5Classifier(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext, Mode mode) {
					return getList5Classifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5Classifier_Property(lookupContext);
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
											return ((ClassifierValue) resolved5).getClassifier();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList5Classifier_Property(NamedElement lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + LIST_5_CLASSIFIER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5Classifier_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5Classifier_Property(lookupContext));
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(classifierTest, otherPs))
		assertEquals("src-gen/classifiertest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("ClassifierTest.java", results.classes.head.fileName)
		assertEquals(classifierTestClass.toString, results.classes.head.contents)
	}
}