/**
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ba.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;

/**
 * Supplies local BA-state scopes and delegates AADL, property, and time-unit references to OSATE-aware global scoping.
 * Generic {@code Reference} segments intentionally remain symbolic until the phase-5 translator has their type
 * context.
 */
public class BehaviorAnnexScopeProvider extends AbstractBehaviorAnnexScopeProvider {
	public IScope scope_BehaviorTransition_sourceStates(BehaviorTransition context, EReference reference) {
		return scopeForBehaviorStates(context);
	}

	public IScope scope_BehaviorTransition_destinationState(BehaviorTransition context, EReference reference) {
		return scopeForBehaviorStates(context);
	}

	public IScope scope_BehaviorVariableGroup_dataClassifier(BehaviorVariableGroup context, EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_ForStatement_dataClassifier(ForStatement context, EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_TimedAction_processors(TimedAction context, EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_BehaviorPropertyAssociation_property(BehaviorPropertyAssociation context,
			EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_BehaviorTime_unit(BehaviorTime context, EReference reference) {
		UnitsType timeUnits = Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getUnitsType(),
				"AADL_Project::Time_Units");
		return timeUnits == null ? IScope.NULLSCOPE : scopeFor(timeUnits.getOwnedLiterals());
	}

	private static IScope scopeForBehaviorStates(BehaviorTransition context) {
		BehaviorAnnex annex = EcoreUtil2.getContainerOfType(context, BehaviorAnnex.class);
		if (annex == null) {
			return IScope.NULLSCOPE;
		}
		return scopeFor(annex.getStateGroups()
				.stream()
				.flatMap(group -> group.getStates().stream())
				.toList());
	}

}
