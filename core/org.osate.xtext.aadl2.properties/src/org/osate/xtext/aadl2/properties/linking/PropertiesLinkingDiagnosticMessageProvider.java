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
package org.osate.xtext.aadl2.properties.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;

public class PropertiesLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		String targetName = null;
		if (Aadl2Package.eINSTANCE.getAbstractNamedValue() == referenceType) {
			targetName = "Property Constant, Property Definition, Enumeration or Unit literal";
			String msg = "Couldn't resolve reference to " + targetName + " '" + context.getLinkText() + "'."
					+ " For classifier references use classifier( <ref> ).";
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		if (Aadl2Package.eINSTANCE.getProperty() == referenceType) {
			String msg = "Couldn't resolve reference to property definition '" + context.getLinkText() + "'."
					+ (context.getLinkText().indexOf("::") < 0 ? " Property set name may be missing." : "");
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		if (Aadl2Package.eINSTANCE.getPropertyType() == referenceType) {
			String msg = "Couldn't resolve reference to property type '" + context.getLinkText() + "'."
					+ (context.getLinkText().indexOf("::") < 0 ? " Property set name may be missing." : "");
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		if (Aadl2Package.eINSTANCE.getPropertyConstant() == referenceType) {
			String msg = "Couldn't resolve reference to property constant '" + context.getLinkText() + "'."
					+ (context.getLinkText().indexOf("::") < 0 ? " Property set name may be missing." : "");
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		if (Aadl2Package.eINSTANCE.getNamedElement() == referenceType) {
			EObject obj = context.getContext();
			if (obj instanceof ContainmentPathElement) {
				Subcomponent sub = AadlUtil.getContainingSubcomponent(obj);
				INode node = NodeModelUtils.findActualNodeFor(obj);
				String name = NodeModelUtils.getTokenText(node);
				if (sub != null && !(obj.eContainer() instanceof ContainmentPathElement)) {
					String msg = "Could not find path element " + name + " in subcomponent " + sub.getName();
					return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
				}
			}
			String msg = "Couldn't resolve reference to '" + context.getLinkText() + "'.";
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		if (Aadl2Package.eINSTANCE.getMode() == referenceType) {
			EObject cxt = context.getContext();
			PropertyAssociation pa = AadlUtil.getContainingPropertyAssociation(cxt);
			boolean iscontainedPA = (pa != null && !pa.getAppliesTos().isEmpty());
			String msg = "Couldn't resolve reference to mode '" + context.getLinkText() + "'";
			if (iscontainedPA) {
				EList<ContainedNamedElement> appl = pa.getAppliesTos();
				ContainedNamedElement path = appl.get(appl.size() - 1);
				msg = msg + " in applies to '" + Aadl2Util.getPrintablePathName(path) + "'.";
			} else {
				msg = msg + ".";
			}
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		return super.getUnresolvedProxyMessage(context);
	}
}
