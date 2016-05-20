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
package org.osate.results.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AConditional;
import org.osate.alisa.common.common.AFunctionCall;
import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.ARange;
import org.osate.alisa.common.common.AUnaryOperation;
import org.osate.alisa.common.common.AUnitExpression;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ImageReference;
import org.osate.alisa.common.common.ModelRef;
import org.osate.alisa.common.common.PropertyRef;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.ResultIssue;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.TypeRef;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.results.results.IssuesReport;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultDataReport;
import org.osate.results.results.ResultReportCollection;
import org.osate.results.results.ResultsPackage;
import org.osate.results.services.ResultsGrammarAccess;

@SuppressWarnings("all")
public class ResultsSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private ResultsGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.AADL_BOOLEAN:
				sequence_TypeRef(context, (AadlBoolean) semanticObject); 
				return; 
			case Aadl2Package.AADL_INTEGER:
				sequence_TypeRef(context, (AadlInteger) semanticObject); 
				return; 
			case Aadl2Package.AADL_REAL:
				sequence_TypeRef(context, (AadlReal) semanticObject); 
				return; 
			case Aadl2Package.AADL_STRING:
				sequence_TypeRef(context, (AadlString) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_ABooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_AIntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_ARealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if (epackage == CommonPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CommonPackage.ABINARY_OPERATION:
				sequence_AAdditiveExpression_AAndExpression_AEqualityExpression_AMultiplicativeExpression_AOrExpression_ARelationalExpression(context, (ABinaryOperation) semanticObject); 
				return; 
			case CommonPackage.ACONDITIONAL:
				sequence_AIfExpression(context, (AConditional) semanticObject); 
				return; 
			case CommonPackage.AFUNCTION_CALL:
				sequence_AFunctionCall(context, (AFunctionCall) semanticObject); 
				return; 
			case CommonPackage.AMODEL_REFERENCE:
				sequence_AModelReference(context, (AModelReference) semanticObject); 
				return; 
			case CommonPackage.APROPERTY_REFERENCE:
				if (rule == grammarAccess.getAModelOrPropertyReferenceRule()
						|| rule == grammarAccess.getAExpressionRule()
						|| rule == grammarAccess.getAOrExpressionRule()
						|| action == grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAAndExpressionRule()
						|| action == grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAEqualityExpressionRule()
						|| action == grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getARelationalExpressionRule()
						|| action == grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAAdditiveExpressionRule()
						|| action == grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAMultiplicativeExpressionRule()
						|| action == grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAUnaryOperationRule()
						|| rule == grammarAccess.getAUnitExpressionRule()
						|| action == grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()
						|| rule == grammarAccess.getAPrimaryExpressionRule()
						|| rule == grammarAccess.getAParenthesizedExpressionRule()) {
					sequence_AModelOrPropertyReference_APropertyReference(context, (APropertyReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAPropertyReferenceRule()) {
					sequence_APropertyReference(context, (APropertyReference) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.ARANGE:
				sequence_ARangeExpression(context, (ARange) semanticObject); 
				return; 
			case CommonPackage.AUNARY_OPERATION:
				sequence_AUnaryOperation(context, (AUnaryOperation) semanticObject); 
				return; 
			case CommonPackage.AUNIT_EXPRESSION:
				sequence_AUnitExpression(context, (AUnitExpression) semanticObject); 
				return; 
			case CommonPackage.AVARIABLE_REFERENCE:
				sequence_AVariableReference(context, (AVariableReference) semanticObject); 
				return; 
			case CommonPackage.COMPUTE_DECLARATION:
				sequence_ComputeDeclaration(context, (ComputeDeclaration) semanticObject); 
				return; 
			case CommonPackage.DESCRIPTION:
				sequence_Description(context, (Description) semanticObject); 
				return; 
			case CommonPackage.DESCRIPTION_ELEMENT:
				sequence_DescriptionElement(context, (DescriptionElement) semanticObject); 
				return; 
			case CommonPackage.IMAGE_REFERENCE:
				sequence_ImageReference(context, (ImageReference) semanticObject); 
				return; 
			case CommonPackage.MODEL_REF:
				sequence_TypeRef(context, (ModelRef) semanticObject); 
				return; 
			case CommonPackage.PROPERTY_REF:
				sequence_PropertyRef(context, (PropertyRef) semanticObject); 
				return; 
			case CommonPackage.RATIONALE:
				sequence_Rationale(context, (Rationale) semanticObject); 
				return; 
			case CommonPackage.RESULT_ISSUE:
				sequence_ResultIssue(context, (ResultIssue) semanticObject); 
				return; 
			case CommonPackage.SHOW_VALUE:
				sequence_ShowValue(context, (ShowValue) semanticObject); 
				return; 
			case CommonPackage.TYPE_REF:
				sequence_TypeRef(context, (TypeRef) semanticObject); 
				return; 
			case CommonPackage.UNCERTAINTY:
				sequence_Uncertainty(context, (Uncertainty) semanticObject); 
				return; 
			case CommonPackage.VAL_DECLARATION:
				sequence_ValDeclaration(context, (ValDeclaration) semanticObject); 
				return; 
			}
		else if (epackage == ResultsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ResultsPackage.ISSUES_REPORT:
				sequence_IssuesReport(context, (IssuesReport) semanticObject); 
				return; 
			case ResultsPackage.RESULT_CONTRIBUTOR:
				sequence_ResultContributor(context, (ResultContributor) semanticObject); 
				return; 
			case ResultsPackage.RESULT_DATA:
				sequence_ResultData(context, (ResultData) semanticObject); 
				return; 
			case ResultsPackage.RESULT_DATA_REPORT:
				sequence_ResultDataReport(context, (ResultDataReport) semanticObject); 
				return; 
			case ResultsPackage.RESULT_REPORT_COLLECTION:
				sequence_ResultReportCollection(context, (ResultReportCollection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ResultReport returns IssuesReport
	 *     IssuesReport returns IssuesReport
	 *
	 * Constraint:
	 *     (name=ID target=[EObject|URIID]? description=STRING? issues+=ResultIssue*)
	 */
	protected void sequence_IssuesReport(ISerializationContext context, IssuesReport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ResultContributor returns ResultContributor
	 *
	 * Constraint:
	 *     (target=[EObject|URIID] resultData+=ResultData* issues+=ResultIssue* subcontributor+=ResultContributor*)
	 */
	protected void sequence_ResultContributor(ISerializationContext context, ResultContributor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ResultReport returns ResultDataReport
	 *     ResultDataReport returns ResultDataReport
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         target=[EObject|URIID] 
	 *         description=STRING? 
	 *         (heading=STRING content+=ResultContributor*)? 
	 *         resultData+=ResultData* 
	 *         issues+=ResultIssue*
	 *     )
	 */
	protected void sequence_ResultDataReport(ISerializationContext context, ResultDataReport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ResultData returns ResultData
	 *
	 * Constraint:
	 *     (name=ID (value=STRING | integerValue=INT))
	 */
	protected void sequence_ResultData(ISerializationContext context, ResultData semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ResultReport returns ResultReportCollection
	 *     ResultReportCollection returns ResultReportCollection
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         target=[EObject|URIID] 
	 *         description=STRING? 
	 *         content+=ResultReport* 
	 *         issues+=ResultIssue*
	 *     )
	 */
	protected void sequence_ResultReportCollection(ISerializationContext context, ResultReportCollection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
