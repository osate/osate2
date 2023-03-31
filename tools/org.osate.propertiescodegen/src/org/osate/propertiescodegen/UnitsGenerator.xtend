/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.propertiescodegen

import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI

package class UnitsGenerator extends AbstractPropertyGenerator {
	val UnitsType unitsType
	val String typeName
	
	new(UnitsType unitsType, String packageName, String typeName, ImportCollector imports) {
		super(packageName, imports)
		this.unitsType = unitsType
		this.typeName = typeName
	}
	
	new(UnitsType unitsType, String packageName, String typeName) {
		super(packageName)
		this.unitsType = unitsType
		this.typeName = typeName
	}
	
	override generate() {
		imports.add(
			"org.eclipse.emf.common.util.URI",
			"org.osate.aadl2.AbstractNamedValue",
			"org.osate.aadl2.NamedValue",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.UnitLiteral",
			"org.osate.pluginsupport.properties.GeneratedUnits"
		)
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor]
		val literalsString = literals.join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»", "«it.URI»")''']
		'''
			public enum «typeName» implements GeneratedUnits<«typeName»> {
				«literalsString»;
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private «typeName»(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(«typeName» target) {
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
	}
}