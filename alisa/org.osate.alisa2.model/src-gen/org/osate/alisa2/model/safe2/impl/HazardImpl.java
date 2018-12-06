/**
 */
package org.osate.alisa2.model.safe2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.Constraint;
import org.osate.alisa2.model.safe2.Hazard;
import org.osate.alisa2.model.safe2.Safe2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hazard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getAccident <em>Accident</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HazardImpl extends MinimalEObjectImpl.Container implements Hazard {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccident() <em>Accident</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccident()
	 * @generated
	 * @ordered
	 */
	protected Accident accident;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HazardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Safe2Package.Literals.HAZARD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accident getAccident() {
		if (accident != null && accident.eIsProxy()) {
			InternalEObject oldAccident = (InternalEObject)accident;
			accident = (Accident)eResolveProxy(oldAccident);
			if (accident != oldAccident) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Safe2Package.HAZARD__ACCIDENT, oldAccident, accident));
			}
		}
		return accident;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accident basicGetAccident() {
		return accident;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccident(Accident newAccident, NotificationChain msgs) {
		Accident oldAccident = accident;
		accident = newAccident;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__ACCIDENT, oldAccident, newAccident);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccident(Accident newAccident) {
		if (newAccident != accident) {
			NotificationChain msgs = null;
			if (accident != null)
				msgs = ((InternalEObject)accident).eInverseRemove(this, Safe2Package.ACCIDENT__HAZARD, Accident.class, msgs);
			if (newAccident != null)
				msgs = ((InternalEObject)newAccident).eInverseAdd(this, Safe2Package.ACCIDENT__HAZARD, Accident.class, msgs);
			msgs = basicSetAccident(newAccident, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__ACCIDENT, newAccident, newAccident));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectWithInverseResolvingEList<Constraint>(Constraint.class, this, Safe2Package.HAZARD__CONSTRAINT, Safe2Package.CONSTRAINT__HAZARD);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Safe2Package.HAZARD__ACCIDENT:
				if (accident != null)
					msgs = ((InternalEObject)accident).eInverseRemove(this, Safe2Package.ACCIDENT__HAZARD, Accident.class, msgs);
				return basicSetAccident((Accident)otherEnd, msgs);
			case Safe2Package.HAZARD__CONSTRAINT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraint()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Safe2Package.HAZARD__ACCIDENT:
				return basicSetAccident(null, msgs);
			case Safe2Package.HAZARD__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
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
			case Safe2Package.HAZARD__NAME:
				return getName();
			case Safe2Package.HAZARD__DESCRIPTION:
				return getDescription();
			case Safe2Package.HAZARD__ACCIDENT:
				if (resolve) return getAccident();
				return basicGetAccident();
			case Safe2Package.HAZARD__CONSTRAINT:
				return getConstraint();
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
			case Safe2Package.HAZARD__NAME:
				setName((String)newValue);
				return;
			case Safe2Package.HAZARD__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case Safe2Package.HAZARD__ACCIDENT:
				setAccident((Accident)newValue);
				return;
			case Safe2Package.HAZARD__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends Constraint>)newValue);
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
			case Safe2Package.HAZARD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Safe2Package.HAZARD__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case Safe2Package.HAZARD__ACCIDENT:
				setAccident((Accident)null);
				return;
			case Safe2Package.HAZARD__CONSTRAINT:
				getConstraint().clear();
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
			case Safe2Package.HAZARD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Safe2Package.HAZARD__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case Safe2Package.HAZARD__ACCIDENT:
				return accident != null;
			case Safe2Package.HAZARD__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //HazardImpl
