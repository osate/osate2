/**
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 */
package org.osate.aadl2.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osate.aadl2.*;

/**
 * <!-- begin-user-doc -->
 * An adapter that propagates notifications for derived unions.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.Aadl2Package
 * @generated
 */
public class Aadl2DerivedUnionAdapter extends AdapterImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Aadl2Package modelPackage;

	/**
	 * Creates an instance of the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2DerivedUnionAdapter() {
		if (modelPackage == null) {
			modelPackage = Aadl2Package.eINSTANCE;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> with the appropriate model class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof EObject) {
			EClass eClass = ((EObject) notifier).eClass();
			if (eClass.eContainer() == modelPackage) {
				notifyChanged(notification, eClass);
			}
		}
	}

	/**
	 * Calls <code>notifyXXXChanged</code> for the corresponding class of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyChanged(Notification notification, EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Aadl2Package.COMMENT:
			notifyCommentChanged(notification, eClass);
			break;
		case Aadl2Package.PROPERTY_ASSOCIATION:
			notifyPropertyAssociationChanged(notification, eClass);
			break;
		case Aadl2Package.PROPERTY:
			notifyPropertyChanged(notification, eClass);
			break;
		case Aadl2Package.BASIC_PROPERTY:
			notifyBasicPropertyChanged(notification, eClass);
			break;
		case Aadl2Package.METACLASS_REFERENCE:
			notifyMetaclassReferenceChanged(notification, eClass);
			break;
		case Aadl2Package.MODAL_ELEMENT:
			notifyModalElementChanged(notification, eClass);
			break;
		case Aadl2Package.MODE:
			notifyModeChanged(notification, eClass);
			break;
		case Aadl2Package.CONTAINED_NAMED_ELEMENT:
			notifyContainedNamedElementChanged(notification, eClass);
			break;
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
			notifyContainmentPathElementChanged(notification, eClass);
			break;
		case Aadl2Package.ARRAY_RANGE:
			notifyArrayRangeChanged(notification, eClass);
			break;
		case Aadl2Package.MODAL_PROPERTY_VALUE:
			notifyModalPropertyValueChanged(notification, eClass);
			break;
		case Aadl2Package.ARRAY_DIMENSION:
			notifyArrayDimensionChanged(notification, eClass);
			break;
		case Aadl2Package.ARRAY_SIZE:
			notifyArraySizeChanged(notification, eClass);
			break;
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE:
			notifyComponentImplementationReferenceChanged(notification, eClass);
			break;
		case Aadl2Package.MODE_TRANSITION:
			notifyModeTransitionChanged(notification, eClass);
			break;
		case Aadl2Package.MODE_TRANSITION_TRIGGER:
			notifyModeTransitionTriggerChanged(notification, eClass);
			break;
		case Aadl2Package.FLOW_SPECIFICATION:
			notifyFlowSpecificationChanged(notification, eClass);
			break;
		case Aadl2Package.FLOW_END:
			notifyFlowEndChanged(notification, eClass);
			break;
		case Aadl2Package.TYPE_EXTENSION:
			notifyTypeExtensionChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP:
			notifyFeatureGroupChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE:
			notifyFeatureGroupTypeChanged(notification, eClass);
			break;
		case Aadl2Package.GROUP_EXTENSION:
			notifyGroupExtensionChanged(notification, eClass);
			break;
		case Aadl2Package.BUS_ACCESS:
			notifyBusAccessChanged(notification, eClass);
			break;
		case Aadl2Package.DATA_ACCESS:
			notifyDataAccessChanged(notification, eClass);
			break;
		case Aadl2Package.DATA_PORT:
			notifyDataPortChanged(notification, eClass);
			break;
		case Aadl2Package.EVENT_DATA_PORT:
			notifyEventDataPortChanged(notification, eClass);
			break;
		case Aadl2Package.EVENT_PORT:
			notifyEventPortChanged(notification, eClass);
			break;
		case Aadl2Package.PARAMETER:
			notifyParameterChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_ACCESS:
			notifySubprogramAccessChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS:
			notifySubprogramGroupAccessChanged(notification, eClass);
			break;
		case Aadl2Package.ABSTRACT_FEATURE:
			notifyAbstractFeatureChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_PROTOTYPE:
			notifyFeaturePrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE:
			notifyFeatureGroupPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.MODE_BINDING:
			notifyModeBindingChanged(notification, eClass);
			break;
		case Aadl2Package.FLOW_IMPLEMENTATION:
			notifyFlowImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.FLOW_SEGMENT:
			notifyFlowSegmentChanged(notification, eClass);
			break;
		case Aadl2Package.CONNECTED_ELEMENT:
			notifyConnectedElementChanged(notification, eClass);
			break;
		case Aadl2Package.IMPLEMENTATION_EXTENSION:
			notifyImplementationExtensionChanged(notification, eClass);
			break;
		case Aadl2Package.REALIZATION:
			notifyRealizationChanged(notification, eClass);
			break;
		case Aadl2Package.END_TO_END_FLOW:
			notifyEndToEndFlowChanged(notification, eClass);
			break;
		case Aadl2Package.END_TO_END_FLOW_SEGMENT:
			notifyEndToEndFlowSegmentChanged(notification, eClass);
			break;
		case Aadl2Package.ABSTRACT_SUBCOMPONENT:
			notifyAbstractSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.ACCESS_CONNECTION:
			notifyAccessConnectionChanged(notification, eClass);
			break;
		case Aadl2Package.PARAMETER_CONNECTION:
			notifyParameterConnectionChanged(notification, eClass);
			break;
		case Aadl2Package.PORT_CONNECTION:
			notifyPortConnectionChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_CONNECTION:
			notifyFeatureConnectionChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP_CONNECTION:
			notifyFeatureGroupConnectionChanged(notification, eClass);
			break;
		case Aadl2Package.EVENT_SOURCE:
			notifyEventSourceChanged(notification, eClass);
			break;
		case Aadl2Package.EVENT_DATA_SOURCE:
			notifyEventDataSourceChanged(notification, eClass);
			break;
		case Aadl2Package.PORT_PROXY:
			notifyPortProxyChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_PROXY:
			notifySubprogramProxyChanged(notification, eClass);
			break;
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY:
			notifyDefaultAnnexLibraryChanged(notification, eClass);
			break;
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE:
			notifyDefaultAnnexSubclauseChanged(notification, eClass);
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION:
			notifyPublicPackageSectionChanged(notification, eClass);
			break;
		case Aadl2Package.PACKAGE_RENAME:
			notifyPackageRenameChanged(notification, eClass);
			break;
		case Aadl2Package.AADL_PACKAGE:
			notifyAadlPackageChanged(notification, eClass);
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION:
			notifyPrivatePackageSectionChanged(notification, eClass);
			break;
		case Aadl2Package.COMPONENT_TYPE_RENAME:
			notifyComponentTypeRenameChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME:
			notifyFeatureGroupTypeRenameChanged(notification, eClass);
			break;
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING:
			notifyComponentPrototypeBindingChanged(notification, eClass);
			break;
		case Aadl2Package.COMPONENT_PROTOTYPE_ACTUAL:
			notifyComponentPrototypeActualChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_BINDING:
			notifyFeatureGroupPrototypeBindingChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL:
			notifyFeatureGroupPrototypeActualChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_PROTOTYPE_BINDING:
			notifyFeaturePrototypeBindingChanged(notification, eClass);
			break;
		case Aadl2Package.ACCESS_SPECIFICATION:
			notifyAccessSpecificationChanged(notification, eClass);
			break;
		case Aadl2Package.PORT_SPECIFICATION:
			notifyPortSpecificationChanged(notification, eClass);
			break;
		case Aadl2Package.FEATURE_PROTOTYPE_REFERENCE:
			notifyFeaturePrototypeReferenceChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE:
			notifySubprogramCallSequenceChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_CALL:
			notifySubprogramCallChanged(notification, eClass);
			break;
		case Aadl2Package.ABSTRACT_TYPE:
			notifyAbstractTypeChanged(notification, eClass);
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION:
			notifyAbstractImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.BUS_SUBCOMPONENT:
			notifyBusSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.DATA_SUBCOMPONENT:
			notifyDataSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.DEVICE_SUBCOMPONENT:
			notifyDeviceSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.MEMORY_SUBCOMPONENT:
			notifyMemorySubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESS_SUBCOMPONENT:
			notifyProcessSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESSOR_SUBCOMPONENT:
			notifyProcessorSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.SYSTEM_SUBCOMPONENT:
			notifySystemSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT:
			notifySubprogramSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifySubprogramGroupSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_SUBCOMPONENT:
			notifyThreadSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT:
			notifyThreadGroupSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT:
			notifyVirtualBusSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT:
			notifyVirtualProcessorSubcomponentChanged(notification, eClass);
			break;
		case Aadl2Package.ABSTRACT_PROTOTYPE:
			notifyAbstractPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.BUS_TYPE:
			notifyBusTypeChanged(notification, eClass);
			break;
		case Aadl2Package.BUS_IMPLEMENTATION:
			notifyBusImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.BUS_PROTOTYPE:
			notifyBusPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.DATA_TYPE:
			notifyDataTypeChanged(notification, eClass);
			break;
		case Aadl2Package.DATA_IMPLEMENTATION:
			notifyDataImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.DATA_PROTOTYPE:
			notifyDataPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.DEVICE_TYPE:
			notifyDeviceTypeChanged(notification, eClass);
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION:
			notifyDeviceImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.DEVICE_PROTOTYPE:
			notifyDevicePrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.MEMORY_TYPE:
			notifyMemoryTypeChanged(notification, eClass);
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION:
			notifyMemoryImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.MEMORY_PROTOTYPE:
			notifyMemoryPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_TYPE:
			notifySubprogramTypeChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION:
			notifySubprogramImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_PROTOTYPE:
			notifySubprogramPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE:
			notifySubprogramGroupTypeChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION:
			notifySubprogramGroupImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE:
			notifySubprogramGroupPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.SYSTEM_TYPE:
			notifySystemTypeChanged(notification, eClass);
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION:
			notifySystemImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.SYSTEM_PROTOTYPE:
			notifySystemPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESSOR_TYPE:
			notifyProcessorTypeChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION:
			notifyProcessorImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESSOR_PROTOTYPE:
			notifyProcessorPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESS_TYPE:
			notifyProcessTypeChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION:
			notifyProcessImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.PROCESS_PROTOTYPE:
			notifyProcessPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_TYPE:
			notifyThreadTypeChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION:
			notifyThreadImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_PROTOTYPE:
			notifyThreadPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_GROUP_TYPE:
			notifyThreadGroupTypeChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION:
			notifyThreadGroupImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.THREAD_GROUP_PROTOTYPE:
			notifyThreadGroupPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE:
			notifyVirtualBusTypeChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION:
			notifyVirtualBusImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_BUS_PROTOTYPE:
			notifyVirtualBusPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE:
			notifyVirtualProcessorTypeChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION:
			notifyVirtualProcessorImplementationChanged(notification, eClass);
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE:
			notifyVirtualProcessorPrototypeChanged(notification, eClass);
			break;
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
			notifyBasicPropertyAssociationChanged(notification, eClass);
			break;
		case Aadl2Package.PROPERTY_CONSTANT:
			notifyPropertyConstantChanged(notification, eClass);
			break;
		case Aadl2Package.STRING_LITERAL:
			notifyStringLiteralChanged(notification, eClass);
			break;
		case Aadl2Package.UNIT_LITERAL:
			notifyUnitLiteralChanged(notification, eClass);
			break;
		case Aadl2Package.ENUMERATION_LITERAL:
			notifyEnumerationLiteralChanged(notification, eClass);
			break;
		case Aadl2Package.CLASSIFIER_VALUE:
			notifyClassifierValueChanged(notification, eClass);
			break;
		case Aadl2Package.REFERENCE_VALUE:
			notifyReferenceValueChanged(notification, eClass);
			break;
		case Aadl2Package.BOOLEAN_LITERAL:
			notifyBooleanLiteralChanged(notification, eClass);
			break;
		case Aadl2Package.RANGE_VALUE:
			notifyRangeValueChanged(notification, eClass);
			break;
		case Aadl2Package.INTEGER_LITERAL:
			notifyIntegerLiteralChanged(notification, eClass);
			break;
		case Aadl2Package.REAL_LITERAL:
			notifyRealLiteralChanged(notification, eClass);
			break;
		case Aadl2Package.OPERATION:
			notifyOperationChanged(notification, eClass);
			break;
		case Aadl2Package.RECORD_VALUE:
			notifyRecordValueChanged(notification, eClass);
			break;
		case Aadl2Package.COMPUTED_VALUE:
			notifyComputedValueChanged(notification, eClass);
			break;
		case Aadl2Package.LIST_VALUE:
			notifyListValueChanged(notification, eClass);
			break;
		case Aadl2Package.NAMED_VALUE:
			notifyNamedValueChanged(notification, eClass);
			break;
		case Aadl2Package.PROPERTY_SET:
			notifyPropertySetChanged(notification, eClass);
			break;
		case Aadl2Package.GLOBAL_NAMESPACE:
			notifyGlobalNamespaceChanged(notification, eClass);
			break;
		case Aadl2Package.AADL_BOOLEAN:
			notifyAadlBooleanChanged(notification, eClass);
			break;
		case Aadl2Package.AADL_STRING:
			notifyAadlStringChanged(notification, eClass);
			break;
		case Aadl2Package.AADL_INTEGER:
			notifyAadlIntegerChanged(notification, eClass);
			break;
		case Aadl2Package.UNITS_TYPE:
			notifyUnitsTypeChanged(notification, eClass);
			break;
		case Aadl2Package.ENUMERATION_TYPE:
			notifyEnumerationTypeChanged(notification, eClass);
			break;
		case Aadl2Package.NUMERIC_RANGE:
			notifyNumericRangeChanged(notification, eClass);
			break;
		case Aadl2Package.AADL_REAL:
			notifyAadlRealChanged(notification, eClass);
			break;
		case Aadl2Package.CLASSIFIER_TYPE:
			notifyClassifierTypeChanged(notification, eClass);
			break;
		case Aadl2Package.RANGE_TYPE:
			notifyRangeTypeChanged(notification, eClass);
			break;
		case Aadl2Package.RECORD_TYPE:
			notifyRecordTypeChanged(notification, eClass);
			break;
		case Aadl2Package.RECORD_FIELD:
			notifyRecordFieldChanged(notification, eClass);
			break;
		case Aadl2Package.REFERENCE_TYPE:
			notifyReferenceTypeChanged(notification, eClass);
			break;
		case Aadl2Package.LIST_TYPE:
			notifyListTypeChanged(notification, eClass);
			break;
		}
	}

	/**
	 * Does nothing; clients may override so that it does something.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @param derivedUnion the derived union affected by the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
		// Do nothing.
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCommentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Comment.class)) {
		case Aadl2Package.COMMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPropertyAssociationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PropertyAssociation.class)) {
		case Aadl2Package.PROPERTY_ASSOCIATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPropertyChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Property.class)) {
		case Aadl2Package.PROPERTY__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBasicPropertyChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BasicProperty.class)) {
		case Aadl2Package.BASIC_PROPERTY__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMetaclassReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MetaclassReference.class)) {
		case Aadl2Package.METACLASS_REFERENCE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModalElementChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModalElement.class)) {
		case Aadl2Package.MODAL_ELEMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Mode.class)) {
		case Aadl2Package.MODE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyContainedNamedElementChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ContainedNamedElement.class)) {
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyContainmentPathElementChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ContainmentPathElement.class)) {
		case Aadl2Package.CONTAINMENT_PATH_ELEMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyArrayRangeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ArrayRange.class)) {
		case Aadl2Package.ARRAY_RANGE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModalPropertyValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModalPropertyValue.class)) {
		case Aadl2Package.MODAL_PROPERTY_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyArrayDimensionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ArrayDimension.class)) {
		case Aadl2Package.ARRAY_DIMENSION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyArraySizeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ArraySize.class)) {
		case Aadl2Package.ARRAY_SIZE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentImplementationReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ComponentImplementationReference.class)) {
		case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModeTransitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModeTransition.class)) {
		case Aadl2Package.MODE_TRANSITION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModeTransitionTriggerChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModeTransitionTrigger.class)) {
		case Aadl2Package.MODE_TRANSITION_TRIGGER__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFlowSpecificationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FlowSpecification.class)) {
		case Aadl2Package.FLOW_SPECIFICATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFlowEndChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FlowEnd.class)) {
		case Aadl2Package.FLOW_END__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTypeExtensionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(TypeExtension.class)) {
		case Aadl2Package.TYPE_EXTENSION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.TYPE_EXTENSION__SOURCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.TYPE_EXTENSION__TARGET:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.TYPE_EXTENSION__GENERAL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.TYPE_EXTENSION__SPECIFIC:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Source());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.TYPE_EXTENSION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getGeneralization_General());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroup.class)) {
		case Aadl2Package.FEATURE_GROUP__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.FEATURE_GROUP__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.FEATURE_GROUP__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroupType.class)) {
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGroupExtensionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GroupExtension.class)) {
		case Aadl2Package.GROUP_EXTENSION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.GROUP_EXTENSION__SOURCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.GROUP_EXTENSION__TARGET:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.GROUP_EXTENSION__GENERAL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.GROUP_EXTENSION__SPECIFIC:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Source());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.GROUP_EXTENSION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getGeneralization_General());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBusAccessChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BusAccess.class)) {
		case Aadl2Package.BUS_ACCESS__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_ACCESS__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.BUS_ACCESS__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.BUS_ACCESS__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataAccessChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataAccess.class)) {
		case Aadl2Package.DATA_ACCESS__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_ACCESS__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.DATA_ACCESS__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.DATA_ACCESS__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.DATA_ACCESS__DATA_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataPortChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataPort.class)) {
		case Aadl2Package.DATA_PORT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_PORT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.DATA_PORT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.DATA_PORT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.DATA_PORT__DATA_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEventDataPortChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EventDataPort.class)) {
		case Aadl2Package.EVENT_DATA_PORT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.EVENT_DATA_PORT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.EVENT_DATA_PORT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.EVENT_DATA_PORT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.EVENT_DATA_PORT__DATA_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEventPortChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EventPort.class)) {
		case Aadl2Package.EVENT_PORT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.EVENT_PORT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.EVENT_PORT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.EVENT_PORT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyParameterChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Parameter.class)) {
		case Aadl2Package.PARAMETER__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PARAMETER__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.PARAMETER__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.PARAMETER__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.PARAMETER__DATA_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramAccessChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramAccess.class)) {
		case Aadl2Package.SUBPROGRAM_ACCESS__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_ACCESS__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.SUBPROGRAM_ACCESS__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.SUBPROGRAM_ACCESS__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.SUBPROGRAM_ACCESS__SUBPROGRAM_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramGroupAccessChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramGroupAccess.class)) {
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAbstractFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AbstractFeature.class)) {
		case Aadl2Package.ABSTRACT_FEATURE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_FEATURE__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		case Aadl2Package.ABSTRACT_FEATURE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.ABSTRACT_FEATURE__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getFeature_FeatureClassifier());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeaturePrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeaturePrototype.class)) {
		case Aadl2Package.FEATURE_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroupPrototype.class)) {
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModeBindingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModeBinding.class)) {
		case Aadl2Package.MODE_BINDING__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFlowImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FlowImplementation.class)) {
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFlowSegmentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FlowSegment.class)) {
		case Aadl2Package.FLOW_SEGMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConnectedElementChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConnectedElement.class)) {
		case Aadl2Package.CONNECTED_ELEMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyImplementationExtensionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ImplementationExtension.class)) {
		case Aadl2Package.IMPLEMENTATION_EXTENSION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.IMPLEMENTATION_EXTENSION__SOURCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.IMPLEMENTATION_EXTENSION__TARGET:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.IMPLEMENTATION_EXTENSION__GENERAL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.IMPLEMENTATION_EXTENSION__SPECIFIC:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Source());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.IMPLEMENTATION_EXTENSION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getGeneralization_General());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRealizationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Realization.class)) {
		case Aadl2Package.REALIZATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.REALIZATION__SOURCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.REALIZATION__TARGET:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.REALIZATION__GENERAL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.REALIZATION__SPECIFIC:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Source());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		case Aadl2Package.REALIZATION__IMPLEMENTED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getGeneralization_General());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getDirectedRelationship_Target());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRelationship_RelatedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEndToEndFlowChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EndToEndFlow.class)) {
		case Aadl2Package.END_TO_END_FLOW__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEndToEndFlowSegmentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EndToEndFlowSegment.class)) {
		case Aadl2Package.END_TO_END_FLOW_SEGMENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAbstractSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AbstractSubcomponent.class)) {
		case Aadl2Package.ABSTRACT_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.ABSTRACT_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.ABSTRACT_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.ABSTRACT_SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAccessConnectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AccessConnection.class)) {
		case Aadl2Package.ACCESS_CONNECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ACCESS_CONNECTION__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyParameterConnectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ParameterConnection.class)) {
		case Aadl2Package.PARAMETER_CONNECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PARAMETER_CONNECTION__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortConnectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortConnection.class)) {
		case Aadl2Package.PORT_CONNECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PORT_CONNECTION__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureConnectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureConnection.class)) {
		case Aadl2Package.FEATURE_CONNECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_CONNECTION__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupConnectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroupConnection.class)) {
		case Aadl2Package.FEATURE_GROUP_CONNECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.FEATURE_GROUP_CONNECTION__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEventSourceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EventSource.class)) {
		case Aadl2Package.EVENT_SOURCE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEventDataSourceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EventDataSource.class)) {
		case Aadl2Package.EVENT_DATA_SOURCE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortProxyChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortProxy.class)) {
		case Aadl2Package.PORT_PROXY__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramProxyChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramProxy.class)) {
		case Aadl2Package.SUBPROGRAM_PROXY__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDefaultAnnexLibraryChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DefaultAnnexLibrary.class)) {
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDefaultAnnexSubclauseChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DefaultAnnexSubclause.class)) {
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPublicPackageSectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PublicPackageSection.class)) {
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackageRenameChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PackageRename.class)) {
		case Aadl2Package.PACKAGE_RENAME__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAadlPackageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AadlPackage.class)) {
		case Aadl2Package.AADL_PACKAGE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.AADL_PACKAGE__OWNED_PUBLIC_SECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.AADL_PACKAGE__OWNED_PRIVATE_SECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPrivatePackageSectionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PrivatePackageSection.class)) {
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PRIVATE_PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentTypeRenameChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ComponentTypeRename.class)) {
		case Aadl2Package.COMPONENT_TYPE_RENAME__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupTypeRenameChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroupTypeRename.class)) {
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentPrototypeBindingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ComponentPrototypeBinding.class)) {
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentPrototypeActualChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ComponentPrototypeActual.class)) {
		case Aadl2Package.COMPONENT_PROTOTYPE_ACTUAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupPrototypeBindingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroupPrototypeBinding.class)) {
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_BINDING__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureGroupPrototypeActualChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureGroupPrototypeActual.class)) {
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeaturePrototypeBindingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeaturePrototypeBinding.class)) {
		case Aadl2Package.FEATURE_PROTOTYPE_BINDING__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAccessSpecificationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AccessSpecification.class)) {
		case Aadl2Package.ACCESS_SPECIFICATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortSpecificationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortSpecification.class)) {
		case Aadl2Package.PORT_SPECIFICATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeaturePrototypeReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeaturePrototypeReference.class)) {
		case Aadl2Package.FEATURE_PROTOTYPE_REFERENCE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramCallSequenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramCallSequence.class)) {
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramCallChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramCall.class)) {
		case Aadl2Package.SUBPROGRAM_CALL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAbstractTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AbstractType.class)) {
		case Aadl2Package.ABSTRACT_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAbstractImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AbstractImplementation.class)) {
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__SUBPROGRAM_CALL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBusSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BusSubcomponent.class)) {
		case Aadl2Package.BUS_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.BUS_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.BUS_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.BUS_SUBCOMPONENT__BUS_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataSubcomponent.class)) {
		case Aadl2Package.DATA_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.DATA_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.DATA_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.DATA_SUBCOMPONENT__DATA_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeviceSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DeviceSubcomponent.class)) {
		case Aadl2Package.DEVICE_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.DEVICE_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.DEVICE_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.DEVICE_SUBCOMPONENT__DEVICE_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMemorySubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MemorySubcomponent.class)) {
		case Aadl2Package.MEMORY_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.MEMORY_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.MEMORY_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.MEMORY_SUBCOMPONENT__MEMORY_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessSubcomponent.class)) {
		case Aadl2Package.PROCESS_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.PROCESS_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.PROCESS_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.PROCESS_SUBCOMPONENT__PROCESS_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessorSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessorSubcomponent.class)) {
		case Aadl2Package.PROCESSOR_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.PROCESSOR_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.PROCESSOR_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.PROCESSOR_SUBCOMPONENT__PROCESSOR_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySystemSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SystemSubcomponent.class)) {
		case Aadl2Package.SYSTEM_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.SYSTEM_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.SYSTEM_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.SYSTEM_SUBCOMPONENT__SYSTEM_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramSubcomponent.class)) {
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.SUBPROGRAM_SUBCOMPONENT__SUBPROGRAM_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramGroupSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramGroupSubcomponent.class)) {
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadSubcomponent.class)) {
		case Aadl2Package.THREAD_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.THREAD_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.THREAD_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.THREAD_SUBCOMPONENT__THREAD_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadGroupSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadGroupSubcomponent.class)) {
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.THREAD_GROUP_SUBCOMPONENT__THREAD_GROUP_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualBusSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualBusSubcomponent.class)) {
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT__VIRTUAL_BUS_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualProcessorSubcomponentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualProcessorSubcomponent.class)) {
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT__PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT__CLASSIFIER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT__VIRTUAL_PROCESSOR_SUBCOMPONENT_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAbstractPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AbstractPrototype.class)) {
		case Aadl2Package.ABSTRACT_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ABSTRACT_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBusTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BusType.class)) {
		case Aadl2Package.BUS_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBusImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BusImplementation.class)) {
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.BUS_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBusPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BusPrototype.class)) {
		case Aadl2Package.BUS_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.BUS_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataType.class)) {
		case Aadl2Package.DATA_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataImplementation.class)) {
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataPrototype.class)) {
		case Aadl2Package.DATA_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DATA_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeviceTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DeviceType.class)) {
		case Aadl2Package.DEVICE_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeviceImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DeviceImplementation.class)) {
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDevicePrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DevicePrototype.class)) {
		case Aadl2Package.DEVICE_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.DEVICE_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMemoryTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MemoryType.class)) {
		case Aadl2Package.MEMORY_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMemoryImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MemoryImplementation.class)) {
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMemoryPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MemoryPrototype.class)) {
		case Aadl2Package.MEMORY_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.MEMORY_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramType.class)) {
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramImplementation.class)) {
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__SUBPROGRAM_CALL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramPrototype.class)) {
		case Aadl2Package.SUBPROGRAM_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramGroupTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramGroupType.class)) {
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramGroupImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramGroupImplementation.class)) {
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubprogramGroupPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubprogramGroupPrototype.class)) {
		case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySystemTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SystemType.class)) {
		case Aadl2Package.SYSTEM_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySystemImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SystemImplementation.class)) {
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySystemPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SystemPrototype.class)) {
		case Aadl2Package.SYSTEM_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.SYSTEM_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessorTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessorType.class)) {
		case Aadl2Package.PROCESSOR_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_BUS_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessorImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessorImplementation.class)) {
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessorPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessorPrototype.class)) {
		case Aadl2Package.PROCESSOR_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESSOR_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessType.class)) {
		case Aadl2Package.PROCESS_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessImplementation.class)) {
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProcessPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ProcessPrototype.class)) {
		case Aadl2Package.PROCESS_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROCESS_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadType.class)) {
		case Aadl2Package.THREAD_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadImplementation.class)) {
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__SUBPROGRAM_CALL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadPrototype.class)) {
		case Aadl2Package.THREAD_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadGroupTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadGroupType.class)) {
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_DATA_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadGroupImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadGroupImplementation.class)) {
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyThreadGroupPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ThreadGroupPrototype.class)) {
		case Aadl2Package.THREAD_GROUP_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.THREAD_GROUP_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualBusTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualBusType.class)) {
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualBusImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualBusImplementation.class)) {
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualBusPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualBusPrototype.class)) {
		case Aadl2Package.VIRTUAL_BUS_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_BUS_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualProcessorTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualProcessorType.class)) {
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_FLOW_SPECIFICATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_FEATURE_GROUP:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_ABSTRACT_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_EVENT_DATA_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_EVENT_PORT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_SUBPROGRAM_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualProcessorImplementationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualProcessorImplementation.class)) {
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__CLASSIFIER_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__INHERITED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__GENERALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_PROTOTYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_MODE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_MODE_TRANSITION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__EXTENDED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_General());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_EXTENSION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_REALIZATION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_Generalization());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_PORT_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			notifyChanged(notification, eClass,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVirtualProcessorPrototypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VirtualProcessorPrototype.class)) {
		case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE__REFINED:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBasicPropertyAssociationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BasicPropertyAssociation.class)) {
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPropertyConstantChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PropertyConstant.class)) {
		case Aadl2Package.PROPERTY_CONSTANT__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStringLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(StringLiteral.class)) {
		case Aadl2Package.STRING_LITERAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUnitLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(UnitLiteral.class)) {
		case Aadl2Package.UNIT_LITERAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEnumerationLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EnumerationLiteral.class)) {
		case Aadl2Package.ENUMERATION_LITERAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyClassifierValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ClassifierValue.class)) {
		case Aadl2Package.CLASSIFIER_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyReferenceValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ReferenceValue.class)) {
		case Aadl2Package.REFERENCE_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBooleanLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BooleanLiteral.class)) {
		case Aadl2Package.BOOLEAN_LITERAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRangeValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RangeValue.class)) {
		case Aadl2Package.RANGE_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyIntegerLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(IntegerLiteral.class)) {
		case Aadl2Package.INTEGER_LITERAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRealLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RealLiteral.class)) {
		case Aadl2Package.REAL_LITERAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOperationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Operation.class)) {
		case Aadl2Package.OPERATION__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRecordValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RecordValue.class)) {
		case Aadl2Package.RECORD_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComputedValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ComputedValue.class)) {
		case Aadl2Package.COMPUTED_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyListValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ListValue.class)) {
		case Aadl2Package.LIST_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNamedValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(NamedValue.class)) {
		case Aadl2Package.NAMED_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPropertySetChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PropertySet.class)) {
		case Aadl2Package.PROPERTY_SET__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.PROPERTY_SET__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGlobalNamespaceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GlobalNamespace.class)) {
		case Aadl2Package.GLOBAL_NAMESPACE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.GLOBAL_NAMESPACE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.GLOBAL_NAMESPACE__PACKAGE:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAadlBooleanChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AadlBoolean.class)) {
		case Aadl2Package.AADL_BOOLEAN__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAadlStringChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AadlString.class)) {
		case Aadl2Package.AADL_STRING__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAadlIntegerChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AadlInteger.class)) {
		case Aadl2Package.AADL_INTEGER__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUnitsTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(UnitsType.class)) {
		case Aadl2Package.UNITS_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.UNITS_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.UNITS_TYPE__OWNED_LITERAL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEnumerationTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EnumerationType.class)) {
		case Aadl2Package.ENUMERATION_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.ENUMERATION_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNumericRangeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(NumericRange.class)) {
		case Aadl2Package.NUMERIC_RANGE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAadlRealChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AadlReal.class)) {
		case Aadl2Package.AADL_REAL__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyClassifierTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ClassifierType.class)) {
		case Aadl2Package.CLASSIFIER_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRangeTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RangeType.class)) {
		case Aadl2Package.RANGE_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRecordTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RecordType.class)) {
		case Aadl2Package.RECORD_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		case Aadl2Package.RECORD_TYPE__OWNED_MEMBER:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		case Aadl2Package.RECORD_TYPE__OWNED_FIELD:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getNamespace_Member());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRecordFieldChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RecordField.class)) {
		case Aadl2Package.RECORD_FIELD__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyReferenceTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ReferenceType.class)) {
		case Aadl2Package.REFERENCE_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyListTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ListType.class)) {
		case Aadl2Package.LIST_TYPE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

} // Aadl2DerivedUnionAdapter
