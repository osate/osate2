/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.scoping

import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval

class CommonScopeProvider extends AbstractDeclarativeScopeProvider {

	def protected static scopeFor(Iterable<? extends EObject> elements) {
		new SimpleScope(IScope::NULLSCOPE,
			Scopes::scopedElementsFor(elements, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
	}

	def scope_UnitLiteral(EObject context, EReference reference) {
		val units = context.unitLiterals
		if (!units.empty) {
			units.scopeFor
		} else {
			IScope.NULLSCOPE
		}
	}

	val private static EClass UNITS_TYPE = Aadl2Package.eINSTANCE.getUnitsType();

	def private static getUnitLiterals(EObject context) {

		// TODO: Scope literals by type, but how to do we know the type of an
		// expression?
		val Collection<UnitLiteral> result = new ArrayList<UnitLiteral>()
		for (IEObjectDescription desc : EMFIndexRetrieval.getAllEObjectsOfTypeInWorkspace(context, UNITS_TYPE)) {
			val unitsType = EcoreUtil.resolve(desc.getEObjectOrProxy(), context) as UnitsType;
			unitsType.ownedLiterals.forall[lit|result += lit as UnitLiteral];
		}

		return result;
	}

}
