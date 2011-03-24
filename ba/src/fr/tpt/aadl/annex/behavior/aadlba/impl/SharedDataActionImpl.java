/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shared Data Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl#getDataAccessName <em>Data Access Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SharedDataActionImpl extends ElementImpl implements SharedDataAction {
	/**
	 * The cached value of the '{@link #getDataAccessName() <em>Data Access Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataAccessName()
	 * @generated
	 * @ordered
	 */
	protected Name dataAccessName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SharedDataActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.SHARED_DATA_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name getDataAccessName() {
		return dataAccessName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataAccessName(Name newDataAccessName, NotificationChain msgs) {
		Name oldDataAccessName = dataAccessName;
		dataAccessName = newDataAccessName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME, oldDataAccessName, newDataAccessName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataAccessName(Name newDataAccessName) {
		if (newDataAccessName != dataAccessName) {
			NotificationChain msgs = null;
			if (dataAccessName != null)
				msgs = ((InternalEObject)dataAccessName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME, null, msgs);
			if (newDataAccessName != null)
				msgs = ((InternalEObject)newDataAccessName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME, null, msgs);
			msgs = basicSetDataAccessName(newDataAccessName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME, newDataAccessName, newDataAccessName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME:
				return basicSetDataAccessName(null, msgs);
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
			case AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME:
				return getDataAccessName();
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
			case AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME:
				setDataAccessName((Name)newValue);
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
			case AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME:
				setDataAccessName((Name)null);
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
			case AadlBaPackage.SHARED_DATA_ACTION__DATA_ACCESS_NAME:
				return dataAccessName != null;
		}
		return super.eIsSet(featureID);
	}

} //SharedDataActionImpl
