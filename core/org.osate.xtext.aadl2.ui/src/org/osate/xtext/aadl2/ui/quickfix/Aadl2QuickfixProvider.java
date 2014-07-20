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

package org.osate.xtext.aadl2.ui.quickfix;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.validation.Issue;
import org.osate.xtext.aadl2.validation.Aadl2JavaValidator;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class Aadl2QuickfixProvider extends DefaultQuickfixProvider {
//	@Inject
//	private Provider<IssueResolutionAcceptor> issueResolutionAcceptorProvider;
//	@Inject
//	private IssueModificationContext.Factory modificationContextFactory;
//	static final Pattern sideIssuePattern = Pattern.compile("^Couldn't resolve reference to SideDefinition '([a-zA-Z0-9_\\-]+)'\\.$");
//
//	@Override
//	public List<IssueResolution> getResolutionsForLinkingIssue(final Issue issue) {
//		final IssueResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
//		final IModificationContext modificationContext = modificationContextFactory.createModificationContext(issue);
//		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
//
//		List<IssueResolution> originalResolutions = super.getResolutionsForLinkingIssue(issue);
//		List<IssueResolution> finalResolutions = new ArrayList<IssueResolution>();
//		
//		// Hack - we are checking the contents of the issue message to determine
//		// if it is the issue we are interested in:
//		final Pattern changeToResolutionPattern = Pattern.compile("^Change to '([a-zA-Z0-9_\\-]+)'$");
//		Matcher issueMatcher = sideIssuePattern.matcher(issue.getMessage());
//		if (issueMatcher.find())
//		{
//			for (IssueResolution resolution : originalResolutions)
//			{
//				Matcher resolutionMatcher = changeToResolutionPattern.matcher(resolution.getDescription());
//				if (resolutionMatcher.find())
//				{
//					try
//					{
//						// Create a new resolution, equivalent to the one we removed, except
//						// that the replacement string is surrounded by double-quotes:
//						String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
//						
//						String replacement = "\"" + resolutionMatcher.group(1) + "\"";
//						String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
//						issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel, fixCrossReferenceImage(
//								issueString, replacement), new ReplaceModification(issue, replacement));
//					} catch (BadLocationException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				else finalResolutions.add(resolution);
//			}
//		}
//		finalResolutions.addAll(issueResolutionAcceptor.getIssueResolutions());
//		return finalResolutions;
//	}
	
	
	@Fix("org.eclipse.xtext.diagnostics.Diagnostic.Syntax")
	public void fixsyntax(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "syntax name", "Capitalize the name.", "upcase.png", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
			}
		});
	}

	@Fix("org.eclipse.xtext.diagnostics.Diagnostic.Linking")
	public void fixlinking(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "linking name", "Capitalize the name.", "upcase.png", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
			}
		});
	}
	
//	@Fix(Aadl2JavaValidator.INVALID_NAME)
//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
//			public void apply(IModificationContext context) throws BadLocationException {
//				IXtextDocument xtextDocument = context.getXtextDocument();
//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
//				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
//			}
//		});
//	}

}
