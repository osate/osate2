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

import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.UnitsType;

abstract class AbstractPropertyGenerator {
	protected final String packageName;
	private final ImportCollector imports;

	public AbstractPropertyGenerator(String packageName, ImportCollector imports) {
		this.packageName = packageName;
		this.imports = imports;
	}

	public AbstractPropertyGenerator(String packageName) {
		this(packageName, new ImportCollector());
	}

	public ImportCollector getImports() {
		return imports;
	}

	public abstract String generate();

	protected String getBaseOptionalType(PropertyType type) {
		return switch (type) {
		case AadlInteger integer when integer.getUnitsType() == null -> imported("java.util.OptionalLong");
		case AadlReal real when real.getUnitsType() == null -> imported("java.util.OptionalDouble");
		case null, default -> imported("java.util.Optional");
		};
	}

	protected String getGenericOptionalType(PropertyType type) {
		var optional = getBaseOptionalType(type);
		return optional.equals("Optional") ? optional + "<" + getJavaType(type) + ">" : optional;
	}

	protected String getJavaType(PropertyType type) {
		return switch (type) {
		case ListType list -> imported("java.util.List") + "<" + getJavaType(list.getElementType()) + ">";
		case AadlBoolean bool -> "Boolean";
		case AadlString string -> "String";
		case ClassifierType classifier -> imported("org.osate.aadl2.Classifier");
		case AadlInteger integer when integer.getUnitsType() == null -> "Long";
		case AadlInteger integer -> unitsType("IntegerWithUnits", integer.getUnitsType());
		case AadlReal real when real.getUnitsType() == null -> "Double";
		case AadlReal real -> unitsType("RealWithUnits", real.getUnitsType());
		case RangeType range -> switch (range.getNumberType()) {
		case AadlInteger integer when integer.getUnitsType() == null ->
			imported("org.osate.pluginsupport.properties.IntegerRange");
		case AadlInteger integer -> unitsType("IntegerRangeWithUnits", integer.getUnitsType());
		case AadlReal real when real.getUnitsType() == null -> imported("org.osate.pluginsupport.properties.RealRange");
		case AadlReal real -> unitsType("RealRangeWithUnits", real.getUnitsType());
		case null, default -> null;
		};
		case ReferenceType reference -> imported("org.osate.aadl2.instance.InstanceObject");
		default -> {
			if (type.getName() != null) {
				yield namedType(type);
			}
			NamedElement owner = type;
			do {
				owner = EcoreUtil2.getContainerOfType(owner.eContainer(), NamedElement.class);
			} while (owner.getName() == null);
			yield ownedTypeName(owner);
		}
		};
	}

	private String unitsType(String name, UnitsType units) {
		return imported("org.osate.pluginsupport.properties." + name) + "<" + getUnitsJavaName(units) + ">";
	}

	private String namedType(NamedElement type) {
		var name = PropertiesCodeGen.toCamelCase(type.getName());
		var packageToImport = PropertiesCodeGen.getPackageName(EcoreUtil2.getContainerOfType(type, PropertySet.class));
		if (!Objects.equals(packageToImport, packageName)) {
			imports.add(packageToImport + "." + name);
		}
		return name;
	}

	private static String ownedTypeName(NamedElement owner) {
		var name = PropertiesCodeGen.toCamelCase(owner.getName());
		return switch (owner) {
		case Property property -> name;
		case PropertyConstant constant -> name;
		case BasicProperty field -> name + "_FieldType";
		default -> null;
		};
	}

	protected String getUnitsJavaName(UnitsType type) {
		/*
		 * Units may be named themselves, contained in a named number or range type,
		 * or indirectly owned by a property, constant, or record field.
		 */
		NamedElement owner = type;
		while (owner.getName() == null) {
			owner = EcoreUtil2.getContainerOfType(owner.eContainer(), NamedElement.class);
		}
		return owner instanceof PropertyType ? namedType(owner) : ownedTypeName(owner);
	}

	protected String getValueExtractor(PropertyType type, String parameterName, int listDepth) {
		return valueExtractor(type, parameterName, listDepth, false);
	}

	protected String getConstantValueExtractor(PropertyType type, String parameterName, int listDepth) {
		return valueExtractor(type, parameterName, listDepth, true);
	}

	private String valueExtractor(PropertyType type, String parameterName, int listDepth, boolean constant) {
		var context = constant ? "" : ", lookupContext, mode";
		return switch (type) {
		case ListType list -> {
			imports.add("org.osate.aadl2.ListValue", "org.osate.pluginsupport.properties.CodeGenUtil");
			var nextParameter = "element" + listDepth;
			var resolved = "resolved" + listDepth;
			yield """
					((ListValue) %s).getOwnedListElements().stream().map(%s -> {
					\tvar %s = CodeGenUtil.resolveNamedValue(%s%s);
					\treturn %s;
					}).toList()\
					""".formatted(parameterName, nextParameter, resolved, nextParameter, context,
					indentContinuation(valueExtractor(list.getElementType(), resolved, listDepth + 1, constant), 1));
		}
		case AadlBoolean bool -> literalExtractor("BooleanLiteral", parameterName, "getValue");
		case AadlString string -> literalExtractor("StringLiteral", parameterName, "getValue");
		case ClassifierType classifier -> literalExtractor("ClassifierValue", parameterName, "getClassifier");
		case EnumerationType enumeration -> getJavaType(type) + ".valueOf(" + parameterName + ")";
		case AadlInteger integer when integer.getUnitsType() == null ->
			literalExtractor("IntegerLiteral", parameterName, "getValue");
		case AadlInteger integer -> unitsExtractor("IntegerWithUnits", integer.getUnitsType(), parameterName, "");
		case AadlReal real when real.getUnitsType() == null ->
			literalExtractor("RealLiteral", parameterName, "getValue");
		case AadlReal real -> unitsExtractor("RealWithUnits", real.getUnitsType(), parameterName, "");
		case RangeType range -> switch (range.getNumberType()) {
		case AadlInteger integer when integer.getUnitsType() == null ->
			"new " + imported("org.osate.pluginsupport.properties.IntegerRange") + "(" + parameterName + context + ")";
		case AadlInteger integer ->
			unitsExtractor("IntegerRangeWithUnits", integer.getUnitsType(), parameterName, context);
		case AadlReal real when real.getUnitsType() == null ->
			"new " + imported("org.osate.pluginsupport.properties.RealRange") + "(" + parameterName + context + ")";
		case AadlReal real -> unitsExtractor("RealRangeWithUnits", real.getUnitsType(), parameterName, context);
		case null, default -> null;
		};
		case RecordType record -> "new " + getJavaType(type) + "(" + parameterName + context + ")";
		case ReferenceType reference -> {
			imports.add("org.osate.aadl2.instance.InstanceReferenceValue");
			yield "((InstanceReferenceValue) " + parameterName + ").getReferencedInstanceObject()";
		}
		case null, default -> null;
		};
	}

	private String literalExtractor(String type, String parameter, String getter) {
		return "((" + imported("org.osate.aadl2." + type) + ") " + parameter + ")." + getter + "()";
	}

	private String unitsExtractor(String type, UnitsType units, String parameter, String context) {
		return "new " + imported("org.osate.pluginsupport.properties." + type) + "<>(" + parameter + ", "
				+ getUnitsJavaName(units) + ".class" + context + ")";
	}

	private String imported(String qualifiedName) {
		imports.add(qualifiedName);
		return qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1);
	}

	/** Indents nonblank lines of a generated block, leaving blank lines empty. */
	protected static String indent(String text) {
		return text.lines().map(line -> line.isBlank() ? "" : "\t" + line).collect(Collectors.joining("\n", "", "\n"));
	}

	/** Aligns the continuation lines of an expression with its insertion point. */
	protected static String indentContinuation(String text, int tabs) {
		return text.replace("\n", "\n" + "\t".repeat(tabs));
	}
}
