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
package org.osate.analysis.modes.modemodel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.InternalFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.modes.modemodel.InternalTrigger#getInternalFeature <em>Internal Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalTrigger extends Trigger {
	/**
	 * The cached value of the '{@link #getInternalFeature() <em>Internal Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalFeature()
	 * @generated
	 * @ordered
	 */
	protected InternalFeature internalFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalTrigger() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModemodelPackage.Literals.INTERNAL_TRIGGER;
	}

	/**
	 * Returns the value of the '<em><b>Internal Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Feature</em>' reference.
	 * @see #setInternalFeature(InternalFeature)
	 * @generated
	 */
	public InternalFeature getInternalFeature() {
		if (internalFeature != null && ((EObject) internalFeature).eIsProxy()) {
			InternalEObject oldInternalFeature = (InternalEObject) internalFeature;
			internalFeature = (InternalFeature) eResolveProxy(oldInternalFeature);
			if (internalFeature != oldInternalFeature) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModemodelPackage.INTERNAL_TRIGGER__INTERNAL_FEATURE, oldInternalFeature, internalFeature));
				}
			}
		}
		return internalFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalFeature basicGetInternalFeature() {
		return internalFeature;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.InternalTrigger#getInternalFeature <em>Internal Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newInternalFeature the new value of the '<em>Internal Feature</em>' reference.
	 * @see #getInternalFeature()
	 * @generated
	 */
	public void setInternalFeature(InternalFeature newInternalFeature) {
		InternalFeature oldInternalFeature = internalFeature;
		internalFeature = newInternalFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.INTERNAL_TRIGGER__INTERNAL_FEATURE,
					oldInternalFeature, internalFeature));
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
		case ModemodelPackage.INTERNAL_TRIGGER__INTERNAL_FEATURE:
			if (resolve) {
				return getInternalFeature();
			}
			return basicGetInternalFeature();
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
		case ModemodelPackage.INTERNAL_TRIGGER__INTERNAL_FEATURE:
			setInternalFeature((InternalFeature) newValue);
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
		case ModemodelPackage.INTERNAL_TRIGGER__INTERNAL_FEATURE:
			setInternalFeature((InternalFeature) null);
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
		case ModemodelPackage.INTERNAL_TRIGGER__INTERNAL_FEATURE:
			return internalFeature != null;
		}
		return super.eIsSet(featureID);
	}

} // InternalTrigger
