/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.errormodel.instance.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.CompositeConditionExpression;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite State Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl#getDestinationTypeSet <em>Destination Type Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeStateInstanceImpl extends EMV2InstanceObjectImpl implements CompositeStateInstance {
	/**
	 * The cached value of the '{@link #getComposite() <em>Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposite()
	 * @generated
	 * @ordered
	 */
	protected CompositeState composite;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected CompositeConditionExpression condition;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected StateInstance destination;

	/**
	 * The cached value of the '{@link #getDestinationTypeSet() <em>Destination Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationTypeSet()
	 * @generated
	 * @ordered
	 */
	protected AnonymousTypeSet destinationTypeSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeStateInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.COMPOSITE_STATE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeState getComposite() {
		if (composite != null && composite.eIsProxy()) {
			InternalEObject oldComposite = (InternalEObject) composite;
			composite = (CompositeState) eResolveProxy(oldComposite);
			if (composite != oldComposite) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__COMPOSITE, oldComposite, composite));
				}
			}
		}
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState basicGetComposite() {
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComposite(CompositeState newComposite) {
		CompositeState oldComposite = composite;
		composite = newComposite;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__COMPOSITE, oldComposite, composite));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeConditionExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(CompositeConditionExpression newCondition, NotificationChain msgs) {
		CompositeConditionExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION, oldCondition, newCondition);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(CompositeConditionExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null) {
				msgs = ((InternalEObject) condition).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION, null, msgs);
			}
			if (newCondition != null) {
				msgs = ((InternalEObject) newCondition).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION, null, msgs);
			}
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION, newCondition, newCondition));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateInstance getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (StateInstance) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION, oldDestination, destination));
				}
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateInstance basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestination(StateInstance newDestination) {
		StateInstance oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION, oldDestination, destination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet getDestinationTypeSet() {
		return destinationTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestinationTypeSet(AnonymousTypeSet newDestinationTypeSet,
			NotificationChain msgs) {
		AnonymousTypeSet oldDestinationTypeSet = destinationTypeSet;
		destinationTypeSet = newDestinationTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET, oldDestinationTypeSet,
					newDestinationTypeSet);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestinationTypeSet(AnonymousTypeSet newDestinationTypeSet) {
		if (newDestinationTypeSet != destinationTypeSet) {
			NotificationChain msgs = null;
			if (destinationTypeSet != null) {
				msgs = ((InternalEObject) destinationTypeSet).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET,
						null, msgs);
			}
			if (newDestinationTypeSet != null) {
				msgs = ((InternalEObject) newDestinationTypeSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET,
						null, msgs);
			}
			msgs = basicSetDestinationTypeSet(newDestinationTypeSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET, newDestinationTypeSet,
					newDestinationTypeSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public TypeTokenInstance getDestinationTypeToken() {
		var typeSet = getDestinationTypeSet();
		return typeSet == null ? null : typeSet.flatten().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION:
			return basicSetCondition(null, msgs);
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET:
			return basicSetDestinationTypeSet(null, msgs);
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
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__COMPOSITE:
			if (resolve) {
				return getComposite();
			}
			return basicGetComposite();
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION:
			return getCondition();
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION:
			if (resolve) {
				return getDestination();
			}
			return basicGetDestination();
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET:
			return getDestinationTypeSet();
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
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__COMPOSITE:
			setComposite((CompositeState) newValue);
			return;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION:
			setCondition((CompositeConditionExpression) newValue);
			return;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION:
			setDestination((StateInstance) newValue);
			return;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET:
			setDestinationTypeSet((AnonymousTypeSet) newValue);
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
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__COMPOSITE:
			setComposite((CompositeState) null);
			return;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION:
			setCondition((CompositeConditionExpression) null);
			return;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION:
			setDestination((StateInstance) null);
			return;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET:
			setDestinationTypeSet((AnonymousTypeSet) null);
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
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__COMPOSITE:
			return composite != null;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__CONDITION:
			return condition != null;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION:
			return destination != null;
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET:
			return destinationTypeSet != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<? extends NamedElement> getInstantiatedObjects() {
		return List.of(getComposite());
	}
} // CompositeStateInstanceImpl
