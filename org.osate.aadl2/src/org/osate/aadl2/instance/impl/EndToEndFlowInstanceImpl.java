/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: EndToEndFlowInstanceImpl.java,v 1.10 2010-05-07 20:01:28 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import java.util.ArrayList;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End To End Flow Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getFlowElements <em>Flow Element</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getInSystemOperationModes <em>In System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.EndToEndFlowInstanceImpl#getEndToEndFlow <em>End To End Flow</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.END_TO_END_FLOW_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
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
				@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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

	@Override
	public EList<EList<ModeInstance>> getModesList() {
		if (modesList == null) {
			modesList = new BasicEList<EList<ModeInstance>>();
		}
		return modesList;
	}

	@Override
	public List<SystemOperationMode> getExistsInModes() {
		// be overly cautious
		List<ModeInstance> inModes = getInModes();
		if (inModes == null || inModes.isEmpty()) {
			return null;
		} else {
			// TODO this code can be used to determine the SOM
			// /* inModes is a list of ModeInstances. We want all the SOMs that contain
			// * these mode instances.
			// */
			List<SystemOperationMode> processedModes = new ArrayList<SystemOperationMode>();
			for (SystemOperationMode som : getSystemInstance().getSystemOperationModes()) {
				for (ModeInstance mi : som.getCurrentModes()) {
					if (inModes.contains(mi)) {
						processedModes.add(som);
						break;
					}
				}
			}
			return processedModes;
			// return inModes;
		}
	}

	@Override
	public List<EndToEndFlow> getInstantiatedObjects() {
		return Collections.singletonList(getEndToEndFlow());
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		if (getInSystemOperationModes().contains(som)) {
			return getContainingComponentInstance().isActive(som);
		}
		return false;
	}

} // EndToEndFlowInstanceImpl
