/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.NamedElement;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repair Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.RepairEventImpl#getEventInitiator <em>Event Initiator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepairEventImpl extends ErrorBehaviorEventImpl implements RepairEvent {
	/**
	 * The cached value of the '{@link #getEventInitiator() <em>Event Initiator</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventInitiator()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> eventInitiator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ErrorModelPackage.Literals.REPAIR_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getEventInitiator() {
		if (eventInitiator == null) {
			eventInitiator = new EObjectResolvingEList<NamedElement>(NamedElement.class, this,
					ErrorModelPackage.REPAIR_EVENT__EVENT_INITIATOR);
		}
		return eventInitiator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ErrorModelPackage.REPAIR_EVENT__EVENT_INITIATOR:
			return getEventInitiator();
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
		case ErrorModelPackage.REPAIR_EVENT__EVENT_INITIATOR:
			getEventInitiator().clear();
			getEventInitiator().addAll((Collection<? extends NamedElement>) newValue);
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
		case ErrorModelPackage.REPAIR_EVENT__EVENT_INITIATOR:
			getEventInitiator().clear();
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
		case ErrorModelPackage.REPAIR_EVENT__EVENT_INITIATOR:
			return eventInitiator != null && !eventInitiator.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // RepairEventImpl
