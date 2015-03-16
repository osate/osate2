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
import org.osate.results.results.NameValuePair;
import org.osate.results.results.ReportIssue;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportEntry;
import org.osate.results.results.ResultsPackage;
import org.osate.results.services.ResultsGrammarAccess;

@SuppressWarnings("all")
public class ResultsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ResultsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ResultsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ResultsPackage.NAME_VALUE_PAIR:
				if(context == grammarAccess.getNameValuePairRule()) {
					sequence_NameValuePair(context, (NameValuePair) semanticObject); 
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
				if(context == grammarAccess.getResultContributorRule()) {
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
				if(context == grammarAccess.getResultReportRule()) {
					sequence_ResultReport(context, (ResultReport) semanticObject); 
					return; 
				}
				else break;
			case ResultsPackage.RESULT_REPORT_ENTRY:
				if(context == grammarAccess.getResultReportEntryRule()) {
					sequence_ResultReportEntry(context, (ResultReportEntry) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID value=STRING)
	 */
	protected void sequence_NameValuePair(EObject context, NameValuePair semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.NAME_VALUE_PAIR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.NAME_VALUE_PAIR__NAME));
			if(transientValues.isValueTransient(semanticObject, ResultsPackage.Literals.NAME_VALUE_PAIR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ResultsPackage.Literals.NAME_VALUE_PAIR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNameValuePairAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getNameValuePairAccess().getValueSTRINGTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
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
	 *     (contributor=[EObject|URIID] cell+=STRING+ issue+=ReportIssue* subcontributor+=ResultContributor*)
	 */
	protected void sequence_ResultContributor(EObject context, ResultContributor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     data+=NameValuePair+
	 */
	protected void sequence_ResultData(EObject context, ResultData semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         target=[EObject|URIID] 
	 *         decription=STRING? 
	 *         heading=STRING? 
	 *         resultData=ResultData? 
	 *         issue+=ReportIssue* 
	 *         row+=ResultContributor*
	 *     )
	 */
	protected void sequence_ResultReportEntry(EObject context, ResultReportEntry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         root=[EObject|URIID] 
	 *         decription=STRING? 
	 *         (heading=STRING content+=ResultReportEntry*)? 
	 *         resultData=ResultData? 
	 *         issue+=ReportIssue*
	 *     )
	 */
	protected void sequence_ResultReport(EObject context, ResultReport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
