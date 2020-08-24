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
class RealWithUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRealWithUnits() {
		val otherPs = '''
			property set other_ps is
				mass: type units (g, kg => g * 1000);
			end other_ps;
		'''
		val realWithUnitsTest = '''
			property set real_with_units_test is
				with other_ps;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				owned: aadlreal units (B, KiB => B * 1024) applies to (all);
				same_file: aadlreal units real_with_units_test::time applies to (all);
				other_file: aadlreal units other_ps::mass applies to (all);
				
				list_1_owned: list of aadlreal units (mg, g => mg * 1000) applies to (all);
				list_1_same_file: list of aadlreal units real_with_units_test::time applies to (all);
				list_1_other_file: list of aadlreal units other_ps::mass applies to (all);
				
				record_property: record (
					owned: aadlreal units (hour, day => hour * 24);
					same_file: aadlreal units real_with_units_test::time;
					other_file: aadlreal units other_ps::mass;
					
					list_1_owned: list of aadlreal units (ml, l => ml * 1000);
					list_1_same_file: list of aadlreal units real_with_units_test::time;
					list_1_other_file: list of aadlreal units other_ps::mass;
				) applies to (all);
			end real_with_units_test;
		'''
		val realWithUnitsTestClass = '''
			package realwithunitstest;
			
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
			import org.osate.pluginsupport.properties.RealWithUnits;
			
			import otherps.Mass;
			
			public class RealWithUnitsTest {
				public static final String REAL_WITH_UNITS_TEST__NAME = "real_with_units_test";
				
				public static final String OWNED__NAME = "owned";
				public static final String SAME_FILE__NAME = "same_file";
				public static final String OTHER_FILE__NAME = "other_file";
				public static final String LIST_1_OWNED__NAME = "list_1_owned";
				public static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";
				public static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";
				public static final String RECORD_PROPERTY__NAME = "record_property";
				
				public static Optional<RealWithUnits<Owned>> getOwned(NamedElement lookupContext) {
					return getOwned(lookupContext, Optional.empty());
				}
				
				public static Optional<RealWithUnits<Owned>> getOwned(NamedElement lookupContext, Mode mode) {
					return getOwned(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealWithUnits<Owned>> getOwned(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "real_with_units_test::owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealWithUnits<>(resolved, Owned.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOwned_EObject(NamedElement lookupContext) {
					String name = "real_with_units_test::owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealWithUnits<Time>> getSameFile(NamedElement lookupContext) {
					return getSameFile(lookupContext, Optional.empty());
				}
				
				public static Optional<RealWithUnits<Time>> getSameFile(NamedElement lookupContext, Mode mode) {
					return getSameFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealWithUnits<Time>> getSameFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "real_with_units_test::same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealWithUnits<>(resolved, Time.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getSameFile_EObject(NamedElement lookupContext) {
					String name = "real_with_units_test::same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement lookupContext) {
					return getOtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Mode mode) {
					return getOtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "real_with_units_test::other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealWithUnits<>(resolved, Mass.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOtherFile_EObject(NamedElement lookupContext) {
					String name = "real_with_units_test::other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext) {
					return getList1Owned(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Mode mode) {
					return getList1Owned(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "real_with_units_test::list_1_owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealWithUnits<>(resolved1, List1Owned.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Owned_EObject(NamedElement lookupContext) {
					String name = "real_with_units_test::list_1_owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement lookupContext) {
					return getList1SameFile(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Mode mode) {
					return getList1SameFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "real_with_units_test::list_1_same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealWithUnits<>(resolved1, Time.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1SameFile_EObject(NamedElement lookupContext) {
					String name = "real_with_units_test::list_1_same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext) {
					return getList1OtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Mode mode) {
					return getList1OtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "real_with_units_test::list_1_other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealWithUnits<>(resolved1, Mass.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OtherFile_EObject(NamedElement lookupContext) {
					String name = "real_with_units_test::list_1_other_file";
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
					String name = "real_with_units_test::record_property";
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
					String name = "real_with_units_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val time = '''
			package realwithunitstest;
			
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
		val owned = '''
			package realwithunitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Owned implements GeneratedUnits<Owned> {
				B(1.0, "B", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
				KIB(1024.0, "KiB", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Owned(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static Owned valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(Owned target) {
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
		val list1Owned = '''
			package realwithunitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1Owned implements GeneratedUnits<List1Owned> {
				MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
				G(1000.0, "g", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1Owned(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1Owned valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1Owned target) {
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
			package realwithunitstest;
			
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
			import org.osate.pluginsupport.properties.RealWithUnits;
			
			import otherps.Mass;
			
			public class RecordProperty extends GeneratedRecord {
				public static final String OWNED__NAME = "owned";
				public static final String SAME_FILE__NAME = "same_file";
				public static final String OTHER_FILE__NAME = "other_file";
				public static final String LIST_1_OWNED__NAME = "list_1_owned";
				public static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";
				public static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";
				public static final URI OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0");
				public static final URI SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.1");
				public static final URI OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.2");
				public static final URI LIST_1_OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3");
				public static final URI LIST_1_SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.4");
				public static final URI LIST_1_OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.5");
				
				private final Optional<RealWithUnits<Owned_FieldType>> owned;
				private final Optional<RealWithUnits<Time>> sameFile;
				private final Optional<RealWithUnits<Mass>> otherFile;
				private final Optional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned;
				private final Optional<List<RealWithUnits<Time>>> list1SameFile;
				private final Optional<List<RealWithUnits<Mass>>> list1OtherFile;
				
				public RecordProperty(
						Optional<RealWithUnits<Owned_FieldType>> owned,
						Optional<RealWithUnits<Time>> sameFile,
						Optional<RealWithUnits<Mass>> otherFile,
						Optional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned,
						Optional<List<RealWithUnits<Time>>> list1SameFile,
						Optional<List<RealWithUnits<Mass>>> list1OtherFile
				) {
					this.owned = owned;
					this.sameFile = sameFile;
					this.otherFile = otherFile;
					this.list1Owned = list1Owned;
					this.list1SameFile = list1SameFile;
					this.list1OtherFile = list1OtherFile;
				}
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<RealWithUnits<Owned_FieldType>> owned_local;
					try {
						owned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealWithUnits<>(resolved, Owned_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						owned_local = Optional.empty();
					}
					this.owned = owned_local;
					
					Optional<RealWithUnits<Time>> sameFile_local;
					try {
						sameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						sameFile_local = Optional.empty();
					}
					this.sameFile = sameFile_local;
					
					Optional<RealWithUnits<Mass>> otherFile_local;
					try {
						otherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						otherFile_local = Optional.empty();
					}
					this.otherFile = otherFile_local;
					
					Optional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned_local;
					try {
						list1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealWithUnits<>(resolved1, List1Owned_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1Owned_local = Optional.empty();
					}
					this.list1Owned = list1Owned_local;
					
					Optional<List<RealWithUnits<Time>>> list1SameFile_local;
					try {
						list1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1SameFile_local = Optional.empty();
					}
					this.list1SameFile = list1SameFile_local;
					
					Optional<List<RealWithUnits<Mass>>> list1OtherFile_local;
					try {
						list1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1OtherFile_local = Optional.empty();
					}
					this.list1OtherFile = list1OtherFile_local;
				}
				
				public Optional<RealWithUnits<Owned_FieldType>> getOwned() {
					return owned;
				}
				
				public Optional<RealWithUnits<Time>> getSameFile() {
					return sameFile;
				}
				
				public Optional<RealWithUnits<Mass>> getOtherFile() {
					return otherFile;
				}
				
				public Optional<List<RealWithUnits<List1Owned_FieldType>>> getList1Owned() {
					return list1Owned;
				}
				
				public Optional<List<RealWithUnits<Time>>> getList1SameFile() {
					return list1SameFile;
				}
				
				public Optional<List<RealWithUnits<Mass>>> getList1OtherFile() {
					return list1OtherFile;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!owned.isPresent()
							&& !sameFile.isPresent()
							&& !otherFile.isPresent()
							&& !list1Owned.isPresent()
							&& !list1SameFile.isPresent()
							&& !list1OtherFile.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					owned.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED__URI, OWNED__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					sameFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, SAME_FILE__URI, SAME_FILE__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					otherFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OTHER_FILE__URI, OTHER_FILE__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1Owned.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_OWNED__URI, LIST_1_OWNED__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1SameFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_SAME_FILE__URI, LIST_1_SAME_FILE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1OtherFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_OTHER_FILE__URI, LIST_1_OTHER_FILE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							owned,
							sameFile,
							otherFile,
							list1Owned,
							list1SameFile,
							list1OtherFile
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
					return Objects.equals(this.owned, other.owned)
							&& Objects.equals(this.sameFile, other.sameFile)
							&& Objects.equals(this.otherFile, other.otherFile)
							&& Objects.equals(this.list1Owned, other.list1Owned)
							&& Objects.equals(this.list1SameFile, other.list1SameFile)
							&& Objects.equals(this.list1OtherFile, other.list1OtherFile);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.owned.ifPresent(field -> {
						builder.append(OWNED__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.sameFile.ifPresent(field -> {
						builder.append(SAME_FILE__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.otherFile.ifPresent(field -> {
						builder.append(OTHER_FILE__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1Owned.ifPresent(field -> {
						builder.append(LIST_1_OWNED__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1SameFile.ifPresent(field -> {
						builder.append(LIST_1_SAME_FILE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1OtherFile.ifPresent(field -> {
						builder.append(LIST_1_OTHER_FILE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum Owned_FieldType implements GeneratedUnits<Owned_FieldType> {
					HOUR(1.0, "hour", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
					DAY(24.0, "day", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private Owned_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(Owned_FieldType target) {
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
				
				public enum List1Owned_FieldType implements GeneratedUnits<List1Owned_FieldType> {
					ML(1.0, "ml", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
					L(1000.0, "l", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1Owned_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static List1Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(List1Owned_FieldType target) {
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(realWithUnitsTest, otherPs))
		assertEquals("src-gen/realwithunitstest", results.packagePath)
		assertEquals(5, results.classes.size)
		
		assertEquals("RealWithUnitsTest.java", results.classes.get(0).fileName)
		assertEquals(realWithUnitsTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("Owned.java", results.classes.get(2).fileName)
		assertEquals(owned.toString, results.classes.get(2).contents)
		
		assertEquals("List1Owned.java", results.classes.get(3).fileName)
		assertEquals(list1Owned.toString, results.classes.get(3).contents)
		
		assertEquals("RecordProperty.java", results.classes.get(4).fileName)
		assertEquals(recordProperty.toString, results.classes.get(4).contents)
	}
}