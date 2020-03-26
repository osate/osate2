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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedPropertyTypes <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedProperties <em>Owned Property</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedPropertyConstants <em>Owned Property Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getImportedUnits <em>Imported Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertySetImpl extends NamespaceImpl implements PropertySet {
	/**
	 * The cached value of the '{@link #getOwnedPropertyTypes() <em>Owned Property Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyType> ownedPropertyTypes;

	/**
	 * The cached value of the '{@link #getOwnedProperties() <em>Owned Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> ownedProperties;

	/**
	 * The cached value of the '{@link #getOwnedPropertyConstants() <em>Owned Property Constant</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyConstants()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyConstant> ownedPropertyConstants;

	/**
	 * The cached value of the '{@link #getImportedUnits() <em>Imported Unit</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelUnit> importedUnits;

	/**
	 * The cached value of the '{@link #getOwnedAnnexSubclauses() <em>Owned Annex Subclause</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAnnexSubclauses()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnexSubclause> ownedAnnexSubclauses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPropertySet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.PROPERTY_SET__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] { Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE,
			Aadl2Package.PROPERTY_SET__OWNED_PROPERTY, Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyType> getOwnedPropertyTypes() {
		if (ownedPropertyTypes == null) {
			ownedPropertyTypes = new EObjectContainmentEList<PropertyType>(PropertyType.class, this,
					Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE);
		}
		return ownedPropertyTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createOwnedPropertyType(EClass eClass) {
		PropertyType newOwnedPropertyType = (PropertyType) create(eClass);
		getOwnedPropertyTypes().add(newOwnedPropertyType);
		return newOwnedPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getOwnedProperties() {
		if (ownedProperties == null) {
			ownedProperties = new EObjectContainmentEList<Property>(Property.class, this,
					Aadl2Package.PROPERTY_SET__OWNED_PROPERTY);
		}
		return ownedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createOwnedProperty() {
		Property newOwnedProperty = (Property) create(Aadl2Package.eINSTANCE.getProperty());
		getOwnedProperties().add(newOwnedProperty);
		return newOwnedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyConstant> getOwnedPropertyConstants() {
		if (ownedPropertyConstants == null) {
			ownedPropertyConstants = new EObjectContainmentEList<PropertyConstant>(PropertyConstant.class, this,
					Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT);
		}
		return ownedPropertyConstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyConstant createOwnedPropertyConstant() {
		PropertyConstant newOwnedPropertyConstant = (PropertyConstant) create(
				Aadl2Package.eINSTANCE.getPropertyConstant());
		getOwnedPropertyConstants().add(newOwnedPropertyConstant);
		return newOwnedPropertyConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelUnit> getImportedUnits() {
		if (importedUnits == null) {
			importedUnits = new EObjectResolvingEList<ModelUnit>(ModelUnit.class, this,
					Aadl2Package.PROPERTY_SET__IMPORTED_UNIT);
		}
		return importedUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnexSubclause> getOwnedAnnexSubclauses() {
		if (ownedAnnexSubclauses == null) {
			ownedAnnexSubclauses = new EObjectContainmentEList<AnnexSubclause>(AnnexSubclause.class, this,
					Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE);
		}
		return ownedAnnexSubclauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause createOwnedAnnexSubclause(EClass eClass) {
		AnnexSubclause newOwnedAnnexSubclause = (AnnexSubclause) create(eClass);
		getOwnedAnnexSubclauses().add(newOwnedAnnexSubclause);
		return newOwnedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause createOwnedAnnexSubclause() {
		return createOwnedAnnexSubclause(Aadl2Package.eINSTANCE.getAnnexSubclause());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
			return ((InternalEList<?>) getOwnedPropertyTypes()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
			return ((InternalEList<?>) getOwnedProperties()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
			return ((InternalEList<?>) getOwnedPropertyConstants()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE:
			return ((InternalEList<?>) getOwnedAnnexSubclauses()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
			return getOwnedPropertyTypes();
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
			return getOwnedProperties();
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
			return getOwnedPropertyConstants();
		case Aadl2Package.PROPERTY_SET__IMPORTED_UNIT:
			return getImportedUnits();
		case Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE:
			return getOwnedAnnexSubclauses();
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
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
			getOwnedPropertyTypes().clear();
			getOwnedPropertyTypes().addAll((Collection<? extends PropertyType>) newValue);
			return;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
			getOwnedProperties().clear();
			getOwnedProperties().addAll((Collection<? extends Property>) newValue);
			return;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
			getOwnedPropertyConstants().clear();
			getOwnedPropertyConstants().addAll((Collection<? extends PropertyConstant>) newValue);
			return;
		case Aadl2Package.PROPERTY_SET__IMPORTED_UNIT:
			getImportedUnits().clear();
			getImportedUnits().addAll((Collection<? extends ModelUnit>) newValue);
			return;
		case Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE:
			getOwnedAnnexSubclauses().clear();
			getOwnedAnnexSubclauses().addAll((Collection<? extends AnnexSubclause>) newValue);
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
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
			getOwnedPropertyTypes().clear();
			return;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
			getOwnedProperties().clear();
			return;
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
			getOwnedPropertyConstants().clear();
			return;
		case Aadl2Package.PROPERTY_SET__IMPORTED_UNIT:
			getImportedUnits().clear();
			return;
		case Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE:
			getOwnedAnnexSubclauses().clear();
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
		case Aadl2Package.PROPERTY_SET__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
			return ownedPropertyTypes != null && !ownedPropertyTypes.isEmpty();
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
			return ownedProperties != null && !ownedProperties.isEmpty();
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
			return ownedPropertyConstants != null && !ownedPropertyConstants.isEmpty();
		case Aadl2Package.PROPERTY_SET__IMPORTED_UNIT:
			return importedUnits != null && !importedUnits.isEmpty();
		case Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE:
			return ownedAnnexSubclauses != null && !ownedAnnexSubclauses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE)
				|| eIsSet(Aadl2Package.PROPERTY_SET__OWNED_PROPERTY)
				|| eIsSet(Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT);
	}

} // PropertySetImpl
