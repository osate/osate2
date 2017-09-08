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

package org.osate.assure.ui.outline

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.result.Issue

class AssureEObjectHoverProvider extends DefaultEObjectHoverProvider {
	override getHoverInfoAsHtml(EObject o){
		switch (o){
			AssuranceCaseResult: return o.message?:"No message"
			ClaimResult: return o.message?:"No message"
			VerificationActivityResult: return o.message?:"No message"
			ValidationResult: return o.message?:"No message"
			PreconditionResult: return o.message?:"No message"
			Issue: return o.message?:"No message"
		}
		return super.getHoverInfoAsHtml(o)
	}
}