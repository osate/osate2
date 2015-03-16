package org.osate.results.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.results.results.IssuesReport;
import org.osate.results.results.ReportIssue;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportCollection;
import org.osate.results.results.ResultsPackage;
import org.osate.results.services.ResultsGrammarAccess;

@SuppressWarnings("all")
public class ResultsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ResultsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ResultsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ResultsPackage.ISSUES_REPORT:
				if(context == grammarAccess.getIssuesReportRule() ||
				   context == grammarAccess.getResultIssueHolderRule() ||
				   context == grammarAccess.getResultReportsRule()) {
					sequence_IssuesReport(context, (IssuesReport) semanticObject); 
					return; 
				}
				else break;
			case ResultsPackage.REPORT_ISSUE:
				if(context == grammarAccess.getReportIssueRule()) {
					sequence_ReportIssue(context, (ReportIssue) semanticObject); 
					return; 
				}
				else break;
			case ResultsPackage.RESULT_CONTRIBUTOR:
				if(context == grammarAccess.getResultContributorRule() ||
				   context == grammarAccess.getResultIssueHolderRule()) {
					sequence_ResultContributor(context, (ResultContributor) semanticObject); 
					return; 
				}
				else break;
			case ResultsPackage.RESULT_DATA:
				if(context == grammarAccess.getResultDataRule()) {
					sequence_ResultData(context, (ResultData) semanticObject); 
					return; 
				}
				else break;
			case ResultsPackage.RESULT_REPORT:
				if(context == grammarAccess.getResultIssueHolderRule() ||
				   context == grammarAccess.getResultReportRule() ||
				   context == grammarAccess.getResultReportsRule()) {
					sequence_ResultReport(context, (ResultReport) semanticObject); 
					return; 
				}
				else break;
			case ResultsPackage.RESULT_REPORT_COLLECTION:
				if(context == grammarAccess.getResultIssueHolderRule() ||
				   context == grammarAccess.getResultReportCollectionRule() ||
				   context == grammarAccess.getResultReportsRule()) {
					sequence_ResultReportCollection(context, (ResultReportCollection) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID title=STRING? target=[EObject|URIID] decription=STRING? issues+=ReportIssue*)
	 */
	protected void sequence_IssuesReport(EObject context, IssuesReport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (issueType=ReportIssueType title=STRING target=[EObject|URIID])
	 */
	protected void sequence_ReportIssue(EObject context, ReportIssue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.REPORT_ISSUE__ISSUE_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.REPORT_ISSUE__ISSUE_TYPE));
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.REPORT_ISSUE__TITLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.REPORT_ISSUE__TITLE));
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.REPORT_ISSUE__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.REPORT_ISSUE__TARGET));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReportIssueAccess().getIssueTypeReportIssueTypeEnumRuleCall_0_0(), semanticObject.getIssueType());
		feeder.accept(grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0(), semanticObject.getTitle());
		feeder.accept(grammarAccess.getReportIssueAccess().getTargetEObjectURIIDParserRuleCall_2_0_1(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (contributor=[EObject|URIID] cell+=STRING+ issues+=ReportIssue* subcontributor+=ResultContributor*)
	 */
	protected void sequence_ResultContributor(EObject context, ResultContributor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=STRING)
	 */
	protected void sequence_ResultData(EObject context, ResultData semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.RESULT_DATA__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.RESULT_DATA__NAME));
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.RESULT_DATA__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.RESULT_DATA__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         target=[EObject|URIID] 
	 *         decription=STRING? 
	 *         content+=ResultReport* 
	 *         issues+=ReportIssue*
	 *     )
	 */
	protected void sequence_ResultReportCollection(EObject context, ResultReportCollection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         target=[EObject|URIID] 
	 *         decription=STRING? 
	 *         (heading=STRING content+=ResultContributor*)? 
	 *         resultData+=ResultData* 
	 *         issues+=ReportIssue*
	 *     )
	 */
	protected void sequence_ResultReport(EObject context, ResultReport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
