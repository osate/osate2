package org.osate.xtext.aadl2.properties.ui.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

public class PropertiesLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider{

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		String targetName = referenceType.getName();
		if (targetName.equalsIgnoreCase("AbstractNamedValue")){
			targetName = "Property Constant, Property Definition, Enumeration or Unit literal";
		}
		String msg = "Couldn't resolve reference to " + targetName + " '" + context.getLinkText() + "'.";
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}

}
