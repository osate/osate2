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

package org.osate.verify.util

import com.google.inject.ImplementedBy
import org.eclipse.emf.ecore.EObject
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
import org.osate.reqspec.reqSpec.RequirementSet
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.VerificationPlan
import org.osate.verify.verify.VerifyPackage

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

@ImplementedBy(VerifyGlobalReferenceFinder)
interface IVerifyGlobalReferenceFinder {
	/**
	 * do not use this methods to construction of scopes as they are operating on references
	 * cc is the classifier that must be the same or an ancestor of the classifier referenced by the system requirements or the verification plan
	 * context determines the resourceset into which the verification plans are loaded
	 */
	def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc ,EObject context);

	/**
	 * method to be used for scope creation as it does not use EReferences
	 */
	
	def Iterable<VerificationPlan> getAllVerificationPlansForRequirements(RequirementSet reqs, EObject context);
	
	def Iterable<VerificationMethod> getVerificationMethod(String methodName, EObject context);
	
}

class VerifyGlobalReferenceFinder implements IVerifyGlobalReferenceFinder{
		
		override Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc, EObject context){
			return	Aadl2GlobalScopeUtil.getAll(context, VerifyPackage.Literals.VERIFICATION_PLAN).filter[svp|val reqs = svp.requirementSet; reqs instanceof SystemRequirementSet && cc.isSameorExtends((reqs as SystemRequirementSet).target)]
	}

		override Iterable<VerificationPlan> getAllVerificationPlansForRequirements(RequirementSet reqs, EObject context){
			 Aadl2GlobalScopeUtil.getAll(context, VerifyPackage.Literals.VERIFICATION_PLAN).filter[vp|vp.requirementSet === reqs]
		}

		override Iterable<VerificationMethod> getVerificationMethod(String methodName, EObject context){
			 Aadl2GlobalScopeUtil.getAll(context, VerifyPackage.Literals.VERIFICATION_PLAN).filter[vm|methodName.equalsIgnoreCase(vm.name)]
		}

}