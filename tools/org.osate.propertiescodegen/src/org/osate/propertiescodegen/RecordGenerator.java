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

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.util.AadlUtil;

class RecordGenerator extends AbstractPropertyGenerator {
	private final RecordType recordType;
	private final String typeName;
	private final boolean topLevel;

	public RecordGenerator(RecordType recordType, String packageName, String typeName) {
		super(packageName);
		this.recordType = recordType;
		this.typeName = typeName;
		topLevel = true;
	}

	private RecordGenerator(RecordType recordType, String packageName, String typeName, ImportCollector imports) {
		super(packageName, imports);
		this.recordType = recordType;
		this.typeName = typeName;
		topLevel = false;
	}

	@Override
	public String generate() {
		getImports().add("org.osate.pluginsupport.properties.GeneratedRecord");
		var body = new StringBuilder(
				String.join("\n", generateConstants(), generateFields(), generateFieldByFieldConstructor(),
						generateExtractionConstructor(false), generateExtractionConstructor(true) + generateGetters(),
						generateToPropertyExpression(), generateHashCode(), generateEquals(), generateToString()));
		for (var field : recordType.getOwnedFields()) {
			var fieldType = generateFieldType(field);
			if (fieldType != null) {
				body.append('\n').append(fieldType);
			}
		}
		return "public" + (topLevel ? "" : " static") + " class " + typeName + " extends GeneratedRecord {\n"
				+ indent(body.toString()) + "}\n";
	}

	private String generateConstants() {
		getImports().add("org.eclipse.emf.common.util.URI");
		var builder = new StringBuilder();
		for (var field : recordType.getOwnedFields()) {
			builder.append("public static final String ")
					.append(field.getName().toUpperCase())
					.append("__NAME = \"")
					.append(field.getName())
					.append("\";\n");
		}
		for (var field : recordType.getOwnedFields()) {
			builder.append("public static final URI ")
					.append(field.getName().toUpperCase())
					.append("__URI = URI.createURI(\"")
					.append(EcoreUtil.getURI(field))
					.append("\");\n");
		}
		return builder.toString();
	}

	private String generateFields() {
		return recordType.getOwnedFields()
				.stream()
				.map(field -> "private final " + getGenericOptionalType(field.getPropertyType()) + " "
						+ fieldName(field) + ";\n")
				.collect(Collectors.joining());
	}

	private String generateFieldByFieldConstructor() {
		var fields = recordType.getOwnedFields();
		var parameters = fields.stream()
				.map(field -> getGenericOptionalType(field.getPropertyType()) + " " + fieldName(field))
				.collect(Collectors.joining(",\n\t\t"));
		var builder = new StringBuilder("public " + typeName + "(");
		if (fields.size() == 1) {
			builder.append(parameters);
		} else {
			builder.append("\n\t\t").append(parameters).append('\n');
		}
		builder.append(") {\n");
		for (var field : fields) {
			var name = fieldName(field);
			builder.append("\tthis.").append(name).append(" = ").append(name).append(";\n");
		}
		return builder.append("}\n").toString();
	}

	private String generateExtractionConstructor(boolean constant) {
		getImports().add("org.osate.aadl2.PropertyExpression", "org.osate.aadl2.RecordValue",
				"org.osate.aadl2.properties.PropertyNotPresentException",
				"org.osate.pluginsupport.properties.CodeGenUtil");
		if (!constant) {
			getImports().add("java.util.Optional", "org.osate.aadl2.Mode", "org.osate.aadl2.NamedElement");
		}
		var parameters = constant ? "" : ", NamedElement lookupContext, Optional<Mode> mode";
		var context = constant ? "" : ", lookupContext, mode";
		var builder = new StringBuilder("""
				public %s(PropertyExpression propertyExpression%s) {
				\tvar recordValue = (RecordValue) propertyExpression;
				""".formatted(typeName, parameters));
		for (var field : recordType.getOwnedFields()) {
			var name = fieldName(field);
			var type = field.getPropertyType();
			builder.append("""

					\t%s %s_local;
					\ttry {
					\t\t%s_local = findFieldValue(recordValue, %s__NAME).map(field -> {
					\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue()%s);
					\t\t\treturn %s;
					\t\t%s
					\t} catch (PropertyNotPresentException e) {
					\t\t%s_local = %s.empty();
					\t}
					\tthis.%s = %s_local;
					""".formatted(getGenericOptionalType(type), name, name, field.getName().toUpperCase(), context,
					indentContinuation(constant ? getConstantValueExtractor(type, "resolved", 1)
							: getValueExtractor(type, "resolved", 1), 3),
					getPrimitiveConversion(type), name, getBaseOptionalType(type), name, name));
		}
		return builder.append("}\n").toString();
	}

	private String getPrimitiveConversion(PropertyType type) {
		return switch (type) {
		case AadlInteger integer when integer.getUnitsType() == null -> {
			getImports().add("java.util.OptionalLong");
			yield "}).map(OptionalLong::of).orElse(OptionalLong.empty());";
		}
		case AadlReal real when real.getUnitsType() == null -> {
			getImports().add("java.util.OptionalDouble");
			yield "}).map(OptionalDouble::of).orElse(OptionalDouble.empty());";
		}
		case null, default -> "});";
		};
	}

	private String generateGetters() {
		return recordType.getOwnedFields()
				.stream()
				.map(field -> """

						public %s get%s() {
						\treturn %s;
						}
						""".formatted(getGenericOptionalType(field.getPropertyType()),
						PropertiesCodeGen.toCamelCase(field.getName()), fieldName(field)))
				.collect(Collectors.joining());
	}

	private String generateToPropertyExpression() {
		getImports().add("org.eclipse.emf.ecore.resource.ResourceSet", "org.osate.aadl2.Aadl2Factory",
				"org.osate.aadl2.RecordValue");
		var fields = recordType.getOwnedFields();
		var condition = fields.stream()
				.map(field -> fieldName(field) + ".isEmpty()")
				.collect(Collectors.joining("\n\t\t\t&& "));
		var builder = new StringBuilder("""
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\tif (%s%s) {
				\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t}
				\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				""".formatted(condition, fields.size() == 1 ? "" : "\n\t"));
		for (var field : fields) {
			var capitalized = field.getName().toUpperCase();
			builder.append("""
					\t%s.ifPresent(field -> {
					\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
					\t\tfieldAssociation.setProperty(loadField(resourceSet, %s__URI, %s__NAME));
					\t\tfieldAssociation.setOwnedValue(%s);
					\t});
					""".formatted(fieldName(field), capitalized, capitalized,
					indentContinuation(getValueCreator(field.getPropertyType(), "field", 1), 2)));
		}
		return builder.append("\treturn recordValue;\n}\n").toString();
	}

	private String getValueCreator(PropertyType type, String parameterName, int listDepth) {
		return switch (type) {
		case ListType list -> {
			getImports().add("org.osate.pluginsupport.properties.CodeGenUtil");
			var nextParameter = "element" + listDepth;
			yield "CodeGenUtil.toPropertyExpression(" + parameterName + ", " + nextParameter + " -> "
					+ getValueCreator(list.getElementType(), nextParameter, listDepth + 1) + ")";
		}
		case AadlBoolean bool -> simpleValueCreator(parameterName);
		case AadlString string -> simpleValueCreator(parameterName);
		case ClassifierType classifier -> simpleValueCreator(parameterName);
		case NumberType number when number.getUnitsType() == null -> simpleValueCreator(parameterName);
		case ReferenceType reference -> simpleValueCreator(parameterName);
		case RangeType range when range.getNumberType().getUnitsType() == null ->
			parameterName + ".toPropertyExpression()";
		case EnumerationType enumeration -> parameterName + ".toPropertyExpression(resourceSet)";
		case NumberType number -> parameterName + ".toPropertyExpression(resourceSet)";
		case RangeType range -> parameterName + ".toPropertyExpression(resourceSet)";
		case RecordType record -> parameterName + ".toPropertyExpression(resourceSet)";
		case null, default -> null;
		};
	}

	private String simpleValueCreator(String parameterName) {
		getImports().add("org.osate.pluginsupport.properties.CodeGenUtil");
		return "CodeGenUtil.toPropertyExpression(" + parameterName + ")";
	}

	private String generateHashCode() {
		getImports().add("java.util.Objects");
		var fields = recordType.getOwnedFields();
		var names = fields.stream().map(RecordGenerator::fieldName).collect(Collectors.joining(",\n\t\t\t"));
		var arguments = fields.size() == 1 ? names : "\n\t\t\t" + names + "\n\t";
		return """
				@Override
				public int hashCode() {
				\treturn Objects.hash(%s);
				}
				""".formatted(arguments);
	}

	private String generateEquals() {
		getImports().add("java.util.Objects");
		var comparisons = recordType.getOwnedFields()
				.stream()
				.map(RecordGenerator::fieldName)
				.map(name -> "Objects.equals(this." + name + ", other." + name + ")")
				.collect(Collectors.joining("\n\t\t\t&& "));
		return """
				@Override
				public boolean equals(Object obj) {
				\tif (this == obj) {
				\t\treturn true;
				\t}
				\tif (!(obj instanceof %s other)) {
				\t\treturn false;
				\t}
				\treturn %s;
				}
				""".formatted(typeName, comparisons);
	}

	private String generateToString() {
		var builder = new StringBuilder("""
				@Override
				public String toString() {
				\tvar builder = new StringBuilder();
				\tbuilder.append('[');
				""");
		for (var field : recordType.getOwnedFields()) {
			var type = field.getPropertyType();
			builder.append("""
					\tthis.%s.ifPresent(field -> {
					\t\tbuilder.append(%s__NAME);
					\t\tbuilder.append(" => %s");
					\t\tbuilder.append(%s);
					\t\tbuilder.append(%s);
					\t});
					""".formatted(fieldName(field), field.getName().toUpperCase(), getStringPrefix(type),
					indentContinuation(getStringBody(type), 2), getStringPostfix(type)));
		}
		return builder.append("\tbuilder.append(']');\n\treturn builder.toString();\n}\n").toString();
	}

	private static String getStringPrefix(PropertyType type) {
		return switch (type) {
		case AadlString string -> "\\\"";
		case ClassifierType classifier -> "classifier (";
		case ReferenceType reference -> "reference (";
		case null, default -> "";
		};
	}

	private String getStringBody(PropertyType type) {
		return switch (type) {
		case ListType list -> {
			getImports().add("java.util.stream.Collectors");
			yield "field.stream().map(" + getStringTransform(list.getElementType(), 1)
					+ ").collect(Collectors.joining(\", \", \"(\", \")\"))";
		}
		case ClassifierType classifier -> "field.getQualifiedName()";
		case ReferenceType reference -> "field.getName()";
		case null, default -> "field";
		};
	}

	private String getStringTransform(PropertyType type, int listDepth) {
		var parameter = "element" + listDepth;
		return switch (type) {
		case ListType list -> {
			getImports().add("java.util.stream.Collectors");
			yield parameter + " -> " + parameter + ".stream().map("
					+ getStringTransform(list.getElementType(), listDepth + 1)
					+ ").collect(Collectors.joining(\", \", \"(\", \")\"))";
		}
		case AadlString string -> """
				%s -> '\\"' + %s + '\\"'\
				""".formatted(parameter, parameter);
		case ClassifierType classifier -> """
				%s -> "classifier (" + %s.getQualifiedName() + ")"\
				""".formatted(parameter, parameter);
		case ReferenceType reference -> """
				%s -> "reference (" + %s.getName() + ")"\
				""".formatted(parameter, parameter);
		case null, default -> "Object::toString";
		};
	}

	private static String getStringPostfix(PropertyType type) {
		return switch (type) {
		case AadlString string -> "\"\\\";\"";
		case ClassifierType classifier -> "\");\"";
		case ReferenceType reference -> "\");\"";
		case null, default -> "';'";
		};
	}

	private String generateFieldType(BasicProperty field) {
		var baseType = AadlUtil.getBasePropertyType(field.getPropertyType());
		if (!EcoreUtil.isAncestor(field, baseType)) {
			return null;
		}
		var name = PropertiesCodeGen.toCamelCase(field.getName()) + "_FieldType";
		var generator = switch (baseType) {
		case UnitsType units -> new UnitsGenerator(units, packageName, name, getImports());
		case EnumerationType enumeration -> new EnumerationGenerator(enumeration, packageName, name, getImports());
		case NumberType number when number.getOwnedUnitsType() != null ->
			new UnitsGenerator(number.getUnitsType(), packageName, name, getImports());
		case RangeType range when range.getOwnedNumberType() != null
				&& range.getOwnedNumberType().getOwnedUnitsType() != null ->
			new UnitsGenerator(range.getNumberType().getUnitsType(), packageName, name, getImports());
		case RecordType record -> new RecordGenerator(record, packageName, name, getImports());
		case null, default -> null;
		};
		return generator == null ? null : generator.generate();
	}

	private static String fieldName(BasicProperty field) {
		var name = PropertiesCodeGen.toCamelCase(field.getName());
		return name.isEmpty() ? name : Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}
}
