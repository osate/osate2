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

import java.util.Comparator;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;

class UnitsGenerator extends AbstractPropertyGenerator {
	private final UnitsType unitsType;
	private final String typeName;

	public UnitsGenerator(UnitsType unitsType, String packageName, String typeName, ImportCollector imports) {
		super(packageName, imports);
		this.unitsType = unitsType;
		this.typeName = typeName;
	}

	public UnitsGenerator(UnitsType unitsType, String packageName, String typeName) {
		this(unitsType, packageName, typeName, new ImportCollector());
	}

	@Override
	public String generate() {
		getImports().add("org.eclipse.emf.common.util.URI", "org.osate.aadl2.NamedValue",
				"org.osate.aadl2.PropertyExpression", "org.osate.aadl2.UnitLiteral",
				"org.osate.pluginsupport.properties.GeneratedUnits");
		var literals = unitsType.getOwnedLiterals()
				.stream()
				.filter(UnitLiteral.class::isInstance)
				.map(UnitLiteral.class::cast)
				.sorted(Comparator.comparingDouble(UnitLiteral::getAbsoluteFactor))
				.map(literal -> literal.getName().toUpperCase() + "(" + literal.getAbsoluteFactor() + ", \""
						+ literal.getName() + "\", \"" + EcoreUtil.getURI(literal) + "\")")
				.collect(Collectors.joining(",\n"));
		return """
				public enum %s implements GeneratedUnits<%s> {
				\t%s;

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate %s(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static %s valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(%s target) {
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
				""".formatted(typeName, typeName, indentContinuation(literals, 1), typeName, typeName, typeName);
	}
}
