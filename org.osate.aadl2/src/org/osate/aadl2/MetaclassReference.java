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
 * $Id: MetaclassReference.java,v 1.6 2009-06-03 17:46:28 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.MetaclassReference#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.aadl2.MetaclassReference#getMetaclassNames <em>Metaclass Name</em>}</li>
 * </ul>
 * </p>
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
