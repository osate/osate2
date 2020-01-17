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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyEvaluationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.NamedValueImpl#getNamedValue <em>Named Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedValueImpl extends PropertyValueImpl implements NamedValue {
	/**
	 * The cached value of the '{@link #getNamedValue() <em>Named Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedValue()
	 * @generated
	 * @ordered
	 */
	protected AbstractNamedValue namedValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getNamedValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedValue getNamedValue() {
		if (namedValue != null && ((EObject) namedValue).eIsProxy()) {
			InternalEObject oldNamedValue = (InternalEObject) namedValue;
			namedValue = (AbstractNamedValue) eResolveProxy(oldNamedValue);
			if (namedValue != oldNamedValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.NAMED_VALUE__NAMED_VALUE,
							oldNamedValue, namedValue));
			}
		}
		return namedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedValue basicGetNamedValue() {
		return namedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedValue(AbstractNamedValue newNamedValue) {
		AbstractNamedValue oldNamedValue = namedValue;
		namedValue = newNamedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NAMED_VALUE__NAMED_VALUE, oldNamedValue,
					namedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.NAMED_VALUE__NAMED_VALUE:
			if (resolve)
				return getNamedValue();
			return basicGetNamedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.NAMED_VALUE__NAMED_VALUE:
			setNamedValue((AbstractNamedValue) newValue);
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
		case Aadl2Package.NAMED_VALUE__NAMED_VALUE:
			setNamedValue((AbstractNamedValue) null);
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
		case Aadl2Package.NAMED_VALUE__NAMED_VALUE:
			return namedValue != null;
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
		NamedValueImpl other = (NamedValueImpl) pe;
		return namedValue.sameAs(other.namedValue);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.PropertyExpressionImpl#evaluate(org.osate.aadl2.properties.EvaluationContext)
	 */
	public EvaluatedProperty evaluate(EvaluationContext ctx, int depth) {
		AbstractNamedValue nv = getNamedValue();
		if (depth > 50) {
			throw new InvalidModelException(ctx.getInstanceObject(),
					"Property " + ((Property) nv).getQualifiedName() + " has cyclic value");
		}
		PropertyEvaluationResult pev = nv.evaluate(ctx, depth + 1);
		List<EvaluatedProperty> evaluated = pev.getEvaluated();
		if (evaluated.isEmpty()) {
			throw new InvalidModelException(ctx.getInstanceObject(),
					"Property " + ((Property) nv).getQualifiedName() + " is undefined");
		}
		return evaluated.get(0);
	}

} // NamedValueImpl
