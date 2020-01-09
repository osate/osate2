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
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ModeBindingImpl#getParentMode <em>Parent Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ModeBindingImpl#getDerivedMode <em>Derived Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeBindingImpl extends ElementImpl implements ModeBinding {
	/**
	 * The cached value of the '{@link #getParentMode() <em>Parent Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentMode()
	 * @generated
	 * @ordered
	 */
	protected Mode parentMode;

	/**
	 * The cached value of the '{@link #getDerivedMode() <em>Derived Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedMode()
	 * @generated
	 * @ordered
	 */
	protected Mode derivedMode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getModeBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getParentMode() {
		if (parentMode != null && ((EObject) parentMode).eIsProxy()) {
			InternalEObject oldParentMode = (InternalEObject) parentMode;
			parentMode = (Mode) eResolveProxy(oldParentMode);
			if (parentMode != oldParentMode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_BINDING__PARENT_MODE,
							oldParentMode, parentMode));
			}
		}
		return parentMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetParentMode() {
		return parentMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentMode(Mode newParentMode) {
		Mode oldParentMode = parentMode;
		parentMode = newParentMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_BINDING__PARENT_MODE, oldParentMode,
					parentMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getDerivedMode() {
		if (derivedMode != null && ((EObject) derivedMode).eIsProxy()) {
			InternalEObject oldDerivedMode = (InternalEObject) derivedMode;
			derivedMode = (Mode) eResolveProxy(oldDerivedMode);
			if (derivedMode != oldDerivedMode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_BINDING__DERIVED_MODE,
							oldDerivedMode, derivedMode));
			}
		}
		return derivedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetDerivedMode() {
		return derivedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedMode(Mode newDerivedMode) {
		Mode oldDerivedMode = derivedMode;
		derivedMode = newDerivedMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_BINDING__DERIVED_MODE,
					oldDerivedMode, derivedMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			if (resolve)
				return getParentMode();
			return basicGetParentMode();
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			if (resolve)
				return getDerivedMode();
			return basicGetDerivedMode();
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
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			setParentMode((Mode) newValue);
			return;
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			setDerivedMode((Mode) newValue);
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
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			setParentMode((Mode) null);
			return;
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			setDerivedMode((Mode) null);
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
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			return parentMode != null;
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			return derivedMode != null;
		}
		return super.eIsSet(featureID);
	}

} // ModeBindingImpl
