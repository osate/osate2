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
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An instance of this class represents the logical origin of an event that causes a mode transition.
 *
 * All mode transitions that have the same trigger source happen simultaneously [13.6 (1)]
 *
 * Note: If the same event causes mode transitions in different synchronization domains, there must be different TriggerSource instances for each target synchronization domain.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.modes.modemodel.Trigger#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.Trigger#getKey <em>Key</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.Trigger#getComponent <em>Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class Trigger extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected TriggerKey key;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModemodelPackage.Literals.TRIGGER;
	}

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' reference list.
	 * @see org.osate.analysis.modes.modemodel.Transition#getTrigger
	 * @generated
	 */
	public List<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectWithInverseEList<>(Transition.class, this,
					ModemodelPackage.TRIGGER__TRANSITIONS, ModemodelPackage.TRANSITION__TRIGGER);
		}
		return transitions;
	}

	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.TriggerKey#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference.
	 * @see #setKey(TriggerKey)
	 * @see org.osate.analysis.modes.modemodel.TriggerKey#getTrigger
	 * @generated
	 */
	public TriggerKey getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKey(TriggerKey newKey, NotificationChain msgs) {
		TriggerKey oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ModemodelPackage.TRIGGER__KEY, oldKey, newKey);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.Trigger#getKey <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newKey the new value of the '<em>Key</em>' reference.
	 * @see #getKey()
	 * @generated
	 */
	public void setKey(TriggerKey newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null) {
				msgs = key.eInverseRemove(this, ModemodelPackage.TRIGGER_KEY__TRIGGER, TriggerKey.class, msgs);
			}
			if (newKey != null) {
				msgs = newKey.eInverseAdd(this, ModemodelPackage.TRIGGER_KEY__TRIGGER, TriggerKey.class, msgs);
			}
			msgs = basicSetKey(newKey, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.TRIGGER__KEY, newKey, newKey));
		}
	}

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The component in which a trigger originates. The trigger can only occur if this component is active.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(ComponentInstance)
	 * @generated
	 */
	public ComponentInstance getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject) component;
			component = (ComponentInstance) eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModemodelPackage.TRIGGER__COMPONENT,
							oldComponent, component));
				}
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetComponent() {
		return component;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.Trigger#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newComponent the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	public void setComponent(ComponentInstance newComponent) {
		ComponentInstance oldComponent = component;
		component = newComponent;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.TRIGGER__COMPONENT, oldComponent,
					component));
		}
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
		case ModemodelPackage.TRIGGER__TRANSITIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getTransitions()).basicAdd(otherEnd, msgs);
		case ModemodelPackage.TRIGGER__KEY:
			if (key != null) {
				msgs = key.eInverseRemove(this, ModemodelPackage.TRIGGER_KEY__TRIGGER, TriggerKey.class, msgs);
			}
			return basicSetKey((TriggerKey) otherEnd, msgs);
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
		case ModemodelPackage.TRIGGER__TRANSITIONS:
			return ((InternalEList<?>) getTransitions()).basicRemove(otherEnd, msgs);
		case ModemodelPackage.TRIGGER__KEY:
			return basicSetKey(null, msgs);
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
		case ModemodelPackage.TRIGGER__TRANSITIONS:
			return getTransitions();
		case ModemodelPackage.TRIGGER__KEY:
			return getKey();
		case ModemodelPackage.TRIGGER__COMPONENT:
			if (resolve) {
				return getComponent();
			}
			return basicGetComponent();
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
		case ModemodelPackage.TRIGGER__TRANSITIONS:
			getTransitions().clear();
			getTransitions().addAll((Collection<? extends Transition>) newValue);
			return;
		case ModemodelPackage.TRIGGER__KEY:
			setKey((TriggerKey) newValue);
			return;
		case ModemodelPackage.TRIGGER__COMPONENT:
			setComponent((ComponentInstance) newValue);
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
		case ModemodelPackage.TRIGGER__TRANSITIONS:
			getTransitions().clear();
			return;
		case ModemodelPackage.TRIGGER__KEY:
			setKey((TriggerKey) null);
			return;
		case ModemodelPackage.TRIGGER__COMPONENT:
			setComponent((ComponentInstance) null);
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
		case ModemodelPackage.TRIGGER__TRANSITIONS:
			return transitions != null && !transitions.isEmpty();
		case ModemodelPackage.TRIGGER__KEY:
			return key != null;
		case ModemodelPackage.TRIGGER__COMPONENT:
			return component != null;
		}
		return super.eIsSet(featureID);
	}

} // Trigger
