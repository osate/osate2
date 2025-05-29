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
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.StateSource;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outgoing Propagation Condition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl#getOutgoingPropagationCondition <em>Outgoing Propagation Condition</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutgoingPropagationConditionInstanceImpl extends EMV2InstanceObjectImpl
		implements OutgoingPropagationConditionInstance {
	/**
	 * The cached value of the '{@link #getOutgoingPropagationCondition() <em>Outgoing Propagation Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingPropagationCondition()
	 * @generated
	 * @ordered
	 */
	protected OutgoingPropagationCondition outgoingPropagationCondition;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected StateSource source;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected ConditionExpressionInstance condition;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected OutgoingPropagationConditionDestination destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutgoingPropagationConditionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.OUTGOING_PROPAGATION_CONDITION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutgoingPropagationCondition getOutgoingPropagationCondition() {
		if (outgoingPropagationCondition != null && outgoingPropagationCondition.eIsProxy()) {
			InternalEObject oldOutgoingPropagationCondition = (InternalEObject) outgoingPropagationCondition;
			outgoingPropagationCondition = (OutgoingPropagationCondition) eResolveProxy(
					oldOutgoingPropagationCondition);
			if (outgoingPropagationCondition != oldOutgoingPropagationCondition) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION,
							oldOutgoingPropagationCondition, outgoingPropagationCondition));
				}
			}
		}
		return outgoingPropagationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutgoingPropagationCondition basicGetOutgoingPropagationCondition() {
		return outgoingPropagationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoingPropagationCondition(OutgoingPropagationCondition newOutgoingPropagationCondition) {
		OutgoingPropagationCondition oldOutgoingPropagationCondition = outgoingPropagationCondition;
		outgoingPropagationCondition = newOutgoingPropagationCondition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION,
					oldOutgoingPropagationCondition, outgoingPropagationCondition));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateSource getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(StateSource newSource, NotificationChain msgs) {
		StateSource oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE, oldSource, newSource);
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
	public void setSource(StateSource newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE,
						null, msgs);
			}
			if (newSource != null) {
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE,
						null, msgs);
			}
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE, newSource, newSource));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionExpressionInstance getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(ConditionExpressionInstance newCondition, NotificationChain msgs) {
		ConditionExpressionInstance oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION, oldCondition, newCondition);
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
	public void setCondition(ConditionExpressionInstance newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null) {
				msgs = ((InternalEObject) condition).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION,
						null, msgs);
			}
			if (newCondition != null) {
				msgs = ((InternalEObject) newCondition).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION,
						null, msgs);
			}
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION, newCondition,
					newCondition));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutgoingPropagationConditionDestination getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(OutgoingPropagationConditionDestination newDestination,
			NotificationChain msgs) {
		OutgoingPropagationConditionDestination oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION, oldDestination,
					newDestination);
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
	public void setDestination(OutgoingPropagationConditionDestination newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION, null, msgs);
			}
			if (newDestination != null) {
				msgs = ((InternalEObject) newDestination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION, null, msgs);
			}
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION, newDestination,
					newDestination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE:
			return basicSetSource(null, msgs);
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION:
			return basicSetCondition(null, msgs);
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION:
			return basicSetDestination(null, msgs);
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
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION:
			if (resolve) {
				return getOutgoingPropagationCondition();
			}
			return basicGetOutgoingPropagationCondition();
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE:
			return getSource();
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION:
			return getCondition();
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION:
			return getDestination();
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
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION:
			setOutgoingPropagationCondition((OutgoingPropagationCondition) newValue);
			return;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE:
			setSource((StateSource) newValue);
			return;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION:
			setCondition((ConditionExpressionInstance) newValue);
			return;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION:
			setDestination((OutgoingPropagationConditionDestination) newValue);
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
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION:
			setOutgoingPropagationCondition((OutgoingPropagationCondition) null);
			return;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE:
			setSource((StateSource) null);
			return;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION:
			setCondition((ConditionExpressionInstance) null);
			return;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION:
			setDestination((OutgoingPropagationConditionDestination) null);
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
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION:
			return outgoingPropagationCondition != null;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE:
			return source != null;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION:
			return condition != null;
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION:
			return destination != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<? extends NamedElement> getInstantiatedObjects() {
		return List.of(getOutgoingPropagationCondition());
	}
} // OutgoingPropagationConditionInstanceImpl
