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
					put(grammarAccess.getResultReportAccess().getAlternatives(), "rule__ResultReport__Alternatives");
					put(grammarAccess.getResultIssueTypeAccess().getAlternatives(), "rule__ResultIssueType__Alternatives");
					put(grammarAccess.getResultReportCollectionAccess().getGroup(), "rule__ResultReportCollection__Group__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_2(), "rule__ResultReportCollection__Group_2__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_6(), "rule__ResultReportCollection__Group_6__0");
					put(grammarAccess.getResultDataReportAccess().getGroup(), "rule__ResultDataReport__Group__0");
					put(grammarAccess.getResultDataReportAccess().getGroup_2(), "rule__ResultDataReport__Group_2__0");
					put(grammarAccess.getResultDataReportAccess().getGroup_6(), "rule__ResultDataReport__Group_6__0");
					put(grammarAccess.getResultDataReportAccess().getGroup_7(), "rule__ResultDataReport__Group_7__0");
					put(grammarAccess.getResultDataReportAccess().getGroup_8(), "rule__ResultDataReport__Group_8__0");
					put(grammarAccess.getResultContributorAccess().getGroup(), "rule__ResultContributor__Group__0");
					put(grammarAccess.getResultContributorAccess().getGroup_3(), "rule__ResultContributor__Group_3__0");
					put(grammarAccess.getIssuesReportAccess().getGroup(), "rule__IssuesReport__Group__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_2(), "rule__IssuesReport__Group_2__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_3(), "rule__IssuesReport__Group_3__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_3_1(), "rule__IssuesReport__Group_3_1__0");
					put(grammarAccess.getResultIssueAccess().getGroup(), "rule__ResultIssue__Group__0");
					put(grammarAccess.getResultIssueAccess().getGroup_3(), "rule__ResultIssue__Group_3__0");
					put(grammarAccess.getResultIssueAccess().getGroup_4(), "rule__ResultIssue__Group_4__0");
					put(grammarAccess.getResultIssueAccess().getGroup_5(), "rule__ResultIssue__Group_5__0");
					put(grammarAccess.getResultDataAccess().getGroup(), "rule__ResultData__Group__0");
					put(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1(), "rule__ResultReportCollection__NameAssignment_1");
					put(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1(), "rule__ResultReportCollection__TitleAssignment_2_1");
					put(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4(), "rule__ResultReportCollection__TargetAssignment_4");
					put(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1(), "rule__ResultReportCollection__DecriptionAssignment_6_1");
					put(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7(), "rule__ResultReportCollection__ContentAssignment_7");
					put(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8(), "rule__ResultReportCollection__IssuesAssignment_8");
					put(grammarAccess.getResultDataReportAccess().getNameAssignment_1(), "rule__ResultDataReport__NameAssignment_1");
					put(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1(), "rule__ResultDataReport__TitleAssignment_2_1");
					put(grammarAccess.getResultDataReportAccess().getTargetAssignment_4(), "rule__ResultDataReport__TargetAssignment_4");
					put(grammarAccess.getResultDataReportAccess().getDecriptionAssignment_6_1(), "rule__ResultDataReport__DecriptionAssignment_6_1");
					put(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1(), "rule__ResultDataReport__HeadingAssignment_7_1");
					put(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2(), "rule__ResultDataReport__ContentAssignment_7_2");
					put(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1(), "rule__ResultDataReport__ResultDataAssignment_8_1");
					put(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9(), "rule__ResultDataReport__IssuesAssignment_9");
					put(grammarAccess.getResultContributorAccess().getTargetAssignment_1(), "rule__ResultContributor__TargetAssignment_1");
					put(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1(), "rule__ResultContributor__ResultDataAssignment_3_1");
					put(grammarAccess.getResultContributorAccess().getIssuesAssignment_4(), "rule__ResultContributor__IssuesAssignment_4");
					put(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5(), "rule__ResultContributor__SubcontributorAssignment_5");
					put(grammarAccess.getIssuesReportAccess().getNameAssignment_1(), "rule__IssuesReport__NameAssignment_1");
					put(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1(), "rule__IssuesReport__TargetAssignment_2_1");
					put(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1(), "rule__IssuesReport__DescriptionAssignment_3_1_1");
					put(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2(), "rule__IssuesReport__IssuesAssignment_3_2");
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
			typedParser.entryRuleResultReport();
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
