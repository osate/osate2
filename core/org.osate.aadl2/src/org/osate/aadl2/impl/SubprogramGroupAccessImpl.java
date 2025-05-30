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
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Group Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramGroupAccessImpl#getFeatureClassifier <em>Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramGroupAccessImpl#getSubprogramGroupFeatureClassifier <em>Subprogram Group Feature Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubprogramGroupAccessImpl extends AccessImpl implements SubprogramGroupAccess {
	/**
	 * The cached value of the '{@link #getSubprogramGroupFeatureClassifier() <em>Subprogram Group Feature Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprogramGroupFeatureClassifier()
	 * @generated
	 * @ordered
	 */
	protected SubprogramGroupSubcomponentType subprogramGroupFeatureClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramGroupAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramGroupAccess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public FeatureClassifier basicGetFeatureClassifier() {
		if (eIsSet(Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER)) {
			return basicGetSubprogramGroupFeatureClassifier();
		}
		return super.basicGetFeatureClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramGroupSubcomponentType getSubprogramGroupFeatureClassifier() {
		if (subprogramGroupFeatureClassifier != null && ((EObject) subprogramGroupFeatureClassifier).eIsProxy()) {
			InternalEObject oldSubprogramGroupFeatureClassifier = (InternalEObject) subprogramGroupFeatureClassifier;
			subprogramGroupFeatureClassifier = (SubprogramGroupSubcomponentType) eResolveProxy(
					oldSubprogramGroupFeatureClassifier);
			if (subprogramGroupFeatureClassifier != oldSubprogramGroupFeatureClassifier) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER,
							oldSubprogramGroupFeatureClassifier, subprogramGroupFeatureClassifier));
				}
			}
		}
		return subprogramGroupFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupSubcomponentType basicGetSubprogramGroupFeatureClassifier() {
		return subprogramGroupFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubprogramGroupFeatureClassifier(
			SubprogramGroupSubcomponentType newSubprogramGroupFeatureClassifier) {
		SubprogramGroupSubcomponentType oldSubprogramGroupFeatureClassifier = subprogramGroupFeatureClassifier;
		subprogramGroupFeatureClassifier = newSubprogramGroupFeatureClassifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER,
					oldSubprogramGroupFeatureClassifier, subprogramGroupFeatureClassifier));
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
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER:
			if (resolve) {
				return getSubprogramGroupFeatureClassifier();
			}
			return basicGetSubprogramGroupFeatureClassifier();
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
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER:
			setSubprogramGroupFeatureClassifier((SubprogramGroupSubcomponentType) newValue);
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
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER:
			setSubprogramGroupFeatureClassifier((SubprogramGroupSubcomponentType) null);
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
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__FEATURE_CLASSIFIER:
			return isSetFeatureClassifier();
		case Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER:
			return subprogramGroupFeatureClassifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFeatureClassifier() {
		return super.isSetFeatureClassifier()
				|| eIsSet(Aadl2Package.SUBPROGRAM_GROUP_ACCESS__SUBPROGRAM_GROUP_FEATURE_CLASSIFIER);
	}

} // SubprogramGroupAccessImpl
