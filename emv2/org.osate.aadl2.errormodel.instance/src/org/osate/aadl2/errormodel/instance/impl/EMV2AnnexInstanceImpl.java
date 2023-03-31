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
package org.osate.aadl2.errormodel.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Property;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.DetectionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.ModeMappingInstance;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineProperties;
import org.osate.aadl2.errormodel.instance.TransitionInstance;
import org.osate.aadl2.instance.impl.AnnexInstanceImpl;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Annex Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getSubclauses <em>Subclauses</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getPropagations <em>Propagations</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getErrorFlows <em>Error Flows</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getPropagationPaths <em>Propagation Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getDetections <em>Detections</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getModeMappings <em>Mode Mappings</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getComposites <em>Composites</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getPropagationPoints <em>Propagation Points</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl#getStateMachineProperties <em>State Machine Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2AnnexInstanceImpl extends AnnexInstanceImpl implements EMV2AnnexInstance {
	/**
	 * The cached value of the '{@link #getSubclauses() <em>Subclauses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubclauses()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorModelSubclause> subclauses;

	/**
	 * The cached value of the '{@link #getPropagations() <em>Propagations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagations()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorPropagationInstance> propagations;

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
	 * The cached value of the '{@link #getPropagationPaths() <em>Propagation Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationPathInstance> propagationPaths;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<StateInstance> states;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected StateInstance initialState;

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
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionInstance> transitions;

	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<OutgoingPropagationConditionInstance> conditions;

	/**
	 * The cached value of the '{@link #getDetections() <em>Detections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetections()
	 * @generated
	 * @ordered
	 */
	protected EList<DetectionInstance> detections;

	/**
	 * The cached value of the '{@link #getModeMappings() <em>Mode Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeMappingInstance> modeMappings;

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
	 * The cached value of the '{@link #getPropagationPoints() <em>Propagation Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<PropagationPointInstance> propagationPoints;

	/**
	 * The cached value of the '{@link #getStateMachineProperties() <em>State Machine Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachineProperties()
	 * @generated
	 * @ordered
	 */
	protected StateMachineProperties stateMachineProperties;

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
	public EList<ErrorModelSubclause> getSubclauses() {
		if (subclauses == null) {
			subclauses = new EObjectResolvingEList<>(ErrorModelSubclause.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__SUBCLAUSES);
		}
		return subclauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransitionInstance> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<>(TransitionInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OutgoingPropagationConditionInstance> getConditions() {
		if (conditions == null) {
			conditions = new EObjectContainmentEList<>(
					OutgoingPropagationConditionInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropagationPointInstance> getPropagationPoints() {
		if (propagationPoints == null) {
			propagationPoints = new EObjectContainmentEList<>(PropagationPointInstance.class,
					this, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS);
		}
		return propagationPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachineProperties getStateMachineProperties() {
		return stateMachineProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateMachineProperties(StateMachineProperties newStateMachineProperties,
			NotificationChain msgs) {
		StateMachineProperties oldStateMachineProperties = stateMachineProperties;
		stateMachineProperties = newStateMachineProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES, oldStateMachineProperties,
					newStateMachineProperties);
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
	public void setStateMachineProperties(StateMachineProperties newStateMachineProperties) {
		if (newStateMachineProperties != stateMachineProperties) {
			NotificationChain msgs = null;
			if (stateMachineProperties != null) {
				msgs = ((InternalEObject) stateMachineProperties).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES,
						null, msgs);
			}
			if (newStateMachineProperties != null) {
				msgs = ((InternalEObject) newStateMachineProperties).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES,
						null, msgs);
			}
			msgs = basicSetStateMachineProperties(newStateMachineProperties, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES, newStateMachineProperties,
					newStateMachineProperties));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventInstance> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<>(EventInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DetectionInstance> getDetections() {
		if (detections == null) {
			detections = new EObjectContainmentEList<>(DetectionInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__DETECTIONS);
		}
		return detections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeMappingInstance> getModeMappings() {
		if (modeMappings == null) {
			modeMappings = new EObjectContainmentEList<>(ModeMappingInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__MODE_MAPPINGS);
		}
		return modeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorFlowInstance> getErrorFlows() {
		if (errorFlows == null) {
			errorFlows = new EObjectContainmentEList<>(ErrorFlowInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS);
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
			composites = new EObjectContainmentEList<>(CompositeStateInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES);
		}
		return composites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorPropagationInstance> getPropagations() {
		if (propagations == null) {
			propagations = new EObjectContainmentEList<>(ErrorPropagationInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATIONS);
		}
		return propagations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropagationPathInstance> getPropagationPaths() {
		if (propagationPaths == null) {
			propagationPaths = new EObjectContainmentEList<>(PropagationPathInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS);
		}
		return propagationPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StateInstance> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<>(StateInstance.class, this,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateInstance getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject) initialState;
			initialState = (StateInstance) eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.EMV2_ANNEX_INSTANCE__INITIAL_STATE, oldInitialState, initialState));
				}
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateInstance basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialState(StateInstance newInitialState) {
		StateInstance oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.EMV2_ANNEX_INSTANCE__INITIAL_STATE, oldInitialState, initialState));
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATIONS:
			return ((InternalEList<?>) getPropagations()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
			return ((InternalEList<?>) getErrorFlows()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
			return ((InternalEList<?>) getPropagationPaths()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATES:
			return ((InternalEList<?>) getStates()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
			return ((InternalEList<?>) getEvents()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
			return ((InternalEList<?>) getTransitions()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__CONDITIONS:
			return ((InternalEList<?>) getConditions()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__DETECTIONS:
			return ((InternalEList<?>) getDetections()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__MODE_MAPPINGS:
			return ((InternalEList<?>) getModeMappings()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
			return ((InternalEList<?>) getComposites()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
			return ((InternalEList<?>) getPropagationPoints()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES:
			return basicSetStateMachineProperties(null, msgs);
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__SUBCLAUSES:
			return getSubclauses();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATIONS:
			return getPropagations();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
			return getErrorFlows();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
			return getPropagationPaths();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATES:
			return getStates();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__INITIAL_STATE:
			if (resolve) {
				return getInitialState();
			}
			return basicGetInitialState();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
			return getEvents();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
			return getTransitions();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__CONDITIONS:
			return getConditions();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__DETECTIONS:
			return getDetections();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__MODE_MAPPINGS:
			return getModeMappings();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
			return getComposites();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
			return getPropagationPoints();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES:
			return getStateMachineProperties();
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__SUBCLAUSES:
			getSubclauses().clear();
			getSubclauses().addAll((Collection<? extends ErrorModelSubclause>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATIONS:
			getPropagations().clear();
			getPropagations().addAll((Collection<? extends ErrorPropagationInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
			getErrorFlows().clear();
			getErrorFlows().addAll((Collection<? extends ErrorFlowInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
			getPropagationPaths().clear();
			getPropagationPaths().addAll((Collection<? extends PropagationPathInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATES:
			getStates().clear();
			getStates().addAll((Collection<? extends StateInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__INITIAL_STATE:
			setInitialState((StateInstance) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
			getEvents().clear();
			getEvents().addAll((Collection<? extends EventInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
			getTransitions().clear();
			getTransitions().addAll((Collection<? extends TransitionInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__CONDITIONS:
			getConditions().clear();
			getConditions().addAll((Collection<? extends OutgoingPropagationConditionInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__DETECTIONS:
			getDetections().clear();
			getDetections().addAll((Collection<? extends DetectionInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__MODE_MAPPINGS:
			getModeMappings().clear();
			getModeMappings().addAll((Collection<? extends ModeMappingInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
			getComposites().clear();
			getComposites().addAll((Collection<? extends CompositeStateInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
			getPropagationPoints().clear();
			getPropagationPoints().addAll((Collection<? extends PropagationPointInstance>) newValue);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES:
			setStateMachineProperties((StateMachineProperties) newValue);
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__SUBCLAUSES:
			getSubclauses().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATIONS:
			getPropagations().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
			getErrorFlows().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
			getPropagationPaths().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATES:
			getStates().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__INITIAL_STATE:
			setInitialState((StateInstance) null);
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
			getEvents().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
			getTransitions().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__CONDITIONS:
			getConditions().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__DETECTIONS:
			getDetections().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__MODE_MAPPINGS:
			getModeMappings().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
			getComposites().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
			getPropagationPoints().clear();
			return;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES:
			setStateMachineProperties((StateMachineProperties) null);
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__SUBCLAUSES:
			return subclauses != null && !subclauses.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATIONS:
			return propagations != null && !propagations.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ERROR_FLOWS:
			return errorFlows != null && !errorFlows.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS:
			return propagationPaths != null && !propagationPaths.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATES:
			return states != null && !states.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__INITIAL_STATE:
			return initialState != null;
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__EVENTS:
			return events != null && !events.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__TRANSITIONS:
			return transitions != null && !transitions.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__CONDITIONS:
			return conditions != null && !conditions.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__DETECTIONS:
			return detections != null && !detections.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__MODE_MAPPINGS:
			return modeMappings != null && !modeMappings.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__COMPOSITES:
			return composites != null && !composites.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS:
			return propagationPoints != null && !propagationPoints.isEmpty();
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__STATE_MACHINE_PROPERTIES:
			return stateMachineProperties != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean acceptsProperty(Property property) {
		if (getSubclauses().isEmpty()) {
			return false;
		} else {
			return getSubclauses().get(0).acceptsProperty(property);
		}
	}
} // EMV2AnnexInstanceImpl
