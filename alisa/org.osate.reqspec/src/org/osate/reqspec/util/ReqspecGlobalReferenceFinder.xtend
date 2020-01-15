/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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

package org.osate.reqspec.util

import com.google.inject.ImplementedBy
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

@ImplementedBy(ReqspecGlobalReferenceFinder)
interface IReqspecGlobalReferenceFinder {
	/**
	 * these methods should not be used to construct scopes
	 */
	def Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentInstance ci);

	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);

	def Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentClassifier cc);

	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);

	def Iterable<SystemRequirementSet> getSystemRequirementSetsNoExtends(ComponentClassifier cc);

	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc);

	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentInstance ci);
}

class ReqspecGlobalReferenceFinder implements IReqspecGlobalReferenceFinder {


	override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentInstance ci) {
		ci.componentClassifier.systemRequirementSets
	}

	override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentClassifier cc) {
		Aadl2GlobalScopeUtil.getAll(cc, ReqSpecPackage.eINSTANCE.systemRequirementSet).filter[srs|cc.isSameorExtends(srs.target)]
	}

	override Iterable<SystemRequirementSet> getSystemRequirementSetsNoExtends(ComponentClassifier cc) {
		Aadl2GlobalScopeUtil.getAll(cc, ReqSpecPackage.eINSTANCE.systemRequirementSet).filter[srs|cc === srs.target]
	}

	override Iterable<Requirement> getAllRequirements(ComponentInstance ci) {
		ci.componentClassifier.allRequirements
	}

	override Iterable<Requirement> getAllRequirements(ComponentClassifier cc) {
		cc.systemRequirementSets.map[it.requirements].flatten
	}

	override Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc) {
		Aadl2GlobalScopeUtil.getAll(cc, ReqSpecPackage.eINSTANCE.stakeholderGoals).filter[sgs|cc === sgs.target]
	}

	override getStakeholderGoals(ComponentInstance ci) {
		ci.componentClassifier.stakeholderGoals
	}

}
