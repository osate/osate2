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
 * $Id: PropertySet.java,v 1.16 2009-03-31 15:50:15 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedPropertyTypes <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedProperties <em>Owned Property</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedPropertyConstants <em>Owned Property Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getImportedUnits <em>Imported Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertySet#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 * </ul>
 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
