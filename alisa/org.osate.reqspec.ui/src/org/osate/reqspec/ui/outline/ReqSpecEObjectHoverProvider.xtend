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

package org.osate.reqspec.ui.outline

import org.eclipse.emf.ecore.EObject
import org.osate.alisa.common.ui.editor.hover.html.CommonEObjectHoverProvider
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.Requirement

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*

class ReqSpecEObjectHoverProvider extends CommonEObjectHoverProvider {
	override getHoverInfoAsHtml(EObject o) {
		switch (o) {
			Requirement: {
				return reqText(o)
			}
			Goal: {
				return reqText(o)
			}
		}
		return super.getHoverInfoAsHtml(o)
	}

	def reqText(ContractualElement req) {
		val z = (req.title ?: "")
		var zz = (req.description?.toText(req.targetClassifier)) ?: ""
		if (zz.length > 0) zz = ": " + zz
		val res = req.eClass.name + " " + req.name + ": " + z + zz
		return res
	}

}