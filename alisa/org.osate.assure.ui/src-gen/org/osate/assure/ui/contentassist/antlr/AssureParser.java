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
package org.osate.assure.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.assure.services.AssureGrammarAccess;

public class AssureParser extends AbstractContentAssistParser {
	
	@Inject
	private AssureGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser createParser() {
		org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser result = new org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getAssureResultAccess().getAlternatives(), "rule__AssureResult__Alternatives");
					put(grammarAccess.getVerificationExprAccess().getAlternatives(), "rule__VerificationExpr__Alternatives");
					put(grammarAccess.getResultReportAccess().getAlternatives(), "rule__ResultReport__Alternatives");
					put(grammarAccess.getElseTypeAccess().getAlternatives(), "rule__ElseType__Alternatives");
					put(grammarAccess.getVerificationResultStateAccess().getAlternatives(), "rule__VerificationResultState__Alternatives");
					put(grammarAccess.getVerificationExecutionStateAccess().getAlternatives(), "rule__VerificationExecutionState__Alternatives");
					put(grammarAccess.getResultIssueTypeAccess().getAlternatives(), "rule__ResultIssueType__Alternatives");
					put(grammarAccess.getAssuranceCaseAccess().getGroup(), "rule__AssuranceCase__Group__0");
					put(grammarAccess.getAssuranceCaseAccess().getGroup_2(), "rule__AssuranceCase__Group_2__0");
					put(grammarAccess.getAssuranceCaseAccess().getGroup_3(), "rule__AssuranceCase__Group_3__0");
					put(grammarAccess.getAssuranceCaseAccess().getGroup_6(), "rule__AssuranceCase__Group_6__0");
					put(grammarAccess.getClaimResultAccess().getGroup(), "rule__ClaimResult__Group__0");
					put(grammarAccess.getClaimResultAccess().getGroup_4(), "rule__ClaimResult__Group_4__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup(), "rule__PreconditionResult__Group__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup_8(), "rule__PreconditionResult__Group_8__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup_9(), "rule__PreconditionResult__Group_9__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup_11(), "rule__PreconditionResult__Group_11__0");
					put(grammarAccess.getValidationResultAccess().getGroup(), "rule__ValidationResult__Group__0");
					put(grammarAccess.getValidationResultAccess().getGroup_8(), "rule__ValidationResult__Group_8__0");
					put(grammarAccess.getValidationResultAccess().getGroup_9(), "rule__ValidationResult__Group_9__0");
					put(grammarAccess.getValidationResultAccess().getGroup_11(), "rule__ValidationResult__Group_11__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup(), "rule__VerificationActivityResult__Group__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_8(), "rule__VerificationActivityResult__Group_8__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_9(), "rule__VerificationActivityResult__Group_9__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_11(), "rule__VerificationActivityResult__Group_11__0");
					put(grammarAccess.getElseResultAccess().getGroup(), "rule__ElseResult__Group__0");
					put(grammarAccess.getElseResultAccess().getGroup_2(), "rule__ElseResult__Group_2__0");
					put(grammarAccess.getElseResultAccess().getGroup_3(), "rule__ElseResult__Group_3__0");
					put(grammarAccess.getElseResultAccess().getGroup_4(), "rule__ElseResult__Group_4__0");
					put(grammarAccess.getThenResultAccess().getGroup(), "rule__ThenResult__Group__0");
					put(grammarAccess.getMetricsAccess().getGroup(), "rule__Metrics__Group__0");
					put(grammarAccess.getMetricsAccess().getGroup_1(), "rule__Metrics__Group_1__0");
					put(grammarAccess.getMetricsAccess().getGroup_2(), "rule__Metrics__Group_2__0");
					put(grammarAccess.getMetricsAccess().getGroup_3(), "rule__Metrics__Group_3__0");
					put(grammarAccess.getMetricsAccess().getGroup_4(), "rule__Metrics__Group_4__0");
					put(grammarAccess.getMetricsAccess().getGroup_5(), "rule__Metrics__Group_5__0");
					put(grammarAccess.getMetricsAccess().getGroup_6(), "rule__Metrics__Group_6__0");
					put(grammarAccess.getMetricsAccess().getGroup_7(), "rule__Metrics__Group_7__0");
					put(grammarAccess.getMetricsAccess().getGroup_8(), "rule__Metrics__Group_8__0");
					put(grammarAccess.getMetricsAccess().getGroup_9(), "rule__Metrics__Group_9__0");
					put(grammarAccess.getMetricsAccess().getGroup_10(), "rule__Metrics__Group_10__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup(), "rule__AadlClassifierReference__Group__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1(), "rule__AadlClassifierReference__Group_1__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2(), "rule__AadlClassifierReference__Group_2__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
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
					put(grammarAccess.getResultDataAccess().getGroup(), "rule__ResultData__Group__0");
					put(grammarAccess.getIssuesReportAccess().getGroup(), "rule__IssuesReport__Group__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_2(), "rule__IssuesReport__Group_2__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_3(), "rule__IssuesReport__Group_3__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_3_1(), "rule__IssuesReport__Group_3_1__0");
					put(grammarAccess.getResultIssueAccess().getGroup(), "rule__ResultIssue__Group__0");
					put(grammarAccess.getResultIssueAccess().getGroup_3(), "rule__ResultIssue__Group_3__0");
					put(grammarAccess.getResultIssueAccess().getGroup_4(), "rule__ResultIssue__Group_4__0");
					put(grammarAccess.getResultIssueAccess().getGroup_5(), "rule__ResultIssue__Group_5__0");
					put(grammarAccess.getAssuranceCaseAccess().getNameAssignment_1(), "rule__AssuranceCase__NameAssignment_1");
					put(grammarAccess.getAssuranceCaseAccess().getTargetAssignment_2_1(), "rule__AssuranceCase__TargetAssignment_2_1");
					put(grammarAccess.getAssuranceCaseAccess().getTargetSystemAssignment_3_1(), "rule__AssuranceCase__TargetSystemAssignment_3_1");
					put(grammarAccess.getAssuranceCaseAccess().getMetricsAssignment_5(), "rule__AssuranceCase__MetricsAssignment_5");
					put(grammarAccess.getAssuranceCaseAccess().getMessageAssignment_6_1(), "rule__AssuranceCase__MessageAssignment_6_1");
					put(grammarAccess.getAssuranceCaseAccess().getClaimResultAssignment_7(), "rule__AssuranceCase__ClaimResultAssignment_7");
					put(grammarAccess.getAssuranceCaseAccess().getSubAssuranceCaseAssignment_8(), "rule__AssuranceCase__SubAssuranceCaseAssignment_8");
					put(grammarAccess.getClaimResultAccess().getTargetAssignment_1(), "rule__ClaimResult__TargetAssignment_1");
					put(grammarAccess.getClaimResultAccess().getMetricsAssignment_3(), "rule__ClaimResult__MetricsAssignment_3");
					put(grammarAccess.getClaimResultAccess().getMessageAssignment_4_1(), "rule__ClaimResult__MessageAssignment_4_1");
					put(grammarAccess.getClaimResultAccess().getSubClaimResultAssignment_5(), "rule__ClaimResult__SubClaimResultAssignment_5");
					put(grammarAccess.getClaimResultAccess().getVerificationActivityResultAssignment_6(), "rule__ClaimResult__VerificationActivityResultAssignment_6");
					put(grammarAccess.getPreconditionResultAccess().getTargetAssignment_2(), "rule__PreconditionResult__TargetAssignment_2");
					put(grammarAccess.getPreconditionResultAccess().getExecutionStateAssignment_5(), "rule__PreconditionResult__ExecutionStateAssignment_5");
					put(grammarAccess.getPreconditionResultAccess().getResultStateAssignment_7(), "rule__PreconditionResult__ResultStateAssignment_7");
					put(grammarAccess.getPreconditionResultAccess().getIssuesAssignment_8_2(), "rule__PreconditionResult__IssuesAssignment_8_2");
					put(grammarAccess.getPreconditionResultAccess().getResultReportAssignment_9_1(), "rule__PreconditionResult__ResultReportAssignment_9_1");
					put(grammarAccess.getPreconditionResultAccess().getMetricsAssignment_10(), "rule__PreconditionResult__MetricsAssignment_10");
					put(grammarAccess.getPreconditionResultAccess().getMessageAssignment_11_1(), "rule__PreconditionResult__MessageAssignment_11_1");
					put(grammarAccess.getValidationResultAccess().getTargetAssignment_2(), "rule__ValidationResult__TargetAssignment_2");
					put(grammarAccess.getValidationResultAccess().getExecutionStateAssignment_5(), "rule__ValidationResult__ExecutionStateAssignment_5");
					put(grammarAccess.getValidationResultAccess().getResultStateAssignment_7(), "rule__ValidationResult__ResultStateAssignment_7");
					put(grammarAccess.getValidationResultAccess().getIssuesAssignment_8_2(), "rule__ValidationResult__IssuesAssignment_8_2");
					put(grammarAccess.getValidationResultAccess().getResultReportAssignment_9_1(), "rule__ValidationResult__ResultReportAssignment_9_1");
					put(grammarAccess.getValidationResultAccess().getMetricsAssignment_10(), "rule__ValidationResult__MetricsAssignment_10");
					put(grammarAccess.getValidationResultAccess().getMessageAssignment_11_1(), "rule__ValidationResult__MessageAssignment_11_1");
					put(grammarAccess.getVerificationActivityResultAccess().getTargetAssignment_2(), "rule__VerificationActivityResult__TargetAssignment_2");
					put(grammarAccess.getVerificationActivityResultAccess().getExecutionStateAssignment_5(), "rule__VerificationActivityResult__ExecutionStateAssignment_5");
					put(grammarAccess.getVerificationActivityResultAccess().getResultStateAssignment_7(), "rule__VerificationActivityResult__ResultStateAssignment_7");
					put(grammarAccess.getVerificationActivityResultAccess().getIssuesAssignment_8_2(), "rule__VerificationActivityResult__IssuesAssignment_8_2");
					put(grammarAccess.getVerificationActivityResultAccess().getResultReportAssignment_9_1(), "rule__VerificationActivityResult__ResultReportAssignment_9_1");
					put(grammarAccess.getVerificationActivityResultAccess().getMetricsAssignment_10(), "rule__VerificationActivityResult__MetricsAssignment_10");
					put(grammarAccess.getVerificationActivityResultAccess().getMessageAssignment_11_1(), "rule__VerificationActivityResult__MessageAssignment_11_1");
					put(grammarAccess.getVerificationActivityResultAccess().getPreconditionResultAssignment_12(), "rule__VerificationActivityResult__PreconditionResultAssignment_12");
					put(grammarAccess.getVerificationActivityResultAccess().getValidationResultAssignment_13(), "rule__VerificationActivityResult__ValidationResultAssignment_13");
					put(grammarAccess.getElseResultAccess().getFirstAssignment_1(), "rule__ElseResult__FirstAssignment_1");
					put(grammarAccess.getElseResultAccess().getErrorAssignment_2_1(), "rule__ElseResult__ErrorAssignment_2_1");
					put(grammarAccess.getElseResultAccess().getFailAssignment_3_1(), "rule__ElseResult__FailAssignment_3_1");
					put(grammarAccess.getElseResultAccess().getTimeoutAssignment_4_1(), "rule__ElseResult__TimeoutAssignment_4_1");
					put(grammarAccess.getElseResultAccess().getDidFailAssignment_6(), "rule__ElseResult__DidFailAssignment_6");
					put(grammarAccess.getElseResultAccess().getMetricsAssignment_7(), "rule__ElseResult__MetricsAssignment_7");
					put(grammarAccess.getThenResultAccess().getFirstAssignment_1(), "rule__ThenResult__FirstAssignment_1");
					put(grammarAccess.getThenResultAccess().getSecondAssignment_3(), "rule__ThenResult__SecondAssignment_3");
					put(grammarAccess.getThenResultAccess().getDidThenFailAssignment_5(), "rule__ThenResult__DidThenFailAssignment_5");
					put(grammarAccess.getThenResultAccess().getMetricsAssignment_6(), "rule__ThenResult__MetricsAssignment_6");
					put(grammarAccess.getMetricsAccess().getTbdCountAssignment_1_1(), "rule__Metrics__TbdCountAssignment_1_1");
					put(grammarAccess.getMetricsAccess().getSuccessCountAssignment_2_1(), "rule__Metrics__SuccessCountAssignment_2_1");
					put(grammarAccess.getMetricsAccess().getFailCountAssignment_3_1(), "rule__Metrics__FailCountAssignment_3_1");
					put(grammarAccess.getMetricsAccess().getTimeoutCountAssignment_4_1(), "rule__Metrics__TimeoutCountAssignment_4_1");
					put(grammarAccess.getMetricsAccess().getErrorCountAssignment_5_1(), "rule__Metrics__ErrorCountAssignment_5_1");
					put(grammarAccess.getMetricsAccess().getDidelseCountAssignment_6_1(), "rule__Metrics__DidelseCountAssignment_6_1");
					put(grammarAccess.getMetricsAccess().getThenskipCountAssignment_7_1(), "rule__Metrics__ThenskipCountAssignment_7_1");
					put(grammarAccess.getMetricsAccess().getPreconditionfailCountAssignment_8_1(), "rule__Metrics__PreconditionfailCountAssignment_8_1");
					put(grammarAccess.getMetricsAccess().getValidationfailCountAssignment_9_1(), "rule__Metrics__ValidationfailCountAssignment_9_1");
					put(grammarAccess.getMetricsAccess().getWeightAssignment_10_1(), "rule__Metrics__WeightAssignment_10_1");
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
					put(grammarAccess.getResultDataAccess().getNameAssignment_0(), "rule__ResultData__NameAssignment_0");
					put(grammarAccess.getResultDataAccess().getValueAssignment_2(), "rule__ResultData__ValueAssignment_2");
					put(grammarAccess.getIssuesReportAccess().getNameAssignment_1(), "rule__IssuesReport__NameAssignment_1");
					put(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1(), "rule__IssuesReport__TargetAssignment_2_1");
					put(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1(), "rule__IssuesReport__DescriptionAssignment_3_1_1");
					put(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2(), "rule__IssuesReport__IssuesAssignment_3_2");
					put(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1(), "rule__ResultIssue__IssueTypeAssignment_1");
					put(grammarAccess.getResultIssueAccess().getMessageAssignment_2(), "rule__ResultIssue__MessageAssignment_2");
					put(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1(), "rule__ResultIssue__TargetAssignment_3_1");
					put(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1(), "rule__ResultIssue__ExceptionTypeAssignment_4_1");
					put(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1(), "rule__ResultIssue__IssuesAssignment_5_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser typedParser = (org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser) parser;
			typedParser.entryRuleAssuranceCase();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public AssureGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AssureGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
