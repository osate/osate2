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
 * A representation of the model object '<em><b>Metaclass Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Types.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.MetaclassReference#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.aadl2.MetaclassReference#getMetaclassNames <em>Metaclass Name</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getMetaclassReference()
 * @model
 * @generated
 */
public interface MetaclassReference extends PropertyOwner {
	/**
	 * Returns the value of the '<em><b>Annex Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annex Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annex Name</em>' attribute.
	 * @see #setAnnexName(String)
	 * @see org.osate.aadl2.Aadl2Package#getMetaclassReference_AnnexName()
	 * @model dataType="org.osate.aadl2.String" ordered="false"
	 * @generated
	 */
	String getAnnexName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.MetaclassReference#getAnnexName <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annex Name</em>' attribute.
	 * @see #getAnnexName()
	 * @generated
	 */
	void setAnnexName(String value);

	/**
	 * Returns the value of the '<em><b>Metaclass Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaclass Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metaclass Name</em>' attribute list.
	 * @see org.osate.aadl2.Aadl2Package#getMetaclassReference_MetaclassName()
	 * @model unique="false" dataType="org.osate.aadl2.String" required="true" ordered="false"
	 * @generated
	 */
	EList<String> getMetaclassNames();

	/**
	 * Finds the metaclass that is referenced by the metaclass names.  The returned {@code EClass} represents
	 * {@code NamedElement} or a subtype of {@code NamedElement}.
	 *
	 * @return An {@code EClass} representing the named metaclass or null if there is no such class.
	 */
	EClass getMetaclass();

	/**
	 * Get the error that occurred when trying to resolve the metaclass name to an EClass.
	 * <ul>
	 *   <li> "Metaclass <name> is not a named element"</li>
	 *   <li> "Metaclass <name> does not exist"</li>
	 * </ul>
	 *
	 * @return a descriptive error message
	 */
	String getErrorMessage();

} // MetaclassReference
