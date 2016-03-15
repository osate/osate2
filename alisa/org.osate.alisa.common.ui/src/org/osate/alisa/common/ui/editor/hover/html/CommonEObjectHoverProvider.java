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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.PropertyType;
import org.osate.alisa.common.typing.CommonTypeSystem;

import com.google.inject.Inject;

import it.xsemantics.runtime.Result;

public class CommonEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	CommonTypeSystem cts;

	@Override
	protected String getFirstLine(EObject o) {
		Result<PropertyType> type = cts.type(o);

		if (!type.failed()) {
			String label = getLabel(o);
			PropertyType pt = type.getValue();
			String typename;

			if (pt instanceof AadlInteger) {
				typename = "integer";
			} else if (pt instanceof AadlReal) {
				typename = "real";
			} else if (pt instanceof AadlBoolean) {
				typename = "boolean";
			} else if (pt instanceof AadlString) {
				typename = "string";
			} else {
				typename = pt.getQualifiedName();
			}
			return typename + ((label != null) ? " <b>" + label + "</b>" : "");
		}
		return super.getFirstLine(o);
	}
}
