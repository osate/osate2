package org.osate.annexsupport;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

public interface AnnexContentAssist {
	public List<String> annexCompletionSuggestions(EObject defaultAnnex, int offset);
}
