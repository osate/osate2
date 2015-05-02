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
 * $Id: RecordValueImpl.java,v 1.11 2010-06-15 20:46:19 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.RecordValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RecordValueImpl#getOwnedFieldValues <em>Owned Field Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecordValueImpl extends PropertyValueImpl implements RecordValue {
	/**
	 * The cached value of the '{@link #getOwnedFieldValues() <em>Owned Field Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFieldValues()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicPropertyAssociation> ownedFieldValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRecordValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BasicPropertyAssociation> getOwnedFieldValues() {
		if (ownedFieldValues == null) {
			ownedFieldValues = new EObjectContainmentEList<BasicPropertyAssociation>(BasicPropertyAssociation.class,
					this, Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE);
		}
		return ownedFieldValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicPropertyAssociation createOwnedFieldValue() {
		BasicPropertyAssociation newOwnedFieldValue = (BasicPropertyAssociation) create(Aadl2Package.eINSTANCE
				.getBasicPropertyAssociation());
		getOwnedFieldValues().add(newOwnedFieldValue);
		return newOwnedFieldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE:
			return ((InternalEList<?>) getOwnedFieldValues()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE:
			return getOwnedFieldValues();
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
		case Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE:
			getOwnedFieldValues().clear();
			getOwnedFieldValues().addAll((Collection<? extends BasicPropertyAssociation>) newValue);
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
		case Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE:
			getOwnedFieldValues().clear();
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
		case Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE:
			return ownedFieldValues != null && !ownedFieldValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ownedFieldValues == null) ? 0 : ownedFieldValues.hashCode());
		return result;
	}

	@Override
	public boolean sameAs(PropertyValue pv) {
		if (this == pv) {
			return true;
		}
		if (pv == null || getClass() != pv.getClass()) {
			return false;
		}

		// TODO: implement comparicon for record values
		return false;

		// RecordValueImpl other = (RecordValueImpl) pv;
		// if (ownedFieldValues == null) {
		// if (other.ownedFieldValues != null) {
		// return false;
		// }
		// } else if (!ownedFieldValues.equals(other.ownedFieldValues)) {
		// return false;
		// }
		// return true;
	}

} // RecordValueImpl
