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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connected Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ConnectedElementImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectedElementImpl#getConnectionEnd <em>Connection End</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectedElementImpl#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectedElementImpl extends ElementImpl implements ConnectedElement {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected Context context;

	/**
	 * The cached value of the '{@link #getConnectionEnd() <em>Connection End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionEnd()
	 * @generated
	 * @ordered
	 */
	protected ConnectionEnd connectionEnd;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected ConnectedElement next;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getConnectedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getContext() {
		if (context != null && ((EObject) context).eIsProxy()) {
			InternalEObject oldContext = (InternalEObject) context;
			context = (Context) eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.CONNECTED_ELEMENT__CONTEXT,
							oldContext, context));
				}
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Context newContext) {
		Context oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTED_ELEMENT__CONTEXT, oldContext,
					context));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd getConnectionEnd() {
		if (connectionEnd != null && ((EObject) connectionEnd).eIsProxy()) {
			InternalEObject oldConnectionEnd = (InternalEObject) connectionEnd;
			connectionEnd = (ConnectionEnd) eResolveProxy(oldConnectionEnd);
			if (connectionEnd != oldConnectionEnd) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONNECTED_ELEMENT__CONNECTION_END, oldConnectionEnd, connectionEnd));
				}
			}
		}
		return connectionEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd basicGetConnectionEnd() {
		return connectionEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionEnd(ConnectionEnd newConnectionEnd) {
		ConnectionEnd oldConnectionEnd = connectionEnd;
		connectionEnd = newConnectionEnd;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTED_ELEMENT__CONNECTION_END,
					oldConnectionEnd, connectionEnd));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement getNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNext(ConnectedElement newNext, NotificationChain msgs) {
		ConnectedElement oldNext = next;
		next = newNext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTED_ELEMENT__NEXT, oldNext, newNext);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(ConnectedElement newNext) {
		if (newNext != next) {
			NotificationChain msgs = null;
			if (next != null) {
				msgs = ((InternalEObject) next).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONNECTED_ELEMENT__NEXT, null, msgs);
			}
			if (newNext != null) {
				msgs = ((InternalEObject) newNext).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONNECTED_ELEMENT__NEXT, null, msgs);
			}
			msgs = basicSetNext(newNext, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTED_ELEMENT__NEXT, newNext,
					newNext));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement createNext() {
		ConnectedElement newNext = (ConnectedElement) create(Aadl2Package.eINSTANCE.getConnectedElement());
		setNext(newNext);
		return newNext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.CONNECTED_ELEMENT__NEXT:
			return basicSetNext(null, msgs);
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
		case Aadl2Package.CONNECTED_ELEMENT__CONTEXT:
			if (resolve) {
				return getContext();
			}
			return basicGetContext();
		case Aadl2Package.CONNECTED_ELEMENT__CONNECTION_END:
			if (resolve) {
				return getConnectionEnd();
			}
			return basicGetConnectionEnd();
		case Aadl2Package.CONNECTED_ELEMENT__NEXT:
			return getNext();
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
		case Aadl2Package.CONNECTED_ELEMENT__CONTEXT:
			setContext((Context) newValue);
			return;
		case Aadl2Package.CONNECTED_ELEMENT__CONNECTION_END:
			setConnectionEnd((ConnectionEnd) newValue);
			return;
		case Aadl2Package.CONNECTED_ELEMENT__NEXT:
			setNext((ConnectedElement) newValue);
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
		case Aadl2Package.CONNECTED_ELEMENT__CONTEXT:
			setContext((Context) null);
			return;
		case Aadl2Package.CONNECTED_ELEMENT__CONNECTION_END:
			setConnectionEnd((ConnectionEnd) null);
			return;
		case Aadl2Package.CONNECTED_ELEMENT__NEXT:
			setNext((ConnectedElement) null);
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
		case Aadl2Package.CONNECTED_ELEMENT__CONTEXT:
			return context != null;
		case Aadl2Package.CONNECTED_ELEMENT__CONNECTION_END:
			return connectionEnd != null;
		case Aadl2Package.CONNECTED_ELEMENT__NEXT:
			return next != null;
		}
		return super.eIsSet(featureID);
	}

	public ConnectionEnd getLastConnectionEnd() {
		ConnectedElement current = this;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current.getConnectionEnd();
	}

} // ConnectedElementImpl
