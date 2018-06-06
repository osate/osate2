/**
 * Copyright 2016 Carnegie Mellon University. All Rights Reserved.
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

package org.osate.alisa.common.ui.editor.hover.html;

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.osate.alisa.common.common.ValDeclaration
import org.osate.alisa.common.typing.CommonInterpreter
import org.osate.alisa.common.typing.CommonStringRepresentation
import org.osate.alisa.common.typing.CommonTypeSystem

public class CommonEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	var CommonTypeSystem cts;
	
	@Inject
	CommonInterpreter inter;
	
	@Inject
	var CommonStringRepresentation csr;

	override def getFirstLine(EObject o) {
		val result = cts.type(o);

		if (result.failed()) {
			'no type '
		} else {
			val label = getLabel(o)
			val type = result.first
			var str = csr.string(type)
			
			if (o instanceof ValDeclaration) {
				val value = inter.interpretExpression(o.value)
				if (!value.failed)
					str += value.value
			}

			str + if (label !== null) ' <b>' + label + '</b>' else ''
		}
	}
}