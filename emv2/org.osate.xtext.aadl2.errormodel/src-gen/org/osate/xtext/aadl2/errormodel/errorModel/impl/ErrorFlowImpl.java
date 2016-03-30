/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorFlowImpl#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorFlowImpl extends NamedElementImpl implements ErrorFlow {
	/**
	 * The cached value of the '{@link #getTypeTokenConstraint() <em>Type Token Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeTokenConstraint()
	 * @generated
	 * @ordered
	 */
	protected TypeSet typeTokenConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ErrorModelPackage.Literals.ERROR_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSet getTypeTokenConstraint() {
		return typeTokenConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeTokenConstraint(TypeSet newTypeTokenConstraint, NotificationChain msgs) {
		TypeSet oldTypeTokenConstraint = typeTokenConstraint;
		typeTokenConstraint = newTypeTokenConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT, oldTypeTokenConstraint,
					newTypeTokenConstraint);
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
	public void setTypeTokenConstraint(TypeSet newTypeTokenConstraint) {
		if (newTypeTokenConstraint != typeTokenConstraint) {
			NotificationChain msgs = null;
			if (typeTokenConstraint != null)
				msgs = ((InternalEObject) typeTokenConstraint).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT, null, msgs);
			if (newTypeTokenConstraint != null)
				msgs = ((InternalEObject) newTypeTokenConstraint).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT, null, msgs);
			msgs = basicSetTypeTokenConstraint(newTypeTokenConstraint, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT,
					newTypeTokenConstraint, newTypeTokenConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT:
			return basicSetTypeTokenConstraint(null, msgs);
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
		case ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT:
			return getTypeTokenConstraint();
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
		case ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT:
			setTypeTokenConstraint((TypeSet) newValue);
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
		case ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT:
			setTypeTokenConstraint((TypeSet) null);
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
		case ErrorModelPackage.ERROR_FLOW__TYPE_TOKEN_CONSTRAINT:
			return typeTokenConstraint != null;
		}
		return super.eIsSet(featureID);
	}

} // ErrorFlowImpl
