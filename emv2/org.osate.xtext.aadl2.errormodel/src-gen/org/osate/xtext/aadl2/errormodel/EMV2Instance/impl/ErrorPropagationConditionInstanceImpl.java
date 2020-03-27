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
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;

import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation Condition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl#getEmv2Element <em>Emv2 Element</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl#getInStates <em>In States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl#isSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl#isSink <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorPropagationConditionInstanceImpl extends EMV2InstanceObjectImpl implements ErrorPropagationConditionInstance {
	/**
	 * The cached value of the '{@link #getEmv2Element() <em>Emv2 Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmv2Element()
	 * @generated
	 * @ordered
	 */
	protected OutgoingPropagationCondition emv2Element;

	/**
	 * The cached value of the '{@link #getInStates() <em>In States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInStates()
	 * @generated
	 * @ordered
	 */
	protected EList<StateInstance> inStates;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected ConstraintElement condition;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected ConstrainedInstanceObject action;

	/**
	 * The default value of the '{@link #isSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSource()
	 * @generated
	 * @ordered
	 */
	protected boolean source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSink() <em>Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSink()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSink() <em>Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSink()
	 * @generated
	 * @ordered
	 */
	protected boolean sink = SINK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorPropagationConditionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.ERROR_PROPAGATION_CONDITION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutgoingPropagationCondition getEmv2Element() {
		if (emv2Element != null && emv2Element.eIsProxy()) {
			InternalEObject oldEmv2Element = (InternalEObject)emv2Element;
			emv2Element = (OutgoingPropagationCondition)eResolveProxy(oldEmv2Element);
			if (emv2Element != oldEmv2Element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT, oldEmv2Element, emv2Element));
			}
		}
		return emv2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutgoingPropagationCondition basicGetEmv2Element() {
		return emv2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmv2Element(OutgoingPropagationCondition newEmv2Element) {
		OutgoingPropagationCondition oldEmv2Element = emv2Element;
		emv2Element = newEmv2Element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT, oldEmv2Element, emv2Element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StateInstance> getInStates() {
		if (inStates == null) {
			inStates = new EObjectResolvingEList<StateInstance>(StateInstance.class, this, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES);
		}
		return inStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintElement getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(ConstraintElement newCondition, NotificationChain msgs) {
		ConstraintElement oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION, oldCondition, newCondition);
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
	public void setCondition(ConstraintElement newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstrainedInstanceObject getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (ConstrainedInstanceObject)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstrainedInstanceObject basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAction(ConstrainedInstanceObject newAction) {
		ConstrainedInstanceObject oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(boolean newSource) {
		boolean oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSink() {
		return sink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSink(boolean newSink) {
		boolean oldSink = sink;
		sink = newSink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SINK, oldSink, sink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION:
				return basicSetCondition(null, msgs);
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
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT:
				if (resolve) return getEmv2Element();
				return basicGetEmv2Element();
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES:
				return getInStates();
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION:
				return getCondition();
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE:
				return isSource();
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SINK:
				return isSink();
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
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT:
				setEmv2Element((OutgoingPropagationCondition)newValue);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES:
				getInStates().clear();
				getInStates().addAll((Collection<? extends StateInstance>)newValue);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION:
				setCondition((ConstraintElement)newValue);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__ACTION:
				setAction((ConstrainedInstanceObject)newValue);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE:
				setSource((Boolean)newValue);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SINK:
				setSink((Boolean)newValue);
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
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT:
				setEmv2Element((OutgoingPropagationCondition)null);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES:
				getInStates().clear();
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION:
				setCondition((ConstraintElement)null);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__ACTION:
				setAction((ConstrainedInstanceObject)null);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SINK:
				setSink(SINK_EDEFAULT);
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
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT:
				return emv2Element != null;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES:
				return inStates != null && !inStates.isEmpty();
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION:
				return condition != null;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__ACTION:
				return action != null;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE:
				return source != SOURCE_EDEFAULT;
			case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE__SINK:
				return sink != SINK_EDEFAULT;
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
		result.append(" (source: ");
		result.append(source);
		result.append(", sink: ");
		result.append(sink);
		result.append(')');
		return result.toString();
	}

} //ErrorPropagationConditionInstanceImpl
