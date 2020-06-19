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
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Transition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl#getModeTransition <em>Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl#getTriggers <em>Trigger</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeTransitionInstanceImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeTransitionInstanceImpl extends ConnectionInstanceEndImpl implements ModeTransitionInstance {
	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ModeInstance destination;
	/**
	 * The cached value of the '{@link #getModeTransition() <em>Mode Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeTransition()
	 * @generated
	 * @ordered
	 */
	protected ModeTransition modeTransition;

	/**
	 * The cached value of the '{@link #getTriggers() <em>Trigger</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureInstance> triggers;
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ModeInstance source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeTransitionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.MODE_TRANSITION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeInstance getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(ModeInstance newDestination, NotificationChain msgs) {
		ModeInstance oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION, oldDestination, newDestination);
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
	public void setDestination(ModeInstance newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION, ModeInstance.class, msgs);
			}
			if (newDestination != null) {
				msgs = ((InternalEObject) newDestination).eInverseAdd(this,
						InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION, ModeInstance.class, msgs);
			}
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION,
					newDestination, newDestination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeTransition getModeTransition() {
		if (modeTransition != null && ((EObject) modeTransition).eIsProxy()) {
			InternalEObject oldModeTransition = (InternalEObject) modeTransition;
			modeTransition = (ModeTransition) eResolveProxy(oldModeTransition);
			if (modeTransition != oldModeTransition) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.MODE_TRANSITION_INSTANCE__MODE_TRANSITION, oldModeTransition,
							modeTransition));
				}
			}
		}
		return modeTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeTransition basicGetModeTransition() {
		return modeTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModeTransition(ModeTransition newModeTransition) {
		ModeTransition oldModeTransition = modeTransition;
		modeTransition = newModeTransition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.MODE_TRANSITION_INSTANCE__MODE_TRANSITION, oldModeTransition, modeTransition));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureInstance> getTriggers() {
		if (triggers == null) {
			triggers = new EObjectResolvingEList<FeatureInstance>(FeatureInstance.class, this,
					InstancePackage.MODE_TRANSITION_INSTANCE__TRIGGER);
		}
		return triggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeInstance getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ModeInstance newSource, NotificationChain msgs) {
		ModeInstance oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE, oldSource, newSource);
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
	public void setSource(ModeInstance newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this,
						InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION, ModeInstance.class, msgs);
			}
			if (newSource != null) {
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION, ModeInstance.class, msgs);
			}
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE,
					newSource, newSource));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION:
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION, ModeInstance.class, msgs);
			}
			return basicSetDestination((ModeInstance) otherEnd, msgs);
		case InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE:
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this,
						InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION, ModeInstance.class, msgs);
			}
			return basicSetSource((ModeInstance) otherEnd, msgs);
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
		case InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION:
			return basicSetDestination(null, msgs);
		case InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE:
			return basicSetSource(null, msgs);
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
		case InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION:
			return getDestination();
		case InstancePackage.MODE_TRANSITION_INSTANCE__MODE_TRANSITION:
			if (resolve) {
				return getModeTransition();
			}
			return basicGetModeTransition();
		case InstancePackage.MODE_TRANSITION_INSTANCE__TRIGGER:
			return getTriggers();
		case InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE:
			return getSource();
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
		case InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION:
			setDestination((ModeInstance) newValue);
			return;
		case InstancePackage.MODE_TRANSITION_INSTANCE__MODE_TRANSITION:
			setModeTransition((ModeTransition) newValue);
			return;
		case InstancePackage.MODE_TRANSITION_INSTANCE__TRIGGER:
			getTriggers().clear();
			getTriggers().addAll((Collection<? extends FeatureInstance>) newValue);
			return;
		case InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE:
			setSource((ModeInstance) newValue);
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
		case InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION:
			setDestination((ModeInstance) null);
			return;
		case InstancePackage.MODE_TRANSITION_INSTANCE__MODE_TRANSITION:
			setModeTransition((ModeTransition) null);
			return;
		case InstancePackage.MODE_TRANSITION_INSTANCE__TRIGGER:
			getTriggers().clear();
			return;
		case InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE:
			setSource((ModeInstance) null);
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
		case InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION:
			return destination != null;
		case InstancePackage.MODE_TRANSITION_INSTANCE__MODE_TRANSITION:
			return modeTransition != null;
		case InstancePackage.MODE_TRANSITION_INSTANCE__TRIGGER:
			return triggers != null && !triggers.isEmpty();
		case InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE:
			return source != null;
		}
		return super.eIsSet(featureID);
	}
	public List<? extends NamedElement> getInstantiatedObjects() {
		return Collections.singletonList(getModeTransition());
	}

	public boolean isActive(SystemOperationMode som) {
		return getContainingComponentInstance().isActive(som);
	}

} // ModeTransitionInstanceImpl
