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
 * $Id: PropertySetImpl.java,v 1.19 2011-04-11 13:35:54 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedPropertyTypes <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedProperties <em>Owned Property</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedPropertyConstants <em>Owned Property Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getImportedUnits <em>Imported Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertySetImpl#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPropertySet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> ownedMembers = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			if (ownedMembers == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_OwnedMember(),
						ownedMembers = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.PROPERTY_SET__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public PropertyConstant createOwnedPropertyConstant() {
		PropertyConstant newOwnedPropertyConstant = (PropertyConstant) create(Aadl2Package.eINSTANCE
				.getPropertyConstant());
		getOwnedPropertyConstants().add(newOwnedPropertyConstant);
		return newOwnedPropertyConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public AnnexSubclause createOwnedAnnexSubclause() {
		return createOwnedAnnexSubclause(Aadl2Package.eINSTANCE.getAnnexSubclause());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE)
				|| eIsSet(Aadl2Package.PROPERTY_SET__OWNED_PROPERTY)
				|| eIsSet(Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT);
	}

} // PropertySetImpl
