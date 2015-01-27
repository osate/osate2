package org.osate.xtext.aadl2.ui.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;

public class AnnexAwareContentAssistProcessor extends XtextContentAssistProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor#createCompletionProposalComputer(org.eclipse.jface.text.ITextViewer, int)
	 */
	@Override
	protected CompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer, int offset) {
		return new AnnexAwareCompletionProposalComputer(this, viewer, offset);
	}

}
