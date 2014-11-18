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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
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
		case Aadl2Package.CONTEXT:
			return validateContext((Context) value, diagnostics, context);
		case Aadl2Package.TRIGGER_PORT:
			return validateTriggerPort((TriggerPort) value, diagnostics, context);
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
		case Aadl2Package.FLOW_FEATURE:
			return validateFlowFeature((FlowFeature) value, diagnostics, context);
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
		case Aadl2Package.DATA_ACCESS:
			return validateDataAccess((DataAccess) value, diagnostics, context);
		case Aadl2Package.PARAMETER_CONNECTION_END:
			return validateParameterConnectionEnd((ParameterConnectionEnd) value, diagnostics, context);
		case Aadl2Package.PORT_CONNECTION_END:
			return validatePortConnectionEnd((PortConnectionEnd) value, diagnostics, context);
		case Aadl2Package.DATA_SUBCOMPONENT_TYPE:
			return validateDataSubcomponentType((DataSubcomponentType) value, diagnostics, context);
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
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS:
			return validateSubprogramGroupAccess((SubprogramGroupAccess) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			return validateSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType) value, diagnostics,
					context);
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
		case Aadl2Package.CONNECTED_ELEMENT:
			return validateConnectedElement((ConnectedElement) value, diagnostics, context);
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
		case Aadl2Package.PROCESSOR_FEATURE:
			return validateProcessorFeature((ProcessorFeature) value, diagnostics, context);
		case Aadl2Package.INTERNAL_FEATURE:
			return validateInternalFeature((InternalFeature) value, diagnostics, context);
		case Aadl2Package.EVENT_SOURCE:
			return validateEventSource((EventSource) value, diagnostics, context);
		case Aadl2Package.EVENT_DATA_SOURCE:
			return validateEventDataSource((EventDataSource) value, diagnostics, context);
		case Aadl2Package.DATA_CLASSIFIER:
			return validateDataClassifier((DataClassifier) value, diagnostics, context);
		case Aadl2Package.DATA:
			return validateData((Data) value, diagnostics, context);
		case Aadl2Package.PORT_PROXY:
			return validatePortProxy((PortProxy) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_PROXY:
			return validateSubprogramProxy((SubprogramProxy) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_CLASSIFIER:
			return validateSubprogramClassifier((SubprogramClassifier) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM:
			return validateSubprogram((Subprogram) value, diagnostics, context);
		case Aadl2Package.ANNEX_LIBRARY:
			return validateAnnexLibrary((AnnexLibrary) value, diagnostics, context);
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY:
			return validateDefaultAnnexLibrary((DefaultAnnexLibrary) value, diagnostics, context);
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE:
			return validateDefaultAnnexSubclause((DefaultAnnexSubclause) value, diagnostics, context);
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
		case Aadl2Package.SUBPROGRAM_CALL:
			return validateSubprogramCall((SubprogramCall) value, diagnostics, context);
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION:
			return validateBehavioredImplementation((BehavioredImplementation) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_TYPE:
			return validateAbstractType((AbstractType) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_CLASSIFIER:
			return validateAbstractClassifier((AbstractClassifier) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT_TYPE:
			return validateVirtualProcessorSubcomponentType((VirtualProcessorSubcomponentType) value, diagnostics,
					context);
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT_TYPE:
			return validateVirtualBusSubcomponentType((VirtualBusSubcomponentType) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT_TYPE:
			return validateThreadGroupSubcomponentType((ThreadGroupSubcomponentType) value, diagnostics, context);
		case Aadl2Package.THREAD_SUBCOMPONENT_TYPE:
			return validateThreadSubcomponentType((ThreadSubcomponentType) value, diagnostics, context);
		case Aadl2Package.SYSTEM_SUBCOMPONENT_TYPE:
			return validateSystemSubcomponentType((SystemSubcomponentType) value, diagnostics, context);
		case Aadl2Package.PROCESS_SUBCOMPONENT_TYPE:
			return validateProcessSubcomponentType((ProcessSubcomponentType) value, diagnostics, context);
		case Aadl2Package.MEMORY_SUBCOMPONENT_TYPE:
			return validateMemorySubcomponentType((MemorySubcomponentType) value, diagnostics, context);
		case Aadl2Package.DEVICE_SUBCOMPONENT_TYPE:
			return validateDeviceSubcomponentType((DeviceSubcomponentType) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_SUBCOMPONENT_TYPE:
			return validateProcessorSubcomponentType((ProcessorSubcomponentType) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION:
			return validateAbstractImplementation((AbstractImplementation) value, diagnostics, context);
		case Aadl2Package.BUS_SUBCOMPONENT:
			return validateBusSubcomponent((BusSubcomponent) value, diagnostics, context);
		case Aadl2Package.BUS:
			return validateBus((Bus) value, diagnostics, context);
		case Aadl2Package.DATA_SUBCOMPONENT:
			return validateDataSubcomponent((DataSubcomponent) value, diagnostics, context);
		case Aadl2Package.DEVICE_SUBCOMPONENT:
			return validateDeviceSubcomponent((DeviceSubcomponent) value, diagnostics, context);
		case Aadl2Package.DEVICE:
			return validateDevice((Device) value, diagnostics, context);
		case Aadl2Package.MEMORY_SUBCOMPONENT:
			return validateMemorySubcomponent((MemorySubcomponent) value, diagnostics, context);
		case Aadl2Package.MEMORY:
			return validateMemory((Memory) value, diagnostics, context);
		case Aadl2Package.PROCESS_SUBCOMPONENT:
			return validateProcessSubcomponent((ProcessSubcomponent) value, diagnostics, context);
		case Aadl2Package.PROCESS:
			return validateProcess((org.osate.aadl2.Process) value, diagnostics, context);
		case Aadl2Package.PROCESSOR_SUBCOMPONENT:
			return validateProcessorSubcomponent((ProcessorSubcomponent) value, diagnostics, context);
		case Aadl2Package.PROCESSOR:
			return validateProcessor((Processor) value, diagnostics, context);
		case Aadl2Package.SYSTEM_SUBCOMPONENT:
			return validateSystemSubcomponent((SystemSubcomponent) value, diagnostics, context);
		case Aadl2Package.SYSTEM:
			return validateSystem((org.osate.aadl2.System) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT:
			return validateSubprogramSubcomponent((SubprogramSubcomponent) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT:
			return validateSubprogramGroupSubcomponent((SubprogramGroupSubcomponent) value, diagnostics, context);
		case Aadl2Package.SUBPROGRAM_GROUP:
			return validateSubprogramGroup((SubprogramGroup) value, diagnostics, context);
		case Aadl2Package.THREAD_SUBCOMPONENT:
			return validateThreadSubcomponent((ThreadSubcomponent) value, diagnostics, context);
		case Aadl2Package.THREAD:
			return validateThread((org.osate.aadl2.Thread) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT:
			return validateThreadGroupSubcomponent((ThreadGroupSubcomponent) value, diagnostics, context);
		case Aadl2Package.THREAD_GROUP:
			return validateThreadGroup((org.osate.aadl2.ThreadGroup) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT:
			return validateVirtualBusSubcomponent((VirtualBusSubcomponent) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_BUS:
			return validateVirtualBus((VirtualBus) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return validateVirtualProcessorSubcomponent((VirtualProcessorSubcomponent) value, diagnostics, context);
		case Aadl2Package.VIRTUAL_PROCESSOR:
			return validateVirtualProcessor((VirtualProcessor) value, diagnostics, context);
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
		if (!validate_NoCircularContainment(element, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(element, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(element, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(element, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(comment, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(comment, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(comment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(comment, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(namedElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(namedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(namedElement, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(namespace, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(namespace, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(namespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(namespace, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(propertyAssociation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyAssociation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertyAssociation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicPropertyAssociation(BasicPropertyAssociation basicPropertyAssociation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(basicPropertyAssociation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(basicPropertyAssociation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(basicPropertyAssociation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(basicPropertyAssociation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(type, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(type, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(type, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(type, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typedElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(typedElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(typedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(typedElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierFeature(ClassifierFeature classifierFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifierFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(classifierFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(classifierFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(classifierFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinableElement(RefinableElement refinableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(refinableElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(refinableElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(refinableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(refinableElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureClassifier(FeatureClassifier featureClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioralFeature(BehavioralFeature behavioralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(behavioralFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(behavioralFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(behavioralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(behavioralFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayDimension(ArrayDimension arrayDimension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(arrayDimension, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(arrayDimension, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(arrayDimension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(arrayDimension, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier(Classifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(classifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(classifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(classifier, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(generalization, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(generalization, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(generalization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(generalization, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedRelationship(DirectedRelationship directedRelationship, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(directedRelationship, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(directedRelationship, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(directedRelationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(directedRelationship, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationship, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(relationship, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(relationship, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(relationship, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrototype(Prototype prototype, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(prototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(prototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(prototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(prototype, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(componentClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(componentClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(componentClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponentType(SubcomponentType subcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMode(Mode mode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mode, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(mode, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(mode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(mode, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeFeature(ModeFeature modeFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modeFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modeFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(modeFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(modeFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeTransition(ModeTransition modeTransition, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modeTransition, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modeTransition, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(modeTransition, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(modeTransition, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeTransitionTrigger(ModeTransitionTrigger modeTransitionTrigger,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modeTransitionTrigger, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modeTransitionTrigger, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modeTransitionTrigger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modeTransitionTrigger, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTriggerPort(TriggerPort triggerPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(triggerPort, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(triggerPort, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(triggerPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(triggerPort, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
		if (!validate_NoCircularContainment(context, diagnostics, theContext)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(context, diagnostics, theContext);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(context, diagnostics, theContext);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(context, diagnostics, theContext);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(port, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(port, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(port, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(port, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedFeature(DirectedFeature directedFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(directedFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(directedFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(directedFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(directedFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrototypeBinding(PrototypeBinding prototypeBinding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(prototypeBinding, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(prototypeBinding, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(prototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(prototypeBinding, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayableElement(ArrayableElement arrayableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(arrayableElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(arrayableElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(arrayableElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(arrayableElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArraySize(ArraySize arraySize, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(arraySize, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(arraySize, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(arraySize, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(arraySize, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexSubclause(AnnexSubclause annexSubclause, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(annexSubclause, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(annexSubclause, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(annexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(annexSubclause, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeature(StructuralFeature structuralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuralFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(structuralFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(structuralFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(structuralFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalElement(ModalElement modalElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modalElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modalElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(modalElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(modalElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeBinding(ModeBinding modeBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modeBinding, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modeBinding, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modeBinding, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractSubcomponentType(AbstractSubcomponentType abstractSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractSubcomponentType, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(componentImplementationReference, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentImplementationReference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentImplementationReference, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentImplementationReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentImplementationReference, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConnectionEnd(FeatureConnectionEnd featureConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureConnectionEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureConnectionEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureConnectionEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponent(Subcomponent subcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExtension(TypeExtension typeExtension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeExtension, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(typeExtension, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(typeExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(typeExtension, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentType(ComponentType componentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(componentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(componentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(feature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(feature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(feature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(feature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSpecification(FlowSpecification flowSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowSpecification, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowSpecification, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(flowSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(flowSpecification, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowFeature(FlowFeature flowFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(flowFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(flowFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flow, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flow, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(flow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(flow, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowElement(EndToEndFlowElement endToEndFlowElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(endToEndFlowElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(endToEndFlowElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(endToEndFlowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(endToEndFlowElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowEnd(FlowEnd flowEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flowEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flowEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup(FeatureGroup featureGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroup, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroup, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureGroup, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupConnectionEnd(FeatureGroupConnectionEnd featureGroupConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupConnectionEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupConnectionEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureGroupConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureGroupConnectionEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureType(FeatureType featureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallContext(CallContext callContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(callContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionEnd(ConnectionEnd connectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connectionEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(connectionEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(connectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(connectionEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupType(FeatureGroupType featureGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(featureGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(featureGroupType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupExtension(GroupExtension groupExtension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(groupExtension, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(groupExtension, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(groupExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(groupExtension, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentImplementation(ComponentImplementation componentImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(componentImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(componentImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowImplementation(FlowImplementation flowImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(flowImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(flowImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnection(Connection connection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(connection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(connection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(connection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectedElement(ConnectedElement connectedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connectedElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(connectedElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(connectedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(connectedElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowElement(FlowElement flowElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(flowElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(flowElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealization(Realization realization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(realization, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(realization, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(realization, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(realization, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractSubcomponent(AbstractSubcomponent abstractSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototype(ComponentPrototype componentPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(componentPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(componentPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototypeBinding(ComponentPrototypeBinding componentPrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentPrototypeBinding, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentPrototypeBinding, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototypeActual(ComponentPrototypeActual componentPrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentPrototypeActual, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentPrototypeActual, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentPrototypeActual, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototype(FeatureGroupPrototype featureGroupPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(featureGroupPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding featureGroupPrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupPrototypeBinding, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupPrototypeBinding, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupPrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupPrototypeBinding, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototypeActual(FeatureGroupPrototypeActual featureGroupPrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupPrototypeActual, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupPrototypeActual, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupPrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupPrototypeActual, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototype(FeaturePrototype featurePrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featurePrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featurePrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featurePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(featurePrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeBinding(FeaturePrototypeBinding featurePrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featurePrototypeBinding, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featurePrototypeBinding, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featurePrototypeBinding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featurePrototypeBinding, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeActual(FeaturePrototypeActual featurePrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featurePrototypeActual, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featurePrototypeActual, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featurePrototypeActual, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featurePrototypeActual, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessSpecification(AccessSpecification accessSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(accessSpecification, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(accessSpecification, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(accessSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(accessSpecification, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortSpecification(PortSpecification portSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(portSpecification, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(portSpecification, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(portSpecification, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(portSpecification, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeReference(FeaturePrototypeReference featurePrototypeReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featurePrototypeReference, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featurePrototypeReference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featurePrototypeReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featurePrototypeReference, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstract(Abstract abstract_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstract_, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstract_, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstract_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstract_, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractClassifier(AbstractClassifier abstractClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(abstractClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(abstractClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlow(EndToEndFlow endToEndFlow, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(endToEndFlow, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(endToEndFlow, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(endToEndFlow, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(endToEndFlow, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowSegment(EndToEndFlowSegment endToEndFlowSegment, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(endToEndFlowSegment, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(endToEndFlowSegment, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(endToEndFlowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(endToEndFlowSegment, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConnection(FeatureConnection featureConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureConnection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureConnection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureConnection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePublicPackageSection(PublicPackageSection publicPackageSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(publicPackageSection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(publicPackageSection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(publicPackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(publicPackageSection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageSection(PackageSection packageSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(packageSection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(packageSection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(packageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(packageSection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageRename(PackageRename packageRename, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(packageRename, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(packageRename, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(packageRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(packageRename, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlPackage(AadlPackage aadlPackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aadlPackage, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(aadlPackage, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(aadlPackage, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(aadlPackage, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelUnit(ModelUnit modelUnit, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelUnit, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modelUnit, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(modelUnit, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(modelUnit, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrivatePackageSection(PrivatePackageSection privatePackageSection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(privatePackageSection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(privatePackageSection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(privatePackageSection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(privatePackageSection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentTypeRename(ComponentTypeRename componentTypeRename, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentTypeRename, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentTypeRename, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(componentTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(componentTypeRename, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupTypeRename(FeatureGroupTypeRename featureGroupTypeRename,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupTypeRename, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupTypeRename, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureGroupTypeRename, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureGroupTypeRename, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexLibrary(AnnexLibrary annexLibrary, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(annexLibrary, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(annexLibrary, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(annexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(annexLibrary, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalNamespace(GlobalNamespace globalNamespace, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(globalNamespace, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(globalNamespace, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(globalNamespace, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(globalNamespace, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonListType(NonListType nonListType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nonListType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(nonListType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(nonListType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(nonListType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertySet(PropertySet propertySet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertySet, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertySet, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(propertySet, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(propertySet, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyType(PropertyType propertyType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(propertyType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(propertyType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(property, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(property, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(property, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(property, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainedNamedElement(ContainedNamedElement containedNamedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containedNamedElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(containedNamedElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(containedNamedElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(containedNamedElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayRange(ArrayRange arrayRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(arrayRange, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(arrayRange, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(arrayRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(arrayRange, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalPropertyValue(ModalPropertyValue modalPropertyValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modalPropertyValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modalPropertyValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(modalPropertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(modalPropertyValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentPathElement(ContainmentPathElement containmentPathElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containmentPathElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(containmentPathElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(containmentPathElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(containmentPathElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyExpression(PropertyExpression propertyExpression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyExpression, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyExpression, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertyExpression, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertyExpression, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicProperty(BasicProperty basicProperty, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(basicProperty, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(basicProperty, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(basicProperty, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(basicProperty, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyConstant(PropertyConstant propertyConstant, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyConstant, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyConstant, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(propertyConstant, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(propertyConstant, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultAnnexLibrary(DefaultAnnexLibrary defaultAnnexLibrary, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(defaultAnnexLibrary, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(defaultAnnexLibrary, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(defaultAnnexLibrary, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(defaultAnnexLibrary, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultAnnexSubclause(DefaultAnnexSubclause defaultAnnexSubclause,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(defaultAnnexSubclause, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(defaultAnnexSubclause, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(defaultAnnexSubclause, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(defaultAnnexSubclause, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractFeature(AbstractFeature abstractFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalPath(ModalPath modalPath, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modalPath, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modalPath, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(modalPath, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(modalPath, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSegment(FlowSegment flowSegment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowSegment, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowSegment, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(flowSegment, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(flowSegment, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessConnection(AccessConnection accessConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(accessConnection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(accessConnection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(accessConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(accessConnection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterConnection(ParameterConnection parameterConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameterConnection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(parameterConnection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(parameterConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(parameterConnection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterConnectionEnd(ParameterConnectionEnd parameterConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameterConnectionEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(parameterConnectionEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(parameterConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(parameterConnectionEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortConnection(PortConnection portConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(portConnection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(portConnection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(portConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(portConnection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortConnectionEnd(PortConnectionEnd portConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(portConnectionEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(portConnectionEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(portConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(portConnectionEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessConnectionEnd(AccessConnectionEnd accessConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(accessConnectionEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(accessConnectionEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(accessConnectionEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(accessConnectionEnd, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupConnection(FeatureGroupConnection featureGroupConnection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureGroupConnection, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureGroupConnection, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(featureGroupConnection, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(featureGroupConnection, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorFeature(ProcessorFeature processorFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalFeature(InternalFeature internalFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(internalFeature, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(internalFeature, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(internalFeature, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(internalFeature, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventSource(EventSource eventSource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventSource, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(eventSource, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(eventSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(eventSource, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventDataSource(EventDataSource eventDataSource, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventDataSource, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(eventDataSource, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(eventDataSource, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(eventDataSource, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortProxy(PortProxy portProxy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(portProxy, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(portProxy, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(portProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(portProxy, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramProxy(SubprogramProxy subprogramProxy, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramProxy, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramProxy, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramProxy, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramProxy, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataAccess(DataAccess dataAccess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataAccess, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataAccess, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataAccess, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataClassifier(DataClassifier dataClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(dataClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(dataClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSubcomponentType(DataSubcomponentType dataSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateData(Data data, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(data, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(data, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(data, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(data, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusAccess(BusAccess busAccess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busAccess, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busAccess, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busAccess, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccess(Access access, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(access, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(access, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(access, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(access, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusClassifier(BusClassifier busClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(busClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(busClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusSubcomponentType(BusSubcomponentType busSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBus(Bus bus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bus, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(bus, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(bus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(bus, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramAccess(SubprogramAccess subprogramAccess, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramAccess, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramAccess, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramAccess, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCalledSubprogram(CalledSubprogram calledSubprogram, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(calledSubprogram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramClassifier(SubprogramClassifier subprogramClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(subprogramClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(subprogramClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramSubcomponentType(SubprogramSubcomponentType subprogramSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogram(Subprogram subprogram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogram, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogram, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogram, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogram, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataPort(DataPort dataPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataPort, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataPort, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataPort, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventPort(EventPort eventPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventPort, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(eventPort, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(eventPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(eventPort, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventDataPort(EventDataPort eventDataPort, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventDataPort, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(eventDataPort, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(eventDataPort, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(eventDataPort, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(parameter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(parameter, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupAccess(SubprogramGroupAccess subprogramGroupAccess,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroupAccess, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupAccess, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupAccess, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupAccess, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupClassifier(SubprogramGroupClassifier subprogramGroupClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroupClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(subprogramGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(subprogramGroupClassifier, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(subprogramGroupSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupSubcomponentType, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroup(SubprogramGroup subprogramGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroup, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroup, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroup, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationExtension(ImplementationExtension implementationExtension,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(implementationExtension, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(implementationExtension, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(implementationExtension, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(implementationExtension, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(device, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(device, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(device, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(device, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceSubcomponentType(DeviceSubcomponentType deviceSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deviceSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(deviceSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(deviceSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(deviceSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceClassifier(DeviceClassifier deviceClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deviceClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(deviceClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(deviceClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(deviceClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceSubcomponent(DeviceSubcomponent deviceSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deviceSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(deviceSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(deviceSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(deviceSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceType(DeviceType deviceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deviceType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(deviceType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(deviceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(deviceType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceImplementation(DeviceImplementation deviceImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deviceImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(deviceImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(deviceImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(deviceImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevicePrototype(DevicePrototype devicePrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(devicePrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(devicePrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(devicePrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(devicePrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusSubcomponent(BusSubcomponent busSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractType(AbstractType abstractType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(abstractType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(abstractType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractImplementation(AbstractImplementation abstractImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(abstractImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(abstractImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioredImplementation(BehavioredImplementation behavioredImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(behavioredImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(behavioredImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(behavioredImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(behavioredImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSubcomponent(DataSubcomponent dataSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemorySubcomponent(MemorySubcomponent memorySubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memorySubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memorySubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memorySubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memorySubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemory(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memory, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memory, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memory, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memory, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemorySubcomponentType(MemorySubcomponentType memorySubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memorySubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memorySubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memorySubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memorySubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryClassifier(MemoryClassifier memoryClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memoryClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memoryClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(memoryClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(memoryClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessSubcomponent(ProcessSubcomponent processSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessSubcomponentType(ProcessSubcomponentType processSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(org.osate.aadl2.Process process, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(process, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(process, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(process, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(process, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessClassifier(ProcessClassifier processClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(processClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(processClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubcomponent(ProcessorSubcomponent processorSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessor(Processor processor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processor, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processor, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processor, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubcomponentType(ProcessorSubcomponentType processorSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorClassifier(ProcessorClassifier processorClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(processorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(processorClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemSubcomponent(SystemSubcomponent systemSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(systemSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(systemSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemSubcomponentType(SystemSubcomponentType systemSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(systemSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(systemSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(org.osate.aadl2.System system, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(system, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(system, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(system, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(system, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemClassifier(SystemClassifier systemClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(systemClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(systemClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramSubcomponent(SubprogramSubcomponent subprogramSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupSubcomponent(SubprogramGroupSubcomponent subprogramGroupSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroupSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadSubcomponent(ThreadSubcomponent threadSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadSubcomponentType(ThreadSubcomponentType threadSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThread(org.osate.aadl2.Thread thread, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(thread, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(thread, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(thread, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(thread, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadClassifier(ThreadClassifier threadClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(threadClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(threadClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupSubcomponent(ThreadGroupSubcomponent threadGroupSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroupSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroupSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroupSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroupSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupSubcomponentType(ThreadGroupSubcomponentType threadGroupSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroupSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroupSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroupSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroupSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroup(org.osate.aadl2.ThreadGroup threadGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroup, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroup, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroup, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupClassifier(ThreadGroupClassifier threadGroupClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroupClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroupClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(threadGroupClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(threadGroupClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusSubcomponent(VirtualBusSubcomponent virtualBusSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBusSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBusSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBusSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBusSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBus(VirtualBus virtualBus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBus, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBus, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBus, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBus, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusClassifier(VirtualBusClassifier virtualBusClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBusClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBusClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(virtualBusClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(virtualBusClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorSubcomponent(VirtualProcessorSubcomponent virtualProcessorSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualProcessorSubcomponent, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessorSubcomponent, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorSubcomponent, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessorSubcomponent, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessor(VirtualProcessor virtualProcessor, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualProcessor, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessor, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessor, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessor, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusSubcomponentType(VirtualBusSubcomponentType virtualBusSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBusSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBusSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBusSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBusSubcomponentType, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(virtualProcessorSubcomponentType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessorSubcomponentType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessorSubcomponentType, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorSubcomponentType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessorSubcomponentType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractPrototype(AbstractPrototype abstractPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(abstractPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(abstractPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(abstractPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorClassifier(VirtualProcessorClassifier virtualProcessorClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualProcessorClassifier, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessorClassifier, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(virtualProcessorClassifier, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(virtualProcessorClassifier, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramCallSequence(SubprogramCallSequence subprogramCallSequence,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramCallSequence, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramCallSequence, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramCallSequence, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramCallSequence, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramCall(SubprogramCall subprogramCall, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramCall, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramCall, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramCall, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramCall, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusType(BusType busType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(busType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(busType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusImplementation(BusImplementation busImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(busImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(busImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusPrototype(BusPrototype busPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(busPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(busPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(busPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(busPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(dataType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(dataType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataImplementation(DataImplementation dataImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(dataImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(dataImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataPrototype(DataPrototype dataPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(dataPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(dataPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(dataPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryType(MemoryType memoryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memoryType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memoryType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(memoryType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(memoryType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryImplementation(MemoryImplementation memoryImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memoryImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memoryImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(memoryImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(memoryImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryPrototype(MemoryPrototype memoryPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memoryPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(memoryPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(memoryPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(memoryPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemType(SystemType systemType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(systemType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(systemType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemImplementation(SystemImplementation systemImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(systemImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(systemImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemPrototype(SystemPrototype systemPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(systemPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(systemPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadType(ThreadType threadType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(threadType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(threadType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadImplementation(ThreadImplementation threadImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(threadImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(threadImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadPrototype(ThreadPrototype threadPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(threadPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupType(ThreadGroupType threadGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroupType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroupType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(threadGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(threadGroupType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupImplementation(ThreadGroupImplementation threadGroupImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroupImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroupImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(threadGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(threadGroupImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupPrototype(ThreadGroupPrototype threadGroupPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(threadGroupPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(threadGroupPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(threadGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(threadGroupPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusType(VirtualBusType virtualBusType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBusType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBusType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(virtualBusType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(virtualBusType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusImplementation(VirtualBusImplementation virtualBusImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBusImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBusImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(virtualBusImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(virtualBusImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusPrototype(VirtualBusPrototype virtualBusPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualBusPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualBusPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualBusPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(virtualBusPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorType(VirtualProcessorType virtualProcessorType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualProcessorType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessorType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(virtualProcessorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(virtualProcessorType, diagnostics, context);
		}
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
		if (!validate_NoCircularContainment(virtualProcessorImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessorImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(virtualProcessorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(virtualProcessorImplementation, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(virtualProcessorImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorPrototype(VirtualProcessorPrototype virtualProcessorPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualProcessorPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(virtualProcessorPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(virtualProcessorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(virtualProcessorPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupType(SubprogramGroupType subprogramGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroupType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(subprogramGroupType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(subprogramGroupType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupImplementation(SubprogramGroupImplementation subprogramGroupImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroupImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(subprogramGroupImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(subprogramGroupImplementation, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(subprogramGroupImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupPrototype(SubprogramGroupPrototype subprogramGroupPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramGroupPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramGroupPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramGroupPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(subprogramGroupPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorType(ProcessorType processorType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(processorType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(processorType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorImplementation(ProcessorImplementation processorImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(processorImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(processorImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorPrototype(ProcessorPrototype processorPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processorPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processorPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processorPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(processorPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessType(ProcessType processType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(processType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(processType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessImplementation(ProcessImplementation processImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(processImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(processImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessPrototype(ProcessPrototype processPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(processPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(processPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(processPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(processPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramType(SubprogramType subprogramType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(subprogramType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(subprogramType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramImplementation(SubprogramImplementation subprogramImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramImplementation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramImplementation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_no_cycles_in_generalization(subprogramImplementation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateClassifier_specialize_type(subprogramImplementation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramPrototype(SubprogramPrototype subprogramPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(subprogramPrototype, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(subprogramPrototype, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(subprogramPrototype, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePrototype_categoryConstraint(subprogramPrototype, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractNamedValue(AbstractNamedValue abstractNamedValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractNamedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArraySizeProperty(ArraySizeProperty arraySizeProperty, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arraySizeProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyValue(PropertyValue propertyValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertyValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertyValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberType(NumberType numberType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numberType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(numberType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(numberType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(numberType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitsType(UnitsType unitsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unitsType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(unitsType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(unitsType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(unitsType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlInteger(AadlInteger aadlInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aadlInteger, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(aadlInteger, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(aadlInteger, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(aadlInteger, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlReal(AadlReal aadlReal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aadlReal, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(aadlReal, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(aadlReal, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(aadlReal, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlBoolean(AadlBoolean aadlBoolean, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aadlBoolean, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(aadlBoolean, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(aadlBoolean, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(aadlBoolean, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlString(AadlString aadlString, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aadlString, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(aadlString, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(aadlString, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(aadlString, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationType(EnumerationType enumerationType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumerationType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(enumerationType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(enumerationType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(enumerationType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericRange(NumericRange numericRange, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numericRange, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(numericRange, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(numericRange, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(numericRange, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumerationLiteral, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(enumerationLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(enumerationLiteral, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitLiteral(UnitLiteral unitLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unitLiteral, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(unitLiteral, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(unitLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(unitLiteral, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stringLiteral, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(stringLiteral, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(stringLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(stringLiteral, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberValue(NumberValue numberValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numberValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(numberValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(numberValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(numberValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierValue(ClassifierValue classifierValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifierValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(classifierValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(classifierValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(classifierValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceValue(ReferenceValue referenceValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(referenceValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(referenceValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(referenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(referenceValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteral(BooleanLiteral booleanLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanLiteral, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(booleanLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(booleanLiteral, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeValue(RangeValue rangeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rangeValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(rangeValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(rangeValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(rangeValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteral(IntegerLiteral integerLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(integerLiteral, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(integerLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(integerLiteral, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteral(RealLiteral realLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(realLiteral, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(realLiteral, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(realLiteral, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(realLiteral, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(operation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(operation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(operation, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordValue(RecordValue recordValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(recordValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(recordValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(recordValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(recordValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputedValue(ComputedValue computedValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(computedValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(computedValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(computedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(computedValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListValue(ListValue listValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(listValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(listValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(listValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(listValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedValue(NamedValue namedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(namedValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(namedValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(namedValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierType(ClassifierType classifierType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifierType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(classifierType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(classifierType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(classifierType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaclassReference(MetaclassReference metaclassReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(metaclassReference, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(metaclassReference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(metaclassReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(metaclassReference, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyOwner(PropertyOwner propertyOwner, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyOwner, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyOwner, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(propertyOwner, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(propertyOwner, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceType(ReferenceType referenceType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(referenceType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(referenceType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(referenceType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(referenceType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListType(ListType listType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(listType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(listType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(listType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(listType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeType(RangeType rangeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rangeType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(rangeType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(rangeType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(rangeType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordType(RecordType recordType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(recordType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(recordType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(recordType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamespace_members_distinguishable(recordType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordField(RecordField recordField, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(recordField, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(recordField, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_not_own_self(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateElement_has_owner(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_no_qualified_name(recordField, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateNamedElement_has_qualified_name(recordField, diagnostics, context);
		}
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private String getRedefinitionDetail(EClass eClass, String featureName, String key) {
		List<EClass> eClasses = new ArrayList<EClass>();
		eClasses.add(eClass);
		eClasses.addAll(eClass.getEAllSuperTypes());
		String redefinitionDetail = null;
		for (Iterator<EClass> eClassesIterator = eClasses.iterator(); redefinitionDetail == null
				&& eClassesIterator.hasNext();) {
			EAnnotation eAnnotation = eClassesIterator.next().getEAnnotation("duplicates");
			if (eAnnotation != null) {
				EAnnotation nestedEAnnotation = eAnnotation.getEAnnotation(featureName);
				if (nestedEAnnotation != null) {
					redefinitionDetail = nestedEAnnotation.getDetails().get(key);
				}
			}
		}
		return redefinitionDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int getLowerBound(EObject eObject, EStructuralFeature eStructuralFeature) {
		try {
			return Integer
					.parseInt(getRedefinitionDetail(eObject.eClass(), eStructuralFeature.getName(), "lowerBound"));
		} catch (Exception e) {
			return eStructuralFeature.getLowerBound();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int getUpperBound(EObject eObject, EStructuralFeature eStructuralFeature) {
		try {
			return Integer
					.parseInt(getRedefinitionDetail(eObject.eClass(), eStructuralFeature.getName(), "upperBound"));
		} catch (Exception e) {
			return eStructuralFeature.getUpperBound();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean isEcoreString(String key) {
		return super.isEcoreString(key) || "_UI_FeatureHasTooFewValues_diagnostic".equals(key)
				|| "_UI_FeatureHasTooManyValues_diagnostic".equals(key)
				|| "_UI_RequiredFeatureMustBeSet_diagnostic".equals(key);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate_MultiplicityConforms(EObject eObject, EStructuralFeature eStructuralFeature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		if (eStructuralFeature.isMany()) {
			if (FeatureMapUtil.isFeatureMap(eStructuralFeature)
					&& ExtendedMetaData.INSTANCE.isDocumentRoot(eObject.eClass())) {
				result = super.validate_MultiplicityConforms(eObject, eStructuralFeature, diagnostics, context);
			} else {
				int lowerBound = getLowerBound(eObject, eStructuralFeature);
				if (lowerBound > 0) {
					int size = ((List<?>) eObject.eGet(eStructuralFeature)).size();
					if (size < lowerBound) {
						result = false;
						if (diagnostics != null) {
							diagnostics.add(createDiagnostic(
									Diagnostic.ERROR,
									EObjectValidator.DIAGNOSTIC_SOURCE,
									EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
									"_UI_FeatureHasTooFewValues_diagnostic",
									new Object[] { getFeatureLabel(eStructuralFeature, context),
											getObjectLabel(eObject, context), size, lowerBound }, new Object[] {
											eObject, eStructuralFeature }, context));
						}
					}
					int upperBound = getUpperBound(eObject, eStructuralFeature);
					if (upperBound > 0 && size > upperBound) {
						result = false;
						if (diagnostics != null) {
							diagnostics.add(createDiagnostic(
									Diagnostic.ERROR,
									EObjectValidator.DIAGNOSTIC_SOURCE,
									EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
									"_UI_FeatureHasTooManyValues_diagnostic",
									new Object[] { getFeatureLabel(eStructuralFeature, context),
											getObjectLabel(eObject, context), size, upperBound }, new Object[] {
											eObject, eStructuralFeature }, context));
						}
					}
				} else {
					int upperBound = getUpperBound(eObject, eStructuralFeature);
					if (upperBound > 0) {
						int size = ((List<?>) eObject.eGet(eStructuralFeature)).size();
						if (size > upperBound) {
							result = false;
							if (diagnostics != null) {
								diagnostics.add(createDiagnostic(
										Diagnostic.ERROR,
										EObjectValidator.DIAGNOSTIC_SOURCE,
										EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
										"_UI_FeatureHasTooManyValues_diagnostic",
										new Object[] { getFeatureLabel(eStructuralFeature, context),
												getObjectLabel(eObject, context), size, upperBound }, new Object[] {
												eObject, eStructuralFeature }, context));
							}
						}
					}
				}
			}
		} else if (getLowerBound(eObject, eStructuralFeature) >= 1) {
			if (eStructuralFeature.isUnsettable() ? !eObject.eIsSet(eStructuralFeature) : eObject.eGet(
					eStructuralFeature, false) == null) {
				result = false;
				if (diagnostics != null) {
					diagnostics.add(createDiagnostic(
							Diagnostic.ERROR,
							EObjectValidator.DIAGNOSTIC_SOURCE,
							EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
							"_UI_RequiredFeatureMustBeSet_diagnostic",
							new Object[] { getFeatureLabel(eStructuralFeature, context),
									getObjectLabel(eObject, context) }, new Object[] { eObject, eStructuralFeature },
							context));
				}
			}
		}
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	// @Override
	// public ResourceLocator getResourceLocator() {
	// // TODO
	// // Specialize this to return a resource locator for messages specific to
	// this validator.
	// // Ensure that you remove @generated or mark it @generated NOT
	// return super.getResourceLocator();
	// }
} // Aadl2Validator
