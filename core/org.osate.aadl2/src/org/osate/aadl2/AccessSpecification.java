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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Templates.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.AccessSpecification#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.AccessSpecification#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.AccessSpecification#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.AccessSpecification#getComponentPrototype <em>Component Prototype</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getAccessSpecification()
 * @model
 * @generated
 */
public interface AccessSpecification extends FeaturePrototypeActual {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.AccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Templates.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.AccessType
	 * @see #setKind(AccessType)
	 * @see org.osate.aadl2.Aadl2Package#getAccessSpecification_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AccessType getKind();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AccessSpecification#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.AccessType
	 * @see #getKind()
	 * @generated
	 */
	void setKind(AccessType value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.AccessCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Templates.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see org.osate.aadl2.AccessCategory
	 * @see #setCategory(AccessCategory)
	 * @see org.osate.aadl2.Aadl2Package#getAccessSpecification_Category()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AccessCategory getCategory();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AccessSpecification#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.osate.aadl2.AccessCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(AccessCategory value);

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Templates.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(ComponentClassifier)
	 * @see org.osate.aadl2.Aadl2Package#getAccessSpecification_Classifier()
	 * @model ordered="false"
	 * @generated
	 */
	ComponentClassifier getClassifier();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AccessSpecification#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(ComponentClassifier value);

	/**
	 * Returns the value of the '<em><b>Component Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Templates.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Prototype</em>' reference.
	 * @see #setComponentPrototype(ComponentPrototype)
	 * @see org.osate.aadl2.Aadl2Package#getAccessSpecification_ComponentPrototype()
	 * @model ordered="false"
	 * @generated
	 */
	ComponentPrototype getComponentPrototype();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AccessSpecification#getComponentPrototype <em>Component Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Prototype</em>' reference.
	 * @see #getComponentPrototype()
	 * @generated
	 */
	void setComponentPrototype(ComponentPrototype value);

} // AccessSpecification
