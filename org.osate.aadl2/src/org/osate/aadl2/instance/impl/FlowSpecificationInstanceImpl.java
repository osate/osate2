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
 *
 * $Id: FlowSpecificationInstanceImpl.java,v 1.2 2010-05-12 20:09:22 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getFlowSpecification <em>Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FlowSpecificationInstanceImpl#getInModeTransitions <em>In Mode Transition</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureInstance getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (FeatureInstance) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE, oldSource, source));
				}
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance basicGetSource() {
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
	@Override
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
	@Override
	public FeatureInstance getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (FeatureInstance) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION, oldDestination, destination));
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
	public FeatureInstance basicGetDestination() {
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE:
			if (resolve) {
				return getSource();
			}
			return basicGetSource();
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION:
			if (resolve) {
				return getDestination();
			}
			return basicGetDestination();
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
	@Override
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
	@Override
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
	@Override
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

	@Override
	public final List<SystemOperationMode> getExistsInModes() {
		// Modes always exist
		return null;
	}

	@Override
	public List<FlowSpecification> getInstantiatedObjects() {
		return Collections.singletonList(getFlowSpecification());
	}

	@Override
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

	@Override
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
