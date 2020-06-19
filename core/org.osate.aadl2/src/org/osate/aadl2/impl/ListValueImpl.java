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
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ListValueImpl#getOwnedListElements <em>Owned List Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListValueImpl extends PropertyExpressionImpl implements ListValue {
	/**
	 * The cached value of the '{@link #getOwnedListElements() <em>Owned List Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedListElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyExpression> ownedListElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getListValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyExpression> getOwnedListElements() {
		if (ownedListElements == null) {
			ownedListElements = new EObjectContainmentEList<PropertyExpression>(PropertyExpression.class, this,
					Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT);
		}
		return ownedListElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createOwnedListElement(EClass eClass) {
		PropertyExpression newOwnedListElement = (PropertyExpression) create(eClass);
		getOwnedListElements().add(newOwnedListElement);
		return newOwnedListElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT:
			return ((InternalEList<?>) getOwnedListElements()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT:
			return getOwnedListElements();
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
		case Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT:
			getOwnedListElements().clear();
			getOwnedListElements().addAll((Collection<? extends PropertyExpression>) newValue);
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
		case Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT:
			getOwnedListElements().clear();
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
		case Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT:
			return ownedListElements != null && !ownedListElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	public boolean sameAs(PropertyExpression pe) {
		if (this == pe) {
			return true;
		}
		if (pe == null || getClass() != pe.getClass()) {
			return false;
		}
		ListValueImpl other = (ListValueImpl) pe;
		if (ownedListElements == null && other.ownedListElements != null
				|| ownedListElements != null && other.ownedListElements == null) {
			return false;
		}
		if (ownedListElements == other.ownedListElements) {
			return true;
		}
		if (ownedListElements.size() != other.ownedListElements.size()) {
			return false;
		}

		for (int i = 0; i < ownedListElements.size(); ++i) {
			PropertyExpression pe1 = ownedListElements.get(i);
			PropertyExpression pe2 = other.ownedListElements.get(i);
			if (pe1 == null ? pe2 != null : !pe1.sameAs(pe2)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.PropertyExpressionImpl#evaluate(org.osate.aadl2.properties.EvaluationContext, int)
	 */
	public EvaluatedProperty evaluate(EvaluationContext ctx, int depth) {
		// evaluate each list element
		ListValue newVal = Aadl2Factory.eINSTANCE.createListValue();
		int i = 0;
		for (PropertyExpression elem : getOwnedListElements()) {
			i += 1;
			EvaluatedProperty elemVal = elem.evaluate(ctx, depth + 1);
			if (elemVal.isEmpty()) {
				throw new InvalidModelException(this, "Element " + i + " has no value");
			}
			if (elemVal.size() > 1) {
				throw new InvalidModelException(this, "Element " + i + " has multiple values");
			}
			if (elemVal.first().isModal()) {
				throw new InvalidModelException(this, "Element " + i + ": value is modal");
			}
			PropertyExpression exp = elemVal.first().getValue();
			newVal.getOwnedListElements().add(exp);
		}
		return new EvaluatedProperty(newVal);
	}

} // ListValueImpl
