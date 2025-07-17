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
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ModeInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SOM Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getInTransitions <em>In Transitions</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#isReachable <em>Reachable</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getMode <em>Mode</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getLevel <em>Level</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getInactiveConnections <em>Inactive Connections</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMNode#getInactiveComponents <em>Inactive Components</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SOMNode extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The cached value of the '{@link #getOutTransitions() <em>Out Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outTransitions;

	/**
	 * The cached value of the '{@link #getInTransitions() <em>In Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> inTransitions;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected SOMNode parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SOMNode> children;

	/**
	 * The default value of the '{@link #isReachable() <em>Reachable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReachable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REACHABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReachable() <em>Reachable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReachable()
	 * @generated
	 * @ordered
	 */
	protected boolean reachable = REACHABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected ModeInstance mode;

	/**
	 * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInactiveConnections() <em>Inactive Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInactiveConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> inactiveConnections;

	/**
	 * The cached value of the '{@link #getInactiveComponents() <em>Inactive Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInactiveComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> inactiveComponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOMNode() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModemodelPackage.Literals.SOM_NODE;
	}

	/**
	 * Returns the value of the '<em><b>Out Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.Transition#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Transitions</em>' reference list.
	 * @see org.osate.analysis.modes.modemodel.Transition#getSrc
	 * @generated
	 */
	public List<Transition> getOutTransitions() {
		if (outTransitions == null) {
			outTransitions = new EObjectWithInverseEList<>(Transition.class, this,
					ModemodelPackage.SOM_NODE__OUT_TRANSITIONS, ModemodelPackage.TRANSITION__SRC);
		}
		return outTransitions;
	}

	/**
	 * Returns the value of the '<em><b>In Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.Transition#getDst <em>Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transitions</em>' reference list.
	 * @see org.osate.analysis.modes.modemodel.Transition#getDst
	 * @generated
	 */
	public List<Transition> getInTransitions() {
		if (inTransitions == null) {
			inTransitions = new EObjectWithInverseEList<>(Transition.class, this,
					ModemodelPackage.SOM_NODE__IN_TRANSITIONS, ModemodelPackage.TRANSITION__DST);
		}
		return inTransitions;
	}

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.SOMNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(SOMNode)
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getChildren
	 * @generated
	 */
	public SOMNode getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(SOMNode newParent, NotificationChain msgs) {
		SOMNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ModemodelPackage.SOM_NODE__PARENT, oldParent, newParent);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newParent the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	public void setParent(SOMNode newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null) {
				msgs = parent.eInverseRemove(this, ModemodelPackage.SOM_NODE__CHILDREN, SOMNode.class, msgs);
			}
			if (newParent != null) {
				msgs = newParent.eInverseAdd(this, ModemodelPackage.SOM_NODE__CHILDREN, SOMNode.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_NODE__PARENT, newParent,
					newParent));
		}
	}

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.SOMNode}.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.SOMNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getParent
	 * @generated
	 */
	public List<SOMNode> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseEList<>(SOMNode.class, this, ModemodelPackage.SOM_NODE__CHILDREN,
					ModemodelPackage.SOM_NODE__PARENT);
		}
		return children;
	}

	/**
	 * Returns the value of the '<em><b>Reachable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reachable</em>' attribute.
	 * @see #setReachable(boolean)
	 * @generated
	 */
	public boolean isReachable() {
		return reachable;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMNode#isReachable <em>Reachable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newReachable the new value of the '<em>Reachable</em>' attribute.
	 * @see #isReachable()
	 * @generated
	 */
	public void setReachable(boolean newReachable) {
		boolean oldReachable = reachable;
		reachable = newReachable;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_NODE__REACHABLE, oldReachable,
					reachable));
		}
	}

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The next mode if the component is activated, unset if the component has no modes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mode</em>' reference.
	 * @see #setMode(ModeInstance)
	 * @generated
	 */
	public ModeInstance getMode() {
		if (mode != null && mode.eIsProxy()) {
			InternalEObject oldMode = (InternalEObject) mode;
			mode = (ModeInstance) eResolveProxy(oldMode);
			if (mode != oldMode) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModemodelPackage.SOM_NODE__MODE, oldMode,
							mode));
				}
			}
		}
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeInstance basicGetMode() {
		return mode;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMNode#getMode <em>Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newMode the new value of the '<em>Mode</em>' reference.
	 * @see #getMode()
	 * @generated
	 */
	public void setMode(ModeInstance newMode) {
		ModeInstance oldMode = mode;
		mode = newMode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_NODE__MODE, oldMode, mode));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public boolean isActive();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.osate.analysis.modes.modemodel.SOMLevel#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' container reference.
	 * @see #setLevel(SOMLevel)
	 * @see org.osate.analysis.modes.modemodel.SOMLevel#getNodes
	 * @generated
	 */
	public SOMLevel getLevel() {
		if (eContainerFeatureID() != ModemodelPackage.SOM_NODE__LEVEL) {
			return null;
		}
		return (SOMLevel) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLevel(SOMLevel newLevel, NotificationChain msgs) {
		msgs = eBasicSetContainer(newLevel, ModemodelPackage.SOM_NODE__LEVEL, msgs);
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMNode#getLevel <em>Level</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newLevel the new value of the '<em>Level</em>' container reference.
	 * @see #getLevel()
	 * @generated
	 */
	public void setLevel(SOMLevel newLevel) {
		if (newLevel != eInternalContainer()
				|| (eContainerFeatureID() != ModemodelPackage.SOM_NODE__LEVEL && newLevel != null)) {
			if (EcoreUtil.isAncestor(this, newLevel)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newLevel != null) {
				msgs = newLevel.eInverseAdd(this, ModemodelPackage.SOM_LEVEL__NODES, SOMLevel.class, msgs);
			}
			msgs = basicSetLevel(newLevel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_NODE__LEVEL, newLevel,
					newLevel));
		}
	}

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @generated
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * Sets the value of the '{@link org.osate.analysis.modes.modemodel.SOMNode#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newDerived the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ModemodelPackage.SOM_NODE__DERIVED, oldDerived,
					derived));
		}
	}

	/**
	 * Returns the value of the '<em><b>Inactive Connections</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inactive Connections</em>' reference list.
	 * @generated
	 */
	public List<ConnectionInstance> getInactiveConnections() {
		if (inactiveConnections == null) {
			inactiveConnections = new EObjectResolvingEList<>(ConnectionInstance.class, this,
					ModemodelPackage.SOM_NODE__INACTIVE_CONNECTIONS);
		}
		return inactiveConnections;
	}

	/**
	 * Returns the value of the '<em><b>Inactive Components</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inactive Components</em>' reference list.
	 * @generated
	 */
	public List<ComponentInstance> getInactiveComponents() {
		if (inactiveComponents == null) {
			inactiveComponents = new EObjectResolvingEList<>(ComponentInstance.class, this,
					ModemodelPackage.SOM_NODE__INACTIVE_COMPONENTS);
		}
		return inactiveComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasMode() {
		return mode != null;
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
		case ModemodelPackage.SOM_NODE__OUT_TRANSITIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutTransitions()).basicAdd(otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__IN_TRANSITIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInTransitions()).basicAdd(otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__PARENT:
			if (parent != null) {
				msgs = parent.eInverseRemove(this, ModemodelPackage.SOM_NODE__CHILDREN, SOMNode.class, msgs);
			}
			return basicSetParent((SOMNode) otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__LEVEL:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetLevel((SOMLevel) otherEnd, msgs);
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
		case ModemodelPackage.SOM_NODE__OUT_TRANSITIONS:
			return ((InternalEList<?>) getOutTransitions()).basicRemove(otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__IN_TRANSITIONS:
			return ((InternalEList<?>) getInTransitions()).basicRemove(otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__PARENT:
			return basicSetParent(null, msgs);
		case ModemodelPackage.SOM_NODE__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		case ModemodelPackage.SOM_NODE__LEVEL:
			return basicSetLevel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ModemodelPackage.SOM_NODE__LEVEL:
			return eInternalContainer().eInverseRemove(this, ModemodelPackage.SOM_LEVEL__NODES, SOMLevel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModemodelPackage.SOM_NODE__OUT_TRANSITIONS:
			return getOutTransitions();
		case ModemodelPackage.SOM_NODE__IN_TRANSITIONS:
			return getInTransitions();
		case ModemodelPackage.SOM_NODE__PARENT:
			return getParent();
		case ModemodelPackage.SOM_NODE__CHILDREN:
			return getChildren();
		case ModemodelPackage.SOM_NODE__REACHABLE:
			return isReachable();
		case ModemodelPackage.SOM_NODE__MODE:
			if (resolve) {
				return getMode();
			}
			return basicGetMode();
		case ModemodelPackage.SOM_NODE__LEVEL:
			return getLevel();
		case ModemodelPackage.SOM_NODE__DERIVED:
			return isDerived();
		case ModemodelPackage.SOM_NODE__INACTIVE_CONNECTIONS:
			return getInactiveConnections();
		case ModemodelPackage.SOM_NODE__INACTIVE_COMPONENTS:
			return getInactiveComponents();
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
		case ModemodelPackage.SOM_NODE__OUT_TRANSITIONS:
			getOutTransitions().clear();
			getOutTransitions().addAll((Collection<? extends Transition>) newValue);
			return;
		case ModemodelPackage.SOM_NODE__IN_TRANSITIONS:
			getInTransitions().clear();
			getInTransitions().addAll((Collection<? extends Transition>) newValue);
			return;
		case ModemodelPackage.SOM_NODE__PARENT:
			setParent((SOMNode) newValue);
			return;
		case ModemodelPackage.SOM_NODE__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends SOMNode>) newValue);
			return;
		case ModemodelPackage.SOM_NODE__REACHABLE:
			setReachable((Boolean) newValue);
			return;
		case ModemodelPackage.SOM_NODE__MODE:
			setMode((ModeInstance) newValue);
			return;
		case ModemodelPackage.SOM_NODE__LEVEL:
			setLevel((SOMLevel) newValue);
			return;
		case ModemodelPackage.SOM_NODE__DERIVED:
			setDerived((Boolean) newValue);
			return;
		case ModemodelPackage.SOM_NODE__INACTIVE_CONNECTIONS:
			getInactiveConnections().clear();
			getInactiveConnections().addAll((Collection<? extends ConnectionInstance>) newValue);
			return;
		case ModemodelPackage.SOM_NODE__INACTIVE_COMPONENTS:
			getInactiveComponents().clear();
			getInactiveComponents().addAll((Collection<? extends ComponentInstance>) newValue);
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
		case ModemodelPackage.SOM_NODE__OUT_TRANSITIONS:
			getOutTransitions().clear();
			return;
		case ModemodelPackage.SOM_NODE__IN_TRANSITIONS:
			getInTransitions().clear();
			return;
		case ModemodelPackage.SOM_NODE__PARENT:
			setParent((SOMNode) null);
			return;
		case ModemodelPackage.SOM_NODE__CHILDREN:
			getChildren().clear();
			return;
		case ModemodelPackage.SOM_NODE__REACHABLE:
			setReachable(REACHABLE_EDEFAULT);
			return;
		case ModemodelPackage.SOM_NODE__MODE:
			setMode((ModeInstance) null);
			return;
		case ModemodelPackage.SOM_NODE__LEVEL:
			setLevel((SOMLevel) null);
			return;
		case ModemodelPackage.SOM_NODE__DERIVED:
			setDerived(DERIVED_EDEFAULT);
			return;
		case ModemodelPackage.SOM_NODE__INACTIVE_CONNECTIONS:
			getInactiveConnections().clear();
			return;
		case ModemodelPackage.SOM_NODE__INACTIVE_COMPONENTS:
			getInactiveComponents().clear();
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
		case ModemodelPackage.SOM_NODE__OUT_TRANSITIONS:
			return outTransitions != null && !outTransitions.isEmpty();
		case ModemodelPackage.SOM_NODE__IN_TRANSITIONS:
			return inTransitions != null && !inTransitions.isEmpty();
		case ModemodelPackage.SOM_NODE__PARENT:
			return parent != null;
		case ModemodelPackage.SOM_NODE__CHILDREN:
			return children != null && !children.isEmpty();
		case ModemodelPackage.SOM_NODE__REACHABLE:
			return reachable != REACHABLE_EDEFAULT;
		case ModemodelPackage.SOM_NODE__MODE:
			return mode != null;
		case ModemodelPackage.SOM_NODE__LEVEL:
			return getLevel() != null;
		case ModemodelPackage.SOM_NODE__DERIVED:
			return derived != DERIVED_EDEFAULT;
		case ModemodelPackage.SOM_NODE__INACTIVE_CONNECTIONS:
			return inactiveConnections != null && !inactiveConnections.isEmpty();
		case ModemodelPackage.SOM_NODE__INACTIVE_COMPONENTS:
			return inactiveComponents != null && !inactiveComponents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (mode: ");
		result.append(mode == null ? "--" : mode.getName());
		result.append(" (reachable: ");
		result.append(reachable);
		result.append(", derived: ");
		result.append(derived);
		result.append(')');
		return result.toString();
	}

} // SOMNode
