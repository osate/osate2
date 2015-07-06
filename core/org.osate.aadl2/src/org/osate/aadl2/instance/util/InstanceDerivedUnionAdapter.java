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
