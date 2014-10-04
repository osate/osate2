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
 * $Id: VirtualProcessorImplementationImpl.java,v 1.26 2009-06-05 16:43:26 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getOwnedVirtualBusSubcomponents <em>Owned Virtual Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getOwnedVirtualProcessorSubcomponents <em>Owned Virtual Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.VirtualProcessorImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualProcessorImplementationImpl extends ComponentImplementationImpl implements
		VirtualProcessorImplementation {
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getVirtualProcessorImplementation();
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
								Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_SUBCOMPONENT,
								OWNED_SUBCOMPONENT_ESUBSETS));
			}
			return ownedSubcomponents;
		}
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
	@Override
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
	@Override
	public VirtualBusSubcomponent createOwnedVirtualBusSubcomponent() {
		VirtualBusSubcomponent newOwnedVirtualBusSubcomponent = (VirtualBusSubcomponent) create(Aadl2Package.eINSTANCE
				.getVirtualBusSubcomponent());
		getOwnedVirtualBusSubcomponents().add(newOwnedVirtualBusSubcomponent);
		return newOwnedVirtualBusSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public VirtualProcessorSubcomponent createOwnedVirtualProcessorSubcomponent() {
		VirtualProcessorSubcomponent newOwnedVirtualProcessorSubcomponent = (VirtualProcessorSubcomponent) create(Aadl2Package.eINSTANCE
				.getVirtualProcessorSubcomponent());
		getOwnedVirtualProcessorSubcomponents().add(newOwnedVirtualProcessorSubcomponent);
		return newOwnedVirtualProcessorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public VirtualProcessorType getType() {
		ComponentType ct = super.getType();
		return ct instanceof VirtualProcessorType ? (VirtualProcessorType) ct : null;
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
	@Override
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			getOwnedVirtualBusSubcomponents().addAll((Collection<? extends VirtualBusSubcomponent>) newValue);
			return;
		case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			getOwnedVirtualProcessorSubcomponents().clear();
			getOwnedVirtualProcessorSubcomponents().addAll(
					(Collection<? extends VirtualProcessorSubcomponent>) newValue);
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
	@Override
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
	@Override
	public boolean isSetOwnedSubcomponents() {
		return super.isSetOwnedSubcomponents()
				|| eIsSet(Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
	}

	@Override
	public ComponentCategory getCategory() {
		return ComponentCategory.VIRTUAL_PROCESSOR;
	}
} // VirtualProcessorImplementationImpl
