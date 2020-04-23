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
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

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
	protected EPackage getEPackage() {
		return Aadl2Package.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
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
		case Aadl2Package.ARRAY_SIZE_PROPERTY:
			return validateArraySizeProperty((ArraySizeProperty) value, diagnostics, context);
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
		case Aadl2Package.BUS_FEATURE_CLASSIFIER:
			return validateBusFeatureClassifier((BusFeatureClassifier) value, diagnostics, context);
		case Aadl2Package.DATA_ACCESS:
			return validateDataAccess((DataAccess) value, diagnostics, context);
		case Aadl2Package.PARAMETER_CONNECTION_END:
			return validateParameterConnectionEnd((ParameterConnectionEnd) value, diagnostics, context);
		case Aadl2Package.PORT_CONNECTION_END:
			return validatePortConnectionEnd((PortConnectionEnd) value, diagnostics, context);
		case Aadl2Package.DATA_SUBCOMPONENT_TYPE:
			return validateDataSubcomponentType((DataSubcomponentType) value, diagnostics, context);
		case Aadl2Package.ABSTRACT_FEATURE_CLASSIFIER:
			return validateAbstractFeatureClassifier((AbstractFeatureClassifier) value, diagnostics, context);
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
		case Aadl2Package.BUS_SUBCOMPONENT_TYPE:
			return validateBusSubcomponentType((BusSubcomponentType) value, diagnostics, context);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(element, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComment(Comment comment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(comment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(type, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssociation(PropertyAssociation propertyAssociation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyAssociation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(property, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicProperty(BasicProperty basicProperty, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(basicProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyType(PropertyType propertyType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyType, diagnostics, context);
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
	public boolean validatePropertyExpression(PropertyExpression propertyExpression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaclassReference(MetaclassReference metaclassReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metaclassReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyOwner(PropertyOwner propertyOwner, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyOwner, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier(Classifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(Namespace namespace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namespace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierFeature(ClassifierFeature classifierFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralization(Generalization generalization, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(generalization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedRelationship(DirectedRelationship directedRelationship, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(directedRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexSubclause(AnnexSubclause annexSubclause, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(annexSubclause, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalElement(ModalElement modalElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modalElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMode(Mode mode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeFeature(ModeFeature modeFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modeFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrototype(Prototype prototype, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(prototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeature(StructuralFeature structuralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structuralFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinableElement(RefinableElement refinableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(refinableElement, diagnostics, context);
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
	public boolean validatePrototypeBinding(PrototypeBinding prototypeBinding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(prototypeBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainedNamedElement(ContainedNamedElement containedNamedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containedNamedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentPathElement(ContainmentPathElement containmentPathElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containmentPathElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayRange(ArrayRange arrayRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arrayRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalPropertyValue(ModalPropertyValue modalPropertyValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modalPropertyValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioralFeature(BehavioralFeature behavioralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(behavioralFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayDimension(ArrayDimension arrayDimension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arrayDimension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArraySize(ArraySize arraySize, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arraySize, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayableElement(ArrayableElement arrayableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arrayableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentImplementationReference(
			ComponentImplementationReference componentImplementationReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentImplementationReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentImplementation(ComponentImplementation componentImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentClassifier(ComponentClassifier componentClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponentType(SubcomponentType subcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subcomponentType, diagnostics, context);
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
	public boolean validateModeTransition(ModeTransition modeTransition, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modeTransition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeTransitionTrigger(ModeTransitionTrigger modeTransitionTrigger,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modeTransitionTrigger, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
		return validate_EveryDefaultConstraint(context, diagnostics, theContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTriggerPort(TriggerPort triggerPort, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(triggerPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentType(ComponentType componentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(feature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConnectionEnd(FeatureConnectionEnd featureConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureConnectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionEnd(ConnectionEnd connectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototype(ComponentPrototype componentPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSpecification(FlowSpecification flowSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flowSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowFeature(FlowFeature flowFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flowFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flow, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModalPath(ModalPath modalPath, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modalPath, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowElement(FlowElement flowElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flowElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowElement(EndToEndFlowElement endToEndFlowElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(endToEndFlowElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowEnd(FlowEnd flowEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flowEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExtension(TypeExtension typeExtension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeExtension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroup(FeatureGroup featureGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallContext(CallContext callContext, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(callContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedFeature(DirectedFeature directedFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(directedFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupConnectionEnd(FeatureGroupConnectionEnd featureGroupConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupConnectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureType(FeatureType featureType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupType(FeatureGroupType featureGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupExtension(GroupExtension groupExtension, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(groupExtension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusAccess(BusAccess busAccess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busAccess, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccess(Access access, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(access, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessConnectionEnd(AccessConnectionEnd accessConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(accessConnectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusFeatureClassifier(BusFeatureClassifier busFeatureClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busFeatureClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusSubcomponentType(BusSubcomponentType busSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataAccess(DataAccess dataAccess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataAccess, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterConnectionEnd(ParameterConnectionEnd parameterConnectionEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterConnectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortConnectionEnd(PortConnectionEnd portConnectionEnd, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(portConnectionEnd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSubcomponentType(DataSubcomponentType dataSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractFeatureClassifier(AbstractFeatureClassifier abstractFeatureClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractFeatureClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataPort(DataPort dataPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(port, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventDataPort(EventDataPort eventDataPort, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventDataPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventPort(EventPort eventPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramAccess(SubprogramAccess subprogramAccess, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramAccess, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramSubcomponentType(SubprogramSubcomponentType subprogramSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupAccess(SubprogramGroupAccess subprogramGroupAccess,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupAccess, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupSubcomponentType(
			SubprogramGroupSubcomponentType subprogramGroupSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractFeature(AbstractFeature abstractFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototype(FeaturePrototype featurePrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featurePrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototype(FeatureGroupPrototype featureGroupPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponent(Subcomponent subcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeBinding(ModeBinding modeBinding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modeBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowImplementation(FlowImplementation flowImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flowImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSegment(FlowSegment flowSegment, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flowSegment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnection(Connection connection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectedElement(ConnectedElement connectedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connectedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationExtension(ImplementationExtension implementationExtension,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(implementationExtension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealization(Realization realization, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(realization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlow(EndToEndFlow endToEndFlow, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(endToEndFlow, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowSegment(EndToEndFlowSegment endToEndFlowSegment, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(endToEndFlowSegment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractSubcomponent(AbstractSubcomponent abstractSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstract(Abstract abstract_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstract_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractSubcomponentType(AbstractSubcomponentType abstractSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessConnection(AccessConnection accessConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(accessConnection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterConnection(ParameterConnection parameterConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterConnection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortConnection(PortConnection portConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(portConnection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConnection(FeatureConnection featureConnection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureConnection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupConnection(FeatureGroupConnection featureGroupConnection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupConnection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorFeature(ProcessorFeature processorFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalFeature(InternalFeature internalFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(internalFeature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventSource(EventSource eventSource, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventSource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventDataSource(EventDataSource eventDataSource, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventDataSource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataClassifier(DataClassifier dataClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateData(Data data, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(data, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortProxy(PortProxy portProxy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(portProxy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramProxy(SubprogramProxy subprogramProxy, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramProxy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramClassifier(SubprogramClassifier subprogramClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogram(Subprogram subprogram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexLibrary(AnnexLibrary annexLibrary, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(annexLibrary, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultAnnexLibrary(DefaultAnnexLibrary defaultAnnexLibrary, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(defaultAnnexLibrary, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultAnnexSubclause(DefaultAnnexSubclause defaultAnnexSubclause,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(defaultAnnexSubclause, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePublicPackageSection(PublicPackageSection publicPackageSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(publicPackageSection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageSection(PackageSection packageSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packageSection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageRename(PackageRename packageRename, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packageRename, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlPackage(AadlPackage aadlPackage, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aadlPackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelUnit(ModelUnit modelUnit, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrivatePackageSection(PrivatePackageSection privatePackageSection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(privatePackageSection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentTypeRename(ComponentTypeRename componentTypeRename, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentTypeRename, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupTypeRename(FeatureGroupTypeRename featureGroupTypeRename,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupTypeRename, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototypeBinding(ComponentPrototypeBinding componentPrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentPrototypeBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPrototypeActual(ComponentPrototypeActual componentPrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentPrototypeActual, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding featureGroupPrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupPrototypeBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupPrototypeActual(FeatureGroupPrototypeActual featureGroupPrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupPrototypeActual, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeActual(FeaturePrototypeActual featurePrototypeActual,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featurePrototypeActual, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeBinding(FeaturePrototypeBinding featurePrototypeBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featurePrototypeBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessSpecification(AccessSpecification accessSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(accessSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortSpecification(PortSpecification portSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(portSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeaturePrototypeReference(FeaturePrototypeReference featurePrototypeReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featurePrototypeReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramCallSequence(SubprogramCallSequence subprogramCallSequence,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramCallSequence, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramCall(SubprogramCall subprogramCall, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramCall, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioredImplementation(BehavioredImplementation behavioredImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(behavioredImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractType(AbstractType abstractType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractClassifier(AbstractClassifier abstractClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorSubcomponentType(
			VirtualProcessorSubcomponentType virtualProcessorSubcomponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessorSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusSubcomponentType(VirtualBusSubcomponentType virtualBusSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBusSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupSubcomponentType(ThreadGroupSubcomponentType threadGroupSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroupSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadSubcomponentType(ThreadSubcomponentType threadSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemSubcomponentType(SystemSubcomponentType systemSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessSubcomponentType(ProcessSubcomponentType processSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemorySubcomponentType(MemorySubcomponentType memorySubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memorySubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceSubcomponentType(DeviceSubcomponentType deviceSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deviceSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubcomponentType(ProcessorSubcomponentType processorSubcomponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorSubcomponentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractImplementation(AbstractImplementation abstractImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusSubcomponent(BusSubcomponent busSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBus(Bus bus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bus, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSubcomponent(DataSubcomponent dataSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceSubcomponent(DeviceSubcomponent deviceSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deviceSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice(Device device, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(device, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemorySubcomponent(MemorySubcomponent memorySubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memorySubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemory(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memory, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessSubcomponent(ProcessSubcomponent processSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(org.osate.aadl2.Process process, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(process, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorSubcomponent(ProcessorSubcomponent processorSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessor(Processor processor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemSubcomponent(SystemSubcomponent systemSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(org.osate.aadl2.System system, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(system, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramSubcomponent(SubprogramSubcomponent subprogramSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupSubcomponent(SubprogramGroupSubcomponent subprogramGroupSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroup(SubprogramGroup subprogramGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadSubcomponent(ThreadSubcomponent threadSubcomponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThread(org.osate.aadl2.Thread thread, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(thread, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupSubcomponent(ThreadGroupSubcomponent threadGroupSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroupSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroup(org.osate.aadl2.ThreadGroup threadGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusSubcomponent(VirtualBusSubcomponent virtualBusSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBusSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBus(VirtualBus virtualBus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBus, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorSubcomponent(VirtualProcessorSubcomponent virtualProcessorSubcomponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessorSubcomponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessor(VirtualProcessor virtualProcessor, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractPrototype(AbstractPrototype abstractPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusClassifier(BusClassifier busClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusType(BusType busType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusImplementation(BusImplementation busImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBusPrototype(BusPrototype busPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(busPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataImplementation(DataImplementation dataImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataPrototype(DataPrototype dataPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceClassifier(DeviceClassifier deviceClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deviceClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceType(DeviceType deviceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deviceType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeviceImplementation(DeviceImplementation deviceImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deviceImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevicePrototype(DevicePrototype devicePrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(devicePrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryClassifier(MemoryClassifier memoryClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryType(MemoryType memoryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryImplementation(MemoryImplementation memoryImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryPrototype(MemoryPrototype memoryPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramType(SubprogramType subprogramType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramImplementation(SubprogramImplementation subprogramImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramPrototype(SubprogramPrototype subprogramPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupClassifier(SubprogramGroupClassifier subprogramGroupClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupType(SubprogramGroupType subprogramGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupImplementation(SubprogramGroupImplementation subprogramGroupImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubprogramGroupPrototype(SubprogramGroupPrototype subprogramGroupPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subprogramGroupPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemClassifier(SystemClassifier systemClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemType(SystemType systemType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemImplementation(SystemImplementation systemImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemPrototype(SystemPrototype systemPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorClassifier(ProcessorClassifier processorClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorType(ProcessorType processorType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorImplementation(ProcessorImplementation processorImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessorPrototype(ProcessorPrototype processorPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processorPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessClassifier(ProcessClassifier processClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessType(ProcessType processType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessImplementation(ProcessImplementation processImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessPrototype(ProcessPrototype processPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadClassifier(ThreadClassifier threadClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadType(ThreadType threadType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadImplementation(ThreadImplementation threadImplementation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadPrototype(ThreadPrototype threadPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupClassifier(ThreadGroupClassifier threadGroupClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroupClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupType(ThreadGroupType threadGroupType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroupType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupImplementation(ThreadGroupImplementation threadGroupImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroupImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThreadGroupPrototype(ThreadGroupPrototype threadGroupPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(threadGroupPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusClassifier(VirtualBusClassifier virtualBusClassifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBusClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusType(VirtualBusType virtualBusType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBusType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusImplementation(VirtualBusImplementation virtualBusImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBusImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualBusPrototype(VirtualBusPrototype virtualBusPrototype, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualBusPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorClassifier(VirtualProcessorClassifier virtualProcessorClassifier,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessorClassifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorType(VirtualProcessorType virtualProcessorType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessorType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorImplementation(VirtualProcessorImplementation virtualProcessorImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessorImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualProcessorPrototype(VirtualProcessorPrototype virtualProcessorPrototype,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualProcessorPrototype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicPropertyAssociation(BasicPropertyAssociation basicPropertyAssociation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(basicPropertyAssociation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyConstant(PropertyConstant propertyConstant, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyConstant, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyValue(PropertyValue propertyValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberValue(NumberValue numberValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numberValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitLiteral(UnitLiteral unitLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unitLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierValue(ClassifierValue classifierValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceValue(ReferenceValue referenceValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referenceValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteral(BooleanLiteral booleanLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(booleanLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeValue(RangeValue rangeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rangeValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteral(IntegerLiteral integerLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(integerLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteral(RealLiteral realLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(realLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordValue(RecordValue recordValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(recordValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputedValue(ComputedValue computedValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(computedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListValue(ListValue listValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(listValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedValue(NamedValue namedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertySet(PropertySet propertySet, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertySet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalNamespace(GlobalNamespace globalNamespace, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(globalNamespace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonListType(NonListType nonListType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nonListType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlBoolean(AadlBoolean aadlBoolean, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aadlBoolean, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlString(AadlString aadlString, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aadlString, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlInteger(AadlInteger aadlInteger, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aadlInteger, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberType(NumberType numberType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numberType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitsType(UnitsType unitsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unitsType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationType(EnumerationType enumerationType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericRange(NumericRange numericRange, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numericRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAadlReal(AadlReal aadlReal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aadlReal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierType(ClassifierType classifierType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeType(RangeType rangeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rangeType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordType(RecordType recordType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(recordType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecordField(RecordField recordField, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(recordField, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceType(ReferenceType referenceType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referenceType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListType(ListType listType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(listType, diagnostics, context);
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
	public boolean validateDirectionType(DirectionType directionType, DiagnosticChain diagnostics,
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
	public boolean validateAccessCategory(AccessCategory accessCategory, DiagnosticChain diagnostics,
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
	public boolean validateComponentCategory(ComponentCategory componentCategory, DiagnosticChain diagnostics,
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
		String redefinitionDetail = getRedefinitionDetail(eObject.eClass(), eStructuralFeature.getName(), "lowerBound");
		if (redefinitionDetail != null && redefinitionDetail.length() > 0) {
			try {
				return Integer.parseInt(redefinitionDetail);
			} catch (Exception e) {
				// do nothing
			}
		}
		return eStructuralFeature.getLowerBound();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int getUpperBound(EObject eObject, EStructuralFeature eStructuralFeature) {
		String redefinitionDetail = getRedefinitionDetail(eObject.eClass(), eStructuralFeature.getName(), "upperBound");
		if (redefinitionDetail != null && redefinitionDetail.length() > 0) {
			try {
				return Integer.parseInt(redefinitionDetail);
			} catch (Exception e) {
				// do nothing
			}
		}
		return eStructuralFeature.getUpperBound();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
							diagnostics.add(createDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE,
									EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
									"_UI_FeatureHasTooFewValues_diagnostic",
									new Object[] { getFeatureLabel(eStructuralFeature, context),
											getObjectLabel(eObject, context), size, lowerBound },
									new Object[] { eObject, eStructuralFeature }, context));
						}
					}
					int upperBound = getUpperBound(eObject, eStructuralFeature);
					if (upperBound > 0 && size > upperBound) {
						result = false;
						if (diagnostics != null) {
							diagnostics.add(createDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE,
									EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
									"_UI_FeatureHasTooManyValues_diagnostic",
									new Object[] { getFeatureLabel(eStructuralFeature, context),
											getObjectLabel(eObject, context), size, upperBound },
									new Object[] { eObject, eStructuralFeature }, context));
						}
					}
				} else {
					int upperBound = getUpperBound(eObject, eStructuralFeature);
					if (upperBound > 0) {
						int size = ((List<?>) eObject.eGet(eStructuralFeature)).size();
						if (size > upperBound) {
							result = false;
							if (diagnostics != null) {
								diagnostics.add(createDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE,
										EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
										"_UI_FeatureHasTooManyValues_diagnostic",
										new Object[] { getFeatureLabel(eStructuralFeature, context),
												getObjectLabel(eObject, context), size, upperBound },
										new Object[] { eObject, eStructuralFeature }, context));
							}
						}
					}
				}
			}
		} else if (getLowerBound(eObject, eStructuralFeature) >= 1) {
			if (eStructuralFeature.isUnsettable() ? !eObject.eIsSet(eStructuralFeature)
					: eObject.eGet(eStructuralFeature, false) == null) {
				result = false;
				if (diagnostics != null) {
					diagnostics.add(createDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE,
							EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
							"_UI_RequiredFeatureMustBeSet_diagnostic",
							new Object[] { getFeatureLabel(eStructuralFeature, context),
									getObjectLabel(eObject, context) },
							new Object[] { eObject, eStructuralFeature }, context));
				}
			}
		}
		return result;
	}
	public boolean validate_EveryDefaultConstraint(EObject object, DiagnosticChain theDiagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(object, theDiagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(object, theDiagnostics, context);
		if (result || theDiagnostics != null) {
			result &= validate_EveryReferenceIsContained(object, theDiagnostics, context);
		}
		if (result || theDiagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(object, theDiagnostics, context);
		}
		if (result || theDiagnostics != null) {
			result &= validate_EveryDataValueConforms(object, theDiagnostics, context);
		}
		if (result || theDiagnostics != null) {
			result &= validate_UniqueID(object, theDiagnostics, context);
		}
		if (result || theDiagnostics != null) {
			result &= validate_EveryKeyUnique(object, theDiagnostics, context);
		}
		if (result || theDiagnostics != null) {
			result &= validate_EveryMapEntryUnique(object, theDiagnostics, context);
		}
		return result;
	}

} // Aadl2Validator
