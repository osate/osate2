/**
 */
package org.osate.alisa2.model.safe2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.alisa2.model.safe2.Fundamental;
import org.osate.alisa2.model.safe2.Safe2Package;
import org.osate.alisa2.model.safe2.SystemOverview;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Overview</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.SystemOverviewImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.SystemOverviewImpl#getFundamentals <em>Fundamentals</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.SystemOverviewImpl#getTopLevelElement <em>Top Level Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemOverviewImpl extends MinimalEObjectImpl.Container implements SystemOverview {
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
	 * The cached value of the '{@link #getFundamentals() <em>Fundamentals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFundamentals()
	 * @generated
	 * @ordered
	 */
	protected EList<Fundamental> fundamentals;

	/**
	 * The cached value of the '{@link #getTopLevelElement() <em>Top Level Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelElement()
	 * @generated
	 * @ordered
	 */
	protected ComponentClassifier topLevelElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOverviewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Safe2Package.Literals.SYSTEM_OVERVIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.SYSTEM_OVERVIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Fundamental> getFundamentals() {
		if (fundamentals == null) {
			fundamentals = new EObjectContainmentEList<Fundamental>(Fundamental.class, this, Safe2Package.SYSTEM_OVERVIEW__FUNDAMENTALS);
		}
		return fundamentals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentClassifier getTopLevelElement() {
		if (topLevelElement != null && ((EObject)topLevelElement).eIsProxy()) {
			InternalEObject oldTopLevelElement = (InternalEObject)topLevelElement;
			topLevelElement = (ComponentClassifier)eResolveProxy(oldTopLevelElement);
			if (topLevelElement != oldTopLevelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Safe2Package.SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT, oldTopLevelElement, topLevelElement));
			}
		}
		return topLevelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentClassifier basicGetTopLevelElement() {
		return topLevelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopLevelElement(ComponentClassifier newTopLevelElement) {
		ComponentClassifier oldTopLevelElement = topLevelElement;
		topLevelElement = newTopLevelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT, oldTopLevelElement, topLevelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Safe2Package.SYSTEM_OVERVIEW__FUNDAMENTALS:
				return ((InternalEList<?>)getFundamentals()).basicRemove(otherEnd, msgs);
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
			case Safe2Package.SYSTEM_OVERVIEW__NAME:
				return getName();
			case Safe2Package.SYSTEM_OVERVIEW__FUNDAMENTALS:
				return getFundamentals();
			case Safe2Package.SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT:
				if (resolve) return getTopLevelElement();
				return basicGetTopLevelElement();
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
			case Safe2Package.SYSTEM_OVERVIEW__NAME:
				setName((String)newValue);
				return;
			case Safe2Package.SYSTEM_OVERVIEW__FUNDAMENTALS:
				getFundamentals().clear();
				getFundamentals().addAll((Collection<? extends Fundamental>)newValue);
				return;
			case Safe2Package.SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT:
				setTopLevelElement((ComponentClassifier)newValue);
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
			case Safe2Package.SYSTEM_OVERVIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Safe2Package.SYSTEM_OVERVIEW__FUNDAMENTALS:
				getFundamentals().clear();
				return;
			case Safe2Package.SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT:
				setTopLevelElement((ComponentClassifier)null);
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
			case Safe2Package.SYSTEM_OVERVIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Safe2Package.SYSTEM_OVERVIEW__FUNDAMENTALS:
				return fundamentals != null && !fundamentals.isEmpty();
			case Safe2Package.SYSTEM_OVERVIEW__TOP_LEVEL_ELEMENT:
				return topLevelElement != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SystemOverviewImpl
