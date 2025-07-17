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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SOM Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMLevel#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMLevel#getComponent <em>Component</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMLevel#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMLevel#getInitialNode <em>Initial Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SOMLevel extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SOMNode> nodes;

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
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getInitialNode() <em>Initial Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNode()
	 * @generated
	 * @ordered
	 */
	protected SOMNode initialNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOMLevel() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModemodelPackage.Literals.SOM_LEVEL;
	}

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.SOMNode}.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.SOMNode#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getLevel
	 * @generated
	 */
	public List<SOMNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<>(SOMNode.class, this,
					ModemodelPackage.SOM_LEVEL__NODES, ModemodelPackage.SOM_NODE__LEVEL);
		}
		return nodes;
	}

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModemodelPackage.SOM_LEVEL__COMPONENT,
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
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMLevel#getComponent <em>Component</em>}' reference.
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_LEVEL__COMPONENT, oldComponent,
					component));
		}
	}

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @generated
	 */
	public List<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<>(Transition.class, this,
					ModemodelPackage.SOM_LEVEL__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * Returns the value of the '<em><b>Initial Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Node</em>' reference.
	 * @see #setInitialNode(SOMNode)
	 * @generated
	 */
	public SOMNode getInitialNode() {
		return initialNode;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMLevel#getInitialNode <em>Initial Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newInitialNode the new value of the '<em>Initial Node</em>' reference.
	 * @see #getInitialNode()
	 * @generated
	 */
	public void setInitialNode(SOMNode newInitialNode) {
		SOMNode oldInitialNode = initialNode;
		initialNode = newInitialNode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_LEVEL__INITIAL_NODE,
					oldInitialNode, initialNode));
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
		case ModemodelPackage.SOM_LEVEL__NODES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getNodes()).basicAdd(otherEnd, msgs);
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
		case ModemodelPackage.SOM_LEVEL__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		case ModemodelPackage.SOM_LEVEL__TRANSITIONS:
			return ((InternalEList<?>) getTransitions()).basicRemove(otherEnd, msgs);
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
		case ModemodelPackage.SOM_LEVEL__NODES:
			return getNodes();
		case ModemodelPackage.SOM_LEVEL__COMPONENT:
			if (resolve) {
				return getComponent();
			}
			return basicGetComponent();
		case ModemodelPackage.SOM_LEVEL__TRANSITIONS:
			return getTransitions();
		case ModemodelPackage.SOM_LEVEL__INITIAL_NODE:
			return getInitialNode();
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
		case ModemodelPackage.SOM_LEVEL__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends SOMNode>) newValue);
			return;
		case ModemodelPackage.SOM_LEVEL__COMPONENT:
			setComponent((ComponentInstance) newValue);
			return;
		case ModemodelPackage.SOM_LEVEL__TRANSITIONS:
			getTransitions().clear();
			getTransitions().addAll((Collection<? extends Transition>) newValue);
			return;
		case ModemodelPackage.SOM_LEVEL__INITIAL_NODE:
			setInitialNode((SOMNode) newValue);
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
		case ModemodelPackage.SOM_LEVEL__NODES:
			getNodes().clear();
			return;
		case ModemodelPackage.SOM_LEVEL__COMPONENT:
			setComponent((ComponentInstance) null);
			return;
		case ModemodelPackage.SOM_LEVEL__TRANSITIONS:
			getTransitions().clear();
			return;
		case ModemodelPackage.SOM_LEVEL__INITIAL_NODE:
			setInitialNode((SOMNode) null);
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
		case ModemodelPackage.SOM_LEVEL__NODES:
			return nodes != null && !nodes.isEmpty();
		case ModemodelPackage.SOM_LEVEL__COMPONENT:
			return component != null;
		case ModemodelPackage.SOM_LEVEL__TRANSITIONS:
			return transitions != null && !transitions.isEmpty();
		case ModemodelPackage.SOM_LEVEL__INITIAL_NODE:
			return initialNode != null;
		}
		return super.eIsSet(featureID);
	}

} // SOMLevel
