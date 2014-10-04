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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: ModeTransitionImpl.java,v 1.15 2009-02-26 21:21:12 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ModeTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ModeTransitionImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ModeTransitionImpl#getOwnedTriggers <em>Owned Trigger</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getModeTransition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getSource() {
		if (source != null && ((EObject) source).eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Mode) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_TRANSITION__SOURCE,
							oldSource, source));
				}
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
	@Override
	public void setSource(Mode newSource) {
		Mode oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_TRANSITION__SOURCE, oldSource,
					source));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getDestination() {
		if (destination != null && ((EObject) destination).eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (Mode) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.MODE_TRANSITION__DESTINATION, oldDestination, destination));
				}
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
	@Override
	public void setDestination(Mode newDestination) {
		Mode oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_TRANSITION__DESTINATION,
					oldDestination, destination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public ModeTransitionTrigger createOwnedTrigger() {
		ModeTransitionTrigger newOwnedTrigger = (ModeTransitionTrigger) create(Aadl2Package.eINSTANCE
				.getModeTransitionTrigger());
		getOwnedTriggers().add(newOwnedTrigger);
		return newOwnedTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.MODE_TRANSITION__SOURCE:
			if (resolve) {
				return getSource();
			}
			return basicGetSource();
		case Aadl2Package.MODE_TRANSITION__DESTINATION:
			if (resolve) {
				return getDestination();
			}
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
	@Override
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
	@Override
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
	@Override
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
