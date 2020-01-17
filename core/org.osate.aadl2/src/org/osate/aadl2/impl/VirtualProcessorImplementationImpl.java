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
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Processor Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getOwnedVirtualBusSubcomponents <em>Owned Virtual Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getOwnedVirtualProcessorSubcomponents <em>Owned Virtual Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VirtualProcessorImplementationImpl extends ComponentImplementationImpl
		implements VirtualProcessorImplementation {
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
	protected VirtualProcessorImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getVirtualProcessorImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subcomponent> getOwnedSubcomponents() {
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
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
			Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT,
			Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualBusSubcomponent> getOwnedVirtualBusSubcomponents() {
		if (ownedVirtualBusSubcomponents == null) {
			ownedVirtualBusSubcomponents = new EObjectContainmentEList<VirtualBusSubcomponent>(
					VirtualBusSubcomponent.class, this,
					Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT);
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
					Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
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
	public VirtualProcessorType getType() {
		ComponentType ct = super.getType();
		return ct instanceof VirtualProcessorType ? (VirtualProcessorType) ct : null;
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
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedVirtualBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
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
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return getOwnedVirtualBusSubcomponents();
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
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
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			getOwnedVirtualBusSubcomponents().addAll((Collection<? extends VirtualBusSubcomponent>) newValue);
			return;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
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
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			return;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
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
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ownedVirtualBusSubcomponents != null && !ownedVirtualBusSubcomponents.isEmpty();
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return ownedVirtualProcessorSubcomponents != null && !ownedVirtualProcessorSubcomponents.isEmpty();
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__TYPE:
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
		return super.isSetOwnedSubcomponents()
				|| eIsSet(Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.VIRTUAL_PROCESSOR;
	}
} // VirtualProcessorImplementationImpl
