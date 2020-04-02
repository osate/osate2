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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.instance.impl.AnnexInstanceImpl;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Annex Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getPropagationPoints <em>Propagation Points</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getErrorPropagationConditions <em>Error Propagation Conditions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getErrorDetections <em>Error Detections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getErrorFlows <em>Error Flows</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getComposites <em>Composites</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getPropagationPaths <em>Propagation Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2AnnexInstanceImpl extends AnnexInstanceImpl implements EMV2AnnexInstance {
	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<StateTransitionInstance> transitions;

	/**
	 * The cached value of the '{@link #getPropagationPoints() <em>Propagation Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationPointInstance> propagationPoints;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<EventInstance> events;

	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachineInstance stateMachine;

	/**
	 * The cached value of the '{@link #getErrorPropagationConditions() <em>Error Propagation Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorPropagationConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorPropagationConditionInstance> errorPropagationConditions;

	/**
	 * The cached value of the '{@link #getErrorDetections() <em>Error Detections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorDetections()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorDetectionInstance> errorDetections;

	/**
	 * The cached value of the '{@link #getErrorFlows() <em>Error Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorFlowInstance> errorFlows;

	/**
	 * The cached value of the '{@link #getComposites() <em>Composites</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposites()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeStateInstance> composites;

	/**
	 * The cached value of the '{@link #getPropagationPaths() <em>Propagation Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationPathInstance> propagationPaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMV2AnnexInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.EMV2_ANNEX_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StateTransitionInstance> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<StateTransitionInstance>(StateTransitionInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropagationPointInstance> getPropagationPoints() {
		if (propagationPoints == null) {
			propagationPoints = new EObjectContainmentEList<PropagationPointInstance>(PropagationPointInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS);
		}
		return propagationPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventInstance> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<EventInstance>(EventInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachineInstance getStateMachine() {
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateMachine(StateMachineInstance newStateMachine, NotificationChain msgs) {
		StateMachineInstance oldStateMachine = stateMachine;
		stateMachine = newStateMachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, oldStateMachine, newStateMachine);
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
	public void setStateMachine(StateMachineInstance newStateMachine) {
		if (newStateMachine != stateMachine) {
			NotificationChain msgs = null;
			if (stateMachine != null)
				msgs = ((InternalEObject)stateMachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, null, msgs);
			if (newStateMachine != null)
				msgs = ((InternalEObject)newStateMachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, null, msgs);
			msgs = basicSetStateMachine(newStateMachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE, newStateMachine, newStateMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorPropagationConditionInstance> getErrorPropagationConditions() {
		if (errorPropagationConditions == null) {
			errorPropagationConditions = new EObjectContainmentEList<ErrorPropagationConditionInstance>(ErrorPropagationConditionInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS);
		}
		return errorPropagationConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorDetectionInstance> getErrorDetections() {
		if (errorDetections == null) {
			errorDetections = new EObjectContainmentEList<ErrorDetectionInstance>(ErrorDetectionInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS);
		}
		return errorDetections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorFlowInstance> getErrorFlows() {
		if (errorFlows == null) {
			errorFlows = new EObjectContainmentEList<ErrorFlowInstance>(ErrorFlowInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS);
		}
		return errorFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CompositeStateInstance> getComposites() {
		if (composites == null) {
			composites = new EObjectContainmentEList<CompositeStateInstance>(CompositeStateInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES);
		}
		return composites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropagationPathInstance> getPropagationPaths() {
		if (propagationPaths == null) {
			propagationPaths = new EObjectContainmentEList<PropagationPathInstance>(PropagationPathInstance.class, this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS);
		}
		return propagationPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
				return ((InternalEList<?>)getPropagationPoints()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				return basicSetStateMachine(null, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS:
				return ((InternalEList<?>)getErrorPropagationConditions()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS:
				return ((InternalEList<?>)getErrorDetections()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
				return ((InternalEList<?>)getErrorFlows()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				return ((InternalEList<?>)getComposites()).basicRemove(otherEnd, msgs);
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
				return ((InternalEList<?>)getPropagationPaths()).basicRemove(otherEnd, msgs);
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
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				return getTransitions();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
				return getPropagationPoints();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				return getEvents();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				return getStateMachine();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS:
				return getErrorPropagationConditions();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS:
				return getErrorDetections();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
				return getErrorFlows();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				return getComposites();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
				return getPropagationPaths();
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
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends StateTransitionInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
				getPropagationPoints().clear();
				getPropagationPoints().addAll((Collection<? extends PropagationPointInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends EventInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				setStateMachine((StateMachineInstance)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS:
				getErrorPropagationConditions().clear();
				getErrorPropagationConditions().addAll((Collection<? extends ErrorPropagationConditionInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS:
				getErrorDetections().clear();
				getErrorDetections().addAll((Collection<? extends ErrorDetectionInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
				getErrorFlows().clear();
				getErrorFlows().addAll((Collection<? extends ErrorFlowInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				getComposites().clear();
				getComposites().addAll((Collection<? extends CompositeStateInstance>)newValue);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
				getPropagationPaths().clear();
				getPropagationPaths().addAll((Collection<? extends PropagationPathInstance>)newValue);
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
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				getTransitions().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
				getPropagationPoints().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				getEvents().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				setStateMachine((StateMachineInstance)null);
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS:
				getErrorPropagationConditions().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS:
				getErrorDetections().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
				getErrorFlows().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				getComposites().clear();
				return;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
				getPropagationPaths().clear();
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
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
				return propagationPoints != null && !propagationPoints.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
				return events != null && !events.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE:
				return stateMachine != null;
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS:
				return errorPropagationConditions != null && !errorPropagationConditions.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS:
				return errorDetections != null && !errorDetections.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
				return errorFlows != null && !errorFlows.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
				return composites != null && !composites.isEmpty();
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
				return propagationPaths != null && !propagationPaths.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EMV2AnnexInstanceImpl
