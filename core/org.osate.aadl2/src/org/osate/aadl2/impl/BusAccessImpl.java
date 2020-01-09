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
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusFeatureClassifier;
import org.osate.aadl2.FeatureClassifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BusAccessImpl#getFeatureClassifier <em>Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BusAccessImpl#getBusFeatureClassifier <em>Bus Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BusAccessImpl#isVirtual <em>Virtual</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusAccessImpl extends AccessImpl implements BusAccess {
	/**
	 * The cached value of the '{@link #getBusFeatureClassifier() <em>Bus Feature Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusFeatureClassifier()
	 * @generated
	 * @ordered
	 */
	protected BusFeatureClassifier busFeatureClassifier;

	/**
	 * The default value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIRTUAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean virtual = VIRTUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBusAccess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureClassifier getFeatureClassifier() {
		FeatureClassifier featureClassifier = basicGetFeatureClassifier();
		return featureClassifier != null && ((EObject) featureClassifier).eIsProxy()
				? (FeatureClassifier) eResolveProxy((InternalEObject) featureClassifier)
				: featureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureClassifier basicGetFeatureClassifier() {
		if (eIsSet(Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER)) {
			return basicGetBusFeatureClassifier();
		}
		return super.basicGetFeatureClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusFeatureClassifier getBusFeatureClassifier() {
		if (busFeatureClassifier != null && ((EObject) busFeatureClassifier).eIsProxy()) {
			InternalEObject oldBusFeatureClassifier = (InternalEObject) busFeatureClassifier;
			busFeatureClassifier = (BusFeatureClassifier) eResolveProxy(oldBusFeatureClassifier);
			if (busFeatureClassifier != oldBusFeatureClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER, oldBusFeatureClassifier,
							busFeatureClassifier));
			}
		}
		return busFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusFeatureClassifier basicGetBusFeatureClassifier() {
		return busFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusFeatureClassifier(BusFeatureClassifier newBusFeatureClassifier) {
		BusFeatureClassifier oldBusFeatureClassifier = busFeatureClassifier;
		busFeatureClassifier = newBusFeatureClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER,
					oldBusFeatureClassifier, busFeatureClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVirtual() {
		return virtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtual(boolean newVirtual) {
		boolean oldVirtual = virtual;
		virtual = newVirtual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BUS_ACCESS__VIRTUAL, oldVirtual,
					virtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			if (resolve)
				return getBusFeatureClassifier();
			return basicGetBusFeatureClassifier();
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			return isVirtual();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			setBusFeatureClassifier((BusFeatureClassifier) newValue);
			return;
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			setVirtual((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			setBusFeatureClassifier((BusFeatureClassifier) null);
			return;
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			setVirtual(VIRTUAL_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.BUS_ACCESS__FEATURE_CLASSIFIER:
			return isSetFeatureClassifier();
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			return busFeatureClassifier != null;
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			return virtual != VIRTUAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (virtual: ");
		result.append(virtual);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatureClassifier() {
		return super.isSetFeatureClassifier() || eIsSet(Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER);
	}

} // BusAccessImpl
