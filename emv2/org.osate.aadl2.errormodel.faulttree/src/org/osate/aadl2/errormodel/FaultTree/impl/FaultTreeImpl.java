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
package org.osate.aadl2.errormodel.FaultTree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreePackage;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl#getFaultTreeType <em>Fault Tree Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl#getInstanceRoot <em>Instance Root</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FaultTreeImpl extends MinimalEObjectImpl.Container implements FaultTree {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultTreeType() <em>Fault Tree Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultTreeType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultTreeType FAULT_TREE_TYPE_EDEFAULT = FaultTreeType.FAULT_TREE;

	/**
	 * The cached value of the '{@link #getFaultTreeType() <em>Fault Tree Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultTreeType()
	 * @generated
	 * @ordered
	 */
	protected FaultTreeType faultTreeType = FAULT_TREE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Event root;

	/**
	 * The cached value of the '{@link #getInstanceRoot() <em>Instance Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceRoot()
	 * @generated
	 * @ordered
	 */
	protected EObject instanceRoot;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FaultTreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FaultTreePackage.Literals.FAULT_TREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.FAULT_TREE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.FAULT_TREE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultTreeType getFaultTreeType() {
		return faultTreeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultTreeType(FaultTreeType newFaultTreeType) {
		FaultTreeType oldFaultTreeType = faultTreeType;
		faultTreeType = newFaultTreeType == null ? FAULT_TREE_TYPE_EDEFAULT : newFaultTreeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.FAULT_TREE__FAULT_TREE_TYPE, oldFaultTreeType, faultTreeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<Event>(Event.class, this, FaultTreePackage.FAULT_TREE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (Event)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTreePackage.FAULT_TREE__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Event newRoot) {
		Event oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.FAULT_TREE__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getInstanceRoot() {
		if (instanceRoot != null && instanceRoot.eIsProxy()) {
			InternalEObject oldInstanceRoot = (InternalEObject)instanceRoot;
			instanceRoot = eResolveProxy(oldInstanceRoot);
			if (instanceRoot != oldInstanceRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTreePackage.FAULT_TREE__INSTANCE_ROOT, oldInstanceRoot, instanceRoot));
			}
		}
		return instanceRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetInstanceRoot() {
		return instanceRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceRoot(EObject newInstanceRoot) {
		EObject oldInstanceRoot = instanceRoot;
		instanceRoot = newInstanceRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.FAULT_TREE__INSTANCE_ROOT, oldInstanceRoot, instanceRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FaultTreePackage.FAULT_TREE__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
			case FaultTreePackage.FAULT_TREE__NAME:
				return getName();
			case FaultTreePackage.FAULT_TREE__MESSAGE:
				return getMessage();
			case FaultTreePackage.FAULT_TREE__FAULT_TREE_TYPE:
				return getFaultTreeType();
			case FaultTreePackage.FAULT_TREE__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
			case FaultTreePackage.FAULT_TREE__INSTANCE_ROOT:
				if (resolve) return getInstanceRoot();
				return basicGetInstanceRoot();
			case FaultTreePackage.FAULT_TREE__EVENTS:
				return getEvents();
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
			case FaultTreePackage.FAULT_TREE__NAME:
				setName((String)newValue);
				return;
			case FaultTreePackage.FAULT_TREE__MESSAGE:
				setMessage((String)newValue);
				return;
			case FaultTreePackage.FAULT_TREE__FAULT_TREE_TYPE:
				setFaultTreeType((FaultTreeType)newValue);
				return;
			case FaultTreePackage.FAULT_TREE__ROOT:
				setRoot((Event)newValue);
				return;
			case FaultTreePackage.FAULT_TREE__INSTANCE_ROOT:
				setInstanceRoot((EObject)newValue);
				return;
			case FaultTreePackage.FAULT_TREE__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
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
			case FaultTreePackage.FAULT_TREE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FaultTreePackage.FAULT_TREE__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case FaultTreePackage.FAULT_TREE__FAULT_TREE_TYPE:
				setFaultTreeType(FAULT_TREE_TYPE_EDEFAULT);
				return;
			case FaultTreePackage.FAULT_TREE__ROOT:
				setRoot((Event)null);
				return;
			case FaultTreePackage.FAULT_TREE__INSTANCE_ROOT:
				setInstanceRoot((EObject)null);
				return;
			case FaultTreePackage.FAULT_TREE__EVENTS:
				getEvents().clear();
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
			case FaultTreePackage.FAULT_TREE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FaultTreePackage.FAULT_TREE__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case FaultTreePackage.FAULT_TREE__FAULT_TREE_TYPE:
				return faultTreeType != FAULT_TREE_TYPE_EDEFAULT;
			case FaultTreePackage.FAULT_TREE__ROOT:
				return root != null;
			case FaultTreePackage.FAULT_TREE__INSTANCE_ROOT:
				return instanceRoot != null;
			case FaultTreePackage.FAULT_TREE__EVENTS:
				return events != null && !events.isEmpty();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", message: ");
		result.append(message);
		result.append(", faultTreeType: ");
		result.append(faultTreeType);
		result.append(')');
		return result.toString();
	}

} //FaultTreeImpl
