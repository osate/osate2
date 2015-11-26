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
package org.osate.results.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.results.services.ResultsGrammarAccess;

public class ResultsParser extends AbstractContentAssistParser {
	
	@Inject
	private ResultsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser createParser() {
		org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser result = new org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getResultReportsAccess().getAlternatives(), "rule__ResultReports__Alternatives");
					put(grammarAccess.getResultIssueTypeAccess().getAlternatives(), "rule__ResultIssueType__Alternatives");
					put(grammarAccess.getResultReportCollectionAccess().getGroup(), "rule__ResultReportCollection__Group__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_2(), "rule__ResultReportCollection__Group_2__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_6(), "rule__ResultReportCollection__Group_6__0");
					put(grammarAccess.getResultReportAccess().getGroup(), "rule__ResultReport__Group__0");
					put(grammarAccess.getResultReportAccess().getGroup_3(), "rule__ResultReport__Group_3__0");
					put(grammarAccess.getResultReportAccess().getGroup_7(), "rule__ResultReport__Group_7__0");
					put(grammarAccess.getResultReportAccess().getGroup_9(), "rule__ResultReport__Group_9__0");
					put(grammarAccess.getResultReportAccess().getGroup_10(), "rule__ResultReport__Group_10__0");
					put(grammarAccess.getResultReportAccess().getGroup_11(), "rule__ResultReport__Group_11__0");
					put(grammarAccess.getResultContributorAccess().getGroup(), "rule__ResultContributor__Group__0");
					put(grammarAccess.getResultContributorAccess().getGroup_5(), "rule__ResultContributor__Group_5__0");
					put(grammarAccess.getIssueReportAccess().getGroup(), "rule__IssueReport__Group__0");
					put(grammarAccess.getIssueReportAccess().getGroup_4(), "rule__IssueReport__Group_4__0");
					put(grammarAccess.getIssueReportAccess().getGroup_5(), "rule__IssueReport__Group_5__0");
					put(grammarAccess.getIssueReportAccess().getGroup_6(), "rule__IssueReport__Group_6__0");
					put(grammarAccess.getResultIssueAccess().getGroup(), "rule__ResultIssue__Group__0");
					put(grammarAccess.getResultIssueAccess().getGroup_3(), "rule__ResultIssue__Group_3__0");
					put(grammarAccess.getResultIssueAccess().getGroup_4(), "rule__ResultIssue__Group_4__0");
					put(grammarAccess.getResultIssueAccess().getGroup_5(), "rule__ResultIssue__Group_5__0");
					put(grammarAccess.getResultDataAccess().getGroup(), "rule__ResultData__Group__0");
					put(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1(), "rule__ResultReportCollection__NameAssignment_1");
					put(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1(), "rule__ResultReportCollection__TitleAssignment_2_1");
					put(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5(), "rule__ResultReportCollection__TargetAssignment_5");
					put(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1(), "rule__ResultReportCollection__DecriptionAssignment_6_1");
					put(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7(), "rule__ResultReportCollection__ContentAssignment_7");
					put(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8(), "rule__ResultReportCollection__IssuesAssignment_8");
					put(grammarAccess.getResultReportAccess().getNameAssignment_2(), "rule__ResultReport__NameAssignment_2");
					put(grammarAccess.getResultReportAccess().getTitleAssignment_3_1(), "rule__ResultReport__TitleAssignment_3_1");
					put(grammarAccess.getResultReportAccess().getTargetAssignment_4(), "rule__ResultReport__TargetAssignment_4");
					put(grammarAccess.getResultReportAccess().getIssueTypeAssignment_5(), "rule__ResultReport__IssueTypeAssignment_5");
					put(grammarAccess.getResultReportAccess().getMessageAssignment_6(), "rule__ResultReport__MessageAssignment_6");
					put(grammarAccess.getResultReportAccess().getExceptionTypeAssignment_7_1(), "rule__ResultReport__ExceptionTypeAssignment_7_1");
					put(grammarAccess.getResultReportAccess().getDecriptionAssignment_9_1(), "rule__ResultReport__DecriptionAssignment_9_1");
					put(grammarAccess.getResultReportAccess().getHeadingAssignment_10_1(), "rule__ResultReport__HeadingAssignment_10_1");
					put(grammarAccess.getResultReportAccess().getContentAssignment_10_2(), "rule__ResultReport__ContentAssignment_10_2");
					put(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1(), "rule__ResultReport__ResultDataAssignment_11_1");
					put(grammarAccess.getResultReportAccess().getIssuesAssignment_12(), "rule__ResultReport__IssuesAssignment_12");
					put(grammarAccess.getResultContributorAccess().getTargetAssignment_2(), "rule__ResultContributor__TargetAssignment_2");
					put(grammarAccess.getResultContributorAccess().getIssueTypeAssignment_3(), "rule__ResultContributor__IssueTypeAssignment_3");
					put(grammarAccess.getResultContributorAccess().getMessageAssignment_4(), "rule__ResultContributor__MessageAssignment_4");
					put(grammarAccess.getResultContributorAccess().getExceptionTypeAssignment_5_1(), "rule__ResultContributor__ExceptionTypeAssignment_5_1");
					put(grammarAccess.getResultContributorAccess().getCellAssignment_8(), "rule__ResultContributor__CellAssignment_8");
					put(grammarAccess.getResultContributorAccess().getIssuesAssignment_9(), "rule__ResultContributor__IssuesAssignment_9");
					put(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_10(), "rule__ResultContributor__SubcontributorAssignment_10");
					put(grammarAccess.getIssueReportAccess().getIssueTypeAssignment_2(), "rule__IssueReport__IssueTypeAssignment_2");
					put(grammarAccess.getIssueReportAccess().getMessageAssignment_3(), "rule__IssueReport__MessageAssignment_3");
					put(grammarAccess.getIssueReportAccess().getTargetAssignment_4_1(), "rule__IssueReport__TargetAssignment_4_1");
					put(grammarAccess.getIssueReportAccess().getExceptionTypeAssignment_5_1(), "rule__IssueReport__ExceptionTypeAssignment_5_1");
					put(grammarAccess.getIssueReportAccess().getIssuesAssignment_6_1(), "rule__IssueReport__IssuesAssignment_6_1");
					put(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1(), "rule__ResultIssue__IssueTypeAssignment_1");
					put(grammarAccess.getResultIssueAccess().getMessageAssignment_2(), "rule__ResultIssue__MessageAssignment_2");
					put(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1(), "rule__ResultIssue__TargetAssignment_3_1");
					put(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1(), "rule__ResultIssue__ExceptionTypeAssignment_4_1");
					put(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1(), "rule__ResultIssue__IssuesAssignment_5_1");
					put(grammarAccess.getResultDataAccess().getNameAssignment_0(), "rule__ResultData__NameAssignment_0");
					put(grammarAccess.getResultDataAccess().getValueAssignment_2(), "rule__ResultData__ValueAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser typedParser = (org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser) parser;
			typedParser.entryRuleResultReports();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ResultsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ResultsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
