/**
 */
package org.osate.aadl2.errormodel.PropagationGraph.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationNode;

import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Propagation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl#getComponentInstance <em>Component Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropagationNodeImpl extends MinimalEObjectImpl.Container implements PropagationNode {
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
	 * The cached value of the '{@link #getComponentInstance() <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance componentInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropagationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropagationGraphPackage.Literals.PROPAGATION_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_NODE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_NODE__HIGHLIGHT, oldHighlight, highlight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getComponentInstance() {
		if (componentInstance != null && componentInstance.eIsProxy()) {
			InternalEObject oldComponentInstance = (InternalEObject)componentInstance;
			componentInstance = (ComponentInstance)eResolveProxy(oldComponentInstance);
			if (componentInstance != oldComponentInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_NODE__COMPONENT_INSTANCE, oldComponentInstance, componentInstance));
			}
		}
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetComponentInstance() {
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentInstance(ComponentInstance newComponentInstance) {
		ComponentInstance oldComponentInstance = componentInstance;
		componentInstance = newComponentInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_NODE__COMPONENT_INSTANCE, oldComponentInstance, componentInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_NODE__NAME:
				return getName();
			case PropagationGraphPackage.PROPAGATION_NODE__HIGHLIGHT:
				return isHighlight();
			case PropagationGraphPackage.PROPAGATION_NODE__COMPONENT_INSTANCE:
				if (resolve) return getComponentInstance();
				return basicGetComponentInstance();
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
			case PropagationGraphPackage.PROPAGATION_NODE__NAME:
				setName((String)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_NODE__HIGHLIGHT:
				setHighlight((Boolean)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_NODE__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)newValue);
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
			case PropagationGraphPackage.PROPAGATION_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_NODE__HIGHLIGHT:
				setHighlight(HIGHLIGHT_EDEFAULT);
				return;
			case PropagationGraphPackage.PROPAGATION_NODE__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)null);
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
			case PropagationGraphPackage.PROPAGATION_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PropagationGraphPackage.PROPAGATION_NODE__HIGHLIGHT:
				return highlight != HIGHLIGHT_EDEFAULT;
			case PropagationGraphPackage.PROPAGATION_NODE__COMPONENT_INSTANCE:
				return componentInstance != null;
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
		result.append(')');
		return result.toString();
	}

} //PropagationNodeImpl
