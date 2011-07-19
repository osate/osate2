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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 *
 * $Id: AadlPackage.java,v 1.11 2008-08-21 17:20:18 lwrage Exp $
 */
package org.osate.aadl2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aadl Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.AadlPackage#getOwnedPublicSection <em>Owned Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#getOwnedPrivateSection <em>Owned Private Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#getPublicSection <em>Public Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#getPrivateSection <em>Private Section</em>}</li>
 *   <li>{@link org.osate.aadl2.AadlPackage#isNoProperties <em>No Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getAadlPackage()
 * @model extendedMetaData="name='Package'"
 * @generated
 */
public interface AadlPackage extends ModelUnit {
	/**
	 * Returns the value of the '<em><b>Owned Public Section</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.AadlPackage#getPublicSection() <em>Public Section</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Public Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Public Section</em>' containment reference.
	 * @see #setOwnedPublicSection(PublicPackageSection)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_OwnedPublicSection()
	 * @model containment="true" ordered="false"
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.AadlPackage#getPrivateSection() <em>Private Section</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Private Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Private Section</em>' containment reference.
	 * @see #setOwnedPrivateSection(PrivatePackageSection)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_OwnedPrivateSection()
	 * @model containment="true" ordered="false"
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

	/**
	 * Returns the value of the '<em><b>No Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Properties</em>' attribute.
	 * @see #setNoProperties(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getAadlPackage_NoProperties()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoProperties();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.AadlPackage#isNoProperties <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Properties</em>' attribute.
	 * @see #isNoProperties()
	 * @generated
	 */
	void setNoProperties(boolean value);

} // AadlPackage
