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
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedFeatures <em>Owned Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedEventDataPorts <em>Owned Event Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedEventPorts <em>Owned Event Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedParameters <em>Owned Parameter</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedDataAccesses <em>Owned Data Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedSubprogramAccesses <em>Owned Subprogram Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramTypeImpl#getOwnedSubprogramGroupAccesses <em>Owned Subprogram Group Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubprogramTypeImpl extends ComponentTypeImpl implements SubprogramType {
	/**
	 * The cached value of the '{@link #getOwnedEventDataPorts() <em>Owned Event Data Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDataPort> ownedEventDataPorts;
	/**
	 * The cached value of the '{@link #getOwnedEventPorts() <em>Owned Event Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPort> ownedEventPorts;
	/**
	 * The cached value of the '{@link #getOwnedParameters() <em>Owned Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedParameters;
	/**
	 * The cached value of the '{@link #getOwnedDataAccesses() <em>Owned Data Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<DataAccess> ownedDataAccesses;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramAccesses() <em>Owned Subprogram Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramAccess> ownedSubprogramAccesses;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupAccesses() <em>Owned Subprogram Group Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupAccess> ownedSubprogramGroupAccesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getOwnedFeatures() {
		return new DerivedUnionEObjectEList<Feature>(Feature.class, this, Aadl2Package.SUBPROGRAM_TYPE__OWNED_FEATURE,
				OWNED_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedFeatures() <em>Owned Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_FEATURE_ESUBSETS = new int[] { Aadl2Package.SUBPROGRAM_TYPE__OWNED_FEATURE_GROUP,
			Aadl2Package.SUBPROGRAM_TYPE__OWNED_ABSTRACT_FEATURE, Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT,
			Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT, Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER,
			Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS, Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS,
			Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventDataPort> getOwnedEventDataPorts() {
		if (ownedEventDataPorts == null) {
			ownedEventDataPorts = new EObjectContainmentEList<EventDataPort>(EventDataPort.class, this,
					Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT);
		}
		return ownedEventDataPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDataPort createOwnedEventDataPort() {
		EventDataPort newOwnedEventDataPort = (EventDataPort) create(Aadl2Package.eINSTANCE.getEventDataPort());
		getOwnedEventDataPorts().add(newOwnedEventDataPort);
		return newOwnedEventDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventPort> getOwnedEventPorts() {
		if (ownedEventPorts == null) {
			ownedEventPorts = new EObjectContainmentEList<EventPort>(EventPort.class, this,
					Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT);
		}
		return ownedEventPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPort createOwnedEventPort() {
		EventPort newOwnedEventPort = (EventPort) create(Aadl2Package.eINSTANCE.getEventPort());
		getOwnedEventPorts().add(newOwnedEventPort);
		return newOwnedEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getOwnedParameters() {
		if (ownedParameters == null) {
			ownedParameters = new EObjectContainmentEList<Parameter>(Parameter.class, this,
					Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER);
		}
		return ownedParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createOwnedParameter() {
		Parameter newOwnedParameter = (Parameter) create(Aadl2Package.eINSTANCE.getParameter());
		getOwnedParameters().add(newOwnedParameter);
		return newOwnedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataAccess> getOwnedDataAccesses() {
		if (ownedDataAccesses == null) {
			ownedDataAccesses = new EObjectContainmentEList<DataAccess>(DataAccess.class, this,
					Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS);
		}
		return ownedDataAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccess createOwnedDataAccess() {
		DataAccess newOwnedDataAccess = (DataAccess) create(Aadl2Package.eINSTANCE.getDataAccess());
		getOwnedDataAccesses().add(newOwnedDataAccess);
		return newOwnedDataAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramAccess> getOwnedSubprogramAccesses() {
		if (ownedSubprogramAccesses == null) {
			ownedSubprogramAccesses = new EObjectContainmentEList<SubprogramAccess>(SubprogramAccess.class, this,
					Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS);
		}
		return ownedSubprogramAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramAccess createOwnedSubprogramAccess() {
		SubprogramAccess newOwnedSubprogramAccess = (SubprogramAccess) create(
				Aadl2Package.eINSTANCE.getSubprogramAccess());
		getOwnedSubprogramAccesses().add(newOwnedSubprogramAccess);
		return newOwnedSubprogramAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramGroupAccess> getOwnedSubprogramGroupAccesses() {
		if (ownedSubprogramGroupAccesses == null) {
			ownedSubprogramGroupAccesses = new EObjectContainmentEList<SubprogramGroupAccess>(
					SubprogramGroupAccess.class, this, Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS);
		}
		return ownedSubprogramGroupAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupAccess createOwnedSubprogramGroupAccess() {
		SubprogramGroupAccess newOwnedSubprogramGroupAccess = (SubprogramGroupAccess) create(
				Aadl2Package.eINSTANCE.getSubprogramGroupAccess());
		getOwnedSubprogramGroupAccesses().add(newOwnedSubprogramGroupAccess);
		return newOwnedSubprogramGroupAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT:
			return ((InternalEList<?>) getOwnedEventDataPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT:
			return ((InternalEList<?>) getOwnedEventPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER:
			return ((InternalEList<?>) getOwnedParameters()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS:
			return ((InternalEList<?>) getOwnedDataAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return ((InternalEList<?>) getOwnedSubprogramAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return ((InternalEList<?>) getOwnedSubprogramGroupAccesses()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT:
			return getOwnedEventDataPorts();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT:
			return getOwnedEventPorts();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER:
			return getOwnedParameters();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS:
			return getOwnedDataAccesses();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return getOwnedSubprogramAccesses();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return getOwnedSubprogramGroupAccesses();
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
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT:
			getOwnedEventDataPorts().clear();
			getOwnedEventDataPorts().addAll((Collection<? extends EventDataPort>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT:
			getOwnedEventPorts().clear();
			getOwnedEventPorts().addAll((Collection<? extends EventPort>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER:
			getOwnedParameters().clear();
			getOwnedParameters().addAll((Collection<? extends Parameter>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS:
			getOwnedDataAccesses().clear();
			getOwnedDataAccesses().addAll((Collection<? extends DataAccess>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			getOwnedSubprogramAccesses().clear();
			getOwnedSubprogramAccesses().addAll((Collection<? extends SubprogramAccess>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			getOwnedSubprogramGroupAccesses().clear();
			getOwnedSubprogramGroupAccesses().addAll((Collection<? extends SubprogramGroupAccess>) newValue);
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
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT:
			getOwnedEventDataPorts().clear();
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT:
			getOwnedEventPorts().clear();
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER:
			getOwnedParameters().clear();
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS:
			getOwnedDataAccesses().clear();
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			getOwnedSubprogramAccesses().clear();
			return;
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			getOwnedSubprogramGroupAccesses().clear();
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
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_FEATURE:
			return isSetOwnedFeatures();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT:
			return ownedEventDataPorts != null && !ownedEventDataPorts.isEmpty();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT:
			return ownedEventPorts != null && !ownedEventPorts.isEmpty();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER:
			return ownedParameters != null && !ownedParameters.isEmpty();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS:
			return ownedDataAccesses != null && !ownedDataAccesses.isEmpty();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return ownedSubprogramAccesses != null && !ownedSubprogramAccesses.isEmpty();
		case Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return ownedSubprogramGroupAccesses != null && !ownedSubprogramGroupAccesses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedFeatures() {
		return super.isSetOwnedFeatures() || eIsSet(Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_DATA_PORT)
				|| eIsSet(Aadl2Package.SUBPROGRAM_TYPE__OWNED_EVENT_PORT)
				|| eIsSet(Aadl2Package.SUBPROGRAM_TYPE__OWNED_PARAMETER)
				|| eIsSet(Aadl2Package.SUBPROGRAM_TYPE__OWNED_DATA_ACCESS)
				|| eIsSet(Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_ACCESS)
				|| eIsSet(Aadl2Package.SUBPROGRAM_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.SUBPROGRAM;
	}
} // SubprogramTypeImpl
