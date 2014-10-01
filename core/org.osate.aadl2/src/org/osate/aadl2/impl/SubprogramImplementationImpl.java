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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: SubprogramImplementationImpl.java,v 1.34 2011-04-11 13:35:52 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramImplementationImpl#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramImplementationImpl#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubprogramImplementationImpl extends BehavioredImplementationImpl implements SubprogramImplementation {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Subcomponent> getOwnedSubcomponents() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Subcomponent> ownedSubcomponents = (EList<Subcomponent>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			if (ownedSubcomponents == null) {
				cache.put(
						eResource,
						this,
						Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent(),
						ownedSubcomponents = new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
								Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS));
			}
			return ownedSubcomponents;
		}
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
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
			Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT,
			Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataSubcomponent> getOwnedDataSubcomponents() {
		if (ownedDataSubcomponents == null) {
			ownedDataSubcomponents = new EObjectContainmentEList<DataSubcomponent>(DataSubcomponent.class, this,
					Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT);
		}
		return ownedDataSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSubcomponent createOwnedDataSubcomponent() {
		DataSubcomponent newOwnedDataSubcomponent = (DataSubcomponent) create(Aadl2Package.eINSTANCE
				.getDataSubcomponent());
		getOwnedDataSubcomponents().add(newOwnedDataSubcomponent);
		return newOwnedDataSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramSubcomponent> getOwnedSubprogramSubcomponents() {
		if (ownedSubprogramSubcomponents == null) {
			ownedSubprogramSubcomponents = new EObjectContainmentEList<SubprogramSubcomponent>(
					SubprogramSubcomponent.class, this,
					Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT);
		}
		return ownedSubprogramSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramSubcomponent createOwnedSubprogramSubcomponent() {
		SubprogramSubcomponent newOwnedSubprogramSubcomponent = (SubprogramSubcomponent) create(Aadl2Package.eINSTANCE
				.getSubprogramSubcomponent());
		getOwnedSubprogramSubcomponents().add(newOwnedSubprogramSubcomponent);
		return newOwnedSubprogramSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public SubprogramType getType() {
		ComponentType ct = super.getType();
		return ct instanceof SubprogramType ? (SubprogramType) ct : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ComponentType basicGetType() {
		// DONE: implement this method to return the 'Type' reference
		return super.basicGetType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDataSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramSubcomponents()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return getOwnedDataSubcomponents();
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return getOwnedSubprogramSubcomponents();
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
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			getOwnedDataSubcomponents().addAll((Collection<? extends DataSubcomponent>) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			getOwnedSubprogramSubcomponents().addAll((Collection<? extends SubprogramSubcomponent>) newValue);
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
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			return;
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
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
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ownedDataSubcomponents != null && !ownedDataSubcomponents.isEmpty();
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ownedSubprogramSubcomponents != null && !ownedSubprogramSubcomponents.isEmpty();
		case Aadl2Package.SUBPROGRAM_IMPLEMENTATION__TYPE:
			return isSetType();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedSubcomponents() {
		return super.isSetOwnedSubcomponents()
				|| eIsSet(Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.SUBPROGRAM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT);
	}

	@Override
	public ComponentCategory getCategory() {
		return ComponentCategory.SUBPROGRAM;
	}
} // SubprogramImplementationImpl
