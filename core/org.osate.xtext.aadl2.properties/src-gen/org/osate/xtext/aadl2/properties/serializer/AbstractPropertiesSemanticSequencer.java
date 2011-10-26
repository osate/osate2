package org.osate.xtext.aadl2.properties.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractPropertiesSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected PropertiesGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Aadl2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				if(context == grammarAccess.getArrayRangeRule()) {
					sequence_ArrayRange(context, (ArrayRange) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				if(context == grammarAccess.getFieldPropertyAssociationRule()) {
					sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.BOOLEAN_LITERAL:
				if(context == grammarAccess.getActualBooleanTermRule() ||
				   context == grammarAccess.getAndTermRule() ||
				   context == grammarAccess.getAndTermAccess().getOperationOwnedPropertyExpressionAction_1_0() ||
				   context == grammarAccess.getBooleanAtomRule() ||
				   context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getBooleanTermRule() ||
				   context == grammarAccess.getOrTermRule() ||
				   context == grammarAccess.getOrTermAccess().getOperationOwnedPropertyExpressionAction_1_0() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CLASSIFIER_VALUE:
				if(context == grammarAccess.getComponentClassifierTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.COMPUTED_VALUE:
				if(context == grammarAccess.getComputedTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				if(context == grammarAccess.getContainmentPathRule()) {
					sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				if(context == grammarAccess.getContainmentPathElementRule()) {
					sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.INTEGER_LITERAL:
				if(context == grammarAccess.getIntegerTermRule() ||
				   context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.LIST_VALUE:
				if(context == grammarAccess.getListTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ListTerm(context, (ListValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if(context == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if(context == grammarAccess.getActualBooleanTermRule() ||
				   context == grammarAccess.getAndTermRule() ||
				   context == grammarAccess.getAndTermAccess().getOperationOwnedPropertyExpressionAction_1_0() ||
				   context == grammarAccess.getBooleanAtomRule() ||
				   context == grammarAccess.getBooleanTermRule() ||
				   context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getOrTermRule() ||
				   context == grammarAccess.getOrTermAccess().getOperationOwnedPropertyExpressionAction_1_0()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyExpressionRule()) {
					sequence_PropertyExpression(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				if(context == grammarAccess.getActualAndTermRule()) {
					sequence_ActualAndTerm(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActualBooleanTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ActualBooleanTerm(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActualOrTermRule()) {
					sequence_ActualOrTerm(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBooleanTermRule() ||
				   context == grammarAccess.getOrTermRule() ||
				   context == grammarAccess.getOrTermAccess().getOperationOwnedPropertyExpressionAction_1_0()) {
					sequence_AndTerm(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAndTermRule() ||
				   context == grammarAccess.getAndTermAccess().getOperationOwnedPropertyExpressionAction_1_0() ||
				   context == grammarAccess.getBooleanAtomRule()) {
					sequence_BooleanAtom(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNotTermRule()) {
					sequence_NotTerm(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getSignedConstantRule()) {
					sequence_SignedConstant(context, (Operation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if(context == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPModelRule()) {
					sequence_PModel(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				if(context == grammarAccess.getNumericRangeTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REAL_LITERAL:
				if(context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getRealTermRule()) {
					sequence_RealTerm(context, (RealLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RECORD_VALUE:
				if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getReferenceTermRule()) {
					sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.STRING_LITERAL:
				if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getStringTermRule()) {
					sequence_StringTerm(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (ownedPropertyExpression+=BooleanAtom op=AndOp ownedPropertyExpression+=BooleanAtom (op=AndOp ownedPropertyExpression+=BooleanAtom)*)
	 *
	 * Features:
	 *    op[1, *]
	 *    ownedPropertyExpression[2, *]
	 */
	protected void sequence_ActualAndTerm(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ownedPropertyExpression+=AndTerm op=OrOp ownedPropertyExpression+=AndTerm (op=OrOp ownedPropertyExpression+=AndTerm)*) | 
	 *         (ownedPropertyExpression+=BooleanAtom op=AndOp ownedPropertyExpression+=BooleanAtom (op=AndOp ownedPropertyExpression+=BooleanAtom)*) | 
	 *         (op=NotOp ownedPropertyExpression+=BooleanAtom)
	 *     )
	 *
	 * Features:
	 *    op[0, *]
	 *    ownedPropertyExpression[0, *]
	 */
	protected void sequence_ActualBooleanTerm(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPropertyExpression+=AndTerm op=OrOp ownedPropertyExpression+=AndTerm (op=OrOp ownedPropertyExpression+=AndTerm)*)
	 *
	 * Features:
	 *    op[1, *]
	 *    ownedPropertyExpression[2, *]
	 */
	protected void sequence_ActualOrTerm(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ownedPropertyExpression+=AndTerm_Operation_1_0 op=AndOp ownedPropertyExpression+=BooleanAtom) | 
	 *         (op=NotOp ownedPropertyExpression+=BooleanAtom) | 
	 *         (ownedPropertyExpression+=OrTerm_Operation_1_0 op=OrOp ownedPropertyExpression+=AndTerm)
	 *     )
	 *
	 * Features:
	 *    op[0, 3]
	 *    ownedPropertyExpression[0, 5]
	 */
	protected void sequence_AndTerm(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=INTVALUE upperBound=INTVALUE?)
	 *
	 * Features:
	 *    lowerBound[1, 1]
	 *    upperBound[0, 1]
	 */
	protected void sequence_ArrayRange(EObject context, ArrayRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=[Property|QPREF] ownedValue+=PropertyValue)
	 *
	 * Features:
	 *    property[1, 1]
	 *    ownedValue[1, 1]
	 */
	protected void sequence_BasicPropertyAssociation(EObject context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (op=NotOp ownedPropertyExpression+=BooleanAtom) | 
	 *         (ownedPropertyExpression+=OrTerm_Operation_1_0 op=OrOp ownedPropertyExpression+=AndTerm) | 
	 *         (ownedPropertyExpression+=AndTerm_Operation_1_0 op=AndOp ownedPropertyExpression+=BooleanAtom)
	 *     )
	 *
	 * Features:
	 *    op[0, 3]
	 *    ownedPropertyExpression[0, 5]
	 */
	protected void sequence_BooleanAtom(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value?='true'?)
	 *
	 * Features:
	 *    value[0, 1]
	 */
	protected void sequence_BooleanLiteral(EObject context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     classifier=[ComponentClassifier|QCREF]
	 *
	 * Features:
	 *    classifier[1, 1]
	 */
	protected void sequence_ComponentClassifierTerm(EObject context, ClassifierValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     function=ID
	 *
	 * Features:
	 *    function[1, 1]
	 */
	protected void sequence_ComputedTerm(EObject context, ComputedValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     namedValue=[PropertyConstant|QPREF]
	 *
	 * Features:
	 *    namedValue[1, 1]
	 */
	protected void sequence_ConstantValue(EObject context, NamedValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         append?='+=>'? 
	 *         constant?='constant'? 
	 *         (ownedValue+=PropertyValue | (ownedValue+=ModalPropertyValue ownedValue+=ModalPropertyValue* ownedValue+=PropertyValue?)) 
	 *         (appliesTo+=ContainmentPath appliesTo+=ContainmentPath*)?
	 *     )
	 *
	 * Features:
	 *    property[1, 1]
	 *    appliesTo[0, *]
	 *    append[0, 1]
	 *    constant[0, 1]
	 *    ownedValue[0, *]
	 */
	protected void sequence_ContainedPropertyAssociation(EObject context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((namedElement=[NamedElement|ID] arrayRange+=ArrayRange?) | namedElement=[NamedElement|ANNEXREF])
	 *
	 * Features:
	 *    arrayRange[0, 1]
	 *         EXCLUDE_IF_UNSET namedElement
	 *         EXCLUDE_IF_SET namedElement
	 *    namedElement[0, 2]
	 */
	protected void sequence_ContainmentPathElement(EObject context, ContainmentPathElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (containmentPathElement+=ContainmentPathElement containmentPathElement+=ContainmentPathElement*)
	 *
	 * Features:
	 *    containmentPathElement[1, *]
	 */
	protected void sequence_ContainmentPath(EObject context, ContainedNamedElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=[BasicProperty|ID] ownedValue=PropertyExpression)
	 *
	 * Features:
	 *    property[1, 1]
	 *    ownedValue[1, 1]
	 */
	protected void sequence_FieldPropertyAssociation(EObject context, BasicPropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=SignedInt unit=[UnitLiteral|ID]?)
	 *
	 * Features:
	 *    unit[0, 1]
	 *    value[1, 1]
	 */
	protected void sequence_IntegerTerm(EObject context, IntegerLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedListElement+=PropertyExpression ownedListElement+=PropertyExpression*)
	 *
	 * Features:
	 *    ownedListElement[1, *]
	 */
	protected void sequence_ListTerm(EObject context, ListValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     namedValue=[AbstractNamedValue|QPREF]
	 *
	 * Features:
	 *    namedValue[1, 1]
	 */
	protected void sequence_LiteralorReferenceTerm(EObject context, NamedValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedValue=PropertyExpression inMode+=[Mode|ID] inMode+=[Mode|ID]*)
	 *
	 * Features:
	 *    inMode[1, *]
	 *    ownedValue[1, 1]
	 */
	protected void sequence_ModalPropertyValue(EObject context, ModalPropertyValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=NotOp ownedPropertyExpression+=BooleanAtom)
	 *
	 * Features:
	 *    op[1, 1]
	 *    ownedPropertyExpression[1, 1]
	 */
	protected void sequence_NotTerm(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (minimum=NumAlt maximum=NumAlt delta=NumAlt?)
	 *
	 * Features:
	 *    minimum[1, 1]
	 *    maximum[1, 1]
	 *    delta[0, 1]
	 */
	protected void sequence_NumericRangeTerm(EObject context, RangeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             property=[Property|QPREF] 
	 *             append?='+=>'? 
	 *             constant?='constant'? 
	 *             (ownedValue+=PropertyValue | (ownedValue+=ModalPropertyValue ownedValue+=ModalPropertyValue* ownedValue+=PropertyValue?)) 
	 *             (appliesTo+=ContainmentPath appliesTo+=ContainmentPath*)?
	 *         ) | 
	 *         (property=[Property|QPREF] ownedValue+=PropertyValue) | 
	 *         (
	 *             property=[Property|QPREF] 
	 *             append?='+=>'? 
	 *             constant?='constant'? 
	 *             (ownedValue+=PropertyValue | (ownedValue+=ModalPropertyValue ownedValue+=ModalPropertyValue* ownedValue+=PropertyValue?))
	 *         )
	 *     )
	 *
	 * Features:
	 *    property[0, 3]
	 *    appliesTo[0, *]
	 *         EXCLUDE_IF_UNSET property
	 *         EXCLUDE_IF_SET property
	 *         EXCLUDE_IF_SET ownedValue
	 *         EXCLUDE_IF_SET property
	 *         EXCLUDE_IF_SET append
	 *         EXCLUDE_IF_SET constant
	 *         EXCLUDE_IF_SET ownedValue
	 *         EXCLUDE_IF_SET ownedValue
	 *         EXCLUDE_IF_SET ownedValue
	 *         EXCLUDE_IF_SET ownedValue
	 *    append[0, 2]
	 *         EXCLUDE_IF_SET property
	 *         EXCLUDE_IF_SET ownedValue
	 *    constant[0, 2]
	 *         EXCLUDE_IF_SET property
	 *         EXCLUDE_IF_SET ownedValue
	 *    ownedValue[0, *]
	 */
	protected void sequence_PModel(EObject context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         append?='+=>'? 
	 *         constant?='constant'? 
	 *         (ownedValue+=PropertyValue | (ownedValue+=ModalPropertyValue ownedValue+=ModalPropertyValue* ownedValue+=PropertyValue?))
	 *     )
	 *
	 * Features:
	 *    property[1, 1]
	 *    append[0, 1]
	 *    constant[0, 1]
	 *    ownedValue[0, *]
	 */
	protected void sequence_PropertyAssociation(EObject context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (namedValue=[PropertyConstant|QPREF] | namedValue=[AbstractNamedValue|QPREF])
	 *
	 * Features:
	 *    namedValue[0, 2]
	 */
	protected void sequence_PropertyExpression(EObject context, NamedValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedValue=PropertyExpression
	 *
	 * Features:
	 *    ownedValue[1, 1]
	 */
	protected void sequence_PropertyValue(EObject context, ModalPropertyValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=SignedReal unit=[UnitLiteral|ID]?)
	 *
	 * Features:
	 *    unit[0, 1]
	 *    value[1, 1]
	 */
	protected void sequence_RealTerm(EObject context, RealLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedFieldValue+=FieldPropertyAssociation+
	 *
	 * Features:
	 *    ownedFieldValue[1, *]
	 */
	protected void sequence_RecordTerm(EObject context, RecordValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (containmentPathElement+=ContainmentPathElement containmentPathElement+=ContainmentPathElement*)
	 *
	 * Features:
	 *    containmentPathElement[1, *]
	 */
	protected void sequence_ReferenceTerm(EObject context, ReferenceValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=PlusMinus ownedPropertyExpression+=ConstantValue)
	 *
	 * Features:
	 *    op[1, 1]
	 *    ownedPropertyExpression[1, 1]
	 */
	protected void sequence_SignedConstant(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=NoQuoteString
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_StringTerm(EObject context, StringLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
