/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.Value;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Freeze Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl#getIdentifierOwned <em>Identifier Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl#getArrayIndexes <em>Array Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortFreezeActionImpl extends BehaviorElementImpl implements PortFreezeAction {
	/**
	 * The cached value of the '{@link #getIdentifierOwned() <em>Identifier Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierOwned()
	 * @generated
	 * @ordered
	 */
	protected Identifier identifierOwned;

	/**
	 * The cached value of the '{@link #getArrayIndexes() <em>Array Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<IntegerValueVariable> arrayIndexes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortFreezeActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.PORT_FREEZE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getIdentifierOwned() {
		return identifierOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifierOwned(Identifier newIdentifierOwned, NotificationChain msgs) {
		Identifier oldIdentifierOwned = identifierOwned;
		identifierOwned = newIdentifierOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED, oldIdentifierOwned, newIdentifierOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierOwned(Identifier newIdentifierOwned) {
		if (newIdentifierOwned != identifierOwned) {
			NotificationChain msgs = null;
			if (identifierOwned != null)
				msgs = ((InternalEObject)identifierOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED, null, msgs);
			if (newIdentifierOwned != null)
				msgs = ((InternalEObject)newIdentifierOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED, null, msgs);
			msgs = basicSetIdentifierOwned(newIdentifierOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED, newIdentifierOwned, newIdentifierOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntegerValueVariable> getArrayIndexes() {
		if (arrayIndexes == null) {
			arrayIndexes = new EObjectContainmentEList.Unsettable<IntegerValueVariable>(IntegerValueVariable.class, this, AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES);
		}
		return arrayIndexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetArrayIndexes() {
		if (arrayIndexes != null) ((InternalEList.Unsettable<?>)arrayIndexes).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetArrayIndexes() {
		return arrayIndexes != null && ((InternalEList.Unsettable<?>)arrayIndexes).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED:
				return basicSetIdentifierOwned(null, msgs);
			case AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES:
				return ((InternalEList<?>)getArrayIndexes()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED:
				return getIdentifierOwned();
			case AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES:
				return getArrayIndexes();
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
			case AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED:
				setIdentifierOwned((Identifier)newValue);
				return;
			case AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES:
				getArrayIndexes().clear();
				getArrayIndexes().addAll((Collection<? extends IntegerValueVariable>)newValue);
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
			case AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED:
				setIdentifierOwned((Identifier)null);
				return;
			case AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES:
				unsetArrayIndexes();
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
			case AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED:
				return identifierOwned != null;
			case AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES:
				return isSetArrayIndexes();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ElementValues.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ParameterLabel.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Target.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Value.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IntegerValue.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IntegerValueVariable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ValueVariable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Name.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED: return AadlBaPackage.NAME__IDENTIFIER_OWNED;
				case AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES: return AadlBaPackage.NAME__ARRAY_INDEXES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ElementValues.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ParameterLabel.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Target.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Value.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IntegerValue.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IntegerValueVariable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ValueVariable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Name.class) {
			switch (baseFeatureID) {
				case AadlBaPackage.NAME__IDENTIFIER_OWNED: return AadlBaPackage.PORT_FREEZE_ACTION__IDENTIFIER_OWNED;
				case AadlBaPackage.NAME__ARRAY_INDEXES: return AadlBaPackage.PORT_FREEZE_ACTION__ARRAY_INDEXES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //PortFreezeActionImpl
