/*******************************************************************************
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.propertiescodegen.tests;

import static org.junit.Assert.assertEquals;
import static org.osate.propertiescodegen.tests.GeneratedJavaCompiler.generateAndCompile;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.PropertySet;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/** Verifies exact generated Java for codegen package. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class CodegenPackageTest {
	private static final String CODEGEN_PACKAGE_BASE = """
			-- other comments
			-- @codegen-package org.osate.properties.codegenpackage
			property set codegen_package_base is
			\tspeed: type units (light, ridiculous => light * 1000, ludicrous => ridiculous * 1000);
			\trecord_type: type record (bool: aadlboolean;);
			\trecord_def: codegen_package_base::record_type applies to (all);
			\trecord_const: constant codegen_package_base::record_type => [bool => true;];
			end codegen_package_base;
			""";

	private static final String CODEGEN_PACKAGE_SAME = """
			-- @codegen-package org.osate.properties.codegenpackage
			property set codegen_package_same is
			\twith codegen_package_base;
			\t
			\trecord_def: codegen_package_base::record_type applies to (all);
			\tint_def: aadlinteger units codegen_package_base::speed applies to (all);
			\trecord_const: constant codegen_package_base::record_type => [bool => false;];
			end codegen_package_same;
			""";

	private static final String CODEGEN_PACKAGE_OTHER = """
			-- @codegen-package org.osate.properties.codegenpackage.other
			property set codegen_package_other is
			\twith codegen_package_base;
			\t
			\trecord_def: codegen_package_base::record_type applies to (all);
			\tint_def: aadlinteger units codegen_package_base::speed applies to (all);
			\trecord_const: constant codegen_package_base::record_type => [bool => true;];
			end codegen_package_other;
			""";

	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testCustomPackage() throws Exception {
		var codegenPackageBaseClass = """
				package org.osate.properties.codegenpackage;

				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;

				public final class CodegenPackageBase {
				\tpublic static final String CODEGEN_PACKAGE_BASE__NAME = "codegen_package_base";

				\tprivate CodegenPackageBase() {}

				\t// Lookup methods for codegen_package_base::record_def

				\tpublic static final String RECORD_DEF__NAME = "record_def";

				\tpublic static boolean acceptsRecordDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordDef_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext) {
				\t\treturn getRecordDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordType(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordDef_Property(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_BASE__NAME + "::" + RECORD_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordDef_Property(lookupContext));
				\t}

				\t// Lookup methods for codegen_package_base::record_const

				\tpublic static final String RECORD_CONST__NAME = "record_const";

				\tpublic static RecordType getRecordConst(EObject lookupContext) {
				\t\tvar constant = getRecordConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RecordType(resolved);
				\t}

				\tpublic static PropertyConstant getRecordConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_BASE__NAME + "::" + RECORD_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var speed = """
				package org.osate.properties.codegenpackage;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Speed implements GeneratedUnits<Speed> {
				\tLIGHT(1.0, "light", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tRIDICULOUS(1000.0, "ridiculous", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tLUDICROUS(1000000.0, "ludicrous", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Speed(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Speed valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Speed target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var recordType = """
				package org.osate.properties.codegenpackage;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordType extends GeneratedRecord {
				\tpublic static final String BOOL__NAME = "bool";
				\tpublic static final URI BOOL__URI = URI.createURI("__synthetic0.aadl#/0/@ownedPropertyType.1/@ownedField.0");

				\tprivate final Optional<Boolean> bool;

				\tpublic RecordType(Optional<Boolean> bool) {
				\t\tthis.bool = bool;
				\t}

				\tpublic RecordType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> bool_local;
				\t\ttry {
				\t\t\tbool_local = findFieldValue(recordValue, BOOL__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tbool_local = Optional.empty();
				\t\t}
				\t\tthis.bool = bool_local;
				\t}

				\tpublic RecordType(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> bool_local;
				\t\ttry {
				\t\t\tbool_local = findFieldValue(recordValue, BOOL__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tbool_local = Optional.empty();
				\t\t}
				\t\tthis.bool = bool_local;
				\t}

				\tpublic Optional<Boolean> getBool() {
				\t\treturn bool;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (bool.isEmpty()) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tbool.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, BOOL__URI, BOOL__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(bool);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordType other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.bool, other.bool);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.bool.ifPresent(field -> {
				\t\t\tbuilder.append(BOOL__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(CODEGEN_PACKAGE_BASE));
		assertEquals("src-gen/org/osate/properties/codegenpackage", results.getPackagePath());
		assertEquals(3, results.getClasses().size());

		assertEquals("CodegenPackageBase.java", results.getClasses().get(0).getFileName());
		assertEquals(codegenPackageBaseClass, results.getClasses().get(0).getContents());

		assertEquals("Speed.java", results.getClasses().get(1).getFileName());
		assertEquals(speed, results.getClasses().get(1).getContents());

		assertEquals("RecordType.java", results.getClasses().get(2).getFileName());
		assertEquals(recordType, results.getClasses().get(2).getContents());
	}

	@Test
	public void testReferenceToSameCustomPackage() throws Exception {
		var codegenPackageSameClass = """
				package org.osate.properties.codegenpackage;

				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.IntegerWithUnits;

				public final class CodegenPackageSame {
				\tpublic static final String CODEGEN_PACKAGE_SAME__NAME = "codegen_package_same";

				\tprivate CodegenPackageSame() {}

				\t// Lookup methods for codegen_package_same::record_def

				\tpublic static final String RECORD_DEF__NAME = "record_def";

				\tpublic static boolean acceptsRecordDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordDef_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext) {
				\t\treturn getRecordDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordType(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordDef_Property(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_SAME__NAME + "::" + RECORD_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordDef_Property(lookupContext));
				\t}

				\t// Lookup methods for codegen_package_same::int_def

				\tpublic static final String INT_DEF__NAME = "int_def";

				\tpublic static boolean acceptsIntDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntDef_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext) {
				\t\treturn getIntDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerWithUnits<>(resolved, Speed.class));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntDef_Property(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_SAME__NAME + "::" + INT_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntDef_Property(lookupContext));
				\t}

				\t// Lookup methods for codegen_package_same::record_const

				\tpublic static final String RECORD_CONST__NAME = "record_const";

				\tpublic static RecordType getRecordConst(EObject lookupContext) {
				\t\tvar constant = getRecordConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RecordType(resolved);
				\t}

				\tpublic static PropertyConstant getRecordConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_SAME__NAME + "::" + RECORD_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(CODEGEN_PACKAGE_SAME, CODEGEN_PACKAGE_BASE));
		assertEquals("src-gen/org/osate/properties/codegenpackage", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("CodegenPackageSame.java", results.getClasses().getFirst().getFileName());
		assertEquals(codegenPackageSameClass, results.getClasses().getFirst().getContents());
	}

	@Test
	public void testReferenceToOtherCustomPackage() throws Exception {
		var codegenPackageOtherClass = """
				package org.osate.properties.codegenpackage.other;

				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.IntegerWithUnits;
				import org.osate.properties.codegenpackage.RecordType;
				import org.osate.properties.codegenpackage.Speed;

				public final class CodegenPackageOther {
				\tpublic static final String CODEGEN_PACKAGE_OTHER__NAME = "codegen_package_other";

				\tprivate CodegenPackageOther() {}

				\t// Lookup methods for codegen_package_other::record_def

				\tpublic static final String RECORD_DEF__NAME = "record_def";

				\tpublic static boolean acceptsRecordDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordDef_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext) {
				\t\treturn getRecordDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordType> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordType(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordDef_Property(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_OTHER__NAME + "::" + RECORD_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordDef_Property(lookupContext));
				\t}

				\t// Lookup methods for codegen_package_other::int_def

				\tpublic static final String INT_DEF__NAME = "int_def";

				\tpublic static boolean acceptsIntDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntDef_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext) {
				\t\treturn getIntDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerWithUnits<Speed>> getIntDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerWithUnits<>(resolved, Speed.class));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntDef_Property(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_OTHER__NAME + "::" + INT_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntDef_Property(lookupContext));
				\t}

				\t// Lookup methods for codegen_package_other::record_const

				\tpublic static final String RECORD_CONST__NAME = "record_const";

				\tpublic static RecordType getRecordConst(EObject lookupContext) {
				\t\tvar constant = getRecordConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RecordType(resolved);
				\t}

				\tpublic static PropertyConstant getRecordConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CODEGEN_PACKAGE_OTHER__NAME + "::" + RECORD_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(CODEGEN_PACKAGE_OTHER, CODEGEN_PACKAGE_BASE));
		assertEquals("src-gen/org/osate/properties/codegenpackage/other", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("CodegenPackageOther.java", results.getClasses().getFirst().getFileName());
		assertEquals(codegenPackageOtherClass, results.getClasses().getFirst().getContents());
	}
}
