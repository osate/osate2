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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::PropertySets.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedPropertyTypes <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedProperties <em>Owned Property</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedPropertyConstants <em>Owned Property Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getImportedUnits <em>Imported Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getPropertySet()
 * @model
 * @generated
 */
public interface PropertySet extends Namespace, ModelUnit {
	/**
	 * Returns the value of the '<em><b>Owned Property Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PropertyType}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::PropertySets.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertySet_OwnedPropertyType()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<PropertyType> getOwnedPropertyTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyType} and appends it to the '<em><b>Owned Property Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyType} to create.
	 * @return The new {@link org.osate.aadl2.PropertyType}.
	 * @see #getOwnedPropertyTypes()
	 * @generated
	 */
	PropertyType createOwnedPropertyType(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Owned Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Property}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::PropertySets.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertySet_OwnedProperty()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Property> getOwnedProperties();

	/**
	 * Creates a new {@link org.osate.aadl2.Property} and appends it to the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.Property}.
	 * @see #getOwnedProperties()
	 * @generated
	 */
	Property createOwnedProperty();

	/**
	 * Returns the value of the '<em><b>Owned Property Constant</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PropertyConstant}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property Constant</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::PropertySets.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Constant</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertySet_OwnedPropertyConstant()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<PropertyConstant> getOwnedPropertyConstants();

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyConstant} and appends it to the '<em><b>Owned Property Constant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PropertyConstant}.
	 * @see #getOwnedPropertyConstants()
	 * @generated
	 */
	PropertyConstant createOwnedPropertyConstant();

	/**
	 * Returns the value of the '<em><b>Imported Unit</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.ModelUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Unit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::PropertySets.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Imported Unit</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertySet_ImportedUnit()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModelUnit> getImportedUnits();

	/**
	 * Returns the value of the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AnnexSubclause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annex Subclause</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::PropertySets.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Annex Subclause</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertySet_OwnedAnnexSubclause()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AnnexSubclause> getOwnedAnnexSubclauses();

	/**
	 * Creates a new {@link org.osate.aadl2.AnnexSubclause} and appends it to the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.AnnexSubclause} to create.
	 * @return The new {@link org.osate.aadl2.AnnexSubclause}.
	 * @see #getOwnedAnnexSubclauses()
	 * @generated
	 */
	AnnexSubclause createOwnedAnnexSubclause(EClass eClass);

	/**
	 * Creates a new {@link org.osate.aadl2.DefaultAnnexSubclause} and appends it to the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DefaultAnnexSubclause}.
	 * @see #getOwnedAnnexSubclauses()
	 * @generated
	 */
	AnnexSubclause createOwnedAnnexSubclause();

} // PropertySet
