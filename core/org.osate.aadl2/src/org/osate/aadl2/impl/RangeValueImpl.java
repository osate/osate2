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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RangeValueImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RangeValueImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RangeValueImpl#getDelta <em>Delta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeValueImpl extends PropertyValueImpl implements RangeValue {
	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression minimum;
	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression maximum;
	/**
	 * The cached value of the '{@link #getDelta() <em>Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelta()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression delta;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRangeValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinimum(PropertyExpression newMinimum, NotificationChain msgs) {
		PropertyExpression oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.RANGE_VALUE__MINIMUM, oldMinimum, newMinimum);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(PropertyExpression newMinimum) {
		if (newMinimum != minimum) {
			NotificationChain msgs = null;
			if (minimum != null)
				msgs = ((InternalEObject) minimum).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_VALUE__MINIMUM, null, msgs);
			if (newMinimum != null)
				msgs = ((InternalEObject) newMinimum).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_VALUE__MINIMUM, null, msgs);
			msgs = basicSetMinimum(newMinimum, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_VALUE__MINIMUM, newMinimum,
					newMinimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createMinimum(EClass eClass) {
		PropertyExpression newMinimum = (PropertyExpression) create(eClass);
		setMinimum(newMinimum);
		return newMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaximum(PropertyExpression newMaximum, NotificationChain msgs) {
		PropertyExpression oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.RANGE_VALUE__MAXIMUM, oldMaximum, newMaximum);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(PropertyExpression newMaximum) {
		if (newMaximum != maximum) {
			NotificationChain msgs = null;
			if (maximum != null)
				msgs = ((InternalEObject) maximum).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_VALUE__MAXIMUM, null, msgs);
			if (newMaximum != null)
				msgs = ((InternalEObject) newMaximum).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_VALUE__MAXIMUM, null, msgs);
			msgs = basicSetMaximum(newMaximum, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_VALUE__MAXIMUM, newMaximum,
					newMaximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createMaximum(EClass eClass) {
		PropertyExpression newMaximum = (PropertyExpression) create(eClass);
		setMaximum(newMaximum);
		return newMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getDelta() {
		return delta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelta(PropertyExpression newDelta, NotificationChain msgs) {
		PropertyExpression oldDelta = delta;
		delta = newDelta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.RANGE_VALUE__DELTA, oldDelta, newDelta);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelta(PropertyExpression newDelta) {
		if (newDelta != delta) {
			NotificationChain msgs = null;
			if (delta != null)
				msgs = ((InternalEObject) delta).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_VALUE__DELTA, null, msgs);
			if (newDelta != null)
				msgs = ((InternalEObject) newDelta).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_VALUE__DELTA, null, msgs);
			msgs = basicSetDelta(newDelta, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_VALUE__DELTA, newDelta, newDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createDelta(EClass eClass) {
		PropertyExpression newDelta = (PropertyExpression) create(eClass);
		setDelta(newDelta);
		return newDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.RANGE_VALUE__MINIMUM:
			return basicSetMinimum(null, msgs);
		case Aadl2Package.RANGE_VALUE__MAXIMUM:
			return basicSetMaximum(null, msgs);
		case Aadl2Package.RANGE_VALUE__DELTA:
			return basicSetDelta(null, msgs);
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
		case Aadl2Package.RANGE_VALUE__MINIMUM:
			return getMinimum();
		case Aadl2Package.RANGE_VALUE__MAXIMUM:
			return getMaximum();
		case Aadl2Package.RANGE_VALUE__DELTA:
			return getDelta();
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
		case Aadl2Package.RANGE_VALUE__MINIMUM:
			setMinimum((PropertyExpression) newValue);
			return;
		case Aadl2Package.RANGE_VALUE__MAXIMUM:
			setMaximum((PropertyExpression) newValue);
			return;
		case Aadl2Package.RANGE_VALUE__DELTA:
			setDelta((PropertyExpression) newValue);
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
		case Aadl2Package.RANGE_VALUE__MINIMUM:
			setMinimum((PropertyExpression) null);
			return;
		case Aadl2Package.RANGE_VALUE__MAXIMUM:
			setMaximum((PropertyExpression) null);
			return;
		case Aadl2Package.RANGE_VALUE__DELTA:
			setDelta((PropertyExpression) null);
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
		case Aadl2Package.RANGE_VALUE__MINIMUM:
			return minimum != null;
		case Aadl2Package.RANGE_VALUE__MAXIMUM:
			return maximum != null;
		case Aadl2Package.RANGE_VALUE__DELTA:
			return delta != null;
		}
		return super.eIsSet(featureID);
	}

	public final EvaluatedProperty evaluate(EvaluationContext ctx, int depth) throws InvalidModelException {
		/*
		 * The min, max, and delta attributes can refer to PropertyReferences to
		 * signed property constants that we need to resolve. So we first
		 * evaluate the min, max, and delta values, and then create a new
		 * RangeValue out of the evaluated contents.
		 */
		try {
			NumberValue maxNumberValue;
			NumberValue minNumberValue;
			EvaluatedProperty maxVal = maximum.evaluate(ctx, depth);
			EvaluatedProperty minVal = minimum.evaluate(ctx, depth);
			EvaluatedProperty deltaVal = null;

			maxNumberValue = null;
			minNumberValue = null;

			/*
			 * First, retrieve the maximum value.
			 */
			if (maxVal.size() != 1 || maxVal.first().isModal()) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Range maximum is modal");
			}

			if (maxVal.first().getValue() instanceof NumberValue) {
				maxNumberValue = (NumberValue) maxVal.first().getValue();
			} else {
				throw new InvalidModelException(ctx.getInstanceObject(), "Range maximum is not numeric");
			}

			/*
			 * So now, retrieve the minimum value.
			 */
			if (minVal.size() != 1 || minVal.first().isModal()) {
				throw new InvalidModelException(ctx.getInstanceObject(), "Range minimum is modal");
			}

			if (minVal.first().getValue() instanceof NumberValue) {
				minNumberValue = (NumberValue) minVal.first().getValue();
			} else {
				throw new InvalidModelException(ctx.getInstanceObject(), "Range minimum is not numeric");
			}

			if (delta != null) {
				deltaVal = delta.evaluate(ctx, depth);
				if (deltaVal.size() != 1 || deltaVal.first().isModal()) {
					throw new InvalidModelException(ctx.getInstanceObject(), "Range delta is modal");
				}
				if (!(deltaVal.first().getValue() instanceof NumberValue)) {
					throw new InvalidModelException(ctx.getInstanceObject(), "Range delta is not numeric");
				}
			}
			RangeValue newVal = Aadl2Factory.eINSTANCE.createRangeValue();
			newVal.setMaximum(maxNumberValue);
			newVal.setMinimum(minNumberValue);
			if (deltaVal != null) {
				newVal.setDelta(deltaVal.first().getValue());
			}
			return new EvaluatedProperty(newVal);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new InvalidModelException(ctx.getInstanceObject(), "Incomplete range value");
		} catch (ClassCastException e) {
			e.printStackTrace();

			throw new InvalidModelException(ctx.getInstanceObject(), "Incomplete range value");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.RangeValue#getMinimumValue()
	 */
	public NumberValue getMinimumValue() {
		return getNumberValue(getMinimum());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.RangeValue#getMaximumValue()
	 */
	public NumberValue getMaximumValue() {
		return getNumberValue(getMaximum());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.RangeValue#getDeltaValue()
	 */
	public NumberValue getDeltaValue() {
		return getNumberValue(getDelta());
	}

	/**
	 * @param pe
	 * @return
	 */
	private NumberValue getNumberValue(PropertyExpression pe) {
		if (pe instanceof Operation) {
			pe = ((Operation) pe).getOwnedPropertyExpressions().get(0);
		}
		if (pe instanceof NumberValue) {
			return (NumberValue) pe;
		} else if (pe instanceof PropertyConstant) {
			return (NumberValue) ((PropertyConstant) pe).getConstantValue();
		}
		return null;
	}

	public boolean sameAs(PropertyExpression pe) {
		if (this == pe) {
			return true;
		}

		if (pe == null || getClass() != pe.getClass()) {
			return false;
		}
		RangeValueImpl other = (RangeValueImpl) pe;
		if (delta == null) {
			if (other.delta != null) {
				return false;
			}
		} else if (!delta.sameAs(other.delta)) {
			return false;
		}
		if (maximum == null) {
			if (other.maximum != null) {
				return false;
			}
		} else if (!maximum.sameAs(other.maximum)) {
			return false;
		}
		if (minimum == null) {
			if (other.minimum != null) {
				return false;
			}
		} else if (!minimum.sameAs(other.minimum)) {
			return false;
		}
		return true;
	}

	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer();
		result.append('[');
		result.append(minimum.toString());
		result.append(" .. ");
		result.append(maximum.toString());
		result.append(']');
		if (delta != null) {
			result.append(" delta ");
			result.append(delta.toString());
		}
		return result.toString();
	}

} // RangeValueImpl
