/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.instance.textual.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
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
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.textual.services.InstanceGrammarAccess;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;

@SuppressWarnings("all")
public abstract class AbstractInstanceSemanticSequencer extends PropertiesSemanticSequencer {

	@Inject
	private InstanceGrammarAccess grammarAccess;
	
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
		else if (epackage == InstancePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case InstancePackage.COMPONENT_INSTANCE:
				sequence_ComponentInstance(context, (ComponentInstance) semanticObject); 
				return; 
			case InstancePackage.CONNECTION_INSTANCE:
				sequence_ConnectionInstance(context, (ConnectionInstance) semanticObject); 
				return; 
			case InstancePackage.CONNECTION_REFERENCE:
				sequence_ConnectionReference(context, (ConnectionReference) semanticObject); 
				return; 
			case InstancePackage.END_TO_END_FLOW_INSTANCE:
				sequence_EndToEndFlowInstance(context, (EndToEndFlowInstance) semanticObject); 
				return; 
			case InstancePackage.FEATURE_INSTANCE:
				sequence_FeatureInstance(context, (FeatureInstance) semanticObject); 
				return; 
			case InstancePackage.FLOW_SPECIFICATION_INSTANCE:
				sequence_FlowSpecificationInstance(context, (FlowSpecificationInstance) semanticObject); 
				return; 
			case InstancePackage.INSTANCE_REFERENCE_VALUE:
				sequence_InstanceReferenceValue(context, (InstanceReferenceValue) semanticObject); 
				return; 
			case InstancePackage.MODE_INSTANCE:
				sequence_ModeInstance(context, (ModeInstance) semanticObject); 
				return; 
			case InstancePackage.MODE_TRANSITION_INSTANCE:
				sequence_ModeTransitionInstance(context, (ModeTransitionInstance) semanticObject); 
				return; 
			case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE:
				sequence_PropertyAssociationInstance(context, (PropertyAssociationInstance) semanticObject); 
				return; 
			case InstancePackage.SYSTEM_INSTANCE:
				sequence_SystemInstance(context, (SystemInstance) semanticObject); 
				return; 
			case InstancePackage.SYSTEM_OPERATION_MODE:
				sequence_SystemOperationMode(context, (SystemOperationMode) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ComponentInstance returns ComponentInstance
	 *
	 * Constraint:
	 *     (
	 *         category=ComponentCategory 
	 *         classifier=[ComponentClassifier|ClassifierRef]? 
	 *         name=ID 
	 *         index+=Long* 
	 *         (inMode+=[ModeInstance|ID] inMode+=[ModeInstance|ID]*)? 
	 *         subcomponent=[Subcomponent|DeclarativeRef] 
	 *         (
	 *             featureInstance+=FeatureInstance | 
	 *             componentInstance+=ComponentInstance | 
	 *             connectionInstance+=ConnectionInstance | 
	 *             flowSpecification+=FlowSpecificationInstance | 
	 *             endToEndFlow+=EndToEndFlowInstance | 
	 *             modeInstance+=ModeInstance | 
	 *             modeTransitionInstance+=ModeTransitionInstance | 
	 *             ownedPropertyAssociation+=PropertyAssociationInstance
	 *         )*
	 *     )
	 */
	protected void sequence_ComponentInstance(ISerializationContext context, ComponentInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConnectionInstance returns ConnectionInstance
	 *
	 * Constraint:
	 *     (
	 *         complete?='complete'? 
	 *         kind=ConnectionKind 
	 *         name=STRING 
	 *         source=[ConnectionInstanceEnd|InstanceRef] 
	 *         bidirectional?='<->'? 
	 *         destination=[ConnectionInstanceEnd|InstanceRef] 
	 *         (inSystemOperationMode+=[SystemOperationMode|ID] inSystemOperationMode+=[SystemOperationMode|ID]*)? 
	 *         (inModeTransition+=[ModeTransitionInstance|TransitionRef] inModeTransition+=[ModeTransitionInstance|TransitionRef]*)? 
	 *         (connectionReference+=ConnectionReference | ownedPropertyAssociation+=PropertyAssociationInstance)+
	 *     )
	 */
	protected void sequence_ConnectionInstance(ISerializationContext context, ConnectionInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConnectionReference returns ConnectionReference
	 *
	 * Constraint:
	 *     (
	 *         source=[ConnectionInstanceEnd|InstanceRef] 
	 *         destination=[ConnectionInstanceEnd|InstanceRef] 
	 *         reverse?='reverse'? 
	 *         connection=[Connection|DeclarativeRef] 
	 *         context=[ComponentInstance|InstanceRef]
	 *     )
	 */
	protected void sequence_ConnectionReference(ISerializationContext context, ConnectionReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ContainmentPathElement returns ContainmentPathElement
	 *
	 * Constraint:
	 *     (namedElement=[NamedElement|DeclarativeRef] arrayRange+=ArrayRange? path=ContainmentPathElement?)
	 */
	protected void sequence_ContainmentPathElement(ISerializationContext context, ContainmentPathElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EndToEndFlowInstance returns EndToEndFlowInstance
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (flowElement+=[FlowElementInstance|InstanceRef] flowElement+=[FlowElementInstance|InstanceRef]*)? 
	 *         (inSystemOperationMode+=[SystemOperationMode|ID] inSystemOperationMode+=[SystemOperationMode|ID]*)? 
	 *         endToEndFlow=[EndToEndFlow|DeclarativeRef] 
	 *         ownedPropertyAssociation+=PropertyAssociationInstance?
	 *     )
	 */
	protected void sequence_EndToEndFlowInstance(ISerializationContext context, EndToEndFlowInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeatureInstance returns FeatureInstance
	 *
	 * Constraint:
	 *     (
	 *         direction=DirectionType 
	 *         category=FeatureCategory 
	 *         name=ID 
	 *         index=Long? 
	 *         feature=[Feature|DeclarativeRef] 
	 *         (featureInstance+=FeatureInstance | ownedPropertyAssociation+=PropertyAssociationInstance)*
	 *     )
	 */
	protected void sequence_FeatureInstance(ISerializationContext context, FeatureInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSpecificationInstance returns FlowSpecificationInstance
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         source=[FeatureInstance|InstanceRef]? 
	 *         destination=[FeatureInstance|InstanceRef]? 
	 *         (inMode+=[ModeInstance|ID] inMode+=[ModeInstance|ID]*)? 
	 *         (inModeTransition+=[ModeTransitionInstance|TransitionRef] inModeTransition+=[ModeTransitionInstance|TransitionRef]*)? 
	 *         flowSpecification=[FlowSpecification|DeclarativeRef] 
	 *         ownedPropertyAssociation+=PropertyAssociationInstance*
	 *     )
	 */
	protected void sequence_FlowSpecificationInstance(ISerializationContext context, FlowSpecificationInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyExpression returns InstanceReferenceValue
	 *     InstanceReferenceValue returns InstanceReferenceValue
	 *
	 * Constraint:
	 *     referencedInstanceObject=[InstanceObject|InstanceRef]
	 */
	protected void sequence_InstanceReferenceValue(ISerializationContext context, InstanceReferenceValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, InstancePackage.Literals.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InstancePackage.Literals.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectInstanceRefParserRuleCall_2_0_1(), semanticObject.eGet(InstancePackage.Literals.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ModeInstance returns ModeInstance
	 *
	 * Constraint:
	 *     (
	 *         initial?='initial'? 
	 *         derived?='derived'? 
	 *         name=ID 
	 *         (parent+=[ModeInstance|ID] | (parent+=[ModeInstance|ID] parent+=[ModeInstance|ID]+))? 
	 *         mode=[Mode|DeclarativeRef] 
	 *         ownedPropertyAssociation+=PropertyAssociationInstance?
	 *     )
	 */
	protected void sequence_ModeInstance(ISerializationContext context, ModeInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModeTransitionInstance returns ModeTransitionInstance
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         source=[ModeInstance|ID] 
	 *         (trigger+=[FeatureInstance|InstanceRef] trigger+=[FeatureInstance|InstanceRef]*)? 
	 *         destination=[ModeInstance|ID] 
	 *         modeTransition=[ModeTransition|DeclarativeRef] 
	 *         ownedPropertyAssociation+=PropertyAssociationInstance?
	 *     )
	 */
	protected void sequence_ModeTransitionInstance(ISerializationContext context, ModeTransitionInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *     PropertyAssociationInstance returns PropertyAssociationInstance
	 *
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         ownedValue+=OptionalModalPropertyValue 
	 *         ownedValue+=OptionalModalPropertyValue* 
	 *         propertyAssociation=[PropertyAssociation|PropertyAssociationRef]
	 *     )
	 */
	protected void sequence_PropertyAssociationInstance(ISerializationContext context, PropertyAssociationInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SystemInstance returns SystemInstance
	 *
	 * Constraint:
	 *     (
	 *         category=ComponentCategory 
	 *         name=ID 
	 *         componentImplementation=[ComponentImplementation|ImplRef] 
	 *         (
	 *             featureInstance+=FeatureInstance | 
	 *             componentInstance+=ComponentInstance | 
	 *             connectionInstance+=ConnectionInstance | 
	 *             flowSpecification+=FlowSpecificationInstance | 
	 *             endToEndFlow+=EndToEndFlowInstance | 
	 *             modeInstance+=ModeInstance | 
	 *             modeTransitionInstance+=ModeTransitionInstance | 
	 *             systemOperationMode+=SystemOperationMode | 
	 *             ownedPropertyAssociation+=PropertyAssociationInstance
	 *         )*
	 *     )
	 */
	protected void sequence_SystemInstance(ISerializationContext context, SystemInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SystemOperationMode returns SystemOperationMode
	 *
	 * Constraint:
	 *     (name=STRING (currentMode+=[ModeInstance|InstanceRef] currentMode+=[ModeInstance|InstanceRef]*)?)
	 */
	protected void sequence_SystemOperationMode(ISerializationContext context, SystemOperationMode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
