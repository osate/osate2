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
 * $Id: EnumerationTypeImpl.java,v 1.10 2011-04-11 13:35:50 lwrage Exp $
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
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Type;
import org.osate.aadl2.operations.TypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.EnumerationTypeImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EnumerationTypeImpl#getOwnedLiterals <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationTypeImpl extends NamespaceImpl implements EnumerationType {
	/**
	 * The cached value of the '{@link #getOwnedLiterals() <em>Owned Literal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> ownedLiterals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getEnumerationType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> ownedMembers = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			if (ownedMembers == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_OwnedMember(),
						ownedMembers = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.ENUMERATION_TYPE__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.ENUMERATION_TYPE__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] { Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnumerationLiteral> getOwnedLiterals() {
		if (ownedLiterals == null) {
			ownedLiterals = new EObjectContainmentEList<EnumerationLiteral>(EnumerationLiteral.class, this,
					Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL);
		}
		return ownedLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationLiteral createOwnedLiteral(EClass eClass) {
		EnumerationLiteral newOwnedLiteral = (EnumerationLiteral) create(eClass);
		getOwnedLiterals().add(newOwnedLiteral);
		return newOwnedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationLiteral createOwnedLiteral() {
		return createOwnedLiteral(Aadl2Package.eINSTANCE.getEnumerationLiteral());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean conformsTo(Type other) {
		return TypeOperations.conformsTo(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL:
			return ((InternalEList<?>) getOwnedLiterals()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL:
			return getOwnedLiterals();
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
		case Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL:
			getOwnedLiterals().clear();
			getOwnedLiterals().addAll((Collection<? extends EnumerationLiteral>) newValue);
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
		case Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL:
			getOwnedLiterals().clear();
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
		case Aadl2Package.ENUMERATION_TYPE__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL:
			return ownedLiterals != null && !ownedLiterals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.ENUMERATION_TYPE__OWNED_LITERAL);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.EnumerationType#findLiteral(java.lang.String)
	 */
	@Override
	public EnumerationLiteral findLiteral(String literalName) {
		for (EnumerationLiteral literal : getOwnedLiterals()) {
			// The name could be null if the model is incomplete.
			if (literal.getName() != null && literal.getName().equalsIgnoreCase(literalName)) {
				return literal;
			}
		}
		return null;
	}

	@Override
	public NamedElement findNamedElement(String name) {
		return findLiteral(name);
	}

} // EnumerationTypeImpl
