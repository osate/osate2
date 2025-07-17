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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.instance.ConnectionInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.modes.modemodel.Transition#getSrc <em>Src</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.Transition#getDst <em>Dst</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.Transition#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.Transition#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Transition extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected SOMNode src;

	/**
	 * The cached value of the '{@link #getDst() <em>Dst</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDst()
	 * @generated
	 * @ordered
	 */
	protected SOMNode dst;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected Trigger trigger;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModemodelPackage.Literals.TRANSITION;
	}

	/**
	 * Returns the value of the '<em><b>Src</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.SOMNode#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' reference.
	 * @see #setSrc(SOMNode)
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getOutTransitions
	 * @generated
	 */
	public SOMNode getSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSrc(SOMNode newSrc, NotificationChain msgs) {
		SOMNode oldSrc = src;
		src = newSrc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ModemodelPackage.TRANSITION__SRC, oldSrc, newSrc);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.Transition#getSrc <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newSrc the new value of the '<em>Src</em>' reference.
	 * @see #getSrc()
	 * @generated
	 */
	public void setSrc(SOMNode newSrc) {
		if (newSrc != src) {
			NotificationChain msgs = null;
			if (src != null) {
				msgs = src.eInverseRemove(this, ModemodelPackage.SOM_NODE__OUT_TRANSITIONS, SOMNode.class, msgs);
			}
			if (newSrc != null) {
				msgs = newSrc.eInverseAdd(this, ModemodelPackage.SOM_NODE__OUT_TRANSITIONS, SOMNode.class, msgs);
			}
			msgs = basicSetSrc(newSrc, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.TRANSITION__SRC, newSrc, newSrc));
		}
	}

	/**
	 * Returns the value of the '<em><b>Dst</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.SOMNode#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst</em>' reference.
	 * @see #setDst(SOMNode)
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getInTransitions
	 * @generated
	 */
	public SOMNode getDst() {
		return dst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDst(SOMNode newDst, NotificationChain msgs) {
		SOMNode oldDst = dst;
		dst = newDst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ModemodelPackage.TRANSITION__DST, oldDst, newDst);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.Transition#getDst <em>Dst</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newDst the new value of the '<em>Dst</em>' reference.
	 * @see #getDst()
	 * @generated
	 */
	public void setDst(SOMNode newDst) {
		if (newDst != dst) {
			NotificationChain msgs = null;
			if (dst != null) {
				msgs = dst.eInverseRemove(this, ModemodelPackage.SOM_NODE__IN_TRANSITIONS, SOMNode.class, msgs);
			}
			if (newDst != null) {
				msgs = newDst.eInverseAdd(this, ModemodelPackage.SOM_NODE__IN_TRANSITIONS, SOMNode.class, msgs);
			}
			msgs = basicSetDst(newDst, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.TRANSITION__DST, newDst, newDst));
		}
	}

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.Trigger#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The trigger must be active such that the transition can occur.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Trigger</em>' reference.
	 * @see #setTrigger(Trigger)
	 * @see org.osate.analysis.modes.modemodel.Trigger#getTransitions
	 * @generated
	 */
	public Trigger getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrigger(Trigger newTrigger, NotificationChain msgs) {
		Trigger oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ModemodelPackage.TRANSITION__TRIGGER, oldTrigger, newTrigger);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.Transition#getTrigger <em>Trigger</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newTrigger the new value of the '<em>Trigger</em>' reference.
	 * @see #getTrigger()
	 * @generated
	 */
	public void setTrigger(Trigger newTrigger) {
		if (newTrigger != trigger) {
			NotificationChain msgs = null;
			if (trigger != null) {
				msgs = trigger.eInverseRemove(this, ModemodelPackage.TRIGGER__TRANSITIONS, Trigger.class, msgs);
			}
			if (newTrigger != null) {
				msgs = newTrigger.eInverseAdd(this, ModemodelPackage.TRIGGER__TRANSITIONS, Trigger.class, msgs);
			}
			msgs = basicSetTrigger(newTrigger, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.TRANSITION__TRIGGER, newTrigger,
					newTrigger));
		}
	}

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Connection references identify the connections that must be active such that the transition can occur.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @generated
	 */
	public List<ConnectionInstance> getConnections() {
		if (connections == null) {
			connections = new EObjectResolvingEList<>(ConnectionInstance.class, this,
					ModemodelPackage.TRANSITION__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModemodelPackage.TRANSITION__SRC:
			if (src != null) {
				msgs = src.eInverseRemove(this, ModemodelPackage.SOM_NODE__OUT_TRANSITIONS, SOMNode.class, msgs);
			}
			return basicSetSrc((SOMNode) otherEnd, msgs);
		case ModemodelPackage.TRANSITION__DST:
			if (dst != null) {
				msgs = dst.eInverseRemove(this, ModemodelPackage.SOM_NODE__IN_TRANSITIONS, SOMNode.class, msgs);
			}
			return basicSetDst((SOMNode) otherEnd, msgs);
		case ModemodelPackage.TRANSITION__TRIGGER:
			if (trigger != null) {
				msgs = trigger.eInverseRemove(this, ModemodelPackage.TRIGGER__TRANSITIONS, Trigger.class, msgs);
			}
			return basicSetTrigger((Trigger) otherEnd, msgs);
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
		case ModemodelPackage.TRANSITION__SRC:
			return basicSetSrc(null, msgs);
		case ModemodelPackage.TRANSITION__DST:
			return basicSetDst(null, msgs);
		case ModemodelPackage.TRANSITION__TRIGGER:
			return basicSetTrigger(null, msgs);
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
		case ModemodelPackage.TRANSITION__SRC:
			return getSrc();
		case ModemodelPackage.TRANSITION__DST:
			return getDst();
		case ModemodelPackage.TRANSITION__TRIGGER:
			return getTrigger();
		case ModemodelPackage.TRANSITION__CONNECTIONS:
			return getConnections();
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
		case ModemodelPackage.TRANSITION__SRC:
			setSrc((SOMNode) newValue);
			return;
		case ModemodelPackage.TRANSITION__DST:
			setDst((SOMNode) newValue);
			return;
		case ModemodelPackage.TRANSITION__TRIGGER:
			setTrigger((Trigger) newValue);
			return;
		case ModemodelPackage.TRANSITION__CONNECTIONS:
			getConnections().clear();
			getConnections().addAll((Collection<? extends ConnectionInstance>) newValue);
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
		case ModemodelPackage.TRANSITION__SRC:
			setSrc((SOMNode) null);
			return;
		case ModemodelPackage.TRANSITION__DST:
			setDst((SOMNode) null);
			return;
		case ModemodelPackage.TRANSITION__TRIGGER:
			setTrigger((Trigger) null);
			return;
		case ModemodelPackage.TRANSITION__CONNECTIONS:
			getConnections().clear();
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
		case ModemodelPackage.TRANSITION__SRC:
			return src != null;
		case ModemodelPackage.TRANSITION__DST:
			return dst != null;
		case ModemodelPackage.TRANSITION__TRIGGER:
			return trigger != null;
		case ModemodelPackage.TRANSITION__CONNECTIONS:
			return connections != null && !connections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return getSrc().getMode().getName() + " - " + getTrigger().toString() + " -> " + getDst().getMode().getName();
	}

} // Transition
