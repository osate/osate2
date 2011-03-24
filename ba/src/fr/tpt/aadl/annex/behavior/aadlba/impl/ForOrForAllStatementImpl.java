/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Or For All Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getElementIdentifier <em>Element Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getElementValuesOwned <em>Element Values Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#isForAll <em>For All</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForOrForAllStatementImpl extends LoopStatementImpl implements ForOrForAllStatement {
	/**
	 * The cached value of the '{@link #getElementIdentifier() <em>Element Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier elementIdentifier;

	/**
	 * The cached value of the '{@link #getDataUniqueComponentClassifierReference() <em>Data Unique Component Classifier Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataUniqueComponentClassifierReference()
	 * @generated
	 * @ordered
	 */
	protected UniqueComponentClassifierReference dataUniqueComponentClassifierReference;

	/**
	 * The cached value of the '{@link #getElementValuesOwned() <em>Element Values Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementValuesOwned()
	 * @generated
	 * @ordered
	 */
	protected ElementValues elementValuesOwned;

	/**
	 * The default value of the '{@link #isForAll() <em>For All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForAll()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOR_ALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForAll() <em>For All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForAll()
	 * @generated
	 * @ordered
	 */
	protected boolean forAll = FOR_ALL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForOrForAllStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.FOR_OR_FOR_ALL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getElementIdentifier() {
		return elementIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementIdentifier(Identifier newElementIdentifier, NotificationChain msgs) {
		Identifier oldElementIdentifier = elementIdentifier;
		elementIdentifier = newElementIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER, oldElementIdentifier, newElementIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementIdentifier(Identifier newElementIdentifier) {
		if (newElementIdentifier != elementIdentifier) {
			NotificationChain msgs = null;
			if (elementIdentifier != null)
				msgs = ((InternalEObject)elementIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER, null, msgs);
			if (newElementIdentifier != null)
				msgs = ((InternalEObject)newElementIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER, null, msgs);
			msgs = basicSetElementIdentifier(newElementIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER, newElementIdentifier, newElementIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniqueComponentClassifierReference getDataUniqueComponentClassifierReference() {
		return dataUniqueComponentClassifierReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataUniqueComponentClassifierReference(UniqueComponentClassifierReference newDataUniqueComponentClassifierReference, NotificationChain msgs) {
		UniqueComponentClassifierReference oldDataUniqueComponentClassifierReference = dataUniqueComponentClassifierReference;
		dataUniqueComponentClassifierReference = newDataUniqueComponentClassifierReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, oldDataUniqueComponentClassifierReference, newDataUniqueComponentClassifierReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference newDataUniqueComponentClassifierReference) {
		if (newDataUniqueComponentClassifierReference != dataUniqueComponentClassifierReference) {
			NotificationChain msgs = null;
			if (dataUniqueComponentClassifierReference != null)
				msgs = ((InternalEObject)dataUniqueComponentClassifierReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, null, msgs);
			if (newDataUniqueComponentClassifierReference != null)
				msgs = ((InternalEObject)newDataUniqueComponentClassifierReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, null, msgs);
			msgs = basicSetDataUniqueComponentClassifierReference(newDataUniqueComponentClassifierReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, newDataUniqueComponentClassifierReference, newDataUniqueComponentClassifierReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementValues getElementValuesOwned() {
		return elementValuesOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementValuesOwned(ElementValues newElementValuesOwned, NotificationChain msgs) {
		ElementValues oldElementValuesOwned = elementValuesOwned;
		elementValuesOwned = newElementValuesOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, oldElementValuesOwned, newElementValuesOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementValuesOwned(ElementValues newElementValuesOwned) {
		if (newElementValuesOwned != elementValuesOwned) {
			NotificationChain msgs = null;
			if (elementValuesOwned != null)
				msgs = ((InternalEObject)elementValuesOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, null, msgs);
			if (newElementValuesOwned != null)
				msgs = ((InternalEObject)newElementValuesOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, null, msgs);
			msgs = basicSetElementValuesOwned(newElementValuesOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, newElementValuesOwned, newElementValuesOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForAll() {
		return forAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForAll(boolean newForAll) {
		boolean oldForAll = forAll;
		forAll = newForAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL, oldForAll, forAll));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER:
				return basicSetElementIdentifier(null, msgs);
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				return basicSetDataUniqueComponentClassifierReference(null, msgs);
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				return basicSetElementValuesOwned(null, msgs);
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER:
				return getElementIdentifier();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				return getDataUniqueComponentClassifierReference();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				return getElementValuesOwned();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				return isForAll();
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER:
				setElementIdentifier((Identifier)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				setDataUniqueComponentClassifierReference((UniqueComponentClassifierReference)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				setElementValuesOwned((ElementValues)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				setForAll((Boolean)newValue);
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER:
				setElementIdentifier((Identifier)null);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				setDataUniqueComponentClassifierReference((UniqueComponentClassifierReference)null);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				setElementValuesOwned((ElementValues)null);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				setForAll(FOR_ALL_EDEFAULT);
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER:
				return elementIdentifier != null;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				return dataUniqueComponentClassifierReference != null;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				return elementValuesOwned != null;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				return forAll != FOR_ALL_EDEFAULT;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (forAll: ");
		result.append(forAll);
		result.append(')');
		return result.toString();
	}

} //ForOrForAllStatementImpl
