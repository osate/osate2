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
package org.osate.aadl2.instance.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osate.aadl2.Aadl2Package;
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

/**
 * <!-- begin-user-doc -->
 * An adapter that propagates notifications for derived unions.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.instance.InstancePackage
 * @generated
 */
public class InstanceDerivedUnionAdapter extends AdapterImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InstancePackage modelPackage;

	/**
	 * Creates an instance of the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceDerivedUnionAdapter() {
		if (modelPackage == null) {
			modelPackage = InstancePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> with the appropriate model class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @generated
	 */
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
		case InstancePackage.FEATURE_INSTANCE:
			notifyFeatureInstanceChanged(notification, eClass);
			break;
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE:
			notifyPropertyAssociationInstanceChanged(notification, eClass);
			break;
		case InstancePackage.CONNECTION_INSTANCE:
			notifyConnectionInstanceChanged(notification, eClass);
			break;
		case InstancePackage.SYSTEM_OPERATION_MODE:
			notifySystemOperationModeChanged(notification, eClass);
			break;
		case InstancePackage.MODE_INSTANCE:
			notifyModeInstanceChanged(notification, eClass);
			break;
		case InstancePackage.MODE_TRANSITION_INSTANCE:
			notifyModeTransitionInstanceChanged(notification, eClass);
			break;
		case InstancePackage.CONNECTION_REFERENCE:
			notifyConnectionReferenceChanged(notification, eClass);
			break;
		case InstancePackage.COMPONENT_INSTANCE:
			notifyComponentInstanceChanged(notification, eClass);
			break;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE:
			notifyFlowSpecificationInstanceChanged(notification, eClass);
			break;
		case InstancePackage.END_TO_END_FLOW_INSTANCE:
			notifyEndToEndFlowInstanceChanged(notification, eClass);
			break;
		case InstancePackage.SYSTEM_INSTANCE:
			notifySystemInstanceChanged(notification, eClass);
			break;
		case InstancePackage.INSTANCE_REFERENCE_VALUE:
			notifyInstanceReferenceValueChanged(notification, eClass);
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
	protected void notifyFeatureInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureInstance.class)) {
		case InstancePackage.FEATURE_INSTANCE__OWNED_COMMENT:
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
	protected void notifyPropertyAssociationInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PropertyAssociationInstance.class)) {
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__OWNED_COMMENT:
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
	protected void notifyConnectionInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConnectionInstance.class)) {
		case InstancePackage.CONNECTION_INSTANCE__OWNED_COMMENT:
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
	protected void notifySystemOperationModeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SystemOperationMode.class)) {
		case InstancePackage.SYSTEM_OPERATION_MODE__OWNED_COMMENT:
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
	protected void notifyModeInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModeInstance.class)) {
		case InstancePackage.MODE_INSTANCE__OWNED_COMMENT:
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
	protected void notifyModeTransitionInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ModeTransitionInstance.class)) {
		case InstancePackage.MODE_TRANSITION_INSTANCE__OWNED_COMMENT:
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
	protected void notifyConnectionReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConnectionReference.class)) {
		case InstancePackage.CONNECTION_REFERENCE__OWNED_COMMENT:
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
	protected void notifyComponentInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ComponentInstance.class)) {
		case InstancePackage.COMPONENT_INSTANCE__OWNED_COMMENT:
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
	protected void notifyFlowSpecificationInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FlowSpecificationInstance.class)) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__OWNED_COMMENT:
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
	protected void notifyEndToEndFlowInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EndToEndFlowInstance.class)) {
		case InstancePackage.END_TO_END_FLOW_INSTANCE__OWNED_COMMENT:
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
	protected void notifySystemInstanceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SystemInstance.class)) {
		case InstancePackage.SYSTEM_INSTANCE__OWNED_COMMENT:
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
	protected void notifyInstanceReferenceValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(InstanceReferenceValue.class)) {
		case InstancePackage.INSTANCE_REFERENCE_VALUE__OWNED_COMMENT:
			notifyChanged(notification, eClass, Aadl2Package.eINSTANCE.getElement_OwnedElement());
			break;
		}
	}

} // InstanceDerivedUnionAdapter
