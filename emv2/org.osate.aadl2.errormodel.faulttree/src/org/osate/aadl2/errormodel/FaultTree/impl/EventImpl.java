/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.FaultTree.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getSubEvents <em>Sub Events</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getK <em>K</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getAssignedProbability <em>Assigned Probability</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getComputedProbability <em>Computed Probability</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getRelatedInstanceObject <em>Related Instance Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getRelatedErrorType <em>Related Error Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getReferenceCount <em>Reference Count</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getSubEventLogic <em>Sub Event Logic</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getRelatedEMV2Object <em>Related EMV2 Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl#getScale <em>Scale</em>}</li>
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
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

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
	 * The default value of the '{@link #getAssignedProbability() <em>Assigned Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedProbability()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal ASSIGNED_PROBABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssignedProbability() <em>Assigned Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedProbability()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal assignedProbability = ASSIGNED_PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getComputedProbability() <em>Computed Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputedProbability()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal COMPUTED_PROBABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComputedProbability() <em>Computed Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputedProbability()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal computedProbability = COMPUTED_PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedInstanceObject() <em>Related Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedInstanceObject()
	 * @generated
	 * @ordered
	 */
	protected EObject relatedInstanceObject;

	/**
	 * The cached value of the '{@link #getRelatedErrorType() <em>Related Error Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedErrorType()
	 * @generated
	 * @ordered
	 */
	protected EObject relatedErrorType;

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
	protected static final LogicOperation SUB_EVENT_LOGIC_EDEFAULT = LogicOperation.OR;

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
	 * The cached value of the '{@link #getRelatedEMV2Object() <em>Related EMV2 Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedEMV2Object()
	 * @generated
	 * @ordered
	 */
	protected EObject relatedEMV2Object;

	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal SCALE_EDEFAULT = new BigDecimal("1.0");

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal scale = SCALE_EDEFAULT;

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
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__MESSAGE, oldMessage, message));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public int getK() {
		return k;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setK(int newK) {
		int oldK = k;
		k = newK;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__K, oldK, k));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getAssignedProbability() {
		return assignedProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssignedProbability(BigDecimal newAssignedProbability) {
		BigDecimal oldAssignedProbability = assignedProbability;
		assignedProbability = newAssignedProbability;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__ASSIGNED_PROBABILITY, oldAssignedProbability, assignedProbability));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns computed probability if present. Otherwise returns assigned probability
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public BigDecimal getProbability() {
		if (this.getComputedProbability() == null || this.getComputedProbability().compareTo(BigZero) == 0) {
			if (this.getAssignedProbability() != null) {
				return this.getAssignedProbability();
			} else {
				return BigZero;
			}
		}
		return this.getComputedProbability();
	}

	public static BigDecimal BigZero = BigDecimal.valueOf(0.0);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getComputedProbability() {
		return computedProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComputedProbability(BigDecimal newComputedProbability) {
		BigDecimal oldComputedProbability = computedProbability;
		computedProbability = newComputedProbability;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__COMPUTED_PROBABILITY, oldComputedProbability, computedProbability));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getRelatedInstanceObject() {
		if (relatedInstanceObject != null && relatedInstanceObject.eIsProxy()) {
			InternalEObject oldRelatedInstanceObject = (InternalEObject)relatedInstanceObject;
			relatedInstanceObject = eResolveProxy(oldRelatedInstanceObject);
			if (relatedInstanceObject != oldRelatedInstanceObject) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTreePackage.EVENT__RELATED_INSTANCE_OBJECT, oldRelatedInstanceObject, relatedInstanceObject));
				}
			}
		}
		return relatedInstanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRelatedInstanceObject() {
		return relatedInstanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedInstanceObject(EObject newRelatedInstanceObject) {
		EObject oldRelatedInstanceObject = relatedInstanceObject;
		relatedInstanceObject = newRelatedInstanceObject;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__RELATED_INSTANCE_OBJECT, oldRelatedInstanceObject, relatedInstanceObject));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getReferenceCount() {
		return referenceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceCount(int newReferenceCount) {
		int oldReferenceCount = referenceCount;
		referenceCount = newReferenceCount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__REFERENCE_COUNT, oldReferenceCount, referenceCount));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EventType newType) {
		EventType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__TYPE, oldType, type));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogicOperation getSubEventLogic() {
		return subEventLogic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubEventLogic(LogicOperation newSubEventLogic) {
		LogicOperation oldSubEventLogic = subEventLogic;
		subEventLogic = newSubEventLogic == null ? SUB_EVENT_LOGIC_EDEFAULT : newSubEventLogic;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__SUB_EVENT_LOGIC, oldSubEventLogic, subEventLogic));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getRelatedEMV2Object() {
		if (relatedEMV2Object != null && relatedEMV2Object.eIsProxy()) {
			InternalEObject oldRelatedEMV2Object = (InternalEObject)relatedEMV2Object;
			relatedEMV2Object = eResolveProxy(oldRelatedEMV2Object);
			if (relatedEMV2Object != oldRelatedEMV2Object) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTreePackage.EVENT__RELATED_EMV2_OBJECT, oldRelatedEMV2Object, relatedEMV2Object));
				}
			}
		}
		return relatedEMV2Object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRelatedEMV2Object() {
		return relatedEMV2Object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedEMV2Object(EObject newRelatedEMV2Object) {
		EObject oldRelatedEMV2Object = relatedEMV2Object;
		relatedEMV2Object = newRelatedEMV2Object;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__RELATED_EMV2_OBJECT, oldRelatedEMV2Object, relatedEMV2Object));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(BigDecimal newScale) {
		BigDecimal oldScale = scale;
		scale = newScale;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__SCALE, oldScale, scale));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getRelatedErrorType() {
		if (relatedErrorType != null && relatedErrorType.eIsProxy()) {
			InternalEObject oldRelatedErrorType = (InternalEObject)relatedErrorType;
			relatedErrorType = eResolveProxy(oldRelatedErrorType);
			if (relatedErrorType != oldRelatedErrorType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FaultTreePackage.EVENT__RELATED_ERROR_TYPE, oldRelatedErrorType, relatedErrorType));
				}
			}
		}
		return relatedErrorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRelatedErrorType() {
		return relatedErrorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedErrorType(EObject newRelatedErrorType) {
		EObject oldRelatedErrorType = relatedErrorType;
		relatedErrorType = newRelatedErrorType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FaultTreePackage.EVENT__RELATED_ERROR_TYPE, oldRelatedErrorType, relatedErrorType));
		}
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
			case FaultTreePackage.EVENT__MESSAGE:
				return getMessage();
			case FaultTreePackage.EVENT__SUB_EVENTS:
				return getSubEvents();
			case FaultTreePackage.EVENT__K:
				return getK();
			case FaultTreePackage.EVENT__ASSIGNED_PROBABILITY:
				return getAssignedProbability();
			case FaultTreePackage.EVENT__COMPUTED_PROBABILITY:
				return getComputedProbability();
			case FaultTreePackage.EVENT__RELATED_INSTANCE_OBJECT:
				if (resolve) {
					return getRelatedInstanceObject();
				}
				return basicGetRelatedInstanceObject();
			case FaultTreePackage.EVENT__RELATED_ERROR_TYPE:
				if (resolve) {
					return getRelatedErrorType();
				}
				return basicGetRelatedErrorType();
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
				return getReferenceCount();
			case FaultTreePackage.EVENT__TYPE:
				return getType();
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
				return getSubEventLogic();
			case FaultTreePackage.EVENT__RELATED_EMV2_OBJECT:
				if (resolve) {
					return getRelatedEMV2Object();
				}
				return basicGetRelatedEMV2Object();
			case FaultTreePackage.EVENT__SCALE:
				return getScale();
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
			case FaultTreePackage.EVENT__MESSAGE:
				setMessage((String)newValue);
				return;
			case FaultTreePackage.EVENT__SUB_EVENTS:
				getSubEvents().clear();
				getSubEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case FaultTreePackage.EVENT__K:
				setK((Integer)newValue);
				return;
			case FaultTreePackage.EVENT__ASSIGNED_PROBABILITY:
				setAssignedProbability((BigDecimal)newValue);
				return;
			case FaultTreePackage.EVENT__COMPUTED_PROBABILITY:
				setComputedProbability((BigDecimal)newValue);
				return;
			case FaultTreePackage.EVENT__RELATED_INSTANCE_OBJECT:
				setRelatedInstanceObject((EObject)newValue);
				return;
			case FaultTreePackage.EVENT__RELATED_ERROR_TYPE:
				setRelatedErrorType((EObject)newValue);
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
			case FaultTreePackage.EVENT__RELATED_EMV2_OBJECT:
				setRelatedEMV2Object((EObject)newValue);
				return;
			case FaultTreePackage.EVENT__SCALE:
				setScale((BigDecimal)newValue);
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
			case FaultTreePackage.EVENT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__SUB_EVENTS:
				getSubEvents().clear();
				return;
			case FaultTreePackage.EVENT__K:
				setK(K_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__ASSIGNED_PROBABILITY:
				setAssignedProbability(ASSIGNED_PROBABILITY_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__COMPUTED_PROBABILITY:
				setComputedProbability(COMPUTED_PROBABILITY_EDEFAULT);
				return;
			case FaultTreePackage.EVENT__RELATED_INSTANCE_OBJECT:
				setRelatedInstanceObject((EObject)null);
				return;
			case FaultTreePackage.EVENT__RELATED_ERROR_TYPE:
				setRelatedErrorType((EObject)null);
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
			case FaultTreePackage.EVENT__RELATED_EMV2_OBJECT:
				setRelatedEMV2Object((EObject)null);
				return;
			case FaultTreePackage.EVENT__SCALE:
				setScale(SCALE_EDEFAULT);
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
			case FaultTreePackage.EVENT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case FaultTreePackage.EVENT__SUB_EVENTS:
				return subEvents != null && !subEvents.isEmpty();
			case FaultTreePackage.EVENT__K:
				return k != K_EDEFAULT;
			case FaultTreePackage.EVENT__ASSIGNED_PROBABILITY:
				return ASSIGNED_PROBABILITY_EDEFAULT == null ? assignedProbability != null : !ASSIGNED_PROBABILITY_EDEFAULT.equals(assignedProbability);
			case FaultTreePackage.EVENT__COMPUTED_PROBABILITY:
				return COMPUTED_PROBABILITY_EDEFAULT == null ? computedProbability != null : !COMPUTED_PROBABILITY_EDEFAULT.equals(computedProbability);
			case FaultTreePackage.EVENT__RELATED_INSTANCE_OBJECT:
				return relatedInstanceObject != null;
			case FaultTreePackage.EVENT__RELATED_ERROR_TYPE:
				return relatedErrorType != null;
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
				return referenceCount != REFERENCE_COUNT_EDEFAULT;
			case FaultTreePackage.EVENT__TYPE:
				return type != TYPE_EDEFAULT;
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
				return subEventLogic != SUB_EVENT_LOGIC_EDEFAULT;
			case FaultTreePackage.EVENT__RELATED_EMV2_OBJECT:
				return relatedEMV2Object != null;
			case FaultTreePackage.EVENT__SCALE:
				return SCALE_EDEFAULT == null ? scale != null : !SCALE_EDEFAULT.equals(scale);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FaultTreePackage.EVENT___GET_PROBABILITY:
				return getProbability();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", message: ");
		result.append(message);
		result.append(", k: ");
		result.append(k);
		result.append(", assignedProbability: ");
		result.append(assignedProbability);
		result.append(", computedProbability: ");
		result.append(computedProbability);
		result.append(", referenceCount: ");
		result.append(referenceCount);
		result.append(", type: ");
		result.append(type);
		result.append(", subEventLogic: ");
		result.append(subEventLogic);
		result.append(", scale: ");
		result.append(scale);
		result.append(')');
		return result.toString();
	}

} // EventImpl
