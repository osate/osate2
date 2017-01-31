/*
<copyright>
Copyright  2016 by Carnegie Mellon University, all rights reserved.

Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
at http://www.eclipse.org/org/documents/epl-v10.html.

NO WARRANTY

ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.

Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
employees, and agents from all claims or demands made against them (and any related losses, expenses, or
attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
product liability, personal injury, death, damage to property, or violation of any laws or regulations.

Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
under the contract clause at 252.227.7013.
</copyright>
 */
package org.osate.aadl2.instance.textual.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
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
public class InstanceSemanticSequencer extends PropertiesSemanticSequencer {

	@Inject
	private InstanceGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Aadl2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
				else if(context == grammarAccess.getLiteralorReferenceTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
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
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_RealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.RECORD_VALUE:
				if(context == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getRecordTermRule()) {
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
		else if(semanticObject.eClass().getEPackage() == InstancePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         category=ComponentCategory 
	 *         name=ID 
	 *         index+=Long* 
	 *         (inMode+=[ModeInstance|ID] inMode+=[ModeInstance|ID]*)? 
	 *         classifier=[ComponentClassifier|ClassifierRef] 
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
	protected void sequence_ComponentInstance(EObject context, ComponentInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         complete?='complete'? 
	 *         kind=ConnectionKind 
	 *         name=STRING 
	 *         source=[ConnectionInstanceEnd|InstanceRef] 
	 *         bidirectional?='<->'? 
	 *         destination=[ConnectionInstanceEnd|InstanceRef] 
	 *         (inSystemOperationMode+=[SystemOperationMode|SomRef] inSystemOperationMode+=[SystemOperationMode|SomRef]*)? 
	 *         (inModeTransition+=[ModeTransitionInstance|TransitionRef] inModeTransition+=[ModeTransitionInstance|TransitionRef]*)? 
	 *         (connectionReference+=ConnectionReference | ownedPropertyAssociation+=PropertyAssociationInstance)+
	 *     )
	 */
	protected void sequence_ConnectionInstance(EObject context, ConnectionInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         source=[ConnectionInstanceEnd|InstanceRef] 
	 *         destination=[ConnectionInstanceEnd|InstanceRef] 
	 *         connection=[Connection|DeclarativeRef] 
	 *         context=[ComponentInstance|InstanceRef]
	 *     )
	 */
	protected void sequence_ConnectionReference(EObject context, ConnectionReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (namedElement=[NamedElement|DeclarativeRef] arrayRange+=ArrayRange? path=ContainmentPathElement?)
	 */
	protected void sequence_ContainmentPathElement(EObject context, ContainmentPathElement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (flowElement+=[FlowElementInstance|InstanceRef] flowElement+=[FlowElementInstance|InstanceRef]*)? 
	 *         (inSystemOperationMode+=[SystemOperationMode|SomRef] inSystemOperationMode+=[SystemOperationMode|SomRef]*)? 
	 *         endToEndFlow=[EndToEndFlow|DeclarativeRef] 
	 *         ownedPropertyAssociation+=PropertyAssociationInstance?
	 *     )
	 */
	protected void sequence_EndToEndFlowInstance(EObject context, EndToEndFlowInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_FeatureInstance(EObject context, FeatureInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_FlowSpecificationInstance(EObject context, FlowSpecificationInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referencedInstanceObject=[InstanceObject|InstanceRef]
	 */
	protected void sequence_InstanceReferenceValue(EObject context, InstanceReferenceValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_ModeInstance(EObject context, ModeInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ModeTransitionName 
	 *         source=[ModeInstance|ID] 
	 *         destination=[ModeInstance|ID] 
	 *         modeTransition=[ModeTransition|DeclarativeRef] 
	 *         ownedPropertyAssociation+=PropertyAssociationInstance?
	 *     )
	 */
	protected void sequence_ModeTransitionInstance(EObject context, ModeTransitionInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedValue=PropertyExpression (inMode+=[Mode|SomRef] inMode+=[Mode|SomRef]*)?)
	 */
	protected void sequence_OptionalModalPropertyValue(EObject context, ModalPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         ownedValue+=OptionalModalPropertyValue 
	 *         ownedValue+=OptionalModalPropertyValue* 
	 *         propertyAssociation=[PropertyAssociation|PropertyAssociationRef]
	 *     )
	 */
	protected void sequence_PropertyAssociationInstance(EObject context, PropertyAssociationInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_SystemInstance(EObject context, SystemInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=STRING (currentMode+=[ModeInstance|InstanceRef] currentMode+=[ModeInstance|InstanceRef]*)?)
	 */
	protected void sequence_SystemOperationMode(EObject context, SystemOperationMode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
