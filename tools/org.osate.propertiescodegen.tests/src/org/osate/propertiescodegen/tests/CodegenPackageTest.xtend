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
class CodegenPackageTest {
	val static CODEGEN_PACKAGE_BASE = '''
		-- other comments
		-- @codegen-package org.osate.properties.codegenpackage
		property set codegen_package_base is
			speed: type units (light, ridiculous => light * 1000, ludicrous => ridiculous * 1000);
			record_type: type record (bool: aadlboolean;);
			record_def: codegen_package_base::record_type applies to (all);
		end codegen_package_base;
	'''
	
	val static CODEGEN_PACKAGE_SAME = '''
		-- @codegen-package org.osate.properties.codegenpackage
		property set codegen_package_same is
			with codegen_package_base;
			
			record_def: codegen_package_base::record_type applies to (all);
			int_def: aadlinteger units codegen_package_base::speed applies to (all);
		end codegen_package_same;
	'''
	
	val static CODEGEN_PACKAGE_OTHER = '''
		-- @codegen-package org.osate.properties.codegenpackage.other
		property set codegen_package_other is
			with codegen_package_base;
			
			record_def: codegen_package_base::record_type applies to (all);
			int_def: aadlinteger units codegen_package_base::speed applies to (all);
		end codegen_package_other;
	'''
	
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testCustomPackage() {
		val codegenPackageBaseClass = '''
			package org.osate.properties.codegenpackage;
			
			import java.util.Optional;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class CodegenPackageBase {
				public static final String CODEGEN_PACKAGE_BASE__NAME = "codegen_package_base";
				
				public static final String RECORD_DEF__NAME = "record_def";
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext) {
					return getRecordDef(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext, Mode mode) {
					return getRecordDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "codegen_package_base::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordType(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
					String name = "codegen_package_base::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val speed = '''
			package org.osate.properties.codegenpackage;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Speed implements GeneratedUnits<Speed> {
				LIGHT(1.0, "light", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				RIDICULOUS(1000.0, "ridiculous", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				LUDICROUS(1000000.0, "ludicrous", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Speed(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static Speed valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(Speed target) {
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
		val recordType = '''
			package org.osate.properties.codegenpackage;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedRecord;
			
			public class RecordType extends GeneratedRecord {
				public static final String BOOL__NAME = "bool";
				public static final URI BOOL__URI = URI.createURI("__synthetic0.aadl#/0/@ownedPropertyType.1/@ownedField.0");
				
				private final Optional<Boolean> bool;
				
				public RecordType(Optional<Boolean> bool) {
					this.bool = bool;
				}
				
				public RecordType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> bool_local;
					try {
						bool_local = findFieldValue(recordValue, BOOL__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((BooleanLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						bool_local = Optional.empty();
					}
					this.bool = bool_local;
				}
				
				public Optional<Boolean> getBool() {
					return bool;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!bool.isPresent()) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					bool.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, BOOL__URI, BOOL__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(bool);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordType)) {
						return false;
					}
					RecordType other = (RecordType) obj;
					return Objects.equals(this.bool, other.bool);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.bool.ifPresent(field -> {
						builder.append(BOOL__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(CODEGEN_PACKAGE_BASE))
		assertEquals("src-gen/org/osate/properties/codegenpackage", results.packagePath)
		assertEquals(3, results.classes.size)
		
		assertEquals("CodegenPackageBase.java", results.classes.get(0).fileName)
		assertEquals(codegenPackageBaseClass.toString, results.classes.get(0).contents)
		
		assertEquals("Speed.java", results.classes.get(1).fileName)
		assertEquals(speed.toString, results.classes.get(1).contents)
		
		assertEquals("RecordType.java", results.classes.get(2).fileName)
		assertEquals(recordType.toString, results.classes.get(2).contents)
	}
	
	@Test
	def void testReferenceToSameCustomPackage() {
		val codegenPackageSameClass = '''
			package org.osate.properties.codegenpackage;
			
			import java.util.Optional;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			public class CodegenPackageSame {
				public static final String CODEGEN_PACKAGE_SAME__NAME = "codegen_package_same";
				
				public static final String RECORD_DEF__NAME = "record_def";
				public static final String INT_DEF__NAME = "int_def";
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext) {
					return getRecordDef(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext, Mode mode) {
					return getRecordDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "codegen_package_same::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordType(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
					String name = "codegen_package_same::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext) {
					return getIntDef(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Mode mode) {
					return getIntDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "codegen_package_same::int_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Speed.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntDef_EObject(NamedElement lookupContext) {
					String name = "codegen_package_same::int_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(CODEGEN_PACKAGE_SAME, CODEGEN_PACKAGE_BASE))
		assertEquals("src-gen/org/osate/properties/codegenpackage", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("CodegenPackageSame.java", results.classes.head.fileName)
		assertEquals(codegenPackageSameClass.toString, results.classes.head.contents)
	}
	
	@Test
	def void testReferenceToOtherCustomPackage() {
		val codegenPackageOtherClass = '''
			package org.osate.properties.codegenpackage.other;
			
			import java.util.Optional;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			import org.osate.properties.codegenpackage.RecordType;
			import org.osate.properties.codegenpackage.Speed;
			
			public class CodegenPackageOther {
				public static final String CODEGEN_PACKAGE_OTHER__NAME = "codegen_package_other";
				
				public static final String RECORD_DEF__NAME = "record_def";
				public static final String INT_DEF__NAME = "int_def";
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext) {
					return getRecordDef(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext, Mode mode) {
					return getRecordDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordType> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "codegen_package_other::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordType(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
					String name = "codegen_package_other::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext) {
					return getIntDef(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Mode mode) {
					return getIntDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "codegen_package_other::int_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Speed.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntDef_EObject(NamedElement lookupContext) {
					String name = "codegen_package_other::int_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(CODEGEN_PACKAGE_OTHER, CODEGEN_PACKAGE_BASE))
		assertEquals("src-gen/org/osate/properties/codegenpackage/other", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("CodegenPackageOther.java", results.classes.head.fileName)
		assertEquals(codegenPackageOtherClass.toString, results.classes.head.contents)
	}
}