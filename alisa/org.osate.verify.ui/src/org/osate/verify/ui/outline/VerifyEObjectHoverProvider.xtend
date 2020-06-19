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

package org.osate.verify.ui.outline

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.osate.verify.verify.VerificationActivity
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import static extension org.osate.verify.util.VerifyUtilExtension.*
import org.osate.reqspec.reqSpec.Requirement
import org.osate.verify.verify.Claim
import org.osate.verify.verify.VerificationMethod
import org.osate.aadl2.ComponentClassifier

class VerifyEObjectHoverProvider extends DefaultEObjectHoverProvider {
		override getHoverInfoAsHtml (EObject o){ 
		switch (o){
			VerificationActivity: {
				val vm = o.method
				val target = o.containingClaim?.requirement?.targetClassifier
				return vaText(vm, target)
				}
			VerificationMethod: {
				return vmText(o)
				}
			Claim: {
				val Requirement req = o.requirement
				return reqText(req)
				}
		}
		return super.getHoverInfoAsHtml(o)
	}
	
	def vaText(VerificationMethod vm, ComponentClassifier target){
				val z =  (vm.title?:"") 
				var zz = (vm.description?.toText(target))?:""
				if (zz.length > 0) zz = ": " + zz
				val res = "Method "+vm.name+": "+ z + zz
			return res
	}
	
	def vmText(VerificationMethod vm){
				val z =  (vm.title?:"") 
				var zz = (vm.description?.toText(null))?:""
				if (zz.length > 0) zz = ": " + zz
				val res = "Method "+vm.name+": "+ z + zz
			return res
	}
		
	def reqText(Requirement req){
				val z =  (req.title?:"") 
				var zz = (req.description?.toText(req.targetClassifier))?:""
				if (zz.length > 0) zz = ": " + zz
				val res = "Requirement "+req.name+": "+ z + zz
			return res
	}
	
}