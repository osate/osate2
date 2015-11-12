package org.osate.alisa.workbench.ui.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.osate.aadl2.Aadl2Package;

public class AlisaLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		if (Aadl2Package.eINSTANCE.getComponentClassifier() == referenceType
				|| Aadl2Package.eINSTANCE.getComponentImplementation() == referenceType) {
			String targetName = "Component Classifier or Implementation";
			String msg = "Please provide model with target " + targetName + " '" + context.getLinkText()
					+ "' for verification.";
			return new DiagnosticMessage(msg, Severity.WARNING, Diagnostic.LINKING_DIAGNOSTIC);
		}
		return super.getUnresolvedProxyMessage(context);
	}
}
