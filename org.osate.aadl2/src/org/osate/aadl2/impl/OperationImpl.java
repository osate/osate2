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
 * $Id: OperationImpl.java,v 1.10 2011-04-11 13:35:53 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.OperationImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.OperationImpl#getOwnedPropertyExpressions <em>Owned Property Expression</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationKind getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

	@Override
	public EvaluatedProperty evaluate(EvaluationContext ctx) throws InvalidModelException {
		if (ownedPropertyExpressions.size() < 1) {
			throw new InvalidModelException(this, "Property expression has no operands");
		}
		EvaluatedProperty left = ownedPropertyExpressions.get(0).evaluate(ctx);
		EvaluatedProperty right = null;
		PropertyExpression arg1 = null;
		PropertyExpression arg2 = null;

		if (left.size() == 0) {
			throw new InvalidModelException(ownedPropertyExpressions.get(0), "Argument has no value");
		}
		if (left.size() != 1 || left.first().isModal()) {
			throw new InvalidModelException(ownedPropertyExpressions.get(0), "Argument to operation cannot be modal");
		}
		arg1 = left.first().getValue();
		if (arg1 == null) {
			throw new InvalidModelException(ownedPropertyExpressions.get(0), "Argument missing");
		}

		// check for required arguments to operation
		switch (op) {
		case AND:
		case OR:
			if (ownedPropertyExpressions.size() < 2) {
				throw new InvalidModelException(this, "Second operand missing for binary operation");
			}
			if (ownedPropertyExpressions.size() > 2) {
				throw new InvalidModelException(this, "Too many operands in expression");
			}
			right = ownedPropertyExpressions.get(1).evaluate(ctx);
			if (right.size() != 1 || right.first().isModal()) {
				throw new InvalidModelException(ownedPropertyExpressions.get(1),
						"Argument to operation cannot be modal");
			}
			if (right.size() == 0) {
				throw new InvalidModelException(ownedPropertyExpressions.get(1), "Argument has no value");
			}
			arg2 = right.first().getValue();
			if (arg2 == null) {
				throw new InvalidModelException(ownedPropertyExpressions.get(1), "Argument missing");
			}
			break;
		default:
			if (ownedPropertyExpressions.size() > 1) {
				throw new InvalidModelException(this, "Too many operands in expression");
			}
			break;
		}

		// check argument types
		switch (op) {
		case NOT:
			if (!(arg1 instanceof BooleanLiteral)) {
				throw new InvalidModelException(getOwnedPropertyExpressions().get(0),
						"Does not evaluate to a boolean value");
			}
			// fall through!
		case AND:
		case OR:
			if (!(arg2 instanceof BooleanLiteral)) {
				throw new InvalidModelException(getOwnedPropertyExpressions().get(1),
						"Does not evaluate to a boolean value");
			}
			break;
		default:
			if (!(arg1 instanceof NumberValue)) {
				throw new InvalidModelException(getOwnedPropertyExpressions().get(0),
						"Does not evaluate to a numeric value");
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

} // OperationImpl
