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
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.Property
import org.osate.alisa.common.common.ModelRef
import org.osate.alisa.common.typing.CommonTypeSystem

public class CommonEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	var CommonTypeSystem cts;

	override def getFirstLine(EObject o) {
		val result = cts.type(o);

		if (!result.failed()) {
			val label = getLabel(o);
			val type = result.getValue();
			val typename = if (type.name == null) {
					val owner = type.eContainer
					if (owner instanceof Property) {
						'typeof(' + owner.qualifiedName() + ')'
					} else {
						switch (type) {
							AadlInteger: 'integer'
							AadlReal: 'real'
							AadlBoolean: 'boolean'
							AadlString: 'string'
							ModelRef: 'model element'
						}
					}
				} else {
					type.qualifiedName()
				}
			typename + if (label != null) ' <b>' + label + '</b>' else ''
		} else {
			super.getFirstLine(o);
		}
	}
}