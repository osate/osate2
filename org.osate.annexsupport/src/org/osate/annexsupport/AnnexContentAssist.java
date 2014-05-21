package org.osate.annexsupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

public interface AnnexContentAssist {
	public void callAnnexContentAssist(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor);
}
