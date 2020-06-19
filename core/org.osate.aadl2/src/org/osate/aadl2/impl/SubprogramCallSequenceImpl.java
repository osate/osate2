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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.operations.ModalElementOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Call Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramCallSequenceImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramCallSequenceImpl#getOwnedSubprogramCalls <em>Owned Subprogram Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubprogramCallSequenceImpl extends BehavioralFeatureImpl implements SubprogramCallSequence {
	/**
	 * The cached value of the '{@link #getInModes() <em>In Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModes()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> inModes;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramCalls() <em>Owned Subprogram Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramCalls()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramCall> ownedSubprogramCalls;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramCallSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramCallSequence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<Mode>(Mode.class, this, Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramCall> getOwnedSubprogramCalls() {
		if (ownedSubprogramCalls == null) {
			ownedSubprogramCalls = new EObjectContainmentEList<SubprogramCall>(SubprogramCall.class, this,
					Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_SUBPROGRAM_CALL);
		}
		return ownedSubprogramCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramCall createOwnedSubprogramCall() {
		SubprogramCall newOwnedSubprogramCall = (SubprogramCall) create(Aadl2Package.eINSTANCE.getSubprogramCall());
		getOwnedSubprogramCalls().add(newOwnedSubprogramCall);
		return newOwnedSubprogramCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getAllInModes() {
		return ModalElementOperations.getAllInModes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_SUBPROGRAM_CALL:
			return ((InternalEList<?>) getOwnedSubprogramCalls()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE:
			return getInModes();
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_SUBPROGRAM_CALL:
			return getOwnedSubprogramCalls();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_SUBPROGRAM_CALL:
			getOwnedSubprogramCalls().clear();
			getOwnedSubprogramCalls().addAll((Collection<? extends SubprogramCall>) newValue);
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
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_SUBPROGRAM_CALL:
			getOwnedSubprogramCalls().clear();
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
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__OWNED_SUBPROGRAM_CALL:
			return ownedSubprogramCalls != null && !ownedSubprogramCalls.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_ELEMENT__IN_MODE:
				return Aadl2Package.SUBPROGRAM_CALL_SEQUENCE__IN_MODE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
} // SubprogramCallSequenceImpl
