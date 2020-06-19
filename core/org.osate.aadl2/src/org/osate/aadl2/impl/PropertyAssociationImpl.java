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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getInBindings <em>In Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#isAppend <em>Append</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getOwnedValues <em>Owned Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyAssociationImpl extends ElementImpl implements PropertyAssociation {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getAppliesTos() <em>Applies To</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliesTos()
	 * @generated
	 * @ordered
	 */
	protected EList<ContainedNamedElement> appliesTos;

	/**
	 * The cached value of the '{@link #getInBindings() <em>In Binding</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> inBindings;

	/**
	 * The default value of the '{@link #isAppend() <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAppend()
	 * @generated
	 * @ordered
	 */
	protected static final boolean APPEND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAppend() <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAppend()
	 * @generated
	 * @ordered
	 */
	protected boolean append = APPEND_EDEFAULT;

	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected boolean constant = CONSTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedValues() <em>Owned Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ModalPropertyValue> ownedValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPropertyAssociation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContainedNamedElement> getAppliesTos() {
		if (appliesTos == null) {
			appliesTos = new EObjectContainmentEList<ContainedNamedElement>(ContainedNamedElement.class, this,
					Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO);
		}
		return appliesTos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainedNamedElement createAppliesTo(EClass eClass) {
		ContainedNamedElement newAppliesTo = (ContainedNamedElement) create(eClass);
		getAppliesTos().add(newAppliesTo);
		return newAppliesTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainedNamedElement createAppliesTo() {
		return createAppliesTo(Aadl2Package.eINSTANCE.getContainedNamedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getInBindings() {
		if (inBindings == null) {
			inBindings = new EObjectResolvingEList<Classifier>(Classifier.class, this,
					Aadl2Package.PROPERTY_ASSOCIATION__IN_BINDING);
		}
		return inBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAppend() {
		return append;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppend(boolean newAppend) {
		boolean oldAppend = append;
		append = newAppend;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PROPERTY_ASSOCIATION__APPEND, oldAppend,
					append));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstant() {
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstant(boolean newConstant) {
		boolean oldConstant = constant;
		constant = newConstant;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PROPERTY_ASSOCIATION__CONSTANT,
					oldConstant, constant));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModalPropertyValue> getOwnedValues() {
		if (ownedValues == null) {
			ownedValues = new EObjectContainmentEList<ModalPropertyValue>(ModalPropertyValue.class, this,
					Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE);
		}
		return ownedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModalPropertyValue createOwnedValue() {
		ModalPropertyValue newOwnedValue = (ModalPropertyValue) create(Aadl2Package.eINSTANCE.getModalPropertyValue());
		getOwnedValues().add(newOwnedValue);
		return newOwnedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && ((EObject) property).eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject) property;
			property = (Property) eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY, oldProperty, property));
				}
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY,
					oldProperty, property));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO:
			return ((InternalEList<?>) getAppliesTos()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE:
			return ((InternalEList<?>) getOwnedValues()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY:
			if (resolve) {
				return getProperty();
			}
			return basicGetProperty();
		case Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO:
			return getAppliesTos();
		case Aadl2Package.PROPERTY_ASSOCIATION__IN_BINDING:
			return getInBindings();
		case Aadl2Package.PROPERTY_ASSOCIATION__APPEND:
			return isAppend();
		case Aadl2Package.PROPERTY_ASSOCIATION__CONSTANT:
			return isConstant();
		case Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE:
			return getOwnedValues();
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
		case Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY:
			setProperty((Property) newValue);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO:
			getAppliesTos().clear();
			getAppliesTos().addAll((Collection<? extends ContainedNamedElement>) newValue);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__IN_BINDING:
			getInBindings().clear();
			getInBindings().addAll((Collection<? extends Classifier>) newValue);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__APPEND:
			setAppend((Boolean) newValue);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__CONSTANT:
			setConstant((Boolean) newValue);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE:
			getOwnedValues().clear();
			getOwnedValues().addAll((Collection<? extends ModalPropertyValue>) newValue);
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
		case Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY:
			setProperty((Property) null);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO:
			getAppliesTos().clear();
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__IN_BINDING:
			getInBindings().clear();
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__APPEND:
			setAppend(APPEND_EDEFAULT);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__CONSTANT:
			setConstant(CONSTANT_EDEFAULT);
			return;
		case Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE:
			getOwnedValues().clear();
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
		case Aadl2Package.PROPERTY_ASSOCIATION__PROPERTY:
			return property != null;
		case Aadl2Package.PROPERTY_ASSOCIATION__APPLIES_TO:
			return appliesTos != null && !appliesTos.isEmpty();
		case Aadl2Package.PROPERTY_ASSOCIATION__IN_BINDING:
			return inBindings != null && !inBindings.isEmpty();
		case Aadl2Package.PROPERTY_ASSOCIATION__APPEND:
			return append != APPEND_EDEFAULT;
		case Aadl2Package.PROPERTY_ASSOCIATION__CONSTANT:
			return constant != CONSTANT_EDEFAULT;
		case Aadl2Package.PROPERTY_ASSOCIATION__OWNED_VALUE:
			return ownedValues != null && !ownedValues.isEmpty();
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
		result.append(" (append: ");
		result.append(append);
		result.append(", constant: ");
		result.append(constant);
		result.append(')');
		return result.toString();
	}

	public boolean isModal() {
		int count = getOwnedValues().size();

		if (count > 1) {
			return true;
		}
		if (count == 0) {
			return false;
		}
		return getOwnedValues().get(0).getInModes() != null && !getOwnedValues().get(0).getInModes().isEmpty();
	}

	public EvaluatedProperty evaluate(EvaluationContext ctx, int depth) throws InvalidModelException {
		EvaluatedProperty result = new EvaluatedProperty();
		for (ModalPropertyValue mpv : ownedValues) {
			result.add(mpv.evaluate(ctx, depth));
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.PropertyAssociation#valueInMode(org.osate.aadl2.Mode)
	 */
	public PropertyExpression valueInMode(Mode mode) {
		PropertyExpression def = null;
		for (ModalPropertyValue mpv : getOwnedValues()) {
			if (mpv.getInModes().isEmpty()) {
				def = mpv.getOwnedValue();
			} else {
				for (Mode m : mpv.getInModes()) {
					if (m == mode) {
						return mpv.getOwnedValue();
					}
				}
			}
		}
		return def;
	}

} // PropertyAssociationImpl
