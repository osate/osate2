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
package org.osate.propertiescodegen;

import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;

class PropertyGettersGenerator extends AbstractPropertyGenerator {
	private final PropertySet propertySet;
	private final String className;

	public PropertyGettersGenerator(PropertySet propertySet, String packageName, String className) {
		super(packageName);
		this.propertySet = propertySet;
		this.className = className;
	}

	@Override
	public String generate() {
		var builder = new StringBuilder("""
				public final class %s {
				\tpublic static final String %s__NAME = "%s";

				\tprivate %s() {}
				""".formatted(className, propertySet.getName().toUpperCase(), propertySet.getName(), className));
		for (var property : propertySet.getOwnedProperties()) {
			builder.append("\n").append(indent(generateGetter(property)));
		}
		for (var constant : propertySet.getOwnedPropertyConstants()) {
			builder.append("\n").append(indent(generateGetter(constant)));
		}
		return builder.append("}\n").toString();
	}

	private String generateGetter(Property property) {
		var type = property.getPropertyType();
		var baseOptionalType = getBaseOptionalType(type);
		getImports().add("java.util.Optional", "org.eclipse.emf.ecore.EObject", "org.osate.aadl2.Aadl2Package",
				"org.osate.aadl2.Mode", "org.osate.aadl2.NamedElement", "org.osate.aadl2.Property",
				"org.osate.aadl2.PropertyExpression", "org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
				"org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException",
				"org.osate.aadl2.properties.PropertyNotPresentException",
				"org.osate.pluginsupport.properties.CodeGenUtil");
		var returnType = getGenericOptionalType(type);
		var camelName = PropertiesCodeGen.toCamelCase(property.getName());
		return """
				// Lookup methods for %s::%s

				public static final String %s__NAME = "%s";

				public static boolean accepts%s(NamedElement lookupContext) {
				\treturn lookupContext.acceptsProperty(get%s_Property(lookupContext));
				}

				public static %s get%s(NamedElement lookupContext) {
				\treturn get%s(lookupContext, Optional.empty());
				}

				public static %s get%s(NamedElement lookupContext, Mode mode) {
				\treturn get%s(lookupContext, Optional.of(mode));
				}

				public static %s get%s(NamedElement lookupContext, Optional<Mode> mode) {
				\tvar property = get%s_Property(lookupContext);
				\ttry {
				\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\treturn %s.of(%s);
				\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\treturn %s.empty();
				\t}
				}

				public static Property get%s_Property(EObject lookupContext) {
				\tvar name = %s__NAME + "::" + %s__NAME;
				\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}

				public static PropertyExpression get%s_EObject(NamedElement lookupContext) {
				\treturn lookupContext.getNonModalPropertyValue(get%s_Property(lookupContext));
				}
				""".formatted(propertySet.getName(), property.getName(), property.getName().toUpperCase(),
				property.getName(), camelName, camelName, returnType, camelName, camelName, returnType, camelName,
				camelName, returnType, camelName, camelName, baseOptionalType,
				indentContinuation(getValueExtractor(type, "resolved", 1), 2), baseOptionalType, camelName,
				propertySet.getName().toUpperCase(), property.getName().toUpperCase(), camelName, camelName);
	}

	private String generateGetter(PropertyConstant constant) {
		getImports().add("org.eclipse.emf.ecore.EObject", "org.osate.aadl2.Aadl2Package",
				"org.osate.aadl2.PropertyConstant", "org.osate.aadl2.PropertyExpression",
				"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
				"org.osate.pluginsupport.properties.CodeGenUtil");
		var camelName = PropertiesCodeGen.toCamelCase(constant.getName());
		return """
				// Lookup methods for %s::%s

				public static final String %s__NAME = "%s";

				public static %s get%s(EObject lookupContext) {
				\tvar constant = get%s_PropertyConstant(lookupContext);
				\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\treturn %s;
				}

				public static PropertyConstant get%s_PropertyConstant(EObject lookupContext) {
				\tvar name = %s__NAME + "::" + %s__NAME;
				\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				""".formatted(propertySet.getName(), constant.getName(), constant.getName().toUpperCase(),
				constant.getName(), getPrimitiveJavaType(constant.getPropertyType()), camelName, camelName,
				indentContinuation(getConstantValueExtractor(constant.getPropertyType(), "resolved", 1), 1), camelName,
				propertySet.getName().toUpperCase(), constant.getName().toUpperCase());
	}

	private String getPrimitiveJavaType(PropertyType type) {
		return switch (type) {
		case AadlBoolean bool -> "boolean";
		case AadlInteger integer when integer.getUnitsType() == null -> "long";
		case AadlReal real when real.getUnitsType() == null -> "double";
		case null, default -> getJavaType(type);
		};
	}
}
