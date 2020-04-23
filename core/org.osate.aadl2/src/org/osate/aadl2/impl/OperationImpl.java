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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.OperationKind;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.OperationImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.OperationImpl#getOwnedPropertyExpressions <em>Owned Property Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends PropertyExpressionImpl implements Operation {
	/**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected static final OperationKind OP_EDEFAULT = OperationKind.AND;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected OperationKind op = OP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedPropertyExpressions() <em>Owned Property Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyExpression> ownedPropertyExpressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationKind getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(OperationKind newOp) {
		OperationKind oldOp = op;
		op = newOp == null ? OP_EDEFAULT : newOp;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.OPERATION__OP, oldOp, op));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyExpression> getOwnedPropertyExpressions() {
		if (ownedPropertyExpressions == null) {
			ownedPropertyExpressions = new EObjectContainmentEList<PropertyExpression>(PropertyExpression.class, this,
					Aadl2Package.OPERATION__OWNED_PROPERTY_EXPRESSION);
		}
		return ownedPropertyExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createOwnedPropertyExpression(EClass eClass) {
		PropertyExpression newOwnedPropertyExpression = (PropertyExpression) create(eClass);
		getOwnedPropertyExpressions().add(newOwnedPropertyExpression);
		return newOwnedPropertyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.OPERATION__OWNED_PROPERTY_EXPRESSION:
			return ((InternalEList<?>) getOwnedPropertyExpressions()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.OPERATION__OP:
			return getOp();
		case Aadl2Package.OPERATION__OWNED_PROPERTY_EXPRESSION:
			return getOwnedPropertyExpressions();
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
		case Aadl2Package.OPERATION__OP:
			setOp((OperationKind) newValue);
			return;
		case Aadl2Package.OPERATION__OWNED_PROPERTY_EXPRESSION:
			getOwnedPropertyExpressions().clear();
			getOwnedPropertyExpressions().addAll((Collection<? extends PropertyExpression>) newValue);
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
		case Aadl2Package.OPERATION__OP:
			setOp(OP_EDEFAULT);
			return;
		case Aadl2Package.OPERATION__OWNED_PROPERTY_EXPRESSION:
			getOwnedPropertyExpressions().clear();
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
		case Aadl2Package.OPERATION__OP:
			return op != OP_EDEFAULT;
		case Aadl2Package.OPERATION__OWNED_PROPERTY_EXPRESSION:
			return ownedPropertyExpressions != null && !ownedPropertyExpressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}
	public EvaluatedProperty evaluate(EvaluationContext ctx, int depth) throws InvalidModelException {
		if (ownedPropertyExpressions.size() < 1) {
			throw new InvalidModelException(ctx.getInstanceObject(), "Property expression has no operands");
		}
		EvaluatedProperty left = ownedPropertyExpressions.get(0).evaluate(ctx, depth);
		EvaluatedProperty right = null;
		PropertyExpression arg1 = null;
		PropertyExpression arg2 = null;

		if (left.size() == 0) {
			throw new InvalidModelException(ctx.getInstanceObject(), "Argument has no value");
		}
		if (left.size() != 1 || left.first().isModal()) {
			throw new InvalidModelException(ctx.getInstanceObject(), "Argument to operation cannot be modal");
		}
		arg1 = left.first().getValue();
		if (arg1 == null) {
			throw new InvalidModelException(ctx.getInstanceObject(), "Argument missing");
		}

		// check for required arguments to operation
		switch (op) {
		case AND:
		case OR:
			if (ownedPropertyExpressions.size() < 2) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Second operand missing for binary operation");
			}
			if (ownedPropertyExpressions.size() > 2) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Too many operands in expression");
			}
			right = ownedPropertyExpressions.get(1).evaluate(ctx, depth);
			if (right.size() != 1 || right.first().isModal()) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Argument to operation cannot be modal");
			}
			if (right.size() == 0) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Argument has no value");
			}
			arg2 = right.first().getValue();
			if (arg2 == null) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Argument missing");
			}
			break;
		default:
			if (ownedPropertyExpressions.size() > 1) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Too many operands in expression");
			}
			break;
		}

		// check argument types
		switch (op) {
		case NOT:
			if (!(arg1 instanceof BooleanLiteral)) {
				throw new InvalidModelException(ctx.getInstanceObject(),
						"Argument to NOT does not evaluate to a boolean value");
			}
			// fall through!
		case AND:
		case OR:
			if (!(arg2 instanceof BooleanLiteral)) {
				throw new InvalidModelException(ctx.getInstanceObject(),
						"Second argument does not evaluate to a boolean value");
			}
			break;
		default:
			if (!(arg1 instanceof NumberValue)) {
				throw new InvalidModelException(ctx.getInstanceObject(),
						"Argument does not evaluate to a numeric value");
			}
			break;
		}

		// calculate result
		EvaluatedProperty result = null;

		switch (op) {
		case AND:
			BooleanLiteral abv = Aadl2Factory.eINSTANCE.createBooleanLiteral();

			abv.setValue(((BooleanLiteral) arg1).getValue() && ((BooleanLiteral) arg1).getValue());
			result = new EvaluatedProperty(abv);
			break;
		case OR:
			BooleanLiteral obv = Aadl2Factory.eINSTANCE.createBooleanLiteral();

			obv.setValue(((BooleanLiteral) arg1).getValue() || ((BooleanLiteral) arg1).getValue());
			result = new EvaluatedProperty(obv);
			break;
		case NOT:
			BooleanLiteral nbv = Aadl2Factory.eINSTANCE.createBooleanLiteral();

			nbv.setValue(!((BooleanLiteral) arg1).getValue());
			result = new EvaluatedProperty(nbv);
			break;
		case PLUS:
			result = left;
			break;
		case MINUS:
			result = new EvaluatedProperty(((NumberValue) arg1).cloneAndInvert());
			break;
		default:
			throw new AssertionError("Unexpected enum literal: " + getOp());
		}

		return result;
	}
	public boolean sameAs(PropertyExpression other) {
		// TODO Auto-generated method stub
		return false;
	}

} // OperationImpl
