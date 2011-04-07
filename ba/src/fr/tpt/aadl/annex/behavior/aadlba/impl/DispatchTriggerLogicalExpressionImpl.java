/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Trigger Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl#getDispatchConjunctions <em>Dispatch Conjunctions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchTriggerLogicalExpressionImpl extends BehaviorElementImpl implements DispatchTriggerLogicalExpression {
	/**
	 * The cached value of the '{@link #getDispatchConjunctions() <em>Dispatch Conjunctions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispatchConjunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<DispatchConjunction> dispatchConjunctions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DispatchTriggerLogicalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.DISPATCH_TRIGGER_LOGICAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DispatchConjunction> getDispatchConjunctions() {
		if (dispatchConjunctions == null) {
			dispatchConjunctions = new EObjectContainmentEList.Unsettable<DispatchConjunction>(DispatchConjunction.class, this, AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS);
		}
		return dispatchConjunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDispatchConjunctions() {
		if (dispatchConjunctions != null) ((InternalEList.Unsettable<?>)dispatchConjunctions).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDispatchConjunctions() {
		return dispatchConjunctions != null && ((InternalEList.Unsettable<?>)dispatchConjunctions).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
				return ((InternalEList<?>)getDispatchConjunctions()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
				return getDispatchConjunctions();
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
			case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
				getDispatchConjunctions().clear();
				getDispatchConjunctions().addAll((Collection<? extends DispatchConjunction>)newValue);
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
			case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
				unsetDispatchConjunctions();
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
			case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
				return isSetDispatchConjunctions();
		}
		return super.eIsSet(featureID);
	}

} //DispatchTriggerLogicalExpressionImpl
