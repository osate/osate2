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

package org.osate.alisa.workbench.ui.contentassist

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.osate.aadl2.ComponentImplementation
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.verify.util.IVerifyGlobalReferenceFinder
import org.osate.alisa.workbench.alisa.ModelPlan

class AlisaEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject extension IVerifyGlobalReferenceFinder referenceFinder

	override getHoverInfoAsHtml(EObject o) {
		switch (o) {
			AssurancePlan: {
				val mps = o.modelPlan
				val z = mps.map[mp|(mp as ModelPlan).target.name]
				val res = "Verified system implementations: " + z.fold("")[a, b|a + " " + b]
				return res
			}
		}
		return "No message!!"
	}

}