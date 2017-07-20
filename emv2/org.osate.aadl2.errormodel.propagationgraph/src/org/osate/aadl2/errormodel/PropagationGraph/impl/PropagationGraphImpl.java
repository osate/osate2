/**
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
import org.osate.aadl2.errormodel.PropagationGraph.PropagationNode;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPath;

import org.osate.aadl2.instance.ComponentInstance;

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
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getPropagationPaths <em>Propagation Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl#getNodes <em>Nodes</em>}</li>
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
	 * The cached value of the '{@link #getPropagationPaths() <em>Propagation Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationPath> propagationPaths;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationNode> nodes;

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
	public EList<PropagationPath> getPropagationPaths() {
		if (propagationPaths == null) {
			propagationPaths = new EObjectContainmentEList<PropagationPath>(PropagationPath.class, this, PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_PATHS);
		}
		return propagationPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropagationNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<PropagationNode>(PropagationNode.class, this, PropagationGraphPackage.PROPAGATION_GRAPH__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_PATHS:
				return ((InternalEList<?>)getPropagationPaths()).basicRemove(otherEnd, msgs);
			case PropagationGraphPackage.PROPAGATION_GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_PATHS:
				return getPropagationPaths();
			case PropagationGraphPackage.PROPAGATION_GRAPH__NODES:
				return getNodes();
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_PATHS:
				getPropagationPaths().clear();
				getPropagationPaths().addAll((Collection<? extends PropagationPath>)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends PropagationNode>)newValue);
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_PATHS:
				getPropagationPaths().clear();
				return;
			case PropagationGraphPackage.PROPAGATION_GRAPH__NODES:
				getNodes().clear();
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
			case PropagationGraphPackage.PROPAGATION_GRAPH__PROPAGATION_PATHS:
				return propagationPaths != null && !propagationPaths.isEmpty();
			case PropagationGraphPackage.PROPAGATION_GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
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
