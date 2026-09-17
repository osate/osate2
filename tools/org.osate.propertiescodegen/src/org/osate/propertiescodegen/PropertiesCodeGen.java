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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.util.AadlUtil;

public class PropertiesCodeGen {
	public static GeneratedPackage generateJava(PropertySet propertySet) {
		var packageName = getPackageName(propertySet);
		var classes = new ArrayList<GeneratedClass>();
		var className = toCamelCase(propertySet.getName());
		classes.add(generateFile(packageName, className,
				new PropertyGettersGenerator(propertySet, packageName, className)));
		for (var element : propertySet.eContents()) {
			if (!(element instanceof NamedElement namedElement)) {
				continue;
			}
			var name = toCamelCase(namedElement.getName());
			var type = switch (namedElement) {
			case PropertyType propertyType -> propertyType;
			case Property property -> ownedBaseType(property, property.getPropertyType());
			case PropertyConstant constant -> ownedBaseType(constant, constant.getPropertyType());
			default -> null;
			};
			var generator = switch (type) {
			case UnitsType units -> new UnitsGenerator(units, packageName, name);
			case EnumerationType enumeration -> new EnumerationGenerator(enumeration, packageName, name);
			case NumberType number when number.getOwnedUnitsType() != null ->
				new UnitsGenerator(number.getUnitsType(), packageName, name);
			case RangeType range when range.getOwnedNumberType() != null
					&& range.getOwnedNumberType().getOwnedUnitsType() != null ->
				new UnitsGenerator(range.getNumberType().getUnitsType(), packageName, name);
			case RecordType record -> new RecordGenerator(record, packageName, name);
			case null, default -> null;
			};
			if (generator != null) {
				classes.add(generateFile(packageName, name, generator));
			}
		}
		return new GeneratedPackage("src-gen/" + packageName.replace('.', '/'), classes);
	}

	private static PropertyType ownedBaseType(NamedElement owner, PropertyType type) {
		var baseType = AadlUtil.getBasePropertyType(type);
		return EcoreUtil.isAncestor(owner, baseType) ? baseType : null;
	}

	private static GeneratedClass generateFile(String packageName, String typeName,
			AbstractPropertyGenerator generator) {
		// Generate the type first so that it populates the import collector.
		var generatedType = generator.generate();
		return new GeneratedClass(typeName + ".java",
				"package " + packageName + ";\n" + generator.getImports().generate() + "\n" + generatedType);
	}

	static String getPackageName(PropertySet propertySet) {
		var leaves = NodeModelUtils.getNode(propertySet).getLeafNodes();
		for (var leaf : leaves) {
			if (leaf.isHidden()) {
				continue;
			}
			var previousNode = leaf.getPreviousSibling();
			if (previousNode != null) {
				var commentLine = previousNode.getText().trim();
				var firstNonComment = 0;
				while (firstNonComment < commentLine.length() && commentLine.charAt(firstNonComment) == '-') {
					firstNonComment++;
				}
				if (firstNonComment < commentLine.length()) {
					var trimmed = commentLine.substring(firstNonComment).trim();
					if (trimmed.startsWith("@codegen-package ")) {
						return trimmed.substring(17).trim();
					}
				}
			}
			break;
		}
		return propertySet.getName().toLowerCase().replace("_", "");
	}

	static String toCamelCase(String text) {
		return Arrays.stream(text.split("_"))
				.map(String::toLowerCase)
				.map(PropertiesCodeGen::capitalize)
				.collect(Collectors.joining());
	}

	private static String capitalize(String text) {
		return text.isEmpty() ? text : Character.toUpperCase(text.charAt(0)) + text.substring(1);
	}
}
