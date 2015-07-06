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
 * $Id: UnitLiteralImpl.java,v 1.13 2009-10-07 16:46:58 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.operations.UnitLiteralOperations;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Unit Literal</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.UnitLiteralImpl#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.UnitLiteralImpl#getFactor <em>Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitLiteralImpl extends EnumerationLiteralImpl implements UnitLiteral {
	/**
	 * The cached value of the '{@link #getBaseUnit() <em>Base Unit</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBaseUnit()
	 * @generated
	 * @ordered
	 */
	protected UnitLiteral baseUnit;

	/**
	 * The cached value of the '{@link #getFactor() <em>Factor</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected NumberValue factor;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getUnitLiteral();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitLiteral getBaseUnit() {
		if (baseUnit != null && ((EObject) baseUnit).eIsProxy()) {
			InternalEObject oldBaseUnit = (InternalEObject) baseUnit;
			baseUnit = (UnitLiteral) eResolveProxy(oldBaseUnit);
			if (baseUnit != oldBaseUnit) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.UNIT_LITERAL__BASE_UNIT,
							oldBaseUnit, baseUnit));
				}
			}
		}
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLiteral basicGetBaseUnit() {
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseUnit(UnitLiteral newBaseUnit) {
		UnitLiteral oldBaseUnit = baseUnit;
		baseUnit = newBaseUnit;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.UNIT_LITERAL__BASE_UNIT, oldBaseUnit,
					baseUnit));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumberValue getFactor() {
		return factor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFactor(NumberValue newFactor, NotificationChain msgs) {
		NumberValue oldFactor = factor;
		factor = newFactor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.UNIT_LITERAL__FACTOR, oldFactor, newFactor);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactor(NumberValue newFactor) {
		if (newFactor != factor) {
			NotificationChain msgs = null;
			if (factor != null) {
				msgs = ((InternalEObject) factor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.UNIT_LITERAL__FACTOR, null, msgs);
			}
			if (newFactor != null) {
				msgs = ((InternalEObject) newFactor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.UNIT_LITERAL__FACTOR, null, msgs);
			}
			msgs = basicSetFactor(newFactor, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.UNIT_LITERAL__FACTOR, newFactor,
					newFactor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumberValue createFactor(EClass eClass) {
		NumberValue newFactor = (NumberValue) create(eClass);
		setFactor(newFactor);
		return newFactor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			return basicSetFactor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			if (resolve) {
				return getBaseUnit();
			}
			return basicGetBaseUnit();
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			return getFactor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			setBaseUnit((UnitLiteral) newValue);
			return;
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			setFactor((NumberValue) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			setBaseUnit((UnitLiteral) null);
			return;
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			setFactor((NumberValue) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			return baseUnit != null;
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			return factor != null;
		}
		return super.eIsSet(featureID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.UnitLiteral#getAbsoluteFactor()
	 */
	@Override
	public final double getAbsoluteFactor() {
		double factor = 1.0;
		UnitLiteral current = this;
		while (current.getBaseUnit() != null) {
			double val = (current.getFactor() instanceof IntegerLiteral ? (double) ((IntegerLiteral) current
					.getFactor()).getValue() : ((RealLiteral) current.getFactor()).getValue());
			if (val != 0) {
				factor *= val;
			}
			current = current.getBaseUnit();
		}
		return factor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.UnitLiteral#getAbsoluteFactor(org.osate.aadl2.UnitLiteral)
	 */
	@Override
	public final double getAbsoluteFactor(UnitLiteral target) {
		return UnitLiteralOperations.getAbsoluteFactor(this, target);
	}

} // UnitLiteralImpl
