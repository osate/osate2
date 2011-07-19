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
 * $Id: ThreadGroupImplementationImpl.java,v 1.26 2009-06-05 16:43:26 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadSubcomponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread Group Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getOwnedThreadSubcomponents <em>Owned Thread Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getOwnedThreadGroupSubcomponents <em>Owned Thread Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getOwnedSubprogramGroupSubcomponents <em>Owned Subprogram Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadGroupImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreadGroupImplementationImpl extends ComponentImplementationImpl implements ThreadGroupImplementation {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadGroupImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getThreadGroupImplementation();
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
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent(),
						ownedSubcomponents = new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
								Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBCOMPONENT,
								OWNED_SUBCOMPONENT_ESUBSETS));
			}
			return ownedSubcomponents;
		}
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedSubcomponents() <em>Owned Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_SUBCOMPONENT_ESUBSETS = new int[] {
			Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT,
			Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT,
			Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT,
			Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT,
			Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataSubcomponent> getOwnedDataSubcomponents() {
		if (ownedDataSubcomponents == null) {
			ownedDataSubcomponents = new EObjectContainmentEList<DataSubcomponent>(DataSubcomponent.class, this,
					Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT);
		}
		return ownedDataSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public EList<ThreadSubcomponent> getOwnedThreadSubcomponents() {
		if (ownedThreadSubcomponents == null) {
			ownedThreadSubcomponents = new EObjectContainmentEList<ThreadSubcomponent>(ThreadSubcomponent.class, this,
					Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT);
		}
		return ownedThreadSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadSubcomponent createOwnedThreadSubcomponent() {
		ThreadSubcomponent newOwnedThreadSubcomponent = (ThreadSubcomponent) create(Aadl2Package.eINSTANCE
				.getThreadSubcomponent());
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
					Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT);
		}
		return ownedThreadGroupSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupSubcomponent createOwnedThreadGroupSubcomponent() {
		ThreadGroupSubcomponent newOwnedThreadGroupSubcomponent = (ThreadGroupSubcomponent) create(Aadl2Package.eINSTANCE
				.getThreadGroupSubcomponent());
		getOwnedThreadGroupSubcomponents().add(newOwnedThreadGroupSubcomponent);
		return newOwnedThreadGroupSubcomponent;
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
					Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT);
		}
		return ownedSubprogramSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramSubcomponent createOwnedSubprogramSubcomponent() {
		SubprogramSubcomponent newOwnedSubprogramSubcomponent = (SubprogramSubcomponent) create(Aadl2Package.eINSTANCE
				.getSubprogramSubcomponent());
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
					Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT);
		}
		return ownedSubprogramGroupSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupSubcomponent createOwnedSubprogramGroupSubcomponent() {
		SubprogramGroupSubcomponent newOwnedSubprogramGroupSubcomponent = (SubprogramGroupSubcomponent) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupSubcomponent());
		getOwnedSubprogramGroupSubcomponents().add(newOwnedSubprogramGroupSubcomponent);
		return newOwnedSubprogramGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ThreadGroupType getType() {
		ThreadGroupType type = basicGetType();
		return type != null && ((EObject) type).eIsProxy() ? (ThreadGroupType) eResolveProxy((InternalEObject) type)
				: type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ThreadGroupType basicGetType() {
		// DONE: implement this method to return the 'Type' reference
		return (ThreadGroupType) super.basicGetType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ComponentType newType) {
		// TODO: implement this method to set the 'Type' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDataSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedThreadSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedThreadGroupSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramGroupSubcomponents()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return getOwnedDataSubcomponents();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return getOwnedThreadSubcomponents();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return getOwnedThreadGroupSubcomponents();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return getOwnedSubprogramSubcomponents();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return getOwnedSubprogramGroupSubcomponents();
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
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			getOwnedDataSubcomponents().addAll((Collection<? extends DataSubcomponent>) newValue);
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			getOwnedThreadSubcomponents().clear();
			getOwnedThreadSubcomponents().addAll((Collection<? extends ThreadSubcomponent>) newValue);
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			getOwnedThreadGroupSubcomponents().clear();
			getOwnedThreadGroupSubcomponents().addAll((Collection<? extends ThreadGroupSubcomponent>) newValue);
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			getOwnedSubprogramSubcomponents().addAll((Collection<? extends SubprogramSubcomponent>) newValue);
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			getOwnedSubprogramGroupSubcomponents().addAll((Collection<? extends SubprogramGroupSubcomponent>) newValue);
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
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			getOwnedThreadSubcomponents().clear();
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			getOwnedThreadGroupSubcomponents().clear();
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			return;
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
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
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ownedDataSubcomponents != null && !ownedDataSubcomponents.isEmpty();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return ownedThreadSubcomponents != null && !ownedThreadSubcomponents.isEmpty();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return ownedThreadGroupSubcomponents != null && !ownedThreadGroupSubcomponents.isEmpty();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ownedSubprogramSubcomponents != null && !ownedSubprogramSubcomponents.isEmpty();
		case Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ownedSubprogramGroupSubcomponents != null && !ownedSubprogramGroupSubcomponents.isEmpty();
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
				|| eIsSet(Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.THREAD_GROUP_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT);
	}

	public String getCategory() {
		return "thread group";
	}
} //ThreadGroupImplementationImpl
