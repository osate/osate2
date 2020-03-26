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
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.Subcomponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.MemoryImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.MemoryImplementationImpl#getOwnedBusSubcomponents <em>Owned Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.MemoryImplementationImpl#getOwnedMemorySubcomponents <em>Owned Memory Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.MemoryImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemoryImplementationImpl extends ComponentImplementationImpl implements MemoryImplementation {
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
	 * The cached value of the '{@link #getOwnedMemorySubcomponents() <em>Owned Memory Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMemorySubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<MemorySubcomponent> ownedMemorySubcomponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getMemoryImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subcomponent> getOwnedSubcomponents() {
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
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
			Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT,
			Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusSubcomponent> getOwnedBusSubcomponents() {
		if (ownedBusSubcomponents == null) {
			ownedBusSubcomponents = new EObjectContainmentEList<BusSubcomponent>(BusSubcomponent.class, this,
					Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT);
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
	public EList<MemorySubcomponent> getOwnedMemorySubcomponents() {
		if (ownedMemorySubcomponents == null) {
			ownedMemorySubcomponents = new EObjectContainmentEList<MemorySubcomponent>(MemorySubcomponent.class, this,
					Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT);
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
	 * @generated NOT
	 */
	public MemoryType getType() {
		ComponentType ct = super.getType();
		return ct instanceof MemoryType ? (MemoryType) ct : null;
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
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedMemorySubcomponents()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return getOwnedBusSubcomponents();
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return getOwnedMemorySubcomponents();
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
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			getOwnedBusSubcomponents().addAll((Collection<? extends BusSubcomponent>) newValue);
			return;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			getOwnedMemorySubcomponents().clear();
			getOwnedMemorySubcomponents().addAll((Collection<? extends MemorySubcomponent>) newValue);
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
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			return;
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			getOwnedMemorySubcomponents().clear();
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
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ownedBusSubcomponents != null && !ownedBusSubcomponents.isEmpty();
		case Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return ownedMemorySubcomponents != null && !ownedMemorySubcomponents.isEmpty();
		case Aadl2Package.MEMORY_IMPLEMENTATION__TYPE:
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
		return super.isSetOwnedSubcomponents() || eIsSet(Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.MEMORY_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.MEMORY;
	}
} // MemoryImplementationImpl
