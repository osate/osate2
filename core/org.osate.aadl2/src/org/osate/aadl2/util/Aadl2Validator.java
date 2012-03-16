/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: Aadl2Validator.java,v 1.94 2011-04-11 13:35:56 lwrage Exp $
 */
package org.osate.aadl2.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.osate.aadl2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.Aadl2Package
 * @generated
 */
public class Aadl2Validator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Aadl2Validator INSTANCE = new Aadl2Validator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.osate.aadl2";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Not own self' of 'Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT__NOT_OWN_SELF = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has owner' of 'Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT__HAS_OWNER = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has no qualified name' of 'Named Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_ELEMENT__HAS_NO_QUALIFIED_NAME = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has qualified name' of 'Named Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_ELEMENT__HAS_QUALIFIED_NAME = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Members distinguishable' of 'Namespace'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMESPACE__MEMBERS_DISTINGUISHABLE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No cycles in generalization' of 'Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER__NO_CYCLES_IN_GENERALIZATION = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Specialize type' of 'Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER__SPECIALIZE_TYPE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Category Constraint' of 'Prototype'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOTYPE__CATEGORY_CONSTRAINT = 8;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 8;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2Validator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return Aadl2Package.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validateGen(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
		case Aadl2Package.ELEMENT:
			return validateElement((Element) value, diagnostics, context);
		case Aadl2Package.COMMENT:
			return validateComment((Comment) value, diagnostics, context);
		case Aadl2Package.TYPE:
			return validateType((Type) value, diagnostics, context);
		case Aadl2Package.NAMED_ELEMENT:
			return validateNamedElement((NamedElement) value, diagnostics, context);
		case Aadl2Package.PROPERTY_ASSOCIATION:
			return validatePropertyAssociation((PropertyAssociation) value, diagnostics, context);
		case Aadl2Package.PROPERTY:
			return validateProperty((Property) value, diagnostics, context);
		case Aadl2Package.BASIC_PROPERTY:
			return validateBasicProperty((BasicProperty) value, diagnostics, context);
		case Aadl2Package.TYPED_ELEMENT:
			return validateTypedElement((TypedElement) value, diagnostics, context);
		case Aadl2Package.PROPERTY_TYPE:
			return validatePropertyType((PropertyType) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_NAMED_VALUE:
			return validateAbstractNamedValue((AbstractNamedValue) value, diagnostics, context);
		case Aadl2Package.ARRAY_SIZE_PROPERTY:
			return validateArraySizeProperty((ArraySizeProperty) value, diagnostics, context);
		case Aadl2Package.PROPERTY_EXPRESSION:
			return validatePropertyExpression((PropertyExpression) value, diagnostics, context);
		case Aadl2Package.METACLASS_REFERENCE:
			return validateMetaclassReference((MetaclassReference) value, diagnostics, context);
		case Aadl2Package.PROPERTY_OWNER:
			return validatePropertyOwner((PropertyOwner) value, diagnostics, context);
		case Aadl2Package.CLASSIFIER:
			return validateClassifier((Classifier) value, diagnostics, context);
		case Aadl2Package.NAMESPACE:
			return validateNamespace((Namespace) value, diagnostics, context);
		case Aadl2Package.CLASSIFIER_FEATURE:
			return validateClassifierFeature((ClassifierFeature) value, diagnostics, context);
		case Aadl2Package.GENERALIZATION:
			return validateGeneralization((Generalization) value, diagnostics, context);
		case Aadl2Package.DIRECTED_RELATIONSHIP:
			return validateDirectedRelationship((DirectedRelationship) value, diagnostics, context);
		case Aadl2Package.RELATIONSHIP:
			return validateRelationship((Relationship) value, diagnostics, context);
		case Aadl2Package.ANNEX_SUBCLAUSE:
			return validateAnnexSubclause((AnnexSubclause) value, diagnostics, context);
		case Aadl2Package.MODAL_ELEMENT:
			return validateModalElement((ModalElement) value, diagnostics, context);
		case Aadl2Package.MODE:
			return validateMode((Mode) value, diagnostics, context);
		case Aadl2Package.MODE_FEATURE:
			return validateModeFeature((ModeFeature) value, diagnostics, context);
		case Aadl2Package.PROTOTYPE:
			return validatePrototype((Prototype) value, diagnostics, context);
		case Aadl2Package.STRUCTURAL_FEATURE:
			return validateStructuralFeature((StructuralFeature) value, diagnostics, context);
		case Aadl2Package.REFINABLE_ELEMENT:
			return validateRefinableElement((RefinableElement) value, diagnostics, context);
		case Aadl2Package.CALLED_SUBPROGRAM:
			return validateCalledSubprogram((CalledSubprogram) value, diagnostics, context);
		case Aadl2Package.PROTOTYPE_BINDING:
			return validatePrototypeBinding((PrototypeBinding) value, diagnostics, context);
		case Aadl2Package.CONTAINED_NAMED_ELEMENT:
			return validateContainedNamedElement((ContainedNamedElement) value, diagnostics, context);
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
			return validateContainmentPathElement((ContainmentPathElement) value, diagnostics, context);
		case Aadl2Package.ARRAY_RANGE:
			return validateArrayRange((ArrayRange) value, diagnostics, context);
		case Aadl2Package.MODAL_PROPERTY_VALUE:
			return validateModalPropertyValue((ModalPropertyValue) value, diagnostics, context);
		case Aadl2Package.BEHAVIORAL_FEATURE:
			return validateBehavioralFeature((BehavioralFeature) value, diagnostics, context);
		case Aadl2Package.ARRAY_DIMENSION:
			return validateArrayDimension((ArrayDimension) value, diagnostics, context);
		case Aadl2Package.ARRAY_SIZE:
			return validateArraySize((ArraySize) value, diagnostics, context);
		case Aadl2Package.ARRAYABLE_ELEMENT:
			return validateArrayableElement((ArrayableElement) value, diagnostics, context);
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE:
			return validateComponentImplementationReference((ComponentImplementationReference) value, diagnostics,
					context);
		case Aadl2Package.COMPONENT_IMPLEMENTATION:
			return validateComponentImplementation((ComponentImplementation) value, diagnostics, context);
		case Aadl2Package.COMPONENT_CLASSIFIER:
			return validateComponentClassifier((ComponentClassifier) value, diagnostics, context);
		case Aadl2Package.SUBCOMPONENT_TYPE:
			return validateSubcomponentType((SubcomponentType) value, diagnostics, context);
		case Aadl2Package.FEATURE_CLASSIFIER:
			return validateFeatureClassifier((FeatureClassifier) value, diagnostics, context);
		case Aadl2Package.MODE_TRANSITION:
			return validateModeTransition((ModeTransition) value, diagnostics, context);
		case Aadl2Package.MODE_TRANSITION_TRIGGER:
			return validateModeTransitionTrigger((ModeTransitionTrigger) value, diagnostics, context);
		case Aadl2Package.COMPONENT_TYPE:
			return validateComponentType((ComponentType) value, diagnostics, context);
		case Aadl2Package.FEATURE:
			return validateFeature((Feature) value, diagnostics, context);
		case Aadl2Package.FEATURE_CONNECTION_END:
			return validateFeatureConnectionEnd((FeatureConnectionEnd) value, diagnostics, context);
		case Aadl2Package.CONNECTION_END:
			return validateConnectionEnd((ConnectionEnd) value, diagnostics, context);
		case Aadl2Package.COMPONENT_PROTOTYPE:
			return validateComponentPrototype((ComponentPrototype) value, diagnostics, context);
		case Aadl2Package.FLOW_SPECIFICATION:
			return validateFlowSpecification((FlowSpecification) value, diagnostics, context);
		case Aadl2Package.FLOW:
			return validateFlow((Flow) value, diagnostics, context);
		case Aadl2Package.MODAL_PATH:
			return validateModalPath((ModalPath) value, diagnostics, context);
		case Aadl2Package.FLOW_ELEMENT:
			return validateFlowElement((FlowElement) value, diagnostics, context);
		case Aadl2Package.END_TO_END_FLOW_ELEMENT:
			return validateEndToEndFlowElement((EndToEndFlowElement) value, diagnostics, context);
		case Aadl2Package.FLOW_END:
			return validateFlowEnd((FlowEnd) value, diagnostics, context);
		case Aadl2Package.CONTEXT:
			return validateContext((Context) value, diagnostics, context);
		case Aadl2Package.TYPE_EXTENSION:
			return validateTypeExtension((TypeExtension) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP:
			return validateFeatureGroup((FeatureGroup) value, diagnostics, context);
		case Aadl2Package.CALL_CONTEXT:
			return validateCallContext((CallContext) value, diagnostics, context);
		case Aadl2Package.DIRECTED_FEATURE:
			return validateDirectedFeature((DirectedFeature) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_CONNECTION_END:
			return validateFeatureGroupConnectionEnd((FeatureGroupConnectionEnd) value, diagnostics, context);
		case Aadl2Package.FEATURE_TYPE:
			return validateFeatureType((FeatureType) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_TYPE:
			return validateFeatureGroupType((FeatureGroupType) value, diagnostics, context);
		case Aadl2Package.GROUP_EXTENSION:
			return validateGroupExtension((GroupExtension) value, diagnostics, context);
		case Aadl2Package.BUS_ACCESS:
			return validateBusAccess((BusAccess) value, diagnostics, context);
		case Aadl2Package.ACCESS:
			return validateAccess((Access) value, diagnostics, context);
		case Aadl2Package.ACCESS_CONNECTION_END:
			return validateAccessConnectionEnd((AccessConnectionEnd) value, diagnostics, context);
		case Aadl2Package.BUS_SUBCOMPONENT_TYPE:
			return validateBusSubcomponentType((BusSubcomponentType) value, diagnostics, context);
		case Aadl2Package.BUS:
			return validateBus((Bus) value, diagnostics, context);
		case Aadl2Package.DATA_ACCESS:
			return validateDataAccess((DataAccess) value, diagnostics, context);
		case Aadl2Package.PARAMETER_CONNECTION_END:
			return validateParameterConnectionEnd((ParameterConnectionEnd) value, diagnostics, context);
		case Aadl2Package.PORT_CONNECTION_END:
			return validatePortConnectionEnd((PortConnectionEnd) value, diagnostics, context);
		case Aadl2Package.DATA_SUBCOMPONENT_TYPE:
			return validateDataSubcomponentType((DataSubcomponentType) value, diagnostics, context);
		case Aadl2Package.DATA:
			return validateData((Data) value, diagnostics, context);
		case Aadl2Package.DATA_PORT:
			return validateDataPort((DataPort) value, diagnostics, context);
		case Aadl2Package.PORT:
			return validatePort((Port) value, diagnostics, context);
		case Aadl2Package.EVENT_DATA_PORT:
			return validateEventDataPort((EventDataPort) value, diagnostics, context);
		case Aadl2Package.EVENT_PORT:
			return validateEventPort((EventPort) value, diagnostics, context);
		case Aadl2Package.PARAMETER:
			return validateParameter((Parameter) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_ACCESS:
			return validateSubprogramAccess((SubprogramAccess) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT_TYPE:
			return validateSubprogramSubcomponentType((SubprogramSubcomponentType) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM:
			return validateSubprogram((Subprogram) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS:
			return validateSubprogramGroupAccess((SubprogramGroupAccess) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			return validateSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType) value, diagnostics,
					context);
		case Aadl2Package.SUBPROGRAM_GROUP:
			return validateSubprogramGroup((SubprogramGroup) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_FEATURE:
			return validateAbstractFeature((AbstractFeature) value, diagnostics, context);
		case Aadl2Package.FEATURE_PROTOTYPE:
			return validateFeaturePrototype((FeaturePrototype) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE:
			return validateFeatureGroupPrototype((FeatureGroupPrototype) value, diagnostics, context);
		case Aadl2Package.SUBCOMPONENT:
			return validateSubcomponent((Subcomponent) value, diagnostics, context);
		case Aadl2Package.MODE_BINDING:
			return validateModeBinding((ModeBinding) value, diagnostics, context);
		case Aadl2Package.FLOW_IMPLEMENTATION:
			return validateFlowImplementation((FlowImplementation) value, diagnostics, context);
		case Aadl2Package.FLOW_SEGMENT:
			return validateFlowSegment((FlowSegment) value, diagnostics, context);
		case Aadl2Package.CONNECTION:
			return validateConnection((Connection) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_CONNECTION_END:
			return validateAbstractConnectionEnd((AbstractConnectionEnd) value, diagnostics, context);
		case Aadl2Package.IMPLEMENTATION_EXTENSION:
			return validateImplementationExtension((ImplementationExtension) value, diagnostics, context);
		case Aadl2Package.REALIZATION:
			return validateRealization((Realization) value, diagnostics, context);
		case Aadl2Package.END_TO_END_FLOW:
			return validateEndToEndFlow((EndToEndFlow) value, diagnostics, context);
		case Aadl2Package.END_TO_END_FLOW_SEGMENT:
			return validateEndToEndFlowSegment((EndToEndFlowSegment) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_SUBCOMPONENT:
			return validateAbstractSubcomponent((AbstractSubcomponent) value, diagnostics, context);
		case Aadl2Package.ABSTRACT:
			return validateAbstract((Abstract) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_SUBCOMPONENT_TYPE:
			return validateAbstractSubcomponentType((AbstractSubcomponentType) value, diagnostics, context);
		case Aadl2Package.ACCESS_CONNECTION:
			return validateAccessConnection((AccessConnection) value, diagnostics, context);
		case Aadl2Package.PARAMETER_CONNECTION:
			return validateParameterConnection((ParameterConnection) value, diagnostics, context);
		case Aadl2Package.PORT_CONNECTION:
			return validatePortConnection((PortConnection) value, diagnostics, context);
		case Aadl2Package.FEATURE_CONNECTION:
			return validateFeatureConnection((FeatureConnection) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_CONNECTION:
			return validateFeatureGroupConnection((FeatureGroupConnection) value, diagnostics, context);
		case Aadl2Package.CONNECTED_ELEMENT:
			return validateConnectedElement((ConnectedElement) value, diagnostics, context);
		case Aadl2Package.ELEMENT_NAME:
			return validateElementName((ElementName) value, diagnostics, context);
		case Aadl2Package.ANNEX_LIBRARY:
			return validateAnnexLibrary((AnnexLibrary) value, diagnostics, context);
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY:
			return validateDefaultAnnexLibrary((DefaultAnnexLibrary) value, diagnostics, context);
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE:
			return validateDefaultAnnexSubclause((DefaultAnnexSubclause) value, diagnostics, context);
		case Aadl2Package.TRIGGER_PORT:
			return validateTriggerPort((TriggerPort) value, diagnostics, context);
		case Aadl2Package.PUBLIC_PACKAGE_SECTION:
			return validatePublicPackageSection((PublicPackageSection) value, diagnostics, context);
		case Aadl2Package.PACKAGE_SECTION:
			return validatePackageSection((PackageSection) value, diagnostics, context);
		case Aadl2Package.PACKAGE_RENAME:
			return validatePackageRename((PackageRename) value, diagnostics, context);
		case Aadl2Package.AADL_PACKAGE:
			return validateAadlPackage((AadlPackage) value, diagnostics, context);
		case Aadl2Package.MODEL_UNIT:
			return validateModelUnit((ModelUnit) value, diagnostics, context);
		case Aadl2Package.PRIVATE_PACKAGE_SECTION:
			return validatePrivatePackageSection((PrivatePackageSection) value, diagnostics, context);
		case Aadl2Package.COMPONENT_TYPE_RENAME:
			return validateComponentTypeRename((ComponentTypeRename) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME:
			return validateFeatureGroupTypeRename((FeatureGroupTypeRename) value, diagnostics, context);
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING:
			return validateComponentPrototypeBinding((ComponentPrototypeBinding) value, diagnostics, context);
		case Aadl2Package.COMPONENT_PROTOTYPE_ACTUAL:
			return validateComponentPrototypeActual((ComponentPrototypeActual) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_BINDING:
			return validateFeatureGroupPrototypeBinding((FeatureGroupPrototypeBinding) value, diagnostics, context);
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL:
			return validateFeatureGroupPrototypeActual((FeatureGroupPrototypeActual) value, diagnostics, context);
		case Aadl2Package.FEATURE_PROTOTYPE_ACTUAL:
			return validateFeaturePrototypeActual((FeaturePrototypeActual) value, diagnostics, context);
		case Aadl2Package.FEATURE_PROTOTYPE_BINDING:
			return validateFeaturePrototypeBinding((FeaturePrototypeBinding) value, diagnostics, context);
		case Aadl2Package.ACCESS_SPECIFICATION:
			return validateAccessSpecification((AccessSpecification) value, diagnostics, context);
		case Aadl2Package.PORT_SPECIFICATION:
			return validatePortSpecification((PortSpecification) value, diagnostics, context);
		case Aadl2Package.FEATURE_PROTOTYPE_REFERENCE:
			return validateFeaturePrototypeReference((FeaturePrototypeReference) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE:
			return validateSubprogramCallSequence((SubprogramCallSequence) value, diagnostics, context);
		case Aadl2Package.CALL_SPECIFICATION:
			return validateCallSpecification((CallSpecification) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_CALL:
			return validateProcessorCall((ProcessorCall) value, diagnostics, context);
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION:
			return validateBehavioredImplementation((BehavioredImplementation) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_CALL:
			return validateSubprogramCall((SubprogramCall) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_TYPE:
			return validateAbstractType((AbstractType) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_CLASSIFIER:
			return validateAbstractClassifier((AbstractClassifier) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT_TYPE:
			return validateVirtualProcessorSubcomponentType((VirtualProcessorSubcomponentType) value, diagnostics,
					context);
		case Aadl2Package.VIRTUAL_PROCESSOR:
			return validateVirtualProcessor((VirtualProcessor) value, diagnostics, context);
		case Aadl2Package.VITUAL_BUS_SUBCOMPONENT_TYPE:
			return validateVitualBusSubcomponentType((VitualBusSubcomponentType) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS:
			return validateVirtualBus((VirtualBus) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT_TYPE:
			return validateThreadGroupSubcomponentType((ThreadGroupSubcomponentType) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP:
			return validateThreadGroup((org.osate.aadl2.ThreadGroup) value, diagnostics, context);
		case Aadl2Package.THREAD_SUBCOMPONENT_TYPE:
			return validateThreadSubcomponentType((ThreadSubcomponentType) value, diagnostics, context);
		case Aadl2Package.THREAD:
			return validateThread((org.osate.aadl2.Thread) value, diagnostics, context);
		case Aadl2Package.SYSTEM_SUBCOMPONENT_TYPE:
			return validateSystemSubcomponentType((SystemSubcomponentType) value, diagnostics, context);
		case Aadl2Package.SYSTEM:
			return validateSystem((org.osate.aadl2.System) value, diagnostics, context);
		case Aadl2Package.PROCESS_SUBCOMPONENT_TYPE:
			return validateProcessSubcomponentType((ProcessSubcomponentType) value, diagnostics, context);
		case Aadl2Package.PROCESS:
			return validateProcess((org.osate.aadl2.Process) value, diagnostics, context);
		case Aadl2Package.MEMORY_SUBCOMPONENT_TYPE:
			return validateMemorySubcomponentType((MemorySubcomponentType) value, diagnostics, context);
		case Aadl2Package.MEMORY:
			return validateMemory((Memory) value, diagnostics, context);
		case Aadl2Package.DEVICE_SUBCOMPONENT_TYPE:
			return validateDeviceSubcomponentType((DeviceSubcomponentType) value, diagnostics, context);
		case Aadl2Package.DEVICE:
			return validateDevice((Device) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_SUBCOMPONENT_TYPE:
			return validateProcessorSubcomponentType((ProcessorSubcomponentType) value, diagnostics, context);
		case Aadl2Package.PROCESSOR:
			return validateProcessor((Processor) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION:
			return validateAbstractImplementation((AbstractImplementation) value, diagnostics, context);
		case Aadl2Package.BUS_SUBCOMPONENT:
			return validateBusSubcomponent((BusSubcomponent) value, diagnostics, context);
		case Aadl2Package.DATA_SUBCOMPONENT:
			return validateDataSubcomponent((DataSubcomponent) value, diagnostics, context);
		case Aadl2Package.DEVICE_SUBCOMPONENT:
			return validateDeviceSubcomponent((DeviceSubcomponent) value, diagnostics, context);
		case Aadl2Package.MEMORY_SUBCOMPONENT:
			return validateMemorySubcomponent((MemorySubcomponent) value, diagnostics, context);
		case Aadl2Package.PROCESS_SUBCOMPONENT:
			return validateProcessSubcomponent((ProcessSubcomponent) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_SUBCOMPONENT:
			return validateProcessorSubcomponent((ProcessorSubcomponent) value, diagnostics, context);
		case Aadl2Package.SYSTEM_SUBCOMPONENT:
			return validateSystemSubcomponent((SystemSubcomponent) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT:
			return validateSubprogramSubcomponent((SubprogramSubcomponent) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT:
			return validateSubprogramGroupSubcomponent((SubprogramGroupSubcomponent) value, diagnostics, context);
		case Aadl2Package.THREAD_SUBCOMPONENT:
			return validateThreadSubcomponent((ThreadSubcomponent) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT:
			return validateThreadGroupSubcomponent((ThreadGroupSubcomponent) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT:
			return validateVirtualBusSubcomponent((VirtualBusSubcomponent) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return validateVirtualProcessorSubcomponent((VirtualProcessorSubcomponent) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_PROTOTYPE:
			return validateAbstractPrototype((AbstractPrototype) value, diagnostics, context);
		case Aadl2Package.BUS_CLASSIFIER:
			return validateBusClassifier((BusClassifier) value, diagnostics, context);
		case Aadl2Package.BUS_TYPE:
			return validateBusType((BusType) value, diagnostics, context);
		case Aadl2Package.BUS_IMPLEMENTATION:
			return validateBusImplementation((BusImplementation) value, diagnostics, context);
		case Aadl2Package.BUS_PROTOTYPE:
			return validateBusPrototype((BusPrototype) value, diagnostics, context);
		case Aadl2Package.DATA_CLASSIFIER:
			return validateDataClassifier((DataClassifier) value, diagnostics, context);
		case Aadl2Package.DATA_TYPE:
			return validateDataType((DataType) value, diagnostics, context);
		case Aadl2Package.DATA_IMPLEMENTATION:
			return validateDataImplementation((DataImplementation) value, diagnostics, context);
		case Aadl2Package.DATA_PROTOTYPE:
			return validateDataPrototype((DataPrototype) value, diagnostics, context);
		case Aadl2Package.DEVICE_CLASSIFIER:
			return validateDeviceClassifier((DeviceClassifier) value, diagnostics, context);
		case Aadl2Package.DEVICE_TYPE:
			return validateDeviceType((DeviceType) value, diagnostics, context);
		case Aadl2Package.DEVICE_IMPLEMENTATION:
			return validateDeviceImplementation((DeviceImplementation) value, diagnostics, context);
		case Aadl2Package.DEVICE_PROTOTYPE:
			return validateDevicePrototype((DevicePrototype) value, diagnostics, context);
		case Aadl2Package.MEMORY_CLASSIFIER:
			return validateMemoryClassifier((MemoryClassifier) value, diagnostics, context);
		case Aadl2Package.MEMORY_TYPE:
			return validateMemoryType((MemoryType) value, diagnostics, context);
		case Aadl2Package.MEMORY_IMPLEMENTATION:
			return validateMemoryImplementation((MemoryImplementation) value, diagnostics, context);
		case Aadl2Package.MEMORY_PROTOTYPE:
			return validateMemoryPrototype((MemoryPrototype) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_CLASSIFIER:
			return validateSubprogramClassifier((SubprogramClassifier) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_TYPE:
			return validateSubprogramType((SubprogramType) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION:
			return validateSubprogramImplementation((SubprogramImplementation) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_PROTOTYPE:
			return validateSubprogramPrototype((SubprogramPrototype) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_CLASSIFIER:
			return validateSubprogramGroupClassifier((SubprogramGroupClassifier) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE:
			return validateSubprogramGroupType((SubprogramGroupType) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION:
			return validateSubprogramGroupImplementation((SubprogramGroupImplementation) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE:
			return validateSubprogramGroupPrototype((SubprogramGroupPrototype) value, diagnostics, context);
		case Aadl2Package.SYSTEM_CLASSIFIER:
			return validateSystemClassifier((SystemClassifier) value, diagnostics, context);
		case Aadl2Package.SYSTEM_TYPE:
			return validateSystemType((SystemType) value, diagnostics, context);
		case Aadl2Package.SYSTEM_IMPLEMENTATION:
			return validateSystemImplementation((SystemImplementation) value, diagnostics, context);
		case Aadl2Package.SYSTEM_PROTOTYPE:
			return validateSystemPrototype((SystemPrototype) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_CLASSIFIER:
			return validateProcessorClassifier((ProcessorClassifier) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_TYPE:
			return validateProcessorType((ProcessorType) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_IMPLEMENTATION:
			return validateProcessorImplementation((ProcessorImplementation) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_PROTOTYPE:
			return validateProcessorPrototype((ProcessorPrototype) value, diagnostics, context);
		case Aadl2Package.PROCESS_CLASSIFIER:
			return validateProcessClassifier((ProcessClassifier) value, diagnostics, context);
		case Aadl2Package.PROCESS_TYPE:
			return validateProcessType((ProcessType) value, diagnostics, context);
		case Aadl2Package.PROCESS_IMPLEMENTATION:
			return validateProcessImplementation((ProcessImplementation) value, diagnostics, context);
		case Aadl2Package.PROCESS_PROTOTYPE:
			return validateProcessPrototype((ProcessPrototype) value, diagnostics, context);
		case Aadl2Package.THREAD_CLASSIFIER:
			return validateThreadClassifier((ThreadClassifier) value, diagnostics, context);
		case Aadl2Package.THREAD_TYPE:
			return validateThreadType((ThreadType) value, diagnostics, context);
		case Aadl2Package.THREAD_IMPLEMENTATION:
			return validateThreadImplementation((ThreadImplementation) value, diagnostics, context);
		case Aadl2Package.THREAD_PROTOTYPE:
			return validateThreadPrototype((ThreadPrototype) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_CLASSIFIER:
			return validateThreadGroupClassifier((ThreadGroupClassifier) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_TYPE:
			return validateThreadGroupType((ThreadGroupType) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION:
			return validateThreadGroupImplementation((ThreadGroupImplementation) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_PROTOTYPE:
			return validateThreadGroupPrototype((ThreadGroupPrototype) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS_CLASSIFIER:
			return validateVirtualBusClassifier((VirtualBusClassifier) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS_TYPE:
			return validateVirtualBusType((VirtualBusType) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION:
			return validateVirtualBusImplementation((VirtualBusImplementation) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS_PROTOTYPE:
			return validateVirtualBusPrototype((VirtualBusPrototype) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_CLASSIFIER:
			return validateVirtualProcessorClassifier((VirtualProcessorClassifier) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE:
			return validateVirtualProcessorType((VirtualProcessorType) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION:
			return validateVirtualProcessorImplementation((VirtualProcessorImplementation) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE:
			return validateVirtualProcessorPrototype((VirtualProcessorPrototype) value, diagnostics, context);
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
			return validateBasicPropertyAssociation((BasicPropertyAssociation) value, diagnostics, context);
		case Aadl2Package.PROPERTY_CONSTANT:
			return validatePropertyConstant((PropertyConstant) value, diagnostics, context);
		case Aadl2Package.STRING_LITERAL:
			return validateStringLiteral((StringLiteral) value, diagnostics, context);
		case Aadl2Package.PROPERTY_VALUE:
			return validatePropertyValue((PropertyValue) value, diagnostics, context);
		case Aadl2Package.NUMBER_VALUE:
			return validateNumberValue((NumberValue) value, diagnostics, context);
		case Aadl2Package.UNIT_LITERAL:
			return validateUnitLiteral((UnitLiteral) value, diagnostics, context);
		case Aadl2Package.ENUMERATION_LITERAL:
			return validateEnumerationLiteral((EnumerationLiteral) value, diagnostics, context);
		case Aadl2Package.CLASSIFIER_VALUE:
			return validateClassifierValue((ClassifierValue) value, diagnostics, context);
		case Aadl2Package.REFERENCE_VALUE:
			return validateReferenceValue((ReferenceValue) value, diagnostics, context);
		case Aadl2Package.BOOLEAN_LITERAL:
			return validateBooleanLiteral((BooleanLiteral) value, diagnostics, context);
		case Aadl2Package.RANGE_VALUE:
			return validateRangeValue((RangeValue) value, diagnostics, context);
		case Aadl2Package.INTEGER_LITERAL:
			return validateIntegerLiteral((IntegerLiteral) value, diagnostics, context);
		case Aadl2Package.REAL_LITERAL:
			return validateRealLiteral((RealLiteral) value, diagnostics, context);
		case Aadl2Package.OPERATION:
			return validateOperation((Operation) value, diagnostics, context);
		case Aadl2Package.RECORD_VALUE:
			return validateRecordValue((RecordValue) value, diagnostics, context);
		case Aadl2Package.COMPUTED_VALUE:
			return validateComputedValue((ComputedValue) value, diagnostics, context);
		case Aadl2Package.LIST_VALUE:
			return validateListValue((ListValue) value, diagnostics, context);
		case Aadl2Package.NAMED_VALUE:
			return validateNamedValue((NamedValue) value, diagnostics, context);
		case Aadl2Package.PROPERTY_SET:
			return validatePropertySet((PropertySet) value, diagnostics, context);
		case Aadl2Package.GLOBAL_NAMESPACE:
			return validateGlobalNamespace((GlobalNamespace) value, diagnostics, context);
		case Aadl2Package.NON_LIST_TYPE:
			return validateNonListType((NonListType) value, diagnostics, context);
		case Aadl2Package.AADL_BOOLEAN:
			return validateAadlBoolean((AadlBoolean) value, diagnostics, context);
		case Aadl2Package.AADL_STRING:
			return validateAadlString((AadlString) value, diagnostics, context);
		case Aadl2Package.AADL_INTEGER:
			return validateAadlInteger((AadlInteger) value, diagnostics, context);
		case Aadl2Package.NUMBER_TYPE:
			return validateNumberType((NumberType) value, diagnostics, context);
		case Aadl2Package.UNITS_TYPE:
			return validateUnitsType((UnitsType) value, diagnostics, context);
		case Aadl2Package.ENUMERATION_TYPE:
			return validateEnumerationType((EnumerationType) value, diagnostics, context);
		case Aadl2Package.NUMERIC_RANGE:
			return validateNumericRange((NumericRange) value, diagnostics, context);
		case Aadl2Package.AADL_REAL:
			return validateAadlReal((AadlReal) value, diagnostics, context);
		case Aadl2Package.CLASSIFIER_TYPE:
			return validateClassifierType((ClassifierType) value, diagnostics, context);
		case Aadl2Package.RANGE_TYPE:
			return validateRangeType((RangeType) value, diagnostics, context);
		case Aadl2Package.RECORD_TYPE:
			return validateRecordType((RecordType) value, diagnostics, context);
		case Aadl2Package.RECORD_FIELD:
			return validateRecordField((RecordField) value, diagnostics, context);
		case Aadl2Package.REFERENCE_TYPE:
			return validateReferenceType((ReferenceType) value, diagnostics, context);
		case Aadl2Package.LIST_TYPE:
			return validateListType((ListType) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_PORT:
			return validateProcessorPort((ProcessorPort) value, diagnostics, context);
		case Aadl2Package.INTERNAL_EVENT:
			return validateInternalEvent((InternalEvent) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_SUBPROGRAM:
			return validateProcessorSubprogram((ProcessorSubprogram) value, diagnostics, context);
		case Aadl2Package.FLOW_KIND:
			return validateFlowKind((FlowKind) value, diagnostics, context);
		case Aadl2Package.DIRECTION_TYPE:
			return validateDirectionType((DirectionType) value, diagnostics, context);
		case Aadl2Package.ACCESS_TYPE:
			return validateAccessType((AccessType) value, diagnostics, context);
		case Aadl2Package.ACCESS_CATEGORY:
			return validateAccessCategory((AccessCategory) value, diagnostics, context);
		case Aadl2Package.PORT_CATEGORY:
			return validatePortCategory((PortCategory) value, diagnostics, context);
		case Aadl2Package.COMPONENT_CATEGORY:
			return validateComponentCategory((ComponentCategory) value, diagnostics, context);
		case Aadl2Package.CONNECTION_KIND:
			return validateConnectionKind((ConnectionKind) value, diagnostics, context);
		case Aadl2Package.ELEMENT_NAME_KIND:
			return validateElementNameKind((ElementNameKind) value, diagnostics, context);
		case Aadl2Package.OPERATION_KIND:
			return validateOperationKind((OperationKind) value, diagnostics, context);
		case Aadl2Package.STRING:
			return validateString((String) value, diagnostics, context);
		case Aadl2Package.BOOLEAN:
			return validateBoolean((Boolean) value, diagnostics, context);
		case Aadl2Package.INTEGER:
			return validateInteger((Long) value, diagnostics, context);
		case Aadl2Package.REAL:
			return validateReal((Double) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) element, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(element, diagnostics, context);
		return result;
	}

	/**
	 * Validates the not_own_self constraint of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement_not_own_self(Element element, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return element.not_own_self(diagnostics, context);
	}

	/**
	 * Validates the has_owner constraint of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement_has_owner(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return element.has_owner(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComment(Comment comment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) comment, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(comment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) namedElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(namedElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the has_no_qualified_name constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_has_no_qualified_name(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return namedElement.has_no_qualified_name(diagnostics, context);
	}

	/**
	 * Validates the has_qualified_name constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_has_qualified_name(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return namedElement.has_qualified_name(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(Namespace namespace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) namespace, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(namespace, diagnostics, context);
		return result;
	}

	/**
	 * Validates the members_distinguishable constraint of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace_members_distinguishable(Namespace namespace, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return namespace.members_distinguishable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssociation(PropertyAssociation propertyAssociation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertyAssociation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertyAssociation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicPropertyAssociation(BasicPropertyAssociation basicPropertyAssociation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) basicPropertyAssociation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) basicPropertyAssociation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(basicPropertyAssociation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) type, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(type, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) typedElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(typedElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierFeature(ClassifierFeature classifierFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) classifierFeature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(classifierFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(classifierFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinableElement(RefinableElement refinableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) refinableElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(refinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(refinableElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureClassifier(FeatureClassifier featureClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) featureClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioralFeature(BehavioralFeature behavioralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) behavioralFeature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(behavioralFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayDimension(ArrayDimension arrayDimension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) arrayDimension, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(arrayDimension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(arrayDimension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier(Classifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) classifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(classifier, diagnostics, context);
		return result;
	}

	/**
	 * Validates the no_cycles_in_generalization constraint of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier_no_cycles_in_generalization(Classifier classifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return classifier.no_cycles_in_generalization(diagnostics, context);
	}

	/**
	 * Validates the specialize_type constraint of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier_specialize_type(Classifier classifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return classifier.specialize_type(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralization(Generalization generalization, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) generalization, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(generalization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(generalization, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedRelationship(DirectedRelationship directedRelationship, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) directedRelationship, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(directedRelationship, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) relationship, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(relationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(relationship, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrototype(Prototype prototype, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) prototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(prototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(prototype, diagnostics, context);
		return result;
	}

	/**
	 * Validates the categoryConstraint constraint of '<em>Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrototype_categoryConstraint(Prototype prototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return prototype.categoryConstraint(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentClassifier(ComponentClassifier componentClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(componentClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(componentClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponentType(SubcomponentType subcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMode(Mode mode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) mode, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(mode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(mode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeFeature(ModeFeature modeFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modeFeature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(modeFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(modeFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeTransition(ModeTransition modeTransition, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modeTransition, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(modeTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(modeTransition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeTransitionTrigger(ModeTransitionTrigger modeTransitionTrigger,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modeTransitionTrigger, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modeTransitionTrigger, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modeTransitionTrigger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTriggerPort(TriggerPort triggerPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) triggerPort, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(triggerPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(triggerPort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
		if (!validate_NoCircularContainment((EObject) context, diagnostics, theContext))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(context, diagnostics, theContext);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) port, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(port, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedFeature(DirectedFeature directedFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) directedFeature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(directedFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(directedFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrototypeBinding(PrototypeBinding prototypeBinding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) prototypeBinding, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(prototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(prototypeBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayableElement(ArrayableElement arrayableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) arrayableElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(arrayableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(arrayableElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArraySize(ArraySize arraySize, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) arraySize, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(arraySize, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(arraySize, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexSubclause(AnnexSubclause annexSubclause, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) annexSubclause, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(annexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(annexSubclause, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeature(StructuralFeature structuralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) structuralFeature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(structuralFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalElement(ModalElement modalElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modalElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(modalElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(modalElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeBinding(ModeBinding modeBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modeBinding, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modeBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractSubcomponentType(AbstractSubcomponentType abstractSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentImplementationReference(
			ComponentImplementationReference componentImplementationReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentImplementationReference, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentImplementationReference, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentImplementationReference, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentImplementationReference,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentImplementationReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConnectionEnd(FeatureConnectionEnd featureConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureConnectionEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureConnectionEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponent(Subcomponent subcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExtension(TypeExtension typeExtension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) typeExtension, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(typeExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(typeExtension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentType(ComponentType componentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(componentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(componentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) feature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(feature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSpecification(FlowSpecification flowSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) flowSpecification, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(flowSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(flowSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) flow, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(flow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(flow, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowElement(EndToEndFlowElement endToEndFlowElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) endToEndFlowElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(endToEndFlowElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowEnd(FlowEnd flowEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) flowEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(flowEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(flowEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup(FeatureGroup featureGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroup, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupConnectionEnd(FeatureGroupConnectionEnd featureGroupConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupConnectionEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupConnectionEnd, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureGroupConnectionEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureType(FeatureType featureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) featureType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallContext(CallContext callContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) callContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionEnd(ConnectionEnd connectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) connectionEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(connectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(connectionEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupType(FeatureGroupType featureGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(featureGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(featureGroupType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupExtension(GroupExtension groupExtension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) groupExtension, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(groupExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(groupExtension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentImplementation(ComponentImplementation componentImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(componentImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(componentImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowImplementation(FlowImplementation flowImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) flowImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(flowImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(flowImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnection(Connection connection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) connection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(connection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(connection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractConnectionEnd(AbstractConnectionEnd abstractConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) abstractConnectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectedElement(ConnectedElement connectedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) connectedElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(connectedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(connectedElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowElement(FlowElement flowElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) flowElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(flowElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(flowElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealization(Realization realization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) realization, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(realization, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractSubcomponent(AbstractSubcomponent abstractSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementName(ElementName elementName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) elementName, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(elementName, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(elementName, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototype(ComponentPrototype componentPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(componentPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(componentPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototypeBinding(ComponentPrototypeBinding componentPrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentPrototypeBinding, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentPrototypeBinding, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentPrototypeBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototypeActual(ComponentPrototypeActual componentPrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentPrototypeActual, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentPrototypeActual, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentPrototypeActual, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototype(FeatureGroupPrototype featureGroupPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupPrototype, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(featureGroupPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding featureGroupPrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupPrototypeBinding, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupPrototypeBinding, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupPrototypeBinding, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupPrototypeBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototypeActual(FeatureGroupPrototypeActual featureGroupPrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupPrototypeActual, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupPrototypeActual, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupPrototypeActual, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototype(FeaturePrototype featurePrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featurePrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featurePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(featurePrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeBinding(FeaturePrototypeBinding featurePrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featurePrototypeBinding, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featurePrototypeBinding, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featurePrototypeBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeActual(FeaturePrototypeActual featurePrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featurePrototypeActual, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featurePrototypeActual, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featurePrototypeActual, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessSpecification(AccessSpecification accessSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) accessSpecification, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(accessSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(accessSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortSpecification(PortSpecification portSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) portSpecification, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(portSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(portSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeReference(FeaturePrototypeReference featurePrototypeReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featurePrototypeReference, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featurePrototypeReference, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featurePrototypeReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstract(Abstract abstract_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstract_, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstract_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstract_, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractClassifier(AbstractClassifier abstractClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(abstractClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlow(EndToEndFlow endToEndFlow, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) endToEndFlow, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(endToEndFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(endToEndFlow, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowSegment(EndToEndFlowSegment endToEndFlowSegment, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) endToEndFlowSegment, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(endToEndFlowSegment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConnection(FeatureConnection featureConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureConnection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureConnection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePublicPackageSection(PublicPackageSection publicPackageSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) publicPackageSection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(publicPackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(publicPackageSection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageSection(PackageSection packageSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) packageSection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(packageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(packageSection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageRename(PackageRename packageRename, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) packageRename, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(packageRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(packageRename, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlPackage(AadlPackage aadlPackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) aadlPackage, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(aadlPackage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(aadlPackage, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelUnit(ModelUnit modelUnit, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modelUnit, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(modelUnit, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(modelUnit, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrivatePackageSection(PrivatePackageSection privatePackageSection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) privatePackageSection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) privatePackageSection, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(privatePackageSection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(privatePackageSection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentTypeRename(ComponentTypeRename componentTypeRename, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) componentTypeRename, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(componentTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(componentTypeRename, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupTypeRename(FeatureGroupTypeRename featureGroupTypeRename,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupTypeRename, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupTypeRename, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureGroupTypeRename, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexLibrary(AnnexLibrary annexLibrary, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) annexLibrary, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(annexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(annexLibrary, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalNamespace(GlobalNamespace globalNamespace, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) globalNamespace, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(globalNamespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(globalNamespace, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonListType(NonListType nonListType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) nonListType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(nonListType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(nonListType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertySet(PropertySet propertySet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertySet, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(propertySet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(propertySet, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyType(PropertyType propertyType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertyType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(propertyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(propertyType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) property, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(property, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainedNamedElement(ContainedNamedElement containedNamedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) containedNamedElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) containedNamedElement, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(containedNamedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(containedNamedElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayRange(ArrayRange arrayRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) arrayRange, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(arrayRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(arrayRange, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalPropertyValue(ModalPropertyValue modalPropertyValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modalPropertyValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(modalPropertyValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentPathElement(ContainmentPathElement containmentPathElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) containmentPathElement, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) containmentPathElement, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(containmentPathElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(containmentPathElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyExpression(PropertyExpression propertyExpression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertyExpression, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertyExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertyExpression, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicProperty(BasicProperty basicProperty, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) basicProperty, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(basicProperty, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(basicProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyConstant(PropertyConstant propertyConstant, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertyConstant, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(propertyConstant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(propertyConstant, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultAnnexLibrary(DefaultAnnexLibrary defaultAnnexLibrary, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) defaultAnnexLibrary, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(defaultAnnexLibrary, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultAnnexSubclause(DefaultAnnexSubclause defaultAnnexSubclause,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) defaultAnnexSubclause, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) defaultAnnexSubclause, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(defaultAnnexSubclause, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractFeature(AbstractFeature abstractFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractFeature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalPath(ModalPath modalPath, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) modalPath, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(modalPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(modalPath, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSegment(FlowSegment flowSegment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) flowSegment, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(flowSegment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(flowSegment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessConnection(AccessConnection accessConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) accessConnection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(accessConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(accessConnection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterConnection(ParameterConnection parameterConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) parameterConnection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(parameterConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(parameterConnection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterConnectionEnd(ParameterConnectionEnd parameterConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) parameterConnectionEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) parameterConnectionEnd, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(parameterConnectionEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortConnection(PortConnection portConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) portConnection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(portConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(portConnection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortConnectionEnd(PortConnectionEnd portConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) portConnectionEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(portConnectionEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessConnectionEnd(AccessConnectionEnd accessConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) accessConnectionEnd, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(accessConnectionEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupConnection(FeatureGroupConnection featureGroupConnection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) featureGroupConnection, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) featureGroupConnection, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(featureGroupConnection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubprogram(ProcessorSubprogram processorSubprogram, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorSubprogram, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorSubprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorSubprogram, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataAccess(DataAccess dataAccess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataAccess, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataAccess, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataClassifier(DataClassifier dataClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(dataClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(dataClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSubcomponentType(DataSubcomponentType dataSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateData(Data data, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) data, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(data, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(data, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusAccess(BusAccess busAccess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busAccess, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busAccess, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccess(Access access, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) access, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(access, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(access, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusClassifier(BusClassifier busClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(busClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(busClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusSubcomponentType(BusSubcomponentType busSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBus(Bus bus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) bus, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(bus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(bus, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramAccess(SubprogramAccess subprogramAccess, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramAccess, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramAccess, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCalledSubprogram(CalledSubprogram calledSubprogram, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) calledSubprogram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramClassifier(SubprogramClassifier subprogramClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(subprogramClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramSubcomponentType(SubprogramSubcomponentType subprogramSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogram(Subprogram subprogram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogram, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogram, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogram, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataPort(DataPort dataPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataPort, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataPort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventPort(EventPort eventPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) eventPort, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(eventPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(eventPort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventDataPort(EventDataPort eventDataPort, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) eventDataPort, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(eventDataPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(eventDataPort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) parameter, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(parameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupAccess(SubprogramGroupAccess subprogramGroupAccess,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupAccess, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupAccess, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupAccess, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupClassifier(SubprogramGroupClassifier subprogramGroupClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupClassifier, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(subprogramGroupClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupSubcomponentType(
			SubprogramGroupSubcomponentType subprogramGroupSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupSubcomponentType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupSubcomponentType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroup(SubprogramGroup subprogramGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroup, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationExtension(ImplementationExtension implementationExtension,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) implementationExtension, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) implementationExtension, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(implementationExtension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(implementationExtension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) device, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(device, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceSubcomponentType(DeviceSubcomponentType deviceSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) deviceSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) deviceSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(deviceSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceClassifier(DeviceClassifier deviceClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) deviceClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(deviceClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceSubcomponent(DeviceSubcomponent deviceSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) deviceSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(deviceSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceType(DeviceType deviceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) deviceType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(deviceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(deviceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceImplementation(DeviceImplementation deviceImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) deviceImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(deviceImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevicePrototype(DevicePrototype devicePrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) devicePrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(devicePrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(devicePrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusSubcomponent(BusSubcomponent busSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractType(AbstractType abstractType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(abstractType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(abstractType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractImplementation(AbstractImplementation abstractImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(abstractImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioredImplementation(BehavioredImplementation behavioredImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) behavioredImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) behavioredImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(behavioredImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallSpecification(CallSpecification callSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) callSpecification, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(callSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(callSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSubcomponent(DataSubcomponent dataSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemorySubcomponent(MemorySubcomponent memorySubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memorySubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memorySubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemory(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memory, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memory, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memory, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemorySubcomponentType(MemorySubcomponentType memorySubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memorySubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memorySubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memorySubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryClassifier(MemoryClassifier memoryClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memoryClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(memoryClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessSubcomponent(ProcessSubcomponent processSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(org.osate.aadl2.Process process, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) process, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(process, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(process, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessSubcomponentType(ProcessSubcomponentType processSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessClassifier(ProcessClassifier processClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(processClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(processClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubcomponent(ProcessorSubcomponent processorSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorSubcomponent, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessor(Processor processor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processor, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubcomponentType(ProcessorSubcomponentType processorSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorClassifier(ProcessorClassifier processorClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(processorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(processorClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemSubcomponent(SystemSubcomponent systemSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) systemSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(systemSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(org.osate.aadl2.System system, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) system, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(system, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(system, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemSubcomponentType(SystemSubcomponentType systemSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) systemSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) systemSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(systemSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemClassifier(SystemClassifier systemClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) systemClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(systemClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(systemClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramSubcomponent(SubprogramSubcomponent subprogramSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramSubcomponent, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupSubcomponent(SubprogramGroupSubcomponent subprogramGroupSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupSubcomponent, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadSubcomponent(ThreadSubcomponent threadSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThread(org.osate.aadl2.Thread thread, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) thread, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(thread, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(thread, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadSubcomponentType(ThreadSubcomponentType threadSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadClassifier(ThreadClassifier threadClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(threadClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(threadClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupSubcomponent(ThreadGroupSubcomponent threadGroupSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroupSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroupSubcomponent, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroupSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroup(org.osate.aadl2.ThreadGroup threadGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroup, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupSubcomponentType(ThreadGroupSubcomponentType threadGroupSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroupSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroupSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroupSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupClassifier(ThreadGroupClassifier threadGroupClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroupClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroupClassifier, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(threadGroupClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusSubcomponent(VirtualBusSubcomponent virtualBusSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualBusSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualBusSubcomponent, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualBusSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBus(VirtualBus virtualBus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualBus, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualBus, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualBus, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVitualBusSubcomponentType(VitualBusSubcomponentType vitualBusSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) vitualBusSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) vitualBusSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(vitualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(vitualBusSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusClassifier(VirtualBusClassifier virtualBusClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualBusClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(virtualBusClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorSubcomponent(VirtualProcessorSubcomponent virtualProcessorSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessorSubcomponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessorSubcomponent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessorSubcomponent, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessorSubcomponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessor(VirtualProcessor virtualProcessor, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessor, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorSubcomponentType(
			VirtualProcessorSubcomponentType virtualProcessorSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessorSubcomponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessorSubcomponentType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessorSubcomponentType, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessorSubcomponentType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessorSubcomponentType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractPrototype(AbstractPrototype abstractPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) abstractPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(abstractPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(abstractPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorClassifier(VirtualProcessorClassifier virtualProcessorClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessorClassifier, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessorClassifier, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(virtualProcessorClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramCallSequence(SubprogramCallSequence subprogramCallSequence,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramCallSequence, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramCallSequence, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramCallSequence, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramCall(SubprogramCall subprogramCall, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramCall, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramCall, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorPort(ProcessorPort processorPort, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorPort, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorPort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorPort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalEvent(InternalEvent internalEvent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) internalEvent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(internalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(internalEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusType(BusType busType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(busType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(busType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusImplementation(BusImplementation busImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(busImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(busImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusPrototype(BusPrototype busPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) busPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(busPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(busPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(dataType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataImplementation(DataImplementation dataImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(dataImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(dataImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataPrototype(DataPrototype dataPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) dataPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(dataPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(dataPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryType(MemoryType memoryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memoryType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(memoryType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(memoryType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryImplementation(MemoryImplementation memoryImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memoryImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(memoryImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryPrototype(MemoryPrototype memoryPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) memoryPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(memoryPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(memoryPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemType(SystemType systemType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) systemType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(systemType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(systemType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemImplementation(SystemImplementation systemImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) systemImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(systemImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(systemImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemPrototype(SystemPrototype systemPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) systemPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(systemPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(systemPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadType(ThreadType threadType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(threadType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(threadType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadImplementation(ThreadImplementation threadImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(threadImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(threadImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadPrototype(ThreadPrototype threadPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(threadPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupType(ThreadGroupType threadGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroupType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(threadGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(threadGroupType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupImplementation(ThreadGroupImplementation threadGroupImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroupImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroupImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(threadGroupImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupPrototype(ThreadGroupPrototype threadGroupPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) threadGroupPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(threadGroupPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusType(VirtualBusType virtualBusType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualBusType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(virtualBusType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(virtualBusType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusImplementation(VirtualBusImplementation virtualBusImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualBusImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualBusImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(virtualBusImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusPrototype(VirtualBusPrototype virtualBusPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualBusPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(virtualBusPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorType(VirtualProcessorType virtualProcessorType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessorType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(virtualProcessorType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorImplementation(
			VirtualProcessorImplementation virtualProcessorImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessorImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessorImplementation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessorImplementation,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(virtualProcessorImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(virtualProcessorImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorPrototype(VirtualProcessorPrototype virtualProcessorPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) virtualProcessorPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) virtualProcessorPrototype, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(virtualProcessorPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupType(SubprogramGroupType subprogramGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(subprogramGroupType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupImplementation(SubprogramGroupImplementation subprogramGroupImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupImplementation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupImplementation,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(subprogramGroupImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(subprogramGroupImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupPrototype(SubprogramGroupPrototype subprogramGroupPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramGroupPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramGroupPrototype, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(subprogramGroupPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorType(ProcessorType processorType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(processorType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(processorType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorImplementation(ProcessorImplementation processorImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(processorImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(processorImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorPrototype(ProcessorPrototype processorPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(processorPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessType(ProcessType processType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(processType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(processType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessImplementation(ProcessImplementation processImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(processImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(processImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessPrototype(ProcessPrototype processPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(processPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramType(SubprogramType subprogramType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(subprogramType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(subprogramType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramImplementation(SubprogramImplementation subprogramImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramImplementation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramImplementation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_no_cycles_in_generalization(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_specialize_type(subprogramImplementation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramPrototype(SubprogramPrototype subprogramPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) subprogramPrototype, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePrototype_categoryConstraint(subprogramPrototype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorCall(ProcessorCall processorCall, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) processorCall, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(processorCall, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(processorCall, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractNamedValue(AbstractNamedValue abstractNamedValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) abstractNamedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArraySizeProperty(ArraySizeProperty arraySizeProperty, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) arraySizeProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyValue(PropertyValue propertyValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertyValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertyValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertyValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberType(NumberType numberType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) numberType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(numberType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(numberType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitsType(UnitsType unitsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) unitsType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(unitsType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(unitsType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlInteger(AadlInteger aadlInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) aadlInteger, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(aadlInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(aadlInteger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlReal(AadlReal aadlReal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) aadlReal, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(aadlReal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(aadlReal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlBoolean(AadlBoolean aadlBoolean, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) aadlBoolean, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(aadlBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(aadlBoolean, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlString(AadlString aadlString, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) aadlString, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(aadlString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(aadlString, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationType(EnumerationType enumerationType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) enumerationType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(enumerationType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(enumerationType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericRange(NumericRange numericRange, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) numericRange, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(numericRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(numericRange, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) enumerationLiteral, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(enumerationLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitLiteral(UnitLiteral unitLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) unitLiteral, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(unitLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(unitLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) stringLiteral, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(stringLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(stringLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberValue(NumberValue numberValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) numberValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(numberValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(numberValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierValue(ClassifierValue classifierValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) classifierValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(classifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(classifierValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceValue(ReferenceValue referenceValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) referenceValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(referenceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(referenceValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteral(BooleanLiteral booleanLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) booleanLiteral, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(booleanLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeValue(RangeValue rangeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) rangeValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(rangeValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(rangeValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteral(IntegerLiteral integerLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) integerLiteral, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(integerLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(integerLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteral(RealLiteral realLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) realLiteral, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(realLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(realLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) operation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(operation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordValue(RecordValue recordValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) recordValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(recordValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(recordValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputedValue(ComputedValue computedValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) computedValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(computedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(computedValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListValue(ListValue listValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) listValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(listValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(listValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedValue(NamedValue namedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) namedValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(namedValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(namedValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierType(ClassifierType classifierType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) classifierType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(classifierType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(classifierType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaclassReference(MetaclassReference metaclassReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) metaclassReference, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(metaclassReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(metaclassReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyOwner(PropertyOwner propertyOwner, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) propertyOwner, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(propertyOwner, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(propertyOwner, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceType(ReferenceType referenceType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) referenceType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(referenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(referenceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListType(ListType listType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) listType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(listType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(listType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeType(RangeType rangeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) rangeType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(rangeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(rangeType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordType(RecordType recordType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) recordType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(recordType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_members_distinguishable(recordType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordField(RecordField recordField, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) recordField, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_not_own_self(recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_has_owner(recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_no_qualified_name(recordField, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_has_qualified_name(recordField, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentCategory(ComponentCategory componentCategory, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowKind(FlowKind flowKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionKind(ConnectionKind connectionKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementNameKind(ElementNameKind elementNameKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessCategory(AccessCategory accessCategory, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessType(AccessType accessType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectionType(DirectionType directionType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortCategory(PortCategory portCategory, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationKind(OperationKind operationKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateString(String string, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoolean(boolean boolean_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger(long integer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReal(double real, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//	@Override
	//	public ResourceLocator getResourceLocator() {
	//		// TODO
	//		// Specialize this to return a resource locator for messages specific to this validator.
	//		// Ensure that you remove @generated or mark it @generated NOT
	//		return super.getResourceLocator();
	//	}
} //Aadl2Validator
