/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.properties.ui.linking;

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
