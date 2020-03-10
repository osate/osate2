/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.instance.InstanceObject;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrained Instance Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl#getInstanceObject <em>Instance Object</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl#isOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstrainedInstanceObjectImpl extends EMV2InstanceObjectImpl implements ConstrainedInstanceObject {
	/**
	 * The cached value of the '{@link #getInstanceObject() <em>Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceObject()
	 * @generated
	 * @ordered
	 */
	protected InstanceObject instanceObject;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected Literal constraint;

	/**
	 * The default value of the '{@link #isOutgoing() <em>Outgoing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOutgoing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OUTGOING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOutgoing() <em>Outgoing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOutgoing()
	 * @generated
	 * @ordered
	 */
	protected boolean outgoing = OUTGOING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstrainedInstanceObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.CONSTRAINED_INSTANCE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstanceObject getInstanceObject() {
		if (instanceObject != null && instanceObject.eIsProxy()) {
			InternalEObject oldInstanceObject = (InternalEObject)instanceObject;
			instanceObject = (InstanceObject)eResolveProxy(oldInstanceObject);
			if (instanceObject != oldInstanceObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT, oldInstanceObject, instanceObject));
			}
		}
		return instanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceObject basicGetInstanceObject() {
		return instanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceObject(InstanceObject newInstanceObject) {
		InstanceObject oldInstanceObject = instanceObject;
		instanceObject = newInstanceObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT, oldInstanceObject, instanceObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraint(Literal newConstraint, NotificationChain msgs) {
		Literal oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT, oldConstraint, newConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstraint(Literal newConstraint) {
		if (newConstraint != constraint) {
			NotificationChain msgs = null;
			if (constraint != null)
				msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT, null, msgs);
			if (newConstraint != null)
				msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT, null, msgs);
			msgs = basicSetConstraint(newConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT, newConstraint, newConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOutgoing() {
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoing(boolean newOutgoing) {
		boolean oldOutgoing = outgoing;
		outgoing = newOutgoing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__OUTGOING, oldOutgoing, outgoing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				return basicSetConstraint(null, msgs);
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				if (resolve) return getInstanceObject();
				return basicGetInstanceObject();
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				return getConstraint();
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__OUTGOING:
				return isOutgoing();
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				setInstanceObject((InstanceObject)newValue);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				setConstraint((Literal)newValue);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__OUTGOING:
				setOutgoing((Boolean)newValue);
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				setInstanceObject((InstanceObject)null);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				setConstraint((Literal)null);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__OUTGOING:
				setOutgoing(OUTGOING_EDEFAULT);
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				return instanceObject != null;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				return constraint != null;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__OUTGOING:
				return outgoing != OUTGOING_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (outgoing: ");
		result.append(outgoing);
		result.append(')');
		return result.toString();
	}

} //ConstrainedInstanceObjectImpl
