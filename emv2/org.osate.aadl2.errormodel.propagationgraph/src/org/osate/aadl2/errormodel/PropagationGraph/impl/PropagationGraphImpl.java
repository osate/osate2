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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Propagation Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getPropagationGraphPaths <em>Propagation Graph Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropagationGraphImpl extends MinimalEObjectImpl.Container implements PropagationGraph {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> components;

	/**
	 * The cached value of the '{@link #getPropagationGraphPaths() <em>Propagation Graph Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationGraphPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationGraphPath> propagationGraphPaths;

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
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance root;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropagationGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropagationGraphPackage.Literals.PROPAGATION_GRAPH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentInstance> getComponents() {
		if (components == null) {
			components = new EObjectResolvingEList<ComponentInstance>(ComponentInstance.class, this, PropagationGraphPackage.PROPAGATION_GRAPH__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropagationGraphPath> getPropagationGraphPaths() {
		if (propagationGraphPaths == null) {
			propagationGraphPaths = new EObjectContainmentEList<PropagationGraphPath>(PropagationGraphPath.class, this, PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS);
		}
		return propagationGraphPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionInstance> getConnections() {
		if (connections == null) {
			connections = new EObjectResolvingEList<ConnectionInstance>(ConnectionInstance.class, this, PropagationGraphPackage.PROPAGATION_GRAPH__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (ComponentInstance)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_GRAPH__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(ComponentInstance newRoot) {
		ComponentInstance oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_GRAPH__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS:
				return ((InternalEList<?>)getPropagationGraphPaths()).basicRemove(otherEnd, msgs);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__NAME:
				return getName();
			case PropagationGraphPackage.PROPAGATION_GRAPH__DESCRIPTION:
				return getDescription();
			case PropagationGraphPackage.PROPAGATION_GRAPH__COMPONENTS:
				return getComponents();
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS:
				return getPropagationGraphPaths();
			case PropagationGraphPackage.PROPAGATION_GRAPH__CONNECTIONS:
				return getConnections();
			case PropagationGraphPackage.PROPAGATION_GRAPH__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__NAME:
				setName((String)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends ComponentInstance>)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS:
				getPropagationGraphPaths().clear();
				getPropagationGraphPaths().addAll((Collection<? extends PropagationGraphPath>)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends ConnectionInstance>)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__ROOT:
				setRoot((ComponentInstance)newValue);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__COMPONENTS:
				getComponents().clear();
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS:
				getPropagationGraphPaths().clear();
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__CONNECTIONS:
				getConnections().clear();
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__ROOT:
				setRoot((ComponentInstance)null);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PropagationGraphPackage.PROPAGATION_GRAPH__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PropagationGraphPackage.PROPAGATION_GRAPH__COMPONENTS:
				return components != null && !components.isEmpty();
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS:
				return propagationGraphPaths != null && !propagationGraphPaths.isEmpty();
			case PropagationGraphPackage.PROPAGATION_GRAPH__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case PropagationGraphPackage.PROPAGATION_GRAPH__ROOT:
				return root != null;
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //PropagationGraphImpl
