/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCondition Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.SConditionElementImpl#getQualifiedState <em>Qualified State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SConditionElementImpl extends ConditionElementImpl implements SConditionElement {
	/**
	 * The cached value of the '{@link #getQualifiedState() <em>Qualified State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedState()
	 * @generated
	 * @ordered
	 */
	protected QualifiedErrorBehaviorState qualifiedState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SConditionElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ErrorModelPackage.Literals.SCONDITION_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedErrorBehaviorState getQualifiedState() {
		return qualifiedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualifiedState(QualifiedErrorBehaviorState newQualifiedState,
			NotificationChain msgs) {
		QualifiedErrorBehaviorState oldQualifiedState = qualifiedState;
		qualifiedState = newQualifiedState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE, oldQualifiedState, newQualifiedState);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedState(QualifiedErrorBehaviorState newQualifiedState) {
		if (newQualifiedState != qualifiedState) {
			NotificationChain msgs = null;
			if (qualifiedState != null)
				msgs = ((InternalEObject) qualifiedState).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE, null, msgs);
			if (newQualifiedState != null)
				msgs = ((InternalEObject) newQualifiedState).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE, null, msgs);
			msgs = basicSetQualifiedState(newQualifiedState, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE,
					newQualifiedState, newQualifiedState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE:
			return basicSetQualifiedState(null, msgs);
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
		case ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE:
			return getQualifiedState();
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
		case ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE:
			setQualifiedState((QualifiedErrorBehaviorState) newValue);
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
		case ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE:
			setQualifiedState((QualifiedErrorBehaviorState) null);
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
		case ErrorModelPackage.SCONDITION_ELEMENT__QUALIFIED_STATE:
			return qualifiedState != null;
		}
		return super.eIsSet(featureID);
	}

} // SConditionElementImpl
