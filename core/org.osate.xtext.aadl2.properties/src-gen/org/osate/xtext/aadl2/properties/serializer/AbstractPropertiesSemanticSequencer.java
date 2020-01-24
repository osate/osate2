/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.properties.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
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

@SuppressWarnings("all")
public abstract class AbstractPropertiesSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PropertiesGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				sequence_ArrayRange(context, (ArrayRange) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.CLASSIFIER_VALUE:
				sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
				return; 
			case Aadl2Package.COMPUTED_VALUE:
				sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
				return; 
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
				return; 
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.LIST_VALUE:
				sequence_ListTerm(context, (ListValue) semanticObject); 
				return; 
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if (rule == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if (rule == grammarAccess.getConstantValueRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPModelRule()
						|| rule == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_RealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.RECORD_VALUE:
				if (rule == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ArrayRange returns ArrayRange
	 *
	 * Constraint:
	 *     (lowerBound=INTVALUE upperBound=INTVALUE?)
	 */
	protected void sequence_ArrayRange(ISerializationContext context, ArrayRange semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BasicPropertyAssociation returns PropertyAssociation
	 *
	 * Constraint:
	 *     (property=[Property|QPREF] ownedValue+=PropertyValue)
	 */
	protected void sequence_BasicPropertyAssociation(ISerializationContext context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns BooleanLiteral
	 *     BooleanLiteral returns BooleanLiteral
	 *
	 * Constraint:
	 *     value?='true'?
	 */
	protected void sequence_BooleanLiteral(ISerializationContext context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns ClassifierValue
	 *     ComponentClassifierTerm returns ClassifierValue
	 *
	 * Constraint:
	 *     classifier=[ComponentClassifier|QCREF]
	 */
	protected void sequence_ComponentClassifierTerm(ISerializationContext context, ClassifierValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getClassifierValue_Classifier()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getClassifierValue_Classifier()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierQCREFParserRuleCall_2_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getClassifierValue_Classifier(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns ComputedValue
	 *     ComputedTerm returns ComputedValue
	 *
	 * Constraint:
	 *     function=ID
	 */
	protected void sequence_ComputedTerm(ISerializationContext context, ComputedValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getComputedValue_Function()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getComputedValue_Function()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0(), semanticObject.getFunction());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConstantValue returns NamedValue
	 *     NumAlt returns NamedValue
	 *
	 * Constraint:
	 *     namedValue=[PropertyConstant|QPREF]
	 */
	protected void sequence_ConstantValue(ISerializationContext context, NamedValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedValue_NamedValue()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedValue_NamedValue()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantQPREFParserRuleCall_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getNamedValue_NamedValue(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PModel returns PropertyAssociation
	 *     ContainedPropertyAssociation returns PropertyAssociation
	 *
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
	protected void sequence_ContainedPropertyAssociation(ISerializationContext context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ContainmentPathElement returns ContainmentPathElement
	 *
	 * Constraint:
	 *     (namedElement=[NamedElement|ID] arrayRange+=ArrayRange* path=ContainmentPathElement?)
	 */
	protected void sequence_ContainmentPathElement(ISerializationContext context, ContainmentPathElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ContainmentPath returns ContainedNamedElement
	 *
	 * Constraint:
	 *     path=ContainmentPathElement
	 */
	protected void sequence_ContainmentPath(ISerializationContext context, ContainedNamedElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getContainedNamedElement_Path()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getContainedNamedElement_Path()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0(), semanticObject.getPath());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     FieldPropertyAssociation returns BasicPropertyAssociation
	 *
	 * Constraint:
	 *     (property=[BasicProperty|ID] ownedValue=PropertyExpression)
	 */
	protected void sequence_FieldPropertyAssociation(ISerializationContext context, BasicPropertyAssociation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property()));
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getBasicPropertyAssociation_OwnedValue()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getBasicPropertyAssociation_OwnedValue()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyIDTerminalRuleCall_0_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), false));
		feeder.accept(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0(), semanticObject.getOwnedValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns IntegerLiteral
	 *     IntegerTerm returns IntegerLiteral
	 *     NumAlt returns IntegerLiteral
	 *
	 * Constraint:
	 *     (value=SignedInt unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_IntegerTerm(ISerializationContext context, IntegerLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns ListValue
	 *     ListTerm returns ListValue
	 *
	 * Constraint:
	 *     (ownedListElement+=PropertyExpression ownedListElement+=PropertyExpression*)?
	 */
	protected void sequence_ListTerm(ISerializationContext context, ListValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns NamedValue
	 *     LiteralorReferenceTerm returns NamedValue
	 *
	 * Constraint:
	 *     namedValue=[AbstractNamedValue|QPREF]
	 */
	protected void sequence_LiteralorReferenceTerm(ISerializationContext context, NamedValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedValue_NamedValue()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedValue_NamedValue()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueQPREFParserRuleCall_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getNamedValue_NamedValue(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ModalPropertyValue returns ModalPropertyValue
	 *
	 * Constraint:
	 *     (ownedValue=PropertyExpression inMode+=[Mode|ID] inMode+=[Mode|ID]*)
	 */
	protected void sequence_ModalPropertyValue(ISerializationContext context, ModalPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns RangeValue
	 *     NumericRangeTerm returns RangeValue
	 *
	 * Constraint:
	 *     (minimum=NumAlt maximum=NumAlt delta=NumAlt?)
	 */
	protected void sequence_NumericRangeTerm(ISerializationContext context, RangeValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OldRecordTerm returns RecordValue
	 *
	 * Constraint:
	 *     ownedFieldValue+=FieldPropertyAssociation+
	 */
	protected void sequence_OldRecordTerm(ISerializationContext context, RecordValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OptionalModalPropertyValue returns ModalPropertyValue
	 *
	 * Constraint:
	 *     (ownedValue=PropertyExpression (inMode+=[Mode|ID] inMode+=[Mode|ID]*)?)
	 */
	protected void sequence_OptionalModalPropertyValue(ISerializationContext context, ModalPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyAssociation returns PropertyAssociation
	 *
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
	protected void sequence_PropertyAssociation(ISerializationContext context, PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyValue returns ModalPropertyValue
	 *
	 * Constraint:
	 *     ownedValue=PropertyExpression
	 */
	protected void sequence_PropertyValue(ISerializationContext context, ModalPropertyValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getModalPropertyValue_OwnedValue()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getModalPropertyValue_OwnedValue()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0(), semanticObject.getOwnedValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns RealLiteral
	 *     RealTerm returns RealLiteral
	 *     NumAlt returns RealLiteral
	 *
	 * Constraint:
	 *     (value=SignedReal unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_RealTerm(ISerializationContext context, RealLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns RecordValue
	 *     RecordTerm returns RecordValue
	 *
	 * Constraint:
	 *     ownedFieldValue+=FieldPropertyAssociation+
	 */
	protected void sequence_RecordTerm(ISerializationContext context, RecordValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns ReferenceValue
	 *     ReferenceTerm returns ReferenceValue
	 *
	 * Constraint:
	 *     path=ContainmentPathElement
	 */
	protected void sequence_ReferenceTerm(ISerializationContext context, ReferenceValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getContainedNamedElement_Path()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getContainedNamedElement_Path()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0(), semanticObject.getPath());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SignedConstant returns Operation
	 *     NumAlt returns Operation
	 *
	 * Constraint:
	 *     (op=PlusMinus ownedPropertyExpression+=ConstantValue)
	 */
	protected void sequence_SignedConstant(ISerializationContext context, Operation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns StringLiteral
	 *     StringTerm returns StringLiteral
	 *
	 * Constraint:
	 *     value=NoQuoteString
	 */
	protected void sequence_StringTerm(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getStringLiteral_Value()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getStringLiteral_Value()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
}
