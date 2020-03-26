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
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getOwnedSubprogramGroupSubcomponents <em>Owned Subprogram Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getOwnedThreadSubcomponents <em>Owned Thread Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getOwnedThreadGroupSubcomponents <em>Owned Thread Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ProcessImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessImplementationImpl extends ComponentImplementationImpl implements ProcessImplementation {
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
	 * The cached value of the '{@link #getOwnedThreadSubcomponents() <em>Owned Thread Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadSubcomponent> ownedThreadSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedThreadGroupSubcomponents() <em>Owned Thread Group Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadGroupSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadGroupSubcomponent> ownedThreadGroupSubcomponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getProcessImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subcomponent> getOwnedSubcomponents() {
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
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
			Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT,
			Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT,
			Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT,
			Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT,
			Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataSubcomponent> getOwnedDataSubcomponents() {
		if (ownedDataSubcomponents == null) {
			ownedDataSubcomponents = new EObjectContainmentEList<DataSubcomponent>(DataSubcomponent.class, this,
					Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT);
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
	public EList<SubprogramSubcomponent> getOwnedSubprogramSubcomponents() {
		if (ownedSubprogramSubcomponents == null) {
			ownedSubprogramSubcomponents = new EObjectContainmentEList<SubprogramSubcomponent>(
					SubprogramSubcomponent.class, this,
					Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT);
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
					Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT);
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
	public EList<ThreadSubcomponent> getOwnedThreadSubcomponents() {
		if (ownedThreadSubcomponents == null) {
			ownedThreadSubcomponents = new EObjectContainmentEList<ThreadSubcomponent>(ThreadSubcomponent.class, this,
					Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT);
		}
		return ownedThreadSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadSubcomponent createOwnedThreadSubcomponent() {
		ThreadSubcomponent newOwnedThreadSubcomponent = (ThreadSubcomponent) create(
				Aadl2Package.eINSTANCE.getThreadSubcomponent());
		getOwnedThreadSubcomponents().add(newOwnedThreadSubcomponent);
		return newOwnedThreadSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadGroupSubcomponent> getOwnedThreadGroupSubcomponents() {
		if (ownedThreadGroupSubcomponents == null) {
			ownedThreadGroupSubcomponents = new EObjectContainmentEList<ThreadGroupSubcomponent>(
					ThreadGroupSubcomponent.class, this,
					Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT);
		}
		return ownedThreadGroupSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupSubcomponent createOwnedThreadGroupSubcomponent() {
		ThreadGroupSubcomponent newOwnedThreadGroupSubcomponent = (ThreadGroupSubcomponent) create(
				Aadl2Package.eINSTANCE.getThreadGroupSubcomponent());
		getOwnedThreadGroupSubcomponents().add(newOwnedThreadGroupSubcomponent);
		return newOwnedThreadGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProcessType getType() {
		ComponentType ct = super.getType();
		return ct instanceof ProcessType ? (ProcessType) ct : null;
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
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDataSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramGroupSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedThreadSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedThreadGroupSubcomponents()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return getOwnedDataSubcomponents();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return getOwnedSubprogramSubcomponents();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return getOwnedSubprogramGroupSubcomponents();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return getOwnedThreadSubcomponents();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return getOwnedThreadGroupSubcomponents();
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
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			getOwnedDataSubcomponents().addAll((Collection<? extends DataSubcomponent>) newValue);
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			getOwnedSubprogramSubcomponents().addAll((Collection<? extends SubprogramSubcomponent>) newValue);
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			getOwnedSubprogramGroupSubcomponents().addAll((Collection<? extends SubprogramGroupSubcomponent>) newValue);
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			getOwnedThreadSubcomponents().clear();
			getOwnedThreadSubcomponents().addAll((Collection<? extends ThreadSubcomponent>) newValue);
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			getOwnedThreadGroupSubcomponents().clear();
			getOwnedThreadGroupSubcomponents().addAll((Collection<? extends ThreadGroupSubcomponent>) newValue);
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
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			getOwnedThreadSubcomponents().clear();
			return;
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			getOwnedThreadGroupSubcomponents().clear();
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
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ownedDataSubcomponents != null && !ownedDataSubcomponents.isEmpty();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ownedSubprogramSubcomponents != null && !ownedSubprogramSubcomponents.isEmpty();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ownedSubprogramGroupSubcomponents != null && !ownedSubprogramGroupSubcomponents.isEmpty();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return ownedThreadSubcomponents != null && !ownedThreadSubcomponents.isEmpty();
		case Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return ownedThreadGroupSubcomponents != null && !ownedThreadGroupSubcomponents.isEmpty();
		case Aadl2Package.PROCESS_IMPLEMENTATION__TYPE:
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
		return super.isSetOwnedSubcomponents() || eIsSet(Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.PROCESS_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.PROCESS;
	}
} // ProcessImplementationImpl
