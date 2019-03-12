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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.Subcomponent;
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
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getExplanations <em>Explanations</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getAccident <em>Accident</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getEnvironmentElement <em>Environment Element</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getSystemElement <em>System Element</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.HazardImpl#getHazardousFactor <em>Hazardous Factor</em>}</li>
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
	 * The cached value of the '{@link #getExplanations() <em>Explanations</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplanations()
	 * @generated
	 * @ordered
	 */
	protected EList<String> explanations;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraint;

	/**
	 * The cached value of the '{@link #getEnvironmentElement() <em>Environment Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironmentElement()
	 * @generated
	 * @ordered
	 */
	protected AbstractSubcomponent environmentElement;

	/**
	 * The cached value of the '{@link #getSystemElement() <em>System Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemElement()
	 * @generated
	 * @ordered
	 */
	protected Subcomponent systemElement;

	/**
	 * The default value of the '{@link #getHazardousFactor() <em>Hazardous Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardousFactor()
	 * @generated
	 * @ordered
	 */
	protected static final String HAZARDOUS_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHazardousFactor() <em>Hazardous Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardousFactor()
	 * @generated
	 * @ordered
	 */
	protected String hazardousFactor = HAZARDOUS_FACTOR_EDEFAULT;

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
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public EList<String> getExplanations() {
		if (explanations == null) {
			explanations = new EDataTypeUniqueEList<String>(String.class, this, Safe2Package.HAZARD__EXPLANATIONS);
		}
		return explanations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Accident getAccident() {
		if (eContainerFeatureID() != Safe2Package.HAZARD__ACCIDENT) return null;
		return (Accident)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccident(Accident newAccident, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAccident, Safe2Package.HAZARD__ACCIDENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccident(Accident newAccident) {
		if (newAccident != eInternalContainer() || (eContainerFeatureID() != Safe2Package.HAZARD__ACCIDENT && newAccident != null)) {
			if (EcoreUtil.isAncestor(this, newAccident))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
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
	@Override
	public EList<Constraint> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentWithInverseEList<Constraint>(Constraint.class, this, Safe2Package.HAZARD__CONSTRAINT, Safe2Package.CONSTRAINT__HAZARD);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractSubcomponent getEnvironmentElement() {
		if (environmentElement != null && ((EObject)environmentElement).eIsProxy()) {
			InternalEObject oldEnvironmentElement = (InternalEObject)environmentElement;
			environmentElement = (AbstractSubcomponent)eResolveProxy(oldEnvironmentElement);
			if (environmentElement != oldEnvironmentElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Safe2Package.HAZARD__ENVIRONMENT_ELEMENT, oldEnvironmentElement, environmentElement));
			}
		}
		return environmentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSubcomponent basicGetEnvironmentElement() {
		return environmentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnvironmentElement(AbstractSubcomponent newEnvironmentElement) {
		AbstractSubcomponent oldEnvironmentElement = environmentElement;
		environmentElement = newEnvironmentElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__ENVIRONMENT_ELEMENT, oldEnvironmentElement, environmentElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Subcomponent getSystemElement() {
		if (systemElement != null && ((EObject)systemElement).eIsProxy()) {
			InternalEObject oldSystemElement = (InternalEObject)systemElement;
			systemElement = (Subcomponent)eResolveProxy(oldSystemElement);
			if (systemElement != oldSystemElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Safe2Package.HAZARD__SYSTEM_ELEMENT, oldSystemElement, systemElement));
			}
		}
		return systemElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent basicGetSystemElement() {
		return systemElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemElement(Subcomponent newSystemElement) {
		Subcomponent oldSystemElement = systemElement;
		systemElement = newSystemElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__SYSTEM_ELEMENT, oldSystemElement, systemElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHazardousFactor() {
		return hazardousFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHazardousFactor(String newHazardousFactor) {
		String oldHazardousFactor = hazardousFactor;
		hazardousFactor = newHazardousFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.HAZARD__HAZARDOUS_FACTOR, oldHazardousFactor, hazardousFactor));
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Safe2Package.HAZARD__ACCIDENT:
				return eInternalContainer().eInverseRemove(this, Safe2Package.ACCIDENT__HAZARD, Accident.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case Safe2Package.HAZARD__EXPLANATIONS:
				return getExplanations();
			case Safe2Package.HAZARD__ACCIDENT:
				return getAccident();
			case Safe2Package.HAZARD__CONSTRAINT:
				return getConstraint();
			case Safe2Package.HAZARD__ENVIRONMENT_ELEMENT:
				if (resolve) return getEnvironmentElement();
				return basicGetEnvironmentElement();
			case Safe2Package.HAZARD__SYSTEM_ELEMENT:
				if (resolve) return getSystemElement();
				return basicGetSystemElement();
			case Safe2Package.HAZARD__HAZARDOUS_FACTOR:
				return getHazardousFactor();
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
			case Safe2Package.HAZARD__EXPLANATIONS:
				getExplanations().clear();
				getExplanations().addAll((Collection<? extends String>)newValue);
				return;
			case Safe2Package.HAZARD__ACCIDENT:
				setAccident((Accident)newValue);
				return;
			case Safe2Package.HAZARD__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case Safe2Package.HAZARD__ENVIRONMENT_ELEMENT:
				setEnvironmentElement((AbstractSubcomponent)newValue);
				return;
			case Safe2Package.HAZARD__SYSTEM_ELEMENT:
				setSystemElement((Subcomponent)newValue);
				return;
			case Safe2Package.HAZARD__HAZARDOUS_FACTOR:
				setHazardousFactor((String)newValue);
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
			case Safe2Package.HAZARD__EXPLANATIONS:
				getExplanations().clear();
				return;
			case Safe2Package.HAZARD__ACCIDENT:
				setAccident((Accident)null);
				return;
			case Safe2Package.HAZARD__CONSTRAINT:
				getConstraint().clear();
				return;
			case Safe2Package.HAZARD__ENVIRONMENT_ELEMENT:
				setEnvironmentElement((AbstractSubcomponent)null);
				return;
			case Safe2Package.HAZARD__SYSTEM_ELEMENT:
				setSystemElement((Subcomponent)null);
				return;
			case Safe2Package.HAZARD__HAZARDOUS_FACTOR:
				setHazardousFactor(HAZARDOUS_FACTOR_EDEFAULT);
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
			case Safe2Package.HAZARD__EXPLANATIONS:
				return explanations != null && !explanations.isEmpty();
			case Safe2Package.HAZARD__ACCIDENT:
				return getAccident() != null;
			case Safe2Package.HAZARD__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
			case Safe2Package.HAZARD__ENVIRONMENT_ELEMENT:
				return environmentElement != null;
			case Safe2Package.HAZARD__SYSTEM_ELEMENT:
				return systemElement != null;
			case Safe2Package.HAZARD__HAZARDOUS_FACTOR:
				return HAZARDOUS_FACTOR_EDEFAULT == null ? hazardousFactor != null : !HAZARDOUS_FACTOR_EDEFAULT.equals(hazardousFactor);
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
		result.append(", description: ");
		result.append(description);
		result.append(", explanations: ");
		result.append(explanations);
		result.append(", hazardousFactor: ");
		result.append(hazardousFactor);
		result.append(')');
		return result.toString();
	}

} //HazardImpl
