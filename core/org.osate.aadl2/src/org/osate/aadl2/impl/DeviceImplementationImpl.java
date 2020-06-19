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
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.VirtualBusSubcomponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.DeviceImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DeviceImplementationImpl#getOwnedBusSubcomponents <em>Owned Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DeviceImplementationImpl#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DeviceImplementationImpl#getOwnedVirtualBusSubcomponents <em>Owned Virtual Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DeviceImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeviceImplementationImpl extends ComponentImplementationImpl implements DeviceImplementation {
	/**
	 * The cached value of the '{@link #getOwnedBusSubcomponents() <em>Owned Bus Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBusSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<BusSubcomponent> ownedBusSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedDataSubcomponents() <em>Owned Data Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<DataSubcomponent> ownedDataSubcomponents;

	/**
	 * The cached value of the '{@link #getOwnedVirtualBusSubcomponents() <em>Owned Virtual Bus Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualBusSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualBusSubcomponent> ownedVirtualBusSubcomponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getDeviceImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subcomponent> getOwnedSubcomponents() {
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedSubcomponents() <em>Owned Subcomponent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_SUBCOMPONENT_ESUBSETS = new int[] {
			Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT,
			Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT,
			Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusSubcomponent> getOwnedBusSubcomponents() {
		if (ownedBusSubcomponents == null) {
			ownedBusSubcomponents = new EObjectContainmentEList<BusSubcomponent>(BusSubcomponent.class, this,
					Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT);
		}
		return ownedBusSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusSubcomponent createOwnedBusSubcomponent() {
		BusSubcomponent newOwnedBusSubcomponent = (BusSubcomponent) create(Aadl2Package.eINSTANCE.getBusSubcomponent());
		getOwnedBusSubcomponents().add(newOwnedBusSubcomponent);
		return newOwnedBusSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataSubcomponent> getOwnedDataSubcomponents() {
		if (ownedDataSubcomponents == null) {
			ownedDataSubcomponents = new EObjectContainmentEList<DataSubcomponent>(DataSubcomponent.class, this,
					Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT);
		}
		return ownedDataSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubcomponent createOwnedDataSubcomponent() {
		DataSubcomponent newOwnedDataSubcomponent = (DataSubcomponent) create(
				Aadl2Package.eINSTANCE.getDataSubcomponent());
		getOwnedDataSubcomponents().add(newOwnedDataSubcomponent);
		return newOwnedDataSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualBusSubcomponent> getOwnedVirtualBusSubcomponents() {
		if (ownedVirtualBusSubcomponents == null) {
			ownedVirtualBusSubcomponents = new EObjectContainmentEList<VirtualBusSubcomponent>(
					VirtualBusSubcomponent.class, this,
					Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT);
		}
		return ownedVirtualBusSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusSubcomponent createOwnedVirtualBusSubcomponent() {
		VirtualBusSubcomponent newOwnedVirtualBusSubcomponent = (VirtualBusSubcomponent) create(
				Aadl2Package.eINSTANCE.getVirtualBusSubcomponent());
		getOwnedVirtualBusSubcomponents().add(newOwnedVirtualBusSubcomponent);
		return newOwnedVirtualBusSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DeviceType getType() {
		ComponentType ct = super.getType();
		return ct instanceof DeviceType ? (DeviceType) ct : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentType basicGetType() {
		// DONE: implement this method to return the 'Type' reference
		return super.basicGetType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(ComponentType newType) {
		super.setType(newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return basicGetType() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDataSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedVirtualBusSubcomponents()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return getOwnedBusSubcomponents();
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return getOwnedDataSubcomponents();
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return getOwnedVirtualBusSubcomponents();
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
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			getOwnedBusSubcomponents().addAll((Collection<? extends BusSubcomponent>) newValue);
			return;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			getOwnedDataSubcomponents().addAll((Collection<? extends DataSubcomponent>) newValue);
			return;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			getOwnedVirtualBusSubcomponents().addAll((Collection<? extends VirtualBusSubcomponent>) newValue);
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
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			return;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			return;
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
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
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ownedBusSubcomponents != null && !ownedBusSubcomponents.isEmpty();
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ownedDataSubcomponents != null && !ownedDataSubcomponents.isEmpty();
		case Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ownedVirtualBusSubcomponents != null && !ownedVirtualBusSubcomponents.isEmpty();
		case Aadl2Package.DEVICE_IMPLEMENTATION__TYPE:
			return isSetType();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedSubcomponents() {
		return super.isSetOwnedSubcomponents() || eIsSet(Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.DEVICE_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.DEVICE;
	}
} // DeviceImplementationImpl
