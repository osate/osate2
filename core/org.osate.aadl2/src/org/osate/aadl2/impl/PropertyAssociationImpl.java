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
 * $Id: PropertyAssociationImpl.java,v 1.25 2010-05-04 18:13:32 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getInBindings <em>In Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#isAppend <em>Append</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyAssociationImpl#getOwnedValues <em>Owned Value</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPropertyAssociation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public ContainedNamedElement createAppliesTo() {
		return createAppliesTo(Aadl2Package.eINSTANCE.getContainedNamedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isAppend() {
		return append;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isConstant() {
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (append: ");
		result.append(append);
		result.append(", constant: ");
		result.append(constant);
		result.append(')');
		return result.toString();
	}

	@Override
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

	@Override
	public EvaluatedProperty evaluate(EvaluationContext ctx) throws InvalidModelException {
		EvaluatedProperty result = new EvaluatedProperty();
		for (ModalPropertyValue mpv : ownedValues) {
			result.add(mpv.evaluate(ctx));
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.PropertyAssociation#valueInMode(org.osate.aadl2.Mode)
	 */
	@Override
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
