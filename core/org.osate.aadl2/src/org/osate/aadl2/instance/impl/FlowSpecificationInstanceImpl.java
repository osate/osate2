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
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Specification Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getFlowSpecification <em>Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getInModeTransitions <em>In Mode Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowSpecificationInstanceImpl extends FlowElementInstanceImpl implements FlowSpecificationInstance {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected FeatureInstance source;
	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected FeatureInstance destination;
	/**
	 * The cached value of the '{@link #getFlowSpecification() <em>Flow Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowSpecification()
	 * @generated
	 * @ordered
	 */
	protected FlowSpecification flowSpecification;

	/**
	 * The cached value of the '{@link #getInModes() <em>In Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> inModes;

	/**
	 * The cached value of the '{@link #getInModeTransitions() <em>In Mode Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> inModeTransitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowSpecificationInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(FeatureInstance newSource, NotificationChain msgs) {
		FeatureInstance oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE, oldSource, newSource);
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
	public void setSource(FeatureInstance newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this, InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC,
						FeatureInstance.class, msgs);
			}
			if (newSource != null) {
				msgs = ((InternalEObject) newSource).eInverseAdd(this, InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC,
						FeatureInstance.class, msgs);
			}
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE,
					newSource, newSource));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(FeatureInstance newDestination, NotificationChain msgs) {
		FeatureInstance oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION, oldDestination, newDestination);
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
	public void setDestination(FeatureInstance newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC, FeatureInstance.class, msgs);
			}
			if (newDestination != null) {
				msgs = ((InternalEObject) newDestination).eInverseAdd(this,
						InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC, FeatureInstance.class, msgs);
			}
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION, newDestination, newDestination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification getFlowSpecification() {
		if (flowSpecification != null && ((EObject) flowSpecification).eIsProxy()) {
			InternalEObject oldFlowSpecification = (InternalEObject) flowSpecification;
			flowSpecification = (FlowSpecification) eResolveProxy(oldFlowSpecification);
			if (flowSpecification != oldFlowSpecification) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION, oldFlowSpecification,
							flowSpecification));
				}
			}
		}
		return flowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification basicGetFlowSpecification() {
		return flowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowSpecification(FlowSpecification newFlowSpecification) {
		FlowSpecification oldFlowSpecification = flowSpecification;
		flowSpecification = newFlowSpecification;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION, oldFlowSpecification,
					flowSpecification));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeInstance> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<ModeInstance>(ModeInstance.class, this,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransitionInstance> getInModeTransitions() {
		if (inModeTransitions == null) {
			inModeTransitions = new EObjectResolvingEList<ModeTransitionInstance>(ModeTransitionInstance.class, this,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION);
		}
		return inModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this, InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC,
						FeatureInstance.class, msgs);
			}
			return basicSetSource((FeatureInstance) otherEnd, msgs);
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC, FeatureInstance.class, msgs);
			}
			return basicSetDestination((FeatureInstance) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			return basicSetSource(null, msgs);
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			return basicSetDestination(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			return getSource();
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			return getDestination();
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION:
			if (resolve) {
				return getFlowSpecification();
			}
			return basicGetFlowSpecification();
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE:
			return getInModes();
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION:
			return getInModeTransitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			setSource((FeatureInstance) newValue);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			setDestination((FeatureInstance) newValue);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION:
			setFlowSpecification((FlowSpecification) newValue);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends ModeInstance>) newValue);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION:
			getInModeTransitions().clear();
			getInModeTransitions().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			setSource((FeatureInstance) null);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			setDestination((FeatureInstance) null);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION:
			setFlowSpecification((FlowSpecification) null);
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE:
			getInModes().clear();
			return;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION:
			getInModeTransitions().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			return source != null;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			return destination != null;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION:
			return flowSpecification != null;
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION:
			return inModeTransitions != null && !inModeTransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	public List<FlowSpecification> getInstantiatedObjects() {
		return Collections.singletonList(getFlowSpecification());
	}

	public boolean isActive(SystemOperationMode som) {
		if (getInModes().isEmpty()) {
			return getContainingComponentInstance().isActive(som);
		}
		for (ModeInstance m : getInModes()) {
			if (som.getCurrentModes().contains(m)) {
				return getContainingComponentInstance().isActive(som);
			}
		}
		return false;
	}
	public boolean matchesIndex(List<ArrayRange> ranges) {
		/**
		 * FIX JD
		 * Hack to return the appropriate value in InstanceObject.findInstanceObjectsHelper
		 * This return the appropriate value to add the flow specifications
		 * in the list of the elements to add properties.
		 * Can create side effects, to be double checked.
		 *
		 * FIX bug #205
		 */
		if (ranges.size() == 0) {
			return true;
		}
		return false;
	}

} // FlowSpecificationInstanceImpl
