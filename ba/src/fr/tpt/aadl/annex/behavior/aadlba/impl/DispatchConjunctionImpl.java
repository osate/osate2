/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Conjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchConjunctionImpl extends BehaviorElementImpl implements DispatchConjunction {
	/**
	 * The cached value of the '{@link #getDispatchTriggers() <em>Dispatch Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispatchTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> dispatchTriggers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DispatchConjunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.DISPATCH_CONJUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getDispatchTriggers() {
		if (dispatchTriggers == null) {
			dispatchTriggers = new EObjectContainmentEList.Unsettable<Identifier>(Identifier.class, this, AadlBaPackage.DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS);
		}
		return dispatchTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDispatchTriggers() {
		if (dispatchTriggers != null) ((InternalEList.Unsettable<?>)dispatchTriggers).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDispatchTriggers() {
		return dispatchTriggers != null && ((InternalEList.Unsettable<?>)dispatchTriggers).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS:
				return ((InternalEList<?>)getDispatchTriggers()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS:
				return getDispatchTriggers();
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
			case AadlBaPackage.DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS:
				getDispatchTriggers().clear();
				getDispatchTriggers().addAll((Collection<? extends Identifier>)newValue);
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
			case AadlBaPackage.DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS:
				unsetDispatchTriggers();
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
			case AadlBaPackage.DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS:
				return isSetDispatchTriggers();
		}
		return super.eIsSet(featureID);
	}

} //DispatchConjunctionImpl
