/*
 * /**
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
package org.osate.xtext.aadl2.ui.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.annexsupport.AnnexContentAssist;
import org.osate.annexsupport.AnnexContentAssistRegistry;
import org.osate.annexsupport.AnnexRegistry;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class Aadl2ProposalProvider extends AbstractAadl2ProposalProvider {
	
	AnnexContentAssistRegistry annexContentAssistRegistry ;
	
	protected void initAnnexContentAssistRegistry(){
		if (annexContentAssistRegistry == null){
		annexContentAssistRegistry = (AnnexContentAssistRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_CONTENT_ASSIST_EXT_ID);
		}
	}
	
	
	@Override
	public void completeDefaultAnnexSubclause_SourceText(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		NamedElement annex = AadlUtil.getContainingAnnex(model);
		if (annex != null){
			String annexName = annex.getName();
			if (annexName != null ){ 
				if (annexContentAssistRegistry == null) initAnnexContentAssistRegistry();
				if (annexContentAssistRegistry != null){
					AnnexContentAssist contentAssist = annexContentAssistRegistry.getAnnexContentAssist(annexName);
					if (contentAssist != null){
						List<String> results = contentAssist.annexCompletionSuggestions(model, context.getOffset());
						super.completeDefaultAnnexLibrary_SourceText(model, assignment, context, acceptor);
						String prefix = context.getPrefix();
						
						for(String res : results){
							StyledString display = new StyledString(res);
							String replace = prefix + res;
							acceptor.accept(createCompletionProposal(replace, display, null, context));
						}
					}
				}
			}
		}
	}
	
	@Override
	public void completeDefaultAnnexLibrary_SourceText(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeDefaultAnnexSubclause_SourceText(model, assignment, context, acceptor);
	}
}
