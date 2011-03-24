/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl#getDispatchTriggerConditionOwned <em>Dispatch Trigger Condition Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl#getFrozenPorts <em>Frozen Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchConditionImpl extends ElementImpl implements DispatchCondition {
	/**
	 * The cached value of the '{@link #getDispatchTriggerConditionOwned() <em>Dispatch Trigger Condition Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispatchTriggerConditionOwned()
	 * @generated
	 * @ordered
	 */
	protected DispatchTriggerCondition dispatchTriggerConditionOwned;

	/**
	 * The cached value of the '{@link #getFrozenPorts() <em>Frozen Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrozenPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> frozenPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DispatchConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.DISPATCH_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DispatchTriggerCondition getDispatchTriggerConditionOwned() {
		return dispatchTriggerConditionOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatchTriggerConditionOwned(DispatchTriggerCondition newDispatchTriggerConditionOwned, NotificationChain msgs) {
		DispatchTriggerCondition oldDispatchTriggerConditionOwned = dispatchTriggerConditionOwned;
		dispatchTriggerConditionOwned = newDispatchTriggerConditionOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED, oldDispatchTriggerConditionOwned, newDispatchTriggerConditionOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispatchTriggerConditionOwned(DispatchTriggerCondition newDispatchTriggerConditionOwned) {
		if (newDispatchTriggerConditionOwned != dispatchTriggerConditionOwned) {
			NotificationChain msgs = null;
			if (dispatchTriggerConditionOwned != null)
				msgs = ((InternalEObject)dispatchTriggerConditionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED, null, msgs);
			if (newDispatchTriggerConditionOwned != null)
				msgs = ((InternalEObject)newDispatchTriggerConditionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED, null, msgs);
			msgs = basicSetDispatchTriggerConditionOwned(newDispatchTriggerConditionOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED, newDispatchTriggerConditionOwned, newDispatchTriggerConditionOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getFrozenPorts() {
		if (frozenPorts == null) {
			frozenPorts = new EObjectContainmentEList.Unsettable<Identifier>(Identifier.class, this, AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS);
		}
		return frozenPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrozenPorts() {
		if (frozenPorts != null) ((InternalEList.Unsettable<?>)frozenPorts).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrozenPorts() {
		return frozenPorts != null && ((InternalEList.Unsettable<?>)frozenPorts).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED:
				return basicSetDispatchTriggerConditionOwned(null, msgs);
			case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
				return ((InternalEList<?>)getFrozenPorts()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED:
				return getDispatchTriggerConditionOwned();
			case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
				return getFrozenPorts();
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
			case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED:
				setDispatchTriggerConditionOwned((DispatchTriggerCondition)newValue);
				return;
			case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
				getFrozenPorts().clear();
				getFrozenPorts().addAll((Collection<? extends Identifier>)newValue);
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
			case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED:
				setDispatchTriggerConditionOwned((DispatchTriggerCondition)null);
				return;
			case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
				unsetFrozenPorts();
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
			case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED:
				return dispatchTriggerConditionOwned != null;
			case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
				return isSetFrozenPorts();
		}
		return super.eIsSet(featureID);
	}

} //DispatchConditionImpl
