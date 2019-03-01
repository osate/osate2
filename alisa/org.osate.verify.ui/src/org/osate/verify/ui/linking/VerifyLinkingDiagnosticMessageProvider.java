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

package org.osate.verify.ui.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.assure.util.ResoluteUtil;
import org.osate.verify.verify.VerifyPackage;

public class VerifyLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		if (Aadl2Package.eINSTANCE.getComponentImplementation() == referenceType) {
			String targetName = "Component Implementation";
			String msg = "Please provide model with target " + targetName + " '" + context.getLinkText()
					+ "' for verification.";
			return new DiagnosticMessage(msg, Severity.WARNING, Diagnostic.LINKING_DIAGNOSTIC);
		}
		if (VerifyPackage.eINSTANCE.getResoluteMethod_MethodReference() == context.getReference()) {
			if (ResoluteUtil.isResoluteInstalled()) {
				return new DiagnosticMessage("Could not find referenced Resolute claim function.", Severity.WARNING,
						Diagnostic.LINKING_DIAGNOSTIC);
			} else {
				return new DiagnosticMessage("Resolute is not installed in OSATE.", Severity.WARNING,
						Diagnostic.LINKING_DIAGNOSTIC);
			}
		}
		return super.getUnresolvedProxyMessage(context);
	}
}
