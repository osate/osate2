/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.Subcomponent;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subcomponent Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentElementImpl#getSubcomponent <em>Subcomponent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubcomponentElementImpl extends ElementImpl implements SubcomponentElement {
	/**
	 * The cached value of the '{@link #getSubcomponent() <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcomponent()
	 * @generated
	 * @ordered
	 */
	protected Subcomponent subcomponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubcomponentElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ErrorModelPackage.Literals.SUBCOMPONENT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent getSubcomponent() {
		if (subcomponent != null && ((EObject) subcomponent).eIsProxy()) {
			InternalEObject oldSubcomponent = (InternalEObject) subcomponent;
			subcomponent = (Subcomponent) eResolveProxy(oldSubcomponent);
			if (subcomponent != oldSubcomponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ErrorModelPackage.SUBCOMPONENT_ELEMENT__SUBCOMPONENT, oldSubcomponent, subcomponent));
			}
		}
		return subcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent basicGetSubcomponent() {
		return subcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubcomponent(Subcomponent newSubcomponent) {
		Subcomponent oldSubcomponent = subcomponent;
		subcomponent = newSubcomponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.SUBCOMPONENT_ELEMENT__SUBCOMPONENT,
					oldSubcomponent, subcomponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ErrorModelPackage.SUBCOMPONENT_ELEMENT__SUBCOMPONENT:
			if (resolve)
				return getSubcomponent();
			return basicGetSubcomponent();
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
		case ErrorModelPackage.SUBCOMPONENT_ELEMENT__SUBCOMPONENT:
			setSubcomponent((Subcomponent) newValue);
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
		case ErrorModelPackage.SUBCOMPONENT_ELEMENT__SUBCOMPONENT:
			setSubcomponent((Subcomponent) null);
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
		case ErrorModelPackage.SUBCOMPONENT_ELEMENT__SUBCOMPONENT:
			return subcomponent != null;
		}
		return super.eIsSet(featureID);
	}

} // SubcomponentElementImpl
