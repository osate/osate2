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