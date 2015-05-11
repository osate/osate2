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
 * $Id: RangeValueImpl.java,v 1.20 2011-04-11 13:35:54 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RangeValueImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RangeValueImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RangeValueImpl#getDelta <em>Delta</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRangeValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimum(PropertyExpression newMinimum) {
		if (newMinimum != minimum) {
			NotificationChain msgs = null;
			if (minimum != null) {
				msgs = ((InternalEObject) minimum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.RANGE_VALUE__MINIMUM, null, msgs);
			}
			if (newMinimum != null) {
				msgs = ((InternalEObject) newMinimum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.RANGE_VALUE__MINIMUM, null, msgs);
			}
			msgs = basicSetMinimum(newMinimum, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_VALUE__MINIMUM, newMinimum,
					newMinimum));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaximum(PropertyExpression newMaximum) {
		if (newMaximum != maximum) {
			NotificationChain msgs = null;
			if (maximum != null) {
				msgs = ((InternalEObject) maximum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.RANGE_VALUE__MAXIMUM, null, msgs);
			}
			if (newMaximum != null) {
				msgs = ((InternalEObject) newMaximum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.RANGE_VALUE__MAXIMUM, null, msgs);
			}
			msgs = basicSetMaximum(newMaximum, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_VALUE__MAXIMUM, newMaximum,
					newMaximum));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelta(PropertyExpression newDelta) {
		if (newDelta != delta) {
			NotificationChain msgs = null;
			if (delta != null) {
				msgs = ((InternalEObject) delta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.RANGE_VALUE__DELTA, null, msgs);
			}
			if (newDelta != null) {
				msgs = ((InternalEObject) newDelta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.RANGE_VALUE__DELTA, null, msgs);
			}
			msgs = basicSetDelta(newDelta, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_VALUE__DELTA, newDelta, newDelta));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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

	@Override
	public final EvaluatedProperty evaluate(EvaluationContext ctx) throws InvalidModelException {
		/*
		 * The min, max, and delta attributes can refer to PropertyReferences to
		 * signed property constants that we need to resolve. So we first
		 * evaluate the min, max, and delta values, and then create a new
		 * RangeValue out of the evaluated contents.
		 */
		try {
			NumberValue maxNumberValue;
			NumberValue minNumberValue;
			EvaluatedProperty maxVal = maximum.evaluate(ctx);
			EvaluatedProperty minVal = minimum.evaluate(ctx);
			EvaluatedProperty deltaVal = null;

			maxNumberValue = null;
			minNumberValue = null;

			/*
			 * First, retrieve the maximum value.
			 */
			if (maxVal.size() != 1 || maxVal.first().isModal()) {
				throw new InvalidModelException(this, "Range maximum is modal");
			}

			/*
			 * FIX JD
			 * Fixes bug #129 : when the maxvalue is a constant, we try to resolve it.
			 */
			if (maxVal.first().getValue() instanceof NamedValue) {
				try {
					NamedValue nv = (NamedValue) maxVal.first().getValue();
					AadlInteger aadlInteger = (AadlInteger) nv.getNamedValue().eContents().get(0);
					maxNumberValue = (NumberValue) ((PropertyConstant) aadlInteger.eContainer()).getConstantValue();
				} catch (Exception e) {
					maxNumberValue = null;
				}
			}

			if (maxVal.first().getValue() instanceof NumberValue) {
				maxNumberValue = (NumberValue) maxVal.first().getValue();
			}

			if (maxNumberValue == null) {
				throw new InvalidModelException(this, "Range maximum is not numeric");
			}

			/*
			 * So now, retrieve the minimum value.
			 */
			if (minVal.size() != 1 || minVal.first().isModal()) {
				throw new InvalidModelException(this, "Range minimum is modal");
			}

			if (minVal.first().getValue() instanceof NamedValue) {
				try {
					NamedValue nv = (NamedValue) minVal.first().getValue();
					AadlInteger aadlInteger = (AadlInteger) nv.getNamedValue().eContents().get(0);
					minNumberValue = (NumberValue) ((PropertyConstant) aadlInteger.eContainer()).getConstantValue();
				} catch (Exception e) {
					minNumberValue = null;
				}
			}

			if (minVal.first().getValue() instanceof NumberValue) {
				minNumberValue = (NumberValue) minVal.first().getValue();
			}

			if (minNumberValue == null) {
				throw new InvalidModelException(this, "Range minimum is not numeric");
			}

			if (delta != null) {
				deltaVal = delta.evaluate(ctx);
				if (deltaVal.size() != 1 || deltaVal.first().isModal()) {
					throw new InvalidModelException(this, "Range delta is modal");
				}
				if (!(deltaVal.first().getValue() instanceof NumberValue)) {
					throw new InvalidModelException(this, "Range delta is not numeric");
				}
			}
			RangeValue newVal = Aadl2Factory.eINSTANCE.createRangeValue();
			newVal.setMaximum(maxNumberValue.cloneNumber());
			newVal.setMinimum(minNumberValue.cloneNumber());
			if (deltaVal != null) {
				newVal.setDelta(((NumberValue) deltaVal.first().getValue()).cloneNumber());
			}
			return new EvaluatedProperty(newVal);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new InvalidModelException(this, "Incomplete range value");
		} catch (ClassCastException e) {
			e.printStackTrace();

			throw new InvalidModelException(this, "Incomplete range value");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.RangeValue#getMinimumValue()
	 */
	@Override
	public NumberValue getMinimumValue() {
		return getNumberValue(getMinimum());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.RangeValue#getMaximumValue()
	 */
	@Override
	public NumberValue getMaximumValue() {
		return getNumberValue(getMaximum());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.RangeValue#getDeltaValue()
	 */
	@Override
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

	@Override
	public boolean sameAs(PropertyValue pv) {
		if (this == pv) {
			return true;
		}

		if (pv == null || getClass() != pv.getClass()) {
			return false;
		}
		RangeValueImpl other = (RangeValueImpl) pv;
		if (delta == null) {
			if (other.delta != null) {
				return false;
			}
		} else if (!delta.equals(other.delta)) {
			return false;
		}
		if (maximum == null) {
			if (other.maximum != null) {
				return false;
			}
		} else if (!maximum.equals(other.maximum)) {
			return false;
		}
		if (minimum == null) {
			if (other.minimum != null) {
				return false;
			}
		} else if (!minimum.equals(other.minimum)) {
			return false;
		}
		return true;
	}

} // RangeValueImpl
