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
package org.osate.aadl2.errormodel.PropagationGraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationType;

import org.osate.aadl2.instance.ConnectionInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl#getPathSrc <em>Path Src</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl#getPathDst <em>Path Dst</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropagationGraphPathImpl extends MinimalEObjectImpl.Container implements PropagationGraphPath {
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
	 * The cached value of the '{@link #getPathSrc() <em>Path Src</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathSrc()
	 * @generated
	 * @ordered
	 */
	protected PropagationPathEnd pathSrc;

	/**
	 * The cached value of the '{@link #getPathDst() <em>Path Dst</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathDst()
	 * @generated
	 * @ordered
	 */
	protected PropagationPathEnd pathDst;

	/**
	 * The default value of the '{@link #isHighlight() <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHighlight()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIGHLIGHT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHighlight() <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHighlight()
	 * @generated
	 * @ordered
	 */
	protected boolean highlight = HIGHLIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final PropagationType TYPE_EDEFAULT = PropagationType.CONNECTION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected PropagationType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstance connection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropagationGraphPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropagationGraphPackage.Literals.PROPAGATION_GRAPH_PATH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationPathEnd getPathSrc() {
		return pathSrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathSrc(PropagationPathEnd newPathSrc, NotificationChain msgs) {
		PropagationPathEnd oldPathSrc = pathSrc;
		pathSrc = newPathSrc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC, oldPathSrc, newPathSrc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathSrc(PropagationPathEnd newPathSrc) {
		if (newPathSrc != pathSrc) {
			NotificationChain msgs = null;
			if (pathSrc != null)
				msgs = ((InternalEObject)pathSrc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC, null, msgs);
			if (newPathSrc != null)
				msgs = ((InternalEObject)newPathSrc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC, null, msgs);
			msgs = basicSetPathSrc(newPathSrc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC, newPathSrc, newPathSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationPathEnd getPathDst() {
		return pathDst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathDst(PropagationPathEnd newPathDst, NotificationChain msgs) {
		PropagationPathEnd oldPathDst = pathDst;
		pathDst = newPathDst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST, oldPathDst, newPathDst);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathDst(PropagationPathEnd newPathDst) {
		if (newPathDst != pathDst) {
			NotificationChain msgs = null;
			if (pathDst != null)
				msgs = ((InternalEObject)pathDst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST, null, msgs);
			if (newPathDst != null)
				msgs = ((InternalEObject)newPathDst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST, null, msgs);
			msgs = basicSetPathDst(newPathDst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST, newPathDst, newPathDst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHighlight() {
		return highlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighlight(boolean newHighlight) {
		boolean oldHighlight = highlight;
		highlight = newHighlight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__HIGHLIGHT, oldHighlight, highlight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(PropagationType newType) {
		PropagationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstance getConnection() {
		if (connection != null && connection.eIsProxy()) {
			InternalEObject oldConnection = (InternalEObject)connection;
			connection = (ConnectionInstance)eResolveProxy(oldConnection);
			if (connection != oldConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__CONNECTION, oldConnection, connection));
			}
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstance basicGetConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(ConnectionInstance newConnection) {
		ConnectionInstance oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH_PATH__CONNECTION, oldConnection, connection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC:
				return basicSetPathSrc(null, msgs);
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST:
				return basicSetPathDst(null, msgs);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__NAME:
				return getName();
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC:
				return getPathSrc();
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST:
				return getPathDst();
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__HIGHLIGHT:
				return isHighlight();
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__TYPE:
				return getType();
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__CONNECTION:
				if (resolve) return getConnection();
				return basicGetConnection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__NAME:
				setName((String)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC:
				setPathSrc((PropagationPathEnd)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST:
				setPathDst((PropagationPathEnd)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__HIGHLIGHT:
				setHighlight((Boolean)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__TYPE:
				setType((PropagationType)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__CONNECTION:
				setConnection((ConnectionInstance)newValue);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC:
				setPathSrc((PropagationPathEnd)null);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST:
				setPathDst((PropagationPathEnd)null);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__HIGHLIGHT:
				setHighlight(HIGHLIGHT_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__CONNECTION:
				setConnection((ConnectionInstance)null);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_SRC:
				return pathSrc != null;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__PATH_DST:
				return pathDst != null;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__HIGHLIGHT:
				return highlight != HIGHLIGHT_EDEFAULT;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__TYPE:
				return type != TYPE_EDEFAULT;
			case PropagationGraphPackage.PROPAGATION_GRAPH_PATH__CONNECTION:
				return connection != null;
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
		result.append(", highlight: ");
		result.append(highlight);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //PropagationGraphPathImpl
