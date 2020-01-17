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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ModeTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ModeTransitionImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ModeTransitionImpl#getOwnedTriggers <em>Owned Trigger</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeTransitionImpl extends ModeFeatureImpl implements ModeTransition {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Mode source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Mode destination;

	/**
	 * The cached value of the '{@link #getOwnedTriggers() <em>Owned Trigger</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionTrigger> ownedTriggers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getModeTransition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getSource() {
		if (source != null && ((EObject) source).eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Mode) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_TRANSITION__SOURCE,
							oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Mode newSource) {
		Mode oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_TRANSITION__SOURCE, oldSource,
					source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getDestination() {
		if (destination != null && ((EObject) destination).eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (Mode) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_TRANSITION__DESTINATION,
							oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Mode newDestination) {
		Mode oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_TRANSITION__DESTINATION,
					oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransitionTrigger> getOwnedTriggers() {
		if (ownedTriggers == null) {
			ownedTriggers = new EObjectContainmentEList<ModeTransitionTrigger>(ModeTransitionTrigger.class, this,
					Aadl2Package.MODE_TRANSITION__OWNED_TRIGGER);
		}
		return ownedTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeTransitionTrigger createOwnedTrigger() {
		ModeTransitionTrigger newOwnedTrigger = (ModeTransitionTrigger) create(
				Aadl2Package.eINSTANCE.getModeTransitionTrigger());
		getOwnedTriggers().add(newOwnedTrigger);
		return newOwnedTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.MODE_TRANSITION__OWNED_TRIGGER:
			return ((InternalEList<?>) getOwnedTriggers()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.MODE_TRANSITION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case Aadl2Package.MODE_TRANSITION__DESTINATION:
			if (resolve)
				return getDestination();
			return basicGetDestination();
		case Aadl2Package.MODE_TRANSITION__OWNED_TRIGGER:
			return getOwnedTriggers();
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
		case Aadl2Package.MODE_TRANSITION__SOURCE:
			setSource((Mode) newValue);
			return;
		case Aadl2Package.MODE_TRANSITION__DESTINATION:
			setDestination((Mode) newValue);
			return;
		case Aadl2Package.MODE_TRANSITION__OWNED_TRIGGER:
			getOwnedTriggers().clear();
			getOwnedTriggers().addAll((Collection<? extends ModeTransitionTrigger>) newValue);
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
		case Aadl2Package.MODE_TRANSITION__SOURCE:
			setSource((Mode) null);
			return;
		case Aadl2Package.MODE_TRANSITION__DESTINATION:
			setDestination((Mode) null);
			return;
		case Aadl2Package.MODE_TRANSITION__OWNED_TRIGGER:
			getOwnedTriggers().clear();
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
		case Aadl2Package.MODE_TRANSITION__SOURCE:
			return source != null;
		case Aadl2Package.MODE_TRANSITION__DESTINATION:
			return destination != null;
		case Aadl2Package.MODE_TRANSITION__OWNED_TRIGGER:
			return ownedTriggers != null && !ownedTriggers.isEmpty();
		}
		return super.eIsSet(featureID);
	}
} // ModeTransitionImpl
