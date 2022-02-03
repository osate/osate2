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
package org.osate.aadl2.errormodel.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Set Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl#getResolvedSet <em>Resolved Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl#getDeclaredSet <em>Declared Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeSetInstanceImpl extends TypeTokenInstanceImpl implements TypeSetInstance {
	/**
	 * The cached value of the '{@link #getResolvedSet() <em>Resolved Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedSet()
	 * @generated
	 * @ordered
	 */
	protected TypeSet resolvedSet;

	/**
	 * The cached value of the '{@link #getDeclaredSet() <em>Declared Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredSet()
	 * @generated
	 * @ordered
	 */
	protected TypeSet declaredSet;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeTokenInstance> tokens;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeSetInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.TYPE_SET_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeSet getResolvedSet() {
		if (resolvedSet != null && resolvedSet.eIsProxy()) {
			InternalEObject oldResolvedSet = (InternalEObject) resolvedSet;
			resolvedSet = (TypeSet) eResolveProxy(oldResolvedSet);
			if (resolvedSet != oldResolvedSet) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.TYPE_SET_INSTANCE__RESOLVED_SET, oldResolvedSet, resolvedSet));
				}
			}
		}
		return resolvedSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSet basicGetResolvedSet() {
		return resolvedSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResolvedSet(TypeSet newResolvedSet) {
		TypeSet oldResolvedSet = resolvedSet;
		resolvedSet = newResolvedSet;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.TYPE_SET_INSTANCE__RESOLVED_SET,
					oldResolvedSet, resolvedSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeSet getDeclaredSet() {
		if (declaredSet != null && declaredSet.eIsProxy()) {
			InternalEObject oldDeclaredSet = (InternalEObject) declaredSet;
			declaredSet = (TypeSet) eResolveProxy(oldDeclaredSet);
			if (declaredSet != oldDeclaredSet) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.TYPE_SET_INSTANCE__DECLARED_SET, oldDeclaredSet, declaredSet));
				}
			}
		}
		return declaredSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSet basicGetDeclaredSet() {
		return declaredSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclaredSet(TypeSet newDeclaredSet) {
		TypeSet oldDeclaredSet = declaredSet;
		declaredSet = newDeclaredSet;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.TYPE_SET_INSTANCE__DECLARED_SET,
					oldDeclaredSet, declaredSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeTokenInstance> getTokens() {
		if (tokens == null) {
			tokens = new EObjectContainmentEList<>(TypeTokenInstance.class, this,
					EMV2InstancePackage.TYPE_SET_INSTANCE__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.TYPE_SET_INSTANCE__TOKENS:
			return ((InternalEList<?>) getTokens()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EMV2InstancePackage.TYPE_SET_INSTANCE__RESOLVED_SET:
			if (resolve) {
				return getResolvedSet();
			}
			return basicGetResolvedSet();
		case EMV2InstancePackage.TYPE_SET_INSTANCE__DECLARED_SET:
			if (resolve) {
				return getDeclaredSet();
			}
			return basicGetDeclaredSet();
		case EMV2InstancePackage.TYPE_SET_INSTANCE__TOKENS:
			return getTokens();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EMV2InstancePackage.TYPE_SET_INSTANCE__RESOLVED_SET:
			setResolvedSet((TypeSet) newValue);
			return;
		case EMV2InstancePackage.TYPE_SET_INSTANCE__DECLARED_SET:
			setDeclaredSet((TypeSet) newValue);
			return;
		case EMV2InstancePackage.TYPE_SET_INSTANCE__TOKENS:
			getTokens().clear();
			getTokens().addAll((Collection<? extends TypeTokenInstance>) newValue);
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
		case EMV2InstancePackage.TYPE_SET_INSTANCE__RESOLVED_SET:
			setResolvedSet((TypeSet) null);
			return;
		case EMV2InstancePackage.TYPE_SET_INSTANCE__DECLARED_SET:
			setDeclaredSet((TypeSet) null);
			return;
		case EMV2InstancePackage.TYPE_SET_INSTANCE__TOKENS:
			getTokens().clear();
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
		case EMV2InstancePackage.TYPE_SET_INSTANCE__RESOLVED_SET:
			return resolvedSet != null;
		case EMV2InstancePackage.TYPE_SET_INSTANCE__DECLARED_SET:
			return declaredSet != null;
		case EMV2InstancePackage.TYPE_SET_INSTANCE__TOKENS:
			return tokens != null && !tokens.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // TypeSetInstanceImpl
