package org.osate.xtext.aadl2.propertyset.serializer;

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
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.Operation;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;
import org.osate.xtext.aadl2.propertyset.services.PropertysetGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractPropertysetSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected PropertysetGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<PropertiesSemanticSequencer> superSequencerProvider;
	 
	protected PropertiesSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Aadl2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.AADL_BOOLEAN:
				if(context == grammarAccess.getBooleanTypeRule() ||
				   context == grammarAccess.getPropertyTypeRule()) {
					sequence_BooleanType(context, (AadlBoolean) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedBooleanTypeRule() ||
				   context == grammarAccess.getUnnamedPropertyTypeRule()) {
					sequence_UnnamedPropertyType(context, (AadlBoolean) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.AADL_INTEGER:
				if(context == grammarAccess.getIntegerTypeRule() ||
				   context == grammarAccess.getPropertyTypeRule()) {
					sequence_IntegerType(context, (AadlInteger) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedIntegerTypeRule() ||
				   context == grammarAccess.getUnnamedPropertyTypeRule()) {
					sequence_UnnamedIntegerType(context, (AadlInteger) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.AADL_REAL:
				if(context == grammarAccess.getPropertyTypeRule() ||
				   context == grammarAccess.getRealTypeRule()) {
					sequence_RealType(context, (AadlReal) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedPropertyTypeRule() ||
				   context == grammarAccess.getUnnamedRealTypeRule()) {
					sequence_UnnamedRealType(context, (AadlReal) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.AADL_STRING:
				if(context == grammarAccess.getPropertyTypeRule() ||
				   context == grammarAccess.getStringTypeRule()) {
					sequence_StringType(context, (AadlString) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedPropertyTypeRule() ||
				   context == grammarAccess.getUnnamedStringTypeRule()) {
					sequence_UnnamedPropertyType(context, (AadlString) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.ARRAY_RANGE:
				if(context == grammarAccess.getArrayRangeRule()) {
					sequence_ArrayRange(context, (ArrayRange) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.BASIC_PROPERTY:
				if(context == grammarAccess.getRecordFieldRule()) {
					sequence_RecordField(context, (BasicProperty) semanticObject); 
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
				if(context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CLASSIFIER_TYPE:
				if(context == grammarAccess.getClassifierTypeRule() ||
				   context == grammarAccess.getPropertyTypeRule()) {
					sequence_ClassifierType(context, (ClassifierType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedClassifierTypeRule() ||
				   context == grammarAccess.getUnnamedPropertyTypeRule()) {
					sequence_UnnamedClassifierType(context, (ClassifierType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CLASSIFIER_VALUE:
				if(context == grammarAccess.getComponentClassifierTermRule() ||
				   context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyOwnerRule() ||
				   context == grammarAccess.getQCReferenceRule()) {
					sequence_QCReference(context, (ClassifierValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.COMPUTED_VALUE:
				if(context == grammarAccess.getComputedTermRule() ||
				   context == grammarAccess.getConstantPropertyExpressionRule() ||
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
			case Aadl2Package.ENUMERATION_LITERAL:
				if(context == grammarAccess.getEnumerationLiteralRule()) {
					sequence_EnumerationLiteral(context, (EnumerationLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.ENUMERATION_TYPE:
				if(context == grammarAccess.getEnumerationTypeRule() ||
				   context == grammarAccess.getPropertyTypeRule()) {
					sequence_EnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedEnumerationTypeRule() ||
				   context == grammarAccess.getUnnamedPropertyTypeRule()) {
					sequence_UnnamedEnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.INTEGER_LITERAL:
				if(context == grammarAccess.getIntegerLitRule() ||
				   context == grammarAccess.getNumberValueRule()) {
					sequence_IntegerLit(context, (IntegerLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getIntegerTermRule() ||
				   context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.LIST_TYPE:
				if(context == grammarAccess.getListTypeRule() ||
				   context == grammarAccess.getUnnamedPropertyTypeRule()) {
					sequence_ListType(context, (ListType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.LIST_VALUE:
				if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getListTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ListTerm(context, (ListValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.METACLASS_REFERENCE:
				if(context == grammarAccess.getAllReferenceRule()) {
					sequence_AllReference(context, (MetaclassReference) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyOwnerRule() ||
				   context == grammarAccess.getQMReferenceRule()) {
					sequence_QMReference(context, (MetaclassReference) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if(context == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getLiteralorReferenceTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NUMERIC_RANGE:
				if(context == grammarAccess.getIntegerRangeRule()) {
					sequence_IntegerRange(context, (NumericRange) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRealRangeRule()) {
					sequence_RealRange(context, (NumericRange) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				if(context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getSignedConstantRule()) {
					sequence_SignedConstant(context, (Operation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY:
				if(context == grammarAccess.getPropertyDefinitionRule()) {
					sequence_PropertyDefinition(context, (Property) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if(context == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getContainedPropertyAssociationRule() ||
				   context == grammarAccess.getPModelRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY_CONSTANT:
				if(context == grammarAccess.getPropertyConstantRule()) {
					sequence_PropertyConstant(context, (PropertyConstant) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY_SET:
				if(context == grammarAccess.getPropertySetRule()) {
					sequence_PropertySet(context, (PropertySet) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_TYPE:
				if(context == grammarAccess.getPropertyTypeRule() ||
				   context == grammarAccess.getRangeTypeRule()) {
					sequence_RangeType(context, (RangeType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedPropertyTypeRule() ||
				   context == grammarAccess.getUnnamedRangeTypeRule()) {
					sequence_UnnamedRangeType(context, (RangeType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getNumericRangeTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REAL_LITERAL:
				if(context == grammarAccess.getNumberValueRule() ||
				   context == grammarAccess.getRealLitRule()) {
					sequence_RealLit(context, (RealLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getRealTermRule()) {
					sequence_RealTerm(context, (RealLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RECORD_TYPE:
				if(context == grammarAccess.getPropertyTypeRule() ||
				   context == grammarAccess.getRecordTypeRule()) {
					sequence_RecordType(context, (RecordType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedPropertyTypeRule() ||
				   context == grammarAccess.getUnnamedRecordTypeRule()) {
					sequence_UnnamedRecordType(context, (RecordType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RECORD_VALUE:
				if(context == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyExpressionRule()) {
					sequence_PropertyExpression(context, (RecordValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_TYPE:
				if(context == grammarAccess.getPropertyTypeRule() ||
				   context == grammarAccess.getReferenceTypeRule()) {
					sequence_ReferenceType(context, (ReferenceType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedPropertyTypeRule() ||
				   context == grammarAccess.getUnnamedReferenceTypeRule()) {
					sequence_UnnamedReferenceType(context, (ReferenceType) semanticObject); 
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
				if(context == grammarAccess.getConstantPropertyExpressionRule() ||
				   context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getStringTermRule()) {
					sequence_StringTerm(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.UNIT_LITERAL:
				if(context == grammarAccess.getUnitLiteralConversionRule()) {
					sequence_UnitLiteralConversion(context, (UnitLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnitLiteralRule()) {
					sequence_UnitLiteral(context, (UnitLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.UNITS_TYPE:
				if(context == grammarAccess.getPropertyTypeRule() ||
				   context == grammarAccess.getUnitsTypeRule()) {
					sequence_UnitsType(context, (UnitsType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedPropertyTypeRule() ||
				   context == grammarAccess.getUnnamedUnitsTypeRule()) {
					sequence_UnnamedUnitsType(context, (UnitsType) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     metaclassName+='all'
	 */
	protected void sequence_AllReference(EObject context, MetaclassReference semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=INTVALUE upperBound=INTVALUE?)
	 */
	protected void sequence_ArrayRange(EObject context, ArrayRange semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=[Property|QPREF] ownedValue+=PropertyValue)
	 */
	protected void sequence_BasicPropertyAssociation(EObject context, PropertyAssociation semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value?='true'?)
	 */
	protected void sequence_BooleanLiteral(EObject context, BooleanLiteral semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_BooleanType(EObject context, AadlBoolean semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (classifierReference+=QMReference classifierReference+=QMReference*)?)
	 */
	protected void sequence_ClassifierType(EObject context, ClassifierType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     classifier=[ComponentClassifier|QCREF]
	 */
	protected void sequence_ComponentClassifierTerm(EObject context, ClassifierValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     function=ID
	 */
	protected void sequence_ComputedTerm(EObject context, ComputedValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     namedValue=[PropertyConstant|QPREF]
	 */
	protected void sequence_ConstantValue(EObject context, NamedValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         append?='+=>'? 
	 *         constant?='constant'? 
	 *         ownedValue+=OptionalModalPropertyValue 
	 *         ownedValue+=OptionalModalPropertyValue* 
	 *         (appliesTo+=ContainmentPath appliesTo+=ContainmentPath*)? 
	 *         inBinding+=[Classifier|QCREF]?
	 *     )
	 */
	protected void sequence_ContainedPropertyAssociation(EObject context, PropertyAssociation semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((namedElement=[NamedElement|ID] arrayRange+=ArrayRange?) | namedElement=[NamedElement|ANNEXREF])
	 */
	protected void sequence_ContainmentPathElement(EObject context, ContainmentPathElement semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (containmentPathElement+=ContainmentPathElement containmentPathElement+=ContainmentPathElement*)
	 */
	protected void sequence_ContainmentPath(EObject context, ContainedNamedElement semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_EnumerationLiteral(EObject context, EnumerationLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ownedLiteral+=EnumerationLiteral ownedLiteral+=EnumerationLiteral*)
	 */
	protected void sequence_EnumerationType(EObject context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=[BasicProperty|ID] ownedValue=PropertyExpression)
	 */
	protected void sequence_FieldPropertyAssociation(EObject context, BasicPropertyAssociation semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=SignedInt
	 */
	protected void sequence_IntegerLit(EObject context, IntegerLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (lowerBound=IntegerTerm | lowerBound=SignedConstant | lowerBound=ConstantValue) 
	 *         (upperBound=IntegerTerm | upperBound=SignedConstant | upperBound=ConstantValue)
	 *     )
	 */
	protected void sequence_IntegerRange(EObject context, NumericRange semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=SignedInt unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_IntegerTerm(EObject context, IntegerLiteral semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | unitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_IntegerType(EObject context, AadlInteger semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedListElement+=PropertyExpression ownedListElement+=PropertyExpression*)
	 */
	protected void sequence_ListTerm(EObject context, ListValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elementType=[PropertyType|QPREF] | ownedElementType=UnnamedPropertyType)
	 */
	protected void sequence_ListType(EObject context, ListType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     namedValue=[AbstractNamedValue|QPREF]
	 */
	protected void sequence_LiteralorReferenceTerm(EObject context, NamedValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedValue=PropertyExpression inMode+=[Mode|ID] inMode+=[Mode|ID]*)
	 */
	protected void sequence_ModalPropertyValue(EObject context, ModalPropertyValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (minimum=NumAlt maximum=NumAlt delta=NumAlt?)
	 */
	protected void sequence_NumericRangeTerm(EObject context, RangeValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedFieldValue+=FieldPropertyAssociation+
	 */
	protected void sequence_OldRecordTerm(EObject context, RecordValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedValue=PropertyExpression (inMode+=[Mode|ID] inMode+=[Mode|ID]*)?)
	 */
	protected void sequence_OptionalModalPropertyValue(EObject context, ModalPropertyValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         append?='+=>'? 
	 *         constant?='constant'? 
	 *         ownedValue+=OptionalModalPropertyValue 
	 *         ownedValue+=OptionalModalPropertyValue* 
	 *         inBinding+=[Classifier|QCREF]?
	 *     )
	 */
	protected void sequence_PropertyAssociation(EObject context, PropertyAssociation semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (propertyType=[PropertyType|QPREF] | ownedPropertyType=UnnamedPropertyType) constantValue=ConstantPropertyExpression)
	 */
	protected void sequence_PropertyConstant(EObject context, PropertyConstant semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         inherit?='inherit'? 
	 *         (propertyType=[PropertyType|QPREF] | ownedPropertyType=UnnamedPropertyType) 
	 *         defaultValue=PropertyExpression? 
	 *         ((appliesTo+=PropertyOwner appliesTo+=PropertyOwner*) | appliesTo+=AllReference)
	 *     )
	 */
	protected void sequence_PropertyDefinition(EObject context, Property semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedFieldValue+=FieldPropertyAssociation+ | ownedFieldValue+=FieldPropertyAssociation+)
	 */
	protected void sequence_PropertyExpression(EObject context, RecordValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (importedUnit+=[PropertySet|ID] importedUnit+=[PropertySet|ID]*)* 
	 *         (ownedPropertyType+=PropertyType | ownedProperty+=PropertyDefinition | ownedPropertyConstant+=PropertyConstant)*
	 *     )
	 */
	protected void sequence_PropertySet(EObject context, PropertySet semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedValue=PropertyExpression
	 */
	protected void sequence_PropertyValue(EObject context, ModalPropertyValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     classifier=[ComponentClassifier|FQCREF]
	 */
	protected void sequence_QCReference(EObject context, ClassifierValue semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annexName=ID? (metaclassName+=CoreKeyWord | metaclassName+=ID)+)
	 */
	protected void sequence_QMReference(EObject context, MetaclassReference semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (ownedNumberType=UnnamedIntegerType | ownedNumberType=UnnamedRealType | numberType=[NumberType|QPREF]))
	 */
	protected void sequence_RangeType(EObject context, RangeType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=SignedReal
	 */
	protected void sequence_RealLit(EObject context, RealLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (lowerBound=RealTerm | lowerBound=SignedConstant | lowerBound=ConstantValue) 
	 *         (upperBound=RealTerm | upperBound=SignedConstant | upperBound=ConstantValue)
	 *     )
	 */
	protected void sequence_RealRange(EObject context, NumericRange semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=SignedReal unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_RealTerm(EObject context, RealLiteral semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID range=RealRange? (ownedUnitsType=UnnamedUnitsType | unitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_RealType(EObject context, AadlReal semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (propertyType=[PropertyType|QPREF] | ownedPropertyType=UnnamedPropertyType))
	 */
	protected void sequence_RecordField(EObject context, BasicProperty semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedFieldValue+=FieldPropertyAssociation+
	 */
	protected void sequence_RecordTerm(EObject context, RecordValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ownedField+=RecordField+)
	 */
	protected void sequence_RecordType(EObject context, RecordType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (containmentPathElement+=ContainmentPathElement containmentPathElement+=ContainmentPathElement*)
	 */
	protected void sequence_ReferenceTerm(EObject context, ReferenceValue semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (namedElementReference+=QMReference namedElementReference+=QMReference*)?)
	 */
	protected void sequence_ReferenceType(EObject context, ReferenceType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=PlusMinus ownedPropertyExpression+=ConstantValue)
	 */
	protected void sequence_SignedConstant(EObject context, Operation semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=NoQuoteString
	 */
	protected void sequence_StringTerm(EObject context, StringLiteral semanticObject) {
		superSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_StringType(EObject context, AadlString semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID baseUnit=[UnitLiteral|ID] factor=NumberValue)
	 */
	protected void sequence_UnitLiteralConversion(EObject context, UnitLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_UnitLiteral(EObject context, UnitLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ownedLiteral+=UnitLiteral ownedLiteral+=UnitLiteralConversion*)
	 */
	protected void sequence_UnitsType(EObject context, UnitsType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((classifierReference+=QMReference classifierReference+=QMReference*)?)
	 */
	protected void sequence_UnnamedClassifierType(EObject context, ClassifierType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedLiteral+=EnumerationLiteral ownedLiteral+=EnumerationLiteral*)
	 */
	protected void sequence_UnnamedEnumerationType(EObject context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | unitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_UnnamedIntegerType(EObject context, AadlInteger semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AadlBoolean}
	 */
	protected void sequence_UnnamedPropertyType(EObject context, AadlBoolean semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AadlString}
	 */
	protected void sequence_UnnamedPropertyType(EObject context, AadlString semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedNumberType=UnnamedIntegerType | ownedNumberType=UnnamedRealType | numberType=[NumberType|QPREF])
	 */
	protected void sequence_UnnamedRangeType(EObject context, RangeType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (range=RealRange? (ownedUnitsType=UnnamedUnitsType | unitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_UnnamedRealType(EObject context, AadlReal semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedField+=RecordField+
	 */
	protected void sequence_UnnamedRecordType(EObject context, RecordType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((namedElementReference+=QMReference namedElementReference+=QMReference*)?)
	 */
	protected void sequence_UnnamedReferenceType(EObject context, ReferenceType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedLiteral+=UnitLiteral ownedLiteral+=UnitLiteralConversion*)
	 */
	protected void sequence_UnnamedUnitsType(EObject context, UnitsType semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
}
