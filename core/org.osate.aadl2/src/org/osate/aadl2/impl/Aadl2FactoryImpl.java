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
package org.osate.aadl2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osate.aadl2.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Aadl2FactoryImpl extends EFactoryImpl implements Aadl2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Aadl2Factory init() {
		try {
			Aadl2Factory theAadl2Factory = (Aadl2Factory) EPackage.Registry.INSTANCE.getEFactory(Aadl2Package.eNS_URI);
			if (theAadl2Factory != null) {
				return theAadl2Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Aadl2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Aadl2Package.COMMENT:
			return createComment();
		case Aadl2Package.PROPERTY_ASSOCIATION:
			return createPropertyAssociation();
		case Aadl2Package.PROPERTY:
			return createProperty();
		case Aadl2Package.BASIC_PROPERTY:
			return createBasicProperty();
		case Aadl2Package.METACLASS_REFERENCE:
			return createMetaclassReference();
		case Aadl2Package.MODAL_ELEMENT:
			return createModalElement();
		case Aadl2Package.MODE:
			return createMode();
		case Aadl2Package.CONTAINED_NAMED_ELEMENT:
			return createContainedNamedElement();
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
			return createContainmentPathElement();
		case Aadl2Package.ARRAY_RANGE:
			return createArrayRange();
		case Aadl2Package.MODAL_PROPERTY_VALUE:
			return createModalPropertyValue();
		case Aadl2Package.ARRAY_DIMENSION:
			return createArrayDimension();
		case Aadl2Package.ARRAY_SIZE:
			return createArraySize();
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE:
			return createComponentImplementationReference();
		case Aadl2Package.MODE_TRANSITION:
			return createModeTransition();
		case Aadl2Package.MODE_TRANSITION_TRIGGER:
			return createModeTransitionTrigger();
		case Aadl2Package.FLOW_SPECIFICATION:
			return createFlowSpecification();
		case Aadl2Package.FLOW_END:
			return createFlowEnd();
		case Aadl2Package.TYPE_EXTENSION:
			return createTypeExtension();
		case Aadl2Package.FEATURE_GROUP:
			return createFeatureGroup();
		case Aadl2Package.FEATURE_GROUP_TYPE:
			return createFeatureGroupType();
		case Aadl2Package.GROUP_EXTENSION:
			return createGroupExtension();
		case Aadl2Package.BUS_ACCESS:
			return createBusAccess();
		case Aadl2Package.DATA_ACCESS:
			return createDataAccess();
		case Aadl2Package.ABSTRACT_FEATURE_CLASSIFIER:
			return createAbstractFeatureClassifier();
		case Aadl2Package.DATA_PORT:
			return createDataPort();
		case Aadl2Package.EVENT_DATA_PORT:
			return createEventDataPort();
		case Aadl2Package.EVENT_PORT:
			return createEventPort();
		case Aadl2Package.PARAMETER:
			return createParameter();
		case Aadl2Package.SUBPROGRAM_ACCESS:
			return createSubprogramAccess();
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS:
			return createSubprogramGroupAccess();
		case Aadl2Package.ABSTRACT_FEATURE:
			return createAbstractFeature();
		case Aadl2Package.FEATURE_PROTOTYPE:
			return createFeaturePrototype();
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE:
			return createFeatureGroupPrototype();
		case Aadl2Package.MODE_BINDING:
			return createModeBinding();
		case Aadl2Package.FLOW_IMPLEMENTATION:
			return createFlowImplementation();
		case Aadl2Package.FLOW_SEGMENT:
			return createFlowSegment();
		case Aadl2Package.CONNECTED_ELEMENT:
			return createConnectedElement();
		case Aadl2Package.IMPLEMENTATION_EXTENSION:
			return createImplementationExtension();
		case Aadl2Package.REALIZATION:
			return createRealization();
		case Aadl2Package.END_TO_END_FLOW:
			return createEndToEndFlow();
		case Aadl2Package.END_TO_END_FLOW_SEGMENT:
			return createEndToEndFlowSegment();
		case Aadl2Package.ABSTRACT_SUBCOMPONENT:
			return createAbstractSubcomponent();
		case Aadl2Package.ACCESS_CONNECTION:
			return createAccessConnection();
		case Aadl2Package.PARAMETER_CONNECTION:
			return createParameterConnection();
		case Aadl2Package.PORT_CONNECTION:
			return createPortConnection();
		case Aadl2Package.FEATURE_CONNECTION:
			return createFeatureConnection();
		case Aadl2Package.FEATURE_GROUP_CONNECTION:
			return createFeatureGroupConnection();
		case Aadl2Package.EVENT_SOURCE:
			return createEventSource();
		case Aadl2Package.EVENT_DATA_SOURCE:
			return createEventDataSource();
		case Aadl2Package.PORT_PROXY:
			return createPortProxy();
		case Aadl2Package.SUBPROGRAM_PROXY:
			return createSubprogramProxy();
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY:
			return createDefaultAnnexLibrary();
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE:
			return createDefaultAnnexSubclause();
		case Aadl2Package.PUBLIC_PACKAGE_SECTION:
			return createPublicPackageSection();
		case Aadl2Package.PACKAGE_RENAME:
			return createPackageRename();
		case Aadl2Package.AADL_PACKAGE:
			return createAadlPackage();
		case Aadl2Package.PRIVATE_PACKAGE_SECTION:
			return createPrivatePackageSection();
		case Aadl2Package.COMPONENT_TYPE_RENAME:
			return createComponentTypeRename();
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME:
			return createFeatureGroupTypeRename();
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING:
			return createComponentPrototypeBinding();
		case Aadl2Package.COMPONENT_PROTOTYPE_ACTUAL:
			return createComponentPrototypeActual();
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_BINDING:
			return createFeatureGroupPrototypeBinding();
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL:
			return createFeatureGroupPrototypeActual();
		case Aadl2Package.FEATURE_PROTOTYPE_BINDING:
			return createFeaturePrototypeBinding();
		case Aadl2Package.ACCESS_SPECIFICATION:
			return createAccessSpecification();
		case Aadl2Package.PORT_SPECIFICATION:
			return createPortSpecification();
		case Aadl2Package.FEATURE_PROTOTYPE_REFERENCE:
			return createFeaturePrototypeReference();
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE:
			return createSubprogramCallSequence();
		case Aadl2Package.SUBPROGRAM_CALL:
			return createSubprogramCall();
		case Aadl2Package.ABSTRACT_TYPE:
			return createAbstractType();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION:
			return createAbstractImplementation();
		case Aadl2Package.BUS_SUBCOMPONENT:
			return createBusSubcomponent();
		case Aadl2Package.DATA_SUBCOMPONENT:
			return createDataSubcomponent();
		case Aadl2Package.DEVICE_SUBCOMPONENT:
			return createDeviceSubcomponent();
		case Aadl2Package.MEMORY_SUBCOMPONENT:
			return createMemorySubcomponent();
		case Aadl2Package.PROCESS_SUBCOMPONENT:
			return createProcessSubcomponent();
		case Aadl2Package.PROCESSOR_SUBCOMPONENT:
			return createProcessorSubcomponent();
		case Aadl2Package.SYSTEM_SUBCOMPONENT:
			return createSystemSubcomponent();
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT:
			return createSubprogramSubcomponent();
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT:
			return createSubprogramGroupSubcomponent();
		case Aadl2Package.THREAD_SUBCOMPONENT:
			return createThreadSubcomponent();
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT:
			return createThreadGroupSubcomponent();
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT:
			return createVirtualBusSubcomponent();
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return createVirtualProcessorSubcomponent();
		case Aadl2Package.ABSTRACT_PROTOTYPE:
			return createAbstractPrototype();
		case Aadl2Package.BUS_TYPE:
			return createBusType();
		case Aadl2Package.BUS_IMPLEMENTATION:
			return createBusImplementation();
		case Aadl2Package.BUS_PROTOTYPE:
			return createBusPrototype();
		case Aadl2Package.DATA_TYPE:
			return createDataType();
		case Aadl2Package.DATA_IMPLEMENTATION:
			return createDataImplementation();
		case Aadl2Package.DATA_PROTOTYPE:
			return createDataPrototype();
		case Aadl2Package.DEVICE_TYPE:
			return createDeviceType();
		case Aadl2Package.DEVICE_IMPLEMENTATION:
			return createDeviceImplementation();
		case Aadl2Package.DEVICE_PROTOTYPE:
			return createDevicePrototype();
		case Aadl2Package.MEMORY_TYPE:
			return createMemoryType();
		case Aadl2Package.MEMORY_IMPLEMENTATION:
			return createMemoryImplementation();
		case Aadl2Package.MEMORY_PROTOTYPE:
			return createMemoryPrototype();
		case Aadl2Package.SUBPROGRAM_TYPE:
			return createSubprogramType();
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION:
			return createSubprogramImplementation();
		case Aadl2Package.SUBPROGRAM_PROTOTYPE:
			return createSubprogramPrototype();
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE:
			return createSubprogramGroupType();
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION:
			return createSubprogramGroupImplementation();
		case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE:
			return createSubprogramGroupPrototype();
		case Aadl2Package.SYSTEM_TYPE:
			return createSystemType();
		case Aadl2Package.SYSTEM_IMPLEMENTATION:
			return createSystemImplementation();
		case Aadl2Package.SYSTEM_PROTOTYPE:
			return createSystemPrototype();
		case Aadl2Package.PROCESSOR_TYPE:
			return createProcessorType();
		case Aadl2Package.PROCESSOR_IMPLEMENTATION:
			return createProcessorImplementation();
		case Aadl2Package.PROCESSOR_PROTOTYPE:
			return createProcessorPrototype();
		case Aadl2Package.PROCESS_TYPE:
			return createProcessType();
		case Aadl2Package.PROCESS_IMPLEMENTATION:
			return createProcessImplementation();
		case Aadl2Package.PROCESS_PROTOTYPE:
			return createProcessPrototype();
		case Aadl2Package.THREAD_TYPE:
			return createThreadType();
		case Aadl2Package.THREAD_IMPLEMENTATION:
			return createThreadImplementation();
		case Aadl2Package.THREAD_PROTOTYPE:
			return createThreadPrototype();
		case Aadl2Package.THREAD_GROUP_TYPE:
			return createThreadGroupType();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION:
			return createThreadGroupImplementation();
		case Aadl2Package.THREAD_GROUP_PROTOTYPE:
			return createThreadGroupPrototype();
		case Aadl2Package.VIRTUAL_BUS_TYPE:
			return createVirtualBusType();
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION:
			return createVirtualBusImplementation();
		case Aadl2Package.VIRTUAL_BUS_PROTOTYPE:
			return createVirtualBusPrototype();
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE:
			return createVirtualProcessorType();
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION:
			return createVirtualProcessorImplementation();
		case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE:
			return createVirtualProcessorPrototype();
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
			return createBasicPropertyAssociation();
		case Aadl2Package.PROPERTY_CONSTANT:
			return createPropertyConstant();
		case Aadl2Package.STRING_LITERAL:
			return createStringLiteral();
		case Aadl2Package.UNIT_LITERAL:
			return createUnitLiteral();
		case Aadl2Package.ENUMERATION_LITERAL:
			return createEnumerationLiteral();
		case Aadl2Package.CLASSIFIER_VALUE:
			return createClassifierValue();
		case Aadl2Package.REFERENCE_VALUE:
			return createReferenceValue();
		case Aadl2Package.BOOLEAN_LITERAL:
			return createBooleanLiteral();
		case Aadl2Package.RANGE_VALUE:
			return createRangeValue();
		case Aadl2Package.INTEGER_LITERAL:
			return createIntegerLiteral();
		case Aadl2Package.REAL_LITERAL:
			return createRealLiteral();
		case Aadl2Package.OPERATION:
			return createOperation();
		case Aadl2Package.RECORD_VALUE:
			return createRecordValue();
		case Aadl2Package.COMPUTED_VALUE:
			return createComputedValue();
		case Aadl2Package.LIST_VALUE:
			return createListValue();
		case Aadl2Package.NAMED_VALUE:
			return createNamedValue();
		case Aadl2Package.PROPERTY_SET:
			return createPropertySet();
		case Aadl2Package.GLOBAL_NAMESPACE:
			return createGlobalNamespace();
		case Aadl2Package.AADL_BOOLEAN:
			return createAadlBoolean();
		case Aadl2Package.AADL_STRING:
			return createAadlString();
		case Aadl2Package.AADL_INTEGER:
			return createAadlInteger();
		case Aadl2Package.UNITS_TYPE:
			return createUnitsType();
		case Aadl2Package.ENUMERATION_TYPE:
			return createEnumerationType();
		case Aadl2Package.NUMERIC_RANGE:
			return createNumericRange();
		case Aadl2Package.AADL_REAL:
			return createAadlReal();
		case Aadl2Package.CLASSIFIER_TYPE:
			return createClassifierType();
		case Aadl2Package.RANGE_TYPE:
			return createRangeType();
		case Aadl2Package.RECORD_TYPE:
			return createRecordType();
		case Aadl2Package.RECORD_FIELD:
			return createRecordField();
		case Aadl2Package.REFERENCE_TYPE:
			return createReferenceType();
		case Aadl2Package.LIST_TYPE:
			return createListType();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case Aadl2Package.FLOW_KIND:
			return createFlowKindFromString(eDataType, initialValue);
		case Aadl2Package.DIRECTION_TYPE:
			return createDirectionTypeFromString(eDataType, initialValue);
		case Aadl2Package.ACCESS_TYPE:
			return createAccessTypeFromString(eDataType, initialValue);
		case Aadl2Package.ACCESS_CATEGORY:
			return createAccessCategoryFromString(eDataType, initialValue);
		case Aadl2Package.PORT_CATEGORY:
			return createPortCategoryFromString(eDataType, initialValue);
		case Aadl2Package.COMPONENT_CATEGORY:
			return createComponentCategoryFromString(eDataType, initialValue);
		case Aadl2Package.OPERATION_KIND:
			return createOperationKindFromString(eDataType, initialValue);
		case Aadl2Package.STRING:
			return createStringFromString(eDataType, initialValue);
		case Aadl2Package.BOOLEAN:
			return createBooleanFromString(eDataType, initialValue);
		case Aadl2Package.INTEGER:
			return createIntegerFromString(eDataType, initialValue);
		case Aadl2Package.REAL:
			return createRealFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case Aadl2Package.FLOW_KIND:
			return convertFlowKindToString(eDataType, instanceValue);
		case Aadl2Package.DIRECTION_TYPE:
			return convertDirectionTypeToString(eDataType, instanceValue);
		case Aadl2Package.ACCESS_TYPE:
			return convertAccessTypeToString(eDataType, instanceValue);
		case Aadl2Package.ACCESS_CATEGORY:
			return convertAccessCategoryToString(eDataType, instanceValue);
		case Aadl2Package.PORT_CATEGORY:
			return convertPortCategoryToString(eDataType, instanceValue);
		case Aadl2Package.COMPONENT_CATEGORY:
			return convertComponentCategoryToString(eDataType, instanceValue);
		case Aadl2Package.OPERATION_KIND:
			return convertOperationKindToString(eDataType, instanceValue);
		case Aadl2Package.STRING:
			return convertStringToString(eDataType, instanceValue);
		case Aadl2Package.BOOLEAN:
			return convertBooleanToString(eDataType, instanceValue);
		case Aadl2Package.INTEGER:
			return convertIntegerToString(eDataType, instanceValue);
		case Aadl2Package.REAL:
			return convertRealToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssociation createPropertyAssociation() {
		PropertyAssociationImpl propertyAssociation = new PropertyAssociationImpl();
		return propertyAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicProperty createBasicProperty() {
		BasicPropertyImpl basicProperty = new BasicPropertyImpl();
		return basicProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaclassReference createMetaclassReference() {
		MetaclassReferenceImpl metaclassReference = new MetaclassReferenceImpl();
		return metaclassReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModalElement createModalElement() {
		ModalElementImpl modalElement = new ModalElementImpl();
		return modalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode createMode() {
		ModeImpl mode = new ModeImpl();
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainedNamedElement createContainedNamedElement() {
		ContainedNamedElementImpl containedNamedElement = new ContainedNamedElementImpl();
		return containedNamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainmentPathElement createContainmentPathElement() {
		ContainmentPathElementImpl containmentPathElement = new ContainmentPathElementImpl();
		return containmentPathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayRange createArrayRange() {
		ArrayRangeImpl arrayRange = new ArrayRangeImpl();
		return arrayRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModalPropertyValue createModalPropertyValue() {
		ModalPropertyValueImpl modalPropertyValue = new ModalPropertyValueImpl();
		return modalPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayDimension createArrayDimension() {
		ArrayDimensionImpl arrayDimension = new ArrayDimensionImpl();
		return arrayDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArraySize createArraySize() {
		ArraySizeImpl arraySize = new ArraySizeImpl();
		return arraySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementationReference createComponentImplementationReference() {
		ComponentImplementationReferenceImpl componentImplementationReference = new ComponentImplementationReferenceImpl();
		return componentImplementationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeTransition createModeTransition() {
		ModeTransitionImpl modeTransition = new ModeTransitionImpl();
		return modeTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeTransitionTrigger createModeTransitionTrigger() {
		ModeTransitionTriggerImpl modeTransitionTrigger = new ModeTransitionTriggerImpl();
		return modeTransitionTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification createFlowSpecification() {
		FlowSpecificationImpl flowSpecification = new FlowSpecificationImpl();
		return flowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd createFlowEnd() {
		FlowEndImpl flowEnd = new FlowEndImpl();
		return flowEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeExtension createTypeExtension() {
		TypeExtensionImpl typeExtension = new TypeExtensionImpl();
		return typeExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroup createFeatureGroup() {
		FeatureGroupImpl featureGroup = new FeatureGroupImpl();
		return featureGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupType createFeatureGroupType() {
		FeatureGroupTypeImpl featureGroupType = new FeatureGroupTypeImpl();
		return featureGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupExtension createGroupExtension() {
		GroupExtensionImpl groupExtension = new GroupExtensionImpl();
		return groupExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusAccess createBusAccess() {
		BusAccessImpl busAccess = new BusAccessImpl();
		return busAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccess createDataAccess() {
		DataAccessImpl dataAccess = new DataAccessImpl();
		return dataAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractFeatureClassifier createAbstractFeatureClassifier() {
		AbstractFeatureClassifierImpl abstractFeatureClassifier = new AbstractFeatureClassifierImpl();
		return abstractFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPort createDataPort() {
		DataPortImpl dataPort = new DataPortImpl();
		return dataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDataPort createEventDataPort() {
		EventDataPortImpl eventDataPort = new EventDataPortImpl();
		return eventDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPort createEventPort() {
		EventPortImpl eventPort = new EventPortImpl();
		return eventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramAccess createSubprogramAccess() {
		SubprogramAccessImpl subprogramAccess = new SubprogramAccessImpl();
		return subprogramAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupAccess createSubprogramGroupAccess() {
		SubprogramGroupAccessImpl subprogramGroupAccess = new SubprogramGroupAccessImpl();
		return subprogramGroupAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractFeature createAbstractFeature() {
		AbstractFeatureImpl abstractFeature = new AbstractFeatureImpl();
		return abstractFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeBinding createModeBinding() {
		ModeBindingImpl modeBinding = new ModeBindingImpl();
		return modeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowImplementation createFlowImplementation() {
		FlowImplementationImpl flowImplementation = new FlowImplementationImpl();
		return flowImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSegment createFlowSegment() {
		FlowSegmentImpl flowSegment = new FlowSegmentImpl();
		return flowSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement createConnectedElement() {
		ConnectedElementImpl connectedElement = new ConnectedElementImpl();
		return connectedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationExtension createImplementationExtension() {
		ImplementationExtensionImpl implementationExtension = new ImplementationExtensionImpl();
		return implementationExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realization createRealization() {
		RealizationImpl realization = new RealizationImpl();
		return realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlow createEndToEndFlow() {
		EndToEndFlowImpl endToEndFlow = new EndToEndFlowImpl();
		return endToEndFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlowSegment createEndToEndFlowSegment() {
		EndToEndFlowSegmentImpl endToEndFlowSegment = new EndToEndFlowSegmentImpl();
		return endToEndFlowSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSubcomponent createAbstractSubcomponent() {
		AbstractSubcomponentImpl abstractSubcomponent = new AbstractSubcomponentImpl();
		return abstractSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessConnection createAccessConnection() {
		AccessConnectionImpl accessConnection = new AccessConnectionImpl();
		return accessConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterConnection createParameterConnection() {
		ParameterConnectionImpl parameterConnection = new ParameterConnectionImpl();
		return parameterConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortConnection createPortConnection() {
		PortConnectionImpl portConnection = new PortConnectionImpl();
		return portConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConnection createFeatureConnection() {
		FeatureConnectionImpl featureConnection = new FeatureConnectionImpl();
		return featureConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupConnection createFeatureGroupConnection() {
		FeatureGroupConnectionImpl featureGroupConnection = new FeatureGroupConnectionImpl();
		return featureGroupConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSource createEventSource() {
		EventSourceImpl eventSource = new EventSourceImpl();
		return eventSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDataSource createEventDataSource() {
		EventDataSourceImpl eventDataSource = new EventDataSourceImpl();
		return eventDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortProxy createPortProxy() {
		PortProxyImpl portProxy = new PortProxyImpl();
		return portProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramProxy createSubprogramProxy() {
		SubprogramProxyImpl subprogramProxy = new SubprogramProxyImpl();
		return subprogramProxy;
	}

	public AnnexSubclause createAnnexSubclause() {
		AnnexSubclauseImpl annex = new AnnexSubclauseImpl() {
			private String annexContent;

			public String getAnnexContent() {
				return annexContent;
			}

			public void setAnnexContent(String s) {
				annexContent = s;
			}
		};
		return annex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnexLibrary createDefaultAnnexLibrary() {
		DefaultAnnexLibraryImpl defaultAnnexLibrary = new DefaultAnnexLibraryImpl();
		return defaultAnnexLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnexSubclause createDefaultAnnexSubclause() {
		DefaultAnnexSubclauseImpl defaultAnnexSubclause = new DefaultAnnexSubclauseImpl();
		return defaultAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicPackageSection createPublicPackageSection() {
		PublicPackageSectionImpl publicPackageSection = new PublicPackageSectionImpl();
		return publicPackageSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRename createPackageRename() {
		PackageRenameImpl packageRename = new PackageRenameImpl();
		return packageRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlPackage createAadlPackage() {
		AadlPackageImpl aadlPackage = new AadlPackageImpl();
		return aadlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivatePackageSection createPrivatePackageSection() {
		PrivatePackageSectionImpl privatePackageSection = new PrivatePackageSectionImpl();
		return privatePackageSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentTypeRename createComponentTypeRename() {
		ComponentTypeRenameImpl componentTypeRename = new ComponentTypeRenameImpl();
		return componentTypeRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupTypeRename createFeatureGroupTypeRename() {
		FeatureGroupTypeRenameImpl featureGroupTypeRename = new FeatureGroupTypeRenameImpl();
		return featureGroupTypeRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractType createAbstractType() {
		AbstractTypeImpl abstractType = new AbstractTypeImpl();
		return abstractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractImplementation createAbstractImplementation() {
		AbstractImplementationImpl abstractImplementation = new AbstractImplementationImpl();
		return abstractImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramCallSequence createSubprogramCallSequence() {
		SubprogramCallSequenceImpl subprogramCallSequence = new SubprogramCallSequenceImpl();
		return subprogramCallSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusSubcomponent createBusSubcomponent() {
		BusSubcomponentImpl busSubcomponent = new BusSubcomponentImpl();
		return busSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubcomponent createDataSubcomponent() {
		DataSubcomponentImpl dataSubcomponent = new DataSubcomponentImpl();
		return dataSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceSubcomponent createDeviceSubcomponent() {
		DeviceSubcomponentImpl deviceSubcomponent = new DeviceSubcomponentImpl();
		return deviceSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemorySubcomponent createMemorySubcomponent() {
		MemorySubcomponentImpl memorySubcomponent = new MemorySubcomponentImpl();
		return memorySubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSubcomponent createProcessSubcomponent() {
		ProcessSubcomponentImpl processSubcomponent = new ProcessSubcomponentImpl();
		return processSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorSubcomponent createProcessorSubcomponent() {
		ProcessorSubcomponentImpl processorSubcomponent = new ProcessorSubcomponentImpl();
		return processorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemSubcomponent createSystemSubcomponent() {
		SystemSubcomponentImpl systemSubcomponent = new SystemSubcomponentImpl();
		return systemSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramSubcomponent createSubprogramSubcomponent() {
		SubprogramSubcomponentImpl subprogramSubcomponent = new SubprogramSubcomponentImpl();
		return subprogramSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupSubcomponent createSubprogramGroupSubcomponent() {
		SubprogramGroupSubcomponentImpl subprogramGroupSubcomponent = new SubprogramGroupSubcomponentImpl();
		return subprogramGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadSubcomponent createThreadSubcomponent() {
		ThreadSubcomponentImpl threadSubcomponent = new ThreadSubcomponentImpl();
		return threadSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupSubcomponent createThreadGroupSubcomponent() {
		ThreadGroupSubcomponentImpl threadGroupSubcomponent = new ThreadGroupSubcomponentImpl();
		return threadGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusSubcomponent createVirtualBusSubcomponent() {
		VirtualBusSubcomponentImpl virtualBusSubcomponent = new VirtualBusSubcomponentImpl();
		return virtualBusSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorSubcomponent createVirtualProcessorSubcomponent() {
		VirtualProcessorSubcomponentImpl virtualProcessorSubcomponent = new VirtualProcessorSubcomponentImpl();
		return virtualProcessorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractPrototype createAbstractPrototype() {
		AbstractPrototypeImpl abstractPrototype = new AbstractPrototypeImpl();
		return abstractPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusType createBusType() {
		BusTypeImpl busType = new BusTypeImpl();
		return busType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusImplementation createBusImplementation() {
		BusImplementationImpl busImplementation = new BusImplementationImpl();
		return busImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusPrototype createBusPrototype() {
		BusPrototypeImpl busPrototype = new BusPrototypeImpl();
		return busPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataImplementation createDataImplementation() {
		DataImplementationImpl dataImplementation = new DataImplementationImpl();
		return dataImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPrototype createDataPrototype() {
		DataPrototypeImpl dataPrototype = new DataPrototypeImpl();
		return dataPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType createDeviceType() {
		DeviceTypeImpl deviceType = new DeviceTypeImpl();
		return deviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceImplementation createDeviceImplementation() {
		DeviceImplementationImpl deviceImplementation = new DeviceImplementationImpl();
		return deviceImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DevicePrototype createDevicePrototype() {
		DevicePrototypeImpl devicePrototype = new DevicePrototypeImpl();
		return devicePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryType createMemoryType() {
		MemoryTypeImpl memoryType = new MemoryTypeImpl();
		return memoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryImplementation createMemoryImplementation() {
		MemoryImplementationImpl memoryImplementation = new MemoryImplementationImpl();
		return memoryImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryPrototype createMemoryPrototype() {
		MemoryPrototypeImpl memoryPrototype = new MemoryPrototypeImpl();
		return memoryPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType createProcessType() {
		ProcessTypeImpl processType = new ProcessTypeImpl();
		return processType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorType createProcessorType() {
		ProcessorTypeImpl processorType = new ProcessorTypeImpl();
		return processorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessImplementation createProcessImplementation() {
		ProcessImplementationImpl processImplementation = new ProcessImplementationImpl();
		return processImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessPrototype createProcessPrototype() {
		ProcessPrototypeImpl processPrototype = new ProcessPrototypeImpl();
		return processPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorImplementation createProcessorImplementation() {
		ProcessorImplementationImpl processorImplementation = new ProcessorImplementationImpl();
		return processorImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorPrototype createProcessorPrototype() {
		ProcessorPrototypeImpl processorPrototype = new ProcessorPrototypeImpl();
		return processorPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramType createSubprogramType() {
		SubprogramTypeImpl subprogramType = new SubprogramTypeImpl();
		return subprogramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramImplementation createSubprogramImplementation() {
		SubprogramImplementationImpl subprogramImplementation = new SubprogramImplementationImpl();
		return subprogramImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramPrototype createSubprogramPrototype() {
		SubprogramPrototypeImpl subprogramPrototype = new SubprogramPrototypeImpl();
		return subprogramPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupType createSubprogramGroupType() {
		SubprogramGroupTypeImpl subprogramGroupType = new SubprogramGroupTypeImpl();
		return subprogramGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupImplementation createSubprogramGroupImplementation() {
		SubprogramGroupImplementationImpl subprogramGroupImplementation = new SubprogramGroupImplementationImpl();
		return subprogramGroupImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupPrototype createSubprogramGroupPrototype() {
		SubprogramGroupPrototypeImpl subprogramGroupPrototype = new SubprogramGroupPrototypeImpl();
		return subprogramGroupPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemType createSystemType() {
		SystemTypeImpl systemType = new SystemTypeImpl();
		return systemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemImplementation createSystemImplementation() {
		SystemImplementationImpl systemImplementation = new SystemImplementationImpl();
		return systemImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemPrototype createSystemPrototype() {
		SystemPrototypeImpl systemPrototype = new SystemPrototypeImpl();
		return systemPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadType createThreadType() {
		ThreadTypeImpl threadType = new ThreadTypeImpl();
		return threadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadImplementation createThreadImplementation() {
		ThreadImplementationImpl threadImplementation = new ThreadImplementationImpl();
		return threadImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadPrototype createThreadPrototype() {
		ThreadPrototypeImpl threadPrototype = new ThreadPrototypeImpl();
		return threadPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupType createThreadGroupType() {
		ThreadGroupTypeImpl threadGroupType = new ThreadGroupTypeImpl();
		return threadGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupImplementation createThreadGroupImplementation() {
		ThreadGroupImplementationImpl threadGroupImplementation = new ThreadGroupImplementationImpl();
		return threadGroupImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupPrototype createThreadGroupPrototype() {
		ThreadGroupPrototypeImpl threadGroupPrototype = new ThreadGroupPrototypeImpl();
		return threadGroupPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusType createVirtualBusType() {
		VirtualBusTypeImpl virtualBusType = new VirtualBusTypeImpl();
		return virtualBusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusImplementation createVirtualBusImplementation() {
		VirtualBusImplementationImpl virtualBusImplementation = new VirtualBusImplementationImpl();
		return virtualBusImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusPrototype createVirtualBusPrototype() {
		VirtualBusPrototypeImpl virtualBusPrototype = new VirtualBusPrototypeImpl();
		return virtualBusPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorType createVirtualProcessorType() {
		VirtualProcessorTypeImpl virtualProcessorType = new VirtualProcessorTypeImpl();
		return virtualProcessorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorImplementation createVirtualProcessorImplementation() {
		VirtualProcessorImplementationImpl virtualProcessorImplementation = new VirtualProcessorImplementationImpl();
		return virtualProcessorImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorPrototype createVirtualProcessorPrototype() {
		VirtualProcessorPrototypeImpl virtualProcessorPrototype = new VirtualProcessorPrototypeImpl();
		return virtualProcessorPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPrototypeBinding createComponentPrototypeBinding() {
		ComponentPrototypeBindingImpl componentPrototypeBinding = new ComponentPrototypeBindingImpl();
		return componentPrototypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPrototypeActual createComponentPrototypeActual() {
		ComponentPrototypeActualImpl componentPrototypeActual = new ComponentPrototypeActualImpl();
		return componentPrototypeActual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupPrototypeBinding createFeatureGroupPrototypeBinding() {
		FeatureGroupPrototypeBindingImpl featureGroupPrototypeBinding = new FeatureGroupPrototypeBindingImpl();
		return featureGroupPrototypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupPrototypeActual createFeatureGroupPrototypeActual() {
		FeatureGroupPrototypeActualImpl featureGroupPrototypeActual = new FeatureGroupPrototypeActualImpl();
		return featureGroupPrototypeActual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePrototype createFeaturePrototype() {
		FeaturePrototypeImpl featurePrototype = new FeaturePrototypeImpl();
		return featurePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupPrototype createFeatureGroupPrototype() {
		FeatureGroupPrototypeImpl featureGroupPrototype = new FeatureGroupPrototypeImpl();
		return featureGroupPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePrototypeBinding createFeaturePrototypeBinding() {
		FeaturePrototypeBindingImpl featurePrototypeBinding = new FeaturePrototypeBindingImpl();
		return featurePrototypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessSpecification createAccessSpecification() {
		AccessSpecificationImpl accessSpecification = new AccessSpecificationImpl();
		return accessSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortSpecification createPortSpecification() {
		PortSpecificationImpl portSpecification = new PortSpecificationImpl();
		return portSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePrototypeReference createFeaturePrototypeReference() {
		FeaturePrototypeReferenceImpl featurePrototypeReference = new FeaturePrototypeReferenceImpl();
		return featurePrototypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramCall createSubprogramCall() {
		SubprogramCallImpl subprogramCall = new SubprogramCallImpl();
		return subprogramCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicPropertyAssociation createBasicPropertyAssociation() {
		BasicPropertyAssociationImpl basicPropertyAssociation = new BasicPropertyAssociationImpl();
		return basicPropertyAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyConstant createPropertyConstant() {
		PropertyConstantImpl propertyConstant = new PropertyConstantImpl();
		return propertyConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLiteral createUnitLiteral() {
		UnitLiteralImpl unitLiteral = new UnitLiteralImpl();
		return unitLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierValue createClassifierValue() {
		ClassifierValueImpl classifierValue = new ClassifierValueImpl();
		return classifierValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceValue createReferenceValue() {
		ReferenceValueImpl referenceValue = new ReferenceValueImpl();
		return referenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeValue createRangeValue() {
		RangeValueImpl rangeValue = new RangeValueImpl();
		return rangeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealLiteral createRealLiteral() {
		RealLiteralImpl realLiteral = new RealLiteralImpl();
		return realLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordValue createRecordValue() {
		RecordValueImpl recordValue = new RecordValueImpl();
		return recordValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedValue createComputedValue() {
		ComputedValueImpl computedValue = new ComputedValueImpl();
		return computedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListValue createListValue() {
		ListValueImpl listValue = new ListValueImpl();
		return listValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedValue createNamedValue() {
		NamedValueImpl namedValue = new NamedValueImpl();
		return namedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySet createPropertySet() {
		PropertySetImpl propertySet = new PropertySetImpl();
		return propertySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalNamespace createGlobalNamespace() {
		GlobalNamespaceImpl globalNamespace = new GlobalNamespaceImpl();
		return globalNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlBoolean createAadlBoolean() {
		AadlBooleanImpl aadlBoolean = new AadlBooleanImpl();
		return aadlBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlString createAadlString() {
		AadlStringImpl aadlString = new AadlStringImpl();
		return aadlString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlInteger createAadlInteger() {
		AadlIntegerImpl aadlInteger = new AadlIntegerImpl();
		return aadlInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitsType createUnitsType() {
		UnitsTypeImpl unitsType = new UnitsTypeImpl();
		return unitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationType createEnumerationType() {
		EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
		return enumerationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericRange createNumericRange() {
		NumericRangeImpl numericRange = new NumericRangeImpl();
		return numericRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlReal createAadlReal() {
		AadlRealImpl aadlReal = new AadlRealImpl();
		return aadlReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierType createClassifierType() {
		ClassifierTypeImpl classifierType = new ClassifierTypeImpl();
		return classifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeType createRangeType() {
		RangeTypeImpl rangeType = new RangeTypeImpl();
		return rangeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordType createRecordType() {
		RecordTypeImpl recordType = new RecordTypeImpl();
		return recordType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordField createRecordField() {
		RecordFieldImpl recordField = new RecordFieldImpl();
		return recordField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceType createReferenceType() {
		ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
		return referenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListType createListType() {
		ListTypeImpl listType = new ListTypeImpl();
		return listType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionType createDirectionTypeFromString(EDataType eDataType, String initialValue) {
		DirectionType result = DirectionType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortCategory createPortCategoryFromString(EDataType eDataType, String initialValue) {
		PortCategory result = PortCategory.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowKind createFlowKindFromString(EDataType eDataType, String initialValue) {
		FlowKind result = FlowKind.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlowKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType createAccessTypeFromString(EDataType eDataType, String initialValue) {
		AccessType result = AccessType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessCategory createAccessCategoryFromString(EDataType eDataType, String initialValue) {
		AccessCategory result = AccessCategory.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentCategory createComponentCategoryFromString(EDataType eDataType, String initialValue) {
		ComponentCategory result = ComponentCategory.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComponentCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationKind createOperationKindFromString(EDataType eDataType, String initialValue) {
		OperationKind result = OperationKind.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean createBooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createIntegerFromString(EDataType eDataType, String initialValue) {
		return (Long) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createRealFromString(EDataType eDataType, String initialValue) {
		return (Double) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2Package getAadl2Package() {
		return (Aadl2Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Aadl2Package getPackage() {
		return Aadl2Package.eINSTANCE;
	}

} // Aadl2FactoryImpl
