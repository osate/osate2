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
 * A representation of the model object '<em><b>Aadl Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Packaging.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.AadlPackage#getOwnedPublicSection <em>Owned Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#getOwnedPrivateSection <em>Owned Private Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#getPublicSection <em>Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#getPrivateSection <em>Private Section</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getAadlPackage()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Package'"
 *        extendedMetaData="name='Package'"
 * @generated
 */
public interface AadlPackage extends ModelUnit {
	/**
	 * Returns the value of the '<em><b>Owned Public Section</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.AadlPackage#getPublicSection() <em>Public Section</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Public Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Public Section</em>' containment reference.
	 * @see #setOwnedPublicSection(PublicPackageSection)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_OwnedPublicSection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	PublicPackageSection getOwnedPublicSection();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AadlPackage#getOwnedPublicSection <em>Owned Public Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Public Section</em>' containment reference.
	 * @see #getOwnedPublicSection()
	 * @generated
	 */
	void setOwnedPublicSection(PublicPackageSection value);

	/**
	 * Creates a new {@link org.osate.aadl2.PublicPackageSection} and sets the '<em><b>Owned Public Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PublicPackageSection}.
	 * @see #getOwnedPublicSection()
	 * @generated
	 */
	PublicPackageSection createOwnedPublicSection();

	/**
	 * Returns the value of the '<em><b>Owned Private Section</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.AadlPackage#getPrivateSection() <em>Private Section</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Private Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Private Section</em>' containment reference.
	 * @see #setOwnedPrivateSection(PrivatePackageSection)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_OwnedPrivateSection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	PrivatePackageSection getOwnedPrivateSection();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AadlPackage#getOwnedPrivateSection <em>Owned Private Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Private Section</em>' containment reference.
	 * @see #getOwnedPrivateSection()
	 * @generated
	 */
	void setOwnedPrivateSection(PrivatePackageSection value);

	/**
	 * Creates a new {@link org.osate.aadl2.PrivatePackageSection} and sets the '<em><b>Owned Private Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PrivatePackageSection}.
	 * @see #getOwnedPrivateSection()
	 * @generated
	 */
	PrivatePackageSection createOwnedPrivateSection();

	/**
	 * Returns the value of the '<em><b>Public Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Public Section</em>' reference.
	 * @see #setPublicSection(PublicPackageSection)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_PublicSection()
	 * @model ordered="false"
	 * @generated
	 */
	PublicPackageSection getPublicSection();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AadlPackage#getPublicSection <em>Public Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Section</em>' reference.
	 * @see #getPublicSection()
	 * @generated
	 */
	void setPublicSection(PublicPackageSection value);

	/**
	 * Returns the value of the '<em><b>Private Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Private Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Private Section</em>' reference.
	 * @see #setPrivateSection(PrivatePackageSection)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_PrivateSection()
	 * @model ordered="false"
	 * @generated
	 */
	PrivatePackageSection getPrivateSection();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AadlPackage#getPrivateSection <em>Private Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private Section</em>' reference.
	 * @see #getPrivateSection()
	 * @generated
	 */
	void setPrivateSection(PrivatePackageSection value);

} // AadlPackage
