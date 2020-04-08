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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End To End Flow Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getFlowElements <em>Flow Element</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getInSystemOperationModes <em>In System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getEndToEndFlow <em>End To End Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EndToEndFlowInstanceImpl extends FlowElementInstanceImpl implements EndToEndFlowInstance {
	/**
	 * The cached value of the '{@link #getFlowElements() <em>Flow Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowElements()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowElementInstance> flowElements;

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
	 * The cached value of the '{@link #getInSystemOperationModes() <em>In System Operation Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSystemOperationModes()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemOperationMode> inSystemOperationModes;

	/**
	 * The cached value of the '{@link #getEndToEndFlow() <em>End To End Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndToEndFlow()
	 * @generated
	 * @ordered
	 */
	protected EndToEndFlow endToEndFlow;

	/**
	 * to temporarily hold the list of modes for each modal component&flow
	 */
	protected EList<EList<ModeInstance>> modesList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndToEndFlowInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.END_TO_END_FLOW_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FlowElementInstance> getFlowElements() {
		if (flowElements == null) {
			flowElements = new EObjectResolvingEList<FlowElementInstance>(FlowElementInstance.class, this,
					InstancePackage.END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT) {
				private static final long serialVersionUID = 1L;

				/*
				 * (non-Javadoc)
				 *
				 * @see org.eclipse.emf.ecore.util.EObjectEList#isUnique()
				 */
				protected boolean isUnique() {
					return false;
				}
			};
		}
		return flowElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlow getEndToEndFlow() {
		if (endToEndFlow != null && ((EObject) endToEndFlow).eIsProxy()) {
			InternalEObject oldEndToEndFlow = (InternalEObject) endToEndFlow;
			endToEndFlow = (EndToEndFlow) eResolveProxy(oldEndToEndFlow);
			if (endToEndFlow != oldEndToEndFlow) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW, oldEndToEndFlow, endToEndFlow));
				}
			}
		}
		return endToEndFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlow basicGetEndToEndFlow() {
		return endToEndFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndToEndFlow(EndToEndFlow newEndToEndFlow) {
		EndToEndFlow oldEndToEndFlow = endToEndFlow;
		endToEndFlow = newEndToEndFlow;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW, oldEndToEndFlow, endToEndFlow));
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
					InstancePackage.END_TO_END_FLOW_INSTANCE__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemOperationMode> getInSystemOperationModes() {
		if (inSystemOperationModes == null) {
			inSystemOperationModes = new EObjectResolvingEList<SystemOperationMode>(SystemOperationMode.class, this,
					InstancePackage.END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE);
		}
		return inSystemOperationModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT:
			return getFlowElements();
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_MODE:
			return getInModes();
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			return getInSystemOperationModes();
		case InstancePackage.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW:
			if (resolve) {
				return getEndToEndFlow();
			}
			return basicGetEndToEndFlow();
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
		case InstancePackage.END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT:
			getFlowElements().clear();
			getFlowElements().addAll((Collection<? extends FlowElementInstance>) newValue);
			return;
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends ModeInstance>) newValue);
			return;
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			getInSystemOperationModes().clear();
			getInSystemOperationModes().addAll((Collection<? extends SystemOperationMode>) newValue);
			return;
		case InstancePackage.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW:
			setEndToEndFlow((EndToEndFlow) newValue);
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
		case InstancePackage.END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT:
			getFlowElements().clear();
			return;
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_MODE:
			getInModes().clear();
			return;
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			getInSystemOperationModes().clear();
			return;
		case InstancePackage.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW:
			setEndToEndFlow((EndToEndFlow) null);
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
		case InstancePackage.END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT:
			return flowElements != null && !flowElements.isEmpty();
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case InstancePackage.END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			return inSystemOperationModes != null && !inSystemOperationModes.isEmpty();
		case InstancePackage.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW:
			return endToEndFlow != null;
		}
		return super.eIsSet(featureID);
	}

	public EList<EList<ModeInstance>> getModesList() {
		if (modesList == null) {
			modesList = new BasicEList<EList<ModeInstance>>();
		}
		return modesList;
	}
	public List<EndToEndFlow> getInstantiatedObjects() {
		return Collections.singletonList(getEndToEndFlow());
	}

	public boolean isActive(SystemOperationMode som) {
		if (InstanceUtil.isNoMode(som) || getInSystemOperationModes().contains(som)) {
			return getContainingComponentInstance().isActive(som);
		}
		return false;
	}

} // EndToEndFlowInstanceImpl
