/**
 */
package org.osate.aadl2.errormodel.FaultTree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTreePackage;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getSubEvents <em>Sub Events</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getK <em>K</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getRelatedObject <em>Related Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getReferenceCount <em>Reference Count</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getSubEventLogic <em>Sub Event Logic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventImpl extends MinimalEObjectImpl.Container implements Event {
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
	 * The cached value of the '{@link #getSubEvents() <em>Sub Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> subEvents;

	/**
	 * The default value of the '{@link #getK() <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected static final int K_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getK() <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected int k = K_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected double probability = PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedObject() <em>Related Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedObject()
	 * @generated
	 * @ordered
	 */
	protected EObject relatedObject;

	/**
	 * The default value of the '{@link #getReferenceCount() <em>Reference Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REFERENCE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReferenceCount() <em>Reference Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceCount()
	 * @generated
	 * @ordered
	 */
	protected int referenceCount = REFERENCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EventType TYPE_EDEFAULT = EventType.BASIC;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EventType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubEventLogic() <em>Sub Event Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubEventLogic()
	 * @generated
	 * @ordered
	 */
	protected static final LogicOperation SUB_EVENT_LOGIC_EDEFAULT = LogicOperation.NOOP;

	/**
	 * The cached value of the '{@link #getSubEventLogic() <em>Sub Event Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubEventLogic()
	 * @generated
	 * @ordered
	 */
	protected LogicOperation subEventLogic = SUB_EVENT_LOGIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FaultTreePackage.Literals.EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getSubEvents() {
		if (subEvents == null) {
			subEvents = new EObjectResolvingEList<Event>(Event.class, this, FaultTreePackage.EVENT__SUB_EVENTS);
		}
		return subEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getK() {
		return k;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setK(int newK) {
		int oldK = k;
		k = newK;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__K, oldK, k));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(double newProbability) {
		double oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__PROBABILITY, oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRelatedObject() {
		if (relatedObject != null && relatedObject.eIsProxy()) {
			InternalEObject oldRelatedObject = (InternalEObject)relatedObject;
			relatedObject = eResolveProxy(oldRelatedObject);
			if (relatedObject != oldRelatedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTreePackage.EVENT__RELATED_OBJECT, oldRelatedObject, relatedObject));
			}
		}
		return relatedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRelatedObject() {
		return relatedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedObject(EObject newRelatedObject) {
		EObject oldRelatedObject = relatedObject;
		relatedObject = newRelatedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__RELATED_OBJECT, oldRelatedObject, relatedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getReferenceCount() {
		return referenceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceCount(int newReferenceCount) {
		int oldReferenceCount = referenceCount;
		referenceCount = newReferenceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__REFERENCE_COUNT, oldReferenceCount, referenceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EventType newType) {
		EventType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicOperation getSubEventLogic() {
		return subEventLogic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubEventLogic(LogicOperation newSubEventLogic) {
		LogicOperation oldSubEventLogic = subEventLogic;
		subEventLogic = newSubEventLogic == null ? SUB_EVENT_LOGIC_EDEFAULT : newSubEventLogic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__SUB_EVENT_LOGIC, oldSubEventLogic, subEventLogic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FaultTreePackage.EVENT__NAME:
				return getName();
			case FaultTreePackage.EVENT__DESCRIPTION:
				return getDescription();
			case FaultTreePackage.EVENT__SUB_EVENTS:
				return getSubEvents();
			case FaultTreePackage.EVENT__K:
				return getK();
			case FaultTreePackage.EVENT__PROBABILITY:
				return getProbability();
			case FaultTreePackage.EVENT__RELATED_OBJECT:
				if (resolve) return getRelatedObject();
				return basicGetRelatedObject();
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
				return getReferenceCount();
			case FaultTreePackage.EVENT__TYPE:
				return getType();
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
				return getSubEventLogic();
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
			case FaultTreePackage.EVENT__NAME:
				setName((String)newValue);
				return;
			case FaultTreePackage.EVENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FaultTreePackage.EVENT__SUB_EVENTS:
				getSubEvents().clear();
				getSubEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case FaultTreePackage.EVENT__K:
				setK((Integer)newValue);
				return;
			case FaultTreePackage.EVENT__PROBABILITY:
				setProbability((Double)newValue);
				return;
			case FaultTreePackage.EVENT__RELATED_OBJECT:
				setRelatedObject((EObject)newValue);
				return;
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
				setReferenceCount((Integer)newValue);
				return;
			case FaultTreePackage.EVENT__TYPE:
				setType((EventType)newValue);
				return;
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
				setSubEventLogic((LogicOperation)newValue);
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
			case FaultTreePackage.EVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__SUB_EVENTS:
				getSubEvents().clear();
				return;
			case FaultTreePackage.EVENT__K:
				setK(K_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__RELATED_OBJECT:
				setRelatedObject((EObject)null);
				return;
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
				setReferenceCount(REFERENCE_COUNT_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
				setSubEventLogic(SUB_EVENT_LOGIC_EDEFAULT);
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
			case FaultTreePackage.EVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FaultTreePackage.EVENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FaultTreePackage.EVENT__SUB_EVENTS:
				return subEvents != null && !subEvents.isEmpty();
			case FaultTreePackage.EVENT__K:
				return k != K_EDEFAULT;
			case FaultTreePackage.EVENT__PROBABILITY:
				return probability != PROBABILITY_EDEFAULT;
			case FaultTreePackage.EVENT__RELATED_OBJECT:
				return relatedObject != null;
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
				return referenceCount != REFERENCE_COUNT_EDEFAULT;
			case FaultTreePackage.EVENT__TYPE:
				return type != TYPE_EDEFAULT;
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
				return subEventLogic != SUB_EVENT_LOGIC_EDEFAULT;
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
		result.append(", k: ");
		result.append(k);
		result.append(", probability: ");
		result.append(probability);
		result.append(", referenceCount: ");
		result.append(referenceCount);
		result.append(", type: ");
		result.append(type);
		result.append(", subEventLogic: ");
		result.append(subEventLogic);
		result.append(')');
		return result.toString();
	}

} //EventImpl
