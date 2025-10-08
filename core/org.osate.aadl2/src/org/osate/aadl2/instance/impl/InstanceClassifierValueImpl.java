/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *
 */
package org.osate.aadl2.instance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.impl.ClassifierValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceClassifierValue;
import org.osate.aadl2.instance.InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.InstanceClassifierValueImpl#getInstantiatedClassifier <em>Instantiated Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceClassifierValueImpl extends ClassifierValueImpl implements InstanceClassifierValue {
	/**
	 * The cached value of the '{@link #getInstantiatedClassifier() <em>Instantiated Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiatedClassifier()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance instantiatedClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceClassifierValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.INSTANCE_CLASSIFIER_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInstance getInstantiatedClassifier() {
		if (instantiatedClassifier != null && instantiatedClassifier.eIsProxy()) {
			InternalEObject oldInstantiatedClassifier = (InternalEObject) instantiatedClassifier;
			instantiatedClassifier = (ComponentInstance) eResolveProxy(oldInstantiatedClassifier);
			if (instantiatedClassifier != oldInstantiatedClassifier) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.INSTANCE_CLASSIFIER_VALUE__INSTANTIATED_CLASSIFIER,
							oldInstantiatedClassifier, instantiatedClassifier));
				}
			}
		}
		return instantiatedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetInstantiatedClassifier() {
		return instantiatedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstantiatedClassifier(ComponentInstance newInstantiatedClassifier) {
		ComponentInstance oldInstantiatedClassifier = instantiatedClassifier;
		instantiatedClassifier = newInstantiatedClassifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.INSTANCE_CLASSIFIER_VALUE__INSTANTIATED_CLASSIFIER, oldInstantiatedClassifier,
					instantiatedClassifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.INSTANCE_CLASSIFIER_VALUE__INSTANTIATED_CLASSIFIER:
			if (resolve) {
				return getInstantiatedClassifier();
			}
			return basicGetInstantiatedClassifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.INSTANCE_CLASSIFIER_VALUE__INSTANTIATED_CLASSIFIER:
			setInstantiatedClassifier((ComponentInstance) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstancePackage.INSTANCE_CLASSIFIER_VALUE__INSTANTIATED_CLASSIFIER:
			setInstantiatedClassifier((ComponentInstance) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstancePackage.INSTANCE_CLASSIFIER_VALUE__INSTANTIATED_CLASSIFIER:
			return instantiatedClassifier != null;
		}
		return super.eIsSet(featureID);
	}

} // InstanceClassifierValueImpl
