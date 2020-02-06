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
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Mode;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getSrcModeTransitions <em>Src Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getDstModeTransitions <em>Dst Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getParents <em>Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeInstanceImpl extends InstanceObjectImpl implements ModeInstance {
	/**
	 * The cached value of the '{@link #getSrcModeTransitions() <em>Src Mode Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> srcModeTransitions;

	/**
	 * The cached value of the '{@link #getDstModeTransitions() <em>Dst Mode Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> dstModeTransitions;

	/**
	 * The default value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
	protected boolean initial = INITIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected Mode mode;

	/**
	 * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParents() <em>Parent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> parents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.MODE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransitionInstance> getSrcModeTransitions() {
		if (srcModeTransitions == null) {
			srcModeTransitions = new EObjectWithInverseEList<ModeTransitionInstance>(ModeTransitionInstance.class, this,
					InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION,
					InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE);
		}
		return srcModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransitionInstance> getDstModeTransitions() {
		if (dstModeTransitions == null) {
			dstModeTransitions = new EObjectWithInverseEList<ModeTransitionInstance>(ModeTransitionInstance.class, this,
					InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION,
					InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION);
		}
		return dstModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getMode() {
		if (mode != null && ((EObject) mode).eIsProxy()) {
			InternalEObject oldMode = (InternalEObject) mode;
			mode = (Mode) eResolveProxy(oldMode);
			if (mode != oldMode) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InstancePackage.MODE_INSTANCE__MODE,
							oldMode, mode));
				}
			}
		}
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_INSTANCE__MODE, oldMode, mode));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_INSTANCE__DERIVED, oldDerived,
					derived));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeInstance> getParents() {
		if (parents == null) {
			parents = new EObjectResolvingEList<ModeInstance>(ModeInstance.class, this,
					InstancePackage.MODE_INSTANCE__PARENT);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSrcModeTransitions()).basicAdd(otherEnd,
					msgs);
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDstModeTransitions()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return ((InternalEList<?>) getSrcModeTransitions()).basicRemove(otherEnd, msgs);
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return ((InternalEList<?>) getDstModeTransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(boolean newInitial) {
		boolean oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_INSTANCE__INITIAL, oldInitial,
					initial));
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return getSrcModeTransitions();
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return getDstModeTransitions();
		case InstancePackage.MODE_INSTANCE__INITIAL:
			return isInitial();
		case InstancePackage.MODE_INSTANCE__MODE:
			if (resolve) {
				return getMode();
			}
			return basicGetMode();
		case InstancePackage.MODE_INSTANCE__DERIVED:
			return isDerived();
		case InstancePackage.MODE_INSTANCE__PARENT:
			return getParents();
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			getSrcModeTransitions().clear();
			getSrcModeTransitions().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			getDstModeTransitions().clear();
			getDstModeTransitions().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__INITIAL:
			setInitial((Boolean) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__MODE:
			setMode((Mode) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__DERIVED:
			setDerived((Boolean) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__PARENT:
			getParents().clear();
			getParents().addAll((Collection<? extends ModeInstance>) newValue);
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			getSrcModeTransitions().clear();
			return;
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			getDstModeTransitions().clear();
			return;
		case InstancePackage.MODE_INSTANCE__INITIAL:
			setInitial(INITIAL_EDEFAULT);
			return;
		case InstancePackage.MODE_INSTANCE__MODE:
			setMode((Mode) null);
			return;
		case InstancePackage.MODE_INSTANCE__DERIVED:
			setDerived(DERIVED_EDEFAULT);
			return;
		case InstancePackage.MODE_INSTANCE__PARENT:
			getParents().clear();
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return srcModeTransitions != null && !srcModeTransitions.isEmpty();
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return dstModeTransitions != null && !dstModeTransitions.isEmpty();
		case InstancePackage.MODE_INSTANCE__INITIAL:
			return initial != INITIAL_EDEFAULT;
		case InstancePackage.MODE_INSTANCE__MODE:
			return mode != null;
		case InstancePackage.MODE_INSTANCE__DERIVED:
			return derived != DERIVED_EDEFAULT;
		case InstancePackage.MODE_INSTANCE__PARENT:
			return parents != null && !parents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (initial: "); //$NON-NLS-1$
		result.append(initial);
		result.append(", derived: "); //$NON-NLS-1$
		result.append(derived);
		result.append(')');
		return result.toString();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public List<Mode> getInstantiatedObjects() {
		return Collections.singletonList(getMode());
	}

	public boolean isActive(SystemOperationMode som) {
		return getContainingComponentInstance().isActive(som);
	}

} // ModeInstanceImpl
