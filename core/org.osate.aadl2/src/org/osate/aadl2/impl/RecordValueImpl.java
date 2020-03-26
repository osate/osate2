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
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RecordValueImpl#getOwnedFieldValues <em>Owned Field Value</em>}</li>
 * </ul>
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
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRecordValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public BasicPropertyAssociation createOwnedFieldValue() {
		BasicPropertyAssociation newOwnedFieldValue = (BasicPropertyAssociation) create(
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation());
		getOwnedFieldValues().add(newOwnedFieldValue);
		return newOwnedFieldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE:
			return ownedFieldValues != null && !ownedFieldValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ownedFieldValues == null) ? 0 : ownedFieldValues.hashCode());
		return result;
	}
	public boolean sameAs(PropertyExpression pv) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.impl.PropertyExpressionImpl#evaluate(org.osate.aadl2.properties.EvaluationContext, int)
	 */
	public EvaluatedProperty evaluate(EvaluationContext ctx, int depth) {
		// evaluate each record field
		RecordValue newVal = Aadl2Factory.eINSTANCE.createRecordValue();
		for (BasicPropertyAssociation field : getOwnedFieldValues()) {
			EvaluatedProperty fieldVal = field.getOwnedValue().evaluate(ctx, depth + 1);
			String name = field.getProperty().getName();
			if (fieldVal.isEmpty()) {
				throw new InvalidModelException(this, "Field " + name + " has no value");
			}
			if (fieldVal.size() > 1) {
				throw new InvalidModelException(this, "Field " + name + " has multiple values");
			}
			if (fieldVal.first().isModal()) {
				throw new InvalidModelException(this, "Field " + name + ": value is modal");
			}
			BasicPropertyAssociation newField = newVal.createOwnedFieldValue();
			newField.setProperty(field.getProperty());
			PropertyExpression exp = fieldVal.first().getValue();
			newField.setOwnedValue(exp);
		}
		return new EvaluatedProperty(newVal);
	}

} // RecordValueImpl
