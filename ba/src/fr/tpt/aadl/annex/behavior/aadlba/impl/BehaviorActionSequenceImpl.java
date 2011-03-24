/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Action Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl#getBehaviorActions <em>Behavior Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorActionSequenceImpl extends ElementImpl implements BehaviorActionSequence {
	/**
	 * The cached value of the '{@link #getBehaviorActions() <em>Behavior Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorActions()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorAction> behaviorActions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorActionSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_ACTION_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorAction> getBehaviorActions() {
		if (behaviorActions == null) {
			behaviorActions = new EObjectContainmentEList.Unsettable<BehaviorAction>(BehaviorAction.class, this, AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS);
		}
		return behaviorActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBehaviorActions() {
		if (behaviorActions != null) ((InternalEList.Unsettable<?>)behaviorActions).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehaviorActions() {
		return behaviorActions != null && ((InternalEList.Unsettable<?>)behaviorActions).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS:
				return ((InternalEList<?>)getBehaviorActions()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS:
				return getBehaviorActions();
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
			case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS:
				getBehaviorActions().clear();
				getBehaviorActions().addAll((Collection<? extends BehaviorAction>)newValue);
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
			case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS:
				unsetBehaviorActions();
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
			case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS:
				return isSetBehaviorActions();
		}
		return super.eIsSet(featureID);
	}

} //BehaviorActionSequenceImpl
