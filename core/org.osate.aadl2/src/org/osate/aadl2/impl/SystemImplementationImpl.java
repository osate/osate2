/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedBusSubcomponents <em>Owned Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedDeviceSubcomponents <em>Owned Device Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedMemorySubcomponents <em>Owned Memory Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedProcessSubcomponents <em>Owned Process Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedProcessorSubcomponents <em>Owned Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedSubprogramGroupSubcomponents <em>Owned Subprogram Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedSystemSubcomponents <em>Owned System Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedVirtualBusSubcomponents <em>Owned Virtual Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getOwnedVirtualProcessorSubcomponents <em>Owned Virtual Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SystemImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImplementationImpl extends ComponentImplementationImpl implements SystemImplementation {
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
	 * The cached value of the '{@link #getOwnedDeviceSubcomponents() <em>Owned Device Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDeviceSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<DeviceSubcomponent> ownedDeviceSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedMemorySubcomponents() <em>Owned Memory Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMemorySubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<MemorySubcomponent> ownedMemorySubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedProcessSubcomponents() <em>Owned Process Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessSubcomponent> ownedProcessSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedProcessorSubcomponents() <em>Owned Processor Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessorSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessorSubcomponent> ownedProcessorSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramSubcomponents() <em>Owned Subprogram Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramSubcomponent> ownedSubprogramSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupSubcomponents() <em>Owned Subprogram Group Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupSubcomponent> ownedSubprogramGroupSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedSystemSubcomponents() <em>Owned System Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSystemSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemSubcomponent> ownedSystemSubcomponents;
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
	 * The cached value of the '{@link #getOwnedVirtualProcessorSubcomponents() <em>Owned Virtual Processor Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualProcessorSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualProcessorSubcomponent> ownedVirtualProcessorSubcomponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSystemImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subcomponent> getOwnedSubcomponents() {
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
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
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT,
			Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusSubcomponent> getOwnedBusSubcomponents() {
		if (ownedBusSubcomponents == null) {
			ownedBusSubcomponents = new EObjectContainmentEList<BusSubcomponent>(BusSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT);
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
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT);
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
	public EList<DeviceSubcomponent> getOwnedDeviceSubcomponents() {
		if (ownedDeviceSubcomponents == null) {
			ownedDeviceSubcomponents = new EObjectContainmentEList<DeviceSubcomponent>(DeviceSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT);
		}
		return ownedDeviceSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceSubcomponent createOwnedDeviceSubcomponent() {
		DeviceSubcomponent newOwnedDeviceSubcomponent = (DeviceSubcomponent) create(
				Aadl2Package.eINSTANCE.getDeviceSubcomponent());
		getOwnedDeviceSubcomponents().add(newOwnedDeviceSubcomponent);
		return newOwnedDeviceSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemorySubcomponent> getOwnedMemorySubcomponents() {
		if (ownedMemorySubcomponents == null) {
			ownedMemorySubcomponents = new EObjectContainmentEList<MemorySubcomponent>(MemorySubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT);
		}
		return ownedMemorySubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemorySubcomponent createOwnedMemorySubcomponent() {
		MemorySubcomponent newOwnedMemorySubcomponent = (MemorySubcomponent) create(
				Aadl2Package.eINSTANCE.getMemorySubcomponent());
		getOwnedMemorySubcomponents().add(newOwnedMemorySubcomponent);
		return newOwnedMemorySubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessSubcomponent> getOwnedProcessSubcomponents() {
		if (ownedProcessSubcomponents == null) {
			ownedProcessSubcomponents = new EObjectContainmentEList<ProcessSubcomponent>(ProcessSubcomponent.class,
					this, Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT);
		}
		return ownedProcessSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSubcomponent createOwnedProcessSubcomponent() {
		ProcessSubcomponent newOwnedProcessSubcomponent = (ProcessSubcomponent) create(
				Aadl2Package.eINSTANCE.getProcessSubcomponent());
		getOwnedProcessSubcomponents().add(newOwnedProcessSubcomponent);
		return newOwnedProcessSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessorSubcomponent> getOwnedProcessorSubcomponents() {
		if (ownedProcessorSubcomponents == null) {
			ownedProcessorSubcomponents = new EObjectContainmentEList<ProcessorSubcomponent>(
					ProcessorSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT);
		}
		return ownedProcessorSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorSubcomponent createOwnedProcessorSubcomponent() {
		ProcessorSubcomponent newOwnedProcessorSubcomponent = (ProcessorSubcomponent) create(
				Aadl2Package.eINSTANCE.getProcessorSubcomponent());
		getOwnedProcessorSubcomponents().add(newOwnedProcessorSubcomponent);
		return newOwnedProcessorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramSubcomponent> getOwnedSubprogramSubcomponents() {
		if (ownedSubprogramSubcomponents == null) {
			ownedSubprogramSubcomponents = new EObjectContainmentEList<SubprogramSubcomponent>(
					SubprogramSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT);
		}
		return ownedSubprogramSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramSubcomponent createOwnedSubprogramSubcomponent() {
		SubprogramSubcomponent newOwnedSubprogramSubcomponent = (SubprogramSubcomponent) create(
				Aadl2Package.eINSTANCE.getSubprogramSubcomponent());
		getOwnedSubprogramSubcomponents().add(newOwnedSubprogramSubcomponent);
		return newOwnedSubprogramSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramGroupSubcomponent> getOwnedSubprogramGroupSubcomponents() {
		if (ownedSubprogramGroupSubcomponents == null) {
			ownedSubprogramGroupSubcomponents = new EObjectContainmentEList<SubprogramGroupSubcomponent>(
					SubprogramGroupSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT);
		}
		return ownedSubprogramGroupSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupSubcomponent createOwnedSubprogramGroupSubcomponent() {
		SubprogramGroupSubcomponent newOwnedSubprogramGroupSubcomponent = (SubprogramGroupSubcomponent) create(
				Aadl2Package.eINSTANCE.getSubprogramGroupSubcomponent());
		getOwnedSubprogramGroupSubcomponents().add(newOwnedSubprogramGroupSubcomponent);
		return newOwnedSubprogramGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemSubcomponent> getOwnedSystemSubcomponents() {
		if (ownedSystemSubcomponents == null) {
			ownedSystemSubcomponents = new EObjectContainmentEList<SystemSubcomponent>(SystemSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT);
		}
		return ownedSystemSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemSubcomponent createOwnedSystemSubcomponent() {
		SystemSubcomponent newOwnedSystemSubcomponent = (SystemSubcomponent) create(
				Aadl2Package.eINSTANCE.getSystemSubcomponent());
		getOwnedSystemSubcomponents().add(newOwnedSystemSubcomponent);
		return newOwnedSystemSubcomponent;
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
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT);
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
	 * @generated
	 */
	public EList<VirtualProcessorSubcomponent> getOwnedVirtualProcessorSubcomponents() {
		if (ownedVirtualProcessorSubcomponents == null) {
			ownedVirtualProcessorSubcomponents = new EObjectContainmentEList<VirtualProcessorSubcomponent>(
					VirtualProcessorSubcomponent.class, this,
					Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
		}
		return ownedVirtualProcessorSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorSubcomponent createOwnedVirtualProcessorSubcomponent() {
		VirtualProcessorSubcomponent newOwnedVirtualProcessorSubcomponent = (VirtualProcessorSubcomponent) create(
				Aadl2Package.eINSTANCE.getVirtualProcessorSubcomponent());
		getOwnedVirtualProcessorSubcomponents().add(newOwnedVirtualProcessorSubcomponent);
		return newOwnedVirtualProcessorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SystemType getType() {
		ComponentType ct = super.getType();
		return ct instanceof SystemType ? (SystemType) ct : null;
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
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDataSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDeviceSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedMemorySubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedProcessSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedProcessorSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramGroupSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSystemSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedVirtualBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedVirtualProcessorSubcomponents()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return getOwnedBusSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return getOwnedDataSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			return getOwnedDeviceSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return getOwnedMemorySubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			return getOwnedProcessSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			return getOwnedProcessorSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return getOwnedSubprogramSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return getOwnedSubprogramGroupSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			return getOwnedSystemSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return getOwnedVirtualBusSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return getOwnedVirtualProcessorSubcomponents();
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
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			getOwnedBusSubcomponents().addAll((Collection<? extends BusSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			getOwnedDataSubcomponents().addAll((Collection<? extends DataSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			getOwnedDeviceSubcomponents().clear();
			getOwnedDeviceSubcomponents().addAll((Collection<? extends DeviceSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			getOwnedMemorySubcomponents().clear();
			getOwnedMemorySubcomponents().addAll((Collection<? extends MemorySubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			getOwnedProcessSubcomponents().clear();
			getOwnedProcessSubcomponents().addAll((Collection<? extends ProcessSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			getOwnedProcessorSubcomponents().clear();
			getOwnedProcessorSubcomponents().addAll((Collection<? extends ProcessorSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			getOwnedSubprogramSubcomponents().addAll((Collection<? extends SubprogramSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			getOwnedSubprogramGroupSubcomponents().addAll((Collection<? extends SubprogramGroupSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			getOwnedSystemSubcomponents().clear();
			getOwnedSystemSubcomponents().addAll((Collection<? extends SystemSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			getOwnedVirtualBusSubcomponents().addAll((Collection<? extends VirtualBusSubcomponent>) newValue);
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			getOwnedVirtualProcessorSubcomponents().clear();
			getOwnedVirtualProcessorSubcomponents()
					.addAll((Collection<? extends VirtualProcessorSubcomponent>) newValue);
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
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			getOwnedDeviceSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			getOwnedMemorySubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			getOwnedProcessSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			getOwnedProcessorSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			getOwnedSystemSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			return;
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			getOwnedVirtualProcessorSubcomponents().clear();
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
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ownedBusSubcomponents != null && !ownedBusSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ownedDataSubcomponents != null && !ownedDataSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			return ownedDeviceSubcomponents != null && !ownedDeviceSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return ownedMemorySubcomponents != null && !ownedMemorySubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			return ownedProcessSubcomponents != null && !ownedProcessSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			return ownedProcessorSubcomponents != null && !ownedProcessorSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ownedSubprogramSubcomponents != null && !ownedSubprogramSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ownedSubprogramGroupSubcomponents != null && !ownedSubprogramGroupSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			return ownedSystemSubcomponents != null && !ownedSystemSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ownedVirtualBusSubcomponents != null && !ownedVirtualBusSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return ownedVirtualProcessorSubcomponents != null && !ownedVirtualProcessorSubcomponents.isEmpty();
		case Aadl2Package.SYSTEM_IMPLEMENTATION__TYPE:
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
		return super.isSetOwnedSubcomponents() || eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.SYSTEM;
	}
} // SystemImplementationImpl
