package org.osate.reqspec.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.XExpression;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.Always;
import org.osate.reqspec.reqSpec.And;
import org.osate.reqspec.reqSpec.ArrayAccessExpr;
import org.osate.reqspec.reqSpec.ArrayExpr;
import org.osate.reqspec.reqSpec.ArrayType;
import org.osate.reqspec.reqSpec.BinaryExpr;
import org.osate.reqspec.reqSpec.BoolExpr;
import org.osate.reqspec.reqSpec.BooleanType;
import org.osate.reqspec.reqSpec.Divide;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.DomainExpr;
import org.osate.reqspec.reqSpec.EnumerationType;
import org.osate.reqspec.reqSpec.Enumerator;
import org.osate.reqspec.reqSpec.EqualTo;
import org.osate.reqspec.reqSpec.Exists;
import org.osate.reqspec.reqSpec.ExistsExpr;
import org.osate.reqspec.reqSpec.Exponentiation;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.FnCallExpr;
import org.osate.reqspec.reqSpec.ForallExpr;
import org.osate.reqspec.reqSpec.Function;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.GoalFolder;
import org.osate.reqspec.reqSpec.GreaterThan;
import org.osate.reqspec.reqSpec.GreaterThanEqual;
import org.osate.reqspec.reqSpec.IdExpr;
import org.osate.reqspec.reqSpec.IfThenElseExpr;
import org.osate.reqspec.reqSpec.Implies;
import org.osate.reqspec.reqSpec.InformalPredicate;
import org.osate.reqspec.reqSpec.IntExpr;
import org.osate.reqspec.reqSpec.IntegerSubRangeType;
import org.osate.reqspec.reqSpec.IntegerType;
import org.osate.reqspec.reqSpec.LessThan;
import org.osate.reqspec.reqSpec.LessThanEqual;
import org.osate.reqspec.reqSpec.Minus;
import org.osate.reqspec.reqSpec.Modulus;
import org.osate.reqspec.reqSpec.Multiply;
import org.osate.reqspec.reqSpec.NamedType;
import org.osate.reqspec.reqSpec.NamedUnit;
import org.osate.reqspec.reqSpec.Not;
import org.osate.reqspec.reqSpec.NotEqual;
import org.osate.reqspec.reqSpec.Or;
import org.osate.reqspec.reqSpec.Plus;
import org.osate.reqspec.reqSpec.PreExpr;
import org.osate.reqspec.reqSpec.Precedes;
import org.osate.reqspec.reqSpec.ProdUnit;
import org.osate.reqspec.reqSpec.QuantifiedVariable;
import org.osate.reqspec.reqSpec.QuotUnit;
import org.osate.reqspec.reqSpec.RealExpr;
import org.osate.reqspec.reqSpec.RealType;
import org.osate.reqspec.reqSpec.RecordAccessExpr;
import org.osate.reqspec.reqSpec.RecordExpr;
import org.osate.reqspec.reqSpec.RecordField;
import org.osate.reqspec.reqSpec.RecordFieldExpr;
import org.osate.reqspec.reqSpec.RecordType;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpecFolder;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ReqSpecs;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.Responds;
import org.osate.reqspec.reqSpec.SPeARPredicate;
import org.osate.reqspec.reqSpec.Scalar;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SumExpr;
import org.osate.reqspec.reqSpec.TypeDef;
import org.osate.reqspec.reqSpec.UnaryExpr;
import org.osate.reqspec.reqSpec.UnaryMinus;
import org.osate.reqspec.reqSpec.UnitDef;
import org.osate.reqspec.reqSpec.XPredicate;
import org.osate.reqspec.reqSpec.Xor;
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private ReqSpecGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CommonPackage.DESCRIPTION:
				if(context == grammarAccess.getDescriptionRule()) {
					sequence_Description(context, (Description) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.DESCRIPTION_ELEMENT:
				if(context == grammarAccess.getDescriptionElementRule()) {
					sequence_DescriptionElement(context, (DescriptionElement) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.SHOW_VALUE:
				if(context == grammarAccess.getShowValueRule()) {
					sequence_ShowValue(context, (ShowValue) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.XEXPRESSION:
				if(context == grammarAccess.getXValDeclarationRule()) {
					sequence_XValDeclaration(context, (XExpression) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == ReqSpecPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ReqSpecPackage.ALWAYS:
				if(context == grammarAccess.getFormulaOpsRule() ||
				   context == grammarAccess.getUnaryFormulaOpsRule()) {
					sequence_UnaryFormulaOps(context, (Always) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.AND:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getLogicalOpRule()) {
					sequence_LogicalOp(context, (And) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.ARRAY_ACCESS_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_ArrayAccessExpr(context, (ArrayAccessExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.ARRAY_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_QNExpr(context, (ArrayExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.ARRAY_TYPE:
				if(context == grammarAccess.getArrayTypeRule() ||
				   context == grammarAccess.getAtomicTypeRule() ||
				   context == grammarAccess.getFiniteSetTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_ArrayType(context, (ArrayType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.BINARY_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_AddExpr_ExpExpr_LogicalExpr_MultExpr_RelationalExpr(context, (BinaryExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.BOOL_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_AtomicExpr(context, (BoolExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.BOOLEAN_TYPE:
				if(context == grammarAccess.getAtomicTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_AtomicType(context, (BooleanType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.DIVIDE:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getDivideRule()) {
					sequence_Divide(context, (Divide) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.DOCUMENT_SECTION:
				if(context == grammarAccess.getDocumentSectionRule()) {
					sequence_DocumentSection(context, (DocumentSection) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.DOMAIN_EXPR:
				if(context == grammarAccess.getDomainRule()) {
					sequence_Domain(context, (DomainExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.ENUMERATION_TYPE:
				if(context == grammarAccess.getEnumerationTypeRule() ||
				   context == grammarAccess.getFiniteSetTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_EnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.ENUMERATOR:
				if(context == grammarAccess.getEnumeratorRule() ||
				   context == grammarAccess.getVariableRefRule()) {
					sequence_Enumerator(context, (Enumerator) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.EQUAL_TO:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getRelationalOpRule()) {
					sequence_RelationalOp(context, (EqualTo) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.EXISTS:
				if(context == grammarAccess.getFormulaOpsRule() ||
				   context == grammarAccess.getUnaryFormulaOpsRule()) {
					sequence_UnaryFormulaOps(context, (Exists) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.EXISTS_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExistsExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getQuantificationExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_ExistsExpr(context, (ExistsExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.EXPONENTIATION:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getExponentiationRule()) {
					sequence_Exponentiation(context, (Exponentiation) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.EXTERNAL_DOCUMENT:
				if(context == grammarAccess.getExternalDocumentRule()) {
					sequence_ExternalDocument(context, (ExternalDocument) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.FN_CALL_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_QNExpr(context, (FnCallExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.FORALL_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getForallExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getQuantificationExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_ForallExpr(context, (ForallExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.FUNCTION:
				if(context == grammarAccess.getCallRefRule() ||
				   context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.GOAL:
				if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getGoalRule()) {
					sequence_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.GOAL_FOLDER:
				if(context == grammarAccess.getGoalFolderRule() ||
				   context == grammarAccess.getReqSpecContainerRule()) {
					sequence_GoalFolder(context, (GoalFolder) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.GREATER_THAN:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getRelationalOpRule()) {
					sequence_RelationalOp(context, (GreaterThan) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.GREATER_THAN_EQUAL:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getRelationalOpRule()) {
					sequence_RelationalOp(context, (GreaterThanEqual) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.ID_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_QNExpr(context, (IdExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.IF_THEN_ELSE_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_IfExpr(context, (IfThenElseExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.IMPLIES:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getLogicalOpRule()) {
					sequence_LogicalOp(context, (Implies) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.INFORMAL_PREDICATE:
				if(context == grammarAccess.getInformalPredicateRule() ||
				   context == grammarAccess.getReqPredicateRule()) {
					sequence_InformalPredicate(context, (InformalPredicate) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.INT_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_AtomicExpr(context, (IntExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.INTEGER_SUB_RANGE_TYPE:
				if(context == grammarAccess.getAtomicTypeRule() ||
				   context == grammarAccess.getFiniteSetTypeRule() ||
				   context == grammarAccess.getIntegerSubRangeTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_IntegerSubRangeType(context, (IntegerSubRangeType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.INTEGER_TYPE:
				if(context == grammarAccess.getAtomicTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_AtomicType(context, (IntegerType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.LESS_THAN:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getRelationalOpRule()) {
					sequence_RelationalOp(context, (LessThan) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.LESS_THAN_EQUAL:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getRelationalOpRule()) {
					sequence_RelationalOp(context, (LessThanEqual) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.MINUS:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getMinusRule()) {
					sequence_Minus(context, (Minus) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.MODULUS:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getModulusRule()) {
					sequence_Modulus(context, (Modulus) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.MULTIPLY:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getMultiplyRule()) {
					sequence_Multiply(context, (Multiply) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.NAMED_TYPE:
				if(context == grammarAccess.getAtomicTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_AtomicType(context, (NamedType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.NAMED_UNIT:
				if(context == grammarAccess.getAtomicUnitRule() ||
				   context == grammarAccess.getNamedUnitRule() ||
				   context == grammarAccess.getProdUnitExprRule() ||
				   context == grammarAccess.getProdUnitExprAccess().getProdUnitLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitAccess().getQuotUnitLeftAction_1_0_0_0()) {
					sequence_NamedUnit(context, (NamedUnit) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.NOT:
				if(context == grammarAccess.getUnaryOpRule()) {
					sequence_UnaryOp(context, (Not) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.NOT_EQUAL:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getRelationalOpRule()) {
					sequence_RelationalOp(context, (NotEqual) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.OR:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getLogicalOpRule()) {
					sequence_LogicalOp(context, (Or) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.PLUS:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getPlusRule()) {
					sequence_Plus(context, (Plus) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.PRE_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_UnaryExpr(context, (PreExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.PRECEDES:
				if(context == grammarAccess.getBinaryFormulaOpsRule() ||
				   context == grammarAccess.getFormulaOpsRule()) {
					sequence_BinaryFormulaOps(context, (Precedes) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.PROD_UNIT:
				if(context == grammarAccess.getAtomicUnitRule() ||
				   context == grammarAccess.getProdUnitExprRule() ||
				   context == grammarAccess.getProdUnitExprAccess().getProdUnitLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitAccess().getQuotUnitLeftAction_1_0_0_0()) {
					sequence_ProdUnitExpr(context, (ProdUnit) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.QUANTIFIED_VARIABLE:
				if(context == grammarAccess.getQuantifiedVariableRule() ||
				   context == grammarAccess.getVariableRefRule()) {
					sequence_QuantifiedVariable(context, (QuantifiedVariable) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.QUOT_UNIT:
				if(context == grammarAccess.getAtomicUnitRule() ||
				   context == grammarAccess.getProdUnitExprRule() ||
				   context == grammarAccess.getProdUnitExprAccess().getProdUnitLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitAccess().getQuotUnitLeftAction_1_0_0_0()) {
					sequence_Unit(context, (QuotUnit) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REAL_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_AtomicExpr(context, (RealExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REAL_TYPE:
				if(context == grammarAccess.getAtomicTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_AtomicType(context, (RealType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RECORD_ACCESS_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_RecordAccessExpr(context, (RecordAccessExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RECORD_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_QNExpr(context, (RecordExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RECORD_FIELD:
				if(context == grammarAccess.getRecordFieldRule()) {
					sequence_RecordField(context, (RecordField) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RECORD_FIELD_EXPR:
				if(context == grammarAccess.getRecordFieldExprRule()) {
					sequence_RecordFieldExpr(context, (RecordFieldExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RECORD_TYPE:
				if(context == grammarAccess.getRecordTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_RecordType(context, (RecordType) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_DOCUMENT:
				if(context == grammarAccess.getReqDocumentRule() ||
				   context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule()) {
					sequence_ReqDocument(context, (ReqDocument) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_SPEC_FOLDER:
				if(context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecFolderRule()) {
					sequence_ReqSpecFolder(context, (ReqSpecFolder) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_SPECS:
				if(context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecsRule()) {
					sequence_ReqSpecs(context, (ReqSpecs) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQUIREMENT:
				if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getRequirementRule()) {
					sequence_Requirement(context, (Requirement) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RESPONDS:
				if(context == grammarAccess.getBinaryFormulaOpsRule() ||
				   context == grammarAccess.getFormulaOpsRule()) {
					sequence_BinaryFormulaOps(context, (Responds) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.SPE_AR_PREDICATE:
				if(context == grammarAccess.getReqPredicateRule() ||
				   context == grammarAccess.getSPeARPredicateRule()) {
					sequence_SPeARPredicate(context, (SPeARPredicate) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.SCALAR:
				if(context == grammarAccess.getAtomicUnitRule() ||
				   context == grammarAccess.getProdUnitExprRule() ||
				   context == grammarAccess.getProdUnitExprAccess().getProdUnitLeftAction_1_0_0_0() ||
				   context == grammarAccess.getScalarRule() ||
				   context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitAccess().getQuotUnitLeftAction_1_0_0_0()) {
					sequence_Scalar(context, (Scalar) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.STAKEHOLDER_GOALS:
				if(context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getStakeholderGoalsRule()) {
					sequence_StakeholderGoals(context, (StakeholderGoals) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.SUM_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getQuantificationExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_SumExpr(context, (SumExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.TYPE_DEF:
				if(context == grammarAccess.getTypeDefRule()) {
					sequence_TypeDef(context, (TypeDef) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.UNARY_EXPR:
				if(context == grammarAccess.getAddExprRule() ||
				   context == grammarAccess.getAddExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArrayAccessExprRule() ||
				   context == grammarAccess.getArrayAccessExprAccess().getArrayAccessExprArrayAction_1_0_0() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getExpExprRule() ||
				   context == grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLogicalExprRule() ||
				   context == grammarAccess.getLogicalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultExprRule() ||
				   context == grammarAccess.getMultExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getQNExprRule() ||
				   context == grammarAccess.getRecordAccessExprRule() ||
				   context == grammarAccess.getRecordAccessExprAccess().getRecordAccessExprRecordAction_1_0_0() ||
				   context == grammarAccess.getRelationalExprRule() ||
				   context == grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_UnaryExpr(context, (UnaryExpr) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.UNARY_MINUS:
				if(context == grammarAccess.getUnaryOpRule()) {
					sequence_UnaryOp(context, (UnaryMinus) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.UNIT_DEF:
				if(context == grammarAccess.getUnitDefRule()) {
					sequence_UnitDef(context, (UnitDef) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.XPREDICATE:
				if(context == grammarAccess.getReqPredicateRule() ||
				   context == grammarAccess.getXPredicateRule()) {
					sequence_XPredicate(context, (XPredicate) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.XOR:
				if(context == grammarAccess.getBinaryOpRule() ||
				   context == grammarAccess.getLogicalOpRule()) {
					sequence_LogicalOp(context, (Xor) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if(context == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				if(context == grammarAccess.getJvmTypeParameterRule()) {
					sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_UPPER_BOUND:
				if(context == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmWildcardTypeReferenceRule()) {
					sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XbasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XASSIGNMENT:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXBasicForLoopExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBasicForLoopExpression(context, (XBasicForLoopExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBINARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBLOCK_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXBlockExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXExpressionInClosureRule()) {
					sequence_XExpressionInClosure(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXBooleanLiteralRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASE_PART:
				if(context == grammarAccess.getXCasePartRule()) {
					sequence_XCasePart(context, (XCasePart) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASTED_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCATCH_CLAUSE:
				if(context == grammarAccess.getXCatchClauseRule()) {
					sequence_XCatchClause(context, (XCatchClause) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCLOSURE:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXClosureRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXConstructorCallRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XDO_WHILE_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXDoWhileExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFEATURE_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXForLoopExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XIF_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXIfExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XIfExpression(context, (XIfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XLIST_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXCollectionLiteralRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXListLiteralRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XMEMBER_FEATURE_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNULL_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXNullLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNUMBER_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXNumberLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XPOSTFIX_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XRETURN_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXReturnExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSET_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXCollectionLiteralRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXSetLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XSetLiteral(context, (XSetLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSTRING_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXStringLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSWITCH_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXSwitchExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXSynchronizedExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XSynchronizedExpression(context, (XSynchronizedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTHROW_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXThrowExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXTryCatchFinallyExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTYPE_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXTypeLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XUNARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XVARIABLE_DECLARATION:
				if(context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXVariableDeclarationRule()) {
					sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XWHILE_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXWhileExpressionRule()) {
					sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getXFunctionTypeRefRule()) {
					sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_DECLARATION:
				if(context == grammarAccess.getXImportDeclarationRule()) {
					sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_SECTION:
				if(context == grammarAccess.getXImportSectionRule()) {
					sequence_XImportSection(context, (XImportSection) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (left=MultExpr_BinaryExpr_1_0_0_0 (op=Multiply | op=Divide | op=Modulus) right=ExpExpr) | 
	 *         (left=ExpExpr_BinaryExpr_1_0_0_0 op=Exponentiation right=UnaryExpr) | 
	 *         (left=AddExpr_BinaryExpr_1_0_0_0 (op=Plus | op=Minus) right=MultExpr) | 
	 *         (left=RelationalExpr_BinaryExpr_1_0_0_0 op=RelationalOp right=AddExpr) | 
	 *         (left=LogicalExpr_BinaryExpr_1_0_0_0 op=LogicalOp right=RelationalExpr)
	 *     )
	 */
	protected void sequence_AddExpr_ExpExpr_LogicalExpr_MultExpr_RelationalExpr(EObject context, BinaryExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (array=ArrayAccessExpr_ArrayAccessExpr_1_0_0 index=Expr expr=Expr?)
	 */
	protected void sequence_ArrayAccessExpr(EObject context, ArrayAccessExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=AtomicType length=Expr)
	 */
	protected void sequence_ArrayType(EObject context, ArrayType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.ARRAY_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.ARRAY_TYPE__TYPE));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.ARRAY_TYPE__LENGTH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.ARRAY_TYPE__LENGTH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArrayTypeAccess().getTypeAtomicTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getArrayTypeAccess().getLengthExprParserRuleCall_3_0(), semanticObject.getLength());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=XBooleanLiteral
	 */
	protected void sequence_AtomicExpr(EObject context, BoolExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.BOOL_EXPR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.BOOL_EXPR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAtomicExprAccess().getValueXBooleanLiteralParserRuleCall_0_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value=INT unit=Unit?)
	 */
	protected void sequence_AtomicExpr(EObject context, IntExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=REAL unit=Unit?)
	 */
	protected void sequence_AtomicExpr(EObject context, RealExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BooleanType}
	 */
	protected void sequence_AtomicType(EObject context, BooleanType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {IntegerType}
	 */
	protected void sequence_AtomicType(EObject context, IntegerType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=[TypeDef|QualifiedName]
	 */
	protected void sequence_AtomicType(EObject context, NamedType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.NAMED_TYPE__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.NAMED_TYPE__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAtomicTypeAccess().getIdTypeDefQualifiedNameParserRuleCall_5_1_0_1(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {RealType}
	 */
	protected void sequence_AtomicType(EObject context, RealType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     string='precedes'
	 */
	protected void sequence_BinaryFormulaOps(EObject context, Precedes semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBinaryFormulaOpsAccess().getStringPrecedesKeyword_1_1_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     string='responds'
	 */
	protected void sequence_BinaryFormulaOps(EObject context, Responds semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBinaryFormulaOpsAccess().getStringRespondsKeyword_0_1_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Divide}
	 */
	protected void sequence_Divide(EObject context, Divide semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID title=STRING? description=Description? (content+=Goal | content+=Requirement | content+=DocumentSection)*)
	 */
	protected void sequence_DocumentSection(EObject context, DocumentSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     domain=Expr
	 */
	protected void sequence_Domain(EObject context, DomainExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.DOMAIN_EXPR__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.DOMAIN_EXPR__DOMAIN));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDomainAccess().getDomainExprParserRuleCall_2_0(), semanticObject.getDomain());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (Enumerators+=Enumerator Enumerators+=Enumerator*)
	 */
	protected void sequence_EnumerationType(EObject context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Enumerator(EObject context, Enumerator semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.VARIABLE_REF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.VARIABLE_REF__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumeratorAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (variable=QuantifiedVariable domain=Domain expr=Expr)
	 */
	protected void sequence_ExistsExpr(EObject context, ExistsExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__DOMAIN));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExistsExprAccess().getVariableQuantifiedVariableParserRuleCall_1_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getExistsExprAccess().getDomainDomainParserRuleCall_3_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getExistsExprAccess().getExprExprParserRuleCall_5_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Exponentiation}
	 */
	protected void sequence_Exponentiation(EObject context, Exponentiation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (docReference=DOCPATH docFragment=DOCFRAGMENT?)
	 */
	protected void sequence_ExternalDocument(EObject context, ExternalDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (variable=QuantifiedVariable domain=Domain expr=Expr)
	 */
	protected void sequence_ForallExpr(EObject context, ForallExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__DOMAIN));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getForallExprAccess().getVariableQuantifiedVariableParserRuleCall_1_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getForallExprAccess().getDomainDomainParserRuleCall_3_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getForallExprAccess().getExprExprParserRuleCall_5_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.FUNCTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.FUNCTION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID title=STRING? (content+=Goal | content+=GoalFolder)*)
	 */
	protected void sequence_GoalFolder(EObject context, GoalFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (target=[NamedElement|ID] | targetDescription=STRING)? 
	 *         category=[RequirementCategory|ID]? 
	 *         description=Description? 
	 *         rationale=STRING? 
	 *         refinesReference+=[Goal|QualifiedName]* 
	 *         conflictsReference+=[Goal|QualifiedName]* 
	 *         stakeholderReference+=[Stakeholder|QualifiedName]* 
	 *         documentRequirement+=[ContractualElement|QualifiedName]* 
	 *         docReference+=ExternalDocument*
	 *     )
	 */
	protected void sequence_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ifExpr=Expr thenExpr=Expr elseExpr=Expr)
	 */
	protected void sequence_IfExpr(EObject context, IfThenElseExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.IF_THEN_ELSE_EXPR__IF_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.IF_THEN_ELSE_EXPR__IF_EXPR));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.IF_THEN_ELSE_EXPR__THEN_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.IF_THEN_ELSE_EXPR__THEN_EXPR));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.IF_THEN_ELSE_EXPR__ELSE_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.IF_THEN_ELSE_EXPR__ELSE_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIfExprAccess().getIfExprExprParserRuleCall_0_2_0(), semanticObject.getIfExpr());
		feeder.accept(grammarAccess.getIfExprAccess().getThenExprExprParserRuleCall_0_4_0(), semanticObject.getThenExpr());
		feeder.accept(grammarAccess.getIfExprAccess().getElseExprExprParserRuleCall_0_6_0(), semanticObject.getElseExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     description=STRING
	 */
	protected void sequence_InformalPredicate(EObject context, InformalPredicate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.INFORMAL_PREDICATE__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.INFORMAL_PREDICATE__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInformalPredicateAccess().getDescriptionSTRINGTerminalRuleCall_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (low=Expr high=Expr)
	 */
	protected void sequence_IntegerSubRangeType(EObject context, IntegerSubRangeType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.INTEGER_SUB_RANGE_TYPE__LOW) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.INTEGER_SUB_RANGE_TYPE__LOW));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.INTEGER_SUB_RANGE_TYPE__HIGH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.INTEGER_SUB_RANGE_TYPE__HIGH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntegerSubRangeTypeAccess().getLowExprParserRuleCall_3_0(), semanticObject.getLow());
		feeder.accept(grammarAccess.getIntegerSubRangeTypeAccess().getHighExprParserRuleCall_5_0(), semanticObject.getHigh());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {And}
	 */
	protected void sequence_LogicalOp(EObject context, And semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Implies}
	 */
	protected void sequence_LogicalOp(EObject context, Implies semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Or}
	 */
	protected void sequence_LogicalOp(EObject context, Or semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Xor}
	 */
	protected void sequence_LogicalOp(EObject context, Xor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Minus}
	 */
	protected void sequence_Minus(EObject context, Minus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Modulus}
	 */
	protected void sequence_Modulus(EObject context, Modulus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Multiply}
	 */
	protected void sequence_Multiply(EObject context, Multiply semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=[UnitDef|QualifiedName]
	 */
	protected void sequence_NamedUnit(EObject context, NamedUnit semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.NAMED_UNIT__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.NAMED_UNIT__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedUnitAccess().getIdUnitDefQualifiedNameParserRuleCall_0_1(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Plus}
	 */
	protected void sequence_Plus(EObject context, Plus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=ProdUnitExpr_ProdUnit_1_0_0_0 right=AtomicUnit)
	 */
	protected void sequence_ProdUnitExpr(EObject context, ProdUnit semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.PROD_UNIT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.PROD_UNIT__LEFT));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.PROD_UNIT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.PROD_UNIT__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProdUnitExprAccess().getProdUnitLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getProdUnitExprAccess().getRightAtomicUnitParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (exprs+=Expr exprs+=Expr*)
	 */
	protected void sequence_QNExpr(EObject context, ArrayExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=[CallRef|QualifiedName] (args+=Expr args+=Expr*)?)
	 */
	protected void sequence_QNExpr(EObject context, FnCallExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=[VariableRef|QualifiedName]
	 */
	protected void sequence_QNExpr(EObject context, IdExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.ID_EXPR__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.ID_EXPR__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQNExprAccess().getIdVariableRefQualifiedNameParserRuleCall_0_1_0_1(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=[TypeDef|QualifiedName] recordFields+=RecordFieldExpr recordFields+=RecordFieldExpr*)
	 */
	protected void sequence_QNExpr(EObject context, RecordExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_QuantifiedVariable(EObject context, QuantifiedVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.VARIABLE_REF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.VARIABLE_REF__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQuantifiedVariableAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (record=RecordAccessExpr_RecordAccessExpr_1_0_0 field=[RecordField|QualifiedName] expr=Expr?)
	 */
	protected void sequence_RecordAccessExpr(EObject context, RecordAccessExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (field=[RecordField|QualifiedName] expr=Expr)
	 */
	protected void sequence_RecordFieldExpr(EObject context, RecordFieldExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.RECORD_FIELD_EXPR__FIELD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.RECORD_FIELD_EXPR__FIELD));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.RECORD_FIELD_EXPR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.RECORD_FIELD_EXPR__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRecordFieldExprAccess().getFieldRecordFieldQualifiedNameParserRuleCall_0_0_1(), semanticObject.getField());
		feeder.accept(grammarAccess.getRecordFieldExprAccess().getExprExprParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=AtomicType unit=Unit?)
	 */
	protected void sequence_RecordField(EObject context, RecordField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (fields+=RecordField fields+=RecordField*)
	 */
	protected void sequence_RecordType(EObject context, RecordType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EqualTo}
	 */
	protected void sequence_RelationalOp(EObject context, EqualTo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {GreaterThan}
	 */
	protected void sequence_RelationalOp(EObject context, GreaterThan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {GreaterThanEqual}
	 */
	protected void sequence_RelationalOp(EObject context, GreaterThanEqual semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LessThan}
	 */
	protected void sequence_RelationalOp(EObject context, LessThan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LessThanEqual}
	 */
	protected void sequence_RelationalOp(EObject context, LessThanEqual semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {NotEqual}
	 */
	protected void sequence_RelationalOp(EObject context, NotEqual semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID title=STRING? description=Description? content+=DocumentSection)
	 */
	protected void sequence_ReqDocument(EObject context, ReqDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID title=STRING? (content+=Goal | content+=Requirement | content+=ReqSpecFolder)*)
	 */
	protected void sequence_ReqSpecFolder(EObject context, ReqSpecFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         target=[Classifier|AadlClassifierReference]? 
	 *         otherreqspecs+=[ReqSpecs|QualifiedName]* 
	 *         (content+=Requirement | content+=ReqSpecFolder)*
	 *     )
	 */
	protected void sequence_ReqSpecs(EObject context, ReqSpecs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (target=[NamedElement|ID] | targetDescription=STRING)? 
	 *         category=[RequirementCategory|ID]? 
	 *         description=Description? 
	 *         constants+=XValDeclaration* 
	 *         predicate=ReqPredicate? 
	 *         rationale=STRING? 
	 *         goalReference+=[Goal|QualifiedName]* 
	 *         (exception=[EObject|ID] | exceptionText=STRING)? 
	 *         refinedReference+=[Requirement|QualifiedName]* 
	 *         stakeholderRequirementReference+=[Goal|QualifiedName]* 
	 *         documentRequirement+=[ContractualElement|QualifiedName]* 
	 *         docReference+=ExternalDocument*
	 *     )
	 */
	protected void sequence_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     predicate=Expr
	 */
	protected void sequence_SPeARPredicate(EObject context, SPeARPredicate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.SPE_AR_PREDICATE__PREDICATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.SPE_AR_PREDICATE__PREDICATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSPeARPredicateAccess().getPredicateExprParserRuleCall_1_0(), semanticObject.getPredicate());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Scalar}
	 */
	protected void sequence_Scalar(EObject context, Scalar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (target=[Classifier|AadlClassifierReference] | targetDescription=STRING)? 
	 *         description=Description? 
	 *         (content+=Goal | content+=GoalFolder)
	 *     )
	 */
	protected void sequence_StakeholderGoals(EObject context, StakeholderGoals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (variable=QuantifiedVariable domain=Domain expr=Expr)
	 */
	protected void sequence_SumExpr(EObject context, SumExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__DOMAIN));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUANTIFICATION_EXPR__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSumExprAccess().getVariableQuantifiedVariableParserRuleCall_1_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getSumExprAccess().getDomainDomainParserRuleCall_3_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getSumExprAccess().getExprExprParserRuleCall_5_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=Type)
	 */
	protected void sequence_TypeDef(EObject context, TypeDef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.TYPE_DEF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.TYPE_DEF__NAME));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.TYPE_DEF__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.TYPE_DEF__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expr=UnaryExpr
	 */
	protected void sequence_UnaryExpr(EObject context, PreExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.PRE_EXPR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.PRE_EXPR__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnaryExprAccess().getExprUnaryExprParserRuleCall_1_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOp expr=UnaryExpr)
	 */
	protected void sequence_UnaryExpr(EObject context, UnaryExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.UNARY_EXPR__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.UNARY_EXPR__OP));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.UNARY_EXPR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.UNARY_EXPR__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnaryExprAccess().getOpUnaryOpParserRuleCall_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getUnaryExprAccess().getExprUnaryExprParserRuleCall_0_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     string='always'
	 */
	protected void sequence_UnaryFormulaOps(EObject context, Always semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnaryFormulaOpsAccess().getStringAlwaysKeyword_0_1_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     string='exists'
	 */
	protected void sequence_UnaryFormulaOps(EObject context, Exists semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.FORMULA_OPS__STRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnaryFormulaOpsAccess().getStringExistsKeyword_1_1_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Not}
	 */
	protected void sequence_UnaryOp(EObject context, Not semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {UnaryMinus}
	 */
	protected void sequence_UnaryOp(EObject context, UnaryMinus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID unit=Unit?)
	 */
	protected void sequence_UnitDef(EObject context, UnitDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Unit_QuotUnit_1_0_0_0 right=ProdUnitExpr)
	 */
	protected void sequence_Unit(EObject context, QuotUnit semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUOT_UNIT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUOT_UNIT__LEFT));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.QUOT_UNIT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.QUOT_UNIT__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnitAccess().getQuotUnitLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getUnitAccess().getRightProdUnitExprParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     Xlambda=XClosure
	 */
	protected void sequence_XPredicate(EObject context, XPredicate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.XPREDICATE__XLAMBDA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.XPREDICATE__XLAMBDA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getXPredicateAccess().getXlambdaXClosureParserRuleCall_0(), semanticObject.getXlambda());
		feeder.finish();
	}
}
